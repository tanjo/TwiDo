package in.tanjo.twido;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.LinearLayout;

import com.twitter.sdk.android.Twitter;
import com.twitter.sdk.android.core.Callback;
import com.twitter.sdk.android.core.Result;
import com.twitter.sdk.android.core.TwitterAuthConfig;
import com.twitter.sdk.android.core.TwitterException;
import com.twitter.sdk.android.core.TwitterSession;
import com.twitter.sdk.android.core.identity.TwitterLoginButton;

import butterknife.Bind;
import butterknife.ButterKnife;
import in.tanjo.twido.preference.TwitterAccountManager;
import in.tanjo.twido.util.TLog;
import io.fabric.sdk.android.Fabric;

public class MainActivity extends AppCompatActivity {

  @Bind(R.id.main_linearlayout) LinearLayout mLinearLayout;
  @Bind(R.id.twitter_login_button) TwitterLoginButton mTwitterLoginButton;
  @Bind(R.id.main_toolbar) Toolbar mToolbar;

  private TwitterAccountManager mAccountManager;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    fabric();
    setContentView(R.layout.activity_main);
    ButterKnife.bind(this);
    init();

    if (mAccountManager.hasAccessToken()) {
      CollectionActivity.startActivity(this);
      finish();
    }
  }

  @Override
  public boolean onCreateOptionsMenu(Menu menu) {
    // Inflate the menu; this adds items to the action bar if it is present.
    getMenuInflater().inflate(R.menu.menu_main, menu);
    return true;
  }

  @Override
  public boolean onOptionsItemSelected(MenuItem item) {
    // Handle action bar item clicks here. The action bar will
    // automatically handle clicks on the Home/Up button, so long
    // as you specify a parent activity in AndroidManifest.xml.
    int id = item.getItemId();

    //noinspection SimplifiableIfStatement
    if (id == R.id.action_settings) {
      return true;
    }

    return super.onOptionsItemSelected(item);
  }

  @Override
  protected void onActivityResult(int requestCode, int resultCode, Intent data) {
    super.onActivityResult(requestCode, resultCode, data);
    mTwitterLoginButton.onActivityResult(requestCode, resultCode, data);
  }

  /**
   * Fabric (Twitter Kit の初期化)
   */
  private void fabric() {
    Fabric.with(this, new Twitter(new TwitterAuthConfig(
        BuildConfig.TWITTER_CONSUMER_KEY,
        BuildConfig.TWITTER_CONSUMER_SECRET)));
  }

  /**
   * View, Action 等の初期化
   */
  private void init() {
    setSupportActionBar(mToolbar);

    mAccountManager = new TwitterAccountManager(this);

    mTwitterLoginButton.setCallback(new Callback<TwitterSession>() {
      @Override
      public void success(Result<TwitterSession> result) {
        mAccountManager.setTwitterSession(result.data);
        CollectionActivity.startActivity(MainActivity.this);
        finish();
      }

      @Override
      public void failure(TwitterException e) {
        e.printStackTrace();
        TLog.i("失敗");
        Snackbar.make(mLinearLayout, "ログインに失敗しました", Snackbar.LENGTH_SHORT).show();
      }
    });
  }
}
