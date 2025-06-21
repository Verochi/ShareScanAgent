package com.vivo.push.b;

/* loaded from: classes19.dex */
public final class o extends com.vivo.push.b.v {
    protected com.vivo.push.model.UnvarnishedMessage a;

    public o() {
        super(3);
    }

    @Override // com.vivo.push.b.v, com.vivo.push.b.s, com.vivo.push.o
    public final void c(com.vivo.push.a aVar) {
        super.c(aVar);
        aVar.a("msg_v1", this.a.unpackToJson());
    }

    public final java.lang.String d() {
        com.vivo.push.model.UnvarnishedMessage unvarnishedMessage = this.a;
        if (unvarnishedMessage == null) {
            return null;
        }
        return unvarnishedMessage.unpackToJson();
    }

    @Override // com.vivo.push.b.v, com.vivo.push.b.s, com.vivo.push.o
    public final void d(com.vivo.push.a aVar) {
        super.d(aVar);
        java.lang.String a = aVar.a("msg_v1");
        if (android.text.TextUtils.isEmpty(a)) {
            return;
        }
        com.vivo.push.model.UnvarnishedMessage unvarnishedMessage = new com.vivo.push.model.UnvarnishedMessage(a);
        this.a = unvarnishedMessage;
        unvarnishedMessage.setMsgId(f());
    }

    public final com.vivo.push.model.UnvarnishedMessage e() {
        return this.a;
    }

    @Override // com.vivo.push.b.s, com.vivo.push.o
    public final java.lang.String toString() {
        return "OnMessageCommand";
    }
}
