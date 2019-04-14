package ir.mseif.app.com.fzm;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import ir.mseif.app.com.fzm.Activity.About;
import ir.mseif.app.com.fzm.Activity.Contact;
import ir.mseif.app.com.fzm.Activity.History;
import ir.mseif.app.com.fzm.Activity.Profile;
import ir.mseif.app.com.fzm.Activity.Wallet;
import ir.mseif.app.com.fzm.Services.Antenna;
import ir.mseif.app.com.fzm.Services.Camera;
import ir.mseif.app.com.fzm.Services.Chandelier;
import ir.mseif.app.com.fzm.Services.Cooler;
import ir.mseif.app.com.fzm.Services.E_Device;
import ir.mseif.app.com.fzm.Services.E_panel;
import ir.mseif.app.com.fzm.Services.Generator;
import ir.mseif.app.com.fzm.Services.Iphon;
import ir.mseif.app.com.fzm.Services.Lighting;
import ir.mseif.app.com.fzm.Services.Santeral;
import ir.mseif.app.com.fzm.Services.Security;
import ir.mseif.app.com.fzm.Services.Shutter_Door;
import ir.mseif.app.com.fzm.Services.Socket;
import ir.mseif.app.com.fzm.Services.Wiring;
import uk.co.chrisjenx.calligraphy.CalligraphyContextWrapper;

public class MainActivity extends AppCompatActivity {


    public DrawerLayout drawerLayout;
    public ActionBarDrawerToggle actionBarDrawerToggle;
    Button btn_nav;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        drawerLayout = findViewById(R.id.drawer_main);
        actionBarDrawerToggle = new ActionBarDrawerToggle(this,drawerLayout,R.string.Open,R.string.Close);
        actionBarDrawerToggle.setDrawerIndicatorEnabled(true);


        drawerLayout.addDrawerListener(actionBarDrawerToggle);
        actionBarDrawerToggle.syncState();

        NavigationView nav_view = findViewById(R.id.nav_view);

        getSupportActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        getSupportActionBar().setCustomView(R.layout.app_title);


        btn_nav = findViewById(R.id.btn_nav);




        nav_view.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                int id = menuItem.getItemId();

                if(id == R.id.profile){
                    Intent intent = new Intent(getApplicationContext(), Profile.class);
                    startActivity(intent);
                }else if(id == R.id.lastservice){
                    Intent intent = new Intent(getApplicationContext(), History.class);
                    startActivity(intent);
                }else if(id == R.id.wallet){
                    Intent intent = new Intent(getApplicationContext(), Wallet.class);
                    startActivity(intent);
                }else if(id == R.id.contact){
                    Intent intent = new Intent(getApplicationContext(), Contact.class);
                    startActivity(intent);
                }else if(id == R.id.about){
                    Intent intent = new Intent(getApplicationContext(), About.class);
                    startActivity(intent);
                }else if(id == R.id.exit_app){
                }


                return true;
            }
        });


        btn_nav.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (drawerLayout.isDrawerOpen(Gravity.RIGHT)) {
                    drawerLayout.closeDrawer(Gravity.RIGHT);
                } else {
                    drawerLayout.openDrawer(Gravity.RIGHT);
                }
            }
        });
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
