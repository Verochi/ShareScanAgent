package com.alipay.sdk.m.q0;

/* loaded from: classes.dex */
public interface a extends android.os.IInterface {

    /* renamed from: com.alipay.sdk.m.q0.a$a, reason: collision with other inner class name */
    public static abstract class AbstractBinderC0040a extends android.os.Binder implements com.alipay.sdk.m.q0.a {
        public static final java.lang.String a = "com.zui.deviceidservice.IDeviceidInterface";
        public static final int b = 1;
        public static final int c = 2;
        public static final int d = 3;
        public static final int e = 4;
        public static final int f = 5;
        public static final int g = 6;

        /* renamed from: com.alipay.sdk.m.q0.a$a$a, reason: collision with other inner class name */
        public static class C0041a implements com.alipay.sdk.m.q0.a {
            public android.os.IBinder a;

            public C0041a(android.os.IBinder iBinder) {
                this.a = iBinder;
            }

            @Override // com.alipay.sdk.m.q0.a
            public java.lang.String a() throws android.os.RemoteException {
                android.os.Parcel obtain = android.os.Parcel.obtain();
                android.os.Parcel obtain2 = android.os.Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(com.alipay.sdk.m.q0.a.AbstractBinderC0040a.a);
                    this.a.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readString();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.alipay.sdk.m.q0.a
            public java.lang.String a(java.lang.String str) throws android.os.RemoteException {
                android.os.Parcel obtain = android.os.Parcel.obtain();
                android.os.Parcel obtain2 = android.os.Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(com.alipay.sdk.m.q0.a.AbstractBinderC0040a.a);
                    obtain.writeString(str);
                    this.a.transact(5, obtain, obtain2, 0);
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

            @Override // com.alipay.sdk.m.q0.a
            public java.lang.String b() throws android.os.RemoteException {
                android.os.Parcel obtain = android.os.Parcel.obtain();
                android.os.Parcel obtain2 = android.os.Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(com.alipay.sdk.m.q0.a.AbstractBinderC0040a.a);
                    this.a.transact(2, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readString();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.alipay.sdk.m.q0.a
            public java.lang.String b(java.lang.String str) throws android.os.RemoteException {
                android.os.Parcel obtain = android.os.Parcel.obtain();
                android.os.Parcel obtain2 = android.os.Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(com.alipay.sdk.m.q0.a.AbstractBinderC0040a.a);
                    obtain.writeString(str);
                    this.a.transact(4, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readString();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.alipay.sdk.m.q0.a
            public boolean c() throws android.os.RemoteException {
                android.os.Parcel obtain = android.os.Parcel.obtain();
                android.os.Parcel obtain2 = android.os.Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(com.alipay.sdk.m.q0.a.AbstractBinderC0040a.a);
                    this.a.transact(3, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt() != 0;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.alipay.sdk.m.q0.a
            public boolean c(java.lang.String str) throws android.os.RemoteException {
                android.os.Parcel obtain = android.os.Parcel.obtain();
                android.os.Parcel obtain2 = android.os.Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(com.alipay.sdk.m.q0.a.AbstractBinderC0040a.a);
                    obtain.writeString(str);
                    this.a.transact(6, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt() != 0;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public java.lang.String d() {
                return com.alipay.sdk.m.q0.a.AbstractBinderC0040a.a;
            }
        }

        public AbstractBinderC0040a() {
            attachInterface(this, a);
        }

        public static com.alipay.sdk.m.q0.a a(android.os.IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            android.os.IInterface queryLocalInterface = iBinder.queryLocalInterface(a);
            return (queryLocalInterface == null || !(queryLocalInterface instanceof com.alipay.sdk.m.q0.a)) ? new com.alipay.sdk.m.q0.a.AbstractBinderC0040a.C0041a(iBinder) : (com.alipay.sdk.m.q0.a) queryLocalInterface;
        }

        @Override // android.os.IInterface
        public android.os.IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, android.os.Parcel parcel, android.os.Parcel parcel2, int i2) throws android.os.RemoteException {
            if (i == 1598968902) {
                parcel2.writeString(a);
                return true;
            }
            switch (i) {
                case 1:
                    parcel.enforceInterface(a);
                    java.lang.String a2 = a();
                    parcel2.writeNoException();
                    parcel2.writeString(a2);
                    return true;
                case 2:
                    parcel.enforceInterface(a);
                    java.lang.String b2 = b();
                    parcel2.writeNoException();
                    parcel2.writeString(b2);
                    return true;
                case 3:
                    parcel.enforceInterface(a);
                    boolean c2 = c();
                    parcel2.writeNoException();
                    parcel2.writeInt(c2 ? 1 : 0);
                    return true;
                case 4:
                    parcel.enforceInterface(a);
                    java.lang.String b3 = b(parcel.readString());
                    parcel2.writeNoException();
                    parcel2.writeString(b3);
                    return true;
                case 5:
                    parcel.enforceInterface(a);
                    java.lang.String a3 = a(parcel.readString());
                    parcel2.writeNoException();
                    parcel2.writeString(a3);
                    return true;
                case 6:
                    parcel.enforceInterface(a);
                    boolean c3 = c(parcel.readString());
                    parcel2.writeNoException();
                    parcel2.writeInt(c3 ? 1 : 0);
                    return true;
                default:
                    return super.onTransact(i, parcel, parcel2, i2);
            }
        }
    }

    java.lang.String a() throws android.os.RemoteException;

    java.lang.String a(java.lang.String str) throws android.os.RemoteException;

    java.lang.String b() throws android.os.RemoteException;

    java.lang.String b(java.lang.String str) throws android.os.RemoteException;

    boolean c() throws android.os.RemoteException;

    boolean c(java.lang.String str) throws android.os.RemoteException;
}
