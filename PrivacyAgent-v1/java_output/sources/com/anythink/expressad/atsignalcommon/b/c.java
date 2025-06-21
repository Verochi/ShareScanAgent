package com.anythink.expressad.atsignalcommon.b;

/* loaded from: classes12.dex */
public final class c {
    private static com.anythink.expressad.atsignalcommon.b.c.a a;

    public interface a {
        boolean a();
    }

    public static abstract class b {

        public static class a extends java.lang.Throwable {
            private static final long d = 1;
            private java.lang.Class<?> a;
            private java.lang.String b;
            private java.lang.String c;

            public a(java.lang.Exception exc) {
                super(exc);
            }

            public a(java.lang.String str) {
                super(str);
            }

            public final java.lang.Class<?> a() {
                return this.a;
            }

            public final void a(java.lang.Class<?> cls) {
                this.a = cls;
            }

            public final void a(java.lang.String str) {
                this.c = str;
            }

            public final java.lang.String b() {
                return this.c;
            }

            public final void b(java.lang.String str) {
                this.b = str;
            }

            public final java.lang.String c() {
                return this.b;
            }

            @Override // java.lang.Throwable
            public final java.lang.String toString() {
                if (getCause() == null) {
                    return super.toString();
                }
                return com.anythink.expressad.atsignalcommon.b.c.b.a.class.getName() + ": " + getCause();
            }
        }
    }

    /* renamed from: com.anythink.expressad.atsignalcommon.b.c$c, reason: collision with other inner class name */
    public static class C0180c<C> {
        protected java.lang.Class<C> a;

        public C0180c(java.lang.Class<C> cls) {
            this.a = cls;
        }

        private com.anythink.expressad.atsignalcommon.b.c.d a(java.lang.Class<?>... clsArr) {
            return new com.anythink.expressad.atsignalcommon.b.c.d(this.a, clsArr);
        }

        private com.anythink.expressad.atsignalcommon.b.c.e<C, java.lang.Object> a(java.lang.String str) {
            return new com.anythink.expressad.atsignalcommon.b.c.e<>(this.a, str, 8);
        }

        private java.lang.Class<C> a() {
            return this.a;
        }

        private com.anythink.expressad.atsignalcommon.b.c.e<C, java.lang.Object> b(java.lang.String str) {
            return new com.anythink.expressad.atsignalcommon.b.c.e<>(this.a, str, 0);
        }

        private com.anythink.expressad.atsignalcommon.b.c.f b(java.lang.String str, java.lang.Class<?>... clsArr) {
            return new com.anythink.expressad.atsignalcommon.b.c.f(this.a, str, clsArr, 8);
        }

        public final com.anythink.expressad.atsignalcommon.b.c.f a(java.lang.String str, java.lang.Class<?>... clsArr) {
            return new com.anythink.expressad.atsignalcommon.b.c.f(this.a, str, clsArr, 0);
        }
    }

    public static class d {
        protected java.lang.reflect.Constructor<?> a;

        public d(java.lang.Class<?> cls, java.lang.Class<?>[] clsArr) {
            if (cls == null) {
                return;
            }
            try {
                this.a = cls.getDeclaredConstructor(clsArr);
            } catch (java.lang.NoSuchMethodException e) {
                com.anythink.expressad.atsignalcommon.b.c.b.a aVar = new com.anythink.expressad.atsignalcommon.b.c.b.a(e);
                aVar.a(cls);
                com.anythink.expressad.atsignalcommon.b.c.b(aVar);
            }
        }

        private java.lang.Object a(java.lang.Object... objArr) {
            this.a.setAccessible(true);
            try {
                return this.a.newInstance(objArr);
            } catch (java.lang.Exception e) {
                e.printStackTrace();
                return null;
            }
        }
    }

    public static class e<C, T> {
        private java.lang.Object a;
        private final java.lang.reflect.Field b;

