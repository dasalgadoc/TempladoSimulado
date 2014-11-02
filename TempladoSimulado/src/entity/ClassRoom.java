package entity;

public class ClassRoom {

	public ClassRoom() {
	}

	public ClassRoom(int classRoomCode, int classRoomType, Schedule schedule) {
		setClassRoomCode(classRoomCode);
		setClassRoomType(classRoomType);
		setSchedule(schedule);
	}

	public Schedule getSchedule() {
		return schedule;
	}

	public void setSchedule(Schedule schedule) {
		this.schedule = schedule;
	}

	public int getClassRoomCode() {
		return classRoomCode;
	}

	public void setClassRoomCode(int classRoomCode) {
		this.classRoomCode = classRoomCode;
	}

	public int getClassRoomType() {
		return classRoomType;
	}

	public void setClassRoomType(int classRoomType) {
		this.classRoomType = classRoomType;
	}
	
	@Override
	public String toString() {
		return "Salón [Código=" + classRoomCode + ", Tipo="
				+ classRoomType + "]";
	}



	private int classRoomCode;
	private int classRoomType;
	private Schedule schedule;
}
