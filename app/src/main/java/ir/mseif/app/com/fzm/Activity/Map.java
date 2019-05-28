package ir.mseif.app.com.fzm.Activity;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.location.LocationManager;
import android.os.Bundle;
import android.view.Gravity;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.UiSettings;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.material.navigation.NavigationView;

import butterknife.BindView;
import butterknife.ButterKnife;
import ir.mseif.app.com.fzm.R;
import ir.mseif.app.com.fzm.Services.Antenna;
import ir.mseif.app.com.fzm.Services.Asansor;
import uk.co.chrisjenx.calligraphy.CalligraphyContextWrapper;

public class Map extends AppCompatActivity implements OnMapReadyCallback {

    private LocationManager locationManager;
    private GoogleMap gmap;
    private Bitmap smallMarker;
    String lat , lang ;
    private SupportMapFragment map;



    public DrawerLayout drawerLayout;
    public ActionBarDrawerToggle actionBarDrawerToggle;
    Button btn_nav;

    @BindView(R.id.btn_accept)
    Button btn_accept;
    String type;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_map);
        ButterKnife.bind(this);

        Bundle bundle = getIntent().getExtras();
        if (bundle != null) {
            type = bundle.getString("name");
        }

        map = (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.fragment_map);
        map.getMapAsync(this);

        drawerLayout = findViewById(R.id.drawer_map);
        actionBarDrawerToggle = new ActionBarDrawerToggle(this, drawerLayout, R.string.Open, R.string.Close);
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

                if (id == R.id.profile) {
                    Intent intent = new Intent(getApplicationContext(), Profile.class);
                    startActivity(intent);
                } else if (id == R.id.lastservice) {
                    Intent intent = new Intent(getApplicationContext(), History.class);
                    startActivity(intent);
                } else if (id == R.id.wallet) {
                    Intent intent = new Intent(getApplicationContext(), Wallet.class);
                    startActivity(intent);
                } else if (id == R.id.contact) {
                    Intent intent = new Intent(getApplicationContext(), Contact.class);
                    startActivity(intent);
                } else if (id == R.id.about) {
                    Intent intent = new Intent(getApplicationContext(), About.class);
                    startActivity(intent);
                } else if (id == R.id.exit_app) {
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

        btn_accept.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    switch(type) {
                        case "antena":
                            Intent antena = new Intent(getApplicationContext(), Antenna.class);
                            antena.putExtra("lat", lat);
                            antena.putExtra("lang", lang);
                            startActivity(antena);
                            finish();
                            break;
                        case "asansor":
                            Intent asansor = new Intent(getApplicationContext(), Asansor.class);
                            startActivity(asansor);
                            asansor.putExtra("lat", lat);
                            asansor.putExtra("lang", lang);
                            startActivity(asansor);
                            finish();
                            break;
                    }
                }
        });

        //--------------------------------------------- Map ----------------------------------

        int height = 180;
        int width = 180;
        BitmapDrawable bitmapdraw=(BitmapDrawable)getResources().getDrawable(R.drawable.marker);
        Bitmap b=bitmapdraw.getBitmap();
        smallMarker = Bitmap.createScaledBitmap(b, width, height, false);
    }




    public void onMapReady(GoogleMap googleMap) {
        gmap = googleMap;
        gmap.getUiSettings().setAllGesturesEnabled(true);
        gmap.getUiSettings().setScrollGesturesEnabled(true);
        gmap.setMinZoomPreference(12);
        gmap.setIndoorEnabled(true);
        UiSettings uiSettings = gmap.getUiSettings();
        uiSettings.setIndoorLevelPickerEnabled(true);
        uiSettings.setMyLocationButtonEnabled(true);
        uiSettings.setMapToolbarEnabled(true);
        uiSettings.setCompassEnabled(true);
        uiSettings.setZoomControlsEnabled(true);
        LatLng ny = new LatLng(35.685050, 51.395248);
        MarkerOptions markerOptions = new MarkerOptions();
        markerOptions.icon(BitmapDescriptorFactory.fromBitmap(smallMarker));
        markerOptions.position(ny);
        gmap.addMarker(markerOptions);
        gmap.moveCamera(CameraUpdateFactory.newLatLng(ny));
        gmap.setMinZoomPreference(8);
        gmap.moveCamera(CameraUpdateFactory.newLatLng(ny));


        gmap.setOnMapClickListener(new GoogleMap.OnMapClickListener() {

            @Override
            public void onMapClick(LatLng latLng) {
                MarkerOptions markerOptions = new MarkerOptions();
                markerOptions.icon(BitmapDescriptorFactory.fromBitmap(smallMarker));
                markerOptions.position(latLng);
                lat = latLng.latitude + "";
                lang = latLng.longitude + "";
                gmap.clear();
                markerOptions.title(lat + " : " + lang);
                gmap.animateCamera(CameraUpdateFactory.newLatLng(latLng));
                gmap.addMarker(markerOptions);
            }
        });

    }




    @Override
    protected void attachBaseContext(Context newBase) {
        super.attachBaseContext(CalligraphyContextWrapper.wrap(newBase));
    }
}
