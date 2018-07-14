package us.xingkong.starmessage.base;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by SeaLynn0 on 2018/7/15 1:00
 * <p>
 * Email：sealynndev@gmail.com
 */
public abstract class BaseActivity<P extends BasePresenter> extends AppCompatActivity
        implements BaseView<P> {

    Unbinder bind;
    /**
     * 泛型确定Presenter
     */
    protected P mPresenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(bindLayout());
        // ButterKnife绑定布局
        bind = ButterKnife.bind(this);
        mPresenter = createPresenter();
        if (mPresenter != null) {
            // 调用Presenter初始化方法
            mPresenter.onStart();
        }
        init(savedInstanceState);
    }

    protected abstract void init(Bundle savedInstanceState);

    /**
     * 创建Presenter
     *
     * @return 泛型Presenter
     */
    protected abstract P createPresenter();

    protected abstract int bindLayout();

    /**
     * Activity销毁时清理资源
     */
    @Override
    protected void onDestroy() {
        // ButterKnife解除绑定
        bind.unbind();
        // 销毁Presenter
        if (mPresenter != null) {
            mPresenter.onDestroy();
        }
        super.onDestroy();
    }

    /**
     * 实现BasePresenter接口的setPresenter方法
     *
     * @param presenter createPresenter()创建的Presenter
     */
    @Override
    public void setPresenter(P presenter) {
        mPresenter = presenter;
    }

    @Override
    public Context getContext() {
        return this;
    }
}
