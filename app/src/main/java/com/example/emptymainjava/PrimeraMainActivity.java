package com.example.emptymainjava;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.text.BreakIterator;

public class PrimeraMainActivity extends AppCompatActivity {
    private Button btn; 
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    public void PasarAsegunda(View view) {
        Intent i = new Intent(this, SegundaActivityMain.class);
        startActivity(i);
    }

    public static final String REQUEST_RESULT = "REQUEST_RESULT";

    public void onlyClickSwitchActivity(View view) {
        EditText editText = (EditText) findViewById(
                R.id.editText);
        String text = editText.getText().toString();

        Intent intent = new Intent(this, SegundaActivityMain.class);
        intent.putExtra(Intent.EXTRA_TEXT, text);
        startActivityForResult(intent, 1);
    }


    protected void onActivityResult(int requestCode, int
            resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode==RESULT_OK) {
            Toast.makeText(this, Integer.toString(
                    data.getIntExtra(REQUEST_RESULT, 0)),
                    Toast.LENGTH_LONG).show();
        }
    }
}
