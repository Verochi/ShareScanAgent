package com.badlogic.gdx.utils;

/* loaded from: classes12.dex */
public class SharedLibraryLoader {
    public static java.lang.String abi;
    public static final java.util.HashSet<java.lang.String> b;
    public static boolean is64Bit;
    public static boolean isARM = java.lang.System.getProperty("os.arch").startsWith("arm");
    public static boolean isAndroid;
    public static boolean isIos;
    public static boolean isLinux;
    public static boolean isMac;
    public static boolean isWindows;
    public java.lang.String a;

    static {
        isWindows = java.lang.System.getProperty("os.name").contains("Windows");
        isLinux = java.lang.System.getProperty("os.name").contains("Linux");
        isMac = java.lang.System.getProperty("os.name").contains("Mac");
        isIos = false;
        isAndroid = false;
        is64Bit = java.lang.System.getProperty("os.arch").equals("amd64") || java.lang.System.getProperty("os.arch").equals("x86_64");
        abi = java.lang.System.getProperty("sun.arch.abi") != null ? java.lang.System.getProperty("sun.arch.abi") : "";
        boolean equals = "iOS".equals(java.lang.System.getProperty("moe.platform.name"));
        java.lang.String property = java.lang.System.getProperty("java.runtime.name");
        if (property != null && property.contains("Android Runtime")) {
            isAndroid = true;
            isWindows = false;
            isLinux = false;
            isMac = false;
            is64Bit = false;
        }
        if (equals || (!isAndroid && !isWindows && !isLinux && !isMac)) {
            isIos = true;
            isAndroid = false;
            isWindows = false;
            isLinux = false;
            isMac = false;
            is64Bit = false;
        }
        b = new java.util.HashSet<>();
    }

    public SharedLibraryLoader() {
    }

    public SharedLibraryLoader(java.lang.String str) {
        this.a = str;
    }

    public static synchronized boolean isLoaded(java.lang.String str) {
        boolean contains;
        synchronized (com.badlogic.gdx.utils.SharedLibraryLoader.class) {
            contains = b.contains(str);
        }
        return contains;
    }

    public static synchronized void setLoaded(java.lang.String str) {
        synchronized (com.badlogic.gdx.utils.SharedLibraryLoader.class) {
            b.add(str);
        }
    }

    public final boolean a(java.io.File file) {
        try {
            java.lang.reflect.Method method = java.io.File.class.getMethod("canExecute", new java.lang.Class[0]);
            if (((java.lang.Boolean) method.invoke(file, new java.lang.Object[0])).booleanValue()) {
                return true;
            }
            java.lang.Class cls = java.lang.Boolean.TYPE;
            java.io.File.class.getMethod("setExecutable", cls, cls).invoke(file, java.lang.Boolean.TRUE, java.lang.Boolean.FALSE);
            return ((java.lang.Boolean) method.invoke(file, new java.lang.Object[0])).booleanValue();
        } catch (java.lang.Exception unused) {
            return false;
        }
    }

