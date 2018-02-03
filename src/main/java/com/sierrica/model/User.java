package com.sierrica.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.codehaus.jackson.annotate.JsonProperty;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.Value;
import lombok.experimental.Accessors;
import lombok.experimental.Wither;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

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

