package com.igexin.push.c;

/* loaded from: classes31.dex */
public final class e {
    private static final java.lang.String e = "DT_DetectRunTask";
    private static final long f = 60;
    java.util.concurrent.Future<com.igexin.push.c.d> a;
    com.igexin.push.c.d b;
    com.igexin.push.c.i c;
    boolean d;

    /* renamed from: com.igexin.push.c.e$1, reason: invalid class name */
    /* loaded from: classes23.dex */
    public class AnonymousClass1 implements java.util.concurrent.Callable<com.igexin.push.c.d> {
        public AnonymousClass1() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        @Override // java.util.concurrent.Callable
        @android.annotation.SuppressLint({"NewApi"})
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public com.igexin.push.c.d call() {
            java.lang.Thread.currentThread().hashCode();
            com.igexin.b.a.a().a.getActiveCount();
            if (!java.lang.Thread.currentThread().isInterrupted()) {
                java.net.Socket socket = null;
                try {
                    try {
                    } catch (java.lang.Exception e) {
                        e = e;
                    }
                    if (java.lang.Thread.currentThread().isInterrupted()) {
                        com.igexin.c.a.c.a.a(com.igexin.push.c.e.e, java.lang.Thread.currentThread().getName() + " is interrupted ######");
                        java.lang.Thread.currentThread().hashCode();
                        com.igexin.b.a.a().a.getActiveCount();
                        return null;
                    }
                    synchronized (com.igexin.push.c.i.class) {
                    }
                    long currentTimeMillis = java.lang.System.currentTimeMillis();
                    java.lang.String[] a = com.igexin.c.a.b.g.a(com.igexin.push.c.e.this.b.a());
                    java.net.Socket socket2 = new java.net.Socket();
                    try {
                        socket2.connect(new java.net.InetSocketAddress(a[1], com.igexin.push.c.e.this.b.b), 2500);
                        long currentTimeMillis2 = java.lang.System.currentTimeMillis();
                        java.lang.String a2 = com.igexin.push.c.e.a(socket2.getInetAddress());
                        com.igexin.push.c.e.this.b.a("socket://" + a2 + com.xiaomi.mipush.sdk.Constants.COLON_SEPARATOR + com.igexin.push.c.e.this.b.b, currentTimeMillis2 - currentTimeMillis, currentTimeMillis2);
                        com.igexin.push.c.e.this.c();
                        com.igexin.c.a.c.a.a("DT_DetectRunTask|detect " + com.igexin.push.c.e.this.c() + "|time = " + com.igexin.push.c.e.this.b.c(), new java.lang.Object[0]);
                        synchronized (com.igexin.push.c.i.class) {
                            if (com.igexin.push.c.e.this.c != null && !java.lang.Thread.currentThread().isInterrupted()) {
                                com.igexin.push.c.e eVar = com.igexin.push.c.e.this;
                                eVar.c.a(com.igexin.push.c.b.a.a, eVar.b);
                            }
                            if (!socket2.isClosed()) {
                                try {
                                    socket2.close();
                                } catch (java.lang.Exception e2) {
                                    e = e2;
                                    com.igexin.c.a.c.a.a(e);
                                    java.lang.Thread.currentThread().hashCode();
                                    com.igexin.b.a.a().a.getActiveCount();
                                    return com.igexin.push.c.e.this.b;
                                }
                            }
                        }
                    } catch (java.lang.Exception e3) {
                        e = e3;
                        socket = socket2;
                        com.igexin.c.a.c.a.b(com.igexin.push.c.e.e, "|detect " + com.igexin.push.c.e.this.c() + "thread -->" + e.getMessage());
                        synchronized (com.igexin.push.c.i.class) {
                            com.igexin.push.c.e eVar2 = com.igexin.push.c.e.this;
                            if (eVar2.c != null) {
                                eVar2.b.b();
                                com.igexin.push.c.e eVar3 = com.igexin.push.c.e.this;
                                eVar3.c.a(com.igexin.push.c.b.a.c, eVar3.b);
                            }
                            if (socket != null && !socket.isClosed()) {
                                try {
                                    socket.close();
                                } catch (java.lang.Exception e4) {
                                    e = e4;
                                    com.igexin.c.a.c.a.a(e);
                                    java.lang.Thread.currentThread().hashCode();
                                    com.igexin.b.a.a().a.getActiveCount();
                                    return com.igexin.push.c.e.this.b;
                                }
                            }
                            java.lang.Thread.currentThread().hashCode();
                            com.igexin.b.a.a().a.getActiveCount();
                            return com.igexin.push.c.e.this.b;
                        }
                    } catch (java.lang.Throwable th) {
                        th = th;
                        socket = socket2;
                        if (socket != null && !socket.isClosed()) {
                            try {
                                socket.close();
                            } catch (java.lang.Exception e5) {
                                com.igexin.c.a.c.a.a(e5);
                            }
                        }
                        java.lang.Thread.currentThread().hashCode();
                        com.igexin.b.a.a().a.getActiveCount();
                        throw th;
                    }
                    java.lang.Thread.currentThread().hashCode();
                    com.igexin.b.a.a().a.getActiveCount();
                } catch (java.lang.Throwable th2) {
                    th = th2;
                }
            }
            return com.igexin.push.c.e.this.b;
        }
    }

