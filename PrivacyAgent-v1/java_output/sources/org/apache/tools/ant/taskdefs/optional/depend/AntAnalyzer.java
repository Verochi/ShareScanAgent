package org.apache.tools.ant.taskdefs.optional.depend;

/* loaded from: classes25.dex */
public class AntAnalyzer extends org.apache.tools.ant.util.depend.AbstractAnalyzer {
    /* JADX WARN: Removed duplicated region for block: B:45:0x00d9 A[Catch: IOException -> 0x00dd, TryCatch #2 {IOException -> 0x00dd, blocks: (B:19:0x0058, B:22:0x005f, B:33:0x00c2, B:36:0x00c7, B:43:0x00d4, B:45:0x00d9, B:46:0x00dc), top: B:18:0x0058 }] */
    @Override // org.apache.tools.ant.util.depend.AbstractAnalyzer
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void determineDependencies(java.util.Vector<java.io.File> vector, java.util.Vector<java.lang.String> vector2) {
        java.io.InputStream inputStream;
        java.util.zip.ZipFile zipFile;
        java.util.Hashtable hashtable = new java.util.Hashtable();
        java.util.Hashtable hashtable2 = new java.util.Hashtable();
        java.util.Hashtable hashtable3 = new java.util.Hashtable();
        java.util.Enumeration<java.lang.String> rootClasses = getRootClasses();
        while (rootClasses.hasMoreElements()) {
            java.lang.String nextElement = rootClasses.nextElement();
            hashtable3.put(nextElement, nextElement);
        }
        int i = isClosureRequired() ? 1000 : 1;
        int i2 = 0;
        java.util.Hashtable hashtable4 = null;
        while (hashtable3.size() != 0) {
            int i3 = i2 + 1;
            if (i2 >= i) {
                break;
            }
            hashtable4 = new java.util.Hashtable();
            java.util.Enumeration keys = hashtable3.keys();
            while (keys.hasMoreElements()) {
                java.lang.String str = (java.lang.String) keys.nextElement();
                hashtable.put(str, str);
                try {
                    java.io.File classContainer = getClassContainer(str);
                    if (classContainer != null) {
                        hashtable2.put(classContainer, classContainer);
                        try {
                            if (classContainer.getName().endsWith(".class")) {
                                inputStream = new java.io.FileInputStream(classContainer.getPath());
                                zipFile = null;
                            } else {
                                zipFile = new java.util.zip.ZipFile(classContainer.getPath());
                                try {
                                    inputStream = zipFile.getInputStream(new java.util.zip.ZipEntry(str.replace('.', '/') + ".class"));
                                } catch (java.lang.Throwable th) {
                                    th = th;
                                    inputStream = null;
                                    org.apache.tools.ant.util.FileUtils.close(inputStream);
                                    if (zipFile != null) {
                                    }
                                    throw th;
                                }
                            }
                        } catch (java.lang.Throwable th2) {
                            th = th2;
                            inputStream = null;
                            zipFile = null;
                        }
                        try {
                            org.apache.tools.ant.taskdefs.optional.depend.ClassFile classFile = new org.apache.tools.ant.taskdefs.optional.depend.ClassFile();
                            classFile.read(inputStream);
                            java.util.Iterator<java.lang.String> it = classFile.getClassRefs().iterator();
                            while (it.hasNext()) {
                                java.lang.String next = it.next();
                                hashtable4.put(next, next);
                            }
                            org.apache.tools.ant.util.FileUtils.close(inputStream);
                            if (zipFile != null) {
                                zipFile.close();
                            }
                        } catch (java.lang.Throwable th3) {
                            th = th3;
                            org.apache.tools.ant.util.FileUtils.close(inputStream);
                            if (zipFile != null) {
                                zipFile.close();
                            }
                            throw th;
                        }
                    }
                } catch (java.io.IOException unused) {
                }
            }
            hashtable3.clear();
            for (java.lang.String str2 : hashtable4.values()) {
                if (!hashtable.containsKey(str2)) {
                    hashtable3.put(str2, str2);
                }
            }
            i2 = i3;
        }
        for (java.lang.String str3 : hashtable4.values()) {
            hashtable.put(str3, str3);
        }
        vector.removeAllElements();
        java.util.Iterator it2 = hashtable2.keySet().iterator();
        while (it2.hasNext()) {
            vector.add((java.io.File) it2.next());
        }
        vector2.removeAllElements();
        java.util.Iterator it3 = hashtable.keySet().iterator();
        while (it3.hasNext()) {
            vector2.add((java.lang.String) it3.next());
        }
    }

    @Override // org.apache.tools.ant.util.depend.AbstractAnalyzer
    public boolean supportsFileDependencies() {
        return true;
    }
}
