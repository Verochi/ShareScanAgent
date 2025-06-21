package com.miui.externalserver;

/* loaded from: classes23.dex */
public interface IExternalMediaSplashAdService extends android.os.IInterface {

    public static class Default implements com.miui.externalserver.IExternalMediaSplashAdService {
        @Override // android.os.IInterface
        public android.os.IBinder asBinder() {
            return null;
        }

        @Override // com.miui.externalserver.IExternalMediaSplashAdService
        public void cancelSplashAd(java.lang.String str) throws android.os.RemoteException {
        }

        @Override // com.miui.externalserver.IExternalMediaSplashAdService
        public void requestSplashAd(java.lang.String str, com.miui.externalserver.IExternalMediaSplashAdListener iExternalMediaSplashAdListener, android.os.Bundle bundle) throws android.os.RemoteException {
        }
    }

    public static abstract class Stub extends android.os.Binder implements com.miui.externalserver.IExternalMediaSplashAdService {
        private static final java.lang.String DESCRIPTOR = "com.miui.externalserver.IExternalMediaSplashAdService";
        static final int TRANSACTION_cancelSplashAd = 2;
        static final int TRANSACTION_requestSplashAd = 1;

        public static class Proxy implements com.miui.externalserver.IExternalMediaSplashAdService {
            public static com.miui.externalserver.IExternalMediaSplashAdService sDefaultImpl;
            private android.os.IBinder mRemote;

            public Proxy(android.os.IBinder iBinder) {
                this.mRemote = iBinder;
            }

            @Override // android.os.IInterface
            public android.os.IBinder asBinder() {
                return this.mRemote;
            }

            @Override // com.miui.externalserver.IExternalMediaSplashAdService
            public void cancelSplashAd(java.lang.String str) throws android.os.RemoteException {
                android.os.Parcel obtain = android.os.Parcel.obtain();
                android.os.Parcel obtain2 = android.os.Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(com.miui.externalserver.IExternalMediaSplashAdService.Stub.DESCRIPTOR);
                    obtain.writeString(str);
                    if (this.mRemote.transact(2, obtain, obtain2, 0) || com.miui.externalserver.IExternalMediaSplashAdService.Stub.getDefaultImpl() == null) {
                        obtain2.readException();
                    } else {
                        com.miui.externalserver.IExternalMediaSplashAdService.Stub.getDefaultImpl().cancelSplashAd(str);
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public java.lang.String getInterfaceDescriptor() {
                return com.miui.externalserver.IExternalMediaSplashAdService.Stub.DESCRIPTOR;
            }

            @Override // com.miui.externalserver.IExternalMediaSplashAdService
            public void requestSplashAd(java.lang.String str, com.miui.externalserver.IExternalMediaSplashAdListener iExternalMediaSplashAdListener, android.os.Bundle bundle) throws android.os.RemoteException {
                android.os.Parcel obtain = android.os.Parcel.obtain();
                android.os.Parcel obtain2 = android.os.Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(com.miui.externalserver.IExternalMediaSplashAdService.Stub.DESCRIPTOR);
                    obtain.writeString(str);
                    obtain.writeStrongBinder(iExternalMediaSplashAdListener != null ? iExternalMediaSplashAdListener.asBinder() : null);
                    if (bundle != null) {
                        obtain.writeInt(1);
                        bundle.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (this.mRemote.transact(1, obtain, obtain2, 0) || com.miui.externalserver.IExternalMediaSplashAdService.Stub.getDefaultImpl() == null) {
                        obtain2.readException();
                    } else {
                        com.miui.externalserver.IExternalMediaSplashAdService.Stub.getDefaultImpl().requestSplashAd(str, iExternalMediaSplashAdListener, bundle);
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

        public static com.miui.externalserver.IExternalMediaSplashAdService asInterface(android.os.IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            android.os.IInterface queryLocalInterface = iBinder.queryLocalInterface(DESCRIPTOR);
            return (queryLocalInterface == null || !(queryLocalInterface instanceof com.miui.externalserver.IExternalMediaSplashAdService)) ? new com.miui.externalserver.IExternalMediaSplashAdService.Stub.Proxy(iBinder) : (com.miui.externalserver.IExternalMediaSplashAdService) queryLocalInterface;
        }

        public static com.miui.externalserver.IExternalMediaSplashAdService getDefaultImpl() {
            return com.miui.externalserver.IExternalMediaSplashAdService.Stub.Proxy.sDefaultImpl;
        }

        public static boolean setDefaultImpl(com.miui.externalserver.IExternalMediaSplashAdService iExternalMediaSplashAdService) {
            if (com.miui.externalserver.IExternalMediaSplashAdService.Stub.Proxy.sDefaultImpl != null) {
                throw new java.lang.IllegalStateException("setDefaultImpl() called twice");
            }
            if (iExternalMediaSplashAdService == null) {
                return false;
            }
            com.miui.externalserver.IExternalMediaSplashAdService.Stub.Proxy.sDefaultImpl = iExternalMediaSplashAdService;
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
                requestSplashAd(parcel.readString(), com.miui.externalserver.IExternalMediaSplashAdListener.Stub.asInterface(parcel.readStrongBinder()), parcel.readInt() != 0 ? (android.os.Bundle) android.os.Bundle.CREATOR.createFromParcel(parcel) : null);
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
            cancelSplashAd(parcel.readString());
            parcel2.writeNoException();
            return true;
        }
    }

    void cancelSplashAd(java.lang.String str) throws android.os.RemoteException;

    void requestSplashAd(java.lang.String str, com.miui.externalserver.IExternalMediaSplashAdListener iExternalMediaSplashAdListener, android.os.Bundle bundle) throws android.os.RemoteException;
}
