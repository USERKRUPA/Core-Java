package tester;

import static utils.StudentUtils.*;
import java.util.List;
import java.util.Map;
import java.util.OptionalDouble;
import java.util.Scanner;

import com.acts.core.Course;
import com.acts.core.Student;

public class TestStudent {

	public static void main(String[] args) {
		try (Scanner sc = new Scanner(System.in)) {
			List<Student> stdList = populateList();
			Map<String, Student> stdMap = populateMap();
			
			stdList.stream()
			.forEach(std -> System.out.println(std));
			
			System.out.println("=====================");
			stdMap.forEach((prn,std) -> System.out.println(std));
			
			System.out.println("=====================");
			stdList.stream()
			.sorted()
			.forEach(std -> System.out.println(std));
			
			System.out.println("=========Sorted Map============");
			stdMap.values()
			.stream()
			.sorted()
			.forEach(std -> System.out.println(std));
			
			System.out.println("=========Sorted Based on GPA============");
			
			stdList.stream()
			.sorted((s1, s2) -> ((Integer)s1.getMarks()).compareTo(s2.getMarks()))
			.forEach(s -> System.out.println(s));
			
			System.out.println("Average is: ");
			Course course1 = Course.valueOf("DAC");
			double avg = stdList.stream()
			.filter(s -> s.getEnrolledCourse().equals(course1))
			.mapToInt(s -> s.getMarks())
			.average()
			.orElseThrow();
			
			System.out.println(avg);
			
			System.out.println("Toppers: ");
			Course course2 = Course.valueOf("DAC");
			Student s = stdList.stream()
			.filter(st -> st.getEnrolledCourse().equals(course2) )
			.max((s1, s2) -> (((Integer)s1.getMarks()).compareTo(s2.getMarks())))
			.orElseThrow();
			System.out.println(s.getFirstName() + " " + s.getLastName());
			
			System.out.println("No of failed students: ");
			Course course3 = Course.valueOf("DITISS");
			long count = stdList.stream()
			.filter(st -> st.getEnrolledCourse().equals(course3))
			.filter(st -> st.getMarks() < 70)
			.count();
			
			System.out.println(count);
			
			System.out.println("Map Tasks===================");
			System.out.println("Average is: ");
			Course course4 = Course.valueOf("DAC");
			avg = stdMap.values()
			.stream()
			.filter(st -> st.getEnrolledCourse().equals(course4))
			.mapToInt(st -> st.getMarks())
			.average()
			.orElseThrow();
			System.out.println(avg);
			
			System.out.println("No of failed students: ");
			Course course5 = Course.valueOf("DITISS");
			count = stdMap.values().stream()
			.filter(st -> st.getEnrolledCourse().equals(course5))
			.filter(st -> st.getMarks() < 70)
			.count();
			System.out.println(count);
			
		}
		
	}
}
