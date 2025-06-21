package org.apache.tools.ant.util;

/* loaded from: classes26.dex */
public class ReflectWrapper {
    public java.lang.Object a;

    public ReflectWrapper(java.lang.ClassLoader classLoader, java.lang.String str) {
        try {
            this.a = java.lang.Class.forName(str, true, classLoader).getConstructor(null).newInstance(null);
        } catch (java.lang.Exception e) {
            org.apache.tools.ant.util.ReflectUtil.throwBuildException(e);
        }
    }

    public ReflectWrapper(java.lang.Object obj) {
        this.a = obj;
    }

    public java.lang.Object getObject() {
        return this.a;
    }

    public java.lang.Object invoke(java.lang.String str) {
        return org.apache.tools.ant.util.ReflectUtil.invoke(this.a, str);
    }

    public java.lang.Object invoke(java.lang.String str, java.lang.Class cls, java.lang.Object obj) {
        return org.apache.tools.ant.util.ReflectUtil.invoke(this.a, str, cls, obj);
    }

    public java.lang.Object invoke(java.lang.String str, java.lang.Class cls, java.lang.Object obj, java.lang.Class cls2, java.lang.Object obj2) {
        return org.apache.tools.ant.util.ReflectUtil.invoke(this.a, str, cls, obj, cls2, obj2);
    }
}
