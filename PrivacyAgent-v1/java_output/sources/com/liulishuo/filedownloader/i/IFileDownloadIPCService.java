package com.liulishuo.filedownloader.i;

/* loaded from: classes23.dex */
public interface IFileDownloadIPCService extends android.os.IInterface {

    public static abstract class Stub extends android.os.Binder implements com.liulishuo.filedownloader.i.IFileDownloadIPCService {
        private static final java.lang.String DESCRIPTOR = "com.liulishuo.filedownloader.i.IFileDownloadIPCService";
        static final int TRANSACTION_checkDownloading = 3;
        static final int TRANSACTION_clearAllTaskData = 15;
        static final int TRANSACTION_clearTaskData = 14;
        static final int TRANSACTION_getSofar = 8;
        static final int TRANSACTION_getStatus = 10;
        static final int TRANSACTION_getTotal = 9;
        static final int TRANSACTION_isIdle = 11;
        static final int TRANSACTION_pause = 5;
        static final int TRANSACTION_pauseAllTasks = 6;
        static final int TRANSACTION_registerCallback = 1;
        static final int TRANSACTION_setMaxNetworkThreadCount = 7;
        static final int TRANSACTION_start = 4;
        static final int TRANSACTION_startForeground = 12;
        static final int TRANSACTION_stopForeground = 13;
        static final int TRANSACTION_unregisterCallback = 2;

        public static class Proxy implements com.liulishuo.filedownloader.i.IFileDownloadIPCService {
            private android.os.IBinder mRemote;

            public Proxy(android.os.IBinder iBinder) {
                this.mRemote = iBinder;
            }

            @Override // android.os.IInterface
            public android.os.IBinder asBinder() {
                return this.mRemote;
            }

