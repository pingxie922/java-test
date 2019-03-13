Vue.component("container", {
	template: `
		<div id="centerhome">
			<el-container v-for="(articles,index) in allArticles" :key="index">
		  		<el-aside width="350px" height="250px" style="overflow: hidden;"><img style="width: 350px;height: 250px;" :src="articles.path" class="bannerImg"/></el-aside>
		  		<el-main>{{articles.content}}</el-main>
			</el-container>
			
			<el-pagination
		      	@current-change="handleCurrentChange"
		      	:current-page="currentPage"
		      	:page-size="size"
		      	layout="prev, pager, next, total, jumper"
		      	:total="total">
    		</el-pagination>
		</div>
	`,
	data: function(){
		return {
			currentPage: 1,
	        total: 500,
	        size: 15,
	        allArticles: []
		}
	},
	methods: {
	    handleCurrentChange(val) {
	      	console.log(`当前页: ${val}`);
	      	this.currentPage = val;
	      	this.getArticle();
	    },
	   getArticle: function(){
	    	var that = this;
		  	var param=new URLSearchParams();
	    	param.append('page',that.currentPage);
	    	param.append('size',2);
		  	axios.post('/demo/home/getArticle.do',param).then(function (result) {
		    	var obj = JSON.parse(JSON.stringify(result));
		    	var json = obj.data;
		    	console.log(json.total);
		    	that.total = json.total;
		    	that.currentPage = json.current;
		    	that.size = json.size;
		    	that.allArticles = json.records;
		    });
	    }
	},
	created: function() {
	  	this.getArticle();
	}
})

new Vue({
	el: "#container"
});