package com.example.savedata.wanted;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.viewpager.widget.ViewPager;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import android.os.Bundle;

import com.example.savedata.Fragment_evidence;
import com.example.savedata.R;
import com.example.savedata.criminal_case_fragment;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;

public class WantedActivity extends AppCompatActivity {

    NavController navController;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wanted);

        //navController = Navigation.findNavController(this, R.id.container_wanted);

        TabLayout tabLayout = findViewById(R.id.tabLayout);


        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());
        adapter.addFragment(new criminal_case_fragment(), "Criminal Cases");
        adapter.addFragment(new Fragment_evidence(), "Evidences");
        ViewPager viewPager = findViewById(R.id.viewPager);
        viewPager.setAdapter(adapter); // устанавливаем адаптер

        tabLayout.setupWithViewPager(viewPager);

        /*TabLayout.Tab criminal = tabLayout.newTab();
        criminal.setText("Criminal cases");
        criminal.setId(R.id.criminal_case_fragment);
        tabLayout.addTab(criminal);

        TabLayout.Tab evidence = tabLayout.newTab();
        evidence.setText("Evidence");
        evidence.setId(R.id.fragment_evidence);
        tabLayout.addTab(evidence);
        tabLayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                navController.navigate(tab.getId());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });*/
    }
    class ViewPagerAdapter extends FragmentPagerAdapter {

        List<Fragment> fragments = new ArrayList<>();
        List<String> fragmentsTitle = new ArrayList<>();

        public ViewPagerAdapter(@NonNull FragmentManager fm) {
            super(fm);
        }

        public void addFragment(Fragment fragment, String title){
            fragments.add(fragment);
            fragmentsTitle.add(title);
        }

        @NonNull
        @Override
        public Fragment getItem(int position) {
            return fragments.get(position);
        }

        @Override
        public int getCount() {
            return fragments.size();
        }

        @Nullable
        @Override
        public CharSequence getPageTitle(int position) {
            return fragmentsTitle.get(position);
        }
    }
}