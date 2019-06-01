package ir.mseif.app.com.fzm.Services;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Gravity;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;

import com.google.android.material.navigation.NavigationView;

import butterknife.BindView;
import butterknife.ButterKnife;
import de.mateware.snacky.Snacky;
import ir.mseif.app.com.fzm.Activity.About;
import ir.mseif.app.com.fzm.Activity.Contact;
import ir.mseif.app.com.fzm.Activity.History;
import ir.mseif.app.com.fzm.Activity.Profile;
import ir.mseif.app.com.fzm.Activity.Time;
import ir.mseif.app.com.fzm.Activity.Wallet;
import ir.mseif.app.com.fzm.R;
import uk.co.chrisjenx.calligraphy.CalligraphyContextWrapper;

public class ShutterDoor extends AppCompatActivity {


    public DrawerLayout drawerLayout;
    public ActionBarDrawerToggle actionBarDrawerToggle;
    Button btn_nav;
    String lat,lang;

    @BindView(R.id.spn_brand) Spinner spn_brand;
    @BindView(R.id.spn_job) Spinner spn_job;
    @BindView(R.id.spn_kind) Spinner spn_kind;
    @BindView(R.id.etx_number_remote) EditText etx_number_remote;
    @BindView(R.id.etx_description_karshenas) EditText etx_description_karshenas;

    @BindView(R.id.etx_address) EditText etx_address;
    @BindView(R.id.etx_alley) EditText etx_alley;
    @BindView(R.id.etx_unit) EditText etx_unit;
    @BindView(R.id.etx_plaque) EditText etx_plaque;
    @BindView(R.id.etx_description_address) EditText etx_description_address;
    @BindView(R.id.btn_accept) Button btn_accept;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shutter_door);
        ButterKnife.bind(this);

        Bundle bundle = getIntent().getExtras();
        if (bundle != null) {
            lat = bundle.getString("lat");
            lang = bundle.getString("lang");
        }

        drawerLayout = findViewById(R.id.drawer_shutter_door);
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


            if (etx_number_remote.getText().toString().length() == 0){
                Snacky.builder()
                        .setActivity(ShutterDoor.this)
                        .setActionClickListener(v1 -> {
                            //do something
                        })
                        .setText("تعداد ریموت نمی تواند ۰ باشد")
                        .setTextColor(Color.rgb(255,255,255))
                        .setBackgroundColor(Color.rgb(232,59,58))
                        .setDuration(Snacky.LENGTH_LONG)
                        .build()
                        .show();
            }else{
                if (etx_description_karshenas.getText().toString().length() == 0){
                    Snacky.builder()
                            .setActivity(ShutterDoor.this)
                            .setActionClickListener(v1 -> {
                                //do something
                            })
                            .setText("فیلد توضیحات کارشناس نمی تواند خالی باشد")
                            .setTextColor(Color.rgb(255,255,255))
                            .setBackgroundColor(Color.rgb(232,59,58))
                            .setDuration(Snacky.LENGTH_LONG)
                            .build()
                            .show();

                }else{
                    if (etx_address.getText().toString().length() == 0) {
                        Snacky.builder()
                                .setActivity(ShutterDoor.this)
                                .setActionClickListener(v1 -> {
                                    //do something
                                })
                                .setText("فیلد آدرس نمی تواند خالی باشد")
                                .setTextColor(Color.rgb(255,255,255))
                                .setBackgroundColor(Color.rgb(232,59,58))
                                .setDuration(Snacky.LENGTH_LONG)
                                .build()
                                .show();

                    } else {
                        if (etx_alley.getText().toString().length() == 0) {
                            Snacky.builder()
                                    .setActivity(ShutterDoor.this)
                                    .setActionClickListener(v1 -> {
                                        //do something
                                    })
                                    .setText("فیلد کوچه نمی تواند خالی باشد")
                                    .setTextColor(Color.rgb(255,255,255))
                                    .setBackgroundColor(Color.rgb(232,59,58))
                                    .setDuration(Snacky.LENGTH_LONG)
                                    .build()
                                    .show();

                        } else {
                            if (etx_plaque.getText().toString().length() == 0) {
                                Snacky.builder()
                                        .setActivity(ShutterDoor.this)
                                        .setActionClickListener(v1 -> {
                                            //do something
                                        })
                                        .setText("فیلد پلاک نمی تواند خالی باشد")
                                        .setTextColor(Color.rgb(255,255,255))
                                        .setBackgroundColor(Color.rgb(232,59,58))
                                        .setDuration(Snacky.LENGTH_LONG)
                                        .build()
                                        .show();

                            } else {
                                if (etx_unit.getText().toString().length() == 0) {
                                    Snacky.builder()
                                            .setActivity(ShutterDoor.this)
                                            .setActionClickListener(v1 -> {
                                                //do something
                                            })
                                            .setText("فیلد واحد نمی تواند خالی باشد")
                                            .setTextColor(Color.rgb(255,255,255))
                                            .setBackgroundColor(Color.rgb(232,59,58))
                                            .setDuration(Snacky.LENGTH_LONG)
                                            .build()
                                            .show();

                                } else {
                                    if (etx_description_address.getText().toString().length() == 0) {
                                        Snacky.builder()
                                                .setActivity(ShutterDoor.this)
                                                .setActionClickListener(v1 -> {
                                                    //do something
                                                })
                                                .setText("فیلد توضیحات نمی تواند خالی باشد")
                                                .setTextColor(Color.rgb(255,255,255))
                                                .setBackgroundColor(Color.rgb(232,59,58))
                                                .setDuration(Snacky.LENGTH_LONG)
                                                .build()
                                                .show();

                                    } else {
                                        Intent shutterdoor_intent = new Intent(ShutterDoor.this, Time.class);
                                        startActivity(shutterdoor_intent);
                                    }
                                }
                            }
                        }
                    }
                }
            }
        });
    }





    @Override
    protected void attachBaseContext(Context newBase) {
        super.attachBaseContext(CalligraphyContextWrapper.wrap(newBase));
    }
}
