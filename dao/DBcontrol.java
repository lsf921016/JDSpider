package JDSpider.dao;

import JDSpider.JDBean;
import org.jsoup.Connection;

/**
 * Created by lenovo on 2017/3/27.
 */
public class DBcontrol {
    public static boolean insertToDB(JDBean jd){
        return DBModel.insertToDB(jd.getName(),
                jd.getNumber(),jd.getUrl(),
                jd.getPictureSrc(),
                jd.getDetail(),
                jd.getPrice(),
                jd.getCommentCount(),
                jd.getGoodRate());
    }

}
