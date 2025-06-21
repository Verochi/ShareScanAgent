package org.apache.tools.ant.taskdefs.optional.depend;

/* loaded from: classes25.dex */
public class ClassFileUtils {
    public static java.lang.String convertDotName(java.lang.String str) {
        return str.replace('.', '/');
    }

    public static java.lang.String convertSlashName(java.lang.String str) {
        return str.replace('\\', '.').replace('/', '.');
    }
}
