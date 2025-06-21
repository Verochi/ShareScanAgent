package androidx.room;

/* loaded from: classes.dex */
public interface IMultiInstanceInvalidationCallback extends android.os.IInterface {

    public static class Default implements androidx.room.IMultiInstanceInvalidationCallback {
        @Override // android.os.IInterface
        public android.os.IBinder asBinder() {
            return null;
        }

        @Override // androidx.room.IMultiInstanceInvalidationCallback
        public void onInvalidation(java.lang.String[] strArr) throws android.os.RemoteException {
        }
    }

    public static abstract class Stub extends android.os.Binder implements androidx.room.IMultiInstanceInvalidationCallback {
        private static final java.lang.String DESCRIPTOR = "androidx.room.IMultiInstanceInvalidationCallback";
        static final int TRANSACTION_onInvalidation = 1;

        public static class Proxy implements androidx.room.IMultiInstanceInvalidationCallback {
            public static androidx.room.IMultiInstanceInvalidationCallback sDefaultImpl;
            private android.os.IBinder mRemote;

            public Proxy(android.os.IBinder iBinder) {
                this.mRemote = iBinder;
            }

            @Override // android.os.IInterface
            public android.os.IBinder asBinder() {
                return this.mRemote;
            }

            public java.lang.String getInterfaceDescriptor() {
                return androidx.room.IMultiInstanceInvalidationCallback.Stub.DESCRIPTOR;
            }

            @Override // androidx.room.IMultiInstanceInvalidationCallback
            public void onInvalidation(java.lang.String[] strArr) throws android.os.RemoteException {
                android.os.Parcel obtain = android.os.Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(androidx.room.IMultiInstanceInvalidationCallback.Stub.DESCRIPTOR);
                    obtain.writeStringArray(strArr);
                    if (this.mRemote.transact(1, obtain, null, 1) || androidx.room.IMultiInstanceInvalidationCallback.Stub.getDefaultImpl() == null) {
                        return;
                    }
                    androidx.room.IMultiInstanceInvalidationCallback.Stub.getDefaultImpl().onInvalidation(strArr);
                } finally {
                    obtain.recycle();
                }
            }
        }

        public Stub() {
            attachInterface(this, DESCRIPTOR);
        }

        public static androidx.room.IMultiInstanceInvalidationCallback asInterface(android.os.IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            android.os.IInterface queryLocalInterface = iBinder.queryLocalInterface(DESCRIPTOR);
            return (queryLocalInterface == null || !(queryLocalInterface instanceof androidx.room.IMultiInstanceInvalidationCallback)) ? new androidx.room.IMultiInstanceInvalidationCallback.Stub.Proxy(iBinder) : (androidx.room.IMultiInstanceInvalidationCallback) queryLocalInterface;
        }

        public static androidx.room.IMultiInstanceInvalidationCallback getDefaultImpl() {
            return androidx.room.IMultiInstanceInvalidationCallback.Stub.Proxy.sDefaultImpl;
        }

        public static boolean setDefaultImpl(androidx.room.IMultiInstanceInvalidationCallback iMultiInstanceInvalidationCallback) {
            if (androidx.room.IMultiInstanceInvalidationCallback.Stub.Proxy.sDefaultImpl != null) {
                throw new java.lang.IllegalStateException("setDefaultImpl() called twice");
            }
            if (iMultiInstanceInvalidationCallback == null) {
                return false;
            }
            androidx.room.IMultiInstanceInvalidationCallback.Stub.Proxy.sDefaultImpl = iMultiInstanceInvalidationCallback;
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
                onInvalidation(parcel.createStringArray());
                return true;
            }
            if (i != 1598968902) {
                return super.onTransact(i, parcel, parcel2, i2);
            }
            parcel2.writeString(DESCRIPTOR);
            return true;
        }
    }

    void onInvalidation(java.lang.String[] strArr) throws android.os.RemoteException;
}
