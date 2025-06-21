package com.xiaomi.push;

/* loaded from: classes19.dex */
public class dp {
    private static volatile com.xiaomi.push.dp a;
    private android.content.Context b;

    private dp(android.content.Context context) {
        this.b = context;
    }

    public static com.xiaomi.push.dp a(android.content.Context context) {
        if (a == null) {
            synchronized (com.xiaomi.push.dp.class) {
                if (a == null) {
                    a = new com.xiaomi.push.dp(context);
                }
            }
        }
        return a;
    }

    private void a(com.xiaomi.a.a.d dVar) {
        if (dVar instanceof com.xiaomi.a.a.c) {
            com.xiaomi.a.b.a.a(this.b, (com.xiaomi.a.a.c) dVar);
        } else if (dVar instanceof com.xiaomi.a.a.b) {
            com.xiaomi.a.b.a.a(this.b, (com.xiaomi.a.a.b) dVar);
        }
    }

    public final void a(java.lang.String str, int i, long j) {
        if (i < 0 || j < 0) {
            return;
        }
        com.xiaomi.a.a.c a2 = com.xiaomi.push.Cdo.a(i, j);
        a2.h = str;
        a2.i = "4_9_0";
        a(a2);
    }

    public final void a(java.lang.String str, android.content.Intent intent, int i) {
        if (intent == null) {
            return;
        }
        a(str, com.xiaomi.push.Cdo.a(intent.getIntExtra("eventMessageType", -1)), intent.getStringExtra("messageId"), i, java.lang.System.currentTimeMillis(), null);
    }

    public final void a(java.lang.String str, android.content.Intent intent, java.lang.String str2) {
        if (intent == null) {
            return;
        }
        a(str, com.xiaomi.push.Cdo.a(intent.getIntExtra("eventMessageType", -1)), intent.getStringExtra("messageId"), 5001, java.lang.System.currentTimeMillis(), str2);
    }

    public final void a(java.lang.String str, java.lang.String str2, java.lang.String str3, int i, long j, java.lang.String str4) {
        if (android.text.TextUtils.isEmpty(str2) || android.text.TextUtils.isEmpty(str3)) {
            return;
        }
        com.xiaomi.a.a.b a2 = com.xiaomi.push.Cdo.a(str2, str3, i, j, str4);
        a2.h = str;
        a2.i = "4_9_0";
        a(a2);
    }

    public final void a(java.lang.String str, java.lang.String str2, java.lang.String str3, int i, java.lang.String str4) {
        a(str, str2, str3, i, java.lang.System.currentTimeMillis(), str4);
    }

    public final void a(java.lang.String str, java.lang.String str2, java.lang.String str3, java.lang.String str4) {
        a(str, str2, str3, 5002, java.lang.System.currentTimeMillis(), str4);
    }

    public final void b(java.lang.String str, java.lang.String str2, java.lang.String str3, java.lang.String str4) {
        a(str, str2, str3, 5001, java.lang.System.currentTimeMillis(), str4);
    }

    public final void c(java.lang.String str, java.lang.String str2, java.lang.String str3, java.lang.String str4) {
        a(str, str2, str3, 4002, java.lang.System.currentTimeMillis(), str4);
    }
}
