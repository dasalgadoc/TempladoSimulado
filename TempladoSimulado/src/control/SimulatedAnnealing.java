package control;

import java.util.ArrayList;
import java.util.Stack;

import entity.Course;
import entity.ClassRoom;

public class SimulatedAnnealing {
	
	public static void simulatedAnneling(Initialization iniClass){
		// We have a initial Solution since CourseMapper generate a Random no-optimal solution for iniClass let this be xNow = X0 
		// Setting initial Control Parameter with optimal Ones.
		int ti = 0;
		for (int i = 0; i < 6; i++) {
			xNowAssignedCourses[i] = iniClass.getRooms().get(i).getSchedule().getAssignedCourses();
			if(xNowAssignedCourses[i]<12){
				removeAllCourses(iniClass, (i+1));
				ti += 0;
			}else{
				ti += 12;
			}
		}
		// Repeat until stopping criterion
		int count = 0;
		do{
			// An arbitrary "Temperature Length"
			count ++;
			if(count == 10){
				break;
			}
			// Generate randomly a solution
			// Computing Change of cost
			// And Select
			Stack<Course> tempCourses = (Stack<Course>) CourseMapper.getAssignedCourses().clone();
			
			for (int i = 5; i >= 4; i--) {
				if(xNowAssignedCourses[i]<12){
					CourseMapper.addRandomSACourses(iniClass, 3, CourseMapper.audithoriumOrder, tempCourses, i +1);
					roomsSA.add(iniClass.getRoomById(i+1));
				}
			}
			for (int i = 3; i >= 2; i--) {
				if(xNowAssignedCourses[i]<12){
					CourseMapper.addRandomSACourses(iniClass, 2, CourseMapper.computerOrder, tempCourses, i + 1);
					roomsSA.add(iniClass.getRoomById(i+1));
				}
			}
			for (int i = 1; i >= 0; i--) {
				if(xNowAssignedCourses[i]<12){
					CourseMapper.addRandomSACourses(iniClass, 1, CourseMapper.normalOrder, tempCourses, i + 1);
					roomsSA.add(iniClass.getRoomById(i+1));
				}
			}
		}while(ti < 72);
		
		Main.printClassRooms();
		Main.printDeepClassRoom();
		Main.printSheduleSummary();
		//System.out.println("Cursos Eliminados: ");
		//for (Course course : CourseMapper.getAssignedCourses()) {
		//	System.out.println(course.toString());
		//}
	}
	
	public static void removeAllCourses(Initialization iniClass, int classRoomCode){
		for (int i = 1; i <= 3; i++) {
			for (int j = 1; j <= 6 ; j++) {
				CourseMapper.removeCourse(iniClass, classRoomCode, i, j);
			}
		}
	}
	
	private static int[] xNowAssignedCourses = new int[6];
	private static ArrayList<ClassRoom> roomsSA = new ArrayList<ClassRoom>();
}
