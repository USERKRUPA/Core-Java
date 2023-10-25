package tester;

import java.time.LocalDate;
import java.util.*;

import com.app.core.Status;
import com.app.core.Task;
import static utils.TaskHandler.*;

public class TaskTester {

	public static void main(String[] args) {
		try (Scanner sc = new Scanner(System.in)) {
			boolean flag = true;
			List<Task> taskList = populateTaskList();
			while (flag) {
				try {
					System.out.println("\n1. Add New Task \n2. Delete a task \n3. Update task status"
							+ "\n4. Display all pending tasks \n5. Display all pending tasks for today"
							+ "\n6. Display all tasks sorted by taskDate \n0. Exit");
					System.out.println("Enter your choice: ");
					switch (sc.nextInt()) {
					case 1:
						System.out.println("Enter name, desc, taskDate");
						Task task = validateTask(sc.next(), sc.nextLine(), sc.next(), taskList);
						taskList.add(task); 
						System.out.println("Task added...");
						break;
					case 2:
						System.out.println("Enter task Name");
						int taskId = searchTask(sc.next(), taskList);
						task = taskList.get(taskId);
						task.setActive(false);
						System.out.println("Task status is set to false...");
						break;
					case 3:
						System.out.println("Enter task Name and task status");
						taskId = searchTask(sc.next(), taskList);
						task = taskList.get(taskId);
						task.setStatus(Status.valueOf(sc.next().toUpperCase()));
						System.out.println("Status of task is " +task.getTaskName()+ " updated to " + task.getStatus());
						break;
					case 4:
						taskList.stream()
						.filter(tsk -> tsk.getStatus().equals(Status.PENDING))
						.forEach(System.out::println);
						break;
					case 5:
						taskList.stream()
						.filter(tsk -> tsk.getTaskDate().equals(LocalDate.now()))
						.filter(tsk -> tsk.getStatus().equals(Status.PENDING))
						.forEach(System.out::println);
						break;
					case 6:
						taskList.stream()
						.sorted((t1, t2) -> t1.getTaskDate().compareTo(t2.getTaskDate()))
						.forEach(System.out::println);
						break;
					case 0:
						flag = false;
						break;
					}
				} catch (Exception e) {
					e.printStackTrace();
					sc.nextLine();
				}
			}
		} // Scanner is autoclosable
	}
}
