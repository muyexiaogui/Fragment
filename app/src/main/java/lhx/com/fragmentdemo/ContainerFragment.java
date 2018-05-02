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

public class ContainerFragment extends Fragment {

    private View rootView;
    private Button mBtn;
    private TextView mTv;
    private Bundle arguments;
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
       rootView = inflater.inflate(R.layout.container_fragment,container,false);
       mBtn = (Button)rootView.findViewById(R.id.fragment_container_btn);
       mTv = (TextView)rootView.findViewById(R.id.fragment_container_tv);
        //取值
        arguments = getArguments();

       mBtn.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {

               if(arguments != null){
                   String value = arguments.getString("key", "");
                   mTv.setText("接收的信息"+ value);
               }

           }
       });

        return rootView;
    }
}
