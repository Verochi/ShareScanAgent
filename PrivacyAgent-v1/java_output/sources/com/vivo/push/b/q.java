package com.vivo.push.b;

/* loaded from: classes19.dex */
public final class q extends com.vivo.push.b.v {
    protected com.vivo.push.model.InsideNotificationItem a;
    private java.lang.String b;

    public q() {
        super(4);
    }

    @Override // com.vivo.push.b.v, com.vivo.push.b.s, com.vivo.push.o
    public final void c(com.vivo.push.a aVar) {
        super.c(aVar);
        java.lang.String b = com.vivo.push.util.q.b(this.a);
        this.b = b;
        aVar.a("notification_v1", b);
    }

    public final com.vivo.push.model.InsideNotificationItem d() {
        return this.a;
    }

    @Override // com.vivo.push.b.v, com.vivo.push.b.s, com.vivo.push.o
    public final void d(com.vivo.push.a aVar) {
        super.d(aVar);
        java.lang.String a = aVar.a("notification_v1");
        this.b = a;
        if (android.text.TextUtils.isEmpty(a)) {
            return;
        }
        com.vivo.push.model.InsideNotificationItem a2 = com.vivo.push.util.q.a(this.b);
        this.a = a2;
        if (a2 != null) {
            a2.setMsgId(f());
        }
    }

    public final java.lang.String e() {
        if (!android.text.TextUtils.isEmpty(this.b)) {
            return this.b;
        }
        com.vivo.push.model.InsideNotificationItem insideNotificationItem = this.a;
        if (insideNotificationItem == null) {
            return null;
        }
        return com.vivo.push.util.q.b(insideNotificationItem);
    }

    @Override // com.vivo.push.b.s, com.vivo.push.o
    public final java.lang.String toString() {
        return "OnNotifyArrivedCommand";
    }
}
