package homework.day13;

public class Room {
	private int roomNum;
	private String roomType;
	private String guest;
	
	public Room(int roomNum, String roomType, String guest) {
		this.roomNum = roomNum;
		this.roomType = roomType;
		this.guest = null;
	}

	public int getRoomNum() {
		return roomNum;
	}

	public void setRoomNum(int roomNum) {
		this.roomNum = roomNum;
	}

	public String getRoomType() {
		return roomType;
	}

	public void setRoomType(String roomType) {
		this.roomType = roomType;
	}

	public String getGuest() {
		return guest;
	}

	public void setGuest(String guest) {
		this.guest = guest;
	}

	
	private String roomTypeSet(int roomNum) {
		if(roomNum >= 201 && roomNum <=209) {
			return "싱글룸";
		} else if(roomNum >= 301 && roomNum <=309) {
			return "더블룸";
		} else if(roomNum >= 401 && roomNum <= 409) {
			return "스위트룸";
		} else return "잘못된 방번호";
	}
	
}
