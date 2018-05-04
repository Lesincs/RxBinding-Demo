package april.lesincs.rxbinding_demo;


import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.TextView;

import io.reactivex.Observable;
import io.reactivex.Observer;

/**
 * Created by cs丶 on 2018/5/4 14:09.
 * 　文件描述:
 */

public class ViewTextChangesObservable extends Observable<CharSequence> {

    private TextView mTextView;

    public ViewTextChangesObservable(TextView mTextView) {
        this.mTextView = mTextView;
    }

    @Override
    protected void subscribeActual(final Observer<? super CharSequence> observer) {

        //被订阅时,为TextView增加TextWatcher,文字文化时,向下游发射事件
        mTextView.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                observer.onNext(s);
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        //发送现有的事件到下游,便于combineLatest等操作符的使用
        observer.onNext(mTextView.getText());

    }
}
