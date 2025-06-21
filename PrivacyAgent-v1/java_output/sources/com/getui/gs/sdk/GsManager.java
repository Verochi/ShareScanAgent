package com.getui.gs.sdk;

/* loaded from: classes22.dex */
public class GsManager {

    public static class a {
        private static final com.getui.gs.sdk.GsManager a = new com.getui.gs.sdk.GsManager(null);
    }

    private GsManager() {
    }

    public /* synthetic */ GsManager(com.getui.gs.sdk.GsManager.AnonymousClass1 anonymousClass1) {
        this();
    }

    public static com.getui.gs.sdk.GsManager getInstance() {
        return com.getui.gs.sdk.GsManager.a.a;
    }

    public boolean close(android.content.Context context) {
        return com.getui.gs.a.c.d(context);
    }

    public java.lang.String getGtcId() {
        try {
            return com.getui.gs.a.c.a();
        } catch (java.lang.Throwable th) {
            com.getui.gs.h.a.c("GsManager.getGtcId failed: " + th.getMessage());
            return "";
        }
    }

    @java.lang.Deprecated
    public java.lang.String getGtcid(android.content.Context context) {
        try {
            com.getui.gtc.base.GtcProvider.setContext(context);
            return com.getui.gs.a.c.c(context);
        } catch (java.lang.Throwable th) {
            com.getui.gs.h.a.c("GsManager.getGtcid failed: " + th.getMessage());
            return "";
        }
    }

    public java.lang.String getVersion() {
        return "GSIDO-1.4.6.2";
    }

    public void init(android.content.Context context) {
        try {
            com.getui.gtc.base.GtcProvider.setContext(context);
            com.getui.gs.a.c.b(context);
        } catch (java.lang.Throwable th) {
            com.getui.gs.h.a.c("GsManager.init failed: " + th.getMessage());
        }
    }

    public void onBeginEvent(java.lang.String str) {
        onBeginEvent(str, null);
    }

    @java.lang.Deprecated
    public void onBeginEvent(java.lang.String str, org.json.JSONObject jSONObject) {
        try {
            com.getui.gs.a.c.a(str, jSONObject);
        } catch (java.lang.Throwable th) {
            com.getui.gs.h.a.c("GsManager.onBeginEvent failed: " + th.getMessage());
        }
    }

    public void onEndEvent(java.lang.String str) {
        onEndEvent(str, null);
    }

    public void onEndEvent(java.lang.String str, org.json.JSONObject jSONObject) {
        onEndEvent(str, jSONObject, null);
    }

    public void onEndEvent(java.lang.String str, org.json.JSONObject jSONObject, java.lang.String str2) {
        try {
            com.getui.gs.a.c.a(str, jSONObject, str2);
        } catch (java.lang.Throwable th) {
            com.getui.gs.h.a.c("GsManager.onEndEvent failed: " + th.getMessage());
        }
    }

    public void onEvent(java.lang.String str) {
        onEvent(str, null);
    }

    public void onEvent(java.lang.String str, org.json.JSONObject jSONObject) {
        onEvent(str, jSONObject, null);
    }

    public void onEvent(java.lang.String str, org.json.JSONObject jSONObject, java.lang.String str2) {
        try {
            com.getui.gs.a.c.b(str, jSONObject, str2);
        } catch (java.lang.Throwable th) {
            com.getui.gs.h.a.c("GsManager.onEvent failed: " + th.getMessage());
        }
    }

    public void onPopupClickEvent(org.json.JSONObject jSONObject) {
        try {
            com.getui.gs.a.c.b("$push_popup_click", jSONObject);
        } catch (java.lang.Throwable th) {
            com.getui.gs.h.a.c("GsManager.onPopupShowEvent failed: " + th.getMessage());
        }
    }

    public void onPopupShowEvent(org.json.JSONObject jSONObject) {
        try {
            com.getui.gs.a.c.b("$push_popup_show", jSONObject);
        } catch (java.lang.Throwable th) {
            com.getui.gs.h.a.c("GsManager.onPopupShowEvent failed: " + th.getMessage());
        }
    }

    public void preInit(android.content.Context context) {
        try {
            com.getui.gtc.base.GtcProvider.setContext(context);
            com.getui.gs.a.c.a(context);
        } catch (java.lang.Throwable th) {
            com.getui.gs.h.a.c("GsManager.preInit failed: " + th.getMessage());
        }
    }

    public void setGtcIdCallback(com.getui.gs.sdk.IGtcIdCallback iGtcIdCallback) {
        try {
            com.getui.gs.a.c.a(iGtcIdCallback);
        } catch (java.lang.Throwable th) {
            com.getui.gs.h.a.c("GsManager.setGtcIdCallback failed: " + th.getMessage());
        }
    }

    public void setProfile(org.json.JSONObject jSONObject) {
        setProfile(jSONObject, null);
    }

    public void setProfile(org.json.JSONObject jSONObject, java.lang.String str) {
        try {
            com.getui.gs.a.c.a(jSONObject, str);
        } catch (java.lang.Throwable th) {
            com.getui.gs.h.a.c("GsManager.setProfile failed: " + th.getMessage());
        }
    }
}
