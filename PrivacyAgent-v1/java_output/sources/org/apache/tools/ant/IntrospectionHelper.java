package org.apache.tools.ant;

/* loaded from: classes25.dex */
public final class IntrospectionHelper {
    protected static final java.lang.String NOT_SUPPORTED_CHILD_POSTFIX = "\" element.";
    protected static final java.lang.String NOT_SUPPORTED_CHILD_PREFIX = " doesn't support the nested \"";
    public static final java.util.Map<java.lang.String, org.apache.tools.ant.IntrospectionHelper> h = new java.util.Hashtable();
    public static final java.util.Map<java.lang.Class<?>, java.lang.Class<?>> i = new java.util.HashMap(8);
    public final java.util.Hashtable<java.lang.String, java.lang.Class<?>> a = new java.util.Hashtable<>();
    public final java.util.Hashtable<java.lang.String, org.apache.tools.ant.IntrospectionHelper.AttributeSetter> b = new java.util.Hashtable<>();
    public final java.util.Hashtable<java.lang.String, java.lang.Class<?>> c = new java.util.Hashtable<>();
    public final java.util.Hashtable<java.lang.String, org.apache.tools.ant.IntrospectionHelper.NestedCreator> d = new java.util.Hashtable<>();
    public final java.util.List<java.lang.reflect.Method> e = new java.util.ArrayList();
    public final java.lang.reflect.Method f;
    public final java.lang.Class<?> g;

    /* renamed from: org.apache.tools.ant.IntrospectionHelper$1, reason: invalid class name */
    public class AnonymousClass1 extends org.apache.tools.ant.IntrospectionHelper.NestedCreator {
        public final /* synthetic */ java.lang.Object b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(java.lang.reflect.Method method, java.lang.Object obj) {
            super(method);
            this.b = obj;
        }

        @Override // org.apache.tools.ant.IntrospectionHelper.NestedCreator
        public java.lang.Object b(org.apache.tools.ant.Project project, java.lang.Object obj, java.lang.Object obj2) {
            return this.b;
        }
    }

    /* renamed from: org.apache.tools.ant.IntrospectionHelper$10, reason: invalid class name */
    public class AnonymousClass10 extends org.apache.tools.ant.IntrospectionHelper.AttributeSetter {
        public final /* synthetic */ java.lang.reflect.Method c;
        public final /* synthetic */ java.lang.String d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass10(java.lang.reflect.Method method, java.lang.Class cls, java.lang.reflect.Method method2, java.lang.String str) {
            super(method, cls);
            this.c = method2;
            this.d = str;
        }

        @Override // org.apache.tools.ant.IntrospectionHelper.AttributeSetter
        public void c(org.apache.tools.ant.Project project, java.lang.Object obj, java.lang.String str) throws java.lang.reflect.InvocationTargetException, java.lang.IllegalAccessException, org.apache.tools.ant.BuildException {
            try {
                this.c.invoke(obj, new java.lang.Long(org.apache.tools.ant.util.StringUtils.parseHumanSizes(str)));
            } catch (java.lang.IllegalAccessException e) {
                throw e;
            } catch (java.lang.NumberFormatException unused) {
                throw new org.apache.tools.ant.BuildException("Can't assign non-numeric value '" + str + "' to attribute " + this.d);
            } catch (java.lang.reflect.InvocationTargetException e2) {
                throw e2;
            } catch (java.lang.Exception e3) {
                throw new org.apache.tools.ant.BuildException(e3);
            }
        }
    }

    /* renamed from: org.apache.tools.ant.IntrospectionHelper$11, reason: invalid class name */
    public class AnonymousClass11 extends org.apache.tools.ant.IntrospectionHelper.AttributeSetter {
        public final /* synthetic */ boolean c;
        public final /* synthetic */ java.lang.reflect.Constructor d;
        public final /* synthetic */ java.lang.reflect.Method e;
        public final /* synthetic */ java.lang.String f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass11(java.lang.reflect.Method method, java.lang.Class cls, boolean z, java.lang.reflect.Constructor constructor, java.lang.reflect.Method method2, java.lang.String str) {
            super(method, cls);
            this.c = z;
            this.d = constructor;
            this.e = method2;
            this.f = str;
        }

        @Override // org.apache.tools.ant.IntrospectionHelper.AttributeSetter
        public void c(org.apache.tools.ant.Project project, java.lang.Object obj, java.lang.String str) throws java.lang.reflect.InvocationTargetException, java.lang.IllegalAccessException, org.apache.tools.ant.BuildException {
            try {
                java.lang.Object newInstance = this.d.newInstance(this.c ? new java.lang.Object[]{project, str} : new java.lang.Object[]{str});
                if (project != null) {
                    project.setProjectReference(newInstance);
                }
                this.e.invoke(obj, newInstance);
            } catch (java.lang.InstantiationException e) {
                throw new org.apache.tools.ant.BuildException(e);
            } catch (java.lang.reflect.InvocationTargetException e2) {
                java.lang.Throwable cause = e2.getCause();
                if (!(cause instanceof java.lang.IllegalArgumentException)) {
                    throw e2;
                }
                throw new org.apache.tools.ant.BuildException("Can't assign value '" + str + "' to attribute " + this.f + ", reason: " + cause.getClass() + " with message '" + cause.getMessage() + "'");
            }
        }
    }

    /* renamed from: org.apache.tools.ant.IntrospectionHelper$12, reason: invalid class name */
    public class AnonymousClass12 extends org.apache.tools.ant.IntrospectionHelper.AttributeSetter {
        public final /* synthetic */ java.lang.Class c;
        public final /* synthetic */ java.lang.reflect.Method d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass12(java.lang.reflect.Method method, java.lang.Class cls, java.lang.Class cls2, java.lang.reflect.Method method2) {
            super(method, cls);
            this.c = cls2;
            this.d = method2;
        }

        @Override // org.apache.tools.ant.IntrospectionHelper.AttributeSetter
        public void c(org.apache.tools.ant.Project project, java.lang.Object obj, java.lang.String str) throws java.lang.reflect.InvocationTargetException, java.lang.IllegalAccessException, org.apache.tools.ant.BuildException {
            try {
                this.d.invoke(obj, java.lang.Enum.valueOf(this.c, str));
            } catch (java.lang.IllegalArgumentException unused) {
                throw new org.apache.tools.ant.BuildException("'" + str + "' is not a permitted value for " + this.c.getName());
            }
        }
    }

