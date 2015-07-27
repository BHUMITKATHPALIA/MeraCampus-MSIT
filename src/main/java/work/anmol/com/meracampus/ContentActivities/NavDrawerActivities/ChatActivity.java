package work.anmol.com.meracampus.ContentActivities.NavDrawerActivities;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import work.anmol.com.meracampus.Adapters.ChatAdapter;
import work.anmol.com.meracampus.ContentActivities.SecondaryActivities.ChatViewActivity;
import work.anmol.com.meracampus.DrawerActivity;
import work.anmol.com.meracampus.Models.Chat;
import work.anmol.com.meracampus.R;


public class ChatActivity extends DrawerActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat);

        List<Chat> chats = new ArrayList<>();

        chats.add(new Chat("Anmol", "Hey", "11-2-01"));
        chats.add(new Chat("Dher pal", "Can you please send me the notes?", "10-11-16"));
        chats.add(new Chat("Jatin", "Man down", "10-11-12"));
        chats.add(new Chat("Sachin", "Roger that", "11-9-15"));
        chats.add(new Chat("Shewag", "Since its been", "10-09-19"));
        chats.add(new Chat("Virat", "Some message", "12-08-11"));
        chats.add(new Chat("Gauti", "Some message", "19-2-13"));
        chats.add(new Chat("Raina", "Some message", "2-04-11"));
        chats.add(new Chat("Dhoni", "Some message", "11-9-15"));
        chats.add(new Chat("Bhuvi", "Some message with a random date", "11-9-15"));
        chats.add(new Chat("Shami", "POJO created", "11-9-15"));
        chats.add(new Chat("Pathan", "Some message with some text", "11-9-15"));
        chats.add(new Chat("A B Devilers", "Yeah thats mah man", "11-9-15"));
        chats.add(new Chat("Steve Smith", "Project endcode dutf-9", "11-9-15"));
        chats.add(new Chat("Chris Gayle", "Ductile frequency", "11-9-15"));
        chats.add(new Chat("Sachin Java", "POJO created", "11-9-15"));
        chats.add(new Chat("Reetika", "POJO created", "11-9-15"));
        chats.add(new Chat("Shreesanth", "POJO created", "11-9-15"));
        chats.add(new Chat("Bhumit", "Happy bday ", "10-11-12"));
        ListView list = (ListView) findViewById(R.id.lvChats);
        ChatAdapter adapter = new ChatAdapter(getApplicationContext(), chats);
        list.setAdapter(adapter);
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                startActivity(new Intent(getApplicationContext(), ChatViewActivity.class));
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
