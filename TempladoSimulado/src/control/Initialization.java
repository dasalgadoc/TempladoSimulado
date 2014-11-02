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

	private String[] normalCourse = { "Inglés", "Gerencia de Proyectos",
			"Álgebra Lineal", "Cálculo Diferencial", "Cálculo Integral",
			"Cálculo Multivarible", "Ecuaciones Diferenciales",
			"Ingeniería Económica", "Variable Compleja",
			"Matemáticas Discretas", "Probabilidad y Estadística",
			"Sistemas inteligentes", "Modelos estocásticos", "Optimización",
			"Pensamiento sistémico", "Señales y sistemas", "Alemán", "Chino",
			"Coreano", "Turco", "Estadística descriptiva", "Francés",
			"Geometría Elemental", "Griego", "Italiano", "Lógica matemática",
			"Portugués", "Ruso", "Inferencia Estadística", "Finanzas" };

	private String[] computerCourse = { "Teoría de la Computación",
			"Métodos Numéricos", "Algoritmos", "Arquitectura de Computadores",
			"Arquitectura de Software", "Bases de datos",
			"Computación paralela", "Computación Visual",
			"Elementos de computadores", "Ingeniería de Software",
			"Criptografía", "Lenguajes de programación",
			"Modelos y Simulación", "Programación de computadores",
			"Programación orientada objetos", "Redes de computadores",
			"Sistemas operativos", "Administración de redes",
			"Aprendizaje de máquina", "Computación Evolutiva",
			"Desarrollo de aplicaciones web", "Desarrollo de videojuegos",
			"Proyectos de Software", "Internet Palazzo", "Mundos virtuales",
			"Pruebas de Software", "Autocad", "Desarrollo en Arduino",
			"Patrones de Diseño", "Robótica" };

	private String[] auditoriumCourse = { "Matemáticas Básicas",
			"Física Mecánica", "Electricidad y Magnetismo",
			"Introducción Ingeniería sistemas", "Taller de proyectos",
			"Astronomía para todos", "Biología general", "Cátedra Ángel Maya",
			"Cátedra de comercio", "Cátedra de derecho",
			"Cátedra de ingenio y ciencia",
			"Cátedra de divulgación científica", "Cátedra de Matemáticas",
			"Seminario de Bioseguridad", "Control y gestión de calidad",
			"Coro universitario", "Cuántica para todos",
			"Desarrollo de la ingeniería", "Fundamentos de matemáticas",
			"Jueves del Egresado", "Desarrollo sostenible",
			"Estudios feministas", "Taller de creatividad", "Nanotecnología",
			"Cátedra de Software Libre", "Física Moderna",
			"Fundamentos de oscilaciones", "Principios de Química",
			"Introducción ingeniería química", "Congreso de Logística" };
}
