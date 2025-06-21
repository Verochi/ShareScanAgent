package com.sijla.f;

/* loaded from: classes19.dex */
public class f {
    private static com.sijla.f.f a = new com.sijla.f.f();
    private static long b = 0;

    public static com.sijla.f.f a() {
        if (a == null) {
            synchronized (com.sijla.f.f.class) {
                if (a == null) {
                    a = new com.sijla.f.f();
                }
            }
        }
        return a;
    }

    public static java.util.List<java.lang.String> b() {
        java.util.ArrayList arrayList = new java.util.ArrayList();
        arrayList.add("06");
        arrayList.add(com.tencent.connect.common.Constants.VIA_REPORT_TYPE_DATALINE);
        arrayList.add(com.tencent.connect.common.Constants.VIA_REPORT_TYPE_SHARE_TO_TROOPBAR);
        arrayList.add(com.tencent.connect.common.Constants.VIA_REPORT_TYPE_CHAT_AUDIO);
        arrayList.add("27");
        arrayList.add("29");
        arrayList.add("30");
        arrayList.add("13");
        return arrayList;
    }

    public final void a(android.content.Context context) {
        if (b == 0 || java.lang.System.currentTimeMillis() - b > 3000) {
            b = java.lang.System.currentTimeMillis();
            com.sijla.a.a.a(new com.sijla.f.g(this, context));
        }
    }
}
