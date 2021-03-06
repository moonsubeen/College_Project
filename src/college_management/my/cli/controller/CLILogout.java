package college_management.my.cli.controller;

import college_management.my.auth.UserAuth;

import picocli.CommandLine.Command;
import picocli.CommandLine.ParentCommand;

@Command(name = "logout")
public class CLILogout implements Runnable {
	@ParentCommand
	CliCommands parent;

	public void run() {
		UserAuth auth = UserAuth.getInstance();

		// 로그인 확인
		if (!auth.isLogin()) {
			parent.out.println("it's need to login");
			return;
		}

		// 로그아웃
		if (auth.logout()) {
			parent.out.println("logout success");
		} else {
			parent.out.println("logout fail");
		}
	}
}