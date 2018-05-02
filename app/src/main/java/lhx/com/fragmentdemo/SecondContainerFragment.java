package lhx.com.fragmentdemo;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by lhx
 * date:on 2018/5/2 0002.
 * TODO :
 */

public class SecondContainerFragment extends Fragment {

    private View rootView;
    private Button mbtn;
    private TextView mTv;
    private String msg;
    public void setMsg(String msg){
        this.msg = msg;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.second_container_fragment,container,false);
        mbtn = (Button) rootView.findViewById(R.id.second_container_fragment_btn);
        mTv = (TextView)rootView.findViewById(R.id.second_container_fragment_tv);

        mbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(msg != null){
                    mTv.setText("获取到的信息"+msg);
                }

            }
        });
        return rootView;
    }
}
