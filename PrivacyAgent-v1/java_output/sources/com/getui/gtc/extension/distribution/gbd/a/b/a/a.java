package com.getui.gtc.extension.distribution.gbd.a.b.a;

/* loaded from: classes22.dex */
public final class a {
    private static final java.lang.String a = "B_D_M";
    private android.content.SharedPreferences b;

    /* renamed from: com.getui.gtc.extension.distribution.gbd.a.b.a.a$a, reason: collision with other inner class name */
    public static class C0307a {
        private static final com.getui.gtc.extension.distribution.gbd.a.b.a.a a = new com.getui.gtc.extension.distribution.gbd.a.b.a.a(com.getui.gtc.extension.distribution.gbd.d.c.d, (byte) 0);

        private C0307a() {
        }
    }

    private a(android.content.Context context) {
        this.b = null;
        if (context != null) {
            try {
                if (com.getui.gtc.extension.distribution.gbd.d.h.at.size() >= 2) {
                    this.b = context.getSharedPreferences(com.getui.gtc.extension.distribution.gbd.d.h.at.get(0).replace(".xml", ""), 0);
                }
            } catch (java.lang.Throwable th) {
                com.getui.gtc.extension.distribution.gbd.n.j.a(th);
            }
        }
    }

    public /* synthetic */ a(android.content.Context context, byte b) {
        this(context);
    }

    private static java.util.List<java.lang.String> a(java.lang.String str) {
        return (str == null || "".equals(str)) ? new java.util.ArrayList() : new java.util.ArrayList(java.util.Arrays.asList(new java.lang.String(android.util.Base64.decode(str.getBytes(), 0)).split("\\|")));
    }

    private static com.getui.gtc.extension.distribution.gbd.a.b.a.a b() {
        return com.getui.gtc.extension.distribution.gbd.a.b.a.a.C0307a.a;
    }

    public final java.util.List<com.getui.gtc.extension.distribution.gbd.c.k> a() {
        java.util.ArrayList arrayList = new java.util.ArrayList();
        android.content.SharedPreferences sharedPreferences = this.b;
        if (sharedPreferences == null) {
            com.getui.gtc.extension.distribution.gbd.n.j.b(a, "s null.");
            return arrayList;
        }
        try {
            java.lang.String string = sharedPreferences.getString("wf_pre", "");
            java.lang.String string2 = this.b.getString("ll_pre", "");
            java.util.Iterator<java.lang.String> it = a(string).iterator();
            while (it.hasNext()) {
                java.lang.String[] split = it.next().split(",");
                if (split.length >= 3) {
                    arrayList.add(new com.getui.gtc.extension.distribution.gbd.c.k(java.util.Arrays.asList(split), 1));
                }
            }
            java.util.Iterator<java.lang.String> it2 = a(string2).iterator();
            while (it2.hasNext()) {
                java.lang.String[] split2 = it2.next().split(",");
                if (split2.length >= 7) {
                    java.util.ArrayList arrayList2 = new java.util.ArrayList();
                    arrayList2.add(split2[5]);
                    arrayList2.add(split2[6]);
                    arrayList2.add(split2[3]);
                    arrayList.add(new com.getui.gtc.extension.distribution.gbd.c.k(arrayList2, 1));
                }
            }
        } catch (java.lang.Throwable th) {
            com.getui.gtc.extension.distribution.gbd.n.j.a(th);
        }
        return arrayList;
    }
}
