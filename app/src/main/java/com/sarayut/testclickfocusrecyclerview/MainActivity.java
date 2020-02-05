package com.sarayut.testclickfocusrecyclerview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements TestAdapter.PositionMenuInterface{

    TestAdapter testAdapter;
    RecyclerView recyclerView,recyclerview_column;
    String[] str_menu;
    private List<Vas> vasList;
    private HorizontalVasItemAdapter horizontalVasItemAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.id_recyclerview);
        recyclerview_column = findViewById(R.id.id_recyclerview_column);

        str_menu = getResources().getStringArray(R.array.testArray);

        testAdapter = new TestAdapter(str_menu);

        LinearLayoutManager Manager = new LinearLayoutManager(getApplicationContext(),LinearLayoutManager.VERTICAL,false);
        recyclerView.setLayoutManager(Manager);
        recyclerView.setAdapter(testAdapter);
        testAdapter.setCallback(MainActivity.this);
    }

    @Override
    public void getPositionMenu(int position) {
        System.out.println("anunda_t position: " + position);
        switch (position) {
            case 0:
                vasList = new ArrayList<>();
                for (int i = 0; i < 13; i++) {
                    Vas vas = new Vas();
                    vas.setPrice("฿" + (30 + i));
                    vas.setPromotion("500 MB (24 ชม.)");
                    vas.setPromotion_detail("เน็ตเต็มสปีด");
                    vas.setPromotion_detail2("500 MB 1 GB");
                    vasList.add(i, vas);
                }
                horizontalVasItemAdapter = new HorizontalVasItemAdapter(vasList);
                break;
            case 1:
                recyclerview_column.setAdapter(null);
                vasList = new ArrayList<>();
                for (int i = 0; i < 3; i++) {
                    Vas vas = new Vas();
                    vas.setPrice("฿" + (30 + i));
                    vas.setPromotion("500 MB (24 ชม.)");
                    vas.setPromotion_detail("เน็ตเต็มสปีด");
                    vas.setPromotion_detail2("500 MB 1 GB");
                    vasList.add(i, vas);
                }
                horizontalVasItemAdapter = new HorizontalVasItemAdapter(vasList);
                break;
            case 2:
                recyclerview_column.setAdapter(null);
                vasList = new ArrayList<>();
                for (int i = 0; i < 1; i++) {
                    Vas vas = new Vas();
                    vas.setPrice("฿" + (30 + i));
                    vas.setPromotion("500 MB (24 ชม.)");
                    vas.setPromotion_detail("เน็ตเต็มสปีด");
                    vas.setPromotion_detail2("500 MB 1 GB");
                    vasList.add(i, vas);
                }
                horizontalVasItemAdapter = new HorizontalVasItemAdapter(vasList);
                break;
            case 5:
            case 3:
            case 4:
                vasList = new ArrayList<>();
                recyclerview_column.setAdapter(null);
                horizontalVasItemAdapter = new HorizontalVasItemAdapter(vasList);
                break;
            default:
                break;
        }

        GridLayoutManager gridLayoutManager = new GridLayoutManager(getApplicationContext(), 2, GridLayoutManager.HORIZONTAL, false);
        recyclerview_column.setLayoutManager(gridLayoutManager);
        recyclerview_column.setAdapter(horizontalVasItemAdapter);
        recyclerview_column.addOnItemTouchListener(new RecyclerItemClickListener(getApplicationContext(), recyclerview_column, new RecyclerItemClickListener.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
               System.out.println("sarayut_test adapter position: " + position);
            }

            @Override
            public void onLongItemClick(View view, int position) {
            }
        }));
    }
}
