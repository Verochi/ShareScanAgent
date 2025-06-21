package com.vivo.push.b;

/* loaded from: classes19.dex */
public final class x extends com.vivo.push.o {
    private java.util.HashMap<java.lang.String, java.lang.String> a;
    private long b;

    public x() {
        super(2012);
    }

    public x(long j) {
        this();
        this.b = j;
    }

    public final void a(java.util.HashMap<java.lang.String, java.lang.String> hashMap) {
        this.a = hashMap;
    }

    @Override // com.vivo.push.o
    public final void c(com.vivo.push.a aVar) {
        aVar.a("ReporterCommand.EXTRA_PARAMS", this.a);
        aVar.a("ReporterCommand.EXTRA_REPORTER_TYPE", this.b);
    }

    public final void d() {
        java.lang.String sb;
        if (this.a == null) {
            sb = "reportParams is empty";
        } else {
            java.lang.StringBuilder sb2 = new java.lang.StringBuilder("report message reportType:");
            sb2.append(this.b);
            sb2.append(",msgId:");
            java.lang.String str = this.a.get(com.heytap.mcssdk.constant.b.c);
            if (android.text.TextUtils.isEmpty(str)) {
                str = this.a.get("message_id");
            }
            sb2.append(str);
            sb = sb2.toString();
        }
        com.vivo.push.util.p.d("ReporterCommand", sb);
    }

    @Override // com.vivo.push.o
    public final void d(com.vivo.push.a aVar) {
        this.a = (java.util.HashMap) aVar.d("ReporterCommand.EXTRA_PARAMS");
        this.b = aVar.b("ReporterCommand.EXTRA_REPORTER_TYPE", this.b);
    }

    @Override // com.vivo.push.o
    public final java.lang.String toString() {
        return "ReporterCommand（" + this.b + ")";
    }
}
