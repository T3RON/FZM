package ir.mseif.app.com.fzm;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import butterknife.BindView;
import uk.co.chrisjenx.calligraphy.CalligraphyContextWrapper;

public class Asansor extends AppCompatActivity {


//    @BindView(R.id.button2) Button Inc_number;
//    @BindView(R.id.button3) Button Dec_number;
    @BindView(R.id.textView9) TextView asansor_num;

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
