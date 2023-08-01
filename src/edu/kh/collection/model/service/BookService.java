package edu.kh.collection.model.service;

import java.awt.DisplayMode;
import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

import edu.kh.collection.model.vo.Book;
import edu.kh.collection.model.vo.Student;

public class BookService {

	Scanner sc = new Scanner(System.in);
	List<Book> list = new LinkedList<Book>();
	Map<Integer, String> map = new HashMap<Integer, String>();
	
	public void displayMenu() { // 메뉴 화면
		int input = 0;
		
		do{
			System.out.println("=========== 도서 관리 프로그램 ============");
			System.out.println("1. 도서 등록");
			System.out.println("2. 도서 전체 조회");
			System.out.println("3. 도서 검색");			
			System.out.println("4. 도서 수정");
			System.out.println("5. 도서 삭제");
			System.out.println("6. 즐겨찾기 추가");
			System.out.println("7. 즐겨찾기 조회");
			System.out.println("8. 즐겨찾기 제거");
			System.out.println("0. 프로그램 종료");
			System.out.println("-----------------");
			System.out.print("번호 입력 >> ");
			
			try {
				input = sc.nextInt();
				sc.nextLine();
				switch(input) {
				case 1 : System.out.println(addBook()); break;
				case 2 : overView(); break;
				case 3 : lookFor(); break;
				case 4 : setBook(); break;
				case 5 : System.out.println(deleteBook()); break;
				case 6 : favorite(); break;
				case 7 : lookFavorite(); break;
				case 8 : deleteFavorite(); break;
				case 0 : System.out.println("프로그램 종료"); break;
				default : System.out.println("잘못 입력하셨습니다.");

				}

			} catch(InputMismatchException e) {
				System.out.println("\nerror : 입력형식이 유효하지 않습니다. 다시 시도해주세요\n");
				sc.nextLine(); 
				input = -1; 

			}

		} while(input != 0);

	}

	public String addBook() throws InputMismatchException { //도서 추가
		System.out.println("\n**** 도서 추가 ****\n");
		
		System.out.print("책 제목 >> ");
		String title = sc.nextLine();
		
		
		System.out.print("책 저자 >> ");
		String author = sc.next();
		
		System.out.print("가격 >> ");
		int price = sc.nextInt();
		
		sc.nextLine();
		System.out.print("출판사 >> ");
		String publicier = sc.nextLine();
				
		list.add(new Book(title, author, price, publicier));
		return "\n도서 등록 완료!\n";
	}
	
	public void overView() { // 도서 전체 조회
		System.out.println("\n**** 도서 전체 목록 ****\n");
		int num = 0;
		
		for(Book bb : list) {
			System.out.println(num++ + "번 인덱스의 책 : " + bb);	
		}
	}
	
	public void lookFor() throws InputMismatchException{ // 도서 조회
		System.out.println("\n**** 도서 조회 ****\n");
		System.out.println("1. 도서명으로 검색");
		System.out.println("2. 작가명으로 검색");
		System.out.println("3. 출판사로 검색");
		System.out.print("번호 입력 >>");
		int num = sc.nextInt();
		sc.nextLine();
		
		if (num == 1 ) {
			System.out.print("도서명을 입력하세요 >> ");
			String input = sc.nextLine();
		
			for(Book b : list) {
				if(b.getTitle().contains(input)) {
					System.out.println("\n"+b+"\n");
				}else {
					System.out.println("\n등록된 정보가 없습니다. \n");
				}
			}	
		} else if(num == 2) {
			System.out.print("작가명을 입력하세요 >> ");
			String input = sc.nextLine();

			for(Book b : list) {
				if(b.getAuthor().contains(input)) {
					System.out.println("\n"+b+"\n");
				}else {
					System.out.println("\n등록된 정보가 없습니다. \n");
				}
			}
		} else if(num ==3 ) {
			System.out.print("출판사명을 입력하세요 >> ");
			String input = sc.nextLine();

			for(Book b : list) {
				if(b.getPublisier().contains(input)) {
					System.out.println("\n"+b+"\n");
				}else {
					System.out.println("\n등록된 정보가 없습니다. \n");
				}
			}

		} 
	}
	
