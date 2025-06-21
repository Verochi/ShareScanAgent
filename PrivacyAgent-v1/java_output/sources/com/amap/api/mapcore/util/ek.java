package com.amap.api.mapcore.util;

/* loaded from: classes12.dex */
public final class ek extends android.view.ContextThemeWrapper {
    private static final java.lang.String[] d = {"android.widget", "android.webkit", "android.app"};
    private android.content.res.Resources a;
    private android.view.LayoutInflater b;
    private java.lang.ClassLoader c;
    private com.amap.api.mapcore.util.ek.a e;
    private android.view.LayoutInflater.Factory f;

    /* renamed from: com.amap.api.mapcore.util.ek$1, reason: invalid class name */
    public class AnonymousClass1 implements android.view.LayoutInflater.Factory {
        public AnonymousClass1() {
        }

        @Override // android.view.LayoutInflater.Factory
        public final android.view.View onCreateView(java.lang.String str, android.content.Context context, android.util.AttributeSet attributeSet) {
            return com.amap.api.mapcore.util.ek.this.a(str, context, attributeSet);
        }
    }

    public class a {
        public java.util.HashSet<java.lang.String> a = new java.util.HashSet<>();
        public java.util.HashMap<java.lang.String, java.lang.reflect.Constructor<?>> b = new java.util.HashMap<>();

        public a() {
        }
    }

    public ek(android.content.Context context, int i, java.lang.ClassLoader classLoader) {
        super(context, i);
        this.e = new com.amap.api.mapcore.util.ek.a();
        this.f = new com.amap.api.mapcore.util.ek.AnonymousClass1();
        this.a = com.amap.api.mapcore.util.el.a();
        this.c = classLoader;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:28:0x006a  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0072 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final android.view.View a(java.lang.String str, android.content.Context context, android.util.AttributeSet attributeSet) {
        java.lang.Class<?> cls;
        boolean z;
        if (this.e.a.contains(str)) {
            return null;
        }
        java.lang.reflect.Constructor<?> constructor = this.e.b.get(str);
        if (constructor == null) {
            try {
                if (!str.contains("api.navi")) {
                    java.lang.String[] strArr = d;
                    int length = strArr.length;
                    int i = 0;
                    while (true) {
                        if (i >= length) {
                            cls = null;
                            break;
                        }
                        java.lang.String str2 = strArr[i];
                        try {
                            cls = this.c.loadClass(str2 + "." + str);
                            break;
                        } catch (java.lang.Throwable unused) {
                            i++;
                        }
                    }
                } else {
                    cls = this.c.loadClass(str);
                }
            } catch (java.lang.Throwable unused2) {
                cls = null;
            }
            if (cls != null && cls != android.view.ViewStub.class) {
                if (cls.getClassLoader() == this.c) {
                    z = true;
                    if (z) {
                        this.e.a.add(str);
                        return null;
                    }
                    try {
                        constructor = cls.getConstructor(android.content.Context.class, android.util.AttributeSet.class);
                        this.e.b.put(str, constructor);
                    } catch (java.lang.Throwable unused3) {
                    }
                }
            }
            z = false;
            if (z) {
            }
        }
        if (constructor == null) {
            return null;
        }
        try {
            return (android.view.View) constructor.newInstance(context, attributeSet);
        } catch (java.lang.Throwable unused4) {
            return null;
        }
    }

    @Override // android.view.ContextThemeWrapper, android.content.ContextWrapper, android.content.Context
    public final android.content.res.Resources getResources() {
        android.content.res.Resources resources = this.a;
        return resources != null ? resources : super.getResources();
    }

    @Override // android.view.ContextThemeWrapper, android.content.ContextWrapper, android.content.Context
    public final java.lang.Object getSystemService(java.lang.String str) {
        if (!"layout_inflater".equals(str)) {
            return super.getSystemService(str);
        }
        if (this.b == null) {
            android.view.LayoutInflater layoutInflater = (android.view.LayoutInflater) super.getSystemService(str);
            if (layoutInflater != null) {
                this.b = layoutInflater.cloneInContext(this);
            }
            this.b.setFactory(this.f);
            this.b = this.b.cloneInContext(this);
        }
        return this.b;
    }
}
