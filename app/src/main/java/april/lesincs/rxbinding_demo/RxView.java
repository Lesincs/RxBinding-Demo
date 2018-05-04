package april.lesincs.rxbinding_demo;

import android.view.View;
import android.widget.TextView;

import io.reactivex.Observable;

/**
 * Created by cs丶 on 2018/5/4 9:47.
 * 　文件描述:
 */

public class RxView {

    /**
     *
     * @param textView 需要监听文字变化的view
     * @return 返回一个可被订阅的observable
     */
    public static Observable<CharSequence> textChanges(TextView textView){
        return new ViewTextChangesObservable(textView);
    }


    /**
     *
     * @param view 需要被订阅点击事件的view
     * @return 这里肯定是返回一个可被订阅的observable
     */
    public static Observable<Object> clicks(View view) {
        return new ViewClickObservale(view);
    }


}
