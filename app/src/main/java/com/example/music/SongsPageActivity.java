package com.example.music;

import android.os.Bundle;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.tabs.TabLayout;
import androidx.annotation.NonNull;
import androidx.viewpager.widget.ViewPager;
import androidx.appcompat.app.AppCompatActivity;
import android.view.MenuItem;
import com.example.music.ui.main.SectionsPagerAdapter;
import com.example.music.databinding.ActivitySongsPageBinding;

public class SongsPageActivity extends AppCompatActivity {
    BottomNavigationView bottomNav;
    ViewPager viewPager;
    private ActivitySongsPageBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivitySongsPageBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        SectionsPagerAdapter sectionsPagerAdapter = new SectionsPagerAdapter(this, getSupportFragmentManager());
        ViewPager viewPager = binding.viewPager;
        viewPager.setAdapter(sectionsPagerAdapter);
        TabLayout tabs = binding.tabs;
        tabs.setupWithViewPager(viewPager);
        bottomNav=findViewById(R.id.bottom_navigation);
        bottomNav.setOnNavigationItemSelectedListener(navlistener);
        getSupportFragmentManager().beginTransaction().replace(R.id.view_pager,new HomeFragment()).commit();
    }

    private BottomNavigationView.OnNavigationItemSelectedListener navlistener = new BottomNavigationView.OnNavigationItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            viewPager = findViewById(R.id.view_pager);
            switch (item.getItemId())
            {
                case R.id.nav_home:
                    viewPager.setCurrentItem(0);
                    return true;
                case R.id.nav_library:
                    viewPager.setCurrentItem(1);
                    return true;
                case R.id.nav_settings:
                    viewPager.setCurrentItem(2);
                    return true;
                case R.id.nav_exit:
                    viewPager.setCurrentItem(3);
                    return true;
            }
            return  false;
        }
    };

}
