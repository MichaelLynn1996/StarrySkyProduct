package us.xingkong.starmessage.operator;

import com.google.gson.Gson;

import io.realm.RealmList;
import us.xingkong.starmessage.been.Items;
import us.xingkong.starmessage.been.JsonRootBean;

/**
 * Created by SeaLynn0 on 2017/7/9.
 */

public class GsonOperator {
    public static void parseJSONWithGson(String jsonData) {
        Gson gson = new Gson();
        JsonRootBean bean = gson.fromJson(jsonData, JsonRootBean.class);
//        System.out.println(bean);
        parseGsonToRealm(bean);
    }

    public static void parseGsonToRealm(JsonRootBean bean) {
        RealmList<Items> list = bean.getItems();
        RealmOperator.clearAllItems();
        for (int i = 0; i < list.size(); i++) {
            Items item = list.get(i);
//            System.out.println(i + item.getName() + item.getType() + item.getMaster_release().getVersion());
            RealmOperator.addItem(item);
        }

    }
}
