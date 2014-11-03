package entity;

public class Course {

	public Course() {

	}

	public Course(String name, int courseType, int courseCode) {
		setName(name);
		setCourseType(courseType);
		setCourseCode(courseCode);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getCourseType() {
		return courseType;
	}

	public void setCourseType(int courseType) {
		this.courseType = courseType;
	}

	public int getCourseCode() {
		return courseCode;
	}

	public void setCourseCode(int courseCode) {
		this.courseCode = courseCode;
	}

	@Override
	public String toString() {
		//return "Curso [Código=" + courseCode + ", Nombre=" + name + "]";
		return "Curso [Código=" + courseCode + "]";
	}

	private String name;
	private int courseType;
	private int courseCode;
}
