import com.vwits.db.QuestionDAO;
import com.vwits.db.ResultsDAO;
import com.vwits.db.StudentDAO;
import com.vwits.db.TeacherDAO;
import com.vwits.model.Question;
import com.vwits.model.Results;
import com.vwits.model.Student;
import com.vwits.model.Teacher;

public class Demo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		QuestionDAO s = new QuestionDAO();
		Question r1 = new Question("Which of the following option leads to the portability and security of Java?", "Bytecode is executed by JVM", "The applet makes the Java code secure and portable", "Use of exception handling", "Dynamic binding between objects", "Bytecode is executed by JVM");
		Question r2 = new Question("Which of the following is not a Java features?", "Dynamic", "Architecture Neutral", "Use of pointers", "Object-oriented", "Use of pointers");
		Question r3 = new Question("The \\u0021 article referred to as a", "Unicode escape sequence", "Octal escape", "Hexadecimal", "Line feed", "Unicode escape sequence");
		Question r4 = new Question("_____ is used to find and fix bugs in the Java programs.", "JVM", "JRE", "JDK", "JDB", "JDB");
		
		s.insertQuestion(r1);
		s.insertQuestion(r2);
		s.insertQuestion(r3);
		s.insertQuestion(r4);
		
		
	}

}
