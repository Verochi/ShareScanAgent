package org.apache.tools.ant.taskdefs.optional.extension;

/* loaded from: classes25.dex */
public final class ExtensionUtil {
    public static void a(java.util.List list, org.apache.tools.ant.taskdefs.optional.extension.Extension extension, boolean z, boolean z2) {
        if (!z2 && extension.getImplementationURL() != null) {
            extension = new org.apache.tools.ant.taskdefs.optional.extension.Extension(extension.getExtensionName(), extension.getSpecificationVersion().toString(), extension.getSpecificationVendor(), extension.getImplementationVersion().toString(), extension.getImplementationVendor(), extension.getImplementationVendorID(), null);
        }
        boolean z3 = (extension.getImplementationURL() == null && extension.getImplementationVersion() == null && extension.getImplementationVendorID() == null && extension.getImplementationVendor() == null) ? false : true;
        if (!z && z3) {
            extension = new org.apache.tools.ant.taskdefs.optional.extension.Extension(extension.getExtensionName(), extension.getSpecificationVersion().toString(), extension.getSpecificationVendor(), null, null, null, extension.getImplementationURL());
        }
        list.add(extension);
    }

    public static void b(java.util.jar.JarFile jarFile) {
        if (jarFile != null) {
            try {
                jarFile.close();
            } catch (java.io.IOException unused) {
            }
        }
    }

    public static void c(org.apache.tools.ant.Project project, java.util.List list, java.util.List list2) throws org.apache.tools.ant.BuildException {
        if (list2.isEmpty()) {
            return;
        }
        org.apache.tools.ant.taskdefs.optional.extension.Extension[] d = d(project, list2);
        for (org.apache.tools.ant.taskdefs.optional.extension.Extension extension : d) {
            list.add(extension);
        }
    }

    public static org.apache.tools.ant.taskdefs.optional.extension.Extension[] d(org.apache.tools.ant.Project project, java.util.List list) throws org.apache.tools.ant.BuildException {
        boolean z;
        boolean z2;
        java.util.ArrayList arrayList = new java.util.ArrayList();
        java.util.Iterator it = list.iterator();
        while (it.hasNext()) {
            org.apache.tools.ant.types.FileSet fileSet = (org.apache.tools.ant.types.FileSet) it.next();
            if (fileSet instanceof org.apache.tools.ant.taskdefs.optional.extension.LibFileSet) {
                org.apache.tools.ant.taskdefs.optional.extension.LibFileSet libFileSet = (org.apache.tools.ant.taskdefs.optional.extension.LibFileSet) fileSet;
                z = libFileSet.c();
                z2 = libFileSet.d();
            } else {
                z = true;
                z2 = true;
            }
            org.apache.tools.ant.DirectoryScanner directoryScanner = fileSet.getDirectoryScanner(project);
            java.io.File basedir = directoryScanner.getBasedir();
            for (java.lang.String str : directoryScanner.getIncludedFiles()) {
                f(new java.io.File(basedir, str), arrayList, z, z2);
            }
        }
        return (org.apache.tools.ant.taskdefs.optional.extension.Extension[]) arrayList.toArray(new org.apache.tools.ant.taskdefs.optional.extension.Extension[arrayList.size()]);
    }

    public static java.util.jar.Manifest e(java.io.File file) throws org.apache.tools.ant.BuildException {
        java.util.jar.JarFile jarFile;
        java.util.jar.JarFile jarFile2 = null;
        try {
            try {
                jarFile = new java.util.jar.JarFile(file);
            } catch (java.io.IOException e) {
                e = e;
            }
        } catch (java.lang.Throwable th) {
            th = th;
        }
        try {
            java.util.jar.Manifest manifest = jarFile.getManifest();
            if (manifest != null) {
                b(jarFile);
                return manifest;
            }
            throw new org.apache.tools.ant.BuildException(file + " doesn't have a MANIFEST");
        } catch (java.io.IOException e2) {
            e = e2;
            jarFile2 = jarFile;
            throw new org.apache.tools.ant.BuildException(e.getMessage(), e);
        } catch (java.lang.Throwable th2) {
            th = th2;
            jarFile2 = jarFile;
            b(jarFile2);
            throw th;
        }
    }

    public static void f(java.io.File file, java.util.List list, boolean z, boolean z2) throws org.apache.tools.ant.BuildException {
        java.util.jar.JarFile jarFile;
        java.util.jar.JarFile jarFile2 = null;
        try {
            try {
                jarFile = new java.util.jar.JarFile(file);
            } catch (java.lang.Throwable th) {
                th = th;
            }
        } catch (java.lang.Exception e) {
            e = e;
        }
        try {
            for (org.apache.tools.ant.taskdefs.optional.extension.Extension extension : org.apache.tools.ant.taskdefs.optional.extension.Extension.getAvailable(jarFile.getManifest())) {
                a(list, extension, z, z2);
            }
            b(jarFile);
        } catch (java.lang.Exception e2) {
            e = e2;
            throw new org.apache.tools.ant.BuildException(e.getMessage(), e);
        } catch (java.lang.Throwable th2) {
            th = th2;
            jarFile2 = jarFile;
            b(jarFile2);
            throw th;
        }
    }

    public static java.util.ArrayList g(java.util.List list) throws org.apache.tools.ant.BuildException {
        java.util.ArrayList arrayList = new java.util.ArrayList();
        int size = list.size();
        for (int i = 0; i < size; i++) {
            arrayList.add(((org.apache.tools.ant.taskdefs.optional.extension.ExtensionAdapter) list.get(i)).b());
        }
        return arrayList;
    }
}
