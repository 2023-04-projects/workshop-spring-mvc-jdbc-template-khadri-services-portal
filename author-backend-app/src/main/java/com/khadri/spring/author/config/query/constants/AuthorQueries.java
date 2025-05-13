package com.khadri.spring.author.config.query.constants;

public enum AuthorQueries {

	FIND_BY_ID("SELECT * FROM author WHERE id=?"), 
	FIND_BY_NAME("SELECT * FROM author WHERE name LIKE ?"),
	FIND_BY_SKILLSETS("SELECT * FROM author WHERE skillsets LIKE ?"),
	FIND_BY_YEAR("SELECT * FROM author WHERE year = ?"),
	INSERT("INSERT INTO author (name, skillsets, year) VALUES (?, ?, ?)"),
	UPDATE("UPDATE author SET name=?, skillsets=?, year=? WHERE id=?"),
	DELETE("DELETE FROM author WHERE id=?");

	private String query;

	private AuthorQueries(String query) {
		this.query = query;
	}

	public String getQuery() {
		return query;
	}
}
