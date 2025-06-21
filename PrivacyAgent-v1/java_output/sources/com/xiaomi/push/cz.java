package com.xiaomi.push;

/* loaded from: classes19.dex */
public final class cz {
    public static void a(android.content.Context context, java.lang.String str, int i, java.lang.String str2) {
        com.xiaomi.push.m.a(context).a(new com.xiaomi.push.db(context, str, i, str2), 0);
    }

    public static void a(android.content.Context context, java.util.HashMap<java.lang.String, java.lang.String> hashMap) {
        com.xiaomi.push.di diVar = com.xiaomi.push.de.a(context).e;
        if (diVar != null) {
            diVar.a(context, hashMap);
        }
    }

    public static void b(android.content.Context context, java.util.HashMap<java.lang.String, java.lang.String> hashMap) {
        com.xiaomi.push.di diVar = com.xiaomi.push.de.a(context).e;
        if (diVar != null) {
            diVar.b(context, hashMap);
        }
    }
}
