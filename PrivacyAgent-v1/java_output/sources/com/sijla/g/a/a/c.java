package com.sijla.g.a.a;

/* loaded from: classes19.dex */
public final class c {
    private com.sijla.g.a.a.c.a a;

    public interface a {
        void a(java.lang.String str);
    }

    public c(com.sijla.g.a.a.c.a aVar) {
        this.a = aVar;
    }

    private static java.lang.String a(java.lang.String str) {
        try {
            java.lang.Class<?> cls = java.lang.Class.forName("android.os.SystemProperties");
            return (java.lang.String) cls.getMethod(com.ss.android.socialbase.downloader.constants.MonitorConstants.CONNECT_TYPE_GET, java.lang.String.class, java.lang.String.class).invoke(cls, str, "unknown");
        } catch (java.lang.Exception unused) {
            return null;
        }
    }

    public static boolean a() {
        java.lang.String a2 = a("ro.build.freeme.label");
        return !android.text.TextUtils.isEmpty(a2) && a2.equalsIgnoreCase("FREEMEOS");
    }

    private void b(android.content.Context context) {
        new java.lang.Thread(new com.sijla.g.a.a.d(this, context)).start();
    }

    public static boolean b() {
        java.lang.String a2 = a("ro.ssui.product");
        return (android.text.TextUtils.isEmpty(a2) || a2.equalsIgnoreCase("unknown")) ? false : true;
    }

    /* JADX WARN: Code restructure failed: missing block: B:51:0x014d, code lost:
    
        if (b() == false) goto L48;
     */
    /* JADX WARN: Removed duplicated region for block: B:12:0x0157  */
    /* JADX WARN: Removed duplicated region for block: B:15:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void a(android.content.Context context) {
        java.lang.String str;
        com.sijla.g.a.a.c.a aVar;
        com.sijla.g.a aVar2;
        com.sijla.g.a.a.g gVar;
        java.lang.String str2 = android.os.Build.MANUFACTURER;
        if (!"ASUS".equals(str2.toUpperCase().toUpperCase()) && !"HUAWEI".equals(str2.toUpperCase().toUpperCase())) {
            if ("LENOVO".equals(str2.toUpperCase().toUpperCase())) {
                gVar = new com.sijla.g.a.a.g(context);
            } else if ("MOTOLORA".equals(str2.toUpperCase().toUpperCase())) {
                gVar = new com.sijla.g.a.a.g(context);
            } else {
                if (!"MEIZU".equals(str2.toUpperCase().toUpperCase())) {
                    if ("NUBIA".equals(str2.toUpperCase().toUpperCase())) {
                        str = new com.sijla.g.a.a.j(context).a();
                    } else if (!com.ss.android.download.api.constant.BaseConstants.ROM_OPPO_UPPER_CONSTANT.equals(str2.toUpperCase().toUpperCase())) {
                        if ("SAMSUNG".equals(str2.toUpperCase().toUpperCase())) {
                            new com.sijla.g.a.a.o(context).a(this.a);
                        } else if ("VIVO".equals(str2.toUpperCase().toUpperCase())) {
                            str = new com.sijla.g.a.a.q(context).a();
                        } else {
                            if ("XIAOMI".equals(str2.toUpperCase().toUpperCase())) {
                                aVar2 = new com.sijla.g.a(context);
                            } else if ("BLACKSHARK".equals(str2.toUpperCase().toUpperCase())) {
                                aVar2 = new com.sijla.g.a(context);
                            } else if (!"ONEPLUS".equals(str2.toUpperCase().toUpperCase())) {
                                if (!"ZTE".equals(str2.toUpperCase().toUpperCase())) {
                                    if (!"FERRMEOS".equals(str2.toUpperCase().toUpperCase())) {
                                        if (!a()) {
                                            if (!"SSUI".equals(str2.toUpperCase().toUpperCase())) {
                                            }
                                        }
                                    }
                                }
                            }
                            str = aVar2.a();
                        }
                    }
                    aVar = this.a;
                    if (aVar == null) {
                        aVar.a(str);
                        return;
                    }
                    return;
                }
                new com.sijla.g.a.a.i(context).a(this.a);
                str = null;
                aVar = this.a;
                if (aVar == null) {
                }
            }
            gVar.a(this.a);
            str = null;
            aVar = this.a;
            if (aVar == null) {
            }
        }
        b(context);
        str = null;
        aVar = this.a;
        if (aVar == null) {
        }
    }
}
