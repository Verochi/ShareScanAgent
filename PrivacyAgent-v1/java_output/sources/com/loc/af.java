package com.loc;

/* loaded from: classes23.dex */
public final class af {

    public static final class a {
        private final java.lang.String a;
        private final boolean b;

        public a(java.lang.String str, boolean z) {
            this.a = str;
            this.b = z;
        }

        public final boolean a() {
            return this.b;
        }
    }

    public static final class b implements android.content.ServiceConnection {
        boolean a;
        private final java.util.concurrent.LinkedBlockingQueue<android.os.IBinder> b;

        private b() {
            this.a = false;
            this.b = new java.util.concurrent.LinkedBlockingQueue<>(1);
        }

        public /* synthetic */ b(byte b) {
            this();
        }

        public final android.os.IBinder a() throws java.lang.InterruptedException {
            if (this.a) {
                throw new java.lang.IllegalStateException();
            }
            this.a = true;
            return this.b.take();
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

        public final java.lang.String a() throws android.os.RemoteException {
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

        public final boolean b() throws android.os.RemoteException {
            android.os.Parcel obtain = android.os.Parcel.obtain();
            android.os.Parcel obtain2 = android.os.Parcel.obtain();
            try {
                obtain.writeInterfaceToken("com.google.android.gms.ads.identifier.internal.IAdvertisingIdService");
                obtain.writeInt(1);
                this.a.transact(2, obtain, obtain2, 0);
                obtain2.readException();
                return obtain2.readInt() != 0;
            } finally {
                obtain2.recycle();
                obtain.recycle();
            }
        }
    }

    public static java.lang.String a(android.content.Context context) {
        try {
            com.loc.af.a b2 = b(context);
            if (b2 != null && !b2.a()) {
                return b2.a;
            }
        } catch (java.lang.Throwable unused) {
        }
        return null;
    }

    private static com.loc.af.a b(android.content.Context context) throws java.lang.Exception {
        if (android.os.Looper.myLooper() == android.os.Looper.getMainLooper()) {
            return null;
        }
        try {
            context.getPackageManager().getPackageInfo("com.android.vending", 0);
            com.loc.af.b bVar = new com.loc.af.b((byte) 0);
            android.content.Intent intent = new android.content.Intent("com.google.android.gms.ads.identifier.service.START");
            intent.setPackage("com.google.android.gms");
            if (!context.bindService(intent, bVar, 1)) {
                throw new java.io.IOException("Google Play connection failed");
            }
            try {
                try {
                    com.loc.af.c cVar = new com.loc.af.c(bVar.a());
                    boolean b2 = cVar.b();
                    return new com.loc.af.a(b2 ? "" : cVar.a(), b2);
                } catch (java.lang.Exception e) {
                    throw e;
                }
            } finally {
                context.unbindService(bVar);
            }
        } catch (java.lang.Exception e2) {
            throw e2;
        }
    }
}
