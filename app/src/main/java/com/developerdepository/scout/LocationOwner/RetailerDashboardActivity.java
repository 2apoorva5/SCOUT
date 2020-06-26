package com.developerdepository.scout.LocationOwner;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.TextView;

import com.developerdepository.scout.Databases.SessionManager;
import com.developerdepository.scout.R;

import java.util.HashMap;

public class RetailerDashboardActivity extends AppCompatActivity {

    private TextView userDetails;
    SessionManager sessionManager;

    String name, username, email, password, gender, dateOfBirth, mobile;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_retailer_dashboard);

        //StatusBar Color
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
        getWindow().setStatusBarColor(getResources().getColor(android.R.color.white));
        getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);

        sessionManager = new SessionManager(RetailerDashboardActivity.this, SessionManager.SESSION_USERSESSION);
        HashMap<String, String> user_details = sessionManager.getUsersDetailFromSession();

        name = user_details.get(SessionManager.KEY_NAME);
        username = user_details.get(SessionManager.KEY_USERNAME);
        email = user_details.get(SessionManager.KEY_EMAIL);
        password = user_details.get(SessionManager.KEY_PASSWORD);
        gender = user_details.get(SessionManager.KEY_GENDER);
        dateOfBirth = user_details.get(SessionManager.KEY_DATEOFBIRTH);
        mobile = user_details.get(SessionManager.KEY_MOBILE);

        initViews();
        setActionOnViews();
    }

    private void initViews() {
        userDetails = findViewById(R.id.retailer_dashboard_user_details);
    }

    private void setActionOnViews() {
        userDetails.setText(String.format("%s\n%s\n%s\n%s\n%s\n%s\n%s", name, username, email, password, gender, dateOfBirth, mobile));
    }
}