package cn.likegirl;

import java.util.concurrent.TimeUnit;
import okhttp3.ConnectionPool;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Request.Builder;
import okhttp3.Response;
import okhttp3.ResponseBody;
import org.junit.Test;

/**
 * Description :   .
 *
 * @author : LikeGirl
 * @date : Created in 2020/5/20 17:34
 */
public class CrawlerSomTest {

    private volatile static OkHttpClient httpClient = null;

    private static OkHttpClient getHttpClient() {
        if(httpClient == null){
            synchronized (CrawlerSomTest.class){
                if(httpClient == null){
                    httpClient = new OkHttpClient.Builder()
                            //设置连接超时
                            .connectTimeout(10, TimeUnit.SECONDS)
                            //设置读超时
                            .readTimeout(30, TimeUnit.SECONDS)
                            //设置写超时
                            .writeTimeout(30, TimeUnit.SECONDS)
                            //是否自动重连
                            .retryOnConnectionFailure(true)
                            .connectionPool(new ConnectionPool(1, 5, TimeUnit.MINUTES))
                            .build();
                }
            }
        }
        return httpClient;
    }

    @Test
    public void test() throws Exception {
        OkHttpClient client = getHttpClient();
        Request request = new Builder()
                .url("http://lian.liaomei21.com/app/index.php?i=27&t=0&v=1.79&from=wxapp&c=entry&a=wxapp&do=surgery&state=we7sid-d25734a457b62d26b3fcbb553af775d9&sign=b1b3c40d84eae665716c41b656b717d8&category_id=376&keyword=&page=1&status=1&uid=126545&searchmode=fuzzy&n=1&bb=1&op=search&m=mengwei_speechcraft&vt=1589967624000&vn=Lp9czkZlqPd0AEql&client=mpweixin&ster=1&sid=d25734a457b62d26b3fcbb553af775d9")
                .get()
                .addHeader("Host", "lian.liaomei21.com")
                .addHeader("user-agent", "Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/53.0.2785.143 Safari/537.36 MicroMessenger/7.0.9.501 NetType/WIFI MiniProgramEnv/Windows WindowsWechat")
                .addHeader("content-type", "application/json")
                .addHeader("referer", "https://servicewechat.com/wx1fd84e4b6937535f/1/page-frame.html")
                .build();
        Response response = client.newCall(request).execute();
        if(response.isSuccessful()){
            ResponseBody body = response.body();
            System.out.println(body.string());
        }
    }
}
