package com.ss.android.socialbase.downloader.depend;

/* loaded from: classes19.dex */
public interface IRetryDelayTimeAidlCalculator extends android.os.IInterface {

    public static class Default implements com.ss.android.socialbase.downloader.depend.IRetryDelayTimeAidlCalculator {
        @Override // android.os.IInterface
        public android.os.IBinder asBinder() {
            return null;
        }

        @Override // com.ss.android.socialbase.downloader.depend.IRetryDelayTimeAidlCalculator
        public long calculateRetryDelayTime(int i, int i2) throws android.os.RemoteException {
            return 0L;
        }
    }

    public static abstract class Stub extends android.os.Binder implements com.ss.android.socialbase.downloader.depend.IRetryDelayTimeAidlCalculator {
        private static final java.lang.String DESCRIPTOR = "com.ss.android.socialbase.downloader.depend.IRetryDelayTimeAidlCalculator";
        static final int TRANSACTION_calculateRetryDelayTime = 1;

        public static class Proxy implements com.ss.android.socialbase.downloader.depend.IRetryDelayTimeAidlCalculator {
            public static com.ss.android.socialbase.downloader.depend.IRetryDelayTimeAidlCalculator sDefaultImpl;
            private android.os.IBinder mRemote;

            public Proxy(android.os.IBinder iBinder) {
                this.mRemote = iBinder;
            }

            @Override // android.os.IInterface
            public android.os.IBinder asBinder() {
                return this.mRemote;
            }

            @Override // com.ss.android.socialbase.downloader.depend.IRetryDelayTimeAidlCalculator
            public long calculateRetryDelayTime(int i, int i2) throws android.os.RemoteException {
                android.os.Parcel obtain = android.os.Parcel.obtain();
                android.os.Parcel obtain2 = android.os.Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(com.ss.android.socialbase.downloader.depend.IRetryDelayTimeAidlCalculator.Stub.DESCRIPTOR);
                    obtain.writeInt(i);
                    obtain.writeInt(i2);
                    if (!this.mRemote.transact(1, obtain, obtain2, 0) && com.ss.android.socialbase.downloader.depend.IRetryDelayTimeAidlCalculator.Stub.getDefaultImpl() != null) {
                        return com.ss.android.socialbase.downloader.depend.IRetryDelayTimeAidlCalculator.Stub.getDefaultImpl().calculateRetryDelayTime(i, i2);
                    }
                    obtain2.readException();
                    return obtain2.readLong();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public java.lang.String getInterfaceDescriptor() {
                return com.ss.android.socialbase.downloader.depend.IRetryDelayTimeAidlCalculator.Stub.DESCRIPTOR;
            }
        }

        public Stub() {
            attachInterface(this, DESCRIPTOR);
        }

        public static com.ss.android.socialbase.downloader.depend.IRetryDelayTimeAidlCalculator asInterface(android.os.IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            android.os.IInterface queryLocalInterface = iBinder.queryLocalInterface(DESCRIPTOR);
            return (queryLocalInterface == null || !(queryLocalInterface instanceof com.ss.android.socialbase.downloader.depend.IRetryDelayTimeAidlCalculator)) ? new com.ss.android.socialbase.downloader.depend.IRetryDelayTimeAidlCalculator.Stub.Proxy(iBinder) : (com.ss.android.socialbase.downloader.depend.IRetryDelayTimeAidlCalculator) queryLocalInterface;
        }

        public static com.ss.android.socialbase.downloader.depend.IRetryDelayTimeAidlCalculator getDefaultImpl() {
            return com.ss.android.socialbase.downloader.depend.IRetryDelayTimeAidlCalculator.Stub.Proxy.sDefaultImpl;
        }

        public static boolean setDefaultImpl(com.ss.android.socialbase.downloader.depend.IRetryDelayTimeAidlCalculator iRetryDelayTimeAidlCalculator) {
            if (com.ss.android.socialbase.downloader.depend.IRetryDelayTimeAidlCalculator.Stub.Proxy.sDefaultImpl != null || iRetryDelayTimeAidlCalculator == null) {
                return false;
            }
            com.ss.android.socialbase.downloader.depend.IRetryDelayTimeAidlCalculator.Stub.Proxy.sDefaultImpl = iRetryDelayTimeAidlCalculator;
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
            long calculateRetryDelayTime = calculateRetryDelayTime(parcel.readInt(), parcel.readInt());
            parcel2.writeNoException();
            parcel2.writeLong(calculateRetryDelayTime);
            return true;
        }
    }

    long calculateRetryDelayTime(int i, int i2) throws android.os.RemoteException;
}
