package ir.mseif.app.com.fzm.Services;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.RadioButton;
import android.widget.TextView;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;

import com.bvapp.directionalsnackbar.SnackbarUtil;
import com.google.android.material.navigation.NavigationView;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import ir.mseif.app.com.fzm.Activity.About;
import ir.mseif.app.com.fzm.Activity.Contact;
import ir.mseif.app.com.fzm.Activity.History;
import ir.mseif.app.com.fzm.Activity.Profile;
import ir.mseif.app.com.fzm.Activity.Time;
import ir.mseif.app.com.fzm.Activity.Wallet;
import ir.mseif.app.com.fzm.Model.AsansorModel;
import ir.mseif.app.com.fzm.R;
import uk.co.chrisjenx.calligraphy.CalligraphyContextWrapper;

public class Asansor extends AppCompatActivity {


    private DrawerLayout drawerLayout;
    private ActionBarDrawerToggle actionBarDrawerToggle;
    Button btn_nav;
    String asansorJobText;
    String engineText;
    String kindText;
    String lat,lang;

    @BindView(R.id.imgbtn_up) ImageButton Inc_number;
    @BindView(R.id.imgbtn_down) ImageButton Dec_number;
    @BindView(R.id.txt_number) TextView txt_number;

    @BindView(R.id.cb_nasb) CheckBox cb_nasb;
    @BindView(R.id.cb_repair) CheckBox cb_repair;
    @BindView(R.id.cb_other_kind) CheckBox cb_other_kind;

    @BindView(R.id.rb_nimeEsteal_nime) RadioButton rb_nimeEsteal_nime;
    @BindView(R.id.rb_nimeEsteal_auto) RadioButton rb_nimeEsteal_auto;
    @BindView(R.id.rb_tamamEsteal_nime) RadioButton rb_tamamEsteal_nime;
    @BindView(R.id.rb_tamamEsteal_tamam) RadioButton rb_tamamEsteal_tamam;

    @BindView(R.id.rb_nemidanam) RadioButton rb_nemidanam;
    @BindView(R.id.rb_irani) RadioButton rb_irani;
    @BindView(R.id.rb_khareji) RadioButton rb_khareji;

