package work.anmol.com.meracampus.ContentActivities.SecondaryActivities;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import work.anmol.com.meracampus.DrawerActivity;
import work.anmol.com.meracampus.R;


public class TeacherViewActivity extends DrawerActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_teacher_view);

        String[] list = {"This is Awesome", "I just want to say that thanks for being our teacher", "Mam you're really a rockstar", "Five outta five", "Cant believe i am giving marks to a teacher"};
        ArrayAdapter<String> adapter = new ArrayAdapter<>(getApplicationContext(), R.layout.teacher_comments_list, R.id.tvListTeachers, list);
        ListView listView = (ListView) findViewById(R.id.lvReviews);
        listView.setAdapter(adapter);
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
