package in.tanjo.twido.model;

import com.google.gson.annotations.SerializedName;

public class Timeline {

  @SerializedName("name") String mName;
  @SerializedName("user_id") long mUserId;
  @SerializedName("collection_url") String mCollectionUrl;
  @SerializedName("description") String mDescription;
  @SerializedName("url") String mUrl;
  @SerializedName("visibility") String mVisibility;
  @SerializedName("timeline_order") String mTimelineOrder;
  @SerializedName("collection_type") String mCollectionType;

  public String getName() {
    return mName;
  }

  public long getUserId() {
    return mUserId;
  }

  public String getCollectionUrl() {
    return mCollectionUrl;
  }

  public String getDescription() {
    return mDescription;
  }

  public String getUrl() {
    return mUrl;
  }

  public String getVisibility() {
    return mVisibility;
  }

  public String getTimelineOrder() {
    return mTimelineOrder;
  }

  public String getCollectionType() {
    return mCollectionType;
  }
}
