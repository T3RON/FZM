package ir.mseif.app.com.fzm.Activity;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;

import com.androidnetworking.AndroidNetworking;
import com.androidnetworking.common.Priority;
import com.androidnetworking.error.ANError;
import com.androidnetworking.interfaces.JSONArrayRequestListener;
import com.bvapp.directionalsnackbar.SnackbarUtil;
import com.google.android.material.navigation.NavigationView;
import com.mohamadamin.persianmaterialdatetimepicker.date.DatePickerDialog;
import com.mohamadamin.persianmaterialdatetimepicker.utils.PersianCalendar;

import org.json.JSONArray;

import butterknife.BindView;
import butterknife.ButterKnife;
import ir.mseif.app.com.fzm.MainActivity;
import ir.mseif.app.com.fzm.Model.AntenaModel;
import ir.mseif.app.com.fzm.R;
import ir.mseif.app.com.fzm.Utils.Global;
import uk.co.chrisjenx.calligraphy.CalligraphyContextWrapper;

public class Time extends AppCompatActivity {

    public DrawerLayout drawerLayout;
    public ActionBarDrawerToggle actionBarDrawerToggle;
    Button btn_nav;
    String date,h,m;

    @BindView(R.id.txt_date_picker) TextView txt_date_picker;
    @BindView(R.id.txt_other_day) TextView txt_other_day;
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
            AntenaPost();
            SnackbarUtil.setSnackBarWithNoActionButton(v,"سرویس مورد نظر ثبت شد",
            Color.rgb(255,255,255),
            Color.rgb(35,144,3)
                ,null,12, SnackbarUtil.RTL_DIRECTION);
        });

        Log.i("sdas" , AntenaModel.service_antenna_job+"");
        Log.i("sdas" , AntenaModel.service_antenna_number+"");
        Log.i("sdas" , AntenaModel.service_antenna_address+"");
        Log.i("sdas" , h+":"+m);



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
                .addBodyParameter("service_antenna_lat",AntenaModel.service_antenna_lat)
                .addBodyParameter("service_antenna_sat",AntenaModel.service_antenna_sat)
                .addBodyParameter("id",AntenaModel.id )
                .addBodyParameter("state_id",AntenaModel.state_id)
                .setPriority(Priority.MEDIUM)
                .build()
                .getAsJSONArray(new JSONArrayRequestListener() {
                    @Override
                    public void onResponse(JSONArray response) {
                        // do anything with response
                        Log.i("sdas" , response + "");
                    }
                    @Override
                    public void onError(ANError error) {
                        // handle error
                        Log.i("sdas" , error + "");
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


    @Override
    protected void attachBaseContext(Context newBase) {
        super.attachBaseContext(CalligraphyContextWrapper.wrap(newBase));
    }

}
