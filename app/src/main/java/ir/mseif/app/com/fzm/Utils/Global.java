package ir.mseif.app.com.fzm.Utils;

import android.app.Application;
import android.content.Context;

import ir.mseif.app.com.fzm.R;
import uk.co.chrisjenx.calligraphy.CalligraphyConfig;

public class Global extends Application {
    public static Context context;
    @Override
    public void onCreate() {
        super.onCreate();



        // Font Library
        CalligraphyConfig.initDefault(new CalligraphyConfig.Builder()
                .setDefaultFontPath("fonts/ira.ttf")
                .setFontAttrId(R.attr.fontPath).build());
    }
}
