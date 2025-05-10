package com.khadri.spring.employee.config.query.constants;

public enum Queries {

	FIND_BY_ID("SELECT * FROM employee WHERE id=?"), 
	FIND_BY_NAME("SELECT * FROM employee WHERE name LIKE ?"),
	FIND_BY_SALARY("SELECT * FROM employee WHERE salary=?"),
	INSERT("INSERT INTO employee (name, salary) VALUES (?, ?)"),
   UPDATE("UPDATE employee SET name = ?, salary = ? WHERE id = ?"),
	DELETE("DELETE FROM employee WHERE id=?");

	private String query;

	private Queries(String query) {
		this.query = query;
	}

	public String getQuery() {
		return query;
	}
}
