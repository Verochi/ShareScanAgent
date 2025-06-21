package com.getui.gtc.extension.distribution.gbd.n;

/* loaded from: classes22.dex */
public final class w {
    private static final java.lang.String d = "rs";
    private static com.getui.gtc.extension.distribution.gbd.n.w e;
    private final java.lang.String g;
    private final java.lang.String h = "L2NvbS50ZW5jZW50Lm1tL01pY3JvTXNnL3d4YWZpbGVz\n";
    private final java.lang.String i = "d3g=\n";
    public java.util.Map<java.lang.String, java.util.List<java.lang.String>> a = new java.util.HashMap();
    public java.util.List<java.lang.String> b = new java.util.ArrayList();
    public final java.util.Map<java.lang.String, java.util.Map<java.lang.String, java.lang.Long>> c = new java.util.HashMap();
    private long j = 0;
    private long k = 0;
    private long l = 0;
    private java.lang.String m = "";
    private java.lang.String n = "";
    private final android.content.Context f = com.getui.gtc.extension.distribution.gbd.d.c.d;

    /* renamed from: com.getui.gtc.extension.distribution.gbd.n.w$1, reason: invalid class name */
    public class AnonymousClass1 implements java.util.Comparator<java.io.File> {
        public AnonymousClass1() {
        }

        private static int a(java.io.File file, java.io.File file2) {
            return file.lastModified() - file2.lastModified() > 0 ? -1 : 1;
        }

        @Override // java.util.Comparator
        public final /* synthetic */ int compare(java.io.File file, java.io.File file2) {
            return file.lastModified() - file2.lastModified() > 0 ? -1 : 1;
        }
    }

    /* renamed from: com.getui.gtc.extension.distribution.gbd.n.w$2, reason: invalid class name */
    public class AnonymousClass2 implements java.io.FileFilter {
        public AnonymousClass2() {
        }

        @Override // java.io.FileFilter
        public final boolean accept(java.io.File file) {
            return !file.getName().startsWith(".");
        }
    }

    /* renamed from: com.getui.gtc.extension.distribution.gbd.n.w$3, reason: invalid class name */
    public class AnonymousClass3 implements java.io.FileFilter {
        public AnonymousClass3() {
        }

        @Override // java.io.FileFilter
        public final boolean accept(java.io.File file) {
            return file.isDirectory();
        }
    }

    private w() {
        java.lang.String absolutePath = com.getui.gtc.extension.distribution.gbd.d.c.i.getAbsolutePath();
        if (android.text.TextUtils.isEmpty(absolutePath) || !absolutePath.endsWith(net.lingala.zip4j.util.InternalZipConstants.ZIP_FILE_SEPARATOR)) {
            this.g = absolutePath;
        } else {
            this.g = absolutePath.substring(0, absolutePath.length() - 1);
        }
    }

    public static synchronized com.getui.gtc.extension.distribution.gbd.n.w a() {
        com.getui.gtc.extension.distribution.gbd.n.w wVar;
        synchronized (com.getui.gtc.extension.distribution.gbd.n.w.class) {
            if (e == null) {
                e = new com.getui.gtc.extension.distribution.gbd.n.w();
            }
            wVar = e;
        }
        return wVar;
    }

