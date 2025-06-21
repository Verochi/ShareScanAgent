package androidx.room;

/* loaded from: classes.dex */
public interface IMultiInstanceInvalidationService extends android.os.IInterface {

    public static class Default implements androidx.room.IMultiInstanceInvalidationService {
        @Override // android.os.IInterface
        public android.os.IBinder asBinder() {
            return null;
        }

        @Override // androidx.room.IMultiInstanceInvalidationService
        public void broadcastInvalidation(int i, java.lang.String[] strArr) throws android.os.RemoteException {
        }

        @Override // androidx.room.IMultiInstanceInvalidationService
        public int registerCallback(androidx.room.IMultiInstanceInvalidationCallback iMultiInstanceInvalidationCallback, java.lang.String str) throws android.os.RemoteException {
            return 0;
        }

        @Override // androidx.room.IMultiInstanceInvalidationService
        public void unregisterCallback(androidx.room.IMultiInstanceInvalidationCallback iMultiInstanceInvalidationCallback, int i) throws android.os.RemoteException {
        }
    }

    public static abstract class Stub extends android.os.Binder implements androidx.room.IMultiInstanceInvalidationService {
        private static final java.lang.String DESCRIPTOR = "androidx.room.IMultiInstanceInvalidationService";
        static final int TRANSACTION_broadcastInvalidation = 3;
        static final int TRANSACTION_registerCallback = 1;
        static final int TRANSACTION_unregisterCallback = 2;

        public static class Proxy implements androidx.room.IMultiInstanceInvalidationService {
            public static androidx.room.IMultiInstanceInvalidationService sDefaultImpl;
            private android.os.IBinder mRemote;

            public Proxy(android.os.IBinder iBinder) {
                this.mRemote = iBinder;
            }

            @Override // android.os.IInterface
            public android.os.IBinder asBinder() {
                return this.mRemote;
            }

            @Override // androidx.room.IMultiInstanceInvalidationService
            public void broadcastInvalidation(int i, java.lang.String[] strArr) throws android.os.RemoteException {
                android.os.Parcel obtain = android.os.Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(androidx.room.IMultiInstanceInvalidationService.Stub.DESCRIPTOR);
                    obtain.writeInt(i);
                    obtain.writeStringArray(strArr);
                    if (this.mRemote.transact(3, obtain, null, 1) || androidx.room.IMultiInstanceInvalidationService.Stub.getDefaultImpl() == null) {
                        return;
                    }
                    androidx.room.IMultiInstanceInvalidationService.Stub.getDefaultImpl().broadcastInvalidation(i, strArr);
                } finally {
                    obtain.recycle();
                }
            }

            public java.lang.String getInterfaceDescriptor() {
                return androidx.room.IMultiInstanceInvalidationService.Stub.DESCRIPTOR;
            }

            @Override // androidx.room.IMultiInstanceInvalidationService
            public int registerCallback(androidx.room.IMultiInstanceInvalidationCallback iMultiInstanceInvalidationCallback, java.lang.String str) throws android.os.RemoteException {
                android.os.Parcel obtain = android.os.Parcel.obtain();
                android.os.Parcel obtain2 = android.os.Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(androidx.room.IMultiInstanceInvalidationService.Stub.DESCRIPTOR);
                    obtain.writeStrongBinder(iMultiInstanceInvalidationCallback != null ? iMultiInstanceInvalidationCallback.asBinder() : null);
                    obtain.writeString(str);
                    if (!this.mRemote.transact(1, obtain, obtain2, 0) && androidx.room.IMultiInstanceInvalidationService.Stub.getDefaultImpl() != null) {
                        return androidx.room.IMultiInstanceInvalidationService.Stub.getDefaultImpl().registerCallback(iMultiInstanceInvalidationCallback, str);
                    }
                    obtain2.readException();
                    return obtain2.readInt();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // androidx.room.IMultiInstanceInvalidationService
            public void unregisterCallback(androidx.room.IMultiInstanceInvalidationCallback iMultiInstanceInvalidationCallback, int i) throws android.os.RemoteException {
                android.os.Parcel obtain = android.os.Parcel.obtain();
                android.os.Parcel obtain2 = android.os.Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(androidx.room.IMultiInstanceInvalidationService.Stub.DESCRIPTOR);
                    obtain.writeStrongBinder(iMultiInstanceInvalidationCallback != null ? iMultiInstanceInvalidationCallback.asBinder() : null);
                    obtain.writeInt(i);
                    if (this.mRemote.transact(2, obtain, obtain2, 0) || androidx.room.IMultiInstanceInvalidationService.Stub.getDefaultImpl() == null) {
                        obtain2.readException();
                    } else {
                        androidx.room.IMultiInstanceInvalidationService.Stub.getDefaultImpl().unregisterCallback(iMultiInstanceInvalidationCallback, i);
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

        public static androidx.room.IMultiInstanceInvalidationService asInterface(android.os.IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            android.os.IInterface queryLocalInterface = iBinder.queryLocalInterface(DESCRIPTOR);
            return (queryLocalInterface == null || !(queryLocalInterface instanceof androidx.room.IMultiInstanceInvalidationService)) ? new androidx.room.IMultiInstanceInvalidationService.Stub.Proxy(iBinder) : (androidx.room.IMultiInstanceInvalidationService) queryLocalInterface;
        }

        public static androidx.room.IMultiInstanceInvalidationService getDefaultImpl() {
            return androidx.room.IMultiInstanceInvalidationService.Stub.Proxy.sDefaultImpl;
        }

        public static boolean setDefaultImpl(androidx.room.IMultiInstanceInvalidationService iMultiInstanceInvalidationService) {
            if (androidx.room.IMultiInstanceInvalidationService.Stub.Proxy.sDefaultImpl != null) {
                throw new java.lang.IllegalStateException("setDefaultImpl() called twice");
            }
            if (iMultiInstanceInvalidationService == null) {
                return false;
            }
            androidx.room.IMultiInstanceInvalidationService.Stub.Proxy.sDefaultImpl = iMultiInstanceInvalidationService;
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
                int registerCallback = registerCallback(androidx.room.IMultiInstanceInvalidationCallback.Stub.asInterface(parcel.readStrongBinder()), parcel.readString());
                parcel2.writeNoException();
                parcel2.writeInt(registerCallback);
                return true;
            }
            if (i == 2) {
                parcel.enforceInterface(DESCRIPTOR);
                unregisterCallback(androidx.room.IMultiInstanceInvalidationCallback.Stub.asInterface(parcel.readStrongBinder()), parcel.readInt());
                parcel2.writeNoException();
                return true;
            }
            if (i == 3) {
                parcel.enforceInterface(DESCRIPTOR);
                broadcastInvalidation(parcel.readInt(), parcel.createStringArray());
                return true;
            }
            if (i != 1598968902) {
                return super.onTransact(i, parcel, parcel2, i2);
            }
            parcel2.writeString(DESCRIPTOR);
            return true;
        }
    }

    void broadcastInvalidation(int i, java.lang.String[] strArr) throws android.os.RemoteException;

    int registerCallback(androidx.room.IMultiInstanceInvalidationCallback iMultiInstanceInvalidationCallback, java.lang.String str) throws android.os.RemoteException;

    void unregisterCallback(androidx.room.IMultiInstanceInvalidationCallback iMultiInstanceInvalidationCallback, int i) throws android.os.RemoteException;
}
