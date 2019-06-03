package ir.mseif.app.com.fzm.Activity;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;

import com.androidnetworking.AndroidNetworking;
import com.androidnetworking.common.Priority;
import com.androidnetworking.error.ANError;
import com.androidnetworking.interfaces.JSONArrayRequestListener;
import com.androidnetworking.interfaces.OkHttpResponseListener;
import com.google.android.material.navigation.NavigationView;
import com.mohamadamin.persianmaterialdatetimepicker.date.DatePickerDialog;
import com.mohamadamin.persianmaterialdatetimepicker.utils.PersianCalendar;

import org.json.JSONArray;

import butterknife.BindView;
import butterknife.ButterKnife;
import de.mateware.snacky.Snacky;
import ir.mseif.app.com.fzm.MainActivity;
import ir.mseif.app.com.fzm.Model.AntenaModel;
import ir.mseif.app.com.fzm.Model.AsansorModel;
import ir.mseif.app.com.fzm.R;
import ir.mseif.app.com.fzm.Services.Antenna;
import ir.mseif.app.com.fzm.Services.Asansor;
import ir.mseif.app.com.fzm.Services.Camera;
import ir.mseif.app.com.fzm.Services.Chandelier;
import ir.mseif.app.com.fzm.Services.Cooler;
import ir.mseif.app.com.fzm.Services.ElectronicDevice;
import ir.mseif.app.com.fzm.Services.ElectronicPanel;
import ir.mseif.app.com.fzm.Services.Generator;
import ir.mseif.app.com.fzm.Services.Iphon;
import ir.mseif.app.com.fzm.Services.Lighting;
import ir.mseif.app.com.fzm.Services.Santeral;
import ir.mseif.app.com.fzm.Services.Security;
import ir.mseif.app.com.fzm.Services.ShutterDoor;
import ir.mseif.app.com.fzm.Services.Socket;
import ir.mseif.app.com.fzm.Services.Wiring;
import ir.mseif.app.com.fzm.Utils.Global;
import okhttp3.Response;
import uk.co.chrisjenx.calligraphy.CalligraphyContextWrapper;

public class Time extends AppCompatActivity {

    public DrawerLayout drawerLayout;
    public ActionBarDrawerToggle actionBarDrawerToggle;
    Button btn_nav;
    String date,h,m,type;

    @BindView(R.id.txt_date_picker) TextView txt_date_picker;
    @BindView(R.id.btn_accept) Button btn_accept;
    @BindView(R.id.place_other_day) ViewGroup place_other_day;

    @BindView(R.id.imgbtn_hour_up) ImageButton hour_up;
    @BindView(R.id.imgbtn_hour_down) ImageButton hour_down;
    @BindView(R.id.imgbtn_minute_up) ImageButton minute_up;
    @BindView(R.id.imgbtn_minute_down) ImageButton minute_down;

