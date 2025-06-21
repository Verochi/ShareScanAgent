package com.anythink.expressad.foundation.h;

/* loaded from: classes12.dex */
public final class m extends com.anythink.expressad.foundation.h.e {
    public static final int a = 1;
    public static final int b = 2;
    public static final int c = 3;
    public static final int d = 4;
    public static final java.lang.String e = "/download/.at";
    public static final java.lang.String f = "/atdownload";
    private static final java.lang.String g = "SameFileTool";

    /* renamed from: com.anythink.expressad.foundation.h.m$1, reason: invalid class name */
    public class AnonymousClass1 implements java.lang.Runnable {
        @Override // java.lang.Runnable
        public final void run() {
            try {
                if (com.anythink.expressad.foundation.b.a.b().d() != null) {
                    java.lang.String b = com.anythink.expressad.foundation.g.c.d.b(com.anythink.expressad.foundation.g.c.a.ANYTHINK_VC);
                    try {
                        java.io.File file = new java.io.File(b);
                        if (file.exists() && file.isDirectory()) {
                            for (java.io.File file2 : com.anythink.expressad.foundation.h.m.b(b)) {
                                if (file2.exists() && file2.isFile()) {
                                    file2.delete();
                                }
                            }
                        }
                    } catch (java.lang.Exception e) {
                        e.printStackTrace();
                    }
                }
            } catch (java.lang.Exception e2) {
                if (com.anythink.expressad.a.a) {
                    e2.printStackTrace();
                }
            }
        }
    }

    /* renamed from: com.anythink.expressad.foundation.h.m$2, reason: invalid class name */
    public class AnonymousClass2 implements java.lang.Runnable {
        @Override // java.lang.Runnable
        public final void run() {
            try {
                com.anythink.expressad.d.b.a();
                com.anythink.expressad.foundation.b.a.b().e();
                com.anythink.expressad.d.a b = com.anythink.expressad.d.b.b();
                if (b == null) {
                    com.anythink.expressad.d.b.a();
                    b = com.anythink.expressad.d.b.c();
                }
                com.anythink.expressad.foundation.h.m.a(com.anythink.expressad.foundation.g.c.d.b(com.anythink.expressad.foundation.g.c.a.ANYTHINK_RES_MANAGER_DIR), b.b());
                com.anythink.expressad.foundation.h.m.a(java.lang.System.currentTimeMillis() - (b.n() * 1000));
            } catch (java.lang.Exception e) {
                if (com.anythink.expressad.a.a) {
                    e.printStackTrace();
                }
            }
        }
    }

    /* renamed from: com.anythink.expressad.foundation.h.m$3, reason: invalid class name */
    public class AnonymousClass3 implements java.io.FileFilter {
        @Override // java.io.FileFilter
        public final boolean accept(java.io.File file) {
            return !file.isHidden() || file.isDirectory();
        }
    }

    /* renamed from: com.anythink.expressad.foundation.h.m$4, reason: invalid class name */
    public class AnonymousClass4 implements java.util.Comparator<java.io.File> {
        private static int a(java.io.File file, java.io.File file2) {
            long lastModified = file.lastModified() - file2.lastModified();
            if (lastModified > 0) {
                return 1;
            }
            return lastModified == 0 ? 0 : -1;
        }

        @Override // java.util.Comparator
        public final /* synthetic */ int compare(java.io.File file, java.io.File file2) {
            long lastModified = file.lastModified() - file2.lastModified();
            if (lastModified > 0) {
                return 1;
            }
            return lastModified == 0 ? 0 : -1;
        }

        @Override // java.util.Comparator
        public final boolean equals(java.lang.Object obj) {
            return true;
        }
    }

    public static class a {
        public static final int a = 448;
        public static final int b = 256;
        public static final int c = 128;
        public static final int d = 64;
        public static final int e = 56;
        public static final int f = 32;
        public static final int g = 16;
        public static final int h = 8;
        public static final int i = 7;
        public static final int j = 4;
        public static final int k = 2;
        public static final int l = 1;
    }

    private static double a(long j, int i) {
        java.text.DecimalFormat decimalFormat = new java.text.DecimalFormat("#.00");
        if (i == 1) {
            return java.lang.Double.valueOf(decimalFormat.format(j)).doubleValue();
        }
        if (i == 2) {
            return java.lang.Double.valueOf(decimalFormat.format(j / 1024.0d)).doubleValue();
        }
        if (i == 3) {
            return java.lang.Double.valueOf(decimalFormat.format(j / 1048576.0d)).doubleValue();
        }
        if (i != 4) {
            return 0.0d;
        }
        return java.lang.Double.valueOf(decimalFormat.format(j / 1.073741824E9d)).doubleValue();
    }

