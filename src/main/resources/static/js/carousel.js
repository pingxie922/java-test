Vue.component("carousel", {
	template: `
		<el-carousel indicator-position="outside">
	    	<el-carousel-item v-for="(img,index) in images" :key="index">
	      		<h3>{{ img.id }}<img :src="img.path"></h3>
	    	</el-carousel-item>
	  	</el-carousel>
	`,
	data: function(){
		return {
			images: [
    		]
		}
	},
	methods: {
	},
	created: function() {
	  	var that = this;
		axios.post('/demo/home/getBanner.do').then(function (result)  {
	    	var obj = JSON.parse(JSON.stringify(result));
	    	var json = obj.data;
	        that.images = json;
	    })
	}
	
})

new Vue({
	el: "#carousel"
});


