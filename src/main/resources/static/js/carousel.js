Vue.component("carousel", {
	template: `
		<el-carousel indicator-position="outside" :height="winheight">
	    	<el-carousel-item v-for="(img,index) in images" :key="index">
	          	<a :href="img.url"><img style="width: 100%;" :height="winheight" :src="img.path" class="bannerImg"/></a>
	    	</el-carousel-item>
	  	</el-carousel>
	`,
	data: function(){
		return {
			images: [
    		],
    		winheight: '500px',
    		screenWidth: document.body.clientWidth
		}
	},
	methods: {
	},
	watch:{
		screenWidth(val){
			var that = this;
		    // 为了避免频繁触发resize函数导致页面卡顿，使用定时器   :style="{width:imgWidth+'px'}"
		    if(!that.timer){
		        // 一旦监听到的screenWidth值改变，就将其重新赋给data里的screenWidth
		        that.screenWidth = val;
		        that.timer = true;
		        setTimeout(function(){
		            // 打印screenWidth变化的值
		            that.timer = false;
		            that.winheight = (0.35 * screenWidth) + "px";
		            console.log(that.winheight);
		        },400)
		    }
		}
	},
	created: function() {
	  	var that = this;
	  	var height1 = $(document).height();
	  	that.winheight = (0.35 * height1) + "px";
		axios.post('/demo/home/getBanner.do').then(function (result)  {
	    	var obj = JSON.parse(JSON.stringify(result));
	    	var json = obj.data;
	        that.images = json;
	    });
	},
	mounted: function() {
		var that = this;
		window.onresize = function() {
    		return (() => {
        		window.screenWidth = $(document).height();
        		that.screenWidth = window.screenWidth
    		})()
		};
	}
})

new Vue({
	el: "#carousel"
});