    /* renamed from: org.apache.tools.ant.IntrospectionHelper$13, reason: invalid class name */
    public class AnonymousClass13 extends org.apache.tools.ant.IntrospectionHelper.NestedCreator {
        public final /* synthetic */ java.lang.Object b;
        public final /* synthetic */ java.lang.Object c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass13(java.lang.reflect.Method method, java.lang.Object obj, java.lang.Object obj2) {
            super(method);
            this.b = obj;
            this.c = obj2;
        }

        @Override // org.apache.tools.ant.IntrospectionHelper.NestedCreator
        public java.lang.Object b(org.apache.tools.ant.Project project, java.lang.Object obj, java.lang.Object obj2) throws java.lang.reflect.InvocationTargetException, java.lang.IllegalAccessException {
            if (!c().getName().endsWith("Configured")) {
                c().invoke(obj, this.b);
            }
            return this.c;
        }

        @Override // org.apache.tools.ant.IntrospectionHelper.NestedCreator
        public java.lang.Object d() {
            return this.b;
        }

        @Override // org.apache.tools.ant.IntrospectionHelper.NestedCreator
        public void f(java.lang.Object obj, java.lang.Object obj2) throws java.lang.reflect.InvocationTargetException, java.lang.IllegalAccessException, java.lang.InstantiationException {
            if (c().getName().endsWith("Configured")) {
                c().invoke(obj, this.b);
            }
        }
    }

    /* renamed from: org.apache.tools.ant.IntrospectionHelper$2, reason: invalid class name */
    public class AnonymousClass2 extends org.apache.tools.ant.IntrospectionHelper.AttributeSetter {
        public AnonymousClass2(java.lang.reflect.Method method, java.lang.Class cls) {
            super(method, cls);
        }

        @Override // org.apache.tools.ant.IntrospectionHelper.AttributeSetter
        public void c(org.apache.tools.ant.Project project, java.lang.Object obj, java.lang.String str) throws java.lang.reflect.InvocationTargetException, java.lang.IllegalAccessException {
            throw new org.apache.tools.ant.BuildException("Internal ant problem - this should not get called");
        }
    }

    /* renamed from: org.apache.tools.ant.IntrospectionHelper$3, reason: invalid class name */
    public class AnonymousClass3 extends org.apache.tools.ant.IntrospectionHelper.AttributeSetter {
        public final /* synthetic */ java.lang.reflect.Method c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass3(java.lang.reflect.Method method, java.lang.Class cls, java.lang.reflect.Method method2) {
            super(method, cls);
            this.c = method2;
        }

        @Override // org.apache.tools.ant.IntrospectionHelper.AttributeSetter
        public void c(org.apache.tools.ant.Project project, java.lang.Object obj, java.lang.String str) throws java.lang.reflect.InvocationTargetException, java.lang.IllegalAccessException {
            this.c.invoke(obj, str);
        }
    }

    /* renamed from: org.apache.tools.ant.IntrospectionHelper$4, reason: invalid class name */
    public class AnonymousClass4 extends org.apache.tools.ant.IntrospectionHelper.AttributeSetter {
        public final /* synthetic */ java.lang.String c;
        public final /* synthetic */ java.lang.reflect.Method d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass4(java.lang.reflect.Method method, java.lang.Class cls, java.lang.String str, java.lang.reflect.Method method2) {
            super(method, cls);
            this.c = str;
            this.d = method2;
        }

        @Override // org.apache.tools.ant.IntrospectionHelper.AttributeSetter
        public void c(org.apache.tools.ant.Project project, java.lang.Object obj, java.lang.String str) throws java.lang.reflect.InvocationTargetException, java.lang.IllegalAccessException {
            if (str.length() != 0) {
                this.d.invoke(obj, new java.lang.Character(str.charAt(0)));
                return;
            }
            throw new org.apache.tools.ant.BuildException("The value \"\" is not a legal value for attribute \"" + this.c + "\"");
        }
    }

    /* renamed from: org.apache.tools.ant.IntrospectionHelper$5, reason: invalid class name */
    public class AnonymousClass5 extends org.apache.tools.ant.IntrospectionHelper.AttributeSetter {
        public final /* synthetic */ java.lang.reflect.Method c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass5(java.lang.reflect.Method method, java.lang.Class cls, java.lang.reflect.Method method2) {
            super(method, cls);
            this.c = method2;
        }

        @Override // org.apache.tools.ant.IntrospectionHelper.AttributeSetter
        public void c(org.apache.tools.ant.Project project, java.lang.Object obj, java.lang.String str) throws java.lang.reflect.InvocationTargetException, java.lang.IllegalAccessException {
            java.lang.reflect.Method method = this.c;
            java.lang.Boolean[] boolArr = new java.lang.Boolean[1];
            boolArr[0] = org.apache.tools.ant.Project.toBoolean(str) ? java.lang.Boolean.TRUE : java.lang.Boolean.FALSE;
            method.invoke(obj, boolArr);
        }
    }

    /* renamed from: org.apache.tools.ant.IntrospectionHelper$6, reason: invalid class name */
    public class AnonymousClass6 extends org.apache.tools.ant.IntrospectionHelper.AttributeSetter {
        public final /* synthetic */ java.lang.reflect.Method c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass6(java.lang.reflect.Method method, java.lang.Class cls, java.lang.reflect.Method method2) {
            super(method, cls);
            this.c = method2;
        }

        @Override // org.apache.tools.ant.IntrospectionHelper.AttributeSetter
        public void c(org.apache.tools.ant.Project project, java.lang.Object obj, java.lang.String str) throws java.lang.reflect.InvocationTargetException, java.lang.IllegalAccessException, org.apache.tools.ant.BuildException {
            try {
                this.c.invoke(obj, java.lang.Class.forName(str));
            } catch (java.lang.ClassNotFoundException e) {
                throw new org.apache.tools.ant.BuildException(e);
            }
        }
    }

    /* renamed from: org.apache.tools.ant.IntrospectionHelper$7, reason: invalid class name */
    public class AnonymousClass7 extends org.apache.tools.ant.IntrospectionHelper.AttributeSetter {
        public final /* synthetic */ java.lang.reflect.Method c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass7(java.lang.reflect.Method method, java.lang.Class cls, java.lang.reflect.Method method2) {
            super(method, cls);
            this.c = method2;
        }

        @Override // org.apache.tools.ant.IntrospectionHelper.AttributeSetter
        public void c(org.apache.tools.ant.Project project, java.lang.Object obj, java.lang.String str) throws java.lang.reflect.InvocationTargetException, java.lang.IllegalAccessException {
            this.c.invoke(obj, project.resolveFile(str));
        }
    }

