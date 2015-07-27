package work.anmol.com.meracampus.Adapters;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.List;

import work.anmol.com.meracampus.Models.Message;
import work.anmol.com.meracampus.R;

public class MessageAdapter extends ArrayAdapter<Message> {
    public MessageAdapter(Context context, List<Message> ob) {
        super(context, R.layout.simple_message, ob);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater teacherInflater = LayoutInflater.from(getContext());
        View customView = teacherInflater.inflate(R.layout.simple_message, parent, false);
        Message entity = getItem(position);
        TextView tv = (TextView) customView.findViewById(R.id.tvMessageChat);
        tv.setText(entity.getMessage());
        LinearLayout layout = (LinearLayout) customView.findViewById(R.id.outerLayout);
        RelativeLayout.LayoutParams lp = (RelativeLayout.LayoutParams) layout.getLayoutParams();
        if (entity.isRecived()) {
            layout.setBackground(getContext().getResources().getDrawable(R.drawable.chat_bubble_sent));
            lp.setMargins(60, 5, 5, 5);
            layout.setPadding(10, 10, 10, 10);
            lp.addRule(RelativeLayout.ALIGN_PARENT_END);
        } else {
            layout.setBackground(getContext().getResources().getDrawable(R.drawable.chat_bubble));
            lp.setMargins(5, 5, 60, 5);
            lp.addRule(RelativeLayout.ALIGN_PARENT_START);
            layout.setPadding(10, 10, 10, 10);
        }
        return customView;
    }
}
