package ir.mseif.app.com.fzm.Activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.android.material.navigation.NavigationView;

import butterknife.BindView;
import butterknife.ButterKnife;
import de.hdodenhof.circleimageview.CircleImageView;
import ir.mseif.app.com.fzm.R;
import uk.co.chrisjenx.calligraphy.CalligraphyContextWrapper;

public class ServiceInfo extends AppCompatActivity {

    public DrawerLayout drawerLayout;
    public ActionBarDrawerToggle actionBarDrawerToggle;
    Button btn_nav;

    @BindView(R.id.txt_date) TextView txt_date;
    @BindView(R.id.txt_service_kind) TextView txt_service_kind;
    @BindView(R.id.txt_servicekar) TextView txt_servicekar;
    @BindView(R.id.img_service) CircleImageView img_service;
    @BindView(R.id.txt_price) TextView txt_price;
    @BindView(R.id.txt_description) TextView txt_description;
    @BindView(R.id.txt_type_vaziat) TextView txt_type_vaziat;
    @BindView(R.id.btn_accept) Button btn_accept;
    @BindView(R.id.btn_cancel) Button btn_cancel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_service_info);
        ButterKnife.bind(this);



        drawerLayout = findViewById(R.id.drawer_service_info);
        actionBarDrawerToggle = new ActionBarDrawerToggle(this, drawerLayout, R.string.Open, R.string.Close);
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

                if (id == R.id.profile) {
                    Intent intent = new Intent(getApplicationContext(), Profile.class);
                    startActivity(intent);
                } else if (id == R.id.lastservice) {
                    Intent intent = new Intent(getApplicationContext(), History.class);
                    startActivity(intent);
                } else if (id == R.id.wallet) {
                    Intent intent = new Intent(getApplicationContext(), Wallet.class);
                    startActivity(intent);
                } else if (id == R.id.contact) {
                    Intent intent = new Intent(getApplicationContext(), Contact.class);
                    startActivity(intent);
                } else if (id == R.id.about) {
                    Intent intent = new Intent(getApplicationContext(), About.class);
                    startActivity(intent);
                } else if (id == R.id.exit_app) {
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


        btn_accept.setOnClickListener(v -> {
            Dialog dialog = new Dialog(this);
            dialog.setContentView(R.layout.dialog_service);
            dialog.show();
        });
    }


    @Override
    protected void attachBaseContext(Context newBase) {
        super.attachBaseContext(CalligraphyContextWrapper.wrap(newBase));
    }
}