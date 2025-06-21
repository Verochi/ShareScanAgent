package com.anythink.core.common.b;

/* loaded from: classes12.dex */
public final class d {

    public final class a {
        private final java.lang.String b;
        private final boolean c;

        public a(java.lang.String str, boolean z) {
            this.b = str;
            this.c = z;
        }

        private boolean b() {
            return this.c;
        }

        public final java.lang.String a() {
            return this.b;
        }
    }

    public final class b implements android.content.ServiceConnection {
        boolean a;
        private final java.util.concurrent.LinkedBlockingQueue<android.os.IBinder> c;

        private b() {
            this.a = false;
            this.c = new java.util.concurrent.LinkedBlockingQueue<>(1);
        }

        public /* synthetic */ b(com.anythink.core.common.b.d dVar, byte b) {
            this();
        }

        public final android.os.IBinder a() {
            if (this.a) {
                throw new java.lang.IllegalStateException();
            }
            this.a = true;
            return this.c.take();
        }

        @Override // android.content.ServiceConnection
        public final void onServiceConnected(android.content.ComponentName componentName, android.os.IBinder iBinder) {
            try {
                this.c.put(iBinder);
            } catch (java.lang.InterruptedException unused) {
            }
        }

        @Override // android.content.ServiceConnection
        public final void onServiceDisconnected(android.content.ComponentName componentName) {
        }
    }

    public final class c implements android.os.IInterface {
        private android.os.IBinder b;

        public c(android.os.IBinder iBinder) {
            this.b = iBinder;
        }

        public final java.lang.String a() {
            android.os.Parcel obtain = android.os.Parcel.obtain();
            android.os.Parcel obtain2 = android.os.Parcel.obtain();
            try {
                obtain.writeInterfaceToken("com.google.android.gms.ads.identifier.internal.IAdvertisingIdService");
                this.b.transact(1, obtain, obtain2, 0);
                obtain2.readException();
                return obtain2.readString();
            } finally {
                obtain2.recycle();
                obtain.recycle();
            }
        }

        @Override // android.os.IInterface
        public final android.os.IBinder asBinder() {
            return this.b;
        }

        public final boolean b() {
            android.os.Parcel obtain = android.os.Parcel.obtain();
            android.os.Parcel obtain2 = android.os.Parcel.obtain();
            try {
                obtain.writeInterfaceToken("com.google.android.gms.ads.identifier.internal.IAdvertisingIdService");
                obtain.writeInt(1);
                this.b.transact(2, obtain, obtain2, 0);
                obtain2.readException();
                return obtain2.readInt() != 0;
            } finally {
                obtain2.recycle();
                obtain.recycle();
            }
        }
    }

    public final com.anythink.core.common.b.d.a a(android.content.Context context) {
        if (android.os.Looper.myLooper() == android.os.Looper.getMainLooper()) {
            throw new java.lang.IllegalStateException("Cannot be called from the main thread");
        }
        try {
            context.getPackageManager().getPackageInfo("com.android.vending", 0);
            com.anythink.core.common.b.d.b bVar = new com.anythink.core.common.b.d.b(this, (byte) 0);
            android.content.Intent intent = new android.content.Intent("com.google.android.gms.ads.identifier.service.START");
            intent.setPackage("com.google.android.gms");
            java.util.List<android.content.pm.ResolveInfo> queryIntentServices = context.getPackageManager().queryIntentServices(intent, 0);
            if (queryIntentServices == null || queryIntentServices.size() <= 0 || !context.bindService(intent, bVar, 1)) {
                throw new java.io.IOException("Google Play connection failed");
            }
            try {
                com.anythink.core.common.b.d.c cVar = new com.anythink.core.common.b.d.c(bVar.a());
                return new com.anythink.core.common.b.d.a(cVar.a(), cVar.b());
            } finally {
            }
        } catch (java.lang.Exception e) {
            throw e;
        }
    }
}
