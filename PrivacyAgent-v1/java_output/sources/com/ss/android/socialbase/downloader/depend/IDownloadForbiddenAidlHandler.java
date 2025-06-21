package com.ss.android.socialbase.downloader.depend;

/* loaded from: classes19.dex */
public interface IDownloadForbiddenAidlHandler extends android.os.IInterface {

    public static class Default implements com.ss.android.socialbase.downloader.depend.IDownloadForbiddenAidlHandler {
        @Override // android.os.IInterface
        public android.os.IBinder asBinder() {
            return null;
        }

        @Override // com.ss.android.socialbase.downloader.depend.IDownloadForbiddenAidlHandler
        public boolean onForbidden(com.ss.android.socialbase.downloader.depend.IDownloadForbiddenAidlCallback iDownloadForbiddenAidlCallback) throws android.os.RemoteException {
            return false;
        }
    }

    public static abstract class Stub extends android.os.Binder implements com.ss.android.socialbase.downloader.depend.IDownloadForbiddenAidlHandler {
        private static final java.lang.String DESCRIPTOR = "com.ss.android.socialbase.downloader.depend.IDownloadForbiddenAidlHandler";
        static final int TRANSACTION_onForbidden = 1;

        public static class Proxy implements com.ss.android.socialbase.downloader.depend.IDownloadForbiddenAidlHandler {
            public static com.ss.android.socialbase.downloader.depend.IDownloadForbiddenAidlHandler sDefaultImpl;
            private android.os.IBinder mRemote;

            public Proxy(android.os.IBinder iBinder) {
                this.mRemote = iBinder;
            }

            @Override // android.os.IInterface
            public android.os.IBinder asBinder() {
                return this.mRemote;
            }

            public java.lang.String getInterfaceDescriptor() {
                return com.ss.android.socialbase.downloader.depend.IDownloadForbiddenAidlHandler.Stub.DESCRIPTOR;
            }

            @Override // com.ss.android.socialbase.downloader.depend.IDownloadForbiddenAidlHandler
            public boolean onForbidden(com.ss.android.socialbase.downloader.depend.IDownloadForbiddenAidlCallback iDownloadForbiddenAidlCallback) throws android.os.RemoteException {
                android.os.Parcel obtain = android.os.Parcel.obtain();
                android.os.Parcel obtain2 = android.os.Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(com.ss.android.socialbase.downloader.depend.IDownloadForbiddenAidlHandler.Stub.DESCRIPTOR);
                    obtain.writeStrongBinder(iDownloadForbiddenAidlCallback != null ? iDownloadForbiddenAidlCallback.asBinder() : null);
                    if (!this.mRemote.transact(1, obtain, obtain2, 0) && com.ss.android.socialbase.downloader.depend.IDownloadForbiddenAidlHandler.Stub.getDefaultImpl() != null) {
                        return com.ss.android.socialbase.downloader.depend.IDownloadForbiddenAidlHandler.Stub.getDefaultImpl().onForbidden(iDownloadForbiddenAidlCallback);
                    }
                    obtain2.readException();
                    return obtain2.readInt() != 0;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

        public Stub() {
            attachInterface(this, DESCRIPTOR);
        }

        public static com.ss.android.socialbase.downloader.depend.IDownloadForbiddenAidlHandler asInterface(android.os.IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            android.os.IInterface queryLocalInterface = iBinder.queryLocalInterface(DESCRIPTOR);
            return (queryLocalInterface == null || !(queryLocalInterface instanceof com.ss.android.socialbase.downloader.depend.IDownloadForbiddenAidlHandler)) ? new com.ss.android.socialbase.downloader.depend.IDownloadForbiddenAidlHandler.Stub.Proxy(iBinder) : (com.ss.android.socialbase.downloader.depend.IDownloadForbiddenAidlHandler) queryLocalInterface;
        }

        public static com.ss.android.socialbase.downloader.depend.IDownloadForbiddenAidlHandler getDefaultImpl() {
            return com.ss.android.socialbase.downloader.depend.IDownloadForbiddenAidlHandler.Stub.Proxy.sDefaultImpl;
        }

        public static boolean setDefaultImpl(com.ss.android.socialbase.downloader.depend.IDownloadForbiddenAidlHandler iDownloadForbiddenAidlHandler) {
            if (com.ss.android.socialbase.downloader.depend.IDownloadForbiddenAidlHandler.Stub.Proxy.sDefaultImpl != null || iDownloadForbiddenAidlHandler == null) {
                return false;
            }
            com.ss.android.socialbase.downloader.depend.IDownloadForbiddenAidlHandler.Stub.Proxy.sDefaultImpl = iDownloadForbiddenAidlHandler;
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
            boolean onForbidden = onForbidden(com.ss.android.socialbase.downloader.depend.IDownloadForbiddenAidlCallback.Stub.asInterface(parcel.readStrongBinder()));
            parcel2.writeNoException();
            parcel2.writeInt(onForbidden ? 1 : 0);
            return true;
        }
    }

    boolean onForbidden(com.ss.android.socialbase.downloader.depend.IDownloadForbiddenAidlCallback iDownloadForbiddenAidlCallback) throws android.os.RemoteException;
}
