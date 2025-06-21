package cn.fly.verify;

/* loaded from: classes.dex */
public class eu {
    private static final java.util.HashMap<java.lang.String, cn.fly.verify.eu> a = new java.util.HashMap<>();
    private static final java.util.HashMap<java.lang.String, java.lang.String> b = new java.util.HashMap<>();
    private java.lang.String c;
    private int d;
    private boolean e;

    public eu() {
        this.e = false;
        this.c = null;
        this.d = -1;
    }

    private eu(java.lang.String str, int i) {
        this.e = false;
        this.c = str;
        this.d = i;
    }

    private int a(int i, int i2, java.lang.String str) {
        cn.fly.verify.eu euVar;
        try {
            java.lang.String str2 = android.os.Process.myPid() + com.xiaomi.mipush.sdk.Constants.ACCEPT_TIME_SEPARATOR_SERVER + android.os.Process.myTid() + "(" + java.lang.Thread.currentThread().getName() + ") " + str;
            if (i2 == 1) {
                java.lang.String str3 = this.c;
                int i3 = this.d;
                java.util.HashMap<java.lang.String, java.lang.String> hashMap = b;
                if (!hashMap.isEmpty()) {
                    java.util.Iterator<java.util.Map.Entry<java.lang.String, java.lang.String>> it = hashMap.entrySet().iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            euVar = null;
                            break;
                        }
                        java.util.Map.Entry<java.lang.String, java.lang.String> next = it.next();
                        if (next.getValue() != null && str.contains(next.getValue())) {
                            euVar = a.get(next.getKey());
                            break;
                        }
                    }
                    if (euVar != null) {
                        str3 = euVar.c;
                        i3 = euVar.d;
                    }
                }
                cn.fly.verify.dr.a().a(1, str3, i3, str2);
            }
            cn.fly.verify.dr.a().a(i, str2);
            return 0;
        } catch (java.lang.Throwable unused) {
            return 0;
        }
    }

    @java.lang.Deprecated
    public static cn.fly.verify.eu a(java.lang.String str) {
        cn.fly.verify.eu euVar;
        java.util.HashMap<java.lang.String, cn.fly.verify.eu> hashMap = a;
        synchronized (hashMap) {
            euVar = hashMap.get(str);
            if (euVar == null) {
                euVar = new cn.fly.verify.eu(str, -1);
                b.put(str, null);
                hashMap.put(str, euVar);
            }
        }
        return euVar;
    }

    public static cn.fly.verify.eu a(java.lang.String str, int i, java.lang.String str2) {
        cn.fly.verify.eu euVar;
        java.util.HashMap<java.lang.String, cn.fly.verify.eu> hashMap = a;
        synchronized (hashMap) {
            euVar = hashMap.get(str);
            if (euVar == null) {
                euVar = new cn.fly.verify.eu(str, i);
                b.put(str, str2);
                hashMap.put(str, euVar);
            }
        }
        return euVar;
    }

    private java.lang.String e(java.lang.Throwable th) {
        try {
            return android.util.Log.getStackTraceString(th);
        } catch (java.lang.Throwable th2) {
            return th2 instanceof java.lang.OutOfMemoryError ? cn.fly.verify.ba.a("023=gg:hk:gl8kfe0fngmfl)feh.glEk=flfk5gPggkhgfgffh") : th2.getMessage();
        }
    }

    private java.lang.String f(java.lang.Throwable th) {
        try {
            java.lang.String name = th.getClass().getName();
            java.lang.String g = g(th);
            java.lang.String stackTraceElement = th.getStackTrace().length > 0 ? th.getStackTrace()[0].toString() : "";
            java.lang.Throwable th2 = th;
            while (th2 != null && th2.getCause() != null) {
                th2 = th2.getCause();
            }
            if (th2 == null || th2 == th) {
                return e(th);
            }
            return name + com.xiaomi.mipush.sdk.Constants.COLON_SEPARATOR + g + "\n" + stackTraceElement + "\n......\nCaused by:\n" + e(th2);
        } catch (java.lang.Throwable unused) {
            return e(th);
        }
    }

    private static java.lang.String g(java.lang.Throwable th) {
        java.lang.String message = th.getMessage();
        if (android.text.TextUtils.isEmpty(message)) {
            return "";
        }
        if (message.length() <= 1000) {
            return message;
        }
        return message.substring(0, 1000) + "\n[Message over limit size:1000, cut!]";
    }

    public final int a(int i, java.lang.Object obj, java.lang.Object... objArr) {
        java.lang.String obj2 = obj.toString();
        if (objArr.length > 0) {
            obj2 = java.lang.String.format(obj2, objArr);
        }
        return a(i, 0, obj2);
    }

    public final int a(int i, java.lang.Throwable th) {
        return a(i, 0, e(th));
    }

    public final int a(int i, java.lang.Throwable th, java.lang.Object obj, java.lang.Object... objArr) {
        java.lang.String obj2 = obj.toString();
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        if (objArr.length > 0) {
            obj2 = java.lang.String.format(obj2, objArr);
        }
        sb.append(obj2);
        sb.append('\n');
        sb.append(e(th));
        return a(i, 0, sb.toString());
    }

    public final int a(java.lang.Object obj, java.lang.Object... objArr) {
        return a(3, obj, objArr);
    }

    public final int a(java.lang.Throwable th) {
        return a(3, th);
    }

    public final int a(java.lang.Throwable th, java.lang.Object obj, java.lang.Object... objArr) {
        return a(3, th, obj, objArr);
    }

    public final int b(java.lang.Object obj, java.lang.Object... objArr) {
        return a(5, obj, objArr);
    }

    public final int b(java.lang.String str) {
        return a(5, str, new java.lang.Object[0]);
    }

    public final int b(java.lang.Throwable th) {
        return a(5, th);
    }

    public final int c(java.lang.Object obj, java.lang.Object... objArr) {
        return a(4, obj, objArr);
    }

    public final int c(java.lang.String str) {
        return a(4, str, new java.lang.Object[0]);
    }

    public final int c(java.lang.Throwable th) {
        return a(6, th);
    }

    public final int d(java.lang.Object obj, java.lang.Object... objArr) {
        return a(6, obj, objArr);
    }

    public final void d(java.lang.Throwable th) {
        a(6, 1, f(th));
    }
}
