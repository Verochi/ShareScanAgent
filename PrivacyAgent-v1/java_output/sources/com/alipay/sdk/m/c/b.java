package com.alipay.sdk.m.c;

/* loaded from: classes.dex */
public class b implements com.alipay.sdk.m.b.b {
    public static final java.lang.String a = "com.uodis.opendevice.aidl.OpenDeviceIdentifierService";
    public static final int b = 1;
    public static final int c = 2;

    /* renamed from: com.alipay.sdk.m.c.b$b, reason: collision with other inner class name */
    public static final class ServiceConnectionC0031b implements android.content.ServiceConnection {
        public boolean a;
        public final java.util.concurrent.LinkedBlockingQueue<android.os.IBinder> b;

        public ServiceConnectionC0031b() {
            this.a = false;
            this.b = new java.util.concurrent.LinkedBlockingQueue<>();
        }

        public /* synthetic */ ServiceConnectionC0031b(com.alipay.sdk.m.c.b.a aVar) {
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

    public static final class c implements android.os.IInterface {
        public android.os.IBinder a;

        public c(android.os.IBinder iBinder) {
            this.a = iBinder;
        }

        @Override // android.os.IInterface
        public android.os.IBinder asBinder() {
            return this.a;
        }

        public java.lang.String d() throws android.os.RemoteException {
            android.os.Parcel obtain = android.os.Parcel.obtain();
            android.os.Parcel obtain2 = android.os.Parcel.obtain();
            try {
                obtain.writeInterfaceToken(com.alipay.sdk.m.c.b.a);
                this.a.transact(1, obtain, obtain2, 0);
                obtain2.readException();
                return obtain2.readString();
            } finally {
                obtain2.recycle();
                obtain.recycle();
            }
        }

        public boolean e() throws android.os.RemoteException {
            android.os.Parcel obtain = android.os.Parcel.obtain();
            android.os.Parcel obtain2 = android.os.Parcel.obtain();
            try {
                obtain.writeInterfaceToken(com.alipay.sdk.m.c.b.a);
                this.a.transact(2, obtain, obtain2, 0);
                obtain2.readException();
                return obtain2.readInt() != 0;
            } finally {
                obtain2.recycle();
                obtain.recycle();
            }
        }
    }

    @Override // com.alipay.sdk.m.b.b
    public java.lang.String a(android.content.Context context) {
        com.alipay.sdk.m.c.b.ServiceConnectionC0031b serviceConnectionC0031b = new com.alipay.sdk.m.c.b.ServiceConnectionC0031b(null);
        android.content.Intent intent = new android.content.Intent("com.uodis.opendevice.OPENIDS_SERVICE");
        intent.setPackage("com.huawei.hwid");
        if (context.bindService(intent, serviceConnectionC0031b, 1)) {
            try {
                return new com.alipay.sdk.m.c.b.c(serviceConnectionC0031b.a()).d();
            } catch (java.lang.Exception unused) {
            } finally {
                context.unbindService(serviceConnectionC0031b);
            }
        }
        return null;
    }
}
