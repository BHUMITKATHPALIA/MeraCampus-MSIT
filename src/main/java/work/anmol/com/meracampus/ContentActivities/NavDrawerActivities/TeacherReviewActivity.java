package work.anmol.com.meracampus.ContentActivities.NavDrawerActivities;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import work.anmol.com.meracampus.Adapters.TeacherAdapter;
import work.anmol.com.meracampus.ContentActivities.SecondaryActivities.TeacherViewActivity;
import work.anmol.com.meracampus.DrawerActivity;
import work.anmol.com.meracampus.Models.Teacher;
import work.anmol.com.meracampus.R;


public class TeacherReviewActivity extends DrawerActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_teacher_review);

        List<Teacher> teacher = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            String name = "Mrs. Mam" + i;
            teacher.add(new Teacher(name));
        }
        ListView lV = (ListView) findViewById(R.id.lvTeachers);
        TeacherAdapter listAdapter = new TeacherAdapter(getApplicationContext(), teacher);
        lV.setAdapter(listAdapter);
        lV.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent i = new Intent(getApplicationContext(), TeacherViewActivity.class);
                startActivity(i);
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
