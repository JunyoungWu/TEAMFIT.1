package TeamFit2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Iterator;
import java.util.Scanner;

public class TeamFit {
	static final int NUM_EXERCISE = 10;
	static final int NUM_ITEM = 10;

	static int listCount = 0;
	static ExerciseCart exCart = new ExerciseCart();
	static People people;
	static Scanner scan = new Scanner(System.in);
	static ArrayList<People> poepleList = new ArrayList<People>();
	static ArrayList<Instructor> instructorList = new ArrayList<Instructor>();
	static ArrayList<User> userList = new ArrayList<User>();
	static String userName;
	static String userPNnum;
	static ExerciseCart userCart = new ExerciseCart();

	public static void main(String[] args) {
		boolean flag = false;
		ArrayList<Exercise> exerciseList = new ArrayList<Exercise>();
		loadExerciseData(exerciseList);
		loadInstructorData(instructorList);
		loadPeopleData(poepleList);
		loadUserData(userList);

		System.out.println("================================================================");
		System.out.println();
		System.out.println("=====================Team Fit에 오신것을 환영합니다=====================");
		System.out.println();
		System.out.println("================================================================");
		
		login();

		for (;;) {
			int numberSelection = 0;
			for (;;) {
				System.out.println("1. 마이페이지 2. 운동 신청(리스트) 3.운동 신청(검색) 4.개별 운동 삭제 5.전체 운동 삭제 6. 강사 리스트  7. 강사메뉴  8. 종료");
				System.out.println();
				System.out.print("메뉴 번호를 선택해주세요 : ");
				try {
					numberSelection = scan.nextInt();
					break;
				} catch (InputMismatchException e) {
					System.out.println("정수를 입력해주세요");
					scan.nextLine();

				}
			}
			System.out.println(numberSelection + "번을 선택했습니다");
			if (numberSelection < 1 || numberSelection > 9) {
				System.out.println("1부터 9까지의 숫자를 입력해주세요");
			} else {
				switch (numberSelection) {
				case 1:
					boolean isUserInstructor = false;
					for (People data : poepleList) {
						if (data.getName().equals(userName) && data.getPnum().equals(userPNnum)) {
							if (data.isTeacher() == true) {
								isUserInstructor = true;
								break;
							}
						}
					}
					if (!isUserInstructor) {
						viewmypage();
					} else {
						System.out.println("강사는 강사 메뉴를 사용해주세요");

					}
					break;

				case 2:
					System.out.println("2. 운동 신청(리스트)");
					System.out.println();
					System.out.println("==================================================================================================================================================================");
					System.out.println();
					for(Exercise data:exerciseList) {
						System.out.println(data);
					}
					System.out.println();
					System.out.println("==================================================================================================================================================================");
					scan.nextLine();
					System.out.println();
					System.out.print("신청할 운동의 코드를 입력해주세요 > ");
					String code = scan.nextLine();
					for (Exercise data : exerciseList) {
						if (data.getClassCode().equals(code)) {
							userCart.insertExercise(data);
							System.out.println(data.getName()+" 운동이 추가 되었습니다");
							flag = true;
						}
					}
					if (flag == false) {
						System.out.println("올바른 코드를 입력해주세요");
					}
					break;
				case 3:

					int num = 0;

					for (;;) {
						System.out.println("3.운동 신청(검색)");
						System.out.println("검색 방식을 선택해주세요");
						System.out.println("1. 운동 이름 2. 운동 코드 3. 강사명 ");
						try {
							num = scan.nextInt();
							break;
						} catch (InputMismatchException e) {
							System.out.println("정수를 입력해주세요");
							scan.nextLine();

						}
					}

					switch (num) {
					case 1:
						scan.nextLine();
						flag = false;
						System.out.print("검색할 운동의 이름을 정확히 입력해주세요 > ");
						String exname = scan.nextLine();
						for (Exercise data : exerciseList) {
							if (exname.equals(data.getName())) {
								System.out.println("검색 결과");
								System.out.println(data.toString());
								flag = true;
							}

						}
						if (flag == false) {
							System.out.println("검색결과가 없습니다");
						}

						break;
					case 2:
						scan.nextLine();
						flag = false;
						System.out.print("검색할 운동의 코드를 정확히 입력해주세요 > ");
						String excode = scan.nextLine();
						for (Exercise data : exerciseList) {
							if (excode.equals(data.getClassCode())) {
								System.out.println("검색 결과");
								System.out.println(data.toString());
								flag = true;
							}

						}
						if (flag == false) {
							System.out.println("검색결과가 없습니다");
						}
						break;
					case 3:
						scan.nextLine();
						flag = false;
						System.out.print("검색할 운동의 강사명을 정확히 입력해주세요 > ");
						String teacher = scan.nextLine();
						for (Exercise data : exerciseList) {
							if (teacher.equals(data.getTeacherName())) {
								System.out.println("검색 결과");
								System.out.println(data.toString());
								flag = true;
							}

						}
						if (flag == false) {
							System.out.println("검색결과가 없습니다");
						}

						break;
					default:
						System.out.println("올바른 숫자를 입력해주세요");
					}
					scan.nextLine();
					System.out.print("신청할 운동의 코드를 입력해주세요 > ");
					code = scan.nextLine();
					for (Exercise data : exerciseList) {
						if (data.getClassCode().equals(code)) {
							userCart.insertExercise(data);

							flag = true;
						}
					}
					if (flag == false) {
						System.out.println("올바른 코드를 입력해주세요");
					}

					break;
				case 4:
					System.out.println("4.개별 운동 삭제");
					userCart.printCart();
					scan.nextLine();
					System.out.print("삭제할 운동의 코드를 입력해주세요");
					String sc = scan.nextLine();
					userCart.removeCart(sc);
					break;
				case 5:
					System.out.println("5.전체 운동 삭제");
					userCart.delAllExercise();
					break;
				case 6:
					System.out.println("6. 강사 리스트");
					flag = false;
					System.out.println("====================TeamFit 강사 목록====================");
					System.out.println();
					for(Instructor data : instructorList) {
						
						System.out.println(data.toString());
						System.out.println();
					}
					System.out.println(); 
				
					System.out.println("1대1강사를 신청하시겠습니까? (Y / N) : ");
					System.out.println();
					String tr = scan.next();
					if (tr.toUpperCase().equals("Y")) {
						System.out.println("신청할 강사의 이름을 입력해주세요");
						String tname = scan.next();
						for (Instructor data : instructorList) {
							if (data.getName().equals(tname)) {
								for (User data1 : userList) {
									if (data1.getPnum().equals(userPNnum)) {
										data1.setTeacherName(tname);
										System.out.println("담당강사가 설정되었습니다");
										flag = true;
									}
								}

							}
						}
						if (flag == false) {
							System.out.println("올바르게 입력해주세요");
						}
					}
					break;

				case 7:
					System.out.println("7. 강사메뉴");
					isUserInstructor = false;
					for (People data : poepleList) {
						if (data.getName().equals(userName) && data.getPnum().equals(userPNnum)) {
							if (data.isTeacher() == true) {
								isUserInstructor = true;
								break;
							}
						}
					}
					if (!isUserInstructor) {
						System.out.println();
						System.out.println("강사만 이용 가능한 메뉴입니다.");
					} else {
						System.out.println();
						System.out.println("강사메뉴입니다");
						System.out.println();
						System.out.println("강사명 : " + userName + " 연락처 : " + userPNnum);
						System.out.println();
						System.out.println("========================================================================================================================");
						System.out.println("담당 운동 목록");
						System.out.println();
						for (Exercise data : exerciseList) {
							if (data.getTeacherName().equals(userName)) {
								System.out.println(data);
							}
						}
						System.out.println("========================================================================================================================");
						System.out.println();
						System.out.println("담당 학생 목록");
						System.out.println();
						for (User data : userList) {
							if (data.getTeacherName().equals(userName)) {
								System.out.println(data);
							}
						}
						
						int num12 = 0;
						for (;;) {

							System.out.println("운동 관리 메뉴");
							System.out.println("1.등록된 운동 내용 수정 2.등록된 운동 삭제 3. 운동 등록 4.종료");
							try {
								num12 = scan.nextInt();
								break;
							} catch (InputMismatchException e) {
								System.out.println("정수를 입력해주세요");
								scan.nextLine();

							}
						}
						switch (num12) {
						case 1:
							scan.nextLine();
							System.out.print("수정할 본인 운동의 코드를 입력해주세요 > ");
							String str = scan.nextLine();
							for (Exercise data : exerciseList) {
								if (data.getTeacherName().equals(userName) && data.getClassCode().equals(str)) {
									for (;;) {
										
										int mnum = 0;
										
										for (;;) {

											System.out.println("수정할 내용을 선택해주세요");
											System.out.println("1.위치 2. 날짜 3. 최대인원수 4. 가격 5.종료");
											try {
												mnum = scan.nextInt();
												break;
											} catch (InputMismatchException e) {
												System.out.println("정수를 입력해주세요");
												scan.nextLine();

											}
										}
										switch (mnum) {

										case 1:
											scan.nextLine();
											System.out.print("수정할 위치를 입력해주세요 > ");
											String location = scan.nextLine();
											data.setLocation(location);
											;
											break;
										case 2:
											scan.nextLine();
											System.out.print("수정할 날짜를 입력해주세요 > ");
											String date = scan.nextLine();
											data.setDate(date);
											break;
										case 3:
											scan.nextLine();
											System.out.print("수정할 최대인원수를 입력해주세요 > ");
											int memnum = scan.nextInt();
											data.setMemNum(memnum);
											break;
										case 4:
											scan.nextLine();
											System.out.print("수정할 가격 입력해주세요 > ");
											int price = scan.nextInt();
											data.setPrice(price);
											break;
										case 5:
											System.out.println("5. 종료");
											System.out.println("The End");

											break;

										}
										if (mnum == 5) {
										
											break;
										}
									}
								}
							}

							break;

						case 2:
							scan.nextLine();
							System.out.println("삭제할 본인의 운동코드를 입력해주세요");
							str = scan.nextLine();
							Iterator<Exercise> iterator = exerciseList.iterator();
							boolean found = false;
							while (iterator.hasNext()) {
								Exercise data = iterator.next();
								if (data.getTeacherName().equals(userName) && data.getClassCode().equals(str)) {
									iterator.remove();
									System.out.println("삭제완료");
									found = true;
									break;
								}
							}
							if (!found) {
								System.out.println("본인의 운동이 아닙니다");
							}
							break;
						case 3: 
							scan.nextLine();
							System.out.print("강의코드를 설정해주세요 : ");
							
							String newcode = scan.nextLine();
							System.out.println();
							System.out.println("newcode값:"+newcode);
							scan.nextLine();
							System.out.println();
							System.out.print("운동이름을 설정해주세요 : ");
							String newname = scan.nextLine();
							System.out.println("newname값:"+newname);
							scan.nextLine();
							System.out.println();
							System.out.print("위치를 설정해주세요 : ");
							String newloca = scan.nextLine();
							System.out.println();
							System.out.println("newloca 값"+newloca);
							scan.nextLine();
							
							System.out.print("날짜를 설정해주세요 : ");
							String newdate = scan.nextLine();
							System.out.println();
							System.out.println("newdate 값:"+newdate);
							System.out.print("인원수를 설정해주세요 : ");
							int newmem = scan.nextInt();
							System.out.print("가격을 설정해주세요 : ");
							int newprice = scan.nextInt();
							exerciseList.add(new Exercise(newcode, newname, newloca, newdate, newmem, userName, newprice));
							saveExerciseData(exerciseList);
							break;
						case 4:
							System.out.println("종료");
							break;
						}
					}

					break;
				case 8:
					System.out.println("8. 종료");
					System.out.println("The End");
					System.exit(0); // 프로그램 종료
					break;

				}
			}
			saveExerciseData(exerciseList);
			saveInstructorData(instructorList);
			savePeopleData(poepleList);
			saveUserData(userList);
			userCart.saveExerciseData(userName,userPNnum);
		}

	}

