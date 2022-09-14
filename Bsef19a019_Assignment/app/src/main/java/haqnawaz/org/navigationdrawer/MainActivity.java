package haqnawaz.org.navigationdrawer;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Intent;

import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;

import android.os.Bundle;
import android.view.View;
import android.view.textclassifier.TextClassification;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity implements RecyclerViewInterface {
    List<Friend> friendsList = new ArrayList<>();
    RecyclerView recyclerView;
    Button b1;
Friend data;
    Button button;
    RecyclerView.Adapter adapter;
    RecyclerView.LayoutManager layoutManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Friend f0 = new Friend(1,"سُورتیں", R.drawable.d);

        Friend f1 = new Friend(2,"Introduction", R.drawable.d);
        Friend f2 = new Friend(3,"Urdu Introduction", R.drawable.d);

        friendsList.addAll(Arrays.asList(new Friend[]{f0}));

        friendsList.addAll(Arrays.asList(new Friend[]{f1}));
        friendsList.addAll(Arrays.asList(new Friend[]{f2}));


        recyclerView = findViewById(R.id.recylerViewStudent);



        recyclerView.setHasFixedSize(true);

        //LinearLayoutManager GridLayoutManager
        // layoutManager = new LinearLayoutManager(MainActivity.this);
        layoutManager = new LinearLayoutManager(MainActivity.this,
                LinearLayoutManager.HORIZONTAL,
                true);
        recyclerView.setLayoutManager(layoutManager);

        adapter = new myRecyclerViewAdapter(this,friendsList,this) ;
        recyclerView.setAdapter(adapter);
        //adapter.notifyDataSetChanged();

    }

    @Override
    public void onItemClick(int position) {
        if(position==0) {
            startActivity(new Intent(MainActivity.this, surah.class));
        }
        else if(position==1) {
            startActivity(new Intent(MainActivity.this, introenglish.class));
        }
        else if(position==2)
        {
            startActivity(new Intent(MainActivity.this,introductionToAyaat.class));
        }
    }}





