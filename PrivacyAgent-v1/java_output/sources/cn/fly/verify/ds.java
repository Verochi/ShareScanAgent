package cn.fly.verify;

/* loaded from: classes.dex */
public class ds {
    public static volatile java.lang.String a = null;
    public static volatile java.lang.String b = null;
    public static volatile java.lang.String c = null;
    public static volatile java.lang.String d = null;
    public static volatile cn.fly.verify.bb e = null;
    public static volatile boolean f = true;
    public static volatile boolean g = false;
    public static volatile boolean h = true;
    public static volatile boolean i;
    public static volatile java.lang.String j;
    private static java.util.concurrent.atomic.AtomicBoolean k = new java.util.concurrent.atomic.AtomicBoolean(false);
    private static final java.lang.String l = b("009Bgbdceddiejhbecce+h");
    private static final java.lang.String m = b("0113di^gcFci eFdiejhbecceVh");
    private static final java.lang.String n = b("010?gbdcedfkcfeg_g5ecce,h");
    private static final java.lang.String o = b("0128diIeb.fi!eJcichdecjecce<h");
    private static final java.lang.String p = b("009Idigbdidiejhbecce5h");
    private static final java.lang.String q = b("010Kgbdcedebch[dFckecce1h");
    private static java.util.HashMap<java.lang.String, java.util.HashMap<java.lang.String, java.lang.Object>> r = new java.util.HashMap<>();

