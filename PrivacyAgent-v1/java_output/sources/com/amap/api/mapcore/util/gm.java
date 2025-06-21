package com.amap.api.mapcore.util;

/* loaded from: classes12.dex */
public final class gm {
    private android.content.Context a;
    private com.amap.api.mapcore.util.fh b;
    private boolean c = true;
    private java.lang.String d = "40C27E38DCAD404B5465362914090908";
    private com.amap.api.mapcore.util.il e = new com.amap.api.mapcore.util.il("40C27E38DCAD404B5465362914090908");

    public final void a(android.content.Context context, boolean z, java.lang.String str, java.lang.String str2, java.lang.String str3, java.lang.String[] strArr) {
        try {
            com.amap.api.mapcore.util.fh a = new com.amap.api.mapcore.util.fh.a(str, str2, str).a(strArr).a(str3).a();
            if (context == null) {
                return;
            }
            android.content.Context applicationContext = context.getApplicationContext();
            this.a = applicationContext;
            this.b = a;
            this.c = z;
            this.e.a(applicationContext, a);
        } catch (com.amap.api.mapcore.util.eu unused) {
        }
    }

    public final void a(java.lang.String str, java.lang.String str2) {
        java.util.List<com.amap.api.mapcore.util.fh> a = this.e.a(this.a);
        com.amap.api.mapcore.util.go goVar = com.amap.api.mapcore.util.go.a.a;
        com.amap.api.mapcore.util.go.a(this.a, str, str2, a, this.c, this.b);
    }
}
