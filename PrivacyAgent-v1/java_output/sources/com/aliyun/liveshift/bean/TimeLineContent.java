package com.aliyun.liveshift.bean;

/* loaded from: classes.dex */
public class TimeLineContent {
    private static final java.lang.String TAG = "TimeLineContent";
    public long current;
    public java.util.List<com.aliyun.liveshift.bean.TimeLineInfo> timelines;

    public static com.aliyun.liveshift.bean.TimeLineContent getInfoFromJson(org.json.JSONObject jSONObject) {
        com.aliyun.liveshift.bean.TimeLineContent timeLineContent = new com.aliyun.liveshift.bean.TimeLineContent();
        if (jSONObject == null) {
            return timeLineContent;
        }
        timeLineContent.current = com.aliyun.utils.e.b(jSONObject, org.apache.tools.ant.taskdefs.optional.vss.MSVSSConstants.TIME_CURRENT);
        try {
            timeLineContent.timelines = com.aliyun.liveshift.bean.TimeLineInfo.getInfoArrayFromJson(jSONObject.getJSONArray("timeline"));
        } catch (org.json.JSONException unused) {
        }
        return timeLineContent;
    }
}
