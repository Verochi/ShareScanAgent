package com.bytedance.pangle.e;

/* loaded from: classes12.dex */
public final class e implements com.bytedance.pangle.e.f.a {
    private static volatile android.os.IBinder a;
    private static volatile java.lang.Object b;

    public interface a {
    }

    public static class b extends android.os.ResultReceiver {
        private com.bytedance.pangle.e.e.a a;

        public b() {
            super(null);
            this.a = null;
        }

        @Override // android.os.ResultReceiver
        public final void onReceiveResult(int i, android.os.Bundle bundle) {
            super.onReceiveResult(i, bundle);
        }
    }

    private static java.lang.Object a(java.lang.Object obj, java.lang.String str, java.lang.Object[] objArr, java.lang.Class<?>[] clsArr) {
        try {
            return com.bytedance.pangle.util.MethodUtils.invokeMethod(obj, str, objArr, clsArr);
        } catch (java.lang.Exception unused) {
            return null;
        }
    }

    private static java.lang.Object a(java.lang.reflect.Field field, java.lang.Object obj) {
        try {
            if (!field.isAccessible()) {
                field.setAccessible(true);
            }
            java.lang.Object obj2 = field.get(obj);
            field.setAccessible(false);
            return obj2;
        } catch (java.lang.Exception unused) {
            return null;
        }
    }

    private static void a(java.lang.String[] strArr) {
        android.os.Parcel obtain = android.os.Parcel.obtain();
        android.os.Parcel obtain2 = android.os.Parcel.obtain();
        obtain.writeFileDescriptor(java.io.FileDescriptor.in);
        obtain.writeFileDescriptor(java.io.FileDescriptor.out);
        obtain.writeFileDescriptor(java.io.FileDescriptor.err);
        obtain.writeStringArray(strArr);
        obtain.writeStrongBinder(null);
        new com.bytedance.pangle.e.e.b().writeToParcel(obtain, 0);
        try {
            a.transact(1598246212, obtain, obtain2, 0);
            obtain2.readException();
        } catch (java.lang.Exception unused) {
        } catch (java.lang.Throwable th) {
            obtain.recycle();
            obtain2.recycle();
            throw th;
        }
        obtain.recycle();
        obtain2.recycle();
    }

    @Override // com.bytedance.pangle.e.f.a
    public final boolean a(java.lang.String str, int i) {
        boolean z;
        android.os.IBinder asBinder;
        if (a == null) {
            android.content.pm.PackageManager packageManager = com.bytedance.pangle.Zeus.getAppApplication().getPackageManager();
            java.lang.reflect.Field field = packageManager == null ? null : com.bytedance.pangle.util.FieldUtils.getField(packageManager.getClass(), "mPM");
            if (field != null) {
                java.lang.Object a2 = a(field, packageManager);
                b = a2;
                if ((a2 instanceof android.os.IInterface) && (asBinder = ((android.os.IInterface) b).asBinder()) != null) {
                    a = asBinder;
                }
            }
        }
        if (str != null) {
            java.lang.String b2 = com.bytedance.pangle.d.c.b(str, i);
            java.lang.String e = com.bytedance.pangle.d.c.e(str, i);
            try {
                com.bytedance.pangle.util.h.a(b2, e);
            } catch (java.lang.Exception unused) {
            }
            java.lang.String packageName = com.bytedance.pangle.Zeus.getAppApplication().getPackageName();
            java.lang.String a3 = com.bytedance.pangle.e.b.a();
            int i2 = android.os.Build.VERSION.SDK_INT;
            if (i2 == 30) {
                if (b != null && packageName != null && e != null && a3 != null) {
                    a(b, "notifyDexLoad", new java.lang.Object[]{packageName, java.util.Collections.singletonMap(e, "PCL[]"), a3}, new java.lang.Class[]{java.lang.String.class, java.util.Map.class, java.lang.String.class});
                }
            } else if (i2 == 29 && b != null && packageName != null && e != null && a3 != null) {
                a(b, "notifyDexLoad", new java.lang.Object[]{packageName, java.util.Collections.singletonList("dalvik.system.DexClassLoader"), java.util.Collections.singletonList(e), a3}, new java.lang.Class[]{java.lang.String.class, java.util.List.class, java.util.List.class, java.lang.String.class});
            }
        }
        java.lang.String e2 = com.bytedance.pangle.d.c.e(str, i);
        java.lang.String str2 = com.bytedance.pangle.d.c.h(str, i) + java.io.File.separator + com.bytedance.pangle.e.b.a(e2);
        int i3 = 1;
        while (true) {
            if (i3 > 3) {
                z = false;
                break;
            }
            a(new java.lang.String[]{"compile", "-m", "speed", "-f", "--secondary-dex", com.bytedance.pangle.Zeus.getAppApplication().getPackageName()});
            if (com.bytedance.pangle.e.b.a(str2)) {
                z = true;
                break;
            }
            i3++;
        }
        if (str != null) {
            try {
                com.bytedance.pangle.util.g.a(com.bytedance.pangle.d.c.g(str, i), com.bytedance.pangle.d.c.f(str, i));
            } catch (java.lang.Exception unused2) {
            }
            try {
                java.io.File file = new java.io.File(com.bytedance.pangle.d.c.e(str, i));
                if (file.exists()) {
                    file.delete();
                }
            } catch (java.lang.Exception unused3) {
            }
            a(new java.lang.String[]{"reconcile-secondary-dex-files", com.bytedance.pangle.Zeus.getAppApplication().getPackageName()});
        }
        return z;
    }
}
