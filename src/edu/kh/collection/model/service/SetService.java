package edu.kh.collection.model.service;

import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

import edu.kh.collection.model.vo.Member;

public class SetService {
// set(집합)
// 1) 순서 유지하지 않음(인덱스 없음)
// 2) 중복 허용하지 않음(null도 중복 허용 안함)
	
// ** Set이 중복을 확인하는 방법
// 	객체가 가지고 있는 필드값이 모두 같으면 중복으로 판단
// 	필드값이 모두 같은지 비교하기 위해서 
//	' 객체에 equals()가 반드시 오버라이딩 되어있어야 한다. '
	
	Scanner sc = new Scanner(System.in);
	
	public void ex1() { // HashSet 확인

		Set<String> set = new HashSet<String>();
		
		//HashSet : Set의 대표적인 자식 클래스
		// 사용조건 
		// 1) 저장되는 객체에 equals() 오버라이딩 필수
		// 2) 저장되는 객체에 hashCode() 오버라이딩 필수
		
		//  * Hash라는 단어가 붙은 컬렉션은 반드시 저장되는 객체에
		//    hashCode(), equals() 오버라이딩 해야함
		
		set.add("안녕");
		set.add("하세요");
		set.add("이름은");
		set.add("제이크");
		set.add("입니다.");
		set.add("입니다.");
		set.add("입니다.");
		set.add(null);
		set.add(null);
		set.add(null);
		
		System.out.println(set);
		System.out.println("------------------");
		// 순서 유지 X, 중복 X(null 포함);
		
		System.out.println("저장된 데이터 수  : " + set.size());
		System.out.println("------------------");
		// 사이즈도 중복값 제거된 개수
		
		// remove(String e) : Set에 저장된 객체 중 매개변수 e와 필드 값이 같은 객체를 제거
		// 반환값은 boolean -> 제거완료면 true, 안되면 false
		System.out.println(set.remove("안녕"));
		System.out.println(set.remove("하이"));
		System.out.println(set);
		System.out.println("------------------");
		
		// Set은 순서가 없어서 객체 하나를 가져올 방법이 없음.
		// 대신 전체 데이터를 하나씩 반복적으로 얻어올 수는 있음
		
	// 1) 첫번째 방법(Iterator, 반복자)
		// 	  - 컬렉션에서 제공하는 반복 접근자 메서드
		//    - 저장된 데이터를 임의로 꺼내는 역할
		Iterator<String> it = set.iterator(); // iterator가 가져온 데이터 타입이 모두 String :<제네릭>
											  // set.iterator() -> set을 Iterator로 하나씩 꺼내갈 수 있는 모양으로 
		//    - while문으로 접근
		while(it.hasNext()) { 				  // it.hasNext() : 다음 값이 있으면 true 반환
			System.out.println(it.next());	  // it.next() : 다음 값(객체)를 얻어옴
		}
		System.out.println("------------------");
		
	// 2) 두번째 방법(향상된 for문) 
		for(String temp : set) { 		// for(하나씩 꺼내서 저장할 변수 : 컬렉션)
			System.out.println(temp);
		}
		
	}	
	
	public void ex2() { // 오버라이딩 확인
		
		Set<Member> memberSet = new HashSet<Member>();
		
		memberSet.add(new Member("user01", "pass01", 30));
		memberSet.add(new Member("user01", "pass01", 30));
		memberSet.add(new Member("user03", "pass03", 25));
		
		for(Member us : memberSet) { // 중복제거가 안되어 있음 
								  	 // -> alt + shift + s 에 hash, equals 오버라이드
			System.out.println(us);  // (제네릭이 String일때는 자동)
		}
		
		// object의 equals(), hashCode()을 오버라이딩	
		// A.equals(b) : A와 B가 가지고 있는 필드 값이 모두 같으면 truem 아니면 false
			// hash 함수 : 입력된 단어를 지정된 길이의 문자열로 변환하는 함수(중복X)
			//	ex) 입력 : 111 -> "asdfg" (다섯글자)
			//	ex) 입력 : 12323123 -> "zsfsa"	(다섯글자)
		// hashCode() : 필드값이 다르면 중복되지 않는 숫자를 만드는 메서드
		//			  : 빠른 데이터 검색을 위해(객체가 어디있는지 빨리 찾기 위해)
		
		
		// ** HashSet **
		// 중복 없이 데이터를 저장하고, 데이터 검색이 빠름(hash 덕분에)
		
	}

	public void ex3() { // Wrapper 클래스
		
		// Wrapper 
		// 기본 자료형을 객체 형태로 포장해주는 클래스
		
		// 컬렉션에 기본자료형 값을 저장하고 싶을 때 사용 
		// 기본 자료형에 없던 추가 기능, 값을 이용하고 싶을 때 사용
		
		// <Wrapper 종류>
			// int -> Integer
			// char -> Character
			// double -> Double
			// boolean -> Boolean
			// float -> Float
			// byte -> Byte
			// short -> Short
			// long -> Long
		
		int iNum = 10;
		double dNum = 3.14;
		
		Integer w1 = new Integer(iNum); // int가 Integer로 포장
		Double w2 = new Double(dNum);   // double이 Double로 포장
		// 삭제선 == 해당 구문은 삭제될 예정(사용 권장 X)
		
		
		// Wrapper의 활용
		System.out.println("int의 최대값 : " + w1.MAX_VALUE);
		System.out.println("double의 최소값 : " + w2.MIN_VALUE); 
		// 기울어진 글씨 = static
		// static은 클래스명.필드명 / 클래스명.메소드명() 호출 
		
		System.out.println("static 방식으로 Wrapper클래스 사용하기");
		System.out.println("int의 최대값 : " + Integer.MAX_VALUE);
		System.out.println("double의 최소값 : " + Double.MIN_VALUE);
		
		//parsing - 데이터 형식을 변환
		int num1 = Integer.parseInt("100"); // 문자열 "100"을 int 형식으로 변환
		System.out.println(num1);
		double num2 = Double.parseDouble("1.234");// 문자열 "1.23455"을 double형식으로 변환
		System.out.println(num2);
		System.out.println(num1 + num2);
	}

	public void ex4() { // Wrapper 클래스 삭제선
		
		//Wrapper 클래스의 AutoBoxing / AutoUnboxing
		
		int num =100;
		Integer w1 = new Integer(num);
		
		Integer w2 = 100;  //오토박싱
		Integer w3 = 200;  
		// (Integer)  (int -> Integer로 자동 포장)
		
		// w2와 100은 원래 연산이 안되는 게 맞지만
		// Integer는 int의 포장 형식이라는 것을 java가 인식하고 있어 
		// int를 Integer로 자동 포장해준다.
		
		System.out.println(w2 + w3); //오토 언박싱
		// Integer + Integer -> int + int로 자동 포장해제
		
		// w2와 w3는 객체임 (원래는 불가능)
		// Integer는 int의 포장 형태라는 것을 인식
		// +연산 시 포장을 자동으로 벗겨냄								
	}
	
	public void lotto2() {
		//로또 번호 생성기 vol.2
		
//		Set<Integer> set = new HeshSet<Integer>(); // 
//		Set<Integer> set = new TreeSet<Integer>(); // TreeSet : 자동 정렬
		Set<Integer> set = new LinkedHashSet<Integer>(); // LinkedHashSet : 순서 유지
				
		while(set.size() < 6 ) {
			int random = (int)(Math.random()*45 + 1);
			set.add(random);
		}
		System.out.println("로또 번호 : " + set);
	}
	
	
	
}
