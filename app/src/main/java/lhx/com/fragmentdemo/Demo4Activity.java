package lhx.com.fragmentdemo;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
/**
 * Fragment传值， Activity向Fragment传值
 *
 * **/
public class Demo4Activity extends AppCompatActivity {

    private Button mBtn;
    private FragmentManager manager;
    private FragmentTransaction transaction;
    private SecondContainerFragment fragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_demo4);
        mBtn = findViewById(R.id.activity_demo4_btn);
        manager = getSupportFragmentManager();
        fragment = new SecondContainerFragment();
        //tag fragment的唯一 标识
        manager.beginTransaction().add(R.id.activity_demo4_fl_container,fragment,"content").commit();

        mBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //进行值传递
                SecondContainerFragment contentFragment = (SecondContainerFragment) manager.findFragmentByTag("content");
                contentFragment.setMsg("第二种方法 - 我在ACitivy中传递的值");
            }
        });
    }
}
