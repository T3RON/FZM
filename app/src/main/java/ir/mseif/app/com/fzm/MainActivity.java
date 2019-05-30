package ir.mseif.app.com.fzm;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Gravity;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.view.ViewCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import com.bvapp.directionalsnackbar.SnackbarUtil;
import com.google.android.material.navigation.NavigationView;
import com.google.android.material.snackbar.Snackbar;
import com.mohamadamin.persianmaterialdatetimepicker.date.DatePickerDialog;
import com.mohamadamin.persianmaterialdatetimepicker.utils.PersianCalendar;


import butterknife.BindView;
import ir.mseif.app.com.fzm.Activity.About;
import ir.mseif.app.com.fzm.Activity.Contact;
import ir.mseif.app.com.fzm.Activity.History;
import ir.mseif.app.com.fzm.Activity.Map;
import ir.mseif.app.com.fzm.Activity.PayForService;
import ir.mseif.app.com.fzm.Activity.Profile;
import ir.mseif.app.com.fzm.Activity.Wallet;
import ir.mseif.app.com.fzm.Utils.Global;
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
                Intent intent = new Intent(getApplicationContext(), PayForService.class);
                startActivity(intent);
            }


            return true;
        });


        btn_nav.setOnClickListener(v -> {
            Snackbar snackbar = Snackbar.make(drawerLayout, "Simple Snackbar", Snackbar.LENGTH_LONG);
            snackbar.show();
        });

    }






    // Go to Camera Page
    public void PageCamera(View v){
        Intent intent = new Intent(getApplicationContext(), Map.class);
        intent.putExtra("name", "camera");
        startActivity(intent);
    }

    // Go to Iphon Page
    public void PageIphon(View v){
        Intent intent = new Intent(getApplicationContext(), Map.class);
        intent.putExtra("name", "iphon");
        startActivity(intent);
    }

    // Go to Asansor Page
    public void PageAsansor(View v){
        Intent intent = new Intent(getApplicationContext(), Map.class);
        intent.putExtra("name", "asansor");
        startActivity(intent);
    }

    // Go to Santeral Page
    public void PageSanteral(View v){
        Intent intent = new Intent(getApplicationContext(), Map.class);
        intent.putExtra("name", "santral");
        startActivity(intent);
    }

    // Go to ElectronicDevice Page
    public void PageElectronicDevice(View v){
        Intent intent = new Intent(getApplicationContext(), Map.class);
        intent.putExtra("name", "electronicdevice");
        startActivity(intent);
    }

    // Go to Wiring Page
    public void PageWiring(View v){
        Intent intent = new Intent(getApplicationContext(), Map.class);
        intent.putExtra("name", "wiring");
        startActivity(intent);
    }

    // Go to ElectronicPanel Page
    public void PageElectronicPanel(View v){
        Intent intent = new Intent(getApplicationContext(), Map.class);
        intent.putExtra("name", "electronicpanel");
        startActivity(intent);
    }

    // Go to Shutter_Door Page
    public void PageShutterDoor(View v){
        Intent intent = new Intent(getApplicationContext(), Map.class);
        intent.putExtra("name", "shutterdoor");
        startActivity(intent);
    }

    // Go to Antenna Page
    public void PageAntenna(View v){
        Intent intent = new Intent(getApplicationContext(), Map.class);
        intent.putExtra("name", "antenna");
        startActivity(intent);
    }

    // Go to Lighting Page
    public void PageLighting(View v){
        Intent intent = new Intent(getApplicationContext(), Map.class);
        intent.putExtra("name", "lighting");
        startActivity(intent);
    }

    // Go to Security Page
    public void PageSecurity(View v){
        Intent intent = new Intent(getApplicationContext(), Map.class);
        intent.putExtra("name", "security");
        startActivity(intent);
    }

    // Go to Generator Page
    public void PageGenerator(View v){
        Intent intent = new Intent(getApplicationContext(), Map.class);
        intent.putExtra("name", "generator");
        startActivity(intent);
    }

    // Go to Cooler Page
    public void PageCooler(View v){
        Intent intent = new Intent(getApplicationContext(), Map.class);
        intent.putExtra("name", "cooler");
        startActivity(intent);
    }

    // Go to Chandelier Page
    public void PageChandelier(View v){
        Intent intent = new Intent(getApplicationContext(), Map.class);
        intent.putExtra("name", "chandelier");
        startActivity(intent);
    }
    // Go to Socket Page
    public void PageSocket(View v){
        Intent intent = new Intent(getApplicationContext(), Map.class);
        intent.putExtra("name", "socket");
        startActivity(intent);

    }

//snack red
//        SnackbarUtil.setSnackBarWithNoActionButton(v,"شماره همراه نامعتبر است",
//        Color.rgb(255,255,255),
//        Color.rgb(232,59,58)
//            ,null,12, SnackbarUtil.RTL_DIRECTION);

//    snack green
//        SnackbarUtil.setSnackBarWithNoActionButton(v,"شماره همراه نامعتبر است",
//        Color.rgb(255,255,255),
//        Color.rgb(35,144,3)
//            ,null,12, SnackbarUtil.RTL_DIRECTION);


    @Override
    protected void attachBaseContext(Context newBase) {
        super.attachBaseContext(CalligraphyContextWrapper.wrap(newBase));
    }
}
