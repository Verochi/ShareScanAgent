package com.vivo.push.cache;

/* loaded from: classes19.dex */
public final class a extends com.vivo.push.cache.c<com.vivo.push.model.a> {
    public a(android.content.Context context) {
        super(context);
    }

    public static boolean a(int i) {
        return i != -1 ? (i & 1) != 0 : com.vivo.push.util.z.b("persist.sys.log.ctrl", "no").equals("yes");
    }

    @Override // com.vivo.push.cache.c
    public final java.lang.String a() {
        return "com.vivo.pushservice.back_up";
    }

    @Override // com.vivo.push.cache.c
    public final java.util.List<com.vivo.push.model.a> a(java.lang.String str) {
        if (android.text.TextUtils.isEmpty(str)) {
            return null;
        }
        java.util.ArrayList arrayList = new java.util.ArrayList();
        if (!android.text.TextUtils.isEmpty(str)) {
            for (java.lang.String str2 : str.trim().split("@#")) {
                java.lang.String trim = str2.trim();
                java.lang.String[] split = trim.trim().split(",");
                if (split.length >= 2) {
                    try {
                        java.lang.String str3 = split[0];
                        arrayList.add(new com.vivo.push.model.a(str3, trim.substring(str3.length() + 1)));
                    } catch (java.lang.Exception e) {
                        com.vivo.push.util.p.d("AppConfigSettings", "str2Clients E: ".concat(java.lang.String.valueOf(e)));
                    }
                }
            }
        }
        return arrayList;
    }

    public final int b() {
        com.vivo.push.model.a c = c("push_mode");
        if (c != null && !android.text.TextUtils.isEmpty(c.b())) {
            try {
                return java.lang.Integer.parseInt(c.b());
            } catch (java.lang.Exception unused) {
            }
        }
        return -1;
    }

    @Override // com.vivo.push.cache.c
    public final java.lang.String b(java.lang.String str) {
        return new java.lang.String(com.vivo.push.util.f.a(com.vivo.push.util.f.a(e()), com.vivo.push.util.f.a(f()), android.util.Base64.decode(str, 2)), "utf-8");
    }

    public final com.vivo.push.model.a c(java.lang.String str) {
        synchronized (com.vivo.push.cache.c.a) {
            for (T t : this.b) {
                if (!android.text.TextUtils.isEmpty(t.a()) && t.a().equals(str)) {
                    return t;
                }
            }
            return null;
        }
    }
}
