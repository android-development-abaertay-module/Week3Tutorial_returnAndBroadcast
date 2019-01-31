package com.bodovix.tutorial3returningresultsfromactivity;

import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import org.w3c.dom.Text;

import static com.bodovix.tutorial3returningresultsfromactivity.LoginActivity.RESULT_LOGIN_SUCCESS;

public class MainActivity extends AppCompatActivity {

    final static int LOGIN_REQUEST =0;
    TextView statusTxt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        statusTxt = findViewById(R.id.statusTxt);
    }

    public void loginNavBtn_Click(View view) {
        Intent intent = new Intent(MainActivity.this,LoginActivity.class);
        startActivityForResult(intent,LOGIN_REQUEST);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == LOGIN_REQUEST){
            if (resultCode == RESULT_LOGIN_SUCCESS)  {
                //login success
//                statusTxt.setText("Login Success for: " + data.getStringExtra("name"));
                statusTxt.setText("Login Success for: " + data.getStringExtra("name"));
            }else{
                //login fail
                statusTxt.setText("Login Fail");
            }
        }
    }
}
