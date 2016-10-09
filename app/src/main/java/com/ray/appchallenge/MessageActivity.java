package com.ray.appchallenge;

import java.util.ArrayList;

import com.raychenon.licensedroid.OpenSourceDialogFragment;

import android.os.Bundle;

import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import android.view.Menu;
import android.view.MenuItem;

public class MessageActivity extends AppCompatActivity {

    private OpenSourceDialogFragment dialog;

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.message_activity);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
    }

    @Override
    public boolean onCreateOptionsMenu(final Menu menu) {

        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_message, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(final MenuItem item) {

        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        // noinspection SimplifiableIfStatement
        if (id == R.id.action_licenses) {
            showTheLicenses();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    private void showTheLicenses() {
        if (dialog == null) {
            dialog = OpenSourceDialogFragment.newInstance(new ArrayList<>(OpenSourceData.getLicenseData()));
        }

        dialog.show(getSupportFragmentManager(), "dialog");
    }

}