    @BindView(R.id.txt_hour) TextView txt_h;
    @BindView(R.id.txt_minute) TextView txt_m;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_time);
        ButterKnife.bind(this);

        Bundle bundle = getIntent().getExtras();
        if (bundle != null) {
            type = bundle.getString("name");
        }



        drawerLayout = findViewById(R.id.drawer_time);
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


        place_other_day.setOnClickListener(v -> {

            PersianCalendar now = new PersianCalendar();
            DatePickerDialog datePickerDialog = DatePickerDialog.newInstance((view, year, monthOfYear, dayOfMonth) -> {
                txt_date_picker.setText("تاریخ : "  + year + "/" + monthOfYear + "/" + dayOfMonth);
                date = year + "/" + monthOfYear + "/" + dayOfMonth;
            }, now.getPersianYear(),
                    now.getPersianMonth(),
                    now.getPersianDay());

            datePickerDialog.setThemeDark(false);
            datePickerDialog.show(getFragmentManager(), "tpd");

        });


        hour_up.setOnClickListener(v -> {
            String A = INC(String.valueOf(txt_h.getText()));
            txt_h.setText(A);
            h = A;
        });


        hour_down.setOnClickListener(v -> {
            String A = DEC(String.valueOf(txt_h.getText()));
            txt_h.setText(A);
            h = A;
        });


        minute_up.setOnClickListener(v -> {
            String A = INCM(String.valueOf(txt_m.getText()));
            txt_m.setText(A);
            m = A;
        });


        minute_down.setOnClickListener(v -> {
            String A = DECM(String.valueOf(txt_m.getText()));
            txt_m.setText(A);
            m = A;
        });

        btn_accept.setOnClickListener(v -> {
            switch(type) {
                case "antenna":
                    AntenaPost();
                    Intent antenna = new Intent(getApplicationContext(), Wallet.class);
                    startActivity(antenna);
                    finish();
                    break;
                case "asansor":
                    AsansorPost();
                    Intent asansor = new Intent(getApplicationContext(), Wallet.class);
                    startActivity(asansor);
                    finish();
                    break;
                case "camera":
                    Intent camera = new Intent(getApplicationContext(), Wallet.class);
                    startActivity(camera);
                    finish();
                    break;
                case "chandelier":
                    Intent chandelier = new Intent(getApplicationContext(), Wallet.class);
                    startActivity(chandelier);
                    finish();
                    break;
                case "cooler":
                    Intent cooler = new Intent(getApplicationContext(), Wallet.class);
                    startActivity(cooler);
                    finish();
                    break;
                case "electronicdevice":
                    Intent electronicDevice = new Intent(getApplicationContext(), Wallet.class);
                    startActivity(electronicDevice);
                    finish();
                    break;
                case "electronicpanel":
                    Intent electronicPanel = new Intent(getApplicationContext(), Wallet.class);
                    startActivity(electronicPanel);
                    finish();
                    break;
                case "generator":
                    Intent generator = new Intent(getApplicationContext(), Wallet.class);
                    startActivity(generator);
                    finish();
                    break;
                case "iphon":
                    Intent iphon = new Intent(getApplicationContext(), Wallet.class);
                    startActivity(iphon);
                    finish();
                    break;
                case "lighting":
                    Intent lighting = new Intent(getApplicationContext(), Wallet.class);
                    startActivity(lighting);
                    finish();
                    break;
                case "santeral":
                    Intent santeral = new Intent(getApplicationContext(), Wallet.class);
                    startActivity(santeral);
                    finish();
                    break;
                case "security":
                    Intent security = new Intent(getApplicationContext(), Wallet.class);
                    startActivity(security);
                    finish();
                    break;
                case "shutterdoor":
                    Intent shutterDoor = new Intent(getApplicationContext(), Wallet.class);
                    startActivity(shutterDoor);
                    finish();
                    break;
                case "socket":
                    Intent socket = new Intent(getApplicationContext(), Wallet.class);
                    startActivity(socket);
                    finish();
                    break;
                case "wiring":
                    Intent wiring = new Intent(getApplicationContext(), Wallet.class);
                    startActivity(wiring);
                    finish();
                    break;
            }

        });



    }


    public void AntenaPost() {
        AndroidNetworking.post(Global.BASE_URL + "ApiPost/Antena")
                .addBodyParameter("service_antenna_job",AntenaModel.service_antenna_job)
                .addBodyParameter("service_antenna_number",AntenaModel.service_antenna_number)
                .addBodyParameter("service_antenna_address",AntenaModel.service_antenna_address)
                .addBodyParameter("service_antenna_alley",AntenaModel.service_antenna_alley)
                .addBodyParameter("service_antenna_plaque",AntenaModel.service_antenna_plaque)
                .addBodyParameter("service_antenna_unit",AntenaModel.service_antenna_unit)
                .addBodyParameter("service_antenna_text",AntenaModel.service_antenna_text)
                .addBodyParameter("service_antenna_date",date)
                .addBodyParameter("service_antenna_hour",h+":"+m)
                .addBodyParameter("service_lat",AntenaModel.service_lat)
                .addBodyParameter("service_sat",AntenaModel.service_sat)
                .addBodyParameter("id","1" )
                .addBodyParameter("state_id","2")
                .setPriority(Priority.MEDIUM)
                .setTag("Antena")
                .build()
                .getAsOkHttpResponse(new OkHttpResponseListener() {
                    @Override
                    public void onResponse(Response response) {
                        // do anything with response
                        if (response.isSuccessful()) {
                            SnackFunc("درخواست شما با موفقیت ثبت شد" , "#2eb82e");
                        }
                    }
                    @Override
                    public void onError(ANError anError) {
                        SnackFunc("مشکلی پیش آمده با پشتیبانی تماس بگیرید" , "#ff3333");

                    }
                });
    }

    public void AsansorPost() {
        AndroidNetworking.post(Global.BASE_URL + "ApiPost/Asansor")
                .setContentType("application/json; charset=utf-8")
                .addBodyParameter("service_asansor_number", AsansorModel.service_asansor_number)
                .addBodyParameter("service_asansor_job",AsansorModel.service_asansor_job)
                .addBodyParameter("service_asansor_kind",AsansorModel.service_asansor_kind)
                .addBodyParameter("service_asansor_engine",AsansorModel.service_asansor_engine)
                .addBodyParameter("service_asansor_address",AsansorModel.service_asansor_address)
                .addBodyParameter("service_asansor_alley",AsansorModel.service_asansor_alley)
                .addBodyParameter("service_asansor_unit",AsansorModel.service_asansor_unit)
                .addBodyParameter("service_asansor_plaque",AsansorModel.service_asansor_plaque)
                .addBodyParameter("service_asansor_text",AsansorModel.service_asansor_text)
                .addBodyParameter("service_asansor_date",date)
                .addBodyParameter("service_asansor_hour",h+":"+m)
                .addBodyParameter("service_lat",AsansorModel.service_lat)
                .addBodyParameter("service_sat",AsansorModel.service_sat)
                .addBodyParameter("id",AsansorModel.id )
                .addBodyParameter("state_id",AsansorModel.state_id)
                .setPriority(Priority.MEDIUM)
                .setTag("Asansor")
                .build()
                .getAsOkHttpResponse(new OkHttpResponseListener() {
                    @Override
                    public void onResponse(Response response) {
                        // do anything with response
                        if (response.isSuccessful()) {
                            SnackFunc("درخواست شما با موفقیت ثبت شد" , "#2eb82e");
                        }
                    }
                    @Override
                    public void onError(ANError anError) {
                        SnackFunc("مشکلی پیش آمده با پشتیبانی تماس بگیرید" , "#ff3333");

                    }
                });
    }



    // Increas the Hour
    private String INC (String a){
        int b = Integer.parseInt(a);
        if (b<23) {
            b++;
        }else {
            b=0;
        }
        return String.valueOf(b);
    }
    // Decrease the Hour
    private String DEC (String a){
        int b = Integer.parseInt(a);
        if (b>0) {
            b--;
        }else {
            b=23;
        }
        return String.valueOf(b);
    }
    // Increas the Minute
    private String INCM (String a){
        int b = Integer.parseInt(a);
        if (b<59) {
            b++;
        }else {
            b=0;
        }
        return String.valueOf(b);
    }
    // Decrease the Minute
    private String DECM (String a){
        int b = Integer.parseInt(a);
        if (b>0) {
            b--;
        }else {
            b=59;
        }
        return String.valueOf(b);
    }


    public void SnackFunc(String message,String color) {
        Snacky.builder()
                .setActivity(Time.this)
                .setActionClickListener(v1 -> {
                    //do something
                })
                .setText(message)
                .setTextColor(Color.rgb(255,255,255))
                .setBackgroundColor(Color.parseColor(color))
                .setDuration(Snacky.LENGTH_LONG)
                .build()
                .show();
    }


    @Override
    protected void attachBaseContext(Context newBase) {
        super.attachBaseContext(CalligraphyContextWrapper.wrap(newBase));
    }



}
