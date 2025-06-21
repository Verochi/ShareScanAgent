package com.bun.miitmdid.c.j.b;

/* loaded from: classes.dex */
public class c extends android.database.ContentObserver {
    private java.lang.String a;
    private int b;
    private com.bun.miitmdid.c.j.b.b c;

    public c(com.bun.miitmdid.c.j.b.b bVar, int i, java.lang.String str) {
        super(null);
        this.c = bVar;
        this.b = i;
        this.a = str;
    }

    @Override // android.database.ContentObserver
    public void onChange(boolean z) {
        com.bun.miitmdid.c.j.b.b bVar = this.c;
        if (bVar != null) {
            bVar.a(this.b, this.a);
        } else {
            com.bun.lib.a.a(com.alipay.sdk.m.p0.d.d, "mIdentifierIdClient is null");
        }
    }
}
