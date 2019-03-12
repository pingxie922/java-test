Vue.component("container", {
	template: `
		<div>
			<el-container>
		  		<el-aside width="200px">Aside</el-aside>
		  		<el-main>Main</el-main>
			</el-container>
		</div>
	`,
	data: function(){
		return {
		}
	},
	methods: {
	},
	created: function() {
	  	var that = this;
		axios.post('/demo/home/getBanner.do').then(function (result)  {
	    	var obj = JSON.parse(JSON.stringify(result));
	    	var json = obj.data;
	    });
	}
})

new Vue({
	el: "#container"
});