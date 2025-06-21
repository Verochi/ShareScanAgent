package org.apache.tools.ant.util;

/* loaded from: classes26.dex */
public class SymbolicLinkUtils {
    public static final org.apache.tools.ant.util.FileUtils a = org.apache.tools.ant.util.FileUtils.getFileUtils();
    public static final org.apache.tools.ant.util.SymbolicLinkUtils b = new org.apache.tools.ant.util.SymbolicLinkUtils();

    /* renamed from: org.apache.tools.ant.util.SymbolicLinkUtils$1, reason: invalid class name */
    public class AnonymousClass1 implements java.io.FilenameFilter {
        public final /* synthetic */ java.lang.String a;

        public AnonymousClass1(java.lang.String str) {
            this.a = str;
        }

        @Override // java.io.FilenameFilter
        public boolean accept(java.io.File file, java.lang.String str) {
            return this.a.equals(str);
        }
    }

    public static org.apache.tools.ant.util.SymbolicLinkUtils getSymbolicLinkUtils() {
        return b;
    }

    public void deleteSymbolicLink(java.io.File file, org.apache.tools.ant.Task task) throws java.io.IOException {
        java.lang.Throwable th;
        if (isDanglingSymbolicLink(file)) {
            if (file.delete()) {
                return;
            }
            throw new java.io.IOException("failed to remove dangling symbolic link " + file);
        }
        if (!isSymbolicLink(file)) {
            return;
        }
        if (!file.exists()) {
            throw new java.io.FileNotFoundException("No such symbolic link: " + file);
        }
        java.io.File canonicalFile = file.getCanonicalFile();
        boolean z = true;
        if (task != null && !canonicalFile.getParentFile().canWrite()) {
            org.apache.tools.ant.taskdefs.Execute.runCommand(task, new java.lang.String[]{"rm", file.getAbsolutePath()});
            return;
        }
        org.apache.tools.ant.Project project = task == null ? null : task.getProject();
        org.apache.tools.ant.util.FileUtils fileUtils = a;
        java.io.File createTempFile = fileUtils.createTempFile(project, com.alibaba.sdk.android.oss.common.RequestParameters.X_OSS_SYMLINK, com.baidu.mobads.sdk.internal.al.k, canonicalFile.getParentFile(), false, false);
        java.io.File file2 = fileUtils.isLeadingPath(canonicalFile, file) ? new java.io.File(createTempFile, fileUtils.removeLeadingPath(canonicalFile, file)) : file;
        try {
            try {
                fileUtils.rename(canonicalFile, createTempFile);
                try {
                    if (!file2.delete()) {
                        throw new java.io.IOException("Couldn't delete symlink: " + file2 + " (was it a real file? is this not a UNIX system?)");
                    }
                    try {
                        fileUtils.rename(createTempFile, canonicalFile);
                    } catch (java.io.IOException e) {
                        throw new java.io.IOException("Couldn't return resource " + createTempFile + " to its original name: " + canonicalFile.getAbsolutePath() + ". Reason: " + e.getMessage() + "\n THE RESOURCE'S NAME ON DISK HAS BEEN CHANGED BY THIS ERROR!\n");
                    }
                } catch (java.lang.Throwable th2) {
                    th = th2;
                    if (!z) {
                        throw th;
                    }
                    try {
                        a.rename(createTempFile, canonicalFile);
                        throw th;
                    } catch (java.io.IOException e2) {
                        java.lang.System.err.println("Couldn't return resource " + createTempFile + " to its original name: " + canonicalFile.getAbsolutePath() + ". Reason: " + e2.getMessage() + "\n THE RESOURCE'S NAME ON DISK HAS BEEN CHANGED BY THIS ERROR!\n");
                        throw th;
                    }
                }
            } catch (java.io.IOException e3) {
                throw new java.io.IOException("Couldn't rename resource when attempting to delete '" + file2 + "'.  Reason: " + e3.getMessage());
            }
        } catch (java.lang.Throwable th3) {
            th = th3;
            z = false;
        }
    }

    public boolean isDanglingSymbolicLink(java.io.File file) throws java.io.IOException {
        return isDanglingSymbolicLink(file.getParentFile(), file.getName());
    }

    public boolean isDanglingSymbolicLink(java.io.File file, java.lang.String str) throws java.io.IOException {
        java.lang.String[] list;
        java.io.File file2 = new java.io.File(file, str);
        return (file2.exists() || (list = file.list(new org.apache.tools.ant.util.SymbolicLinkUtils.AnonymousClass1(file2.getName()))) == null || list.length <= 0) ? false : true;
    }

    public boolean isDanglingSymbolicLink(java.lang.String str) throws java.io.IOException {
        return isDanglingSymbolicLink(new java.io.File(str));
    }

    public boolean isSymbolicLink(java.io.File file) throws java.io.IOException {
        return isSymbolicLink(file.getParentFile(), file.getName());
    }

    public boolean isSymbolicLink(java.io.File file, java.lang.String str) throws java.io.IOException {
        java.io.File file2 = file != null ? new java.io.File(file.getCanonicalPath(), str) : new java.io.File(str);
        return !file2.getAbsolutePath().equals(file2.getCanonicalPath());
    }

    public boolean isSymbolicLink(java.lang.String str) throws java.io.IOException {
        return isSymbolicLink(new java.io.File(str));
    }
}
