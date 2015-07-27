package work.anmol.com.meracampus.ContentActivities.NavDrawerActivities;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import work.anmol.com.meracampus.Adapters.NotesAdapter;
import work.anmol.com.meracampus.ContentActivities.SecondaryActivities.AddNotesActivity;
import work.anmol.com.meracampus.ContentActivities.SecondaryActivities.NotesViewActivtiy;
import work.anmol.com.meracampus.DrawerActivity;
import work.anmol.com.meracampus.Models.Notes;
import work.anmol.com.meracampus.R;


public class NotesActivity extends DrawerActivity {
    Button bNotes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notes);

        bNotes = (Button) findViewById(R.id.bAddNotes);
        bNotes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), AddNotesActivity.class));
            }
        });
        List<Notes> obj = new ArrayList<>();
        obj.add(new Notes("Android", "Talking about intents"));
        obj.add(new Notes("Android", "Lets start a new activity"));
        obj.add(new Notes("Android", "Hello world"));
        obj.add(new Notes("Android", "Shared prefs"));
        obj.add(new Notes("Android", "Start activity for a result"));
        obj.add(new Notes("Android", "Databases"));
        obj.add(new Notes("Android", "Databases over a network"));
        obj.add(new Notes("Android", "SQLite, its really LITE"));
        obj.add(new Notes("Android", "PARSING JSON DATA"));
        obj.add(new Notes("Android", "Fragments"));
        obj.add(new Notes("Android", "Broadcast"));
        obj.add(new Notes("Android", "Services"));
        obj.add(new Notes("Android", "Best APP ever"));
        obj.add(new Notes("Android", "Custom UI"));

        ListView lv = (ListView) findViewById(R.id.lv123);
        NotesAdapter adapter = new NotesAdapter(getApplicationContext(), obj);
        lv.setAdapter(adapter);
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                startActivity(new Intent(getApplicationContext(), NotesViewActivtiy.class));
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
