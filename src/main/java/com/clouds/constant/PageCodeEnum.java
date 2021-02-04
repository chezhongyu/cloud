package com.clouds.constant;

public enum PageCodeEnum {
    ADD_SUCCESS(1000,"增加成功"),
    UPDATE_SUCCESS(1002,"修改成功"),
    UPDATE_FAIL(1003,"添加失败"),
    ADD_FAIL(1001,"添加失败");

    private Integer code;
    private String msg;

    public static final String KEY = "pageCode";

    PageCodeEnum(Integer code,String msg){
        this.code=code;
        this.msg=msg;
    }
    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }



}
