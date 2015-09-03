package in.tanjo.twido.adapter.viewholder;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import butterknife.Bind;
import butterknife.ButterKnife;
import in.tanjo.twido.R;
import in.tanjo.twido.model.Timeline;

public class CollectionListViewHolder extends RecyclerView.ViewHolder {

  @Bind(R.id.collection_list_card_view_name) TextView mNameView;
  @Bind(R.id.collection_list_card_view_description) TextView mDescriptionView;
  @Bind(R.id.collection_list_card_view_visibility) ImageView mVisibility;

  public CollectionListViewHolder(View itemView) {
    super(itemView);
    ButterKnife.bind(this, itemView);
  }

  public void bind(Timeline timeline) {
    mNameView.setText(timeline.getName());
    mDescriptionView.setText(timeline.getDescription());
    if (timeline.getVisibility().equals("public")) {
      mVisibility.setImageResource(R.drawable.ic_lock_open_black_24dp);
    } else {
      mVisibility.setImageResource(R.drawable.ic_lock_outline_black_24dp);
    }
  }
}
