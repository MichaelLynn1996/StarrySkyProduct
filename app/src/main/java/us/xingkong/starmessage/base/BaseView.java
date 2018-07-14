package us.xingkong.starmessage.base;

import android.content.Context;

/**
 * Created by SeaLynn0 on 2018/7/15 0:54
 * <p>
 * Email：sealynndev@gmail.com
 */
public interface BaseView<P> {

    void setPresenter(P presenter);

    Context getContext();
}
