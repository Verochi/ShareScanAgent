package com.anythink.core.common.h.a;

/* loaded from: classes12.dex */
public final class d {
    private static com.anythink.core.common.h.a.d g;
    private java.lang.String h;
    private int i;
    private java.net.Socket j;
    private final int c = 0;
    private final int d = 7;
    private final int e = 1;
    private final java.lang.String f = com.anythink.core.common.h.a.d.class.getSimpleName();
    byte[] a = null;
    byte[] b = new byte[1];

    /* renamed from: com.anythink.core.common.h.a.d$1, reason: invalid class name */
    public class AnonymousClass1 extends com.anythink.core.common.o.b.d {
        final /* synthetic */ com.anythink.core.common.h.a.c a;
        final /* synthetic */ com.anythink.core.common.h.a.c.a b;

        public AnonymousClass1(com.anythink.core.common.h.a.c cVar, com.anythink.core.common.h.a.c.a aVar) {
            this.a = cVar;
            this.b = aVar;
        }

        @Override // com.anythink.core.common.o.b.d
        public final void a() {
            try {
                try {
                    com.anythink.core.common.h.a.d.this.a(this.a);
                    int e = com.anythink.core.common.h.a.d.this.e();
                    if (e != 1) {
                        throw new java.lang.Exception("Response Error Code:".concat(java.lang.String.valueOf(e)));
                    }
                    com.anythink.core.common.h.a.c.a aVar = this.b;
                    if (aVar != null) {
                        aVar.a(this.a);
                    }
                } catch (java.net.SocketException unused) {
                    com.anythink.core.common.h.a.d.b(com.anythink.core.common.h.a.d.this);
                    com.anythink.core.common.h.a.d.this.a(this.a);
                    int e2 = com.anythink.core.common.h.a.d.this.e();
                    if (e2 != 1) {
                        throw new java.lang.Exception("Response Error Code:".concat(java.lang.String.valueOf(e2)));
                    }
                    com.anythink.core.common.h.a.c.a aVar2 = this.b;
                    if (aVar2 != null) {
                        aVar2.a(this.a);
                    }
                }
            } catch (java.lang.Throwable th) {
                this.a.a("", th.getMessage() + "," + com.anythink.core.common.o.i.a(th.getStackTrace()), com.anythink.core.common.h.a.d.this.h, com.anythink.core.common.h.a.d.this.i);
                com.anythink.core.common.h.a.c.a aVar3 = this.b;
                if (aVar3 != null) {
                    aVar3.a(th);
                }
            }
        }
    }

    private d() {
    }

    public static synchronized com.anythink.core.common.h.a.d a() {
        com.anythink.core.common.h.a.d dVar;
        synchronized (com.anythink.core.common.h.a.d.class) {
            if (g == null) {
                g = new com.anythink.core.common.h.a.d();
            }
            dVar = g;
        }
        return dVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void a(com.anythink.core.common.h.a.c cVar) {
        java.net.Socket socket = this.j;
        if (!((socket == null || !socket.isConnected() || this.j.isClosed()) ? false : true)) {
            synchronized (this) {
                if (this.j == null) {
                    java.net.Socket socket2 = new java.net.Socket();
                    this.j = socket2;
                    socket2.setSoTimeout(60000);
                }
                com.anythink.core.d.a b = com.anythink.core.d.b.a(com.anythink.core.common.b.o.a().f()).b(com.anythink.core.common.b.o.a().o());
                if (b != null) {
                    this.h = b.D();
                    this.i = b.E();
                    this.j.connect(new java.net.InetSocketAddress(this.h, this.i), 30000);
                }
            }
        }
        byte[] e = cVar.e();
        if (e != null) {
            int length = e.length;
            if (e.length == 0) {
                return;
            }
            int i = length + 7;
            byte[] bArr = this.a;
            if (bArr == null || bArr.length < i) {
                this.a = new byte[i];
            }
            byte[] bArr2 = this.a;
            bArr2[0] = 0;
            bArr2[1] = 3;
            bArr2[2] = (byte) cVar.c();
            byte[] bArr3 = this.a;
            bArr3[3] = (byte) ((length >>> 24) & 255);
            bArr3[4] = (byte) ((length >>> 16) & 255);
            bArr3[5] = (byte) ((length >>> 8) & 255);
            bArr3[6] = (byte) ((length >>> 0) & 255);
            java.lang.System.arraycopy(e, 0, bArr3, 7, e.length);
            java.io.OutputStream outputStream = this.j.getOutputStream();
            outputStream.write(this.a, 0, i);
            outputStream.flush();
        }
    }

    private void a(com.anythink.core.common.h.a.c cVar, com.anythink.core.common.h.a.c.a aVar) {
        com.anythink.core.common.o.b.b.a().a((com.anythink.core.common.o.b.d) new com.anythink.core.common.h.a.d.AnonymousClass1(cVar, aVar), 3);
    }

    private void b() {
        synchronized (this) {
            if (this.j == null) {
                java.net.Socket socket = new java.net.Socket();
                this.j = socket;
                socket.setSoTimeout(60000);
            }
            com.anythink.core.d.a b = com.anythink.core.d.b.a(com.anythink.core.common.b.o.a().f()).b(com.anythink.core.common.b.o.a().o());
            if (b != null) {
                this.h = b.D();
                this.i = b.E();
                this.j.connect(new java.net.InetSocketAddress(this.h, this.i), 30000);
            }
        }
    }

    public static /* synthetic */ void b(com.anythink.core.common.h.a.d dVar) {
        synchronized (dVar) {
            try {
                java.net.Socket socket = dVar.j;
                if (socket != null) {
                    socket.close();
                    dVar.j = null;
                }
            } catch (java.lang.Exception unused) {
            }
        }
    }

    private void c() {
        synchronized (this) {
            try {
                java.net.Socket socket = this.j;
                if (socket != null) {
                    socket.close();
                    this.j = null;
                }
            } catch (java.lang.Exception unused) {
            }
        }
    }

    private boolean d() {
        java.net.Socket socket = this.j;
        return (socket == null || !socket.isConnected() || this.j.isClosed()) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized int e() {
        byte b;
        if (this.j.getInputStream().read(this.b, 0, 1) == -1) {
            throw new java.net.SocketException("Socket.InputStream read length = -1!");
        }
        byte[] bArr = this.b;
        b = bArr[0];
        bArr[0] = 0;
        return b;
    }
}