    /* JADX WARN: Code restructure failed: missing block: B:23:0x003e, code lost:
    
        if (r1 == null) goto L23;
     */
    /* JADX WARN: Removed duplicated region for block: B:31:0x004d A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static java.lang.String a(java.io.File file) {
        java.lang.StringBuffer stringBuffer;
        java.io.BufferedReader bufferedReader;
        java.io.BufferedReader bufferedReader2 = null;
        try {
            bufferedReader = new java.io.BufferedReader(new java.io.FileReader(file));
            try {
                try {
                    stringBuffer = new java.lang.StringBuffer();
                } catch (java.io.IOException e2) {
                    e = e2;
                    stringBuffer = null;
                }
            } catch (java.lang.Throwable th) {
                th = th;
                bufferedReader2 = bufferedReader;
                if (bufferedReader2 != null) {
                    try {
                        bufferedReader2.close();
                    } catch (java.io.IOException unused) {
                    }
                }
                throw th;
            }
        } catch (java.io.IOException e3) {
            e = e3;
            stringBuffer = null;
            bufferedReader = null;
        } catch (java.lang.Throwable th2) {
            th = th2;
            if (bufferedReader2 != null) {
            }
            throw th;
        }
        while (true) {
            try {
                java.lang.String readLine = bufferedReader.readLine();
                if (readLine != null) {
                    stringBuffer.append(readLine + "\n");
                }
            } catch (java.io.IOException e4) {
                e = e4;
                e.printStackTrace();
            }
            try {
                break;
            } catch (java.io.IOException unused2) {
            }
        }
        bufferedReader.close();
        if (stringBuffer != null) {
            return stringBuffer.toString();
        }
        return null;
    }

    /* JADX WARN: Code restructure failed: missing block: B:107:0x00e9, code lost:
    
        r9.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:109:0x00ed, code lost:
    
        r9 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:110:0x00ee, code lost:
    
        r9.printStackTrace();
     */
    /* JADX WARN: Code restructure failed: missing block: B:119:0x0103, code lost:
    
        throw new java.lang.Exception("zipEntry's name is unsafe!");
     */
    /* JADX WARN: Code restructure failed: missing block: B:98:0x00e7, code lost:
    
        if (r9 == null) goto L71;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static java.lang.String a(java.lang.String str, java.lang.String str2) {
        java.io.FileOutputStream fileOutputStream;
        if (str == null || str2 == null) {
            return "unzip srcFile or destDir is null ";
        }
        if (!str2.endsWith(net.lingala.zip4j.util.InternalZipConstants.ZIP_FILE_SEPARATOR)) {
            str2 = str2 + net.lingala.zip4j.util.InternalZipConstants.ZIP_FILE_SEPARATOR;
        }
        java.io.File file = new java.io.File(str);
        if (!file.exists()) {
            return "unzip file not exists";
        }
        java.io.InputStream inputStream = null;
        try {
            java.util.zip.ZipFile zipFile = new java.util.zip.ZipFile(file);
            java.util.Enumeration<? extends java.util.zip.ZipEntry> entries = zipFile.entries();
            fileOutputStream = null;
            while (true) {
                try {
                    java.lang.String str3 = "";
                    if (!entries.hasMoreElements()) {
                        zipFile.close();
                        if (inputStream != null) {
                            try {
                                inputStream.close();
                            } catch (java.io.IOException e2) {
                                e2.printStackTrace();
                            }
                        }
                        if (fileOutputStream != null) {
                            try {
                                fileOutputStream.close();
                            } catch (java.io.IOException e3) {
                                e3.printStackTrace();
                            }
                        }
                        return "";
                    }
                    java.util.zip.ZipEntry nextElement = entries.nextElement();
                    if (nextElement != null) {
                        java.lang.String name = nextElement.getName();
                        if (!android.text.TextUtils.isEmpty(name) && !name.contains("../")) {
                            java.io.File file2 = new java.io.File(str2 + name);
                            try {
                                str3 = file2.getCanonicalPath();
                            } catch (java.io.IOException unused) {
                            }
                            if (android.text.TextUtils.isEmpty(str3) || !str3.startsWith(str2) || str3.startsWith("..") || str3.startsWith("../") || str3.contains("../")) {
                                break;
                            }
                            if (nextElement.isDirectory()) {
                                file2.mkdirs();
                            } else {
                                if (!file2.getParentFile().exists()) {
                                    file2.getParentFile().mkdirs();
                                }
                                java.io.FileOutputStream fileOutputStream2 = new java.io.FileOutputStream(file2);
                                try {
                                    inputStream = zipFile.getInputStream(nextElement);
                                    byte[] bArr = new byte[1024];
                                    while (true) {
                                        int read = inputStream.read(bArr, 0, 1024);
                                        if (read == -1) {
                                            break;
                                        }
                                        fileOutputStream2.write(bArr, 0, read);
                                        fileOutputStream2.flush();
                                    }
                                    fileOutputStream = fileOutputStream2;
                                } catch (java.lang.Throwable th) {
                                    th = th;
                                    fileOutputStream = fileOutputStream2;
                                    try {
                                        if (com.anythink.expressad.a.a) {
                                            th.printStackTrace();
                                        }
                                        java.lang.String message = th.getMessage();
                                        if (inputStream != null) {
                                            try {
                                                inputStream.close();
                                            } catch (java.io.IOException e4) {
                                                e4.printStackTrace();
                                            }
                                        }
                                        if (fileOutputStream != null) {
                                            try {
                                                fileOutputStream.close();
                                            } catch (java.io.IOException e5) {
                                                e5.printStackTrace();
                                            }
                                        }
                                        return message;
                                    } finally {
                                    }
                                }
                            }
                        } else {
                            break;
                        }
                    } else {
                        if (inputStream != null) {
                            try {
                                inputStream.close();
                            } catch (java.io.IOException e6) {
                                e6.printStackTrace();
                            }
                        }
                        if (fileOutputStream != null) {
                            try {
                                fileOutputStream.close();
                            } catch (java.io.IOException e7) {
                                e7.printStackTrace();
                            }
                        }
                        return "unzip zipEntry is null";
                    }
                } catch (java.lang.Throwable th2) {
                    th = th2;
                }
            }
        } catch (java.lang.Throwable th3) {
            th = th3;
            fileOutputStream = null;
        }
        if (fileOutputStream != null) {
            try {
                fileOutputStream.close();
            } catch (java.io.IOException e8) {
                e8.printStackTrace();
            }
        }
        return "unzip zipEntry canonicalPath is not available";
        return "unzip zipEntry canonicalPath is not available";
    }

    public static void a() {
        new java.lang.Thread(new com.anythink.expressad.foundation.h.m.AnonymousClass1()).start();
    }

    public static void a(long j) {
        try {
            java.util.Iterator<java.io.File> it = e(new java.io.File(com.anythink.expressad.foundation.g.c.d.b(com.anythink.expressad.foundation.g.c.a.ANYTHINK_RES_MANAGER_DIR))).iterator();
            while (it.hasNext()) {
                java.io.File next = it.next();
                if (next.lastModified() < j && next.exists() && next.isFile()) {
                    next.delete();
                }
            }
        } catch (java.lang.Throwable th) {
            th.getMessage();
        }
    }

    public static /* synthetic */ void a(java.lang.String str, int i) {
        try {
            if (d(new java.io.File(str)) > i * 1048576) {
                f(str);
            }
        } catch (java.lang.Exception e2) {
            e2.printStackTrace();
        } catch (java.lang.Throwable unused) {
        }
    }