    @BindView(R.id.etx_address) EditText etx_address;
    @BindView(R.id.etx_alley) EditText etx_alley;
    @BindView(R.id.etx_unit) EditText etx_unit;
    @BindView(R.id.etx_plaque) EditText etx_plaque;
    @BindView(R.id.etx_description_address) EditText etx_description_address;
    @BindView(R.id.btn_accept) Button btn_accept;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_asansor);
        ButterKnife.bind(this);

        Bundle bundle = getIntent().getExtras();
        if (bundle != null) {
            lat = bundle.getString("lat");
            lang = bundle.getString("lang");
        }



        Inc_number.setOnClickListener(v -> {
            String A = INC(String.valueOf(txt_number.getText()));
            txt_number.setText(A);
        });


        Dec_number.setOnClickListener(v -> {
            String A = DEC(String.valueOf(txt_number.getText()));
            txt_number.setText(A);
        });










        drawerLayout = findViewById(R.id.drawer_asansor);
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

            if (Integer.parseInt((txt_number.getText().toString())) == 0){
                SnackbarUtil.setSnackBarWithNoActionButton(v,"تعداد آسانسور نمی تواند ۰ باشد",
                        Color.rgb(255,255,255),
                        Color.rgb(232,59,58)
                        ,null,12, SnackbarUtil.RTL_DIRECTION);
            }else{
                if ((!(cb_nasb.isChecked())) &&
                        (!(cb_repair.isChecked())) &&
                            (!(cb_other_kind.isChecked()))  ){
                    SnackbarUtil.setSnackBarWithNoActionButton(v,"بخش خدمت درخواستی نمی تواند خالی باشد",
                            Color.rgb(255,255,255),
                            Color.rgb(232,59,58)
                            ,null,12, SnackbarUtil.RTL_DIRECTION);

                }else{
                    if ((!(rb_nimeEsteal_nime.isChecked())) &&
                            (!(rb_nimeEsteal_auto.isChecked())) &&
                                    (!(rb_tamamEsteal_nime.isChecked())) &&
                                            (!(rb_tamamEsteal_tamam.isChecked())) ){
                        SnackbarUtil.setSnackBarWithNoActionButton(v,"بخش نوع کابین نمی تواند خالی باشد",
                                Color.rgb(255,255,255),
                                Color.rgb(232,59,58)
                                ,null,12, SnackbarUtil.RTL_DIRECTION);
                    }else{
                        if ((!(rb_nemidanam.isChecked())) &&
                                (!(rb_irani.isChecked())) &&
                                        (!(rb_khareji.isChecked())) ){
                            SnackbarUtil.setSnackBarWithNoActionButton(v,"بخش نوع موتور نمی تواند خالی باشد",
                                    Color.rgb(255,255,255),
                                    Color.rgb(232,59,58)
                                    ,null,12, SnackbarUtil.RTL_DIRECTION);

                        }else{
                                if (etx_address.getText().toString().length() == 0) {
                                    SnackbarUtil.setSnackBarWithNoActionButton(v, "فیلد آدرس نمی تواند خالی باشد",
                                            Color.rgb(255, 255, 255),
                                            Color.rgb(232, 59, 58)
                                            , null, 12, SnackbarUtil.RTL_DIRECTION);

                                } else {
                                    if (etx_alley.getText().toString().length() == 0) {
                                        SnackbarUtil.setSnackBarWithNoActionButton(v, "فیلد کوچه نمی تواند خالی باشد",
                                                Color.rgb(255, 255, 255),
                                                Color.rgb(232, 59, 58)
                                                , null, 12, SnackbarUtil.RTL_DIRECTION);

                                    } else {
                                        if (etx_plaque.getText().toString().length() == 0) {
                                            SnackbarUtil.setSnackBarWithNoActionButton(v, "فیلد پلاک نمی تواند خالی باشد",
                                                    Color.rgb(255, 255, 255),
                                                    Color.rgb(232, 59, 58)
                                                    , null, 12, SnackbarUtil.RTL_DIRECTION);

                                        } else {
                                            if (etx_unit.getText().toString().length() == 0) {
                                                SnackbarUtil.setSnackBarWithNoActionButton(v, "فیلد واحد نمی تواند خالی باشد",
                                                        Color.rgb(255, 255, 255),
                                                        Color.rgb(232, 59, 58)
                                                        , null, 12, SnackbarUtil.RTL_DIRECTION);

                                            } else {
                                                if (etx_description_address.getText().toString().length() == 0) {
                                                    SnackbarUtil.setSnackBarWithNoActionButton(v, "فیلد توضیحات نمی تواند خالی باشد",
                                                            Color.rgb(255, 255, 255),
                                                            Color.rgb(232, 59, 58)
                                                            , null, 12, SnackbarUtil.RTL_DIRECTION);

                                                } else {
                                                    Intent asansor_intent = new Intent(Asansor.this, Time.class);
                                                    asansor_intent.putExtra("name", "asansor");
                                                    AsansorModel.service_asansor_number =txt_number.getText().toString();
                                                    AsansorModel.service_asansor_job = asansorJobText;
                                                    AsansorModel.service_asansor_kind = kindText;
                                                    AsansorModel.service_asansor_engine = engineText;
                                                    AsansorModel.service_asansor_address = etx_address.getText().toString();
                                                    AsansorModel.service_asansor_alley = etx_alley.getText().toString();
                                                    AsansorModel.service_asansor_unit = etx_unit.getText().toString();
                                                    AsansorModel.service_asansor_plaque = etx_plaque.getText().toString();
                                                    AsansorModel.service_asansor_text = etx_description_address.getText().toString();
                                                    AsansorModel.service_asansor_lat = lat;
                                                    AsansorModel.service_asansor_sat = lang;
                                                    AsansorModel.id = "1";
                                                    AsansorModel.state_id = "1";

//                                                    Log.i("ss",AsansorModel.service_asansor_lat + "");
//                                                    Log.i("ss",AsansorModel.service_asansor_sat + "");


                                                    startActivity(asansor_intent);

                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
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



    @Override
    protected void attachBaseContext(Context newBase) {
        super.attachBaseContext(CalligraphyContextWrapper.wrap(newBase));
    }
}
