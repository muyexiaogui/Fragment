package lhx.com.fragmentdemo;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by lhx
 * date:on 2018/4/30 0030.
 * TODO :
 */

public class AnotherRightFragment extends Fragment {

    public static final String TAG = "AnotherRightFragment";

    private View rootView;

    @Override
    public void onAttach(Context context) {
        Log.e(TAG,"----------------onAttach");
        super.onAttach(context);
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        Log.e(TAG,"----------------onCreate");
        super.onCreate(savedInstanceState);
    }



    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        Log.e(TAG,"----------------onCreateView");
        rootView = inflater.inflate(R.layout.another_right_fragment,container,false);
        return  rootView;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        Log.e(TAG,"----------------onActivityCreated");
        super.onActivityCreated(savedInstanceState);
    }

    @Override
    public void onStart() {
        Log.e(TAG,"----------------onStart");
        super.onStart();
    }

    @Override
    public void onResume() {
        Log.e(TAG,"----------------onResume");
        super.onResume();
    }

    @Override
    public void onPause() {
        Log.e(TAG,"----------------onPause");
        super.onPause();
    }

    @Override
    public void onStop() {
        Log.e(TAG,"----------------onStop");
        super.onStop();
    }

    @Override
    public void onDestroyView() {
        Log.e(TAG,"----------------onDestroyView");
        super.onDestroyView();
    }

    @Override
    public void onDestroy() {
        Log.e(TAG,"----------------onDestroy");
        super.onDestroy();
    }

    @Override
    public void onDetach() {
        Log.e(TAG,"----------------onDetach");
        super.onDetach();
    }
}
