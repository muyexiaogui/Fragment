package lhx.com.fragmentdemo;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;

/**
 * 静态添加Fragment
 * 1、布局文件添加fragment （元素首字母小写）
 * 2、填写name属性，属性值为Fragment的包名+类名
 **/
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
       getMenuInflater().inflate(R.menu.main_menu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.demo2:
                startActivity(new Intent(MainActivity.this,Demo2Activity.class));
                break;
            case R.id.demo3:
                startActivity(new Intent(MainActivity.this,Demo3Activity.class));
                break;
            case R.id.demo4:
                startActivity(new Intent(MainActivity.this,Demo4Activity.class));
                break;
            case R.id.demo5:
                startActivity(new Intent(MainActivity.this,Demo5Activity.class));
                break;
            case R.id.newsDemo:
                startActivity(new Intent(MainActivity.this,NewsActivity.class));
        }
        return true;
    }

}
