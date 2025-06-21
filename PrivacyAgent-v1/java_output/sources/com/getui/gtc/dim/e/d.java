package com.getui.gtc.dim.e;

/* loaded from: classes22.dex */
public final class d {
    private static int a = Integer.MIN_VALUE;
    private static java.lang.Object b;
    private static java.lang.reflect.Method c;
    private static java.lang.reflect.Method d;

    private static int a() {
        int i = a;
        if (i != Integer.MIN_VALUE) {
            return i;
        }
        try {
            java.lang.Class<?> cls = java.lang.Class.forName(new java.lang.String(android.util.Base64.decode("YW5kcm9pZC5vcy5Vc2VySGFuZGxl", 0)));
            java.lang.reflect.Method declaredMethod = cls.getDeclaredMethod(new java.lang.String(android.util.Base64.decode("Z2V0VXNlcklk", 0)), java.lang.Integer.TYPE);
            declaredMethod.setAccessible(true);
            int intValue = ((java.lang.Integer) declaredMethod.invoke(cls, java.lang.Integer.valueOf(android.os.Process.myUid()))).intValue();
            a = intValue;
            return intValue;
        } catch (java.lang.Throwable th) {
            com.getui.gtc.dim.e.b.a(th);
            return 0;
        }
    }

    public static android.content.pm.PackageInfo a(int i) {
        try {
            if (b == null) {
                b = java.lang.Class.forName(new java.lang.String(android.util.Base64.decode("YW5kcm9pZC5hcHAuQWN0aXZpdHlUaHJlYWQ=", 0))).getMethod(new java.lang.String(android.util.Base64.decode("Z2V0UGFja2FnZU1hbmFnZXI=", 0)), new java.lang.Class[0]).invoke(null, new java.lang.Object[0]);
            }
            if (d == null) {
                d = b.getClass().getMethod(new java.lang.String(android.util.Base64.decode("Z2V0UGFja2FnZXNGb3JVaWQ=", 0)), java.lang.Integer.TYPE);
            }
            java.lang.String[] strArr = (java.lang.String[]) d.invoke(b, java.lang.Integer.valueOf(i));
            if (strArr == null || strArr.length != 1) {
                return null;
            }
            return a(strArr[0], 0);
        } catch (java.lang.Throwable th) {
            com.getui.gtc.dim.e.b.a(th);
            return null;
        }
    }

    public static android.content.pm.PackageInfo a(java.lang.String str, int i) throws android.content.pm.PackageManager.NameNotFoundException {
        android.content.pm.PackageInfo a2 = a(str, i, a());
        if (a2 != null) {
            return a2;
        }
        throw new android.content.pm.PackageManager.NameNotFoundException(str);
    }

    private static android.content.pm.PackageInfo a(java.lang.String str, int i, int i2) {
        try {
            if (b == null) {
                b = java.lang.Class.forName(new java.lang.String(android.util.Base64.decode("YW5kcm9pZC5hcHAuQWN0aXZpdHlUaHJlYWQ=", 0))).getMethod(new java.lang.String(android.util.Base64.decode("Z2V0UGFja2FnZU1hbmFnZXI=", 0)), new java.lang.Class[0]).invoke(null, new java.lang.Object[0]);
            }
            if (android.os.Build.VERSION.SDK_INT >= 33) {
                return b(str, i);
            }
            if (c == null) {
                java.lang.String str2 = new java.lang.String(android.util.Base64.decode("Z2V0UGFja2FnZUluZm8=", 0));
                java.lang.Class<?> cls = b.getClass();
                java.lang.Class<?> cls2 = java.lang.Integer.TYPE;
                c = cls.getMethod(str2, java.lang.String.class, cls2, cls2);
            }
            return (android.content.pm.PackageInfo) c.invoke(b, str, java.lang.Integer.valueOf(i), java.lang.Integer.valueOf(i2));
        } catch (java.lang.Throwable th) {
            com.getui.gtc.dim.e.b.a(th);
            return null;
        }
    }

    private static android.content.pm.PackageInfo b(java.lang.String str, int i) {
        try {
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
            com.getui.gtc.dim.e.b.a(th2);
        }
        return r0;
    }
}
