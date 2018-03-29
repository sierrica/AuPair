<template>
	<div>
		<ul id="slide-out" class="side-nav fixed">
		
		
			<div class="sidenav-profile">
				<div class="sidebar-profile-image" style="min-height:100px;">
					<!--  <img src="assets/profile-image.png" class="circle" alt="">-->
				</div>
			
	        	<div class="sidebar-profile-info">
		        	<ul>
						<li>
							<a href='#' data-activates='dropdown_profile' class='dropdown-button' v-on:click="dropdown_profile()">
								<div class="user-name">Katsumoto
									<i class="material-icons right">arrow_drop_down</i>
								</div>
								<div class="small">admin</div>
							</a>
						  	<ul id='dropdown_profile' class='dropdown-content'>
								<li>
									<a href="#">Profile</a>
									
								</li>
								<li>
									<!-- <a href="login">Login</a> -->
									<router-link to="login">Login</router-link>
								</li>
								<li>
									<a href="#">Signup</a>
								</li>
								<li>
									<a href="#">Logout</a>
								</li>
						  	</ul>
						</li>
					</ul>
	        	

	          	</div>
	        </div>
		
			<li>
				<a href="#!">First Sidebar Link</a>
			</li>
			<li>
				<a href="#!">Second Sidebar Link</a>
	      	</li>
	      
	    </ul>


	</div>
</template>


<script scoped>
	
export default {
	mounted () {
		$('.button-collapse').sideNav ({
 		    menuWidth: 300,
 		    edge: 'left', 
 		    closeOnClick: false,
 		    draggable: true,
 		    onOpen: function() {},
 		    onClose: function() {}
 		});
	},
	methods: {
		dropdown_profile: function() {
			($('.sidenav-profile .dropdown-button i').html() == 'arrow_drop_down')   ?   $('.sidenav-profile .dropdown-button i').html('arrow_drop_up')   :   $('.sidenav-profile .dropdown-button i').html('arrow_drop_down')
		}
	}

}
</script>


<style scoped>

	.side-nav.fixed {
	    top: 64px;
	    z-index: 999;
	    height: calc(100% - 50px);
	    /*height: calc(100% - 100px);   */          /* Para poner el footer toda la pantalla*/
	}

	@media only screen and (max-width: 992px) {
		.side-nav.fixed {
			top: 0px;
			height: 100%;
		}
	}

	.drag-target {
		width: 20px;
	}

	.side-nav {
	    background: #474747;
	    color: #fff;
	}
	
	.side-nav li > a {
		color: #fff;
	}
	#dropdown_profile {
		margin-top: 50px;
	}
	.side-nav #dropdown_profile li > a {
		color: #222;
	}
	
	
	/* Sidenav Profile */
	.side-nav .sidenav-profile {
	    min-height: 200px;
	    position: relative;
	    display: table;
	    width: 100%;
	    -webkit-box-shadow: inset 0 0 2px rgba(0,0,0,.1);
	    box-shadow: inset 0 0 2px rgba(0,0,0,.1);
	}
	.side-nav .sidenav-profile:after {
	    content: "";
	    background: url(../assets/user-bg.png);
	    background-size: cover;
	    opacity: .2;
	    top: 0;
	    left: 0;
	    bottom: 0;
	    right: 0;
	    position: absolute;
	    z-index: -1;
	}
	
	
	.side-nav .sidenav-profile .dropdown-button {
		height: 100%;
	}
	
	.side-nav .sidenav-profile .dropdown-button i {
		font-size: 40px;
	}

	
	


</style>