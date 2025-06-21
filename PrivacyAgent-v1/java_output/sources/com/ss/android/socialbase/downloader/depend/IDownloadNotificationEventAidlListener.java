package com.ss.android.socialbase.downloader.depend;

/* loaded from: classes19.dex */
public interface IDownloadNotificationEventAidlListener extends android.os.IInterface {

    public static class Default implements com.ss.android.socialbase.downloader.depend.IDownloadNotificationEventAidlListener {
        @Override // android.os.IInterface
        public android.os.IBinder asBinder() {
            return null;
        }

        @Override // com.ss.android.socialbase.downloader.depend.IDownloadNotificationEventAidlListener
        public java.lang.String getNotifyProcessName() throws android.os.RemoteException {
            return null;
        }

        @Override // com.ss.android.socialbase.downloader.depend.IDownloadNotificationEventAidlListener
        public boolean interceptAfterNotificationSuccess(boolean z) throws android.os.RemoteException {
            return false;
        }

        @Override // com.ss.android.socialbase.downloader.depend.IDownloadNotificationEventAidlListener
        public void onNotificationEvent(int i, com.ss.android.socialbase.downloader.model.DownloadInfo downloadInfo, java.lang.String str, java.lang.String str2) throws android.os.RemoteException {
        }
    }

    public static abstract class Stub extends android.os.Binder implements com.ss.android.socialbase.downloader.depend.IDownloadNotificationEventAidlListener {
        private static final java.lang.String DESCRIPTOR = "com.ss.android.socialbase.downloader.depend.IDownloadNotificationEventAidlListener";
        static final int TRANSACTION_getNotifyProcessName = 3;
        static final int TRANSACTION_interceptAfterNotificationSuccess = 2;
        static final int TRANSACTION_onNotificationEvent = 1;

        public static class Proxy implements com.ss.android.socialbase.downloader.depend.IDownloadNotificationEventAidlListener {
            public static com.ss.android.socialbase.downloader.depend.IDownloadNotificationEventAidlListener sDefaultImpl;
            private android.os.IBinder mRemote;

            public Proxy(android.os.IBinder iBinder) {
                this.mRemote = iBinder;
            }

            @Override // android.os.IInterface
            public android.os.IBinder asBinder() {
                return this.mRemote;
            }

            public java.lang.String getInterfaceDescriptor() {
                return com.ss.android.socialbase.downloader.depend.IDownloadNotificationEventAidlListener.Stub.DESCRIPTOR;
            }

