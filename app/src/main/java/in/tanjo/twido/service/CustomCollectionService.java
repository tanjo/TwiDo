package in.tanjo.twido.service;

import in.tanjo.twido.model.TwiDoContent;
import in.tanjo.twido.model.TwiDoObject;
import retrofit.Callback;
import retrofit.http.GET;
import retrofit.http.POST;
import retrofit.http.Query;

public interface CustomCollectionService {
  /**
   *
   * @param userId required.
   * @param screenName required.
   * @param tweetId optional.
   * @param count optional.
   * @param cursor optional.
   * @param callback callback.
   */
  @GET("/1.1/collections/list.json")
  void list(@Query("user_id") long userId, @Query("screenName") String screenName, @Query("tweet_id") long tweetId, @Query("count") int count, @Query("cursor") String cursor, Callback<TwiDoContent> callback);

//  @GET("/1.1/collections/show.json")
//  void show(@Query("id") String id);
//
//  @GET("/1.1/collections/entries.json")
//  void entries(@Query("id") String id, @Query("count") long count, @Query("max_position") long maxPosition, @Query("min_position") long minPosition);
//
//  @POST("")
//  void create();
//
//  @POST("")
//  void update();
//
//  @POST("")
//  void destroy();
//
//  @POST("")
//  void addEntries();
//
//  @POST("")
//  void removeEntries();
//
//  @POST("")
//  void moveEntries();
//
//  @POST("")
//  void curateEntries();
}
