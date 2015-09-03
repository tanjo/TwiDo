package in.tanjo.twido.model;

import com.google.gson.annotations.SerializedName;

public class TwiDoResult {

  @SerializedName("timeline_id") String mTimelineId;

  public String getTimelineId() {
    return mTimelineId;
  }
}
