package com.getui.gtc.extension.distribution.gbd.m.e;

/* loaded from: classes22.dex */
public final class b {
    protected final java.util.List<java.net.NetworkInterface> a = new java.util.ArrayList();
    protected final java.util.List<java.net.InetAddress> b = new java.util.ArrayList();

    public b() {
        d();
    }

    private static boolean a(java.net.InetAddress inetAddress) {
        if (inetAddress == null || inetAddress.isLoopbackAddress()) {
            return false;
        }
        return inetAddress instanceof java.net.Inet4Address;
    }

    private static boolean a(java.net.NetworkInterface networkInterface) {
        return networkInterface.getName().contains("wlan");
    }

    /* JADX WARN: Removed duplicated region for block: B:24:0x0068 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:28:0x004d A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void d() {
        com.getui.gtc.extension.distribution.gbd.m.c.a.b bVar;
        boolean z;
        try {
            java.util.Iterator it = java.util.Collections.list(java.net.NetworkInterface.getNetworkInterfaces()).iterator();
            while (it.hasNext()) {
                java.net.NetworkInterface networkInterface = (java.net.NetworkInterface) it.next();
                if (networkInterface.getName().contains("wlan")) {
                    this.a.add(networkInterface);
                }
            }
            try {
                java.util.Iterator<java.net.NetworkInterface> it2 = this.a.iterator();
                while (it2.hasNext()) {
                    java.util.Iterator it3 = java.util.Collections.list(it2.next().getInetAddresses()).iterator();
                    int i = 0;
                    while (it3.hasNext()) {
                        java.net.InetAddress inetAddress = (java.net.InetAddress) it3.next();
                        if (inetAddress != null && !inetAddress.isLoopbackAddress()) {
                            z = inetAddress instanceof java.net.Inet4Address;
                            if (!z) {
                                i++;
                                this.b.add(inetAddress);
                            }
                        }
                        z = false;
                        if (!z) {
                        }
                    }
                    if (i == 0) {
                        it2.remove();
                    }
                }
            } finally {
            }
        } finally {
        }
    }

    public final java.util.List<java.net.NetworkInterface> a() {
        return this.a;
    }

    public final java.util.List<java.net.InetAddress> b() {
        return this.b;
    }

    public final boolean c() {
        return this.a.size() > 0 && this.b.size() > 0;
    }
}
