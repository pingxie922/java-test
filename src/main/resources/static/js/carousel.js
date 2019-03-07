Vue.component("carousel", {
	template: `
		<el-carousel indicator-position="outside">
	    	<el-carousel-item v-for="item in 4" :key="item">
	      	<h3>{{ item }}</h3>
	    	</el-carousel-item>
	  	</el-carousel>
	`,
	data: function(){
		return {
		}
	},
	methods: {
	}
})

new Vue({
	el: "#carousel"
});