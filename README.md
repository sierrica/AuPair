queda pendiente la actualizacion a webpack 4 porque da un error de compilacion. dev-server funciona correctamente poniendo el --mode development antes de la ejecucion de webpack pero cuando voy a compilar da error. supongo que porque en el javascript que invoco build.js no especifico la variable --mode production en ningun momento.
es necesario actalizar optimize-css-assets-webpack-plugin, webpack-dev-server y webpack al mismo tiempo.
Ademas es necesario instalar tambien 2.0.10.



# Encriptar
jasypt/bin\encrypt.bat algorithm=PBEWithMD5AndDES password=PASS input="INPUT"



# AuPair Web App
App for AuPairs

# Okta company
```
sierrica-dev-621930
https://dev-621930.oktapreview.com/login/login.htm
```

## Built With
* Java Spring Boot
* PostgreSQL, JDBC, Hibernate/JPA
* Maven, Gradle
* JUnit, Mockito
* Git, Github
* OAuth2, JWT, Okta/Stormpath, Jasypt
* Logback, Slf4j, Papertrail
* jackson, lombok 
* HTML5
* MaterializeCSS, SASS
* Vue, jQuery
* Webpack
* Cordova
* Apache Tomcat
* Openshift & Heroku
* CloudFlare



## Getting Started




## Running the Application
```
mvn spring-boot:run
```

## Executing the tests
```
mvn spring-boot:run
```



## Heroku
>### Login
```
heroku login
```

>### Instalar el plugin que permite desplegar war desde local. Desplegar desde Github no funciona
```
heroku plugins:install heroku-cli-deploy
```

>### Limpiar. Importante con errores.
```
heroku buildpacks:clear -a aupairsierrica
```

>### Variables de entorno
```
heroku config:set PLATFORM="heroku" --app aupairsierrica
```

>### Añadir un dominio especifico. Es necesario introducir la tarjeta de credito!!!
```
heroku domains:add aupair.sierrica.com --app aupairsierrica
```

>### Desplegar war local con el CLI. Es necesario antes realizar un mvn clean verify para generar el WAR. Ademas es necesario estar no detras de un proxy sino da error (java.net.SocketException), no vale poner como NAT en la VM, es necesario estar en la red fisica. Desde la carpeta target, ejecutar:
```
heroku war:deploy target/ROOT.war --app aupairsierrica
```

## Openshift
>### Login.
```
oc login https://api.starter-ca-central-1.openshift.com
```


oc get pods
oc rsh <pod>

Dir donde se ubican los logs
/home/jboss


>### Delete all of an application.
```
oc delete all --all
```

>### Create a new Proyect. Delete all not eliminate the proyect. Could do error. Dont worry that means that already exist
```
oc new-project au-pair --description="AuPair APP" --display-name="AuPair"
```

>### Create DATABASE
```
oc new-app -e POSTGRESQL_USER=sierrica -e POSTGRESQL_PASSWORD=tauste -e POSTGRESQL_ADMIN_PASSWORD=taustemix -e POSTGRESQL_DATABASE=aupair centos/postgresql-96-centos7
```


>### Create APP. Change de IP of database
```
oc new-app -e PLATFORM=openshift NODE_ENV=production JASYPT_PASSWORD=tauste POSTGRESQL_URL=10.130.27.223 POSTGRESQL_USER=sierrica -e POSTGRESQL_PASSWORD=tauste -e POSTGRESQL_DATABASE=aupair registry.access.redhat.com/jboss-webserver-3/webserver31-tomcat8-openshift~https://github.com/sierrica/AuPair.git
```

>### Expose route
```
oc expose service aupair --name=aupair
```

>### No funciona ya exponer con dominio custom con la version gratuita
```
oc expose service aupair --name=aupair --hostname=aupair.sierrica.com
```


## Cordova
>### Install cordova global
```
- npm install -g cordova
```

>### Cordova create. Is necessary that the folder redirected has to be called as well "www"
```
cordova create cordova com.sierrica.aupair AuPair --link-to=src/main/resources/public/www
```

>### Plugins
```
cd cordova
cordova plugin add cordova-plugin-inappbrowser

```

>### Add platform
```
cd cordova
cordova platform add android
cordova platform add browser
cordova platform add ios
```

>### Build for Android
```cd cordova
cordova build android
```


## NameServers
### Godaddy
```
ns35.domaincontrol.com
ns36.domaincontrol.com
```

### Cloudflare
```
merlin.ns.cloudflare.com
rafe.ns.cloudflare.com
```

### Profreehost
```
ns1.unaux.com
ns2.unaux.com
```


## ERRORS
>### Error oaut2 devtools actuator
@EnableAuthorizationServer  // Solo se utiliza por querer asegurar actuator management.security.enabled=true,  okta-spring-security-starter 0.1.0 y devtools
Por ahora seguir utilizando okta-spring-security-starter 0.1.0 por el error con Devtools y dejar management.security.enabled=false para poder ver la informacion

>### Error lombook no reconocido en Eclipse.
Instalar el java desde un CMD(admin )Hacer un Maven Update y esperar un poco. Si eso no funciona añadir el Jar al proyecto y luego quitarlo porque he comprobado que no es necesario, solo el instalarlo en el dir de Eclipse
```
java -jar lombok.jar install <path of where your IDE is installed>
java -jar lombok.jar install ..\..\eclipse\jee-oxygen\eclipse
```

### Error que no encuentra la libreria plperl.dll en windows cuando se pretende ejecutar procedures Perl en PostgreSQL.
1. Instalar postgreSQL 10 con las devops opcion.
2. Acceder a la url del webadmin devops: http://localhost:8051/#/components/view   (Seccion PostgreSQL -> Package Manager)
3. Instalar el paquete Perl5
4.- Reinicial el servicio PostgreSQL o reiniciar windows.

>### Error en el config.xml de Cordova sutituir el nombre de una etiqueta por mayusculas:
```
<preference name="loglevel" value="DEBUG" />
```

>### Maven
Si se pasa de Gradle a Maven con Configure -> Convert to Maven Project, es necesario eliminar de .classpath esto para eliminar los errores de duplicidad de dependencias en la pestaña marker

```
<classpathentry kind="con" path="org.eclipse.buildship.core.gradleclasspathcontainer">
	<attributes>
		<attribute name="org.eclipse.jst.component.dependency" value="/WEB-INF/lib"/>
	</attributes>
</classpathentry>
```
Si aparece errror Class path contains multiple SLF4J bindings, borrar el directorio ```.gradle/caches``` con las librerias
Si aparece un error de que no encuentra la clase principal al arrancar en modo Spring Boot, ejecutar primero como Maven y luego ya deja

>### Matar proceso tomcat. Error: Address already in use
Open cmd
```
netstat -aon | find "8080"
taskkill /pid 5388 /f
```


## Meta
Javier Sierra – [sierrica](https://twitter.com/sierrica_tauste) – sierrica@hotmail.com
Distributed under the XYZ license. See ``LICENSE`` for more information.
[https://github.com/sierrica/Aupair-link](https://github.com/sierrica/)


## Contributing


## Cosas a mirar
* Probar @okta/okta-vue en lugar @okta/okta-auth-js


