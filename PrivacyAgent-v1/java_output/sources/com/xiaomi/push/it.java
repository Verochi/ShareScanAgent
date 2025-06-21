package com.xiaomi.push;

/* loaded from: classes19.dex */
final class it {

    public static final class a {
        final java.lang.String a;
        private final boolean b = false;

        public a(java.lang.String str) {
            this.a = str;
        }
    }

    public static final class b implements android.content.ServiceConnection {
        boolean a;
        final java.util.concurrent.LinkedBlockingQueue<android.os.IBinder> b;

        private b() {
            this.a = false;
            this.b = new java.util.concurrent.LinkedBlockingQueue<>(1);
        }

        public /* synthetic */ b(byte b) {
            this();
        }

        @Override // android.content.ServiceConnection
        public final void onServiceConnected(android.content.ComponentName componentName, android.os.IBinder iBinder) {
            try {
                this.b.put(iBinder);
            } catch (java.lang.InterruptedException unused) {
            }
        }

        @Override // android.content.ServiceConnection
        public final void onServiceDisconnected(android.content.ComponentName componentName) {
        }
    }

    public static final class c implements android.os.IInterface {
        private android.os.IBinder a;

        public c(android.os.IBinder iBinder) {
            this.a = iBinder;
        }

        public final java.lang.String a() {
            android.os.Parcel obtain = android.os.Parcel.obtain();
            android.os.Parcel obtain2 = android.os.Parcel.obtain();
            try {
                obtain.writeInterfaceToken("com.google.android.gms.ads.identifier.internal.IAdvertisingIdService");
                this.a.transact(1, obtain, obtain2, 0);
                obtain2.readException();
                return obtain2.readString();
            } finally {
                obtain2.recycle();
                obtain.recycle();
            }
        }

        @Override // android.os.IInterface
        public final android.os.IBinder asBinder() {
            return this.a;
        }
    }

    public static com.xiaomi.push.it.a a(android.content.Context context) {
        if (android.os.Looper.myLooper() == android.os.Looper.getMainLooper()) {
            throw new java.lang.IllegalStateException("Cannot be called from the main thread");
        }
        try {
            context.getPackageManager().getPackageInfo("com.android.vending", 0);
            com.xiaomi.push.it.b bVar = new com.xiaomi.push.it.b((byte) 0);
            android.content.Intent intent = new android.content.Intent("com.google.android.gms.ads.identifier.service.START");
            intent.setPackage("com.google.android.gms");
            try {
                if (context.bindService(intent, bVar, 1)) {
                    try {
                        if (bVar.a) {
                            throw new java.lang.IllegalStateException();
                        }
                        bVar.a = true;
                        android.os.IBinder poll = bVar.b.poll(30000L, java.util.concurrent.TimeUnit.MILLISECONDS);
                        if (poll != null) {
                            return new com.xiaomi.push.it.a(new com.xiaomi.push.it.c(poll).a());
                        }
                    } catch (java.lang.Exception e) {
                        throw e;
                    }
                }
                throw new java.io.IOException("Google Play connection failed");
            } finally {
                context.unbindService(bVar);
            }
        } catch (java.lang.Exception e2) {
            throw e2;
        }
    }
}
