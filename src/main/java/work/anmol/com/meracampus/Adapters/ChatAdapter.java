package work.anmol.com.meracampus.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

import work.anmol.com.meracampus.Models.Chat;
import work.anmol.com.meracampus.R;

public class ChatAdapter extends ArrayAdapter<Chat> {
    public ChatAdapter(Context context, List<Chat> object) {
        super(context, R.layout.single_chat_item, object);

    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflate = LayoutInflater.from(getContext());
        View rootView = inflate.inflate(R.layout.single_chat_item, parent, false);
        Chat entity = getItem(position);
        TextView tvNamec = (TextView) rootView.findViewById(R.id.tvPersonName);
        TextView tvMessage = (TextView) rootView.findViewById(R.id.tvMessage);
        TextView tvDate = (TextView) rootView.findViewById(R.id.tvDate);
        tvDate.setText(entity.date);
        tvNamec.setText(entity.name);
        tvMessage.setText(entity.message);
        /*ImageView iv = (ImageView) rootView.findViewById(R.id.ivProfPic);
        iv.setImageResource(R.drawable.user_profile);*/
        return rootView;

    }
}
