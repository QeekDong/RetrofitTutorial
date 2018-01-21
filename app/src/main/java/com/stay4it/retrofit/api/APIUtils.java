package com.stay4it.retrofit.api;

import com.stay4it.retrofit.bean.ExamInfo;
import com.stay4it.retrofit.bean.HttpResponse;
import com.stay4it.retrofit.bean.LoginInfo;
import com.stay4it.retrofit.bean.MessageInfo;
import com.stay4it.retrofit.bean.StudentInfo;

import java.util.List;
import java.util.Map;

import okhttp3.RequestBody;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;
import retrofit2.http.PartMap;
import retrofit2.http.Query;
import rx.Observable;

/**
 * 接口定义
 * @author lizhixian
 * @time 16/8/18 21:46
 */
public interface APIUtils {

    @Multipart
    @POST("Exam/addExamRecord")
    Observable<MessageInfo> uploadMultipleTypeFile(
            @PartMap Map<String,RequestBody> params);

    @FormUrlEncoded
    @POST("Index/login")
    Observable<LoginInfo>stulogin(@Field("student_id") String method, @Field("password") String token);

    @GET("Student/getStudentByStudentId")
    Observable<StudentInfo>getStudentInfo(@Query("student_id") String student_id,
                                     @Query("access_token") String access_token);

    @GET("Exam/getTodayExamByStudentId")
    Observable<ExamInfo>getExamInfo(@Query("student_id") String student_id,
                                       @Query("access_token") String access_token);

}
