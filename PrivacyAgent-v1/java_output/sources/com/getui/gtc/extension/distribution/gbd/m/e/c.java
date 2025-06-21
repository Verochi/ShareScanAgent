package com.getui.gtc.extension.distribution.gbd.m.e;

/* loaded from: classes22.dex */
public final class c implements java.lang.Runnable {
    private static final java.lang.String c = "Up_Uni";
    protected java.net.InetSocketAddress a;
    protected java.net.MulticastSocket b;

    /* renamed from: com.getui.gtc.extension.distribution.gbd.m.e.c$1, reason: invalid class name */
    public class AnonymousClass1 implements com.getui.gtc.extension.distribution.gbd.f.j<java.net.InetAddress, java.net.InetSocketAddress> {
        public AnonymousClass1() {
        }

        /* renamed from: a, reason: avoid collision after fix types in other method */
        private static java.net.InetSocketAddress a2(java.net.InetAddress inetAddress) {
            return new java.net.InetSocketAddress(inetAddress, 0);
        }

        @Override // com.getui.gtc.extension.distribution.gbd.f.j
        public final /* synthetic */ java.net.InetSocketAddress a(java.net.InetAddress inetAddress) {
            return new java.net.InetSocketAddress(inetAddress, 0);
        }
    }

    private static java.net.DatagramPacket b(com.getui.gtc.extension.distribution.gbd.m.f.a aVar) {
        try {
            byte[] bytes = ("M-SEARCH * HTTP/1.1\r\n" + aVar.c.toString() + "\r\n").getBytes("US-ASCII");
            com.getui.gtc.extension.distribution.gbd.n.j.b(c, "Writing new datagram packet with " + bytes.length + " bytes for: " + aVar);
            return new java.net.DatagramPacket(bytes, bytes.length, aVar.a, aVar.b);
        } catch (java.io.UnsupportedEncodingException e) {
            throw new com.getui.gtc.extension.distribution.gbd.m.c.a.f("Can't convert message content to US-ASCII: " + e.getMessage(), e);
        }
    }

    public final synchronized void a() {
        java.net.MulticastSocket multicastSocket = this.b;
        if (multicastSocket != null && !multicastSocket.isClosed()) {
            this.b.close();
        }
    }

    public final synchronized void a(com.getui.gtc.extension.distribution.gbd.m.f.a aVar) {
        this.b.send(b(aVar));
    }

    public final synchronized void a(java.net.InetAddress inetAddress) {
        try {
            com.getui.gtc.extension.distribution.gbd.f.c unused = com.getui.gtc.extension.distribution.gbd.f.c.a.a;
            this.a = (java.net.InetSocketAddress) com.getui.gtc.extension.distribution.gbd.f.c.a(true, com.getui.gtc.extension.distribution.gbd.f.b.v, inetAddress, new com.getui.gtc.extension.distribution.gbd.m.e.c.AnonymousClass1());
            java.net.MulticastSocket multicastSocket = new java.net.MulticastSocket(this.a);
            this.b = multicastSocket;
            multicastSocket.setTimeToLive(4);
            this.b.setReceiveBufferSize(262144);
        } catch (java.lang.Exception e) {
            throw new com.getui.gtc.extension.distribution.gbd.m.c.a.b("Could not initialize " + com.getui.gtc.extension.distribution.gbd.m.e.c.class.getSimpleName() + ": " + e);
        }
    }

    @Override // java.lang.Runnable
    public final void run() {
        while (true) {
            try {
                java.net.DatagramPacket datagramPacket = new java.net.DatagramPacket(new byte[com.autonavi.amap.mapcore.tools.GlMapUtil.DEVICE_DISPLAY_DPI_XXHIGH], com.autonavi.amap.mapcore.tools.GlMapUtil.DEVICE_DISPLAY_DPI_XXHIGH);
                this.b.receive(datagramPacket);
                java.lang.String a = com.getui.gtc.extension.distribution.gbd.n.l.a(datagramPacket.getAddress());
                com.getui.gtc.extension.distribution.gbd.n.j.a(c, "listen udp datagrams on uni: ".concat(java.lang.String.valueOf(a)));
                com.getui.gtc.extension.distribution.gbd.m.h.a.a(a, datagramPacket.getData());
            } catch (com.getui.gtc.extension.distribution.gbd.m.c.a.f e) {
                com.getui.gtc.extension.distribution.gbd.n.j.b(c, "Could not read datagram: " + e.getMessage());
            } catch (java.net.SocketException unused) {
                com.getui.gtc.extension.distribution.gbd.n.j.b(c, "Socket closed");
                try {
                    if (this.b.isClosed()) {
                        return;
                    }
                    com.getui.gtc.extension.distribution.gbd.n.j.b(c, "Closing unicast socket");
                    this.b.close();
                    return;
                } catch (java.lang.Throwable th) {
                    com.getui.gtc.extension.distribution.gbd.n.j.a(c, "st closed error: ".concat(java.lang.String.valueOf(th)));
                    return;
                }
            } catch (java.lang.Throwable th2) {
                com.getui.gtc.extension.distribution.gbd.n.j.a(c, "read error: ".concat(java.lang.String.valueOf(th2)));
            }
        }
    }
}
