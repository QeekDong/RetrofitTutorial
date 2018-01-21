package com.stay4it.retrofit.bean;

/**
 * Created by win on 2018/1/20.
 * 用于接收登录返回的学生信息
 */

public class LoginInfo {
    private int code;
    private String message;
    private Data data;

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

    public Data getData() {
        return data;
    }

    public void setData(Data data) {
        this.data = data;
    }

    public static class Data{
        private String student_id;
        private String access_token;
        private long expire;

        public Data(String student_id, String access_token, long expire){
            this.student_id = student_id;
            this.access_token = access_token;
            this.expire = expire;
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

        public long getexpire() {
            return expire;
        }

        public void setexpire(long expire) {
            this.expire = expire;
        }

    }
}
