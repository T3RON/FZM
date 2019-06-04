package ir.mseif.app.com.fzm;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.widget.Button;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.drawerlayout.widget.DrawerLayout;

import com.google.android.material.navigation.NavigationView;

import butterknife.BindView;
import butterknife.ButterKnife;
import ir.mseif.app.com.fzm.Activity.About;
import ir.mseif.app.com.fzm.Activity.Contact;
import ir.mseif.app.com.fzm.Activity.History;
import ir.mseif.app.com.fzm.Activity.Map;
import ir.mseif.app.com.fzm.Activity.ServiceInfo;
import ir.mseif.app.com.fzm.Activity.ServiceNotDone;
import ir.mseif.app.com.fzm.Activity.Profile;
import ir.mseif.app.com.fzm.Activity.ServiceToDo;
import ir.mseif.app.com.fzm.Activity.Wallet;
import uk.co.chrisjenx.calligraphy.CalligraphyContextWrapper;

public class MainActivity extends AppCompatActivity {


    @BindView(R.id.place_antenna) CardView place_antenna;
    @BindView(R.id.place_asansor) CardView place_asansor;
    @BindView(R.id.place_camera) CardView place_camera;
    @BindView(R.id.place_chandelier) CardView place_chandelier;
    @BindView(R.id.place_cooler) CardView place_cooler;
    @BindView(R.id.place_electronicdevice) CardView place_electronicdevice;
    @BindView(R.id.place_electronicpanel) CardView place_electronicpanel;
    @BindView(R.id.place_generator) CardView place_generator;
    @BindView(R.id.place_iphon) CardView place_iphon;
    @BindView(R.id.place_lighting) CardView place_lighting;
    @BindView(R.id.place_santeral) CardView place_santeral;
    @BindView(R.id.place_security) CardView place_security;
    @BindView(R.id.place_shutterdoor) CardView place_shutterdoor;
    @BindView(R.id.place_socket) CardView place_socket;
    @BindView(R.id.place_wiring) CardView place_wiring;


    public DrawerLayout drawerLayout;
    public ActionBarDrawerToggle actionBarDrawerToggle;
    Button btn_nav;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        drawerLayout = findViewById(R.id.drawer_main);
        actionBarDrawerToggle = new ActionBarDrawerToggle(this,drawerLayout,R.string.Open,R.string.Close);
        actionBarDrawerToggle.setDrawerIndicatorEnabled(true);


        drawerLayout.addDrawerListener(actionBarDrawerToggle);
        actionBarDrawerToggle.syncState();

        NavigationView nav_view = findViewById(R.id.nav_view);

        getSupportActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        getSupportActionBar().setCustomView(R.layout.app_title);


        btn_nav = findViewById(R.id.btn_nav);




        nav_view.setNavigationItemSelectedListener(menuItem -> {
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
                Intent intent = new Intent(getApplicationContext(), ServiceInfo.class);
                startActivity(intent);
            }


            return true;
        });


        btn_nav.setOnClickListener(v -> {
            if (drawerLayout.isDrawerOpen(Gravity.RIGHT)) {
                drawerLayout.closeDrawer(Gravity.RIGHT);
            } else {
                drawerLayout.openDrawer(Gravity.RIGHT);
            }
        });


        // Go to Antenna Page
        place_antenna.setOnClickListener(v -> {
            Intent intent = new Intent(getApplicationContext(), Map.class);
            intent.putExtra("name", "antenna");
            startActivity(intent);
        });


        // Go to Asansor Page
        place_asansor.setOnClickListener(v -> {
            Intent intent = new Intent(getApplicationContext(), Map.class);
            intent.putExtra("name", "asansor");
            startActivity(intent);
        });


        // Go to Camera Page
        place_camera.setOnClickListener(v -> {
            Intent intent = new Intent(getApplicationContext(), Map.class);
            intent.putExtra("name", "camera");
            startActivity(intent);
        });


        // Go to Chandelier Page
        place_chandelier.setOnClickListener(v -> {
            Intent intent = new Intent(getApplicationContext(), Map.class);
            intent.putExtra("name", "chandelier");
            startActivity(intent);
        });


        // Go to Cooler Page
        place_cooler.setOnClickListener(v -> {
            Intent intent = new Intent(getApplicationContext(), Map.class);
            intent.putExtra("name", "cooler");
            startActivity(intent);
        });


        // Go to ElectronicDevice Page
        place_electronicdevice.setOnClickListener(v -> {
            Intent intent = new Intent(getApplicationContext(), Map.class);
            intent.putExtra("name", "electronicdevice");
            startActivity(intent);
        });


        // Go to ElectronicPanel Page
        place_electronicpanel.setOnClickListener(v -> {
            Intent intent = new Intent(getApplicationContext(), Map.class);
            intent.putExtra("name", "electronicpanel");
            startActivity(intent);
        });


        // Go to Generator Page
        place_generator.setOnClickListener(v -> {
            Intent intent = new Intent(getApplicationContext(), Map.class);
            intent.putExtra("name", "generator");
            startActivity(intent);
        });


        // Go to Iphon Page
        place_iphon.setOnClickListener(v -> {
            Intent intent = new Intent(getApplicationContext(), Map.class);
            intent.putExtra("name", "iphon");
            startActivity(intent);
        });


        // Go to Lighting Page
        place_lighting.setOnClickListener(v -> {
            Intent intent = new Intent(getApplicationContext(), Map.class);
            intent.putExtra("name", "lighting");
            startActivity(intent);
        });


        // Go to Santeral Page
        place_santeral.setOnClickListener(v -> {
            Intent intent = new Intent(getApplicationContext(), Map.class);
            intent.putExtra("name", "santeral");
            startActivity(intent);
        });


        // Go to Security Page
        place_security.setOnClickListener(v -> {
            Intent intent = new Intent(getApplicationContext(), Map.class);
            intent.putExtra("name", "security");
            startActivity(intent);
        });


        // Go to Shutter_Door Page
        place_shutterdoor.setOnClickListener(v -> {
            Intent intent = new Intent(getApplicationContext(), Map.class);
            intent.putExtra("name", "shutterdoor");
            startActivity(intent);
        });


        // Go to Socket Page
        place_socket.setOnClickListener(v -> {
            Intent intent = new Intent(getApplicationContext(), Map.class);
            intent.putExtra("name", "socket");
            startActivity(intent);
        });


        // Go to Wiring Page
        place_wiring.setOnClickListener(v -> {
            Intent intent = new Intent(getApplicationContext(), Map.class);
            intent.putExtra("name", "wiring");
            startActivity(intent);
        });



    }


    @Override
    protected void attachBaseContext(Context newBase) {
        super.attachBaseContext(CalligraphyContextWrapper.wrap(newBase));
    }
}
