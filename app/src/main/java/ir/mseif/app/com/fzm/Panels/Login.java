package ir.mseif.app.com.fzm.Panels;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


import androidx.appcompat.app.AppCompatActivity;

import com.bvapp.directionalsnackbar.SnackbarUtil;

import butterknife.BindView;
import butterknife.ButterKnife;
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
                SnackbarUtil.setSnackBarWithNoActionButton(v,"شماره همراه نامعتبر است",
                        Color.rgb(255,255,255),
                        Color.rgb(232,59,58),
                        null,12, SnackbarUtil.RTL_DIRECTION);
            }
        });


    }



    @Override
    protected void attachBaseContext(Context newBase) {
        super.attachBaseContext(CalligraphyContextWrapper.wrap(newBase));
    }
}
