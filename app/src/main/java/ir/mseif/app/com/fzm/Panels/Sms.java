package ir.mseif.app.com.fzm.Panels;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


import androidx.appcompat.app.AppCompatActivity;


import butterknife.BindView;
import butterknife.ButterKnife;
import de.mateware.snacky.Snacky;
import ir.mseif.app.com.fzm.Activity.Time;
import ir.mseif.app.com.fzm.MainActivity;
import ir.mseif.app.com.fzm.R;
import ir.mseif.app.com.fzm.Services.Asansor;
import uk.co.chrisjenx.calligraphy.CalligraphyContextWrapper;

public class Sms extends AppCompatActivity {



    @BindView(R.id.btn_verify) Button btn_sms;
    @BindView(R.id.etx_verify) EditText etx_verify;
    @BindView(R.id.txt_send_again) TextView txt_send_again;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sms);
        ButterKnife.bind(this);


    btn_sms.setOnClickListener(v -> {
        if (etx_verify.getText().length() != 0){
            Intent intent = new Intent(getApplicationContext(), MainActivity.class);
            startActivity(intent);

        }else{
            Snacky.builder()
                    .setActivity(Sms.this)
                    .setActionClickListener(v1 -> {
                        //do something
                    })
                    .setText("کد فعال سازی نامعتبر است")
                    .setTextColor(Color.rgb(255,255,255))
                    .setBackgroundColor(Color.rgb(232,59,58))
                    .setDuration(Snacky.LENGTH_LONG)
                    .build()
                    .show();
        }

    });

    txt_send_again.setOnClickListener(v -> {
                Snacky.builder()
                        .setActivity(Sms.this)
                        .setActionClickListener(v1 -> {
                            //do something
                        })
                        .setText("کد فعال سازی مجددا ارسال شد")
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
