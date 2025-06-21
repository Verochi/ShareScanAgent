package com.alimm.tanx.ui.image.glide.util;

/* loaded from: classes.dex */
public class MultiClassKey {
    private java.lang.Class<?> first;
    private java.lang.Class<?> second;

    public MultiClassKey() {
    }

    public MultiClassKey(java.lang.Class<?> cls, java.lang.Class<?> cls2) {
        set(cls, cls2);
    }

    public boolean equals(java.lang.Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || com.alimm.tanx.ui.image.glide.util.MultiClassKey.class != obj.getClass()) {
            return false;
        }
        com.alimm.tanx.ui.image.glide.util.MultiClassKey multiClassKey = (com.alimm.tanx.ui.image.glide.util.MultiClassKey) obj;
        return this.first.equals(multiClassKey.first) && this.second.equals(multiClassKey.second);
    }

    public int hashCode() {
        return this.second.hashCode() + (this.first.hashCode() * 31);
    }

    public void set(java.lang.Class<?> cls, java.lang.Class<?> cls2) {
        this.first = cls;
        this.second = cls2;
    }

    public java.lang.String toString() {
        java.lang.StringBuilder tanxu_do2 = tanxu_do.tanxu_do.tanxu_do.tanxu_do.tanxu_do.tanxu_do("MultiClassKey{first=");
        tanxu_do2.append(this.first);
        tanxu_do2.append(", second=");
        tanxu_do2.append(this.second);
        tanxu_do2.append('}');
        return tanxu_do2.toString();
    }
}