	public void setBook() throws InputMismatchException{// 도서 정보 수정
		System.out.println("\n**** 도서 정보 수정 ****\n");
		
		System.out.println("수정을 원하는 도서의 인덱스 번호를 입력하세요");
		System.out.print("인덱스 번호 입력 >>  ");
		int input = sc.nextInt();

		System.out.println(list.get(input).toString());
		
		System.out.print("수정을 진행하시겠습니까? (y/n)>>");
		char yes = sc.next().toUpperCase().charAt(0);
		
		if(yes == 'Y') {
			System.out.println("\n**** 수정 진행 ****\n");
			System.out.println("1. 책 제목");
			System.out.println("2. 책 저자");
			System.out.println("3. 가격");
			System.out.println("4. 출판사");
			System.out.print("\n수정을 원하는 항목을 선택하세요. >>  ");
			int input2 = sc.nextInt();
			sc.nextLine();
			
			if(input2 == 1) {
				System.out.print("책 제목 >> ");
				String title = sc.nextLine();
				list.get(input).setTitle(title);
				System.out.println("제목 변경 완료!\n");
				
			}else if(input2 == 2 ) {
				System.out.print("책 저자 >> ");
				String author = sc.nextLine();
				list.get(input).setAuthor(author);
				System.out.println("작가 변경 완료!\n");
			
			}else if(input2 == 3 ) {				
				System.out.print("가격 >> ");
				int price = sc.nextInt();
				list.get(input).setPrice(price);
				System.out.println("가격 변경 완료!\n");
				
			}else if(input2 == 4 ) {						
				System.out.print("출판사 >> ");
				String publicier = sc.nextLine();
				list.get(input).setPublisier(publicier);
				System.out.println("출판사 변경 완료!\n");
				
			} else
				
			System.out.println("잘못 입력하셨습니다.");
		}
		
		
	
	}

	public String deleteBook() throws InputMismatchException{ // 도서 정보 제거
		System.out.println("\n**** 도서 정보 제거 ****\n");
		System.out.println("제거를 원하는 도서의 인덱스 번호를 입력하세요.");
		System.out.print("인덱스 번호 입력 >>  ");
		int input = sc.nextInt();

		System.out.println(list.get(input).toString());
		
		System.out.print("제거를 진행하시겠습니까? (y/n)>>");
		char yes = sc.next().toUpperCase().charAt(0);
		
		if(yes == 'Y') {
			 list.remove(input);
			 return "제거가 완료되었습니다";			
		} else {
			return "제거 실패";
			
		}
	
	}

	public void favorite() throws InputMismatchException { // 즐겨찾기 추가
		System.out.println("\n**** 즐겨찾기 추가 ****\n");
		
		System.out.println("즐겨찾기 목록에 추가할 도서의 인덱스 번호를 입력하세요");
		System.out.print("인덱스 번호 >> ");
		int input = sc.nextInt();
		
		map.put(input, list.get(input).getTitle());
		System.out.println("\n즐겨찾기에 추가되었습니다.");	
	}
	
	public void lookFavorite() { // 즐겨찾기 조회
		System.out.println("\n**** 즐겨찾기 조회 ****\n");
		Set<Integer> set = map.keySet();
		
		for(Integer key : set) {
			System.out.println(key + "번 인덱스의 "+ map.get(key));		
		
		}
		
	}
	
	public void deleteFavorite() throws InputMismatchException { //즐겨찾기 제거
		System.out.println("\n**** 즐겨찾기 제거 ****\n");
		System.out.println("제거를 원하는 도서의 인덱스 번호를 입력하세요.");
		System.out.print("인덱스 번호 입력 >>  ");
		int input = sc.nextInt();

		System.out.println(map.get(input).toString());
		
		System.out.print("제거를 진행하시겠습니까? (y/n)>> ");
		char yes = sc.next().toUpperCase().charAt(0);
		
		if(yes == 'Y') {
			 map.remove(input);
			 System.out.println("제거가 완료되었습니다");			
		} else {
			System.out.println("제거 실패");
			
		}
	
		
		
	}
	
}
