package ir.mseif.app.com.fzm.Services;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;

import com.androidnetworking.AndroidNetworking;
import com.androidnetworking.common.Priority;
import com.androidnetworking.error.ANError;
import com.androidnetworking.interfaces.JSONArrayRequestListener;
import com.google.android.material.navigation.NavigationView;

import org.json.JSONArray;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import ir.mseif.app.com.fzm.Activity.About;
import ir.mseif.app.com.fzm.Activity.Contact;
import ir.mseif.app.com.fzm.Activity.History;
import ir.mseif.app.com.fzm.Activity.Map;
import ir.mseif.app.com.fzm.Activity.Profile;
import ir.mseif.app.com.fzm.Activity.Time;
import ir.mseif.app.com.fzm.Activity.Wallet;
import ir.mseif.app.com.fzm.Model.AntenaModel;
import ir.mseif.app.com.fzm.R;
import ir.mseif.app.com.fzm.Utils.Global;
import uk.co.chrisjenx.calligraphy.CalligraphyContextWrapper;

public class Antenna extends AppCompatActivity {


    public ActionBarDrawerToggle actionBarDrawerToggle;
    Button btn_nav;
    String antenJobText;
    String lat,lang;

    @BindView(R.id.spn_place) Spinner spn_place;
    @BindView(R.id.imgbtn_up) ImageButton Inc_number;
    @BindView(R.id.imgbtn_down) ImageButton Dec_number;
    @BindView(R.id.txt_number) TextView asansor_num;

    @BindView(R.id.etx_address) EditText etx_address;
    @BindView(R.id.etx_alley) EditText etx_alley;
    @BindView(R.id.etx_unit) EditText etx_unit;
    @BindView(R.id.etx_plaque) EditText etx_plaque;
    @BindView(R.id.etx_description_address) EditText etx_description_address;
    @BindView(R.id.btn_accept) Button btn_accept;
    @BindView(R.id.drawer_antenna)
    DrawerLayout drawerLayout;
    @BindView(R.id.nav_view)
    NavigationView nav_view;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_antenna);
        ButterKnife.bind(this);

        Bundle bundle = getIntent().getExtras();
        if (bundle != null) {
            lat = bundle.getString("lat");
            lang = bundle.getString("lang");
        }

        actionBarDrawerToggle = new ActionBarDrawerToggle(this,drawerLayout,R.string.Open,R.string.Close);
        actionBarDrawerToggle.setDrawerIndicatorEnabled(true);


        drawerLayout.addDrawerListener(actionBarDrawerToggle);
        actionBarDrawerToggle.syncState();


        getSupportActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        getSupportActionBar().setCustomView(R.layout.app_title);


        btn_nav = findViewById(R.id.btn_nav);



        Inc_number.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String A = INC(String.valueOf(asansor_num.getText()));
                asansor_num.setText(A);
            }
        });


        Dec_number.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String A = DEC(String.valueOf(asansor_num.getText()));
                asansor_num.setText(A);
            }
        });


        AntenJobs();


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



        btn_accept.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent antena_intent = new Intent(Antenna.this,Time.class);
                antena_intent.putExtra("name", "antena");
                AntenaModel.service_antenna_job = antenJobText;
                AntenaModel.service_antenna_number = asansor_num.getText().toString();
                AntenaModel.service_antenna_address = etx_address.getText().toString();
                AntenaModel.service_antenna_alley = etx_alley.getText() + "";
                AntenaModel.service_antenna_plaque = etx_plaque.getText() + "";
                AntenaModel.service_antenna_unit = etx_unit.getText().toString();
                AntenaModel.service_antenna_text = etx_description_address.getText().toString();
                AntenaModel.service_antenna_lat = lat;
                AntenaModel.service_antenna_sat = lang;
                AntenaModel.id = "1";
                AntenaModel.state_id = "1";
                startActivity(antena_intent);
            }
        });






    }

    // Increas the number of asansor
    private String INC (String a){
        int b = Integer.parseInt(a);
        b++;
        return String.valueOf(b);

    }

    // Decrease the number of asansor
    private String DEC (String a){
        int b = Integer.parseInt(a);
        if (b>0) {
            b--;
        }else {
            b=0;
        }
        return String.valueOf(b);
    }


    // Go To Time Activity
    public void GoToLocation(View v){
        Intent intent = new Intent(getApplicationContext(), Map.class);
        intent.putExtra("name", "antena");
        startActivity(intent);
    }



    public void AntenJobs() {
        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add("وصل کردن دوربین مداربسته به آنتن مرکزی");
        arrayList.add("نصب آنتن دیجیتال");
        arrayList.add("نصب آنتن مرکزی");
        arrayList.add("تحویل داخل هر واحد");
        arrayList.add("تنظیم آنتن");
        arrayList.add("رفع ایراد سیم\u200Cکشی");
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item, arrayList);
        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spn_place.setAdapter(arrayAdapter);
        spn_place.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                antenJobText = parent.getItemAtPosition(position).toString();
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });
    }

    @Override
    protected void attachBaseContext(Context newBase) {
        super.attachBaseContext(CalligraphyContextWrapper.wrap(newBase));
    }
}
