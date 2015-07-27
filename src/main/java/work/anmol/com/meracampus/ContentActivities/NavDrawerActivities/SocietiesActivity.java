package work.anmol.com.meracampus.ContentActivities.NavDrawerActivities;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import work.anmol.com.meracampus.Adapters.SocietiesAdapter;
import work.anmol.com.meracampus.DrawerActivity;
import work.anmol.com.meracampus.Models.Society;
import work.anmol.com.meracampus.R;


public class SocietiesActivity extends DrawerActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_societies);

        ListView list = (ListView) findViewById(R.id.lvSocity);
        List<Society> listOfSocity = new ArrayList<Society>();

        listOfSocity.add(new Society("MUGD", "Connect Delhi"));
        listOfSocity.add(new Society("Microsoft User Group Delhi", "Connect Delhi"));
        listOfSocity.add(new Society("IEEE", "Seminar on Hacking"));
        listOfSocity.add(new Society("Prakriti", "Environmental Drive"));
        listOfSocity.add(new Society("MUGD", "Connect Delhi"));

        SocietiesAdapter adapter = new SocietiesAdapter(getApplicationContext(), listOfSocity);
        list.setAdapter(adapter);
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
