Vue.component("myarticle", {
	template: `
		
	`,
	data: function(){
		return {
			readArticle: ''
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


