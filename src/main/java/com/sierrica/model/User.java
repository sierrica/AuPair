package com.sierrica.model;

import java.io.Serializable;
/*import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;*/

/*import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.AllArgsConstructor;

/**
 * @author sierrica
 *
 */

//@Entity
//@Table(name = "\"user\"")		// Necesary the quotes because Postgre reserve this word
//@Getter @Setter
//@NoArgsConstructor @AllArgsConstructor
//@ToString @EqualsAndHashCode
public class User implements Serializable {

	private static final long serialVersionUID = -3009157732242241606L;
		
	//@Id
	//@Column(name = "email")
	private String email;
	
	//@Column(name = "firstName", nullable=false)
	private String firstName;
	
	//@Column(name = "lastName", nullable=false)
	private String lastName;

	//@Column(name = "password", nullable=false)
	private String password;
	
	//@Column(name = "securityQuestion", nullable=false)
	private String securityQuestion;
	
	//@Column(name = "securityQuestionAnswer", nullable=false)
	private String securityQuestionAnswer;

}