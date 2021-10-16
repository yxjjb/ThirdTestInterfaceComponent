package com.example.thirdtest;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MainActivity extends AppCompatActivity {
//    private String[] names = new String[]{"Lion", "Tiger", "Monkey", "Dog", "Cat", "Elephant"};
//    private int[] images = new int[]{R.drawable.lion, R.drawable.tiger, R.drawable.monkey, R.drawable.dog, R.drawable.cat, R.drawable.elephant};
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);
////        List<Map<String, Object>> lists = new ArrayList<Map<String, Object>>();
////        for (int i = 0; i < names.length; i++) {
////            Map<String, Object> map = new HashMap<String, Object>();
////            map.put("text", names[i]);
////            map.put("image", images[i]);
////            lists.add(map);
////
////        }
////        SimpleAdapter simpleAdapter = new SimpleAdapter(this, lists, R.layout.layout,
////                new String[]{"text", "image"}, new int[]{R.id.text, R.id.image});
////
////        ListView list = findViewById(R.id.mylist);
////        list.setAdapter(simpleAdapter);
////        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
////            @Override
////            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
////                Toast toastCenter = Toast.makeText(getApplicationContext(), names[position], Toast.LENGTH_SHORT);
////                toastCenter.show();
////            }
////        });
////        Myclass myclass = new Myclass(this);
////        myclass.show();
//    }
//}






private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        textView = (TextView) findViewById(R.id.text);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = new MenuInflater(this);
        inflater.inflate(R.menu.my_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.font_10:
                textView.setTextSize(10);
                break;
            case R.id.font_16:
                textView.setTextSize(16);
                break;
            case R.id.font_20:
                textView.setTextSize(20);
                break;
            case R.id.plain_item:
                Toast.makeText(this,"点击了普通菜单项",Toast.LENGTH_LONG).show();
                break;
            case R.id.red_font:
                textView.setTextColor(Color.RED);
                break;
            case R.id.black_font:
                textView.setTextColor(Color.BLACK);
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}