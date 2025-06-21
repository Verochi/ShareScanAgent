package com.anythink.expressad.foundation.g.f.h;

/* loaded from: classes12.dex */
public class a {
    private static final java.lang.String b = "a";
    protected android.content.Context a;

    public a(android.content.Context context) {
        if (context == null) {
            this.a = com.anythink.expressad.foundation.b.a.b().d();
        } else {
            this.a = context.getApplicationContext();
        }
    }

    private void a(int i, java.lang.String str, com.anythink.expressad.foundation.g.f.h.b bVar, com.anythink.expressad.foundation.g.f.e eVar) {
        java.lang.String str2 = bVar.b().get("sign");
        if (str2 == null) {
            str2 = "";
        }
        long currentTimeMillis = java.lang.System.currentTimeMillis();
        bVar.a("ts", java.lang.String.valueOf(currentTimeMillis));
        bVar.a("st", com.anythink.expressad.foundation.h.p.a(str2 + currentTimeMillis));
        b(i, str, bVar, new com.anythink.expressad.foundation.g.f.b(), eVar);
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x007c  */
    /* JADX WARN: Removed duplicated region for block: B:18:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void a(int i, java.lang.String str, com.anythink.expressad.foundation.g.f.h.b bVar, com.anythink.expressad.foundation.g.f.l lVar, com.anythink.expressad.foundation.g.f.e eVar) {
        com.anythink.expressad.foundation.g.f.i gVar;
        if (bVar == null) {
            try {
                bVar = new com.anythink.expressad.foundation.g.f.h.b();
            } catch (java.lang.Exception e) {
                e.getMessage();
            }
        }
        a(str, bVar);
        java.lang.String str2 = bVar.b().get("sign");
        if (str2 == null) {
            str2 = "";
        }
        long currentTimeMillis = java.lang.System.currentTimeMillis();
        bVar.a("ts", java.lang.String.valueOf(currentTimeMillis));
        bVar.a("st", com.anythink.expressad.foundation.h.p.a(str2 + currentTimeMillis));
        java.lang.String str3 = str + "?" + bVar.toString();
        com.anythink.expressad.foundation.g.f.i iVar = null;
        if (i == 0) {
            gVar = new com.anythink.expressad.foundation.g.f.d.g(0, str3, null, eVar);
        } else {
            if (i != 1) {
                if (i == 2) {
                    gVar = new com.anythink.expressad.foundation.g.f.d.c(0, str3, null, eVar);
                }
                if (iVar == null) {
                    iVar.a(lVar);
                    com.anythink.expressad.foundation.g.f.m.a(iVar);
                    return;
                }
                return;
            }
            gVar = new com.anythink.expressad.foundation.g.f.d.d(0, str3, null, eVar);
        }
        iVar = gVar;
        if (iVar == null) {
        }
    }

    public static void a(java.io.File file, java.lang.String str, com.anythink.expressad.foundation.g.f.e eVar) {
        com.anythink.expressad.foundation.g.f.m.a().a(file, str, (com.anythink.expressad.foundation.g.f.e<java.lang.Void>) eVar);
    }

    private void b(int i, java.lang.String str, com.anythink.expressad.foundation.g.f.h.b bVar, com.anythink.expressad.foundation.g.f.e eVar) {
        b(i, str, bVar, new com.anythink.expressad.foundation.g.f.b(), eVar);
    }

    private void b(int i, java.lang.String str, com.anythink.expressad.foundation.g.f.h.b bVar, com.anythink.expressad.foundation.g.f.l lVar, com.anythink.expressad.foundation.g.f.e eVar) {
        com.anythink.expressad.foundation.g.f.i gVar;
        if (bVar == null) {
            try {
                bVar = new com.anythink.expressad.foundation.g.f.h.b();
            } catch (java.lang.Exception e) {
                e.getMessage();
            }
        }
        a(str, bVar);
        if (i == 0) {
            gVar = new com.anythink.expressad.foundation.g.f.d.g(1, str, bVar.toString(), eVar);
            gVar.a("Content-Type", com.anythink.expressad.foundation.g.f.g.b.e);
        } else if (i == 1) {
            gVar = new com.anythink.expressad.foundation.g.f.d.d(1, str, bVar.toString(), eVar);
            gVar.a("Content-Type", com.anythink.expressad.foundation.g.f.g.b.e);
        } else if (i != 2) {
            gVar = null;
        } else {
            gVar = new com.anythink.expressad.foundation.g.f.d.c(1, str, bVar.toString(), eVar);
            gVar.a("Content-Type", com.anythink.expressad.foundation.g.f.g.b.e);
        }
        if (gVar != null) {
            gVar.a(lVar);
            com.anythink.expressad.foundation.g.f.m.a(gVar);
        }
    }

    public void a(java.lang.String str, com.anythink.expressad.foundation.g.f.h.b bVar) {
        if (bVar != null) {
            bVar.a(com.igexin.sdk.PushBuildConfig.sdk_conf_channelid, com.anythink.expressad.foundation.g.a.cy);
            java.lang.StringBuilder sb = new java.lang.StringBuilder();
            com.anythink.expressad.foundation.g.f.a.a();
            sb.append(com.anythink.expressad.foundation.g.f.a.b());
            bVar.a("band_width", sb.toString());
            java.lang.String str2 = bVar.b().get("unit_id");
            if (str2 != null) {
                java.lang.String a = com.anythink.expressad.out.k.a().a(str2, str);
                if (android.text.TextUtils.isEmpty(a)) {
                    return;
                }
                bVar.a("ch_info", a);
            }
        }
    }

    public final void a(java.lang.String str, com.anythink.expressad.foundation.g.f.h.b bVar, com.anythink.expressad.foundation.g.f.e eVar) {
        com.anythink.expressad.foundation.g.f.b bVar2 = new com.anythink.expressad.foundation.g.f.b();
        if (bVar == null) {
            try {
                bVar = new com.anythink.expressad.foundation.g.f.h.b();
            } catch (java.lang.Exception e) {
                e.getMessage();
            }
        }
        a(str, bVar);
        java.lang.String str2 = bVar.b().get("sign");
        if (str2 == null) {
            str2 = "";
        }
        long currentTimeMillis = java.lang.System.currentTimeMillis();
        bVar.a("ts", java.lang.String.valueOf(currentTimeMillis));
        bVar.a("st", com.anythink.expressad.foundation.h.p.a(str2 + currentTimeMillis));
        com.anythink.expressad.foundation.g.f.d.g gVar = new com.anythink.expressad.foundation.g.f.d.g(0, str + "?" + bVar.toString(), null, eVar);
        gVar.a((com.anythink.expressad.foundation.g.f.l) bVar2);
        com.anythink.expressad.foundation.g.f.m.a(gVar);
    }
}
