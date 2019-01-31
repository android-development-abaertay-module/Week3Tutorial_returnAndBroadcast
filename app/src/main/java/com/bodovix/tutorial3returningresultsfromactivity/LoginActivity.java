package com.bodovix.tutorial3returningresultsfromactivity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import static android.app.job.JobScheduler.RESULT_FAILURE;
import static android.app.job.JobScheduler.RESULT_SUCCESS;

public class LoginActivity extends AppCompatActivity {

    private static final int RESULT_LOGIN_FAIL = 1;
    protected static final int RESULT_LOGIN_SUCCESS = 0;
    EditText nameTxt;
    EditText passwordTxt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        nameTxt = findViewById(R.id.nameTxt);
        passwordTxt = findViewById(R.id.passwordTxt);
    }

    public void loginBtn_Click(View view) {
        String validName  = "gwyd";
        String validPassword  = "password";

        String name = nameTxt.getText().toString();
        String pass = passwordTxt.getText().toString();

        Intent intent = new Intent();
        intent.putExtra("name",name);


        //set the Intent result
        if(name.equals(validName) && pass.equals(validPassword)){

            setResult(RESULT_LOGIN_SUCCESS,intent);
        }else{
            setResult(RESULT_LOGIN_FAIL);
        }
        //finish this activity and return to MainActivity
        this.finish();
    }
}
