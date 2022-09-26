package whatsapp.clone.azka.noreen;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.google.android.material.tabs.TabLayout;

import whatsapp.clone.azka.noreen.callhistory.CallHistoryFragment;

public class MainActivity extends AppCompatActivity {
    Toolbar toolbar;
    ViewPager viewPager;
    TabLayout tabLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbar=findViewById(R.id.wtoolbar);
        setSupportActionBar(toolbar); //set toolbar to act as action bar

        InitPagerView();

    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        //inflate the menu ,this adds items to action bar but here in toolbar
        getMenuInflater().inflate(R.menu.whatsappmenu,menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        int menuItemId=item.getItemId();
        if(menuItemId==R.id.quit){
            Toast.makeText(this, "Serach Clicked", Toast.LENGTH_SHORT).show();
        }
        return super.onOptionsItemSelected(item);
    }
    private void InitPagerView() {
        viewPager=findViewById(R.id.viewPager);
        tabLayout=findViewById(R.id.tabLayout);
        VIewPagerAdapter vpa=new VIewPagerAdapter(getSupportFragmentManager());

        vpa.addFragment(new ChatFragment(),"Chat");
        vpa.addFragment(new CallHistoryFragment(),"Call History");

        viewPager.setAdapter(vpa);
        //to set limit of initilaized fragment, by default 1( 1-current-1 )
        viewPager.setOffscreenPageLimit(3);
        tabLayout.setupWithViewPager(viewPager);

    }
}