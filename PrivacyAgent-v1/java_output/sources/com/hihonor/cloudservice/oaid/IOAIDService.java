package com.hihonor.cloudservice.oaid;

/* loaded from: classes22.dex */
public interface IOAIDService extends android.os.IInterface {

    public static class Default implements com.hihonor.cloudservice.oaid.IOAIDService {
        @Override // android.os.IInterface
        public android.os.IBinder asBinder() {
            return null;
        }

        @Override // com.hihonor.cloudservice.oaid.IOAIDService
        public void basicTypes(int i, long j, boolean z, float f, double d, java.lang.String str) throws android.os.RemoteException {
        }

        @Override // com.hihonor.cloudservice.oaid.IOAIDService
        public void getOAID(com.hihonor.cloudservice.oaid.IOAIDCallBack iOAIDCallBack) throws android.os.RemoteException {
        }

        @Override // com.hihonor.cloudservice.oaid.IOAIDService
        public void isOAIDTrackingLimited(com.hihonor.cloudservice.oaid.IOAIDCallBack iOAIDCallBack) throws android.os.RemoteException {
        }
    }

    public static abstract class Stub extends android.os.Binder implements com.hihonor.cloudservice.oaid.IOAIDService {
        private static final java.lang.String DESCRIPTOR = "com.hihonor.cloudservice.oaid.IOAIDService";
        static final int TRANSACTION_basicTypes = 1;
        static final int TRANSACTION_getOAID = 2;
        static final int TRANSACTION_isOAIDTrackingLimited = 3;

        public static class Proxy implements com.hihonor.cloudservice.oaid.IOAIDService {
            public static com.hihonor.cloudservice.oaid.IOAIDService sDefaultImpl;
            private android.os.IBinder mRemote;

            public Proxy(android.os.IBinder iBinder) {
                this.mRemote = iBinder;
            }

            @Override // android.os.IInterface
            public android.os.IBinder asBinder() {
                return this.mRemote;
            }

            @Override // com.hihonor.cloudservice.oaid.IOAIDService
            public void basicTypes(int i, long j, boolean z, float f, double d, java.lang.String str) throws android.os.RemoteException {
                android.os.Parcel obtain = android.os.Parcel.obtain();
                android.os.Parcel obtain2 = android.os.Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(com.hihonor.cloudservice.oaid.IOAIDService.Stub.DESCRIPTOR);
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
                    if (this.mRemote.transact(1, obtain, obtain2, 0) || com.hihonor.cloudservice.oaid.IOAIDService.Stub.getDefaultImpl() == null) {
                        obtain2.readException();
                        obtain2.recycle();
                        obtain.recycle();
                    } else {
                        com.hihonor.cloudservice.oaid.IOAIDService.Stub.getDefaultImpl().basicTypes(i, j, z, f, d, str);
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
                return com.hihonor.cloudservice.oaid.IOAIDService.Stub.DESCRIPTOR;
            }

            @Override // com.hihonor.cloudservice.oaid.IOAIDService
            public void getOAID(com.hihonor.cloudservice.oaid.IOAIDCallBack iOAIDCallBack) throws android.os.RemoteException {
                android.os.Parcel obtain = android.os.Parcel.obtain();
                android.os.Parcel obtain2 = android.os.Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(com.hihonor.cloudservice.oaid.IOAIDService.Stub.DESCRIPTOR);
                    obtain.writeStrongBinder(iOAIDCallBack != null ? iOAIDCallBack.asBinder() : null);
                    if (this.mRemote.transact(2, obtain, obtain2, 0) || com.hihonor.cloudservice.oaid.IOAIDService.Stub.getDefaultImpl() == null) {
                        obtain2.readException();
                    } else {
                        com.hihonor.cloudservice.oaid.IOAIDService.Stub.getDefaultImpl().getOAID(iOAIDCallBack);
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.hihonor.cloudservice.oaid.IOAIDService
            public void isOAIDTrackingLimited(com.hihonor.cloudservice.oaid.IOAIDCallBack iOAIDCallBack) throws android.os.RemoteException {
                android.os.Parcel obtain = android.os.Parcel.obtain();
                android.os.Parcel obtain2 = android.os.Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(com.hihonor.cloudservice.oaid.IOAIDService.Stub.DESCRIPTOR);
                    obtain.writeStrongBinder(iOAIDCallBack != null ? iOAIDCallBack.asBinder() : null);
                    if (this.mRemote.transact(3, obtain, obtain2, 0) || com.hihonor.cloudservice.oaid.IOAIDService.Stub.getDefaultImpl() == null) {
                        obtain2.readException();
                    } else {
                        com.hihonor.cloudservice.oaid.IOAIDService.Stub.getDefaultImpl().isOAIDTrackingLimited(iOAIDCallBack);
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

        public static com.hihonor.cloudservice.oaid.IOAIDService asInterface(android.os.IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            android.os.IInterface queryLocalInterface = iBinder.queryLocalInterface(DESCRIPTOR);
            return (queryLocalInterface == null || !(queryLocalInterface instanceof com.hihonor.cloudservice.oaid.IOAIDService)) ? new com.hihonor.cloudservice.oaid.IOAIDService.Stub.Proxy(iBinder) : (com.hihonor.cloudservice.oaid.IOAIDService) queryLocalInterface;
        }

        public static com.hihonor.cloudservice.oaid.IOAIDService getDefaultImpl() {
            return com.hihonor.cloudservice.oaid.IOAIDService.Stub.Proxy.sDefaultImpl;
        }

        public static boolean setDefaultImpl(com.hihonor.cloudservice.oaid.IOAIDService iOAIDService) {
            if (com.hihonor.cloudservice.oaid.IOAIDService.Stub.Proxy.sDefaultImpl != null) {
                throw new java.lang.IllegalStateException("setDefaultImpl() called twice");
            }
            if (iOAIDService == null) {
                return false;
            }
            com.hihonor.cloudservice.oaid.IOAIDService.Stub.Proxy.sDefaultImpl = iOAIDService;
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
            if (i == 2) {
                parcel.enforceInterface(DESCRIPTOR);
                getOAID(com.hihonor.cloudservice.oaid.IOAIDCallBack.Stub.asInterface(parcel.readStrongBinder()));
                parcel2.writeNoException();
                return true;
            }
            if (i != 3) {
                if (i != 1598968902) {
                    return super.onTransact(i, parcel, parcel2, i2);
                }
                parcel2.writeString(DESCRIPTOR);
                return true;
            }
            parcel.enforceInterface(DESCRIPTOR);
            isOAIDTrackingLimited(com.hihonor.cloudservice.oaid.IOAIDCallBack.Stub.asInterface(parcel.readStrongBinder()));
            parcel2.writeNoException();
            return true;
        }
    }

    void basicTypes(int i, long j, boolean z, float f, double d, java.lang.String str) throws android.os.RemoteException;

    void getOAID(com.hihonor.cloudservice.oaid.IOAIDCallBack iOAIDCallBack) throws android.os.RemoteException;

    void isOAIDTrackingLimited(com.hihonor.cloudservice.oaid.IOAIDCallBack iOAIDCallBack) throws android.os.RemoteException;
}
