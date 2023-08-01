package edu.kh.collection.model.service;

import java.util.InputMismatchException;
import java.util.LinkedList;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import edu.kh.collection.model.vo.Student;

public class StudentService {

	Scanner sc = new Scanner(System.in);
	
	// 학생 정보 저장 List 생성
	
	// java.util.List 인터페이스 : List에 반드시 필요한 필수 기능을 모아둔 인터페이스
		// * 인터페이스는 객체 생성 x, 부모 참조변수 o
	
	// java.util.ArrayList : 배열 형태 List(대표적인 List의 자식)
		// ArrayList() 기본생성자 : 기본 크기 10짜리 리스트 생성
		//						-> 크기는 알아서 조절
		// ArrayList(용량) : 용량만큼의 리스트를 생성하겠다.(너무 큰 값을 작성하면 메모리 소모가 큼)
		//					-> 용량도 알아서 조절되니까 무의미
	
				//generics - '< >' : 컬렉션에 저장되는 객체 타입을 한가지로 통일
				//		   == Student만 저장 가능 == 모든게 Student == Student임을 검사할 필요가 없다.
//	private List<Student> studentList = new ArrayList<Student>(); // 검색, 조회에 효율적
	private List<Student> studentList = new LinkedList<Student>(); // 추가, 수정, 삭제에 효율적
	
	
	/**
	 * 생성자
	 */
	public StudentService() { 
		
		studentList.add( new Student("홍길동", 20, "서울시 중구", 'M', 90) );
		studentList.add( new Student("고영희", 30, "서울시 성북구", 'F', 80) );
		studentList.add( new Student("강아지", 40, "서울시 노원구", 'M', 70) );
		studentList.add( new Student("오미나", 50, "서울시 도봉구", 'F', 60) );
		studentList.add( new Student("박주희", 60, "서울시 종로구", 'M', 50) );
		
	}
	
	/**
	 *  List 테스트
	 */
	public void ex() {
		
//		List.add(Object a) : 리스트에 객체 추가
//							 - (제네릭으로 제한 걸지 않으면)매개변수 타입은 기본적으로 Object
//		Object List.get(index 1) - 반환형도 마찬가지
		
		studentList.add(new Student()); // 0번째 인덱스
//		studentList.add(sc); // 1번째 인덱스
//		studentList.add("문자열"); // 2번째 인덱스
//		studentList.add(new Object()); // 3번째 인덱스
			// =>  여러 타입의 데이터를 저장할 수 있다.
		
//		if(studentList.get(0) instanceof Student) {
//			System.out.println((Student)studentList.get(0));
			
			// Student 객체타입을 찾기 위해 복잡한 과정 필요
			// *** generics 사용!
		
	}
	
	/**
	 * 메서드 설명용 주석(alt + shift + j)
	   @author 작성자
	 */
	public void displayMenu() { // 메뉴 출력용 메서드
		
		int menuNum = 0;
				
		do {
			
			System.out.println("======== 학생관리 프로그램 =========");
			System.out.println("1. 학생 정보 추가");
			System.out.println("2. 학생 정보 조회");
			System.out.println("3. 학생 정보 수정");
			System.out.println("4. 학생 정보 제거");
			System.out.println("5. 이름으로 검색(일치)");
			System.out.println("6. 이름으로 검색(일부)");
			System.out.println("*********************");
			System.out.println("0. 프로그램 종료");
			
			System.out.print("\n메뉴 번호 선택 >> ");
			
						
			try {	
				menuNum = sc.nextInt();
				System.out.println();
				
				switch(menuNum) {
				case 1 : System.out.println(addStudent()); break;
				case 2 : selectAll(); break;
				case 3 : System.out.println(updateStudent()); break;
				case 4 : System.out.println(removeStudent()); break;
				case 5 : searchStudent(); break;
				case 6 : searchStudent2(); break;
				case 0 : System.out.println("프로그램을 종료합니다."); break;
				default : System.out.println("메뉴에 작성된 번호만 입력하세요");
				}
				
			}catch(InputMismatchException e){
				System.out.println("\nerror : 입력형식이 유효하지 않습니다. 다시 시도해주세요\n");
				sc.nextLine(); // 입력버퍼에 남아있는 잘못된 문자열 제거
				menuNum = -1; // 첫 반복에서 잘못 입력했을 때 종료되는 것을 방지
			}

		}while(menuNum != 0);
	}

