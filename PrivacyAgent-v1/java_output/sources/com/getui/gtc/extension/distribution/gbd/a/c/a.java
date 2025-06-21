package com.getui.gtc.extension.distribution.gbd.a.c;

/* loaded from: classes22.dex */
public final class a implements com.getui.gtc.extension.distribution.gbd.a.a {
    private static final java.lang.String a = "GBD_RCAAction";
    private static com.getui.gtc.extension.distribution.gbd.a.c.a b;

    private static void a(java.lang.String str) {
        com.getui.gtc.extension.distribution.gbd.n.j.a(a, "RCAA saveData = true ");
        if (com.getui.gtc.extension.distribution.gbd.n.l.d(com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField.CALL_DOWNLOAD_MODEL_SET_MIME_TYPE)) {
            com.getui.gtc.extension.distribution.gbd.n.j.b(a, "instant r 143");
            com.getui.gtc.extension.distribution.gbd.f.a.a.a().a(str, com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField.CALL_DOWNLOAD_MODEL_SET_MIME_TYPE);
        } else {
            com.getui.gtc.extension.distribution.gbd.n.j.b(a, "not instant r 143");
            com.getui.gtc.extension.distribution.gbd.f.a.a.a().b(str, com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField.CALL_DOWNLOAD_MODEL_SET_MIME_TYPE);
        }
        com.getui.gtc.extension.distribution.gbd.n.j.a(a, "RCAA data: type = 143 content = ".concat(java.lang.String.valueOf(str)));
    }

    public static synchronized com.getui.gtc.extension.distribution.gbd.a.c.a f() {
        com.getui.gtc.extension.distribution.gbd.a.c.a aVar;
        synchronized (com.getui.gtc.extension.distribution.gbd.a.c.a.class) {
            if (b == null) {
                b = new com.getui.gtc.extension.distribution.gbd.a.c.a();
            }
            aVar = b;
        }
        return aVar;
    }

