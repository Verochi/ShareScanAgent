package com.xiaomi.push;

/* loaded from: classes19.dex */
class v implements com.xiaomi.push.u, java.lang.reflect.InvocationHandler {
    private static final java.lang.String[][] a = {new java.lang.String[]{"com.bun.supplier.IIdentifierListener", "com.bun.supplier.IdSupplier"}, new java.lang.String[]{"com.bun.miitmdid.core.IIdentifierListener", "com.bun.miitmdid.supplier.IdSupplier"}};
    private android.content.Context k;
    private java.lang.Class b = null;
    private java.lang.Class c = null;
    private java.lang.reflect.Method d = null;
    private java.lang.reflect.Method e = null;
    private java.lang.reflect.Method f = null;
    private java.lang.reflect.Method g = null;
    private java.lang.reflect.Method h = null;
    private java.lang.reflect.Method i = null;
    private java.lang.reflect.Method j = null;
    private final java.lang.Object l = new java.lang.Object();
    private volatile int m = 0;
    private volatile long n = 0;
    private volatile com.xiaomi.push.v.a o = null;

    public class a {
        java.lang.Boolean a;
        java.lang.String b;
        java.lang.String c;
        java.lang.String d;
        java.lang.String e;

        private a() {
            this.a = null;
            this.b = null;
            this.c = null;
            this.d = null;
            this.e = null;
        }

        public /* synthetic */ a(com.xiaomi.push.v vVar, byte b) {
            this();
        }
    }

    public v(android.content.Context context) {
        this.k = context.getApplicationContext();
        a(context);
        b(context);
    }

    private static java.lang.Class<?> a(android.content.Context context, java.lang.String str) {
        try {
            return com.xiaomi.push.jc.a(context, str);
        } catch (java.lang.Throwable unused) {
            return null;
        }
    }

    private static <T> T a(java.lang.reflect.Method method, java.lang.Object obj, java.lang.Object... objArr) {
        if (method == null) {
            return null;
        }
        try {
            T t = (T) method.invoke(obj, objArr);
            if (t != null) {
                return t;
            }
            return null;
        } catch (java.lang.Throwable unused) {
            return null;
        }
    }

    private static java.lang.reflect.Method a(java.lang.Class<?> cls, java.lang.String str, java.lang.Class<?>... clsArr) {
        if (cls == null) {
            return null;
        }
        try {
            return cls.getMethod(str, clsArr);
        } catch (java.lang.Throwable unused) {
            return null;
        }
    }

    private void a(android.content.Context context) {
        java.lang.Class<?> a2 = a(context, "com.bun.miitmdid.core.MdidSdk");
        java.lang.Class<?> cls = null;
        java.lang.Class<?> cls2 = null;
        int i = 0;
        while (true) {
            java.lang.String[][] strArr = a;
            if (i >= strArr.length) {
                break;
            }
            java.lang.String[] strArr2 = strArr[i];
            java.lang.Class<?> a3 = a(context, strArr2[0]);
            java.lang.Class<?> a4 = a(context, strArr2[1]);
            if (a3 != null && a4 != null) {
                b("found class in index ".concat(java.lang.String.valueOf(i)));
                cls2 = a4;
                cls = a3;
                break;
            } else {
                i++;
                cls2 = a4;
                cls = a3;
            }
        }
        this.b = a2;
        this.d = a(a2, "InitSdk", (java.lang.Class<?>[]) new java.lang.Class[]{android.content.Context.class, cls});
        this.c = cls;
        this.e = a(cls2, "getUDID", (java.lang.Class<?>[]) new java.lang.Class[0]);
        this.f = a(cls2, "getOAID", (java.lang.Class<?>[]) new java.lang.Class[0]);
        this.g = a(cls2, "getVAID", (java.lang.Class<?>[]) new java.lang.Class[0]);
        this.h = a(cls2, "getAAID", (java.lang.Class<?>[]) new java.lang.Class[0]);
        this.i = a(cls2, "isSupported", (java.lang.Class<?>[]) new java.lang.Class[0]);
        this.j = a(cls2, "shutDown", (java.lang.Class<?>[]) new java.lang.Class[0]);
    }

