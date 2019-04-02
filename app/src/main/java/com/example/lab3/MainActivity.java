package com.example.lab3;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.constraint.ConstraintLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    static final  int REQUEST_IMAGE_CAPTURE = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        //noinspection SimplifiableIfStatement
        switch (id) {
            case R.id.action_settings:
                Toast.makeText(getApplicationContext(), "Kliknieto przycisk action_settings", Toast.LENGTH_SHORT).show();
                break;
            case R.id.item1:
                Toast.makeText(getApplicationContext(), "Kliknieto przycisk Item1", Toast.LENGTH_SHORT).show();
                break;
            case R.id.item2:
                Toast.makeText(getApplicationContext(), "Kliknieto przycisk Item2", Toast.LENGTH_SHORT).show();
                break;
            case R.id.item3:
                Toast.makeText(getApplicationContext(), "Kliknieto przycisk Item3", Toast.LENGTH_SHORT).show();
                break;
        }


        return super.onOptionsItemSelected(item);
    }
    public void kliknij (View item) {
        Toast.makeText(getApplicationContext(), "Kliknieto przycisk Button", Toast.LENGTH_SHORT).show();
    }

    public void kliknij2 (View item2) {
        Intent intent = new Intent(this, LoginActivity.class);
        startActivity(intent);
    }

    public void kliknij3 (View item3) {
        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        startActivityForResult(intent, REQUEST_IMAGE_CAPTURE);
    }
    public void kliknij4 (View view) {
        Random rand = new Random();
        int value = rand.nextInt(4) + 1;
        Toast.makeText(getApplicationContext(), "" + value, Toast.LENGTH_SHORT).show();
        Button button = (Button) findViewById(R.id.button5);
        switch (value){
            case 1:
                button.setBackgroundResource(android.R.drawable.btn_star_big_off);
                break;
            case 2:
                button.setBackgroundResource(android.R.drawable.alert_light_frame);
                break;
            case 3:
                button.setBackgroundResource(android.R.drawable.arrow_down_float);
                break;
            case 4:
                button.setBackgroundResource(android.R.drawable.bottom_bar);
                break;
            default:
                button.setBackgroundResource(R.color.colorPrimary);
                break;
        }
    }

    @Override
    public void onActivityResult (int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK) {
            Bundle extras = data.getExtras();
            Bitmap imageBitmap = (Bitmap) extras.get("data");
            ConstraintLayout lay = findViewById(R.id.cont);
            lay.setBackground(new BitmapDrawable(getResources(), imageBitmap));
        }
   }
}
