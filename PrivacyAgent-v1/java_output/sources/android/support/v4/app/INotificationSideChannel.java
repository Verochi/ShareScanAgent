package android.support.v4.app;

/* loaded from: classes.dex */
public interface INotificationSideChannel extends android.os.IInterface {

    public static class Default implements android.support.v4.app.INotificationSideChannel {
        @Override // android.os.IInterface
        public android.os.IBinder asBinder() {
            return null;
        }

        @Override // android.support.v4.app.INotificationSideChannel
        public void cancel(java.lang.String str, int i, java.lang.String str2) throws android.os.RemoteException {
        }

        @Override // android.support.v4.app.INotificationSideChannel
        public void cancelAll(java.lang.String str) throws android.os.RemoteException {
        }

        @Override // android.support.v4.app.INotificationSideChannel
        public void notify(java.lang.String str, int i, java.lang.String str2, android.app.Notification notification) throws android.os.RemoteException {
        }
    }

    public static abstract class Stub extends android.os.Binder implements android.support.v4.app.INotificationSideChannel {
        private static final java.lang.String DESCRIPTOR = "android.support.v4.app.INotificationSideChannel";
        static final int TRANSACTION_cancel = 2;
        static final int TRANSACTION_cancelAll = 3;
        static final int TRANSACTION_notify = 1;

        public static class Proxy implements android.support.v4.app.INotificationSideChannel {
            public static android.support.v4.app.INotificationSideChannel sDefaultImpl;
            private android.os.IBinder mRemote;

            public Proxy(android.os.IBinder iBinder) {
                this.mRemote = iBinder;
            }

            @Override // android.os.IInterface
            public android.os.IBinder asBinder() {
                return this.mRemote;
            }

            @Override // android.support.v4.app.INotificationSideChannel
            public void cancel(java.lang.String str, int i, java.lang.String str2) throws android.os.RemoteException {
                android.os.Parcel obtain = android.os.Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(android.support.v4.app.INotificationSideChannel.Stub.DESCRIPTOR);
                    obtain.writeString(str);
                    obtain.writeInt(i);
                    obtain.writeString(str2);
                    if (this.mRemote.transact(2, obtain, null, 1) || android.support.v4.app.INotificationSideChannel.Stub.getDefaultImpl() == null) {
                        return;
                    }
                    android.support.v4.app.INotificationSideChannel.Stub.getDefaultImpl().cancel(str, i, str2);
                } finally {
                    obtain.recycle();
                }
            }

            @Override // android.support.v4.app.INotificationSideChannel
            public void cancelAll(java.lang.String str) throws android.os.RemoteException {
                android.os.Parcel obtain = android.os.Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(android.support.v4.app.INotificationSideChannel.Stub.DESCRIPTOR);
                    obtain.writeString(str);
                    if (this.mRemote.transact(3, obtain, null, 1) || android.support.v4.app.INotificationSideChannel.Stub.getDefaultImpl() == null) {
                        return;
                    }
                    android.support.v4.app.INotificationSideChannel.Stub.getDefaultImpl().cancelAll(str);
                } finally {
                    obtain.recycle();
                }
            }

            public java.lang.String getInterfaceDescriptor() {
                return android.support.v4.app.INotificationSideChannel.Stub.DESCRIPTOR;
            }

            @Override // android.support.v4.app.INotificationSideChannel
            public void notify(java.lang.String str, int i, java.lang.String str2, android.app.Notification notification) throws android.os.RemoteException {
                android.os.Parcel obtain = android.os.Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(android.support.v4.app.INotificationSideChannel.Stub.DESCRIPTOR);
                    obtain.writeString(str);
                    obtain.writeInt(i);
                    obtain.writeString(str2);
                    if (notification != null) {
                        obtain.writeInt(1);
                        notification.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (this.mRemote.transact(1, obtain, null, 1) || android.support.v4.app.INotificationSideChannel.Stub.getDefaultImpl() == null) {
                        return;
                    }
                    android.support.v4.app.INotificationSideChannel.Stub.getDefaultImpl().notify(str, i, str2, notification);
                } finally {
                    obtain.recycle();
                }
            }
        }

        public Stub() {
            attachInterface(this, DESCRIPTOR);
        }

        public static android.support.v4.app.INotificationSideChannel asInterface(android.os.IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            android.os.IInterface queryLocalInterface = iBinder.queryLocalInterface(DESCRIPTOR);
            return (queryLocalInterface == null || !(queryLocalInterface instanceof android.support.v4.app.INotificationSideChannel)) ? new android.support.v4.app.INotificationSideChannel.Stub.Proxy(iBinder) : (android.support.v4.app.INotificationSideChannel) queryLocalInterface;
        }

        public static android.support.v4.app.INotificationSideChannel getDefaultImpl() {
            return android.support.v4.app.INotificationSideChannel.Stub.Proxy.sDefaultImpl;
        }

        public static boolean setDefaultImpl(android.support.v4.app.INotificationSideChannel iNotificationSideChannel) {
            if (android.support.v4.app.INotificationSideChannel.Stub.Proxy.sDefaultImpl != null) {
                throw new java.lang.IllegalStateException("setDefaultImpl() called twice");
            }
            if (iNotificationSideChannel == null) {
                return false;
            }
            android.support.v4.app.INotificationSideChannel.Stub.Proxy.sDefaultImpl = iNotificationSideChannel;
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
                notify(parcel.readString(), parcel.readInt(), parcel.readString(), parcel.readInt() != 0 ? (android.app.Notification) android.app.Notification.CREATOR.createFromParcel(parcel) : null);
                return true;
            }
            if (i == 2) {
                parcel.enforceInterface(DESCRIPTOR);
                cancel(parcel.readString(), parcel.readInt(), parcel.readString());
                return true;
            }
            if (i == 3) {
                parcel.enforceInterface(DESCRIPTOR);
                cancelAll(parcel.readString());
                return true;
            }
            if (i != 1598968902) {
                return super.onTransact(i, parcel, parcel2, i2);
            }
            parcel2.writeString(DESCRIPTOR);
            return true;
        }
    }

    void cancel(java.lang.String str, int i, java.lang.String str2) throws android.os.RemoteException;

    void cancelAll(java.lang.String str) throws android.os.RemoteException;

    void notify(java.lang.String str, int i, java.lang.String str2, android.app.Notification notification) throws android.os.RemoteException;
}
