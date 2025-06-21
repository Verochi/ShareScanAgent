package com.getui.gtc.extension.distribution.gbd.b.a;

/* loaded from: classes22.dex */
public final class e extends com.getui.gtc.extension.distribution.gbd.b.a.d {
    public static final short a = 0;
    public static final short c = 1;
    public static final short d = 2;
    public static final short e = 3;
    public static final short f = 4;
    public static final short g = 5;
    public static final short h = 6;
    public static final short i = 7;
    public static final short j = 8;
    public static final short k = 9;
    com.getui.gtc.extension.distribution.gbd.b.a.a.a l;
    java.net.InetAddress m;
    byte[] n;
    private int o;
    private com.getui.gtc.extension.distribution.gbd.b.a.a.b p;

    private e(com.getui.gtc.extension.distribution.gbd.b.a.a.e eVar) {
        super(eVar);
        this.l = null;
        this.m = null;
        this.n = null;
        this.o = 0;
        this.p = null;
    }

    private com.getui.gtc.extension.distribution.gbd.b.a.a.a a() {
        return this.l;
    }

    public static com.getui.gtc.extension.distribution.gbd.b.a.e a(com.getui.gtc.extension.distribution.gbd.b.a.a.e eVar, java.nio.ByteBuffer byteBuffer) {
        com.getui.gtc.extension.distribution.gbd.b.a.e eVar2 = new com.getui.gtc.extension.distribution.gbd.b.a.e(eVar);
        com.getui.gtc.extension.distribution.gbd.b.a.a.a a2 = com.getui.gtc.extension.distribution.gbd.b.a.a.a.a(byteBuffer);
        eVar2.l = a2;
        java.lang.Integer num = null;
        if (a2 == null) {
            return null;
        }
        int position = byteBuffer.position();
        com.getui.gtc.extension.distribution.gbd.b.a.a.c a3 = com.getui.gtc.extension.distribution.gbd.b.a.a.c.a((short) 1, byteBuffer);
        if (a3 != null) {
            eVar2.m = a3.b();
        }
        byteBuffer.position(position);
        com.getui.gtc.extension.distribution.gbd.b.a.a.c a4 = com.getui.gtc.extension.distribution.gbd.b.a.a.c.a((short) 2, byteBuffer);
        if (a4 != null) {
            eVar2.n = a4.e;
        }
        byteBuffer.position(position);
        com.getui.gtc.extension.distribution.gbd.b.a.a.c a5 = com.getui.gtc.extension.distribution.gbd.b.a.a.c.a((short) 4, byteBuffer);
        if (a5 != null) {
            java.nio.ByteBuffer a6 = a5.a();
            if (a6 != null && a6.remaining() == 4) {
                num = java.lang.Integer.valueOf(a6.getInt());
            }
            eVar2.o = num != null ? num.intValue() : 0;
        }
        byteBuffer.position(position);
        com.getui.gtc.extension.distribution.gbd.b.a.a.c a7 = com.getui.gtc.extension.distribution.gbd.b.a.a.c.a((short) 3, byteBuffer);
        if (a7 != null) {
            eVar2.p = com.getui.gtc.extension.distribution.gbd.b.a.a.b.a(a7.a());
        }
        int a8 = com.getui.gtc.extension.distribution.gbd.b.a.b.a(eVar2.b.m - 28);
        byteBuffer.position(byteBuffer.remaining() < a8 ? byteBuffer.limit() : position + a8);
        return eVar2;
    }

    private java.net.InetAddress b() {
        return this.m;
    }

    private byte[] c() {
        return this.n;
    }

    private int d() {
        return this.o;
    }

    private com.getui.gtc.extension.distribution.gbd.b.a.a.b e() {
        return this.p;
    }

    private int f() {
        java.net.InetAddress inetAddress = this.m;
        int a2 = inetAddress != null ? 28 + com.getui.gtc.extension.distribution.gbd.b.a.b.a(inetAddress.getAddress().length + 4) : 28;
        byte[] bArr = this.n;
        return bArr != null ? a2 + com.getui.gtc.extension.distribution.gbd.b.a.b.a(bArr.length + 4) : a2;
    }

    @Override // com.getui.gtc.extension.distribution.gbd.b.a.d
    public final java.lang.String toString() {
        int i2;
        java.lang.String a2;
        java.net.InetAddress inetAddress = this.m;
        java.lang.String hostAddress = inetAddress == null ? "" : inetAddress.getHostAddress();
        java.lang.StringBuilder sb = new java.lang.StringBuilder("RtNetlinkNeighborMessage{ nlmsghdr{");
        com.getui.gtc.extension.distribution.gbd.b.a.a.e eVar = this.b;
        if (eVar == null) {
            a2 = "";
        } else {
            i2 = android.system.OsConstants.NETLINK_ROUTE;
            a2 = eVar.a(java.lang.Integer.valueOf(i2));
        }
        sb.append(a2);
        sb.append("}, ndmsg{");
        com.getui.gtc.extension.distribution.gbd.b.a.a.a aVar = this.l;
        sb.append(aVar == null ? "" : aVar.toString());
        sb.append("}, destination{");
        sb.append(hostAddress);
        sb.append("} linklayeraddr{");
        sb.append(com.getui.gtc.extension.distribution.gbd.b.a.b.a(this.n));
        sb.append("} probes{");
        sb.append(this.o);
        sb.append("} cacheinfo{");
        com.getui.gtc.extension.distribution.gbd.b.a.a.b bVar = this.p;
        sb.append(bVar != null ? bVar.toString() : "");
        sb.append("} }");
        return sb.toString();
    }
}
