package com.zzy.javatest.statues;

public enum StatusEnum {

    SUCCESS("成功", 0000),

    FAILD("失败",0001),

    ERROR("错误", 0002);

    public String msg;
    public int value;

    private StatusEnum(String msg, int value){
        this.msg = msg;
        this.value = value;
    }

}
