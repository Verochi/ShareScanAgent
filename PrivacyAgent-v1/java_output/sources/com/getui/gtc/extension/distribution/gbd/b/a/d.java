package com.getui.gtc.extension.distribution.gbd.b.a;

/* loaded from: classes22.dex */
public class d {
    protected final com.getui.gtc.extension.distribution.gbd.b.a.a.e b;

    public d(com.getui.gtc.extension.distribution.gbd.b.a.a.e eVar) {
        this.b = eVar;
    }

    private com.getui.gtc.extension.distribution.gbd.b.a.a.e a() {
        return this.b;
    }

    private static com.getui.gtc.extension.distribution.gbd.b.a.d a(com.getui.gtc.extension.distribution.gbd.b.a.a.e eVar, java.nio.ByteBuffer byteBuffer) {
        switch (eVar.n) {
            case 28:
            case 29:
            case 30:
                return com.getui.gtc.extension.distribution.gbd.b.a.e.a(eVar, byteBuffer);
            default:
                return null;
        }
    }

    private static com.getui.gtc.extension.distribution.gbd.b.a.d a(com.getui.gtc.extension.distribution.gbd.b.a.a.e eVar, java.nio.ByteBuffer byteBuffer, int i) {
        com.getui.gtc.extension.distribution.gbd.b.a.a.d dVar;
        if (eVar.n != 2) {
            byteBuffer.position(byteBuffer.position() + i);
            return new com.getui.gtc.extension.distribution.gbd.b.a.d(eVar);
        }
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

    private static com.getui.gtc.extension.distribution.gbd.b.a.d a(java.nio.ByteBuffer byteBuffer, int i) {
        int i2;
        com.getui.gtc.extension.distribution.gbd.b.a.a.d dVar;
        int position = byteBuffer != null ? byteBuffer.position() : -1;
        com.getui.gtc.extension.distribution.gbd.b.a.a.e a = com.getui.gtc.extension.distribution.gbd.b.a.a.e.a(byteBuffer);
        com.getui.gtc.extension.distribution.gbd.b.a.e eVar = null;
        if (a == null) {
            return null;
        }
        int a2 = com.getui.gtc.extension.distribution.gbd.b.a.b.a(a.m);
        int i3 = a2 - 16;
        if (i3 < 0 || i3 > byteBuffer.remaining()) {
            byteBuffer.position(byteBuffer.limit());
            return null;
        }
        short s2 = a.n;
        if (s2 > 15) {
            i2 = android.system.OsConstants.NETLINK_ROUTE;
            if (i == i2) {
                switch (a.n) {
                    case 28:
                    case 29:
                    case 30:
                        eVar = com.getui.gtc.extension.distribution.gbd.b.a.e.a(a, byteBuffer);
                        break;
                }
            }
            byteBuffer.position(position + a2);
            return eVar;
        }
        if (s2 != 2) {
            byteBuffer.position(byteBuffer.position() + i3);
            return new com.getui.gtc.extension.distribution.gbd.b.a.d(a);
        }
        com.getui.gtc.extension.distribution.gbd.b.a.c cVar = new com.getui.gtc.extension.distribution.gbd.b.a.c(a);
        if (byteBuffer.remaining() >= 20) {
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

    public java.lang.String toString() {
        return "NetlinkMessage{" + this.b.toString() + com.alipay.sdk.m.u.i.d;
    }
}
