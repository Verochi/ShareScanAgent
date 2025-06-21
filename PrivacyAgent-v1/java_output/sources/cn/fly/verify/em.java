package cn.fly.verify;

/* loaded from: classes.dex */
public class em {
    private static final java.lang.String a = cn.fly.verify.bj.a("014Dgegiigifghkgieik9e-giediheekg");
    private static cn.fly.verify.em b;
    private cn.fly.verify.em.a c;
    private volatile boolean d = false;

    public interface a {
        <T> T a(java.lang.Class cls, java.lang.Object obj, java.lang.String str, java.lang.Class[] clsArr, java.lang.Object[] objArr) throws java.lang.Throwable;

        <T> T a(java.lang.String str, java.lang.Object obj, java.lang.String str2, java.lang.Class[] clsArr, java.lang.Object[] objArr) throws java.lang.Throwable;

        <T> T a(java.lang.String str, java.lang.String str2, java.lang.Object obj) throws java.lang.Throwable;
    }

    public static class b implements cn.fly.verify.em.a {
        private java.lang.reflect.Method a;
        private java.lang.reflect.Method b;
        private java.lang.reflect.Method c;
        private java.lang.reflect.Method d;
        private java.lang.reflect.Method e;
        private java.lang.reflect.Method f;
        private java.lang.reflect.Method g;
        private boolean h;

        public b(android.content.Context context) {
            java.io.FileOutputStream fileOutputStream;
            java.io.FileOutputStream fileOutputStream2 = null;
            this.a = null;
            this.b = null;
            this.c = null;
            this.d = null;
            this.e = null;
            this.f = null;
            this.g = null;
            this.h = false;
            try {
                cn.fly.verify.fq.a(new java.io.File(context.getFilesDir(), cn.fly.verify.bj.a("014^gegiigifghkgieikJeMgiediheeig")));
            } catch (java.lang.Throwable unused) {
            }
            try {
                java.io.File file = new java.io.File(context.getFilesDir(), cn.fly.verify.em.a);
                if (!file.exists()) {
                    byte[] decode = android.util.Base64.decode("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", 2);
                    try {
                        fileOutputStream = new java.io.FileOutputStream(file);
                    } catch (java.lang.Throwable th) {
                        th = th;
                    }
                    try {
                        fileOutputStream.write(decode);
                        cn.fly.verify.dw.a(fileOutputStream);
                        file.setReadOnly();
                    } catch (java.lang.Throwable th2) {
                        th = th2;
                        fileOutputStream2 = fileOutputStream;
                        cn.fly.verify.dw.a(fileOutputStream2);
                        throw th;
                    }
                }
                java.lang.Class cls = (java.lang.Class) cn.fly.verify.fp.a(cn.fly.verify.fp.a(cn.fly.verify.fp.a(cn.fly.verify.bj.a("0214edAeh+eeejemgegielgi!jg*eggeglXgWfdgmejHhg")), file), cn.fly.verify.bj.a("009h feUe]edhlTheIgigi"), new java.lang.Object[]{cn.fly.verify.bj.a("026d3feeggeegedgeRdejLgegfejTfNed2gFekgegkejgjej8f)ed gAek"), null}, (java.lang.Class<?>[]) new java.lang.Class[]{java.lang.String.class, java.lang.ClassLoader.class});
                java.lang.reflect.Method declaredMethod = cls.getDeclaredMethod(cn.fly.verify.bj.a("014gHfd,g egMkjKejfeHfQgigkfmhmfj"), java.lang.String[].class);
                this.a = declaredMethod;
                declaredMethod.setAccessible(true);
                java.lang.reflect.Method declaredMethod2 = cls.getDeclaredMethod(cn.fly.verify.bj.a("010_ejQfZeefeem$gYgkfmhmfj"), java.lang.Class.class, java.lang.Object.class, java.lang.String.class, java.lang.Class[].class, java.lang.Object[].class);
                this.b = declaredMethod2;
                declaredMethod2.setAccessible(true);
                java.lang.reflect.Method declaredMethod3 = cls.getDeclaredMethod(cn.fly.verify.bj.a("010.ej0f4eefeemHg'gkfmhmfj"), java.lang.String.class, java.lang.Object.class, java.lang.String.class, java.lang.Class[].class, java.lang.Object[].class);
                this.c = declaredMethod3;
                declaredMethod3.setAccessible(true);
                java.lang.reflect.Method declaredMethod4 = cls.getDeclaredMethod(cn.fly.verify.bj.a("012fg<gggkfj8fJgi2jefdg"), java.lang.String.class);
                this.d = declaredMethod4;
                declaredMethod4.setAccessible(true);
                java.lang.reflect.Method declaredMethod5 = cls.getDeclaredMethod(cn.fly.verify.bj.a("012fg2gggkfj0f(gi5jefdg"), java.lang.String.class, java.lang.Class[].class, java.lang.Object[].class);
                this.e = declaredMethod5;
                declaredMethod5.setAccessible(true);
                java.lang.reflect.Method declaredMethod6 = cls.getDeclaredMethod(cn.fly.verify.bj.a("009VffDgj5gkgmej@gh6ed"), java.lang.String.class, java.lang.String.class, java.lang.Object.class);
                this.f = declaredMethod6;
                declaredMethod6.setAccessible(true);
                java.lang.reflect.Method declaredMethod7 = cls.getDeclaredMethod(cn.fly.verify.bj.a("007NffKgj=gkhlVh'hd"), java.lang.String.class);
                this.g = declaredMethod7;
                declaredMethod7.setAccessible(true);
                this.h = true;
            } catch (java.lang.Throwable unused2) {
            }
        }

