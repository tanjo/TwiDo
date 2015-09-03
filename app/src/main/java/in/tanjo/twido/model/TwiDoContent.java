package in.tanjo.twido.model;

import com.google.gson.annotations.SerializedName;

public class TwiDoContent {

  @SerializedName("objects") TwiDoObject mObjects;
  @SerializedName("response") TwiDoResponse mTwiDoResponse;

  public TwiDoObject getObjects() {
    return mObjects;
  }

  public TwiDoResponse getTwiDoResponse() {
    return mTwiDoResponse;
  }
}
