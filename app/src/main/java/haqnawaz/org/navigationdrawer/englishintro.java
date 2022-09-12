package haqnawaz.org.navigationdrawer;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.List;

public class englishintro extends AppCompatActivity {
    private ListView list;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_englishintro);
        this.list = (ListView) findViewById(R.id.list);
        DbAccess databaseAccess = DbAccess.getInstance(this);


        Bundle bundle=getIntent().getExtras();
        int id1=bundle.getInt("idn");
        databaseAccess.open();
        List<String> quotes2 = databaseAccess.getAyatTrans(id1);
        databaseAccess.close();

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, quotes2);
        this.list.setAdapter(adapter);

    }
}