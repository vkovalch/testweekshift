package net.vlad.testweekshift;

import android.content.Context;
import android.graphics.Point;
import android.support.v7.widget.RecyclerView;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.LinearLayout;
import android.widget.TextView;

import net.vlad.testweekshift.HItemFragment.OnListFragmentInteractionListener;
import net.vlad.testweekshift.dummy.DummyContent.DummyItem;
import net.vlad.testweekshift.model.DayModel;

import java.util.List;

/**
 * {@link RecyclerView.Adapter} that can display a {@link DummyItem} and makes a call to the
 * specified {@link OnListFragmentInteractionListener}.
 * TODO: Replace the implementation with code for your data type.
 */
public class HorizontalRecyclerViewAdapter extends RecyclerView.Adapter<HorizontalRecyclerViewAdapter.ViewHolder> {

    private final List<DayModel> mValues;
    private final OnListFragmentInteractionListener mListener;

    public HorizontalRecyclerViewAdapter(List<DayModel> items, OnListFragmentInteractionListener listener) {
        mValues = items;
        mListener = listener;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.week_day_view, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        holder.mItem = mValues.get(position);
        holder.hday.setText(mValues.get(position).getFdate().toString("E"));
        holder.vday.setText(mValues.get(position).getFdate().toString("dd"));
        //holder.mView.set
        holder.mView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (null != mListener) {
                    // Notify the active callbacks interface (the activity, if the
                    // fragment is attached to one) that an item has been selected.
                    mListener.onListFragmentInteraction(holder.mItem);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return mValues.size();
    }
    
    public static int calculateCellWidth(Context context, int itemsOnScreen) {
        WindowManager windowManager = ((WindowManager) context.getSystemService(Context.WINDOW_SERVICE));
        if (windowManager != null) {
            Display display = windowManager.getDefaultDisplay();
            Point size = new Point();
            
            display.getSize(size);
            int screenWidth = (int)(size.x - 72*context.getResources().getDisplayMetrics().density + 0.5f);
            
            return screenWidth / itemsOnScreen;
        }
        
        return ViewGroup.LayoutParams.WRAP_CONTENT;
    }
    
    public class ViewHolder extends RecyclerView.ViewHolder {
        public final View mView;
        public final TextView hday;
        public final TextView vday;
        public DayModel mItem;

        public ViewHolder(View view) {
            super(view);
            mView = view;
            LinearLayout llroot = mView.findViewById(R.id.llroot);
            llroot.setWeightSum(1.0f);
            llroot.setMinimumWidth(calculateCellWidth(view.getContext(), 7));
            hday = (TextView) view.findViewById(R.id.sdv_day_letter);
            vday = (TextView) view.findViewById(R.id.sdv_day_number);
        }

        @Override
        public String toString() {
            return super.toString() + " '" + hday.getText() + "'";
        }
    }
}
