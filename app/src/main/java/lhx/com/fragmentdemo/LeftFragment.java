package lhx.com.fragmentdemo;

/**
 * Created by lhx
 * date:on 2018/4/30 0030.
 * TODO :左边的Fragment
 */

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 *  1、继承Fragment  注意：有两个包 ， 一个是android.app.Fragment, 一个是android.support.v4.Fragment
 * 一般我们使用V4包下的，因为这样可以兼容低版本
 *
 * 2、重写OnCreateView方法
 * 3、使用布局加载器加载布局文件
**/

public class LeftFragment extends Fragment {

    private View rootView;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
       rootView = inflater.inflate(R.layout.left_fragment,container,false);
       return  rootView;
    }
}
