package com.vivo.push.b;

/* loaded from: classes19.dex */
public final class p extends com.vivo.push.o {
    private java.lang.String a;
    private java.lang.String b;
    private byte[] c;
    private long d;
    private com.vivo.push.model.InsideNotificationItem e;

    public p() {
        super(5);
    }

    public p(java.lang.String str, long j, com.vivo.push.model.InsideNotificationItem insideNotificationItem) {
        super(5);
        this.a = str;
        this.d = j;
        this.e = insideNotificationItem;
    }

    @Override // com.vivo.push.o
    public final void c(com.vivo.push.a aVar) {
        aVar.a("package_name", this.a);
        aVar.a("notify_id", this.d);
        aVar.a("notification_v1", com.vivo.push.util.q.b(this.e));
        aVar.a("open_pkg_name", this.b);
        aVar.a("open_pkg_name_encode", this.c);
    }

    public final java.lang.String d() {
        return this.a;
    }

    @Override // com.vivo.push.o
    public final void d(com.vivo.push.a aVar) {
        this.a = aVar.a("package_name");
        this.d = aVar.b("notify_id", -1L);
        this.b = aVar.a("open_pkg_name");
        this.c = aVar.b("open_pkg_name_encode");
        java.lang.String a = aVar.a("notification_v1");
        if (!android.text.TextUtils.isEmpty(a)) {
            this.e = com.vivo.push.util.q.a(a);
        }
        com.vivo.push.model.InsideNotificationItem insideNotificationItem = this.e;
        if (insideNotificationItem != null) {
            insideNotificationItem.setMsgId(this.d);
        }
    }

    public final long e() {
        return this.d;
    }

    public final com.vivo.push.model.InsideNotificationItem f() {
        return this.e;
    }

    @Override // com.vivo.push.o
    public final java.lang.String toString() {
        return "OnNotificationClickCommand";
    }
}
