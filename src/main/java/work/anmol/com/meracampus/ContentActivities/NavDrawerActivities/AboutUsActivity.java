package work.anmol.com.meracampus.ContentActivities.NavDrawerActivities;

import android.content.SharedPreferences;
import android.os.Bundle;

import work.anmol.com.meracampus.DrawerActivity;
import work.anmol.com.meracampus.R;


public class AboutUsActivity extends DrawerActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about_us);
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
