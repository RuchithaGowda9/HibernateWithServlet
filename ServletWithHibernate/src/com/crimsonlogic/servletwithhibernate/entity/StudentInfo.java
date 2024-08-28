package com.crimsonlogic.servletwithhibernate.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "students")
public class StudentInfo {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int studentId;
	@Column(name = "student_name")
	private String studentName;
	@Column(name = "student_email")
	private String studentEmail;
	@Column(name = "username")
	private String username;
	@Column(name = "password")
	private String password;

}
