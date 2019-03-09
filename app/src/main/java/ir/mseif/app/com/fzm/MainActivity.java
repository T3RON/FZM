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

    // Go to E_Device Page
    public void page_e_device (View v){
        Intent intent = new Intent(getApplicationContext(), E_Device.class);
        startActivity(intent);
    }

    // Go to Wiring Page
    public void page_wiring (View v){
        Intent intent = new Intent(getApplicationContext(), Wiring.class);
        startActivity(intent);
    }

    // Go to E_Panel Page
    public void page_e_panel (View v){
        Intent intent = new Intent(getApplicationContext(), E_panel.class);
        startActivity(intent);
    }

    // Go to Shutter_Door Page
    public void page_shutter_door (View v){
        Intent intent = new Intent(getApplicationContext(), Shutter_Door.class);
        startActivity(intent);
    }

    // Go to Antenna Page
    public void page_antenna (View v){
        Intent intent = new Intent(getApplicationContext(), Antenna.class);
        startActivity(intent);
    }

    // Go to Lighting Page
    public void page_lighting (View v){
        Intent intent = new Intent(getApplicationContext(), Lighting.class);
        startActivity(intent);
    }

    // Go to Security Page
    public void page_security (View v){
        Intent intent = new Intent(getApplicationContext(), Security.class);
        startActivity(intent);
    }

    // Go to Generator Page
    public void page_generator (View v){
        Intent intent = new Intent(getApplicationContext(), Generator.class);
        startActivity(intent);
    }

    // Go to Cooler Page
    public void page_cooler (View v){
        Intent intent = new Intent(getApplicationContext(), Cooler.class);
        startActivity(intent);
    }

    // Go to Chandelier Page
    public void page_chandelier (View v){
        Intent intent = new Intent(getApplicationContext(), Chandelier.class);
        startActivity(intent);
    }

    // Go to Socket Page
    public void page_socket (View v){
        Intent intent = new Intent(getApplicationContext(), Socket.class);
        startActivity(intent);
    }






    @Override
    protected void attachBaseContext(Context newBase) {
        super.attachBaseContext(CalligraphyContextWrapper.wrap(newBase));
    }
}
