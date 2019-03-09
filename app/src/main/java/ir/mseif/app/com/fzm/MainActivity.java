package ir.mseif.app.com.fzm;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import uk.co.chrisjenx.calligraphy.CalligraphyContextWrapper;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }






    // Go to Camera Page
    public void page_camera (View v){
        Intent intent = new Intent(getApplicationContext(), Camera.class);
        startActivity(intent);
    }

    // Go to Iphon Page
    public void page_iphon (View v){
        Intent intent = new Intent(getApplicationContext(), Iphon.class);
        startActivity(intent);
    }

    // Go to Asansor Page
    public void page_asansor (View v){
        Intent intent = new Intent(getApplicationContext(), Asansor.class);
        startActivity(intent);
    }

    // Go to Santeral Page
    public void page_santeral (View v){
        Intent intent = new Intent(getApplicationContext(), Santeral.class);
        startActivity(intent);
    }

    // Go to Wiring Page
    public void page_wiring (View v){
        Intent intent = new Intent(getApplicationContext(), Wiring.class);
        startActivity(intent);
    }

    // Go to Antenna Page
    public void page_e_panel (View v){
        Intent intent = new Intent(getApplicationContext(), E_panel.class);
        startActivity(intent);
    }

    // Go to Antenna Page
    public void page_antenna (View v){
        Intent intent = new Intent(getApplicationContext(), Antenna.class);
        startActivity(intent);
    }






    @Override
    protected void attachBaseContext(Context newBase) {
        super.attachBaseContext(CalligraphyContextWrapper.wrap(newBase));
    }
}
