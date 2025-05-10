package com.khadri.spring.software.config.query.constantas;

public enum SoftwareQueries {

	FIND_BY_ID("SELECT * FROM softawre WHERE id=?"), 
	FIND_BY_NAME("SELECT * FROM software WHERE name LIKE ?"),
	FIND_BY_ADDRESS("SELECT * FROM software WHERE address LIKE ?"),
	FIND_BY_PHONENUMBER("SELECT * FROM software WHERE phoneNumber = ?"),
	INSERT("INSERT INTO software (name, address, phoneNumber) VALUES (?, ?, ?)"),
	UPDATE("UPDATE software SET name=?, address=?, phoneNumber=? WHERE id=?"),
	DELETE("DELETE FROM software WHERE id=?");

	private String query;

	private SoftwareQueries(String query) {
		this.query = query;
	}

	public String getQuery() {
		return query;
	}
}