    public static <T> T a(java.lang.String str) {
        try {
            android.os.Bundle bundle = cn.fly.verify.eh.a(cn.fly.verify.ax.g()).d().a(cn.fly.verify.ax.g().getPackageName(), 128).metaData;
            if (bundle == null) {
                return null;
            }
            T t = (T) bundle.get(str);
            if (b("0097gbdcedgjeiXhhiTeg").equals(str) && t != null && (t instanceof java.lang.String)) {
                return (T) java.lang.Boolean.valueOf(b("003WcjGe-eg").equalsIgnoreCase(java.lang.String.valueOf(t)));
            }
            if (t != null) {
                return t;
            }
            return null;
        } catch (java.lang.Throwable th) {
            cn.fly.verify.ed.a().a(th);
            return null;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:37:0x00aa  */
    /* JADX WARN: Type inference failed for: r10v1, types: [java.io.Closeable[]] */
    /* JADX WARN: Type inference failed for: r11v10 */
    /* JADX WARN: Type inference failed for: r11v11 */
    /* JADX WARN: Type inference failed for: r11v13, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r9v22, types: [java.lang.Class<java.lang.Double>] */
    /* JADX WARN: Type inference failed for: r9v27, types: [java.lang.Class<java.lang.Float>] */
    /* JADX WARN: Type inference failed for: r9v32, types: [java.lang.Class<java.lang.Long>] */
    /* JADX WARN: Type inference failed for: r9v37, types: [java.lang.Class<java.lang.Short>] */
    /* JADX WARN: Type inference failed for: r9v4, types: [java.io.Closeable[]] */
    /* JADX WARN: Type inference failed for: r9v41, types: [java.lang.Class<java.lang.Character>] */
    /* JADX WARN: Type inference failed for: r9v43, types: [java.lang.Class<java.lang.Byte>] */
    /* JADX WARN: Type inference failed for: r9v48, types: [java.lang.Class<java.lang.Integer>] */
    /* JADX WARN: Type inference failed for: r9v56, types: [java.lang.Class<java.lang.Boolean>] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static <T> T a(java.lang.String str, java.lang.Class<T> cls, cn.fly.verify.bd bdVar) {
        T t;
        java.util.zip.GZIPInputStream gZIPInputStream;
        java.util.HashMap<java.lang.String, java.lang.Object> hashMap;
        java.io.ObjectInputStream objectInputStream;
        T t2;
        T cast;
        java.lang.Class cls2;
        boolean z;
        T t3 = null;
        try {
            java.lang.String a2 = a(bdVar);
            if (r.containsKey(a2)) {
                hashMap = r.get(a2);
                gZIPInputStream = null;
                objectInputStream = null;
            } else {
                try {
                    gZIPInputStream = new java.util.zip.GZIPInputStream(cn.fly.verify.ax.g().getResources().getAssets().open(a2));
                    try {
                        objectInputStream = new java.io.ObjectInputStream(gZIPInputStream);
                        try {
                            java.util.HashMap<java.lang.String, java.lang.Object> hashMap2 = (java.util.HashMap) objectInputStream.readObject();
                            if (hashMap2 != null) {
                                try {
                                    if (!hashMap2.isEmpty()) {
                                        r.put(a2, hashMap2);
                                    }
                                } catch (java.lang.Throwable unused) {
                                    hashMap = hashMap2;
                                    try {
                                        cn.fly.verify.ed.a().a("No ast file", new java.lang.Object[0]);
                                        if (hashMap != null) {
                                            t2 = hashMap.get(str);
                                            if (!b("009(gbdcedgjeiAhhiEeg").equals(str)) {
                                            }
                                            if (t2 != 0) {
                                            }
                                        }
                                        cn.fly.verify.dw.a(objectInputStream, gZIPInputStream);
                                        return t3;
                                    } catch (java.lang.Throwable th) {
                                        th = th;
                                        t2 = 0;
                                        t3 = (T) objectInputStream;
                                        t = t2;
                                        try {
                                            cn.fly.verify.ed.a().a(th);
                                            cn.fly.verify.dw.a((java.io.Closeable[]) new java.io.Closeable[]{t3, gZIPInputStream});
                                            return t;
                                        } catch (java.lang.Throwable th2) {
                                            cn.fly.verify.dw.a((java.io.Closeable[]) new java.io.Closeable[]{t3, gZIPInputStream});
                                            throw th2;
                                        }
                                    }
                                }
                            }
                            hashMap = hashMap2;
                        } catch (java.lang.Throwable unused2) {
                            hashMap = null;
                        }
                    } catch (java.lang.Throwable unused3) {
                        hashMap = null;
                        objectInputStream = null;
                    }
                } catch (java.lang.Throwable unused4) {
                    hashMap = null;
                    gZIPInputStream = null;
                    objectInputStream = null;
                }
            }
            if (hashMap != null && !hashMap.isEmpty()) {
                t2 = hashMap.get(str);
                if (!b("009(gbdcedgjeiAhhiEeg").equals(str) && t2 != 0 && (t2 instanceof java.lang.String)) {
                    if (!b("003$cjTeGeg").equalsIgnoreCase(java.lang.String.valueOf(t2)) && !b("004hJcicfYe").equalsIgnoreCase(java.lang.String.valueOf(t2))) {
                        z = false;
                        t3 = (T) java.lang.Boolean.valueOf(z);
                    }
                    z = true;
                    t3 = (T) java.lang.Boolean.valueOf(z);
                } else if (t2 != 0) {
                    if (cls != null) {
                        if (cls != java.lang.Void.class) {
                            try {
                                if (cls == java.lang.Boolean.TYPE) {
                                    if (t2 instanceof java.lang.String) {
                                        cast = (T) java.lang.Boolean.valueOf((java.lang.String) t2);
                                        t3 = cast;
                                    } else {
                                        cls2 = java.lang.Boolean.class;
                                        cast = cls2.cast(t2);
                                        t3 = cast;
                                    }
                                } else if (cls == java.lang.Integer.TYPE) {
                                    if (t2 instanceof java.lang.String) {
                                        cast = (T) java.lang.Integer.valueOf((java.lang.String) t2);
                                        t3 = cast;
                                    } else {
                                        cls2 = java.lang.Integer.class;
                                        cast = cls2.cast(t2);
                                        t3 = cast;
                                    }
                                } else if (cls != java.lang.Byte.TYPE) {
                                    java.lang.Class<T> cls3 = java.lang.Character.TYPE;
                                    if (cls == cls3) {
                                        cls2 = t2 instanceof java.lang.String ? cls3 : java.lang.Character.class;
                                    } else if (cls == java.lang.Short.TYPE) {
                                        if (t2 instanceof java.lang.String) {
                                            cast = (T) java.lang.Short.valueOf((java.lang.String) t2);
                                            t3 = cast;
                                        } else {
                                            cls2 = java.lang.Short.class;
                                        }
                                    } else if (cls == java.lang.Long.TYPE) {
                                        if (t2 instanceof java.lang.String) {
                                            cast = (T) java.lang.Long.valueOf((java.lang.String) t2);
                                            t3 = cast;
                                        } else {
                                            cls2 = java.lang.Long.class;
                                        }
                                    } else if (cls != java.lang.Float.TYPE) {
                                        if (cls != java.lang.Double.TYPE) {
                                            cast = cls.cast(t2);
                                        } else if (t2 instanceof java.lang.String) {
                                            cast = (T) java.lang.Double.valueOf((java.lang.String) t2);
                                        } else {
                                            cls2 = java.lang.Double.class;
                                        }
                                        t3 = cast;
                                    } else if (t2 instanceof java.lang.String) {
                                        cast = (T) java.lang.Float.valueOf((java.lang.String) t2);
                                        t3 = cast;
                                    } else {
                                        cls2 = java.lang.Float.class;
                                    }
                                    cast = cls2.cast(t2);
                                    t3 = cast;
                                } else if (t2 instanceof java.lang.String) {
                                    cast = (T) java.lang.Byte.valueOf((java.lang.String) t2);
                                    t3 = cast;
                                } else {
                                    cls2 = java.lang.Byte.class;
                                    cast = cls2.cast(t2);
                                    t3 = cast;
                                }
                            } catch (java.lang.Throwable th3) {
                                try {
                                    cn.fly.verify.ed.a().a(th3);
                                } catch (java.lang.Throwable th4) {
                                    th = th4;
                                    t3 = (T) objectInputStream;
                                    t = t2;
                                    cn.fly.verify.ed.a().a(th);
                                    cn.fly.verify.dw.a((java.io.Closeable[]) new java.io.Closeable[]{t3, gZIPInputStream});
                                    return t;
                                }
                            }
                        }
                    }
                    t3 = t2;
                }
            }
            cn.fly.verify.dw.a(objectInputStream, gZIPInputStream);
            return t3;
        } catch (java.lang.Throwable th5) {
            th = th5;
            t = null;
            gZIPInputStream = null;
        }
    }

    private static java.lang.String a(cn.fly.verify.bd bdVar) {
        java.lang.String str;
        java.lang.String str2 = l;
        if (bdVar == null) {
            return str2;
        }
        try {
            java.lang.String a2 = bdVar.a();
            if (b("008Xdieidkfhfgdiejhb").equals(a2)) {
                str = m;
            } else if (b("006<digbdidiejhb").equals(a2)) {
                str = p;
            } else if (b("007>gbffehebdhdghb").equals(a2)) {
                str = q;
            } else if (b("007)gbffehfkdfdiei").equals(a2)) {
                str = n;
            } else {
                if (!b("009+difgfjfifgfhdhekhj").equals(a2)) {
                    return str2;
                }
                str = o;
            }
            return str;
        } catch (java.lang.Throwable th) {
            cn.fly.verify.ed.a().a(th);
            return str2;
        }
    }

    public static void a(android.content.Context context) {
        try {
            if (k.compareAndSet(false, true)) {
                try {
                    if (a == null) {
                        java.lang.String str = (java.lang.String) cn.fly.verify.bc.a(null, b("013bIcfeg(hCdccegjdkHii+hbWe*cj"), java.lang.String.class, null);
                        if (android.text.TextUtils.isEmpty(str)) {
                            str = cn.fly.verify.bl.a().n();
                            if (android.text.TextUtils.isEmpty(str)) {
                                str = cn.fly.verify.dy.i();
                            }
                            if (!android.text.TextUtils.isEmpty(str)) {
                                c = str;
                            }
                        } else {
                            a = str;
                            c = str;
                        }
                        cn.fly.verify.bl.a().d(str);
                    }
                    if (b == null) {
                        java.lang.String str2 = (java.lang.String) cn.fly.verify.bc.a(null, b("016b3cfegYhEdccegjdk?iiOdi1eb*ci5eh"), java.lang.String.class, null);
                        if (android.text.TextUtils.isEmpty(str2)) {
                            str2 = (java.lang.String) cn.fly.verify.bc.a(null, b("012*gbdcedgjdk(ii9diNe=ciPeh"), java.lang.String.class, null);
                        }
                        if (android.text.TextUtils.isEmpty(str2)) {
                            java.lang.String o2 = cn.fly.verify.bl.a().o();
                            if (!android.text.TextUtils.isEmpty(o2)) {
                                d = o2;
                            }
                        } else {
                            b = str2;
                            d = str2;
                            cn.fly.verify.bl.a().e(str2);
                        }
                    }
                } catch (java.lang.Throwable unused) {
                }
                try {
                    java.lang.String str3 = (java.lang.String) cn.fly.verify.bc.a(null, b("006LejdcceJc]chVd"), java.lang.String.class, null);
                    if (str3 != null) {
                        e = cn.fly.verify.bb.a(str3);
                    }
                } catch (java.lang.Throwable unused2) {
                    e = cn.fly.verify.bb.DEFAULT;
                }
                j = (java.lang.String) cn.fly.verify.bc.a(null, b("015$gbdcedgjffcbfichccdcdkXii!dhcb"), java.lang.String.class, null);
                f = true;
                java.lang.String b2 = b("006)gbdcedgjfigg");
                java.lang.Class cls = java.lang.Boolean.TYPE;
                java.lang.Boolean bool = java.lang.Boolean.FALSE;
                g = ((java.lang.Boolean) cn.fly.verify.bc.a(null, b2, cls, bool)).booleanValue();
                h = ((java.lang.Boolean) cn.fly.verify.bc.a(null, b("008ZgbdcedgjDef_dcdd"), cls, java.lang.Boolean.TRUE)).booleanValue();
                i = ((java.lang.Boolean) cn.fly.verify.bc.a(null, b("007Ygbdcedgjhcfkfk"), cls, bool)).booleanValue();
            }
        } catch (java.lang.Throwable th) {
            cn.fly.verify.ed.a().a(th);
        }
    }

    public static java.lang.String b(java.lang.String str) {
        return cn.fly.verify.dw.a(str, 98);
    }
}
