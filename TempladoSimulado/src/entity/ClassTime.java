package entity;

public class ClassTime {

	public ClassTime() {

	}

	public ClassTime(int day, int strip, boolean asssigned,
			Course assignedCourse) {
		setDay(day);
		setStrip(strip);
		setAssigned(asssigned);
		setAssignedCourse(assignedCourse);
	}

	public int getDay() {
		return day;
	}

	public void setDay(int day) {
		this.day = day;
	}

	public int getStrip() {
		return strip;
	}

	public void setStrip(int strip) {
		this.strip = strip;
	}

	public boolean isAssigned() {
		return assigned;
	}

	public void setAssigned(boolean assigned) {
		this.assigned = assigned;
	}

	public Course getAssignedCourse() {
		return assignedCourse;
	}

	public void setAssignedCourse(Course assinedCourse) {
		this.assignedCourse = assinedCourse;
		if (assinedCourse == null) {
			setAssigned(false);
		} else {
			setAssigned(true);
		}
	}

	@Override
	public String toString() {
		return "Franja [Día=" + day + ", Franja=" + strip + ", ¿Asignado?="
				+ assigned + ", Asignado a=" + assignedCourse + "]";
	}



	private int day;
	private int strip;
	private boolean assigned;
	private Course assignedCourse;
}
