package com.vsportal.watch_list;

import com.vsportal.task.Task;
import com.vsportal.user.User;

public class WatchList {
	private User user;
	private Task task;
	
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Task getTask() {
		return task;
	}
	public void setTask(Task task) {
		this.task = task;
	}
}
