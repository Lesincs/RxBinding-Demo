package april.lesincs.rxbinding_demo;

import android.view.View;

import io.reactivex.Observable;
import io.reactivex.Observer;

/**
 * Created by cs丶 on 2018/5/4 10:12.
 * 　文件描述:
 */

public class ViewClickObservale extends Observable<Object> {

    private View mView;

    public ViewClickObservale(View mView) {
        this.mView = mView;
    }

    /**
     * 继承Observable必须实现的抽象方法
     * @param observer
     */
    @Override
    protected void subscribeActual(final Observer<? super Object> observer) {

        //为view设置监听,每次收到点击事件,向下游发射事件
        mView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                observer.onNext("onClick");
            }
        });
    }

}
