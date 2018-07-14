package us.xingkong.starmessage.net;

import retrofit2.Call;
import retrofit2.http.GET;
import us.xingkong.starmessage.been.JsonRootBean;

/**
 * Created by SeaLynn0 on 2017/7/8.
 */

public interface RetrofitService {
    @GET("apps?api_token=40491834f9928316f344629e1e90d505")
    Call<JsonRootBean> getApps();
}
