package com.baidu.mobads.sdk.internal;

/* loaded from: classes.dex */
public class ay {
    public static final java.lang.String a = "bqt_ad_tag";
    static volatile com.baidu.mobads.sdk.internal.ay.a[] b;
    private static final com.baidu.mobads.sdk.internal.ay.a[] c;
    private static final java.util.Map<java.lang.String, com.baidu.mobads.sdk.internal.ay.a> d = new java.util.HashMap();
    private static final com.baidu.mobads.sdk.internal.ay.a e = new com.baidu.mobads.sdk.internal.az();

    public static abstract class a {
        private final java.lang.ThreadLocal<java.lang.String> a = new java.lang.ThreadLocal<>();

        private void b(int i, java.lang.Throwable th, java.lang.String str) {
            java.lang.String b = b();
            if (a(b, i)) {
                if (str != null && str.length() == 0) {
                    str = null;
                }
                if (str == null) {
                    if (th == null) {
                        return;
                    } else {
                        str = g(th);
                    }
                } else if (th != null) {
                    str = str + "\n" + g(th);
                }
                a(i, b, str, th);
            }
        }

        private java.lang.String g(java.lang.Throwable th) {
            java.io.StringWriter stringWriter = new java.io.StringWriter(256);
            java.io.PrintWriter printWriter = new java.io.PrintWriter((java.io.Writer) stringWriter, false);
            th.printStackTrace(printWriter);
            printWriter.flush();
            return stringWriter.toString();
        }

        private java.lang.String g(java.lang.Object[] objArr) {
            java.lang.StringBuilder sb = new java.lang.StringBuilder();
            for (java.lang.Object obj : objArr) {
                sb.append(obj);
                sb.append(' ');
            }
            return sb.toString();
        }

        @androidx.annotation.NonNull
        public abstract java.lang.String a();

        public java.lang.String a(java.lang.String str, java.lang.Object[] objArr) {
            return java.lang.String.format(str, objArr);
        }

        public void a(int i, java.lang.String str) {
            b(i, null, str);
        }

        public abstract void a(int i, java.lang.String str, java.lang.String str2, java.lang.Throwable th);

        public void a(int i, java.lang.Throwable th) {
            b(i, th, null);
        }

        public void a(int i, java.lang.Throwable th, java.lang.String str) {
            b(i, th, str);
        }

        public void a(int i, java.lang.Object... objArr) {
            b(i, null, g(objArr));
        }

        public void a(java.lang.Object obj) {
            b(3, null, b(obj));
        }

        public void a(java.lang.String str) {
            if (android.text.TextUtils.isEmpty(str)) {
                c("Empty/Null json content");
                return;
            }
            try {
                java.lang.String trim = str.trim();
                if (trim.startsWith("{")) {
                    b(3, null, new org.json.JSONObject(trim).toString(2));
                } else if (trim.startsWith("[")) {
                    b(3, null, new org.json.JSONArray(trim).toString(2));
                } else {
                    f("Invalid Json");
                }
            } catch (java.lang.Exception unused) {
                f("Invalid Json");
            }
        }

        public void a(java.lang.Throwable th) {
            b(2, th, null);
        }

        public void a(java.lang.Throwable th, java.lang.String str) {
            b(2, th, str);
        }

        public void a(java.lang.Object... objArr) {
            b(2, null, g(objArr));
        }

        public boolean a(int i) {
            return true;
        }

        public boolean a(java.lang.String str, int i) {
            return a(i);
        }

        public java.lang.String b() {
            java.lang.String str = this.a.get();
            if (str != null) {
                this.a.remove();
            }
            return str;
        }

