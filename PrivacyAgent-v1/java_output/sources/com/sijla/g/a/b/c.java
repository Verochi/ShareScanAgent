package com.sijla.g.a.b;

/* loaded from: classes19.dex */
public interface c extends android.os.IInterface {

    public static abstract class a extends android.os.Binder implements com.sijla.g.a.b.c {

        /* renamed from: com.sijla.g.a.b.c$a$a, reason: collision with other inner class name */
        public static class C0450a implements com.sijla.g.a.b.c {
            private android.os.IBinder a;

            public C0450a(android.os.IBinder iBinder) {
                this.a = iBinder;
            }

            @Override // com.sijla.g.a.b.c
            public final java.lang.String a() {
                android.os.Parcel obtain = android.os.Parcel.obtain();
                android.os.Parcel obtain2 = android.os.Parcel.obtain();
                try {
                    try {
                        obtain.writeInterfaceToken(com.alipay.sdk.m.q0.a.AbstractBinderC0040a.a);
                        this.a.transact(1, obtain, obtain2, 0);
                        obtain2.readException();
                        return obtain2.readString();
                    } catch (java.lang.Exception e) {
                        e.printStackTrace();
                        obtain2.recycle();
                        obtain.recycle();
                        return null;
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // android.os.IInterface
            public final android.os.IBinder asBinder() {
                return null;
            }

            @Override // com.sijla.g.a.b.c
            public final java.lang.String b() {
                android.os.Parcel obtain = android.os.Parcel.obtain();
                android.os.Parcel obtain2 = android.os.Parcel.obtain();
                try {
                    try {
                        obtain.writeInterfaceToken(com.alipay.sdk.m.q0.a.AbstractBinderC0040a.a);
                        this.a.transact(4, obtain, obtain2, 0);
                        obtain2.readException();
                        return obtain2.readString();
                    } catch (java.lang.Exception e) {
                        e.printStackTrace();
                        obtain2.recycle();
                        obtain.recycle();
                        return null;
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.sijla.g.a.b.c
            public final java.lang.String c() {
                android.os.Parcel obtain = android.os.Parcel.obtain();
                android.os.Parcel obtain2 = android.os.Parcel.obtain();
                try {
                    try {
                        obtain.writeInterfaceToken(com.alipay.sdk.m.q0.a.AbstractBinderC0040a.a);
                        this.a.transact(2, obtain, obtain2, 0);
                        obtain2.readException();
                        return obtain2.readString();
                    } catch (java.lang.Exception e) {
                        e.printStackTrace();
                        obtain2.recycle();
                        obtain.recycle();
                        return null;
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.sijla.g.a.b.c
            public final java.lang.String d() {
                android.os.Parcel obtain = android.os.Parcel.obtain();
                android.os.Parcel obtain2 = android.os.Parcel.obtain();
                try {
                    try {
                        obtain.writeInterfaceToken(com.alipay.sdk.m.q0.a.AbstractBinderC0040a.a);
                        this.a.transact(5, obtain, obtain2, 0);
                        obtain2.readException();
                        return obtain2.readString();
                    } catch (java.lang.Exception e) {
                        e.printStackTrace();
                        obtain2.recycle();
                        obtain.recycle();
                        return null;
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.sijla.g.a.b.c
            public final boolean e() {
                android.os.Parcel obtain = android.os.Parcel.obtain();
                android.os.Parcel obtain2 = android.os.Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(com.alipay.sdk.m.q0.a.AbstractBinderC0040a.a);
                    this.a.transact(3, obtain, obtain2, 0);
                    obtain2.readException();
                    r2 = obtain2.readInt() != 0;
                    obtain2.recycle();
                    obtain.recycle();
                } catch (java.lang.Throwable unused) {
                    obtain2.recycle();
                    obtain.recycle();
                }
                return r2;
            }
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, android.os.Parcel parcel, android.os.Parcel parcel2, int i2) {
            java.lang.String a;
            if (i == 1) {
                parcel.enforceInterface(com.alipay.sdk.m.q0.a.AbstractBinderC0040a.a);
                a = a();
            } else if (i == 2) {
                parcel.enforceInterface(com.alipay.sdk.m.q0.a.AbstractBinderC0040a.a);
                a = c();
            } else {
                if (i == 3) {
                    parcel.enforceInterface(com.alipay.sdk.m.q0.a.AbstractBinderC0040a.a);
                    boolean e = e();
                    parcel2.writeNoException();
                    parcel2.writeInt(e ? 1 : 0);
                    return true;
                }
                if (i == 4) {
                    parcel.enforceInterface(com.alipay.sdk.m.q0.a.AbstractBinderC0040a.a);
                    parcel.readString();
                    a = b();
                } else {
                    if (i != 5) {
                        if (i != 1598968902) {
                            return super.onTransact(i, parcel, parcel2, i2);
                        }
                        parcel2.writeString(com.alipay.sdk.m.q0.a.AbstractBinderC0040a.a);
                        return true;
                    }
                    parcel.enforceInterface(com.alipay.sdk.m.q0.a.AbstractBinderC0040a.a);
                    parcel.readString();
                    a = d();
                }
            }
            parcel2.writeNoException();
            parcel2.writeString(a);
            return true;
        }
    }

    java.lang.String a();

    java.lang.String b();

    java.lang.String c();

    java.lang.String d();

    boolean e();
}
