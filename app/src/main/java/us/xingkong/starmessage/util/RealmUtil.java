package us.xingkong.starmessage.util;

import android.support.annotation.NonNull;

import java.util.List;

import io.realm.Realm;
import io.realm.RealmResults;
import us.xingkong.starmessage.been.Items;

/**
 * Created by SeaLynn0 on 2017/7/9.
 */

public class RealmUtil {

    public static void addItem(Items item){
        // Copy the object to Realm. Any further changes must happen on realmUser
        getRealm().beginTransaction();
        getRealm().copyToRealm(item);
        getRealm().commitTransaction();
    }

    public static void addItems(List items){
        // Copy the object to Realm. Any further changes must happen on realmUser
        getRealm().beginTransaction();
        getRealm().copyToRealm(items);
        getRealm().commitTransaction();
    }

    public static List<Items> queryAllItems() {

        RealmResults<Items> items = getRealm().where(Items.class).findAll();

        return getRealm().copyFromRealm(items);
    }

    public static Items queryItemById(String id) {
        Realm  mRealm=Realm.getDefaultInstance();

        return mRealm.where(Items.class).equalTo("id", id).findFirst();
    }

    static void clearAllItems(){
        final RealmResults<Items> items = getRealm().where(Items.class).findAll();
        getRealm().executeTransaction(new Realm.Transaction(){

            @Override
            public void execute(@NonNull Realm realm) {
                items.deleteAllFromRealm();
            }
        });
    }

    private static Realm getRealm(){
        return Realm.getDefaultInstance();
    }
}
