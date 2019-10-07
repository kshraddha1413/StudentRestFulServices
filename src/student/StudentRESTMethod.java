package student;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import student.Message;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;

@Path("/student")
public class StudentRESTMethod {

	Message result;

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("list")
	public List<Student> getEmployeeList() {
		return StudentList.stuList;
	}

	@POST
	@Path("add")
	@Consumes({ MediaType.APPLICATION_JSON })
	@Produces({ MediaType.APPLICATION_JSON })
	public Message createStudent(Student s) {

		StudentList.addStudent(s);

		result = new Message();
		result.message = "Student Added --";
		System.out.println(result.message);
		return result;// sending object of ResultOk class
		// massage class(Result Ok need geeter method)
		// In Post methods can accepts and send only
		// json and objects if string or anything else send it is taken as raw
	}

	@DELETE
	@Path("delete")
	@Consumes({ MediaType.APPLICATION_JSON })
	@Produces({ MediaType.APPLICATION_JSON })
	public Message deleteStudentbyId(Student s) {
		String str = StudentList.deleteStudent(s);
		result = new Message(str);
		System.out.println(result.getMessage());
		return result;
	}

	@PUT
	@Path("update")
	@Consumes({ MediaType.APPLICATION_JSON })
	@Produces({ MediaType.APPLICATION_JSON })
	public Message updateStudentRecord(Student s) {
		String str=StudentList.updateStudent(s);
		result=new Message(str);
		System.out.println(result.getMessage());
		return result;
	}
}
