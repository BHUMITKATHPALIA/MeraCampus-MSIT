package work.anmol.com.meracampus.ContentActivities.SecondaryActivities;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import work.anmol.com.meracampus.ContentActivities.NavDrawerActivities.NotesActivity;
import work.anmol.com.meracampus.DrawerActivity;
import work.anmol.com.meracampus.R;


public class AddNotesActivity extends DrawerActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_notes);

        Button bSub = (Button) findViewById(R.id.bSubnotes);
        bSub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "Added Successfully", Toast.LENGTH_LONG).show();
                startActivity(new Intent(getApplicationContext(), NotesActivity.class));
            }
        });
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
