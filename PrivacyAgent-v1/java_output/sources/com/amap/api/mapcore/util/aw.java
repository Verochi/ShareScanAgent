package com.amap.api.mapcore.util;

@com.amap.api.mapcore.util.gi(a = "update_item", b = true)
/* loaded from: classes12.dex */
public class aw extends com.amap.api.mapcore.util.az {
    private java.lang.String n = "";
    private android.content.Context o;

    public aw() {
    }

    public aw(com.amap.api.maps.offlinemap.OfflineMapCity offlineMapCity, android.content.Context context) {
        this.o = context;
        this.a = offlineMapCity.getCity();
        this.c = offlineMapCity.getAdcode();
        this.b = offlineMapCity.getUrl();
        this.g = offlineMapCity.getSize();
        this.e = offlineMapCity.getVersion();
        this.k = offlineMapCity.getCode();
        this.i = 0;
        this.l = offlineMapCity.getState();
        this.j = offlineMapCity.getcompleteCode();
        this.m = offlineMapCity.getPinyin();
        i();
    }

    public aw(com.amap.api.maps.offlinemap.OfflineMapProvince offlineMapProvince, android.content.Context context) {
        this.o = context;
        this.a = offlineMapProvince.getProvinceName();
        this.c = offlineMapProvince.getProvinceCode();
        this.b = offlineMapProvince.getUrl();
        this.g = offlineMapProvince.getSize();
        this.e = offlineMapProvince.getVersion();
        this.i = 1;
        this.l = offlineMapProvince.getState();
        this.j = offlineMapProvince.getcompleteCode();
        this.m = offlineMapProvince.getPinyin();
        i();
    }

    private static java.lang.String a(org.json.JSONObject jSONObject, java.lang.String str) throws org.json.JSONException {
        return (jSONObject == null || !jSONObject.has(str) || "[]".equals(jSONObject.getString(str))) ? "" : jSONObject.optString(str).trim();
    }

    private void i() {
        this.d = com.amap.api.mapcore.util.dl.c(this.o) + this.m + ".zip.tmp";
    }

    public final java.lang.String a() {
        return this.n;
    }

    public final void a(java.lang.String str) {
        this.n = str;
    }

    public final void b() {
        java.io.OutputStreamWriter outputStreamWriter;
        org.json.JSONObject jSONObject = new org.json.JSONObject();
        try {
            org.json.JSONObject jSONObject2 = new org.json.JSONObject();
            jSONObject2.put("title", this.a);
            jSONObject2.put("code", this.c);
            jSONObject2.put("url", this.b);
            jSONObject2.put(com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField.TT_FILE_NAME, this.d);
            jSONObject2.put("lLocalLength", this.f);
            jSONObject2.put("lRemoteLength", this.g);
            jSONObject2.put("mState", this.l);
            jSONObject2.put("version", this.e);
            jSONObject2.put("localPath", this.h);
            java.lang.String str = this.n;
            if (str != null) {
                jSONObject2.put("vMapFileNames", str);
            }
            jSONObject2.put("isSheng", this.i);
            jSONObject2.put("mCompleteCode", this.j);
            jSONObject2.put("mCityCode", this.k);
            jSONObject2.put("pinyin", this.m);
            jSONObject.put("file", jSONObject2);
            java.io.File file = new java.io.File(this.d + ".dt");
            file.delete();
            java.io.OutputStreamWriter outputStreamWriter2 = null;
            try {
                try {
                    outputStreamWriter = new java.io.OutputStreamWriter(new java.io.FileOutputStream(file, true), "utf-8");
                } catch (java.lang.Throwable th) {
                    th = th;
                }
            } catch (java.io.IOException e) {
                e = e;
            }
            try {
                outputStreamWriter.write(jSONObject.toString());
                try {
                    outputStreamWriter.close();
                } catch (java.io.IOException e2) {
                    e2.printStackTrace();
                }
            } catch (java.io.IOException e3) {
                e = e3;
                outputStreamWriter2 = outputStreamWriter;
                com.amap.api.mapcore.util.gd.c(e, "UpdateItem", "saveJSONObjectToFile");
                e.printStackTrace();
                if (outputStreamWriter2 != null) {
                    try {
                        outputStreamWriter2.close();
                    } catch (java.io.IOException e4) {
                        e4.printStackTrace();
                    }
                }
            } catch (java.lang.Throwable th2) {
                th = th2;
                outputStreamWriter2 = outputStreamWriter;
                if (outputStreamWriter2 != null) {
                    try {
                        outputStreamWriter2.close();
                    } catch (java.io.IOException e5) {
                        e5.printStackTrace();
                    }
                }
                throw th;
            }
        } catch (java.lang.Throwable th3) {
            com.amap.api.mapcore.util.gd.c(th3, "UpdateItem", "saveJSONObjectToFile parseJson");
            th3.printStackTrace();
        }
    }

    public final void b(java.lang.String str) {
        org.json.JSONObject jSONObject;
        if (str != null) {
            try {
                if ("".equals(str) || (jSONObject = new org.json.JSONObject(str).getJSONObject("file")) == null) {
                    return;
                }
                this.a = jSONObject.optString("title");
                this.c = jSONObject.optString("code");
                this.b = jSONObject.optString("url");
                this.d = jSONObject.optString(com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField.TT_FILE_NAME);
                this.f = jSONObject.optLong("lLocalLength");
                this.g = jSONObject.optLong("lRemoteLength");
                this.l = jSONObject.optInt("mState");
                this.e = jSONObject.optString("version");
                this.h = jSONObject.optString("localPath");
                this.n = jSONObject.optString("vMapFileNames");
                this.i = jSONObject.optInt("isSheng");
                this.j = jSONObject.optInt("mCompleteCode");
                this.k = jSONObject.optString("mCityCode");
                java.lang.String a = a(jSONObject, "pinyin");
                this.m = a;
                if ("".equals(a)) {
                    java.lang.String str2 = this.b;
                    java.lang.String substring = str2.substring(str2.lastIndexOf(net.lingala.zip4j.util.InternalZipConstants.ZIP_FILE_SEPARATOR) + 1);
                    this.m = substring.substring(0, substring.lastIndexOf("."));
                }
            } catch (java.lang.Throwable th) {
                com.amap.api.mapcore.util.gd.c(th, "UpdateItem", "readFileToJSONObject");
                th.printStackTrace();
            }
        }
    }
}
