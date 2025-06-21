package com.bun.miitmdid.b;

/* loaded from: classes.dex */
public class c {
    private java.util.Map<java.lang.String, java.lang.String> a = new java.util.HashMap();

    public class a implements com.bun.miitmdid.b.b.InterfaceC0256b {
        public a(com.bun.miitmdid.b.c cVar) {
        }

        @Override // com.bun.miitmdid.b.b.InterfaceC0256b
        public void a(java.lang.Exception exc, int i, java.lang.String str) {
        }
    }

    private java.util.Map<java.lang.String, java.lang.String> a() {
        if (this.a.isEmpty()) {
            this.a.put("av", com.bun.lib.sysParamters.f().a());
            this.a.put("sv", com.bun.lib.sysParamters.f().d());
            this.a.put("md", com.bun.lib.sysParamters.f().c());
            this.a.put("mf", com.bun.lib.sysParamters.f().b());
            this.a.put("pn", com.bun.lib.sysParamters.g());
        }
        this.a.put("tm", java.lang.String.valueOf(java.lang.System.currentTimeMillis()));
        return this.a;
    }

    public boolean a(boolean z, java.lang.String str, java.lang.String str2, java.lang.String str3, java.lang.String str4, java.lang.String str5) {
        try {
            java.lang.String a2 = com.bun.miitmdid.d.b.a(java.lang.String.format("UDID=%s&OAID=%s&VAID=%s&AAID=%s&ADDID=%s", str, str2, str3, str4, str5));
            com.bun.miitmdid.b.b a3 = com.bun.miitmdid.b.b.a(com.bun.lib.b.b());
            a3.a(a());
            a3.a("support", java.lang.String.valueOf(z ? 1 : 0));
            a3.a((java.lang.Object) a2);
            a3.a("http://sdk.api.oaid.wocloud.cn/stat");
            a3.a((com.bun.miitmdid.b.b.InterfaceC0256b) new com.bun.miitmdid.b.c.a(this)).a();
            return true;
        } catch (java.lang.Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
