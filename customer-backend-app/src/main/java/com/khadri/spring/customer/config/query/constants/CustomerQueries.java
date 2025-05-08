package com.khadri.spring.customer.config.query.constants;

public enum CustomerQueries {

	FIND_BY_ID("SELECT * FROM customer WHERE id=?"), 
	FIND_BY_NAME("SELECT * FROM customer WHERE name LIKE ?"),
	FIND_BY_ADDRESS("SELECT * FROM customer WHERE address LIKE ?"),
	FIND_BY_PHONENUMBER("SELECT * FROM customer WHERE phoneNumber = ?"),
	INSERT("INSERT INTO customer (name, address, phoneNmuber) VALUES (?, ?, ?)"),
	UPDATE("UPDATE customer SET name=?, address=?, phoneNmuber=? WHERE id=?"),
	DELETE("DELETE FROM customer WHERE id=?");

	private String query;

	private CustomerQueries(String query) {
		this.query = query;
	}

	public String getQuery() {
		return query;
	}
}
