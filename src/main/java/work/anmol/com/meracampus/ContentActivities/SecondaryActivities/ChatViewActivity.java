package work.anmol.com.meracampus.ContentActivities.SecondaryActivities;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import work.anmol.com.meracampus.Adapters.MessageAdapter;
import work.anmol.com.meracampus.DrawerActivity;
import work.anmol.com.meracampus.Models.Message;
import work.anmol.com.meracampus.R;


public class ChatViewActivity extends DrawerActivity {
    List<Message> chats;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat_view);

        String AB = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
        Random rnd = new Random();

        chats = new ArrayList<>();
        for (int i = 0; i < 120; i++) {
            int r = rnd.nextInt(7) + 3;
            StringBuilder sb = new StringBuilder(r);
            for (int k = 0; k < r; k++)
                sb.append(AB.charAt(rnd.nextInt(AB.length())));
            chats.add(new Message(sb.toString(), rnd.nextBoolean()));
        }

        ListView list = (ListView) findViewById(R.id.lvMessageChatView);
        MessageAdapter adapter = new MessageAdapter(getApplicationContext(), chats);
        list.setAdapter(adapter);
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
