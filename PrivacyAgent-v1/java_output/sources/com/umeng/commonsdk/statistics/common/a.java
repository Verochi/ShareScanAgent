package com.umeng.commonsdk.statistics.common;

/* loaded from: classes19.dex */
public class a {

    /* renamed from: com.umeng.commonsdk.statistics.common.a$a, reason: collision with other inner class name */
    public static final class C0521a {
        private final java.lang.String a;
        private final boolean b;

        public C0521a(java.lang.String str, boolean z) {
            this.a = str;
            this.b = z;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public java.lang.String b() {
            return this.a;
        }

        public boolean a() {
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

        public /* synthetic */ b(com.umeng.commonsdk.statistics.common.a.AnonymousClass1 anonymousClass1) {
            this();
        }

        public android.os.IBinder a() throws java.lang.InterruptedException {
            if (this.a) {
                throw new java.lang.IllegalStateException();
            }
            this.a = true;
            return this.b.take();
        }

        @Override // android.content.ServiceConnection
        public void onServiceConnected(android.content.ComponentName componentName, android.os.IBinder iBinder) {
            try {
                this.b.put(iBinder);
            } catch (java.lang.InterruptedException unused) {
            }
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(android.content.ComponentName componentName) {
        }
    }

    public static final class c implements android.os.IInterface {
        private android.os.IBinder a;

        public c(android.os.IBinder iBinder) {
            this.a = iBinder;
        }

        public java.lang.String a() throws android.os.RemoteException {
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

        public boolean a(boolean z) throws android.os.RemoteException {
            android.os.Parcel obtain = android.os.Parcel.obtain();
            android.os.Parcel obtain2 = android.os.Parcel.obtain();
            try {
                obtain.writeInterfaceToken("com.google.android.gms.ads.identifier.internal.IAdvertisingIdService");
                obtain.writeInt(z ? 1 : 0);
                this.a.transact(2, obtain, obtain2, 0);
                obtain2.readException();
                return obtain2.readInt() != 0;
            } finally {
                obtain2.recycle();
                obtain.recycle();
            }
        }

        @Override // android.os.IInterface
        public android.os.IBinder asBinder() {
            return this.a;
        }
    }

    public static java.lang.String a(android.content.Context context) {
        try {
            com.umeng.commonsdk.statistics.common.a.C0521a c2 = c(context);
            if (c2 != null && !c2.a()) {
                return c2.b();
            }
        } catch (java.lang.Exception unused) {
        }
        return null;
    }

    public static java.lang.String b(android.content.Context context) {
        try {
            com.umeng.commonsdk.statistics.common.a.C0521a c2 = c(context);
            if (c2 == null) {
                return null;
            }
            return c2.b();
        } catch (java.lang.Exception unused) {
            return null;
        }
    }

    private static com.umeng.commonsdk.statistics.common.a.C0521a c(android.content.Context context) throws java.lang.Exception {
        if (android.os.Looper.myLooper() == android.os.Looper.getMainLooper()) {
            return null;
        }
        try {
            if (com.umeng.commonsdk.utils.b.a().a(context, "com.android.vending", 0) == null) {
                return null;
            }
            com.umeng.commonsdk.statistics.common.a.b bVar = new com.umeng.commonsdk.statistics.common.a.b(null);
            android.content.Intent intent = new android.content.Intent("com.google.android.gms.ads.identifier.service.START");
            intent.setPackage("com.google.android.gms");
            try {
                if (!context.bindService(intent, bVar, 1)) {
                    throw new java.io.IOException("Google Play connection failed");
                }
                try {
                    com.umeng.commonsdk.statistics.common.a.c cVar = new com.umeng.commonsdk.statistics.common.a.c(bVar.a());
                    boolean a = cVar.a(true);
                    return new com.umeng.commonsdk.statistics.common.a.C0521a(a ? "" : cVar.a(), a);
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
