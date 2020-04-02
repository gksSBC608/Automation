package practice.client;

import practice.dao.CourseDaoImpl;
import practice.models.Course;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) {
		System.out.println("Hello World!");
		Course course = new Course();
		course.setCourseName("course1");
		CourseDaoImpl dao = new CourseDaoImpl();
		dao.addCourse(course);
	}
}
