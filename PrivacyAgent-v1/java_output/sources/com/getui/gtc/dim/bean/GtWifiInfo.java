package com.getui.gtc.dim.bean;

/* loaded from: classes22.dex */
public class GtWifiInfo implements android.os.Parcelable {
    public static final android.os.Parcelable.Creator<com.getui.gtc.dim.bean.GtWifiInfo> CREATOR = new com.getui.gtc.dim.bean.GtWifiInfo.AnonymousClass1();
    private java.lang.String BSSID;
    private java.lang.String SSID;
    private int rssi;
    private java.lang.String toString;

    /* renamed from: com.getui.gtc.dim.bean.GtWifiInfo$1, reason: invalid class name */
    public static class AnonymousClass1 implements android.os.Parcelable.Creator<com.getui.gtc.dim.bean.GtWifiInfo> {
        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ com.getui.gtc.dim.bean.GtWifiInfo createFromParcel(android.os.Parcel parcel) {
            return new com.getui.gtc.dim.bean.GtWifiInfo(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final /* bridge */ /* synthetic */ com.getui.gtc.dim.bean.GtWifiInfo[] newArray(int i) {
            return new com.getui.gtc.dim.bean.GtWifiInfo[i];
        }
    }

    private GtWifiInfo() {
    }

    public GtWifiInfo(android.net.wifi.WifiInfo wifiInfo) {
        this.BSSID = wifiInfo.getBSSID();
        this.SSID = wifiInfo.getSSID();
        this.toString = wifiInfo.toString();
        this.rssi = wifiInfo.getRssi();
    }

    public GtWifiInfo(android.os.Parcel parcel) {
        this.BSSID = parcel.readString();
        this.SSID = parcel.readString();
        this.toString = parcel.readString();
        this.rssi = parcel.readInt();
    }

    public static com.getui.gtc.dim.bean.GtWifiInfo parseJson(java.lang.String str) {
        if (str == null) {
            return null;
        }
        try {
            org.json.JSONObject jSONObject = new org.json.JSONObject(str);
            com.getui.gtc.dim.bean.GtWifiInfo gtWifiInfo = new com.getui.gtc.dim.bean.GtWifiInfo();
            gtWifiInfo.toString = jSONObject.optString("toString");
            gtWifiInfo.BSSID = jSONObject.optString("BSSID");
            gtWifiInfo.SSID = jSONObject.optString("SSID");
            gtWifiInfo.rssi = jSONObject.optInt("rssi", 0);
            return gtWifiInfo;
        } catch (org.json.JSONException e) {
            com.getui.gtc.dim.e.b.b(e);
            return null;
        }
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public java.lang.String getBSSID() {
        return this.BSSID;
    }

    public int getRssi() {
        return this.rssi;
    }

    public java.lang.String getSSID() {
        return this.SSID;
    }

    public java.lang.String toJsonString() {
        org.json.JSONObject jSONObject = new org.json.JSONObject();
        try {
            jSONObject.put("BSSID", this.BSSID);
            jSONObject.put("SSID", this.SSID);
            jSONObject.put("toString", this.toString);
            jSONObject.put("rssi", this.rssi);
            return jSONObject.toString();
        } catch (java.lang.Throwable th) {
            com.getui.gtc.dim.e.b.b(th);
            return null;
        }
    }

    public java.lang.String toString() {
        java.lang.String str = this.toString;
        return str == null ? "" : str;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(android.os.Parcel parcel, int i) {
        parcel.writeString(this.BSSID);
        parcel.writeString(this.SSID);
        parcel.writeString(this.toString);
        parcel.writeInt(this.rssi);
    }
}
