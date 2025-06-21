package com.bytedance.pangle.dex;

/* loaded from: classes12.dex */
public final class a {
    private static volatile int a;
    private static volatile java.lang.reflect.Constructor<?> b;

    /* JADX WARN: Removed duplicated region for block: B:11:0x007f  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0063 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:25:0x004e A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0037 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:35:0x001d A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static java.lang.Object a(java.io.File file, java.lang.Object obj) {
        java.lang.Class<?> cls;
        int i = a;
        java.lang.reflect.Constructor<?> constructor = b;
        if (constructor == null) {
            try {
                cls = java.lang.Class.forName("dalvik.system.DexPathList$Element");
            } catch (java.lang.Exception unused) {
            }
            if (constructor == null) {
                try {
                    constructor = cls.getConstructor(java.io.File.class, java.lang.Boolean.TYPE, java.io.File.class, dalvik.system.DexFile.class);
                    constructor.setAccessible(true);
                    i = 8;
                } catch (java.lang.Exception unused2) {
                    constructor = null;
                }
            }
            if (constructor == null) {
                try {
                    constructor = cls.getConstructor(java.io.File.class, java.util.zip.ZipFile.class, dalvik.system.DexFile.class);
                    constructor.setAccessible(true);
                    i = 4;
                } catch (java.lang.Exception unused3) {
                    constructor = null;
                }
            }
            if (constructor == null) {
                try {
                    constructor = cls.getConstructor(java.io.File.class, java.io.File.class, dalvik.system.DexFile.class);
                    constructor.setAccessible(true);
                    i = 2;
                } catch (java.lang.Exception unused4) {
                    constructor = null;
                }
            }
            if (constructor == null) {
                try {
                    constructor = cls.getConstructor(java.io.File.class, java.lang.Boolean.TYPE, java.io.File.class, dalvik.system.DexFile.class);
                    constructor.setAccessible(true);
                    i = 1;
                } catch (java.lang.Exception unused5) {
                    constructor = null;
                }
            }
            b = constructor;
            a = i;
            if (i != 1) {
                if (i == 2 || i == 4) {
                    return a(constructor, file, null, obj);
                }
                if (i != 8) {
                    return null;
                }
            }
            return a(constructor, file, java.lang.Boolean.FALSE, null, obj);
        }
        cls = null;
        if (constructor == null) {
        }
        if (constructor == null) {
        }
        if (constructor == null) {
        }
        if (constructor == null) {
        }
        b = constructor;
        a = i;
        if (i != 1) {
        }
        return a(constructor, file, java.lang.Boolean.FALSE, null, obj);
    }

    private static java.lang.Object a(java.lang.reflect.Constructor<?> constructor, java.lang.Object... objArr) {
        try {
            return constructor.newInstance(objArr);
        } catch (java.lang.Exception unused) {
            return null;
        }
    }

    public static void a(java.lang.ClassLoader classLoader, java.lang.String str, int i) {
        java.lang.Object obj = com.bytedance.pangle.util.FieldUtils.getField(classLoader.getClass(), "pathList").get(classLoader);
        java.util.ArrayList arrayList = new java.util.ArrayList();
        java.lang.String[] split = com.bytedance.pangle.e.g.a(str, i).split(com.xiaomi.mipush.sdk.Constants.COLON_SEPARATOR);
        java.lang.String c = com.bytedance.pangle.d.c.c(str, i);
        for (java.lang.String str2 : split) {
            java.lang.Object native_load_direct_dex = com.bytedance.pangle.dex.DirectDex.native_load_direct_dex(str2);
            if (native_load_direct_dex == null) {
                native_load_direct_dex = dalvik.system.DexFile.loadDex(str2, c + java.io.File.separator + com.bytedance.pangle.e.b.a(str2), 0);
            }
            arrayList.add(a(new java.io.File(str2), native_load_direct_dex));
        }
        java.lang.Object[] array = arrayList.toArray();
        java.lang.reflect.Field field = com.bytedance.pangle.util.FieldUtils.getField(obj.getClass(), "dexElements");
        java.lang.Object[] objArr = (java.lang.Object[]) field.get(obj);
        java.lang.Object[] objArr2 = (java.lang.Object[]) java.lang.reflect.Array.newInstance(objArr.getClass().getComponentType(), objArr.length + array.length);
        java.lang.System.arraycopy(objArr, 0, objArr2, 0, objArr.length);
        java.lang.System.arraycopy(array, 0, objArr2, objArr.length, array.length);
        field.set(obj, objArr2);
    }
}
