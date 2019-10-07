package student;

import java.util.ArrayList;
import java.util.List;

public class StudentList {
	static List<Student> stuList = null;
	static {
		StudentList sm = new StudentList();
	}

	private StudentList() {
		stuList = new ArrayList<Student>();
		Student s1 = new Student(1001, "aFN", "aLN");
		Student s2 = new Student(1001, "bFN", "bLN");
		Student s3 = new Student(1001, "cFN", "cLN");

		stuList.add(s1);
		stuList.add(s2);
		stuList.add(s3);

		System.out.println("inital students added");
	}

	public static List<Student> getStudentList() {
		return stuList;
	}

	public static void addStudent(Student s) {
		stuList.add(s);
	}

	public static String deleteStudent(Student s1) {
		boolean deleteStatus = false;
		for (Student s : stuList) {
			if (s.getId() == s1.id) {
				stuList.remove(s);
				deleteStatus = true;
				break;
			}
		}
		if (deleteStatus) {
			return "Student deleted";
		} else {
			return "Student not present";
		}
	}

	public static String updateStudent(Student s1) {
		boolean status = false;
		String updateMessage;
		for (Student s : stuList) {
			if (s.getId() == s1.id) {
				status = true;

				s.firstName = s1.firstName;
				s.lastName = s1.lastName;
			}
		}
		if (status) {
			updateMessage = "record updated";
		} else {
			updateMessage = "record not found";
		}
		return updateMessage;
	}
	// delete by id

}
