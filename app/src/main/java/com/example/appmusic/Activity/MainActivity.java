package com.example.appmusic.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;

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
        MainViewPagerAdapter mainViewPagerAdapter=new MainViewPagerAdapter(getSupportFragmentManager());
        mainViewPagerAdapter.addPrament(new Fragment_ca_nhan(),"ca nhan");
        mainViewPagerAdapter.addPrament(new Fragment_Trang_chu(),"trang tru");
        mainViewPagerAdapter.addPrament(new Fragment_Tim_Kiem()," tiem kiem");
        viewPager.setAdapter(mainViewPagerAdapter);
        tabLayout.setupWithViewPager(viewPager);
        tabLayout.getTabAt(0).setIcon(R.drawable.person);
        tabLayout.getTabAt(1).setIcon(R.drawable.icontrangchu);
        tabLayout.getTabAt(2).setIcon(R.drawable.ic_search_black_24dp);
    }
}
