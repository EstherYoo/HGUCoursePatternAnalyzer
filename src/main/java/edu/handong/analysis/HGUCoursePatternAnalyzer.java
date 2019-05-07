package edu.handong.analysis;

import edu.handong.analysis.datamodel.Course;
import edu.handong.analysis.datamodel.Student;

public class HGUCoursePatternAnalyzer {
	
	String[] lines = {	"1999-1, JC Nam, Java Programming",
						"1999-2, JC Nam, Programming Language Theory",
						"1999-1, JC Nam, Data Structures",
						"2001-1, JC Nam, Database Systems",
						"2018-1, SB Lim, Java Programming",
						"2018-2, SB Lim, Programming Language Theory",
						"2019-1, SB Lim, Data Structures",
						"2019-1, SB Lim, Algorithm Analysis",
						"2018-1, SJ Kim, Java Programming",
						"2018-2, SJ Kim, Programming Language Theory",
						"2019-1, SJ Kim, Logic Design",
						"2019-1, SJ Kim, Algorithm Analysis",
						};

	private int numOfStudents;
	private int numOfCourses;
	private Student[] students;
	private Course[] courses;
	
	/**
	 * This method runs our analysis logic to get the list of student and course names from lines.
	 * @param args
	 */
	public void run(String[] args) {
		
		numOfStudents = Integer.parseInt(args[0]);
		numOfCourses = Integer.parseInt(args[1]);
			
		students = initiateStudentArrayFromLines(lines);
		
		System.out.println("Number of All Students: " + numOfStudents);
		for(Student student: students) {
			System.out.println(student.getName());
		}
		
		courses = initiateCourseArrayFromLines(lines);
		System.out.println("Number of All Courses: " + numOfCourses);
		for(Course course: courses) {
			System.out.println(course.getCourseName());
		}
		
	}

	/**
	 * This method returns a Student array to initiate the field, students, from lines.
	 * @param lines
	 * @return
	 */
	private Student[] initiateStudentArrayFromLines(String[] lines) {
		int numberOfStudent=0;
		Student[] individualName = new Student[numOfStudents];	
		for(int i = 0; i<lines.length; i++) {
			Student name = new Student(lines[i].split(", ")[1]);
			if (studentExist(individualName, name)) {
				continue;
			}
			individualName[numberOfStudent] = name;
			System.out.println(individualName[numberOfStudent].getName());
			numberOfStudent++;
		}
		return individualName;
	}

	/**
	 * This method check if there is the same name of the second arugement in the array, students
	 * @param students
	 * @param student
	 * @return boolean
	 */
	private boolean studentExist(Student[] students, Student student) {
		if(students[0] == null)
			return false;
		for(int i = 0; i<students.length; i++) {
			if(students[i] == null)
				return false;
			if(students[i].getName().contentEquals(student.getName())) {
				return true;
			}
		}
		return false;
	}
	
	/**
	 * This method returns a Course array to initiate the field, courses, from lines.
	 * @param lines
	 * @return
	 */
	private Course[] initiateCourseArrayFromLines(String[] lines) {
		int numberOfCourse = 0;
		Course[] eachCourseName = new Course[numOfCourses];
		for(int i=0; i<lines.length; i++) {
			Course name = new Course(lines[i].split(", ")[2]);
			if (courseExist(eachCourseName, name))
				continue;
			eachCourseName[numberOfCourse] = name;
			numberOfCourse++;
		}
		return eachCourseName;
	}

	/**
	 * This method check if there is the same name of the second argument in the array, courses.
	 * @param courses
	 * @param course
	 * @return boolean
	 */
	private boolean courseExist(Course[] courses, Course course) {
		if(courses[0] == null)
			return false;
		for(int i = 0; i<courses.length; i++) {
			if(courses[i] == null)
				return false;
			if(courses[i].getCourseName().contentEquals(course.getCourseName())) {
				return true;
			}
		}
	return false;
}
	

}
