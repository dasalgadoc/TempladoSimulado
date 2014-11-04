package control;

import java.util.Stack;
import entity.ClassRoom;
import entity.Course;
import entity.Schedule;

public class CourseMapper {

	public static boolean addCourse(Initialization iniClass, int classRoomCode, int initialDay, int strip, Course course) {
		ClassRoom tempRoom = iniClass.getRoomById(classRoomCode);
		boolean result = false;
		if (tempRoom != null) {
			if (tempRoom.getSchedule().getClassesTime(initialDay - 1, strip - 1).getAssignedCourse() == null && tempRoom.getSchedule().getClassesTime(initialDay + 1, strip - 1).getAssignedCourse() == null) {
				tempRoom.getSchedule().getClassesTime(initialDay - 1, strip - 1).setAssignedCourse(course);
				tempRoom.getSchedule().getClassesTime(initialDay + 1, strip - 1).setAssignedCourse(course);
				result = true;
			} else {
				//System.out.println("ERROR: La Franja ya ha sido asignada");
			}
		} else {
			//System.out.println("ERROR: \t Salón inexistente");
		}
		return result;
	}
	
	public static boolean removeCourse(Initialization iniClass, int classRoomCode, int initialDay, int strip){
		boolean result = false;
		ClassRoom tempRoom = iniClass.getRoomById(classRoomCode);
		if(tempRoom!=null){
			if(tempRoom.getSchedule().getClassesTime(initialDay - 1, strip - 1).getAssignedCourse() !=null && tempRoom.getSchedule().getClassesTime(initialDay + 1, strip - 1).getAssignedCourse() != null){
				assignedCourses.add(tempRoom.getSchedule().getClassesTime(initialDay - 1, strip - 1).getAssignedCourse());
				tempRoom.getSchedule().getClassesTime(initialDay - 1, strip - 1).setAssignedCourse(null);
				tempRoom.getSchedule().getClassesTime(initialDay + 1, strip - 1).setAssignedCourse(null);
			}else{
				//System.out.println("La franja ya está vacia");
			}
		}else{
			//System.out.println("Error: \t Salón inexistente");
		}
		return result;
	}
	
	public static void addRandomCourses(Initialization iniClass) {

		assignedOrders(normalOrder);
		assignedOrders(computerOrder);
		assignedOrders(audithoriumOrder);
		
		int day; 
		int strip;
		int classRoom;
		
		for (int i = 0; i < 24; i++) {
			Course course = new Course();
			course.setCourseType(1);
			course.setCourseCode(iniClass.getCourseByID(normalOrder[i]).getCourseCode());
			course.setName(iniClass.getCourseByID(normalOrder[i]).getName());
			do{
				day = (int) (Math.random() * (3) + 1);
				strip = (int) (Math.random() * (6) + 1);
				classRoom = (int) (Math.random() * (2) + 1);
				if(checkSchedule(iniClass, classRoom)){
					break;
				}
			}while(!addCourse(iniClass,classRoom,day,strip,course));
		}
		for (int i = 0; i < 24; i++) {
			Course course = new Course();
			course.setCourseType(2);
			course.setCourseCode(iniClass.getCourseByID(computerOrder[i] + 30).getCourseCode());
			course.setName(iniClass.getCourseByID(computerOrder[i] + 30).getName());
			do{
				day = (int) (Math.random() * (3) + 1);
				strip = (int) (Math.random() * (6) + 1);
				classRoom = (int) (Math.random() * (2) + 1) + 2;
				if(checkSchedule(iniClass, classRoom)){
					break;
				}
			}while(!addCourse(iniClass,classRoom,day,strip,course));
		}
		for (int i = 0; i < 24; i++) {
			Course course = new Course();
			course.setCourseType(3);
			course.setCourseCode(iniClass.getCourseByID(audithoriumOrder[i] + 60).getCourseCode());
			course.setName(iniClass.getCourseByID(audithoriumOrder[i] + 60).getName());
			do{
				day = (int) (Math.random() * (3) + 1);
				strip = (int) (Math.random() * (6) + 1);
				classRoom= (int) (Math.random() * (2) + 1) + 4;
				if(checkSchedule(iniClass, classRoom)){
					break;
				}
			}while(!addCourse(iniClass,classRoom,day,strip,course));
		}
	}

	public static boolean checkSchedule(Initialization iniClass, int classRoom){
		boolean result = true;
		Schedule tempSchedule = iniClass.getRoomById(classRoom).getSchedule();
		// We need to check only for first 3 days
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 6; j++) {
				if(!tempSchedule.getClassesTime(i, j).isAssigned()){
					if(!tempSchedule.getClassesTime(i + 2, j).isAssigned()){
						result = false;
						break;
					}
				}
			}
		}
		return result;
	}
	
	public static void addRandomSACourses(Initialization iniClass, int courseType, int[] array, Stack <Course> tempCourses, int classRoom){
		int day; 
		int strip;
		
		for (int i = 12; i < 24; i++) {
			Course course;
			if(!tempCourses.isEmpty() && tempCourses.peek().getCourseType()==courseType){
				course = tempCourses.pop();
			}else{
				course = new Course();
				course.setCourseType(courseType);
				course.setCourseCode(iniClass.getCourseByID(array[i]).getCourseCode());
				course.setName(iniClass.getCourseByID(array[i]).getName());
			}
			do{
				day = (int) (Math.random() * (3) + 1);
				strip = (int) (Math.random() * (6) + 1);
				if(checkSchedule(iniClass, classRoom)){
					break;
				}
			}while(!addCourse(iniClass,classRoom,day,strip,course));
		}
	}
	
	
	// Deleting since arrays is not needed
	public static void lauchSA(Initialization iniClass){
		SimulatedAnnealing.simulatedAnneling(iniClass);
	}
	
	public static void assignedOrders(int[] array) {
		int n;
		//Zeros
		for (int i = 0; i < array.length; i++) {
			array[i] = 0;
		}
		for (int i = 0; i < array.length; i++) {
			do {
				n = (int) (Math.random() * (30) + 1);
			} while (repeat(i, n, array));
			array[i] = n;
		}

	}

	public static boolean repeat(int f, int number, int[] array) {
		boolean r = false;
		for (int k = 0; k <= f; k++) {
			if (array[k] == number) {
				r = true;
				break;
			}
		}
		return r;
	}
	
	public static Stack<Course> getAssignedCourses() {
		return assignedCourses;
	}

	public static int[] normalOrder = new int[30];
	public static int[] computerOrder = new int[30];
	public static int[] audithoriumOrder = new int[30];
	
	private static Stack<Course> assignedCourses = new Stack<Course>();
}
