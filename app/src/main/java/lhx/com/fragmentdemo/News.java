package lhx.com.fragmentdemo;

/**
 * Created by lhx
 * date:on 2018/5/3 0003.
 * TODO :新闻实体类
 */

public class News {

    private String title;
    private String content;

    public News() {
    }

    public News(String title, String content) {
        this.title = title;
        this.content = content;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
