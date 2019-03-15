Vue.component("myarticle", {
	template: `
		<div id="container">
			<el-container>
				<el-main>
					<h3 style="text-align:center">{{readArticle.title}}</h3>
					<el-row style="margin: 0 auto; font-size: 12px;" :gutter="20">
					  	<el-col :span="10">{{readArticle.createDate}}</el-col>
					  	<el-col :span="6">作者:{{readArticle.user.name}}</el-col>
					  	<el-col :span="4">阅读({{readArticle.myArticleStatistics.readNum}})</el-col>
					  	<el-col :span="4">评论({{readArticle.myArticleStatistics.collectNum}})</el-col>
					</el-row>
					<span v-html="readArticle.content"></span>
				</el-main>
		  		<el-aside width="350px">Aside</el-aside>
			</el-container>
		</div>
	`,
	data: function(){
		return {
			readArticle: {
				"id": 1,
				"title": '',
				"content": '',
				"createDate": '',
				"introduction": '',
				"tag": '',
				"myArticleStatistics": {
					"collectNum": 0,
					"likeNum": 6,
					"readNum": 0
				},
				"user": {
					"name": ''
				}
			}
		}
	},
	methods: {
	   	getArticle: function(val){
	    	var that = this;
		  	var param=new URLSearchParams();
	    	param.append('id',val);
		  	axios.post('/demo/home/getArticle.do',param).then(function (result) {
                var obj = JSON.parse(JSON.stringify(result));
                var json = obj.data;
                that.readArticle = json.records[0];
                console.log(that.readArticle);
		    });
	    }
	},
	created: function() {
		var url = window.location.href;
        var number = url.indexOf('?', 1);
        var val = url.substr(number+1);
		this.getArticle(val);
	}
})

new Vue({
	el: "#myarticle"
});


