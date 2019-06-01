package ir.mseif.app.com.fzm.Panels;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import de.mateware.snacky.Snacky;
import ir.mseif.app.com.fzm.R;
import uk.co.chrisjenx.calligraphy.CalligraphyContextWrapper;

public class Login extends AppCompatActivity {


    @BindView(R.id.btn_verify) Button btn_sms;
    @BindView(R.id.etx_phone_number) EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);




        btn_sms.setOnClickListener(v -> {
            String Num = String.valueOf(editText.getText());
            if(Num.length() == 11 && Num.startsWith("09")){
                Intent intent = new Intent(getApplicationContext(),Sms.class);
                startActivity(intent);
            }else {
                        Snacky.builder()
                                .setActivity(Login.this)
                                .setActionClickListener(v1 -> {
                                    //do something
                                })
                                .setText("شماره همراه نامعتبر است")
                                .setTextColor(Color.rgb(255,255,255))
                                .setBackgroundColor(Color.rgb(232,59,58))
                                .setDuration(Snacky.LENGTH_LONG)
                                .build()
                                .show();
            }
        });


    }



    @Override
    protected void attachBaseContext(Context newBase) {
        super.attachBaseContext(CalligraphyContextWrapper.wrap(newBase));
    }
}
