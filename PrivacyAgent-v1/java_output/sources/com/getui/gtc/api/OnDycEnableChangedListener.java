package com.getui.gtc.api;

/* loaded from: classes22.dex */
public interface OnDycEnableChangedListener extends android.os.IInterface {

    public static class Default implements com.getui.gtc.api.OnDycEnableChangedListener {
        @Override // android.os.IInterface
        public android.os.IBinder asBinder() {
            return null;
        }

        @Override // com.getui.gtc.api.OnDycEnableChangedListener
        public void onDycEnableChanged(java.util.Map map) throws android.os.RemoteException {
        }
    }

    public static abstract class Stub extends android.os.Binder implements com.getui.gtc.api.OnDycEnableChangedListener {
        private static final java.lang.String DESCRIPTOR = "com.getui.gtc.api.OnDycEnableChangedListener";
        static final int TRANSACTION_onDycEnableChanged = 1;

        public static class Proxy implements com.getui.gtc.api.OnDycEnableChangedListener {
            public static com.getui.gtc.api.OnDycEnableChangedListener sDefaultImpl;
            private android.os.IBinder mRemote;

            public Proxy(android.os.IBinder iBinder) {
                this.mRemote = iBinder;
            }

            @Override // android.os.IInterface
            public android.os.IBinder asBinder() {
                return this.mRemote;
            }

            public java.lang.String getInterfaceDescriptor() {
                return com.getui.gtc.api.OnDycEnableChangedListener.Stub.DESCRIPTOR;
            }

            @Override // com.getui.gtc.api.OnDycEnableChangedListener
            public void onDycEnableChanged(java.util.Map map) throws android.os.RemoteException {
                android.os.Parcel obtain = android.os.Parcel.obtain();
                android.os.Parcel obtain2 = android.os.Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(com.getui.gtc.api.OnDycEnableChangedListener.Stub.DESCRIPTOR);
                    obtain.writeMap(map);
                    if (this.mRemote.transact(1, obtain, obtain2, 0) || com.getui.gtc.api.OnDycEnableChangedListener.Stub.getDefaultImpl() == null) {
                        obtain2.readException();
                    } else {
                        com.getui.gtc.api.OnDycEnableChangedListener.Stub.getDefaultImpl().onDycEnableChanged(map);
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

        public static com.getui.gtc.api.OnDycEnableChangedListener asInterface(android.os.IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            android.os.IInterface queryLocalInterface = iBinder.queryLocalInterface(DESCRIPTOR);
            return (queryLocalInterface == null || !(queryLocalInterface instanceof com.getui.gtc.api.OnDycEnableChangedListener)) ? new com.getui.gtc.api.OnDycEnableChangedListener.Stub.Proxy(iBinder) : (com.getui.gtc.api.OnDycEnableChangedListener) queryLocalInterface;
        }

        public static com.getui.gtc.api.OnDycEnableChangedListener getDefaultImpl() {
            return com.getui.gtc.api.OnDycEnableChangedListener.Stub.Proxy.sDefaultImpl;
        }

        public static boolean setDefaultImpl(com.getui.gtc.api.OnDycEnableChangedListener onDycEnableChangedListener) {
            if (com.getui.gtc.api.OnDycEnableChangedListener.Stub.Proxy.sDefaultImpl != null) {
                throw new java.lang.IllegalStateException("setDefaultImpl() called twice");
            }
            if (onDycEnableChangedListener == null) {
                return false;
            }
            com.getui.gtc.api.OnDycEnableChangedListener.Stub.Proxy.sDefaultImpl = onDycEnableChangedListener;
            return true;
        }

        @Override // android.os.IInterface
        public android.os.IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, android.os.Parcel parcel, android.os.Parcel parcel2, int i2) throws android.os.RemoteException {
            if (i != 1) {
                if (i != 1598968902) {
                    return super.onTransact(i, parcel, parcel2, i2);
                }
                parcel2.writeString(DESCRIPTOR);
                return true;
            }
            parcel.enforceInterface(DESCRIPTOR);
            onDycEnableChanged(parcel.readHashMap(getClass().getClassLoader()));
            parcel2.writeNoException();
            return true;
        }
    }

    void onDycEnableChanged(java.util.Map map) throws android.os.RemoteException;
}
