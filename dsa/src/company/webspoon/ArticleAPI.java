package company.webspoon;

import java.io.*;
import java.util.*;


//import com.google.gson.Gson;
import java.net.*;


/**
 * Created by oakinrele on Oct, 2020
 */
public class ArticleAPI {
    /*
     * Complete the 'getUsernames' function below.
     *
     * The function is expected to return a STRING_ARRAY.
     * The function accepts INTEGER threshold as parameter.
     *
     * URL for cut and paste
     * https://jsonmock.hackerrank.com/api/article_users?page=<pageNumber>
     */

    public static List<String> getUsernames(int threshold) {
        List<User> users = new ArrayList<>();
        getAllUsers(users);
        List<String> result = new ArrayList<>();

        for(User user : users)
        {
            if(user.submission_count > threshold)
            {
                result.add(user.username);
            }
        }
        return result;
    }


    public static void getAllUsers(List<User> users)
    {
        int page = 1;
        String urlStr = "https://jsonmock.hackerrank.com/api/article_users?page=" + page;
        String tmpRes = getResultFromUrl(urlStr);
        Article obj = convertToClass(tmpRes);
        int totalPgs = obj.total_pages;
        users.addAll(obj.data);
        page++;
        while(page <= totalPgs){
            urlStr = "https://jsonmock.hackerrank.com/api/article_users?page=" + page;
            tmpRes = getResultFromUrl(urlStr);
            obj = convertToClass(tmpRes);

            users.addAll(obj.data);
            page++;
        }

    }

    public static Article convertToClass(String s){

        //Gson gson = new Gson();
        //return gson.fromJson(s, Article.class);
        return null;
    }

    public static String getResultFromUrl(String urlStr){
        try {
            URL url = new URL(urlStr);
            URLConnection connection = url.openConnection();
            HttpURLConnection http = (HttpURLConnection) connection;
            http.setRequestMethod("GET");
            http.setDoOutput(true);
            InputStreamReader reader = new InputStreamReader(http.getInputStream());
            BufferedReader br = new BufferedReader(reader);
            StringBuilder sb = new StringBuilder();
            String output;
            while ((output = br.readLine()) != null) {
                sb.append(output);
            }
            return sb.toString();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "";
    }

    class Article
    {
        String page;
        int per_page;
        int total;
        int total_pages;
        List<User> data;
    }

    class User {
        int id;
        String username;
        String about;
        int submitted;
        String updated_at;
        int submission_count;
        int comment_count;
        String created_at;
    }
}
