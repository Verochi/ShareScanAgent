package com.miui.externalserver;

/* loaded from: classes23.dex */
public interface IExternalMediaSplashAdListener extends android.os.IInterface {

    public static class Default implements com.miui.externalserver.IExternalMediaSplashAdListener {
        @Override // android.os.IInterface
        public android.os.IBinder asBinder() {
            return null;
        }

        @Override // com.miui.externalserver.IExternalMediaSplashAdListener
        public void onAdError(int i) throws android.os.RemoteException {
        }

        @Override // com.miui.externalserver.IExternalMediaSplashAdListener
        public void onAdLoaded() throws android.os.RemoteException {
        }
    }

    public static abstract class Stub extends android.os.Binder implements com.miui.externalserver.IExternalMediaSplashAdListener {
        private static final java.lang.String DESCRIPTOR = "com.miui.externalserver.IExternalMediaSplashAdListener";
        static final int TRANSACTION_onAdError = 1;
        static final int TRANSACTION_onAdLoaded = 2;

        public static class Proxy implements com.miui.externalserver.IExternalMediaSplashAdListener {
            public static com.miui.externalserver.IExternalMediaSplashAdListener sDefaultImpl;
            private android.os.IBinder mRemote;

            public Proxy(android.os.IBinder iBinder) {
                this.mRemote = iBinder;
            }

            @Override // android.os.IInterface
            public android.os.IBinder asBinder() {
                return this.mRemote;
            }

            public java.lang.String getInterfaceDescriptor() {
                return com.miui.externalserver.IExternalMediaSplashAdListener.Stub.DESCRIPTOR;
            }

            @Override // com.miui.externalserver.IExternalMediaSplashAdListener
            public void onAdError(int i) throws android.os.RemoteException {
                android.os.Parcel obtain = android.os.Parcel.obtain();
                android.os.Parcel obtain2 = android.os.Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(com.miui.externalserver.IExternalMediaSplashAdListener.Stub.DESCRIPTOR);
                    obtain.writeInt(i);
                    if (this.mRemote.transact(1, obtain, obtain2, 0) || com.miui.externalserver.IExternalMediaSplashAdListener.Stub.getDefaultImpl() == null) {
                        obtain2.readException();
                    } else {
                        com.miui.externalserver.IExternalMediaSplashAdListener.Stub.getDefaultImpl().onAdError(i);
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.miui.externalserver.IExternalMediaSplashAdListener
            public void onAdLoaded() throws android.os.RemoteException {
                android.os.Parcel obtain = android.os.Parcel.obtain();
                android.os.Parcel obtain2 = android.os.Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(com.miui.externalserver.IExternalMediaSplashAdListener.Stub.DESCRIPTOR);
                    if (this.mRemote.transact(2, obtain, obtain2, 0) || com.miui.externalserver.IExternalMediaSplashAdListener.Stub.getDefaultImpl() == null) {
                        obtain2.readException();
                    } else {
                        com.miui.externalserver.IExternalMediaSplashAdListener.Stub.getDefaultImpl().onAdLoaded();
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

        public static com.miui.externalserver.IExternalMediaSplashAdListener asInterface(android.os.IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            android.os.IInterface queryLocalInterface = iBinder.queryLocalInterface(DESCRIPTOR);
            return (queryLocalInterface == null || !(queryLocalInterface instanceof com.miui.externalserver.IExternalMediaSplashAdListener)) ? new com.miui.externalserver.IExternalMediaSplashAdListener.Stub.Proxy(iBinder) : (com.miui.externalserver.IExternalMediaSplashAdListener) queryLocalInterface;
        }

        public static com.miui.externalserver.IExternalMediaSplashAdListener getDefaultImpl() {
            return com.miui.externalserver.IExternalMediaSplashAdListener.Stub.Proxy.sDefaultImpl;
        }

        public static boolean setDefaultImpl(com.miui.externalserver.IExternalMediaSplashAdListener iExternalMediaSplashAdListener) {
            if (com.miui.externalserver.IExternalMediaSplashAdListener.Stub.Proxy.sDefaultImpl != null) {
                throw new java.lang.IllegalStateException("setDefaultImpl() called twice");
            }
            if (iExternalMediaSplashAdListener == null) {
                return false;
            }
            com.miui.externalserver.IExternalMediaSplashAdListener.Stub.Proxy.sDefaultImpl = iExternalMediaSplashAdListener;
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
                onAdError(parcel.readInt());
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
            onAdLoaded();
            parcel2.writeNoException();
            return true;
        }
    }

    void onAdError(int i) throws android.os.RemoteException;

    void onAdLoaded() throws android.os.RemoteException;
}
