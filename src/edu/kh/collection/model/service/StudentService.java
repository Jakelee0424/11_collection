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

	/**
	 *  학생 정보추가 메서드
	 *  - 추가 성공시 "성공", 실패시 "실패" 문자열 반환
	 */
	public String addStudent() throws InputMismatchException {
		System.out.println("========= 학생 정보 추가 =========");
		
		System.out.print("이름 >> ");
		String name = sc.next();
		
		System.out.print("나이 >> ");
		int age = sc.nextInt();
		
		sc.nextLine(); // 입력 버퍼 개행 문자 제거
		System.out.print("거주지 >> ");
		String region = sc.nextLine();
		
		System.out.print("성별(M/F) >> ");
		char gender = sc.next().charAt(0);
		
		System.out.print("성적 >> ");
		int score = sc.nextInt();
		
		// student 객체 생성 후 List에 추가
		
		if(	studentList.add(new Student(name, age, region, gender, score)) ) {
			// boolean java.util.List.add
			return "\n성공!\n";
		} else {
			return "\n실패!\n";
		}
		
	}

	/**
	 * 학생 정보 조회 전체 메서드
	 */
	public void selectAll() {
		// List는 인덱스가 있음. (from 0)
		// List에 저장된 데이터의 개수를 얻어오는 방법
		// -> 배열명.length 대신 사용
		// ** size  -> int List.size()
		
		// List가 비어있는지 확인하는 방법
		// ** boolean List.isEmpty() : 비어있으면 true 반환
		
		System.out.println("========= 학생 전체 조회 =========");
		//studentList가 비어있는 경우 "학생 정보가 없습니다" 조회
		
//		if(studentList.size() == 0 ) {}
		if(studentList.isEmpty()) {
			System.out.println("학생 정보가 없습니다.\n");
		return;
		}
//		
//		for(int i = 0 ; i < studentList.size() ; i++) {
//			System.out.println(studentList.get(i));
//		}
		
//		향상된 for 문 (== for each문)
//		컬렉션, 배열의 모든 요소를 순차적으로 반복접근할 수 있는 for 문
//		(0번 인덱스 부터, 마지막 인덱스까지 1씩 증가)
		int index =0;
		for(Student std : studentList) {
			System.out.print((index++) + "번 인덱스 ");
			System.out.println(std);
		}
		System.out.println();
	}
	
	/**
	 * 학생 정보 수정 메서드
	 */
	public String updateStudent() throws InputMismatchException{
		// set 메서드 : List.set(index, Student e);
		// List의 i번째 요소를 e로 변경
		// 반환값이 Student == 변경 전 Student 객체가 담겨있다.
		
		System.out.println("========= 학생 정보 수정 =========");
		
		System.out.print("인덱스 번호 입력 >>");
		int input = sc.nextInt();
		
		// 1) 학생 정보가 studentList에 있는가
		// 2) 입력된 수가 0보다 작은가
		// 3) 문자열을 입력했다면 예외처리 throws
		// 4) 입력받은 숫자가 studentList 범위 내 인덱스 번호인가
		
		if(studentList.isEmpty()) {
			return "입력된 학생 정보가 없습니다.";
		} else if(input < 0) {
			return "음수는 입력할 수 없습니다.";
		} else if(input >= studentList.size()){
			return "범위를 넘어선 값을 입력할 수 없습니다.";
		} else {
			System.out.print(input + "번째 인덱스에 저장된 학생 정보");		
			System.out.println(studentList.get(input));		
			
			System.out.print("이름 >> ");
			String name = sc.next();
			
			System.out.print("나이 >> ");
			int age = sc.nextInt();
			
			sc.nextLine(); // 입력 버퍼 개행 문자 제거
			System.out.print("거주지 >> ");
			String region = sc.nextLine();
			
			System.out.print("성별(M/F) >> ");
			char gender = sc.next().charAt(0);
			
			System.out.print("성적 >> ");
			int score = sc.nextInt();
			
			Student temp  = studentList.set(input, new Student(name, age, region, gender, score));
				
			return temp.getName() + "의 정보가 변경되었습니다.\n";		
		}
		
	}

	/**
	 * 학생 정보 제거 메서드 
	 */
	public String removeStudent() throws InputMismatchException{
	System.out.println("========= 학생 정보 제거 =========");
	
		// List.remove(int index)
		// 리스트에서 index번째 요소를 제거
		// 이때, 제거된 요소가 반환된다.
		// 제거되면 다음 번째 인덱스 요소를 당겨옴 (비어있는 인덱스 없음)
	
		System.out.print("인덱스 번호 입력 >>");
		int input = sc.nextInt();

		if(studentList.isEmpty()) {
			return "입력된 학생 정보가 없습니다.";
		} else if(input < 0) {
			return "음수는 입력할 수 없습니다.";
		} else if(input >= studentList.size()){
			return "범위를 넘어선 값을 입력할 수 없습니다.";
		} else {
			System.out.println(input + "인덱스의 학생 정보 = " + studentList.get(input) );	
			System.out.println("\n정말 삭제 하시겠습니까?(y / n)");
			char input2 = sc.next().toUpperCase().charAt(0); // toUpperCase : 대문자로 변경
			if(input2 == 'Y') {
				
			Student temp = studentList.remove(input);
			return temp.getName() + "의 정보가 변경되었습니다.\n";
		
			}else {
				return "취소";
			}
			
		}
		
	}

	/**
	 * 학생 정보 검색(일치) 메서드
	 */
	public void searchStudent() throws InputMismatchException{
		System.out.println("========= 학생 정보 검색(일치) =========");

		System.out.print("검색할 학생 이름을 입력하세요 >> ");
		String input = sc.next();

		boolean flag = true;
		
		for(Student std : studentList) {
			if(input.equals(std.getName())) {
				System.out.println(std + "\n");
				flag = false;
			}
		}
		if(flag) {
			System.out.println("검색 결과가 없습니다.\n");
		}
	}

	/**
	 * 학생 정보 검색(일부) 메서드
	 * 이름에 특정 문자열이 포함되는 학생을 찾아서 조회하는 메서드
	 */
	public void searchStudent2() {
		System.out.println("========= 학생 정보 검색(일부) =========");

		System.out.print("이름에 포함된 문자를 입력하세요 >> ");
		String input = sc.next();

		boolean flag = true;
		
		for(Student std : studentList) {
			
			// boolean String.contains(문자열) : String에 문자열이 포함되면 true 아니면 false 
			
			if( std.getName().contains(input)) {
				System.out.println(std + "\n");
				flag = false;
			}
		}
		if(flag) {
			System.out.println("검색 결과가 없습니다.\n");
		}
	}
	
}