    public static java.lang.String a(java.net.InetAddress inetAddress) throws java.lang.NoSuchMethodException {
        java.lang.Class<?> cls;
        try {
            cls = java.lang.Class.forName("java.net.InetAddress");
        } catch (java.lang.Throwable unused) {
        }
        if (android.os.Build.VERSION.SDK_INT >= 23) {
            java.lang.reflect.Method declaredMethod = cls.getDeclaredMethod("holder", new java.lang.Class[0]);
            declaredMethod.setAccessible(true);
            java.lang.Object invoke = declaredMethod.invoke(inetAddress, new java.lang.Object[0]);
            java.lang.reflect.Field declaredField = invoke.getClass().getDeclaredField("address");
            declaredField.setAccessible(true);
            int intValue = ((java.lang.Integer) declaredField.get(invoke)).intValue();
            java.lang.String str = ((intValue >>> 24) & 255) + "." + ((intValue >>> 16) & 255) + "." + ((intValue >>> 8) & 255) + "." + (intValue & 255);
            com.igexin.c.a.c.a.b(e, "i new Str: ".concat(java.lang.String.valueOf(str)));
            return str;
        }
        java.lang.reflect.Field declaredField2 = cls.getDeclaredField("ipaddress");
        declaredField2.setAccessible(true);
        byte[] bArr = (byte[]) declaredField2.get(inetAddress);
        if (bArr.length >= 4) {
            java.lang.String str2 = (bArr[3] & 255) + "." + (bArr[2] & 255) + "." + (bArr[1] & 255) + "." + (bArr[0] & 255);
            com.igexin.c.a.c.a.b(e, "i old Str: ".concat(java.lang.String.valueOf(str2)));
            return str2;
        }
        if (!com.igexin.push.config.d.ah) {
            throw new java.lang.NoSuchMethodException("can't get ad by new method");
        }
        com.igexin.c.a.c.a.b(e, "get ad by original method");
        return inetAddress.getHostAddress();
    }

    private void a(com.igexin.push.c.d dVar) {
        this.b = dVar;
    }

    private void a(boolean z) {
        this.d = z;
    }

    private com.igexin.push.c.d d() {
        return this.b;
    }

    private void e() {
        synchronized (com.igexin.push.c.i.class) {
            if (this.c != null) {
                this.a = com.igexin.b.a.a().a.submit(new com.igexin.push.c.e.AnonymousClass1());
            }
        }
    }

    private void f() {
        this.a = com.igexin.b.a.a().a.submit(new com.igexin.push.c.e.AnonymousClass1());
    }

    private void g() {
        try {
            java.util.concurrent.Future<com.igexin.push.c.d> future = this.a;
            if (future == null || future.isCancelled() || this.a.isDone()) {
                return;
            }
            this.a.cancel(true);
            this.a = null;
        } catch (java.lang.Exception e2) {
            com.igexin.c.a.c.a.a(e2);
        }
    }

    public final void a() {
        c();
        com.igexin.c.a.c.a.a("DT_DetectRunTask|stop " + c() + " task", new java.lang.Object[0]);
        g();
    }

    public final void a(com.igexin.push.c.i iVar) {
        synchronized (com.igexin.push.c.i.class) {
            this.c = iVar;
        }
    }

    public final void b() {
        a((com.igexin.push.c.i) null);
        g();
    }

    public final java.lang.String c() {
        return this.b.a() + "|" + this.b.a;
    }
}
