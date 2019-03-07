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
	}
})

new Vue({
	el: "#container"
});