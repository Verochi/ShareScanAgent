package com.sensorsdata.analytics.android.sdk.listener;

/* loaded from: classes19.dex */
public interface SAEventListener {
    void identify();

    void login();

    void logout();

    void resetAnonymousId();

    void trackEvent(org.json.JSONObject jSONObject);
}
