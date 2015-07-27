package work.anmol.com.meracampus.ContentActivities.NavDrawerActivities;

import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import work.anmol.com.meracampus.DrawerActivity;
import work.anmol.com.meracampus.R;


public class AssesmentActivity extends DrawerActivity {
    TextView text;
    Button bGo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_assesment);

        bGo = (Button) findViewById(R.id.bGo);
        text = (TextView) findViewById(R.id.tvResults);

        bGo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                text.setTextColor(Color.CYAN);
                text.setText("These fucntions will be available after the result");
            }
        });
    }

    @Override
    public void onResume() {
        super.onResume();
        SharedPreferences prefs = getSharedPreferences("meraCampus", MODE_PRIVATE);
        SharedPreferences.Editor edit = prefs.edit();
        edit.putString("activity_type", "navDrawer");
        edit.apply();
    }
}
