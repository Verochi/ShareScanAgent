package com.mcs.aidl;

/* loaded from: classes23.dex */
public interface IMcsSdkService extends android.os.IInterface {

    public static class Default implements com.mcs.aidl.IMcsSdkService {
        @Override // android.os.IInterface
        public android.os.IBinder asBinder() {
            return null;
        }

        @Override // com.mcs.aidl.IMcsSdkService
        public void process(android.os.Bundle bundle) {
        }
    }

    public static abstract class Stub extends android.os.Binder implements com.mcs.aidl.IMcsSdkService {
        private static final java.lang.String DESCRIPTOR = "com.mcs.aidl.IMcsSdkService";
        static final int TRANSACTION_process = 1;

        public static class Proxy implements com.mcs.aidl.IMcsSdkService {
            public static com.mcs.aidl.IMcsSdkService sDefaultImpl;
            private android.os.IBinder mRemote;

            public Proxy(android.os.IBinder iBinder) {
                this.mRemote = iBinder;
            }

            @Override // android.os.IInterface
            public android.os.IBinder asBinder() {
                return this.mRemote;
            }

            public java.lang.String getInterfaceDescriptor() {
                return com.mcs.aidl.IMcsSdkService.Stub.DESCRIPTOR;
            }

            @Override // com.mcs.aidl.IMcsSdkService
            public void process(android.os.Bundle bundle) {
                android.os.Parcel obtain = android.os.Parcel.obtain();
                android.os.Parcel obtain2 = android.os.Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(com.mcs.aidl.IMcsSdkService.Stub.DESCRIPTOR);
                    if (bundle != null) {
                        obtain.writeInt(1);
                        bundle.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (this.mRemote.transact(1, obtain, obtain2, 0) || com.mcs.aidl.IMcsSdkService.Stub.getDefaultImpl() == null) {
                        obtain2.readException();
                    } else {
                        com.mcs.aidl.IMcsSdkService.Stub.getDefaultImpl().process(bundle);
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

        public static com.mcs.aidl.IMcsSdkService asInterface(android.os.IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            android.os.IInterface queryLocalInterface = iBinder.queryLocalInterface(DESCRIPTOR);
            return (queryLocalInterface == null || !(queryLocalInterface instanceof com.mcs.aidl.IMcsSdkService)) ? new com.mcs.aidl.IMcsSdkService.Stub.Proxy(iBinder) : (com.mcs.aidl.IMcsSdkService) queryLocalInterface;
        }

        public static com.mcs.aidl.IMcsSdkService getDefaultImpl() {
            return com.mcs.aidl.IMcsSdkService.Stub.Proxy.sDefaultImpl;
        }

        public static boolean setDefaultImpl(com.mcs.aidl.IMcsSdkService iMcsSdkService) {
            if (com.mcs.aidl.IMcsSdkService.Stub.Proxy.sDefaultImpl != null || iMcsSdkService == null) {
                return false;
            }
            com.mcs.aidl.IMcsSdkService.Stub.Proxy.sDefaultImpl = iMcsSdkService;
            return true;
        }

        @Override // android.os.IInterface
        public android.os.IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, android.os.Parcel parcel, android.os.Parcel parcel2, int i2) {
            if (i != 1) {
                if (i != 1598968902) {
                    return super.onTransact(i, parcel, parcel2, i2);
                }
                parcel2.writeString(DESCRIPTOR);
                return true;
            }
            parcel.enforceInterface(DESCRIPTOR);
            process(parcel.readInt() != 0 ? (android.os.Bundle) android.os.Bundle.CREATOR.createFromParcel(parcel) : null);
            parcel2.writeNoException();
            return true;
        }
    }

    void process(android.os.Bundle bundle);
}
