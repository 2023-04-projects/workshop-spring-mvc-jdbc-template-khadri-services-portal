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
		"add-author-form-section",
		"update-author-form-section",
		"delete-author-form-section",
		"search-author-by-id-section",
		"search-author-by-name-section",
		"search-author-by-skillsets-section",
		"search-author-by-year-section",
		"search-author-by-id-result-section",
		"search-author-by-name-result-section",
		"search-author-by-skillsets-result-section",
		"search-author-by-year-result-section",
		"add-author-form-result-section"
	];
	sections.forEach(id => {
		const el = document.getElementById(id);
		if (el) el.style.display = "none";
	});
}