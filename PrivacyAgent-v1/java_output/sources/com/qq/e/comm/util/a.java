package com.qq.e.comm.util;

/* loaded from: classes19.dex */
public class a {
    private static final java.util.Map<java.lang.String, java.lang.Boolean> a = new java.util.HashMap();

    private static boolean a(java.lang.Class cls, java.lang.String str, java.lang.Class... clsArr) {
        java.lang.String sb;
        if (cls == null) {
            sb = "";
        } else {
            java.lang.StringBuilder sb2 = new java.lang.StringBuilder();
            sb2.append(cls.getName());
            sb2.append("#");
            sb2.append(str);
            for (java.lang.Class cls2 : clsArr) {
                sb2.append("_");
                sb2.append(cls2.getName());
            }
            sb = sb2.toString();
        }
        java.util.Map<java.lang.String, java.lang.Boolean> map = a;
        java.lang.Boolean bool = map.get(sb);
        if (bool != null) {
            return java.lang.Boolean.TRUE.equals(bool);
        }
        try {
            cls.getDeclaredMethod(str, clsArr);
            map.put(sb, java.lang.Boolean.TRUE);
            return true;
        } catch (java.lang.NoSuchMethodException unused) {
            a.put(sb, java.lang.Boolean.FALSE);
            return false;
        }
    }

    public static boolean a(java.lang.Object obj) {
        if (obj == null) {
            return false;
        }
        return a(obj.getClass(), "onRenderFail", new java.lang.Class[0]);
    }

    public static boolean b(java.lang.Object obj) {
        if (obj == null) {
            return false;
        }
        return a(obj.getClass(), "onRenderSuccess", new java.lang.Class[0]);
    }
}
