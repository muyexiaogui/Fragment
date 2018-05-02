package lhx.com.fragmentdemo;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

/**
 * Created by lhx
 * date:on 2018/5/2 0002.
 * TODO :
 */

public class ThirdContainerFragment extends Fragment implements View.OnClickListener {

    private View rootView;
    private Button firstBtn,secondBtn;

    // 定义用来与外部activity交互，获取到宿主activity
    private FragmentInteraction listterner;

    // 1 定义了所有activity必须实现的接口方法
    public interface FragmentInteraction {
        void process(String str);
    }

    // 当FRagmen被加载到activity的时候会被回调
    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        if(activity instanceof FragmentInteraction) {
            listterner = (FragmentInteraction)activity; // 2.2 获取到宿主activity并赋值
        } else{
            throw new IllegalArgumentException("activity must implements FragmentInteraction");
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.third_container_fragment, container, false);
       firstBtn = (Button) rootView.findViewById(R.id.third_container_fragment_first_btn);
        secondBtn = (Button) rootView.findViewById(R.id.third_container_fragment_second_btn);
        if (firstBtn != null||secondBtn!=null) {
            firstBtn.setOnClickListener(this);
            secondBtn.setOnClickListener(this);
        }
        return rootView;
    }

    @Override
    public void onClick(View v) {
        int id  = v.getId();
        switch (id) {
            case R.id.third_container_fragment_first_btn:
                listterner.process("我是第一个按钮传值"); // 3.1 执行回调
                break;
            case R.id.third_container_fragment_second_btn:
                listterner.process("我是第二个按钮传值");
                break;
        }
    }

    //把传递进来的activity对象释放掉
    @Override
    public void onDetach() {
        super.onDetach();
        listterner = null;
    }
}
