package org.apache.tools.ant.util.optional;

/* loaded from: classes26.dex */
public class NoExitSecurityManager extends java.lang.SecurityManager {
    @Override // java.lang.SecurityManager
    public void checkExit(int i) {
        throw new org.apache.tools.ant.ExitException(i);
    }

    @Override // java.lang.SecurityManager
    public void checkPermission(java.security.Permission permission) {
    }
}
