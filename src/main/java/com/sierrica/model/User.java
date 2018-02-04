package com.sierrica.model;



import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.Setter;
import lombok.experimental.NonFinal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.NotEmpty;

import lombok.AllArgsConstructor;


/**
 * @author sierrica
 *
 */

@Entity
//@Table(name = "\"user\"")		// Necesary the quotes because Postgre reserve this word
//@Table(name = "Prueba")
@Getter @Setter
@NoArgsConstructor @AllArgsConstructor
public class User {
	
	//@Id
	//@Column(name = "email")
	@NotBlank(message="email is requireddddddd")
	//@NotNull(message="email is requireddddddd")
	//@NonNull 
	//@Pattern(regexp="[A-Z]{5}[0-9]{4}[A-Z]{1}",message="Invalid PAN Number")
	@Email(message="email no es un formato valido")
	private String email;

	//public void setEmail(String email) { this.email = email; }


	

	
	
//	@Column(name = "firstName", nullable=false)
//	private String firstName;
//	
//	@Column(name = "lastName", nullable=false)
//	private String lastName;
//
//	@Column(name = "password", nullable=false)
//	private String password;
//	
//	@Column(name = "securityQuestion", nullable=false)
//	private String securityQuestion;
//	
//	@Column(name = "securityQuestionAnswer", nullable=false)
//	private String securityQuestionAnswer;

}

