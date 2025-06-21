package com.bytedance.pangle.g;

/* loaded from: classes12.dex */
public final class a {
    private static final java.util.concurrent.atomic.AtomicReference<byte[]> a = new java.util.concurrent.atomic.AtomicReference<>();

    public static com.bytedance.pangle.g.o a(java.lang.String str) {
        java.util.jar.JarFile jarFile;
        java.util.jar.JarFile jarFile2 = null;
        try {
            try {
                jarFile = new java.util.jar.JarFile(str);
            } catch (java.lang.Throwable th) {
                th = th;
            }
        } catch (java.io.IOException e) {
            e = e;
        } catch (java.lang.RuntimeException e2) {
            e = e2;
        } catch (java.security.GeneralSecurityException e3) {
            e = e3;
        }
        try {
            java.util.ArrayList<java.util.jar.JarEntry> arrayList = new java.util.ArrayList();
            java.util.jar.JarEntry jarEntry = jarFile.getJarEntry("AndroidManifest.xml");
            if (jarEntry == null) {
                throw new com.bytedance.pangle.g.q(1, "Package " + str + " has no manifest");
            }
            java.security.cert.Certificate[][] a2 = a(jarFile, jarEntry);
            if (com.bytedance.pangle.util.d.a(a2)) {
                throw new com.bytedance.pangle.g.q(4, "Package " + str + " has no certificates at entry AndroidManifest.xml");
            }
            android.content.pm.Signature[] a3 = com.bytedance.pangle.g.d.a(a2);
            java.util.Enumeration<java.util.jar.JarEntry> entries = jarFile.entries();
            while (entries.hasMoreElements()) {
                java.util.jar.JarEntry nextElement = entries.nextElement();
                if (!nextElement.isDirectory()) {
                    java.lang.String name = nextElement.getName();
                    if (!name.startsWith("META-INF/") && !name.equals("AndroidManifest.xml")) {
                        arrayList.add(nextElement);
                    }
                }
            }
            for (java.util.jar.JarEntry jarEntry2 : arrayList) {
                java.security.cert.Certificate[][] a4 = a(jarFile, jarEntry2);
                if (com.bytedance.pangle.util.d.a(a4)) {
                    throw new com.bytedance.pangle.g.q(4, "Package " + str + " has no certificates at entry " + jarEntry2.getName());
                }
                if (!com.bytedance.pangle.g.o.a(a3, com.bytedance.pangle.g.d.a(a4))) {
                    throw new com.bytedance.pangle.g.q(3, "Package " + str + " has mismatched certificates at entry " + jarEntry2.getName());
                }
            }
            com.bytedance.pangle.g.o oVar = new com.bytedance.pangle.g.o(a3, 1, null, null, null);
            try {
                jarFile.close();
            } catch (java.lang.Exception unused) {
            }
            return oVar;
        } catch (java.io.IOException e4) {
            e = e4;
            throw new com.bytedance.pangle.g.q(4, "Failed to collect certificates from ".concat(java.lang.String.valueOf(str)), e);
        } catch (java.lang.RuntimeException e5) {
            e = e5;
            throw new com.bytedance.pangle.g.q(4, "Failed to collect certificates from ".concat(java.lang.String.valueOf(str)), e);
        } catch (java.security.GeneralSecurityException e6) {
            e = e6;
            throw new com.bytedance.pangle.g.q(2, "Failed to collect certificates from ".concat(java.lang.String.valueOf(str)), e);
        } catch (java.lang.Throwable th2) {
            th = th2;
            jarFile2 = jarFile;
            if (jarFile2 != null) {
                try {
                    jarFile2.close();
                } catch (java.lang.Exception unused2) {
                }
            }
            throw th;
        }
    }

    /* JADX WARN: Not initialized variable reg: 1, insn: 0x0031: MOVE (r0 I:??[OBJECT, ARRAY]) = (r1 I:??[OBJECT, ARRAY]), block:B:29:0x0031 */
    /* JADX WARN: Removed duplicated region for block: B:32:0x0062 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static java.security.cert.Certificate[][] a(java.util.jar.JarFile jarFile, java.util.jar.JarEntry jarEntry) {
        java.lang.Throwable e;
        java.io.InputStream inputStream;
        java.io.InputStream inputStream2 = null;
        try {
            try {
                java.io.InputStream inputStream3 = jarFile.getInputStream(jarEntry);
                try {
                    byte[] andSet = a.getAndSet(null);
                    if (andSet == null) {
                        andSet = new byte[4096];
                    }
                    while (inputStream3.read(andSet, 0, andSet.length) != -1) {
                    }
                    a.set(andSet);
                    java.security.cert.Certificate[][] certificateArr = {jarEntry.getCertificates()};
                    try {
                        inputStream3.close();
                    } catch (java.lang.RuntimeException e2) {
                        throw e2;
                    } catch (java.lang.Exception unused) {
                    }
                    return certificateArr;
                } catch (java.io.IOException e3) {
                    e = e3;
                    throw new com.bytedance.pangle.g.q(5, "Failed reading " + jarEntry.getName() + " in " + jarFile, e);
                } catch (java.lang.RuntimeException e4) {
                    e = e4;
                    throw new com.bytedance.pangle.g.q(5, "Failed reading " + jarEntry.getName() + " in " + jarFile, e);
                }
            } catch (java.lang.Throwable th) {
                th = th;
                inputStream2 = inputStream;
                if (inputStream2 != null) {
                    try {
                        inputStream2.close();
                    } catch (java.lang.RuntimeException e5) {
                        throw e5;
                    } catch (java.lang.Exception unused2) {
                    }
                }
                throw th;
            }
        } catch (java.io.IOException e6) {
            e = e6;
            e = e;
            throw new com.bytedance.pangle.g.q(5, "Failed reading " + jarEntry.getName() + " in " + jarFile, e);
        } catch (java.lang.RuntimeException e7) {
            e = e7;
            e = e;
            throw new com.bytedance.pangle.g.q(5, "Failed reading " + jarEntry.getName() + " in " + jarFile, e);
        } catch (java.lang.Throwable th2) {
            th = th2;
            if (inputStream2 != null) {
            }
            throw th;
        }
    }
}
