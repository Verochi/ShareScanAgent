package com.uc.crashsdk;

/* loaded from: classes19.dex */
public class a {
    public static java.lang.String a = "";
    public static java.lang.String b = "";
    static final /* synthetic */ boolean d = true;
    private static final java.util.Map<java.lang.String, java.lang.String> e = new java.util.HashMap();
    private static final java.util.List<java.lang.String> f = new java.util.ArrayList();
    private static java.lang.String g = "";
    private static java.lang.String h = null;
    private static int i = -1;
    private static long j = 0;
    private static final java.util.HashMap<java.lang.String, java.lang.Object[]> k = new java.util.HashMap<>();
    private static final java.util.List<java.lang.String> l = new java.util.ArrayList();
    private static int m = 0;
    private static int n = 0;
    private static int o = 0;
    private static int p = 0;
    private static final java.util.HashMap<java.lang.String, java.lang.Object[]> q = new java.util.HashMap<>();
    private static final java.util.List<java.lang.String> r = new java.util.ArrayList();

    /* renamed from: s, reason: collision with root package name */
    private static int f439s = 0;
    private static int t = 0;
    private static int u = 0;
    private static int v = 0;
    private static int w = 0;
    private static int x = 0;
    private static final android.util.SparseArray<java.lang.Object[]> y = new android.util.SparseArray<>();
    private static final java.util.List<java.lang.Integer> z = new java.util.ArrayList();
    private static final java.util.HashMap<java.lang.String, java.lang.Object[]> A = new java.util.HashMap<>();
    private static final java.util.List<java.lang.String> B = new java.util.ArrayList();
    private static int C = 0;
    private static int D = 0;
    private static int E = 0;
    static boolean c = false;
    private static java.lang.Runnable F = new com.uc.crashsdk.a.e(201);
    private static boolean G = false;
    private static boolean H = false;
    private static boolean I = false;

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:11:0x0047  */
    /* JADX WARN: Removed duplicated region for block: B:14:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r0v12 */
    /* JADX WARN: Type inference failed for: r0v13 */
    /* JADX WARN: Type inference failed for: r0v7, types: [int] */
    /* JADX WARN: Type inference failed for: r0v9 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static int a(int i2, java.lang.String str) {
        ?? r0;
        if (com.uc.crashsdk.a.g.a(str)) {
            str = java.lang.Thread.currentThread().getName();
        }
        if (com.uc.crashsdk.export.LogType.isForNative(i2) || com.uc.crashsdk.export.LogType.isForANR(i2)) {
            if (com.uc.crashsdk.b.d) {
                synchronized (y) {
                    com.uc.crashsdk.JNIBridge.nativeCmd(4, i2, str, null);
                }
                boolean isForNative = com.uc.crashsdk.export.LogType.isForNative(i2);
                r0 = isForNative;
                if (com.uc.crashsdk.export.LogType.isForANR(i2)) {
                    r0 = (isForNative ? 1 : 0) | 1048576;
                }
                if (com.uc.crashsdk.export.LogType.isForJava(i2)) {
                    return r0;
                }
                a(str, java.lang.Thread.currentThread());
                return r0 | 16;
            }
            com.uc.crashsdk.a.a.a("crashsdk", "crashsdk so has not loaded!", null);
        }
        r0 = 0;
        if (com.uc.crashsdk.export.LogType.isForJava(i2)) {
        }
    }

    public static int a(java.lang.String str, int i2, int i3) {
        int i4;
        int i5;
        boolean z2;
        if (str == null || i2 <= 0) {
            return 0;
        }
        if (i2 > 1500) {
            com.uc.crashsdk.a.a.a("crashsdk", "createCachedInfo: capacity is too large!", null);
            return 0;
        }
        java.util.HashMap<java.lang.String, java.lang.Object[]> hashMap = A;
        synchronized (hashMap) {
            if (hashMap.containsKey(str)) {
                i5 = ((java.lang.Integer) hashMap.get(str)[1]).intValue();
                i4 = com.uc.crashsdk.export.LogType.addType(i5, i3);
            } else {
                i4 = i3;
                i5 = 0;
            }
            if (com.uc.crashsdk.export.LogType.isForJava(i4) && !com.uc.crashsdk.export.LogType.isForJava(i5)) {
                int i6 = C;
                if (i6 >= 8) {
                    i4 = com.uc.crashsdk.export.LogType.removeType(i4, 16);
                } else {
                    C = i6 + 1;
                }
            }
            if (com.uc.crashsdk.export.LogType.isForNative(i4) && !com.uc.crashsdk.export.LogType.isForNative(i5)) {
                int i7 = D;
                if (i7 >= 8) {
                    i4 = com.uc.crashsdk.export.LogType.removeType(i4, 1);
                } else {
                    D = i7 + 1;
                }
            }
            if (com.uc.crashsdk.export.LogType.isForANR(i4) && !com.uc.crashsdk.export.LogType.isForANR(i5)) {
                int i8 = E;
                if (i8 >= 8) {
                    i4 = com.uc.crashsdk.export.LogType.removeType(i4, 1048576);
                } else {
                    E = i8 + 1;
                }
            }
            if ((1048849 & i4) == 0) {
                z2 = false;
            } else {
                if (i5 == 0) {
                    B.add(str);
                }
                z2 = true;
            }
            if (!z2) {
                return i4;
            }
            if (com.uc.crashsdk.b.d && (i3 & 1048577) != 0) {
                int nativeCreateCachedInfo = com.uc.crashsdk.JNIBridge.nativeCreateCachedInfo(str, i2, i4);
                if (!com.uc.crashsdk.export.LogType.isForNative(nativeCreateCachedInfo)) {
                    i4 = com.uc.crashsdk.export.LogType.removeType(i4, 1);
                }
                if (!com.uc.crashsdk.export.LogType.isForANR(nativeCreateCachedInfo)) {
                    i4 = com.uc.crashsdk.export.LogType.removeType(i4, 1048576);
                }
            }
            hashMap.put(str, new java.lang.Object[]{java.lang.Integer.valueOf(i2), java.lang.Integer.valueOf(i4), new java.util.ArrayList()});
            return i4;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x005d A[Catch: all -> 0x015a, TryCatch #0 {, blocks: (B:8:0x000d, B:10:0x0013, B:12:0x0027, B:14:0x002b, B:16:0x0035, B:18:0x003b, B:22:0x005d, B:25:0x0047, B:28:0x004c, B:29:0x0057, B:30:0x0050, B:33:0x0063, B:35:0x006a, B:37:0x0070, B:42:0x009a, B:43:0x00a1, B:45:0x00a9, B:47:0x00af, B:49:0x00b3, B:50:0x00b8, B:51:0x00be, B:53:0x00c6, B:55:0x00cc, B:57:0x00d0, B:58:0x00d5, B:59:0x00db, B:63:0x00ed, B:65:0x00ef, B:67:0x00f3, B:69:0x00f9, B:71:0x0105, B:73:0x010b, B:75:0x0112, B:76:0x0117, B:78:0x011d, B:80:0x0123, B:81:0x0128, B:83:0x012e, B:85:0x0134, B:86:0x013c, B:87:0x0158, B:91:0x00e5, B:97:0x007c, B:100:0x0081, B:101:0x008b, B:104:0x0092), top: B:7:0x000d }] */
    /* JADX WARN: Removed duplicated region for block: B:42:0x009a A[Catch: all -> 0x015a, TryCatch #0 {, blocks: (B:8:0x000d, B:10:0x0013, B:12:0x0027, B:14:0x002b, B:16:0x0035, B:18:0x003b, B:22:0x005d, B:25:0x0047, B:28:0x004c, B:29:0x0057, B:30:0x0050, B:33:0x0063, B:35:0x006a, B:37:0x0070, B:42:0x009a, B:43:0x00a1, B:45:0x00a9, B:47:0x00af, B:49:0x00b3, B:50:0x00b8, B:51:0x00be, B:53:0x00c6, B:55:0x00cc, B:57:0x00d0, B:58:0x00d5, B:59:0x00db, B:63:0x00ed, B:65:0x00ef, B:67:0x00f3, B:69:0x00f9, B:71:0x0105, B:73:0x010b, B:75:0x0112, B:76:0x0117, B:78:0x011d, B:80:0x0123, B:81:0x0128, B:83:0x012e, B:85:0x0134, B:86:0x013c, B:87:0x0158, B:91:0x00e5, B:97:0x007c, B:100:0x0081, B:101:0x008b, B:104:0x0092), top: B:7:0x000d }] */
    /* JADX WARN: Removed duplicated region for block: B:57:0x00d0 A[Catch: all -> 0x015a, TryCatch #0 {, blocks: (B:8:0x000d, B:10:0x0013, B:12:0x0027, B:14:0x002b, B:16:0x0035, B:18:0x003b, B:22:0x005d, B:25:0x0047, B:28:0x004c, B:29:0x0057, B:30:0x0050, B:33:0x0063, B:35:0x006a, B:37:0x0070, B:42:0x009a, B:43:0x00a1, B:45:0x00a9, B:47:0x00af, B:49:0x00b3, B:50:0x00b8, B:51:0x00be, B:53:0x00c6, B:55:0x00cc, B:57:0x00d0, B:58:0x00d5, B:59:0x00db, B:63:0x00ed, B:65:0x00ef, B:67:0x00f3, B:69:0x00f9, B:71:0x0105, B:73:0x010b, B:75:0x0112, B:76:0x0117, B:78:0x011d, B:80:0x0123, B:81:0x0128, B:83:0x012e, B:85:0x0134, B:86:0x013c, B:87:0x0158, B:91:0x00e5, B:97:0x007c, B:100:0x0081, B:101:0x008b, B:104:0x0092), top: B:7:0x000d }] */
    /* JADX WARN: Removed duplicated region for block: B:58:0x00d5 A[Catch: all -> 0x015a, TryCatch #0 {, blocks: (B:8:0x000d, B:10:0x0013, B:12:0x0027, B:14:0x002b, B:16:0x0035, B:18:0x003b, B:22:0x005d, B:25:0x0047, B:28:0x004c, B:29:0x0057, B:30:0x0050, B:33:0x0063, B:35:0x006a, B:37:0x0070, B:42:0x009a, B:43:0x00a1, B:45:0x00a9, B:47:0x00af, B:49:0x00b3, B:50:0x00b8, B:51:0x00be, B:53:0x00c6, B:55:0x00cc, B:57:0x00d0, B:58:0x00d5, B:59:0x00db, B:63:0x00ed, B:65:0x00ef, B:67:0x00f3, B:69:0x00f9, B:71:0x0105, B:73:0x010b, B:75:0x0112, B:76:0x0117, B:78:0x011d, B:80:0x0123, B:81:0x0128, B:83:0x012e, B:85:0x0134, B:86:0x013c, B:87:0x0158, B:91:0x00e5, B:97:0x007c, B:100:0x0081, B:101:0x008b, B:104:0x0092), top: B:7:0x000d }] */
    /* JADX WARN: Removed duplicated region for block: B:61:0x00e1  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x00ed A[Catch: all -> 0x015a, DONT_GENERATE, TryCatch #0 {, blocks: (B:8:0x000d, B:10:0x0013, B:12:0x0027, B:14:0x002b, B:16:0x0035, B:18:0x003b, B:22:0x005d, B:25:0x0047, B:28:0x004c, B:29:0x0057, B:30:0x0050, B:33:0x0063, B:35:0x006a, B:37:0x0070, B:42:0x009a, B:43:0x00a1, B:45:0x00a9, B:47:0x00af, B:49:0x00b3, B:50:0x00b8, B:51:0x00be, B:53:0x00c6, B:55:0x00cc, B:57:0x00d0, B:58:0x00d5, B:59:0x00db, B:63:0x00ed, B:65:0x00ef, B:67:0x00f3, B:69:0x00f9, B:71:0x0105, B:73:0x010b, B:75:0x0112, B:76:0x0117, B:78:0x011d, B:80:0x0123, B:81:0x0128, B:83:0x012e, B:85:0x0134, B:86:0x013c, B:87:0x0158, B:91:0x00e5, B:97:0x007c, B:100:0x0081, B:101:0x008b, B:104:0x0092), top: B:7:0x000d }] */
    /* JADX WARN: Removed duplicated region for block: B:65:0x00ef A[Catch: all -> 0x015a, TryCatch #0 {, blocks: (B:8:0x000d, B:10:0x0013, B:12:0x0027, B:14:0x002b, B:16:0x0035, B:18:0x003b, B:22:0x005d, B:25:0x0047, B:28:0x004c, B:29:0x0057, B:30:0x0050, B:33:0x0063, B:35:0x006a, B:37:0x0070, B:42:0x009a, B:43:0x00a1, B:45:0x00a9, B:47:0x00af, B:49:0x00b3, B:50:0x00b8, B:51:0x00be, B:53:0x00c6, B:55:0x00cc, B:57:0x00d0, B:58:0x00d5, B:59:0x00db, B:63:0x00ed, B:65:0x00ef, B:67:0x00f3, B:69:0x00f9, B:71:0x0105, B:73:0x010b, B:75:0x0112, B:76:0x0117, B:78:0x011d, B:80:0x0123, B:81:0x0128, B:83:0x012e, B:85:0x0134, B:86:0x013c, B:87:0x0158, B:91:0x00e5, B:97:0x007c, B:100:0x0081, B:101:0x008b, B:104:0x0092), top: B:7:0x000d }] */
    /* JADX WARN: Removed duplicated region for block: B:90:0x00e3  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static int a(java.lang.String str, int i2, java.util.concurrent.Callable<java.lang.String> callable, long j2, int i3) {
        int i4;
        int i5;
        boolean z2;
        boolean z3;
        boolean z4;
        boolean z5;
        boolean z6;
        int i6;
        boolean z7;
        boolean z8;
        if (str == null) {
            return 0;
        }
        java.util.HashMap<java.lang.String, java.lang.Object[]> hashMap = q;
        synchronized (hashMap) {
            if (hashMap.containsKey(str)) {
                i5 = ((java.lang.Integer) hashMap.get(str)[0]).intValue();
                i4 = com.uc.crashsdk.export.LogType.addType(i5, i2);
                if (i5 == i4) {
                    return i5;
                }
            } else {
                i4 = i2;
                i5 = 0;
            }
            if (com.uc.crashsdk.export.LogType.isForJava(i4) && !com.uc.crashsdk.export.LogType.isForJava(i5)) {
                int i7 = f439s;
                if (i7 < 8) {
                    if (j2 != 0) {
                        int i8 = w;
                        if (i8 < 6) {
                            w = i8 + 1;
                            f439s = i7 + 1;
                            z8 = false;
                        }
                    } else {
                        if (i7 - w >= 6) {
                        }
                        f439s = i7 + 1;
                        z8 = false;
                    }
                    if (z8) {
                        i4 = com.uc.crashsdk.export.LogType.removeType(i4, 16);
                    }
                }
                z8 = true;
                if (z8) {
                }
            }
            if (!com.uc.crashsdk.export.LogType.isForNative(i4) || com.uc.crashsdk.export.LogType.isForNative(i5)) {
                z2 = false;
                z3 = false;
            } else {
                int i9 = t;
                if (i9 < 6) {
                    if (j2 != 0) {
                        int i10 = x;
                        if (i10 < 4) {
                            x = i10 + 1;
                            t = i9 + 1;
                            z7 = false;
                            z2 = true;
                            z3 = true;
                            if (z7) {
                                i4 = com.uc.crashsdk.export.LogType.removeType(i4, 1);
                            }
                        }
                    } else if (i9 - x < 4) {
                        t = i9 + 1;
                        z7 = false;
                        z2 = true;
                        z3 = false;
                        if (z7) {
                        }
                    }
                }
                z7 = true;
                z2 = false;
                z3 = false;
                if (z7) {
                }
            }
            if (com.uc.crashsdk.export.LogType.isForANR(i4) && !com.uc.crashsdk.export.LogType.isForANR(i5)) {
                int i11 = v;
                if (i11 >= 6) {
                    i4 = com.uc.crashsdk.export.LogType.removeType(i4, 1048576);
                } else {
                    v = i11 + 1;
                    z4 = true;
                    if (com.uc.crashsdk.export.LogType.isForUnexp(i4) && !com.uc.crashsdk.export.LogType.isForUnexp(i5)) {
                        i6 = u;
                        if (i6 >= 6) {
                            u = i6 + 1;
                            z5 = true;
                            if ((1048849 & i4) == 0) {
                                z6 = false;
                            } else {
                                if (i5 == 0) {
                                    r.add(str);
                                }
                                z6 = true;
                            }
                            if (!z6) {
                                return i4;
                            }
                            if (com.uc.crashsdk.b.d && (1048833 & i2) != 0) {
                                int nativeAddCallbackInfo = com.uc.crashsdk.JNIBridge.nativeAddCallbackInfo(str, i2, j2, i3);
                                if (!com.uc.crashsdk.export.LogType.isForNative(nativeAddCallbackInfo)) {
                                    i4 = com.uc.crashsdk.export.LogType.removeType(i4, 1);
                                    if (z2) {
                                        t--;
                                    }
                                    if (z3) {
                                        x--;
                                    }
                                }
                                if (!com.uc.crashsdk.export.LogType.isForANR(nativeAddCallbackInfo)) {
                                    i4 = com.uc.crashsdk.export.LogType.removeType(i4, 1048576);
                                    if (z4) {
                                        v--;
                                    }
                                }
                                if (!com.uc.crashsdk.export.LogType.isForUnexp(nativeAddCallbackInfo)) {
                                    i4 = com.uc.crashsdk.export.LogType.removeType(i4, 256);
                                    if (z5) {
                                        u--;
                                    }
                                }
                            }
                            hashMap.put(str, new java.lang.Object[]{java.lang.Integer.valueOf(i4), callable, java.lang.Long.valueOf(j2), java.lang.Integer.valueOf(i3)});
                            return i4;
                        }
                        i4 = com.uc.crashsdk.export.LogType.removeType(i4, 256);
                    }
                    z5 = false;
                    if ((1048849 & i4) == 0) {
                    }
                    if (!z6) {
                    }
                }
            }
            z4 = false;
            if (com.uc.crashsdk.export.LogType.isForUnexp(i4)) {
                i6 = u;
                if (i6 >= 6) {
                }
            }
            z5 = false;
            if ((1048849 & i4) == 0) {
            }
            if (!z6) {
            }
        }
    }

    public static int a(java.lang.String str, java.lang.String str2, boolean z2, boolean z3, int i2, boolean z4) {
        int i3;
        int i4;
        boolean z5;
        if (str == null || str2 == null) {
            return 0;
        }
        if (str.length() > 256) {
            com.uc.crashsdk.a.a.a("crashsdk", "addDumpFile: description is too long!", null);
            return 0;
        }
        java.util.HashMap<java.lang.String, java.lang.Object[]> hashMap = k;
        synchronized (hashMap) {
            if (hashMap.containsKey(str)) {
                i4 = ((java.lang.Integer) hashMap.get(str)[0]).intValue();
                i3 = com.uc.crashsdk.export.LogType.addType(i4, i2);
            } else {
                i3 = i2;
                i4 = 0;
            }
            if (com.uc.crashsdk.export.LogType.isForJava(i3) && !com.uc.crashsdk.export.LogType.isForJava(i4)) {
                int i5 = m;
                if (i5 >= 10) {
                    i3 = com.uc.crashsdk.export.LogType.removeType(i3, 16);
                } else {
                    m = i5 + 1;
                }
            }
            if (com.uc.crashsdk.export.LogType.isForNative(i3) && !com.uc.crashsdk.export.LogType.isForNative(i4)) {
                int i6 = n;
                if (i6 >= 10) {
                    i3 = com.uc.crashsdk.export.LogType.removeType(i3, 1);
                } else {
                    n = i6 + 1;
                }
            }
            if (com.uc.crashsdk.export.LogType.isForUnexp(i3) && !com.uc.crashsdk.export.LogType.isForUnexp(i4)) {
                int i7 = o;
                if (i7 >= 10) {
                    i3 = com.uc.crashsdk.export.LogType.removeType(i3, 256);
                } else {
                    o = i7 + 1;
                }
            }
            if (com.uc.crashsdk.export.LogType.isForANR(i3) && !com.uc.crashsdk.export.LogType.isForANR(i4)) {
                int i8 = p;
                if (i8 >= 10) {
                    i3 = com.uc.crashsdk.export.LogType.removeType(i3, 1048576);
                } else {
                    p = i8 + 1;
                }
            }
            if ((1048849 & i3) == 0) {
                z5 = false;
            } else {
                if (i4 == 0) {
                    l.add(str);
                }
                z5 = true;
            }
            if (!z5) {
                return i3;
            }
            if (com.uc.crashsdk.b.d && (1048833 & i2) != 0) {
                int nativeAddDumpFile = com.uc.crashsdk.JNIBridge.nativeAddDumpFile(str, str2, z2, z3, i2, z4);
                if (!com.uc.crashsdk.export.LogType.isForNative(nativeAddDumpFile)) {
                    i3 = com.uc.crashsdk.export.LogType.removeType(i3, 1);
                }
                if (!com.uc.crashsdk.export.LogType.isForUnexp(nativeAddDumpFile)) {
                    i3 = com.uc.crashsdk.export.LogType.removeType(i3, 256);
                }
                if (!com.uc.crashsdk.export.LogType.isForANR(nativeAddDumpFile)) {
                    i3 = com.uc.crashsdk.export.LogType.removeType(i3, 1048576);
                }
            }
            hashMap.put(str, new java.lang.Object[]{java.lang.Integer.valueOf(i3), str2, java.lang.Boolean.valueOf(z2), java.lang.Boolean.valueOf(z3), java.lang.Boolean.valueOf(z4)});
            return i3;
        }
    }

    public static java.lang.String a() {
        java.lang.String str = h;
        return str != null ? str : o() ? h : "";
    }

    public static java.lang.String a(java.lang.String str) {
        java.util.HashMap<java.lang.String, java.lang.Object[]> hashMap = k;
        synchronized (hashMap) {
            java.lang.Object[] objArr = hashMap.get(str);
            if (objArr == null) {
                return null;
            }
            int i2 = 1;
            java.lang.String str2 = (java.lang.String) objArr[1];
            boolean booleanValue = ((java.lang.Boolean) objArr[2]).booleanValue();
            boolean booleanValue2 = ((java.lang.Boolean) objArr[3]).booleanValue();
            java.util.Locale locale = java.util.Locale.US;
            java.lang.Object[] objArr2 = new java.lang.Object[4];
            objArr2[0] = str2;
            objArr2[1] = "`";
            objArr2[2] = java.lang.Integer.valueOf(booleanValue ? 1 : 0);
            if (!booleanValue2) {
                i2 = 0;
            }
            objArr2[3] = java.lang.Integer.valueOf(i2);
            return java.lang.String.format(locale, "%s%s%d%d", objArr2);
        }
    }

    public static java.lang.String a(java.lang.String str, boolean z2) {
        java.lang.String nativeGetCallbackInfo;
        java.util.HashMap<java.lang.String, java.lang.Object[]> hashMap = q;
        synchronized (hashMap) {
            java.lang.Object[] objArr = hashMap.get(str);
            long longValue = ((java.lang.Long) objArr[2]).longValue();
            nativeGetCallbackInfo = longValue != 0 ? com.uc.crashsdk.JNIBridge.nativeGetCallbackInfo(str, longValue, ((java.lang.Integer) objArr[3]).intValue(), z2) : b(str, z2).toString();
        }
        return nativeGetCallbackInfo;
    }

    public static void a(int i2) {
        if (i2 == 201) {
            com.uc.crashsdk.a.a.a("crashsdk", "Begin update info ...");
            long currentTimeMillis = java.lang.System.currentTimeMillis();
            if (com.uc.crashsdk.b.d && c) {
                com.uc.crashsdk.JNIBridge.nativeCmd(11, com.uc.crashsdk.g.H(), java.lang.String.valueOf(com.uc.crashsdk.g.I()), null);
            }
            com.uc.crashsdk.a.a.a("crashsdk", "Update info took " + (java.lang.System.currentTimeMillis() - currentTimeMillis) + " ms");
            a(false);
            return;
        }
        if (i2 != 202) {
            if (!d) {
                throw new java.lang.AssertionError();
            }
            return;
        }
        p();
        java.util.Locale locale = java.util.Locale.US;
        java.lang.String format = java.lang.String.format(locale, "%s/%s/%s", com.uc.crashsdk.g.U(), com.uc.crashsdk.g.V(), com.uc.crashsdk.g.W());
        g = m();
        if (com.uc.crashsdk.b.d) {
            com.uc.crashsdk.JNIBridge.set(128, g);
        }
        boolean z2 = !format.equals(g);
        if (z2) {
            com.uc.crashsdk.a.b.a(com.uc.crashsdk.b.m(), format);
        }
        if (z2 && com.uc.crashsdk.g.v()) {
            com.uc.crashsdk.a.a.a("crashsdk", java.lang.String.format(locale, "Is new version ('%s' -> '%s'), deleting old stats data!", g, format));
            com.uc.crashsdk.b.v();
        }
    }

    public static void a(java.io.OutputStream outputStream, java.lang.String str) {
        synchronized (e) {
            for (java.lang.String str2 : f) {
                try {
                    java.lang.StringBuilder sb = new java.lang.StringBuilder(11);
                    sb.append(str2);
                    sb.append(": ");
                    java.lang.String str3 = e.get(str2);
                    if (str3 != null) {
                        sb.append(str3);
                    }
                    sb.append("\n");
                    outputStream.write(sb.toString().getBytes(str));
                } catch (java.lang.Throwable th) {
                    com.uc.crashsdk.e.a(th, outputStream);
                }
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:27:0x0084  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x00ca A[Catch: all -> 0x0100, TryCatch #0 {all -> 0x0100, blocks: (B:30:0x00c3, B:32:0x00ca, B:33:0x00d3, B:35:0x00d8, B:37:0x00dc, B:38:0x00e5), top: B:29:0x00c3, outer: #4 }] */
    /* JADX WARN: Removed duplicated region for block: B:35:0x00d8 A[Catch: all -> 0x0100, TryCatch #0 {all -> 0x0100, blocks: (B:30:0x00c3, B:32:0x00ca, B:33:0x00d3, B:35:0x00d8, B:37:0x00dc, B:38:0x00e5), top: B:29:0x00c3, outer: #4 }] */
    /* JADX WARN: Removed duplicated region for block: B:50:0x0087  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void a(java.io.OutputStream outputStream, java.lang.String str, java.lang.String str2) {
        java.lang.Thread thread;
        java.lang.Throwable th;
        java.lang.String str3;
        java.lang.StackTraceElement[] stackTrace;
        int length;
        int i2;
        java.lang.Object[] objArr;
        synchronized (y) {
            java.lang.Thread currentThread = java.lang.Thread.currentThread();
            java.util.Iterator<java.lang.Integer> it = z.iterator();
            while (it.hasNext()) {
                int intValue = it.next().intValue();
                try {
                    objArr = y.get(intValue);
                } catch (java.lang.Throwable th2) {
                    thread = null;
                    th = th2;
                    str3 = null;
                }
                if (objArr != null) {
                    thread = (java.lang.Thread) ((java.lang.ref.WeakReference) objArr[0]).get();
                    try {
                        str3 = (java.lang.String) objArr[1];
                    } catch (java.lang.Throwable th3) {
                        str3 = null;
                        th = th3;
                    }
                    if (thread == null) {
                        try {
                            com.uc.crashsdk.a.a.b("Thread (" + str3 + ", " + intValue + ") has exited!");
                        } catch (java.lang.Throwable th4) {
                            th = th4;
                            com.uc.crashsdk.e.a(th, outputStream);
                            try {
                                java.util.Locale locale = java.util.Locale.US;
                                outputStream.write(java.lang.String.format(locale, "Thread Name: '%s'\n", str3).getBytes(str));
                                outputStream.write(java.lang.String.format(locale, "\"%s\"%s prio=%d tid=%d %s\n", thread.getName(), !thread.isDaemon() ? " daemon" : "", java.lang.Integer.valueOf(thread.getPriority()), java.lang.Integer.valueOf(intValue), thread.getState().toString()).getBytes(str));
                            } catch (java.lang.Throwable th5) {
                                com.uc.crashsdk.e.a(th5, outputStream);
                            }
                            try {
                                stackTrace = thread.getStackTrace();
                                if (stackTrace.length == 0) {
                                }
                                length = stackTrace.length;
                                i2 = 0;
                                boolean z2 = true;
                                while (i2 < length) {
                                }
                            } catch (java.lang.Throwable th6) {
                                com.uc.crashsdk.e.a(th6, outputStream);
                            }
                            try {
                                outputStream.write("\n".getBytes(str));
                                outputStream.write(str2.getBytes(str));
                            } catch (java.lang.Throwable th7) {
                                com.uc.crashsdk.e.a(th7, outputStream);
                            }
                        }
                    } else {
                        if (currentThread == thread) {
                        }
                        java.util.Locale locale2 = java.util.Locale.US;
                        outputStream.write(java.lang.String.format(locale2, "Thread Name: '%s'\n", str3).getBytes(str));
                        outputStream.write(java.lang.String.format(locale2, "\"%s\"%s prio=%d tid=%d %s\n", thread.getName(), !thread.isDaemon() ? " daemon" : "", java.lang.Integer.valueOf(thread.getPriority()), java.lang.Integer.valueOf(intValue), thread.getState().toString()).getBytes(str));
                        stackTrace = thread.getStackTrace();
                        if (stackTrace.length == 0) {
                            outputStream.write("  (no stack frames)".getBytes(str));
                        }
                        length = stackTrace.length;
                        i2 = 0;
                        boolean z22 = true;
                        while (i2 < length) {
                            java.lang.StackTraceElement stackTraceElement = stackTrace[i2];
                            if (!z22) {
                                outputStream.write("\n".getBytes(str));
                            }
                            outputStream.write(java.lang.String.format(java.util.Locale.US, "  at %s", stackTraceElement.toString()).getBytes(str));
                            i2++;
                            z22 = false;
                        }
                        outputStream.write("\n".getBytes(str));
                        outputStream.write(str2.getBytes(str));
                    }
                }
            }
        }
    }

    /* JADX WARN: Can't wrap try/catch for region: R(11:7|(2:8|9)|(3:35|36|(4:39|40|41|17)(1:38))(3:11|12|(4:14|15|16|17)(1:18))|19|(1:21)(1:34)|(1:33)(1:25)|26|27|29|17|5) */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x00a3, code lost:
    
