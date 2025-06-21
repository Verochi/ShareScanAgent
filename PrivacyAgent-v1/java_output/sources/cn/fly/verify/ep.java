package cn.fly.verify;

/* loaded from: classes.dex */
public class ep {
    static volatile android.os.IBinder a = null;
    private static int b = 0;
    private static volatile int c = Integer.MIN_VALUE;

    private static int a(android.content.Context context) throws java.lang.Throwable {
        int i = b;
        if (i != 0) {
            return i;
        }
        int intValue = ((java.lang.Integer) cn.fly.verify.em.a(context).a(cn.fly.verify.dt.a("034de.dcdjeddidcfd5c,edFeifeiBfdRjOdffdeigl5dc*dlNd+eeOf[hcKdedTeeGfUdj") + "$" + cn.fly.verify.dt.a("004KejBiLdgfe"), cn.fly.verify.dt.a("026:ekgielehejelgkekeiggehdheeWfi=glRdc8dl3dYeeSf'ei=e7efed"), null)).intValue();
        b = intValue;
        return intValue;
    }

    private static android.os.Parcelable.Creator<?> a() throws java.lang.Throwable {
        return (android.os.Parcelable.Creator) cn.fly.verify.fp.c(cn.fly.verify.fp.a(cn.fly.verify.dt.a("030de5dcdjeddidcfdJc2edKeifeiHfdBjNdffdglIdc<dlHd,ee7fQei+eEefed")), cn.fly.verify.dt.a("007?gkgighelekgggi"));
    }

    public static java.lang.Object a(android.content.Context context, java.lang.String str, int i) throws java.lang.Throwable {
        return a(context, str, i, b(), a(context));
    }

    private static java.lang.Object a(android.content.Context context, java.lang.String str, int i, int i2, int i3) throws java.lang.Throwable {
        java.lang.Object readTypedObject;
        if (android.os.Build.VERSION.SDK_INT < 23) {
            return null;
        }
        if (a == null) {
            a = (android.os.IBinder) cn.fly.verify.em.a(context).a(cn.fly.verify.dt.a("025dePdcdjeddidcfdedfhfdej2f8djdddiGcfFhc]dedAeeTf'dj"), (java.lang.Object) null, cn.fly.verify.dt.a("010=ee=fi]ej fJdjdddiYcf"), new java.lang.Class[]{java.lang.String.class}, new java.lang.Object[]{cn.fly.verify.dt.a("007jdcLdl]d<eeAf")});
        }
        android.os.Parcel obtain = android.os.Parcel.obtain();
        android.os.Parcel obtain2 = android.os.Parcel.obtain();
        try {
            obtain.writeInterfaceToken(cn.fly.verify.dt.a("034deGdcdjeddidcfd*c4ed.eifeiSfdHjJdffdeiglHdcZdl0d.ee5fDhc6ded5ee1f)dj"));
            obtain.writeString(str);
            obtain.writeInt(i);
            obtain.writeInt(i2);
            a.transact(i3, obtain, obtain2, 0);
            obtain2.readException();
            readTypedObject = obtain2.readTypedObject(a());
            return readTypedObject;
        } finally {
            obtain2.recycle();
            obtain.recycle();
            cn.fly.verify.em.a(context).b(context);
        }
    }

    private static int b() {
        if (c != Integer.MIN_VALUE) {
            return c;
        }
        try {
            int intValue = ((java.lang.Integer) cn.fly.verify.fp.a(cn.fly.verify.fp.a(cn.fly.verify.dt.a("021deEdcdjeddidcfdedfhfdegfh5fAdjfjCdeBdcZgf")), cn.fly.verify.dt.a("009Fee0fiSegfhVfRdjeidc"), new java.lang.Object[]{java.lang.Integer.valueOf(android.os.Process.myUid())}, (java.lang.Class<?>[]) new java.lang.Class[]{java.lang.Integer.TYPE})).intValue();
            c = intValue;
            return intValue;
        } catch (java.lang.Throwable th) {
            cn.fly.verify.ed.a().a(th);
            return 0;
        }
    }
}
