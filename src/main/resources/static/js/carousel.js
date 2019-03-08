Vue.component("carousel", {
	template: `
		<el-carousel indicator-position="outside" v-bind:height="winheight">
	    	<el-carousel-item v-for="(img,index) in images" :key="index">
	          	<img style="width: 100%; height: auto;" ref="imgHeight" :src="img.path" class="bannerImg"/>
	    	</el-carousel-item>
	  	</el-carousel>
	`,
	data: function(){
		return {
			images: [
    		],
    		winheight: '500px'
		}
	},
	methods: {
	},
	created: function() {
	  	var that = this;
	  	var height1 = $(document).height();
	  	that.winheight = (0.4 * height1) + "px";
		axios.post('/demo/home/getBanner.do').then(function (result)  {
	    	var obj = JSON.parse(JSON.stringify(result));
	    	var json = obj.data;
	        that.images = json;
	    });
	}
	
})

new Vue({
	el: "#carousel"
});


