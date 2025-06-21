package org.apache.tools.ant;

/* loaded from: classes25.dex */
public interface TypeAdapter {
    void checkProxyClass(java.lang.Class<?> cls);

    org.apache.tools.ant.Project getProject();

    java.lang.Object getProxy();

    void setProject(org.apache.tools.ant.Project project);

    void setProxy(java.lang.Object obj);
}
