package com.igexin.push.h;

/* loaded from: classes23.dex */
public final class h {
    private static final int a = 10000;
    private static final java.lang.String b = "ErrorReport";

    /* renamed from: com.igexin.push.h.h$1, reason: invalid class name */
    public static class AnonymousClass1 implements java.lang.Runnable {
        final /* synthetic */ android.content.Context a;
        final /* synthetic */ com.igexin.push.h.h.a b;

        public AnonymousClass1(android.content.Context context, com.igexin.push.h.h.a aVar) {
            this.a = context;
            this.b = aVar;
        }

        @Override // java.lang.Runnable
        public final void run() {
            boolean z = false;
            try {
                if (com.igexin.push.h.h.a()) {
                    com.igexin.push.core.d.d.a().a("s", java.lang.Long.valueOf(java.lang.System.currentTimeMillis()));
                    org.json.JSONObject jSONObject = new org.json.JSONObject();
                    jSONObject.put("action", "upload_BI");
                    jSONObject.put("BIType", com.tencent.connect.common.Constants.VIA_REPORT_TYPE_CHAT_AUDIO);
                    jSONObject.put("cid", "0");
                    jSONObject.put("BIData", new java.lang.String(com.igexin.c.a.b.g.c(com.igexin.push.h.h.a(this.a).getBytes()), "UTF-8"));
                    byte[] a = com.igexin.push.h.r.a(com.igexin.push.config.SDKUrlConfig.getBiUploadServiceUrl(), com.igexin.c.b.a.b(jSONObject.toString().getBytes()));
                    if (a != null) {
                        new java.lang.String(a);
                    }
                    z = true;
                }
            } catch (java.lang.Throwable th) {
                com.igexin.c.a.c.a.a(th);
                com.igexin.c.a.c.a.a("ErrorReport|report 25 ex = " + th.toString(), new java.lang.Object[0]);
            }
            com.igexin.push.h.h.a aVar = this.b;
            if (aVar != null) {
                aVar.a(z);
            }
        }
    }

    public interface a {
        void a(boolean z);
    }

    public static java.lang.String a(android.content.Context context) {
        java.lang.String packageName = context.getPackageName();
        java.lang.String str = null;
        try {
            android.content.pm.ApplicationInfo b2 = com.igexin.push.h.n.b(context);
            if (b2 != null && b2.metaData != null) {
                str = com.igexin.push.h.d.a(b2);
                if (android.text.TextUtils.isEmpty(str)) {
                    str = b2.metaData.getString(com.igexin.push.core.b.b);
                }
                if (android.text.TextUtils.isEmpty(str)) {
                    str = b2.metaData.getString("GETUI_APPID");
                }
            }
        } catch (java.lang.Exception e) {
            com.igexin.c.a.c.a.a(e);
        }
        java.lang.String str2 = android.os.Build.VERSION.SDK;
        java.lang.String str3 = android.os.Build.VERSION.RELEASE;
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        sb.append(new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss", java.util.Locale.getDefault()).format(new java.util.Date()));
        sb.append("|");
        sb.append(str);
        sb.append("|");
        sb.append("3.3.7.2");
        sb.append("|");
        sb.append(true);
        sb.append("|");
        sb.append(com.igexin.push.h.n.g() == null ? "" : com.igexin.push.h.n.g());
        sb.append("|");
        sb.append(com.igexin.push.h.n.e());
        sb.append("|");
        sb.append(str2);
        sb.append("|");
        sb.append(str3);
        sb.append("|");
        sb.append(com.igexin.push.h.n.a(context));
        sb.append("|");
        sb.append(com.igexin.push.h.n.k());
        sb.append("|");
        sb.append(packageName);
        if (com.igexin.push.h.g.d != null) {
            sb.append("|");
            sb.append(com.igexin.push.h.g.d);
        }
        com.igexin.c.a.c.a.a("ErrorReport|" + sb.toString(), new java.lang.Object[0]);
        return sb.toString();
    }

    private static void a(com.igexin.push.h.h.a aVar, android.content.Context context) {
        com.igexin.b.a.a().a.execute(new com.igexin.push.h.h.AnonymousClass1(context, aVar));
    }

    public static boolean a() {
        try {
            return java.lang.System.currentTimeMillis() - com.igexin.push.core.d.d.a().a("s", new long[0]) > 86400000;
        } catch (java.lang.Exception e) {
            com.igexin.c.a.c.a.a(e);
            return false;
        }
    }
}
