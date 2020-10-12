package com.bwisa.blogapp.Adapters;

import android.content.Context;
import android.speech.tts.TextToSpeech;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

import com.bwisa.blogapp.R;

public class ViewPagerAdapter extends PagerAdapter {
    //2.1 initialize variables
    private Context context;
    private LayoutInflater inflater;

    //2.2 generate constructor
    public ViewPagerAdapter(Context context) {
        this.context = context;
    }

    //2.3 add data for title, desc & img resources for imageview
    private int images[] = {
            R.drawable.p1,
            R.drawable.p2,
            R.drawable.p3,
    };

    private String titles[] ={
            "Learn",
            "Create",
            "Enjoy",
    };

    private String desc[] ={
            "Lorem ipsum dolor sit amet, consectetur adipiscing elit",
            "Lorem ipsum dolor sit amet, consectetur adipiscing elit",
            "Lorem ipsum dolor sit amet, consectetur adipiscing elit",
    };

    @Override
    public int getCount() {
        //2.4
        return titles.length;
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        //2.5 implement methods
        return view == (LinearLayout)object;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position){
        inflater = (LayoutInflater)context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
        View v = inflater.inflate(R.layout.view_pager, container, false);

        //2.6 initialize views
        ImageView imageView = v.findViewById(R.id.imgViewPager);
        TextView txtTitle = v.findViewById(R.id.txtTitleViewPager);
        TextView txtDesc = v.findViewById(R.id.txtDescViewPager);

        imageView.setImageResource(images[position]);
        txtTitle.setText(titles[position]);
        txtDesc.setText(desc[position]);

        container.addView(v);
        return v;
    }

    //2.7

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((LinearLayout)object);
    }
}
