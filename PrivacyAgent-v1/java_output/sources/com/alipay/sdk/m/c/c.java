package com.alipay.sdk.m.c;

/* loaded from: classes.dex */
public class c implements com.alipay.sdk.m.b.b {
    public static final int d = 1;
    public com.alipay.sdk.m.r0.b a;
    public boolean b = false;
    public boolean c = false;

    @Override // com.alipay.sdk.m.b.b
    public java.lang.String a(android.content.Context context) {
        if (context == null) {
            return null;
        }
        if (!this.b) {
            com.alipay.sdk.m.r0.b bVar = new com.alipay.sdk.m.r0.b();
            this.a = bVar;
            this.c = bVar.a(context, (com.alipay.sdk.m.r0.b.InterfaceC0042b<java.lang.String>) null) == 1;
            this.b = true;
        }
        com.alipay.sdk.m.d.a.b("getOAID", "isSupported", java.lang.Boolean.valueOf(this.c));
        if (this.c && this.a.e()) {
            return this.a.b();
        }
        return null;
    }
}
