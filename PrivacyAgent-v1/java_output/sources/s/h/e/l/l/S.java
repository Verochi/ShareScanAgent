package s.h.e.l.l;

/* loaded from: classes.dex */
public final class S extends android.app.Application {
    public static java.lang.String p = null;
    public static android.app.Application n = null;
    public static boolean m = false;
    public static java.lang.String f = null;
    public static boolean l = false;
    public static long sT = 0;
    public static long eT = 0;
    public static long tT = 0;
    public static boolean la = true;

    static {
        java.lang.Object obj;
        java.lang.Object obj2;
        java.lang.Object obj3 = null;
        try {
            obj2 = new java.lang.Object();
            try {
                java.lang.Object obj4 = new java.lang.Object();
                if (obj2 != null) {
                    try {
                        obj2.hashCode();
                    } catch (java.lang.Exception e) {
                    }
                }
                if (obj4 != null) {
                    try {
                        obj4.hashCode();
                    } catch (java.lang.Exception e2) {
                    }
                }
            } catch (java.lang.Exception e3) {
                if (obj2 != null) {
                    try {
                        obj2.hashCode();
                    } catch (java.lang.Exception e4) {
                    }
                }
                if (0 != 0) {
                    try {
                        obj3.hashCode();
                    } catch (java.lang.Exception e5) {
                    }
                }
            } catch (java.lang.Throwable th) {
                obj = obj2;
                th = th;
                if (obj != null) {
                    try {
                        obj.hashCode();
                    } catch (java.lang.Exception e6) {
                    }
                }
                if (0 == 0) {
                    throw th;
                }
                try {
                    obj3.hashCode();
                    throw th;
                } catch (java.lang.Exception e7) {
                    throw th;
                }
            }
        } catch (java.lang.Exception e8) {
            obj2 = null;
        } catch (java.lang.Throwable th2) {
            th = th2;
            obj = null;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x002b A[Catch: Exception -> 0x005a, TryCatch #3 {Exception -> 0x005a, blocks: (B:11:0x0018, B:13:0x002b), top: B:10:0x0018 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static java.lang.String a() {
        java.lang.Object obj;
        java.lang.Object obj2;
        java.lang.Object obj3;
        java.lang.Object obj4 = null;
        try {
            obj2 = new java.lang.Object();
        } catch (java.lang.Exception e) {
            obj2 = null;
        } catch (java.lang.Throwable th) {
            th = th;
            obj = null;
        }
        try {
            try {
                java.lang.Object obj5 = new java.lang.Object();
                if (obj2 != null) {
                    try {
                        obj2.hashCode();
                    } catch (java.lang.Exception e2) {
                    }
                }
                if (obj5 != null) {
                    try {
                        obj5.hashCode();
                    } catch (java.lang.Exception e3) {
                    }
                }
            } catch (java.lang.Exception e4) {
                if (obj2 != null) {
                    try {
                        obj2.hashCode();
                    } catch (java.lang.Exception e5) {
                    }
                }
                if (0 != 0) {
                    try {
                        obj4.hashCode();
                    } catch (java.lang.Exception e6) {
                    }
                }
                java.lang.reflect.Field declaredField = android.os.Build.class.getDeclaredField("SUPPORTED_ABIS");
                declaredField.setAccessible(true);
                obj3 = declaredField.get(null);
                if (obj3 != null) {
                }
                return "armeabi";
            } catch (java.lang.Throwable th2) {
                obj = obj2;
                th = th2;
                if (obj != null) {
                    try {
                        obj.hashCode();
                    } catch (java.lang.Exception e7) {
                    }
                }
                if (0 == 0) {
                    throw th;
                }
                try {
                    obj4.hashCode();
                    throw th;
                } catch (java.lang.Exception e8) {
                    throw th;
                }
            }
            java.lang.reflect.Field declaredField2 = android.os.Build.class.getDeclaredField("SUPPORTED_ABIS");
            declaredField2.setAccessible(true);
            obj3 = declaredField2.get(null);
            if (obj3 != null) {
                if (java.util.Arrays.toString((java.lang.String[]) obj3).contains("x86")) {
                    return "x86";
                }
            }
            return "armeabi";
        } catch (java.lang.Exception e9) {
            try {
                java.lang.reflect.Method declaredMethod = android.os.Build.class.getDeclaredMethod("getString", java.lang.String.class);
                declaredMethod.setAccessible(true);
                return (java.lang.String) declaredMethod.invoke(null, "ro.product.cpu.abi");
            } catch (java.lang.Exception e10) {
                return "armeabi";
            }
        }
    }

    public static void c(java.lang.String str) throws java.io.IOException {
        java.lang.Object obj;
        java.lang.Object obj2;
        java.io.File file;
        java.io.File file2;
        java.util.zip.ZipFile zipFile;
        java.util.zip.ZipEntry entry;
        java.util.zip.ZipEntry entry2;
        java.lang.Object obj3 = null;
        try {
            obj2 = new java.lang.Object();
        } catch (java.lang.Exception e) {
            obj2 = null;
        } catch (java.lang.Throwable th) {
            th = th;
            obj = null;
        }
        try {
            java.lang.Object obj4 = new java.lang.Object();
            if (obj2 != null) {
                try {
                    obj2.hashCode();
                } catch (java.lang.Exception e2) {
                }
            }
            if (obj4 != null) {
                try {
                    obj4.hashCode();
                } catch (java.lang.Exception e3) {
                }
            }
        } catch (java.lang.Exception e4) {
            if (obj2 != null) {
                try {
                    obj2.hashCode();
                } catch (java.lang.Exception e5) {
                }
            }
            if (0 != 0) {
                try {
                    obj3.hashCode();
                } catch (java.lang.Exception e6) {
                }
            }
            java.lang.String format = java.lang.String.format("assets/ijm_lib/%s/libexec.so", str);
            java.lang.String format2 = java.lang.String.format("assets/ijm_lib/%s/libexecmain.so", str);
            file = new java.io.File(p, "libexec.so");
            file2 = new java.io.File(p, "libexecmain.so");
            zipFile = new java.util.zip.ZipFile(f);
            entry = zipFile.getEntry(format);
            if (entry != null) {
                c(zipFile, entry, file);
            }
            if (m) {
                c(zipFile, entry2, file2);
            }
            zipFile.close();
        } catch (java.lang.Throwable th2) {
            obj = obj2;
            th = th2;
            if (obj != null) {
                try {
                    obj.hashCode();
                } catch (java.lang.Exception e7) {
                }
            }
            if (0 == 0) {
                throw th;
            }
            try {
                obj3.hashCode();
                throw th;
            } catch (java.lang.Exception e8) {
                throw th;
            }
        }
        java.lang.String format3 = java.lang.String.format("assets/ijm_lib/%s/libexec.so", str);
        java.lang.String format22 = java.lang.String.format("assets/ijm_lib/%s/libexecmain.so", str);
        file = new java.io.File(p, "libexec.so");
        file2 = new java.io.File(p, "libexecmain.so");
        zipFile = new java.util.zip.ZipFile(f);
        entry = zipFile.getEntry(format3);
        if (entry != null && entry.getCrc() != g(file)) {
            c(zipFile, entry, file);
        }
        if (m && (entry2 = zipFile.getEntry(format22)) != null && entry2.getCrc() != g(file2)) {
            c(zipFile, entry2, file2);
        }
        zipFile.close();
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x0020 A[Catch: IOException -> 0x0063, TryCatch #4 {IOException -> 0x0063, blocks: (B:14:0x0016, B:16:0x0020, B:17:0x0027, B:18:0x0034, B:23:0x003b, B:21:0x005f), top: B:13:0x0016 }] */
    /* JADX WARN: Removed duplicated region for block: B:20:0x005e  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x003b A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void c(java.util.zip.ZipFile zipFile, java.util.zip.ZipEntry zipEntry, java.io.File file) {
        java.lang.Object obj;
        java.lang.Object obj2;
        java.io.InputStream inputStream;
        java.io.FileOutputStream fileOutputStream;
        byte[] bArr;
        int read;
        java.lang.Object obj3 = null;
        try {
            obj2 = new java.lang.Object();
        } catch (java.lang.Exception e) {
            obj2 = null;
        } catch (java.lang.Throwable th) {
            th = th;
            obj = null;
        }
        try {
            try {
                java.lang.Object obj4 = new java.lang.Object();
                if (obj2 != null) {
                    try {
                        obj2.hashCode();
                    } catch (java.lang.Exception e2) {
                    }
                }
                if (obj4 != null) {
                    try {
                        obj4.hashCode();
                    } catch (java.lang.Exception e3) {
                    }
                }
            } catch (java.lang.Exception e4) {
                if (obj2 != null) {
                    try {
                        obj2.hashCode();
                    } catch (java.lang.Exception e5) {
                    }
                }
                if (0 != 0) {
                    try {
                        obj3.hashCode();
                    } catch (java.lang.Exception e6) {
                    }
                }
                if (!file.getParentFile().exists()) {
                }
                inputStream = zipFile.getInputStream(zipEntry);
                fileOutputStream = new java.io.FileOutputStream(file);
                bArr = new byte[1024];
                while (true) {
                    read = inputStream.read(bArr);
                    if (read != -1) {
                    }
                    fileOutputStream.write(bArr, 0, read);
                }
            } catch (java.lang.Throwable th2) {
                obj = obj2;
                th = th2;
                if (obj != null) {
                    try {
                        obj.hashCode();
                    } catch (java.lang.Exception e7) {
                    }
                }
                if (0 == 0) {
                    throw th;
                }
                try {
                    obj3.hashCode();
                    throw th;
                } catch (java.lang.Exception e8) {
                    throw th;
                }
            }
            if (!file.getParentFile().exists()) {
                file.getParentFile().mkdirs();
            }
            inputStream = zipFile.getInputStream(zipEntry);
            fileOutputStream = new java.io.FileOutputStream(file);
            bArr = new byte[1024];
            while (true) {
                read = inputStream.read(bArr);
                if (read != -1) {
                    inputStream.close();
                    fileOutputStream.close();
                    return;
                }
                fileOutputStream.write(bArr, 0, read);
            }
        } catch (java.io.IOException e9) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x003b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static long g(java.io.File file) {
        java.lang.Object obj;
        java.io.FileInputStream fileInputStream;
        java.io.FileInputStream fileInputStream2;
        long j = 0;
        java.util.zip.CheckedInputStream checkedInputStream = null;
        java.lang.Object obj2 = null;
        try {
            obj = new java.lang.Object();
            try {
                java.lang.Object obj3 = new java.lang.Object();
                if (obj != null) {
                    try {
                        obj.hashCode();
                    } catch (java.lang.Exception e) {
                    }
                }
                if (obj3 != null) {
                    try {
                        obj3.hashCode();
                    } catch (java.lang.Exception e2) {
                    }
                }
            } catch (java.lang.Exception e3) {
                if (obj != null) {
                    try {
                        obj.hashCode();
                    } catch (java.lang.Exception e4) {
                    }
                }
                if (0 != 0) {
                    try {
                        obj2.hashCode();
                    } catch (java.lang.Exception e5) {
                    }
                }
                if (file.exists()) {
                }
                return j;
            } catch (java.lang.Throwable th) {
                th = th;
                if (obj != null) {
                    try {
                        obj.hashCode();
                    } catch (java.lang.Exception e6) {
                    }
                }
                if (0 == 0) {
                    throw th;
                }
                try {
                    obj2.hashCode();
                    throw th;
                } catch (java.lang.Exception e7) {
                    throw th;
                }
            }
        } catch (java.lang.Exception e8) {
            obj = null;
        } catch (java.lang.Throwable th2) {
            th = th2;
            obj = null;
        }
        if (file.exists()) {
            java.util.zip.CRC32 crc32 = new java.util.zip.CRC32();
            try {
                fileInputStream = new java.io.FileInputStream(file);
                try {
                    java.util.zip.CheckedInputStream checkedInputStream2 = new java.util.zip.CheckedInputStream(fileInputStream, crc32);
                    try {
                        while (checkedInputStream2.read(new byte[1024]) != -1) {
                        }
                        j = crc32.getValue();
                        if (fileInputStream != null) {
                            try {
                                fileInputStream.close();
                            } catch (java.io.IOException e9) {
                            }
                        }
                        if (checkedInputStream2 != null) {
                            try {
                                checkedInputStream2.close();
                            } catch (java.io.IOException e10) {
                            }
                        }
                    } catch (java.lang.Exception e11) {
                        checkedInputStream = checkedInputStream2;
                        fileInputStream2 = fileInputStream;
                        if (fileInputStream2 != null) {
                            try {
                                fileInputStream2.close();
                            } catch (java.io.IOException e12) {
                            }
                        }
                        if (checkedInputStream != null) {
                            try {
                                checkedInputStream.close();
                            } catch (java.io.IOException e13) {
                            }
                        }
                        return j;
                    } catch (java.lang.Throwable th3) {
                        th = th3;
                        checkedInputStream = checkedInputStream2;
                        if (fileInputStream != null) {
                            try {
                                fileInputStream.close();
                            } catch (java.io.IOException e14) {
                            }
                        }
                        if (checkedInputStream == null) {
                            throw th;
                        }
                        try {
                            checkedInputStream.close();
                            throw th;
                        } catch (java.io.IOException e15) {
                            throw th;
                        }
                    }
                } catch (java.lang.Exception e16) {
                    fileInputStream2 = fileInputStream;
                } catch (java.lang.Throwable th4) {
                    th = th4;
                }
            } catch (java.lang.Exception e17) {
                fileInputStream2 = null;
            } catch (java.lang.Throwable th5) {
                th = th5;
                fileInputStream = null;
            }
        }
        return j;
    }

    public static void gET() {
        eT = java.lang.System.currentTimeMillis();
        tT = eT - sT;
    }

    public static void gST() {
        sT = java.lang.System.currentTimeMillis();
    }

    /* JADX WARN: Can't wrap try/catch for region: R(13:0|1|2|3|(4:5|6|(2:57|58)|(2:53|54))|9|10|11|(3:12|13|(2:15|(1:19)(2:32|31))(1:33))|22|(2:26|27)|24|(1:(0))) */
    /* JADX WARN: Code restructure failed: missing block: B:51:0x0073, code lost:
    
        r0 = th;
     */
    /* JADX WARN: Code restructure failed: missing block: B:52:0x0074, code lost:
    
        r2 = null;
     */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0050 A[Catch: all -> 0x0089, Exception -> 0x008b, TRY_ENTER, TryCatch #16 {Exception -> 0x008b, all -> 0x0089, blocks: (B:13:0x0028, B:15:0x0050, B:17:0x0058, B:19:0x0060), top: B:12:0x0028 }] */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0030 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:33:0x002e A[EDGE_INSN: B:33:0x002e->B:23:0x002e BREAK  A[LOOP:0: B:12:0x0028->B:30:?], SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static boolean il() {
        java.lang.Object obj;
        java.lang.Object obj2;
        java.io.BufferedReader bufferedReader;
        java.lang.String readLine;
        java.io.BufferedReader bufferedReader2 = null;
        java.lang.Object obj3 = null;
        try {
            obj2 = new java.lang.Object();
        } catch (java.lang.Exception e) {
            obj2 = null;
        } catch (java.lang.Throwable th) {
            th = th;
            obj = null;
        }
        try {
            java.lang.Object obj4 = new java.lang.Object();
            if (obj2 != null) {
                try {
                    obj2.hashCode();
                } catch (java.lang.Exception e2) {
                }
            }
            if (obj4 != null) {
                try {
                    obj4.hashCode();
                } catch (java.lang.Exception e3) {
                }
            }
        } catch (java.lang.Exception e4) {
            if (obj2 != null) {
                try {
                    obj2.hashCode();
                } catch (java.lang.Exception e5) {
                }
            }
            if (0 != 0) {
                try {
                    obj3.hashCode();
                } catch (java.lang.Exception e6) {
                }
            }
            boolean z = false;
            bufferedReader = new java.io.BufferedReader(new java.io.InputStreamReader(new java.io.FileInputStream("/proc/self/maps")));
            do {
                try {
                    readLine = bufferedReader.readLine();
                    if (readLine == null) {
                    }
                } catch (java.lang.Exception e7) {
                    bufferedReader2 = bufferedReader;
                    if (bufferedReader2 != null) {
                        try {
                            bufferedReader2.close();
                        } catch (java.io.IOException e8) {
                        }
                    }
                    return z;
                } catch (java.lang.Throwable th2) {
                    th = th2;
                    if (bufferedReader != null) {
                        try {
                            bufferedReader.close();
                        } catch (java.io.IOException e9) {
                        }
                    }
                    throw th;
                }
            } while (!readLine.contains("/bin/linker64"));
            z = true;
            if (bufferedReader != null) {
            }
            return z;
        } catch (java.lang.Throwable th3) {
            obj = obj2;
            th = th3;
            if (obj != null) {
                try {
                    obj.hashCode();
                } catch (java.lang.Exception e10) {
                }
            }
            if (0 == 0) {
                throw th;
            }
            try {
                obj3.hashCode();
                throw th;
            } catch (java.lang.Exception e11) {
                throw th;
            }
        }
        boolean z2 = false;
        bufferedReader = new java.io.BufferedReader(new java.io.InputStreamReader(new java.io.FileInputStream("/proc/self/maps")));
        do {
            readLine = bufferedReader.readLine();
            if (readLine == null) {
                break;
            }
            if (readLine.contains("/lib64/libart.so") || readLine.contains("/lib64/libaoc.so")) {
                break;
            }
        } while (!readLine.contains("/bin/linker64"));
        z2 = true;
        if (bufferedReader != null) {
            try {
                bufferedReader.close();
            } catch (java.io.IOException e12) {
            }
        }
        return z2;
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x001a A[Catch: Exception -> 0x0079, TryCatch #5 {Exception -> 0x0079, blocks: (B:13:0x0016, B:15:0x001a, B:16:0x0024, B:18:0x0028, B:19:0x002e, B:22:0x0040, B:24:0x0049, B:26:0x004f, B:29:0x0072, B:31:0x0082, B:33:0x0088, B:35:0x008e), top: B:12:0x0016 }] */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0028 A[Catch: Exception -> 0x0079, TryCatch #5 {Exception -> 0x0079, blocks: (B:13:0x0016, B:15:0x001a, B:16:0x0024, B:18:0x0028, B:19:0x002e, B:22:0x0040, B:24:0x0049, B:26:0x004f, B:29:0x0072, B:31:0x0082, B:33:0x0088, B:35:0x008e), top: B:12:0x0016 }] */
    /* JADX WARN: Removed duplicated region for block: B:33:0x0088 A[Catch: Exception -> 0x0079, TryCatch #5 {Exception -> 0x0079, blocks: (B:13:0x0016, B:15:0x001a, B:16:0x0024, B:18:0x0028, B:19:0x002e, B:22:0x0040, B:24:0x0049, B:26:0x004f, B:29:0x0072, B:31:0x0082, B:33:0x0088, B:35:0x008e), top: B:12:0x0016 }] */
    /* JADX WARN: Removed duplicated region for block: B:35:0x008e A[Catch: Exception -> 0x0079, TRY_LEAVE, TryCatch #5 {Exception -> 0x0079, blocks: (B:13:0x0016, B:15:0x001a, B:16:0x0024, B:18:0x0028, B:19:0x002e, B:22:0x0040, B:24:0x0049, B:26:0x004f, B:29:0x0072, B:31:0x0082, B:33:0x0088, B:35:0x008e), top: B:12:0x0016 }] */
    /* JADX WARN: Removed duplicated region for block: B:37:0x00a7  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void l(android.content.Context context) {
        java.lang.Object obj;
        java.lang.Object obj2;
        java.lang.String ld;
        java.lang.Object obj3 = null;
        try {
            obj2 = new java.lang.Object();
            try {
                java.lang.Object obj4 = new java.lang.Object();
                if (obj2 != null) {
                    try {
                        obj2.hashCode();
                    } catch (java.lang.Exception e) {
                    }
                }
                if (obj4 != null) {
                    try {
                        obj4.hashCode();
                    } catch (java.lang.Exception e2) {
                    }
                }
            } catch (java.lang.Exception e3) {
                if (obj2 != null) {
                    try {
                        obj2.hashCode();
                    } catch (java.lang.Exception e4) {
                    }
                }
                if (0 != 0) {
                    try {
                        obj3.hashCode();
                    } catch (java.lang.Exception e5) {
                    }
                }
                if (p == null) {
                }
                if (f == null) {
                }
                java.lang.String a = a();
                ld = ld(context);
                if (ld.equals("")) {
                }
                if (ld == null) {
                }
                if (il()) {
                }
            } catch (java.lang.Throwable th) {
                obj = obj2;
                th = th;
                if (obj != null) {
                    try {
                        obj.hashCode();
                    } catch (java.lang.Exception e6) {
                    }
                }
                if (0 == 0) {
                    throw th;
                }
                try {
                    obj3.hashCode();
                    throw th;
                } catch (java.lang.Exception e7) {
                    throw th;
                }
            }
        } catch (java.lang.Exception e8) {
            obj2 = null;
        } catch (java.lang.Throwable th2) {
            th = th2;
            obj = null;
        }
        try {
            if (p == null) {
                p = context.getFilesDir().getAbsolutePath();
            }
            if (f == null) {
                f = context.getPackageCodePath();
            }
            java.lang.String a2 = a();
            ld = ld(context);
            if (ld.equals("")) {
                ld = a2;
            }
            if (ld == null && ld.contains("x86")) {
                if (il()) {
                    c("x86_64");
                    return;
                } else {
                    c("x86");
                    return;
                }
            }
            if (il()) {
                c("armeabi");
            } else {
                c("arm64-v8a");
            }
        } catch (java.lang.Exception e9) {
            try {
                c("armeabi");
            } catch (java.lang.Exception e10) {
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x001a A[ORIG_RETURN, RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:12:0x0037 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static java.lang.String ld(android.content.Context context) {
        java.lang.Object obj;
        java.lang.Object obj2;
        java.lang.Object obj3 = null;
        try {
            obj2 = new java.lang.Object();
            try {
                java.lang.Object obj4 = new java.lang.Object();
                if (obj2 != null) {
                    try {
                        obj2.hashCode();
                    } catch (java.lang.Exception e) {
                    }
                }
                if (obj4 != null) {
                    try {
                        obj4.hashCode();
                    } catch (java.lang.Exception e2) {
                    }
                }
            } catch (java.lang.Exception e3) {
                if (obj2 != null) {
                    try {
                        obj2.hashCode();
                    } catch (java.lang.Exception e4) {
                    }
                }
                if (0 != 0) {
                    try {
                        obj3.hashCode();
                    } catch (java.lang.Exception e5) {
                    }
                }
                if (context != null) {
                }
            } catch (java.lang.Throwable th) {
                obj = obj2;
                th = th;
                if (obj != null) {
                    try {
                        obj.hashCode();
                    } catch (java.lang.Exception e6) {
                    }
                }
                if (0 == 0) {
                    throw th;
                }
                try {
                    obj3.hashCode();
                    throw th;
                } catch (java.lang.Exception e7) {
                    throw th;
                }
            }
        } catch (java.lang.Exception e8) {
            obj2 = null;
        } catch (java.lang.Throwable th2) {
            th = th2;
            obj = null;
        }
        if (context != null) {
            return "";
        }
        try {
            java.io.InputStream open = context.getAssets().open("images/icon_max_data_encrypted_xxxxx.png");
            if (open == null) {
                return "";
            }
            open.close();
            byte[] bArr = new byte[20];
            java.io.FileInputStream fileInputStream = new java.io.FileInputStream(new java.io.File("/system/bin/linker"));
            if (fileInputStream == null) {
                return "";
            }
            fileInputStream.read(bArr);
            fileInputStream.close();
            switch (bArr[18]) {
                case 3:
                    return "x86";
                case 40:
                    return "armeabi";
                default:
                    return "";
            }
        } catch (java.lang.Exception e9) {
            return "";
        }
    }

    public static void sp() {
        java.lang.Object obj;
        java.lang.Object obj2;
        java.lang.Object obj3 = null;
        try {
            obj2 = new java.lang.Object();
        } catch (java.lang.Exception e) {
            obj2 = null;
        } catch (java.lang.Throwable th) {
            th = th;
            obj = null;
        }
        try {
            try {
                java.lang.Object obj4 = new java.lang.Object();
                if (obj2 != null) {
                    try {
                        obj2.hashCode();
                    } catch (java.lang.Exception e2) {
                    }
                }
                if (obj4 != null) {
                    try {
                        obj4.hashCode();
                    } catch (java.lang.Exception e3) {
                    }
                }
            } catch (java.lang.Exception e4) {
                if (obj2 != null) {
                    try {
                        obj2.hashCode();
                    } catch (java.lang.Exception e5) {
                    }
                }
                if (0 != 0) {
                    try {
                        obj3.hashCode();
                    } catch (java.lang.Exception e6) {
                    }
                }
                java.lang.reflect.Method declaredMethod = java.lang.Class.forName("com.ijm.dataencryption.DETool").getDeclaredMethod("loadDEso", java.lang.String.class, java.lang.String.class, java.lang.String.class);
                declaredMethod.setAccessible(true);
                declaredMethod.invoke(null, f, p, "com.moji.mjweather");
            } catch (java.lang.Throwable th2) {
                obj = obj2;
                th = th2;
                if (obj != null) {
                    try {
                        obj.hashCode();
                    } catch (java.lang.Exception e7) {
                    }
                }
                if (0 == 0) {
                    throw th;
                }
                try {
                    obj3.hashCode();
                    throw th;
                } catch (java.lang.Exception e8) {
                    throw th;
                }
            }
            java.lang.reflect.Method declaredMethod2 = java.lang.Class.forName("com.ijm.dataencryption.DETool").getDeclaredMethod("loadDEso", java.lang.String.class, java.lang.String.class, java.lang.String.class);
            declaredMethod2.setAccessible(true);
            declaredMethod2.invoke(null, f, p, "com.moji.mjweather");
        } catch (java.lang.Exception e9) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x0020  */
    @Override // android.content.ContextWrapper
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    protected void attachBaseContext(android.content.Context context) {
        java.lang.Object obj;
        java.lang.Object obj2;
        gST();
        super.attachBaseContext(context);
        java.lang.Object obj3 = null;
        try {
            obj2 = new java.lang.Object();
        } catch (java.lang.Exception e) {
            obj2 = null;
        } catch (java.lang.Throwable th) {
            th = th;
            obj = null;
        }
        try {
            java.lang.Object obj4 = new java.lang.Object();
            if (obj2 != null) {
                try {
                    obj2.hashCode();
                } catch (java.lang.Exception e2) {
                }
            }
            if (obj4 != null) {
                try {
                    obj4.hashCode();
                } catch (java.lang.Exception e3) {
                }
            }
        } catch (java.lang.Exception e4) {
            if (obj2 != null) {
                try {
                    obj2.hashCode();
                } catch (java.lang.Exception e5) {
                }
            }
            if (0 != 0) {
                try {
                    obj3.hashCode();
                } catch (java.lang.Exception e6) {
                }
            }
            if (la) {
            }
            s.h.e.l.l.N.l(this, "com.moji.mjweather");
            s.h.e.l.l.N.r(this, "com.moji.mjweather.MJApplication");
            gET();
        } catch (java.lang.Throwable th2) {
            obj = obj2;
            th = th2;
            if (obj != null) {
                try {
                    obj.hashCode();
                } catch (java.lang.Exception e7) {
                }
            }
            if (0 == 0) {
                throw th;
            }
            try {
                obj3.hashCode();
                throw th;
            } catch (java.lang.Exception e8) {
                throw th;
            }
        }
        if (la) {
            l(context);
        }
        s.h.e.l.l.N.l(this, "com.moji.mjweather");
        s.h.e.l.l.N.r(this, "com.moji.mjweather.MJApplication");
        gET();
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x001f  */
    @Override // android.app.Application
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void onCreate() {
        java.lang.Object obj;
        java.lang.Object obj2;
        java.lang.Object obj3 = null;
        try {
            obj2 = new java.lang.Object();
        } catch (java.lang.Exception e) {
            obj2 = null;
        } catch (java.lang.Throwable th) {
            th = th;
            obj = null;
        }
        try {
            java.lang.Object obj4 = new java.lang.Object();
            if (obj2 != null) {
                try {
                    obj2.hashCode();
                } catch (java.lang.Exception e2) {
                }
            }
            if (obj4 != null) {
                try {
                    obj4.hashCode();
                } catch (java.lang.Exception e3) {
                }
            }
        } catch (java.lang.Exception e4) {
            if (obj2 != null) {
                try {
                    obj2.hashCode();
                } catch (java.lang.Exception e5) {
                }
            }
            if (0 != 0) {
                try {
                    obj3.hashCode();
                } catch (java.lang.Exception e6) {
                }
            }
            s.h.e.l.l.N.ra(this, "com.moji.mjweather.MJApplication");
            if (n != null) {
            }
            super.onCreate();
        } catch (java.lang.Throwable th2) {
            obj = obj2;
            th = th2;
            if (obj != null) {
                try {
                    obj.hashCode();
                } catch (java.lang.Exception e7) {
                }
            }
            if (0 == 0) {
                throw th;
            }
            try {
                obj3.hashCode();
                throw th;
            } catch (java.lang.Exception e8) {
                throw th;
            }
        }
        s.h.e.l.l.N.ra(this, "com.moji.mjweather.MJApplication");
        if (n != null) {
            n.onCreate();
        }
        super.onCreate();
    }
}