	public String addStudent() throws InputMismatchException {
		System.out.println("======= 학생 정보 추가 =======");
		
		System.out.print("이름 입력 >> ");
		String name = sc.next();
		
		System.out.print("나이 입력 >> ");
		int age = sc.nextInt();
		
		sc.nextLine();
		System.out.print("거주지 입력 >> ");
		String region = sc.nextLine();
		
		System.out.print("성별 입력 >> ");
		char gender = sc.next().charAt(0);
		
		System.out.print("점수 입력 >> ");
		int score = sc.nextInt();
		
		studentList.add(new Student(name, age, region, gender, score));

		return "추가 성공 ";
	}
	
	public void selectAll() {
		System.out.println("======= 학생 정보 조희 =======");
		
		for(Student std : studentList) {
			System.out.println(std);
		}
		if(studentList.isEmpty()) {
			System.out.println("학생 정보가 없습니다.");
		}
		System.out.println();
		
	}

	public String updateStudent() throws InputMismatchException{
		System.out.println("======= 학생 정보 수정 =======");
		
		System.out.print("수정을 원하는 학생의 인덱스 번호를 입력하세요 >>");
		int input = sc.nextInt();
		
		System.out.println(studentList.get(input) + "\n");
		System.out.print("수정을 진행하시겠습니까?(y/n) >>");
		char input2 = sc.next().toUpperCase().charAt(0);
		
		if (input2 == 'Y') {		
			System.out.print("\n이름 입력 >> ");
			String name = sc.next();

			System.out.print("나이 입력 >> ");
			int age = sc.nextInt();

			sc.nextLine();
			System.out.print("거주지 입력 >> ");
			String region = sc.nextLine();

			System.out.print("성별 입력 >> ");
			char gender = sc.next().charAt(0);

			System.out.print("점수 입력 >> ");
			int score = sc.nextInt();

			studentList.set(input, new Student(name, age, region, gender, score));
		
			return "\n** 수정 완료! **\n";
		} else {
			return "\n** 수정 실패! **\n";
		}
	}

	public String removeStudent() throws InputMismatchException{
		System.out.println("======= 학생 정보 제거 =======");
		
		System.out.print("정보 제거를 원하는 학생의 인덱스 번호를 입력하세요 >> ");
		int input = sc.nextInt();
		
		if (input < 0 || input >= studentList.size()) {
			return "잘못 입력하셨습니다.";
		}
			
		System.out.println(studentList.get(input) + "\n");
		System.out.print("정보 제거를 진행하시겠습니까?(y/n) >>");
		char input2 = sc.next().toUpperCase().charAt(0);
		
		
		if (input2 == 'Y') {	
			studentList.remove(input);
			return "\n정보 제거 완료!\n";
		} else {
			return "\n정보 제거 실패!\n";
			
		}
	
	}

	public void searchStudent() {
		System.out.println("======= 학생 정보 조회(전체) =======");
		
		System.out.print("학생 이름 입력 >> ");
		String input = sc.next();
		
		boolean var = true;
		
		for(Student std : studentList) {
			if(input.equals(std.getName())) {
				System.out.println(std + "\n");
				var = false;
			} 
			
		}
		if(var) {
		System.out.println("잘못 입력하셨습니다.\n");
		}
	}

	public void searchStudent2() {
	System.out.println("======= 학생 정보 조회(일부) =======");
		
		System.out.print("학생 이름 입력 >> ");
		String input = sc.next();
		
		boolean var = true;
				
		for(Student std : studentList) {
			if(std.getName().contains(input)) {
				System.out.println(std + "\n");
				var = false;
			} 
			
		}
		if(var) {
		System.out.println("잘못 입력하셨습니다.\n");
		}
	
		
	}
}
