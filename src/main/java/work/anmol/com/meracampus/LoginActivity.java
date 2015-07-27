package work.anmol.com.meracampus;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MotionEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import work.anmol.com.meracampus.ContentActivities.AboutUsGuestActivity;
import work.anmol.com.meracampus.ContentActivities.NavDrawerActivities.AboutUsActivity;


public class LoginActivity extends AppCompatActivity {
    EditText etUserName, etPassword;
    Boolean val = true;
    TextView tvSkip;
    ImageView ivLogin, ivRegister;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        if (getSharedPreferences("meraCampus", MODE_PRIVATE).getBoolean("login_status", false)) {
            startActivity(new Intent(getApplicationContext(), AboutUsActivity.class));
            finish();
        }

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        etUserName = (EditText) findViewById(R.id.etUserName);
        etPassword = (EditText) findViewById(R.id.etPassword);
        tvSkip = (TextView) findViewById(R.id.tvSkip);
        ivLogin = (ImageView) findViewById(R.id.ivLogin);
        ivRegister = (ImageView) findViewById(R.id.ivRegister);

        ivLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                val = true;
                if (etUserName.getText().toString().isEmpty()) {
                    val = false;
                    etUserName.setHintTextColor(Color.RED);
                }
                if (etPassword.getText().toString().isEmpty()) {
                    val = false;
                    etPassword.setHintTextColor(Color.RED);
                }
                if (val) {
                    SharedPreferences.Editor edit = getSharedPreferences("meraCampus", MODE_PRIVATE).edit();
                    edit.putBoolean("login_status", true);
                    edit.apply();
                    Intent intent = new Intent(getApplicationContext(), AboutUsActivity.class);
                    startActivity(intent);
                    finish();
                } else {
                    Toast.makeText(getApplicationContext(), "Incorrect Login Details", Toast.LENGTH_SHORT).show();
                }

            }
        });
        etUserName.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                etUserName.setHintTextColor(Color.GRAY);
                return false;
            }
        });
        etPassword.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                etUserName.setHintTextColor(Color.RED);
                return false;
            }
        });
        tvSkip.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent2 = new Intent(getApplicationContext(), AboutUsGuestActivity.class);
                intent2.putExtra("sessionLog", false);
                startActivity(intent2);
            }
        });
        ivRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1 = new Intent(getApplicationContext(), RegistrationActivity.class);
                startActivity(intent1);
            }
        });
    }
}