    /* renamed from: org.apache.tools.ant.IntrospectionHelper$8, reason: invalid class name */
    public class AnonymousClass8 extends org.apache.tools.ant.IntrospectionHelper.AttributeSetter {
        public final /* synthetic */ java.lang.reflect.Method c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass8(java.lang.reflect.Method method, java.lang.Class cls, java.lang.reflect.Method method2) {
            super(method, cls);
            this.c = method2;
        }

        @Override // org.apache.tools.ant.IntrospectionHelper.AttributeSetter
        public void c(org.apache.tools.ant.Project project, java.lang.Object obj, java.lang.String str) throws java.lang.reflect.InvocationTargetException, java.lang.IllegalAccessException, org.apache.tools.ant.BuildException {
            this.c.invoke(obj, new org.apache.tools.ant.types.resources.FileResource(project, project.resolveFile(str)));
        }
    }

    /* renamed from: org.apache.tools.ant.IntrospectionHelper$9, reason: invalid class name */
    public class AnonymousClass9 extends org.apache.tools.ant.IntrospectionHelper.AttributeSetter {
        public final /* synthetic */ java.lang.Class c;
        public final /* synthetic */ java.lang.reflect.Method d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass9(java.lang.reflect.Method method, java.lang.Class cls, java.lang.Class cls2, java.lang.reflect.Method method2) {
            super(method, cls);
            this.c = cls2;
            this.d = method2;
        }

        @Override // org.apache.tools.ant.IntrospectionHelper.AttributeSetter
        public void c(org.apache.tools.ant.Project project, java.lang.Object obj, java.lang.String str) throws java.lang.reflect.InvocationTargetException, java.lang.IllegalAccessException, org.apache.tools.ant.BuildException {
            try {
                org.apache.tools.ant.types.EnumeratedAttribute enumeratedAttribute = (org.apache.tools.ant.types.EnumeratedAttribute) this.c.newInstance();
                enumeratedAttribute.setValue(str);
                this.d.invoke(obj, enumeratedAttribute);
            } catch (java.lang.InstantiationException e) {
                throw new org.apache.tools.ant.BuildException(e);
            }
        }
    }

    public static class AddNestedCreator extends org.apache.tools.ant.IntrospectionHelper.NestedCreator {
        public final java.lang.reflect.Constructor<?> b;
        public final int c;

        public AddNestedCreator(java.lang.reflect.Method method, java.lang.reflect.Constructor<?> constructor, int i) {
            super(method);
            this.b = constructor;
            this.c = i;
        }

        @Override // org.apache.tools.ant.IntrospectionHelper.NestedCreator
        public java.lang.Object b(org.apache.tools.ant.Project project, java.lang.Object obj, java.lang.Object obj2) throws java.lang.reflect.InvocationTargetException, java.lang.IllegalAccessException, java.lang.InstantiationException {
            if (obj2 == null) {
                java.lang.reflect.Constructor<?> constructor = this.b;
                obj2 = constructor.newInstance(constructor.getParameterTypes().length == 0 ? new java.lang.Object[0] : new java.lang.Object[]{project});
            }
            if (obj2 instanceof org.apache.tools.ant.taskdefs.PreSetDef.PreSetDefinition) {
                obj2 = ((org.apache.tools.ant.taskdefs.PreSetDef.PreSetDefinition) obj2).createObject(project);
            }
            if (this.c == 1) {
                g(obj, obj2);
            }
            return obj2;
        }

        @Override // org.apache.tools.ant.IntrospectionHelper.NestedCreator
        public boolean e() {
            return true;
        }

        @Override // org.apache.tools.ant.IntrospectionHelper.NestedCreator
        public void f(java.lang.Object obj, java.lang.Object obj2) throws java.lang.reflect.InvocationTargetException, java.lang.IllegalAccessException, java.lang.InstantiationException {
            if (this.c == 2) {
                g(obj, obj2);
            }
        }

        public final void g(java.lang.Object obj, java.lang.Object obj2) throws java.lang.reflect.InvocationTargetException, java.lang.IllegalAccessException, java.lang.InstantiationException {
            c().invoke(obj, obj2);
        }
    }

    public static abstract class AttributeSetter {
        public final java.lang.reflect.Method a;
        public final java.lang.Class<?> b;

        public AttributeSetter(java.lang.reflect.Method method, java.lang.Class<?> cls) {
            this.a = method;
            this.b = cls;
        }

        public abstract void c(org.apache.tools.ant.Project project, java.lang.Object obj, java.lang.String str) throws java.lang.reflect.InvocationTargetException, java.lang.IllegalAccessException, org.apache.tools.ant.BuildException;

        public void d(org.apache.tools.ant.Project project, java.lang.Object obj, java.lang.Object obj2) throws java.lang.reflect.InvocationTargetException, java.lang.IllegalAccessException, org.apache.tools.ant.BuildException {
            java.lang.Class<?> cls = this.b;
            if (cls != null) {
                if (cls.isPrimitive()) {
                    if (obj2 == null) {
                        throw new org.apache.tools.ant.BuildException("Attempt to set primitive " + org.apache.tools.ant.IntrospectionHelper.p(this.a.getName(), "set") + " to null on " + obj);
                    }
                    cls = (java.lang.Class) org.apache.tools.ant.IntrospectionHelper.i.get(this.b);
                }
                if (obj2 == null || cls.isInstance(obj2)) {
                    this.a.invoke(obj, obj2);
                    return;
                }
            }
            c(project, obj, obj2.toString());
        }
    }

    public static class CreateNestedCreator extends org.apache.tools.ant.IntrospectionHelper.NestedCreator {
        public CreateNestedCreator(java.lang.reflect.Method method) {
            super(method);
        }

        @Override // org.apache.tools.ant.IntrospectionHelper.NestedCreator
        public java.lang.Object b(org.apache.tools.ant.Project project, java.lang.Object obj, java.lang.Object obj2) throws java.lang.reflect.InvocationTargetException, java.lang.IllegalAccessException {
            return c().invoke(obj, new java.lang.Object[0]);
        }
    }

    public static final class Creator {
        public final org.apache.tools.ant.IntrospectionHelper.NestedCreator a;
        public final java.lang.Object b;
        public final org.apache.tools.ant.Project c;
        public java.lang.Object d;
        public java.lang.String e;

        public Creator(org.apache.tools.ant.Project project, java.lang.Object obj, org.apache.tools.ant.IntrospectionHelper.NestedCreator nestedCreator) {
            this.c = project;
            this.b = obj;
            this.a = nestedCreator;
        }

