package utils;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.*;

import com.app.core.Task;

import exception_handling.TaskHandlingExecption;

public interface TaskHandler {
	static Vector<Task> populateTaskList(){
		Vector<Task> taskList = new Vector<>();
		taskList.add(new Task("rent", "pay rent 2000 for house", LocalDate.parse("2023-09-27")));
		taskList.add(new Task("bill", "pay gas bill of 1000rs", LocalDate.parse("2023-09-28")));
		taskList.add(new Task("repair" ,"repair laptop charger", LocalDate.parse("2023-10-27")));
		taskList.add(new Task("gardening", "remove unwanted plants", LocalDate.parse("2023-10-24")));
		taskList.add(new Task("cleanliness","clean room and washroom", LocalDate.parse("2023-10-24")));
		return taskList;
	}
	
	static Task validateTask(String taskName, String desc, String date, List<Task> taskList) throws TaskHandlingExecption {
		LocalDate parsedDate = parseDate(date);
		chkDupTask(taskName, taskList);
		return new Task(taskName, desc, parsedDate);
	}
	static void chkDupTask(String taskName, List<Task> taskList) throws TaskHandlingExecption {
		Task task = new Task(taskName);
		if(taskList.contains(task)) {
			throw new TaskHandlingExecption("Duplicate entry for task found...");
		}
		System.out.println("No duplicate entry");
	}
	static LocalDate parseDate(String date) throws DateTimeParseException{
		return LocalDate.parse(date);
	}
	
	static int searchTask(String taskName, List<Task> taskList) throws TaskHandlingExecption {
		Task task = new Task(taskName);
		int taskId = taskList.indexOf(task);
		if(taskId == -1)
			throw new TaskHandlingExecption("No such task exists...");
		return taskId;		
	}
}
