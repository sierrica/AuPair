<template>
	<div class="container" style="max-width: 600px; margin-top:40px; min-height: 600px;">
			<div class="row">
				<div class="col s10 offset-s1 z-depth-4 ">
					<form class="login_form" v-on:submit.prevent="signup(user);">
						<div class="row">
							<div class="input-field col s12 center">
	          					<p class="center" v-html="$t('Signup.legend')"></p>
	        				</div>
	        				<p v-if="user.error" class="error" v-html="$t('Signup.error')"></p>
						</div>
						<div class="row">
							<div class="input-field col s12">
	          					<input type="email" id="email" name="email" v-model="user.email" v-on:input="change_input()" v-on:blur="blur_input()" class="validate">
	          					<label for="email" v-html="$t('Signup.email')"></label>
	        				</div>
						</div>
						<div class="row">
							<div class="input-field col s12">
	          					<input type="password" id="pass" name="pass" v-model="user.pass" v-on:input="change_input()" v-on:blur="blur_input()" class="validate">
	          					<label for="pass" v-html="$t('Signup.password')"></label>
	        				</div>
						</div>
						<div class="row">
							<div class="input-field col s12">
	          					<input type="checkbox" id="remember" name="remember" v-model="user.remember" class="validate">
	          					<label for="remember" v-html="$t('Signup.remember')"></label>
	        				</div>
						</div>
						<div class="row">
							<div class="input-field col s12">
								<button class="btn col s12 waves-effect waves-light pink" type="submit" name="action" v-html="$t('Signup.signup')"></button>
	        				</div>
	        				
						</div>
						<div class="row">
							<div class="input-field col s6 m6 l6">
           						 <p class="margin medium-small">
           						 	<router-link to="login" v-html="$t('Signup.signin')"></router-link>
           						 </p>
          					</div>
							<div class="input-field col s6 m6 l6">
              					<p class="margin right-align medium-small">
              						<a href="page-forgot-password.html" v-html="$t('Signup.forgot')"></a>
              					</p>
         					</div>
						</div>
					</form>
				</div>
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
    	
    	
		signup (user) {
    		if ( ! this.user.error) {
					console.log ()
	  				$.ajax({
	  					method: 'post',
	  					url: window.spring + '/signup',
	  					contentType: 'application/json',
	  					//dataType: 'json',
	  					data: JSON.stringify({"email": "prueba@example.com"}),
	  					/*   							firstName: "Nombre",
							lastName: "Apellido",
							password: "Taustemix8888",
							securityQuestion: "Nombre Padre",
							securityQuestionAnswer: "Jesus" */
	  					success: function(data) {
	  						console.log ("RESPUESTA ME: ");
	  			  		    console.log (data);
	  			  		    	
	  			  		},
			  	    	error: function(err) {
			  	      		console.log("ERROR")
			  	      		console.log(err)
			  	    	}
	  			   });
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