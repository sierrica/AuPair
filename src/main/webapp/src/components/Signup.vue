<template>
	<div class="container" style="max-width: 600px; margin-top:40px; min-height: 600px;">
			<div class="row">
				<div class="col s10 offset-s1 z-depth-4 ">
					<form class="login_form" v-on:submit.prevent="signup(user);">
						<div class="row">
							<div class="input-field col s12 center">
	          					<p class="center" v-html="$t('Signup.legend')"></p>
	        				</div>
	        				<p id="legendError" v-show="user.error" class="error"></p>
						</div>
						<div class="row">
							<div class="input-field col s12">
	          					<i class="material-icons prefix">mail_outline</i>
	          					<input type="email" id="email" name="email" v-model="user.email" data-vv-as="email" data-vv-delay="1000" v-validate="'required|email'" :class="{'valid': fields.email  && fields.email.dirty  &&  ! errors.has('email'), 'invalid': errors.has('email') }">
	          					<label for="email" v-html="$t('Signup.email')"></label>
	          					<span v-show="errors.has('email')" class="error">{{ errors.first('email') }}</span>
	        				</div>
						</div>
						<div class="row">
							<div class="input-field col s12">
								<i class="material-icons prefix">lock</i>
	          					<input type="password" id="password" name="password" v-model="user.password" required pattern="^(?=.*[a-z])(?=.*[A-Z])(?=.*[0-9])(?=.{8,})" title="Username should only contain lowercase letters. e.g. john" data-vv-as="password" data-vv-delay="1000" v-validate="{ rules: { required:true, regex:/^(?=.*[a-z])(?=.*[A-Z])(?=.*[0-9])(?=.{8,})/}}" :class="{'valid': user.password!=null  &&  ! errors.has('password'), 'invalid': errors.has('password') }">
	          					<label for="password" v-html="$t('Signup.password')"></label>
	          					<span v-show="errors.has('password')" class="error">{{ errors.first('password') }}</span>
	        				</div>
						</div>
						<div class="row">
							<div class="input-field col s12">
								<i class="material-icons prefix">lock</i>
	          					<input type="password" id="passwordConfirmation" name="passwordConfirmation" data-vv-as="passwordConfirmation" data-vv-delay="4000" v-validate="'required|confirmed:password'" :class="{'valid': fields.passwordConfirmation  && fields.passwordConfirmation.dirty  &&  ! errors.has('passwordConfirmation'),      'invalid': fields.passwordConfirmation  && fields.passwordConfirmation.dirty  &&  errors.has('passwordConfirmation') }">
	          					<label for="passwordConfirmation" v-html="$t('Signup.passwordConfirmation')"></label>
	          					<span v-show="fields.passwordConfirmation  && fields.passwordConfirmation.dirty  &&  errors.has('passwordConfirmation')" class="error">{{ errors.first('passwordConfirmation') }}</span>
	        				</div>
						</div>
						
						<div class="row">
							<div class="input-field col s12">
	          					<input type="text" id="firstName" name="firstName" v-model="user.firstName" required data-vv-as="firstName" data-vv-delay="1000" v-validate="'required'" :class="{'valid': fields.firstName  && fields.firstName.dirty  &&  ! errors.has('firstName'),      'invalid': fields.firstName  && fields.firstName.dirty  &&  errors.has('firstName') }">
	          					<label for="firstName" v-html="$t('Signup.firstName')"></label>
	          					<span v-show="fields.firstName  && fields.firstName.dirty  &&  errors.has('firstName')" class="error">{{ errors.first('firstName') }}</span>
	        				</div>
						</div>
						
						<div class="row">
							<div class="input-field col s12">
	          					<input type="text" id="lastName" name="lastName" v-model="user.lastName" required data-vv-as="lastName" data-vv-delay="1000" v-validate="'required'" :class="{'valid': fields.lastName  && fields.lastName.dirty  &&  ! errors.has('lastName'),      'invalid': fields.lastName  && fields.lastName.dirty  &&  errors.has('lastName') }">
	          					<label for="lastName" v-html="$t('Signup.lastName')"></label>
	          					<span v-show="fields.lastName  && fields.lastName.dirty  &&  errors.has('lastName')" class="error">{{ errors.first('lastName') }}</span>
	        				</div>
						</div>
						

						
						
						<div class="row">
							<div class="input-field col s12">
	          					<input type="text" id="securityQuestion" name="securityQuestion" data-vv-delay="1000" v-validate="'required'" :class="{'valid': fields.securityQuestion  && fields.securityQuestion.dirty  &&  ! errors.has('securityQuestion'),      'invalid': fields.securityQuestion  && fields.securityQuestion.dirty  &&  errors.has('securityQuestion') }">
	          					<label for="securityQuestion" v-html="$t('Signup.securityQuestion')"></label>
	          					<span v-show="fields.securityQuestion  && fields.securityQuestion.dirty  &&  errors.has('securityQuestion')" class="error">{{ errors.first('securityQuestion') }}</span>
	        				</div>
						</div>
						<div class="row">
							<div class="input-field col s12">
	          					<input type="text" id="securityQuestionAnswer" name="securityQuestionAnswer" data-vv-delay="1000" v-validate="'required'" :class="{'valid': fields.securityQuestionAnswer  && fields.securityQuestionAnswer.dirty  &&  ! errors.has('securityQuestionAnswer'),      'invalid': fields.securityQuestionAnswer  && fields.securityQuestionAnswer.dirty  &&  errors.has('securityQuestionAnswer') }">
	          					<label for="securityQuestionAnswer" v-html="$t('Signup.securityQuestionAnswer')"></label>
	          					<span v-show="fields.securityQuestionAnswer  && fields.securityQuestionAnswer.dirty  &&  errors.has('securityQuestionAnswer')" class="error">{{ errors.first('securityQuestionAnswer') }}</span>
	        				</div>
						</div>

						<div class="row" style="min-height:70px;">
							<div class="input-field col s12">
								<!-- <vue-select :options="locales" label="countryName">
								    <template slot="option" slot-scope="option">
								        <i class="material-icons">mail_outline</i>{{ option.countryName }}
								    </template>
								</vue-select> -->
								
								
								<select>
      								<option value="en" v-html="$t('Signup.english')"></option>
      								<option value="es" v-html="$t('Signup.spanish')"></option>
    							</select>
    							<label>Materialize Select</label>
								
								
								
								
								
								<!-- <label for="id_label_single" v-html="$t('Signup.locale')"> -->
	    							<!-- <label for="locale" v-html="$t('Signup.locale')"></label>
		    							
		    							<select id="locale" name="locale" v-model="user.locale" style="height: 100px !important;">
		      								<i class="material-icons prefix">mail_outline</i><option value="en" v-html="$t('Signup.english')"><span class="flag-icon flag-icon-gr"></span></option>
		      								<option value="es" v-html="$t('Signup.spanish')"></option>
		    							</select> -->
	    							
    							<!-- </label> -->
    							
    							
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
								<button type="submit" :disabled="errors.any() || !isCompleted" v-html="$t('Signup.signup')" class="btn col s12 waves-effect waves-light pink"></button>
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