        r2 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x00a4, code lost:
    
        com.uc.crashsdk.e.a(r2, r10);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void a(java.io.OutputStream outputStream, java.lang.String str, java.lang.String str2, java.util.ArrayList<java.lang.String> arrayList) {
        java.lang.Object[] objArr;
        int intValue;
        synchronized (q) {
            for (java.lang.String str3 : r) {
                try {
                    objArr = q.get(str3);
                    intValue = ((java.lang.Integer) objArr[0]).intValue();
                } catch (java.lang.Throwable th) {
                    com.uc.crashsdk.e.a(th, outputStream);
                }
                if (arrayList == null) {
                    if (!com.uc.crashsdk.export.LogType.isForJava(intValue)) {
                    }
                } else if (!a(arrayList, str3)) {
                }
                outputStream.write((str3 + "\n").getBytes(str));
                long longValue = ((java.lang.Long) objArr[2]).longValue();
                java.lang.String nativeGetCallbackInfo = longValue != 0 ? com.uc.crashsdk.JNIBridge.nativeGetCallbackInfo(str3, longValue, ((java.lang.Integer) objArr[3]).intValue(), false) : b(str3, false).toString();
                if (nativeGetCallbackInfo == null || nativeGetCallbackInfo.length() <= 0) {
                    outputStream.write("(data is null)\n".getBytes(str));
                } else {
                    outputStream.write(nativeGetCallbackInfo.getBytes(str));
                }
                outputStream.write("\n".getBytes(str));
                outputStream.write(str2.getBytes(str));
            }
            if (arrayList != null && com.uc.crashsdk.e.F()) {
                java.util.Iterator<java.lang.String> it = arrayList.iterator();
                while (it.hasNext()) {
                    java.lang.String next = it.next();
                    if (!a(r, next)) {
                        com.uc.crashsdk.e.a(outputStream, "CUSTOMCALLBACKINFO", next);
                    }
                }
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:24:0x0050 A[Catch: all -> 0x00d7, TRY_LEAVE, TryCatch #2 {all -> 0x00d7, blocks: (B:12:0x0025, B:69:0x002f, B:22:0x0045, B:24:0x0050, B:15:0x003e), top: B:11:0x0025 }] */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0075  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x00ce A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:52:0x0019 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:57:0x00b0 A[Catch: all -> 0x00d3, TryCatch #0 {all -> 0x00d3, blocks: (B:33:0x007f, B:37:0x009b, B:39:0x00a3, B:57:0x00b0, B:59:0x00b5), top: B:32:0x007f }] */
    /* JADX WARN: Removed duplicated region for block: B:59:0x00b5 A[Catch: all -> 0x00d3, TRY_LEAVE, TryCatch #0 {all -> 0x00d3, blocks: (B:33:0x007f, B:37:0x009b, B:39:0x00a3, B:57:0x00b0, B:59:0x00b5), top: B:32:0x007f }] */
    /* JADX WARN: Removed duplicated region for block: B:64:0x0079  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x006e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void a(java.io.OutputStream outputStream, java.lang.String str, java.util.ArrayList<java.lang.String> arrayList) {
        int i2;
        int min;
        boolean booleanValue;
        java.lang.String str2;
        boolean booleanValue2;
        java.io.File file;
        boolean z2 = arrayList == null;
        boolean F2 = com.uc.crashsdk.e.F();
        synchronized (k) {
            int i3 = 0;
            for (java.lang.String str3 : l) {
                try {
                    java.lang.Object[] objArr = k.get(str3);
                    if (arrayList == null) {
                        if (com.uc.crashsdk.export.LogType.isForJava(((java.lang.Integer) objArr[0]).intValue())) {
                            if (!((java.lang.Boolean) objArr[3]).booleanValue()) {
                                try {
                                    outputStream.write((str3 + "\n").getBytes(str));
                                } catch (java.lang.Throwable th) {
                                    th = th;
                                    com.uc.crashsdk.e.a(th, outputStream);
                                }
                            }
                            i2 = i3 <= 153600 ? 153600 : i3;
                            try {
                                min = java.lang.Math.min(20480, 153600 - i2);
                                booleanValue = ((java.lang.Boolean) objArr[2]).booleanValue();
                                str2 = (java.lang.String) objArr[1];
                                booleanValue2 = ((java.lang.Boolean) objArr[4]).booleanValue();
                                if (F2 || str2.startsWith("/proc/")) {
                                    i2 += !booleanValue ? com.uc.crashsdk.e.a(outputStream, str2, min) : com.uc.crashsdk.e.b(outputStream, str2, min);
                                } else {
                                    com.uc.crashsdk.e.a(outputStream, "FILE", str2, min, booleanValue, booleanValue2);
                                }
                                i3 = i2;
                                if (booleanValue2 && z2 && !F2) {
                                    file = new java.io.File(str2);
                                    if (!file.exists()) {
                                        file.delete();
                                    }
                                }
                            } catch (java.lang.Throwable th2) {
                                th = th2;
                                i3 = i2;
                                com.uc.crashsdk.e.a(th, outputStream);
                            }
                        }
                    } else if (a(arrayList, str3)) {
                        if (!((java.lang.Boolean) objArr[3]).booleanValue()) {
                        }
                        if (i3 <= 153600) {
                        }
                        min = java.lang.Math.min(20480, 153600 - i2);
                        booleanValue = ((java.lang.Boolean) objArr[2]).booleanValue();
                        str2 = (java.lang.String) objArr[1];
                        booleanValue2 = ((java.lang.Boolean) objArr[4]).booleanValue();
                        if (F2) {
                        }
                        i2 += !booleanValue ? com.uc.crashsdk.e.a(outputStream, str2, min) : com.uc.crashsdk.e.b(outputStream, str2, min);
                        i3 = i2;
                        if (booleanValue2) {
                            file = new java.io.File(str2);
                            if (!file.exists()) {
                            }
                        }
                    }
                } catch (java.lang.Throwable th3) {
                    th = th3;
                }
            }
            if (arrayList != null && F2) {
                java.util.Iterator<java.lang.String> it = arrayList.iterator();
                while (it.hasNext()) {
                    java.lang.String next = it.next();
                    if (!a(l, next)) {
                        com.uc.crashsdk.e.a(outputStream, "CUSTOMDUMPFILE", next);
                    }
                }
            }
        }
    }

    public static void a(java.lang.String str, java.lang.String str2) {
        java.util.Map<java.lang.String, java.lang.String> map = e;
        synchronized (map) {
            if (!map.containsKey(str)) {
                f.add(str);
            }
            map.put(str, str2);
            if (com.uc.crashsdk.b.d) {
                com.uc.crashsdk.JNIBridge.nativeAddHeaderInfo(str, str2);
            }
            com.uc.crashsdk.e.y();
        }
    }

    private static boolean a(java.lang.String str, java.lang.Thread thread) {
        if (thread == null) {
            return false;
        }
        android.util.SparseArray<java.lang.Object[]> sparseArray = y;
        synchronized (sparseArray) {
            int id = (int) thread.getId();
            if (sparseArray.get(id) == null) {
                z.add(java.lang.Integer.valueOf(id));
            }
            sparseArray.put(id, new java.lang.Object[]{new java.lang.ref.WeakReference(thread), str});
        }
        return true;
    }

    private static boolean a(java.util.List<java.lang.String> list, java.lang.String str) {
        if (com.uc.crashsdk.a.g.a(str)) {
            return false;
        }
        java.util.Iterator<java.lang.String> it = list.iterator();
        while (it.hasNext()) {
            if (str.equals(it.next())) {
                return true;
            }
        }
        return false;
    }

    public static boolean a(boolean z2) {
        int H2;
        if (!com.uc.crashsdk.b.c) {
            com.uc.crashsdk.a.a.a("crashsdk", "Unexp log not enabled, skip update unexp info!");
            return false;
        }
        if (com.uc.crashsdk.e.F() || com.uc.crashsdk.b.L()) {
            return false;
        }
        if (z2) {
            com.uc.crashsdk.a.f.a(F);
            H2 = 0;
        } else {
            if (!com.uc.crashsdk.b.B()) {
                com.uc.crashsdk.a.a.a("crashsdk", "Stop update unexp info in background!");
                return false;
            }
            if (com.uc.crashsdk.g.H() <= 0) {
                return false;
            }
            if (com.uc.crashsdk.a.f.b(F)) {
                return true;
            }
            H2 = com.uc.crashsdk.g.H() * 1000;
        }
        com.uc.crashsdk.a.f.a(0, F, H2);
        return true;
    }

    public static int b(java.lang.String str, java.lang.String str2) {
        int i2;
        if (str == null || str2 == null) {
            return 0;
        }
        if (str2.length() > 2048) {
            str2 = str2.substring(0, 2048);
        }
        java.util.HashMap<java.lang.String, java.lang.Object[]> hashMap = A;
        synchronized (hashMap) {
            java.lang.Object[] objArr = hashMap.get(str);
            if (objArr != null) {
                int intValue = ((java.lang.Integer) objArr[0]).intValue();
                int intValue2 = ((java.lang.Integer) objArr[1]).intValue();
                java.util.List list = (java.util.List) objArr[2];
                if (list.size() >= intValue) {
                    list.remove(0);
                }
                list.add(str2);
                r0 = com.uc.crashsdk.export.LogType.isForJava(intValue2) ? com.uc.crashsdk.export.LogType.addType(0, 16) : 0;
                if (!com.uc.crashsdk.b.d) {
                    if (com.uc.crashsdk.export.LogType.isForNative(intValue2)) {
                        r0 = com.uc.crashsdk.export.LogType.addType(r0, 1);
                    }
                    if (com.uc.crashsdk.export.LogType.isForANR(intValue2)) {
                        r0 = com.uc.crashsdk.export.LogType.addType(r0, 1048576);
                    }
                }
                i2 = r0;
                r0 = intValue2;
            } else {
                i2 = 0;
            }
            if (com.uc.crashsdk.b.d && com.uc.crashsdk.JNIBridge.nativeAddCachedInfo(str, str2)) {
                if (com.uc.crashsdk.export.LogType.isForNative(r0)) {
                    i2 = com.uc.crashsdk.export.LogType.addType(i2, 1);
                }
                if (com.uc.crashsdk.export.LogType.isForANR(r0)) {
                    i2 = com.uc.crashsdk.export.LogType.addType(i2, 1048576);
                }
            }
        }
        return i2;
    }

    public static long b() {
        return j;
    }

    public static java.lang.String b(java.lang.String str) {
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        java.util.HashMap<java.lang.String, java.lang.Object[]> hashMap = A;
        synchronized (hashMap) {
            java.lang.Object[] objArr = hashMap.get(str);
            int intValue = ((java.lang.Integer) objArr[0]).intValue();
            java.util.List list = (java.util.List) objArr[2];
            sb.append(java.lang.String.format(java.util.Locale.US, "%s (%d/%d)\n", str, java.lang.Integer.valueOf(list.size()), java.lang.Integer.valueOf(intValue)));
            java.util.Iterator it = list.iterator();
            while (it.hasNext()) {
                sb.append((java.lang.String) it.next());
                sb.append("\n");
            }
        }
        return sb.toString();
    }

    private static java.lang.StringBuilder b(java.lang.String str, boolean z2) {
        java.lang.String a2;
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        try {
            java.lang.Object[] objArr = q.get(str);
            try {
                if (objArr == null) {
                    a2 = "Unknown callback: " + str;
                } else {
                    java.util.concurrent.Callable callable = (java.util.concurrent.Callable) objArr[1];
                    a2 = callable != null ? (java.lang.String) callable.call() : com.uc.crashsdk.d.a(str, z2);
                }
                if (a2 != null) {
                    sb.append(a2);
                }
            } catch (java.lang.Throwable th) {
                sb.append("[DEBUG] Callback occurred new exception:\n");
                sb.append(android.util.Log.getStackTraceString(th));
            }
        } catch (java.lang.Throwable th2) {
            com.uc.crashsdk.a.g.a(th2);
        }
        try {
            if (sb.length() == 0) {
                sb.append("(data is null)\n");
            }
        } catch (java.lang.Throwable th3) {
            com.uc.crashsdk.a.g.a(th3);
        }
        return sb;
    }

    /* JADX WARN: Can't wrap try/catch for region: R(12:7|(3:34|35|(4:37|38|39|24))(3:9|10|(2:33|24))|12|13|15|16|(2:19|17)|20|21|23|24|5) */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x00a3, code lost:
    
        r2 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x00a4, code lost:
    
        com.uc.crashsdk.e.a(r2, r11);
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x008d, code lost:
    
        r2 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x008e, code lost:
    
        com.uc.crashsdk.e.a(r2, r11);
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x0068, code lost:
    
        r2 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x0069, code lost:
    
        com.uc.crashsdk.e.a(r2, r11);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void b(java.io.OutputStream outputStream, java.lang.String str, java.lang.String str2, java.util.ArrayList<java.lang.String> arrayList) {
        synchronized (A) {
            for (java.lang.String str3 : B) {
                java.lang.Object[] objArr = A.get(str3);
                int intValue = ((java.lang.Integer) objArr[0]).intValue();
                int intValue2 = ((java.lang.Integer) objArr[1]).intValue();
                java.util.List list = (java.util.List) objArr[2];
                if (arrayList == null) {
                    if (!com.uc.crashsdk.export.LogType.isForJava(intValue2)) {
                    }
                } else if (!a(arrayList, str3)) {
                }
                outputStream.write(java.lang.String.format(java.util.Locale.US, "%s (%d/%d)\n", str3, java.lang.Integer.valueOf(list.size()), java.lang.Integer.valueOf(intValue)).getBytes(str));
                java.util.Iterator it = list.iterator();
                while (it.hasNext()) {
                    outputStream.write(((java.lang.String) it.next()).getBytes(str));
                    outputStream.write("\n".getBytes(str));
                }
                outputStream.write("\n".getBytes(str));
                outputStream.write(str2.getBytes(str));
            }
            if (arrayList != null && com.uc.crashsdk.e.F()) {
                java.util.Iterator<java.lang.String> it2 = arrayList.iterator();
                while (it2.hasNext()) {
                    java.lang.String next = it2.next();
                    if (!a(B, next)) {
                        com.uc.crashsdk.e.a(outputStream, "CUSTOMCACHEDINFO", next);
                    }
                }
            }
        }
    }

    public static int c() {
        if (i == -1) {
            o();
        }
        return i;
    }

    public static java.util.ArrayList<java.lang.String> c(java.lang.String str) {
        if (com.uc.crashsdk.a.g.a(str)) {
            return null;
        }
        java.lang.String[] split = str.split(com.alipay.sdk.m.u.i.b, 20);
        java.util.ArrayList<java.lang.String> arrayList = new java.util.ArrayList<>();
        for (java.lang.String str2 : split) {
            if (!com.uc.crashsdk.a.g.a(str2)) {
                arrayList.add(str2);
            }
        }
        return arrayList;
    }

    public static void d() {
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        synchronized (e) {
            for (java.lang.String str : f) {
                java.lang.String str2 = e.get(str);
                sb.append(str);
                sb.append(": ");
                if (str2 != null) {
                    sb.append(str2);
                }
                sb.append("\n");
            }
        }
        sb.append(java.lang.String.format(java.util.Locale.US, "(saved at %s)\n", com.uc.crashsdk.e.n()));
        com.uc.crashsdk.a.b.a(com.uc.crashsdk.b.h(), sb.toString());
    }

    public static void e() {
        if (!d && !com.uc.crashsdk.b.d) {
            throw new java.lang.AssertionError();
        }
        synchronized (e) {
            for (java.lang.String str : f) {
                com.uc.crashsdk.JNIBridge.nativeAddHeaderInfo(str, e.get(str));
            }
        }
    }

    public static byte[] f() {
        return new byte[]{com.google.common.base.Ascii.CAN, 99, 121, 60};
    }

    public static void g() {
        if (!d && !com.uc.crashsdk.b.d) {
            throw new java.lang.AssertionError();
        }
        synchronized (k) {
            for (java.lang.String str : l) {
                java.lang.Object[] objArr = k.get(str);
                int intValue = ((java.lang.Integer) objArr[0]).intValue();
                if ((1048833 & intValue) != 0) {
                    com.uc.crashsdk.JNIBridge.nativeAddDumpFile(str, (java.lang.String) objArr[1], ((java.lang.Boolean) objArr[2]).booleanValue(), ((java.lang.Boolean) objArr[3]).booleanValue(), intValue, ((java.lang.Boolean) objArr[4]).booleanValue());
                }
            }
        }
    }

    public static java.lang.String h() {
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        synchronized (k) {
            boolean z2 = true;
            for (java.lang.String str : l) {
                if (com.uc.crashsdk.export.LogType.isForJava(((java.lang.Integer) k.get(str)[0]).intValue())) {
                    if (!z2) {
                        sb.append("`");
                    }
                    sb.append(str);
                    z2 = false;
                }
            }
        }
        return sb.toString();
    }

    public static void i() {
        if (!d && !com.uc.crashsdk.b.d) {
            throw new java.lang.AssertionError();
        }
        synchronized (q) {
            for (java.lang.String str : r) {
                java.lang.Object[] objArr = q.get(str);
                int intValue = ((java.lang.Integer) objArr[0]).intValue();
                if ((1048833 & intValue) != 0) {
                    com.uc.crashsdk.JNIBridge.nativeAddCallbackInfo(str, intValue, ((java.lang.Long) objArr[2]).longValue(), ((java.lang.Integer) objArr[3]).intValue());
                }
            }
        }
    }

    public static java.lang.String j() {
        java.lang.String sb;
        synchronized (q) {
            java.lang.StringBuilder sb2 = new java.lang.StringBuilder();
            java.util.List<java.lang.String> list = r;
            synchronized (list) {
                boolean z2 = true;
                for (java.lang.String str : list) {
                    if (com.uc.crashsdk.export.LogType.isForJava(((java.lang.Integer) q.get(str)[0]).intValue())) {
                        if (!z2) {
                            sb2.append("`");
                        }
                        sb2.append(str);
                        z2 = false;
                    }
                }
            }
            sb = sb2.toString();
        }
        return sb;
    }

    public static void k() {
        if (!d && !com.uc.crashsdk.b.d) {
            throw new java.lang.AssertionError();
        }
        synchronized (A) {
            for (java.lang.String str : B) {
                java.lang.Object[] objArr = A.get(str);
                int intValue = ((java.lang.Integer) objArr[0]).intValue();
                int intValue2 = ((java.lang.Integer) objArr[1]).intValue();
                java.util.List list = (java.util.List) objArr[2];
                if ((1048577 & intValue2) != 0 && com.uc.crashsdk.JNIBridge.nativeCreateCachedInfo(str, intValue, intValue2) != 0) {
                    java.util.Iterator it = list.iterator();
                    while (it.hasNext() && com.uc.crashsdk.JNIBridge.nativeAddCachedInfo(str, (java.lang.String) it.next())) {
                    }
                }
            }
        }
    }

    public static java.lang.String l() {
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        synchronized (A) {
            boolean z2 = true;
            for (java.lang.String str : B) {
                if (com.uc.crashsdk.export.LogType.isForJava(((java.lang.Integer) A.get(str)[1]).intValue())) {
                    if (!z2) {
                        sb.append("`");
                    }
                    sb.append(str);
                    z2 = false;
                }
            }
        }
        return sb.toString();
    }

    public static java.lang.String m() {
        if (!G) {
            java.lang.String a2 = com.uc.crashsdk.a.b.a(com.uc.crashsdk.b.m());
            g = a2;
            G = true;
            if (a2 == null) {
                g = "";
            }
        }
        return g;
    }

    public static void n() {
        p();
        if (!H) {
            H = true;
            com.uc.crashsdk.a.f.a(0, new com.uc.crashsdk.a.e(202));
        } else if (com.uc.crashsdk.b.d) {
            com.uc.crashsdk.JNIBridge.set(128, g);
        }
    }

    private static boolean o() {
        try {
            android.content.pm.PackageInfo packageInfo = com.uc.crashsdk.a.g.a().getPackageManager().getPackageInfo(a, 0);
            h = packageInfo.versionName;
            j = packageInfo.lastUpdateTime;
            i = packageInfo.versionCode;
            return true;
        } catch (java.lang.Throwable th) {
            com.uc.crashsdk.a.g.b(th);
            return false;
        }
    }

    private static void p() {
        if (!I && com.uc.crashsdk.e.a()) {
            if (com.uc.crashsdk.b.d || !com.uc.crashsdk.b.g) {
                java.lang.String format = java.lang.String.format(java.util.Locale.US, "%s/%s/%s", com.uc.crashsdk.g.U(), com.uc.crashsdk.g.V(), com.uc.crashsdk.g.W());
                com.uc.crashsdk.a.a.b("crashsdk", "UUID: " + com.uc.crashsdk.e.q());
                com.uc.crashsdk.a.a.b("crashsdk", "Version: " + format);
                com.uc.crashsdk.a.a.b("crashsdk", "Process Name: " + com.uc.crashsdk.e.h());
                I = true;
            }
        }
    }
}
