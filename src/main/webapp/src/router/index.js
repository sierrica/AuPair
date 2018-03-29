import Vue from 'vue'
import Router from 'vue-router'
import auth from '@/auth'

import Notfound from '@/components/404.vue'
import Topnav from '@/components/Topnav.vue'
import Sidenav from '@/components/Sidenav.vue'
import Foot from '@/components/Foot.vue'
import About from '@/components/About.vue'
import Dashboard from '@/components/Dashboard.vue'
import Signin from '@/components/Signin.vue'
import Signup from '@/components/Signup.vue'


Vue.component('topnav', Topnav)
Vue.component('sidenav', Sidenav)
Vue.component('foot', Foot)
Vue.use(Router)


export default new Router({
	mode: 'history',
	base: __dirname,
	routes: [
		{
		    path: '*',
		    redirect: '/dashboard',
		},
		{
			path: '/dashboard',
			component: Dashboard,
			beforeEnter: requireAuth
		},
		{
			path: '/about',
			component: About
		},
		{
			path: '/signin',
			component: Signin
		},
		{
			path: '/signup',
			component: Signup
		},
		{
			path: '/logout',
			beforeEnter (to, from, next) {
				auth.logout()
				next('/signin')
			}
		}
	]
})


function requireAuth (to, from, next) {
	if ( ! auth.loggedIn()) {
		next({
			path: '/signup'
		})
	}
	else {
		next()
	}
}