package cn.fly.verify;

/* loaded from: classes.dex */
public class l {
    private static android.util.SparseArray<cn.fly.verify.l> h;
    private static android.util.SparseArray<cn.fly.verify.l> i;
    private static boolean j;
    private static volatile long k;
    private static java.lang.Object l = new java.lang.Object();
    public int a;
    public java.lang.String b;
    public java.lang.String c;
    public boolean d;
    private int e;
    private java.lang.Integer f;
    private java.lang.String g;

    public l(int i2, java.lang.String str, java.lang.String str2, boolean z) {
        this.a = i2;
        this.b = str;
        this.c = str2;
        this.d = z;
    }

    public l(int i2, java.lang.String str, java.lang.String str2, boolean z, int i3, java.lang.Integer num, java.lang.String str3) {
        this.a = i2;
        this.b = str;
        this.c = str2;
        this.d = z;
        this.e = i3;
        this.f = num;
        this.g = str3;
    }

    public static android.util.SparseArray<cn.fly.verify.l> a() {
        android.util.SparseArray<cn.fly.verify.l> sparseArray;
        synchronized (l) {
            if (java.lang.System.currentTimeMillis() > k) {
                if (k > 0) {
                    cn.fly.verify.f.a().b("[FlyVerify] ==>%s", "memory config expire");
                }
                h = null;
            }
            sparseArray = h;
        }
        return sparseArray;
    }

    public static void a(android.util.SparseArray<cn.fly.verify.l> sparseArray) {
        i = sparseArray;
    }

    public static void a(android.util.SparseArray<cn.fly.verify.l> sparseArray, boolean z) {
        synchronized (l) {
            j = z;
            k = java.lang.System.currentTimeMillis() + 600000;
            h = sparseArray;
        }
    }

    public static boolean b() {
        boolean z;
        synchronized (l) {
            z = j;
        }
        return z;
    }

    public static android.util.SparseArray<cn.fly.verify.l> c() {
        return i;
    }

    public void a(java.lang.Integer num) {
        this.f = num;
    }

    public void a(java.lang.String str) {
        this.g = str;
    }

    public int d() {
        return this.e;
    }

    public java.lang.Integer e() {
        return this.f;
    }

    public java.lang.String f() {
        return this.g;
    }
}
