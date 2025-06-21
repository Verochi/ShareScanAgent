package com.aliyun.liveshift.bean;

/* loaded from: classes.dex */
public class TimeLineInfo {
    private static final java.lang.String TAG = "TimeLineInfo";
    public long end;
    public long start;

    public static java.util.List<com.aliyun.liveshift.bean.TimeLineInfo> getInfoArrayFromJson(org.json.JSONArray jSONArray) {
        if (jSONArray == null) {
            return null;
        }
        java.util.ArrayList arrayList = new java.util.ArrayList();
        int length = jSONArray.length();
        for (int i = 0; i < length; i++) {
            try {
                com.aliyun.liveshift.bean.TimeLineInfo infoFromJson = getInfoFromJson(jSONArray.getJSONObject(i));
                if (infoFromJson != null) {
                    arrayList.add(infoFromJson);
                }
            } catch (org.json.JSONException unused) {
            }
        }
        return arrayList;
    }

    private static com.aliyun.liveshift.bean.TimeLineInfo getInfoFromJson(org.json.JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        com.aliyun.liveshift.bean.TimeLineInfo timeLineInfo = new com.aliyun.liveshift.bean.TimeLineInfo();
        timeLineInfo.start = com.aliyun.utils.e.b(jSONObject, com.anythink.expressad.foundation.d.c.bT);
        timeLineInfo.end = com.aliyun.utils.e.b(jSONObject, "end");
        return timeLineInfo;
    }
}
