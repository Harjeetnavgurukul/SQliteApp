package com.draw.sq_app;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";

    DatabaseHelper mDatabaseHelper;
    private Button btnAdd, btnViewData;
    private EditText edit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnAdd = (Button) findViewById(R.id.button1);
        btnViewData = (Button) findViewById(R.id.button2);
        edit = (EditText) findViewById(R.id.edit);
        mDatabaseHelper = new DatabaseHelper(this);

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String newEntry = edit.getText().toString();
                if (edit.length() != 0){
                    AddData(newEntry);
                    edit.setText("");

                }else {
                    toastMessage("You must put something text field");
                }
            }
        });


        btnViewData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view){
                Intent intent = new Intent(MainActivity.this,ListDataActivity.class);
                startActivity(intent);  

            }
        });
    }


        public void AddData(String newEntry) {
            boolean insertData = mDatabaseHelper.addData(newEntry);

            if (insertData){
                toastMessage("Data Successfully Inserted");
            }else {
                toastMessage("Something wet wrong");
            }
        }



    private void toastMessage(String data_successfully_inserted) {
        int message = 0;
        Toast.makeText(this,message, Toast.LENGTH_LONG).show();
    }
}