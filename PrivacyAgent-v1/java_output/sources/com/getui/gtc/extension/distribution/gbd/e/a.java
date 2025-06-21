package com.getui.gtc.extension.distribution.gbd.e;

import com.getui.gtc.extension.distribution.gbd.a.a.e.AnonymousClass1;

/* loaded from: classes22.dex */
public final class a extends android.os.Handler {
    private static final java.lang.String a = "GBD_Handler";

    /* renamed from: com.getui.gtc.extension.distribution.gbd.e.a$1, reason: invalid class name */
    public class AnonymousClass1 implements java.lang.Runnable {
        public AnonymousClass1() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            try {
                com.getui.gtc.extension.distribution.gbd.a.b.d.a.a.a();
            } catch (java.lang.Throwable th) {
                com.getui.gtc.extension.distribution.gbd.n.j.a(th);
            }
        }
    }

    @Override // android.os.Handler
    public final void handleMessage(android.os.Message message) {
        java.lang.String str;
        java.lang.String str2;
        java.lang.String str3;
        try {
        } catch (java.lang.Throwable th) {
            com.getui.gtc.extension.distribution.gbd.n.j.a(th);
            com.getui.gtc.extension.distribution.gbd.n.j.b(a, th.toString());
        }
        if (com.getui.gtc.extension.distribution.gbd.n.l.c(com.getui.gtc.extension.distribution.gbd.n.l.b(message.what))) {
            return;
        }
        int i = message.what;
        boolean z = true;
        if (i == 1) {
            int i2 = message.arg1;
            if (i2 == 11) {
                com.getui.gtc.extension.distribution.gbd.a.b.c.f().a(11);
                return;
            }
            if (i2 != 12) {
                return;
            }
            if (!com.getui.gtc.extension.distribution.gbd.d.d.ah) {
                com.getui.gtc.extension.distribution.gbd.n.j.b(a, "11 static disable.");
                return;
            } else {
                com.getui.gtc.extension.distribution.gbd.n.j.b(a, "11 static enable.");
                com.getui.gtc.extension.distribution.gbd.a.b.c.f().a(12);
                return;
            }
        }
        if (i == 2) {
            if (message.arg1 != 21) {
                return;
            }
            com.getui.gtc.extension.distribution.gbd.f.a.a a2 = com.getui.gtc.extension.distribution.gbd.f.a.a.a();
            com.getui.gtc.extension.distribution.gbd.n.j.b("GBD_RALDataManager", "init doReport isReporting = " + a2.h);
            a2.c();
            if (!com.getui.gtc.extension.distribution.gbd.n.l.i(com.getui.gtc.extension.distribution.gbd.d.c.d)) {
                com.getui.gtc.extension.distribution.gbd.n.j.b("GBD_RALDataManager", "ral r no network.");
                return;
            } else {
                if (a2.h) {
                    return;
                }
                a2.h = true;
                a2.a(106);
                return;
            }
        }
        if (i == 3) {
            java.lang.Object obj = message.obj;
            if (obj != null) {
                android.content.Intent intent = (android.content.Intent) obj;
                if (com.getui.gtc.extension.distribution.gbd.a.a.e.a == null) {
                    com.getui.gtc.extension.distribution.gbd.a.a.e.a = new com.getui.gtc.extension.distribution.gbd.a.a.e();
                }
                com.getui.gtc.extension.distribution.gbd.a.a.e eVar = com.getui.gtc.extension.distribution.gbd.a.a.e.a;
                try {
                    if (com.getui.gtc.extension.distribution.gbd.d.d.B) {
                        java.lang.String action = intent.getAction();
                        if ("android.intent.action.PACKAGE_ADDED".equals(action) || "android.intent.action.PACKAGE_REMOVED".equals(action)) {
                            java.lang.String dataString = intent.getDataString();
                            com.getui.gtc.extension.distribution.gbd.n.j.b("GBD_RPRA", "doSample pn = ".concat(java.lang.String.valueOf(dataString)));
                            int indexOf = dataString.indexOf(com.xiaomi.mipush.sdk.Constants.COLON_SEPARATOR);
                            if (indexOf != -1) {
                                java.lang.String substring = dataString.substring(indexOf + 1);
                                if ("android.intent.action.PACKAGE_ADDED".equals(action)) {
                                    str = "install";
                                    com.getui.gtc.extension.distribution.gbd.f.c unused = com.getui.gtc.extension.distribution.gbd.f.c.a.a;
                                    android.content.pm.PackageInfo packageInfo = (android.content.pm.PackageInfo) com.getui.gtc.extension.distribution.gbd.f.c.a(true, "pi", substring, eVar.new AnonymousClass1());
                                    str2 = packageInfo == null ? "" : packageInfo.versionName;
                                    str3 = java.lang.String.valueOf(packageInfo == null ? "" : java.lang.Integer.valueOf(packageInfo.versionCode));
                                    com.getui.gtc.extension.distribution.gbd.c.a aVar = new com.getui.gtc.extension.distribution.gbd.c.a();
                                    aVar.b = "";
                                    aVar.a = substring;
                                    aVar.c = str2;
                                    aVar.d = str3;
                                    com.getui.gtc.extension.distribution.gbd.d.h.F.put(substring, aVar);
                                } else {
                                    str = "uninstall";
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
                                com.getui.gtc.extension.distribution.gbd.n.j.a("GBD_RPRA", "type = 114, content = ".concat(java.lang.String.valueOf(str4)));
                                if (!com.getui.gtc.extension.distribution.gbd.d.d.A || !com.getui.gtc.extension.distribution.gbd.n.l.d(114)) {
                                    z = false;
                                }
                                if (z) {
                                    com.getui.gtc.extension.distribution.gbd.n.j.b("GBD_RPRA", "instant r 114");
                                    com.getui.gtc.extension.distribution.gbd.f.a.a.a().a(str4, 114);
                                    return;
                                } else {
                                    com.getui.gtc.extension.distribution.gbd.n.j.b("GBD_RPRA", "not instant r 114");
                                    com.getui.gtc.extension.distribution.gbd.n.j.b("GBD_RPRA", "save type = 114, content = ".concat(java.lang.String.valueOf(str4)));
                                    com.getui.gtc.extension.distribution.gbd.f.a.a.a().b(str4, 114);
                                    return;
                                }
                            }
                            return;
                        }
                        return;
                    }
                    return;
                } catch (java.lang.Exception e) {
                    com.getui.gtc.extension.distribution.gbd.n.j.a(e);
                    return;
                }
            }
            return;
        }
        if (i == 4) {
            if (message.arg1 == 41 && com.getui.gtc.extension.distribution.gbd.d.d.bv) {
                com.getui.gtc.extension.distribution.gbd.a.a.d.f().a();
                return;
            }
            return;
        }
        if (i == 5) {
            int i3 = message.arg1;
            if (i3 == 51) {
                if (com.getui.gtc.extension.distribution.gbd.d.d.bv && com.getui.gtc.extension.distribution.gbd.n.l.a(124)) {
                    com.getui.gtc.extension.distribution.gbd.a.a.d f = com.getui.gtc.extension.distribution.gbd.a.a.d.f();
                    try {
                        com.getui.gtc.extension.distribution.gbd.n.j.b("GBD_124", "unlock.");
                        if (com.getui.gtc.extension.distribution.gbd.n.l.c(124)) {
                            com.getui.gtc.extension.distribution.gbd.n.j.b("GBD_124", "type 124 in type black list, return.");
                            return;
                        }
                        long currentTimeMillis = java.lang.System.currentTimeMillis();
                        f.a = currentTimeMillis;
                        if (currentTimeMillis - f.b >= com.getui.gtc.extension.distribution.gbd.d.d.cj * 1000) {
                            java.lang.String a3 = f.a(1, 0);
                            if (android.text.TextUtils.isEmpty(a3)) {
                                return;
                            }
                            com.getui.gtc.extension.distribution.gbd.a.a.d.a(a3);
                            return;
                        }
                        return;
                    } catch (java.lang.Throwable th2) {
                        com.getui.gtc.extension.distribution.gbd.n.j.a(th2);
                        return;
                    }
                }
                return;
            }
            if (i3 == 52 && com.getui.gtc.extension.distribution.gbd.d.d.bv && com.getui.gtc.extension.distribution.gbd.n.l.a(124)) {
                com.getui.gtc.extension.distribution.gbd.a.a.d f2 = com.getui.gtc.extension.distribution.gbd.a.a.d.f();
                try {
                    com.getui.gtc.extension.distribution.gbd.n.j.b("GBD_124", "lock.");
                    if (com.getui.gtc.extension.distribution.gbd.n.l.c(124)) {
                        com.getui.gtc.extension.distribution.gbd.n.j.b("GBD_124", "type 124 in type black list, return.");
                        return;
                    }
                    long currentTimeMillis2 = java.lang.System.currentTimeMillis();
                    f2.b = currentTimeMillis2;
                    if (currentTimeMillis2 - f2.a >= com.getui.gtc.extension.distribution.gbd.d.d.cj * 1000) {
                        java.lang.String a4 = f2.a(2, 0);
                        if (android.text.TextUtils.isEmpty(a4)) {
                            return;
                        }
                        com.getui.gtc.extension.distribution.gbd.a.a.d.a(a4);
                        return;
                    }
                    return;
                } catch (java.lang.Throwable th3) {
                    com.getui.gtc.extension.distribution.gbd.n.j.a(th3);
                    return;
                }
            }
            return;
        }
        if (i == 7) {
            com.getui.gtc.extension.distribution.gbd.a.b.f.f().a(1);
            return;
        }
        if (i == 10) {
            if (com.getui.gtc.extension.distribution.gbd.d.d.bG) {
                com.getui.gtc.extension.distribution.gbd.a.a.a.f().a();
                return;
            }
            return;
        }
        if (i == 13) {
            com.getui.gtc.extension.distribution.gbd.a.d.b.f().a();
            return;
        }
        if (i == 17) {
            com.getui.gtc.extension.distribution.gbd.a.c.a.f().a();
            return;
        }
        if (i == 151) {
            com.getui.gtc.extension.distribution.gbd.a.b.e.a.a.a();
            return;
        }
        if (i == 117) {
            com.getui.gtc.extension.distribution.gbd.l.a.C0311a.a.a(new com.getui.gtc.extension.distribution.gbd.e.a.AnonymousClass1());
            return;
        }
        if (i == 118) {
            com.getui.gtc.extension.distribution.gbd.n.l.a(com.getui.gtc.extension.distribution.gbd.d.c.d, false);
            return;
        }
        if (i == 254) {
            com.getui.gtc.extension.distribution.gbd.a.a.b.f().a();
            return;
        }
        if (i == 255) {
            com.getui.gtc.extension.distribution.gbd.a.a.c.f().a();
            return;
        }
        switch (i) {
            case 201:
                if (com.getui.gtc.extension.distribution.gbd.d.d.x && com.getui.gtc.extension.distribution.gbd.d.d.af && com.getui.gtc.extension.distribution.gbd.d.h.d.getAndSet(false)) {
                    com.getui.gtc.extension.distribution.gbd.n.b.g();
                    break;
                }
                break;
            case 202:
                if (com.getui.gtc.extension.distribution.gbd.d.d.x && com.getui.gtc.extension.distribution.gbd.d.d.cN && com.getui.gtc.extension.distribution.gbd.d.h.f.getAndSet(false)) {
                    com.getui.gtc.extension.distribution.gbd.n.b.i();
                    break;
                }
                break;
            case 203:
                if (com.getui.gtc.extension.distribution.gbd.d.d.x && com.getui.gtc.extension.distribution.gbd.d.d.cV && com.getui.gtc.extension.distribution.gbd.d.h.e.getAndSet(false)) {
                    com.getui.gtc.extension.distribution.gbd.n.b.e();
                    break;
                }
                break;
        }
        return;
        com.getui.gtc.extension.distribution.gbd.n.j.a(th);
        com.getui.gtc.extension.distribution.gbd.n.j.b(a, th.toString());
    }
}
