package com.getui.gtc.extension.distribution.gbd.a.a;

/* loaded from: classes22.dex */
public final class e implements com.getui.gtc.extension.distribution.gbd.a.a {
    public static com.getui.gtc.extension.distribution.gbd.a.a.e a = null;
    private static final java.lang.String b = "GBD_RPRA";
    private static final java.lang.String c = "none";
    private static final java.lang.String d = "install";
    private static final java.lang.String e = "uninstall";

    /* renamed from: com.getui.gtc.extension.distribution.gbd.a.a.e$1, reason: invalid class name */
    public class AnonymousClass1 implements com.getui.gtc.extension.distribution.gbd.f.j<java.lang.String, android.content.pm.PackageInfo> {
        public AnonymousClass1() {
        }

        /* renamed from: a, reason: avoid collision after fix types in other method */
        private static android.content.pm.PackageInfo a2(java.lang.String str) {
            return com.getui.gtc.extension.distribution.gbd.n.l.a(str, 0);
        }

        @Override // com.getui.gtc.extension.distribution.gbd.f.j
        public final /* bridge */ /* synthetic */ android.content.pm.PackageInfo a(java.lang.String str) {
            return com.getui.gtc.extension.distribution.gbd.n.l.a(str, 0);
        }
    }

    private void a(android.content.Intent intent) {
        java.lang.String str;
        java.lang.String str2;
        java.lang.String str3;
        try {
            if (com.getui.gtc.extension.distribution.gbd.d.d.B) {
                java.lang.String action = intent.getAction();
                if ("android.intent.action.PACKAGE_ADDED".equals(action) || "android.intent.action.PACKAGE_REMOVED".equals(action)) {
                    java.lang.String dataString = intent.getDataString();
                    com.getui.gtc.extension.distribution.gbd.n.j.b(b, "doSample pn = ".concat(java.lang.String.valueOf(dataString)));
                    int indexOf = dataString.indexOf(com.xiaomi.mipush.sdk.Constants.COLON_SEPARATOR);
                    if (indexOf != -1) {
                        boolean z = true;
                        java.lang.String substring = dataString.substring(indexOf + 1);
                        if ("android.intent.action.PACKAGE_ADDED".equals(action)) {
                            str = d;
                            com.getui.gtc.extension.distribution.gbd.f.c unused = com.getui.gtc.extension.distribution.gbd.f.c.a.a;
                            android.content.pm.PackageInfo packageInfo = (android.content.pm.PackageInfo) com.getui.gtc.extension.distribution.gbd.f.c.a(true, "pi", substring, new com.getui.gtc.extension.distribution.gbd.a.a.e.AnonymousClass1());
                            str2 = packageInfo == null ? "" : packageInfo.versionName;
                            str3 = java.lang.String.valueOf(packageInfo == null ? "" : java.lang.Integer.valueOf(packageInfo.versionCode));
                            com.getui.gtc.extension.distribution.gbd.c.a aVar = new com.getui.gtc.extension.distribution.gbd.c.a();
                            aVar.b = "";
                            aVar.a = substring;
                            aVar.c = str2;
                            aVar.d = str3;
                            com.getui.gtc.extension.distribution.gbd.d.h.F.put(substring, aVar);
                        } else {
                            str = e;
                            com.getui.gtc.extension.distribution.gbd.c.a aVar2 = com.getui.gtc.extension.distribution.gbd.d.h.F.get(substring);
                            if (aVar2 != null) {
                                str2 = aVar2.c;
                                str3 = aVar2.d;
                                com.getui.gtc.extension.distribution.gbd.d.h.F.remove(substring);
                            } else {
                                str2 = "-1";
                                str3 = "-1";
                            }
                        }
                        if (com.getui.gtc.extension.distribution.gbd.d.c.e == null) {
                            return;
                        }
                        java.lang.String str4 = new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss", java.util.Locale.getDefault()).format(new java.util.Date(com.getui.gtc.extension.distribution.gbd.n.l.C())) + "|" + com.getui.gtc.extension.distribution.gbd.d.c.e + "|" + com.getui.gtc.extension.distribution.gbd.d.c.a + "||" + substring + "|" + str + "|" + str2 + "|" + com.sensorsdata.sf.ui.view.UIProperty.action_android + "|" + str3 + "|" + com.getui.gtc.extension.distribution.gbd.n.l.b("114") + "|";
                        com.getui.gtc.extension.distribution.gbd.n.j.a(b, "type = 114, content = ".concat(java.lang.String.valueOf(str4)));
                        if (!com.getui.gtc.extension.distribution.gbd.d.d.A || !com.getui.gtc.extension.distribution.gbd.n.l.d(114)) {
                            z = false;
                        }
                        if (z) {
                            com.getui.gtc.extension.distribution.gbd.n.j.b(b, "instant r 114");
                            com.getui.gtc.extension.distribution.gbd.f.a.a.a().a(str4, 114);
                        } else {
                            com.getui.gtc.extension.distribution.gbd.n.j.b(b, "not instant r 114");
                            com.getui.gtc.extension.distribution.gbd.n.j.b(b, "save type = 114, content = ".concat(java.lang.String.valueOf(str4)));
                            com.getui.gtc.extension.distribution.gbd.f.a.a.a().b(str4, 114);
                        }
                    }
                }
            }
        } catch (java.lang.Exception e2) {
            com.getui.gtc.extension.distribution.gbd.n.j.a(e2);
        }
    }

    private static com.getui.gtc.extension.distribution.gbd.a.a.e f() {
        if (a == null) {
            a = new com.getui.gtc.extension.distribution.gbd.a.a.e();
        }
        return a;
    }

    @Override // com.getui.gtc.extension.distribution.gbd.a.a
    public final void a() {
    }

    @Override // com.getui.gtc.extension.distribution.gbd.a.a
    public final void b() {
    }

    @Override // com.getui.gtc.extension.distribution.gbd.a.a
    public final int c() {
        return 114;
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
