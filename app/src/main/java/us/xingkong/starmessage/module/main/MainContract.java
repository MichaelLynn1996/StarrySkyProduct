package us.xingkong.starmessage.module.main;

import java.util.List;

import us.xingkong.starmessage.adapter.ItemsAdapter;
import us.xingkong.starmessage.base.BasePresenter;
import us.xingkong.starmessage.base.BaseView;
import us.xingkong.starmessage.been.Items;

/**
 * Created by SeaLynn0 on 2018/7/15 0:57
 * <p>
 * Email：sealynndev@gmail.com
 */
class MainContract {

    interface View extends BaseView<Presenter> {
        void showLoading();
        void hideLoading();
    }

    interface Presenter extends BasePresenter {
        void refreshData(final List<Items> itemsList, final ItemsAdapter itemsAdapter);
    }
}
