package com.xiaomi.push;

/* loaded from: classes19.dex */
final class t implements com.xiaomi.push.u {
    private static boolean e;
    volatile int a;
    private android.content.Context f;
    volatile java.lang.String b = null;
    volatile boolean c = false;
    private volatile java.lang.String h = null;
    final java.lang.Object d = new java.lang.Object();
    private android.content.ServiceConnection g = new com.xiaomi.push.t.a(this, (byte) 0);

    public class a implements android.content.ServiceConnection {
        private a() {
        }

        public /* synthetic */ a(com.xiaomi.push.t tVar, byte b) {
            this();
        }

        @Override // android.content.ServiceConnection
        public final void onServiceConnected(android.content.ComponentName componentName, android.os.IBinder iBinder) {
            try {
                com.xiaomi.push.t.this.b = com.xiaomi.push.t.b.a(iBinder);
                com.xiaomi.push.t.this.c = com.xiaomi.push.t.b.b(iBinder);
                com.xiaomi.push.t.a(com.xiaomi.push.t.this);
                com.xiaomi.push.t.this.a = 2;
                synchronized (com.xiaomi.push.t.this.d) {
                    try {
                        com.xiaomi.push.t.this.d.notifyAll();
                    } catch (java.lang.Exception unused) {
                    }
                }
            } catch (java.lang.Exception unused2) {
                com.xiaomi.push.t.a(com.xiaomi.push.t.this);
                com.xiaomi.push.t.this.a = 2;
                synchronized (com.xiaomi.push.t.this.d) {
                    try {
                        com.xiaomi.push.t.this.d.notifyAll();
                    } catch (java.lang.Exception unused3) {
                    }
                }
            } catch (java.lang.Throwable th) {
                com.xiaomi.push.t.a(com.xiaomi.push.t.this);
                com.xiaomi.push.t.this.a = 2;
                synchronized (com.xiaomi.push.t.this.d) {
                    try {
                        com.xiaomi.push.t.this.d.notifyAll();
                    } catch (java.lang.Exception unused4) {
                    }
                    throw th;
                }
            }
        }

        @Override // android.content.ServiceConnection
        public final void onServiceDisconnected(android.content.ComponentName componentName) {
        }
    }

    public static class b {
        public static java.lang.String a(android.os.IBinder iBinder) {
            android.os.Parcel obtain = android.os.Parcel.obtain();
            android.os.Parcel obtain2 = android.os.Parcel.obtain();
            try {
                obtain.writeInterfaceToken(com.alipay.sdk.m.c.b.a);
                iBinder.transact(1, obtain, obtain2, 0);
                obtain2.readException();
                return obtain2.readString();
            } finally {
                obtain2.recycle();
                obtain.recycle();
            }
        }

        public static boolean b(android.os.IBinder iBinder) {
            android.os.Parcel obtain = android.os.Parcel.obtain();
            android.os.Parcel obtain2 = android.os.Parcel.obtain();
            try {
                obtain.writeInterfaceToken(com.alipay.sdk.m.c.b.a);
                iBinder.transact(2, obtain, obtain2, 0);
                obtain2.readException();
                return obtain2.readInt() != 0;
            } finally {
                obtain2.recycle();
                obtain.recycle();
            }
        }
    }

    public t(android.content.Context context) {
        boolean z = false;
        this.a = 0;
        this.f = context;
        android.content.Intent intent = new android.content.Intent("com.uodis.opendevice.OPENIDS_SERVICE");
        intent.setPackage("com.huawei.hwid");
        try {
            z = this.f.bindService(intent, this.g, 1);
        } catch (java.lang.Exception unused) {
        }
        this.a = z ? 1 : 2;
    }

    public static /* synthetic */ void a(com.xiaomi.push.t tVar) {
        android.content.ServiceConnection serviceConnection = tVar.g;
        if (serviceConnection != null) {
            try {
                tVar.f.unbindService(serviceConnection);
            } catch (java.lang.Exception unused) {
            }
        }
    }

    public static boolean a(android.content.Context context) {
        boolean z;
        try {
            android.content.pm.PackageInfo packageInfo = context.getPackageManager().getPackageInfo("com.huawei.hwid", 128);
            z = (packageInfo.applicationInfo.flags & 1) != 0;
            e = packageInfo.versionCode >= 20602000;
        } catch (java.lang.Exception unused) {
        }
        return z;
    }

    @Override // com.xiaomi.push.u
    public final boolean a() {
        return e;
    }

    @Override // com.xiaomi.push.u
    public final java.lang.String b() {
        if (this.a == 1 && android.os.Looper.myLooper() != android.os.Looper.getMainLooper()) {
            synchronized (this.d) {
                try {
                    com.xiaomi.channel.commonutils.logger.b.a("huawei's getOAID wait...");
                    this.d.wait(3000L);
                } catch (java.lang.Exception unused) {
                }
            }
        }
        return this.b;
    }
}
