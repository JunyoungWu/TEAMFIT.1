package projectMyPage;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Properties;

public final class ConnectionPool {
	// 정적블럭 클래스가 로드될때에 실행된다
	static {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException cnfe) {
			cnfe.printStackTrace();
		}
	}
	// 사용하지 않은 커넥션 즉, 초기 커넥션을 저장하는 변수
	private ArrayList<Connection> free;
	private ArrayList<Connection> used; // 사용중인 커넥션을 저장하는 변수
	private String url;
	private String user;
	private String password;
	private int initialCons = 10; // 최초로 초기 커넥션수
	private int maxCons = 20; // 최대 커넥션수
	private int numCons = 0; // 총 Connection 수
	private static ConnectionPool cp;

	public static ConnectionPool getInstance() {
		try {
			if (cp == null) {
				synchronized (ConnectionPool.class) {
					cp = new ConnectionPool();
				}
			}
		} catch (SQLException sqle) {
			sqle.printStackTrace();
		}
		return cp;
	}

	private ConnectionPool() throws SQLException {
		/*
		 * 초기 커넥션 개수를 각각의 ArrayList에 자장할 수 있도록 초기 커넥션 수만큼 ArrayList 생성.
		 */	
		String filePath = "C:/Users/ferdia/eclipse-database/JSPStudy/src/main/java/projectMyPage/db.properties";

		Connection con = null;		Properties properties = new Properties();
		try {
			//db.properties로 db주소, 사용자명, 사용자 암호 로드하기
			
			properties.load(new FileReader(filePath));
			url = properties.getProperty("url");
			user = properties.getProperty("user");
			password = properties.getProperty("password");
			free = new ArrayList<Connection>(initialCons);
			used = new ArrayList<Connection>(initialCons);
			// initialCons 수만큼 Connection 생성(free)
			while (numCons < initialCons) {
				addConnection();
			}
			System.out.println("데이타베이스 접속 성공");
		}  catch (IOException e) {
			System.out.println("db.properties 연결 실패");
			e.printStackTrace();
		}
	}

	// free에
	private void addConnection() throws SQLException {
		free.add(getNewConnection());
	}

	private Connection getNewConnection() throws SQLException {
		Connection con = null;
		try {
			con = DriverManager.getConnection(url, user, password);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		System.out.println("About to connect to " + con);
		++numCons; // 컨넥션 생성될 때 마다 숫자 증가
		return con;
	}

	/* free에 있는 커넥션을 used 로 옮기는 작업=>free--->used */
	public synchronized Connection getConnection()
			throws SQLException { /*
									 * free에 Connection이 없으면 maxCons만큼 Connection을 더 생성한다.
									 */
		if (free.isEmpty()) {
			while (numCons < maxCons) {
				addConnection();
			}
		}
		Connection _con;
		_con = free.get(free.size() - 1);
		free.remove(_con);
		used.add(_con);
		return _con;
	}

	/* used에 있는 커넥션을 free로 반납함. */
	public synchronized void releaseConnection(Connection _con) throws SQLException {
		boolean flag = false;
		if (used.contains(_con)) {
			used.remove(_con);
			numCons--;
			flag = true;
		} else {
			throw new SQLException("ConnectionPool" + "에 있지않네요!!");
		}
		try {
			if (flag) {
				free.add(_con);
				numCons++;
			} else {
				_con.close();
			}
		} catch (SQLException e) {
			try {
				_con.close();
			} catch (SQLException e2) {
				e2.printStackTrace();
			}
		}
	}

	public void closeAll() {// 모든 Connection 자원을 반납함.
		// used에 있는 커넥션을 모두 삭제해 버림.
		for (int i = 0; i < used.size(); i++) {
			Connection _con = (Connection) used.get(i);
			used.remove(i--);
			try {
				_con.close();
			} catch (SQLException sqle) {
				sqle.printStackTrace();
			}
		}
		// free에 있는 커넥션을 모두 삭제해 버림.
		for (int i = 0; i < free.size(); i++) {
			Connection _con = (Connection) free.get(i);
			free.remove(i--);
			try {
				_con.close();
			} catch (SQLException sqle) {
				sqle.printStackTrace();
			}
		}
	}

	public int getMaxCons() {
		return maxCons;
	}

	public int getNumCons() {
		return numCons;
	}

}
