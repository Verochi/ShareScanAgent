package org.apache.tools.ant.types.selectors.modifiedselector;

/* loaded from: classes26.dex */
public interface Cache {
    void delete();

    java.lang.Object get(java.lang.Object obj);

    boolean isValid();

    java.util.Iterator<java.lang.String> iterator();

    void load();

    void put(java.lang.Object obj, java.lang.Object obj2);

    void save();
}
