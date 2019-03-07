Vue.component("ouerfooter", {
	template: `
		<div>
			<el-row :gutter="20">
			  	<el-col :span="6"><div class="grid-content bg-purple"></div></el-col>
			  	<el-col :span="6"><div class="grid-content bg-purple"></div></el-col>
			  	<el-col :span="6"><div class="grid-content bg-purple"></div></el-col>
			  	<el-col :span="6"><div class="grid-content bg-purple"></div></el-col>
			</el-row>
		<div>
	`,
	data: function(){
		return {
		}
	},
	methods: {
	}
})

new Vue({
	el: "#ouerfooter"
});