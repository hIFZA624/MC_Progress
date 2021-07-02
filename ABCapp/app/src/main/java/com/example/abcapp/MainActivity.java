package com.example.abcapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {
    String myTitle[]={"A","B","C","D","E","F","G","H","I","J","K","L","M","N","O","P","Q","R","S","T","U","V","W","X","Y","Z"};
    ListView listView;
    String myDescription[]={"a","b","c","d","e","f","g","h","i","j","k","l","m","n","o","p","q","r","s","t","u","v","w","x","y","z"};
    int myImage[]={R.drawable.apple,R.drawable.baseball,R.drawable.clock,R.drawable.donkey,R.drawable.elephant,R.drawable.father,R.drawable.grandmother,R.drawable.hungry,R.drawable.internet,R.drawable.justice,R.drawable.kangro,R.drawable.london,R.drawable.monkey,R.drawable.norway,R.drawable.overtime,R.drawable.pillow,R.drawable.question,R.drawable.rabbit,R.drawable.spiderman,R.drawable.telephone,R.drawable.under,R.drawable.vacine,R.drawable.web,R.drawable.xylo,R.drawable.yogurt,R.drawable.zebra};
    ArrayAdapter<String> myadapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView=findViewById(R.id.myListView);
        myadapter=new ArrayAdapter<>(this, android.R.layout.simple_list_item_1,myTitle);
        listView.setAdapter(myadapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int i, long id) {
                Intent intent=new Intent(MainActivity.this,Detailabc.class);
                Bundle bundle=new Bundle();
                bundle.putInt("images",myImage[i]);
                intent.putExtras(bundle);
                intent.putExtra("title",myTitle[i]);
                intent.putExtra("desc",myDescription[i]);
                intent.putExtra("position",""+i);
                startActivity(intent);
            }
        });
    }
}