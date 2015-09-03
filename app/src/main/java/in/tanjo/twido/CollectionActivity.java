package in.tanjo.twido;

import android.content.Context;
import android.content.Intent;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.twitter.sdk.android.Twitter;
import com.twitter.sdk.android.core.Callback;
import com.twitter.sdk.android.core.Result;
import com.twitter.sdk.android.core.TwitterApiClient;
import com.twitter.sdk.android.core.TwitterCore;
import com.twitter.sdk.android.core.TwitterException;
import com.twitter.sdk.android.core.TwitterSession;
import com.twitter.sdk.android.core.internal.TwitterCollection;
import com.twitter.sdk.android.core.services.CollectionService;

import java.sql.Time;
import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import in.tanjo.twido.adapter.CollectionListAdapter;
import in.tanjo.twido.adapter.listener.OnCardItemClickListener;
import in.tanjo.twido.model.Timeline;
import in.tanjo.twido.model.TwiDoContent;
import in.tanjo.twido.model.TwiDoObject;
import in.tanjo.twido.model.TwiDoResult;
import in.tanjo.twido.preference.TwitterAccountManager;
import in.tanjo.twido.service.CustomCollectionService;
import in.tanjo.twido.service.client.CollectionApiClient;

public class CollectionActivity extends AppCompatActivity {

  @Bind(R.id.collection_toolbar) Toolbar mToolbar;
  @Bind(R.id.collection_list_recyclearview) RecyclerView mCollectionListView;

  private TwiDoContent mContent;

  /**
   * CollectionActivity を表示する.
   */
  public static void startActivity(Context activity) {
    Intent intent = new Intent(activity, CollectionActivity.class);
    activity.startActivity(intent);
  }

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_collection);
    ButterKnife.bind(this);
    setSupportActionBar(mToolbar);
    init();
  }

  @Override
  public boolean onCreateOptionsMenu(Menu menu) {
    // Inflate the menu; this adds items to the action bar if it is present.
    getMenuInflater().inflate(R.menu.menu_collection, menu);
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

  private void init() {
    mCollectionListView.setHasFixedSize(true);
    mCollectionListView.setLayoutManager(new LinearLayoutManager(this));
    collectionList();
  }

  private void setupCollectionList(List<Timeline> timelines) {
    CollectionListAdapter adapter = new CollectionListAdapter(timelines);
    adapter.setOnCardItemClickListener(new OnCardItemClickListener<Timeline>() {
      @Override
      public void onCardItemClick(View v, RecyclerView.Adapter adapter, int position, Timeline model) {
        // TODO: ページ移動
        Snackbar.make(mCollectionListView, "Click", Snackbar.LENGTH_SHORT).show();
      }
    });
    mCollectionListView.setAdapter(adapter);
  }

  private void collectionList() {
    TwitterSession session = Twitter.getSessionManager().getActiveSession();
    TwitterAccountManager manager = new TwitterAccountManager(this);
    manager.setTwitterSession(session);

    long userId = manager.getUserId();
    String screenName = "";

    CollectionApiClient collectionApiClient =
        new CollectionApiClient(TwitterCore.getInstance().getSessionManager().getActiveSession());
    CustomCollectionService collectionService = collectionApiClient.getCustomCollectionService();
    collectionService.list(userId, screenName, 0, 0, null, new Callback<TwiDoContent>() {
      @Override
      public void success(Result<TwiDoContent> result) {
        mContent = result.data;

        List<Timeline> timelines = new ArrayList<Timeline>();
        for (TwiDoResult r : result.data.getTwiDoResponse().getResults()) {
          String id = r.getTimelineId();
          if (id != null && id.length() > 0) {
            Timeline timeline = result.data.getObjects().getTimelines().get(id);
            if (timeline != null) {
              timelines.add(timeline);
            }
          }
        }
        setupCollectionList(timelines);
      }

      @Override
      public void failure(TwitterException e) {
        e.printStackTrace();
      }
    });
  }

  private void collectionEntries() {
    TwitterApiClient twitterApiClient = TwitterCore.getInstance().getApiClient();
    CollectionService collectionService = twitterApiClient.getCollectionService();
    collectionService.collection("", null, null, null, new Callback<TwitterCollection>() {
      @Override
      public void success(Result<TwitterCollection> result) {

      }

      @Override
      public void failure(TwitterException e) {

      }
    });
  }
}
