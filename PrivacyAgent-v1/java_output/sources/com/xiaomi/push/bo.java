package com.xiaomi.push;

/* loaded from: classes19.dex */
public final class bo {
    private static java.text.SimpleDateFormat a;
    private static java.lang.String b;

    static {
        java.text.SimpleDateFormat simpleDateFormat = new java.text.SimpleDateFormat("yyyy/MM/dd");
        a = simpleDateFormat;
        b = simpleDateFormat.format(java.lang.Long.valueOf(java.lang.System.currentTimeMillis()));
    }

    public static com.xiaomi.push.go a(android.content.Context context, java.lang.String str) {
        if (android.text.TextUtils.isEmpty(str)) {
            return null;
        }
        com.xiaomi.push.go goVar = new com.xiaomi.push.go();
        goVar.g = "category_push_stat";
        goVar.a = "push_sdk_stat_channel";
        goVar.a(1L);
        goVar.b = str;
        goVar.a(true);
        goVar.b(java.lang.System.currentTimeMillis());
        goVar.k = com.xiaomi.push.aw.a(context).b;
        goVar.h = "com.xiaomi.xmsf";
        goVar.i = "";
        goVar.c = "push_stat";
        return goVar;
    }
}