    public static boolean a(java.lang.String str) {
        if (com.anythink.expressad.foundation.g.d.e.a(str)) {
            return false;
        }
        java.io.File file = new java.io.File(str);
        return file.length() > 0 && file.isFile();
    }

    private static boolean a(java.lang.String str, java.lang.String str2, java.lang.String str3) {
        try {
            if (com.anythink.expressad.foundation.h.r.b()) {
                java.lang.StringBuilder sb = new java.lang.StringBuilder();
                sb.append(str);
                java.lang.String str4 = java.io.File.separator;
                sb.append(str4);
                sb.append(str3);
                java.lang.String sb2 = sb.toString();
                java.io.File file = new java.io.File(sb2);
                if (file.exists() && file.isFile() && com.anythink.expressad.foundation.h.r.a(file.length())) {
                    java.io.File file2 = new java.io.File(str2);
                    if (!file2.exists()) {
                        file2.mkdirs();
                    }
                    int b2 = b(sb2, str2 + str4 + str3);
                    if (file.exists() && b2 == 0) {
                        file.delete();
                        return true;
                    }
                }
            }
        } catch (java.lang.Exception e2) {
            e2.printStackTrace();
        }
        return false;
    }

    public static boolean a(byte[] bArr, java.io.File file) {
        java.io.FileOutputStream fileOutputStream;
        java.io.FileOutputStream fileOutputStream2 = null;
        try {
            try {
                if (file.getParentFile() != null && !file.exists()) {
                    file.getParentFile().mkdirs();
                }
                fileOutputStream = new java.io.FileOutputStream(file);
            } catch (java.lang.Exception e2) {
                e = e2;
            }
        } catch (java.lang.Throwable th) {
            th = th;
        }
        try {
            fileOutputStream.write(bArr);
            try {
                fileOutputStream.close();
                return true;
            } catch (java.io.IOException e3) {
                e3.printStackTrace();
                return true;
            }
        } catch (java.lang.Exception e4) {
            e = e4;
            fileOutputStream2 = fileOutputStream;
            e.printStackTrace();
            if (fileOutputStream2 == null) {
                return false;
            }
            try {
                fileOutputStream2.close();
                return false;
            } catch (java.io.IOException e5) {
                e5.printStackTrace();
                return false;
            }
        } catch (java.lang.Throwable th2) {
            th = th2;
            fileOutputStream2 = fileOutputStream;
            if (fileOutputStream2 != null) {
                try {
                    fileOutputStream2.close();
                } catch (java.io.IOException e6) {
                    e6.printStackTrace();
                }
            }
            throw th;
        }
    }