    private static java.lang.String g() {
        try {
            if (android.text.TextUtils.isEmpty(com.getui.gtc.extension.distribution.gbd.d.c.e)) {
                return null;
            }
            java.lang.StringBuilder sb = new java.lang.StringBuilder();
            sb.append(new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss", java.util.Locale.getDefault()).format(new java.util.Date(com.getui.gtc.extension.distribution.gbd.n.l.C())));
            sb.append("|");
            sb.append(com.getui.gtc.extension.distribution.gbd.d.c.e);
            sb.append("|");
            java.lang.String str = com.getui.gtc.extension.distribution.gbd.d.c.a;
            if (str != null) {
                sb.append(str);
            }
            sb.append("|");
            sb.append(com.sensorsdata.sf.ui.view.UIProperty.action_android);
            sb.append("|");
            sb.append("getui");
            sb.append("|");
            java.lang.String str2 = com.getui.gtc.extension.distribution.gbd.d.c.g;
            if (str2 != null) {
                sb.append(str2);
            }
            sb.append("|");
            java.lang.String a2 = com.getui.gtc.extension.distribution.gbd.n.l.a(true);
            if (!android.text.TextUtils.isEmpty(a2)) {
                sb.append(a2);
            }
            sb.append("|");
            sb.append("|");
            sb.append("|");
            if (com.getui.gtc.extension.distribution.gbd.d.h.ak >= 10000) {
                java.lang.StringBuilder sb2 = new java.lang.StringBuilder();
                sb2.append(com.getui.gtc.extension.distribution.gbd.d.h.ai);
                sb2.append((com.getui.gtc.extension.distribution.gbd.d.h.aj / 1000) + com.xiaomi.mipush.sdk.Constants.COLON_SEPARATOR + (com.getui.gtc.extension.distribution.gbd.d.h.ak / 1000));
                com.getui.gtc.extension.distribution.gbd.d.h.ai = sb2.toString();
                java.lang.StringBuilder sb3 = new java.lang.StringBuilder("CAD update =  ");
                sb3.append(com.getui.gtc.extension.distribution.gbd.d.h.ai);
                com.getui.gtc.extension.distribution.gbd.n.j.b(a, sb3.toString());
            }
            java.lang.String str3 = com.getui.gtc.extension.distribution.gbd.d.h.ai;
            com.getui.gtc.extension.distribution.gbd.d.h.ai = "";
            com.getui.gtc.extension.distribution.gbd.f.a.b.a();
            com.getui.gtc.extension.distribution.gbd.f.a.b.e(com.getui.gtc.extension.distribution.gbd.d.h.ai);
            sb.append(str3);
            if (android.text.TextUtils.isEmpty(str3)) {
                return null;
            }
            if (sb.toString().endsWith(",")) {
                sb.deleteCharAt(sb.length() - 1);
            }
            return sb.toString();
        } catch (java.lang.Throwable unused) {
            return null;
        }
    }

    private static java.lang.String h() {
        if (com.getui.gtc.extension.distribution.gbd.d.h.ak >= 10000) {
            java.lang.StringBuilder sb = new java.lang.StringBuilder();
            sb.append(com.getui.gtc.extension.distribution.gbd.d.h.ai);
            sb.append((com.getui.gtc.extension.distribution.gbd.d.h.aj / 1000) + com.xiaomi.mipush.sdk.Constants.COLON_SEPARATOR + (com.getui.gtc.extension.distribution.gbd.d.h.ak / 1000));
            com.getui.gtc.extension.distribution.gbd.d.h.ai = sb.toString();
            java.lang.StringBuilder sb2 = new java.lang.StringBuilder("CAD update =  ");
            sb2.append(com.getui.gtc.extension.distribution.gbd.d.h.ai);
            com.getui.gtc.extension.distribution.gbd.n.j.b(a, sb2.toString());
        }
        java.lang.String str = com.getui.gtc.extension.distribution.gbd.d.h.ai;
        com.getui.gtc.extension.distribution.gbd.d.h.ai = "";
        com.getui.gtc.extension.distribution.gbd.f.a.b.a();
        com.getui.gtc.extension.distribution.gbd.f.a.b.e(com.getui.gtc.extension.distribution.gbd.d.h.ai);
        return str;
    }

    @Override // com.getui.gtc.extension.distribution.gbd.a.a
    public final void a() {
        com.getui.gtc.extension.distribution.gbd.n.j.b(a, "doSample");
        java.lang.String g = g();
        if (android.text.TextUtils.isEmpty(g)) {
            return;
        }
        com.getui.gtc.extension.distribution.gbd.n.j.a(a, "RCAA saveData = true ");
        if (com.getui.gtc.extension.distribution.gbd.n.l.d(com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField.CALL_DOWNLOAD_MODEL_SET_MIME_TYPE)) {
            com.getui.gtc.extension.distribution.gbd.n.j.b(a, "instant r 143");
            com.getui.gtc.extension.distribution.gbd.f.a.a.a().a(g, com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField.CALL_DOWNLOAD_MODEL_SET_MIME_TYPE);
        } else {
            com.getui.gtc.extension.distribution.gbd.n.j.b(a, "not instant r 143");
            com.getui.gtc.extension.distribution.gbd.f.a.a.a().b(g, com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField.CALL_DOWNLOAD_MODEL_SET_MIME_TYPE);
        }
        com.getui.gtc.extension.distribution.gbd.n.j.a(a, "RCAA data: type = 143 content = ".concat(java.lang.String.valueOf(g)));
    }

    @Override // com.getui.gtc.extension.distribution.gbd.a.a
    public final void b() {
    }

    @Override // com.getui.gtc.extension.distribution.gbd.a.a
    public final int c() {
        return com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField.CALL_DOWNLOAD_MODEL_SET_MIME_TYPE;
    }

    @Override // com.getui.gtc.extension.distribution.gbd.a.a
    public final java.lang.String d() {
        return null;
    }

    @Override // com.getui.gtc.extension.distribution.gbd.a.a
    public final java.lang.String e() {
        return null;
    }
}
