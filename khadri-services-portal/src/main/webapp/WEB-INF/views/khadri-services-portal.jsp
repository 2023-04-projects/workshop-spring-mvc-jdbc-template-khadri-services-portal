<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Khadri Services Portal</title>
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/student-portal.css" />

<script> 
        function addStudent() {
        	hideAllForms();
            document.getElementById("add-student-form-section").style.display = "block";
        } 

        function searchStudentByID() {
        	hideAllForms();
            document.getElementById("search-student-by-id-section").style.display = "block";
        }

        function updateStudent() {
        	hideAllForms();
            document.getElementById("update-student-form-section").style.display = "block";
        }

        function deleteStudent() {
        	hideAllForms();
            document.getElementById("delete-student-form-section").style.display = "block";
        }
        
        function searchStudentByName() {
        	hideAllForms();
            document.getElementById("search-student-by-name-section").style.display = "block";
        }
        
        
        function searchStudentByCourse() {
            hideAllForms();
            document.getElementById("search-student-by-course-section").style.display = "block";
        }

        function searchStudentByMarks() {
            hideAllForms();
            document.getElementById("search-student-by-marks-section").style.display = "block";
        }

        function addCustomer() {
        	hideAllForms();
            document.getElementById("add-customer-form-section").style.display = "block";
        }
        function searchCustomerByID() {
        	hideAllForms();
            document.getElementById("search-customer-by-id-section").style.display = "block";
        }
        
        function updateCustomer() {
        	hideAllForms();
            document.getElementById("update-customer-form-section").style.display = "block";
        }

        function deleteCustomer() {
        	hideAllForms();
            document.getElementById("delete-customer-form-section").style.display = "block";
        }
        
        function searchCustomerByName() {
        	hideAllForms();
            document.getElementById("search-customer-by-name-section").style.display = "block";
        }
        
        
        function searchCustomerByCourse() {
            hideAllForms();
            document.getElementById("search-customer-by-address-section").style.display = "block";
        }

        function searchCustomerByMarks() {
            hideAllForms();
            document.getElementById("search-customer-by-phoneNumber-section").style.display = "block";
        }

        function hideAllForms() {
            const sections = [
                "add-student-form-section",
                "update-student-form-section",
                "delete-student-form-section",
                "search-student-by-id-section",
                "search-student-by-name-section",
                "search-student-by-course-section",
                "search-student-by-marks-section",
                "search-student-by-id-result-section",
                "search-student-by-name-result-section",
                "search-student-by-course-result-section",
                "search-student-by-marks-result-section",
                "add-student-form-result-section",
                "add-customer-form-section",
                "add-customer-form-result-section",

                

                  ];
            sections.forEach(id => {
                const el = document.getElementById(id);
                if (el) el.style.display = "none";
            });
        }
    </script>
</head>
<body>


	<header> Khadri Service Portal </header>

	<div class="container">
		<div class="left-pane">
			<h2>Services</h2>
			<div class="nav-links">
				<a href="javascript:void(0);" onclick="addStudent()"> Add Student</a> 
				<a href="javascript:void(0);" onclick="updateStudent()"> Update Student</a>
				<a href="javascript:void(0);" onclick="deleteStudent()"> Delete Student</a>
				<a href="javascript:void(0);" onclick="searchStudentByID()"> Search Student By ID</a>
				<a href="javascript:void(0);" onclick="searchStudentByName()"> Search Student By Name</a>
				<a href="javascript:void(0);" onclick="searchStudentByCourse()"> Search Student By Course</a>
				<a href="javascript:void(0);" onclick="searchStudentByMarks()"> Search Student By Marks</a>
				
				<a href="javascript:void(0);" onclick="addCustomer()"> Add Customer</a> 
				<a href="javascript:void(0);" onclick="updateCustomer()"> Update Customer</a>
				<a href="javascript:void(0);" onclick="deleteCustomer()"> Delete Customer</a>
				<a href="javascript:void(0);" onclick="searchCustomerByID()"> Search Customer By ID</a>
				<a href="javascript:void(0);" onclick="searchCustomerByName()"> Search Customer By Name</a>
				<a href="javascript:void(0);" onclick="searchCustomerByAddress()"> Search Customer By Address</a>
				<a href="javascript:void(0);" onclick="searchCustomerByPhoneNumber()"> Search Customer By PhoneNumber</a>
				
			</div>
		</div>
	
			<div class="right-pane">
			<h2>Forms</h2>

			<div id="search-student-by-id-section" class="form-container"
				style="display: none;">
				<h3>Search Student By Id</h3>
				<form action="${pageContext.request.contextPath}/find/by/id"
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
				<form action="${pageContext.request.contextPath}/find/by/name"
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
				<form action="${pageContext.request.contextPath}/find/by/course"
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
				<form action="${pageContext.request.contextPath}/find/by/marks"
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
					action="${pageContext.request.contextPath}/save">
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
					action="${pageContext.request.contextPath}/update">
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
				<form action="${pageContext.request.contextPath}/delete"
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
			<div id="add-customer-form-section" class="form-container">
				<h3>Add Customer</h3>
				<form:form modelAttribute="customerForm" method="post"
					action="${pageContext.request.contextPath}/save">
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
					<form:input path="address" type="number" required="true" />
					<br />
					<br />
					<input type="submit" value="Submit" />
				</form:form>
			</div>
			<c:if test="${not empty addedCustomer}">
				<div id="add-customer-form-result-section" class="added-record">
					<h3>Employee Added Successfully!</h3>
					<p>
						<strong>ID:</strong> ${addedCustomer.id}
					</p>
					<p>
						<strong>Name:</strong> ${addedCustomer.name}
					</p>
					<p>
						<strong>Address:</strong> ${addedCustomer.address}
					</p>
					<p>
						<strong>PhoneNumber:</strong> ${addedCustomer.phoneNumber}
					</p>
				</div>
			</c:if>
		</div>
	</div>
		
</body>
</html>