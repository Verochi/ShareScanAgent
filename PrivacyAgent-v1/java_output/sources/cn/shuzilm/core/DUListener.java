package cn.shuzilm.core;

/* loaded from: classes.dex */
public interface DUListener extends android.os.IInterface {

    public class Default implements cn.shuzilm.core.DUListener {
        @Override // android.os.IInterface
        public android.os.IBinder asBinder() {
            return null;
        }

        @Override // cn.shuzilm.core.DUListener
        public void handle(java.lang.String str) {
        }
    }

    public abstract class Stub extends android.os.Binder implements cn.shuzilm.core.DUListener {
        private static final java.lang.String DESCRIPTOR = "cn.shuzilm.core.DUListener";
        static final int TRANSACTION_handle = 1;

        class Proxy implements cn.shuzilm.core.DUListener {
            public static cn.shuzilm.core.DUListener sDefaultImpl;
            private android.os.IBinder mRemote;

            public Proxy(android.os.IBinder iBinder) {
                this.mRemote = iBinder;
            }

            @Override // android.os.IInterface
            public android.os.IBinder asBinder() {
                return this.mRemote;
            }

            public java.lang.String getInterfaceDescriptor() {
                return cn.shuzilm.core.DUListener.Stub.DESCRIPTOR;
            }

            @Override // cn.shuzilm.core.DUListener
            public void handle(java.lang.String str) {
                android.os.Parcel obtain = android.os.Parcel.obtain();
                android.os.Parcel obtain2 = android.os.Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(cn.shuzilm.core.DUListener.Stub.DESCRIPTOR);
                    obtain.writeString(str);
                    if (this.mRemote.transact(1, obtain, obtain2, 0) || cn.shuzilm.core.DUListener.Stub.getDefaultImpl() == null) {
                        obtain2.readException();
                    } else {
                        cn.shuzilm.core.DUListener.Stub.getDefaultImpl().handle(str);
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

        public static cn.shuzilm.core.DUListener asInterface(android.os.IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            android.os.IInterface queryLocalInterface = iBinder.queryLocalInterface(DESCRIPTOR);
            return (queryLocalInterface == null || !(queryLocalInterface instanceof cn.shuzilm.core.DUListener)) ? new cn.shuzilm.core.DUListener.Stub.Proxy(iBinder) : (cn.shuzilm.core.DUListener) queryLocalInterface;
        }

        public static cn.shuzilm.core.DUListener getDefaultImpl() {
            return cn.shuzilm.core.DUListener.Stub.Proxy.sDefaultImpl;
        }

        public static boolean setDefaultImpl(cn.shuzilm.core.DUListener dUListener) {
            if (cn.shuzilm.core.DUListener.Stub.Proxy.sDefaultImpl != null) {
                throw new java.lang.IllegalStateException("setDefaultImpl() called twice");
            }
            if (dUListener == null) {
                return false;
            }
            cn.shuzilm.core.DUListener.Stub.Proxy.sDefaultImpl = dUListener;
            return true;
        }

        @Override // android.os.IInterface
        public android.os.IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, android.os.Parcel parcel, android.os.Parcel parcel2, int i2) {
            if (i != 1) {
                if (i != 1598968902) {
                    return super.onTransact(i, parcel, parcel2, i2);
                }
                parcel2.writeString(DESCRIPTOR);
                return true;
            }
            parcel.enforceInterface(DESCRIPTOR);
            handle(parcel.readString());
            parcel2.writeNoException();
            return true;
        }
    }

    void handle(java.lang.String str);
}