            @Override // com.liulishuo.filedownloader.i.IFileDownloadIPCService
            public boolean checkDownloading(java.lang.String str, java.lang.String str2) throws android.os.RemoteException {
                android.os.Parcel obtain = android.os.Parcel.obtain();
                android.os.Parcel obtain2 = android.os.Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(com.liulishuo.filedownloader.i.IFileDownloadIPCService.Stub.DESCRIPTOR);
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    this.mRemote.transact(3, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt() != 0;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.liulishuo.filedownloader.i.IFileDownloadIPCService
            public void clearAllTaskData() throws android.os.RemoteException {
                android.os.Parcel obtain = android.os.Parcel.obtain();
                android.os.Parcel obtain2 = android.os.Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(com.liulishuo.filedownloader.i.IFileDownloadIPCService.Stub.DESCRIPTOR);
                    this.mRemote.transact(15, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.liulishuo.filedownloader.i.IFileDownloadIPCService
            public boolean clearTaskData(int i) throws android.os.RemoteException {
                android.os.Parcel obtain = android.os.Parcel.obtain();
                android.os.Parcel obtain2 = android.os.Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(com.liulishuo.filedownloader.i.IFileDownloadIPCService.Stub.DESCRIPTOR);
                    obtain.writeInt(i);
                    this.mRemote.transact(14, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt() != 0;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public java.lang.String getInterfaceDescriptor() {
                return com.liulishuo.filedownloader.i.IFileDownloadIPCService.Stub.DESCRIPTOR;
            }

            @Override // com.liulishuo.filedownloader.i.IFileDownloadIPCService
            public long getSofar(int i) throws android.os.RemoteException {
                android.os.Parcel obtain = android.os.Parcel.obtain();
                android.os.Parcel obtain2 = android.os.Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(com.liulishuo.filedownloader.i.IFileDownloadIPCService.Stub.DESCRIPTOR);
                    obtain.writeInt(i);
                    this.mRemote.transact(8, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readLong();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.liulishuo.filedownloader.i.IFileDownloadIPCService
            public byte getStatus(int i) throws android.os.RemoteException {
                android.os.Parcel obtain = android.os.Parcel.obtain();
                android.os.Parcel obtain2 = android.os.Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(com.liulishuo.filedownloader.i.IFileDownloadIPCService.Stub.DESCRIPTOR);
                    obtain.writeInt(i);
                    this.mRemote.transact(10, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readByte();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.liulishuo.filedownloader.i.IFileDownloadIPCService
            public long getTotal(int i) throws android.os.RemoteException {
                android.os.Parcel obtain = android.os.Parcel.obtain();
                android.os.Parcel obtain2 = android.os.Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(com.liulishuo.filedownloader.i.IFileDownloadIPCService.Stub.DESCRIPTOR);
                    obtain.writeInt(i);
                    this.mRemote.transact(9, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readLong();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.liulishuo.filedownloader.i.IFileDownloadIPCService
            public boolean isIdle() throws android.os.RemoteException {
                android.os.Parcel obtain = android.os.Parcel.obtain();
                android.os.Parcel obtain2 = android.os.Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(com.liulishuo.filedownloader.i.IFileDownloadIPCService.Stub.DESCRIPTOR);
                    this.mRemote.transact(11, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt() != 0;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.liulishuo.filedownloader.i.IFileDownloadIPCService
            public boolean pause(int i) throws android.os.RemoteException {
                android.os.Parcel obtain = android.os.Parcel.obtain();
                android.os.Parcel obtain2 = android.os.Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(com.liulishuo.filedownloader.i.IFileDownloadIPCService.Stub.DESCRIPTOR);
                    obtain.writeInt(i);
                    this.mRemote.transact(5, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt() != 0;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.liulishuo.filedownloader.i.IFileDownloadIPCService
            public void pauseAllTasks() throws android.os.RemoteException {
                android.os.Parcel obtain = android.os.Parcel.obtain();
                android.os.Parcel obtain2 = android.os.Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(com.liulishuo.filedownloader.i.IFileDownloadIPCService.Stub.DESCRIPTOR);
                    this.mRemote.transact(6, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.liulishuo.filedownloader.i.IFileDownloadIPCService
            public void registerCallback(com.liulishuo.filedownloader.i.IFileDownloadIPCCallback iFileDownloadIPCCallback) throws android.os.RemoteException {
                android.os.Parcel obtain = android.os.Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(com.liulishuo.filedownloader.i.IFileDownloadIPCService.Stub.DESCRIPTOR);
                    obtain.writeStrongBinder(iFileDownloadIPCCallback != null ? iFileDownloadIPCCallback.asBinder() : null);
                    this.mRemote.transact(1, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            @Override // com.liulishuo.filedownloader.i.IFileDownloadIPCService
            public boolean setMaxNetworkThreadCount(int i) throws android.os.RemoteException {
                android.os.Parcel obtain = android.os.Parcel.obtain();
                android.os.Parcel obtain2 = android.os.Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(com.liulishuo.filedownloader.i.IFileDownloadIPCService.Stub.DESCRIPTOR);
                    obtain.writeInt(i);
                    this.mRemote.transact(7, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt() != 0;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.liulishuo.filedownloader.i.IFileDownloadIPCService
            public void start(java.lang.String str, java.lang.String str2, boolean z, int i, int i2, int i3, boolean z2, com.liulishuo.filedownloader.model.FileDownloadHeader fileDownloadHeader, boolean z3) throws android.os.RemoteException {
                android.os.Parcel obtain = android.os.Parcel.obtain();
                android.os.Parcel obtain2 = android.os.Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(com.liulishuo.filedownloader.i.IFileDownloadIPCService.Stub.DESCRIPTOR);
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    int i4 = 1;
                    obtain.writeInt(z ? 1 : 0);
                    obtain.writeInt(i);
                    obtain.writeInt(i2);
                    obtain.writeInt(i3);
                    obtain.writeInt(z2 ? 1 : 0);
                    if (fileDownloadHeader != null) {
                        obtain.writeInt(1);
                        fileDownloadHeader.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (!z3) {
                        i4 = 0;
                    }
                    obtain.writeInt(i4);
                    this.mRemote.transact(4, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.liulishuo.filedownloader.i.IFileDownloadIPCService
            public void startForeground(int i, android.app.Notification notification) throws android.os.RemoteException {
                android.os.Parcel obtain = android.os.Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(com.liulishuo.filedownloader.i.IFileDownloadIPCService.Stub.DESCRIPTOR);
                    obtain.writeInt(i);
                    if (notification != null) {
                        obtain.writeInt(1);
                        notification.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.mRemote.transact(12, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            @Override // com.liulishuo.filedownloader.i.IFileDownloadIPCService
            public void stopForeground(boolean z) throws android.os.RemoteException {
                android.os.Parcel obtain = android.os.Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(com.liulishuo.filedownloader.i.IFileDownloadIPCService.Stub.DESCRIPTOR);
                    obtain.writeInt(z ? 1 : 0);
                    this.mRemote.transact(13, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            @Override // com.liulishuo.filedownloader.i.IFileDownloadIPCService
            public void unregisterCallback(com.liulishuo.filedownloader.i.IFileDownloadIPCCallback iFileDownloadIPCCallback) throws android.os.RemoteException {
                android.os.Parcel obtain = android.os.Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(com.liulishuo.filedownloader.i.IFileDownloadIPCService.Stub.DESCRIPTOR);
                    obtain.writeStrongBinder(iFileDownloadIPCCallback != null ? iFileDownloadIPCCallback.asBinder() : null);
                    this.mRemote.transact(2, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }
        }

        public Stub() {
            attachInterface(this, DESCRIPTOR);
        }

        public static com.liulishuo.filedownloader.i.IFileDownloadIPCService asInterface(android.os.IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            android.os.IInterface queryLocalInterface = iBinder.queryLocalInterface(DESCRIPTOR);
            return (queryLocalInterface == null || !(queryLocalInterface instanceof com.liulishuo.filedownloader.i.IFileDownloadIPCService)) ? new com.liulishuo.filedownloader.i.IFileDownloadIPCService.Stub.Proxy(iBinder) : (com.liulishuo.filedownloader.i.IFileDownloadIPCService) queryLocalInterface;
        }

        @Override // android.os.IInterface
        public android.os.IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, android.os.Parcel parcel, android.os.Parcel parcel2, int i2) throws android.os.RemoteException {
            if (i == 1598968902) {
                parcel2.writeString(DESCRIPTOR);
                return true;
            }
            switch (i) {
                case 1:
                    parcel.enforceInterface(DESCRIPTOR);
                    registerCallback(com.liulishuo.filedownloader.i.IFileDownloadIPCCallback.Stub.asInterface(parcel.readStrongBinder()));
                    return true;
                case 2:
                    parcel.enforceInterface(DESCRIPTOR);
                    unregisterCallback(com.liulishuo.filedownloader.i.IFileDownloadIPCCallback.Stub.asInterface(parcel.readStrongBinder()));
                    return true;
                case 3:
                    parcel.enforceInterface(DESCRIPTOR);
                    boolean checkDownloading = checkDownloading(parcel.readString(), parcel.readString());
                    parcel2.writeNoException();
                    parcel2.writeInt(checkDownloading ? 1 : 0);
                    return true;
                case 4:
                    parcel.enforceInterface(DESCRIPTOR);
                    start(parcel.readString(), parcel.readString(), parcel.readInt() != 0, parcel.readInt(), parcel.readInt(), parcel.readInt(), parcel.readInt() != 0, parcel.readInt() != 0 ? com.liulishuo.filedownloader.model.FileDownloadHeader.CREATOR.createFromParcel(parcel) : null, parcel.readInt() != 0);
                    parcel2.writeNoException();
                    return true;
                case 5:
                    parcel.enforceInterface(DESCRIPTOR);
                    boolean pause = pause(parcel.readInt());
                    parcel2.writeNoException();
                    parcel2.writeInt(pause ? 1 : 0);
                    return true;
                case 6:
                    parcel.enforceInterface(DESCRIPTOR);
                    pauseAllTasks();
                    parcel2.writeNoException();
                    return true;
                case 7:
                    parcel.enforceInterface(DESCRIPTOR);
                    boolean maxNetworkThreadCount = setMaxNetworkThreadCount(parcel.readInt());
                    parcel2.writeNoException();
                    parcel2.writeInt(maxNetworkThreadCount ? 1 : 0);
                    return true;
                case 8:
                    parcel.enforceInterface(DESCRIPTOR);
                    long sofar = getSofar(parcel.readInt());
                    parcel2.writeNoException();
                    parcel2.writeLong(sofar);
                    return true;
                case 9:
                    parcel.enforceInterface(DESCRIPTOR);
                    long total = getTotal(parcel.readInt());
                    parcel2.writeNoException();
                    parcel2.writeLong(total);
                    return true;
                case 10:
                    parcel.enforceInterface(DESCRIPTOR);
                    byte status = getStatus(parcel.readInt());
                    parcel2.writeNoException();
                    parcel2.writeByte(status);
                    return true;
                case 11:
                    parcel.enforceInterface(DESCRIPTOR);
                    boolean isIdle = isIdle();
                    parcel2.writeNoException();
                    parcel2.writeInt(isIdle ? 1 : 0);
                    return true;
                case 12:
                    parcel.enforceInterface(DESCRIPTOR);
                    startForeground(parcel.readInt(), parcel.readInt() != 0 ? (android.app.Notification) android.app.Notification.CREATOR.createFromParcel(parcel) : null);
                    return true;
                case 13:
                    parcel.enforceInterface(DESCRIPTOR);
                    stopForeground(parcel.readInt() != 0);
                    return true;
                case 14:
                    parcel.enforceInterface(DESCRIPTOR);
                    boolean clearTaskData = clearTaskData(parcel.readInt());
                    parcel2.writeNoException();
                    parcel2.writeInt(clearTaskData ? 1 : 0);
                    return true;
                case 15:
                    parcel.enforceInterface(DESCRIPTOR);
                    clearAllTaskData();
                    parcel2.writeNoException();
                    return true;
                default:
                    return super.onTransact(i, parcel, parcel2, i2);
            }
        }
    }

    boolean checkDownloading(java.lang.String str, java.lang.String str2) throws android.os.RemoteException;

    void clearAllTaskData() throws android.os.RemoteException;

    boolean clearTaskData(int i) throws android.os.RemoteException;

    long getSofar(int i) throws android.os.RemoteException;

    byte getStatus(int i) throws android.os.RemoteException;

    long getTotal(int i) throws android.os.RemoteException;

    boolean isIdle() throws android.os.RemoteException;

    boolean pause(int i) throws android.os.RemoteException;

    void pauseAllTasks() throws android.os.RemoteException;

    void registerCallback(com.liulishuo.filedownloader.i.IFileDownloadIPCCallback iFileDownloadIPCCallback) throws android.os.RemoteException;

    boolean setMaxNetworkThreadCount(int i) throws android.os.RemoteException;

    void start(java.lang.String str, java.lang.String str2, boolean z, int i, int i2, int i3, boolean z2, com.liulishuo.filedownloader.model.FileDownloadHeader fileDownloadHeader, boolean z3) throws android.os.RemoteException;

    void startForeground(int i, android.app.Notification notification) throws android.os.RemoteException;

    void stopForeground(boolean z) throws android.os.RemoteException;

    void unregisterCallback(com.liulishuo.filedownloader.i.IFileDownloadIPCCallback iFileDownloadIPCCallback) throws android.os.RemoteException;
}
