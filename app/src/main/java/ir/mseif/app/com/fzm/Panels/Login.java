package ir.mseif.app.com.fzm.Panels;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

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




        btn_sms.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            String Num = String.valueOf(editText.getText());
            if(Num.length() == 11 && Num.startsWith("09")){
                Intent intent = new Intent(getApplicationContext(),Sms.class);
                startActivity(intent);
            }else {
                Toast.makeText(Login.this, "Wrong Number", Toast.LENGTH_SHORT).show();
            }
        }
    });


    }



    @Override
    protected void attachBaseContext(Context newBase) {
        super.attachBaseContext(CalligraphyContextWrapper.wrap(newBase));
    }
}
