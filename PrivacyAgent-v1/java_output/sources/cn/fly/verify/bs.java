package cn.fly.verify;

/* loaded from: classes.dex */
public class bs extends cn.fly.verify.bu {
    public bs(android.content.Context context) {
        super(context);
    }

    @Override // cn.fly.verify.bu
    public android.content.Intent a() {
        android.content.Intent intent = new android.content.Intent();
        intent.setAction(cn.fly.verify.dn.a("028a5cbbddb?fVbg8fQcb1cCcbbhdbbgbadbdh3c,eeAbVcgbachMdUbhbbbg5ad"));
        intent.setPackage(cn.fly.verify.dn.a("014aGcbbddbGfHbg@fMcb=cYcbbhdbbgba"));
        return intent;
    }

    @Override // cn.fly.verify.bu
    public cn.fly.verify.bu.b a(android.os.IBinder iBinder) {
        java.util.concurrent.CountDownLatch countDownLatch = new java.util.concurrent.CountDownLatch(1);
        cn.fly.verify.Cdo cdo = new cn.fly.verify.Cdo();
        cdo.a(countDownLatch);
        long currentTimeMillis = java.lang.System.currentTimeMillis();
        android.os.Parcel obtain = android.os.Parcel.obtain();
        android.os.Parcel obtain2 = android.os.Parcel.obtain();
        try {
            try {
                obtain.writeInterfaceToken(cn.fly.verify.dn.a("042a)cbbddb]f-bg^fTcb3c*cbbhdbBae1cbbebadf-dKbhbbbg@adQdbcbCb$bgbadbcgeecjcgdich7dXbhbbbg3ad"));
                obtain.writeStrongBinder(cdo);
                iBinder.transact(2, obtain, obtain2, 0);
                obtain2.readException();
                countDownLatch.await(2000L, java.util.concurrent.TimeUnit.MILLISECONDS);
                obtain.recycle();
            } catch (java.lang.Throwable th) {
                try {
                    cn.fly.verify.ed.a().a(th);
                    obtain.recycle();
                } catch (java.lang.Throwable th2) {
                    try {
                        obtain.recycle();
                        obtain2.recycle();
                    } catch (java.lang.Throwable unused) {
                    }
                    throw th2;
                }
            }
            obtain2.recycle();
        } catch (java.lang.Throwable unused2) {
        }
        cn.fly.verify.ed.a().a("hord is null ? " + android.text.TextUtils.isEmpty(cdo.a()) + " cost " + (java.lang.System.currentTimeMillis() - currentTimeMillis), new java.lang.Object[0]);
        if (android.text.TextUtils.isEmpty(cdo.a())) {
            return null;
        }
        cn.fly.verify.bu.b bVar = new cn.fly.verify.bu.b();
        bVar.b = cdo.a();
        return bVar;
    }
}