        public /* synthetic */ Creator(org.apache.tools.ant.Project project, java.lang.Object obj, org.apache.tools.ant.IntrospectionHelper.NestedCreator nestedCreator, org.apache.tools.ant.IntrospectionHelper.AnonymousClass1 anonymousClass1) {
            this(project, obj, nestedCreator);
        }

        public java.lang.Object create() {
            if (this.e != null) {
                if (!this.a.e()) {
                    throw new org.apache.tools.ant.BuildException("Not allowed to use the polymorphic form for this element");
                }
                java.lang.Object createComponent = org.apache.tools.ant.ComponentHelper.getComponentHelper(this.c).createComponent(this.e);
                this.d = createComponent;
                if (createComponent == null) {
                    throw new org.apache.tools.ant.BuildException("Unable to create object of type " + this.e);
                }
            }
            try {
                java.lang.Object b = this.a.b(this.c, this.b, this.d);
                this.d = b;
                org.apache.tools.ant.Project project = this.c;
                if (project != null) {
                    project.setProjectReference(b);
                }
                return this.d;
            } catch (java.lang.IllegalAccessException e) {
                throw new org.apache.tools.ant.BuildException(e);
            } catch (java.lang.IllegalArgumentException e2) {
                if (this.e == null) {
                    throw e2;
                }
                throw new org.apache.tools.ant.BuildException("Invalid type used " + this.e);
            } catch (java.lang.InstantiationException e3) {
                throw new org.apache.tools.ant.BuildException(e3);
            } catch (java.lang.reflect.InvocationTargetException e4) {
                throw org.apache.tools.ant.IntrospectionHelper.j(e4);
            }
        }

        public java.lang.Object getRealObject() {
            return this.a.d();
        }

        public void setPolyType(java.lang.String str) {
            this.e = str;
        }

        public void store() {
            try {
                this.a.f(this.b, this.d);
            } catch (java.lang.IllegalAccessException e) {
                throw new org.apache.tools.ant.BuildException(e);
            } catch (java.lang.IllegalArgumentException e2) {
                if (this.e == null) {
                    throw e2;
                }
                throw new org.apache.tools.ant.BuildException("Invalid type used " + this.e);
            } catch (java.lang.InstantiationException e3) {
                throw new org.apache.tools.ant.BuildException(e3);
            } catch (java.lang.reflect.InvocationTargetException e4) {
                throw org.apache.tools.ant.IntrospectionHelper.j(e4);
            }
        }
    }

    public static class MethodAndObject {
        public final java.lang.reflect.Method a;
        public final java.lang.Object b;

        public MethodAndObject(java.lang.reflect.Method method, java.lang.Object obj) {
            this.a = method;
            this.b = obj;
        }
    }

    public static abstract class NestedCreator {
        public final java.lang.reflect.Method a;

        public NestedCreator(java.lang.reflect.Method method) {
            this.a = method;
        }

        public abstract java.lang.Object b(org.apache.tools.ant.Project project, java.lang.Object obj, java.lang.Object obj2) throws java.lang.reflect.InvocationTargetException, java.lang.IllegalAccessException, java.lang.InstantiationException;

        public java.lang.reflect.Method c() {
            return this.a;
        }

        public java.lang.Object d() {
            return null;
        }

        public boolean e() {
            return false;
        }

        public void f(java.lang.Object obj, java.lang.Object obj2) throws java.lang.reflect.InvocationTargetException, java.lang.IllegalAccessException, java.lang.InstantiationException {
        }
    }

    static {
        java.lang.Class<?>[] clsArr = {java.lang.Boolean.TYPE, java.lang.Byte.TYPE, java.lang.Character.TYPE, java.lang.Short.TYPE, java.lang.Integer.TYPE, java.lang.Long.TYPE, java.lang.Float.TYPE, java.lang.Double.TYPE};
        java.lang.Class<?>[] clsArr2 = {java.lang.Boolean.class, java.lang.Byte.class, java.lang.Character.class, java.lang.Short.class, java.lang.Integer.class, java.lang.Long.class, java.lang.Float.class, java.lang.Double.class};
        for (int i2 = 0; i2 < 8; i2++) {
            i.put(clsArr[i2], clsArr2[i2]);
        }
    }

    public IntrospectionHelper(java.lang.Class<?> cls) {
        java.lang.reflect.Constructor<?> constructor;
        java.lang.reflect.Constructor<?> constructor2;
        char c;
        this.g = cls;
        java.lang.reflect.Method[] methods = cls.getMethods();
        int length = methods.length;
        java.lang.reflect.Method method = null;
        char c2 = 0;
        int i2 = 0;
        while (i2 < length) {
            java.lang.reflect.Method method2 = methods[i2];
            java.lang.String name = method2.getName();
            java.lang.Class<?> returnType = method2.getReturnType();
            java.lang.Class<?>[] parameterTypes = method2.getParameterTypes();
            if (parameterTypes.length == 1 && java.lang.Void.TYPE.equals(returnType) && (com.anythink.expressad.d.a.b.ay.equals(name) || "addConfigured".equals(name))) {
                q(method2);
            } else if ((!org.apache.tools.ant.ProjectComponent.class.isAssignableFrom(cls) || parameterTypes.length != 1 || !r(name, parameterTypes[c2])) && (!isContainer() || parameterTypes.length != 1 || !"addTask".equals(name) || !org.apache.tools.ant.Task.class.equals(parameterTypes[c2]))) {
                if ("addText".equals(name) && java.lang.Void.TYPE.equals(returnType) && parameterTypes.length == 1 && java.lang.String.class.equals(parameterTypes[c2])) {
                    method = method2;
                } else {
                    if (name.startsWith("set") && java.lang.Void.TYPE.equals(returnType) && parameterTypes.length == 1) {
                        if (!parameterTypes[0].isArray()) {
                            java.lang.String p = p(name, "set");
                            org.apache.tools.ant.IntrospectionHelper.AttributeSetter attributeSetter = this.b.get(p);
                            if (attributeSetter != null) {
                                c = (java.lang.String.class.equals(parameterTypes[0]) || (java.io.File.class.equals(parameterTypes[0]) && (org.apache.tools.ant.types.Resource.class.equals(attributeSetter.b) || org.apache.tools.ant.types.resources.FileProvider.class.equals(attributeSetter.b)))) ? (char) 0 : (char) 0;
                            }
                            org.apache.tools.ant.IntrospectionHelper.AttributeSetter f = f(method2, parameterTypes[c], p);
                            if (f != null) {
                                this.a.put(p, parameterTypes[c]);
                                this.b.put(p, f);
                            }
                        }
                    }
                    if (name.startsWith("create") && !returnType.isArray() && !returnType.isPrimitive() && parameterTypes.length == 0) {
                        java.lang.String p2 = p(name, "create");
                        if (this.d.get(p2) == null) {
                            this.c.put(p2, returnType);
                            this.d.put(p2, new org.apache.tools.ant.IntrospectionHelper.CreateNestedCreator(method2));
                        }
                    } else if (name.startsWith("addConfigured") && java.lang.Void.TYPE.equals(returnType) && parameterTypes.length == 1 && !java.lang.String.class.equals(parameterTypes[0]) && !parameterTypes[0].isArray() && !parameterTypes[0].isPrimitive()) {
                        try {
                            try {
                                constructor2 = parameterTypes[0].getConstructor(new java.lang.Class[0]);
                            } catch (java.lang.NoSuchMethodException unused) {
                                constructor2 = parameterTypes[0].getConstructor(org.apache.tools.ant.Project.class);
                            }
                            java.lang.String p3 = p(name, "addConfigured");
                            this.c.put(p3, parameterTypes[0]);
                            this.d.put(p3, new org.apache.tools.ant.IntrospectionHelper.AddNestedCreator(method2, constructor2, 2));
                        } catch (java.lang.NoSuchMethodException unused2) {
                        }
                    } else if (name.startsWith(com.anythink.expressad.d.a.b.ay) && java.lang.Void.TYPE.equals(returnType) && parameterTypes.length == 1 && !java.lang.String.class.equals(parameterTypes[0]) && !parameterTypes[0].isArray() && !parameterTypes[0].isPrimitive()) {
                        try {
                            constructor = parameterTypes[0].getConstructor(new java.lang.Class[0]);
                        } catch (java.lang.NoSuchMethodException unused3) {
                            constructor = parameterTypes[0].getConstructor(org.apache.tools.ant.Project.class);
                        }
                        java.lang.String p4 = p(name, com.anythink.expressad.d.a.b.ay);
                        if (this.c.get(p4) == null) {
                            try {
                                this.c.put(p4, parameterTypes[0]);
                                this.d.put(p4, new org.apache.tools.ant.IntrospectionHelper.AddNestedCreator(method2, constructor, 1));
                            } catch (java.lang.NoSuchMethodException unused4) {
                            }
                            i2++;
                            c2 = 0;
                        }
                    }
                }
            }
            i2++;
            c2 = 0;
        }
        this.f = method;
    }

