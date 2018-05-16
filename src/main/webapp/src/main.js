/* CSS */

import 'materialize-css/dist/css/materialize.css'
//import 'ionicons/dist/css/ionicons.css'
import 'font-awesome/css/font-awesome.css'
import 'material-design-icons/iconfont/material-icons.css'
//import 'flag-icon-css/css/flag-icon.css'

import 'select2/dist/css/select2.css'
import 'select2/dist/js/select2.js'


import 'perfect-scrollbar/css/perfect-scrollbar.css'
import 'normalize.css/normalize.css'


/* JS */
window.jQuery = require("jquery");
window.$ = require("jquery");
import 'materialize-css/dist/js/materialize.js'
import PerfectScrollbar from 'perfect-scrollbar/dist/perfect-scrollbar.js'


window._ = require('lodash')
import Vue from 'vue'
import App from './App'
import router from './router'
import auth from './auth'


//import messagesEs from './locale/validator/messages/ar.js'


import VueI18n from 'vue-i18n';
import messages from '@/locale';
Vue.use(VueI18n);

import VeeValidate, { Validator } from 'vee-validate';
import messagesES from 'vee-validate/dist/locale/es';



//import {VueSelect} from 'vue-select';
//Vue.component('v-select', VueSelect.VueSelect)


//Validator.addLocale('es', messagesES);
Vue.use(VeeValidate);
//Vue.use(VeeValidate, {
//	  locale: 'es',
//	  dictionary: {
//	    en: { messages: messagesEn },
//	    es: { messages: messagesEs }
//	  }
//	});



var app = {
	initialize: function () {
		if (window.isCordovaApp)
			document.addEventListener('deviceready', this.onDeviceReady, false)
		 
		var that = this;
		
		$.ajax({
			url: window.backendUrl + '/credentials',
			method: 'get',
			//dataType: 'text',
			//dataType: 'json',
			dataType: 'text json' 	// recibe text y jquery lo interpreta como JSON(Lo parsea automaticamente el string con JSON.parse())
		}).always(function(data_jqXHR, textStatus, jqXHR_errorThrown) {
	        if (textStatus === 'success')
	            var jqXHR = jqXHR_errorThrown;
	        else
	            var jqXHR = data_jqXHR;
	        switch (jqXHR.status) {
	            case 200:
					console.log ("RESPUESTA GETWID: ");
					console.log (data_jqXHR);
			      	window.tokenProvider = data_jqXHR.tokenProvider;
			      	if (window.tokenProvider == 'okta')
			      		auth.setAuthClient(data_jqXHR);
			      	that.setupVue();
			      	break;
	            default:
	            	alert("LOGIN ERROR SPRING /credentials: " + jqXHR_errorThrown);
	                break;
	        }
		});

	},
	onDeviceReady: function () {
		//alert('CORDOVA CARGADO')
	},
	setupVue: function () {
		new Vue({
			el: '#app',
			router,
			template: '<App/>',
			components: { App },
			i18n: new VueI18n({
			  	locale: navigator.language.substr(0, 2) || navigator.userLanguage.substr(0, 2),
			  	fallbackLocale: 'en',
			  	nsSeparator: false,
			  	keySeparator: false,
			  	fallbackLng: false,
			  	silentTranslationWarn: true,
			  	messages

//			  	interpolation: {
//			        escapeValue: false,
//			        formatSeparator: ',',
//			        format: function(value, format, lng) {
//			        	if (format === 'uppercase')
//			        		return value.toUpperCase();
//			        	return value;
//			        }
//			    }
			}),
			beforeCreate: function() {
			},
			created: function() {
				//alert('VUE CARGADO: ' + process.env.NODE_ENV)
				$(document).ready(function() {
					setTimeout(function() {
						$('.preloader-wrapper').css('display', 'none')
	  		  	  	  	$('header, main, footer').css({'transition':  'opacity .5s ease-in-out', 'opacity': '1'})
					}, 500)
				});
			}
		})
  	}
}

app.initialize()
