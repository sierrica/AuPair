package com.sierrica.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotBlank;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;


/**
 * @author sierrica
 *
 */

@Entity
@EntityListeners(AuditingEntityListener.class)
@Table(name = "\"user\"")		// Necesary the quotes because Postgre reserve this word
@Getter @Setter
@NoArgsConstructor @AllArgsConstructor
public class User {

	//@NotNull(message="email is requireddddddd")
	//@NonNull 
	//@Pattern(regexp="[A-Z]{5}[0-9]{4}[A-Z]{1}",message="Invalid PAN Number")
//	@Size.List ({
//	    @Size(min=8, message="The field must be at least {min} characters"),
//	    @Size(max=60, message="The field must be less than {max} characters")
//	})
//	@Min(value=1, message="MINIMO")
//	@Max(value=10, message="MAXIMO")

	
//	@ManyToMany(mappedBy = "tags")
//	private List<Note> notes;
	
//	@SequenceGenerator(name = "note_generator", sequenceName = "note_sequence", initialValue = 5)
//	@GeneratedValue(generator = "note_generator")
	
	//@NaturalId
	
	
//	@Column (name = "id", nullable=false, length=40)
//	@JsonProperty(value="id", index=0, required=true)
//	private String id;
	
	@Id
	@Column (name = "email", nullable=false, length=40)
	@JsonProperty(value="email", index=1, required=true)
	@NotBlank (message="email blank")
	@NotNull(message="email null")
	@Size(max=40, message="email too long")
	@Email (message="email not valid")
	private String email;

	
	@Column(name = "firstName", nullable=false, length=40)
	@JsonProperty(value="firstName", index=2, required=true)
	@NotBlank (message="firstName blank")
	@Size(max=40, message="email too long")
	@NotNull(message="firstName null")
	private String firstName;

	@Column(name = "lastName", nullable=false, length=40)
	@JsonProperty(value="lastName", index=3, required=true)
	@NotBlank (message="lastName blank")
	@NotNull(message="lastName null")
	@Size(max=40, message="email too long")
	private String lastName;

	@Column(name = "password", nullable=false, length=40)
	@JsonProperty(value="password", index=4, required=true)
	@NotBlank (message="password blank")
	@NotNull(message="password null")
	@Size(max=40, message="email too long")
	private String password;
	
	@Column(name = "securityQuestion", nullable=false, length=80)
	@JsonProperty(value="securityQuestion", index=5, required=true)
	@NotBlank (message="securityQuestion blank")
	@NotNull(message="securityQuestion null")
	@Size(max=80, message="securityQuestion too long")
	private String securityQuestion;
	
	@Column(name = "securityQuestionAnswer", nullable=false, length=80)
	@JsonProperty(value="securityQuestionAnswer", index=6, required=true)
	@NotBlank (message="securityQuestionAnswer blank")
	@NotNull(message="securityQuestionAnswer null")
	@Size(max=80, message="securityQuestionAnswer too long")
	private String securityQuestionAnswer;
	
	
	@CreatedDate
	private Date createdDate;
	
	@LastModifiedDate
	private Date lastModifiedDate;
	
	
}

