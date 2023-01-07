package com.example.cms;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class UpdateActivity extends AppCompatActivity {
    DatabaseHelper myDb;
    EditText editName,editCompanyname,editPhno,editDesignation ,editTextId;
    Button btnUpdate;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update);
        myDb = new DatabaseHelper(this);
        editName = (EditText)findViewById(R.id.edtupdate_name);
        editCompanyname = (EditText)findViewById(R.id.edtupdate_companyname);
        editPhno = (EditText)findViewById(R.id.edtupdate_phno);
        editDesignation = (EditText)findViewById(R.id.edtupdate_designation);
        editTextId = (EditText)findViewById(R.id.edtupdate_id);
        btnUpdate = (Button)findViewById(R.id.btnupdate_update);
        UpdateData();
    }

    public void UpdateData() {
        btnUpdate.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        String id = editTextId.getText().toString();

                        if (TextUtils.isEmpty(id)) {
                            Toast.makeText(UpdateActivity.this, "Plase enter ID which you want to update", Toast.LENGTH_LONG).show();
                            return;
                        }
                        boolean isUpdate = myDb.updateData(editTextId.getText().toString(),
                                editName.getText().toString(),
                                editCompanyname.getText().toString(),
                                editDesignation.getText().toString(),
                                editPhno.getText().toString());
                        if(isUpdate == true) {
                            Toast.makeText(UpdateActivity.this, "Data Update", Toast.LENGTH_LONG).show();
                            editName.setText("");
                            editDesignation.setText("");
                            editPhno.setText("");
                            editCompanyname.setText("");
                            editTextId.setText("");
                        }
                        else {
                            Toast.makeText(UpdateActivity.this, "Data not Updated", Toast.LENGTH_LONG).show();
                        }
                    }
                }
        );
    }
}
