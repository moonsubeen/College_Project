package college_management.my.cli;

import college_management.my.api.EmployeeAPI;
import picocli.CommandLine;
import picocli.CommandLine.Command;
import picocli.CommandLine.Option;
import picocli.CommandLine.Parameters;
import picocli.CommandLine.ParentCommand;

/**
 * A command with some options to demonstrate completion.
 */
@Command(name = "register", 
	mixinStandardHelpOptions = true, 
	version = "1.0", 
	description = "Command with some options to demonstrate TAB-completion (note that enum values also get completed)", 
	subcommands = CommandLine.HelpCommand.class)

public class CLIRegister implements Runnable  {
	@Parameters(paramLabel = "Role", description = "The role")
    private String role;

	@Option(names = { "-n", "--name" }, description = "The student name", required = true)
	private String name = "";
	
	@Option(names = { "-i", "--id" }, description = "The student ID", required = true)
	private String id = "";
	
//	@Option(names = { "-p", "--pwd" }, description = "The phone number", required = true)
//	private String pwd = "";
	
	@Option(names = { "-e", "--email" }, description = "The email", required = false)
	private String email = "";
	
	@Option(names = { "-na", "--nationality" }, description = "The nationality", required = false)
	private String nationality = "";
	
	@Option(names = { "-p", "--phone" }, description = "The phone number", required = false)
	private String phone = "";
	
	@Option(names = { "-a", "--address" }, description = "The address", required = false)
	private String address = "";
	
	@Option(names = { "-r", "--residentNumber" }, description = "The residentNumber", required = false)
	private String residentNumber= "";
	
	@Option(names = { "-b", "--birthdate" }, description = "The birthdate", required = false)
	private String birthdate= "";
	
	@Option(names = { "-s", "--sex" }, description = "The sex", required = false)
	private String sex= "";
	
	@ParentCommand
	CliCommands parent;

	public void run() {
		switch(role) {
		case "student":
			EmployeeAPI api = new EmployeeAPI();
			boolean result = api.studentInfo(id, name, email, nationality, phone, address, residentNumber, birthdate, sex);
			if(result) 
				parent.out.println("register success");
			else
				parent.out.println("register fail");
			break;
		case "professor":
			break;
		case "employee":
			break;
		default:
			parent.out.printf("'%s' is not supprt\n", role);
			break;
		}
	}
}