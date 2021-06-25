package com.example.wastemanagementsystem;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class postWork extends AppCompatActivity {
    Spinner spinner;
    String text;
    BinModel binModel;
    TextView driverEmail,binId,area;
    DbHelper dbHelper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_post_work);

    }
    public void SubmitWorkAndBackToViewDetail(View view) {
        Intent intent = new Intent(this, ViewDetail.class);
        dbHelper=new DbHelper(postWork.this);
        intent.putExtra("submit",binModel);

        boolean b = dbHelper.UpdateStatus(binModel.getDriverEmail(),text);
        if (b == true)
            Toast.makeText(postWork.this, "Bin Updated", Toast.LENGTH_SHORT).show();
        else
            Toast.makeText(postWork.this, "Bin Not Updated", Toast.LENGTH_SHORT).show();
        startActivity(intent);

    }

}