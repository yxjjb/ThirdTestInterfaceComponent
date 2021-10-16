package com.example.thirdtest;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class actionModeTest3 extends AppCompatActivity {

    private ListView textView = null;
    private String data[] = {"One","Two","Three","Four","Five","Six","Seven"};
    private int chooseData[] = {0,0,0,0,0,0,0};

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_action_mode_test3);

        textView = (ListView) findViewById(R.id.test3_listview);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, data);
        textView.setAdapter(adapter);
        this.registerForContextMenu(textView);

        textView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                TextView context = (TextView) view.findViewById(android.R.id.text1);
                Toast.makeText(actionModeTest3.this, context.getText().toString(), Toast.LENGTH_SHORT).show();

                chooseData[i] = 1 - chooseData[i];
                if (chooseData[i] == 1) {
                    context.setBackgroundColor(Color.parseColor("#00CCFF"));
                } else {
                    context.setBackgroundColor(Color.parseColor("#ffffff"));
                }
                int chooseMount = 0;
                for( int j = 0; j < chooseData.length; j++) {
                    if( chooseData[j] == 1 ) chooseMount++;
                }
                setTitle("Selected" + chooseMount);
                if (chooseMount == 0) setTitle("unSelected");
            }
        });
    }



    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo){
        super.onCreateContextMenu(menu,v,menuInfo);
        //设置Menu显示内容
        menu.setHeaderTitle("文件操作");
        menu.setHeaderIcon(R.drawable.dog);
        menu.add(1,1,1,"复制");
        menu.add(1,2,1,"粘贴");
        menu.add(1,3,1,"剪切");
        menu.add(1,4,1,"重命名");
    }

    public boolean onContextItemSelected(MenuItem item){
        switch(item.getItemId()){
            case 1:
                Toast.makeText(actionModeTest3.this,"点击复制",Toast.LENGTH_SHORT).show();
                break;
            case 2:
                Toast.makeText(actionModeTest3.this,"点击粘贴",Toast.LENGTH_SHORT).show();
                break;
            case 3:
                Toast.makeText(actionModeTest3.this,"点击剪切",Toast.LENGTH_SHORT).show();
                break;
            case 4:
                Toast.makeText(actionModeTest3.this,"点击重命名",Toast.LENGTH_SHORT).show();
                break;
        }
        return super.onContextItemSelected(item);
    }
}