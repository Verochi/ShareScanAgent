package org.apache.tools.ant.util;

/* loaded from: classes26.dex */
public class WeakishReference {
    public java.lang.ref.WeakReference<java.lang.Object> a;

    public static class HardReference extends org.apache.tools.ant.util.WeakishReference {
        public HardReference(java.lang.Object obj) {
            super(obj);
        }
    }

    public WeakishReference(java.lang.Object obj) {
        this.a = new java.lang.ref.WeakReference<>(obj);
    }

    public static org.apache.tools.ant.util.WeakishReference createReference(java.lang.Object obj) {
        return new org.apache.tools.ant.util.WeakishReference(obj);
    }

    public java.lang.Object get() {
        return this.a.get();
    }
}
