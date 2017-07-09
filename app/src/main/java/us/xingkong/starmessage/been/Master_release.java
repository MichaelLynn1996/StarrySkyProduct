/**
  * Copyright 2017 bejson.com 
  */
package us.xingkong.starmessage.been;

import io.realm.RealmObject;

/**
 * Auto-generated: 2017-07-08 20:16:22
 *
 * @author bejson.com (i@bejson.com)
 * @website http://www.bejson.com/java2pojo/
 */
public class Master_release extends RealmObject {

    private String version;
    private String build;
    private String release_type;
    private String distribution_name;
    private String supported_platform;
    private int created_at;
    public void setVersion(String version) {
         this.version = version;
     }
     public String getVersion() {
         return version;
     }

    public void setBuild(String build) {
         this.build = build;
     }
     public String getBuild() {
         return build;
     }

    public void setRelease_type(String release_type) {
         this.release_type = release_type;
     }
     public String getRelease_type() {
         return release_type;
     }

    public void setDistribution_name(String distribution_name) {
         this.distribution_name = distribution_name;
     }
     public String getDistribution_name() {
         return distribution_name;
     }

    public void setSupported_platform(String supported_platform) {
         this.supported_platform = supported_platform;
     }
     public String getSupported_platform() {
         return supported_platform;
     }

    public void setCreated_at(int created_at) {
         this.created_at = created_at;
     }
     public int getCreated_at() {
         return created_at;
     }

}