    private static double b(java.lang.String str, int i) {
        long j;
        java.io.File file = new java.io.File(str);
        try {
            j = file.isDirectory() ? d(file) : c(file);
        } catch (java.lang.Exception e2) {
            e2.printStackTrace();
            j = 0;
        }
        java.text.DecimalFormat decimalFormat = new java.text.DecimalFormat("#.00");
        if (i == 1) {
            return java.lang.Double.valueOf(decimalFormat.format(j)).doubleValue();
        }
        if (i == 2) {
            return java.lang.Double.valueOf(decimalFormat.format(j / 1024.0d)).doubleValue();
        }
        if (i == 3) {
            return java.lang.Double.valueOf(decimalFormat.format(j / 1048576.0d)).doubleValue();
        }
        if (i != 4) {
            return 0.0d;
        }
        return java.lang.Double.valueOf(decimalFormat.format(j / 1.073741824E9d)).doubleValue();
    }

    private static int b(java.lang.String str, java.lang.String str2) {
        java.io.FileOutputStream fileOutputStream;
        java.io.FileInputStream fileInputStream = null;
        try {
            if (!com.anythink.expressad.foundation.h.r.a) {
                return -1;
            }
            java.io.FileInputStream fileInputStream2 = new java.io.FileInputStream(str);
            try {
                fileOutputStream = new java.io.FileOutputStream(str2);
                try {
                    byte[] bArr = new byte[1024];
                    while (true) {
                        int read = fileInputStream2.read(bArr);
                        if (read <= 0) {
                            break;
                        }
                        fileOutputStream.write(bArr, 0, read);
                    }
                    java.io.File file = new java.io.File(str2);
                    if (file.exists()) {
                        if (file.isFile()) {
                            try {
                                fileInputStream2.close();
                            } catch (java.io.IOException e2) {
                                e2.printStackTrace();
                            }
                            try {
                                fileOutputStream.close();
                            } catch (java.io.IOException e3) {
                                e3.printStackTrace();
                            }
                            return 0;
                        }
                    }
                    try {
                        fileInputStream2.close();
                    } catch (java.io.IOException e4) {
                        e4.printStackTrace();
                    }
                    try {
                        fileOutputStream.close();
                    } catch (java.io.IOException e5) {
                        e5.printStackTrace();
                    }
                    return -1;
                } catch (java.lang.Exception unused) {
                    fileInputStream = fileInputStream2;
                    if (fileInputStream != null) {
                        try {
                            fileInputStream.close();
                        } catch (java.io.IOException e6) {
                            e6.printStackTrace();
                        }
                    }
                    if (fileOutputStream != null) {
                        try {
                            fileOutputStream.close();
                        } catch (java.io.IOException e7) {
                            e7.printStackTrace();
                        }
                    }
                    return -1;
                } catch (java.lang.Throwable th) {
                    th = th;
                    fileInputStream = fileInputStream2;
                    if (fileInputStream != null) {
                        try {
                            fileInputStream.close();
                        } catch (java.io.IOException e8) {
                            e8.printStackTrace();
                        }
                    }
                    if (fileOutputStream == null) {
                        throw th;
                    }
                    try {
                        fileOutputStream.close();
                        throw th;
                    } catch (java.io.IOException e9) {
                        e9.printStackTrace();
                        throw th;
                    }
                }
            } catch (java.lang.Exception unused2) {
                fileOutputStream = null;
            } catch (java.lang.Throwable th2) {
                th = th2;
                fileOutputStream = null;
            }
        } catch (java.lang.Exception unused3) {
            fileOutputStream = null;
        } catch (java.lang.Throwable th3) {
            th = th3;
            fileOutputStream = null;
        }
    }

