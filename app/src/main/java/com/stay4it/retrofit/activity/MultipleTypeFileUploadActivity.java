package com.stay4it.retrofit.activity;

import android.os.Bundle;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.stay4it.retrofit.R;
import com.stay4it.retrofit.api.APIUtils;
import com.stay4it.retrofit.api.util.RetrofitHelper;
import com.stay4it.retrofit.bean.ExamInfo;

import com.stay4it.retrofit.bean.LoginInfo;
import com.stay4it.retrofit.bean.MessageInfo;
import com.stay4it.retrofit.bean.StudentInfo;
import com.stay4it.retrofit.util.TLog;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;

import java.util.Map;

import butterknife.BindView;
import okhttp3.MediaType;
import okhttp3.RequestBody;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class MultipleTypeFileUploadActivity extends AppCompatActivity implements View.OnClickListener{
    private static final String STUDENT_ID = "2014211209";
    private static final String PASSWORD = "0";
    private String access_token;

    private Button mActionBtn;
    private Button mActionInfo;
    private TextView info_txt;
    private Button mActionExamInfo;
    private Button btn_upload;
    //    @BindView(R.id.action_stuinfo)
//    Button mActionInfo;
//
//    @BindView(R.id.info_text)
//    TextView info_txt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pic_and_text_upload);
        initView();
    }



    public void initView() {
        mActionBtn = (Button) findViewById(R.id.action_btn);
        mActionInfo = (Button) findViewById(R.id.action_stuinfo);
        mActionExamInfo = (Button) findViewById(R.id.action_examinfo);
        info_txt = (TextView) findViewById(R.id.info_text);
        btn_upload = (Button) findViewById(R.id.upload);
        btn_upload.setOnClickListener(this);
        mActionBtn.setOnClickListener(this);
        mActionInfo.setOnClickListener(this);
        mActionExamInfo.setOnClickListener(this);
    }


    public void uploadFile(String exam_id, String student_id, String access_token) {
        String path1 = Environment.getExternalStorageDirectory() + File.separator + "test.jpg";
//        String path2 = Environment.getExternalStorageDirectory() + File.separator + "test1.jpg";
        ArrayList<String> pathList = new ArrayList<>();
        pathList.add(path1);
//        pathList.add(path2);

        Map<String, RequestBody> bodyMap = new HashMap<>();
        if(pathList.size() > 0) {
            for (int i = 0; i < pathList.size(); i++) {
                File file = new File(pathList.get(i));
                bodyMap.put("headphoto\"; filename=\""+file.getName(), RequestBody.create(MediaType.parse("image/png"),file));
            }
            bodyMap.put("student_id", RequestBody.create(MediaType.parse("text/plain"), student_id));
            bodyMap.put("exam_id", RequestBody.create(MediaType.parse("text/plain"), exam_id));
            bodyMap.put("access_token", RequestBody.create(MediaType.parse("text/plain"), access_token));

        }

        RetrofitHelper.getInstance()
                .getService(APIUtils.class)
                .uploadMultipleTypeFile(bodyMap)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<MessageInfo>() {
                    @Override
                    public void onCompleted() {
                        Log.d("MYACTIVITY", "completed");

                    }

                    @Override
                    public void onError(Throwable e) {
                        TLog.error("onError " + e.toString());
                    }

                    @Override
                    public void onNext(MessageInfo messageInfo) {
//                        TLog.error("onNext " + response.toString());
//                        Toast.makeText(MultipleTypeFileUploadActivity.this, response.msg, Toast.LENGTH_SHORT).show();


                    }
                });
    }


    public void StuLogin(String student_id, String password){
        RetrofitHelper.getInstance()
                .getService(APIUtils.class)
                .stulogin(student_id, password)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<LoginInfo>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        TLog.error("onError " + e.toString());
                    }

                    @Override
                    public void onNext(LoginInfo stuInfo) {
                        Log.d("WINLOGIN", "onNext: " + stuInfo);
                        access_token = stuInfo.getData().getAccess_token();
                        Log.d("StuClient", "onNext: " + access_token);

                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                Toast.makeText(MultipleTypeFileUploadActivity.this, "success", Toast.LENGTH_SHORT).show();
                            }
                        });
                    }
                });
    }

    private void getStuInfo(String student_id, String access_token){
        RetrofitHelper.getInstance()
                .getService(APIUtils.class)
                .getStudentInfo(student_id, access_token)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<StudentInfo>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        TLog.error("onError " + e.toString());
                    }

                    @Override
                    public void onNext(StudentInfo studentInfo) {
                        Log.d("WINLOGIN", "onNext: " + studentInfo);
                        Log.d("StuClient", "onNext: " + studentInfo.getData().getName());
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                Toast.makeText(MultipleTypeFileUploadActivity.this, "success", Toast.LENGTH_SHORT).show();
                            }
                        });
                    }
                });
    }

    private void getExamInfo(String student_id, String access_token){
        RetrofitHelper.getInstance()
                .getService(APIUtils.class)
                .getExamInfo(student_id, access_token)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<ExamInfo>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        TLog.error("onError " + e.toString());
                    }

                    @Override
                    public void onNext(ExamInfo examInfo) {
                        Log.d("WINLOGIN", "onNext: " + examInfo);
//                        Log.d("StuClient", "onNext: " + examInfo.getData());

                    }
                });
    }


    @Override
    public void onClick(View v) {
        switch(v.getId()){
            case R.id.action_btn:
            StuLogin(STUDENT_ID, PASSWORD);
                break;

            case R.id.action_stuinfo:
                getStuInfo(STUDENT_ID, access_token);
                break;

            case R.id.action_examinfo:
                getExamInfo(STUDENT_ID, access_token);
                break;

            case R.id.upload:
                uploadFile("1", STUDENT_ID, access_token);
                break;
        }

    }
}
