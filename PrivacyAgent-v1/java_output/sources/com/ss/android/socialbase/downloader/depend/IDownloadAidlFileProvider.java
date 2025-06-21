package com.ss.android.socialbase.downloader.depend;

/* loaded from: classes19.dex */
public interface IDownloadAidlFileProvider extends android.os.IInterface {

    public static class Default implements com.ss.android.socialbase.downloader.depend.IDownloadAidlFileProvider {
        @Override // android.os.IInterface
        public android.os.IBinder asBinder() {
            return null;
        }

        @Override // com.ss.android.socialbase.downloader.depend.IDownloadAidlFileProvider
        public android.net.Uri getUriForFile(java.lang.String str, java.lang.String str2) throws android.os.RemoteException {
            return null;
        }
    }

    public static abstract class Stub extends android.os.Binder implements com.ss.android.socialbase.downloader.depend.IDownloadAidlFileProvider {
        private static final java.lang.String DESCRIPTOR = "com.ss.android.socialbase.downloader.depend.IDownloadAidlFileProvider";
        static final int TRANSACTION_getUriForFile = 1;

        public static class Proxy implements com.ss.android.socialbase.downloader.depend.IDownloadAidlFileProvider {
            public static com.ss.android.socialbase.downloader.depend.IDownloadAidlFileProvider sDefaultImpl;
            private android.os.IBinder mRemote;

            public Proxy(android.os.IBinder iBinder) {
                this.mRemote = iBinder;
            }

            @Override // android.os.IInterface
            public android.os.IBinder asBinder() {
                return this.mRemote;
            }

            public java.lang.String getInterfaceDescriptor() {
                return com.ss.android.socialbase.downloader.depend.IDownloadAidlFileProvider.Stub.DESCRIPTOR;
            }

            @Override // com.ss.android.socialbase.downloader.depend.IDownloadAidlFileProvider
            public android.net.Uri getUriForFile(java.lang.String str, java.lang.String str2) throws android.os.RemoteException {
                android.os.Parcel obtain = android.os.Parcel.obtain();
                android.os.Parcel obtain2 = android.os.Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(com.ss.android.socialbase.downloader.depend.IDownloadAidlFileProvider.Stub.DESCRIPTOR);
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    if (!this.mRemote.transact(1, obtain, obtain2, 0) && com.ss.android.socialbase.downloader.depend.IDownloadAidlFileProvider.Stub.getDefaultImpl() != null) {
                        return com.ss.android.socialbase.downloader.depend.IDownloadAidlFileProvider.Stub.getDefaultImpl().getUriForFile(str, str2);
                    }
                    obtain2.readException();
                    return obtain2.readInt() != 0 ? (android.net.Uri) android.net.Uri.CREATOR.createFromParcel(obtain2) : null;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

        public Stub() {
            attachInterface(this, DESCRIPTOR);
        }

        public static com.ss.android.socialbase.downloader.depend.IDownloadAidlFileProvider asInterface(android.os.IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            android.os.IInterface queryLocalInterface = iBinder.queryLocalInterface(DESCRIPTOR);
            return (queryLocalInterface == null || !(queryLocalInterface instanceof com.ss.android.socialbase.downloader.depend.IDownloadAidlFileProvider)) ? new com.ss.android.socialbase.downloader.depend.IDownloadAidlFileProvider.Stub.Proxy(iBinder) : (com.ss.android.socialbase.downloader.depend.IDownloadAidlFileProvider) queryLocalInterface;
        }

        public static com.ss.android.socialbase.downloader.depend.IDownloadAidlFileProvider getDefaultImpl() {
            return com.ss.android.socialbase.downloader.depend.IDownloadAidlFileProvider.Stub.Proxy.sDefaultImpl;
        }

        public static boolean setDefaultImpl(com.ss.android.socialbase.downloader.depend.IDownloadAidlFileProvider iDownloadAidlFileProvider) {
            if (com.ss.android.socialbase.downloader.depend.IDownloadAidlFileProvider.Stub.Proxy.sDefaultImpl != null || iDownloadAidlFileProvider == null) {
                return false;
            }
            com.ss.android.socialbase.downloader.depend.IDownloadAidlFileProvider.Stub.Proxy.sDefaultImpl = iDownloadAidlFileProvider;
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
            android.net.Uri uriForFile = getUriForFile(parcel.readString(), parcel.readString());
            parcel2.writeNoException();
            if (uriForFile != null) {
                parcel2.writeInt(1);
                uriForFile.writeToParcel(parcel2, 1);
            } else {
                parcel2.writeInt(0);
            }
            return true;
        }
    }

    android.net.Uri getUriForFile(java.lang.String str, java.lang.String str2) throws android.os.RemoteException;
}
