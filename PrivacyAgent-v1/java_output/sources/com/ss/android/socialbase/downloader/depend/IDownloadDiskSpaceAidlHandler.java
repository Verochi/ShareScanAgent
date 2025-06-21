package com.ss.android.socialbase.downloader.depend;

/* loaded from: classes19.dex */
public interface IDownloadDiskSpaceAidlHandler extends android.os.IInterface {

    public static class Default implements com.ss.android.socialbase.downloader.depend.IDownloadDiskSpaceAidlHandler {
        @Override // android.os.IInterface
        public android.os.IBinder asBinder() {
            return null;
        }

        @Override // com.ss.android.socialbase.downloader.depend.IDownloadDiskSpaceAidlHandler
        public boolean cleanUpDisk(long j, long j2, com.ss.android.socialbase.downloader.depend.IDownloadDiskSpaceAidlCallback iDownloadDiskSpaceAidlCallback) throws android.os.RemoteException {
            return false;
        }
    }

    public static abstract class Stub extends android.os.Binder implements com.ss.android.socialbase.downloader.depend.IDownloadDiskSpaceAidlHandler {
        private static final java.lang.String DESCRIPTOR = "com.ss.android.socialbase.downloader.depend.IDownloadDiskSpaceAidlHandler";
        static final int TRANSACTION_cleanUpDisk = 1;

        public static class Proxy implements com.ss.android.socialbase.downloader.depend.IDownloadDiskSpaceAidlHandler {
            public static com.ss.android.socialbase.downloader.depend.IDownloadDiskSpaceAidlHandler sDefaultImpl;
            private android.os.IBinder mRemote;

            public Proxy(android.os.IBinder iBinder) {
                this.mRemote = iBinder;
            }

            @Override // android.os.IInterface
            public android.os.IBinder asBinder() {
                return this.mRemote;
            }

            @Override // com.ss.android.socialbase.downloader.depend.IDownloadDiskSpaceAidlHandler
            public boolean cleanUpDisk(long j, long j2, com.ss.android.socialbase.downloader.depend.IDownloadDiskSpaceAidlCallback iDownloadDiskSpaceAidlCallback) throws android.os.RemoteException {
                android.os.Parcel obtain = android.os.Parcel.obtain();
                android.os.Parcel obtain2 = android.os.Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(com.ss.android.socialbase.downloader.depend.IDownloadDiskSpaceAidlHandler.Stub.DESCRIPTOR);
                    obtain.writeLong(j);
                    obtain.writeLong(j2);
                    obtain.writeStrongBinder(iDownloadDiskSpaceAidlCallback != null ? iDownloadDiskSpaceAidlCallback.asBinder() : null);
                    if (!this.mRemote.transact(1, obtain, obtain2, 0) && com.ss.android.socialbase.downloader.depend.IDownloadDiskSpaceAidlHandler.Stub.getDefaultImpl() != null) {
                        return com.ss.android.socialbase.downloader.depend.IDownloadDiskSpaceAidlHandler.Stub.getDefaultImpl().cleanUpDisk(j, j2, iDownloadDiskSpaceAidlCallback);
                    }
                    obtain2.readException();
                    return obtain2.readInt() != 0;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public java.lang.String getInterfaceDescriptor() {
                return com.ss.android.socialbase.downloader.depend.IDownloadDiskSpaceAidlHandler.Stub.DESCRIPTOR;
            }
        }

        public Stub() {
            attachInterface(this, DESCRIPTOR);
        }

        public static com.ss.android.socialbase.downloader.depend.IDownloadDiskSpaceAidlHandler asInterface(android.os.IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            android.os.IInterface queryLocalInterface = iBinder.queryLocalInterface(DESCRIPTOR);
            return (queryLocalInterface == null || !(queryLocalInterface instanceof com.ss.android.socialbase.downloader.depend.IDownloadDiskSpaceAidlHandler)) ? new com.ss.android.socialbase.downloader.depend.IDownloadDiskSpaceAidlHandler.Stub.Proxy(iBinder) : (com.ss.android.socialbase.downloader.depend.IDownloadDiskSpaceAidlHandler) queryLocalInterface;
        }

        public static com.ss.android.socialbase.downloader.depend.IDownloadDiskSpaceAidlHandler getDefaultImpl() {
            return com.ss.android.socialbase.downloader.depend.IDownloadDiskSpaceAidlHandler.Stub.Proxy.sDefaultImpl;
        }

        public static boolean setDefaultImpl(com.ss.android.socialbase.downloader.depend.IDownloadDiskSpaceAidlHandler iDownloadDiskSpaceAidlHandler) {
            if (com.ss.android.socialbase.downloader.depend.IDownloadDiskSpaceAidlHandler.Stub.Proxy.sDefaultImpl != null || iDownloadDiskSpaceAidlHandler == null) {
                return false;
            }
            com.ss.android.socialbase.downloader.depend.IDownloadDiskSpaceAidlHandler.Stub.Proxy.sDefaultImpl = iDownloadDiskSpaceAidlHandler;
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
            boolean cleanUpDisk = cleanUpDisk(parcel.readLong(), parcel.readLong(), com.ss.android.socialbase.downloader.depend.IDownloadDiskSpaceAidlCallback.Stub.asInterface(parcel.readStrongBinder()));
            parcel2.writeNoException();
            parcel2.writeInt(cleanUpDisk ? 1 : 0);
            return true;
        }
    }

    boolean cleanUpDisk(long j, long j2, com.ss.android.socialbase.downloader.depend.IDownloadDiskSpaceAidlCallback iDownloadDiskSpaceAidlCallback) throws android.os.RemoteException;
}
