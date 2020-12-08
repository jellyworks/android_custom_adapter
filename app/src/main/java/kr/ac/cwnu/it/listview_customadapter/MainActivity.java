package kr.ac.cwnu.it.listview_customadapter;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    String[] name = {"호주", "캐나다", "중국", "프랑스", "인도", "인도네시아",
            "이란", "이태리", "일본", "몽골","러시아","한국", "스페인",
            "영국", "미국"};
    String[] location = {"호주", "북미", "아시아", "유럽", "아시아", "아시아",
            "중동", "유럽", "아시아", "아시아","유라시아","아시아", "유럽",
            "유럽", "북미"};
    int[] images = {R.drawable.australia, R.drawable.canada, R.drawable.china,
            R.drawable.france, R.drawable.india, R.drawable.indonesia,
            R.drawable.iran, R.drawable.italy, R.drawable.japan,
            R.drawable.mongol, R.drawable.russia, R.drawable.korea,
            R.drawable.spain, R.drawable.uk, R.drawable.usa};
    ArrayList<Nation> list;
    ListView listView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        list = new ArrayList<>();
        for(int i=0;i<name.length;i++){
            Nation nation = new Nation(name[i], location[i], images[i]);
            list.add(nation);
        }

        listView = findViewById(R.id.listview);
        NationAdapter adapter = new NationAdapter(this, list, R.layout.item_layout);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast toast = Toast.makeText(MainActivity.this, name[position], Toast.LENGTH_SHORT);
                toast.show();
            }
        });
    }
}
