package com.uc.crashsdk;

/* loaded from: classes19.dex */
public final class d {
    private static com.uc.crashsdk.export.ICrashClient a = null;
    private static int b = 3;
    private static volatile java.util.List<android.webkit.ValueCallback<android.os.Bundle>> c;
    private static volatile java.util.List<android.webkit.ValueCallback<android.os.Bundle>> d;
    private static volatile java.util.List<android.webkit.ValueCallback<android.os.Bundle>> e;
    private static volatile java.util.List<android.webkit.ValueCallback<android.os.Bundle>> f;
    private static final java.lang.Object g = new java.lang.Object();

    public static java.io.File a(java.io.File file) {
        com.uc.crashsdk.export.ICrashClient iCrashClient = a;
        if (iCrashClient != null) {
            try {
                return iCrashClient.onBeforeUploadLog(file);
            } catch (java.lang.Throwable th) {
                com.uc.crashsdk.a.g.a(th);
            }
        }
        return file;
    }

    public static java.lang.String a(java.lang.String str, boolean z) {
        com.uc.crashsdk.export.ICrashClient iCrashClient = a;
        return iCrashClient != null ? iCrashClient.onGetCallbackInfo(str, z) : "";
    }

    public static void a(com.uc.crashsdk.export.ICrashClient iCrashClient) {
        a = iCrashClient;
    }

    public static void a(java.lang.String str, int i, int i2) {
        com.uc.crashsdk.export.ICrashClient iCrashClient = a;
        if (iCrashClient != null) {
            iCrashClient.onAddCrashStats(str, i, i2);
        }
        if (f != null) {
            synchronized (f) {
                for (android.webkit.ValueCallback<android.os.Bundle> valueCallback : f) {
                    try {
                        android.os.Bundle bundle = new android.os.Bundle();
                        bundle.putString("processName", str);
                        bundle.putInt("key", i);
                        bundle.putInt(me.leolin.shortcutbadger.impl.NewHtcHomeBadger.COUNT, i2);
                        valueCallback.onReceiveValue(bundle);
                    } catch (java.lang.Throwable th) {
                        com.uc.crashsdk.a.g.a(th);
                    }
                }
            }
        }
    }

    public static void a(java.lang.String str, java.lang.String str2, java.lang.String str3) {
        if (com.uc.crashsdk.a.g.a(str)) {
            com.uc.crashsdk.a.a.a("crashsdk", "onLogGenerated file name is null!", null);
            return;
        }
        boolean equals = com.uc.crashsdk.e.h().equals(str2);
        if (a != null) {
            java.io.File file = new java.io.File(str);
            try {
                if (equals) {
                    a.onLogGenerated(file, str3);
                } else {
                    a.onClientProcessLogGenerated(str2, file, str3);
                }
            } catch (java.lang.Throwable th) {
                com.uc.crashsdk.a.g.a(th);
            }
        }
        java.util.List<android.webkit.ValueCallback<android.os.Bundle>> list = c;
        if (!equals) {
            list = d;
        }
        if (list != null) {
            synchronized (list) {
                for (android.webkit.ValueCallback<android.os.Bundle> valueCallback : list) {
                    try {
                        android.os.Bundle bundle = new android.os.Bundle();
                        bundle.putString("filePathName", str);
                        if (!equals) {
                            bundle.putString("processName", str2);
                        }
                        bundle.putString("logType", str3);
                        valueCallback.onReceiveValue(bundle);
                    } catch (java.lang.Throwable th2) {
                        com.uc.crashsdk.a.g.a(th2);
                    }
                }
            }
        }
    }

    public static void a(boolean z) {
        com.uc.crashsdk.export.ICrashClient iCrashClient = a;
        if (iCrashClient != null) {
            try {
                iCrashClient.onCrashRestarting(z);
            } catch (java.lang.Throwable th) {
                com.uc.crashsdk.a.g.a(th);
            }
        }
        if (e != null) {
            synchronized (e) {
                for (android.webkit.ValueCallback<android.os.Bundle> valueCallback : e) {
                    try {
                        android.os.Bundle bundle = new android.os.Bundle();
                        bundle.putBoolean("isJava", z);
                        valueCallback.onReceiveValue(bundle);
                    } catch (java.lang.Throwable th2) {
                        com.uc.crashsdk.a.g.a(th2);
                    }
                }
            }
        }
    }

    public static boolean a(android.webkit.ValueCallback<android.os.Bundle> valueCallback) {
        if (c == null) {
            synchronized (g) {
                if (c == null) {
                    c = new java.util.ArrayList();
                }
            }
        }
        synchronized (c) {
            if (c.size() >= b) {
                return false;
            }
            c.add(valueCallback);
            return true;
        }
    }

    public static boolean b(android.webkit.ValueCallback<android.os.Bundle> valueCallback) {
        if (d == null) {
            synchronized (g) {
                if (d == null) {
                    d = new java.util.ArrayList();
                }
            }
        }
        synchronized (d) {
            if (d.size() >= b) {
                return false;
            }
            d.add(valueCallback);
            return true;
        }
    }

    public static boolean c(android.webkit.ValueCallback<android.os.Bundle> valueCallback) {
        if (e == null) {
            synchronized (g) {
                if (e == null) {
                    e = new java.util.ArrayList();
                }
            }
        }
        synchronized (e) {
            if (e.size() >= b) {
                return false;
            }
            e.add(valueCallback);
            return true;
        }
    }

    public static boolean d(android.webkit.ValueCallback<android.os.Bundle> valueCallback) {
        if (f == null) {
            synchronized (g) {
                if (f == null) {
                    f = new java.util.ArrayList();
                }
            }
        }
        synchronized (f) {
            if (f.size() >= b) {
                return false;
            }
            f.add(valueCallback);
            return true;
        }
    }
}
