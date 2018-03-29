

-- Da problemas porque necesita instalarse la libreria perl. Se ha conseguido en linux en local pero en PAAS como Openshift no. Por supuesto en SAAS como Elepant se suone que no ira tampoco. Se descarta su uso de momento.
--CREATE OR REPLACE FUNCTION validate_email(email VARCHAR) RETURNS bool
--AS $$
--	use Email::Address;
--	my @addresses = Email::Address->parse($_[0]);
--	return scalar(@addresses) > 0 ? 1 : 0;
--$$ LANGUAGE plperlu;;

DROP TABLE IF EXISTS "user", rol;;

DROP TYPE IF EXISTS StatusType, LocaleType;;
CREATE TYPE StatusType AS ENUM ('STAGED','ACTIVE');;
CREATE TYPE LocaleType AS ENUM ('en','es');;

DROP SEQUENCE IF EXISTS user_sequence;;

CREATE SEQUENCE user_sequence start 1 increment 1;;

Set timezone = 'UTC';;




CREATE TABLE "user" (
	id INTEGER PRIMARY KEY DEFAULT nextval('user_sequence'),
	email VARCHAR(40) NOT NULL UNIQUE,
	status StatusType NOT NULL,
	locale LocaleType NOT NULL,
	--status VARCHAR(10) NOT NULL CHECK (status IN ('STAGED','ACTIVE')),
	firstName VARCHAR(40) NOT NULL,
	lastName VARCHAR(40) NOT NULL,
	password VARCHAR(80) NOT NULL,
	securityQuestion VARCHAR(80) NOT NULL,
	securityQuestionAnswer VARCHAR(80) NOT NULL
	
	-- default 'en'::LocaleType
	--createdDate TIMESTAMP WITHOUT TIME ZONE NOT NULL DEFAULT CURRENT_TIMESTAMP,
	--lastUpdatedDate TIMESTAMP WITHOUT TIME ZONE NOT NULL DEFAULT CURRENT_TIMESTAMP
	--CONSTRAINT email_valid CHECK (validate_email(email)) 
);;