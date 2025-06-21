package com.xiaomi.push;

/* loaded from: classes19.dex */
final class eu implements com.xiaomi.push.ey {
    final /* synthetic */ com.xiaomi.push.et a;

    public eu(com.xiaomi.push.et etVar) {
        this.a = etVar;
    }

    @Override // com.xiaomi.push.ey
    public final void a(com.xiaomi.push.ev evVar) {
        com.xiaomi.channel.commonutils.logger.b.c("[Slim] " + this.a.b.format(new java.util.Date()) + " Connection started (" + this.a.c.hashCode() + ")");
    }

    @Override // com.xiaomi.push.ey
    public final void a(com.xiaomi.push.ev evVar, int i, java.lang.Exception exc) {
        com.xiaomi.channel.commonutils.logger.b.c("[Slim] " + this.a.b.format(new java.util.Date()) + " Connection closed (" + this.a.c.hashCode() + ")");
    }

    @Override // com.xiaomi.push.ey
    public final void a(com.xiaomi.push.ev evVar, java.lang.Exception exc) {
        com.xiaomi.channel.commonutils.logger.b.c("[Slim] " + this.a.b.format(new java.util.Date()) + " Reconnection failed due to an exception (" + this.a.c.hashCode() + ")");
        exc.printStackTrace();
    }

    @Override // com.xiaomi.push.ey
    public final void b(com.xiaomi.push.ev evVar) {
        com.xiaomi.channel.commonutils.logger.b.c("[Slim] " + this.a.b.format(new java.util.Date()) + " Connection reconnected (" + this.a.c.hashCode() + ")");
    }
}
