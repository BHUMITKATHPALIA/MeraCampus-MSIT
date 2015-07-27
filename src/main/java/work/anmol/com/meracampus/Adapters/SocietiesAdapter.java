package work.anmol.com.meracampus.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

import work.anmol.com.meracampus.Models.Society;
import work.anmol.com.meracampus.R;

public class SocietiesAdapter extends ArrayAdapter<Society> {
    public SocietiesAdapter(Context context, List<Society> list) {
        super(context, R.layout.list_societies, list);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflate = LayoutInflater.from(getContext());
        View rootView = inflate.inflate(R.layout.list_societies, parent, false);
        Society entity = getItem(position);
        TextView tvSoc = (TextView) rootView.findViewById(R.id.tvSocityName);
        TextView tvMessage = (TextView) rootView.findViewById(R.id.tvMessgae);
        tvSoc.setText(entity.socName);
        tvMessage.setText(entity.socMessage);
        return rootView;
    }

}
