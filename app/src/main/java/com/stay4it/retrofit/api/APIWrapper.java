//package com.stay4it.retrofit.api;
//
//
//import com.stay4it.retrofit.api.util.RetrofitHelper;
//import com.stay4it.retrofit.bean.HttpResponse;
//import com.stay4it.retrofit.bean.LoginInfo;
//
//import java.util.List;
//import java.util.Map;
//
//import okhttp3.RequestBody;
//import rx.Observable;
//
//public class APIWrapper extends RetrofitHelper {
//
//    private static APIWrapper mAPIWrapper;
//
//    public APIWrapper() {
//    }
//
//    public static APIWrapper getInstance() {
//        if (mAPIWrapper == null) {
//            mAPIWrapper = new APIWrapper();
//        }
//        return mAPIWrapper;
//    }
//
//    public Observable<HttpResponse<List<String>>> uploadMultipleTypeFile(String des, Map<String,RequestBody> params) {
//        return getAPIService().uploadMultipleTypeFile(des, params);
//    }
//
//    public Observable<LoginInfo>StuLogin(String student_id, String password){
//        return getAPIService().stulogin(student_id, password);
//    }
//
//}
