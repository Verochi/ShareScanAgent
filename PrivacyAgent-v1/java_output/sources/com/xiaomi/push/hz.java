package com.xiaomi.push;

/* loaded from: classes19.dex */
public final class hz {
    private final com.xiaomi.push.ih a;
    private final com.xiaomi.push.iq b;

    public hz() {
        this(new com.xiaomi.push.id.a());
    }

    public hz(com.xiaomi.push.ij ijVar) {
        com.xiaomi.push.iq iqVar = new com.xiaomi.push.iq();
        this.b = iqVar;
        this.a = ijVar.a(iqVar);
    }

    public final void a(com.xiaomi.push.hw hwVar, byte[] bArr) {
        this.b.a(bArr, bArr.length);
        hwVar.a(this.a);
    }
}
