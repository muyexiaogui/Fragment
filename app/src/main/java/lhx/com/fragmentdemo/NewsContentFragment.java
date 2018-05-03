package lhx.com.fragmentdemo;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by lhx
 * date:on 2018/5/3 0003.
 * TODO :新闻内容
 */

public class NewsContentFragment extends Fragment {

    private View rootView;
    private TextView newsTitleTv,newsContentTv;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.news_content_frag,container,false);
        return rootView;
    }
    public void refresh(String newsTitle,String newsContent){
        View visibilityLayout = rootView.findViewById(R.id.visibility_layout);
        visibilityLayout.setVisibility(View.VISIBLE);
        newsTitleTv = rootView.findViewById(R.id.news_title);
        newsContentTv = rootView.findViewById(R.id.news_content);
        newsTitleTv.setText(newsTitle);
        newsContentTv.setText(newsContent);

    }
}
