package s.h.e.l.l;

/* loaded from: classes.dex */
public final class N {
    static boolean la = true;

    /* JADX WARN: Removed duplicated region for block: B:15:0x001d A[Catch: Throwable -> 0x0083, TryCatch #6 {Throwable -> 0x0083, blocks: (B:13:0x0019, B:15:0x001d, B:17:0x0039, B:21:0x006e, B:23:0x0074, B:25:0x007d, B:36:0x0095, B:38:0x009e, B:29:0x0085, B:31:0x008e), top: B:12:0x0019, inners: #8 }] */
    /* JADX WARN: Removed duplicated region for block: B:21:0x006e A[Catch: Throwable -> 0x0083, TRY_ENTER, TryCatch #6 {Throwable -> 0x0083, blocks: (B:13:0x0019, B:15:0x001d, B:17:0x0039, B:21:0x006e, B:23:0x0074, B:25:0x007d, B:36:0x0095, B:38:0x009e, B:29:0x0085, B:31:0x008e), top: B:12:0x0019, inners: #8 }] */
    static {
        java.lang.Object obj;
        java.lang.Object obj2;
        java.lang.Object obj3 = null;
        try {
            obj2 = new java.lang.Object();
            try {
                java.lang.Object obj4 = new java.lang.Object();
                if (obj2 != null) {
                    try {
                        obj2.hashCode();
                    } catch (java.lang.Exception e) {
                    }
                }
                if (obj4 != null) {
                    try {
                        obj4.hashCode();
                    } catch (java.lang.Exception e2) {
                    }
                }
            } catch (java.lang.Exception e3) {
                if (obj2 != null) {
                    try {
                        obj2.hashCode();
                    } catch (java.lang.Exception e4) {
                    }
                }
                if (0 != 0) {
                    try {
                        obj3.hashCode();
                    } catch (java.lang.Exception e5) {
                    }
                }
                if (!la) {
                }
            } catch (java.lang.Throwable th) {
                obj = obj2;
                th = th;
                if (obj != null) {
                    try {
                        obj.hashCode();
                    } catch (java.lang.Exception e6) {
                    }
                }
                if (0 == 0) {
                    throw th;
                }
                try {
                    obj3.hashCode();
                    throw th;
                } catch (java.lang.Exception e7) {
                    throw th;
                }
            }
        } catch (java.lang.Exception e8) {
            obj2 = null;
        } catch (java.lang.Throwable th2) {
            th = th2;
            obj = null;
        }
        try {
            if (!la) {
                java.lang.System.load(java.lang.String.valueOf(s.h.e.l.l.S.p) + "/libexec.so");
                if (s.h.e.l.l.S.m) {
                    java.lang.System.load(java.lang.String.valueOf(s.h.e.l.l.S.p) + "/libexecmain.so");
                    return;
                }
                return;
            }
            if (!x()) {
                java.lang.System.loadLibrary("exec");
                if (s.h.e.l.l.S.m) {
                    java.lang.System.loadLibrary("execmain");
                    return;
                }
                return;
            }
            try {
                java.lang.System.loadLibrary("exec_x86");
                if (s.h.e.l.l.S.m) {
                    java.lang.System.loadLibrary("execmain_x86");
                }
            } catch (java.lang.Throwable th3) {
                java.lang.System.loadLibrary("exec");
                if (s.h.e.l.l.S.m) {
                    java.lang.System.loadLibrary("execmain");
                }
            }
        } catch (java.lang.Throwable th4) {
        }
    }

    public static native java.lang.ClassLoader al(java.lang.ClassLoader classLoader, android.content.pm.ApplicationInfo applicationInfo, java.lang.String str, java.lang.String str2);

    public static native byte[] b2b(byte[] bArr, int i);

    public static native boolean l(android.app.Application application, java.lang.String str);

    public static native void m(java.lang.String str, int i);

    public static native boolean r(android.app.Application application, java.lang.String str);

    public static native boolean ra(android.app.Application application, java.lang.String str);

    public static native void sa(java.lang.String str, java.lang.String str2);

    /* JADX WARN: Removed duplicated region for block: B:14:0x002c A[Catch: Exception -> 0x0076, TRY_LEAVE, TryCatch #7 {Exception -> 0x0076, blocks: (B:12:0x001c, B:14:0x002c), top: B:11:0x001c }] */
    /* JADX WARN: Removed duplicated region for block: B:20:0x003b A[Catch: Exception -> 0x0069, TRY_ENTER, TRY_LEAVE, TryCatch #5 {Exception -> 0x0069, blocks: (B:9:0x0016, B:20:0x003b), top: B:8:0x0016 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static boolean x() {
        java.lang.Object obj;
        java.lang.Object obj2;
        java.lang.String a;
        java.io.FileInputStream fileInputStream;
        java.lang.Object obj3 = null;
        try {
            obj2 = new java.lang.Object();
            try {
                java.lang.Object obj4 = new java.lang.Object();
                if (obj2 != null) {
                    try {
                        obj2.hashCode();
                    } catch (java.lang.Exception e) {
                    }
                }
                if (obj4 != null) {
                    try {
                        obj4.hashCode();
                    } catch (java.lang.Exception e2) {
                    }
                }
            } catch (java.lang.Exception e3) {
                if (obj2 != null) {
                    try {
                        obj2.hashCode();
                    } catch (java.lang.Exception e4) {
                    }
                }
                if (0 != 0) {
                    try {
                        obj3.hashCode();
                    } catch (java.lang.Exception e5) {
                    }
                }
                a = s.h.e.l.l.S.a();
                byte[] bArr = new byte[20];
                fileInputStream = new java.io.FileInputStream(new java.io.File("/system/bin/linker"));
                if (fileInputStream != null) {
                }
                if (a != null) {
                }
                return false;
            } catch (java.lang.Throwable th) {
                obj = obj2;
                th = th;
                if (obj != null) {
                    try {
                        obj.hashCode();
                    } catch (java.lang.Exception e6) {
                    }
                }
                if (0 == 0) {
                    throw th;
                }
                try {
                    obj3.hashCode();
                    throw th;
                } catch (java.lang.Exception e7) {
                    throw th;
                }
            }
        } catch (java.lang.Exception e8) {
            obj2 = null;
        } catch (java.lang.Throwable th2) {
            th = th2;
            obj = null;
        }
        try {
            a = s.h.e.l.l.S.a();
            try {
                byte[] bArr2 = new byte[20];
                fileInputStream = new java.io.FileInputStream(new java.io.File("/system/bin/linker"));
                if (fileInputStream != null) {
                    fileInputStream.read(bArr2);
                    fileInputStream.close();
                    switch (bArr2[18]) {
                        case 3:
                            a = "x86";
                            break;
                        case 40:
                            a = "armeabi";
                            break;
                    }
                }
            } catch (java.lang.Exception e9) {
            }
            if (a != null) {
                if (a.contains("x86")) {
                    return true;
                }
            }
        } catch (java.lang.Exception e10) {
        }
        return false;
    }
}
