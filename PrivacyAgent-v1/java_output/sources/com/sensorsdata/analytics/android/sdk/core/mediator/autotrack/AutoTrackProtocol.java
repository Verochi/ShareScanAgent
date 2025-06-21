package com.sensorsdata.analytics.android.sdk.core.mediator.autotrack;

/* loaded from: classes19.dex */
public interface AutoTrackProtocol extends com.sensorsdata.analytics.android.sdk.core.mediator.autotrack.IFragmentAPI {
    void clearLastScreenUrl();

    void clearReferrerWhenAppEnd();

    void disableAutoTrack(com.sensorsdata.analytics.android.sdk.SensorsDataAPI.AutoTrackEventType autoTrackEventType);

    void disableAutoTrack(java.util.List<com.sensorsdata.analytics.android.sdk.SensorsDataAPI.AutoTrackEventType> list);

    void enableAutoTrack(java.util.List<com.sensorsdata.analytics.android.sdk.SensorsDataAPI.AutoTrackEventType> list);

    java.util.List<java.lang.Class<?>> getIgnoredViewTypeList();

    org.json.JSONObject getLastScreenTrackProperties();

    java.lang.String getLastScreenUrl();

    void ignoreAutoTrackActivities(java.util.List<java.lang.Class<?>> list);

    void ignoreAutoTrackActivity(java.lang.Class<?> cls);

    void ignoreView(android.view.View view);

    void ignoreView(android.view.View view, boolean z);

    void ignoreViewType(java.lang.Class<?> cls);

    boolean isActivityAutoTrackAppClickIgnored(java.lang.Class<?> cls);

    boolean isActivityAutoTrackAppViewScreenIgnored(java.lang.Class<?> cls);

    boolean isAutoTrackEnabled();

    boolean isAutoTrackEventTypeIgnored(int i);

    boolean isAutoTrackEventTypeIgnored(com.sensorsdata.analytics.android.sdk.SensorsDataAPI.AutoTrackEventType autoTrackEventType);

    void resumeAutoTrackActivities(java.util.List<java.lang.Class<?>> list);

    void resumeAutoTrackActivity(java.lang.Class<?> cls);

    void setViewActivity(android.view.View view, android.app.Activity activity);

    void setViewFragmentName(android.view.View view, java.lang.String str);

    void setViewID(android.app.Dialog dialog, java.lang.String str);

    void setViewID(android.view.View view, java.lang.String str);

    void setViewID(java.lang.Object obj, java.lang.String str);

    void setViewProperties(android.view.View view, org.json.JSONObject jSONObject);

    void trackViewAppClick(android.view.View view);

    void trackViewAppClick(android.view.View view, org.json.JSONObject jSONObject);

    void trackViewScreen(android.app.Activity activity);

    void trackViewScreen(java.lang.Object obj);

    void trackViewScreen(java.lang.String str, org.json.JSONObject jSONObject);
}
