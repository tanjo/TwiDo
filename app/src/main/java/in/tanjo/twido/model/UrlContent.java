package in.tanjo.twido.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class UrlContent {

  @SerializedName("url") String mUrl;
  @SerializedName("expanded_url") String mExpandedUrl;
  @SerializedName("display_url") String mDispalyUrl;
  @SerializedName("indices") List<Integer> mIndices;

}
