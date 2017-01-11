package com.example.tokel.nrepmax;

import android.content.Context;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        Button gimme = (Button) findViewById(R.id.gimme_my_max);
        InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);

        gimme.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int max = nRepMax();
                Snackbar.make(view, "Your 1RM is " + max, Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

    public int nRepMax() {
        EditText weightLiftedInput = (EditText) findViewById(R.id.weight_lifted_input);
        EditText repsDoneInput = (EditText) findViewById(R.id.reps_done_input);

        try {
            int weightLifted = Integer.parseInt(weightLiftedInput.getText().toString());
            int repsDone = Integer.parseInt(repsDoneInput.getText().toString());
            return (int) epsley(weightLifted, repsDone);
        } catch (Exception e) {
            return 0;
        }
    }

    public double epsley(int weight, int reps) {
        return weight * (1 + (reps / 30.0));
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
