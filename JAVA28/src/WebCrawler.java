import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class WebCrawler {
    public static void main(String[] args) throws IOException {
        webc();
    }
    //网络爬虫 爬取姓名
    public static void webc() throws IOException {
        String boyName = "http://www.haoming8.cn/baobao/10881.html";
        String grilName = "http://www.haoming8.cn/baobao/7641.html";
        String s1 = webCrawler(boyName);
        String regex1 = "(?<![\\u4E00-\\u9FA5])([\\u4E00-\\u9FA5]{2})(、|。)";
        ArrayList<String> ary = getData(s1,regex1,1);
        System.out.println(ary);
    }
    private static String webCrawler(String http) throws IOException {
        URL url = new URL(http);
        URLConnection conn = url.openConnection();
        StringBuilder sb = new StringBuilder();
        InputStreamReader isr= new InputStreamReader(conn.getInputStream());
        char[] ch = new char[1024*1024];
        int len;
        while((len = isr.read(ch))!=-1){
            sb.append(ch,0,len);
        }
        isr.close();
        return sb.toString();
    }
    private static ArrayList<String> getData(String str,String regex,int index){
        ArrayList<String> ary = new ArrayList<>();
        Matcher matcher = Pattern.compile(regex).matcher(str);
        while(matcher.find()){
            ary.add(matcher.group(index));
        }
        return ary;
    }
}
