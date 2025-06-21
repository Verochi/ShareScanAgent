package com.bytedance.pangle.e;

/* loaded from: classes12.dex */
public final class b {
    public static int a = 1;
    public static int b = 2;

    public static android.content.SharedPreferences a(android.content.Context context) {
        return context.getApplicationContext().getSharedPreferences("plugin_oat_info", 0);
    }

    public static java.lang.String a() {
        try {
            return (java.lang.String) com.bytedance.pangle.util.MethodUtils.invokeStaticMethod(java.lang.Class.forName("dalvik.system.VMRuntime"), "getCurrentInstructionSet", new java.lang.Object[0]);
        } catch (java.lang.Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static java.lang.String a(java.lang.String str) {
        java.lang.String substring = str.substring(str.lastIndexOf(net.lingala.zip4j.util.InternalZipConstants.ZIP_FILE_SEPARATOR) + 1);
        java.lang.String substring2 = substring.substring(substring.lastIndexOf("."));
        java.lang.String str2 = android.os.Build.VERSION.SDK_INT >= 26 ? ".odex" : ".dex";
        if (".dex".equals(substring2)) {
            return substring;
        }
        if (".zip".equals(substring2) || com.anythink.china.common.a.a.g.equals(substring2)) {
            return substring.replace(substring2, str2);
        }
        return substring + str2;
    }

    public static boolean a(java.lang.String str, java.lang.String str2) {
        return com.bytedance.pangle.e.a.a(a(str, str2, a));
    }

    public static boolean a(java.lang.String str, java.lang.String... strArr) {
        for (java.lang.String str2 : strArr) {
            if (!new java.io.File(str + java.io.File.separator + a(str2)).exists()) {
                return false;
            }
        }
        return true;
    }

    public static boolean a(java.lang.String... strArr) {
        for (int i = 0; i <= 0; i++) {
            java.io.File file = new java.io.File(strArr[0]);
            if (!file.exists() || !com.bytedance.pangle.e.h.a(file)) {
                return false;
            }
        }
        return true;
    }

    public static java.lang.String[] a(java.lang.String str, java.lang.String str2, int i) {
        java.util.ArrayList arrayList = new java.util.ArrayList();
        arrayList.add("dex2oat");
        if (android.os.Build.VERSION.SDK_INT >= 24) {
            arrayList.add("--runtime-arg");
            arrayList.add("-classpath");
            arrayList.add("--runtime-arg");
            arrayList.add("&");
        }
        arrayList.add("--instruction-set=" + a());
        if (i == a) {
            if (com.bytedance.pangle.util.i.i()) {
                arrayList.add("--compiler-filter=quicken");
            } else {
                arrayList.add("--compiler-filter=interpret-only");
            }
        } else if (i == b) {
            arrayList.add("--compiler-filter=speed");
        }
        arrayList.add("--dex-file=".concat(java.lang.String.valueOf(str)));
        arrayList.add("--oat-file=".concat(java.lang.String.valueOf(str2)));
        return (java.lang.String[]) arrayList.toArray(new java.lang.String[arrayList.size()]);
    }

    public static java.lang.String b(java.lang.String str) {
        java.lang.String substring = str.substring(str.lastIndexOf("."));
        java.lang.String str2 = android.os.Build.VERSION.SDK_INT >= 26 ? ".odex" : ".dex";
        if (".dex".equals(substring)) {
            return substring;
        }
        if (".zip".equals(substring) || com.anythink.china.common.a.a.g.equals(substring)) {
            return str2;
        }
        return str + str2;
    }
}
