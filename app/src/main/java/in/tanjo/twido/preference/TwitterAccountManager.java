package in.tanjo.twido.preference;

import android.content.Context;
import android.content.SharedPreferences;

import com.twitter.sdk.android.core.TwitterSession;

public class TwitterAccountManager {
  public static final String PREFERENCE_NAME = "twitter_account_manager";
  public static final int PREFERENCE_MODE = Context.MODE_PRIVATE;

  private static final String KEY_TWITTER_ACCESS_TOKEN = "key_twitter_access_token";
  private static final String KEY_TWITTER_ACCESS_TOKEN_SECRET = "key_twitter_access_token_secret";
  private static final String KEY_TWITTER_USER_ID = "key_twitter_user_id";
  private static final String KEY_TWITTER_USER_NAME = "key_twitter_user_name";

  private SharedPreferences mSp;

  public TwitterAccountManager(Context context) {
    mSp = context.getSharedPreferences(PREFERENCE_NAME, PREFERENCE_MODE);
  }

  public void setAccessToken(String token) {
    mSp.edit().putString(KEY_TWITTER_ACCESS_TOKEN, token).apply();
  }

  public String getAccessToken() {
    return mSp.getString(KEY_TWITTER_ACCESS_TOKEN, "");
  }

  public void setAccessTokenSecret(String secret) {
    mSp.edit().putString(KEY_TWITTER_ACCESS_TOKEN_SECRET, secret).apply();
  }

  public String getAccessTokenSecret() {
    return mSp.getString(KEY_TWITTER_ACCESS_TOKEN_SECRET, "");
  }

  public void setUserId(long id) {
    mSp.edit().putLong(KEY_TWITTER_USER_ID, id).apply();
  }

  public long getUserId() {
    return mSp.getLong(KEY_TWITTER_USER_ID, 0);
  }

  public void setUserName(String name) {
    mSp.edit().putString(KEY_TWITTER_USER_NAME, name).apply();
  }

  public String getUserName() {
    return mSp.getString(KEY_TWITTER_USER_NAME, "");
  }

  public void setTwitterSession(TwitterSession session) {
    if (session != null) {
      setAccessToken(session.getAuthToken().token);
      setAccessTokenSecret(session.getAuthToken().secret);
      setUserId(session.getUserId());
      setUserName(session.getUserName());
    }
  }

  public boolean hasAccessToken() {
    return getAccessToken().length() > 0 && getAccessTokenSecret().length() > 0;
  }

}
