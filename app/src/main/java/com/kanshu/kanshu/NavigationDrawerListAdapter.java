package com.kanshu.kanshu;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ColorMatrix;
import android.graphics.ColorMatrixColorFilter;
import android.graphics.Paint;
import android.graphics.drawable.BitmapDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;

import de.hdodenhof.circleimageview.CircleImageView;


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
            if(position == 0){
                CircleImageView pictureFrame = (CircleImageView) convertView.findViewById(R.id.user_avatar);
                LinearLayout linearLayout = (LinearLayout) convertView.findViewById(R.id.user_card_layout);
               //replace this with user avatar bitmap
                Bitmap profile = BitmapFactory.decodeResource(parentContext.getResources(),
                        R.drawable.kanshu);
                pictureFrame.setImageBitmap(profile);
                Bitmap filteredBitmap = Bitmap.createBitmap(profile.getWidth(),profile.getHeight(), Bitmap.Config.RGB_565);
                Canvas c = new Canvas(filteredBitmap);
                Paint red = new Paint();
                red.setColor(parentContext.getResources().getColor(R.color.primary_dark_red));
                c.drawRect(0,0,profile.getWidth(),profile.getHeight(),red);
                Paint paint = new Paint();
                float[] mat = new float[]{
                        0.5f, 0.5f, 0.5f, 0, 0,
                        0.5f, 0.5f, 0.5f, 0, 0,
                        0.5f, 0.5f, 0.5f, 0, 0,
                        0, 0, 0, 0.2f, 0,};
                ColorMatrixColorFilter filter = new ColorMatrixColorFilter(mat);
                paint.setColorFilter(filter);
                c.drawBitmap(profile, 0, 0, paint);
                ImageView backgroundFrame = (ImageView) convertView.findViewById(R.id.background);
                backgroundFrame.setImageBitmap(filteredBitmap);
            }
        }

        return convertView;
    }
}
