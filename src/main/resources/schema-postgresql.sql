DROP TABLE IF EXISTS "user", rol;;

-- Da problemas porque necesita instalarse la libreria perl. Se ha conseguido en linux en local pero en PAAS como Openshift no. Por supuesto en SAAS como Elepant se suone que no ira tampoco. Se descarta su uso de momento.
--CREATE OR REPLACE FUNCTION validate_email(email VARCHAR) RETURNS bool
--AS $$
--	use Email::Address;
--	my @addresses = Email::Address->parse($_[0]);
--	return scalar(@addresses) > 0 ? 1 : 0;
--$$ LANGUAGE plperlu;;


DROP TYPE IF EXISTS statustype, localeType;;

CREATE TYPE statusType AS ENUM ('STAGED','ACTIVE');;
CREATE TYPE localeType AS ENUM ('en','es');;


Set timezone = 'UTC';;

CREATE TABLE "user" (
	id VARCHAR(20) PRIMARY KEY,
	status statusType NOT NULL,
	email VARCHAR(40) NOT NULL,
	firstName VARCHAR(40) NOT NULL,
	lastName VARCHAR(40) NOT NULL,
	password VARCHAR(80) NOT NULL,
	locale localeType NOT NULL,
	securityQuestion VARCHAR(80) NOT NULL,
	securityQuestionAnswer VARCHAR(80) NOT NULL,
	createdDate TIMESTAMP WITHOUT TIME ZONE NOT NULL DEFAULT CURRENT_TIMESTAMP,
	lastUpdatedDate TIMESTAMP WITHOUT TIME ZONE NOT NULL DEFAULT CURRENT_TIMESTAMP
	--CONSTRAINT email_valid CHECK (validate_email(email)) 
);;