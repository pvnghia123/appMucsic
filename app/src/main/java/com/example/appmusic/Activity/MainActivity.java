package com.example.appmusic.Activity;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.widget.Toast;

import com.example.appmusic.Adapter.MainViewPagerAdapter;
import com.example.appmusic.Fragment.Fragment_Tim_Kiem;
import com.example.appmusic.Fragment.Fragment_Trang_chu;
import com.example.appmusic.Fragment.Fragment_ca_nhan;
import com.example.appmusic.R;
import com.google.android.material.tabs.TabLayout;

public class MainActivity extends AppCompatActivity {


    TabLayout tabLayout;
    ViewPager viewPager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        anhxa();
        init();
    }
    public void anhxa(){
        tabLayout=findViewById(R.id.mytablayout);
        viewPager =findViewById(R.id.myviewPage);
    }
    public void init(){
        final MainViewPagerAdapter mainViewPagerAdapter=new MainViewPagerAdapter(getSupportFragmentManager());
        mainViewPagerAdapter.addPrament(new Fragment_Trang_chu(),"trang chủ");
        mainViewPagerAdapter.addPrament(new Fragment_ca_nhan(),"cá nhân");
   //     mainViewPagerAdapter.addPrament(new Fragment_Tim_Kiem()," tiem kiem");
        viewPager.setAdapter(mainViewPagerAdapter);
        tabLayout.setupWithViewPager(viewPager);
        tabLayout.getTabAt(0).setIcon(R.drawable.icontrangchu);
        tabLayout.getTabAt(1).setIcon(R.drawable.person);
       // tabLayout.getTabAt(2).setIcon(R.drawable.ic_search_black_24dp);
        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
//             if(position==1){
//                 viewPager.getAdapter().notifyDataSetChanged();
//             }

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }

        });


    }
}
