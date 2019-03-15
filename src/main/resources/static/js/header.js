Vue.component("ouerheader", {
	template: `
		<el-row :gutter="20">
		  	<el-col :span="9"><div class="grid-content bg-purple"></div></el-col>
		  	<el-col :span="15">
		  		<el-menu :default-active="activeIndex" class="el-menu-demo" mode="horizontal" @select="handleSelect">
				  	<el-menu-item index="1"><a href="/demo/home.do">首页</a></el-menu-item>
				  	<el-submenu index="2">
				    	<template slot="title">我的工作台</template>
				    	<el-menu-item index="2-1">选项1</el-menu-item>
				    	<el-menu-item index="2-2">选项2</el-menu-item>
				    	<el-menu-item index="2-3">选项3</el-menu-item>
				  	</el-submenu>
				  	<el-menu-item index="3" disabled>消息中心</el-menu-item>
				  	<el-menu-item index="4">订单管理</el-menu-item>
					<el-menu-item index="5">我的订单</el-menu-item>
					<el-menu-item index="6">关于我们</el-menu-item>
				</el-menu>
		  	</el-col>
		</el-row>
	`,
	data: function(){
		return {
			activeIndex: '1'
		}
	},
	methods: {
		handleSelect(key, keyPath) {
			console.log(keyPath);
		}
	},
	created () {
	    axios.post('http://jsonplaceholder.typicode.com/users').then(function (result)  {
	    	var json = result.data;
	    })
	}
})

new Vue({
	el: "#header"
});


