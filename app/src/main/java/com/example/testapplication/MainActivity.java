package com.example.testapplication;

import android.os.Bundle;
import android.app.Activity;

// EX 1
//public class MainActivity extends Activity {
//    @Override
//    public void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);
//    }
//}

//EX 2
import java.util.ArrayList;
import java.util.List;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;
//
//public class MainActivity extends Activity {
//    private Spinner spinner1, spinner2;
//    private Button btnSubmit;
//    @Override
//    public void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);
//        addItemsOnSpinner2();
//        addListenerOnButton();
//        addListenerOnSpinnerItemSelection();
//    }
//    // add items into spinner dynamically
//    public void addItemsOnSpinner2() {
//        spinner2 = (Spinner) findViewById(R.id.spinner2);
//        List<String> list = new ArrayList<String>();
//        list.add("list 1");
//        list.add("list 2");
//        list.add("list 3");
//        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this,
//                android.R.layout.simple_spinner_item, list);
//        dataAdapter.setDropDownViewResource(android.
//                R.layout.simple_spinner_dropdown_item);
//        spinner2.setAdapter(dataAdapter);
//    }
//    public void addListenerOnSpinnerItemSelection() {
//        spinner1 = (Spinner) findViewById(R.id.spinner1);
//        spinner1.setOnItemSelectedListener(new CustomOnItemSelectedListener());
//    }
//    // get the selected dropdown list value
//    public void addListenerOnButton() {
//        spinner1 = (Spinner) findViewById(R.id.spinner1);
//        spinner2 = (Spinner) findViewById(R.id.spinner2);
//        btnSubmit = (Button) findViewById(R.id.btnSubmit);
//        btnSubmit.setOnClickListener(new OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Toast.makeText(MainActivity.this, "OnClickListener : " +
//                                "\nSpinner 1 : "+ String.valueOf(spinner1.getSelectedItem()) +
//                                "\nSpinner 2 : "+ String.valueOf(spinner2.getSelectedItem()),
//                        Toast.LENGTH_SHORT).show(); } });
//    }
//}

// Ex3:
import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends Activity {

    private Spinner spinner1, spinner2;
    private Button btnSubmit;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Create the main LinearLayout programmatically
        LinearLayout mainLayout = new LinearLayout(this);
        mainLayout.setLayoutParams(new LinearLayout.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.MATCH_PARENT));
        mainLayout.setOrientation(LinearLayout.VERTICAL);
        mainLayout.setPadding(48, 48, 48, 48);

        // Create Spinner 1
        spinner1 = new Spinner(this);
        LinearLayout.LayoutParams spinner1Params = new LinearLayout.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.WRAP_CONTENT);
        spinner1Params.setMargins(0, 0, 0, 48);
        spinner1.setLayoutParams(spinner1Params);

        // Add country array to spinner1
        String[] countries = {"Malaysia", "United States", "Indonesia", "France",
                "Italy", "Singapore", "New Zealand", "India"};
        ArrayAdapter<String> adapter1 = new ArrayAdapter<>(this,
                android.R.layout.simple_spinner_item, countries);
        adapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner1.setAdapter(adapter1);
        spinner1.setPrompt("Choose a country");

        // Create Spinner 2
        spinner2 = new Spinner(this);
        LinearLayout.LayoutParams spinner2Params = new LinearLayout.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.WRAP_CONTENT);
        spinner2Params.setMargins(0, 0, 0, 48);
        spinner2.setLayoutParams(spinner2Params);

        // Add items to spinner2
        List<String> list = new ArrayList<>();
        list.add("list 1");
        list.add("list 2");
        list.add("list 3");
        ArrayAdapter<String> dataAdapter = new ArrayAdapter<>(this,
                android.R.layout.simple_spinner_item, list);
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner2.setAdapter(dataAdapter);

        // Create Submit Button
        btnSubmit = new Button(this);
        LinearLayout.LayoutParams buttonParams = new LinearLayout.LayoutParams(
                ViewGroup.LayoutParams.WRAP_CONTENT,
                ViewGroup.LayoutParams.WRAP_CONTENT);
        btnSubmit.setLayoutParams(buttonParams);
        btnSubmit.setText("Submit");
        btnSubmit.setBackgroundColor(Color.parseColor("#7CB342"));
        btnSubmit.setTextColor(Color.WHITE);
        btnSubmit.setPadding(40, 20, 40, 20);

        // Add views to main layout
        mainLayout.addView(spinner1);
        mainLayout.addView(spinner2);
        mainLayout.addView(btnSubmit);

        // Set the content view
        setContentView(mainLayout);

        // Add listeners
        addListenerOnButton();
        addListenerOnSpinnerItemSelection();
    }

    public void addListenerOnSpinnerItemSelection() {
        spinner1.setOnItemSelectedListener(new CustomOnItemSelectedListener());
    }

    public void addListenerOnButton() {
        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "OnClickListener : " +
                                "\nSpinner 1 : " + String.valueOf(spinner1.getSelectedItem()) +
                                "\nSpinner 2 : " + String.valueOf(spinner2.getSelectedItem()),
                        Toast.LENGTH_SHORT).show();
            }
        });
    }
}