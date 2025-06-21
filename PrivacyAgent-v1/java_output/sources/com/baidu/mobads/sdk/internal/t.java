package com.baidu.mobads.sdk.internal;

/* loaded from: classes.dex */
public class t implements com.baidu.mobads.sdk.api.ICommonModuleObj {
    private static volatile com.baidu.mobads.sdk.internal.t a;
    private com.baidu.mobads.sdk.api.CustomNotification b = new com.baidu.mobads.sdk.api.CustomNotification();
    private com.baidu.mobads.sdk.internal.b.a c = new com.baidu.mobads.sdk.internal.b.a();

    private t() {
    }

    public static com.baidu.mobads.sdk.internal.t a() {
        if (a == null) {
            synchronized (com.baidu.mobads.sdk.internal.t.class) {
                if (a == null) {
                    a = new com.baidu.mobads.sdk.internal.t();
                }
            }
        }
        return a;
    }

    @Override // com.baidu.mobads.sdk.api.ICommonModuleObj
    public java.lang.Object createModuleObj(java.lang.String str, org.json.JSONObject jSONObject) {
        if (!com.baidu.mobads.sdk.api.ICommonModuleObj.KEY_NOTIFICATION.equals(str)) {
            if (com.baidu.mobads.sdk.api.ICommonModuleObj.KEY_RESOURCES.equals(str)) {
                return this.c;
            }
            return null;
        }
        if (jSONObject == null) {
            return null;
        }
        android.content.Context context = (android.content.Context) jSONObject.opt("context");
        int optInt = jSONObject.optInt("version", 0);
        java.lang.String optString = jSONObject.optString(com.huawei.hms.push.constant.RemoteMessageConst.Notification.CHANNEL_ID);
        java.lang.String optString2 = jSONObject.optString(com.huawei.hms.push.constant.RemoteMessageConst.Notification.TICKER);
        android.graphics.Bitmap bitmap = (android.graphics.Bitmap) jSONObject.opt("icon");
        java.lang.String optString3 = jSONObject.optString("title");
        java.lang.String optString4 = jSONObject.optString("content");
        java.lang.String optString5 = jSONObject.optString("status");
        boolean optBoolean = jSONObject.optBoolean(com.huawei.hms.push.constant.RemoteMessageConst.Notification.AUTO_CANCEL);
        int optInt2 = jSONObject.optInt(androidx.core.app.NotificationCompat.CATEGORY_PROGRESS);
        boolean optBoolean2 = jSONObject.optBoolean("indeterminate", false);
        int optInt3 = jSONObject.optInt("smallIcon");
        java.lang.String optString6 = jSONObject.optString("action");
        android.app.PendingIntent pendingIntent = (android.app.PendingIntent) jSONObject.opt(com.google.android.gms.common.internal.BaseGmsClient.KEY_PENDING_INTENT);
        return optInt == 1 ? this.b.getNewNotification(context, optString2, optBoolean, bitmap, optString3, optString4, optInt2, optBoolean2, optString6, pendingIntent, jSONObject.optString("action2"), (android.app.PendingIntent) jSONObject.opt("pendingIntent2")) : this.b.getCustomNotification(context, optString, optString2, bitmap, optString3, optString4, optString5, optBoolean, optInt2, optInt3, optString6, pendingIntent);
    }
}