<style scoped>
	.input-field i.material-icons.prefix {
		font-size: 3rem;
		top: 5px;
	}
	i.material-icons.prefix + input {
		margin-left: 60px;
		width: calc(100% - 5rem);
	}
	i.material-icons.prefix + input + label {
		left: 2rem;
	}
	i.material-icons.prefix + input + label + span {
		margin-left: 4rem;
	}




	.error {
		color: red;
	}

	
	
	.select2-container--material {
    	width: 100% !important;
    }
    .select2-container--material::placeholder {
        color: inherit;
    }

    /**
     * Textbox
     */
    
    .select2-selection {
        /* @extend input */
        overflow: visible;
        
        font: inherit;
        
        touch-action: manipulation;
        
        margin: 0;
        line-height: inherit;
        border-radius: 0;
        
        box-sizing: inherit;
        
        /* @extend .form-control */
        display: block;
        
        width: 100%;
        color: #55595c;
        background-clip: padding-box;
        border: 1px solid rgba(0,0,0,.15);
        
        padding: .5rem 0 .6rem;
        font-size: 1rem;
        line-height: 1.5;
        background-color: transparent;
        background-image: none;
        border-radius: 0;
        margin-top: .2rem;
        margin-bottom: 1rem;
        
        /* @extend input[type=text] */
        background-color: transparent;
        border: none;
        border-bottom: 1px solid #ccc;
        border-radius: 0;
        outline: 0;
        //height: 2.1rem;
        width: 100%;
        font-size: 1rem;
        box-shadow: none;
        transition: all .3s;
        
        min-height: 2.1rem;
    }
    
    .select2-selection .select2-selection__rendered {
    	padding-left: 0;
    }
    
    
    .select2-selection--single .select2-selection__rendered {
            float: left;
	}
        
    .select2-selection--single .select2-selection__arrow {
		float: right;
    }

    
    .select2-search--inline .select2-search__field {
            width: 100%;
            margin-top: 0;
            
            /* Match input[type=text] */
            height: 34px;
            line-height: 1;
    }
    
    
    
    /**
     * Dropdown
     */
    
    .select2-dropdown  {
        border: 0;
    }

    
    .select2-results__options {
        /* @extend .zf-shadow-depth* */
        box-shadow: 0 2px 5px 0 rgba(0,0,0,.16),0 2px 10px 0 rgba(0,0,0,.12);
        
        /* @extend .dropdown-content */
        background-color: #fff;
        margin: 0;
        //display: none;
        min-width: 100px;
        max-height: 650px;
        overflow-y: auto;
        //opacity: 0;
        //position: absolute;
        z-index: 999;
        will-change: width,height;
    }
    
    
    
    /**
     * Options
     */
    
    .select2-results__option {
        /* @extend .dropdown-content li */
        cursor: pointer;
        
        clear: both;
        color: rgba(0,0,0,.87);
        line-height: 1.5rem;
        //width: 100%;
        text-align: left;
        text-transform: none;
        
        /* @extend .dropdown-content li>a, .dropdown-content li>span */
        font-size: 1.2rem;
        //color: #4285F4;
        display: block;
        padding: 1rem;
        
        /**
         * Disabled options
         */
     }
        .select2-results__option[aria-disabled=true] {
            /* @extend .select-dropdown li.disabled */
            color: rgba(0,0,0,.3);
            background-color: transparent!important;
            cursor: context-menu;
            
            /* @extend .disabled */
            cursor: not-allowed;
        }
        
        /**
         * Selected option
         */
        .select2-results__option[aria-selected=true] {
            /* @extend .dropdown-content li:active, .dropdow-content li:hover */
            color: #4285f4;
            
            background-color: #eee;
        }
        
        /**
         * Active/hovered option
         */
        .select2-results__option--highlighted[aria-selected] {
            background-color: #ddd;
        }

    
    
    
    /**
     * Focused textbox
     */
    
    .select2-container--focus .select2-selection {

            /* @extend input[type=text]:focus */
            border-bottom: 1px solid #4285f4;
            box-shadow: 0 1px 0 0 #4585f4;

    }
    
    
    
    /**
     * Disabled textbox
     */
    
    .select2-container--disabled .select2-selection {
            /* @extend .select-wrapper input.select-dropdown:disabled */
            color: rgba(0,0,0,.3);
            cursor: default;
            user-select: none;
            border-bottom: 1px solid rgba(0,0,0,.3);
     }
        
     .select2-container--disabled .select2-container--focus .select2-selection {
     	box-shadow: none;
     }






