package ir.mseif.app.com.fzm.Services;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.RadioButton;
import android.widget.TextView;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;

import com.google.android.material.navigation.NavigationView;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import de.mateware.snacky.Snacky;
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
    String engineText,kindText,lat,lang;
    StringBuilder asansorJobText;

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

        asansorJobText = new StringBuilder();

        Bundle bundle = getIntent().getExtras();
        if (bundle != null) {
            lat = bundle.getString("lat");
            lang = bundle.getString("lang");
        }

        cb_nasb.setOnCheckedChangeListener((buttonView, isChecked) -> {
            if (isChecked) {
                asansorJobText.append(cb_nasb.getText().toString());
            }
        });

        cb_other_kind.setOnCheckedChangeListener((buttonView, isChecked) -> {
            if (isChecked) {
                asansorJobText.append(cb_other_kind.getText().toString());
            }
        });

        cb_repair.setOnCheckedChangeListener((buttonView, isChecked) -> {
            if (isChecked) {
                asansorJobText.append(cb_repair.getText().toString());
            }
        });

        rb_nimeEsteal_auto.setOnCheckedChangeListener((buttonView, isChecked) -> {
            if (isChecked==true) {
                kindText="";
                kindText = rb_nimeEsteal_auto.getText().toString();
            }else {
                kindText="";
            }
        });

        rb_nimeEsteal_nime.setOnCheckedChangeListener((buttonView, isChecked) -> {
            if (isChecked==true) {
                kindText="";
                kindText = rb_nimeEsteal_nime.getText().toString();
            }else {
                kindText="";
            }
        });

        rb_tamamEsteal_tamam.setOnCheckedChangeListener((buttonView, isChecked) -> {
            if (isChecked==true) {
                kindText="";
                kindText = rb_tamamEsteal_tamam.getText().toString();
            }else {
                kindText="";
            }
        });

        rb_tamamEsteal_nime.setOnCheckedChangeListener((buttonView, isChecked) -> {
            if (isChecked==true) {
                kindText="";
                kindText = rb_tamamEsteal_nime.getText().toString();
            }else {
                kindText="";
            }
        });



        rb_irani.setOnCheckedChangeListener((buttonView, isChecked) -> {
            if (isChecked==true) {
                engineText="";
                engineText = rb_irani.getText().toString();
            }else {
                engineText="";
            }
        });

        rb_khareji.setOnCheckedChangeListener((buttonView, isChecked) -> {
            if (isChecked==true) {
                engineText="";
                engineText = rb_khareji.getText().toString();
            }else {
                engineText="";
            }
        });

        rb_nemidanam.setOnCheckedChangeListener((buttonView, isChecked) -> {
            if (isChecked==true) {
                engineText="";
                engineText = rb_nemidanam.getText().toString();
            }else {
                engineText="";
            }
        });


        Inc_number.setOnClickListener(v -> {
            String A = INC(String.valueOf(txt_number.getText()));
            txt_number.setText(A);
            etx_address.clearFocus();
            etx_alley.clearFocus();
            etx_unit.clearFocus();
            etx_plaque.clearFocus();
            etx_description_address.clearFocus();
        });


        Dec_number.setOnClickListener(v -> {
            String A = DEC(String.valueOf(txt_number.getText()));
            txt_number.setText(A);
            etx_address.clearFocus();
            etx_alley.clearFocus();
            etx_unit.clearFocus();
            etx_plaque.clearFocus();
            etx_description_address.clearFocus();
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
                        Snacky.builder()
                                .setActivity(Asansor.this)
                                .setActionClickListener(v1 -> {
                                    //do something
                                })
                                .setText("تعداد آسانسور نمی تواند ۰ باشد")
                                .setTextColor(Color.rgb(255,255,255))
                                .setBackgroundColor(Color.rgb(232,59,58))
                                .setDuration(Snacky.LENGTH_LONG)
                                .build()
                                .show();
            }else{
                if ((!(cb_nasb.isChecked())) &&
                        (!(cb_repair.isChecked())) &&
                            (!(cb_other_kind.isChecked()))  ){
                    Snacky.builder()
                            .setActivity(Asansor.this)
                            .setActionClickListener(v12 -> {
                                //do something
                            })
                            .setText("بخش خدمت درخواستی نمی تواند خالی باشد")
                            .setTextColor(Color.rgb(255,255,255))
                            .setBackgroundColor(Color.rgb(232,59,58))
                            .setDuration(Snacky.LENGTH_LONG)
                            .build()
                            .show();

                }else{
                    if ((!(rb_nimeEsteal_nime.isChecked())) &&
                            (!(rb_nimeEsteal_auto.isChecked())) &&
                                    (!(rb_tamamEsteal_nime.isChecked())) &&
                                            (!(rb_tamamEsteal_tamam.isChecked())) ){
                        Snacky.builder()
                                .setActivity(Asansor.this)
                                .setActionClickListener(v1 -> {
                                    //do something
                                })
                                .setText("بخش نوع کابین نمی تواند خالی باشد")
                                .setTextColor(Color.rgb(255,255,255))
                                .setBackgroundColor(Color.rgb(232,59,58))
                                .setDuration(Snacky.LENGTH_LONG)
                                .build()
                                .show();
                    }else{
                        if ((!(rb_nemidanam.isChecked())) &&
                                (!(rb_irani.isChecked())) &&
                                        (!(rb_khareji.isChecked())) ){
                            Snacky.builder()
                                    .setActivity(Asansor.this)
                                    .setActionClickListener(v1 -> {
                                        //do something
                                    })
                                    .setText("بخش نوع موتور نمی تواند خالی باشد")
                                    .setTextColor(Color.rgb(255,255,255))
                                    .setBackgroundColor(Color.rgb(232,59,58))
                                    .setDuration(Snacky.LENGTH_LONG)
                                    .build()
                                    .show();

                        }else{
                                if (etx_address.getText().toString().length() == 0) {
                                    Snacky.builder()
                                            .setActivity(Asansor.this)
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
                                                .setActivity(Asansor.this)
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
                                                    .setActivity(Asansor.this)
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
                                                        .setActivity(Asansor.this)
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
                                                            .setActivity(Asansor.this)
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
                                                    Intent asansor_intent = new Intent(Asansor.this, Time.class);
                                                    asansor_intent.putExtra("name", "asansor");
                                                    AsansorModel.service_asansor_number =txt_number.getText().toString();
                                                    AsansorModel.service_asansor_job = asansorJobText.toString();
                                                    AsansorModel.service_asansor_kind = kindText;
                                                    AsansorModel.service_asansor_engine = engineText;
                                                    AsansorModel.service_asansor_address = etx_address.getText().toString();
                                                    AsansorModel.service_asansor_alley = etx_alley.getText().toString();
                                                    AsansorModel.service_asansor_unit = etx_unit.getText().toString();
                                                    AsansorModel.service_asansor_plaque = etx_plaque.getText().toString();
                                                    AsansorModel.service_asansor_text = etx_description_address.getText().toString();
                                                    AsansorModel.service_lat = lat;
                                                    AsansorModel.service_sat = lang;
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
