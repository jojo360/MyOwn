package fr.digitecgame.myown;

import android.content.Context;
import android.graphics.Typeface;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Digitec Game on 15/03/2018.
 */

public class ModuleAdapter extends ArrayAdapter<Module> {

    int resource;
    String response;
    Context context;

    public ModuleAdapter(Context context, int resource, List<Module> items) {
        super(context, resource, items);
        this.resource=resource;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent)
    {
        LinearLayout moduleView;
        Module module = getItem(position);
        if(convertView==null) {
            moduleView = new LinearLayout(getContext());
            String inflater = Context.LAYOUT_INFLATER_SERVICE;
            LayoutInflater vi;
            vi = (LayoutInflater)getContext().getSystemService(inflater);
            vi.inflate(resource, moduleView, true);
        } else {
            moduleView = (LinearLayout) convertView;
        }
        TextView moduleNom =(TextView)moduleView.findViewById(R.id.ModNom);
        moduleNom.setTypeface(null, Typeface.BOLD);
        moduleNom.setTextSize(TypedValue.COMPLEX_UNIT_PX,58);
        TextView moduleNote = (TextView)moduleView.findViewById(R.id.ModNote);
        moduleNote.setTextSize(TypedValue.COMPLEX_UNIT_PX,50);
        moduleNom.setText(module.getNom());
        moduleNote.setText(String.format ("%.2f", module.getNote()));
        return moduleView;
    }
}