</style>

<script scoped>
import he from 'he'
import auth from '../auth'





export default {
	beforeCreate: function () {
		var lang = this.$i18n.locale;
		import(`vee-validate/dist/locale/${lang}`).then(dictionary => {
			import(`../locale/${lang}/Signup.json`).then(i18n => {
				this.$validator.localize(lang, dictionary);
				var jsonDecoded = JSON.parse(he.decode(JSON.stringify(i18n.validate)));
				this.$validator.localize(lang, { "custom": jsonDecoded });
			})
		})
		
	},
	mounted: function () {
		//$('#locale').material_select();
		$('#locale').select2({
			//theme: 'material',
			width: '100%',
			placeholder: this.$t('Signup.locale'),
			minimumResultsForSearch: Infinity,
			templateResult: function (state) {
				console.log ("STATEEEEEE")
				console.log (state)
				return $('<span><i class="material-icons prefix">lock</i>' + state.text + '</span>');
								
			}
		});
		
		//$(".select2-selection__arrow").addClass("material-icons").html("arrow_drop_down");
		
		$('#locale').val(this.$i18n.locale);
		//$('#locale span.select2').css({'margin-top': '30px'});
	},
	computed: {
		isCompleted () {
			return this.user.email && this.user.password && this.user.passwordConfirmation && this.user.firstName && this.user.lastName && this.user.securityQuestion && this.user.securityQuestionAnswer;
		}
	},
	data () {
		return {
			/* locales: [{
				countryCode: "en",
			    //countryName: this.$t('Signup.english')
			    countryName: 'english'
			},{
			 	countryCode: "es",
			    //countryName: this.$t('Signup.spanish')
			 	countryName: 'spanish'
			}], */
			user: {
				email: null,
				password: null,
				passwordConfirmation: null,
				firstName: null,
				lastName: null,
				securityQuestion: null,
				securityQuestionAnswer: null,
				locale: this.$i18n.locale,
				remember: false,
				error: false
			}
		}
    },
    methods: {
    	blur_input (event) {
    		/* console.log ($(event.target).hasClass('valid'))
    		console.log ($(event.target).hasClass('invalid')) */
    		console.log (this.errors);
/*       		if (this.user.error)
    			$(event.target).addClass('invalid'); */

    	},
    	change_input (event) {
/*     		if (this.user.error   &&   $(event.target).hasClass('invalid')) {
    			this.user.error = false;
	    		$(event.target).removeClass('invalid');
	    		$("button[type='submit']").prop("disabled",false);
    		} */
    	},
    	
		signup (user) {
    		console.log ("USUARIO")
    		console.log (this.user)
    		if ( ! this.user.error) {
					//this.user.email = "prueba@example.com";
					//this.user.locale = "es";
					//this.user.password = "Taustemix8888";
					//this.user.firstName = "Jesus";
					//this.user.lastName = "Sierra";
					//this.user.securityQuestion = "Jesus";
					//this.user.securityQuestionAnswer = "Maria";
	  				console.log ("DATOS A ENVIAR")
	  				console.log (this.user)
					
	  				var that = this;
	  				$.post({
						url: window.spring + '/signup',
	  					contentType: 'application/json',
	  					dataType: 'text json',
	  					data: JSON.stringify(this.user)
					}).always(function(data_jqXHR, textStatus, jqXHR_errorThrown) {
				        if (textStatus === 'success')
				            var jqXHR = jqXHR_errorThrown;
				        else
				            var jqXHR = data_jqXHR;
				        switch (jqXHR.status) {
				            case 201:
								console.log ("CREADO USUARIO");
								console.log (data_jqXHR);
						      	break;
				            case 400:
								console.log ("ERROR CONTROLADO CREACION USUARIO");
								console.log (data_jqXHR);
								console.log (textStatus);
								console.log (data_jqXHR.responseJSON.message);
								
								if (data_jqXHR.responseJSON.message == 'userAlreadyRegistered')
									$("#email").removeClass('valid').addClass('invalid');
								else if (data_jqXHR.responseJSON.message == 'passwordNotValid')
									$("#password").removeClass('valid').addClass('invalid');
/* 								else if (data_jqXHR.responseJSON.message == 'answerPartQuestion')
									$("#email").addClass('invalid'); */

								$("button[type='submit']").prop("disabled",true);
								$('#legendError').html(that.$t('Signup.error.' + data_jqXHR.responseJSON.message));
				            	Materialize.toast ('<span>' + that.$t('Signup.error.' + data_jqXHR.responseJSON.message) + '</span>', 5000, 'red');
				            	that.user.error = true;
						      	break;
				            default:
				            	console.log("ERROR DESCONOCIDO CREACION USUARIO");
				            	console.log(data_jqXHR);
				            	console.log("ERROR CREAR USUARIO2");
				            	console.log(jqXHR_errorThrown);
				                break;
				        }
					});

	        }
      	}
    }
}
</script>
