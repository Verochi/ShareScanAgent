package com.getui.gtc.extension.distribution.gbd.b.a;

/* loaded from: classes22.dex */
public final class c extends com.getui.gtc.extension.distribution.gbd.b.a.d {
    com.getui.gtc.extension.distribution.gbd.b.a.a.d a;

    public c(com.getui.gtc.extension.distribution.gbd.b.a.a.e eVar) {
        super(eVar);
        this.a = null;
    }

    private com.getui.gtc.extension.distribution.gbd.b.a.a.d a() {
        return this.a;
    }

    private static com.getui.gtc.extension.distribution.gbd.b.a.c a(com.getui.gtc.extension.distribution.gbd.b.a.a.e eVar, java.nio.ByteBuffer byteBuffer) {
        com.getui.gtc.extension.distribution.gbd.b.a.a.d dVar;
        com.getui.gtc.extension.distribution.gbd.b.a.c cVar = new com.getui.gtc.extension.distribution.gbd.b.a.c(eVar);
        if (byteBuffer != null && byteBuffer.remaining() >= 20) {
            dVar = new com.getui.gtc.extension.distribution.gbd.b.a.a.d();
            dVar.b = byteBuffer.getInt();
            dVar.c = com.getui.gtc.extension.distribution.gbd.b.a.a.e.a(byteBuffer);
        } else {
            dVar = null;
        }
        cVar.a = dVar;
        if (dVar == null) {
            return null;
        }
        return cVar;
    }

    @Override // com.getui.gtc.extension.distribution.gbd.b.a.d
    public final java.lang.String toString() {
        java.lang.StringBuilder sb = new java.lang.StringBuilder("NetlinkErrorMessage{ nlmsghdr{");
        com.getui.gtc.extension.distribution.gbd.b.a.a.e eVar = this.b;
        sb.append(eVar == null ? "" : eVar.toString());
        sb.append("}, nlmsgerr{");
        com.getui.gtc.extension.distribution.gbd.b.a.a.d dVar = this.a;
        sb.append(dVar != null ? dVar.toString() : "");
        sb.append("} }");
        return sb.toString();
    }
}
