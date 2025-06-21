package com.igexin.push.core.h;

import com.igexin.push.config.a.AnonymousClass6;
import com.igexin.push.config.a.AnonymousClass7;

/* loaded from: classes23.dex */
public final class b extends com.igexin.push.g.a.d {
    public static final java.lang.String a = "GetIDCConfigHttpPlugin";
    public static org.json.JSONArray b;

    public b(java.lang.String str, org.json.JSONArray jSONArray) {
        super(str);
        b = jSONArray;
    }

    private static void a(org.json.JSONArray jSONArray) {
        b = jSONArray;
    }

    @Override // com.igexin.push.g.a.d
    public final void a(java.lang.Exception exc) {
        com.igexin.push.core.e.f.a().b(java.lang.System.currentTimeMillis());
        com.igexin.c.a.c.a.a(exc);
    }

    @Override // com.igexin.push.g.a.d
    public final void a(byte[] bArr) throws java.lang.Exception {
        if (bArr != null) {
            try {
                java.lang.String str = new java.lang.String(com.igexin.c.b.a.c(android.util.Base64.decode(bArr, 0)));
                com.igexin.c.a.c.a.a("->get idc config server resp data : ".concat(str), new java.lang.Object[0]);
                com.igexin.c.a.b.e.a().a((com.igexin.c.a.d.f) com.igexin.push.config.a.a().new AnonymousClass7(str), true, false);
                com.igexin.push.config.g.a(str, true);
                com.igexin.push.core.e.f.a().b(0L);
                com.igexin.c.a.b.e.a().a((com.igexin.c.a.d.f) com.igexin.push.config.a.a().new AnonymousClass6(b.toString()), true, false);
                com.igexin.push.config.SDKUrlConfig.setIdcConfigUrl(com.igexin.push.core.a.b.h.a(b));
            } catch (java.lang.Exception e) {
                com.igexin.push.core.e.f.a().b(java.lang.System.currentTimeMillis());
                throw e;
            }
        }
    }

    @Override // com.igexin.c.a.d.a.e
    public final int c() {
        return 0;
    }
}