	public static void savePeopleData(ArrayList<People> peopleList) {
		try {
			BufferedWriter writer = new BufferedWriter(new FileWriter("People.txt"));
			for (People person : peopleList) {
				writer.write(person.getName() + "," + person.getPnum() + "," + person.getId() + ","
						+ person.getPassword() + "," + person.isTeacher());
				writer.newLine();
			}
			writer.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void saveInstructorData(ArrayList<Instructor> instructorList) {
		try {
			BufferedWriter writer = new BufferedWriter(new FileWriter("Instructor.txt"));
			for (Instructor instructor : instructorList) {
				writer.write(instructor.getName() + "," + instructor.getPnum() + "," + instructor.getId() + ","
						+ instructor.getPassword() + "," + instructor.isTeacher());
				writer.newLine();
			}
			writer.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void saveUserData(ArrayList<User> userList) {
		try {
			BufferedWriter writer = new BufferedWriter(new FileWriter("User.txt"));
			for (User user : userList) {
				writer.write(user.getName() + "," + user.getPnum() + "," + user.getId() + "," + user.getPassword() + ","
						+ user.isTeacher() + "," + user.getTeacherName());
				writer.newLine();
			}
			writer.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void saveExerciseData(ArrayList<Exercise> exerciseList) {
		try {
			BufferedWriter writer = new BufferedWriter(new FileWriter("Exercise.txt"));
			for (Exercise exercise : exerciseList) {
				writer.write(exercise.getClassCode() + "," + exercise.getName() + "," + exercise.getLocation() + ","
						+ exercise.getDate() + "," + exercise.getMemNum() + "," + exercise.getTeacherName() + ","
						+ exercise.getPrice());
				writer.newLine();
			}

			writer.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void loadPeopleData(ArrayList<People> peopleList) {
		try {
			BufferedReader reader = new BufferedReader(new FileReader("People.txt"));
			String line;
			while ((line = reader.readLine()) != null) {
				String[] parts = line.split(",");
				String name = parts[0];
				String pnum = parts[1];
				String id = parts[2];
				String password = parts[3];
				boolean isTeacher = Boolean.parseBoolean(parts[4]);
				peopleList.add(new People(name, pnum, id, password, isTeacher));
			}
			reader.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void loadInstructorData(ArrayList<Instructor> instructorList) {
		try {
			BufferedReader reader = new BufferedReader(new FileReader("Instructor.txt"));
			String line;
			while ((line = reader.readLine()) != null) {
				String[] parts = line.split(",");
				String name = parts[0];
				String pnum = parts[1];
				String id = parts[2];
				String password = parts[3];
				boolean isTeacher = Boolean.parseBoolean(parts[4]);
				instructorList.add(new Instructor(name, pnum, id, password, isTeacher));
			}
			reader.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void loadUserData(ArrayList<User> userList) {
		try {
			BufferedReader reader = new BufferedReader(new FileReader("User.txt"));
			String line;
			while ((line = reader.readLine()) != null) {
				String[] parts = line.split(",");
				String name = parts[0];
				String pnum = parts[1];
				String id = parts[2];
				String password = parts[3];
				boolean isTeacher = Boolean.parseBoolean(parts[4]);
				String teacherName = parts[5];
				userList.add(new User(name, pnum, id, password, isTeacher, teacherName));
			}
			reader.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void loadExerciseData(ArrayList<Exercise> exerciseList) {
		try {
			BufferedReader reader = new BufferedReader(new FileReader("Exercise.txt"));
			String line;
			while ((line = reader.readLine()) != null) {
				String[] parts = line.split(",");
				String code = parts[0];
				String name = parts[1];
				String location = parts[2];
				String date = parts[3];
				int memnum = Integer.parseInt(parts[4]);
				String teachername = parts[5];
				int price = Integer.parseInt(parts[6]);

				exerciseList.add(new Exercise(code, name, location, date, memnum, teachername, price));
			}
			reader.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private static void viewmypage() {
		System.out.println();
	    System.out.println("현재 고객 정보");
	    System.out.println();
	    System.out.println("이름 : " + userName + "\n연락처 :" + userPNnum);
	    int menu = 0;
	    while (true) {
	    	System.out.println();
	        System.out.println("1. 정보수정 2. 내 운동 리스트 3.담당 강사 정보  4. 계정삭제 5. 메인 메뉴로 돌아가기");
	        System.out.print("메뉴를 선택해주세요 : ");
	        try {
	            menu = scan.nextInt();
	            switch (menu) {
	            case 1:
	    			for (;;) {
	    				int info = 0;
	    				for (;;) {
	    					System.out.println();
	    					System.out.println("수정할 정보를 선택해주세요");
	    					System.out.println();
	    					System.out.print("1.연락처 2. 비밀번호 3. 종료");
	    					try {
	    						info = scan.nextInt();
	    						break;
	    					} catch (InputMismatchException e) {
	    						System.out.println();
	    						System.out.println("정수를 입력해주세요");
	    						scan.nextLine();

	    					}
	    				}
	    				switch (info) {
	    				case 1:
	    					scan.nextLine();
	    					System.out.println();
	    					System.out.println("수정할 연락처를 입력해주세요 : ");
	    					String npnum = scan.nextLine();
	    					/*for (User data : userList) {
	    						if (data.getName().equals(userName) && data.getPnum().equals(userPNnum)) {
	    							data.setPnum(npnum);
	    							
	    							break;
	    						}
	    					}*/
	    					userList.stream()
	    						.filter(data -> data.getName().equals(userName)&& data.getPnum().equals(userPNnum) )
	    						.findFirst()
	    						.ifPresent(data->data.setPnum(npnum));
	    					for (People data : poepleList) {
	    						if (data.getName().equals(userName)&& data.getPnum().equals(userPNnum)) {
	    							data.setPnum(npnum);
	    							userPNnum = npnum;
	    							break;
	    						}
	    					}
	    					savePeopleData(poepleList);
	    					saveUserData(userList);
	    					
	    					break;
	    				case 2:
	    					scan.nextLine();
	    					System.out.println("수정할 비밀번호를 입력해주세요 : ");
	    					String npw = scan.nextLine();
	    					for (User data : userList) {
	    						if (data.getName().equals(userName) && data.getPnum().equals(userPNnum)) {
	    							data.setPassword(npw);
	    							break;
	    						}
	    					}
	    					for (People data : poepleList) {
	    						if (data.getName().equals(userName) && data.getPnum().equals(userPNnum)) {
	    							data.setPassword(npw);
	    							break;
	    						}
	    					}
	    					savePeopleData(poepleList);
	    					saveUserData(userList);
	    					break;
	    				case 3:
	    					break;
	    				}

	    				if (info == 3) {
	    					break;
	    				}
	    			}
	    			break;

	            case 2:
	            	System.out.println();
	    			userCart.printCart();
	    			break;
	            case 3:

	    			for (User data : userList) {
	    			
	    				if (data.getPnum().equals(userPNnum)) {
	    					System.out.println();
	    					System.out.println("현재 내 담당 강사 : "+data.getTeacherName());
	    					break;
	    				}
	    			}
	    			break;
	            case 4:
	    			Iterator<User> userIterator = userList.iterator();
	    			boolean foundUser = false;
	    			while (userIterator.hasNext()) {
	    				User currentUser = userIterator.next();
	    				if (currentUser.getName().equals(userName) && currentUser.getPnum().equals(userPNnum)) {
	    					userIterator.remove(); // Iterator를 통해 현재 사용자를 삭제합니다.
	    					foundUser = true;
	    					break; // 삭제 후에는 더 이상 반복할 필요가 없으므로 반복문을 종료합니다.
	    				}
	    			}

	    			if (foundUser) {
	    				System.out.println();
	    				System.out.println("사용자 정보가 성공적으로 삭제되었습니다.");
	    			} else {
	    				System.out.println();
	    				System.out.println("사용자 정보를 찾지 못했습니다.");
	    			}
	    			break;
	    		case 5:
	    			return;
	    		default:
	    			System.out.println("잘못된 입력입니다.");
	    			break;
	            }
	        } catch (InputMismatchException e) {
	        	System.out.println();
	            System.out.println("정수를 입력해주세요");
	            scan.nextLine(); // 버퍼 비우기
	        }
	    }
	}

	private static void login() {
		for (;;) {
			System.out.println("기존 회원 이시면 Y를, 아니면 N을 입력해주세요");
			System.out.print("입력 : ");
			boolean flag = false;
			String s = scan.nextLine();
			if (s.toUpperCase().equals("Y")) {
				scan.nextLine();
				System.out.print("아이디를 입력해주세요 : ");
				String id = scan.nextLine();
				scan.nextLine();
				System.out.print("비밀번호를 입력해주세요 : ");
				String pw = scan.nextLine();
				for (People data : poepleList) {
					if (data.getId().equals(id) && data.getPassword().equals(pw)) {
						System.out.println();
						System.out.println("로그인에 성공하였습니다.");
						System.out.println();
						userName = data.getName();
						userPNnum = data.getPnum();
						flag = true;
						break;
					}
				}
				// 로그인 end of for2
				if (flag == true) {
					break;

				} else {
					System.out.println("일치하는 회원정보가 없습니다");
				}
			} else if (s.toUpperCase().equals("N")) {
				signIn();

			} else {
				System.out.println("올바르게 입력해주세요");
			}
		} // end of for 1
		userCart.loadExerciseData(userName,userPNnum);
	}

	private static void signIn() {
		boolean teach = false;
		System.out.println();
		System.out.print("고객의 이름을 입력하세요 : ");
		String name = scan.nextLine();
		scan.nextLine();
		System.out.println();
		System.out.print("고객의 연락처를 입력하세요 : ");
		String pnum = scan.nextLine();
		scan.nextLine();
		System.out.println();
		System.out.print("고객의 id를 입력하세요 : ");
		String id = scan.nextLine();
		scan.nextLine();
		System.out.println();
		System.out.print("고객의 비밀번호를 입력하세요 : ");
		String pw = scan.nextLine();
		scan.nextLine();
		System.out.println();
		System.out.print("강사로 가입하시는건가요? (Y / N) : ");
		String teacher = scan.nextLine();

		if (teacher.toUpperCase().equals("Y")) {
			teach = true;
			instructorList.add(new Instructor(name, pnum, id, pw, teach));

		} else if (teacher.toUpperCase().equals("N")) {

			userList.add(new User(name, pnum, id, pw, teach, "미정"));

		} else {
			System.out.println();
			System.out.println("올바르게 입력해주세요");
		}

		poepleList.add(new People(name, pnum, id, pw, teach));
	}

}
