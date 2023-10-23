package utils;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;

import com.acts.core.Course;
import com.acts.core.Student;

import custom_exceptions.StudentHandlingException;

public class StudentUtils {
//add a method for parsing string --> Course (enum)
	public static Course parseAndValidateCourse(String course) throws IllegalArgumentException {
		return Course.valueOf(course.toUpperCase());
	}

	// add a method for parsing string --> LocalDate (dob)
	public static LocalDate parseDob(String dob) {
		return LocalDate.parse(dob);
	}

	// add a method for checking for dup student(PRN)
	public static void checkForDup(String prn1, HashMap<String, Student> students1) throws StudentHandlingException {
		if (students1.containsKey(prn1))
			throw new StudentHandlingException("Dup PRN !!!!!");
		System.out.println("no dup....");
	}

	public static ArrayList<Student> populateList() {
//String prn, String firstName, String lastName, int marks, Course enrolledCourse, LocalDate dob
		ArrayList<Student> studentList = new ArrayList<>();
		studentList
				.add(new Student("123", "krupa", "thumar", 100, Course.valueOf("DAC"), LocalDate.parse("1991-05-17")));
		studentList
				.add(new Student("245", "shivani", "tomar", 95, Course.valueOf("DAC"), LocalDate.parse("1994-07-21")));
		studentList.add(
				new Student("567", "shraddha", "tomar", 60, Course.valueOf("DITISS"), LocalDate.parse("1993-07-15")));
		studentList
				.add(new Student("666", "shiv", "tomar", 50, Course.valueOf("DITISS"), LocalDate.parse("1990-07-21")));
		studentList
				.add(new Student("587", "shivali", "tomar", 60, Course.valueOf("DITISS"), LocalDate.parse("1994-06-21")));
		return studentList;

	}

	public static HashMap<String, Student> populateMap() {
		// String prn, String firstName, String lastName, int marks, Course
		// enrolledCourse, LocalDate dob
		HashMap<String, Student> studentList = new HashMap<>();
		studentList.put("123",
				new Student("123", "krupa", "thumar", 100, Course.valueOf("DAC"), LocalDate.parse("1991-05-17")));
		studentList.put("245",
				new Student("245", "shivani", "tomar", 95, Course.valueOf("DAC"), LocalDate.parse("1994-07-21")));
		studentList.put("567",
				new Student("567", "shraddha", "tomar", 60, Course.valueOf("DITISS"), LocalDate.parse("1993-07-15")));
		studentList.put("666",
				new Student("666", "shiv", "tomar", 50, Course.valueOf("DITISS"), LocalDate.parse("1990-07-21")));
		studentList.put("587",
				new Student("587", "shivali", "tomar", 60, Course.valueOf("DITISS"), LocalDate.parse("1994-06-21")));
		return studentList;

	}
}
