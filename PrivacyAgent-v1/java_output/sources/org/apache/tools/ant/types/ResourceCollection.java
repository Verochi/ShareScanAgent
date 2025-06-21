package org.apache.tools.ant.types;

/* loaded from: classes26.dex */
public interface ResourceCollection extends java.lang.Iterable<org.apache.tools.ant.types.Resource> {
    boolean isFilesystemOnly();

    @Override // java.lang.Iterable
    java.util.Iterator<org.apache.tools.ant.types.Resource> iterator();

    int size();
}
