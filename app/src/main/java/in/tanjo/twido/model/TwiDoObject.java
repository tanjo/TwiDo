package in.tanjo.twido.model;

import com.google.gson.annotations.SerializedName;

import java.util.Map;

public class TwiDoObject {
  @SerializedName("users") Map<String, User> mUsers;
  @SerializedName("timelines") Map<String, Timeline> mTimelines;

  public Map<String, User> getUsers() {
    return mUsers;
  }

  public Map<String, Timeline> getTimelines() {
    return mTimelines;
  }
}
