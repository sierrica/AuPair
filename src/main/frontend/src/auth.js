var $ = window.jQuery = require('jquery')
const OktaAuth = require('@okta/okta-auth-js')
var request = require('request')

var authClient;





var base64UrlToBase64 = function(b64u) {
	return b64u.replace(/\-/g, '+').replace(/_/g, '/');
};

var base64UrlToString = function(b64u) {
	  var b64 = base64UrlToBase64(b64u);
	  switch (b64.length % 4) {
	    case 0:
	      break;
	    case 2:
	      b64 += '==';
	      break;
	    case 3:
	      b64 += '=';
	      break;
	    default:
	      throw 'Not a valid Base64Url';
	  }
	  var utf8 = atob(b64);
	  try {
	    return decodeURIComponent(escape(utf8));
	  } catch (e) {
	    return utf8;
	  }
	};



export default {

	setAuthClient(data) {
		authClient = new OktaAuth(data);
	},
	getAuthClient() {
		return authClient;
  	},
	
  	login (email, pass, cb) {
	  	var that = this;
	  	authClient.signIn({
	  		username: email,
	  		password: pass
	  	}).then(response => {
	  		if (response.status === 'SUCCESS') {

	  			if (window.isCordovaApp) {
	  				var randomCharset = 'abcdefghijklnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789';
	  				var state = ''; var nonce = '';
	  				for (var c = 0, cl = randomCharset.length; c < 64; ++c) {
	  					state += randomCharset[Math.floor(Math.random() * cl)];
	  					nonce += randomCharset[Math.floor(Math.random() * cl)];
	  				}
	  				var oauthUrl = authClient.options.url + '/oauth2/default/v1/authorize?' +
		            'client_id=' + authClient.options.clientId + '&' +
		            'nonce=' + nonce + '&' +
		            'redirect_uri=' + encodeURI(authClient.options.redirectUri) + '&' +
		            'response_mode=' + 'fragment' + '&' +
		            'response_type=' + 'id_token%20token' + '&' +
		            'sessionToken=' + response.sessionToken + '&' +
		            'scope=' + 'openid%20email%20profile' + '&' +
		            'state=' + state;
        	 
	  				//alert('ANTES INAPPBROWSER. Peticion para obtencion de token: ' + oauthUrl)
	  				var browser = window.cordova.InAppBrowser.open(oauthUrl, '_blank', 'location=no,clearsessioncache=yes,clearcache=yes');
	  				browser.addEventListener('loadstart', (event) => {
	  					
	  					if (((event.url).indexOf(authClient.options.redirectUri) === 0)) {
			                 browser.removeEventListener('exit', () => {});
			                 browser.close();
			                 //alert('RESPUESTA DE OKTA CON EL ACCESS_TOKEN: ' + event.url)

			                // No funciona este metodo mas corto porque en Cordova no soporta document.cookie empleado en el metodo parseFromUrl. Hay que implementar el metodo parseFromUrl y handleOAuthResponse manualmente
			                /*authClient.token.parseFromUrl(event.url)
		                	 	.then(function(token) {
		                	 		alert('TOKEN ALMACENAR: ' + JSON.stringify(token))
				                	authClient.tokenManager.add('my_access_token', token['token']);
				                	authClient.tokenManager.add('my_id_token', token['id_token']);
				                	cb(true)

		                	 	}).fail(function(error) {
		                	 		alert ("FALLO EN LA VALIDACION DEL TOKEN CON OKTA")
		    			    		alert (error)
		    			    		cb(false)
		    			    });*/

			                 const responseParameters = ((event.url).split('#')[1]).split('&');
			                 const parsedResponse = {};
			                 for (let i = 0; i < responseParameters.length; i++)
			                   parsedResponse[responseParameters[i].split('=')[0]] = responseParameters[i].split('=')[1];
			                 
			                 if (parsedResponse['state'] !== state) {
			                	 alert('ERROR AUTENTINCACION OKTA. EL ESTADO DE LA CONTESTACION NO ES EL MISMO QUE SE ENVIA.')
			                	 cb(JSON.stringify(parsedResponse))
			                 }
			                 else if (parsedResponse['access_token'] !== undefined  &&  parsedResponse['access_token'] !== null  &&  parsedResponse['id_token'] !== undefined  &&  parsedResponse['id_token'] !== null) {
			                	 var jwt = authClient.token.decode(parsedResponse['id_token'])
			                	 var tokenDict = {};
			                	 
			                	 tokenDict['token'] = {
			                		 accessToken: parsedResponse['access_token'],
			                		 expiresAt: Number(parsedResponse['expires_in']) + Math.floor(Date.now()/1000),
			                		 tokenType: parsedResponse['token_type'],
			                		 scopes: 'openid email profile',
			                		 authorizeUrl: authClient.options.url + '/oauth2/default/v1/authorize',
			                		 userinfoUrl: authClient.options.url + '/oauth2/default/v1/userinfo'
			                	 };
			                	 tokenDict['id_token'] = {
			                		 idToken: parsedResponse['id_token'],
			                		 claims: jwt.payload,
			                		 expiresAt: jwt.payload.exp,
			                		 scopes: 'openid email profile',
			                		 authorizeUrl: authClient.options.url + '/oauth2/default/v1/authorize',
			                		 issuer: authClient.options.issuer,
			                		 clientId: authClient.options.clientId
			                	 };

			                	 authClient.token.verify(tokenDict['id_token'], nonce, true)
			                	 	.then(function(token) {
			                	 		//alert('TOKEN ALMACENAR: ' + JSON.stringify(tokenDict))
			                	 		tokenDict['id_token'] = token;
					                	authClient.tokenManager.add('my_access_token', tokenDict['token']);
					                	authClient.tokenManager.add('my_id_token', tokenDict['id_token']);
					                	cb(true)

			                	 	}).fail(function(error) {
			                	 		alert ("FALLO EN LA VALIDACION DEL TOKEN CON OKTA")
			    			    		alert (error)
			    			    		cb(false)
			    			    	});
			                 }
			                 else {
			                	alert('ERROR DESCONOCIDO AUTENTINCACION OKTA. EL ESTADO DE LA CONTESTACION NO ES EL MISMO QUE SE ENVIA.')
			                	cb(event.url)
			                 }
		            	 }
	  				});
        	 
		             browser.addEventListener('exit', function (event) {
		            	 //alert('SALIENDO DEL EXIT DEL EVENTO ')
		             });
	  			}
	  			// No Cordova
	  			else {
			    	authClient.token.getWithoutPrompt({
			            responseType: ['id_token', 'token'],
			            scopes: ['openid', 'email', 'profile'],
			            sessionToken: response.sessionToken
			    	}).then(tokens => {
			    		authClient.tokenManager.add('my_id_token', tokens[0]);
			    		authClient.tokenManager.add('my_access_token', tokens[1]);
			    		cb(true)
			    	}).fail(err => {
			    		alert ("EN EL ELSE DEL TOKEN DE OKTA")
			    		cb(JSON.stringify(err))
			    	});
	  			}
	  		}
	  		else {
	  			//alert ("EN EL ELSE DEL LOGUIN DE OKTA")
	  		    cb(response)
	  		}
	  	}).fail(err => {
	  		//console.log ("EN EL FAIL DEL LOGUIN DE OKTA")
	  		(err.message == 'Authentication failed')   ?   cb ('401')   :   cb (err);
	  	});
    },


    getToken () {
    	return authClient.tokenManager.get('my_access_token')
    },

    logout (cb) {
    	if (cb)
    		cb()
    	this.onChange(false)
    	return authClient.signOut();
    },

    loggedIn () {
    	return !!authClient.tokenManager.get('my_access_token')
		/*authClient.session.exists().then(function(exists) {
			cb(exists)
		 });*/
    },
  
    getEmail () {
    	return authClient.tokenManager.get('my_id_token').claims.email;
    },
    getUsername () {
    	return authClient.tokenManager.get('my_id_token').claims.preferred_username;
  }
}
