package com.mce.iter_test1;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;

import com.mce.iter_test1.Fragment.FragMy;
import com.mce.iter_test1.Fragment.FragHome;
import com.mce.iter_test1.Fragment.FragSearch;
import com.mce.iter_test1.Fragment.FragFollow;
import com.mce.iter_test1.Fragment.FragExplorer;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {

    // 바텀 네비게이션
    BottomNavigationView bottomNavigationView;

    private String TAG = "메인";

    // 프래그먼트 변수
    Fragment fragment_home;
    Fragment fragment_follow;
    Fragment fragment_search;
    Fragment fragment_my;
    Fragment fragment_explorer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // 프래그먼트 생성
        fragment_my = new FragMy();
        fragment_follow = new FragFollow();
        fragment_search = new FragSearch();
        fragment_home = new FragHome();
        fragment_explorer = new FragExplorer();


        // 바텀 네비게이션
        bottomNavigationView = findViewById(R.id.bottomNavigationView);

        // 초기 플래그먼트 설정
        getSupportFragmentManager().beginTransaction().replace(R.id.main_layout, fragment_home).commitAllowingStateLoss();


        // 바텀 네비게이션
        bottomNavigationView = findViewById(R.id.bottomNavigationView);


        // 리스너 등록
        bottomNavigationView.setOnItemSelectedListener(new BottomNavigationView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                Log.i(TAG, "바텀 네비게이션 클릭");

                switch (item.getItemId()){
                    case R.id.home:
                        Log.i(TAG, "home");
                        getSupportFragmentManager().beginTransaction() .replace(R.id.main_layout,fragment_home).commitAllowingStateLoss();
                        return true;
                    case R.id.follow:
                        Log.i(TAG, "follow");
                        getSupportFragmentManager().beginTransaction() .replace(R.id.main_layout,fragment_follow).commitAllowingStateLoss();
                        return true;
                    case R.id.my:
                        Log.i(TAG, "my");
                        getSupportFragmentManager().beginTransaction() .replace(R.id.main_layout,fragment_my).commitAllowingStateLoss();
                        return true;
                    case R.id.search:
                        Log.i(TAG, "search");
                        getSupportFragmentManager().beginTransaction() .replace(R.id.main_layout,fragment_search).commitAllowingStateLoss();
                        return true;
                    case R.id.explorer:
                        Log.i(TAG, "explorer");
                        getSupportFragmentManager().beginTransaction() .replace(R.id.main_layout,fragment_explorer).commitAllowingStateLoss();
                        return true;
                }
                return true;
            }
        });




    }
}