    public static synchronized void clearCache() {
        synchronized (org.apache.tools.ant.IntrospectionHelper.class) {
            h.clear();
        }
    }

    public static synchronized org.apache.tools.ant.IntrospectionHelper getHelper(java.lang.Class<?> cls) {
        org.apache.tools.ant.IntrospectionHelper helper;
        synchronized (org.apache.tools.ant.IntrospectionHelper.class) {
            helper = getHelper(null, cls);
        }
        return helper;
    }

    public static synchronized org.apache.tools.ant.IntrospectionHelper getHelper(org.apache.tools.ant.Project project, java.lang.Class<?> cls) {
        org.apache.tools.ant.IntrospectionHelper introspectionHelper;
        synchronized (org.apache.tools.ant.IntrospectionHelper.class) {
            java.util.Map<java.lang.String, org.apache.tools.ant.IntrospectionHelper> map = h;
            introspectionHelper = map.get(cls.getName());
            if (introspectionHelper == null || introspectionHelper.g != cls) {
                introspectionHelper = new org.apache.tools.ant.IntrospectionHelper(cls);
                if (project != null) {
                    map.put(cls.getName(), introspectionHelper);
                }
            }
        }
        return introspectionHelper;
    }

    public static org.apache.tools.ant.BuildException j(java.lang.reflect.InvocationTargetException invocationTargetException) {
        java.lang.Throwable targetException = invocationTargetException.getTargetException();
        return targetException instanceof org.apache.tools.ant.BuildException ? (org.apache.tools.ant.BuildException) targetException : new org.apache.tools.ant.BuildException(targetException);
    }

    public static java.lang.String p(java.lang.String str, java.lang.String str2) {
        return str.substring(str2.length()).toLowerCase(java.util.Locale.ENGLISH);
    }

    public void addText(org.apache.tools.ant.Project project, java.lang.Object obj, java.lang.String str) throws org.apache.tools.ant.BuildException {
        java.lang.reflect.Method method = this.f;
        if (method != null) {
            try {
                method.invoke(obj, str);
                return;
            } catch (java.lang.IllegalAccessException e) {
                throw new org.apache.tools.ant.BuildException(e);
            } catch (java.lang.reflect.InvocationTargetException e2) {
                throw j(e2);
            }
        }
        java.lang.String trim = str.trim();
        if (trim.length() == 0) {
            return;
        }
        throw new org.apache.tools.ant.BuildException(project.getElementName(obj) + " doesn't support nested text data (\"" + d(trim) + "\").");
    }

    @java.lang.Deprecated
    public java.lang.Object createElement(org.apache.tools.ant.Project project, java.lang.Object obj, java.lang.String str) throws org.apache.tools.ant.BuildException {
        try {
            java.lang.Object b = o(project, "", obj, str, null).b(project, obj, null);
            if (project != null) {
                project.setProjectReference(b);
            }
            return b;
        } catch (java.lang.IllegalAccessException e) {
            throw new org.apache.tools.ant.BuildException(e);
        } catch (java.lang.InstantiationException e2) {
            throw new org.apache.tools.ant.BuildException(e2);
        } catch (java.lang.reflect.InvocationTargetException e3) {
            throw j(e3);
        }
    }

    public final java.lang.String d(java.lang.String str) {
        return str.length() <= 20 ? str : new java.lang.StringBuffer(str).replace(8, str.length() - 8, "...").toString();
    }

    public final org.apache.tools.ant.IntrospectionHelper.NestedCreator e(org.apache.tools.ant.Project project, java.lang.Object obj, java.lang.String str) throws org.apache.tools.ant.BuildException {
        if (this.e.size() == 0) {
            return null;
        }
        org.apache.tools.ant.ComponentHelper componentHelper = org.apache.tools.ant.ComponentHelper.getComponentHelper(project);
        org.apache.tools.ant.IntrospectionHelper.MethodAndObject h2 = h(componentHelper, str, this.e);
        org.apache.tools.ant.IntrospectionHelper.MethodAndObject i2 = i(componentHelper, str, this.e);
        if (h2 == null && i2 == null) {
            return null;
        }
        if (h2 != null && i2 != null) {
            throw new org.apache.tools.ant.BuildException("ambiguous: type and component definitions for " + str);
        }
        if (h2 == null) {
            h2 = i2;
        }
        java.lang.Object obj2 = h2.b;
        if (h2.b instanceof org.apache.tools.ant.taskdefs.PreSetDef.PreSetDefinition) {
            obj2 = ((org.apache.tools.ant.taskdefs.PreSetDef.PreSetDefinition) h2.b).createObject(project);
        }
        return new org.apache.tools.ant.IntrospectionHelper.AnonymousClass13(h2.a, obj2, h2.b);
    }

