package com.app.core;

import java.time.LocalDate;
import java.util.Objects;

public class Task {
	/*
	 *  Deleted task will have active=false 
	 */
	private int taskId;
	private String taskName;
	private String desc;
	private LocalDate taskDate;
	private Status status;
	private boolean active;
	private static int idGenerator;
	static {
		idGenerator = 0;
	}
	
	public Task(String taskName, String desc, LocalDate taskDate) {
		super();
		this.taskId = ++idGenerator;
		this.taskName = taskName;
		this.desc = desc;
		this.taskDate = taskDate;
		this.status = Status.PENDING;
		this.active = true;
	}

	public Task(String taskName) {
		this.taskName = taskName;
	}

	@Override
	public String toString() {
		return "Task [taskId=" + taskId + ", taskName=" + taskName + ", desc=" + desc + ", taskDate=" + taskDate
				+ ", status=" + status + ", active=" + active + "]";
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!(obj instanceof Task))
			return false;
		Task other = (Task) obj;
		return Objects.equals(taskName, other.taskName);
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public String getTaskName() {
		return taskName;
	}

	public void setTaskName(String taskName) {
		this.taskName = taskName;
	}

	public LocalDate getTaskDate() {
		return taskDate;
	}

	public void setTaskDate(LocalDate taskDate) {
		this.taskDate = taskDate;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}
	
}
