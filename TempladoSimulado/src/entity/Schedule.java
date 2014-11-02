package entity;

public class Schedule {

	public Schedule(){
		assignClassTime();
	}
	
	public void assignClassTime(){
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 6; j++) {
				ClassTime classTime = new ClassTime();
				classTime.setAssigned(false);
				classTime.setDay(i+1);
				classTime.setStrip(j+1);
				classesTime[i][j] = classTime;
			}
		}
	}
	
	public ClassTime getClassesTime(int day, int strip) {
		return classesTime[day][strip];
	}

	public void setClassTime(ClassTime classTime, int day, int strip) {
		this.classesTime[day][strip] = classTime;
	}
	
	public int getAssignedCourses(){
		int assignedCourses = 0;
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 6; j++) {
				if(classesTime[i][j].isAssigned()){
					assignedCourses++;
				}
			}
		}
		return assignedCourses/2;
	}

	@Override
	public String toString() {
		String result = "";
		for (int i = 0; i < 5; i++) {
			result = result.concat("Día: " + classesTime[i][0].getDay() + "   ");
			for (int j = 0; j < 6; j++) {
				result = result.concat("| Franja: " + classesTime[i][j].getStrip() + " ¿Asignado?: " + classesTime[i][j].isAssigned() + " |   ");
			}
			result = result.concat(separator);
		}
		return result;
	}
	
	public String deepToString(){
		String result= "";
		for (int i = 0; i < 5; i++) {
			result = result.concat("Día: " + classesTime[i][0].getDay() + "   ");
			for (int j = 0; j < 6; j++) {
				if(!(classesTime[i][j].getAssignedCourse() == null)){
					result = result.concat("| Franja: " + classesTime[i][j].getStrip() + " Asignado a: " + classesTime[i][j].getAssignedCourse().toString() + " |   ");
				}else{
					result = result.concat("| Franja: " + classesTime[i][j].getStrip() + " NO ASIGNADO |   ");
				}
			}
			result = result.concat(separator);
		}
		return result;
	}

	private ClassTime[][] classesTime = new ClassTime[5][6];
	private String separator = System.getProperty("line.separator");
}

