package com.khadri.spring.customer.dao;

import org.springframework.stereotype.Repository;

@Repository
public class CustomerDAO {

//	private Connection getConnection() throws Exception {
//		// Use your JDBC connection settings here
//		Class.forName("com.mysql.cj.jdbc.Driver");
//		return DriverManager.getConnection("jdbc:mysql://localhost:3306/2024_batch", "root", "root");
//	}

//	public CustomerForm save(CustomerForm student) {
//		String sql = "INSERT INTO students (name, course, marks) VALUES (?, ?, ?)";
//		try (Connection con = getConnection();
//				PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
//
//			ps.setString(1, student.getName());
//			ps.setString(2, student.getCourse());
//			ps.setInt(3, student.getMarks());
//			ps.executeUpdate();
//
//			ResultSet rs = ps.getGeneratedKeys();
//			if (rs.next()) {
//				student.setId(rs.getInt(1));
//			}
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		return student;
//	}
//
//	public StudentForm update(StudentForm student) {
//		String sql = "UPDATE students SET name=?, course=?, marks=? WHERE id=?";
//		try (Connection con = getConnection(); PreparedStatement ps = con.prepareStatement(sql)) {
//
//			ps.setString(1, student.getName());
//			ps.setString(2, student.getCourse());
//			ps.setInt(3, student.getMarks());
//			ps.setInt(4, student.getId());
//			ps.executeUpdate();
//
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//
//		return findById(student.getId());
//	}
//
//	public StudentForm partialUpdate(int id, Map<String, Object> updates) {
//
//		StringBuilder builderSql = new StringBuilder("UPDATE students SET ");
//
//		List<Object> values = new ArrayList<>();
//
//		updates.keySet().stream().forEach(eachkey -> {
//			builderSql.append(eachkey).append("=?, ");
//			values.add(updates.get(eachkey));
//		});
//
//		builderSql.setLength(builderSql.length() - 2);
//		builderSql.append(" WHERE id=?");
//		values.add(id);
//
//		try (Connection con = getConnection(); PreparedStatement ps = con.prepareStatement(builderSql.toString())) {
//
//			for (int i = 0; i < values.size(); i++) {
//				ps.setObject(i + 1, values.get(i));
//			}
//
//			ps.executeUpdate();
//
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//
//		return findById(id);
//	}
//
//	public void delete(int id) {
//		String sql = "DELETE FROM students WHERE id=?";
//		try (Connection con = getConnection(); PreparedStatement ps = con.prepareStatement(sql)) {
//
//			ps.setInt(1, id);
//			ps.executeUpdate();
//
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//	}
//
//	public StudentForm findById(int id) {
//		StudentForm s = null;
//		try (Connection con = getConnection();
//				PreparedStatement ps = con.prepareStatement(Queries.FIND_BY_ID.getQuery())) {
//
//			ps.setInt(1, id);
//			ResultSet rs = ps.executeQuery();
//			if (rs.next()) {
//				s = new StudentForm();
//				s.setId(rs.getInt("id"));
//				s.setName(rs.getString("name"));
//				s.setCourse(rs.getString("course"));
//				s.setMarks(rs.getInt("marks"));
//			}
//
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		return s;
//	}
//
//	public List<StudentForm> findByName(String name) {
//		List<StudentForm> list = new ArrayList<>();
//		try (Connection con = getConnection();
//				PreparedStatement ps = con.prepareStatement(Queries.FIND_BY_NAME.getQuery())) {
//
//			ps.setString(1, "%" + name + "%");
//			ResultSet rs = ps.executeQuery();
//
//			while (rs.next()) {
//				StudentForm s = new StudentForm();
//				s.setId(rs.getInt("id"));
//				s.setName(rs.getString("name"));
//				s.setCourse(rs.getString("course"));
//				s.setMarks(rs.getInt("marks"));
//				list.add(s);
//			}
//
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		return list;
//	}
//
//	public List<StudentForm> findByCourse(String course) {
//		List<StudentForm> list = new ArrayList<>();
//		String sql = "SELECT * FROM students WHERE course LIKE ?";
//		try (Connection con = getConnection(); PreparedStatement ps = con.prepareStatement(sql)) {
//			ps.setString(1, "%" + course + "%");
//			ResultSet rs = ps.executeQuery();
//			while (rs.next()) {
//				StudentForm s = new StudentForm();
//				s.setId(rs.getInt("id"));
//				s.setName(rs.getString("name"));
//				s.setCourse(rs.getString("course"));
//				s.setMarks(rs.getInt("marks"));
//				list.add(s);
//			}
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		return list;
//	}
//
//	public List<StudentForm> findByMarks(int marks) {
//		List<StudentForm> list = new ArrayList<>();
//		String sql = "SELECT * FROM students WHERE marks = ?";
//		try (Connection con = getConnection(); PreparedStatement ps = con.prepareStatement(sql)) {
//			ps.setInt(1, marks);
//			ResultSet rs = ps.executeQuery();
//			while (rs.next()) {
//				StudentForm s = new StudentForm();
//				s.setId(rs.getInt("id"));
//				s.setName(rs.getString("name"));
//				s.setCourse(rs.getString("course"));
//				s.setMarks(rs.getInt("marks"));
//				list.add(s);
//			}
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		return list;
//	}
}
