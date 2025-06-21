package com.anythink.expressad.video.module.c;

/* loaded from: classes12.dex */
public final class a extends com.anythink.expressad.foundation.g.f.h.a {
    public a(android.content.Context context) {
        super(context);
    }

    @Override // com.anythink.expressad.foundation.g.f.h.a
    public final void a(java.lang.String str, com.anythink.expressad.foundation.g.f.h.b bVar) {
        super.a(str, bVar);
        bVar.a("platform", "1");
        bVar.a("os_version", android.os.Build.VERSION.RELEASE);
        bVar.a("package_name", com.anythink.expressad.foundation.h.k.h(this.a));
        bVar.a(com.anythink.expressad.foundation.g.a.bf, com.anythink.expressad.foundation.h.k.d(this.a));
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        sb.append(com.anythink.expressad.foundation.h.k.c(this.a));
        bVar.a(com.xiaomi.mipush.sdk.Constants.EXTRA_KEY_APP_VERSION_CODE, sb.toString());
        java.lang.StringBuilder sb2 = new java.lang.StringBuilder();
        sb2.append(com.anythink.expressad.foundation.h.k.b(this.a));
        bVar.a("orientation", sb2.toString());
        bVar.a("gaid", "");
        bVar.a("sdk_version", com.anythink.expressad.out.b.a);
        com.anythink.expressad.d.b.a();
        com.anythink.expressad.foundation.b.a.b().e();
        if (com.anythink.expressad.d.b.b() != null) {
            org.json.JSONObject jSONObject = new org.json.JSONObject();
            try {
                if (android.text.TextUtils.isEmpty(jSONObject.toString())) {
                    return;
                }
                java.lang.String a = com.anythink.expressad.foundation.h.j.a(jSONObject.toString());
                if (android.text.TextUtils.isEmpty(a)) {
                    return;
                }
                bVar.a("dvi", a);
            } catch (java.lang.Exception e) {
                e.printStackTrace();
            }
        }
    }
}
