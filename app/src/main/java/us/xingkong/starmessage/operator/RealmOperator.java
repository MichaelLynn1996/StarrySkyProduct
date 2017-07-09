package us.xingkong.starmessage.operator;

import java.util.List;

import io.realm.Realm;
import io.realm.RealmResults;
import us.xingkong.starmessage.been.Items;

/**
 * Created by SeaLynn0 on 2017/7/9.
 */

public class RealmOperator {
    static Realm realm=Realm.getDefaultInstance();

    public static void addItem(Items item){
        // Copy the object to Realm. Any further changes must happen on realmUser
        realm.beginTransaction();
        realm.copyToRealm(item);
        realm.commitTransaction();
    }

    public static List<Items> queryAllItems() {

        RealmResults<Items> items = realm.where(Items.class).findAll();

        return realm.copyFromRealm(items);
    }

    public static Items queryItemById(String id) {
        Realm  mRealm=Realm.getDefaultInstance();

        Items item = mRealm.where(Items.class).equalTo("id", id).findFirst();
        return item;
    }

    static void clearAllItems(){
        final RealmResults<Items> items = realm.where(Items.class).findAll();
        realm.executeTransaction(new Realm.Transaction(){

            @Override
            public void execute(Realm realm) {
                items.deleteAllFromRealm();
            }
        });
    }
}