    /* JADX WARN: Removed duplicated region for block: B:41:0x0200  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private java.lang.String a(boolean z) {
        java.lang.String str;
        java.io.File[] fileArr;
        java.lang.String str2;
        long j;
        java.nio.file.Path path;
        java.nio.file.attribute.BasicFileAttributes readAttributes;
        java.nio.file.attribute.FileTime lastAccessTime;
        long millis;
        java.lang.String[] split;
        java.lang.String str3;
        long j2;
        java.lang.String str4;
        boolean z2;
        long j3;
        java.nio.file.Path path2;
        java.nio.file.attribute.BasicFileAttributes readAttributes2;
        java.nio.file.attribute.FileTime lastAccessTime2;
        long millis2;
        if (!com.getui.gtc.extension.distribution.gbd.n.x.a(1, 2)) {
            return "";
        }
        java.lang.String str5 = new java.lang.String(android.util.Base64.decode("L2NvbS50ZW5jZW50Lm1tL01pY3JvTXNnL3d4YWZpbGVz\n", 0));
        java.lang.String str6 = new java.lang.String(android.util.Base64.decode("d3g=\n", 0));
        java.lang.String str7 = this.g + str5;
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        boolean z3 = com.getui.gtc.extension.distribution.gbd.d.h.h >= 26;
        long currentTimeMillis = java.lang.System.currentTimeMillis();
        java.lang.String str8 = " t expired.";
        java.lang.String str9 = "&";
        try {
            if (z) {
                try {
                    if (com.getui.gtc.extension.distribution.gbd.n.b.k()) {
                        split = com.getui.gtc.extension.distribution.gbd.n.b.m();
                        com.getui.gtc.extension.distribution.gbd.n.j.b(d, "wlp from file.");
                    } else {
                        if (android.text.TextUtils.isEmpty(com.getui.gtc.extension.distribution.gbd.d.d.X)) {
                            com.getui.gtc.extension.distribution.gbd.n.j.b(d, "wlp new method empty.");
                            return "";
                        }
                        split = com.getui.gtc.extension.distribution.gbd.d.d.X.split(",");
                        for (int i = 0; i < split.length; i++) {
                            split[i] = str6 + split[i];
                        }
                        com.getui.gtc.extension.distribution.gbd.n.j.b(d, "wlp from config.");
                    }
                    int min = java.lang.Math.min(split.length, com.getui.gtc.extension.distribution.gbd.d.d.T);
                    if (split.length > 0) {
                        int length = split.length;
                        int i2 = 0;
                        int i3 = 0;
                        while (i2 < length) {
                            java.lang.String str10 = split[i2];
                            java.lang.String[] strArr = split;
                            int i4 = length;
                            java.io.File file = new java.io.File(str7 + net.lingala.zip4j.util.InternalZipConstants.ZIP_FILE_SEPARATOR + str10);
                            if (file.exists()) {
                                str3 = str7;
                                long lastModified = file.lastModified();
                                if (currentTimeMillis - lastModified <= com.getui.gtc.extension.distribution.gbd.d.d.U * 1000) {
                                    sb.append(str10);
                                    sb.append("&");
                                    if (z3) {
                                        path2 = file.toPath();
                                        z2 = z3;
                                        str4 = str8;
                                        readAttributes2 = java.nio.file.Files.readAttributes(path2, (java.lang.Class<java.nio.file.attribute.BasicFileAttributes>) java.nio.file.attribute.BasicFileAttributes.class, new java.nio.file.LinkOption[0]);
                                        lastAccessTime2 = readAttributes2.lastAccessTime();
                                        millis2 = lastAccessTime2.toMillis();
                                        j3 = millis2;
                                        j2 = currentTimeMillis;
                                    } else {
                                        z2 = z3;
                                        str4 = str8;
                                        j2 = currentTimeMillis;
                                        j3 = 0;
                                    }
                                    sb.append(j3);
                                    sb.append("&");
                                    sb.append(lastModified);
                                    sb.append(",");
                                    i3++;
                                    if (i3 >= min) {
                                        break;
                                    }
                                    i2++;
                                    split = strArr;
                                    str7 = str3;
                                    length = i4;
                                    z3 = z2;
                                    str8 = str4;
                                    currentTimeMillis = j2;
                                } else {
                                    com.getui.gtc.extension.distribution.gbd.n.j.b(d, str10 + str8);
                                }
                            } else {
                                str3 = str7;
                            }
                            z2 = z3;
                            j2 = currentTimeMillis;
                            str4 = str8;
                            i2++;
                            split = strArr;
                            str7 = str3;
                            length = i4;
                            z3 = z2;
                            str8 = str4;
                            currentTimeMillis = j2;
                        }
                    }
                } catch (java.lang.Throwable th) {
                    th = th;
                    com.getui.gtc.extension.distribution.gbd.n.j.a(th);
                    if (sb.toString().endsWith(",")) {
                    }
                    return sb.toString();
                }
            } else {
                boolean z4 = z3;
                java.lang.String str11 = " t expired.";
                com.getui.gtc.extension.distribution.gbd.n.j.b(d, "wlp by old method.");
                try {
                    java.io.File[] listFiles = new java.io.File(str7).listFiles(new com.getui.gtc.extension.distribution.gbd.n.w.AnonymousClass3());
                    int min2 = java.lang.Math.min(listFiles.length, com.getui.gtc.extension.distribution.gbd.d.d.T);
                    int length2 = listFiles.length;
                    int i5 = 0;
                    int i6 = 0;
                    while (i6 < length2) {
                        java.io.File file2 = listFiles[i6];
                        long lastModified2 = file2.lastModified();
                        if (currentTimeMillis - lastModified2 <= com.getui.gtc.extension.distribution.gbd.d.d.U * 1000) {
                            str = str11;
                            sb.append(file2.getName());
                            sb.append(str9);
                            if (z4) {
                                path = file2.toPath();
                                fileArr = listFiles;
                                readAttributes = java.nio.file.Files.readAttributes(path, (java.lang.Class<java.nio.file.attribute.BasicFileAttributes>) java.nio.file.attribute.BasicFileAttributes.class, new java.nio.file.LinkOption[0]);
                                lastAccessTime = readAttributes.lastAccessTime();
                                millis = lastAccessTime.toMillis();
                                str2 = str9;
                                j = millis;
                            } else {
                                fileArr = listFiles;
                                str2 = str9;
                                j = 0;
                            }
                            sb.append(j);
                            sb.append(str2);
                            sb.append(lastModified2);
                            sb.append(",");
                            i5++;
                            if (i5 >= min2) {
                                break;
                            }
                        } else {
                            java.lang.StringBuilder sb2 = new java.lang.StringBuilder();
                            sb2.append(file2.getName());
                            str = str11;
                            sb2.append(str);
                            com.getui.gtc.extension.distribution.gbd.n.j.b(d, sb2.toString());
                            fileArr = listFiles;
                            str2 = str9;
                        }
                        i6++;
                        str9 = str2;
                        str11 = str;
                        listFiles = fileArr;
                    }
                } catch (java.lang.Throwable th2) {
                    th = th2;
                    com.getui.gtc.extension.distribution.gbd.n.j.a(th);
                    if (sb.toString().endsWith(",")) {
                    }
                    return sb.toString();
                }
            }
        } catch (java.lang.Throwable th3) {
            th = th3;
        }
        if (sb.toString().endsWith(",")) {
            sb.deleteCharAt(sb.length() - 1);
        }
        return sb.toString();
    }

    private void a(java.io.File file) {
        if (file == null || !file.exists()) {
            return;
        }
        long j = this.l;
        if (j >= com.getui.gtc.extension.distribution.gbd.d.d.aw) {
            return;
        }
        this.l = j + 1;
        java.lang.String absolutePath = file.getAbsolutePath();
        if (!file.isDirectory()) {
            if (file.isFile()) {
                long lastModified = file.lastModified();
                if (lastModified > this.k) {
                    this.k = lastModified;
                    this.n = absolutePath;
                    return;
                }
                return;
            }
            return;
        }
        if (file.lastModified() > this.j) {
            this.j = file.lastModified();
            this.m = absolutePath;
        }
        java.io.File[] listFiles = file.listFiles(new com.getui.gtc.extension.distribution.gbd.n.w.AnonymousClass2());
        if (listFiles == null || listFiles.length <= 0) {
            return;
        }
        for (java.io.File file2 : listFiles) {
            a(file2);
        }
    }

    private void a(java.util.Map<java.lang.String, java.util.List<java.lang.String>> map, java.util.List<java.lang.String> list) {
        this.a = map;
        this.b = list;
    }

    private java.util.Map<java.lang.String, java.util.Map<java.lang.String, java.lang.Long>> b() {
        return this.c;
    }

    public final java.lang.String a(java.lang.String str, java.lang.String str2, boolean z) {
        try {
            java.lang.String str3 = this.g + net.lingala.zip4j.util.InternalZipConstants.ZIP_FILE_SEPARATOR + str2;
            if (!new java.io.File(str3).exists()) {
                return "error";
            }
            boolean z2 = com.getui.gtc.extension.distribution.gbd.d.d.cO;
            java.lang.String str4 = z2 ? "/files" : "|/files|/cache";
            java.lang.String str5 = z2 ? "|/files" : "|/files|/cache|";
            if (!android.text.TextUtils.isEmpty(str)) {
                str4 = str + str5;
            }
            java.util.ArrayList<java.lang.String> arrayList = new java.util.ArrayList(java.util.Arrays.asList(str4.split("\\|")));
            if (this.a.containsKey(str2)) {
                java.util.List<java.lang.String> list = this.a.get(str2);
                com.getui.gtc.extension.distribution.gbd.n.j.b(d, "filter pkg=" + str2 + ", list=" + list);
                arrayList.removeAll(list);
            }
            boolean contains = this.b.contains(str2);
            java.util.HashMap hashMap = new java.util.HashMap();
            if (contains) {
                this.c.put(str2, hashMap);
            }
            long j = 0;
            long j2 = 0;
            long j3 = 0;
            for (java.lang.String str6 : arrayList) {
                java.io.File file = new java.io.File(str3 + str6);
                long lastModified = file.lastModified();
                if (contains && lastModified > j) {
                    hashMap.put(str6, java.lang.Long.valueOf(lastModified));
                }
                if (file.isDirectory()) {
                    if (lastModified > j2) {
                        j2 = lastModified;
                    }
                } else if (lastModified > j3) {
                    j3 = lastModified;
                }
                j = 0;
            }
            java.lang.StringBuilder sb = new java.lang.StringBuilder();
            sb.append(j2);
            sb.append("&");
            sb.append(j3);
            sb.append("&0&");
            sb.append(z ? 0 : 1);
            sb.append("&&");
            return sb.toString();
        } catch (java.lang.Throwable th) {
            com.getui.gtc.extension.distribution.gbd.n.j.a(th);
            return "error";
        }
    }

    public final java.lang.String a(java.lang.String str, boolean z) {
        try {
            this.j = 0L;
            this.k = 0L;
            this.l = 0L;
            this.m = "";
            this.n = "";
            boolean z2 = !z && com.getui.gtc.extension.distribution.gbd.d.d.aa;
            java.lang.String str2 = this.g + net.lingala.zip4j.util.InternalZipConstants.ZIP_FILE_SEPARATOR + str;
            java.io.File[] listFiles = new java.io.File(str2).listFiles();
            if (listFiles != null && listFiles.length > 0) {
                java.util.Arrays.sort(listFiles, new com.getui.gtc.extension.distribution.gbd.n.w.AnonymousClass1());
                for (java.io.File file : listFiles) {
                    a(file);
                }
            }
            if (z2) {
                this.m = this.m.replace(str2, "");
                this.n = this.n.replace(str2, "");
            }
            java.lang.String str3 = z2 ? "&" + this.m + "&" + this.n : "&&";
            if (java.lang.System.currentTimeMillis() - java.lang.Math.max(this.j, this.k) > com.getui.gtc.extension.distribution.gbd.d.d.ax * 1000) {
                return "error";
            }
            java.lang.StringBuilder sb = new java.lang.StringBuilder();
            sb.append(this.j);
            sb.append("&");
            sb.append(this.k);
            sb.append("&");
            sb.append(this.l);
            sb.append("&");
            sb.append(z ? 0 : 1);
            sb.append(str3);
            return sb.toString();
        } catch (java.lang.Throwable th) {
            com.getui.gtc.extension.distribution.gbd.n.j.a(th);
            return "error";
        }
    }
}
