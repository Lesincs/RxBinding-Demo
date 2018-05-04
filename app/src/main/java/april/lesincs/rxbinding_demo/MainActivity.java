package april.lesincs.rxbinding_demo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextWatcher;
import android.util.Log;
import android.widget.TextView;

import io.reactivex.functions.Consumer;

public class MainActivity extends AppCompatActivity {

    String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RxView.clicks(findViewById(R.id.tv_obs))
                .subscribe(new Consumer<Object>() {
                    @Override
                    public void accept(Object o) throws Exception {
                        Log.d(TAG, "我被点击了");
                    }
                });

        TextView textView = findViewById(R.id.tv_obs);

        RxView.textChanges(textView)
                .subscribe(new Consumer<CharSequence>() {
                    @Override
                    public void accept(CharSequence charSequence) throws Exception {
                        Log.d(TAG, "我的当前文字为: " + charSequence);
                    }
                });

        textView.setText("test");
    }
}
