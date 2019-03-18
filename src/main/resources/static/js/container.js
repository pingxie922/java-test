Vue.component("container", {
	template: `
		<div id="centerhome">
			<el-container v-for="(articles,index) in allArticles" :key="index">
		  		<el-aside width="30%" style="overflow: hidden; padding: 10px;"><img style="width: 100%; height: 100%;" :src="articles.path" class="bannerImg"/></el-aside>
		  		<el-main style="overflow: hidden; padding: 10px;">
		  			<h3>
		  				<el-tag size="mini">{{articles.tag}}</el-tag>
		  				<a @click="toArticle(articles.id)" :href="toUrl">{{articles.title}}</a>
		  			</h3>
		  			<el-row :gutter="20">
						 <el-col :span="8">{{articles.createDate}}</el-col>
						 <el-col :span="4">作者:{{articles.user.name}}</el-col>
						 <el-col :span="4">阅读({{articles.myArticleStatistics.readNum}})</el-col>
						 <el-col :span="4">评论({{articles.myArticleStatistics.collectNum}})</el-col>
						 <el-col :span="4"><span @click="addLike(articles.id, index)">赞({{articles.myArticleStatistics.likeNum}})</span></el-col>
					</el-row>
		  			<span>{{articles.introduction}}</span>
		  		</el-main>
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
	        size: 10,
	        allArticles: [],
			toUrl: ''
		}
	},
	methods: {
	    handleCurrentChange(val) {
	      	console.log(`当前页: ${val}`);
	      	this.currentPage = val;
	      	this.getArticle();
	    },
        toArticle: function(num) {
            var sel = this;
            console.log(num);
            sel.toUrl = '/demo/article.do?' + num;
            var param=new URLSearchParams();
	    	param.append('id',num);
	    	param.append('str','readNum');
			axios.post('/demo/home/addLike.do', param).then(function (result) {
            });
		},
	    addLike: function(num, index) {
	    	var sel = this;
	    	var param=new URLSearchParams();
	    	param.append('id',num);
	    	param.append('str','likeNum');
			axios.post('/demo/home/addLike.do', param).then(function (result) {
                var obj = JSON.parse(JSON.stringify(result));
                var json = obj.data;
                var likeNum = json.result.likeNum;
                console.log(index);
                // 数组中数据发生变化，vue页面并不会重新渲染，只有用Vue.set去重新刷新数组数据
				// 以前发错 需要注意
				// 		1 ： Vue.set(sel.allArticles[index], 'likeNum', likeNum);
				// 		2 ： Vue.set(sel.allArticles, sel.allArticles[index], json.result);
				// 		3 ： Vue.set(sel.allArticles, index, json.result);
                if(json.success) {
                    Vue.set(sel.allArticles[index].myArticleStatistics, 'likeNum', likeNum);
				}
            });
	   	},
	   	getArticle: function(){
	    	var that = this;
		  	var param=new URLSearchParams();
	    	param.append('page',that.currentPage);
	    	param.append('size',that.size);
		  	axios.post('/demo/home/getArticle.do',param).then(function (result) {
		    	var obj = JSON.parse(JSON.stringify(result));
		    	var json = obj.data;
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


