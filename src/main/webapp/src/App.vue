<template>
	<div id="app">

		<header>
			<topnav></topnav>
		</header>

		<main id="main2" style="height: 95vh">
			<sidenav id="sidenav"></sidenav>
			<content id="content">
				<router-view></router-view>
			</content>
		</main>
		
		<!-- <footer>
			<foot></foot>
		</footer> -->



	<!--<template v-if="$route.matched.length">
     			<router-view></router-view>
   		</template>
   		<template v-else>
     			<p>You are logged {{ loggedIn ? 'in' : 'out' }}</p>
   		</template>  -->


	<!-- <h1>Auth Flow</h1>
		<ul>
      		<li>
      			<div v-on:click="myFunction()">PRUEBA3</div>
        		<router-link v-if="loggedIn" to="/logout">Log out</router-link>
        		<router-link v-if="!loggedIn" to="/login">Log in</router-link>
      		</li>
      		<li>
        		<router-link to="/about">About</router-link>
      		</li>
      		<li>
        		<router-link to="/dashboard">Dashboard</router-link>
        		(authenticated)
      		</li>
    	</ul>
   		<template v-if="$route.matched.length">
     			<router-view></router-view>
   		</template>
   		<template v-else>
     			<p>You are logged {{ loggedIn ? 'in' : 'out' }}</p>
   		</template>
    		 -->
	</div>
</template>





<!-- ****************************************                JAVASCRIPT                ************************************************* -->
<script>
import auth from './auth'

var $ = require('jquery')
import PerfectScrollbar from 'perfect-scrollbar/dist/perfect-scrollbar.js'



export default {
	methods: {
  		myFunction() {

   		}
	},
  
	/*data () {
    	return {
      		loggedIn: auth.loggedIn()
    	}
  	},*/
  	beforeCreate () {
    	/*auth.onChange = loggedIn => {
      		this.loggedIn = loggedIn
    	}*/
  	},
  	 mounted () {
  		$(document).ready(function(){
  			//var container = document.querySelector('#main2');
			//var ps = new PerfectScrollbar(container);
  		});
  		
  		
  		
  	}
}
</script>







<!-- ****************************************                STYLES                ************************************************* -->
<style>

/*@import '../../../../node_modules/font-awesome/css/font-awesome.css'; */

@import '../../../../node_modules/materialize-css/dist/css/materialize.css';





html, body {
    height: 100%;
    width: 100%;
    margin: 0;
}


html, body {
	font-family: -apple-system, BlinkMacSystemFont, "Segoe UI", Roboto,
		Helvetica, Arial, sans-serif, "Apple Color Emoji", "Segoe UI Emoji",
		"Segoe UI Symbol";
	color: #2c3e50;
}

header, main, footer {
	opacity: 0;
}

main, footer {
      padding-left: 300px;
    }

    @media only screen and (max-width : 992px) {
      main, footer {
        padding-left: 0;
      }
    }


#app {

}

footer {

}





/* Cordova inAppBrowser */
.inAppBrowserWrap {
	background-color: rgba(0,0,0,0.75);
	color: rgba(235,235,235,1.0);
}
.inAppBrowserWrap menu {
	overflow: auto;
	list-style-type: none;
	padding-left: 0;
}
.inAppBrowserWrap menu li {
	font-size: 25px;
	height: 25px;
	float: left;
	margin: 0 10px;
	padding: 3px 10px;
	text-decoration: none;
	color: #ccc;
	display: block;
	background: rgba(30,30,30,0.50);
}
.inAppBrowserWrap menu li.disabled {
	color: #777;
}





/* Material Icons */
@font-face {
  font-family: 'Material Icons';
  font-style: normal;
  font-weight: 400;
  src: url(assets/material-icons.woff2) format('woff2');
}
.material-icons {
  font-family: 'Material Icons';
  font-weight: normal;
  font-style: normal;
  font-size: 24px;
  line-height: 1;
  letter-spacing: normal;
  text-transform: none;
  display: inline-block;
  white-space: nowrap;
  word-wrap: normal;
  direction: ltr;
  -webkit-font-feature-settings: 'liga';
  -webkit-font-smoothing: antialiased;
}



</style>
