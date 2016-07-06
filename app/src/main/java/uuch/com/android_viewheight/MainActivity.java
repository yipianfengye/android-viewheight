package uuch.com.android_viewheight;

import android.annotation.TargetApi;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    public static final String TAG = MainActivity.class.getSimpleName();

    public TextView titleText = null;
    public Button button1 = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        titleText = (TextView) findViewById(R.id.text_title);
        button1 = (Button) findViewById(R.id.button1);

        // initOnPreDrawListener();

        // initOnLayoutListener();

        // initViewHandler();

        // mHandler.sendEmptyMessage(101);

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getTextHeightAndWidth();
            }
        });
    }

    private void getTextHeightAndWidth() {
        int height = titleText.getHeight();
        int width = titleText.getWidth();

        Log.i(TAG, "height:" + height + "  " + "width:" + width);
    }

    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);
        if (hasFocus) {
            int width = titleText.getWidth();
            int height = titleText.getHeight();
            Log.i(TAG, "onWindowFocusChanged width:" + width + "   "
                            + "  height:" + height);
        }
    }

    private Handler mHandler = new Handler() {

        @Override
        public void handleMessage(Message msg) {
            if (msg.what == 101) {
                int width = titleText.getWidth();
                int height = titleText.getHeight();

                Log.i(TAG, "initViewHandler height:" + height + "  width:" + width);
            }
        }
    };

    private void initViewHandler() {
        titleText.post(new Runnable() {
            @Override
            public void run() {
                int width = titleText.getWidth();
                int height = titleText.getHeight();

                Log.i(TAG, "initViewHandler height:" + height + "  width:" + width);
            }
        });
    }

    private void initOnLayoutListener() {
        final ViewTreeObserver viewTreeObserver = this.getWindow().getDecorView().getViewTreeObserver();

        viewTreeObserver.addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
            @Override
            public void onGlobalLayout() {
                Log.i(TAG, "开始执行onGlobalLayout().........");
                int height = titleText.getMeasuredHeight();
                int width = titleText.getMeasuredWidth();

                Log.i(TAG, "height:" + height + "   width:" + width);
                // 移除OnGlobalLayoutListener事件监听
                MainActivity.this.getWindow().getDecorView().getViewTreeObserver().removeOnGlobalLayoutListener(this);
            }
        });
    }

    /**
     * 初始化viewTreeObserver事件监听,重写OnPreDrawListener获取组件高度
     */
    private void initOnPreDrawListener() {
        final ViewTreeObserver viewTreeObserver = this.getWindow().getDecorView().getViewTreeObserver();
        viewTreeObserver.addOnPreDrawListener(new ViewTreeObserver.OnPreDrawListener() {
            @Override
            public boolean onPreDraw() {
                Log.i(TAG, "开始执行onPreDraw().........");
                int height = titleText.getMeasuredHeight();
                int width = titleText.getMeasuredWidth();

                Log.i(TAG, "height:" + height + "   width:" + width);
                // 移除OnPreDrawListener事件监听
                MainActivity.this.getWindow().getDecorView().getViewTreeObserver().removeOnPreDrawListener(this);
                return true;
            }
        });
    }
}
