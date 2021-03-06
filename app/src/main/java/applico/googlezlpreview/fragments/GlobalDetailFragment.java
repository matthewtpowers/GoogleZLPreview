package applico.googlezlpreview.fragments;

import android.app.Activity;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.Html;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import applico.googlezlpreview.R;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link GlobalDetailFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link GlobalDetailFragment#newInstance} factory method to
 * create an instance of this fragment.
 *
 */
public class GlobalDetailFragment extends Fragment {

    private static final String LOG_TAG = GlobalDetailFragment.class.getSimpleName();

    private View mRootView;
    private TextView mContentView;

    private String mContent = "";

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    public static final String ARG_CONTENT = "content";

    private OnFragmentInteractionListener mListener;

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment GlobalDetailFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static GlobalDetailFragment newInstance(String param1, String param2) {
        GlobalDetailFragment fragment = new GlobalDetailFragment();
        Bundle args = new Bundle();
        args.putString(ARG_CONTENT, param1);
        fragment.setArguments(args);
        return fragment;
    }
    public GlobalDetailFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.e(LOG_TAG,"In on Create");
        if (getArguments() != null) {
            Log.e(LOG_TAG, "Arguements is not null");
            mContent = getArguments().getString(ARG_CONTENT);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        Log.e(LOG_TAG,"On Create View");
        mRootView = inflater.inflate(R.layout.fragment_global_detail, container, false);
        mContentView = (TextView)mRootView.findViewById(R.id.content);
        mContentView.setText(Html.fromHtml(mContent));

        return mRootView;
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        try {
            mListener = (OnFragmentInteractionListener) activity;
        } catch (ClassCastException e) {
            throw new ClassCastException(activity.toString()
                    + " must implement OnFragmentInteractionListener");
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
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        public void onFragmentInteraction(Uri uri);
    }

}