        public java.lang.String b(java.lang.Object obj) {
            return obj == null ? com.igexin.push.core.b.m : !obj.getClass().isArray() ? obj.toString() : obj instanceof boolean[] ? java.util.Arrays.toString((boolean[]) obj) : obj instanceof byte[] ? java.util.Arrays.toString((byte[]) obj) : obj instanceof char[] ? java.util.Arrays.toString((char[]) obj) : obj instanceof short[] ? java.util.Arrays.toString((short[]) obj) : obj instanceof int[] ? java.util.Arrays.toString((int[]) obj) : obj instanceof long[] ? java.util.Arrays.toString((long[]) obj) : obj instanceof float[] ? java.util.Arrays.toString((float[]) obj) : obj instanceof double[] ? java.util.Arrays.toString((double[]) obj) : obj instanceof java.lang.Object[] ? java.util.Arrays.deepToString((java.lang.Object[]) obj) : "Couldn't find a correct type for the object";
        }

        public void b(java.lang.String str) {
            b(2, null, str);
        }

        public void b(java.lang.Throwable th) {
            b(3, th, null);
        }

        public void b(java.lang.Throwable th, java.lang.String str) {
            b(3, th, str);
        }

        public void b(java.lang.Object... objArr) {
            b(3, null, g(objArr));
        }

        public void c(java.lang.String str) {
            b(3, null, str);
        }

        public void c(java.lang.Throwable th) {
            b(4, th, null);
        }

        public void c(java.lang.Throwable th, java.lang.String str) {
            b(4, th, str);
        }

        public void c(java.lang.Object... objArr) {
            b(4, null, g(objArr));
        }

        public void d(java.lang.String str) {
            b(4, null, str);
        }

        public void d(java.lang.Throwable th) {
            b(5, th, null);
        }

        public void d(java.lang.Throwable th, java.lang.String str) {
            b(5, th, str);
        }

        public void d(java.lang.Object... objArr) {
            b(5, null, g(objArr));
        }

        public void e(java.lang.String str) {
            b(5, null, str);
        }

        public void e(java.lang.Throwable th) {
            b(6, th, null);
        }

        public void e(java.lang.Throwable th, java.lang.String str) {
            b(6, th, str);
        }

        public void e(java.lang.Object... objArr) {
            b(6, null, g(objArr));
        }

        public void f(java.lang.String str) {
            b(6, null, str);
        }

        public void f(java.lang.Throwable th) {
            b(7, th, null);
        }

        public void f(java.lang.Throwable th, java.lang.String str) {
            b(7, th, str);
        }

        public void f(java.lang.Object... objArr) {
            b(7, null, g(objArr));
        }

        public void g(java.lang.String str) {
            b(7, null, str);
        }
    }

    static {
        com.baidu.mobads.sdk.internal.ay.a[] aVarArr = new com.baidu.mobads.sdk.internal.ay.a[0];
        c = aVarArr;
        b = aVarArr;
    }

    public static void a() {
        try {
            i("local");
            i("debug");
        } catch (java.lang.Throwable unused) {
        }
    }

    public static void a(int i, java.lang.String str) {
        e.a(i, str);
    }

    public static void a(int i, java.lang.Throwable th) {
        e.a(i, th);
    }

    public static void a(int i, java.lang.Throwable th, java.lang.String str) {
        e.a(i, th, str);
    }

    public static void a(int i, java.lang.Object... objArr) {
        e.a(i, objArr);
    }

    public static void a(com.baidu.mobads.sdk.internal.ay.a aVar) {
        if (aVar == null || aVar == e) {
            return;
        }
        java.util.Map<java.lang.String, com.baidu.mobads.sdk.internal.ay.a> map = d;
        synchronized (map) {
            map.put(aVar.a(), aVar);
            b = (com.baidu.mobads.sdk.internal.ay.a[]) map.values().toArray(new com.baidu.mobads.sdk.internal.ay.a[0]);
        }
    }

    public static void a(java.lang.Object obj) {
        e.a(obj);
    }

    public static void a(java.lang.String str) {
        e.a(str);
    }

    public static void a(java.lang.Throwable th) {
        e.a(th);
    }

    public static void a(java.lang.Throwable th, java.lang.String str) {
        e.a(th, str);
    }

