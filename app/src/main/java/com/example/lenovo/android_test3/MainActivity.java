package com.example.lenovo.android_test3;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import android.app.Activity;
import android.os.Bundle;
import java.util.HashMap;
import android.view.Gravity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;
public class MainActivity extends Activity {
    private ListView listView;
    private String[] name={"Lion","Tiger","Monkey","Dog","Cat","Elephant"};
    private int[] images={R.drawable.lion,R.drawable.tiger,R.drawable.monkey,R.drawable.dog,
            R.drawable.cat,R.drawable.elephant};
    private List<Map<String,Object>> list_map=new ArrayList<Map<String,Object>>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.simpleadapter);
        listView=(ListView)findViewById(R.id.listView);
        //1.准备好数据源，循环为listView添加数据
        for(int i=0;i<6;i++){
            Map<String,Object> items=new HashMap<String,Object>();
            items.put("pic",images[i]);
            items.put("name",name[i]);
            list_map.add(items);
        }
        //2、创建适配器
        SimpleAdapter simpleAdapter=new SimpleAdapter(
                MainActivity.this,
                list_map,
                R.layout.list_items,
                new String[]{"pic","name"},
                new int[]{R.id.items_imageView1,R.id.items_textView1}
        );
        listView.setAdapter(simpleAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView parent, View view, int position, long id) {
              // Toast.makeText(MainActivity.this, name[position], Toast.LENGTH_LONG).show();
               Toast toast=Toast.makeText(MainActivity.this, name[position], Toast.LENGTH_LONG);
                toast.setGravity(Gravity.CENTER|Gravity.CENTER,0,0);
                toast.show();
            }
        });
    }
}