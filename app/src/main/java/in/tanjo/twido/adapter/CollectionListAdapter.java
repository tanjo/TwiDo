package in.tanjo.twido.adapter;

import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.Adapter;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import in.tanjo.twido.R;
import in.tanjo.twido.adapter.listener.OnCardItemClickListener;
import in.tanjo.twido.adapter.viewholder.CollectionListViewHolder;
import in.tanjo.twido.model.Timeline;

public class CollectionListAdapter extends Adapter<ViewHolder> implements View.OnClickListener {

  private List<Timeline> mTimelines;
  private RecyclerView mRecyclearView;
  private OnCardItemClickListener<Timeline> mOnCardItemClickListener;

  public CollectionListAdapter(List<Timeline> timelines) {
    mTimelines = timelines;
  }

  @Override
  public int getItemCount() {
    return mTimelines.size();
  }

  @Override
  public void onBindViewHolder(ViewHolder viewHolder, int i) {
    if (viewHolder != null && viewHolder instanceof CollectionListViewHolder) {
      Timeline timeline = mTimelines.get(i);

      CollectionListViewHolder collectionListViewHolder = (CollectionListViewHolder) viewHolder;
      collectionListViewHolder.bind(timeline);
    }
  }

  @Override
  public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
    View v = LayoutInflater
        .from(viewGroup.getContext())
        .inflate(R.layout.collection_list_card_view, viewGroup, false);
    v.setOnClickListener(this);
    return new CollectionListViewHolder(v);
  }

  @Override
  public void onAttachedToRecyclerView(RecyclerView recyclerView) {
    super.onAttachedToRecyclerView(recyclerView);
    mRecyclearView = recyclerView;
  }

  @Override
  public void onDetachedFromRecyclerView(RecyclerView recyclerView) {
    super.onDetachedFromRecyclerView(recyclerView);
    mRecyclearView = null;
  }

  @Override
  public void onClick(View v) {
    if (mOnCardItemClickListener != null && mRecyclearView != null) {
      int position = mRecyclearView.getChildAdapterPosition(v);
      mOnCardItemClickListener.onCardItemClick(v, this, position, null);
    }
  }

  public void setOnCardItemClickListener(OnCardItemClickListener<Timeline> onCardItemClickListener) {
    mOnCardItemClickListener = onCardItemClickListener;
  }
}