    private static java.lang.String b(long j) {
        java.text.DecimalFormat decimalFormat = new java.text.DecimalFormat("#.00");
        if (j == 0) {
            return "0B";
        }
        if (j < 1024) {
            return decimalFormat.format(j) + "B";
        }
        if (j < 1048576) {
            return decimalFormat.format(j / 1024.0d) + "KB";
        }
        if (j < 1073741824) {
            return decimalFormat.format(j / 1048576.0d) + "AT";
        }
        return decimalFormat.format(j / 1.073741824E9d) + "GB";
    }

    public static java.lang.String b(java.io.File file) {
        try {
            if (file.isFile()) {
                file.delete();
                return "";
            }
            if (!file.isDirectory()) {
                return "";
            }
            java.io.File[] listFiles = file.listFiles();
            if (listFiles != null && listFiles.length != 0) {
                for (java.io.File file2 : listFiles) {
                    b(file2);
                }
                file.delete();
                return "";
            }
            file.delete();
            return "";
        } catch (java.lang.Exception e2) {
            return e2.getMessage();
        }
    }

    public static void b() {
        com.anythink.core.common.o.b.b.a().a(new com.anythink.expressad.foundation.h.m.AnonymousClass2());
    }

    public static java.io.File[] b(java.lang.String str) {
        try {
            java.io.File file = new java.io.File(str);
            if (file.exists()) {
                return file.listFiles();
            }
            return null;
        } catch (java.lang.Exception unused) {
            return null;
        }
    }

    private static long c(java.io.File file) {
        long j = 0;
        java.io.FileInputStream fileInputStream = null;
        try {
            try {
                try {
                    if (file.exists()) {
                        java.io.FileInputStream fileInputStream2 = new java.io.FileInputStream(file);
                        try {
                            j = fileInputStream2.available();
                            fileInputStream = fileInputStream2;
                        } catch (java.lang.Exception e2) {
                            e = e2;
                            fileInputStream = fileInputStream2;
                            e.printStackTrace();
                            if (fileInputStream != null) {
                                fileInputStream.close();
                            }
                            return j;
                        } catch (java.lang.Throwable th) {
                            th = th;
                            fileInputStream = fileInputStream2;
                            if (fileInputStream != null) {
                                try {
                                    fileInputStream.close();
                                } catch (java.lang.Exception e3) {
                                    e3.printStackTrace();
                                }
                            }
                            throw th;
                        }
                    } else {
                        file.createNewFile();
                    }
                } catch (java.lang.Exception e4) {
                    e = e4;
                }
                if (fileInputStream != null) {
                    fileInputStream.close();
                }
            } catch (java.lang.Exception e5) {
                e5.printStackTrace();
            }
            return j;
        } catch (java.lang.Throwable th2) {
            th = th2;
        }
    }

    public static void c(java.lang.String str) {
        try {
            if (android.text.TextUtils.isEmpty(str)) {
                return;
            }
            long currentTimeMillis = java.lang.System.currentTimeMillis() - 1440000;
            java.io.File file = new java.io.File(str);
            if (file.exists() && file.isDirectory()) {
                long currentTimeMillis2 = java.lang.System.currentTimeMillis();
                java.io.File[] listFiles = file.listFiles();
                if (listFiles != null) {
                    for (java.io.File file2 : listFiles) {
                        if (file2.lastModified() + currentTimeMillis < currentTimeMillis2) {
                            b(file2);
                            try {
                                java.io.File file3 = new java.io.File(str + ".zip");
                                if (file3.exists() && file3.isFile()) {
                                    b(file3);
                                }
                            } catch (java.lang.Exception unused) {
                            }
                        }
                    }
                }
            }
        } catch (java.lang.Exception unused2) {
        }
    }

