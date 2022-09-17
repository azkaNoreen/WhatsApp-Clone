package whatsapp.clone.azka.noreen;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Toolbar toolbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbar=findViewById(R.id.wtoolbar);
        setSupportActionBar(toolbar); //set toolbar to act as action bar
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
}