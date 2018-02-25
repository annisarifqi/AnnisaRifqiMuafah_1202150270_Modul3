package id.web.annisa.annisarifqimuafah_1202150270_modul3;

import android.content.res.TypedArray;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.view.menu.MenuAdapter;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.LinkedList;

public class MainActivity extends AppCompatActivity {
    private RecyclerView mRecyclerView;
    private ArrayList<Drink> mAirData;
    private ListMenuAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        Toast.makeText(this, "Selamat Memilih", Toast.LENGTH_SHORT).show();

        mRecyclerView = (RecyclerView) findViewById(R.id.recyclerview);

        int gridColumn = getResources().getInteger(R.integer.grid_column_count);

        mRecyclerView.setLayoutManager(new GridLayoutManager(this, gridColumn));

        mAirData = new ArrayList<>();
        mAdapter = new ListMenuAdapter(this, mAirData);
        mRecyclerView.setAdapter(mAdapter);

        initialiseData();

    }

    private void initialiseData(){
        String[] airList = getResources().getStringArray(R.array.name_src);
        String[] airInfo = getResources().getStringArray(R.array.info_src);
        TypedArray airImageResource = getResources().obtainTypedArray(R.array.img_src);
        mAirData.clear();

        for (int i=0; i<airList.length; i++){
            mAirData.add(new Drink (airList[i], airInfo[i], airImageResource.getResourceId(i, 0)));
        }

        airImageResource.recycle();

        mAdapter.notifyDataSetChanged();
    }

}
