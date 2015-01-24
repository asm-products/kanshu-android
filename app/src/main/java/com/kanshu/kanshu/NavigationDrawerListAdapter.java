package com.kanshu.kanshu;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;


public class NavigationDrawerListAdapter extends ArrayAdapter<String> {
    private Activity parentContext;
    public NavigationDrawerListAdapter(Context context, int resource, String[] objects) {
        super(context, resource, objects);
        parentContext = (Activity) context;
    }

    public View getView(int position, View convertView, ViewGroup parent) {

        // First let's verify the convertView is not null
        if (convertView == null) {
            // This a new view we inflate the new layout
            LayoutInflater inflater = (LayoutInflater) parentContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            switch(position % 4) {
                case 0:
                convertView = inflater.inflate(R.layout.navigation_drawer_user_card, parent, false);
                    break;
                case 1:
                    convertView = inflater.inflate(R.layout.navigation_drawer_section_1, parent, false);
                    break;
                case 2:
                    convertView = inflater.inflate(R.layout.navigation_drawer_section_2, parent, false);
                    break;
                case 3:
                    convertView = inflater.inflate(R.layout.navigation_drawer_section_3, parent, false);
                    break;
            }
        }

        return convertView;
    }
}
