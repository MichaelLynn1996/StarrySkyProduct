package us.xingkong.starmessage.module.main;

import android.support.annotation.NonNull;
import android.support.v4.widget.SwipeRefreshLayout;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.Toast;


import java.util.List;

import butterknife.BindView;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import us.xingkong.starmessage.adapter.ItemsAdapter;
import us.xingkong.starmessage.R;
import us.xingkong.starmessage.base.BaseActivity;
import us.xingkong.starmessage.been.Items;
import us.xingkong.starmessage.been.JsonRootBean;
import us.xingkong.starmessage.net.RetrofitManager;
import us.xingkong.starmessage.util.RealmUtil;
import us.xingkong.starmessage.net.RetrofitService;

public class MainActivity extends BaseActivity<MainContract.Presenter> implements MainContract.View {

    private static final String TAG = "MainActivity";
    List<Items> itemsList;
    @BindView(R.id.recycler_view)
    RecyclerView recyclerView;
    @BindView(R.id.swipe_fresh)
    SwipeRefreshLayout swipeRefreshLayout;
    ItemsAdapter itemsAdapter;

    @Override
    protected void init(Bundle savedInstanceState) {
        initList();
        initRecyclerView();
        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                mPresenter.refreshData(itemsList, itemsAdapter);
            }
        });
    }

    private void initList() {
        itemsList = RealmUtil.queryAllItems();
    }

    private void initRecyclerView() {
        itemsAdapter = new ItemsAdapter(itemsList, MainActivity.this);

        LinearLayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(itemsAdapter);
    }

    @Override
    protected MainContract.Presenter createPresenter() {
        return new MainPresenter(this);
    }

    @Override
    protected int bindLayout() {
        return R.layout.activity_main;
    }

    @Override
    public void showLoading() {
        if (!swipeRefreshLayout.isRefreshing())
            swipeRefreshLayout.setRefreshing(true);
    }

    @Override
    public void hideLoading() {
        swipeRefreshLayout.setRefreshing(false);
    }
}