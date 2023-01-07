package com.example.cms;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class ReadActivity extends AppCompatActivity {
    Button btnfetch;
    DatabaseHelper myDb;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_read);
        myDb = new DatabaseHelper(this);
        btnfetch=(Button)findViewById(R.id.btndemo);
        viewAll();

    }
    public void showMessage(String title,String Message){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setCancelable(true);
        builder.setTitle(title);
        builder.setMessage(Message);
        builder.show();
    }
    public void viewAll() {
        btnfetch.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Cursor res = myDb.GAD();
                        if(((Cursor) res).getCount() == 0) {
                            // show message
                            showMessage("Alert","Nothing found");
                            return;
                        }

                        StringBuffer buffer = new StringBuffer();
                        while (res.moveToNext()) {
                            buffer.append("Id :"+ res.getString(0)+"\n");
                            buffer.append("Name :"+ res.getString(1)+"\n");
                            buffer.append("Company Name :"+ res.getString(2)+"\n");
                            buffer.append("Designation :"+ res.getString(3)+"\n");
                            buffer.append("Contact Num :"+ res.getString(4)+"\n\n");
                        }

                        // Show all data
                        showMessage("Data",buffer.toString());
                    }
                });
    }
}