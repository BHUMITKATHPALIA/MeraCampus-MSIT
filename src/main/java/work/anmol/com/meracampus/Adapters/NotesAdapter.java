package work.anmol.com.meracampus.Adapters;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

import work.anmol.com.meracampus.Models.Notes;
import work.anmol.com.meracampus.R;

public class NotesAdapter extends ArrayAdapter<Notes> {
    LayoutInflater inflater;
    Context context;


    public NotesAdapter(Context context, List<Notes> n) {
        super(context, R.layout.single_notes, n);
        this.context = context;

    }


    @Override
    public View getView(int position, View view, ViewGroup parent) {
        LayoutInflater inflater = LayoutInflater.from(getContext());

        View rootView = inflater.inflate(R.layout.single_notes, parent, false);
        Notes note = getItem(position);

        TextView etDescription = (TextView) rootView.findViewById(R.id.tvDescription);
        final TextView link = (TextView) rootView.findViewById(R.id.tvLink);
        link.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri uri = Uri.parse("https://www.google.com/search?q=" + link.getText());
                Intent gSearchIntent = new Intent(Intent.ACTION_VIEW, uri);
                gSearchIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                context.startActivity(gSearchIntent);
            }
        });

        etDescription.setText(note.getTopic());
        link.setText(note.getDescription());
        return rootView;
    }
}
