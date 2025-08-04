package homework.day13;

public class Room {
	private String roomNum;
	//private String roomType;
	private String guest;
	
	public Room(String roomNum, String guest) {
		this.roomNum = roomNum;
		//this.roomType = roomTypeSet(roomNum);
		this.guest = guest;
	}

	public String getRoomNum() {
		return roomNum;
	}

	public void setRoomNum(String roomNum) {
		this.roomNum = roomNum;
	}

	/*public String getRoomType() {
		return roomType;
	}

	public void setRoomType(String roomType) {
		this.roomType = roomType;
	}*/

	public String getGuest() {
		return guest;
	}

	public void setGuest(String guest) {
		this.guest = guest;
	}

	@Override
	public String toString() {
		return "Room [roomNum=" + roomNum + ", guest=" + guest + "]";
	}

	
	
	/*private String roomTypeSet(String roomNum) {
		
		int num = Integer.parseInt(roomNum);
		
		if(num >= 201 && num <=209) {
			return "싱글룸";
		} else if(num >= 301 && num <=309) {
			return "더블룸";
		} else if(num >= 401 && num <= 409) {
			return "스위트룸";
		} else return "잘못된 룸넘버";
	}*/
	
}
