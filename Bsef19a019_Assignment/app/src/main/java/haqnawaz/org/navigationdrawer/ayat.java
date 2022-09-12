package haqnawaz.org.navigationdrawer;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.text.style.TtsSpan;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;

import java.io.IOException;
import java.util.List;

public class ayat extends AppCompatActivity {

    private ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ayat);
        this.listView = (ListView) findViewById(R.id.listView);
        DbAccess databaseAccess = DbAccess.getInstance(this);


        Bundle bundle=getIntent().getExtras();
        int id1=bundle.getInt("strName");
            databaseAccess.open();
            List<String> quotes = databaseAccess.getQuotes(id1);
            databaseAccess.close();

            ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, quotes);
            this.listView.setAdapter(adapter);
        }


}