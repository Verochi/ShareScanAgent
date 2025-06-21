package com.getui.gtc.extension.distribution.gbd.m.e;

/* loaded from: classes22.dex */
public final class a implements java.lang.Runnable {
    private static final java.lang.String e = "Up_MR";
    protected java.net.NetworkInterface a;
    protected java.net.InetSocketAddress b;
    protected java.net.MulticastSocket c;
    protected com.getui.gtc.extension.distribution.gbd.m.e.a.C0315a d;

    /* renamed from: com.getui.gtc.extension.distribution.gbd.m.e.a$1, reason: invalid class name */
    public class AnonymousClass1 implements com.getui.gtc.extension.distribution.gbd.f.j<com.getui.gtc.extension.distribution.gbd.m.e.a.C0315a, java.net.InetSocketAddress> {
        public AnonymousClass1() {
        }

        /* renamed from: a, reason: avoid collision after fix types in other method */
        private static java.net.InetSocketAddress a2(com.getui.gtc.extension.distribution.gbd.m.e.a.C0315a c0315a) {
            return new java.net.InetSocketAddress(c0315a.a(), c0315a.b());
        }

        @Override // com.getui.gtc.extension.distribution.gbd.f.j
        public final /* synthetic */ java.net.InetSocketAddress a(com.getui.gtc.extension.distribution.gbd.m.e.a.C0315a c0315a) {
            com.getui.gtc.extension.distribution.gbd.m.e.a.C0315a c0315a2 = c0315a;
            return new java.net.InetSocketAddress(c0315a2.a(), c0315a2.b());
        }
    }

    /* renamed from: com.getui.gtc.extension.distribution.gbd.m.e.a$a, reason: collision with other inner class name */
    public static class C0315a {
        protected final java.net.InetAddress a;
        protected final int b = 1900;

        public C0315a(java.net.InetAddress inetAddress) {
            this.a = inetAddress;
        }

        public final java.net.InetAddress a() {
            return this.a;
        }

        public final int b() {
            return this.b;
        }
    }

    public a(java.net.InetAddress inetAddress) {
        this.d = new com.getui.gtc.extension.distribution.gbd.m.e.a.C0315a(inetAddress);
    }

    public final synchronized void a() {
        java.net.MulticastSocket multicastSocket = this.c;
        if (multicastSocket != null && !multicastSocket.isClosed()) {
            try {
                com.getui.gtc.extension.distribution.gbd.n.j.a(e, "Leaving multicast group.");
                this.c.leaveGroup(this.b, this.a);
            } catch (java.lang.Throwable th) {
                com.getui.gtc.extension.distribution.gbd.n.j.a(e, "Could not leave multicast group: ".concat(java.lang.String.valueOf(th)));
            }
            this.c.close();
        }
    }

    public final synchronized void a(java.net.NetworkInterface networkInterface) {
        this.a = networkInterface;
        try {
            com.getui.gtc.extension.distribution.gbd.f.c unused = com.getui.gtc.extension.distribution.gbd.f.c.a.a;
            this.b = (java.net.InetSocketAddress) com.getui.gtc.extension.distribution.gbd.f.c.a(true, com.getui.gtc.extension.distribution.gbd.f.b.v, this.d, new com.getui.gtc.extension.distribution.gbd.m.e.a.AnonymousClass1());
            java.net.MulticastSocket multicastSocket = new java.net.MulticastSocket(1900);
            this.c = multicastSocket;
            multicastSocket.setReuseAddress(true);
            this.c.setReceiveBufferSize(32768);
            this.c.joinGroup(this.b, this.a);
        } catch (java.lang.Throwable th) {
            com.getui.gtc.extension.distribution.gbd.n.j.a(e, "Could not initialize " + com.getui.gtc.extension.distribution.gbd.m.e.a.class.getSimpleName() + ": " + th);
        }
    }

    @Override // java.lang.Runnable
    public final void run() {
        java.lang.String valueOf;
        java.lang.String str;
        while (true) {
            try {
                java.net.DatagramPacket datagramPacket = new java.net.DatagramPacket(new byte[com.autonavi.amap.mapcore.tools.GlMapUtil.DEVICE_DISPLAY_DPI_XXHIGH], com.autonavi.amap.mapcore.tools.GlMapUtil.DEVICE_DISPLAY_DPI_XXHIGH);
                this.c.receive(datagramPacket);
                java.lang.String a = com.getui.gtc.extension.distribution.gbd.n.l.a(datagramPacket.getAddress());
                com.getui.gtc.extension.distribution.gbd.m.h.a.a(a, datagramPacket.getData());
                com.getui.gtc.extension.distribution.gbd.n.j.a(e, "listening for UDP datagrams on multi: ".concat(java.lang.String.valueOf(a)));
            } catch (com.getui.gtc.extension.distribution.gbd.m.c.a.f e2) {
                valueOf = java.lang.String.valueOf(e2);
                str = "Could not read datagram: ";
                com.getui.gtc.extension.distribution.gbd.n.j.a(e, str.concat(valueOf));
            } catch (java.net.SocketException unused) {
                com.getui.gtc.extension.distribution.gbd.n.j.a(e, "run socket closed.");
                try {
                    if (this.c.isClosed()) {
                        return;
                    }
                    com.getui.gtc.extension.distribution.gbd.n.j.a(e, "Closing multicast socket");
                    this.c.close();
                    return;
                } catch (java.lang.Throwable th) {
                    com.getui.gtc.extension.distribution.gbd.n.j.a(e, "Closing multicast socket e = ".concat(java.lang.String.valueOf(th)));
                    return;
                }
            } catch (java.lang.Throwable th2) {
                valueOf = java.lang.String.valueOf(th2);
                str = "datagram execute : ";
                com.getui.gtc.extension.distribution.gbd.n.j.a(e, str.concat(valueOf));
            }
        }
    }
}
