package com.meizu.cloud.pushsdk.notification.c;

/* loaded from: classes23.dex */
public class d {
    private static com.meizu.cloud.pushsdk.notification.c.d a;
    private android.content.res.AssetManager b;

    private d(android.content.Context context) {
        b(context);
    }

    public static com.meizu.cloud.pushsdk.notification.c.d a(android.content.Context context) {
        if (a == null) {
            a = new com.meizu.cloud.pushsdk.notification.c.d(context);
        }
        return a;
    }

    private void b(android.content.Context context) {
        this.b = context.getAssets();
    }

    public int a(android.content.Context context, java.lang.String str, java.lang.String str2) {
        com.meizu.cloud.pushinternal.DebugLogger.i("ResourceReader", "Get resource type " + str2 + " " + str);
        return context.getResources().getIdentifier(str, str2, context.getApplicationInfo().packageName);
    }
}
