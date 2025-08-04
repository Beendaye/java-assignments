package homework.day14;

public class PlanetTest {
	
	// planet 열거형
	public enum Planet {
		// 행성(반지름)
		MERCURY(2439), 	// 수성
		VENUS(6052),   	// 금성
		EARTH(6371),    // 지구
		MARS(3390),     // 화성
		JUPITER(69911), // 목성
		SATURN(58232),  // 토성
		URANUS(25362),  // 천왕성
		NEPTUNE(24622);  // 해왕성

		private int radius; // 반지름 저장

		// 생성자
		Planet(int radius) {
			this.radius = radius;
		}
		
		public int getRadius() {
			return radius;
		}

		public double getPlanetArea() {
			return 4 * Math.PI * radius * radius;
		}
		
	}
	
	public static void main(String[] args) {
		Planet planet;
		
		for(Planet p : Planet.values()) {
			System.out.println(p.name() + " : " + p.getPlanetArea());
		}
	}
}
