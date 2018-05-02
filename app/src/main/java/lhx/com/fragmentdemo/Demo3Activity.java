package lhx.com.fragmentdemo;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

/**
 * Fragment传值， Activity向Fragment传值
 *
 * **/
public class Demo3Activity extends AppCompatActivity  implements View.OnClickListener{

    private Button mBtn;
    private FragmentManager manager;
    private FragmentTransaction transaction;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_demo3);
        mBtn = (Button)findViewById(R.id.activity_demo3_button);
        manager = getSupportFragmentManager();
        mBtn.setOnClickListener(this);
        manager.beginTransaction().add(R.id.activity_demo3_fl_container,new ContainerFragment()).commit();

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.activity_demo3_button:
                //Activity对Fragment传值
               transaction = manager.beginTransaction();
                ContainerFragment fragment = new ContainerFragment();
                Bundle bundle = new Bundle();
                bundle.putString("key","第一种方法 --我在Activity中传的值");
                fragment.setArguments(bundle);
                transaction.add(R.id.activity_demo3_fl_container,fragment);
                transaction.commit();
                break;
        }
    }
}
