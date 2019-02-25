//发送验证码定时器
	var countdown=60;
	
	function settime(obj) { //发送验证码倒计时
	if (countdown == 0) { 
	    obj.attr('disabled',false); 
	    //obj.removeattr("disabled"); 
	    obj.html("Getcode");
	    countdown = 60; 
	    return;
	} else { 
	    obj.attr('disabled',true);
	    obj.html("(" + countdown + ")秒");
	    countdown--; 
	} 
	setTimeout(function() { 
	    settime(obj) }
	    ,1000) 
	}
