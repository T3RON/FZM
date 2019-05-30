package ir.mseif.app.com.fzm.Panels;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


import androidx.appcompat.app.AppCompatActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import ir.mseif.app.com.fzm.MainActivity;
import ir.mseif.app.com.fzm.R;
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

        Intent intent = new Intent(getApplicationContext(), MainActivity.class);
        startActivity(intent);
    });

    txt_send_again.setOnClickListener(v -> {
        Toast.makeText(this, "Sending SMS Verification", Toast.LENGTH_SHORT).show();

    });



    }




    @Override
    protected void attachBaseContext(Context newBase) {
        super.attachBaseContext(CalligraphyContextWrapper.wrap(newBase));
    }
}
