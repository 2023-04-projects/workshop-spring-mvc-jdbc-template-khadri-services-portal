package com.khadri.spring.task.form;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TaskForm {

	private Integer id;

	private String priority;

	private String status;

	private Double cost;

}