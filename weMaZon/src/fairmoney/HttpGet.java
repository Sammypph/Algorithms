package fairmoney;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;

/**
 * Created by oakinrele on Jun, 2020
 */
public class HttpGet {

    public static void main(String[] args) {
        try {
            URL url = new URL("https://jsonmock.hackerrank.com/api/articles?author=epaga&page=1");
            URLConnection connection = url.openConnection();
            HttpURLConnection http = (HttpURLConnection) connection;
            http.setRequestMethod("GET");
            http.setDoOutput(true);

            InputStream inputStream = http.getInputStream();

            System.out.println(inputStream.toString());

            InputStreamReader reader = new InputStreamReader(http.getInputStream());
            BufferedReader br = new BufferedReader(reader);
            StringBuilder sb = new StringBuilder();
            String output;
            while ((output = br.readLine()) != null) {
                sb.append(output);
                break;
            }

            System.out.println(sb.toString());


        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}


class ArticleRes {
    String page;
    String perPage;
    String total;
    String totalPages;
    List<Data> dataList;
}

class Data {
    String title;
    String url;
    String author;
    int numComments;
    String storyId;
    String storyTitle;
    String storyUrl;
    String parentId;
    long createdAt;
}