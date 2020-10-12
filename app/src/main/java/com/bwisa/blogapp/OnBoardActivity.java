package com.bwisa.blogapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.net.sip.SipSession;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bwisa.blogapp.Adapters.ViewPagerAdapter;

public class OnBoardActivity extends AppCompatActivity {

    //3.1 assign the adapter to viewPager
    private ViewPager viewPager;
    private Button btnLeft, btnRight;
    private ViewPagerAdapter adapter;
    private LinearLayout dotsLayout;
    private TextView[] dots;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_on_board);
        //3.2
        init();
    }

    private void init() {
        //3.3 connect views
        viewPager = findViewById(R.id.view_pager);
        btnLeft = findViewById(R.id.btnLeft);
        btnRight = findViewById(R.id.btnRight);
        dotsLayout = findViewById(R.id.dotsLayout);
        adapter = new ViewPagerAdapter(this);
        //3.5
        addDots(0);
        viewPager.addOnPageChangeListener(listener);
        viewPager.setAdapter(adapter);

        //3.7 add onClickListener for the btns
        btnRight.setOnClickListener(v->{
            //3.7.2 if btn txt is next, go to next pg of view pager
                if (btnRight.getText().toString().equals("Next")){
                    viewPager.setCurrentItem(viewPager.getCurrentItem()+1);
                }
                else {
                    //3.7.3 if its finish start Auth Activity
                    startActivity(new Intent(OnBoardActivity.this,AuthActivity.class));
                    finish();
                }
        });

        btnLeft.setOnClickListener(v->{
            //3.8 if btn skip clicked got to pg 3
            viewPager.setCurrentItem(viewPager.getCurrentItem()+2);
        });
    }

    //3.4.1 method to create dots from html code
    private void addDots(int position){
        dotsLayout.removeAllViews();
        dots = new TextView[3];
        for (int i = 0; i < dots.length; i++){
           dots[i] = new TextView(this);
           //3.4.2 this html code creates dot
            dots[i].setText(Html.fromHtml("&#8226"));
            dots[i].setTextSize(35);
            dots[i].setTextColor(getResources().getColor(R.color.colorLightGrey));
            dotsLayout.addView(dots[i]);
        }

        //3.4.3 change the selected dot color
        if (dots.length>0){
            dots[position].setTextColor(getResources().getColor(R.color.colorGrey));
        }
    }

    //3.6.1 create a listener
    private ViewPager.OnPageChangeListener listener = new ViewPager.OnPageChangeListener() {
        @Override
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

        }

        @Override
        public void onPageSelected(int position) {
            addDots(position);
            //3.6.2 change text of next btn to finish if we reach pg 3
            //and hide skip btn if not in pg 1
            if (position==0){
                btnLeft.setVisibility(View.VISIBLE);
                btnLeft.setEnabled(true);
                btnRight.setText("Next");
            }
            else if (position==1){
                btnLeft.setVisibility(View.GONE);
                btnLeft.setEnabled(false);
                btnRight.setText("Next");
            }
            else {
                btnLeft.setVisibility(View.VISIBLE);
                btnLeft.setEnabled(false);
                btnRight.setText("Finish");
            }

        }

        @Override
        public void onPageScrollStateChanged(int state) {

        }
    };
}