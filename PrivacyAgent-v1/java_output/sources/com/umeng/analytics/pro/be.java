package com.umeng.analytics.pro;

/* loaded from: classes19.dex */
class be implements com.umeng.analytics.pro.az {
    private static final java.lang.String a = "com.uodis.opendevice.aidl.OpenDeviceIdentifierService";
    private static final int b = 1;
    private static final int c = 2;

    public static final class a implements android.content.ServiceConnection {
        boolean a;
        private final java.util.concurrent.LinkedBlockingQueue<android.os.IBinder> b;

        private a() {
            this.a = false;
            this.b = new java.util.concurrent.LinkedBlockingQueue<>();
        }

        public /* synthetic */ a(com.umeng.analytics.pro.be.AnonymousClass1 anonymousClass1) {
            this();
        }

        public android.os.IBinder a() throws java.lang.InterruptedException {
            if (this.a) {
                throw new java.lang.IllegalStateException();
            }
            this.a = true;
            return this.b.poll(5L, java.util.concurrent.TimeUnit.SECONDS);
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

    public static final class b implements android.os.IInterface {
        private android.os.IBinder a;

        public b(android.os.IBinder iBinder) {
            this.a = iBinder;
        }

        public java.lang.String a() throws android.os.RemoteException {
            android.os.Parcel obtain = android.os.Parcel.obtain();
            android.os.Parcel obtain2 = android.os.Parcel.obtain();
            try {
                obtain.writeInterfaceToken("com.uodis.opendevice.aidl.OpenDeviceIdentifierService");
                this.a.transact(1, obtain, obtain2, 0);
                obtain2.readException();
                return obtain2.readString();
            } finally {
                obtain2.recycle();
                obtain.recycle();
            }
        }

        @Override // android.os.IInterface
        public android.os.IBinder asBinder() {
            return this.a;
        }

        public boolean b() throws android.os.RemoteException {
            android.os.Parcel obtain = android.os.Parcel.obtain();
            android.os.Parcel obtain2 = android.os.Parcel.obtain();
            try {
                obtain.writeInterfaceToken("com.uodis.opendevice.aidl.OpenDeviceIdentifierService");
                this.a.transact(2, obtain, obtain2, 0);
                obtain2.readException();
                return obtain2.readInt() != 0;
            } finally {
                obtain2.recycle();
                obtain.recycle();
            }
        }
    }

    @Override // com.umeng.analytics.pro.az
    public java.lang.String a(android.content.Context context) {
        com.umeng.analytics.pro.be.a aVar = new com.umeng.analytics.pro.be.a(null);
        android.content.Intent intent = new android.content.Intent("com.uodis.opendevice.OPENIDS_SERVICE");
        intent.setPackage("com.huawei.hwid");
        if (context.bindService(intent, aVar, 1)) {
            try {
                return new com.umeng.analytics.pro.be.b(aVar.a()).a();
            } catch (java.lang.Exception unused) {
            } finally {
                context.unbindService(aVar);
            }
        }
        return null;
    }
}
