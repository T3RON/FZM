package ir.mseif.app.com.fzm.Panels;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.androidnetworking.AndroidNetworking;
import com.androidnetworking.common.Priority;
import com.androidnetworking.error.ANError;
import com.androidnetworking.interfaces.OkHttpResponseListener;

import java.util.Random;

import butterknife.BindView;
import butterknife.ButterKnife;
import de.mateware.snacky.Snacky;
import ir.mseif.app.com.fzm.Activity.Time;
import ir.mseif.app.com.fzm.Model.AntenaModel;
import ir.mseif.app.com.fzm.R;
import ir.mseif.app.com.fzm.Utils.Global;
import okhttp3.Response;
import uk.co.chrisjenx.calligraphy.CalligraphyContextWrapper;

public class Login extends AppCompatActivity {


    @BindView(R.id.btn_verify) Button btn_sms;
    @BindView(R.id.etx_phone_number) EditText editText;
    String randDigit,Num;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);




        btn_sms.setOnClickListener(v -> {
            Num = String.valueOf(editText.getText());
            Random random = new Random();
            randDigit = String.format("%04d", random.nextInt(10000));
            if(Num.length() == 11 && Num.startsWith("09")){
                AndroidNetworking.post("https://api.kavenegar.com/v1/2F38547A5659585448792B377A6E483449332F537646393958736372442F374B/verify/lookup.json?receptor={receptor}&token={token}&template=token")
                        .addPathParameter("receptor", Num)
                        .addPathParameter("token", randDigit)
                        .setPriority(Priority.HIGH)
                        .setTag("SMS")
                        .build()
                        .getAsOkHttpResponse(new OkHttpResponseListener() {
                            @Override
                            public void onResponse(Response response) {
                                // do anything with response
                                if (response.isSuccessful()) {
                                    Intent intent = new Intent(getApplicationContext(),Sms.class);
                                    intent.putExtra("randDigit", randDigit);
                                    startActivity(intent);
                                }
                            }
                            @Override
                            public void onError(ANError anError) {
                                SnackFunc("مشکلی پیش آمده با پشتیبانی تماس بگیرید" , "#ff3333");

                            }
                        });

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


    public void SnackFunc(String message,String color) {
        Snacky.builder()
                .setActivity(Login.this)
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
