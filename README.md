# Cosas a mirar
- Probar @okta/okta-vue en lugar @okta/okta-auth-js


# Okta company
sierrica-dev-621930


# Error oaut2 devtools actuator
@EnableAuthorizationServer  // Solo se utiliza por querer asegurar actuator management.security.enabled=true,  okta-spring-security-starter 0.1.0 y devtools
Por ahora seguir utilizando okta-spring-security-starter 0.1.0 por el error con Devtools y dejar management.security.enabled=false para poder ver la informacion

# Error lombook no reconocido en Eclipse.
java -jar lombok.jar install ..\..\eclipse\jee-oxygen\eclipse 
java -jar lombok-1.16.20.jar install <path of where your IDE is installed>
Hacer un Maven Update y esperar un poco. Si eso no funciona añadir el Jar al proyecto y luego quitarlo porque he comprobado que no es necesario, solo el instalarlo en el dir de Eclipse


# AuPair Web App
App for AuPairs

# Technologies used
- Java Spring Boot
- Postgre
- Hibernate - JPA
- Git, Github
- HTML5
- Okta, JsonWebToken
- Vue
- MaterializeCSS, SASS
- Cordova
- Openshift & Heroku 


# para eliminar el warning de no DTD especificada en la segunda linea, poner esta linea.
<!DOCTYPE xml> 

<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE xml>



# Matar proceso tomcat. Error: Address already in use.
Open terminal
netstat -aon | find "8080"
taskkill /pid 5388 /f

# aupair / APP for Au Pairs in Spring Boot Angular 4

This project seeks to set up a jumping off point for an Angular 4 and
Spring Boot project.

Additional tools that are involved are:

- Fluentlenium (Acceptance testing)
- Jasmine test framework
- Karma test runner
- Gradle NodeJS plugin (for executing NPM tasks via Gradle)

## Running the Application

```mvn
mvn spring-boot:run
```

## Executing the tests

> npmInstallGlobals needs to be run only once

## Spring Boot

> For 

## Maven

> Si se pasa de Gradle a Maven con Configure -> Convert to Maven Project, es necesario eliminar de .classpath esto para eliminar los errores de duplicidad de dependencias en la pestaña marker

	<classpathentry kind="con" path="org.eclipse.buildship.core.gradleclasspathcontainer">
		<attributes>
			<attribute name="org.eclipse.jst.component.dependency" value="/WEB-INF/lib"/>
		</attributes>
	</classpathentry>



# Cordova

- npm install -g cordova

## cordova create. Is necessary that the folder redirected has to be called as well "www"
- cordova create cordova com.sierrica.aupair AuPair --link-to=src/main/resources/public/www

## Plugins
- cd cordova
- cordova plugin add cordova-plugin-inappbrowser
- cordova plugin add cordova-plugin-console


## Add platform:
- cd cordova
- cordova platform add android
- cordova platform add browser
- cordova platform add ios

## Build for Android
- cd cordova
- cordova build android				necesario al menos una vez antes de la tarea Gulp








# Heroku
primero npm run web-heroku or npm run cordova-heroku
segundo subir a Github

## Login
- heroku login

## Instalar el plugin que permite desplegar war desde local. Desplegar desde Github no funciona
- heroku plugins:install heroku-cli-deploy

## Limpiar. Importante con errores.
- heroku buildpacks:clear -a aupairsierrica

## Desplegar war local con el CLI. Es necesario antes realizar un mvn clean verify para generar el WAR. Desde la carpeta target, ejecutar:
- heroku war:deploy target/ROOT.war --app aupairsierrica

## Añadir un dominio especifico. Es necesario introducir la tarjeta de credito!!!
- heroku domains:add aupair.sierrica.com --app aupairsierrica

## Variables de entorno
- heroku config:set PLATFORM="heroku" --app aupairsierrica




# Openshift
primero npm run web-openshift or npm run cordova-openshift
segundo generar war desde eclipse con Maven mvn:clean verify
tercero desde el dir target o donde esta el WAR

- oc login https://api.starter-ca-central-1.openshift.com
- oc new-project au-pair --description="AuPair APP" --display-name="AuPair"
- oc new-app -e POSTGRESQL_USER=sierrica -e POSTGRESQL_PASSWORD=tauste -e POSTGRESQL_DATABASE=aupair centos/postgresql-95-centos7

## Change de IP of database
- oc new-app -e PLATFORM=openshift NODE_ENV=production POSTGRESQL_URL=172.31.28.98 POSTGRESQL_USER=sierrica -e POSTGRESQL_PASSWORD=tauste -e POSTGRESQL_DATABASE=aupair registry.access.redhat.com/jboss-webserver-3/webserver31-tomcat8-openshift~https://github.com/sierrica/AuPair.git
- oc expose service aupair --name=aupair

## No funciona ya exponer con dominio custom con la version gratuita
- oc expose service aupair --name=aupair --hostname=aupair.sierrica.com


## Delete all of an application.
- oc delete all --all






# NameServers
## Godaddy
- ns35.domaincontrol.com
- ns36.domaincontrol.com

## Cloudflare
- merlin.ns.cloudflare.com
- rafe.ns.cloudflare.com

## Profreehost
- ns1.unaux.com
- ns2.unaux.com




# Errores
## Error en el config.xml de Cordova sutituir el nombre de una etiqueta por mayusculas:
- <preference name="loglevel" value="DEBUG" />
- <preference name="LogLevel" value="DEBUG" />






