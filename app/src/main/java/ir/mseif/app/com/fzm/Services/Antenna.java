package ir.mseif.app.com.fzm.Services;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import ir.mseif.app.com.fzm.Activity.Time;
import ir.mseif.app.com.fzm.MainActivity;
import ir.mseif.app.com.fzm.Activity.Map;
import ir.mseif.app.com.fzm.R;
import uk.co.chrisjenx.calligraphy.CalligraphyContextWrapper;

public class Antenna extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_antenna);
    }



    // Go To Time Activity
    public void Go_To_Location (View v){
        Intent intent = new Intent(getApplicationContext(), Map.class);
        startActivity(intent);
    }


    // Go To Time Activity
    public void Go_To_Time (View v){
        Intent intent = new Intent(getApplicationContext(), Time.class);
        startActivity(intent);
    }


    @Override
    protected void attachBaseContext(Context newBase) {
        super.attachBaseContext(CalligraphyContextWrapper.wrap(newBase));
    }
}