    public final boolean b(java.io.File file) {
        java.io.File parentFile = file.getParentFile();
        if (!file.exists()) {
            parentFile.mkdirs();
            if (!parentFile.isDirectory()) {
                return false;
            }
        } else {
            if (!file.canWrite() || !a(file)) {
                return false;
            }
            file = new java.io.File(parentFile, java.util.UUID.randomUUID().toString());
        }
        try {
            new java.io.FileOutputStream(file).close();
            if (a(file)) {
                file.delete();
                return true;
            }
            file.delete();
            return false;
        } catch (java.lang.Throwable unused) {
            file.delete();
            return false;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x003b A[Catch: IOException -> 0x0040, LOOP:0: B:11:0x002d->B:13:0x003b, LOOP_END, TRY_LEAVE, TryCatch #1 {IOException -> 0x0040, blocks: (B:10:0x0019, B:11:0x002d, B:15:0x0034, B:13:0x003b), top: B:9:0x0019 }] */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0034 A[EDGE_INSN: B:14:0x0034->B:15:0x0034 BREAK  A[LOOP:0: B:11:0x002d->B:13:0x003b], SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final java.io.File c(java.lang.String str, java.lang.String str2, java.io.File file) throws java.io.IOException {
        java.lang.String crc;
        java.io.InputStream g;
        java.io.FileOutputStream fileOutputStream;
        byte[] bArr;
        int read;
        try {
            if (file.exists()) {
                try {
                    crc = crc(new java.io.FileInputStream(file));
                } catch (java.io.FileNotFoundException unused) {
                }
                if (crc != null || !crc.equals(str2)) {
                    g = g(str);
                    file.getParentFile().mkdirs();
                    fileOutputStream = new java.io.FileOutputStream(file);
                    bArr = new byte[4096];
                    while (true) {
                        read = g.read(bArr);
                        if (read != -1) {
                            break;
                        }
                        fileOutputStream.write(bArr, 0, read);
                    }
                    g.close();
                    fileOutputStream.close();
                }
                return file;
            }
            g = g(str);
            file.getParentFile().mkdirs();
            fileOutputStream = new java.io.FileOutputStream(file);
            bArr = new byte[4096];
            while (true) {
                read = g.read(bArr);
                if (read != -1) {
                }
                fileOutputStream.write(bArr, 0, read);
            }
            g.close();
            fileOutputStream.close();
            return file;
        } catch (java.io.IOException e) {
            throw new com.badlogic.gdx.utils.GdxRuntimeException("Error extracting file: " + str + "\nTo: " + file.getAbsolutePath(), e);
        }
        crc = null;
        if (crc != null) {
        }
    }

    public java.lang.String crc(java.io.InputStream inputStream) {
        if (inputStream == null) {
            throw new java.lang.IllegalArgumentException("input cannot be null.");
        }
        java.util.zip.CRC32 crc32 = new java.util.zip.CRC32();
        byte[] bArr = new byte[4096];
        while (true) {
            try {
                int read = inputStream.read(bArr);
                if (read == -1) {
                    break;
                }
                crc32.update(bArr, 0, read);
            } catch (java.lang.Exception unused) {
                com.badlogic.gdx.utils.StreamUtils.closeQuietly(inputStream);
            }
        }
        return java.lang.Long.toString(crc32.getValue(), 16);
    }

    public final java.io.File d(java.lang.String str, java.lang.String str2) {
        java.io.File file = new java.io.File(java.lang.System.getProperty("java.io.tmpdir") + "/libgdx" + java.lang.System.getProperty("user.name") + net.lingala.zip4j.util.InternalZipConstants.ZIP_FILE_SEPARATOR + str, str2);
        if (b(file)) {
            return file;
        }
        try {
            java.io.File createTempFile = java.io.File.createTempFile(str, null);
            if (createTempFile.delete()) {
                java.io.File file2 = new java.io.File(createTempFile, str2);
                if (b(file2)) {
                    return file2;
                }
            }
        } catch (java.io.IOException unused) {
        }
        java.io.File file3 = new java.io.File(java.lang.System.getProperty(org.apache.tools.ant.launch.Launcher.USER_HOMEDIR) + "/.libgdx/" + str, str2);
        if (b(file3)) {
            return file3;
        }
        java.io.File file4 = new java.io.File(".temp/" + str, str2);
        if (b(file4)) {
            return file4;
        }
        if (java.lang.System.getenv("APP_SANDBOX_CONTAINER_ID") != null) {
            return file;
        }
        return null;
    }

    public final java.lang.Throwable e(java.lang.String str, java.lang.String str2, java.io.File file) {
        try {
            java.lang.System.load(c(str, str2, file).getAbsolutePath());
            return null;
        } catch (java.lang.Throwable th) {
            return th;
        }
    }

    public java.io.File extractFile(java.lang.String str, java.lang.String str2) throws java.io.IOException {
        try {
            java.lang.String crc = crc(g(str));
            if (str2 == null) {
                str2 = crc;
            }
            java.io.File d = d(str2, new java.io.File(str).getName());
            if (d == null && (d = d(java.util.UUID.randomUUID().toString(), new java.io.File(str).getName())) == null) {
                throw new com.badlogic.gdx.utils.GdxRuntimeException("Unable to find writable path to extract file. Is the user home directory writable?");
            }
            return c(str, crc, d);
        } catch (java.lang.RuntimeException e) {
            java.io.File file = new java.io.File(java.lang.System.getProperty("java.library.path"), str);
            if (file.exists()) {
                return file;
            }
            throw e;
        }
    }

    public void extractFileTo(java.lang.String str, java.io.File file) throws java.io.IOException {
        c(str, crc(g(str)), new java.io.File(file, new java.io.File(str).getName()));
    }

    public final void f(java.lang.String str) {
        java.lang.String crc = crc(g(str));
        java.lang.String name = new java.io.File(str).getName();
        java.lang.Throwable e = e(str, crc, new java.io.File(java.lang.System.getProperty("java.io.tmpdir") + "/libgdx" + java.lang.System.getProperty("user.name") + net.lingala.zip4j.util.InternalZipConstants.ZIP_FILE_SEPARATOR + crc, name));
        if (e == null) {
            return;
        }
        try {
            java.io.File createTempFile = java.io.File.createTempFile(crc, null);
            if (createTempFile.delete()) {
                if (e(str, crc, createTempFile) == null) {
                    return;
                }
            }
        } catch (java.lang.Throwable unused) {
        }
        if (e(str, crc, new java.io.File(java.lang.System.getProperty(org.apache.tools.ant.launch.Launcher.USER_HOMEDIR) + "/.libgdx/" + crc, name)) == null) {
            return;
        }
        if (e(str, crc, new java.io.File(".temp/" + crc, name)) == null) {
            return;
        }
        java.io.File file = new java.io.File(java.lang.System.getProperty("java.library.path"), str);
        if (!file.exists()) {
            throw new com.badlogic.gdx.utils.GdxRuntimeException(e);
        }
        java.lang.System.load(file.getAbsolutePath());
    }

    public final java.io.InputStream g(java.lang.String str) {
        if (this.a == null) {
            java.io.InputStream resourceAsStream = com.badlogic.gdx.utils.SharedLibraryLoader.class.getResourceAsStream(net.lingala.zip4j.util.InternalZipConstants.ZIP_FILE_SEPARATOR + str);
            if (resourceAsStream != null) {
                return resourceAsStream;
            }
            throw new com.badlogic.gdx.utils.GdxRuntimeException("Unable to read file for extraction: " + str);
        }
        try {
            java.util.zip.ZipFile zipFile = new java.util.zip.ZipFile(this.a);
            java.util.zip.ZipEntry entry = zipFile.getEntry(str);
            if (entry != null) {
                return zipFile.getInputStream(entry);
            }
            throw new com.badlogic.gdx.utils.GdxRuntimeException("Couldn't find '" + str + "' in JAR: " + this.a);
        } catch (java.io.IOException e) {
            throw new com.badlogic.gdx.utils.GdxRuntimeException("Error reading '" + str + "' in JAR: " + this.a, e);
        }
    }

    public void load(java.lang.String str) {
        if (isIos) {
            return;
        }
        synchronized (com.badlogic.gdx.utils.SharedLibraryLoader.class) {
            if (isLoaded(str)) {
                return;
            }
            java.lang.String mapLibraryName = mapLibraryName(str);
            try {
                if (isAndroid) {
                    com.moji.MJLibraryLoader mJLibraryLoader = com.moji.MJLoader.getMJLibraryLoader();
                    if (mJLibraryLoader != null) {
                        mJLibraryLoader.load(str);
                    } else {
                        java.lang.System.loadLibrary(mapLibraryName);
                    }
                } else {
                    f(mapLibraryName);
                }
                setLoaded(str);
            } catch (java.lang.Throwable th) {
                java.lang.StringBuilder sb = new java.lang.StringBuilder();
                sb.append("Couldn't load shared library '");
                sb.append(mapLibraryName);
                sb.append("' for target: ");
                sb.append(java.lang.System.getProperty("os.name"));
                sb.append(is64Bit ? ", 64-bit" : ", 32-bit");
                throw new com.badlogic.gdx.utils.GdxRuntimeException(sb.toString(), th);
            }
        }
    }

    public java.lang.String mapLibraryName(java.lang.String str) {
        java.lang.String str2;
        if (isWindows) {
            java.lang.StringBuilder sb = new java.lang.StringBuilder();
            sb.append(str);
            sb.append(is64Bit ? "64.dll" : ".dll");
            return sb.toString();
        }
        if (!isLinux) {
            if (!isMac) {
                return str;
            }
            java.lang.StringBuilder sb2 = new java.lang.StringBuilder();
            sb2.append("lib");
            sb2.append(str);
            sb2.append(is64Bit ? "64.dylib" : ".dylib");
            return sb2.toString();
        }
        java.lang.StringBuilder sb3 = new java.lang.StringBuilder();
        sb3.append("lib");
        sb3.append(str);
        if (isARM) {
            str2 = "arm" + abi;
        } else {
            str2 = "";
        }
        sb3.append(str2);
        sb3.append(is64Bit ? "64.so" : ".so");
        return sb3.toString();
    }
}
