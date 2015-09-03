package in.tanjo.twido.service.client;

import com.twitter.sdk.android.core.Session;
import com.twitter.sdk.android.core.TwitterApiClient;

import in.tanjo.twido.service.CustomCollectionService;

public class CollectionApiClient extends TwitterApiClient {
  public CollectionApiClient(Session session) {
    super(session);
  }

  public CustomCollectionService getCustomCollectionService() {
    return (CustomCollectionService) getService(CustomCollectionService.class);
  }
}
