package com.zzy.javatest.statues;

public enum OperationLogDictionary {

	LOGIN("账号登陆", (short) 1 ),

    UPDATE_HEAD_IMG("修改头像", (short) 2),
    
	UPDATE_PERSON_MSG("修改信息", (short) 3),
	
	LOGIN_ERROR("登陆失败", (short) 4 ),
	
	REG_USER("用户注册", (short) 5);

    public String msg;
    public Short value;

    private OperationLogDictionary(String msg, Short value){
        this.msg = msg;
        this.value = value;
    }
    
    
    
    public enum ThirdApiLog {

        NOTE_API("短信接口", 1);

        public String msg;
        public int value;

        private ThirdApiLog(String msg, int value){
            this.msg = msg;
            this.value = value;
        }

    }
	
}
