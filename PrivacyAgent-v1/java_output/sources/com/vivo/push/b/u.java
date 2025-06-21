package com.vivo.push.b;

/* loaded from: classes19.dex */
public final class u extends com.vivo.push.b.v {
    private long a;
    private int b;

    public u() {
        super(20);
        this.a = -1L;
    }

    @Override // com.vivo.push.b.v, com.vivo.push.b.s, com.vivo.push.o
    public final void c(com.vivo.push.a aVar) {
        super.c(aVar);
        aVar.a("undo_msg_v1", this.a);
        aVar.a("undo_msg_type_v1", this.b);
    }

    public final long d() {
        return this.a;
    }

    @Override // com.vivo.push.b.v, com.vivo.push.b.s, com.vivo.push.o
    public final void d(com.vivo.push.a aVar) {
        super.d(aVar);
        this.a = aVar.b("undo_msg_v1", this.a);
        this.b = aVar.b("undo_msg_type_v1", 0);
    }

    public final java.lang.String e() {
        long j = this.a;
        if (j != -1) {
            return java.lang.String.valueOf(j);
        }
        return null;
    }

    @Override // com.vivo.push.b.s, com.vivo.push.o
    public final java.lang.String toString() {
        return "OnUndoMsgCommand";
    }
}