    public final org.apache.tools.ant.IntrospectionHelper.AttributeSetter f(java.lang.reflect.Method method, java.lang.Class<?> cls, java.lang.String str) {
        java.lang.reflect.Constructor<?> constructor;
        boolean z;
        java.util.Map<java.lang.Class<?>, java.lang.Class<?>> map = i;
        java.lang.Class<?> cls2 = map.containsKey(cls) ? map.get(cls) : cls;
        if (java.lang.Object.class == cls2) {
            return new org.apache.tools.ant.IntrospectionHelper.AnonymousClass2(method, cls);
        }
        if (java.lang.String.class.equals(cls2)) {
            return new org.apache.tools.ant.IntrospectionHelper.AnonymousClass3(method, cls, method);
        }
        if (java.lang.Character.class.equals(cls2)) {
            return new org.apache.tools.ant.IntrospectionHelper.AnonymousClass4(method, cls, str, method);
        }
        if (java.lang.Boolean.class.equals(cls2)) {
            return new org.apache.tools.ant.IntrospectionHelper.AnonymousClass5(method, cls, method);
        }
        if (java.lang.Class.class.equals(cls2)) {
            return new org.apache.tools.ant.IntrospectionHelper.AnonymousClass6(method, cls, method);
        }
        if (java.io.File.class.equals(cls2)) {
            return new org.apache.tools.ant.IntrospectionHelper.AnonymousClass7(method, cls, method);
        }
        if (org.apache.tools.ant.types.Resource.class.equals(cls2) || org.apache.tools.ant.types.resources.FileProvider.class.equals(cls2)) {
            return new org.apache.tools.ant.IntrospectionHelper.AnonymousClass8(method, cls, method);
        }
        if (org.apache.tools.ant.types.EnumeratedAttribute.class.isAssignableFrom(cls2)) {
            return new org.apache.tools.ant.IntrospectionHelper.AnonymousClass9(method, cls, cls2, method);
        }
        org.apache.tools.ant.IntrospectionHelper.AttributeSetter n = n(cls2, method, cls);
        if (n != null) {
            return n;
        }
        if (java.lang.Long.class.equals(cls2)) {
            return new org.apache.tools.ant.IntrospectionHelper.AnonymousClass10(method, cls, method, str);
        }
        try {
            try {
                constructor = cls2.getConstructor(org.apache.tools.ant.Project.class, java.lang.String.class);
                z = true;
            } catch (java.lang.NoSuchMethodException unused) {
                constructor = cls2.getConstructor(java.lang.String.class);
                z = false;
            }
            return new org.apache.tools.ant.IntrospectionHelper.AnonymousClass11(method, cls, z, constructor, method, str);
        } catch (java.lang.NoSuchMethodException unused2) {
            return null;
        }
    }

    public final java.lang.Object g(java.lang.Object obj, java.lang.String str, java.lang.String str2, java.lang.String str3) {
        java.lang.Object createDynamicElement = obj instanceof org.apache.tools.ant.DynamicElementNS ? ((org.apache.tools.ant.DynamicElementNS) obj).createDynamicElement(str, str2, str3) : null;
        return (createDynamicElement == null && (obj instanceof org.apache.tools.ant.DynamicElement)) ? ((org.apache.tools.ant.DynamicElement) obj).createDynamicElement(str2.toLowerCase(java.util.Locale.ENGLISH)) : createDynamicElement;
    }

    public java.lang.reflect.Method getAddTextMethod() throws org.apache.tools.ant.BuildException {
        if (supportsCharacters()) {
            return this.f;
        }
        throw new org.apache.tools.ant.BuildException("Class " + this.g.getName() + " doesn't support nested text data.");
    }

    public java.util.Map<java.lang.String, java.lang.Class<?>> getAttributeMap() {
        return this.a.isEmpty() ? java.util.Collections.emptyMap() : java.util.Collections.unmodifiableMap(this.a);
    }

    public java.lang.reflect.Method getAttributeMethod(java.lang.String str) throws org.apache.tools.ant.BuildException {
        org.apache.tools.ant.IntrospectionHelper.AttributeSetter attributeSetter = this.b.get(str);
        if (attributeSetter != null) {
            return attributeSetter.a;
        }
        throw new org.apache.tools.ant.UnsupportedAttributeException("Class " + this.g.getName() + " doesn't support the \"" + str + "\" attribute.", str);
    }

    public java.lang.Class<?> getAttributeType(java.lang.String str) throws org.apache.tools.ant.BuildException {
        java.lang.Class<?> cls = this.a.get(str);
        if (cls != null) {
            return cls;
        }
        throw new org.apache.tools.ant.UnsupportedAttributeException("Class " + this.g.getName() + " doesn't support the \"" + str + "\" attribute.", str);
    }

    public java.util.Enumeration<java.lang.String> getAttributes() {
        return this.b.keys();
    }

    public org.apache.tools.ant.IntrospectionHelper.Creator getElementCreator(org.apache.tools.ant.Project project, java.lang.String str, java.lang.Object obj, java.lang.String str2, org.apache.tools.ant.UnknownElement unknownElement) {
        return new org.apache.tools.ant.IntrospectionHelper.Creator(project, obj, o(project, str, obj, str2, unknownElement), null);
    }

    public java.lang.reflect.Method getElementMethod(java.lang.String str) throws org.apache.tools.ant.BuildException {
        org.apache.tools.ant.IntrospectionHelper.NestedCreator nestedCreator = this.d.get(str);
        if (nestedCreator != null) {
            return nestedCreator.a;
        }
        throw new org.apache.tools.ant.UnsupportedElementException("Class " + this.g.getName() + NOT_SUPPORTED_CHILD_PREFIX + str + NOT_SUPPORTED_CHILD_POSTFIX, str);
    }

    public java.lang.Class<?> getElementType(java.lang.String str) throws org.apache.tools.ant.BuildException {
        java.lang.Class<?> cls = this.c.get(str);
        if (cls != null) {
            return cls;
        }
        throw new org.apache.tools.ant.UnsupportedElementException("Class " + this.g.getName() + NOT_SUPPORTED_CHILD_PREFIX + str + NOT_SUPPORTED_CHILD_POSTFIX, str);
    }

