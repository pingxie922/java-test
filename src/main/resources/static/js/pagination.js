Vue.component("pagination", {
	template: `
		<el-pagination
	      	@size-change="handleSizeChange"
	      	@current-change="handleCurrentChange"
	      	:current-page="currentPage"
	      	:page-size="15"
	      	layout="prev, pager, next, total, jumper"
	      	:total="400">
    	</el-pagination>
	`,
	data: function(){
		return {
	        currentPage: 3
		}
	},
	methods: {
		handleSizeChange(val) {
        	console.log(`每页 ${val} 条`);
	    },
	    handleCurrentChange(val) {
	      	console.log(`当前页: ${val}`);
	    }
	}
})

new Vue({
	el: "#pagination"
});
