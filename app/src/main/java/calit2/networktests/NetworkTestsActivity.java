package calit2.networktests;

import android.app.Activity;
import android.bluetooth.BluetoothAdapter;
import android.content.Context;
import android.content.Intent;
import android.location.Location;
import android.location.LocationManager;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Bundle;
import android.provider.Settings;
import android.view.View;
import android.widget.TextView;

/**
 * Name: MainActivity
 * Description: Enables User to test the different network connections
 *              available on their device (Bluetooth, Wi-Fi, GPS).
 */
public class NetworkTestsActivity extends Activity {

    // Constants to determine which activity was requested
    private static final int REQUEST_LOCATION = 0;
    private static final int REQUEST_WIFI     = 1;
    private static final int REQUEST_BT       = 2;

    // Instance Variables to alter the statuses
    private TextView locationStatus;
    private TextView wifiStatus;
    private TextView btStatus;

    /**
     * Name: onCreate
     * Description: Attaches the TextViews of our app to instance variables
     *              and instantiates the app's screen.
     * 
     * @param savedInstanceState Reference to bundle object. Activities can be
     *                           restored to a former state using data saved
     *                           in this bundle.
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        locationStatus = (TextView) findViewById(R.id.LOCATION_STATUS);
        wifiStatus     = (TextView) findViewById(R.id.WIFI_STATUS);
        btStatus       = (TextView) findViewById(R.id.BLUETOOTH_STATUS);
    }

    /**
     * Name: testLocation
     * Description: Tests the location network of the device by first pulling
     *              information from the Network Provider, then overriding it
     *              with the GPS Provider if available.
     * 
     * @param v     The view that was clicked
     */
    public void testLocation(View v) {
        LocationManager manager =
                (LocationManager) getSystemService(Context.LOCATION_SERVICE);

        NetworkTestsLocationListener listener =
                new NetworkTestsLocationListener();

        if (manager.isProviderEnabled(LocationManager.NETWORK_PROVIDER) ||
                manager.isProviderEnabled(LocationManager.GPS_PROVIDER)) {

            if (manager.isProviderEnabled(LocationManager.NETWORK_PROVIDER)) {
                manager.requestLocationUpdates(LocationManager.NETWORK_PROVIDER, 0, 0, listener);
                Location location = manager.getLastKnownLocation(LocationManager.NETWORK_PROVIDER);
                locationStatus.setText("Your Coordinate is: (" + location.getLongitude() + ", " + location.getLatitude());
            }

            if (manager.isProviderEnabled(LocationManager.GPS_PROVIDER)) {
                manager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 0, 0, listener);
                Location location = manager.getLastKnownLocation(LocationManager.GPS_PROVIDER);
                locationStatus.setText("Your Coordinate is: (" + location.getLongitude() + ", " + location.getLatitude());
            }
        }
        else {
            locationStatus.setText("Your device does not support a GPS/Network provider");
        }
    }

    /**
     * Name: getBestLocation
     * Description: Checks both the Network Provider and the GPS Provider to
     *              grab the best/ most accurate coordinates
     * @param manager   LocationManager that determines if the current device's
     *                  location services are on. If the services are available,
     *                  manager will grab the best location.
     * @param listener  A NetworkTestsLocationListener object to enable manager
     *                  to request a location update.
     */
    
	

    /**
     * Name: toggleWifi
     * Description: Uses WifiManager to toggle the Wifi on/off
     * 
     * @param v     The view that was clicked
     */
    public void toggleWifi(View v) {
    }

    /**
     * Name: connectWifiNetwork
     * Description: Opens the setting page to enable the user to turn
     *              Wifi on and connect to a specific network
     * 
     * @param v     The view that was clicked
     */
    public void connectWifiNetwork(View v) {
    }

    /**
     * Name: testBluetooth
     * Description: Tests the Bluetooth network of the device
     * 
     * @param v     The view that was clicked
     */
    public void testBluetooth(View v) {
    }

    /**
     * Name: onActivityResult
     * Description: Handles the result of each new Activity/Intent call
     *              for the bluetooth, gps, and wifi
     * 
     * @param requestCode A number code that denotes what activity 
     *                    (Gps, Wifi, Bluetooth) to handle.
     * @param resultCode  A code that denotes the outcome of the 
     *                    subsequent activity that was called. 
     * @param data        Carries the result of the data from the second activity
     */
    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
    }

    /**
     * Name: refreshStatus
     * Description: Refreshes all of the status texts and turns off the
     *              Bluetooth, Wifi, and GPS
     * 
     * @param v     The view that was clicked.
     */
    public void refreshStatus(View v) {
    }
}