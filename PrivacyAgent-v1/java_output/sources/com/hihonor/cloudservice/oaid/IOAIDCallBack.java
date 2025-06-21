package com.hihonor.cloudservice.oaid;

/* loaded from: classes22.dex */
public interface IOAIDCallBack extends android.os.IInterface {

    public static class Default implements com.hihonor.cloudservice.oaid.IOAIDCallBack {
        @Override // android.os.IInterface
        public android.os.IBinder asBinder() {
            return null;
        }

        @Override // com.hihonor.cloudservice.oaid.IOAIDCallBack
        public void basicTypes(int i, long j, boolean z, float f, double d, java.lang.String str) throws android.os.RemoteException {
        }

        @Override // com.hihonor.cloudservice.oaid.IOAIDCallBack
        public void handleResult(int i, android.os.Bundle bundle) throws android.os.RemoteException {
        }
    }

    public static abstract class Stub extends android.os.Binder implements com.hihonor.cloudservice.oaid.IOAIDCallBack {
        private static final java.lang.String DESCRIPTOR = "com.hihonor.cloudservice.oaid.IOAIDCallBack";
        static final int TRANSACTION_basicTypes = 1;
        static final int TRANSACTION_handleResult = 2;

        public static class Proxy implements com.hihonor.cloudservice.oaid.IOAIDCallBack {
            public static com.hihonor.cloudservice.oaid.IOAIDCallBack sDefaultImpl;
            private android.os.IBinder mRemote;

            public Proxy(android.os.IBinder iBinder) {
                this.mRemote = iBinder;
            }

            @Override // android.os.IInterface
            public android.os.IBinder asBinder() {
                return this.mRemote;
            }

            @Override // com.hihonor.cloudservice.oaid.IOAIDCallBack
            public void basicTypes(int i, long j, boolean z, float f, double d, java.lang.String str) throws android.os.RemoteException {
                android.os.Parcel obtain = android.os.Parcel.obtain();
                android.os.Parcel obtain2 = android.os.Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(com.hihonor.cloudservice.oaid.IOAIDCallBack.Stub.DESCRIPTOR);
                    obtain.writeInt(i);
                    obtain.writeLong(j);
                    obtain.writeInt(z ? 1 : 0);
                    obtain.writeFloat(f);
                    obtain.writeDouble(d);
                    obtain.writeString(str);
                } catch (java.lang.Throwable th) {
                    th = th;
                }
                try {
                    if (this.mRemote.transact(1, obtain, obtain2, 0) || com.hihonor.cloudservice.oaid.IOAIDCallBack.Stub.getDefaultImpl() == null) {
                        obtain2.readException();
                        obtain2.recycle();
                        obtain.recycle();
                    } else {
                        com.hihonor.cloudservice.oaid.IOAIDCallBack.Stub.getDefaultImpl().basicTypes(i, j, z, f, d, str);
                        obtain2.recycle();
                        obtain.recycle();
                    }
                } catch (java.lang.Throwable th2) {
                    th = th2;
                    obtain2.recycle();
                    obtain.recycle();
                    throw th;
                }
            }

            public java.lang.String getInterfaceDescriptor() {
                return com.hihonor.cloudservice.oaid.IOAIDCallBack.Stub.DESCRIPTOR;
            }

            @Override // com.hihonor.cloudservice.oaid.IOAIDCallBack
            public void handleResult(int i, android.os.Bundle bundle) throws android.os.RemoteException {
                android.os.Parcel obtain = android.os.Parcel.obtain();
                android.os.Parcel obtain2 = android.os.Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(com.hihonor.cloudservice.oaid.IOAIDCallBack.Stub.DESCRIPTOR);
                    obtain.writeInt(i);
                    if (bundle != null) {
                        obtain.writeInt(1);
                        bundle.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (this.mRemote.transact(2, obtain, obtain2, 0) || com.hihonor.cloudservice.oaid.IOAIDCallBack.Stub.getDefaultImpl() == null) {
                        obtain2.readException();
                    } else {
                        com.hihonor.cloudservice.oaid.IOAIDCallBack.Stub.getDefaultImpl().handleResult(i, bundle);
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

        public Stub() {
            attachInterface(this, DESCRIPTOR);
        }

        public static com.hihonor.cloudservice.oaid.IOAIDCallBack asInterface(android.os.IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            android.os.IInterface queryLocalInterface = iBinder.queryLocalInterface(DESCRIPTOR);
            return (queryLocalInterface == null || !(queryLocalInterface instanceof com.hihonor.cloudservice.oaid.IOAIDCallBack)) ? new com.hihonor.cloudservice.oaid.IOAIDCallBack.Stub.Proxy(iBinder) : (com.hihonor.cloudservice.oaid.IOAIDCallBack) queryLocalInterface;
        }

        public static com.hihonor.cloudservice.oaid.IOAIDCallBack getDefaultImpl() {
            return com.hihonor.cloudservice.oaid.IOAIDCallBack.Stub.Proxy.sDefaultImpl;
        }

        public static boolean setDefaultImpl(com.hihonor.cloudservice.oaid.IOAIDCallBack iOAIDCallBack) {
            if (com.hihonor.cloudservice.oaid.IOAIDCallBack.Stub.Proxy.sDefaultImpl != null) {
                throw new java.lang.IllegalStateException("setDefaultImpl() called twice");
            }
            if (iOAIDCallBack == null) {
                return false;
            }
            com.hihonor.cloudservice.oaid.IOAIDCallBack.Stub.Proxy.sDefaultImpl = iOAIDCallBack;
            return true;
        }

        @Override // android.os.IInterface
        public android.os.IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, android.os.Parcel parcel, android.os.Parcel parcel2, int i2) throws android.os.RemoteException {
            if (i == 1) {
                parcel.enforceInterface(DESCRIPTOR);
                basicTypes(parcel.readInt(), parcel.readLong(), parcel.readInt() != 0, parcel.readFloat(), parcel.readDouble(), parcel.readString());
                parcel2.writeNoException();
                return true;
            }
            if (i != 2) {
                if (i != 1598968902) {
                    return super.onTransact(i, parcel, parcel2, i2);
                }
                parcel2.writeString(DESCRIPTOR);
                return true;
            }
            parcel.enforceInterface(DESCRIPTOR);
            handleResult(parcel.readInt(), parcel.readInt() != 0 ? (android.os.Bundle) android.os.Bundle.CREATOR.createFromParcel(parcel) : null);
            parcel2.writeNoException();
            return true;
        }
    }

    void basicTypes(int i, long j, boolean z, float f, double d, java.lang.String str) throws android.os.RemoteException;

    void handleResult(int i, android.os.Bundle bundle) throws android.os.RemoteException;
}
