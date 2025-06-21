package com.umeng.commonsdk.stateless;

/* loaded from: classes19.dex */
public class d {
    public static int a;
    private static java.lang.Object b = new java.lang.Object();

    /* renamed from: com.umeng.commonsdk.stateless.d$1, reason: invalid class name */
    public static class AnonymousClass1 implements java.util.Comparator<java.io.File> {
        @Override // java.util.Comparator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(java.io.File file, java.io.File file2) {
            long lastModified = file.lastModified() - file2.lastModified();
            if (lastModified > 0) {
                return 1;
            }
            return lastModified == 0 ? 0 : -1;
        }
    }

    /* renamed from: com.umeng.commonsdk.stateless.d$2, reason: invalid class name */
    public static class AnonymousClass2 implements java.util.Comparator<java.io.File> {
        @Override // java.util.Comparator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(java.io.File file, java.io.File file2) {
            long lastModified = file.lastModified() - file2.lastModified();
            if (lastModified > 0) {
                return 1;
            }
            return lastModified == 0 ? 0 : -1;
        }
    }

    /* renamed from: com.umeng.commonsdk.stateless.d$3, reason: invalid class name */
    public static class AnonymousClass3 implements java.util.Comparator<java.io.File> {
        @Override // java.util.Comparator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(java.io.File file, java.io.File file2) {
            long lastModified = file.lastModified() - file2.lastModified();
            if (lastModified > 0) {
                return 1;
            }
            return lastModified == 0 ? 0 : -1;
        }
    }

    /* renamed from: com.umeng.commonsdk.stateless.d$4, reason: invalid class name */
    public static class AnonymousClass4 implements java.util.Comparator<java.io.File> {
        @Override // java.util.Comparator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(java.io.File file, java.io.File file2) {
            if (file == null || file2 == null || file.lastModified() >= file2.lastModified()) {
                return (file == null || file2 == null || file.lastModified() != file2.lastModified()) ? 1 : 0;
            }
            return -1;
        }
    }

    /* renamed from: com.umeng.commonsdk.stateless.d$5, reason: invalid class name */
    public static class AnonymousClass5 implements java.io.FilenameFilter {
        final /* synthetic */ java.lang.String a;

        public AnonymousClass5(java.lang.String str) {
            this.a = str;
        }

        @Override // java.io.FilenameFilter
        public boolean accept(java.io.File file, java.lang.String str) {
            return str.startsWith(this.a);
        }
    }

    /* renamed from: com.umeng.commonsdk.stateless.d$6, reason: invalid class name */
    public static class AnonymousClass6 implements java.util.Comparator<java.io.File> {
        @Override // java.util.Comparator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(java.io.File file, java.io.File file2) {
            if (file == null || file2 == null || file.lastModified() >= file2.lastModified()) {
                return (file == null || file2 == null || file.lastModified() != file2.lastModified()) ? 1 : 0;
            }
            return -1;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:34:0x006b, code lost:
    
        if (r1 == null) goto L33;
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x0063, code lost:
    
        r1.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:41:0x0061, code lost:
    
        if (r1 == null) goto L33;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static int a(android.content.Context context, java.lang.String str, java.lang.String str2, byte[] bArr) {
        int i = 101;
        if (context != null) {
            java.io.FileOutputStream fileOutputStream = null;
            try {
                try {
                    synchronized (b) {
                        try {
                            java.lang.StringBuilder sb = new java.lang.StringBuilder();
                            sb.append(context.getFilesDir());
                            java.lang.String str3 = java.io.File.separator;
                            sb.append(str3);
                            sb.append(str);
                            java.io.File file = new java.io.File(sb.toString());
                            if (!file.isDirectory()) {
                                file.mkdir();
                            }
                            java.io.FileOutputStream fileOutputStream2 = new java.io.FileOutputStream(new java.io.File(file.getPath() + str3 + str2));
                            try {
                                fileOutputStream2.write(bArr);
                                fileOutputStream2.close();
                                i = 0;
                            } catch (java.lang.Throwable th) {
                                th = th;
                                fileOutputStream = fileOutputStream2;
                                throw th;
                            }
                        } catch (java.lang.Throwable th2) {
                            th = th2;
                        }
                    }
                } catch (java.lang.Throwable th3) {
                    if (0 != 0) {
                        try {
                            fileOutputStream.close();
                        } catch (java.lang.Throwable unused) {
                        }
                    }
                    throw th3;
                }
            } catch (java.io.IOException e) {
                com.umeng.commonsdk.internal.crash.UMCrashManager.reportCrash(context, e);
            } catch (java.lang.Throwable th4) {
                com.umeng.commonsdk.internal.crash.UMCrashManager.reportCrash(context, th4);
            }
        }
        return i;
    }

    public static java.io.File a(android.content.Context context) {
        java.io.File[] listFiles;
        java.io.File[] listFiles2;
        java.io.File file = null;
        try {
            synchronized (b) {
                com.umeng.commonsdk.statistics.common.ULog.i("walle", "get last envelope begin, thread is " + java.lang.Thread.currentThread());
                if (context != null && context.getApplicationContext() != null) {
                    java.lang.String str = context.getApplicationContext().getFilesDir() + java.io.File.separator + com.umeng.commonsdk.stateless.a.e;
                    if (!android.text.TextUtils.isEmpty(str)) {
                        java.io.File file2 = new java.io.File(str);
                        if (file2.isDirectory() && (listFiles = file2.listFiles()) != null && listFiles.length > 0) {
                            for (java.io.File file3 : listFiles) {
                                if (file3 != null && file3.isDirectory() && (listFiles2 = file3.listFiles()) != null && listFiles2.length > 0) {
                                    java.util.Arrays.sort(listFiles2, new com.umeng.commonsdk.stateless.d.AnonymousClass1());
                                    java.io.File file4 = listFiles2[0];
                                    if (file4 != null && (file == null || file.lastModified() > file4.lastModified())) {
                                        file = file4;
                                    }
                                }
                            }
                        }
                    }
                }
                com.umeng.commonsdk.statistics.common.ULog.i("walle", "get last envelope end, thread is " + java.lang.Thread.currentThread());
            }
        } catch (java.lang.Throwable th) {
            com.umeng.commonsdk.internal.crash.UMCrashManager.reportCrash(context, th);
        }
        return file;
    }

    public static java.lang.String a(android.content.Context context, boolean z) {
        java.lang.String str;
        java.lang.String str2 = null;
        if (context == null) {
            return null;
        }
        try {
            if (z) {
                str = context.getApplicationContext().getFilesDir() + java.io.File.separator + com.umeng.commonsdk.stateless.a.e;
            } else {
                str = context.getApplicationContext().getFilesDir() + java.io.File.separator + com.umeng.commonsdk.stateless.a.f;
            }
            str2 = str;
            return str2;
        } catch (java.lang.Throwable unused) {
            return str2;
        }
    }

    public static void a(android.content.Context context, java.lang.String str, int i) {
        try {
            if (str == null) {
                com.umeng.commonsdk.statistics.common.ULog.i("AmapLBS", "[lbs-build] fileDir not exist, thread is " + java.lang.Thread.currentThread());
                return;
            }
            java.io.File file = new java.io.File(str);
            if (!file.isDirectory()) {
                com.umeng.commonsdk.statistics.common.ULog.i("AmapLBS", "[lbs-build] fileDir not exist, thread is " + java.lang.Thread.currentThread());
                return;
            }
            synchronized (b) {
                java.io.File[] listFiles = file.listFiles();
                com.umeng.commonsdk.statistics.common.ULog.i("AmapLBS", "[lbs-build] delete file begin " + listFiles.length + ", thread is " + java.lang.Thread.currentThread());
                if (listFiles.length >= i) {
                    com.umeng.commonsdk.statistics.common.ULog.i("AmapLBS", "[lbs-build] file size >= max");
                    java.util.ArrayList arrayList = new java.util.ArrayList();
                    for (java.io.File file2 : listFiles) {
                        if (file2 != null) {
                            arrayList.add(file2);
                        }
                    }
                    if (arrayList.size() >= i) {
                        java.util.Collections.sort(arrayList, new com.umeng.commonsdk.stateless.d.AnonymousClass4());
                        if (com.umeng.commonsdk.statistics.common.ULog.DEBUG) {
                            for (int i2 = 0; i2 < arrayList.size(); i2++) {
                                com.umeng.commonsdk.statistics.common.ULog.i("AmapLBS", "[lbs-build] overrun native file is " + ((java.io.File) arrayList.get(i2)).getPath());
                            }
                        }
                        for (int i3 = 0; i3 <= arrayList.size() - i; i3++) {
                            if (arrayList.get(i3) != null) {
                                com.umeng.commonsdk.statistics.common.ULog.i("AmapLBS", "[lbs-build] overrun remove file is " + ((java.io.File) arrayList.get(i3)).getPath());
                                try {
                                    ((java.io.File) arrayList.get(i3)).delete();
                                    arrayList.remove(i3);
                                } catch (java.lang.Exception unused) {
                                }
                            }
                        }
                    }
                } else {
                    com.umeng.commonsdk.statistics.common.ULog.i("AmapLBS", "[lbs-build] file size < max");
                }
                com.umeng.commonsdk.statistics.common.ULog.i("AmapLBS", "[lbs-build] delete file end " + listFiles.length + ", thread is " + java.lang.Thread.currentThread());
            }
        } catch (java.lang.Throwable th) {
            com.umeng.commonsdk.internal.crash.UMCrashManager.reportCrash(context, th);
        }
    }

    public static void a(android.content.Context context, java.lang.String str, java.lang.String str2, int i) {
        if (str == null) {
            return;
        }
        try {
            java.io.File file = new java.io.File(str);
            if (file.isDirectory()) {
                synchronized (b) {
                    java.io.File[] listFiles = file.listFiles(new com.umeng.commonsdk.stateless.d.AnonymousClass5(str2));
                    if (listFiles == null || listFiles.length < i) {
                        com.umeng.commonsdk.statistics.common.ULog.i("AmapLBS", "[lbs-build] file size < max");
                    } else {
                        com.umeng.commonsdk.statistics.common.ULog.i("AmapLBS", "[lbs-build] file size >= max");
                        java.util.ArrayList arrayList = new java.util.ArrayList();
                        for (java.io.File file2 : listFiles) {
                            if (file2 != null) {
                                arrayList.add(file2);
                            }
                        }
                        if (arrayList.size() >= i) {
                            java.util.Collections.sort(arrayList, new com.umeng.commonsdk.stateless.d.AnonymousClass6());
                            if (com.umeng.commonsdk.statistics.common.ULog.DEBUG) {
                                for (int i2 = 0; i2 < arrayList.size(); i2++) {
                                    com.umeng.commonsdk.statistics.common.ULog.i("AmapLBS", "[lbs-build] overrun native file is " + ((java.io.File) arrayList.get(i2)).getPath());
                                }
                            }
                            for (int i3 = 0; i3 <= arrayList.size() - i; i3++) {
                                if (arrayList.get(i3) != null) {
                                    com.umeng.commonsdk.statistics.common.ULog.i("AmapLBS", "[lbs-build] overrun remove file is " + ((java.io.File) arrayList.get(i3)).getPath());
                                    try {
                                        ((java.io.File) arrayList.get(i3)).delete();
                                        arrayList.remove(i3);
                                    } catch (java.lang.Exception unused) {
                                    }
                                }
                            }
                        }
                    }
                    com.umeng.commonsdk.statistics.common.ULog.i("AmapLBS", "[lbs-build] delete file end " + listFiles.length + ", thread is " + java.lang.Thread.currentThread());
                }
            }
        } catch (java.lang.Throwable th) {
            com.umeng.commonsdk.internal.crash.UMCrashManager.reportCrash(context, th);
        }
    }

    public static boolean a(long j, long j2) {
        return j > j2;
    }

    public static boolean a(java.io.File file) {
        if (file == null) {
            return false;
        }
        if (file.isDirectory()) {
            for (java.lang.String str : file.list()) {
                if (!a(new java.io.File(file, str))) {
                    return false;
                }
            }
        }
        return file.delete();
    }

    public static byte[] a(java.lang.String str) throws java.io.IOException {
        byte[] bArr;
        synchronized (b) {
            java.nio.channels.FileChannel fileChannel = null;
            try {
                try {
                    fileChannel = new java.io.RandomAccessFile(str, "r").getChannel();
                    java.nio.MappedByteBuffer load = fileChannel.map(java.nio.channels.FileChannel.MapMode.READ_ONLY, 0L, fileChannel.size()).load();
                    bArr = new byte[(int) fileChannel.size()];
                    if (load.remaining() > 0) {
                        load.get(bArr, 0, load.remaining());
                    }
                    try {
                        fileChannel.close();
                    } catch (java.lang.Throwable unused) {
                    }
                } catch (java.io.IOException e) {
                    com.umeng.commonsdk.statistics.common.ULog.i("walle", "[stateless] write envelope, e is " + e.getMessage());
                    throw e;
                }
            } catch (java.lang.Throwable th) {
                if (fileChannel != null) {
                    try {
                        fileChannel.close();
                    } catch (java.lang.Throwable unused2) {
                    }
                }
                throw th;
            }
        }
        return bArr;
    }

    public static byte[] a(byte[] bArr) throws java.io.IOException {
        java.io.ByteArrayOutputStream byteArrayOutputStream = null;
        if (bArr == null || bArr.length <= 0) {
            return null;
        }
        java.util.zip.Deflater deflater = new java.util.zip.Deflater();
        deflater.setInput(bArr);
        deflater.finish();
        byte[] bArr2 = new byte[8192];
        a = 0;
        try {
            java.io.ByteArrayOutputStream byteArrayOutputStream2 = new java.io.ByteArrayOutputStream();
            while (!deflater.finished()) {
                try {
                    int deflate = deflater.deflate(bArr2);
                    a += deflate;
                    byteArrayOutputStream2.write(bArr2, 0, deflate);
                } catch (java.lang.Throwable th) {
                    th = th;
                    byteArrayOutputStream = byteArrayOutputStream2;
                    if (byteArrayOutputStream != null) {
                        byteArrayOutputStream.close();
                    }
                    throw th;
                }
            }
            deflater.end();
            byteArrayOutputStream2.close();
            return byteArrayOutputStream2.toByteArray();
        } catch (java.lang.Throwable th2) {
            th = th2;
        }
    }

    public static java.io.File b(android.content.Context context) {
        if (context == null) {
            return null;
        }
        try {
            synchronized (b) {
                java.lang.String str = context.getApplicationContext().getFilesDir() + java.io.File.separator + com.umeng.commonsdk.stateless.a.f;
                if (android.text.TextUtils.isEmpty(str)) {
                    return null;
                }
                java.io.File file = new java.io.File(str);
                synchronized (b) {
                    java.io.File[] listFiles = file.listFiles();
                    if (listFiles != null && listFiles.length != 0) {
                        java.util.Arrays.sort(listFiles, new com.umeng.commonsdk.stateless.d.AnonymousClass2());
                        return listFiles[0];
                    }
                    return null;
                }
            }
        } catch (java.lang.Throwable th) {
            com.umeng.commonsdk.internal.crash.UMCrashManager.reportCrash(context, th);
            return null;
        }
    }

    public static java.lang.String b(java.lang.String str) {
        try {
            return android.util.Base64.encodeToString(str.getBytes(), 0);
        } catch (java.lang.Throwable unused) {
            return "";
        }
    }

    public static java.lang.String b(byte[] bArr) {
        if (bArr == null) {
            return null;
        }
        java.lang.StringBuffer stringBuffer = new java.lang.StringBuffer();
        for (byte b2 : bArr) {
            stringBuffer.append(java.lang.String.format("%02X", java.lang.Byte.valueOf(b2)));
        }
        return stringBuffer.toString().toLowerCase(java.util.Locale.US);
    }

    /* JADX WARN: Code restructure failed: missing block: B:36:0x0101, code lost:
    
        if (r1 == null) goto L44;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static boolean b(android.content.Context context, java.lang.String str, java.lang.String str2, byte[] bArr) {
        boolean z;
        if (context == null) {
            return false;
        }
        java.io.FileOutputStream fileOutputStream = null;
        try {
            try {
                synchronized (b) {
                    try {
                        com.umeng.commonsdk.statistics.common.ULog.i("walle", "[stateless] begin write envelope, thread is " + java.lang.Thread.currentThread());
                        java.io.File file = new java.io.File(context.getFilesDir() + net.lingala.zip4j.util.InternalZipConstants.ZIP_FILE_SEPARATOR + com.umeng.commonsdk.stateless.a.e);
                        if (!file.isDirectory()) {
                            file.mkdir();
                        }
                        java.io.File file2 = new java.io.File(file.getPath() + net.lingala.zip4j.util.InternalZipConstants.ZIP_FILE_SEPARATOR + str);
                        if (!file2.isDirectory()) {
                            file2.mkdir();
                        }
                        java.io.File file3 = new java.io.File(file2.getPath() + net.lingala.zip4j.util.InternalZipConstants.ZIP_FILE_SEPARATOR + str2);
                        if (!file3.exists()) {
                            file3.createNewFile();
                        }
                        java.io.FileOutputStream fileOutputStream2 = new java.io.FileOutputStream(file3);
                        try {
                            fileOutputStream2.write(bArr);
                            fileOutputStream2.close();
                            try {
                                return true;
                            } catch (java.lang.Throwable th) {
                                th = th;
                                z = true;
                                while (true) {
                                    try {
                                        break;
                                    } catch (java.lang.Throwable th2) {
                                        th = th2;
                                    }
                                }
                                throw th;
                            }
                        } catch (java.lang.Throwable th3) {
                            th = th3;
                            fileOutputStream = fileOutputStream2;
                            z = false;
                            while (true) {
                                break;
                                break;
                            }
                            throw th;
                        }
                    } catch (java.lang.Throwable th4) {
                        th = th4;
                    }
                }
                try {
                    break;
                    throw th;
                } catch (java.io.IOException e) {
                    e = e;
                    com.umeng.commonsdk.statistics.common.ULog.i("walle", "[stateless] write envelope, e is " + e.getMessage());
                    com.umeng.commonsdk.internal.crash.UMCrashManager.reportCrash(context, e);
                } catch (java.lang.Throwable th5) {
                    th = th5;
                    com.umeng.commonsdk.statistics.common.ULog.i("walle", "[stateless] write envelope, e is " + th.getMessage());
                    com.umeng.commonsdk.internal.crash.UMCrashManager.reportCrash(context, th);
                    if (fileOutputStream != null) {
                        try {
                            fileOutputStream.close();
                        } catch (java.io.IOException unused) {
                        }
                    }
                    return z;
                }
            } catch (java.lang.Throwable th6) {
                if (fileOutputStream != null) {
                    try {
                        fileOutputStream.close();
                    } catch (java.io.IOException unused2) {
                    }
                }
                throw th6;
            }
        } catch (java.io.IOException e2) {
            e = e2;
            z = false;
        } catch (java.lang.Throwable th7) {
            th = th7;
            z = false;
        }
    }

    public static java.lang.String c(java.lang.String str) {
        try {
            return new java.lang.String(android.util.Base64.decode(str, 0));
        } catch (java.lang.Throwable unused) {
            return "";
        }
    }

    public static java.io.File[] c(android.content.Context context) {
        if (context == null) {
            return null;
        }
        try {
            synchronized (b) {
                java.lang.String str = context.getApplicationContext().getFilesDir() + java.io.File.separator + com.umeng.commonsdk.stateless.a.f;
                if (android.text.TextUtils.isEmpty(str)) {
                    return null;
                }
                java.io.File file = new java.io.File(str);
                synchronized (b) {
                    java.io.File[] listFiles = file.listFiles();
                    if (listFiles != null && listFiles.length != 0) {
                        java.util.Arrays.sort(listFiles, new com.umeng.commonsdk.stateless.d.AnonymousClass3());
                        return listFiles;
                    }
                    return null;
                }
            }
        } catch (java.lang.Throwable th) {
            com.umeng.commonsdk.internal.crash.UMCrashManager.reportCrash(context, th);
            return null;
        }
    }

    public static java.lang.String d(java.lang.String str) {
        int lastIndexOf;
        int lastIndexOf2;
        return (!android.text.TextUtils.isEmpty(str) && str.indexOf("envelope") < 0 && (lastIndexOf = str.lastIndexOf("_")) >= 0 && (lastIndexOf2 = str.lastIndexOf(".")) >= 0) ? str.substring(lastIndexOf + 1, lastIndexOf2) : "";
    }
}
