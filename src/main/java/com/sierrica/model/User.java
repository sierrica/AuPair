package com.sierrica.model;



import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.AllArgsConstructor;


/**
 * @author sierrica
 *
 */

//@Entity
//@Table(name = "\"user\"")		// Necesary the quotes because Postgre reserve this word
//@Table(name = "Prueba")
@Getter @Setter
@NoArgsConstructor @AllArgsConstructor
public class User {
	
	//@Id
	//@Column(name = "email")
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

