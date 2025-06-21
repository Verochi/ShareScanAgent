package com.bytedance.pangle.apm;

@androidx.annotation.Keep
/* loaded from: classes12.dex */
public abstract class AbsApm {
    public abstract java.lang.String getDid();

    public abstract void init();

    public abstract void monitorEvent(java.lang.String str, org.json.JSONObject jSONObject, org.json.JSONObject jSONObject2, org.json.JSONObject jSONObject3);

    public abstract void reportError(java.lang.String str, @androidx.annotation.NonNull java.lang.Throwable th);
}
