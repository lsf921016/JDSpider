package JDSpider;

/**
 * Created by lenovo on 2017/3/24.
 */
public class Test {
    public static void main(String[] args) {
        String homePage="http://www.jd.com/";
        final JDspider js=new JDspider();
        js.parseHomePage(homePage);
        long start=System.currentTimeMillis();
        System.out.println("开始爬。。。。。。。");
        js.begin();

        while(true){
            if(js.notVisited.isEmpty()&& Thread.activeCount() == 1||js.waitNum==js.maxthread){
                long end = System.currentTimeMillis();
                System.out.println("总共爬了"+js.allUrlset.size()+"个网页");
                System.out.println("总共耗时"+(end-start)/1000+"秒");
                System.exit(1);
//                break;
            }
        }
    }
}
