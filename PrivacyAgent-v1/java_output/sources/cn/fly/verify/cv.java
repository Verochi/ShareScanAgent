package cn.fly.verify;

/* loaded from: classes31.dex */
public class cv {
    private cn.fly.verify.cx a;
    private java.util.HashMap<java.lang.String, java.lang.Object> c;
    private cn.fly.verify.cv e;
    private boolean f;
    private java.util.LinkedList<java.lang.Object> b = new java.util.LinkedList<>();
    private java.util.HashMap<java.lang.String, java.lang.Class<?>> d = new java.util.HashMap<>();

    /* renamed from: cn.fly.verify.cv$1, reason: invalid class name */
    /* loaded from: classes.dex */
    public class AnonymousClass1 implements java.lang.reflect.InvocationHandler {
        final /* synthetic */ java.lang.Object a;
        final /* synthetic */ boolean b;

        public AnonymousClass1(java.lang.Object obj, boolean z) {
            this.a = obj;
            this.b = z;
        }

        @Override // java.lang.reflect.InvocationHandler
        public java.lang.Object invoke(java.lang.Object obj, java.lang.reflect.Method method, java.lang.Object[] objArr) throws java.lang.Throwable {
            java.lang.Throwable th;
            java.util.LinkedList<java.lang.Object> b;
            try {
                java.lang.Object obj2 = this.a;
                cn.fly.verify.dc dcVar = obj2 != null ? obj2 instanceof cn.fly.verify.dc ? (cn.fly.verify.dc) obj2 : (cn.fly.verify.dc) ((java.util.Map) obj2).get(method.getName()) : null;
                if (dcVar != null) {
                    if (objArr == null) {
                        objArr = new java.lang.Object[0];
                    }
                    if (this.b) {
                        b = dcVar.b(objArr);
                    } else {
                        try {
                            b = dcVar.b(objArr);
                        } finally {
                            th = th;
                            try {
                            } catch (java.lang.Throwable unused) {
                            }
                        }
                    }
                    if (b.isEmpty()) {
                        return null;
                    }
                    return b.get(0);
                }
            } catch (java.lang.Throwable unused2) {
            }
            th = null;
            if (th == null) {
                return null;
            }
            throw th;
        }
    }

    public cv(java.util.HashMap<java.lang.String, java.lang.Object> hashMap, cn.fly.verify.cx cxVar) {
        this.a = cxVar;
        this.c = new java.util.HashMap<>(hashMap);
    }

    public java.lang.Object a() {
        return this.b.pop();
    }

    public java.lang.Object a(java.lang.Object obj, boolean z, java.lang.Class<?>... clsArr) {
        return java.lang.reflect.Proxy.newProxyInstance(getClass().getClassLoader(), clsArr, new cn.fly.verify.cv.AnonymousClass1(obj, z));
    }

    public java.lang.Object a(java.lang.String str) {
        for (cn.fly.verify.cv cvVar = this; cvVar != null; cvVar = cvVar.e) {
            if (cvVar.c.containsKey(str)) {
                return cvVar.c.get(str);
            }
        }
        throw new java.lang.RuntimeException("Can not find \"" + str + "\"");
    }

    public void a(java.lang.Object obj) {
        this.b.push(obj);
    }

    public void a(java.lang.String str, java.lang.Class<?> cls) {
        this.d.put(str, cls);
    }

    public void a(java.lang.String str, java.lang.Object obj) {
        if (!this.c.containsKey(str)) {
            this.c.put(str, obj);
            return;
        }
        throw new java.lang.RuntimeException("\"" + str + "\" has defined");
    }

    public void a(java.lang.reflect.Method method, int i) throws java.lang.Throwable {
        java.lang.Object[] objArr = new java.lang.Object[i];
        for (int i2 = 0; i2 < i; i2++) {
            objArr[i2] = a();
        }
        a(method, objArr);
    }

    public void a(java.lang.reflect.Method method, java.lang.Object[] objArr) throws java.lang.Throwable {
        java.lang.Object obj;
        if (java.lang.reflect.Modifier.isStatic(method.getModifiers())) {
            obj = null;
        } else {
            if (objArr.length <= 0) {
                throw new java.lang.RuntimeException("receiver not found");
            }
            obj = objArr[0];
            int length = objArr.length - 1;
            java.lang.Object[] objArr2 = new java.lang.Object[length];
            int i = 0;
            while (i < length) {
                int i2 = i + 1;
                objArr2[i] = objArr[i2];
                i = i2;
            }
            objArr = objArr2;
        }
        method.setAccessible(true);
        for (int i3 = 0; i3 < objArr.length; i3++) {
            if (method.getParameterTypes()[i3].isInterface()) {
                java.lang.Object obj2 = objArr[i3];
                if (obj2 instanceof cn.fly.verify.dc) {
                    objArr[i3] = a(obj2, true, method.getParameterTypes()[i3]);
                }
            }
        }
        if (method.getReturnType() == java.lang.Void.TYPE) {
            method.invoke(obj, objArr);
        } else {
            a(method.invoke(obj, objArr));
        }
    }

    public cn.fly.verify.cv b() {
        cn.fly.verify.cv cvVar = new cn.fly.verify.cv(new java.util.HashMap(), this.a);
        cvVar.e = this;
        return cvVar;
    }

    public java.lang.Class<?> b(java.lang.String str) {
        for (cn.fly.verify.cv cvVar = this; cvVar != null; cvVar = cvVar.e) {
            if (cvVar.d.containsKey(str)) {
                return cvVar.d.get(str);
            }
        }
        throw new java.lang.RuntimeException("Can not find class " + str);
    }

    public void b(java.lang.String str, java.lang.Object obj) {
        if (this.c.containsKey(str)) {
            this.c.put(str, obj);
            return;
        }
        cn.fly.verify.cv cvVar = this.e;
        if (cvVar != null) {
            cvVar.b(str, obj);
            return;
        }
        throw new java.lang.RuntimeException("\"" + str + "\" has not defined");
    }

    public cn.fly.verify.cv c() {
        return this.e;
    }

    public int d() {
        return this.b.size();
    }

    public void e() {
        this.f = true;
    }

    public boolean f() {
        return this.f;
    }

    public cn.fly.verify.cx g() {
        return this.a;
    }
}
