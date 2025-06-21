package com.alipay.android.app;

/* loaded from: classes.dex */
public interface IAlixPay extends android.os.IInterface {

    public static abstract class Stub extends android.os.Binder implements com.alipay.android.app.IAlixPay {
        public static final java.lang.String DESCRIPTOR = "com.alipay.android.app.IAlixPay";
        public static final int TRANSACTION_Pay = 1;
        public static final int TRANSACTION_deployFastConnect = 6;
        public static final int TRANSACTION_getVersion = 8;
        public static final int TRANSACTION_manager = 7;
        public static final int TRANSACTION_pay02 = 9;
        public static final int TRANSACTION_prePay = 5;
        public static final int TRANSACTION_r03 = 10;
        public static final int TRANSACTION_registerCallback = 3;
        public static final int TRANSACTION_registerCallback03 = 11;
        public static final int TRANSACTION_test = 2;
        public static final int TRANSACTION_unregisterCallback = 4;

        public static class a implements com.alipay.android.app.IAlixPay {
            public android.os.IBinder a;

            public a(android.os.IBinder iBinder) {
                this.a = iBinder;
            }

            @Override // com.alipay.android.app.IAlixPay
            public java.lang.String Pay(java.lang.String str) throws android.os.RemoteException {
                android.os.Parcel obtain = android.os.Parcel.obtain();
                android.os.Parcel obtain2 = android.os.Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(com.alipay.android.app.IAlixPay.Stub.DESCRIPTOR);
                    obtain.writeString(str);
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

            public java.lang.String d() {
                return com.alipay.android.app.IAlixPay.Stub.DESCRIPTOR;
            }

            @Override // com.alipay.android.app.IAlixPay
            public void deployFastConnect() throws android.os.RemoteException {
                android.os.Parcel obtain = android.os.Parcel.obtain();
                android.os.Parcel obtain2 = android.os.Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(com.alipay.android.app.IAlixPay.Stub.DESCRIPTOR);
                    this.a.transact(6, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.alipay.android.app.IAlixPay
            public int getVersion() throws android.os.RemoteException {
                android.os.Parcel obtain = android.os.Parcel.obtain();
                android.os.Parcel obtain2 = android.os.Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(com.alipay.android.app.IAlixPay.Stub.DESCRIPTOR);
                    this.a.transact(8, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.alipay.android.app.IAlixPay
            public boolean manager(java.lang.String str) throws android.os.RemoteException {
                android.os.Parcel obtain = android.os.Parcel.obtain();
                android.os.Parcel obtain2 = android.os.Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(com.alipay.android.app.IAlixPay.Stub.DESCRIPTOR);
                    obtain.writeString(str);
                    this.a.transact(7, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt() != 0;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.alipay.android.app.IAlixPay
            public java.lang.String pay02(java.lang.String str, java.util.Map map) throws android.os.RemoteException {
                android.os.Parcel obtain = android.os.Parcel.obtain();
                android.os.Parcel obtain2 = android.os.Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(com.alipay.android.app.IAlixPay.Stub.DESCRIPTOR);
                    obtain.writeString(str);
                    obtain.writeMap(map);
                    this.a.transact(9, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readString();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.alipay.android.app.IAlixPay
            public java.lang.String prePay(java.lang.String str) throws android.os.RemoteException {
                android.os.Parcel obtain = android.os.Parcel.obtain();
                android.os.Parcel obtain2 = android.os.Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(com.alipay.android.app.IAlixPay.Stub.DESCRIPTOR);
                    obtain.writeString(str);
                    this.a.transact(5, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readString();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.alipay.android.app.IAlixPay
            public void r03(java.lang.String str, java.lang.String str2, java.util.Map map) throws android.os.RemoteException {
                android.os.Parcel obtain = android.os.Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(com.alipay.android.app.IAlixPay.Stub.DESCRIPTOR);
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    obtain.writeMap(map);
                    this.a.transact(10, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            @Override // com.alipay.android.app.IAlixPay
            public void registerCallback(com.alipay.android.app.IRemoteServiceCallback iRemoteServiceCallback) throws android.os.RemoteException {
                android.os.Parcel obtain = android.os.Parcel.obtain();
                android.os.Parcel obtain2 = android.os.Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(com.alipay.android.app.IAlixPay.Stub.DESCRIPTOR);
                    obtain.writeStrongBinder(iRemoteServiceCallback != null ? iRemoteServiceCallback.asBinder() : null);
                    this.a.transact(3, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.alipay.android.app.IAlixPay
            public void registerCallback03(com.alipay.android.app.IRemoteServiceCallback iRemoteServiceCallback, java.lang.String str, java.util.Map map) throws android.os.RemoteException {
                android.os.Parcel obtain = android.os.Parcel.obtain();
                android.os.Parcel obtain2 = android.os.Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(com.alipay.android.app.IAlixPay.Stub.DESCRIPTOR);
                    obtain.writeStrongBinder(iRemoteServiceCallback != null ? iRemoteServiceCallback.asBinder() : null);
                    obtain.writeString(str);
                    obtain.writeMap(map);
                    this.a.transact(11, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.alipay.android.app.IAlixPay
            public java.lang.String test() throws android.os.RemoteException {
                android.os.Parcel obtain = android.os.Parcel.obtain();
                android.os.Parcel obtain2 = android.os.Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(com.alipay.android.app.IAlixPay.Stub.DESCRIPTOR);
                    this.a.transact(2, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readString();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.alipay.android.app.IAlixPay
            public void unregisterCallback(com.alipay.android.app.IRemoteServiceCallback iRemoteServiceCallback) throws android.os.RemoteException {
                android.os.Parcel obtain = android.os.Parcel.obtain();
                android.os.Parcel obtain2 = android.os.Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(com.alipay.android.app.IAlixPay.Stub.DESCRIPTOR);
                    obtain.writeStrongBinder(iRemoteServiceCallback != null ? iRemoteServiceCallback.asBinder() : null);
                    this.a.transact(4, obtain, obtain2, 0);
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

        public static com.alipay.android.app.IAlixPay asInterface(android.os.IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            android.os.IInterface queryLocalInterface = iBinder.queryLocalInterface(DESCRIPTOR);
            return (queryLocalInterface == null || !(queryLocalInterface instanceof com.alipay.android.app.IAlixPay)) ? new com.alipay.android.app.IAlixPay.Stub.a(iBinder) : (com.alipay.android.app.IAlixPay) queryLocalInterface;
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
            switch (i) {
                case 1:
                    parcel.enforceInterface(DESCRIPTOR);
                    java.lang.String Pay = Pay(parcel.readString());
                    parcel2.writeNoException();
                    parcel2.writeString(Pay);
                    return true;
                case 2:
                    parcel.enforceInterface(DESCRIPTOR);
                    java.lang.String test = test();
                    parcel2.writeNoException();
                    parcel2.writeString(test);
                    return true;
                case 3:
                    parcel.enforceInterface(DESCRIPTOR);
                    registerCallback(com.alipay.android.app.IRemoteServiceCallback.Stub.asInterface(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 4:
                    parcel.enforceInterface(DESCRIPTOR);
                    unregisterCallback(com.alipay.android.app.IRemoteServiceCallback.Stub.asInterface(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 5:
                    parcel.enforceInterface(DESCRIPTOR);
                    java.lang.String prePay = prePay(parcel.readString());
                    parcel2.writeNoException();
                    parcel2.writeString(prePay);
                    return true;
                case 6:
                    parcel.enforceInterface(DESCRIPTOR);
                    deployFastConnect();
                    parcel2.writeNoException();
                    return true;
                case 7:
                    parcel.enforceInterface(DESCRIPTOR);
                    boolean manager = manager(parcel.readString());
                    parcel2.writeNoException();
                    parcel2.writeInt(manager ? 1 : 0);
                    return true;
                case 8:
                    parcel.enforceInterface(DESCRIPTOR);
                    int version = getVersion();
                    parcel2.writeNoException();
                    parcel2.writeInt(version);
                    return true;
                case 9:
                    parcel.enforceInterface(DESCRIPTOR);
                    java.lang.String pay02 = pay02(parcel.readString(), parcel.readHashMap(com.alipay.android.app.IAlixPay.Stub.class.getClassLoader()));
                    parcel2.writeNoException();
                    parcel2.writeString(pay02);
                    return true;
                case 10:
                    parcel.enforceInterface(DESCRIPTOR);
                    r03(parcel.readString(), parcel.readString(), parcel.readHashMap(com.alipay.android.app.IAlixPay.Stub.class.getClassLoader()));
                    return true;
                case 11:
                    parcel.enforceInterface(DESCRIPTOR);
                    registerCallback03(com.alipay.android.app.IRemoteServiceCallback.Stub.asInterface(parcel.readStrongBinder()), parcel.readString(), parcel.readHashMap(com.alipay.android.app.IAlixPay.Stub.class.getClassLoader()));
                    parcel2.writeNoException();
                    return true;
                default:
                    return super.onTransact(i, parcel, parcel2, i2);
            }
        }
    }

    java.lang.String Pay(java.lang.String str) throws android.os.RemoteException;

    void deployFastConnect() throws android.os.RemoteException;

    int getVersion() throws android.os.RemoteException;

    boolean manager(java.lang.String str) throws android.os.RemoteException;

    java.lang.String pay02(java.lang.String str, java.util.Map map) throws android.os.RemoteException;

    java.lang.String prePay(java.lang.String str) throws android.os.RemoteException;

    void r03(java.lang.String str, java.lang.String str2, java.util.Map map) throws android.os.RemoteException;

    void registerCallback(com.alipay.android.app.IRemoteServiceCallback iRemoteServiceCallback) throws android.os.RemoteException;

    void registerCallback03(com.alipay.android.app.IRemoteServiceCallback iRemoteServiceCallback, java.lang.String str, java.util.Map map) throws android.os.RemoteException;

    java.lang.String test() throws android.os.RemoteException;

    void unregisterCallback(com.alipay.android.app.IRemoteServiceCallback iRemoteServiceCallback) throws android.os.RemoteException;
}
