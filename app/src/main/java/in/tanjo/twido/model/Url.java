package in.tanjo.twido.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Url {

  @SerializedName("urls") List<UrlContent> mUrlContents;

}
