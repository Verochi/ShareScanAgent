package com.aliyun.svideosdk.conan;

/* loaded from: classes12.dex */
public class b implements java.io.Serializable {
    static final int[] u = {32, 544, 32, 32, 32, 32, 32, 32, 32, 8224, 32, 8224, 32, 8224, 8224, 32, 32, 32, 32, 8224, 32, 8224, 32};
    static final int[] v = {com.anythink.expressad.foundation.g.a.aW, 8224, 8224, 8224, 8224, 8224, 8224, 8224};
    private java.lang.String a;
    private java.lang.reflect.Method b;
    private long c;
    private long d;
    private long e;
    private long f;
    private long g;
    private long h;
    private int i;
    private int j;
    private long k;
    private long l;
    private long m;
    private long n;
    private int o;
    private int p;
    private int q;
    private int r;

    /* renamed from: s, reason: collision with root package name */
    private final long[] f93s = new long[7];
    private final long[] t = new long[6];

    public b() {
        try {
            this.a = "/proc/" + android.os.Process.myPid() + "/stat";
            java.lang.reflect.Method method = android.os.Process.class.getMethod("readProcFile", java.lang.String.class, int[].class, java.lang.String[].class, long[].class, float[].class);
            this.b = method;
            method.setAccessible(true);
        } catch (java.lang.Exception unused) {
        }
    }

    public int a() {
        return this.r;
    }

    /* JADX WARN: Can't wrap try/catch for region: R(13:13|14|(3:69|70|(10:72|17|18|(3:20|21|(2:23|(2:25|(2:27|(2:29|(6:31|(4:33|(1:35)|36|(1:38))|41|42|43|(1:60)(3:47|48|(5:50|(1:52)|53|54|55)(1:57))))))))|65|66|67|42|43|(2:45|60)(1:61)))|16|17|18|(0)|65|66|67|42|43|(0)(0)) */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0093  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x013f  */
    /* JADX WARN: Removed duplicated region for block: B:61:? A[ADDED_TO_REGION, RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void a(android.content.Context context) {
        int i;
        android.os.CpuUsageInfo[] cpuUsages;
        long active;
        long j;
        long j2;
        long j3;
        long j4;
        long j5;
        long j6;
        java.lang.reflect.Method method = this.b;
        if (method != null && this.a != null) {
            try {
            } catch (java.lang.Exception unused) {
                i = 0;
            }
            if (!((java.lang.Boolean) method.invoke(null, "/proc/stat", v, null, this.f93s, null)).booleanValue()) {
                return;
            }
            if (((java.lang.Boolean) this.b.invoke(null, this.a, u, null, this.t, null)).booleanValue()) {
                long[] jArr = this.t;
                long j7 = jArr[2];
                this.m = j7;
                long j8 = jArr[3];
                this.n = j8;
                long j9 = this.k;
                if (j7 >= j9) {
                    try {
                        j = this.l;
                    } catch (java.lang.Exception unused2) {
                    }
                    if (j8 >= j) {
                        this.o = (int) (j7 - j9);
                        this.p = (int) (j8 - j);
                        long[] jArr2 = this.f93s;
                        j2 = jArr2[0] + jArr2[1];
                        long j10 = jArr2[2];
                        long j11 = jArr2[3];
                        long j12 = jArr2[4];
                        long j13 = jArr2[5];
                        long j14 = jArr2[6];
                        j3 = this.c;
                        if (j2 >= j3) {
                            long j15 = this.d;
                            if (j10 >= j15) {
                                long j16 = this.e;
                                if (j12 >= j16) {
                                    long j17 = this.f;
                                    if (j13 >= j17) {
                                        long j18 = this.g;
                                        if (j14 >= j18) {
                                            long j19 = this.h;
                                            if (j11 >= j19) {
                                                int i2 = (int) (j2 - j3);
                                                this.i = i2;
                                                j5 = j2;
                                                int i3 = (int) (j10 - j15);
                                                this.j = i3;
                                                j6 = j12;
                                                j4 = j14;
                                                long j20 = i2 + i3 + ((int) (j12 - j16)) + ((int) (j13 - j17)) + ((int) (j14 - j18)) + ((int) (j11 - j19));
                                                if (j20 > 1) {
                                                    int abs = java.lang.Math.abs((int) (((this.o + this.p) * 100) / j20));
                                                    int abs2 = java.lang.Math.abs((int) (((this.i + this.j) * 100) / j20));
                                                    this.q = abs2;
                                                    this.r = abs;
                                                    if (abs2 > 100) {
                                                        this.q = 100;
                                                    }
                                                    int i4 = this.q;
                                                    if (abs > i4) {
                                                        this.r = i4;
                                                    }
                                                }
                                                i = 0;
                                                this.k = this.m;
                                                this.l = this.n;
                                                this.c = j5;
                                                this.d = j10;
                                                this.e = j6;
                                                this.f = j13;
                                                this.g = j4;
                                                this.h = j11;
                                                if (android.os.Build.VERSION.SDK_INT < 24 || context == null) {
                                                    return;
                                                }
                                                try {
                                                    android.os.HardwarePropertiesManager hardwarePropertiesManager = (android.os.HardwarePropertiesManager) context.getSystemService("hardware_properties");
                                                    if (hardwarePropertiesManager != null) {
                                                        cpuUsages = hardwarePropertiesManager.getCpuUsages();
                                                        int length = cpuUsages.length;
                                                        int i5 = 0;
                                                        while (i < length) {
                                                            long j21 = i5;
                                                            active = cpuUsages[i].getActive();
                                                            i5 = (int) (j21 + active);
                                                            i++;
                                                        }
                                                        this.r = i5;
                                                        return;
                                                    }
                                                    return;
                                                } catch (java.lang.Exception unused3) {
                                                    return;
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                        j4 = j14;
                        j5 = j2;
                        j6 = j12;
                        i = 0;
                        this.i = 0;
                        this.j = 0;
                        this.k = this.m;
                        this.l = this.n;
                        this.c = j5;
                        this.d = j10;
                        this.e = j6;
                        this.f = j13;
                        this.g = j4;
                        this.h = j11;
                        if (android.os.Build.VERSION.SDK_INT < 24) {
                            return;
                        } else {
                            return;
                        }
                    }
                }
                this.o = 0;
                this.p = 0;
                long[] jArr22 = this.f93s;
                j2 = jArr22[0] + jArr22[1];
                long j102 = jArr22[2];
                long j112 = jArr22[3];
                long j122 = jArr22[4];
                long j132 = jArr22[5];
                long j142 = jArr22[6];
                j3 = this.c;
                if (j2 >= j3) {
                }
                j4 = j142;
                j5 = j2;
                j6 = j122;
                i = 0;
                this.i = 0;
                this.j = 0;
                this.k = this.m;
                this.l = this.n;
                this.c = j5;
                this.d = j102;
                this.e = j6;
                this.f = j132;
                this.g = j4;
                this.h = j112;
                if (android.os.Build.VERSION.SDK_INT < 24) {
                }
            }
        }
        i = 0;
        if (android.os.Build.VERSION.SDK_INT < 24) {
        }
    }
}
