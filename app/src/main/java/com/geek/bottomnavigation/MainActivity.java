package com.geek.bottomnavigation;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.os.Bundle;
import android.view.FrameMetrics;
import android.view.Menu;
import android.view.MenuItem;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Toast;

import com.geek.bottomnavigation.databinding.ActivityMainBinding;
import com.geek.bottomnavigation.fragments.DashFragment;
import com.geek.bottomnavigation.fragments.HomeFragment;
import com.geek.bottomnavigation.fragments.NotificationFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.sql.RowId;

public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding binding;
    private HomeFragment homeFragment = new HomeFragment();
    private DashFragment dashFragment = new DashFragment();
    private NotificationFragment notificationFragment = new NotificationFragment();
    private FragmentManager fn = getSupportFragmentManager();
    Fragment active = homeFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        setSupportActionBar(binding.toolbar);

        binding.bottomNav.setOnNavigationItemSelectedListener(listener);

        fn.beginTransaction().add(R.id.cont, notificationFragment, "notification").hide(notificationFragment).commit();
        fn.beginTransaction().add(R.id.cont, dashFragment, "dash").hide(dashFragment).commit();
        fn.beginTransaction().add(R.id.cont,homeFragment).commit();

    }

    private BottomNavigationView.OnNavigationItemSelectedListener listener =
            item -> {
                switch (item.getItemId()) {
                    case R.id.home_fragment:
                        fn.beginTransaction().hide(active).hide(active).show(homeFragment).commit();
                        active = homeFragment;
                        return true;
                    case R.id.dashboard_fragment:
                        fn.beginTransaction().hide(active).hide(active).show(dashFragment).commit();
                        active = dashFragment;
                        return true;
                    case R.id.notification_fragment:
                        fn.beginTransaction().hide(active).hide(active).show(notificationFragment).commit();
                        active = notificationFragment;
                        return true;
                }
                return false;
            };

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.toolbar_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == R.id.settings) {

        }
        return super.onOptionsItemSelected(item);
    }
}