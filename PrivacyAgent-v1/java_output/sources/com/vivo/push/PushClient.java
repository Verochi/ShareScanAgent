package com.vivo.push;

/* loaded from: classes19.dex */
public class PushClient {
    public static final java.lang.String DEFAULT_REQUEST_ID = "1";
    private static volatile com.vivo.push.PushClient sPushClient;

    private PushClient(android.content.Context context) {
        com.vivo.push.e.a().a(context);
    }

    private void checkParam(java.lang.String str) {
        if (str == null) {
            throw new java.lang.IllegalArgumentException("PushManager String param should not be ".concat(java.lang.String.valueOf(str)));
        }
    }

    public static synchronized com.vivo.push.PushClient getInstance(android.content.Context context) {
        com.vivo.push.PushClient pushClient;
        synchronized (com.vivo.push.PushClient.class) {
            if (sPushClient == null) {
                sPushClient = new com.vivo.push.PushClient(context.getApplicationContext());
            }
            pushClient = sPushClient;
        }
        return pushClient;
    }

    public void bindAlias(java.lang.String str, com.vivo.push.IPushActionListener iPushActionListener) {
        checkParam(str);
        com.vivo.push.e.a().a(str, iPushActionListener);
    }

    public void checkManifest() {
        com.vivo.push.e.a().b();
    }

    public void delTopic(java.lang.String str, com.vivo.push.IPushActionListener iPushActionListener) {
        java.util.ArrayList<java.lang.String> arrayList = new java.util.ArrayList<>(1);
        arrayList.add(str);
        com.vivo.push.e.a().b(arrayList, iPushActionListener);
    }

    public java.lang.String getAlias() {
        return com.vivo.push.e.a().j();
    }

    public java.lang.String getRegId() {
        return com.vivo.push.e.a().f();
    }

    public java.util.List<java.lang.String> getTopics() {
        return com.vivo.push.e.a().c();
    }

    public java.lang.String getVersion() {
        return "3.4.0.0";
    }

    public void initialize() {
        checkManifest();
        com.vivo.push.e.a().a(new com.vivo.push.b.f());
    }

    public boolean isSupport() {
        return com.vivo.push.e.a().d();
    }

    public void setSystemModel(boolean z) {
        com.vivo.push.e.a().a(z);
    }

    public void setTopic(java.lang.String str, com.vivo.push.IPushActionListener iPushActionListener) {
        java.util.ArrayList<java.lang.String> arrayList = new java.util.ArrayList<>(1);
        arrayList.add(str);
        com.vivo.push.e.a().a(arrayList, iPushActionListener);
    }

    public void turnOffPush(com.vivo.push.IPushActionListener iPushActionListener) {
        com.vivo.push.e.a().b(iPushActionListener);
    }

    public void turnOnPush(com.vivo.push.IPushActionListener iPushActionListener) {
        com.vivo.push.e.a().a(iPushActionListener);
    }

    public void unBindAlias(java.lang.String str, com.vivo.push.IPushActionListener iPushActionListener) {
        checkParam(str);
        com.vivo.push.e.a().b(str, iPushActionListener);
    }
}
