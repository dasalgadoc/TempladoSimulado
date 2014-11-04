package control;

import entity.ClassRoom;
import entity.Course;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// Initialize default courses, classrooms and its 'blank' schedules 
		iniClass.iniCourseProccess();
		iniClass.iniClassRoomProcess();
		
		CourseMapper.addRandomCourses(iniClass);
		
		printClassRooms();
		printDeepClassRoom();
		printSheduleSummary();
	}
	
	public static void printCourses(){
		System.out.println("Código / Nombre Materia" );
		for (Course course : iniClass.getCourses()) {
			System.out.println(course.getCourseCode() + " " + course.getName());
		}
		System.out.println();
	}
	
	public static void printClassRooms() {
		System.out.println("Código / Tipo Salón");
		for (ClassRoom classRoom : iniClass.getRooms()) {
			System.out.println("Código Salón: " + classRoom.getClassRoomCode() + " Tipo de Salón: "  + classRoom.getClassRoomType());
			System.out.println(classRoom.getSchedule().toString());
		}
		System.out.println();
	}
	
	public static void printDeepClassRoom(){
		System.out.println("Código / Tipo Salón");
		for (ClassRoom classRoom : iniClass.getRooms()) {
			System.out.println("Código Salón: " + classRoom.getClassRoomCode() + " Tipo de Salón: "  + classRoom.getClassRoomType());
			System.out.println(classRoom.getSchedule().deepToString());
		}
	}
	
	public static void printSheduleSummary(){
		int[] assignedCourses = new int[6];
		assignedCourses[0] = iniClass.getRooms().get(0).getSchedule().getAssignedCourses();
		assignedCourses[1] = iniClass.getRooms().get(1).getSchedule().getAssignedCourses();
		assignedCourses[2] = iniClass.getRooms().get(2).getSchedule().getAssignedCourses();
		assignedCourses[3] = iniClass.getRooms().get(3).getSchedule().getAssignedCourses();
		assignedCourses[4] = iniClass.getRooms().get(4).getSchedule().getAssignedCourses();
		assignedCourses[5] = iniClass.getRooms().get(5).getSchedule().getAssignedCourses();
		for (int i = 0; i < assignedCourses.length; i++) {
			System.out.println("Salón:\t" + (i + 1) + "\tCursos Asignados:\t" + assignedCourses[i]);
		}
		askForSA(assignedCourses);
	}
	
	private static void askForSA(int[] assignedCourses){
		for (int i = 0; i < assignedCourses.length; i++) {
			if(assignedCourses[i]<12){
				System.out.println("El salón: " + (i+1) + " NO presenta un valor óptimo");
			}
		}
		System.out.println("¿Desea aplicar Templado Simulado para reorganizar el esquema? (S/N): ");
		scanner = new Scanner(System.in);
		String answer = scanner.nextLine().toUpperCase();
		if(answer.substring(0,1).equals("S")){
			SimulatedAnnealing.simulatedAnneling(iniClass);
		}
	}
	
	private static Initialization iniClass = new Initialization();
	private static Scanner scanner;
}
