package projectMyPage;

public class MySingleton {
	private static MySingleton instance = null;

	// 생성자 - 사용자에게 제약을 주기위해서
	private MySingleton() {
	}

	// 메소드 - 생성자의 역할
	public static MySingleton getInstance() {
		if (instance == null) {
			synchronized (MySingleton.class) {
				instance = new MySingleton();
			}
		}
		return instance;
	}
}
