package ny.citycollege.cs.actionbaronaction;

import android.app.Activity;
import android.graphics.drawable.Drawable;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.os.Handler;





public class MyMainActivity extends Activity {


    private final Handler mHandler = new Handler();

    private ColorAnimationDrawable mActionBarBackground;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_main);

        mActionBarBackground = new ColorAnimationDrawable();

        getActionBar().setBackgroundDrawable(mActionBarBackground);
        getActionBar().setDisplayShowTitleEnabled(false);
        getActionBar().setDisplayShowTitleEnabled(true);
//        if(Build.VERSION.SDK_INT < Build.VERSION_CODES.JELLY_BEAN_MR1){
//            mActionBarBackground.setCallback(mDrawableCallback);
//        }else {
//            getActionBar().setBackgroundDrawable(mActionBarBackground);
//        }


    }

    @Override
    protected void onResume() {
        super.onResume();
        mActionBarBackground.start();
    }

    @Override
    protected void onPause() {
        super.onPause();
        mActionBarBackground.stop();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.my_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }


    private Drawable.Callback mDrawableCallback = new Drawable.Callback(){

        @Override
        public void invalidateDrawable(Drawable drawable) {
            getActionBar().setBackgroundDrawable(drawable);

        }

        @Override
        public void scheduleDrawable(Drawable drawable, Runnable runnable, long l) {
            mHandler.postAtTime(runnable, l);

        }

        @Override
        public void unscheduleDrawable(Drawable drawable, Runnable runnable) {
            mHandler.removeCallbacks(runnable);

        }
    };
}
