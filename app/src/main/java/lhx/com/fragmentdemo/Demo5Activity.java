package lhx.com.fragmentdemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

/**
 * Fragment传值， Fragment向Activity传值
 * 1、在fragment中定义一个内部回调接口，再让包含该fragment的activity实现该回调接口，这样fragment即可调用该回调方法将数据传给activity。
 * 2、当fragment添加到activity中时，会调用fragment的方法onAttach()，这个方法中适合检查activity是否实现了OnArticleSelectedListener接口，
 * 检查方法就是对传入的activity的实例进行类型转换，然后赋值给我们在fragment中定义的接口。
 * 3、在一个fragment从activity中剥离的时候，就会调用onDetach方法，这个时候要把传递进来的activity对象释放掉，不然会影响activity的销毁，产生不必要的错误。
 * 意看onAttach方法中的代码，在赋值之前要做一个判断，看看Activity中有没有实现了这个接口，用到了instanceof。如果没有实现接口，我们就抛出异常。
 * **/
public class Demo5Activity extends AppCompatActivity implements ThirdContainerFragment.FragmentInteraction {

    private TextView mtv;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_demo5);
        mtv = (TextView)findViewById(R.id.actiity_demo5_tv);
        getSupportFragmentManager().beginTransaction().add(R.id.activity_demo5_fl_container,new ThirdContainerFragment()).commit();
    }

    @Override
    public void process(String str) {
        mtv.setText("获取Fragment传值"+str);
    }
}
