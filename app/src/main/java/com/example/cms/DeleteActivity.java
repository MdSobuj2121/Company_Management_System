package com.example.cms;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
public class DeleteActivity extends AppCompatActivity {
    DatabaseHelper myDb;
    EditText editTextId;
    Button btnDelete;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delete);
        myDb = new DatabaseHelper(this);
        editTextId = (EditText)findViewById(R.id.edtdelete_id);
        btnDelete= (Button)findViewById(R.id.btndelete_delete);
        DeleteData();
    }
    public void DeleteData() {
        btnDelete.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        String id=editTextId.getText().toString();
                        if (TextUtils.isEmpty(id)) {
                            Toast.makeText(DeleteActivity.this, "Plase enter ID Which you want to delete", Toast.LENGTH_LONG).show();
                            return;
                        }
                        Integer deletedRows = myDb.deleteData(editTextId.getText().toString());
                        if(deletedRows > 0) {
                            Toast.makeText(DeleteActivity.this, "Data Deleted", Toast.LENGTH_LONG).show();
                            editTextId.setText("");
                        }
                        else {
                            Toast.makeText(DeleteActivity.this, "Data not Deleted", Toast.LENGTH_LONG).show();
                        }
                    }
                }
        );
    }
}
