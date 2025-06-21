package com.getui.gtc.extension.distribution.gbd.b.a.a;

/* loaded from: classes22.dex */
public final class d {
    public static final int a = 20;
    public int b;
    public com.getui.gtc.extension.distribution.gbd.b.a.a.e c;

    private static boolean a(java.nio.ByteBuffer byteBuffer) {
        return byteBuffer != null && byteBuffer.remaining() >= 20;
    }

    private static com.getui.gtc.extension.distribution.gbd.b.a.a.d b(java.nio.ByteBuffer byteBuffer) {
        if (!(byteBuffer != null && byteBuffer.remaining() >= 20)) {
            return null;
        }
        com.getui.gtc.extension.distribution.gbd.b.a.a.d dVar = new com.getui.gtc.extension.distribution.gbd.b.a.a.d();
        dVar.b = byteBuffer.getInt();
        dVar.c = com.getui.gtc.extension.distribution.gbd.b.a.a.e.a(byteBuffer);
        return dVar;
    }

    private void c(java.nio.ByteBuffer byteBuffer) {
        byteBuffer.putInt(this.b);
        com.getui.gtc.extension.distribution.gbd.b.a.a.e eVar = this.c;
        if (eVar != null) {
            byteBuffer.putInt(eVar.m);
            byteBuffer.putShort(eVar.n);
            byteBuffer.putShort(eVar.o);
            byteBuffer.putInt(eVar.p);
            byteBuffer.putInt(eVar.q);
        }
    }

    public final java.lang.String toString() {
        java.lang.StringBuilder sb = new java.lang.StringBuilder("StructNlMsgErr{ error{");
        sb.append(this.b);
        sb.append("}, msg{");
        com.getui.gtc.extension.distribution.gbd.b.a.a.e eVar = this.c;
        sb.append(eVar == null ? "" : eVar.toString());
        sb.append("} }");
        return sb.toString();
    }
}
