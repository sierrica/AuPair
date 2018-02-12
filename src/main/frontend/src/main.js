/* CSS */

import 'materialize-css/dist/css/materialize.css'
//import 'ionicons/dist/css/ionicons.css'
import 'font-awesome/css/font-awesome.css'
import 'material-design-icons/iconfont/material-icons.css'


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


import VueI18n from 'vue-i18n';
import messages from '@/locale';
Vue.use(VueI18n);


var app = {
	initialize: function () {
		if (window.isCordovaApp)
			document.addEventListener('deviceready', this.onDeviceReady, false)
		 
		var that = this;
		$.ajax(window.spring + '/credentials', {
  		    success: function(data) {
  		      	console.log ("RESPUESTA GETWID: ");
  		      	console.log (data);
  		      	//data.clientId = data.client_id;
  		        //data.redirectUri = data.redirect_uri;
  		      	
  		      	auth.setAuthClient(JSON.parse(data));
  		      	that.setupVue();
  		  	},
  	    	error: function(err) {
  	      		alert("LOGIN ERROR SPRING /credentials: " + err)
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
			  		locale: 'en',
			  		fallbackLocale: 'en',
			  		messages,
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
