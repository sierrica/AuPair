package com.sierrica.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.Setter;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.annotations.Parameter;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.sierrica.model.config.PostgreEnumUserType;
import com.sierrica.model.types.LocaleType;
import com.sierrica.model.types.StatusType;
import lombok.AllArgsConstructor;

/**
 * @author sierrica
 *
 */

@Entity
@Table(name = "\"user\"", schema="public")							// Necesary the quotes because Postgre reserve this word
@NoArgsConstructor @AllArgsConstructor
@Getter @Setter

//@Audited
//@JsonInclude(JsonInclude.Include.NON_NULL)
@TypeDef(name = "postgresql_enum", typeClass = PostgreEnumUserType.class)
public class User {


	
	@Id
	@SequenceGenerator(name = "user_sequence", sequenceName = "user_sequence", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "user_sequence")
	private Integer id;

	
	@Column (name = "email", length=40, unique=true)
	@NotBlank (message="emailNotBlank")
	@NotNull(message="emailNotNull")
	@Size(max=40, message="emailTooLong")
	@Email (message="emailNotValid")
	@JsonProperty(value="email", index=0, required=true)
	@NonNull
	private String email;

	@Column (name = "status", nullable=false, length=10)
	@Enumerated(EnumType.STRING) 		// JPA Mapea como String al crear el schema. No crea un type enum como si lo crea manualmente mediante script SQL.
	@Type(type = "com.sierrica.model.config.PostgreEnumUserType", parameters = {@Parameter(name = "enumClassName", value = "com.sierrica.model.types.StatusType")})
	@JsonProperty(value="status", index=1, required=false)
	private StatusType status;

	@Enumerated(EnumType.STRING)
	@Column (name = "locale", nullable=false, length=2)
	@Type(type = "postgresql_enum", parameters = {@Parameter(name = "enumClassName", value = "com.sierrica.model.types.LocaleType")})
	@JsonProperty(value="locale", index=2, required=true, defaultValue="en")
	private LocaleType locale = LocaleType.en;
	
	
	
	@Column(name = "firstName", nullable=false, length=40)
	@NotBlank (message="firstName blank")
	@Size(max=40, message="email too long")
	@NotNull(message="firstName null")
	@JsonProperty(value="firstName", index=3, required=true)
	private String firstName;

	@Column(name = "lastName", nullable=false, length=40)
	@NotBlank (message="lastName blank")
	@NotNull(message="lastName null")
	@Size(max=40, message="email too long")
	@JsonProperty(value="lastName", index=4, required=true)
	private String lastName;

	@Column(name = "password", nullable=false, length=40) 
	@NotBlank (message="passwordNotBlank")
	@NotNull(message="passwordNotNull")
	@Size(max=20, message="passwordTooLong")
	@Pattern(regexp="((?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=\\S+$).{8,20})", message="passwordNotValid")
	@JsonProperty(value="password", index=5, required=true)
	private String password;
	
	@Column(name = "securityQuestion", nullable=false, length=80)
	@NotBlank (message="securityQuestion blank")
	@NotNull(message="securityQuestion null")
	@Size(max=80, message="securityQuestion too long")
	@JsonProperty(value="securityQuestion", index=6, required=true)
	private String securityQuestion;
	
	@Column(name = "securityQuestionAnswer", nullable=false, length=80)
	@NotBlank (message="securityQuestionAnswer blank")
	@NotNull(message="securityQuestionAnswer null")
	@Size(max=80, message="securityQuestionAnswer too long")
	@JsonProperty(value="securityQuestionAnswer", index=7, required=true)
	private String securityQuestionAnswer;

	
	
	//@Size.List ({
	//	@Size(min=8, message="The field must be at least {min} characters"),
	//	@Size(max=60, message="The field must be less than {max} characters")
	//})
	//@Min(value=1, message="MINIMO")
	//@Max(value=10, message="MAXIMO")	
	
	
	
//	@Column(name = "createdDate", nullable=false, updatable = false)
//	@Temporal(TemporalType.TIMESTAMP)
//	@CreatedDate
//	@JsonIgnore(value=true)
//	private Date createdDate;
	
//	@LastModifiedDate
//	@Temporal(TemporalType.TIMESTAMP)
//	@JsonIgnore(value=true)
//	private Date lastModifiedDate;
	
//	@PrePersist
//    public void onPrePersist() throws ParseException {
//		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
//        createdDate = dateFormat.parse(dateFormat.format(new Date()));
//        lastModifiedDate = dateFormat.parse(dateFormat.format(new Date()));
//    }
      
//    @PreUpdate
//    public void onPreUpdate() throws ParseException {
//		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
//		lastModifiedDate = dateFormat.parse(dateFormat.format(new Date()));
//    }
      
//    @PreRemove
//    public void onPreRemove() {
//    }

}
