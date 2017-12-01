package com.example.designdemo;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private Toolbar mToolBar;
    private DrawerLayout mDeaweerLayout;
    private NavigationView mNav;
    private FloatingActionButton mBtnFloat;

    private ImgAdapter mImgAdapter;
    private RecyclerView mListRe;

    private List<Img> mImgs=new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        initAdapter();
    }

    private void initView() {
        mToolBar = findViewById(R.id.toolBar);
        setSupportActionBar(mToolBar);

        mDeaweerLayout = findViewById(R.id.DeaweerLayout);
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
            actionBar.setHomeAsUpIndicator(R.mipmap.ic_launcher);
        }


        mNav = findViewById(R.id.nav);
        mNav.setCheckedItem(R.id.l1);//设置默认选中项
        //Nav 界面的监听
        mNav.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.l2:
                        Toast.makeText(MainActivity.this, "l2", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.l1:
                        Toast.makeText(MainActivity.this, "l1", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.l3:
                        Toast.makeText(MainActivity.this, "l3", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.l4:
                        mDeaweerLayout.closeDrawers();
                        Toast.makeText(MainActivity.this, "l4", Toast.LENGTH_SHORT).show();
                        break;
                }
                return true;
            }
        });


        mBtnFloat = findViewById(R.id.btn_float);
        mBtnFloat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "SnackBar", Snackbar.LENGTH_SHORT).setAction("Undo", new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Toast.makeText(MainActivity.this, "Bar", Toast.LENGTH_SHORT).show();
                    }
                }).show();
            }
        });
        mListRe = findViewById(R.id.list_re);
    }

    private void initAdapter() {
        mListRe.setLayoutManager(new GridLayoutManager(this, 2));
        mImgAdapter = new ImgAdapter(getData());
        mListRe.setAdapter(mImgAdapter);
    }

    private List<Img> getData() {
        for (int i = 0; i < 20; i++) {
            Img img = new Img();
            img.setImgId(R.drawable.ic_launcher_background);
            img.setName("标题" + i);
            mImgs.add(img);
        }
        return mImgs;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.toolbar, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.toolBar1:
                Toast.makeText(this, "1", Toast.LENGTH_SHORT).show();
                break;
            case R.id.toolBar2:
                Toast.makeText(this, "2", Toast.LENGTH_SHORT).show();
                break;
            case R.id.toolBar3:
                Toast.makeText(this, "3", Toast.LENGTH_SHORT).show();
                break;
            case android.R.id.home:
                mDeaweerLayout.openDrawer(Gravity.START);
                break;
        }
        return true;
    }
}