    public java.util.List<java.lang.reflect.Method> getExtensionPoints() {
        return this.e.isEmpty() ? java.util.Collections.emptyList() : java.util.Collections.unmodifiableList(this.e);
    }

    public java.util.Map<java.lang.String, java.lang.Class<?>> getNestedElementMap() {
        return this.c.isEmpty() ? java.util.Collections.emptyMap() : java.util.Collections.unmodifiableMap(this.c);
    }

    public java.util.Enumeration<java.lang.String> getNestedElements() {
        return this.c.keys();
    }

    public final org.apache.tools.ant.IntrospectionHelper.MethodAndObject h(org.apache.tools.ant.ComponentHelper componentHelper, java.lang.String str, java.util.List<java.lang.reflect.Method> list) {
        org.apache.tools.ant.Project project = componentHelper.getProject();
        org.apache.tools.ant.AntTypeDefinition l = l(componentHelper, str, list);
        if (l == null) {
            return null;
        }
        java.lang.reflect.Method k = k(l.getExposedClass(project), list);
        if (k == null) {
            throw new org.apache.tools.ant.BuildException("Ant Internal Error - contract mismatch for " + str);
        }
        java.lang.Object create = l.create(project);
        if (create != null) {
            return new org.apache.tools.ant.IntrospectionHelper.MethodAndObject(k, create);
        }
        throw new org.apache.tools.ant.BuildException("Failed to create object " + str + " of type " + l.getTypeClass(project));
    }

    public final org.apache.tools.ant.IntrospectionHelper.MethodAndObject i(org.apache.tools.ant.ComponentHelper componentHelper, java.lang.String str, java.util.List<java.lang.reflect.Method> list) {
        java.lang.reflect.Method k;
        java.lang.Class<?> componentClass = componentHelper.getComponentClass(str);
        if (componentClass == null || (k = k(componentClass, this.e)) == null) {
            return null;
        }
        return new org.apache.tools.ant.IntrospectionHelper.MethodAndObject(k, componentHelper.createComponent(str));
    }

    public boolean isContainer() {
        return org.apache.tools.ant.TaskContainer.class.isAssignableFrom(this.g);
    }

    public boolean isDynamic() {
        return org.apache.tools.ant.DynamicElement.class.isAssignableFrom(this.g) || org.apache.tools.ant.DynamicElementNS.class.isAssignableFrom(this.g);
    }

    public final java.lang.reflect.Method k(java.lang.Class<?> cls, java.util.List<java.lang.reflect.Method> list) {
        java.lang.reflect.Method method = null;
        if (cls == null) {
            return null;
        }
        java.lang.Class<?> cls2 = null;
        for (java.lang.reflect.Method method2 : list) {
            java.lang.Class<?> cls3 = method2.getParameterTypes()[0];
            if (cls3.isAssignableFrom(cls)) {
                if (cls2 == null) {
                    method = method2;
                    cls2 = cls3;
                } else if (!cls3.isAssignableFrom(cls2)) {
                    throw new org.apache.tools.ant.BuildException("ambiguous: types " + cls2.getName() + " and " + cls3.getName() + " match " + cls.getName());
                }
            }
        }
        return method;
    }

    public final org.apache.tools.ant.AntTypeDefinition l(org.apache.tools.ant.ComponentHelper componentHelper, java.lang.String str, java.util.List<java.lang.reflect.Method> list) {
        java.util.List<org.apache.tools.ant.AntTypeDefinition> restrictedDefinitions = componentHelper.getRestrictedDefinitions(str);
        org.apache.tools.ant.AntTypeDefinition antTypeDefinition = null;
        if (restrictedDefinitions == null) {
            return null;
        }
        synchronized (restrictedDefinitions) {
            java.lang.Class<?> cls = null;
            for (org.apache.tools.ant.AntTypeDefinition antTypeDefinition2 : restrictedDefinitions) {
                java.lang.Class<?> exposedClass = antTypeDefinition2.getExposedClass(componentHelper.getProject());
                if (exposedClass != null && k(exposedClass, list) != null) {
                    if (cls != null) {
                        throw new org.apache.tools.ant.BuildException("ambiguous: restricted definitions for " + str + " " + cls + " and " + exposedClass);
                    }
                    antTypeDefinition = antTypeDefinition2;
                    cls = exposedClass;
                }
            }
        }
        return antTypeDefinition;
    }

    public final java.lang.String m(org.apache.tools.ant.Project project, java.lang.Object obj) {
        return project.getElementName(obj);
    }

    public final org.apache.tools.ant.IntrospectionHelper.AttributeSetter n(java.lang.Class<?> cls, java.lang.reflect.Method method, java.lang.Class<?> cls2) {
        if (cls.isEnum()) {
            return new org.apache.tools.ant.IntrospectionHelper.AnonymousClass12(method, cls2, cls, method);
        }
        return null;
    }

    public final org.apache.tools.ant.IntrospectionHelper.NestedCreator o(org.apache.tools.ant.Project project, java.lang.String str, java.lang.Object obj, java.lang.String str2, org.apache.tools.ant.UnknownElement unknownElement) throws org.apache.tools.ant.BuildException {
        java.lang.String extractUriFromComponentName = org.apache.tools.ant.ProjectHelper.extractUriFromComponentName(str2);
        java.lang.String extractNameFromComponentName = org.apache.tools.ant.ProjectHelper.extractNameFromComponentName(str2);
        if (extractUriFromComponentName.equals(org.apache.tools.ant.ProjectHelper.ANT_CORE_URI)) {
            extractUriFromComponentName = "";
        }
        if (str.equals(org.apache.tools.ant.ProjectHelper.ANT_CORE_URI)) {
            str = "";
        }
        org.apache.tools.ant.IntrospectionHelper.NestedCreator nestedCreator = (extractUriFromComponentName.equals(str) || extractUriFromComponentName.length() == 0) ? this.d.get(extractNameFromComponentName.toLowerCase(java.util.Locale.ENGLISH)) : null;
        if (nestedCreator == null) {
            nestedCreator = e(project, obj, str2);
        }
        if (nestedCreator == null && ((obj instanceof org.apache.tools.ant.DynamicElementNS) || (obj instanceof org.apache.tools.ant.DynamicElement))) {
            java.lang.Object g = g(obj, unknownElement != null ? unknownElement.getNamespace() : "", extractNameFromComponentName, unknownElement == null ? extractNameFromComponentName : unknownElement.getQName());
            if (g != null) {
                nestedCreator = new org.apache.tools.ant.IntrospectionHelper.AnonymousClass1(null, g);
            }
        }
        if (nestedCreator == null) {
            throwNotSupported(project, obj, str2);
        }
        return nestedCreator;
    }