            @Override // com.ss.android.socialbase.downloader.depend.IDownloadNotificationEventAidlListener
            public java.lang.String getNotifyProcessName() throws android.os.RemoteException {
                android.os.Parcel obtain = android.os.Parcel.obtain();
                android.os.Parcel obtain2 = android.os.Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(com.ss.android.socialbase.downloader.depend.IDownloadNotificationEventAidlListener.Stub.DESCRIPTOR);
                    if (!this.mRemote.transact(3, obtain, obtain2, 0) && com.ss.android.socialbase.downloader.depend.IDownloadNotificationEventAidlListener.Stub.getDefaultImpl() != null) {
                        return com.ss.android.socialbase.downloader.depend.IDownloadNotificationEventAidlListener.Stub.getDefaultImpl().getNotifyProcessName();
                    }
                    obtain2.readException();
                    return obtain2.readString();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.ss.android.socialbase.downloader.depend.IDownloadNotificationEventAidlListener
            public boolean interceptAfterNotificationSuccess(boolean z) throws android.os.RemoteException {
                android.os.Parcel obtain = android.os.Parcel.obtain();
                android.os.Parcel obtain2 = android.os.Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(com.ss.android.socialbase.downloader.depend.IDownloadNotificationEventAidlListener.Stub.DESCRIPTOR);
                    obtain.writeInt(z ? 1 : 0);
                    if (!this.mRemote.transact(2, obtain, obtain2, 0) && com.ss.android.socialbase.downloader.depend.IDownloadNotificationEventAidlListener.Stub.getDefaultImpl() != null) {
                        return com.ss.android.socialbase.downloader.depend.IDownloadNotificationEventAidlListener.Stub.getDefaultImpl().interceptAfterNotificationSuccess(z);
                    }
                    obtain2.readException();
                    return obtain2.readInt() != 0;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.ss.android.socialbase.downloader.depend.IDownloadNotificationEventAidlListener
            public void onNotificationEvent(int i, com.ss.android.socialbase.downloader.model.DownloadInfo downloadInfo, java.lang.String str, java.lang.String str2) throws android.os.RemoteException {
                android.os.Parcel obtain = android.os.Parcel.obtain();
                android.os.Parcel obtain2 = android.os.Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(com.ss.android.socialbase.downloader.depend.IDownloadNotificationEventAidlListener.Stub.DESCRIPTOR);
                    obtain.writeInt(i);
                    if (downloadInfo != null) {
                        obtain.writeInt(1);
                        downloadInfo.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    if (this.mRemote.transact(1, obtain, obtain2, 0) || com.ss.android.socialbase.downloader.depend.IDownloadNotificationEventAidlListener.Stub.getDefaultImpl() == null) {
                        obtain2.readException();
                    } else {
                        com.ss.android.socialbase.downloader.depend.IDownloadNotificationEventAidlListener.Stub.getDefaultImpl().onNotificationEvent(i, downloadInfo, str, str2);
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

        public static com.ss.android.socialbase.downloader.depend.IDownloadNotificationEventAidlListener asInterface(android.os.IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            android.os.IInterface queryLocalInterface = iBinder.queryLocalInterface(DESCRIPTOR);
            return (queryLocalInterface == null || !(queryLocalInterface instanceof com.ss.android.socialbase.downloader.depend.IDownloadNotificationEventAidlListener)) ? new com.ss.android.socialbase.downloader.depend.IDownloadNotificationEventAidlListener.Stub.Proxy(iBinder) : (com.ss.android.socialbase.downloader.depend.IDownloadNotificationEventAidlListener) queryLocalInterface;
        }

        public static com.ss.android.socialbase.downloader.depend.IDownloadNotificationEventAidlListener getDefaultImpl() {
            return com.ss.android.socialbase.downloader.depend.IDownloadNotificationEventAidlListener.Stub.Proxy.sDefaultImpl;
        }

        public static boolean setDefaultImpl(com.ss.android.socialbase.downloader.depend.IDownloadNotificationEventAidlListener iDownloadNotificationEventAidlListener) {
            if (com.ss.android.socialbase.downloader.depend.IDownloadNotificationEventAidlListener.Stub.Proxy.sDefaultImpl != null || iDownloadNotificationEventAidlListener == null) {
                return false;
            }
            com.ss.android.socialbase.downloader.depend.IDownloadNotificationEventAidlListener.Stub.Proxy.sDefaultImpl = iDownloadNotificationEventAidlListener;
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
                onNotificationEvent(parcel.readInt(), parcel.readInt() != 0 ? com.ss.android.socialbase.downloader.model.DownloadInfo.CREATOR.createFromParcel(parcel) : null, parcel.readString(), parcel.readString());
                parcel2.writeNoException();
                return true;
            }
            if (i == 2) {
                parcel.enforceInterface(DESCRIPTOR);
                boolean interceptAfterNotificationSuccess = interceptAfterNotificationSuccess(parcel.readInt() != 0);
                parcel2.writeNoException();
                parcel2.writeInt(interceptAfterNotificationSuccess ? 1 : 0);
                return true;
            }
            if (i != 3) {
                if (i != 1598968902) {
                    return super.onTransact(i, parcel, parcel2, i2);
                }
                parcel2.writeString(DESCRIPTOR);
                return true;
            }
            parcel.enforceInterface(DESCRIPTOR);
            java.lang.String notifyProcessName = getNotifyProcessName();
            parcel2.writeNoException();
            parcel2.writeString(notifyProcessName);
            return true;
        }
    }

    java.lang.String getNotifyProcessName() throws android.os.RemoteException;

    boolean interceptAfterNotificationSuccess(boolean z) throws android.os.RemoteException;

    void onNotificationEvent(int i, com.ss.android.socialbase.downloader.model.DownloadInfo downloadInfo, java.lang.String str, java.lang.String str2) throws android.os.RemoteException;
}
