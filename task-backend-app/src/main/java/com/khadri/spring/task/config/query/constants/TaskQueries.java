package com.khadri.spring.task.config.query.constants;

public enum TaskQueries {

	FIND_BY_ID("SELECT * FROM task WHERE id=?"), 
	FIND_BY_PRIORITY("SELECT * FROM task WHERE priority LIKE ?"),
	FIND_BY_STATUS("SELECT * FROM task WHERE status LIKE ?"),
	FIND_BY_COST("SELECT * FROM task WHERE cost = ?"),
	INSERT("INSERT INTO task (priority, status, cost) VALUES (?, ?, ?)"),
	UPDATE("UPDATE task SET priority=?, status=?, cost=? WHERE id=?"),
	DELETE("DELETE FROM task WHERE id=?");

	private String query;

	private TaskQueries(String query) {
		this.query = query;
	}

	public String getQuery() {
		return query;
	}
}
