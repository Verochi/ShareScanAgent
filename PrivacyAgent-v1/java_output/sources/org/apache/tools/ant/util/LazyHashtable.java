package org.apache.tools.ant.util;

/* loaded from: classes26.dex */
public class LazyHashtable extends java.util.Hashtable {
    protected boolean initAllDone = false;

    @Override // java.util.Hashtable
    public boolean contains(java.lang.Object obj) {
        initAll();
        return super.contains(obj);
    }

    @Override // java.util.Hashtable, java.util.Map
    public boolean containsKey(java.lang.Object obj) {
        initAll();
        return super.containsKey(obj);
    }

    @Override // java.util.Hashtable, java.util.Map
    public boolean containsValue(java.lang.Object obj) {
        return contains(obj);
    }

    @Override // java.util.Hashtable, java.util.Dictionary
    public java.util.Enumeration elements() {
        initAll();
        return super.elements();
    }

    public void initAll() {
        if (this.initAllDone) {
            return;
        }
        this.initAllDone = true;
    }

    @Override // java.util.Hashtable, java.util.Dictionary, java.util.Map
    public boolean isEmpty() {
        initAll();
        return super.isEmpty();
    }

    @Override // java.util.Hashtable, java.util.Dictionary
    public java.util.Enumeration keys() {
        initAll();
        return super.keys();
    }

    @Override // java.util.Hashtable, java.util.Dictionary, java.util.Map
    public int size() {
        initAll();
        return super.size();
    }
}
