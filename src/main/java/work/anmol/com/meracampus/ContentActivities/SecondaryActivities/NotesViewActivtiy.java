package work.anmol.com.meracampus.ContentActivities.SecondaryActivities;

import android.content.SharedPreferences;
import android.os.Bundle;

import work.anmol.com.meracampus.DrawerActivity;
import work.anmol.com.meracampus.R;


public class NotesViewActivtiy extends DrawerActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notes_view_activtiy);
    }

    @Override
    public void onResume() {
        super.onResume();
        SharedPreferences prefs = getSharedPreferences("meraCampus", MODE_PRIVATE);
        SharedPreferences.Editor edit = prefs.edit();
        edit.putString("activity_type", "secondary");
        edit.apply();
    }
}
