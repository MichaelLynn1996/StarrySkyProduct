/**
  * Copyright 2017 bejson.com 
  */
package us.xingkong.starmessage.been;

import com.google.gson.annotations.SerializedName;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

/**
 * Auto-generated: 2017-07-08 20:16:22
 *
 * @author bejson.com (i@bejson.com)
 * @website http://www.bejson.com/java2pojo/
 */
public class Items extends RealmObject {

    @PrimaryKey
    private String id;

    private String user_id;
    private String org_id;
    private String type;
    private String name;

    @SerializedName("short")
    private String _short;

    private String bundle_id;
    private int genre_id;
    private boolean is_opened;
    private String web_template;
    private String custom_market_url;
    private boolean has_combo;
    private int created_at;
    private int updated_at;
    private int expired_at;
    private String icon_url;
    private Master_release master_release;
    public void setId(String id) {
         this.id = id;
     }
     public String getId() {
         return id;
     }

    public void setUser_id(String user_id) {
         this.user_id = user_id;
     }
     public String getUser_id() {
         return user_id;
     }

    public void setOrg_id(String org_id) {
         this.org_id = org_id;
     }
     public String getOrg_id() {
         return org_id;
     }

    public void setType(String type) {
         this.type = type;
     }
     public String getType() {
         return type;
     }

    public void setName(String name) {
         this.name = name;
     }
     public String getName() {
         return name;
     }

    public void setShort(String _short) {
         this._short = _short;
     }
     public String getShort() {
         return _short;
     }

    public void setBundle_id(String bundle_id) {
         this.bundle_id = bundle_id;
     }
     public String getBundle_id() {
         return bundle_id;
     }

    public void setGenre_id(int genre_id) {
         this.genre_id = genre_id;
     }
     public int getGenre_id() {
         return genre_id;
     }

    public void setIs_opened(boolean is_opened) {
         this.is_opened = is_opened;
     }
     public boolean getIs_opened() {
         return is_opened;
     }

    public void setWeb_template(String web_template) {
         this.web_template = web_template;
     }
     public String getWeb_template() {
         return web_template;
     }

    public void setCustom_market_url(String custom_market_url) {
         this.custom_market_url = custom_market_url;
     }
     public String getCustom_market_url() {
         return custom_market_url;
     }

    public void setHas_combo(boolean has_combo) {
         this.has_combo = has_combo;
     }
     public boolean getHas_combo() {
         return has_combo;
     }

    public void setCreated_at(int created_at) {
         this.created_at = created_at;
     }
     public int getCreated_at() {
         return created_at;
     }

    public void setUpdated_at(int updated_at) {
         this.updated_at = updated_at;
     }
     public int getUpdated_at() {
         return updated_at;
     }

    public void setExpired_at(int expired_at) {
         this.expired_at = expired_at;
     }
     public int getExpired_at() {
         return expired_at;
     }

    public void setIcon_url(String icon_url) {
         this.icon_url = icon_url;
     }
     public String getIcon_url() {
         return icon_url;
     }

    public void setMaster_release(Master_release master_release) {
         this.master_release = master_release;
     }
     public Master_release getMaster_release() {
         return master_release;
     }

}