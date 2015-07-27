package work.anmol.com.meracampus;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import work.anmol.com.meracampus.ContentActivities.NavDrawerActivities.AboutUsActivity;


public class RegistrationActivity extends AppCompatActivity {
    Button reg;
    Boolean validate = true;
    EditText name, enroll, mail, pass, mob;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);

        name = (EditText) findViewById(R.id.etUserName);
        mail = (EditText) findViewById(R.id.etMail);
        mob = (EditText) findViewById(R.id.etMob);
        enroll = (EditText) findViewById(R.id.etEnroll);
        pass = (EditText) findViewById(R.id.etPass);
        reg = (Button) findViewById(R.id.bReg);

        reg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (validate()) {
                    SharedPreferences.Editor edit = getSharedPreferences("meraCampus", MODE_PRIVATE).edit();
                    edit.putBoolean("login_status", true);
                    edit.apply();
                    startActivity(new Intent(getApplicationContext(), AboutUsActivity.class));
                    finish();
                }
            }
        });
    }

    private Boolean validate() {
        validate = true;
        if (name.getText().toString().isEmpty()) {
            validate = false;
            name.setHintTextColor(Color.RED);
            name.setBackgroundColor(Color.red(80));
            Toast.makeText(getApplicationContext(),
                    ("Fields are missing"), Toast.LENGTH_SHORT).show();
        }
        if (mail.getText().toString().isEmpty()) {
            validate = false;
            mail.setHintTextColor(Color.RED);
            mail.setBackgroundColor(Color.red(80));
            Toast.makeText(getApplicationContext(),
                    ("Fields are missing"), Toast.LENGTH_SHORT).show();
        }
        if (mob.getText().toString().isEmpty()) {
            validate = false;
            mob.setHintTextColor(Color.RED);
            mob.setBackgroundColor(Color.red(80));
            Toast.makeText(getApplicationContext(),
                    ("Fields are missing"), Toast.LENGTH_SHORT).show();
        }

        if (enroll.getText().toString().isEmpty()) {
            validate = false;
            enroll.setHintTextColor(Color.RED);
            enroll.setBackgroundColor(Color.red(80));
            Toast.makeText(getApplicationContext(),
                    ("Fields are missing"), Toast.LENGTH_SHORT).show();
        }

        if (pass.getText().toString().isEmpty()) {
            validate = false;
            pass.setHintTextColor(Color.RED);
            pass.setBackgroundColor(Color.red(80));
            Toast.makeText(getApplicationContext(),
                    ("Fields are missing"), Toast.LENGTH_SHORT).show();
        }
        return validate;
    }
}
