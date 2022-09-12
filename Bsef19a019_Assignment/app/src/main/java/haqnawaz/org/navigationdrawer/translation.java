package haqnawaz.org.navigationdrawer;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.List;

public class translation extends AppCompatActivity {
ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_translation);

        this.listView = (ListView) findViewById(R.id.listView);
        DbAccess databaseAccess = DbAccess.getInstance(this);


        Bundle bundle=getIntent().getExtras();
        int id1=bundle.getInt("translation");
        databaseAccess.open();
        List<String> quotes = databaseAccess.getTranslation(id1);
        databaseAccess.close();

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, quotes);
        this.listView.setAdapter(adapter);
    }
}