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
import ir.mseif.app.com.fzm.Services.Camera;
import ir.mseif.app.com.fzm.Services.Chandelier;
import ir.mseif.app.com.fzm.Services.Cooler;
import ir.mseif.app.com.fzm.Services.ElectronicDevice;
import ir.mseif.app.com.fzm.Services.ElectronicPanel;
import ir.mseif.app.com.fzm.Services.Generator;
import ir.mseif.app.com.fzm.Services.Iphon;
import ir.mseif.app.com.fzm.Services.Lighting;
import ir.mseif.app.com.fzm.Services.Santeral;
import ir.mseif.app.com.fzm.Services.Security;
import ir.mseif.app.com.fzm.Services.ShutterDoor;
import ir.mseif.app.com.fzm.Services.Socket;
import ir.mseif.app.com.fzm.Services.Wiring;
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


        nav_view.setNavigationItemSelectedListener(menuItem -> {
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
        });


        btn_nav.setOnClickListener(v -> {
            if (drawerLayout.isDrawerOpen(Gravity.RIGHT)) {
                drawerLayout.closeDrawer(Gravity.RIGHT);
            } else {
                drawerLayout.openDrawer(Gravity.RIGHT);
            }
        });

        btn_accept.setOnClickListener(v -> {
                switch(type) {
                    case "antenna":
                        Intent antenna = new Intent(getApplicationContext(), Antenna.class);
                        antenna.putExtra("lat", lat);
                        antenna.putExtra("lang", lang);
                        startActivity(antenna);
                        finish();
                        break;
                    case "asansor":
                        Intent asansor = new Intent(getApplicationContext(), Asansor.class);
                        asansor.putExtra("lat", lat);
                        asansor.putExtra("lang", lang);
                        startActivity(asansor);
                        finish();
                        break;
                    case "camera":
                        Intent camera = new Intent(getApplicationContext(), Camera.class);
                        camera.putExtra("lat", lat);
                        camera.putExtra("lang", lang);
                        startActivity(camera);
                        finish();
                        break;
                    case "chandelier":
                        Intent chandelier = new Intent(getApplicationContext(), Chandelier.class);
                        chandelier.putExtra("lat", lat);
                        chandelier.putExtra("lang", lang);
                        startActivity(chandelier);
                        finish();
                        break;
                    case "cooler":
                        Intent cooler = new Intent(getApplicationContext(), Cooler.class);
                        cooler.putExtra("lat", lat);
                        cooler.putExtra("lang", lang);
                        startActivity(cooler);
                        finish();
                        break;
                    case "electronicdevice":
                        Intent electronicDevice = new Intent(getApplicationContext(), ElectronicDevice.class);
                        electronicDevice.putExtra("lat", lat);
                        electronicDevice.putExtra("lang", lang);
                        startActivity(electronicDevice);
                        finish();
                        break;
                    case "electronicpanel":
                        Intent electronicPanel = new Intent(getApplicationContext(), ElectronicPanel.class);
                        electronicPanel.putExtra("lat", lat);
                        electronicPanel.putExtra("lang", lang);
                        startActivity(electronicPanel);
                        finish();
                        break;
                    case "generator":
                        Intent generator = new Intent(getApplicationContext(), Generator.class);
                        generator.putExtra("lat", lat);
                        generator.putExtra("lang", lang);
                        startActivity(generator);
                        finish();
                        break;
                    case "iphon":
                        Intent iphon = new Intent(getApplicationContext(), Iphon.class);
                        iphon.putExtra("lat", lat);
                        iphon.putExtra("lang", lang);
                        startActivity(iphon);
                        finish();
                        break;
                    case "lighting":
                        Intent lighting = new Intent(getApplicationContext(), Lighting.class);
                        lighting.putExtra("lat", lat);
                        lighting.putExtra("lang", lang);
                        startActivity(lighting);
                        finish();
                        break;
                    case "santeral":
                        Intent santeral = new Intent(getApplicationContext(), Santeral.class);
                        santeral.putExtra("lat", lat);
                        santeral.putExtra("lang", lang);
                        startActivity(santeral);
                        finish();
                        break;
                    case "security":
                        Intent security = new Intent(getApplicationContext(), Security.class);
                        security.putExtra("lat", lat);
                        security.putExtra("lang", lang);
                        startActivity(security);
                        finish();
                        break;
                    case "shutterDoor":
                        Intent shutterDoor = new Intent(getApplicationContext(), ShutterDoor.class);
                        shutterDoor.putExtra("lat", lat);
                        shutterDoor.putExtra("lang", lang);
                        startActivity(shutterDoor);
                        finish();
                        break;
                    case "socket":
                        Intent socket = new Intent(getApplicationContext(), Socket.class);
                        socket.putExtra("lat", lat);
                        socket.putExtra("lang", lang);
                        startActivity(socket);
                        finish();
                        break;
                    case "wiring":
                        Intent wiring = new Intent(getApplicationContext(), Wiring.class);
                        wiring.putExtra("lat", lat);
                        wiring.putExtra("lang", lang);
                        startActivity(wiring);
                        finish();
                        break;
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


        gmap.setOnMapClickListener(latLng -> {
            MarkerOptions markerOptions1 = new MarkerOptions();
            markerOptions1.icon(BitmapDescriptorFactory.fromBitmap(smallMarker));
            markerOptions1.position(latLng);
            lat = latLng.latitude + "";
            lang = latLng.longitude + "";
            gmap.clear();
            markerOptions1.title(lat + " : " + lang);
            gmap.animateCamera(CameraUpdateFactory.newLatLng(latLng));
            gmap.addMarker(markerOptions1);
        });

    }




    @Override
    protected void attachBaseContext(Context newBase) {
        super.attachBaseContext(CalligraphyContextWrapper.wrap(newBase));
    }
}
