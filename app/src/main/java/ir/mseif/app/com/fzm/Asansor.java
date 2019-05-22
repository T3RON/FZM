package ir.mseif.app.com.fzm;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import butterknife.BindView;
import ir.mseif.app.com.fzm.Activity.About;
import ir.mseif.app.com.fzm.Activity.Contact;
import ir.mseif.app.com.fzm.Activity.History;
import ir.mseif.app.com.fzm.Activity.Map;
import ir.mseif.app.com.fzm.Activity.Profile;
import ir.mseif.app.com.fzm.Activity.Wallet;
import uk.co.chrisjenx.calligraphy.CalligraphyContextWrapper;

public class Asansor extends AppCompatActivity {


    private DrawerLayout drawerLayout;
    private ActionBarDrawerToggle actionBarDrawerToggle;
    Button btn_nav;

//    @BindView(R.id.button2) Button Inc_number;
//    @BindView(R.id.button3) Button Dec_number;
    @BindView(R.id.txt_number) TextView asansor_num;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_asansor);



//        asansor_num.setText("s");
//
//        Inc_number.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                String A = INC(String.valueOf(asansor_num.getText()));
//                asansor_num.setText(A);
//            }
//        });
//
//
//        Dec_number.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                String A = DEC(String.valueOf(asansor_num.getText()));
//                asansor_num.setText(A);
//            }
//        });
//    }
//
//
//
//
//    // Increas the number of asansor
//    private String INC (String a){
//        int b = Integer.parseInt(a);
//        b++;
//        return String.valueOf(b);
//
//    }
//
//    // Decrease the number of asansor
//    private String DEC (String a){
//        int b = Integer.parseInt(a);
//        if (b>0) {
//            b--;
//        }else {
//            b=0;
//        }
//        return String.valueOf(b);







        drawerLayout = findViewById(R.id.drawer_asansor);
        actionBarDrawerToggle = new ActionBarDrawerToggle(this,drawerLayout,R.string.Open,R.string.Close);
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

    }



    // Go To Time Activity
    public void Go_To_Location (View v){
        Intent intent = new Intent(getApplicationContext(), Map.class);
        startActivity(intent);
    }




    // Go To Time Activity
    public void Go_To_Time (View v){
        Intent intent = new Intent(getApplicationContext(), MainActivity.class);
        startActivity(intent);
    }


    @Override
    protected void attachBaseContext(Context newBase) {
        super.attachBaseContext(CalligraphyContextWrapper.wrap(newBase));
    }
}
