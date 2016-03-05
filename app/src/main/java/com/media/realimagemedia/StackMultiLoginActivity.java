package com.media.realimagemedia;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.media.realimagemedia.stackoverflowlogin.StackoverflowActivity;
import com.media.realimagemedia.utils.AppConstants;

public class StackMultiLoginActivity extends AppCompatActivity implements View.OnClickListener {
    private Button stackLogin , stackViews;
    private Intent stkMultiIntent = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.stack_login);
        this.stackLogin = (Button) this.findViewById(R.id.stackLogin);
        this.stackViews = (Button) this.findViewById(R.id.stackloginViews);
        this.stackLogin.setOnClickListener(this);
        this.stackViews.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.stackLogin:
                stkMultiIntent = new Intent(StackMultiLoginActivity.this, StackoverflowActivity.class);
                break;
            case R.id.stackloginViews:
                stkMultiIntent = new Intent(this, HomeActivity.class);
                stkMultiIntent.putExtra("CurrentUserAccessToken", AppConstants.STACK_LOGIN);
                break;
        }
        startActivity(stkMultiIntent);
    }

    @Override
    protected void onPause() {
        super.onPause();
        finish();
    }
}
