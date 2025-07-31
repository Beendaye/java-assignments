package homework.day13;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class Example02 {

	public static void main(String[] args) {
	/*
		Map
		- key값과 value값을 한 쌍으로 관리하는 객체
		- key값은 중복을 허용하지 않고 순서가 없다 (Set의 특징)
		- value값은 중복을 허용한다.
	*/
		Map<String, String> hMap = new HashMap<String, String>();
		
		// 데이터 추가 => put(key값, value값);
		hMap.put("name", "홍길동");
		hMap.put("addr", "대전");
		hMap.put("tel", "010-1234-5678");
		
		System.out.println("hMap => " + hMap);
		
		// 데이터 수정 => 데이터를 저장할 때 key값이 같으면 나중에 입력한 값이 저장된다.
		//			   put(수정할 key값, 새로운 value값)
		hMap.put("addr", "서울");
		System.out.println("hMap => " + hMap);
		
		// 데이터 삭제 => remove(삭제할 데이터의 key값)
		hMap.remove("name");
		System.out.println("hMap => " + hMap);
		
		// 데이터 읽기 => get(읽어올 데이터의 key값)
		System.out.println("addr = " + hMap.get("addr"));
		System.out.println("------------------------------");
		
		// key 값들을 읽어와 데이터를 가져오는 방법
		
		// 방법1) keySet() 메서드를 이용하기
		Set<String> keySet = hMap.keySet();
		
		System.out.println("Iterator 이용하는 방법");
		Iterator<String> it = keySet.iterator();
		while(it.hasNext()) {
			String key = it.next();
			System.out.println(key + " : " + hMap.get(key));
		}
		
		System.out.println("------------------------------");
		
		// 방법2) 향상된 for문
		System.out.println("향상된 for문 이용하는 방법");
		for(String key : keySet) {
			System.out.println(key + " : " + hMap.get(key));
		}
		
		System.out.println("------------------------------");
		
		// 방법3) value값들만 읽어와 출력하기 => values() 메서드 사용
		System.out.println("values() 메서드 이용하는 방법");
		for(String value : hMap.values()) {
			System.out.println(value);
		}
		
		System.out.println("------------------------------");
		
		// 방법 4) Map관련 클래스에는 Map.Entry 타입의 내부클래스가 존재한다.
		//        이 내부클래스를 이용한 객체를 Set 타입의 객체로 가져오기 위해  
		//        entrySet() 메서드를 이용한 방법
		System.out.println("entrySet()을 이용한 방법");
		
		Set<Map.Entry<String, String>> entrySet = hMap.entrySet(); // entrySet 리턴
		
		Iterator<Map.Entry<String, String>> entryIt = entrySet.iterator();
		
		while(entryIt.hasNext()) {
			Map.Entry<String, String> entry = entryIt.next();
			System.out.println(entry.getKey() + " : " + entry.getValue());
		}
		
		// Entry타입으로 접근해서 getKey, getValue 사용해서 데이터 가져오기
	}

}