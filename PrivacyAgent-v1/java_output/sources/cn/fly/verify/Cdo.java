package cn.fly.verify;

/* renamed from: cn.fly.verify.do, reason: invalid class name */
/* loaded from: classes.dex */
public class Cdo extends android.os.Binder implements android.os.IInterface {
    private java.util.concurrent.CountDownLatch a;
    private volatile java.lang.String b;
    private volatile boolean c = false;
    private final java.lang.String d;

    public Cdo() {
        java.lang.String a = cn.fly.verify.dn.a("043aEcbbddbLf]bgLf]cbYc0cbbhdbHae0cbbebadfNdYbhbbbg1ad4dbcbNb?bgbadbcgeecjcgdieiKbeeKdgSba0bj");
        this.d = a;
        attachInterface(this, a);
    }

    public cn.fly.verify.Cdo a(java.util.concurrent.CountDownLatch countDownLatch) {
        this.a = countDownLatch;
        return this;
    }

    public java.lang.String a() {
        return this.b;
    }

    public void a(int i, long j, boolean z, float f, double d, java.lang.String str) {
    }

    public void a(int i, android.os.Bundle bundle) {
        try {
            if (bundle.containsKey(cn.fly.verify.dn.a("010Hcb_b+bfbgbabfcd[eb)cc"))) {
                this.b = bundle.getString(cn.fly.verify.dn.a("010Tcb$bXbfbgbabfcdQeb<cc"));
            } else if (bundle.containsKey(cn.fly.verify.dn.a("017)cbJb+bfbgbabf7e2bgbdbgGg@bfdf>gbgd"))) {
                this.c = bundle.getBoolean(cn.fly.verify.dn.a("017QcbPbDbfbgbabf-e,bgbdbg]g'bfdf-gbgd"));
            }
            java.util.concurrent.CountDownLatch countDownLatch = this.a;
            if (countDownLatch != null) {
                countDownLatch.countDown();
            }
        } catch (java.lang.Throwable th) {
            cn.fly.verify.ed.a().a(th);
        }
    }

    @Override // android.os.IInterface
    public android.os.IBinder asBinder() {
        return this;
    }

    public boolean b() {
        return this.c;
    }

    @Override // android.os.Binder, android.os.IBinder
    public java.lang.String getInterfaceDescriptor() {
        return this.d;
    }

    @Override // android.os.Binder
    public boolean onTransact(int i, android.os.Parcel parcel, android.os.Parcel parcel2, int i2) throws android.os.RemoteException {
        if (i == 1) {
            parcel.enforceInterface(this.d);
            a(parcel.readInt(), parcel.readLong(), parcel.readInt() > 0, parcel.readFloat(), parcel.readDouble(), parcel.readString());
        } else {
            if (i != 2) {
                if (i != 1598968902) {
                    return super.onTransact(i, parcel, parcel2, i2);
                }
                parcel2.writeString(this.d);
                return true;
            }
            parcel.enforceInterface(this.d);
            a(parcel.readInt(), parcel.readInt() > 0 ? (android.os.Bundle) android.os.Bundle.CREATOR.createFromParcel(parcel) : null);
        }
        parcel2.writeNoException();
        return true;
    }
}
