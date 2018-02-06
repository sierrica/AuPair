DROP TABLE IF EXISTS "user", prueba, rol;;



CREATE OR REPLACE FUNCTION validate_email(email VARCHAR) RETURNS bool
AS $$
	use Email::Address;
	my @addresses = Email::Address->parse($_[0]);
	return scalar(@addresses) > 0 ? 1 : 0;
$$ LANGUAGE plperlu;;



CREATE TABLE "user" (
	email VARCHAR(40) PRIMARY KEY,
	firstName VARCHAR(40) NOT NULL,
	lastName VARCHAR(40) NOT NULL,
	password VARCHAR(80),
	securityQuestion VARCHAR(40),
	securityQuestionAnswer VARCHAR(40),
	CONSTRAINT email_valid CHECK (validate_email(email))
);;