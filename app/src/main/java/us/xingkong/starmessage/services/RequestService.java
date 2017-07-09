package us.xingkong.starmessage.services;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by SeaLynn0 on 2017/7/8.
 */

public interface RequestService {
    @GET("apps?api_token=cd8d74030d27a02724735e5aef9feb75")
    Call<ResponseBody>getDate();
}
