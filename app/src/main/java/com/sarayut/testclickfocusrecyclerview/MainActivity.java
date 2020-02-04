package com.sarayut.testclickfocusrecyclerview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

public class MainActivity extends AppCompatActivity implements TestAdapter.PositionMenuInterface{

    TestAdapter testAdapter;
    RecyclerView recyclerView;
    String[] str_menu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.id_recyclerview);

        str_menu = getResources().getStringArray(R.array.testArray);

        testAdapter = new TestAdapter(str_menu);

        LinearLayoutManager Manager = new LinearLayoutManager(getApplicationContext(),LinearLayoutManager.VERTICAL,false);
        recyclerView.setLayoutManager(Manager);
        recyclerView.setAdapter(testAdapter);
        testAdapter.setCallback(MainActivity.this);
    }

    @Override
    public void getPositionMenu(int position) {
        System.out.println("sarayut_test position: " + position);
    }
}
