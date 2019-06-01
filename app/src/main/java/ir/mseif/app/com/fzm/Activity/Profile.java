package ir.mseif.app.com.fzm.Activity;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Gravity;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;


import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;

import com.google.android.material.navigation.NavigationView;

import butterknife.BindView;
import butterknife.ButterKnife;
import de.mateware.snacky.Snacky;
import ir.mseif.app.com.fzm.Model.AntenaModel;
import ir.mseif.app.com.fzm.R;
import ir.mseif.app.com.fzm.Services.Antenna;
import uk.co.chrisjenx.calligraphy.CalligraphyContextWrapper;

public class Profile extends AppCompatActivity {


    public DrawerLayout drawerLayout;
    public ActionBarDrawerToggle actionBarDrawerToggle;
    Button btn_nav;

    @BindView(R.id.img_profile) ImageView img_profile;
    @BindView(R.id.imgbtn_edit_img_profile) ImageButton imgbtn_edit_img_profile;
    @BindView(R.id.txt_profile_name) TextView txt_profile_name;
    @BindView(R.id.txt_profile_wallet) TextView txt_profile_wallet;
    @BindView(R.id.etx_profile_name) EditText etx_profile_name;
    @BindView(R.id.etx_profile_email) EditText etx_profile_email;
    @BindView(R.id.etx_profile_phone) EditText etx_profile_phone;
    @BindView(R.id.btn_accept) Button btn_accept;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        ButterKnife.bind(this);

        drawerLayout = findViewById(R.id.drawer_profile);
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

        btn_accept.setOnClickListener(v -> {
                    Snacky.builder()
                            .setActivity(Profile.this)
                            .setActionClickListener(v1 -> {
                                //do something
                            })
                            .setText("تغییرات ثبت شد")
                            .setTextColor(Color.rgb(255,255,255))
                            .setBackgroundColor(Color.rgb(35,144,3))
                            .setDuration(Snacky.LENGTH_LONG)
                            .build()
                            .show();

        });
    }






    @Override
    protected void attachBaseContext(Context newBase) {
        super.attachBaseContext(CalligraphyContextWrapper.wrap(newBase));
    }
}
