package com.anythink.china.a.a;

/* loaded from: classes12.dex */
public final class h {
    private static final java.lang.String a = "OaidAidlUtil";
    private static final java.lang.String b = "com.huawei.hwid";
    private static final java.lang.String c = "com.uodis.opendevice.OPENIDS_SERVICE";
    private android.content.Context d;
    private android.content.ServiceConnection e;
    private com.anythink.china.a.a.g f;
    private com.anythink.china.a.a g;

    public final class a implements android.content.ServiceConnection {
        private a() {
        }

        public /* synthetic */ a(com.anythink.china.a.a.h hVar, byte b) {
            this();
        }

        @Override // android.content.ServiceConnection
        public final void onServiceConnected(android.content.ComponentName componentName, android.os.IBinder iBinder) {
            com.anythink.china.a.a.h.this.f = com.anythink.china.a.a.g.a.a(iBinder);
            try {
                if (com.anythink.china.a.a.h.this.f != null) {
                    try {
                        if (com.anythink.china.a.a.h.this.g != null) {
                            com.anythink.china.a.a.h.this.g.a(com.anythink.china.a.a.h.this.f.a(), com.anythink.china.a.a.h.this.f.b());
                        }
                    } catch (android.os.RemoteException e) {
                        if (com.anythink.china.a.a.h.this.g != null) {
                            com.anythink.china.a.a aVar = com.anythink.china.a.a.h.this.g;
                            e.getMessage();
                            aVar.a();
                        }
                    } catch (java.lang.Exception e2) {
                        if (com.anythink.china.a.a.h.this.g != null) {
                            com.anythink.china.a.a aVar2 = com.anythink.china.a.a.h.this.g;
                            e2.getMessage();
                            aVar2.a();
                        }
                    }
                }
            } finally {
                com.anythink.china.a.a.h.c(com.anythink.china.a.a.h.this);
            }
        }

        @Override // android.content.ServiceConnection
        public final void onServiceDisconnected(android.content.ComponentName componentName) {
            com.anythink.china.a.a.h.this.f = null;
        }
    }

    public h(android.content.Context context) {
        this.d = context;
    }

    private boolean a() {
        if (this.d == null) {
            return false;
        }
        this.e = new com.anythink.china.a.a.h.a(this, (byte) 0);
        android.content.Intent intent = new android.content.Intent(c);
        intent.setPackage("com.huawei.hwid");
        return this.d.bindService(intent, this.e, 1);
    }

    private void b() {
        android.content.ServiceConnection serviceConnection;
        android.content.Context context = this.d;
        if (context == null || (serviceConnection = this.e) == null) {
            return;
        }
        try {
            context.unbindService(serviceConnection);
        } catch (java.lang.Throwable unused) {
        }
        this.f = null;
        this.d = null;
        this.g = null;
    }

    public static /* synthetic */ void c(com.anythink.china.a.a.h hVar) {
        android.content.ServiceConnection serviceConnection;
        android.content.Context context = hVar.d;
        if (context == null || (serviceConnection = hVar.e) == null) {
            return;
        }
        try {
            context.unbindService(serviceConnection);
        } catch (java.lang.Throwable unused) {
        }
        hVar.f = null;
        hVar.d = null;
        hVar.g = null;
    }

    public final void a(com.anythink.china.a.a aVar) {
        this.g = aVar;
        if (this.d != null) {
            this.e = new com.anythink.china.a.a.h.a(this, (byte) 0);
            android.content.Intent intent = new android.content.Intent(c);
            intent.setPackage("com.huawei.hwid");
            this.d.bindService(intent, this.e, 1);
        }
    }
}
