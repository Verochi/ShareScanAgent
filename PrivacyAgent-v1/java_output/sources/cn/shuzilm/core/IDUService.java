package cn.shuzilm.core;

/* loaded from: classes.dex */
public interface IDUService extends android.os.IInterface {

    public class Default implements cn.shuzilm.core.IDUService {
        @Override // android.os.IInterface
        public android.os.IBinder asBinder() {
            return null;
        }

        @Override // cn.shuzilm.core.IDUService
        public void getOpenAnmsIDAsyn(cn.shuzilm.core.DUListener dUListener) {
        }

        @Override // cn.shuzilm.core.IDUService
        public java.lang.String getQueryID(java.lang.String str, java.lang.String str2) {
            return null;
        }

        @Override // cn.shuzilm.core.IDUService
        public java.util.Map getQueryIDAsyn(java.lang.String str, java.lang.String str2, cn.shuzilm.core.DUListener dUListener) {
            return null;
        }

        @Override // cn.shuzilm.core.IDUService
        public void go(java.lang.String str, java.lang.String str2) {
        }

        @Override // cn.shuzilm.core.IDUService
        public java.util.Map onEvent(java.lang.String str, java.lang.String str2, java.lang.String str3) {
            return null;
        }

        @Override // cn.shuzilm.core.IDUService
        public java.util.Map onEventAsyn(java.lang.String str, java.lang.String str2, java.lang.String str3, cn.shuzilm.core.DUListener dUListener) {
            return null;
        }

        @Override // cn.shuzilm.core.IDUService
        public void report(java.lang.String str, java.lang.String str2) {
        }

        @Override // cn.shuzilm.core.IDUService
        public int setConfig(java.lang.String str, java.lang.String str2) {
            return 0;
        }

        @Override // cn.shuzilm.core.IDUService
        public int setData(java.lang.String str, java.lang.String str2) {
            return 0;
        }
    }

    public abstract class Stub extends android.os.Binder implements cn.shuzilm.core.IDUService {
        private static final java.lang.String DESCRIPTOR = "cn.shuzilm.core.IDUService";
        static final int TRANSACTION_getOpenAnmsIDAsyn = 9;
        static final int TRANSACTION_getQueryID = 5;
        static final int TRANSACTION_getQueryIDAsyn = 8;
        static final int TRANSACTION_go = 3;
        static final int TRANSACTION_onEvent = 6;
        static final int TRANSACTION_onEventAsyn = 7;
        static final int TRANSACTION_report = 4;
        static final int TRANSACTION_setConfig = 2;
        static final int TRANSACTION_setData = 1;

        class Proxy implements cn.shuzilm.core.IDUService {
            public static cn.shuzilm.core.IDUService sDefaultImpl;
            private android.os.IBinder mRemote;

            public Proxy(android.os.IBinder iBinder) {
                this.mRemote = iBinder;
            }

            @Override // android.os.IInterface
            public android.os.IBinder asBinder() {
                return this.mRemote;
            }

            public java.lang.String getInterfaceDescriptor() {
                return cn.shuzilm.core.IDUService.Stub.DESCRIPTOR;
            }

