package in.tanjo.twido.adapter.listener;

import android.support.v7.widget.RecyclerView;
import android.view.View;

public interface OnCardItemClickListener<T> {
  void onCardItemClick(View v, RecyclerView.Adapter adapter, int position, T model);
}