    private void a(java.lang.String str) {
        if (this.o != null) {
            return;
        }
        long j = this.n;
        long elapsedRealtime = android.os.SystemClock.elapsedRealtime() - java.lang.Math.abs(j);
        int i = this.m;
        if (elapsedRealtime > 3000 && i < 3) {
            synchronized (this.l) {
                if (this.n == j && this.m == i) {
                    b("retry, current count is ".concat(java.lang.String.valueOf(i)));
                    this.m++;
                    b(this.k);
                    j = this.n;
                    elapsedRealtime = android.os.SystemClock.elapsedRealtime() - java.lang.Math.abs(j);
                }
            }
        }
        if (this.o != null || j < 0 || elapsedRealtime > 3000 || android.os.Looper.myLooper() == android.os.Looper.getMainLooper()) {
            return;
        }
        synchronized (this.l) {
            if (this.o == null) {
                try {
                    b(str + " wait...");
                    this.l.wait(3000L);
                } catch (java.lang.Exception unused) {
                }
            }
        }
    }

    private void b(android.content.Context context) {
        long elapsedRealtime = android.os.SystemClock.elapsedRealtime();
        long j = -elapsedRealtime;
        java.lang.Class cls = this.c;
        if (cls != null) {
            try {
                java.lang.ClassLoader classLoader = cls.getClassLoader();
                if (classLoader == null) {
                    classLoader = context.getClassLoader();
                }
                a(this.d, this.b.newInstance(), context, java.lang.reflect.Proxy.newProxyInstance(classLoader, new java.lang.Class[]{this.c}, this));
            } catch (java.lang.Throwable th) {
                b("call init sdk error:".concat(java.lang.String.valueOf(th)));
            }
            this.n = elapsedRealtime;
        }
        elapsedRealtime = j;
        this.n = elapsedRealtime;
    }

    private static void b(java.lang.String str) {
        com.xiaomi.channel.commonutils.logger.b.a("mdid:".concat(java.lang.String.valueOf(str)));
    }

    @Override // com.xiaomi.push.u
    public final boolean a() {
        a("isSupported");
        return this.o != null && java.lang.Boolean.TRUE.equals(this.o.a);
    }

    @Override // com.xiaomi.push.u
    public final java.lang.String b() {
        a("getOAID");
        if (this.o == null) {
            return null;
        }
        return this.o.c;
    }

    @Override // java.lang.reflect.InvocationHandler
    public java.lang.Object invoke(java.lang.Object obj, java.lang.reflect.Method method, java.lang.Object[] objArr) {
        this.n = android.os.SystemClock.elapsedRealtime();
        if (objArr != null) {
            com.xiaomi.push.v.a aVar = new com.xiaomi.push.v.a(this, (byte) 0);
            int length = objArr.length;
            int i = 0;
            while (true) {
                if (i >= length) {
                    break;
                }
                java.lang.Object obj2 = objArr[i];
                if (obj2 != null) {
                    if ((obj2 instanceof java.lang.Boolean) || (obj2 instanceof java.lang.Character) || (obj2 instanceof java.lang.Byte) || (obj2 instanceof java.lang.Short) || (obj2 instanceof java.lang.Integer) || (obj2 instanceof java.lang.Long) || (obj2 instanceof java.lang.Float) || (obj2 instanceof java.lang.Double)) {
                        continue;
                    } else {
                        aVar.b = (java.lang.String) a(this.e, obj2, new java.lang.Object[0]);
                        aVar.c = (java.lang.String) a(this.f, obj2, new java.lang.Object[0]);
                        aVar.d = (java.lang.String) a(this.g, obj2, new java.lang.Object[0]);
                        aVar.e = (java.lang.String) a(this.h, obj2, new java.lang.Object[0]);
                        aVar.a = (java.lang.Boolean) a(this.i, obj2, new java.lang.Object[0]);
                        a(this.j, obj2, new java.lang.Object[0]);
                        if (!android.text.TextUtils.isEmpty(aVar.b) || !android.text.TextUtils.isEmpty(aVar.c) || !android.text.TextUtils.isEmpty(aVar.d) || !android.text.TextUtils.isEmpty(aVar.e)) {
                            aVar.a = java.lang.Boolean.TRUE;
                        }
                        if (aVar.a != null) {
                            java.lang.StringBuilder sb = new java.lang.StringBuilder("has get succ, check duplicate:");
                            sb.append(this.o != null);
                            b(sb.toString());
                            synchronized (com.xiaomi.push.v.class) {
                                if (this.o == null) {
                                    this.o = aVar;
                                }
                            }
                        }
                    }
                }
                i++;
            }
        }
        synchronized (this.l) {
            try {
                this.l.notifyAll();
            } catch (java.lang.Exception unused) {
            }
        }
        return null;
    }
}
