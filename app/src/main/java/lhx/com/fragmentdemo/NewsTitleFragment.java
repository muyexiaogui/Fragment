package lhx.com.fragmentdemo;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by lhx
 * date:on 2018/5/3 0003.
 * TODO :
 */

public class NewsTitleFragment extends Fragment {
    private View rootView;
    private  boolean isTwoPane;
    private RecyclerView newsTitleRecyclerView;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.news_title_frag,container,false);
        newsTitleRecyclerView = (RecyclerView) rootView.findViewById(R.id.news_title_recycler_view);
        LinearLayoutManager manager = new LinearLayoutManager(getContext());
        newsTitleRecyclerView.setLayoutManager(manager);
        NewsAdapter adapter = new NewsAdapter(getNews());
        newsTitleRecyclerView.setAdapter(adapter);
        return rootView;
    }

    private List<News> getNews(){
        List<News> newsList = new ArrayList<>();
        for (int i = 0; i <= 50 ; i++) {
            News news = new News();
            news.setTitle("this is new title " + i);
            news.setContent(getRandomLengthContent("这是内容"+i));
            newsList.add(news);
        }
        return  newsList;
    }

    private String getRandomLengthContent(String content){
        Random random = new Random();
        int length  = random.nextInt(20)+1;
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i <length ; i++) {
            builder.append(content);
        }
        return  builder.toString();
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        if(getActivity().findViewById(R.id.news_content_layout) != null){
            isTwoPane = true; //为双页模式
        }else {
            isTwoPane = false; //为单页模式
        }
    }

    class NewsAdapter extends RecyclerView.Adapter<NewsAdapter.ViewHolder> {

        private List<News> mNewsList;

        public NewsAdapter(List<News> mNewsList) {
            this.mNewsList = mNewsList;
        }

        @Override
        public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View view  = LayoutInflater.from(getActivity()).inflate(R.layout.news_item,parent,false);
            final ViewHolder holder = new ViewHolder(view);
            view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    News news = mNewsList.get(holder.getAdapterPosition());
                    if(isTwoPane){
                        //如果是双页模式，刷新NewsContentFragment中的内容
                        NewsContentFragment newsContentFragment = (NewsContentFragment) getFragmentManager().findFragmentById(R.id.news_content_fragment);
                        newsContentFragment.refresh(news.getTitle(),news.getContent());
                    }else{
                        //单页模式 直接启动NewsContentActivity
                        NewsContentActivity.actionStart(getActivity(),news.getTitle(),news.getContent());

                    }

                }
            });
            return holder;
        }

        @Override
        public void onBindViewHolder(ViewHolder holder, int position) {
            News news = mNewsList.get(position);
            holder.newsTitleTv.setText(news.getTitle());
        }

        @Override
        public int getItemCount() {
            return mNewsList.size();
        }

         class ViewHolder extends RecyclerView.ViewHolder{
            private TextView newsTitleTv;
            public ViewHolder(View itemView) {
                super(itemView);
                newsTitleTv = itemView.findViewById(R.id.news_title);
            }
        }
    }
}
