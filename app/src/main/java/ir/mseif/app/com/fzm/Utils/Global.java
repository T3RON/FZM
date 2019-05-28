package ir.mseif.app.com.fzm.Utils;

import android.app.Application;
import android.content.Context;
import android.util.Log;

import ir.mseif.app.com.fzm.R;
import uk.co.chrisjenx.calligraphy.CalligraphyConfig;

public class Global extends Application {
    public static Context context;
    public static String PACKAGE_NAME;
    public static String BASE_URL = "http://10.0.2.2:8080/fzm/api/";
    public static String BASE_URL_UPLOADS = "http://10.0.2.2:8080/fzm/assets/uploads/files/";
    @Override
    public void onCreate() {
        super.onCreate();

        PACKAGE_NAME = getApplicationContext().getPackageName();
        Log.i("pppa" , PACKAGE_NAME + "");

        // Font Library
        CalligraphyConfig.initDefault(new CalligraphyConfig.Builder()
                .setDefaultFontPath("fonts/ira.ttf")
                .setFontAttrId(R.attr.fontPath).build());
    }
}
