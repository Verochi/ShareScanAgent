package com.alipay.sdk.m.p0;

/* loaded from: classes.dex */
public class d extends android.database.ContentObserver {
    public static final java.lang.String d = "VMS_IDLG_SDK_Observer";
    public java.lang.String a;
    public int b;
    public com.alipay.sdk.m.p0.c c;

    public d(com.alipay.sdk.m.p0.c cVar, int i, java.lang.String str) {
        super(null);
        this.c = cVar;
        this.b = i;
        this.a = str;
    }

    @Override // android.database.ContentObserver
    public void onChange(boolean z) {
        com.alipay.sdk.m.p0.c cVar = this.c;
        if (cVar != null) {
            cVar.a(this.b, this.a);
        }
    }
}