        @Override // cn.fly.verify.em.a
        public <T> T a(java.lang.Class cls, java.lang.Object obj, java.lang.String str, java.lang.Class[] clsArr, java.lang.Object[] objArr) throws java.lang.Throwable {
            java.lang.reflect.Method method = this.b;
            if (method != null) {
                return (T) method.invoke(null, cls, obj, str, clsArr, objArr);
            }
            throw new java.lang.Throwable("IHA is null");
        }

        @Override // cn.fly.verify.em.a
        public <T> T a(java.lang.String str, java.lang.Object obj, java.lang.String str2, java.lang.Class[] clsArr, java.lang.Object[] objArr) throws java.lang.Throwable {
            java.lang.reflect.Method method = this.c;
            if (method != null) {
                return (T) method.invoke(null, str, obj, str2, clsArr, objArr);
            }
            throw new java.lang.Throwable("IHABC is null");
        }

        @Override // cn.fly.verify.em.a
        public <T> T a(java.lang.String str, java.lang.String str2, java.lang.Object obj) throws java.lang.Throwable {
            java.lang.reflect.Method method = this.f;
            if (method != null) {
                return (T) method.invoke(null, str, str2, obj);
            }
            throw new java.lang.Throwable("mthGetHField is null");
        }
    }

    public static class c implements cn.fly.verify.em.a {
        @Override // cn.fly.verify.em.a
        public <T> T a(java.lang.Class cls, java.lang.Object obj, java.lang.String str, java.lang.Class[] clsArr, java.lang.Object[] objArr) throws java.lang.Throwable {
            java.lang.reflect.Method method = (java.lang.reflect.Method) java.lang.Class.class.getDeclaredMethod(cn.fly.verify.bj.a("017)ff(gj_gl_gdhe+ek^gJedid_gjiPfeed"), java.lang.String.class, java.lang.Class[].class).invoke(cls, str, clsArr);
            method.setAccessible(true);
            return (T) method.invoke(obj, objArr);
        }

        @Override // cn.fly.verify.em.a
        public <T> T a(java.lang.String str, java.lang.Object obj, java.lang.String str2, java.lang.Class[] clsArr, java.lang.Object[] objArr) throws java.lang.Throwable {
            return (T) a((java.lang.Class) java.lang.Class.class.getDeclaredMethod(cn.fly.verify.bj.a("007RfgfeekfiLeAegGg"), java.lang.String.class).invoke(null, str), obj, str2, clsArr, objArr);
        }

        @Override // cn.fly.verify.em.a
        public <T> T a(java.lang.String str, java.lang.String str2, java.lang.Object obj) throws java.lang.Throwable {
            java.lang.reflect.Field field = (java.lang.reflect.Field) java.lang.Class.class.getDeclaredMethod(cn.fly.verify.bj.a("016Fff%gjSgl!gdhe7ekEg@edgmej+gh%ed"), java.lang.String.class).invoke((java.lang.Class) java.lang.Class.class.getDeclaredMethod(cn.fly.verify.bj.a("007Ffgfeekfi*eYeg'g"), java.lang.String.class).invoke(null, str), str2);
            field.setAccessible(true);
            return (T) field.get(obj);
        }
    }

    private em(android.content.Context context, int i) {
        if (i < 30 || android.os.Build.VERSION.SDK_INT < 30) {
            this.c = new cn.fly.verify.em.c();
        } else {
            this.c = new cn.fly.verify.em.b(context);
        }
    }

    public static synchronized cn.fly.verify.em a(android.content.Context context) {
        cn.fly.verify.em emVar;
        synchronized (cn.fly.verify.em.class) {
            if (b == null && context != null) {
                b = new cn.fly.verify.em(context, context.getApplicationInfo().targetSdkVersion);
            }
            emVar = b;
        }
        return emVar;
    }

    public <T> T a(java.lang.Class cls, java.lang.Object obj, java.lang.String str, java.lang.Class[] clsArr, java.lang.Object[] objArr) throws java.lang.Throwable {
        return (T) this.c.a(cls, obj, str, clsArr, objArr);
    }

    public <T> T a(java.lang.String str, java.lang.Object obj, java.lang.String str2, java.lang.Class[] clsArr, java.lang.Object[] objArr) throws java.lang.Throwable {
        return (T) this.c.a(str, obj, str2, clsArr, objArr);
    }

    public <T> T a(java.lang.String str, java.lang.String str2, java.lang.Object obj) throws java.lang.Throwable {
        return (T) this.c.a(str, str2, obj);
    }

    public boolean b(android.content.Context context) {
        if (!this.d) {
            try {
                java.io.File file = new java.io.File(context.getFilesDir(), a);
                if (file.exists()) {
                    this.d = file.delete();
                }
            } catch (java.lang.Throwable unused) {
            }
        }
        return this.d;
    }
}
