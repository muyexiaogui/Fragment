package lhx.com.fragmentdemo;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

/**
 * 动态添加Fragment
 * 1、创建待添加Fragment 的实例
 * 2、获取FragmentManager(V4包)。调用getSupportFragmentManager()方法得到
 * 3、开启一个transaction（事物），通过begintransaction（）方法开启
 * 4、向容器添加替换碎片，一般使用replace()方法实现，需要传入容器的ID 和待添加Fragment的实例
 * 5、提交事务，调用commit()方法
 *
 * 6、注意xml文件 此时我们使用的是容器来装Fragment，布局文件发生改变
 **/

public class Demo2Activity extends AppCompatActivity {

    private Button mBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_demo2);

        mBtn = (Button) findViewById(R.id.button);
        //默认为绿色的RightFragment
        replaceFragment(new RightFragment());

        mBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                replaceFragment(new AnotherRightFragment());
            }
        });
    }


    public void replaceFragment(Fragment fragment){
        FragmentManager manager = getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        transaction.replace(R.id.activity_main_right_fragment,fragment);
        transaction.addToBackStack(null);
        transaction.commit();
    }
}
