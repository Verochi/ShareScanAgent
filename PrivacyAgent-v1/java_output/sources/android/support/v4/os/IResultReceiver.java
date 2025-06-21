package android.support.v4.os;

/* loaded from: classes.dex */
public interface IResultReceiver extends android.os.IInterface {

    public static class Default implements android.support.v4.os.IResultReceiver {
        @Override // android.os.IInterface
        public android.os.IBinder asBinder() {
            return null;
        }

        @Override // android.support.v4.os.IResultReceiver
        public void send(int i, android.os.Bundle bundle) throws android.os.RemoteException {
        }
    }

    public static abstract class Stub extends android.os.Binder implements android.support.v4.os.IResultReceiver {
        private static final java.lang.String DESCRIPTOR = "android.support.v4.os.IResultReceiver";
        static final int TRANSACTION_send = 1;

        public static class Proxy implements android.support.v4.os.IResultReceiver {
            public static android.support.v4.os.IResultReceiver sDefaultImpl;
            private android.os.IBinder mRemote;

            public Proxy(android.os.IBinder iBinder) {
                this.mRemote = iBinder;
            }

            @Override // android.os.IInterface
            public android.os.IBinder asBinder() {
                return this.mRemote;
            }

            public java.lang.String getInterfaceDescriptor() {
                return android.support.v4.os.IResultReceiver.Stub.DESCRIPTOR;
            }

            @Override // android.support.v4.os.IResultReceiver
            public void send(int i, android.os.Bundle bundle) throws android.os.RemoteException {
                android.os.Parcel obtain = android.os.Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(android.support.v4.os.IResultReceiver.Stub.DESCRIPTOR);
                    obtain.writeInt(i);
                    if (bundle != null) {
                        obtain.writeInt(1);
                        bundle.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (this.mRemote.transact(1, obtain, null, 1) || android.support.v4.os.IResultReceiver.Stub.getDefaultImpl() == null) {
                        return;
                    }
                    android.support.v4.os.IResultReceiver.Stub.getDefaultImpl().send(i, bundle);
                } finally {
                    obtain.recycle();
                }
            }
        }

        public Stub() {
            attachInterface(this, DESCRIPTOR);
        }

        public static android.support.v4.os.IResultReceiver asInterface(android.os.IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            android.os.IInterface queryLocalInterface = iBinder.queryLocalInterface(DESCRIPTOR);
            return (queryLocalInterface == null || !(queryLocalInterface instanceof android.support.v4.os.IResultReceiver)) ? new android.support.v4.os.IResultReceiver.Stub.Proxy(iBinder) : (android.support.v4.os.IResultReceiver) queryLocalInterface;
        }

        public static android.support.v4.os.IResultReceiver getDefaultImpl() {
            return android.support.v4.os.IResultReceiver.Stub.Proxy.sDefaultImpl;
        }

        public static boolean setDefaultImpl(android.support.v4.os.IResultReceiver iResultReceiver) {
            if (android.support.v4.os.IResultReceiver.Stub.Proxy.sDefaultImpl != null) {
                throw new java.lang.IllegalStateException("setDefaultImpl() called twice");
            }
            if (iResultReceiver == null) {
                return false;
            }
            android.support.v4.os.IResultReceiver.Stub.Proxy.sDefaultImpl = iResultReceiver;
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
                send(parcel.readInt(), parcel.readInt() != 0 ? (android.os.Bundle) android.os.Bundle.CREATOR.createFromParcel(parcel) : null);
                return true;
            }
            if (i != 1598968902) {
                return super.onTransact(i, parcel, parcel2, i2);
            }
            parcel2.writeString(DESCRIPTOR);
            return true;
        }
    }

    void send(int i, android.os.Bundle bundle) throws android.os.RemoteException;
}
