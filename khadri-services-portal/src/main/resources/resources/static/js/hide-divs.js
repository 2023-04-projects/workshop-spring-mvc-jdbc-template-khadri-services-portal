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
		"update-customer-form-section",
		"delete-customer-form-section",
		"search-customer-by-id-section",
		"search-customer-by-name-section",
		"search-customer-by-address-section",
		"search-customer-by-phone-number-section",
		"search-customer-by-id-result-section",
		"search-customer-by-name-result-section",
		"search-customer-by-address-result-section",
		"search-customer-by-phone-number-result-section",
		"add-customer-form-result-section",
		"add-task-form-section",
		"update-task-form-section",
		"delete-task-form-section",
		"search-task-by-id-section",
		"search-task-by-priority-section",
		"search-task-by-status-section",
		"search-task-by-cost-section",
		"search-task-by-id-result-section",
		"search-task-by-priority-result-section",
		"search-task-by-status-result-section",
		"search-task-by-cost-result-section",
		"add-task-form-result-section"
	];
	sections.forEach(id => {
		const el = document.getElementById(id);
		if (el) el.style.display = "none";
	});
}