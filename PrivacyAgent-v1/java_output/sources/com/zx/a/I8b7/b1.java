package com.zx.a.I8b7;

/* loaded from: classes19.dex */
public class b1 {
    public static final com.zx.a.I8b7.b1.a a;
    public static volatile com.zx.a.I8b7.b1 b;
    public static android.content.Context c;
    public static boolean d;

    public interface a {
    }

    public static class b implements com.zx.a.I8b7.b1.a {
        public java.lang.String a;
        public final java.lang.String e;
        public final java.lang.String g;
        public final java.lang.String h;
        public com.zx.a.I8b7.b1.d i;
        public boolean b = false;
        public boolean c = false;
        public final java.util.concurrent.CountDownLatch d = new java.util.concurrent.CountDownLatch(1);
        public final java.lang.String f = null;

        public b(java.lang.String str, java.lang.String str2, java.lang.String str3, java.lang.String str4) {
            this.e = str;
            this.g = str3;
            this.h = str4;
        }
    }

    public static class c implements android.os.IInterface {
        public android.os.IBinder a;

        public c(android.os.IBinder iBinder, java.lang.String str) {
            this.a = iBinder;
        }

        @Override // android.os.IInterface
        public android.os.IBinder asBinder() {
            return this.a;
        }
    }

    public static class d implements android.content.ServiceConnection {
        public com.zx.a.I8b7.b1.c a;
        public java.lang.String b;
        public java.util.concurrent.CountDownLatch c;
        public android.os.IBinder d;

        public d(java.lang.String str, java.util.concurrent.CountDownLatch countDownLatch) {
            this.b = str;
            this.c = countDownLatch;
        }

        public boolean a(android.content.Context context, android.content.Intent intent) {
            com.zx.a.I8b7.b1.c cVar;
            if (this.a != null) {
                return true;
            }
            try {
                boolean bindService = context.bindService(intent, this, 1);
                this.c.await(1L, java.util.concurrent.TimeUnit.SECONDS);
                android.os.IBinder iBinder = this.d;
                java.lang.String str = this.b;
                if (iBinder == null) {
                    cVar = null;
                } else {
                    android.os.IInterface queryLocalInterface = iBinder.queryLocalInterface(str);
                    cVar = queryLocalInterface instanceof com.zx.a.I8b7.b1.c ? (com.zx.a.I8b7.b1.c) queryLocalInterface : new com.zx.a.I8b7.b1.c(iBinder, str);
                }
                this.a = cVar;
                return bindService;
            } catch (java.lang.Throwable unused) {
                return false;
            }
        }

        @Override // android.content.ServiceConnection
        public void onServiceConnected(android.content.ComponentName componentName, android.os.IBinder iBinder) {
            try {
                this.d = iBinder;
                this.c.countDown();
            } catch (java.lang.Throwable unused) {
            }
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(android.content.ComponentName componentName) {
            this.a = null;
            this.d = null;
        }
    }

    public static class e extends com.zx.a.I8b7.b1.b {
        public final java.util.concurrent.CountDownLatch j;

        public class a extends com.zx.a.I8b7.b1.e.b {
            public a() {
            }
        }

        public static abstract class b extends android.os.Binder implements android.os.IInterface {
            public b() {
                attachInterface(this, "com.hihonor.cloudservice.oaid.IOAIDCallBack");
            }

            @Override // android.os.IInterface
            public android.os.IBinder asBinder() {
                return this;
            }

            @Override // android.os.Binder
            public boolean onTransact(int i, android.os.Parcel parcel, android.os.Parcel parcel2, int i2) throws android.os.RemoteException {
                if (i != 2) {
                    if (i != 1598968902) {
                        return super.onTransact(i, parcel, parcel2, i2);
                    }
                    parcel2.writeString("com.hihonor.cloudservice.oaid.IOAIDCallBack");
                    return true;
                }
                parcel.enforceInterface("com.hihonor.cloudservice.oaid.IOAIDCallBack");
                int readInt = parcel.readInt();
                android.os.Bundle bundle = parcel.readInt() != 0 ? (android.os.Bundle) android.os.Bundle.CREATOR.createFromParcel(parcel) : null;
                com.zx.a.I8b7.b1.e.a aVar = (com.zx.a.I8b7.b1.e.a) this;
                if (readInt == 0 && bundle != null) {
                    com.zx.a.I8b7.b1.e.this.a = bundle.getString("oa_id_flag");
                }
                com.zx.a.I8b7.b1.e.this.j.countDown();
                parcel2.writeNoException();
                return true;
            }
        }

        public e() {
            super("com.hihonor.id", null, "com.hihonor.id.HnOaIdService", "com.hihonor.cloudservice.oaid.IOAIDService");
            this.j = new java.util.concurrent.CountDownLatch(1);
        }

        public java.lang.String a(android.content.Context context) {
            com.zx.a.I8b7.b1.d dVar;
            com.zx.a.I8b7.b1.d dVar2;
            if (!android.text.TextUtils.isEmpty(this.a) || (dVar = this.i) == null || dVar.a == null) {
                return this.a;
            }
            try {
                android.os.IBinder iBinder = dVar.d;
                com.zx.a.I8b7.b1.e.a aVar = new com.zx.a.I8b7.b1.e.a();
                android.os.Parcel obtain = android.os.Parcel.obtain();
                android.os.Parcel obtain2 = android.os.Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.hihonor.cloudservice.oaid.IOAIDService");
                    obtain.writeStrongBinder(aVar);
                    iBinder.transact(2, obtain, obtain2, 0);
                    obtain2.readException();
                    obtain2.recycle();
                    obtain.recycle();
                    this.j.await(1L, java.util.concurrent.TimeUnit.SECONDS);
                    if (!android.text.TextUtils.isEmpty(this.a) && (dVar2 = this.i) != null) {
                        context.unbindService(dVar2);
                    }
                } catch (java.lang.Throwable th) {
                    obtain2.recycle();
                    obtain.recycle();
                    throw th;
                }
            } catch (java.lang.Throwable unused) {
            }
            return this.a;
        }
    }

    static {
        java.lang.String upperCase = android.os.Build.MANUFACTURER.toUpperCase();
        upperCase.getClass();
        a = !upperCase.equals("HONOR") ? null : new com.zx.a.I8b7.b1.e();
    }

    public final boolean a() {
        com.zx.a.I8b7.b1.a aVar;
        long longVersionCode;
        try {
            if (c == null || (aVar = a) == null) {
                return false;
            }
            com.zx.a.I8b7.b1.b bVar = (com.zx.a.I8b7.b1.b) aVar;
            if (!bVar.c) {
                if (android.text.TextUtils.isEmpty(bVar.e)) {
                    bVar.b = false;
                } else {
                    android.content.pm.PackageInfo a2 = com.zx.a.I8b7.i3.a(bVar.e, 0);
                    if (android.os.Build.VERSION.SDK_INT >= 28) {
                        longVersionCode = a2.getLongVersionCode();
                        return longVersionCode >= 1;
                    }
                    bVar.b = a2.versionCode > 0;
                }
                bVar.c = true;
            }
            return bVar.b;
        } catch (java.lang.Throwable unused) {
            return false;
        }
    }
}
