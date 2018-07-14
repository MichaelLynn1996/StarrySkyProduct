package us.xingkong.starmessage.module.main;

import android.support.annotation.NonNull;
import android.util.Log;
import android.widget.Toast;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import us.xingkong.starmessage.adapter.ItemsAdapter;
import us.xingkong.starmessage.been.Items;
import us.xingkong.starmessage.been.JsonRootBean;
import us.xingkong.starmessage.net.RetrofitManager;
import us.xingkong.starmessage.net.RetrofitService;
import us.xingkong.starmessage.util.RealmUtil;

import static android.support.constraint.Constraints.TAG;

/**
 * Created by SeaLynn0 on 2018/7/15 1:06
 * <p>
 * Email：sealynndev@gmail.com
 */
public class MainPresenter implements MainContract.Presenter {
    @Override
    public void onStart() {

    }

    @Override
    public void onDestroy() {

    }

    private final MainContract.View mView;
    MainPresenter(MainContract.View view) {
        mView = view;
        this.mView.setPresenter(this);
    }

    @Override
    public void refreshData(final List<Items> itemsList, final ItemsAdapter itemsAdapter) {
        mView.showLoading();
        if (!itemsList.isEmpty()) {
            itemsAdapter.setItemsList(itemsList);
            itemsAdapter.notifyDataSetChanged();
            mView.hideLoading();
            Toast.makeText(mView.getContext(), "从数据库加载", Toast.LENGTH_LONG).show();
        } else {
            RetrofitManager.getInstance()
                    .createReq(RetrofitService.class)
                    .getApps()
                    .enqueue(new Callback<JsonRootBean>() {
                        @Override
                        public void onResponse(@NonNull Call<JsonRootBean> call, @NonNull Response<JsonRootBean> response) {
                            if (response.body() != null && response.body().getItems() != null) {
                                List<Items> list = response.body().getItems();
                                Log.d(TAG, "onResponse: " + list.size());
                                itemsAdapter.setItemsList(list);
                                itemsAdapter.notifyDataSetChanged();
                                mView.hideLoading();
                                Toast.makeText(mView.getContext(), "网络请求成功",
                                        Toast.LENGTH_LONG).show();
                                Log.i(TAG, "onResponse: " + response.body().toString());
                                RealmUtil.addItems(list);
                            }
                        }

                        @Override
                        public void onFailure(@NonNull Call<JsonRootBean> call, @NonNull Throwable t) {
                            mView.hideLoading();
                            Toast.makeText(mView.getContext(), "网络请求失败",
                                    Toast.LENGTH_LONG).show();
                        }
                    });
        }
    }
}
