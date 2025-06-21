package com.ss.android.socialbase.downloader.depend;

/* loaded from: classes19.dex */
public interface IChunkCntAidlCalculator extends android.os.IInterface {

    public static class Default implements com.ss.android.socialbase.downloader.depend.IChunkCntAidlCalculator {
        @Override // android.os.IInterface
        public android.os.IBinder asBinder() {
            return null;
        }

        @Override // com.ss.android.socialbase.downloader.depend.IChunkCntAidlCalculator
        public int calculateChunkCount(long j) throws android.os.RemoteException {
            return 0;
        }
    }

    public static abstract class Stub extends android.os.Binder implements com.ss.android.socialbase.downloader.depend.IChunkCntAidlCalculator {
        private static final java.lang.String DESCRIPTOR = "com.ss.android.socialbase.downloader.depend.IChunkCntAidlCalculator";
        static final int TRANSACTION_calculateChunkCount = 1;

        public static class Proxy implements com.ss.android.socialbase.downloader.depend.IChunkCntAidlCalculator {
            public static com.ss.android.socialbase.downloader.depend.IChunkCntAidlCalculator sDefaultImpl;
            private android.os.IBinder mRemote;

            public Proxy(android.os.IBinder iBinder) {
                this.mRemote = iBinder;
            }

            @Override // android.os.IInterface
            public android.os.IBinder asBinder() {
                return this.mRemote;
            }

            @Override // com.ss.android.socialbase.downloader.depend.IChunkCntAidlCalculator
            public int calculateChunkCount(long j) throws android.os.RemoteException {
                android.os.Parcel obtain = android.os.Parcel.obtain();
                android.os.Parcel obtain2 = android.os.Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(com.ss.android.socialbase.downloader.depend.IChunkCntAidlCalculator.Stub.DESCRIPTOR);
                    obtain.writeLong(j);
                    if (!this.mRemote.transact(1, obtain, obtain2, 0) && com.ss.android.socialbase.downloader.depend.IChunkCntAidlCalculator.Stub.getDefaultImpl() != null) {
                        return com.ss.android.socialbase.downloader.depend.IChunkCntAidlCalculator.Stub.getDefaultImpl().calculateChunkCount(j);
                    }
                    obtain2.readException();
                    return obtain2.readInt();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public java.lang.String getInterfaceDescriptor() {
                return com.ss.android.socialbase.downloader.depend.IChunkCntAidlCalculator.Stub.DESCRIPTOR;
            }
        }

        public Stub() {
            attachInterface(this, DESCRIPTOR);
        }

        public static com.ss.android.socialbase.downloader.depend.IChunkCntAidlCalculator asInterface(android.os.IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            android.os.IInterface queryLocalInterface = iBinder.queryLocalInterface(DESCRIPTOR);
            return (queryLocalInterface == null || !(queryLocalInterface instanceof com.ss.android.socialbase.downloader.depend.IChunkCntAidlCalculator)) ? new com.ss.android.socialbase.downloader.depend.IChunkCntAidlCalculator.Stub.Proxy(iBinder) : (com.ss.android.socialbase.downloader.depend.IChunkCntAidlCalculator) queryLocalInterface;
        }

        public static com.ss.android.socialbase.downloader.depend.IChunkCntAidlCalculator getDefaultImpl() {
            return com.ss.android.socialbase.downloader.depend.IChunkCntAidlCalculator.Stub.Proxy.sDefaultImpl;
        }

        public static boolean setDefaultImpl(com.ss.android.socialbase.downloader.depend.IChunkCntAidlCalculator iChunkCntAidlCalculator) {
            if (com.ss.android.socialbase.downloader.depend.IChunkCntAidlCalculator.Stub.Proxy.sDefaultImpl != null || iChunkCntAidlCalculator == null) {
                return false;
            }
            com.ss.android.socialbase.downloader.depend.IChunkCntAidlCalculator.Stub.Proxy.sDefaultImpl = iChunkCntAidlCalculator;
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
            int calculateChunkCount = calculateChunkCount(parcel.readLong());
            parcel2.writeNoException();
            parcel2.writeInt(calculateChunkCount);
            return true;
        }
    }

    int calculateChunkCount(long j) throws android.os.RemoteException;
}
