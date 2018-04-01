<template>
	<div class="container" style="max-width: 600px; margin-top:40px; min-height: 600px;">
			<div class="row">
				<div class="col s10 offset-s1 z-depth-4 ">
					<form class="login_form" v-on:submit.prevent="login(user);">
						<div class="row">
							<div class="input-field col s12 center">
	          					<p class="center" v-html="$t('Signin.legend')"></p>
	        				</div>
	        				<p v-if="user.error" class="error" v-html="$t('Signin.error')"></p>
						</div>
						<div class="row">
							<div class="input-field col s12">
	          					<input id="email" type="email" v-model="user.email" v-on:input="change_input()" v-on:blur="blur_input()" class="validate">
	          					<label for="email" v-html="$t('Signin.email')"></label>
	        				</div>
						</div>
						<div class="row">
							<div class="input-field col s12">
	          					<input id="pass" type="password" v-model="user.pass" v-on:input="change_input()" v-on:blur="blur_input()" class="validate">
	          					<label for="pass" v-html="$t('Signin.password')"></label>
	        				</div>
						</div>
						<div class="row">
							<div class="input-field col s12">
	          					<input id="remember" type="checkbox" v-model="user.remember" class="validate">
	          					<label for="remember" v-html="$t('Signin.remember')"></label>
	        				</div>
						</div>
						<div class="row">
							<div class="input-field col s12">
								<button class="btn col s12 waves-effect waves-light pink" type="submit" name="action" v-html="$t('Signin.signin')"></button>
	        				</div>
	        				
						</div>
						<div class="row">
							<div class="input-field col s6 m6 l6">
           						 <p class="margin medium-small">
           						 <router-link to="signup" v-html="$t('Signin.register')"></router-link>
           						 </p>
          					</div>
							<div class="input-field col s6 m6 l6">
              					<p class="margin right-align medium-small">
              						<a href="page-forgot-password.html" v-html="$t('Signin.forgot')"></a>
              					</p>
         					</div>
						</div>
					</form>
				</div>
			</div>
		</div>

</template>

<script>
import auth from '../auth'
  
export default {
	data () {
		return {
			user: {
				email: null,
				pass: null,
				remember: false,
				error: false
			}
		}
    },
    methods: {
    	blur_input () {
    		if (this.user.error)
    			$('#email, #pass').addClass('invalid');

    	},
    	change_input () {
    		$('#email, #pass').removeClass('invalid');
    		this.user.error = false;
    	},
    	
		login (user) {
    		if ( ! this.user.error) {
	        	auth.login(this.user.email, this.user.pass, loggedIn => {
	          		if (loggedIn == true) {
	          			Materialize.toast ('<span v-html="$t(\'Login.success\')"></span>', 5000, 'green');
	            		
	          			
	          			
	          			$.ajax(window.spring + '/mod', {
	          				headers: {
	      						'Authorization': "Bearer " + auth.getAuthClient().tokenManager.get('my_access_token').accessToken
	      					}, 
	          	  		    success: function(data) {
	          	  		      	console.log ("RESPUESTA ME: ");
	          	  		    	console.log (data);

	          	  		  	},
	          	  	    	error: function(err) {
	          	  	      		console.log("ERROR")
	          	  	      		console.log(err)
	          	  	    	}
	          	  		});
	          			
	          			
	          			
	          			alert ("LOGIN SUCCESSFUL")
	          			this.$router.push('/dashboard');
	          		}
	          		else {
	          			if (loggedIn == '401') {
		          			this.user.error = true;
		          			$("#email, #pass").addClass('invalid');
		          			Materialize.toast ('<span>Usuario o Contrasena erroneo</span>', 5000, 'red');
	          			}
	          			else {
	          				//alert ("ERROR DESCONOCIDO OKTA");
	          				//alert (loggedIn);
	          				console.log("ERROR DESCONOCIDO OKTA");
	          				Materialize.toast ('<span>ERROR CON OKTA, PONGASE EN CONTACTO CON EL ADMINISTRADOR</span>', 5000, 'red');
	          			}
	          		}
	        	})
    		}
      	}
    }
}
</script>

<style scoped>

	.error {
		color: red;
	}
</style>