        public e(java.lang.Class<C> cls, java.lang.String str, int i) {
            java.lang.reflect.Field field = null;
            if (cls == null) {
                return;
            }
            try {
                this.a = null;
                field = cls.getDeclaredField(str);
                if (i > 0 && (field.getModifiers() & i) != i) {
                    com.anythink.expressad.atsignalcommon.b.c.b(new com.anythink.expressad.atsignalcommon.b.c.b.a(field + " does not match modifiers: " + i));
                }
                field.setAccessible(true);
            } catch (java.lang.NoSuchFieldException e) {
                com.anythink.expressad.atsignalcommon.b.c.b.a aVar = new com.anythink.expressad.atsignalcommon.b.c.b.a(e);
                aVar.a((java.lang.Class<?>) cls);
                aVar.b(str);
                com.anythink.expressad.atsignalcommon.b.c.b(aVar);
            } finally {
                this.b = field;
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        private <T2> com.anythink.expressad.atsignalcommon.b.c.e<C, T2> a(java.lang.Class<?> cls) {
            java.lang.reflect.Field field = this.b;
            if (field != null && !cls.isAssignableFrom(field.getType())) {
                com.anythink.expressad.atsignalcommon.b.c.b(new com.anythink.expressad.atsignalcommon.b.c.b.a(new java.lang.ClassCastException(this.b + " is not of type " + cls)));
            }
            return this;
        }

        private com.anythink.expressad.atsignalcommon.b.c.e<C, T> a(java.lang.String str) {
            try {
                java.lang.Class<?> cls = java.lang.Class.forName(str);
                java.lang.reflect.Field field = this.b;
                if (field != null && !cls.isAssignableFrom(field.getType())) {
                    com.anythink.expressad.atsignalcommon.b.c.b(new com.anythink.expressad.atsignalcommon.b.c.b.a(new java.lang.ClassCastException(this.b + " is not of type " + cls)));
                }
                return this;
            } catch (java.lang.ClassNotFoundException e) {
                com.anythink.expressad.atsignalcommon.b.c.b(new com.anythink.expressad.atsignalcommon.b.c.b.a(e));
                return this;
            }
        }

        private T a() {
            try {
                return (T) this.b.get(this.a);
            } catch (java.lang.IllegalAccessException e) {
                e.printStackTrace();
                return null;
            }
        }

        private void a(com.anythink.expressad.atsignalcommon.b.b.AbstractC0179b<?> abstractC0179b) {
            T a = a();
            if (a == null) {
                throw new java.lang.IllegalStateException("Cannot mapping null");
            }
            try {
                this.b.set(this.a, com.anythink.expressad.atsignalcommon.b.b.a(a, abstractC0179b, a.getClass().getInterfaces()));
            } catch (java.lang.IllegalAccessException e) {
                e.printStackTrace();
            }
        }

        private void a(java.lang.Object obj) {
            try {
                this.b.set(this.a, obj);
            } catch (java.lang.IllegalAccessException e) {
                e.printStackTrace();
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        private <T2> com.anythink.expressad.atsignalcommon.b.c.e<C, T2> b(java.lang.Class<T2> cls) {
            java.lang.reflect.Field field = this.b;
            if (field != null && !cls.isAssignableFrom(field.getType())) {
                com.anythink.expressad.atsignalcommon.b.c.b(new com.anythink.expressad.atsignalcommon.b.c.b.a(new java.lang.ClassCastException(this.b + " is not of type " + cls)));
            }
            return this;
        }

        private com.anythink.expressad.atsignalcommon.b.c.e<C, T> b(C c) {
            this.a = c;
            return this;
        }

        private java.lang.reflect.Field b() {
            return this.b;
        }
    }

    public static class f {
        protected final java.lang.reflect.Method a;

        public f(java.lang.Class<?> cls, java.lang.String str, java.lang.Class<?>[] clsArr, int i) {
            java.lang.reflect.Method method = null;
            if (cls == null) {
                return;
            }
            try {
                method = cls.getDeclaredMethod(str, clsArr);
                if (i > 0 && (method.getModifiers() & i) != i) {
                    com.anythink.expressad.atsignalcommon.b.c.b(new com.anythink.expressad.atsignalcommon.b.c.b.a(method + " does not match modifiers: " + i));
                }
                method.setAccessible(true);
            } catch (java.lang.NoSuchMethodException e) {
                com.anythink.expressad.atsignalcommon.b.c.b.a aVar = new com.anythink.expressad.atsignalcommon.b.c.b.a(e);
                aVar.a(cls);
                aVar.a(str);
                com.anythink.expressad.atsignalcommon.b.c.b(aVar);
            } finally {
                this.a = method;
            }
        }

        public final java.lang.Object a(java.lang.Object obj, java.lang.Object... objArr) {
            try {
                return this.a.invoke(obj, objArr);
            } catch (java.lang.IllegalAccessException e) {
                e.printStackTrace();
                return null;
            }
        }

        public final java.lang.reflect.Method a() {
            return this.a;
        }
    }

    private c() {
    }

    private static <T> com.anythink.expressad.atsignalcommon.b.c.C0180c<T> a(java.lang.Class<T> cls) {
        return new com.anythink.expressad.atsignalcommon.b.c.C0180c<>(cls);
    }

    public static <T> com.anythink.expressad.atsignalcommon.b.c.C0180c<T> a(java.lang.ClassLoader classLoader, java.lang.String str) {
        try {
            return new com.anythink.expressad.atsignalcommon.b.c.C0180c<>(classLoader.loadClass(str));
        } catch (java.lang.Exception e2) {
            b(new com.anythink.expressad.atsignalcommon.b.c.b.a(e2));
            return new com.anythink.expressad.atsignalcommon.b.c.C0180c<>(null);
        }
    }

    private static <T> com.anythink.expressad.atsignalcommon.b.c.C0180c<T> a(java.lang.String str) {
        try {
            return new com.anythink.expressad.atsignalcommon.b.c.C0180c<>(java.lang.Class.forName(str));
        } catch (java.lang.ClassNotFoundException e2) {
            b(new com.anythink.expressad.atsignalcommon.b.c.b.a(e2));
            return new com.anythink.expressad.atsignalcommon.b.c.C0180c<>(null);
        }
    }

    private static void a(com.anythink.expressad.atsignalcommon.b.c.a aVar) {
        a = aVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void b(com.anythink.expressad.atsignalcommon.b.c.b.a aVar) {
        com.anythink.expressad.atsignalcommon.b.c.a aVar2 = a;
        if (aVar2 == null) {
            throw aVar;
        }
        if (!aVar2.a()) {
            throw aVar;
        }
    }
}