            @Override // cn.shuzilm.core.IDUService
            public void getOpenAnmsIDAsyn(cn.shuzilm.core.DUListener dUListener) {
                android.os.Parcel obtain = android.os.Parcel.obtain();
                android.os.Parcel obtain2 = android.os.Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(cn.shuzilm.core.IDUService.Stub.DESCRIPTOR);
                    obtain.writeStrongBinder(dUListener != null ? dUListener.asBinder() : null);
                    if (this.mRemote.transact(9, obtain, obtain2, 0) || cn.shuzilm.core.IDUService.Stub.getDefaultImpl() == null) {
                        obtain2.readException();
                    } else {
                        cn.shuzilm.core.IDUService.Stub.getDefaultImpl().getOpenAnmsIDAsyn(dUListener);
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // cn.shuzilm.core.IDUService
            public java.lang.String getQueryID(java.lang.String str, java.lang.String str2) {
                java.lang.String readString;
                android.os.Parcel obtain = android.os.Parcel.obtain();
                android.os.Parcel obtain2 = android.os.Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(cn.shuzilm.core.IDUService.Stub.DESCRIPTOR);
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    if (this.mRemote.transact(5, obtain, obtain2, 0) || cn.shuzilm.core.IDUService.Stub.getDefaultImpl() == null) {
                        obtain2.readException();
                        readString = obtain2.readString();
                    } else {
                        readString = cn.shuzilm.core.IDUService.Stub.getDefaultImpl().getQueryID(str, str2);
                    }
                    return readString;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // cn.shuzilm.core.IDUService
            public java.util.Map getQueryIDAsyn(java.lang.String str, java.lang.String str2, cn.shuzilm.core.DUListener dUListener) {
                java.util.Map readHashMap;
                android.os.Parcel obtain = android.os.Parcel.obtain();
                android.os.Parcel obtain2 = android.os.Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(cn.shuzilm.core.IDUService.Stub.DESCRIPTOR);
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    obtain.writeStrongBinder(dUListener != null ? dUListener.asBinder() : null);
                    if (this.mRemote.transact(8, obtain, obtain2, 0) || cn.shuzilm.core.IDUService.Stub.getDefaultImpl() == null) {
                        obtain2.readException();
                        readHashMap = obtain2.readHashMap(getClass().getClassLoader());
                    } else {
                        readHashMap = cn.shuzilm.core.IDUService.Stub.getDefaultImpl().getQueryIDAsyn(str, str2, dUListener);
                    }
                    return readHashMap;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // cn.shuzilm.core.IDUService
            public void go(java.lang.String str, java.lang.String str2) {
                android.os.Parcel obtain = android.os.Parcel.obtain();
                android.os.Parcel obtain2 = android.os.Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(cn.shuzilm.core.IDUService.Stub.DESCRIPTOR);
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    if (this.mRemote.transact(3, obtain, obtain2, 0) || cn.shuzilm.core.IDUService.Stub.getDefaultImpl() == null) {
                        obtain2.readException();
                    } else {
                        cn.shuzilm.core.IDUService.Stub.getDefaultImpl().go(str, str2);
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // cn.shuzilm.core.IDUService
            public java.util.Map onEvent(java.lang.String str, java.lang.String str2, java.lang.String str3) {
                java.util.Map readHashMap;
                android.os.Parcel obtain = android.os.Parcel.obtain();
                android.os.Parcel obtain2 = android.os.Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(cn.shuzilm.core.IDUService.Stub.DESCRIPTOR);
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    obtain.writeString(str3);
                    if (this.mRemote.transact(6, obtain, obtain2, 0) || cn.shuzilm.core.IDUService.Stub.getDefaultImpl() == null) {
                        obtain2.readException();
                        readHashMap = obtain2.readHashMap(getClass().getClassLoader());
                    } else {
                        readHashMap = cn.shuzilm.core.IDUService.Stub.getDefaultImpl().onEvent(str, str2, str3);
                    }
                    return readHashMap;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // cn.shuzilm.core.IDUService
            public java.util.Map onEventAsyn(java.lang.String str, java.lang.String str2, java.lang.String str3, cn.shuzilm.core.DUListener dUListener) {
                java.util.Map readHashMap;
                android.os.Parcel obtain = android.os.Parcel.obtain();
                android.os.Parcel obtain2 = android.os.Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(cn.shuzilm.core.IDUService.Stub.DESCRIPTOR);
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    obtain.writeString(str3);
                    obtain.writeStrongBinder(dUListener != null ? dUListener.asBinder() : null);
                    if (this.mRemote.transact(7, obtain, obtain2, 0) || cn.shuzilm.core.IDUService.Stub.getDefaultImpl() == null) {
                        obtain2.readException();
                        readHashMap = obtain2.readHashMap(getClass().getClassLoader());
                    } else {
                        readHashMap = cn.shuzilm.core.IDUService.Stub.getDefaultImpl().onEventAsyn(str, str2, str3, dUListener);
                    }
                    return readHashMap;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // cn.shuzilm.core.IDUService
            public void report(java.lang.String str, java.lang.String str2) {
                android.os.Parcel obtain = android.os.Parcel.obtain();
                android.os.Parcel obtain2 = android.os.Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(cn.shuzilm.core.IDUService.Stub.DESCRIPTOR);
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    if (this.mRemote.transact(4, obtain, obtain2, 0) || cn.shuzilm.core.IDUService.Stub.getDefaultImpl() == null) {
                        obtain2.readException();
                    } else {
                        cn.shuzilm.core.IDUService.Stub.getDefaultImpl().report(str, str2);
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // cn.shuzilm.core.IDUService
            public int setConfig(java.lang.String str, java.lang.String str2) {
                int readInt;
                android.os.Parcel obtain = android.os.Parcel.obtain();
                android.os.Parcel obtain2 = android.os.Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(cn.shuzilm.core.IDUService.Stub.DESCRIPTOR);
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    if (this.mRemote.transact(2, obtain, obtain2, 0) || cn.shuzilm.core.IDUService.Stub.getDefaultImpl() == null) {
                        obtain2.readException();
                        readInt = obtain2.readInt();
                    } else {
                        readInt = cn.shuzilm.core.IDUService.Stub.getDefaultImpl().setConfig(str, str2);
                    }
                    return readInt;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // cn.shuzilm.core.IDUService
            public int setData(java.lang.String str, java.lang.String str2) {
                int readInt;
                android.os.Parcel obtain = android.os.Parcel.obtain();
                android.os.Parcel obtain2 = android.os.Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(cn.shuzilm.core.IDUService.Stub.DESCRIPTOR);
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    if (this.mRemote.transact(1, obtain, obtain2, 0) || cn.shuzilm.core.IDUService.Stub.getDefaultImpl() == null) {
                        obtain2.readException();
                        readInt = obtain2.readInt();
                    } else {
                        readInt = cn.shuzilm.core.IDUService.Stub.getDefaultImpl().setData(str, str2);
                    }
                    return readInt;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

        public Stub() {
            attachInterface(this, DESCRIPTOR);
        }

        public static cn.shuzilm.core.IDUService asInterface(android.os.IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            android.os.IInterface queryLocalInterface = iBinder.queryLocalInterface(DESCRIPTOR);
            return (queryLocalInterface == null || !(queryLocalInterface instanceof cn.shuzilm.core.IDUService)) ? new cn.shuzilm.core.IDUService.Stub.Proxy(iBinder) : (cn.shuzilm.core.IDUService) queryLocalInterface;
        }

        public static cn.shuzilm.core.IDUService getDefaultImpl() {
            return cn.shuzilm.core.IDUService.Stub.Proxy.sDefaultImpl;
        }

        public static boolean setDefaultImpl(cn.shuzilm.core.IDUService iDUService) {
            if (cn.shuzilm.core.IDUService.Stub.Proxy.sDefaultImpl != null) {
                throw new java.lang.IllegalStateException("setDefaultImpl() called twice");
            }
            if (iDUService == null) {
                return false;
            }
            cn.shuzilm.core.IDUService.Stub.Proxy.sDefaultImpl = iDUService;
            return true;
        }

        @Override // android.os.IInterface
        public android.os.IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, android.os.Parcel parcel, android.os.Parcel parcel2, int i2) {
            if (i == 1598968902) {
                parcel2.writeString(DESCRIPTOR);
                return true;
            }
            switch (i) {
                case 1:
                    parcel.enforceInterface(DESCRIPTOR);
                    int data = setData(parcel.readString(), parcel.readString());
                    parcel2.writeNoException();
                    parcel2.writeInt(data);
                    return true;
                case 2:
                    parcel.enforceInterface(DESCRIPTOR);
                    int config = setConfig(parcel.readString(), parcel.readString());
                    parcel2.writeNoException();
                    parcel2.writeInt(config);
                    return true;
                case 3:
                    parcel.enforceInterface(DESCRIPTOR);
                    go(parcel.readString(), parcel.readString());
                    parcel2.writeNoException();
                    return true;
                case 4:
                    parcel.enforceInterface(DESCRIPTOR);
                    report(parcel.readString(), parcel.readString());
                    parcel2.writeNoException();
                    return true;
                case 5:
                    parcel.enforceInterface(DESCRIPTOR);
                    java.lang.String queryID = getQueryID(parcel.readString(), parcel.readString());
                    parcel2.writeNoException();
                    parcel2.writeString(queryID);
                    return true;
                case 6:
                    parcel.enforceInterface(DESCRIPTOR);
                    java.util.Map onEvent = onEvent(parcel.readString(), parcel.readString(), parcel.readString());
                    parcel2.writeNoException();
                    parcel2.writeMap(onEvent);
                    return true;
                case 7:
                    parcel.enforceInterface(DESCRIPTOR);
                    java.util.Map onEventAsyn = onEventAsyn(parcel.readString(), parcel.readString(), parcel.readString(), cn.shuzilm.core.DUListener.Stub.asInterface(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    parcel2.writeMap(onEventAsyn);
                    return true;
                case 8:
                    parcel.enforceInterface(DESCRIPTOR);
                    java.util.Map queryIDAsyn = getQueryIDAsyn(parcel.readString(), parcel.readString(), cn.shuzilm.core.DUListener.Stub.asInterface(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    parcel2.writeMap(queryIDAsyn);
                    return true;
                case 9:
                    parcel.enforceInterface(DESCRIPTOR);
                    getOpenAnmsIDAsyn(cn.shuzilm.core.DUListener.Stub.asInterface(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                default:
                    return super.onTransact(i, parcel, parcel2, i2);
            }
        }
    }

    void getOpenAnmsIDAsyn(cn.shuzilm.core.DUListener dUListener);

    java.lang.String getQueryID(java.lang.String str, java.lang.String str2);

    java.util.Map getQueryIDAsyn(java.lang.String str, java.lang.String str2, cn.shuzilm.core.DUListener dUListener);

    void go(java.lang.String str, java.lang.String str2);

    java.util.Map onEvent(java.lang.String str, java.lang.String str2, java.lang.String str3);

    java.util.Map onEventAsyn(java.lang.String str, java.lang.String str2, java.lang.String str3, cn.shuzilm.core.DUListener dUListener);

    void report(java.lang.String str, java.lang.String str2);

    int setConfig(java.lang.String str, java.lang.String str2);

    int setData(java.lang.String str, java.lang.String str2);
}
