package com.khadri.spring.student.config.query.constants;

public enum Queries {

	FIND_BY_ID("SELECT * FROM students WHERE id=?"), FIND_BY_NAME("SELECT * FROM students WHERE name LIKE ?"),
	FIND_BY_COURSE("SELECT * FROM students WHERE course LIKE ?"),
	FIND_BY_MARKS("SELECT * FROM students WHERE marks = ?"),
	INSERT("INSERT INTO students (name, course, marks) VALUES (?, ?, ?)"),
	UPDATE("UPDATE students SET name=?, course=?, marks=? WHERE id=?"),
	DELETE("DELETE FROM students WHERE id=?");

	private String query;

	private Queries(String query) {
		this.query = query;
	}

	public String getQuery() {
		return query;
	}
}
