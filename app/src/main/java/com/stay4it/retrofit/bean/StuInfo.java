package com.stay4it.retrofit.bean;

/**
 * Created by win on 2018/1/20.
 * 用于接收登录返回的学生信息
 */

public class StuInfo {
    private int code;
    private String message;
    private StuData stuData;

//    public StuInfo(int code, String message, StuData stuData) {
//        super();
//        this.code = code;
//        this.message = message;
//        this.stuData = stuData;
//    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public StuData getStuData() {
        return stuData;
    }

    public void setStuData(StuData stuData) {
        this.stuData = stuData;
    }

    public static class StuData{
        private String student_id;
        private String access_token;
        private long token_time;

        public StuData(String student_id, String access_token, long token_time){
            this.student_id = student_id;
            this.access_token = access_token;
            this.token_time = token_time;
        }

        public String getStudent_id() {
            return student_id;
        }

        public void setStudent_id(String student_id) {
            this.student_id = student_id;
        }

        public String getAccess_token() {
            return access_token;
        }

        public void setAccess_token(String access_token) {
            this.access_token = access_token;
        }

        public long getToken_time() {
            return token_time;
        }

        public void setToken_time(long token_time) {
            this.token_time = token_time;
        }

    }
}
