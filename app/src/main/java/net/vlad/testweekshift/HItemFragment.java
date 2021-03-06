package net.vlad.testweekshift;

import android.content.Context;
import android.graphics.Point;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;

import net.vlad.testweekshift.model.DayModel;

import org.joda.time.DateTime;

import java.util.ArrayList;

/**
 * A fragment representing a list of Items.
 * <p/>
 * Activities containing this fragment MUST implement the {@link OnListFragmentInteractionListener}
 * interface.
 */
public class HItemFragment extends Fragment {

    // TODO: Customize parameter argument names
    private static final String ARG_COLUMN_COUNT = "column-count";
    // TODO: Customize parameters
    private int mColumnCount = 1;
    private OnListFragmentInteractionListener mListener;

    /**
     * Mandatory empty constructor for the fragment manager to instantiate the
     * fragment (e.g. upon screen orientation changes).
     */
    public HItemFragment() {
    }

    // TODO: Customize parameter initialization
    @SuppressWarnings("unused")
    public static HItemFragment newInstance(int columnCount) {
        HItemFragment fragment = new HItemFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_COLUMN_COUNT, columnCount);
        fragment.setArguments(args);
        return fragment;
    }

	public ArrayList<DayModel> SetWeek(DateTime firstDay){
    	ArrayList<DayModel> _dayList = new ArrayList<>();
     	for (int i=1;i<8;i++){
    		DayModel _dm = new DayModel();
    		_dm.setFid(i);
    		_dm.setFdate(firstDay.plusDays(i-1));
    		_dm.setFisHasShift(i%3==0);
    		_dm.setShiftCount(_dm.isFisHasShift()?3:0);
    		_dm.setShiftColor(_dm.isFisHasShift()?12487:0);
    		_dayList.add(_dm);
	    }
	    return _dayList;
	}
    
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (getArguments() != null) {
            mColumnCount = getArguments().getInt(ARG_COLUMN_COUNT);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_hitem_list, container, false);

        // Set the adapter
        
        //if (view instanceof RecyclerView) {
            Context context = view.getContext();
            RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.list);
        //    if (mColumnCount <= 1) {
                recyclerView.setLayoutManager(new LinearLayoutManager(context,LinearLayoutManager.HORIZONTAL, false));
        //    } else {
        //        recyclerView.setLayoutManager(new GridLayoutManager(context, mColumnCount));
        //    }
            recyclerView.setAdapter(new HorizontalRecyclerViewAdapter(SetWeek(org.joda.time.DateTime.now()), mListener));
            recyclerView.setHasFixedSize(true);
            int w =calculateCellWidth(context, 7);
            recyclerView.setMinimumWidth(w);
		          
        //}s
        return view;
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

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnListFragmentInteractionListener) {
            mListener = (OnListFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnListFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p/>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnListFragmentInteractionListener {
        // TODO: Update argument type and name
        void onListFragmentInteraction(DayModel item);
    }
}
