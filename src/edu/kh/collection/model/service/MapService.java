package edu.kh.collection.model.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import edu.kh.collection.model.vo.Member;

public class MapService {

	// Map
		// Key : Value가 한쌍을 이루는 객체
		// key 값만 모아두면 set의 특징
		// value를 모아두면 List의 특징을 가짐
		// value는 값의 중복 허용 가능 (key는 안됨)

	public void ex1() { // HashMap <K, V> : Map의 자식 클래스 중 가장 대표되는 놈
		
		Map<Integer, String> map = new HashMap<Integer, String>();
		
		// Map.put() : 추가 (매개변수에 두개(K,V))
		
		map.put(1, "홍길동");
		map.put(2, "강건강");
		map.put(3, "고길동");
		map.put(4, "김길동");
		map.put(5, "이길동");
		map.put(6, "최길동");
		
		// key 중복 안됨 -> 덮어 쓰기
		map.put(1, "홍동길");
		
		// Value 중복 가능
		map.put(7, "최길동");
		
		System.out.println(map); // map.toString 오버라이딩 되어있음.
		
	}

	public void ex2() { // Map 사용 예제
		
		// VO(값 저장용 객체)는 특정 데이터 묶음의 재사용이 많은 경우 주로 사용
		//  -> 재사용이 적은 VO는 오히려 코드 낭비
		//  -> Map을 이용해 VO와 비슷한 코드 작성 가능
		
		// 1) VO Ver
		Member mem = new Member();
		
		// 값세팅
		mem.setId("user01");
		mem.setPw("pass1");
		mem.setAge(30);
		
		// 값출력
		System.out.println(mem.getId());
		System.out.println(mem.getPw());
		System.out.println(mem.getAge());
//--------------------------------------------------------------
		
		// 2) Map Ver
		
		Map<String, Object> map = new HashMap<String, Object>();
		// value가 Object 타입 == 어떤 객체든 Value에 들어올 수 있다.
		
		//값 세팅
		map.put("id", "user02");
		map.put("pw", "pass2");
		map.put("age", 25);
		
		//값 출력
		System.out.println(map.get("id"));
		System.out.println(map.get("pw"));
		System.out.println(map.get("age"));
		System.out.println("-----------------------------------");
//--------------------------------------------------------------		
		
		// Map에 저장된 데이터 순차 접근
		
		// Map에서 key만 모아두면 Set의 특징을 가짐
		// -> 이를 활용할 수 있도록 Map에서 메서드 제공 
		//  ** KeySet() -> Key만 모아서 Set으로 제공
			// Map에 저장된 데이터가 많거나, 어떤 Key가 있는지 불분명할때
			// map에 저장된 모든 데이터에 접근해야할때
		
		
		Set<String> set = map.keySet();
		System.out.println(set);
		
		// 향상된 for문으로 데이터 꺼내올 수 있음
		for(String key : set) {
			System.out.println(map.get(key));		
		}
		
		
	}

	public void ex3() { // 컬렉션 안에 컬렉션 (List 안에 맵)
	
		List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
		
		for(int i = 0 ; i < 10 ; i++) {
			// 맵 생성
			Map<String, Object> map = new HashMap<String, Object>();
			
			// 맵에 데이터 추가
			map.put("id", "user0" + i);
			
			// 맵을 리스트에 추가
			list.add(map);
		
		}
		
		for(Map<String, Object> temp : list) {
			System.out.print(temp.get("id") + " ");
		
		}
		
	}
}

