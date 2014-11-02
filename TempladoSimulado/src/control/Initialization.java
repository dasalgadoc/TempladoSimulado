package control;

import java.util.ArrayList;

import entity.ClassRoom;
import entity.Course;
import entity.Schedule;

public class Initialization {

	public void iniCourseProccess() {
		for (int i = 1; i <= 30; i++) {
			Course course = new Course();
			course.setCourseType(1);
			course.setCourseCode(100 + i);
			course.setName(normalCourse[i - 1]);
			courses.add(course);
		}
		for (int i = 1; i <= 30; i++) {
			Course course = new Course();
			course.setCourseType(2);
			course.setCourseCode(200 + i);
			course.setName(computerCourse[i - 1]);
			courses.add(course);
		}
		for (int i = 1; i <= 30; i++) {
			Course course = new Course();
			course.setCourseType(3);
			course.setCourseCode(300 + i);
			course.setName(auditoriumCourse[i - 1]);
			courses.add(course);
		}
	}

	public void iniClassRoomProcess(){
		for (int i = 1; i <= 2; i++) {
			ClassRoom classRoom = new ClassRoom();
			Schedule schedule = new Schedule();
			classRoom.setClassRoomCode(i);
			classRoom.setClassRoomType(1);
			classRoom.setSchedule(schedule);
			rooms.add(classRoom);
		}
		for (int i = 3; i <= 4; i++) {
			ClassRoom classRoom = new ClassRoom();
			Schedule schedule = new Schedule();
			classRoom.setClassRoomCode(i);
			classRoom.setClassRoomType(2);
			classRoom.setSchedule(schedule);
			rooms.add(classRoom);
		}
		for (int i = 5; i <= 6; i++) {
			ClassRoom classRoom = new ClassRoom();
			Schedule schedule = new Schedule();
			classRoom.setClassRoomCode(i);
			classRoom.setClassRoomType(3);
			classRoom.setSchedule(schedule);
			rooms.add(classRoom);
		}
	}
	
	public ArrayList<Course> getCourses() {
		return courses;
	}
	
	public Course getCourseByID(int id){
		return courses.get(id-1);
	}

	public void setCourses(ArrayList<Course> courses) {
		this.courses = courses;
	}

	public ArrayList<ClassRoom> getRooms() {
		return rooms;
	}
	
	public ClassRoom getRoomById(int id){
		return rooms.get(id-1);
	}

	public void setRooms(ArrayList<ClassRoom> rooms) {
		this.rooms = rooms;
	}

	private ArrayList<Course> courses = new ArrayList<Course>();
	private ArrayList<ClassRoom> rooms = new ArrayList<ClassRoom>();

	private String[] normalCourse = { "Ingl�s", "Gerencia de Proyectos",
			"�lgebra Lineal", "C�lculo Diferencial", "C�lculo Integral",
			"C�lculo Multivarible", "Ecuaciones Diferenciales",
			"Ingenier�a Econ�mica", "Variable Compleja",
			"Matem�ticas Discretas", "Probabilidad y Estad�stica",
			"Sistemas inteligentes", "Modelos estoc�sticos", "Optimizaci�n",
			"Pensamiento sist�mico", "Se�ales y sistemas", "Alem�n", "Chino",
			"Coreano", "Turco", "Estad�stica descriptiva", "Franc�s",
			"Geometr�a Elemental", "Griego", "Italiano", "L�gica matem�tica",
			"Portugu�s", "Ruso", "Inferencia Estad�stica", "Finanzas" };

	private String[] computerCourse = { "Teor�a de la Computaci�n",
			"M�todos Num�ricos", "Algoritmos", "Arquitectura de Computadores",
			"Arquitectura de Software", "Bases de datos",
			"Computaci�n paralela", "Computaci�n Visual",
			"Elementos de computadores", "Ingenier�a de Software",
			"Criptograf�a", "Lenguajes de programaci�n",
			"Modelos y Simulaci�n", "Programaci�n de computadores",
			"Programaci�n orientada objetos", "Redes de computadores",
			"Sistemas operativos", "Administraci�n de redes",
			"Aprendizaje de m�quina", "Computaci�n Evolutiva",
			"Desarrollo de aplicaciones web", "Desarrollo de videojuegos",
			"Proyectos de Software", "Internet Palazzo", "Mundos virtuales",
			"Pruebas de Software", "Autocad", "Desarrollo en Arduino",
			"Patrones de Dise�o", "Rob�tica" };

	private String[] auditoriumCourse = { "Matem�ticas B�sicas",
			"F�sica Mec�nica", "Electricidad y Magnetismo",
			"Introducci�n Ingenier�a sistemas", "Taller de proyectos",
			"Astronom�a para todos", "Biolog�a general", "C�tedra �ngel Maya",
			"C�tedra de comercio", "C�tedra de derecho",
			"C�tedra de ingenio y ciencia",
			"C�tedra de divulgaci�n cient�fica", "C�tedra de Matem�ticas",
			"Seminario de Bioseguridad", "Control y gesti�n de calidad",
			"Coro universitario", "Cu�ntica para todos",
			"Desarrollo de la ingenier�a", "Fundamentos de matem�ticas",
			"Jueves del Egresado", "Desarrollo sostenible",
			"Estudios feministas", "Taller de creatividad", "Nanotecnolog�a",
			"C�tedra de Software Libre", "F�sica Moderna",
			"Fundamentos de oscilaciones", "Principios de Qu�mica",
			"Introducci�n ingenier�a qu�mica", "Congreso de Log�stica" };
}
