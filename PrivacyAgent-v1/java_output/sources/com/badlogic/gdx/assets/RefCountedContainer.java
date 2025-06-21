package com.badlogic.gdx.assets;

/* loaded from: classes12.dex */
public class RefCountedContainer {
    public java.lang.Object a;
    public int b = 1;

    public RefCountedContainer(java.lang.Object obj) {
        if (obj == null) {
            throw new java.lang.IllegalArgumentException("Object must not be null");
        }
        this.a = obj;
    }

    public void decRefCount() {
        this.b--;
    }

    public <T> T getObject(java.lang.Class<T> cls) {
        return (T) this.a;
    }

    public int getRefCount() {
        return this.b;
    }

    public void incRefCount() {
        this.b++;
    }

    public void setObject(java.lang.Object obj) {
        this.a = obj;
    }

    public void setRefCount(int i) {
        this.b = i;
    }
}
