package com.alipay.android.app;

/* loaded from: classes.dex */
public interface IRemoteServiceCallback extends android.os.IInterface {

    public static abstract class Stub extends android.os.Binder implements com.alipay.android.app.IRemoteServiceCallback {
        public static final java.lang.String DESCRIPTOR = "com.alipay.android.app.IRemoteServiceCallback";
        public static final int TRANSACTION_getVersion = 4;
        public static final int TRANSACTION_isHideLoadingScreen = 3;
        public static final int TRANSACTION_payEnd = 2;
        public static final int TRANSACTION_r03 = 5;
        public static final int TRANSACTION_startActivity = 1;

        public static class a implements com.alipay.android.app.IRemoteServiceCallback {
            public android.os.IBinder a;

            public a(android.os.IBinder iBinder) {
                this.a = iBinder;
            }

            @Override // android.os.IInterface
            public android.os.IBinder asBinder() {
                return this.a;
            }

            public java.lang.String d() {
                return com.alipay.android.app.IRemoteServiceCallback.Stub.DESCRIPTOR;
            }

            @Override // com.alipay.android.app.IRemoteServiceCallback
            public int getVersion() throws android.os.RemoteException {
                android.os.Parcel obtain = android.os.Parcel.obtain();
                android.os.Parcel obtain2 = android.os.Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(com.alipay.android.app.IRemoteServiceCallback.Stub.DESCRIPTOR);
                    this.a.transact(4, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.alipay.android.app.IRemoteServiceCallback
            public boolean isHideLoadingScreen() throws android.os.RemoteException {
                android.os.Parcel obtain = android.os.Parcel.obtain();
                android.os.Parcel obtain2 = android.os.Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(com.alipay.android.app.IRemoteServiceCallback.Stub.DESCRIPTOR);
                    this.a.transact(3, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt() != 0;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.alipay.android.app.IRemoteServiceCallback
            public void payEnd(boolean z, java.lang.String str) throws android.os.RemoteException {
                android.os.Parcel obtain = android.os.Parcel.obtain();
                android.os.Parcel obtain2 = android.os.Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(com.alipay.android.app.IRemoteServiceCallback.Stub.DESCRIPTOR);
                    obtain.writeInt(z ? 1 : 0);
                    obtain.writeString(str);
                    this.a.transact(2, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.alipay.android.app.IRemoteServiceCallback
            public void r03(java.lang.String str, java.lang.String str2, java.util.Map map) throws android.os.RemoteException {
                android.os.Parcel obtain = android.os.Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(com.alipay.android.app.IRemoteServiceCallback.Stub.DESCRIPTOR);
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    obtain.writeMap(map);
                    this.a.transact(5, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            @Override // com.alipay.android.app.IRemoteServiceCallback
            public void startActivity(java.lang.String str, java.lang.String str2, int i, android.os.Bundle bundle) throws android.os.RemoteException {
                android.os.Parcel obtain = android.os.Parcel.obtain();
                android.os.Parcel obtain2 = android.os.Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(com.alipay.android.app.IRemoteServiceCallback.Stub.DESCRIPTOR);
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    obtain.writeInt(i);
                    if (bundle != null) {
                        obtain.writeInt(1);
                        bundle.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.a.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

        public Stub() {
            attachInterface(this, DESCRIPTOR);
        }

        public static com.alipay.android.app.IRemoteServiceCallback asInterface(android.os.IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            android.os.IInterface queryLocalInterface = iBinder.queryLocalInterface(DESCRIPTOR);
            return (queryLocalInterface == null || !(queryLocalInterface instanceof com.alipay.android.app.IRemoteServiceCallback)) ? new com.alipay.android.app.IRemoteServiceCallback.Stub.a(iBinder) : (com.alipay.android.app.IRemoteServiceCallback) queryLocalInterface;
        }

        @Override // android.os.IInterface
        public android.os.IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, android.os.Parcel parcel, android.os.Parcel parcel2, int i2) throws android.os.RemoteException {
            if (i == 1598968902) {
                parcel2.writeString(DESCRIPTOR);
                return true;
            }
            if (i == 1) {
                parcel.enforceInterface(DESCRIPTOR);
                startActivity(parcel.readString(), parcel.readString(), parcel.readInt(), parcel.readInt() != 0 ? (android.os.Bundle) android.os.Bundle.CREATOR.createFromParcel(parcel) : null);
                parcel2.writeNoException();
                return true;
            }
            if (i == 2) {
                parcel.enforceInterface(DESCRIPTOR);
                payEnd(parcel.readInt() != 0, parcel.readString());
                parcel2.writeNoException();
                return true;
            }
            if (i == 3) {
                parcel.enforceInterface(DESCRIPTOR);
                boolean isHideLoadingScreen = isHideLoadingScreen();
                parcel2.writeNoException();
                parcel2.writeInt(isHideLoadingScreen ? 1 : 0);
                return true;
            }
            if (i != 4) {
                if (i != 5) {
                    return super.onTransact(i, parcel, parcel2, i2);
                }
                parcel.enforceInterface(DESCRIPTOR);
                r03(parcel.readString(), parcel.readString(), parcel.readHashMap(getClass().getClassLoader()));
                return true;
            }
            parcel.enforceInterface(DESCRIPTOR);
            int version = getVersion();
            parcel2.writeNoException();
            parcel2.writeInt(version);
            return true;
        }
    }

    int getVersion() throws android.os.RemoteException;

    boolean isHideLoadingScreen() throws android.os.RemoteException;

    void payEnd(boolean z, java.lang.String str) throws android.os.RemoteException;

    void r03(java.lang.String str, java.lang.String str2, java.util.Map map) throws android.os.RemoteException;

    void startActivity(java.lang.String str, java.lang.String str2, int i, android.os.Bundle bundle) throws android.os.RemoteException;
}
