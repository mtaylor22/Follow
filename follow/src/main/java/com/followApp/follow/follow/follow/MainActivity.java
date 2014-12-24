package com.followApp.follow.follow.follow;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import com.nativecss.enums.RemoteContentRefreshPeriod;
import com.nativecss.support.v10.NativeCSS;

import java.net.MalformedURLException;
import java.net.URL;


public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        URL css = null;
        try {
            css = new URL("http://follow-backend.appspot.com/stylesheets/mobileStyles.css");
            NativeCSS.styleWithCSS("styles.css",css, RemoteContentRefreshPeriod.EveryFiveSeconds);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }


    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onResume() {
        super.onResume();
        NativeCSS.onActivityResumed(this);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        NativeCSS.onActivityDestroyed(this);
    }
}
