package in.tanjo.twido.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class TwiDoResponse {
  @SerializedName("results") List<TwiDoResult> mResults;
  @SerializedName("cursors") Cursor mCursors;

  public List<TwiDoResult> getResults() {
    return mResults;
  }

  public Cursor getCursors() {
    return mCursors;
  }
}
