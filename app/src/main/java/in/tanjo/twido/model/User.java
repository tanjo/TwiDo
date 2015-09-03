package in.tanjo.twido.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class User {

  @SerializedName("id") long mId;
  @SerializedName("id_str") String mIdStr;
  @SerializedName("name") String mName;
  @SerializedName("screen_name") String mScreenName;
  @SerializedName("location") String mLocation;
  @SerializedName("description") String mDescription;
  @SerializedName("url") String mUrl;
  @SerializedName("entities") List<Entity> mEntities;
  @SerializedName("protected") boolean mProtected;
  @SerializedName("followers_count") long mFollowersCount;
  @SerializedName("friends_count") long mFriendsCount;
  @SerializedName("listed_count") long mListedCount;
  @SerializedName("created_at") String mCreatedAt;
  @SerializedName("favourites_count") long mFavoritesCount;
  @SerializedName("utc_offset") long mUtcOffset;
  @SerializedName("time_zone") String mTimeZone;
  @SerializedName("geo_enabled") boolean mGeoEnabled;
  @SerializedName("verified") boolean mVerified;
  @SerializedName("statuses_count") long mStatusesCount;
  @SerializedName("lang") String mLang;
  @SerializedName("contributors_enabled") boolean mContributorsEnabled;
  @SerializedName("is_translator") boolean mIsTranslator;
  @SerializedName("is_translation_enabled") boolean mIsTranslationEnabled;
  @SerializedName("profile_background_color") int mProfileBackgroundColor;
  @SerializedName("profile_background_image_url") String mProfileBackgroundImageUrl;
  @SerializedName("profile_background_image_url_https") String mProfileBackgroundImageUrlHttps;
  @SerializedName("profile_background_tile") boolean mProfileBackgroundTile;
  @SerializedName("profile_image_url") String mProfileImageUrl;
  @SerializedName("profile_image_url_https") String mProfileImageUrlHttps;
  @SerializedName("profile_banner_url") String mProfileBannerUrl;
  @SerializedName("profile_link_color") String mProfileLinkColor;
  @SerializedName("profile_sidebar_border_color") String mProfileSidebarBorderColor;
  @SerializedName("profile_sidebar_fill_color") String mProfileSidebarFillColor;
  @SerializedName("profile_text_color") String mProfileTextColor;
  @SerializedName("profile_use_background_image") boolean mProfileUseBackgroundImage;
  @SerializedName("default_profile") boolean mDefaultProfile;
  @SerializedName("default_profile_image") boolean mDefaultProfileImage;
  @SerializedName("following") boolean mFollowing;
  @SerializedName("follow_request_sent") boolean mFollowRequestSent;
  @SerializedName("notifications") boolean mNotifications;

}
