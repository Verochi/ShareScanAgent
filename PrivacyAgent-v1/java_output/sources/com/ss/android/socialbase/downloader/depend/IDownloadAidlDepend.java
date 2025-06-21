package com.ss.android.socialbase.downloader.depend;

/* loaded from: classes19.dex */
public interface IDownloadAidlDepend extends android.os.IInterface {

    public static class Default implements com.ss.android.socialbase.downloader.depend.IDownloadAidlDepend {
        @Override // android.os.IInterface
        public android.os.IBinder asBinder() {
            return null;
        }

        @Override // com.ss.android.socialbase.downloader.depend.IDownloadAidlDepend
        public void monitorLogSend(com.ss.android.socialbase.downloader.model.DownloadInfo downloadInfo, com.ss.android.socialbase.downloader.exception.BaseException baseException, int i) throws android.os.RemoteException {
        }
    }

    public static abstract class Stub extends android.os.Binder implements com.ss.android.socialbase.downloader.depend.IDownloadAidlDepend {
        private static final java.lang.String DESCRIPTOR = "com.ss.android.socialbase.downloader.depend.IDownloadAidlDepend";
        static final int TRANSACTION_monitorLogSend = 1;

        public static class Proxy implements com.ss.android.socialbase.downloader.depend.IDownloadAidlDepend {
            public static com.ss.android.socialbase.downloader.depend.IDownloadAidlDepend sDefaultImpl;
            private android.os.IBinder mRemote;

            public Proxy(android.os.IBinder iBinder) {
                this.mRemote = iBinder;
            }

            @Override // android.os.IInterface
            public android.os.IBinder asBinder() {
                return this.mRemote;
            }

            public java.lang.String getInterfaceDescriptor() {
                return com.ss.android.socialbase.downloader.depend.IDownloadAidlDepend.Stub.DESCRIPTOR;
            }

            @Override // com.ss.android.socialbase.downloader.depend.IDownloadAidlDepend
            public void monitorLogSend(com.ss.android.socialbase.downloader.model.DownloadInfo downloadInfo, com.ss.android.socialbase.downloader.exception.BaseException baseException, int i) throws android.os.RemoteException {
                android.os.Parcel obtain = android.os.Parcel.obtain();
                android.os.Parcel obtain2 = android.os.Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(com.ss.android.socialbase.downloader.depend.IDownloadAidlDepend.Stub.DESCRIPTOR);
                    if (downloadInfo != null) {
                        obtain.writeInt(1);
                        downloadInfo.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (baseException != null) {
                        obtain.writeInt(1);
                        baseException.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeInt(i);
                    if (this.mRemote.transact(1, obtain, obtain2, 0) || com.ss.android.socialbase.downloader.depend.IDownloadAidlDepend.Stub.getDefaultImpl() == null) {
                        obtain2.readException();
                    } else {
                        com.ss.android.socialbase.downloader.depend.IDownloadAidlDepend.Stub.getDefaultImpl().monitorLogSend(downloadInfo, baseException, i);
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

        public static com.ss.android.socialbase.downloader.depend.IDownloadAidlDepend asInterface(android.os.IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            android.os.IInterface queryLocalInterface = iBinder.queryLocalInterface(DESCRIPTOR);
            return (queryLocalInterface == null || !(queryLocalInterface instanceof com.ss.android.socialbase.downloader.depend.IDownloadAidlDepend)) ? new com.ss.android.socialbase.downloader.depend.IDownloadAidlDepend.Stub.Proxy(iBinder) : (com.ss.android.socialbase.downloader.depend.IDownloadAidlDepend) queryLocalInterface;
        }

        public static com.ss.android.socialbase.downloader.depend.IDownloadAidlDepend getDefaultImpl() {
            return com.ss.android.socialbase.downloader.depend.IDownloadAidlDepend.Stub.Proxy.sDefaultImpl;
        }

        public static boolean setDefaultImpl(com.ss.android.socialbase.downloader.depend.IDownloadAidlDepend iDownloadAidlDepend) {
            if (com.ss.android.socialbase.downloader.depend.IDownloadAidlDepend.Stub.Proxy.sDefaultImpl != null || iDownloadAidlDepend == null) {
                return false;
            }
            com.ss.android.socialbase.downloader.depend.IDownloadAidlDepend.Stub.Proxy.sDefaultImpl = iDownloadAidlDepend;
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
            monitorLogSend(parcel.readInt() != 0 ? com.ss.android.socialbase.downloader.model.DownloadInfo.CREATOR.createFromParcel(parcel) : null, parcel.readInt() != 0 ? com.ss.android.socialbase.downloader.exception.BaseException.CREATOR.createFromParcel(parcel) : null, parcel.readInt());
            parcel2.writeNoException();
            return true;
        }
    }

    void monitorLogSend(com.ss.android.socialbase.downloader.model.DownloadInfo downloadInfo, com.ss.android.socialbase.downloader.exception.BaseException baseException, int i) throws android.os.RemoteException;
}
