package com.ibrahim.storingdata;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    EditText editText, editText2;
    TextView textView, textView2;
    SharedPreferences sharedPreferences, sharedPreferencesv2;

    String storedDataKey = "StoredData";
    String storedDataKeyv2 = "StoredDatav2";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText = findViewById(R.id.editTextNumber);
        editText2 = findViewById(R.id.editTextNumber2);
        textView = findViewById(R.id.textView);
        textView2 = findViewById(R.id.textView2);


        sharedPreferences = this.getSharedPreferences("com.ibrahim.storingdata", Context.MODE_PRIVATE);
        int storedAge = sharedPreferences.getInt(storedDataKey, 0);
        if (storedAge == 0) {
            textView.setText("Your age :");
        } else {
            textView.setText("Your Age :" + storedAge);

        }

        sharedPreferencesv2 = this.getSharedPreferences("com.ibrahim.storingdata", Context.MODE_PRIVATE);
        int storedAgev2 = sharedPreferencesv2.getInt(storedDataKeyv2, 0);
        if (storedAgev2 == 0) {
            textView2.setText("Your agev2 :");
        } else {
            textView2.setText(" your age v2 : " + storedAgev2);


        }

    }


    public void save(View view) {


        if (!editText.getText().toString().matches("")) {
            try {int userAge = Integer.parseInt(editText.getText().toString());

                int userAgev2 = Integer.parseInt(editText2.getText().toString());

                textView.setText("your age :" + userAge);
                textView2.setText("your agev2 :" + +userAgev2);

                sharedPreferences.edit().putInt(storedDataKey, userAge).apply();
                sharedPreferencesv2.edit().putInt(storedDataKeyv2, userAgev2).apply();

            }
            catch (Exception e){

            }


        }
    }


    public void delete(View view) {
        int storedData = sharedPreferences.getInt(storedDataKey, 0);

        if (storedData != 0) {
            sharedPreferences.edit().remove(storedDataKey).apply();
            textView.setText("your age :");
            textView2.setText("your agev2 :");
        }

    }


}