    public static void a(boolean z) {
        try {
            a();
            if (com.baidu.mobads.sdk.internal.cl.a) {
                a((com.baidu.mobads.sdk.internal.ay.a) new com.baidu.mobads.sdk.internal.aw());
            } else if (z) {
                a((com.baidu.mobads.sdk.internal.ay.a) new com.baidu.mobads.sdk.internal.av());
            }
        } catch (java.lang.Throwable unused) {
        }
    }

    public static void a(java.lang.Object... objArr) {
        e.a(objArr);
    }

    public static com.baidu.mobads.sdk.internal.ay.a b() {
        return e;
    }

    public static void b(com.baidu.mobads.sdk.internal.ay.a aVar) {
        i(aVar.a());
    }

    public static void b(java.lang.String str) {
        e.b(str);
    }

    public static void b(java.lang.Throwable th) {
        e.b(th);
    }

    public static void b(java.lang.Throwable th, java.lang.String str) {
        e.b(th, str);
    }

    public static void b(java.lang.Object... objArr) {
        e.b(objArr);
    }

    public static com.baidu.mobads.sdk.internal.ay.a c() {
        for (com.baidu.mobads.sdk.internal.ay.a aVar : b) {
            aVar.a.set(a);
        }
        return e;
    }

    public static void c(java.lang.String str) {
        e.c(str);
    }

    public static void c(java.lang.Throwable th) {
        e.c(th);
    }

    public static void c(java.lang.Throwable th, java.lang.String str) {
        e.c(th, str);
    }

    public static void c(java.lang.Object... objArr) {
        e.c(objArr);
    }

    public static void d() {
        java.util.Map<java.lang.String, com.baidu.mobads.sdk.internal.ay.a> map = d;
        synchronized (map) {
            map.clear();
            b = c;
        }
    }

    public static void d(java.lang.String str) {
        e.d(str);
    }

    public static void d(java.lang.Throwable th) {
        e.d(th);
    }

    public static void d(java.lang.Throwable th, java.lang.String str) {
        e.d(th, str);
    }

    public static void d(java.lang.Object... objArr) {
        e.d(objArr);
    }

    public static java.util.List<com.baidu.mobads.sdk.internal.ay.a> e() {
        java.util.List<com.baidu.mobads.sdk.internal.ay.a> unmodifiableList;
        java.util.Map<java.lang.String, com.baidu.mobads.sdk.internal.ay.a> map = d;
        synchronized (map) {
            unmodifiableList = java.util.Collections.unmodifiableList(new java.util.ArrayList(map.values()));
        }
        return unmodifiableList;
    }

    public static void e(java.lang.String str) {
        e.e(str);
    }

    public static void e(java.lang.Throwable th) {
        e.e(th);
    }

    public static void e(java.lang.Throwable th, java.lang.String str) {
        e.e(th, str);
    }

    public static void e(java.lang.Object... objArr) {
        e.e(objArr);
    }

    public static int f() {
        int size;
        java.util.Map<java.lang.String, com.baidu.mobads.sdk.internal.ay.a> map = d;
        synchronized (map) {
            size = map.size();
        }
        return size;
    }

    public static void f(java.lang.String str) {
        e.f(str);
    }

    public static void f(java.lang.Throwable th) {
        e.f(th);
    }

    public static void f(java.lang.Throwable th, java.lang.String str) {
        e.f(th, str);
    }

    public static void f(java.lang.Object... objArr) {
        e.f(objArr);
    }

    public static void g(java.lang.String str) {
        e.g(str);
    }

    public static com.baidu.mobads.sdk.internal.ay.a h(java.lang.String str) {
        for (com.baidu.mobads.sdk.internal.ay.a aVar : b) {
            aVar.a.set(str);
        }
        return e;
    }

    public static void i(java.lang.String str) {
        java.util.Map<java.lang.String, com.baidu.mobads.sdk.internal.ay.a> map = d;
        synchronized (map) {
            if (map.remove(str) == null) {
                return;
            }
            b = (com.baidu.mobads.sdk.internal.ay.a[]) map.values().toArray(new com.baidu.mobads.sdk.internal.ay.a[0]);
        }
    }
}
