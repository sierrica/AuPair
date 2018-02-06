package com.sierrica.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotBlank;
import lombok.AllArgsConstructor;


/**
 * @author sierrica
 *
 */

@Entity
@Table(name = "\"user\"")		// Necesary the quotes because Postgre reserve this word
@Getter @Setter
@NoArgsConstructor @AllArgsConstructor
public class User {

	//@NotNull(message="email is requireddddddd")
	//@NonNull 
	//@Pattern(regexp="[A-Z]{5}[0-9]{4}[A-Z]{1}",message="Invalid PAN Number")
	
	@Id
	@Column (name = "email", nullable=false, length=40)
	@NotBlank (message="email is requireddddddd")
	@Email (message="email no es un formato valido")
	private String email;


	@Column(name = "firstName", nullable=false, length=40)
	@NotBlank (message="email is requireddddddd")
	private String firstName;

	@Column(name = "lastName", nullable=false)
	private String lastName;

	@Column(name = "password", nullable=false)
	private String password;
	
	@Column(name = "securityQuestion", nullable=false)
	private String securityQuestion;
	
	@Column(name = "securityQuestionAnswer", nullable=false)
	private String securityQuestionAnswer;
}

