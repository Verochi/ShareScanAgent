package com.ss.android.socialbase.downloader.depend;

/* loaded from: classes19.dex */
public interface IDownloadAidlInterceptor extends android.os.IInterface {

    public static class Default implements com.ss.android.socialbase.downloader.depend.IDownloadAidlInterceptor {
        @Override // android.os.IInterface
        public android.os.IBinder asBinder() {
            return null;
        }

        @Override // com.ss.android.socialbase.downloader.depend.IDownloadAidlInterceptor
        public boolean intercept() throws android.os.RemoteException {
            return false;
        }
    }

    public static abstract class Stub extends android.os.Binder implements com.ss.android.socialbase.downloader.depend.IDownloadAidlInterceptor {
        private static final java.lang.String DESCRIPTOR = "com.ss.android.socialbase.downloader.depend.IDownloadAidlInterceptor";
        static final int TRANSACTION_intercept = 1;

        public static class Proxy implements com.ss.android.socialbase.downloader.depend.IDownloadAidlInterceptor {
            public static com.ss.android.socialbase.downloader.depend.IDownloadAidlInterceptor sDefaultImpl;
            private android.os.IBinder mRemote;

            public Proxy(android.os.IBinder iBinder) {
                this.mRemote = iBinder;
            }

            @Override // android.os.IInterface
            public android.os.IBinder asBinder() {
                return this.mRemote;
            }

            public java.lang.String getInterfaceDescriptor() {
                return com.ss.android.socialbase.downloader.depend.IDownloadAidlInterceptor.Stub.DESCRIPTOR;
            }

            @Override // com.ss.android.socialbase.downloader.depend.IDownloadAidlInterceptor
            public boolean intercept() throws android.os.RemoteException {
                android.os.Parcel obtain = android.os.Parcel.obtain();
                android.os.Parcel obtain2 = android.os.Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(com.ss.android.socialbase.downloader.depend.IDownloadAidlInterceptor.Stub.DESCRIPTOR);
                    if (!this.mRemote.transact(1, obtain, obtain2, 0) && com.ss.android.socialbase.downloader.depend.IDownloadAidlInterceptor.Stub.getDefaultImpl() != null) {
                        return com.ss.android.socialbase.downloader.depend.IDownloadAidlInterceptor.Stub.getDefaultImpl().intercept();
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

        public static com.ss.android.socialbase.downloader.depend.IDownloadAidlInterceptor asInterface(android.os.IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            android.os.IInterface queryLocalInterface = iBinder.queryLocalInterface(DESCRIPTOR);
            return (queryLocalInterface == null || !(queryLocalInterface instanceof com.ss.android.socialbase.downloader.depend.IDownloadAidlInterceptor)) ? new com.ss.android.socialbase.downloader.depend.IDownloadAidlInterceptor.Stub.Proxy(iBinder) : (com.ss.android.socialbase.downloader.depend.IDownloadAidlInterceptor) queryLocalInterface;
        }

        public static com.ss.android.socialbase.downloader.depend.IDownloadAidlInterceptor getDefaultImpl() {
            return com.ss.android.socialbase.downloader.depend.IDownloadAidlInterceptor.Stub.Proxy.sDefaultImpl;
        }

        public static boolean setDefaultImpl(com.ss.android.socialbase.downloader.depend.IDownloadAidlInterceptor iDownloadAidlInterceptor) {
            if (com.ss.android.socialbase.downloader.depend.IDownloadAidlInterceptor.Stub.Proxy.sDefaultImpl != null || iDownloadAidlInterceptor == null) {
                return false;
            }
            com.ss.android.socialbase.downloader.depend.IDownloadAidlInterceptor.Stub.Proxy.sDefaultImpl = iDownloadAidlInterceptor;
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
            boolean intercept = intercept();
            parcel2.writeNoException();
            parcel2.writeInt(intercept ? 1 : 0);
            return true;
        }
    }

    boolean intercept() throws android.os.RemoteException;
}
