package com.ss.android.socialbase.downloader.depend;

/* loaded from: classes19.dex */
public interface IDownloadAidlMonitorDepend extends android.os.IInterface {

    public static class Default implements com.ss.android.socialbase.downloader.depend.IDownloadAidlMonitorDepend {
        @Override // android.os.IInterface
        public android.os.IBinder asBinder() {
            return null;
        }

        @Override // com.ss.android.socialbase.downloader.depend.IDownloadAidlMonitorDepend
        public int[] getAdditionalMonitorStatus() throws android.os.RemoteException {
            return null;
        }

        @Override // com.ss.android.socialbase.downloader.depend.IDownloadAidlMonitorDepend
        public java.lang.String getEventPage() throws android.os.RemoteException {
            return null;
        }

        @Override // com.ss.android.socialbase.downloader.depend.IDownloadAidlMonitorDepend
        public void monitorLogSend(java.lang.String str) throws android.os.RemoteException {
        }
    }

    public static abstract class Stub extends android.os.Binder implements com.ss.android.socialbase.downloader.depend.IDownloadAidlMonitorDepend {
        private static final java.lang.String DESCRIPTOR = "com.ss.android.socialbase.downloader.depend.IDownloadAidlMonitorDepend";
        static final int TRANSACTION_getAdditionalMonitorStatus = 3;
        static final int TRANSACTION_getEventPage = 2;
        static final int TRANSACTION_monitorLogSend = 1;

        public static class Proxy implements com.ss.android.socialbase.downloader.depend.IDownloadAidlMonitorDepend {
            public static com.ss.android.socialbase.downloader.depend.IDownloadAidlMonitorDepend sDefaultImpl;
            private android.os.IBinder mRemote;

            public Proxy(android.os.IBinder iBinder) {
                this.mRemote = iBinder;
            }

            @Override // android.os.IInterface
            public android.os.IBinder asBinder() {
                return this.mRemote;
            }

            @Override // com.ss.android.socialbase.downloader.depend.IDownloadAidlMonitorDepend
            public int[] getAdditionalMonitorStatus() throws android.os.RemoteException {
                android.os.Parcel obtain = android.os.Parcel.obtain();
                android.os.Parcel obtain2 = android.os.Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(com.ss.android.socialbase.downloader.depend.IDownloadAidlMonitorDepend.Stub.DESCRIPTOR);
                    if (!this.mRemote.transact(3, obtain, obtain2, 0) && com.ss.android.socialbase.downloader.depend.IDownloadAidlMonitorDepend.Stub.getDefaultImpl() != null) {
                        return com.ss.android.socialbase.downloader.depend.IDownloadAidlMonitorDepend.Stub.getDefaultImpl().getAdditionalMonitorStatus();
                    }
                    obtain2.readException();
                    return obtain2.createIntArray();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.ss.android.socialbase.downloader.depend.IDownloadAidlMonitorDepend
            public java.lang.String getEventPage() throws android.os.RemoteException {
                android.os.Parcel obtain = android.os.Parcel.obtain();
                android.os.Parcel obtain2 = android.os.Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(com.ss.android.socialbase.downloader.depend.IDownloadAidlMonitorDepend.Stub.DESCRIPTOR);
                    if (!this.mRemote.transact(2, obtain, obtain2, 0) && com.ss.android.socialbase.downloader.depend.IDownloadAidlMonitorDepend.Stub.getDefaultImpl() != null) {
                        return com.ss.android.socialbase.downloader.depend.IDownloadAidlMonitorDepend.Stub.getDefaultImpl().getEventPage();
                    }
                    obtain2.readException();
                    return obtain2.readString();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public java.lang.String getInterfaceDescriptor() {
                return com.ss.android.socialbase.downloader.depend.IDownloadAidlMonitorDepend.Stub.DESCRIPTOR;
            }

            @Override // com.ss.android.socialbase.downloader.depend.IDownloadAidlMonitorDepend
            public void monitorLogSend(java.lang.String str) throws android.os.RemoteException {
                android.os.Parcel obtain = android.os.Parcel.obtain();
                android.os.Parcel obtain2 = android.os.Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(com.ss.android.socialbase.downloader.depend.IDownloadAidlMonitorDepend.Stub.DESCRIPTOR);
                    obtain.writeString(str);
                    if (this.mRemote.transact(1, obtain, obtain2, 0) || com.ss.android.socialbase.downloader.depend.IDownloadAidlMonitorDepend.Stub.getDefaultImpl() == null) {
                        obtain2.readException();
                    } else {
                        com.ss.android.socialbase.downloader.depend.IDownloadAidlMonitorDepend.Stub.getDefaultImpl().monitorLogSend(str);
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

        public static com.ss.android.socialbase.downloader.depend.IDownloadAidlMonitorDepend asInterface(android.os.IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            android.os.IInterface queryLocalInterface = iBinder.queryLocalInterface(DESCRIPTOR);
            return (queryLocalInterface == null || !(queryLocalInterface instanceof com.ss.android.socialbase.downloader.depend.IDownloadAidlMonitorDepend)) ? new com.ss.android.socialbase.downloader.depend.IDownloadAidlMonitorDepend.Stub.Proxy(iBinder) : (com.ss.android.socialbase.downloader.depend.IDownloadAidlMonitorDepend) queryLocalInterface;
        }

        public static com.ss.android.socialbase.downloader.depend.IDownloadAidlMonitorDepend getDefaultImpl() {
            return com.ss.android.socialbase.downloader.depend.IDownloadAidlMonitorDepend.Stub.Proxy.sDefaultImpl;
        }

        public static boolean setDefaultImpl(com.ss.android.socialbase.downloader.depend.IDownloadAidlMonitorDepend iDownloadAidlMonitorDepend) {
            if (com.ss.android.socialbase.downloader.depend.IDownloadAidlMonitorDepend.Stub.Proxy.sDefaultImpl != null || iDownloadAidlMonitorDepend == null) {
                return false;
            }
            com.ss.android.socialbase.downloader.depend.IDownloadAidlMonitorDepend.Stub.Proxy.sDefaultImpl = iDownloadAidlMonitorDepend;
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
                monitorLogSend(parcel.readString());
                parcel2.writeNoException();
                return true;
            }
            if (i == 2) {
                parcel.enforceInterface(DESCRIPTOR);
                java.lang.String eventPage = getEventPage();
                parcel2.writeNoException();
                parcel2.writeString(eventPage);
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
            int[] additionalMonitorStatus = getAdditionalMonitorStatus();
            parcel2.writeNoException();
            parcel2.writeIntArray(additionalMonitorStatus);
            return true;
        }
    }

    int[] getAdditionalMonitorStatus() throws android.os.RemoteException;

    java.lang.String getEventPage() throws android.os.RemoteException;

    void monitorLogSend(java.lang.String str) throws android.os.RemoteException;
}
