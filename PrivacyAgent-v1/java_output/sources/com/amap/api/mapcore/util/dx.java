package com.amap.api.mapcore.util;

/* loaded from: classes12.dex */
public final class dx {
    private boolean b = false;
    java.util.ArrayList<com.amap.api.mapcore.util.dx.a> a = new java.util.ArrayList<>();

    public static class a {
        private java.lang.String a;
        private java.lang.Object b;
        private java.lang.Class<?>[] c;
        private java.lang.Object[] d;

        public a(java.lang.Object obj, java.lang.String str, java.lang.Object... objArr) {
            this.b = obj;
            this.a = str;
            if (objArr == null || objArr.length <= 0) {
                return;
            }
            this.c = new java.lang.Class[objArr.length];
            for (int i = 0; i < objArr.length; i++) {
                this.c[i] = objArr[i].getClass();
            }
            this.d = new java.lang.Object[objArr.length];
            for (int i2 = 0; i2 < objArr.length; i2++) {
                this.d[i2] = objArr[i2];
            }
        }
    }

    public final synchronized void a() {
        java.lang.reflect.Method method;
        if (this.b) {
            return;
        }
        this.b = true;
        for (int i = 0; i < this.a.size(); i++) {
            com.amap.api.mapcore.util.dx.a aVar = this.a.get(i);
            try {
                try {
                    try {
                        if (aVar.b != null) {
                            java.lang.Class<?> cls = aVar.b.getClass();
                            try {
                                method = cls.getDeclaredMethod(aVar.a, aVar.c);
                            } catch (java.lang.NoSuchMethodException unused) {
                                if (aVar.c.length > 0) {
                                    java.lang.Class<?>[] clsArr = new java.lang.Class[aVar.c.length];
                                    for (int i2 = 0; i2 < aVar.c.length; i2++) {
                                        if (aVar.c[i2].getInterfaces().length > 0) {
                                            clsArr[i2] = aVar.c[i2].getInterfaces()[0];
                                        }
                                    }
                                    method = cls.getDeclaredMethod(aVar.a, clsArr);
                                } else {
                                    method = null;
                                }
                            }
                            if (method != null) {
                                method.setAccessible(true);
                                method.invoke(aVar.b, aVar.d);
                            }
                        }
                    } catch (java.lang.NoSuchMethodException e) {
                        e.printStackTrace();
                    }
                } catch (java.lang.IllegalAccessException e2) {
                    e2.printStackTrace();
                } catch (java.lang.SecurityException e3) {
                    e3.printStackTrace();
                }
            } catch (java.lang.IllegalArgumentException e4) {
                e4.printStackTrace();
            } catch (java.lang.reflect.InvocationTargetException e5) {
                e5.printStackTrace();
            }
        }
        this.a.clear();
    }

    public final synchronized void a(java.lang.Object obj, java.lang.Object... objArr) {
        try {
            java.lang.StackTraceElement[] stackTrace = java.lang.Thread.currentThread().getStackTrace();
            if (stackTrace != null && stackTrace.length >= 3) {
                this.a.add(new com.amap.api.mapcore.util.dx.a(obj, stackTrace[3].getMethodName(), objArr));
            }
        } catch (java.lang.Throwable unused) {
        }
        this.b = false;
    }
}