    private static void c(java.lang.String str, int i) {
        try {
            if (d(new java.io.File(str)) > i * 1048576) {
                f(str);
            }
        } catch (java.lang.Exception e2) {
            e2.printStackTrace();
        } catch (java.lang.Throwable unused) {
        }
    }

    private static boolean c(java.lang.String str, java.lang.String str2) {
        java.io.File[] listFiles;
        if (str != null) {
            try {
                if (!android.text.TextUtils.isEmpty(str) && str2 != null && !android.text.TextUtils.isEmpty(str2)) {
                    java.io.File file = new java.io.File(str);
                    if (file.isDirectory() && file.listFiles() != null && file.listFiles().length > 0 && (listFiles = file.listFiles()) != null) {
                        for (java.io.File file2 : listFiles) {
                            if (!file2.isFile()) {
                                c(file2.getAbsolutePath(), str2);
                            } else if (str2.equals(file2.getName())) {
                                return true;
                            }
                        }
                    }
                }
            } catch (java.lang.Exception e2) {
                e2.printStackTrace();
            }
        }
        return false;
    }

    private static long d(java.io.File file) {
        java.io.File[] listFiles = file.listFiles();
        long j = 0;
        if (listFiles != null) {
            for (int i = 0; i < listFiles.length; i++) {
                j += listFiles[i].isDirectory() ? d(listFiles[i]) : c(listFiles[i]);
            }
        }
        return j;
    }

    public static java.lang.String d(java.lang.String str) {
        return !android.text.TextUtils.isEmpty(str) ? com.anythink.expressad.foundation.h.p.a(com.anythink.expressad.foundation.h.x.a(str.trim())) : "";
    }

    private static boolean d(java.lang.String str, int i) {
        try {
            java.lang.Class<?> cls = java.lang.Class.forName("android.os.FileUtils");
            java.lang.Class<?> cls2 = java.lang.Integer.TYPE;
            cls.getMethod("setPermissions", java.lang.String.class, cls2, cls2, cls2).invoke(null, str, java.lang.Integer.valueOf(i), -1, -1);
            return true;
        } catch (java.lang.ClassNotFoundException | java.lang.IllegalAccessException | java.lang.IllegalArgumentException | java.lang.NoSuchMethodException | java.lang.reflect.InvocationTargetException unused) {
            return false;
        }
    }

    private static java.lang.String e(java.lang.String str) {
        long j;
        java.io.File file = new java.io.File(str);
        try {
            j = file.isDirectory() ? d(file) : c(file);
        } catch (java.lang.Exception e2) {
            e2.printStackTrace();
            j = 0;
        }
        java.text.DecimalFormat decimalFormat = new java.text.DecimalFormat("#.00");
        if (j == 0) {
            return "0B";
        }
        if (j < 1024) {
            return decimalFormat.format(j) + "B";
        }
        if (j < 1048576) {
            return decimalFormat.format(j / 1024.0d) + "KB";
        }
        if (j < 1073741824) {
            return decimalFormat.format(j / 1048576.0d) + "AT";
        }
        return decimalFormat.format(j / 1.073741824E9d) + "GB";
    }

    private static java.util.ArrayList<java.io.File> e(java.io.File file) {
        java.util.ArrayList<java.io.File> arrayList = new java.util.ArrayList<>();
        for (java.io.File file2 : file.listFiles(new com.anythink.expressad.foundation.h.m.AnonymousClass3())) {
            if (file2.isDirectory()) {
                arrayList.addAll(e(file2));
            } else {
                arrayList.add(file2);
            }
        }
        return arrayList;
    }

    private static void f(java.lang.String str) {
        try {
            java.util.ArrayList<java.io.File> e2 = e(new java.io.File(str));
            java.util.Collections.sort(e2, new com.anythink.expressad.foundation.h.m.AnonymousClass4());
            int size = (e2.size() - 1) / 2;
            for (int i = 0; i < size; i++) {
                java.io.File file = e2.get(i);
                if (file.exists() && file.isFile()) {
                    file.delete();
                }
            }
        } catch (java.lang.Exception unused) {
        }
    }

    private static void g(java.lang.String str) {
        try {
            java.io.File file = new java.io.File(str);
            if (file.exists() && file.isDirectory()) {
                for (java.io.File file2 : b(str)) {
                    if (file2.exists() && file2.isFile()) {
                        file2.delete();
                    }
                }
            }
        } catch (java.lang.Exception e2) {
            e2.printStackTrace();
        }
    }
}
