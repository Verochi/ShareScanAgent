package com.huawei.hms.ads.identifier.aidl;

/* loaded from: classes22.dex */
public interface OpenDeviceIdentifierService extends android.os.IInterface {

    public static abstract class Stub {
        private static final java.lang.String DESCRIPTOR = "com.uodis.opendevice.aidl.OpenDeviceIdentifierService";
        static final int TRANSACTION_GETOAID = 1;
        static final int TRANSACTION_ISOAIDTRACKLIMITED = 2;

        public static class Proxy implements com.huawei.hms.ads.identifier.aidl.OpenDeviceIdentifierService {
            private android.os.IBinder mRemote;

            public Proxy(android.os.IBinder iBinder) {
                this.mRemote = iBinder;
            }

            @Override // android.os.IInterface
            public android.os.IBinder asBinder() {
                return this.mRemote;
            }

            public java.lang.String getInterfaceDescriptor() {
                return "com.uodis.opendevice.aidl.OpenDeviceIdentifierService";
            }

            @Override // com.huawei.hms.ads.identifier.aidl.OpenDeviceIdentifierService
            public java.lang.String getOaid() {
                android.os.Parcel obtain = android.os.Parcel.obtain();
                android.os.Parcel obtain2 = android.os.Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(getInterfaceDescriptor());
                    this.mRemote.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readString();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.huawei.hms.ads.identifier.aidl.OpenDeviceIdentifierService
            public boolean isOaidTrackLimited() {
                android.os.Parcel obtain = android.os.Parcel.obtain();
                android.os.Parcel obtain2 = android.os.Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(getInterfaceDescriptor());
                    this.mRemote.transact(2, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt() != 0;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

        public static com.huawei.hms.ads.identifier.aidl.OpenDeviceIdentifierService asInterface(android.os.IBinder iBinder) {
            return new com.huawei.hms.ads.identifier.aidl.OpenDeviceIdentifierService.Stub.Proxy(iBinder);
        }
    }

    java.lang.String getOaid();

    boolean isOaidTrackLimited();
}
