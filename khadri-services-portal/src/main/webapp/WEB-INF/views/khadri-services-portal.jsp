<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Khadri Student Portal</title>
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/student-portal.css" />
<script
	src="${pageContext.request.contextPath}/resources/student-portal.js"></script>
<script
	src="${pageContext.request.contextPath}/resources/customer-portal.js"></script>
<script
	src="${pageContext.request.contextPath}/resources/software-portal.js"></script>
<script src="${pageContext.request.contextPath}/resources/hide-divs.js"></script>
</head>
<body>

	<header> Khadri Student Portal </header>

	<div class="container">
		<div class="left-pane">
			<h2>Student Services</h2>
			<div class="nav-links">
				<a href="javascript:void(0);" onclick="addStudent()"> Add
					Student</a> <a href="javascript:void(0);" onclick="updateStudent()">
					Update Student</a> <a href="javascript:void(0);"
					onclick="deleteStudent()"> Delete Student</a> <a
					href="javascript:void(0);" onclick="searchStudentByID()">
					Search Student By ID</a> <a href="javascript:void(0);"
					onclick="searchStudentByName()"> Search Student By Name</a> <a
					href="javascript:void(0);" onclick="searchStudentByCourse()">
					Search Student By Course</a> <a href="javascript:void(0);"
					onclick="searchStudentByMarks()"> Search Student By Marks</a>
			</div>


			<h2>Customer Services</h2>
			<div class="nav-links">
				<a href="javascript:void(0);" onclick="addCustomer()"> Add
					Customer</a> <a href="javascript:void(0);" onclick="updateCustomer()">
					Update Customer</a> <a href="javascript:void(0);"
					onclick="deleteCustomer()"> Delete Customer</a> <a
					href="javascript:void(0);" onclick="searchCustomerByID()">
					Search Customer By ID</a> <a href="javascript:void(0);"
					onclick="searchCustomerByName()"> Search Customer By Name</a> <a
					href="javascript:void(0);" onclick="searchCustomerByAddress()">
					Search Customer By Address</a> <a href="javascript:void(0);"
					onclick="searchCustomerByPhoneNumber()"> Search Customer By
					Phone Number</a>
			</div>
			<h2>Software Services</h2>
			<div class="nav-links">
				<a href="javascript:void(0);" onclick="addSoftware()"> Add
					Software</a> <a href="javascript:void(0);" onclick="updateSoftware()">
					Update Software</a> <a href="javascript:void(0);"
					onclick="deleteSoftware()"> Delete Software</a> <a
					href="javascript:void(0);" onclick="searchSoftwareByID()">
					Search Software By ID</a> <a href="javascript:void(0);"
					onclick="searchSoftwareByName()"> Search Software By Name</a> <a
					href="javascript:void(0);" onclick="searchSoftwareByAddress()">
					Search Software By Address</a> <a href="javascript:void(0);"
					onclick="searchSoftwareByPhoneNumber()"> Search Software By
					Phone Number</a>
			</div>
		</div>

		<div class="right-pane">
			<h2>Forms</h2>

			<div id="search-student-by-id-section" class="form-container"
				style="display: none;">
				<h3>Search Student By Id</h3>
				<form action="${pageContext.request.contextPath}/student/find/by/id"
					method="get">
					<label for="id">Enter Student Id:</label> <input type="text"
						id="id" name="id" required /> <input type="submit" value="Search" />
				</form>
			</div>

			<c:if test="${not empty foundStudent}">
				<div id="search-student-by-id-result-section" class="grid-section">
					<h3>Student Found</h3>
					<table border="1" cellpadding="10" cellspacing="0">
						<tr>
							<th>ID</th>
							<th>Name</th>
							<th>Course</th>
							<th>Marks</th>
						</tr>
						<tr>
							<td>${foundStudent.id}</td>
							<td>${foundStudent.name}</td>
							<td>${foundStudent.course}</td>
							<td>${foundStudent.marks}</td>
						</tr>
					</table>
				</div>
			</c:if>


			<div id="search-student-by-name-section" class="form-container"
				style="display: none;">
				<h3>Search Student By Name</h3>
				<form
					action="${pageContext.request.contextPath}/student/find/by/name"
					method="get">
					<label for="name">Enter Student Name:</label> <input type="text"
						id="name" name="name" required /> <input type="submit"
						value="Search" />
				</form>
			</div>
			<c:if test="${not empty studentsByName}">
				<div id="search-student-by-name-result-section" class="grid-section">
					<h3>Matching Students</h3>
					<table border="1" cellpadding="10" cellspacing="0">
						<tr>
							<th>ID</th>
							<th>Name</th>
							<th>Course</th>
							<th>Marks</th>
						</tr>
						<c:forEach var="student" items="${studentsByName}">
							<tr>
								<td>${student.id}</td>
								<td>${student.name}</td>
								<td>${student.course}</td>
								<td>${student.marks}</td>
							</tr>
						</c:forEach>
					</table>
				</div>
			</c:if>

			<!-- Search by Course -->
			<div id="search-student-by-course-section" class="form-container"
				style="display: none;">
				<h3>Search Student By Course</h3>
				<form
					action="${pageContext.request.contextPath}/student/find/by/course"
					method="get">
					<label for="course">Enter Course Name:</label> <input type="text"
						id="course" name="course" required /> <input type="submit"
						value="Search" />
				</form>
			</div>

			<c:if test="${not empty studentsByCourse}">
				<div id="search-student-by-course-result-section"
					class="grid-section">
					<h3>Matching Students (By Course)</h3>
					<table border="1" cellpadding="10" cellspacing="0">
						<tr>
							<th>ID</th>
							<th>Name</th>
							<th>Course</th>
							<th>Marks</th>
						</tr>
						<c:forEach var="student" items="${studentsByCourse}">
							<tr>
								<td>${student.id}</td>
								<td>${student.name}</td>
								<td>${student.course}</td>
								<td>${student.marks}</td>
							</tr>
						</c:forEach>
					</table>
				</div>
			</c:if>

			<!-- Search by Marks -->
			<div id="search-student-by-marks-section" class="form-container"
				style="display: none;">
				<h3>Search Student By Marks</h3>
				<form
					action="${pageContext.request.contextPath}/student/find/by/marks"
					method="get">
					<label for="marks">Enter Marks:</label> <input type="number"
						id="marks" name="marks" required /> <input type="submit"
						value="Search" />
				</form>
			</div>

			<c:if test="${not empty studentsByMarks}">
				<div id="search-student-by-marks-result-section"
					class="grid-section">
					<h3>Matching Students (By Marks)</h3>
					<table border="1" cellpadding="10" cellspacing="0">
						<tr>
							<th>ID</th>
							<th>Name</th>
							<th>Course</th>
							<th>Marks</th>
						</tr>
						<c:forEach var="student" items="${studentsByMarks}">
							<tr>
								<td>${student.id}</td>
								<td>${student.name}</td>
								<td>${student.course}</td>
								<td>${student.marks}</td>
							</tr>
						</c:forEach>
					</table>
				</div>
			</c:if>

			<div id="add-student-form-section" class="form-container">
				<h3>Add Student</h3>
				<form:form modelAttribute="studentForm" method="post"
					action="${pageContext.request.contextPath}/student/save">
					<form:label path="id">ID:</form:label>
					<form:input path="id" readonly="true" />
					<br />
					<br />
					<form:label path="name">Name:</form:label>
					<form:input path="name" required="true" />
					<br />
					<br />
					<form:label path="course">Course:</form:label>
					<form:input path="course" required="true" />
					<br />
					<br />
					<form:label path="marks">Marks:</form:label>
					<form:input path="marks" type="number" required="true" />
					<br />
					<br />
					<input type="submit" value="Submit" />
				</form:form>
			</div>


			<div id="update-student-form-section" class="form-container"
				style="display: none;">
				<h3>Update Student</h3>
				<form:form modelAttribute="studentForm" method="post"
					action="${pageContext.request.contextPath}/student/update">
					<form:label path="id">ID:</form:label>
					<form:input path="id" required="true" />
					<br />
					<br />
					<form:label path="name">Name:</form:label>
					<form:input path="name" required="true" />
					<br />
					<br />
					<form:label path="course">Course:</form:label>
					<form:input path="course" required="true" />
					<br />
					<br />
					<form:label path="marks">Marks:</form:label>
					<form:input path="marks" type="number" required="true" />
					<br />
					<br />
					<input type="submit" value="Update" />
				</form:form>
			</div>


			<div id="delete-student-form-section" class="form-container"
				style="display: none;">
				<h3>Delete Student</h3>
				<form action="${pageContext.request.contextPath}/student/delete"
					method="post">
					<label for="deleteId">Enter Student ID to Delete:</label> <input
						type="text" id="deleteId" name="id" required /> <input
						type="submit" value="Delete" />
				</form>
			</div>

			<c:if test="${not empty addedStudent}">
				<div id="add-student-form-result-section" class="added-record">
					<h3>Student Added Successfully!</h3>
					<p>
						<strong>ID:</strong> ${addedStudent.id}
					</p>
					<p>
						<strong>Name:</strong> ${addedStudent.name}
					</p>
					<p>
						<strong>Course:</strong> ${addedStudent.course}
					</p>
					<p>
						<strong>Marks:</strong> ${addedStudent.marks}
					</p>
				</div>
			</c:if>

			<!-- Customer module starts -->

			<div id="add-customer-form-section" class="form-container">
				<h3>Add Customer</h3>
				<form:form modelAttribute="customerForm" method="post"
					action="${pageContext.request.contextPath}/customer/save">
					<form:label path="id">ID:</form:label>
					<form:input path="id" readonly="true" />
					<br />
					<br />
					<form:label path="name">Name:</form:label>
					<form:input path="name" required="true" />
					<br />
					<br />
					<form:label path="address">Address:</form:label>
					<form:input path="address" required="true" />
					<br />
					<br />
					<form:label path="phoneNumber">PhoneNumber:</form:label>
					<form:input path="phoneNumber" type="number" required="true" />
					<br />
					<br />
					<input type="submit" value="Submit" />
				</form:form>
			</div>
			<div id="search-customer-by-id-section" class="form-container"
				style="display: none;">
				<h3>Search Customer By Id</h3>
				<form action="${pageContext.request.contextPath}/find/by/id"
					method="get">
					<label for="id">Enter Customer Id:</label> <input type="text"
						id="id" name="id" required /> <input type="submit" value="Search" />
				</form>
			</div>

			<div id="update-customer-form-section" class="form-container"
				style="display: none;">
				<h3>Update Customer</h3>
				<form:form modelAttribute="customerForm" method="post"
					action="${pageContext.request.contextPath}/update">
					<form:label path="id">ID:</form:label>
					<form:input path="id" required="true" />
					<br />
					<br />
					<form:label path="name">Name:</form:label>
					<form:input path="name" required="true" />
					<br />
					<br />
					<form:label path="address">Address:</form:label>
					<form:input path="address" required="true" />
					<br />
					<br />
					<form:label path="phoneNumber">Phone Number:</form:label>
					<form:input path="phoneNumber" type="number" required="true" />
					<br />
					<br />
					<input type="submit" value="Update" />
				</form:form>
			</div>
			<div id="delete-customer-form-section" class="form-container"
				style="display: none;">
				<h3>Delete Customer</h3>
				<form action="${pageContext.request.contextPath}/delete"
					method="post">
					<label for="deleteId">Enter Customer ID to Delete:</label> <input
						type="text" id="deleteId" name="id" required /> <input
						type="submit" value="Delete" />
				</form>
			</div>
			<div id="search-customer-by-name-section" class="form-container"
				style="display: none;">
				<h3>Search Customer By Name</h3>
				<form action="${pageContext.request.contextPath}/find/by/name"
					method="get">
					<label for="name">Enter Customer Name:</label> <input type="text"
						id="name" name="name" required /> <input type="submit"
						value="Search" />
				</form>
			</div>
			<div id="search-customer-by-address-section" class="form-container"
				style="display: none;">
				<h3>Search Customer By Address</h3>
				<form action="${pageContext.request.contextPath}/find/by/course"
					method="get">
					<label for="course">Enter Address Name:</label> <input type="text"
						id="address" name="address" required /> <input type="submit"
						value="Search" />
				</form>
			</div>

			<div id="search-customer-by-phone-number-section"
				class="form-container" style="display: none;">
				<h3>Search Customer By Phone Number</h3>
				<form action="${pageContext.request.contextPath}/find/by/marks"
					method="get">
					<label for="marks">Enter Phone Number:</label> <input type="number"
						id="phoneNumber" name="phoneNumber" required /> <input
						type="submit" value="Search" />
				</form>
			</div>


			<!-- Software module starts -->

			<div id="search-software-by-id-section" class="form-container"
				style="display: none;">
				<h3>Search Software By Id</h3>
				<form
					action="${pageContext.request.contextPath}/software/find/by/id"
					method="get">
					<label for="id">Enter Software Id:</label> <input type="text"
						id="id" name="id" required /> <input type="submit" value="Search" />
				</form>
			</div>

			<c:if test="${not empty foundSoftware}">
				<div id="search-software-by-id-result-section" class="grid-section">
					<h3>Software Found</h3>
					<table border="1" cellpadding="10" cellspacing="0">
						<tr>
							<th>ID</th>
							<th>Name</th>
							<th>Adderss</th>
							<th>PhoneNumer</th>
						</tr>
						<tr>
							<td>${foundSoftware.id}</td>
							<td>${foundSoftware.name}</td>
							<td>${foundSoftware.adderss}</td>
							<td>${foundSoftware.phoneNumber}</td>
						</tr>
					</table>
				</div>
			</c:if>


			<div id="search-software-by-name-section" class="form-container"
				style="display: none;">
				<h3>Search Software By Name</h3>
				<form
					action="${pageContext.request.contextPath}/software/find/by/name"
					method="get">
					<label for="name">Enter Software Name:</label> <input type="text"
						id="name" name="name" required /> <input type="submit"
						value="Search" />
				</form>
			</div>
			<c:if test="${not empty softwaresByName}">
				<div id="search-student-by-name-result-section" class="grid-section">
					<h3>Matching Softwares</h3>
					<table border="1" cellpadding="10" cellspacing="0">
						<tr>
							<th>ID</th>
							<th>Name</th>
							<th>Adderss</th>
							<th>PhoneNumber</th>
						</tr>
						<c:forEach var="software" items="${softwaresByName}">
							<tr>
								<td>${software.id}</td>
								<td>${software.name}</td>
								<td>${software.adderss}</td>
								<td>${software.phoneNumber}</td>
							</tr>
						</c:forEach>
					</table>
				</div>
			</c:if>

			<!-- Search by Adderss -->
			<div id="search-software-by-course-section" class="form-container"
				style="display: none;">
				<h3>Search Software By Adderss</h3>
				<form
					action="${pageContext.request.contextPath}/software/find/by/course"
					method="get">
					<label for="course">Enter Adderss Name:</label> <input type="text"
						id="course" name="course" required /> <input type="submit"
						value="Search" />
				</form>
			</div>

			<c:if test="${not empty softwaresByAdderss}">
				<div id="search-software-by-adderss-result-section"
					class="grid-section">
					<h3>Matching Softwares (By Course)</h3>
					<table border="1" cellpadding="10" cellspacing="0">
						<tr>
							<th>ID</th>
							<th>Name</th>
							<th>Adderss</th>
							<th>PhoneNumber</th>
						</tr>
						<c:forEach var="c" items="${softwaresByCourse}">
							<tr>
								<td>${software.id}</td>
								<td>${software.name}</td>
								<td>${software.adderss}</td>
								<td>${software.phoneNumber}</td>
							</tr>
						</c:forEach>
					</table>
				</div>
			</c:if>

			<!-- Search by PhoneNumber -->
			<div id="search-software-by-phoneNumber-section"
				class="form-container" style="display: none;">
				<h3>Search Software By phoneNumber</h3>
				<form
					action="${pageContext.request.contextPath}/student/find/by/marks"
					method="get">
					<label for="marks">Enter PhoneNumber:</label> <input type="number"
						id="marks" name="marks" required /> <input type="submit"
						value="Search" />
				</form>
			</div>

			<c:if test="${not empty studentsByMarks}">
				<div id="search-student-by-marks-result-section"
					class="grid-section">
					<h3>Matching Students (By Marks)</h3>
					<table border="1" cellpadding="10" cellspacing="0">
						<tr>
							<th>ID</th>
							<th>Name</th>
							<th>Adderss</th>
							<th>PhoneNumber</th>
						</tr>
						<c:forEach var="software" items="${studentsByMarks}">
							<tr>
								<td>${software.id}</td>
								<td>${software.name}</td>
								<td>${software.adderss}</td>
								<td>${software.phoneNumber}</td>
							</tr>
						</c:forEach>
					</table>
				</div>
			</c:if>

			<div id="add-software-form-section" class="form-container">
				<h3>Add Student</h3>
				<form:form modelAttribute="softwareForm" method="post"
					action="${pageContext.request.contextPath}/student/save">
					<form:label path="id">ID:</form:label>
					<form:input path="id" readonly="true" />
					<br />
					<br />
					<form:label path="name">Name:</form:label>
					<form:input path="name" required="true" />
					<br />
					<br />
					<form:label path="adderss">Adderss:</form:label>
					<form:input path="adderss" required="true" />
					<br />
					<br />
					<form:label path="adderss">Adderss:</form:label>
					<form:input path="adderss" type="number" required="true" />
					<br />
					<br />
					<input type="submit" value="Submit" />
				</form:form>
			</div>


			<div id="update-software-form-section" class="form-container"
				style="display: none;">
				<h3>Update Student</h3>
				<form:form modelAttribute="softwareForm" method="post"
					action="${pageContext.request.contextPath}/software/update">
					<form:label path="id">ID:</form:label>
					<form:input path="id" required="true" />
					<br />
					<br />
					<form:label path="name">Name:</form:label>
					<form:input path="name" required="true" />
					<br />
					<br />
					<form:label path="adderss">Adderss:</form:label>
					<form:input path="adderss" required="true" />
					<br />
					<br />
					<form:label path="phoneNumber">Marks:</form:label>
					<form:input path="PhoneNumber" type="number" required="true" />
					<br />
					<br />
					<input type="submit" value="Update" />
				</form:form>
			</div>


			<div id="delete-software-form-section" class="form-container"
				style="display: none;">
				<h3>Delete Software</h3>
				<form action="${pageContext.request.contextPath}/student/delete"
					method="post">
					<label for="deleteId">Enter Software ID to Delete:</label> <input
						type="text" id="deleteId" name="id" required /> <input
						type="submit" value="Delete" />
				</form>
			</div>

			<c:if test="${not empty addedSoftware}">
				<div id="add-software-form-result-section" class="added-record">
					<h3>Software Added Successfully!</h3>
					<p>
						<strong>ID:</strong> ${addedSoftware.id}
					</p>
					<p>
						<strong>Name:</strong> ${addedSoftware.name}
					</p>
					<p>
						<strong>Adderss:</strong> ${addedSoftware.adderss}
					</p>
					<p>
						<strong>PhoneNumber:</strong> ${addedSoftware.phoneNumber}
					</p>
				</div>
			</c:if>

		</div>
	</div>



































</body>
</html>