    public final void q(java.lang.reflect.Method method) {
        java.lang.Class<?> cls = method.getParameterTypes()[0];
        int size = this.e.size();
        for (int i2 = 0; i2 < size; i2++) {
            java.lang.reflect.Method method2 = this.e.get(i2);
            if (method2.getParameterTypes()[0].equals(cls)) {
                if (method.getName().equals("addConfigured")) {
                    this.e.set(i2, method);
                    return;
                }
                return;
            } else {
                if (method2.getParameterTypes()[0].isAssignableFrom(cls)) {
                    this.e.add(i2, method);
                    return;
                }
            }
        }
        this.e.add(method);
    }

    public final boolean r(java.lang.String str, java.lang.Class<?> cls) {
        if ("setLocation".equals(str) && org.apache.tools.ant.Location.class.equals(cls)) {
            return true;
        }
        return "setTaskType".equals(str) && java.lang.String.class.equals(cls);
    }

    public void setAttribute(org.apache.tools.ant.Project project, java.lang.Object obj, java.lang.String str, java.lang.Object obj2) throws org.apache.tools.ant.BuildException {
        java.lang.String str2;
        java.util.Hashtable<java.lang.String, org.apache.tools.ant.IntrospectionHelper.AttributeSetter> hashtable = this.b;
        java.util.Locale locale = java.util.Locale.ENGLISH;
        org.apache.tools.ant.IntrospectionHelper.AttributeSetter attributeSetter = hashtable.get(str.toLowerCase(locale));
        if (attributeSetter != null || obj2 == null) {
            if (attributeSetter != null) {
                try {
                    attributeSetter.d(project, obj, obj2);
                    return;
                } catch (java.lang.IllegalAccessException e) {
                    throw new org.apache.tools.ant.BuildException(e);
                } catch (java.lang.reflect.InvocationTargetException e2) {
                    throw j(e2);
                }
            }
            return;
        }
        if (obj instanceof org.apache.tools.ant.DynamicAttributeNS) {
            org.apache.tools.ant.DynamicAttributeNS dynamicAttributeNS = (org.apache.tools.ant.DynamicAttributeNS) obj;
            java.lang.String extractUriFromComponentName = org.apache.tools.ant.ProjectHelper.extractUriFromComponentName(org.apache.tools.ant.ProjectHelper.extractUriFromComponentName(str));
            java.lang.String extractNameFromComponentName = org.apache.tools.ant.ProjectHelper.extractNameFromComponentName(str);
            if ("".equals(extractUriFromComponentName)) {
                str2 = extractNameFromComponentName;
            } else {
                str2 = extractUriFromComponentName + com.xiaomi.mipush.sdk.Constants.COLON_SEPARATOR + extractNameFromComponentName;
            }
            dynamicAttributeNS.setDynamicAttribute(extractUriFromComponentName, extractNameFromComponentName, str2, obj2.toString());
            return;
        }
        if (obj instanceof org.apache.tools.ant.DynamicObjectAttribute) {
            ((org.apache.tools.ant.DynamicObjectAttribute) obj).setDynamicAttribute(str.toLowerCase(locale), obj2);
            return;
        }
        if (obj instanceof org.apache.tools.ant.DynamicAttribute) {
            ((org.apache.tools.ant.DynamicAttribute) obj).setDynamicAttribute(str.toLowerCase(locale), obj2.toString());
            return;
        }
        if (str.indexOf(58) >= 0) {
            return;
        }
        throw new org.apache.tools.ant.UnsupportedAttributeException(m(project, obj) + " doesn't support the \"" + str + "\" attribute.", str);
    }

    public void setAttribute(org.apache.tools.ant.Project project, java.lang.Object obj, java.lang.String str, java.lang.String str2) throws org.apache.tools.ant.BuildException {
        setAttribute(project, obj, str, (java.lang.Object) str2);
    }

    public void storeElement(org.apache.tools.ant.Project project, java.lang.Object obj, java.lang.Object obj2, java.lang.String str) throws org.apache.tools.ant.BuildException {
        org.apache.tools.ant.IntrospectionHelper.NestedCreator nestedCreator;
        if (str == null || (nestedCreator = this.d.get(str.toLowerCase(java.util.Locale.ENGLISH))) == null) {
            return;
        }
        try {
            nestedCreator.f(obj, obj2);
        } catch (java.lang.IllegalAccessException e) {
            throw new org.apache.tools.ant.BuildException(e);
        } catch (java.lang.InstantiationException e2) {
            throw new org.apache.tools.ant.BuildException(e2);
        } catch (java.lang.reflect.InvocationTargetException e3) {
            throw j(e3);
        }
    }

    public boolean supportsCharacters() {
        return this.f != null;
    }

    public boolean supportsNestedElement(java.lang.String str) {
        return supportsNestedElement("", str);
    }

    public boolean supportsNestedElement(java.lang.String str, java.lang.String str2) {
        if (isDynamic() || this.e.size() > 0) {
            return true;
        }
        return supportsReflectElement(str, str2);
    }

    public boolean supportsNestedElement(java.lang.String str, java.lang.String str2, org.apache.tools.ant.Project project, java.lang.Object obj) {
        return (this.e.size() > 0 && e(project, obj, str2) != null) || isDynamic() || supportsReflectElement(str, str2);
    }

    public boolean supportsReflectElement(java.lang.String str, java.lang.String str2) {
        if (!this.d.containsKey(org.apache.tools.ant.ProjectHelper.extractNameFromComponentName(str2).toLowerCase(java.util.Locale.ENGLISH))) {
            return false;
        }
        java.lang.String extractUriFromComponentName = org.apache.tools.ant.ProjectHelper.extractUriFromComponentName(str2);
        if (extractUriFromComponentName.equals(org.apache.tools.ant.ProjectHelper.ANT_CORE_URI)) {
            extractUriFromComponentName = "";
        }
        if ("".equals(extractUriFromComponentName)) {
            return true;
        }
        if (str.equals(org.apache.tools.ant.ProjectHelper.ANT_CORE_URI)) {
            str = "";
        }
        return extractUriFromComponentName.equals(str);
    }

    public void throwNotSupported(org.apache.tools.ant.Project project, java.lang.Object obj, java.lang.String str) {
        throw new org.apache.tools.ant.UnsupportedElementException(project.getElementName(obj) + NOT_SUPPORTED_CHILD_PREFIX + str + NOT_SUPPORTED_CHILD_POSTFIX, str);
    }
}
