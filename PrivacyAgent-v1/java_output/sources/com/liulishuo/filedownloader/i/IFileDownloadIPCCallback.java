package com.liulishuo.filedownloader.i;

/* loaded from: classes23.dex */
public interface IFileDownloadIPCCallback extends android.os.IInterface {

    public static abstract class Stub extends android.os.Binder implements com.liulishuo.filedownloader.i.IFileDownloadIPCCallback {
        private static final java.lang.String DESCRIPTOR = "com.liulishuo.filedownloader.i.IFileDownloadIPCCallback";
        static final int TRANSACTION_callback = 1;

        public static class Proxy implements com.liulishuo.filedownloader.i.IFileDownloadIPCCallback {
            private android.os.IBinder mRemote;

            public Proxy(android.os.IBinder iBinder) {
                this.mRemote = iBinder;
            }

            @Override // android.os.IInterface
            public android.os.IBinder asBinder() {
                return this.mRemote;
            }

            @Override // com.liulishuo.filedownloader.i.IFileDownloadIPCCallback
            public void callback(com.liulishuo.filedownloader.message.MessageSnapshot messageSnapshot) throws android.os.RemoteException {
                android.os.Parcel obtain = android.os.Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(com.liulishuo.filedownloader.i.IFileDownloadIPCCallback.Stub.DESCRIPTOR);
                    if (messageSnapshot != null) {
                        obtain.writeInt(1);
                        messageSnapshot.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.mRemote.transact(1, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            public java.lang.String getInterfaceDescriptor() {
                return com.liulishuo.filedownloader.i.IFileDownloadIPCCallback.Stub.DESCRIPTOR;
            }
        }

        public Stub() {
            attachInterface(this, DESCRIPTOR);
        }

        public static com.liulishuo.filedownloader.i.IFileDownloadIPCCallback asInterface(android.os.IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            android.os.IInterface queryLocalInterface = iBinder.queryLocalInterface(DESCRIPTOR);
            return (queryLocalInterface == null || !(queryLocalInterface instanceof com.liulishuo.filedownloader.i.IFileDownloadIPCCallback)) ? new com.liulishuo.filedownloader.i.IFileDownloadIPCCallback.Stub.Proxy(iBinder) : (com.liulishuo.filedownloader.i.IFileDownloadIPCCallback) queryLocalInterface;
        }

        @Override // android.os.IInterface
        public android.os.IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, android.os.Parcel parcel, android.os.Parcel parcel2, int i2) throws android.os.RemoteException {
            if (i == 1) {
                parcel.enforceInterface(DESCRIPTOR);
                callback(parcel.readInt() != 0 ? com.liulishuo.filedownloader.message.MessageSnapshot.CREATOR.createFromParcel(parcel) : null);
                return true;
            }
            if (i != 1598968902) {
                return super.onTransact(i, parcel, parcel2, i2);
            }
            parcel2.writeString(DESCRIPTOR);
            return true;
        }
    }

    void callback(com.liulishuo.filedownloader.message.MessageSnapshot messageSnapshot) throws android.os.RemoteException;
}
