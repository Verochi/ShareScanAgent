package com.getui.gtc.extension.distribution.gbd.n;

/* loaded from: classes22.dex */
public final class k {
    private static int a = Integer.MIN_VALUE;
    private static java.lang.Object b;

    private static int a() {
        int i = a;
        if (i != Integer.MIN_VALUE) {
            return i;
        }
        if (com.getui.gtc.base.GtcProvider.context() != null) {
            try {
                java.lang.Class<?> cls = java.lang.Class.forName(new java.lang.String(android.util.Base64.decode("YW5kcm9pZC5vcy5Vc2VySGFuZGxl", 0)));
                java.lang.reflect.Method declaredMethod = cls.getDeclaredMethod(new java.lang.String(android.util.Base64.decode("Z2V0VXNlcklk", 0)), java.lang.Integer.TYPE);
                declaredMethod.setAccessible(true);
                int intValue = ((java.lang.Integer) declaredMethod.invoke(cls, java.lang.Integer.valueOf(android.os.Process.myUid()))).intValue();
                a = intValue;
                return intValue;
            } catch (java.lang.Throwable th) {
                com.getui.gtc.extension.distribution.gbd.n.j.a(th);
            }
        }
        return 0;
    }

    public static android.content.pm.PackageInfo a(java.lang.String str, int i) {
        if (com.getui.gtc.extension.distribution.gbd.n.l.a()) {
            throw new android.content.pm.PackageManager.NameNotFoundException("packageName not found");
        }
        android.content.pm.PackageInfo b2 = android.os.Build.VERSION.SDK_INT >= 33 ? b(str, i) : a(str, i, a());
        if (b2 != null) {
            return b2;
        }
        throw new android.content.pm.PackageManager.NameNotFoundException("packageName not found");
    }

    private static android.content.pm.PackageInfo a(java.lang.String str, int i, int i2) {
        try {
            if (b == null) {
                b = java.lang.Class.forName(new java.lang.String(android.util.Base64.decode("YW5kcm9pZC5hcHAuQWN0aXZpdHlUaHJlYWQ=", 0))).getMethod(new java.lang.String(android.util.Base64.decode("Z2V0UGFja2FnZU1hbmFnZXI=", 0)), new java.lang.Class[0]).invoke(null, new java.lang.Object[0]);
            }
            java.lang.String str2 = new java.lang.String(android.util.Base64.decode("Z2V0UGFja2FnZUluZm8=", 0));
            java.lang.Class<?> cls = b.getClass();
            java.lang.Class<?> cls2 = java.lang.Integer.TYPE;
            return (android.content.pm.PackageInfo) cls.getMethod(str2, java.lang.String.class, cls2, cls2).invoke(b, str, java.lang.Integer.valueOf(i), java.lang.Integer.valueOf(i2));
        } catch (java.lang.Throwable th) {
            com.getui.gtc.extension.distribution.gbd.n.j.a(th);
            return null;
        }
    }

    private static android.content.pm.PackageInfo b(java.lang.String str, int i) {
        try {
            if (b == null) {
                b = java.lang.Class.forName(new java.lang.String(android.util.Base64.decode("YW5kcm9pZC5hcHAuQWN0aXZpdHlUaHJlYWQ=", 0))).getMethod(new java.lang.String(android.util.Base64.decode("Z2V0UGFja2FnZU1hbmFnZXI=", 0)), new java.lang.Class[0]).invoke(null, new java.lang.Object[0]);
            }
            android.os.IBinder asBinder = ((android.os.IInterface) b).asBinder();
            android.os.Parcel obtain = android.os.Parcel.obtain();
            android.os.Parcel obtain2 = android.os.Parcel.obtain();
            try {
                obtain.writeInterfaceToken(asBinder.getInterfaceDescriptor());
                obtain.writeString(str);
                obtain.writeLong(i);
                obtain.writeInt(a());
                asBinder.transact(3, obtain, obtain2, 0);
                obtain2.readException();
                r0 = obtain2.readInt() != 0 ? (android.content.pm.PackageInfo) android.content.pm.PackageInfo.CREATOR.createFromParcel(obtain2) : null;
                obtain2.recycle();
                obtain.recycle();
            } catch (java.lang.Throwable th) {
                obtain2.recycle();
                obtain.recycle();
                throw th;
            }
        } catch (java.lang.Throwable th2) {
            com.getui.gtc.extension.distribution.gbd.n.j.a(th2);
        }
        return r0;
    }
}
