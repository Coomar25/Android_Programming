package com.example.assignment_menu_item;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.options, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int itemid = item.getItemId();
        switch (itemid){
            case R.id.bookmarks:
                Toast.makeText(this, "This is Bookmarks toast illustration", Toast.LENGTH_LONG).show();
                return true;

            case R.id.history:
                Toast.makeText(this,"This is history toast example", Toast.LENGTH_LONG).show();
                return true;
            case R.id.share:
                Toast.makeText(this,"This is share toast example", Toast.LENGTH_LONG).show();
                return true;
            case R.id.desktopsite:
                Toast.makeText(this,"This is desktopsite toast example", Toast.LENGTH_LONG).show();
                return true;
            default:
                Toast.makeText(this, "Wrong", Toast.LENGTH_SHORT).show();
                return super.onOptionsItemSelected(item);
        }
    }
}
