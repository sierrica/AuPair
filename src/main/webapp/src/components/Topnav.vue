<template>
	<div class="navbar-fixed">
		
		<nav id="topnav_normal">
			<div class="nav-wrapper">
				
				<a href="#" class="brand-logo">Logo</a>
				
				<a href="#" data-activates="slide-out" class="button-collapse hide-on-large-only">
	    			<i class="material-icons">menu</i>
	    		</a>
				
				<ul id="nav-mobile" class="right hide-on-large-only">
					<li>
						<a href='#' data-activates='dropdown_tasks' class='dropdown-button'>
							<i class="material-icons">dashboard</i>
							<!-- <i class="fa fa-dashboard fa-2x"></i> -->
						</a>
					  	<ul id='dropdown_tasks' class='dropdown-content'>
							<li>
								<a href="sass.html">Tasks</a>
							</li>
							<li>
								<a href="badges.html">Meals</a>
							</li>
							<li>
								<a href="collapsible.html">Grocery</a>
							</li>
					  	</ul>
					</li>
				</ul>
				
				<ul id="button-search" class="right" v-on:click="search_nav()">
					<li>
						<a href="#">
							<i class="material-icons">search</i>
						</a>
					</li>
				</ul>
				
				<ul id="nav-desktop" class="right hide-on-med-and-down">
					<li>
						<a href="#">
							<i class="material-icons">face</i>
							<span>Tasks</span>
						</a>
					</li>
					<li>
						<a href="#">
							<i class="material-icons">local_dining</i>
							<span>Meals</span>
						</a>
					</li>
					<li>
						<a href="#">
							<i class="material-icons">shopping_cart</i>
							<span>Grocery</span>
						</a>
					</li>
				</ul>

			</div>
		</nav>
		
		
		<nav id="topnav_search">
			<div class="nav-wrapper">
	      		<form v-on:submit.prevent="search()">
	        		<div class="input-field">
	          			<input id="search" type="search" name="search" required v-on:blur="search_blur()">
	          			<label class="label-icon" for="search" v-on:mousedown="search_button()">
	          				<i class="material-icons">search</i>
						</label>
	          			
	          			<i class="material-icons">close</i>
	       			 </div>
	      		</form>
	    	</div>
		</nav>
	</div>
</template>




<script scoped>
export default {
	
	methods: {
		search_nav: function () {
			$('#topnav_normal').css('display', 'none');
			$('#topnav_search').css('display', 'inline');
			$('#topnav_search input').focus();
		},
		search_blur: function () {
			$('#topnav_search').css('display', 'none')
			$('#topnav_normal').css('display', 'inline')
		},
		search_button: function () {
			alert ("CLICK");
			this.search();
		},
		search: function () {
			alert  ("SUBMIT")
		}
	}
	
}
</script>




<style scoped>

	nav {
		background-color: #ee184c;
	}
	
	nav a {
		height: 64px;
	}
	@media only screen and (max-width: 600px) {
		nav a {
			height: 56px;
			padding: 0 4px;
		}
	}
	nav a.button-collapse {
		margin: 0 10px;
	}
	nav a.button-collapse i {
		font-size: 50px;
	}
	nav a.dropdown-button i, nav #button-search i {
		font-size: 35px;
	}
	
	nav a i {
	    float: left;
	    margin-right: 5px;
	}
	nav a span {
		font-size: 20px;
	}
	

	
	
	/* TOPNAV SEARCH */
	#topnav_search {
		display:none;
	}
	#topnav_search label {
		margin-top: -10px;
		cursor: pointer;
		pointer-events: all;
	}

	#topnav_search input {
		font-size: 35px;
	}
	#topnav_search i {
		font-size: 40px;
	}
	@media only screen and (min-width: 993px) {
		#topnav_search  {
			/*left: 302px;*/
		}

	}


</style>