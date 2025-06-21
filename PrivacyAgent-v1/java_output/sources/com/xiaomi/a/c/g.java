package com.xiaomi.a.c;

/* loaded from: classes19.dex */
public final class g {
    public static java.lang.String a(com.xiaomi.a.a.c cVar) {
        return cVar.e + "#" + cVar.f + "#" + cVar.g + "#" + cVar.a;
    }

    /* JADX WARN: Code restructure failed: missing block: B:71:0x00e3, code lost:
    
        if (r2 != null) goto L72;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:32:0x008a A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:36:0x004b A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:75:0x00ec  */
    /* JADX WARN: Removed duplicated region for block: B:84:0x0102  */
    /* JADX WARN: Removed duplicated region for block: B:86:? A[SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r5v0 */
    /* JADX WARN: Type inference failed for: r5v1 */
    /* JADX WARN: Type inference failed for: r5v10, types: [java.io.BufferedReader, java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r5v11 */
    /* JADX WARN: Type inference failed for: r5v2, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r5v3, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r5v4 */
    /* JADX WARN: Type inference failed for: r5v5 */
    /* JADX WARN: Type inference failed for: r5v6 */
    /* JADX WARN: Type inference failed for: r5v7 */
    /* JADX WARN: Type inference failed for: r5v8 */
    /* JADX WARN: Type inference failed for: r5v9 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static java.util.List<java.lang.String> a(java.lang.String str) {
        java.io.File file;
        java.io.RandomAccessFile randomAccessFile;
        ?? r5;
        long[] b;
        java.util.ArrayList arrayList = new java.util.ArrayList();
        if (android.text.TextUtils.isEmpty(str) || !new java.io.File(str).exists()) {
            return arrayList;
        }
        java.nio.channels.FileLock fileLock = null;
        try {
            file = new java.io.File(str + ".lock");
        } catch (java.lang.Exception e) {
            e = e;
            file = null;
            randomAccessFile = null;
        } catch (java.lang.Throwable th) {
            th = th;
            file = null;
            randomAccessFile = null;
        }
        try {
            com.xiaomi.push.c.b(file);
            randomAccessFile = new java.io.RandomAccessFile(file, "rw");
            try {
                java.nio.channels.FileLock lock = randomAccessFile.getChannel().lock();
                try {
                    r5 = new java.io.BufferedReader(new java.io.FileReader(str));
                    while (true) {
                        try {
                            java.lang.String readLine = r5.readLine();
                            if (readLine == null) {
                                break;
                            }
                            java.lang.String[] split = readLine.split("%%%");
                            if (split.length >= 2 && !android.text.TextUtils.isEmpty(split[0]) && !android.text.TextUtils.isEmpty(split[1])) {
                                com.xiaomi.a.a.c d = d(split[0]);
                                java.lang.String str2 = split[1];
                                if (d != null && (b = b(str2)) != null) {
                                    d.b = b[0];
                                    d.c = b[1];
                                    if (d == null) {
                                        arrayList.add(d.b());
                                    }
                                }
                                d = null;
                                if (d == null) {
                                }
                            }
                        } catch (java.lang.Exception e2) {
                            e = e2;
                            fileLock = lock;
                            r5 = r5;
                            try {
                                com.xiaomi.channel.commonutils.logger.b.a(e);
                                if (fileLock != null && fileLock.isValid()) {
                                    try {
                                        fileLock.release();
                                    } catch (java.io.IOException e3) {
                                        com.xiaomi.channel.commonutils.logger.b.a(e3);
                                    }
                                }
                                com.xiaomi.push.c.a(randomAccessFile);
                                com.xiaomi.push.c.a((java.io.Closeable) r5);
                            } catch (java.lang.Throwable th2) {
                                th = th2;
                                if (fileLock != null && fileLock.isValid()) {
                                    try {
                                        fileLock.release();
                                    } catch (java.io.IOException e4) {
                                        com.xiaomi.channel.commonutils.logger.b.a(e4);
                                    }
                                }
                                com.xiaomi.push.c.a(randomAccessFile);
                                com.xiaomi.push.c.a((java.io.Closeable) r5);
                                if (file == null) {
                                    throw th;
                                }
                                file.delete();
                                throw th;
                            }
                        } catch (java.lang.Throwable th3) {
                            th = th3;
                            fileLock = lock;
                            if (fileLock != null) {
                                fileLock.release();
                            }
                            com.xiaomi.push.c.a(randomAccessFile);
                            com.xiaomi.push.c.a((java.io.Closeable) r5);
                            if (file == null) {
                            }
                        }
                    }
                    if (lock != null && lock.isValid()) {
                        try {
                            lock.release();
                        } catch (java.io.IOException e5) {
                            com.xiaomi.channel.commonutils.logger.b.a(e5);
                        }
                    }
                    com.xiaomi.push.c.a(randomAccessFile);
                    com.xiaomi.push.c.a((java.io.Closeable) r5);
                } catch (java.lang.Exception e6) {
                    e = e6;
                    r5 = 0;
                } catch (java.lang.Throwable th4) {
                    th = th4;
                    r5 = 0;
                }
            } catch (java.lang.Exception e7) {
                e = e7;
                r5 = 0;
            } catch (java.lang.Throwable th5) {
                th = th5;
                r5 = 0;
            }
        } catch (java.lang.Exception e8) {
            e = e8;
            randomAccessFile = null;
            r5 = randomAccessFile;
            com.xiaomi.channel.commonutils.logger.b.a(e);
            if (fileLock != null) {
                fileLock.release();
            }
            com.xiaomi.push.c.a(randomAccessFile);
            com.xiaomi.push.c.a((java.io.Closeable) r5);
        } catch (java.lang.Throwable th6) {
            th = th6;
            randomAccessFile = null;
            r5 = randomAccessFile;
            if (fileLock != null) {
            }
            com.xiaomi.push.c.a(randomAccessFile);
            com.xiaomi.push.c.a((java.io.Closeable) r5);
            if (file == null) {
            }
        }
        file.delete();
        return arrayList;
    }

    private static void a(java.lang.String str, java.util.HashMap<java.lang.String, java.lang.String> hashMap) {
        java.lang.Throwable th;
        java.io.BufferedWriter bufferedWriter;
        java.lang.Exception e;
        if (android.text.TextUtils.isEmpty(str) || hashMap == null || hashMap.size() == 0) {
            return;
        }
        java.io.File file = new java.io.File(str);
        if (file.exists()) {
            file.delete();
        }
        try {
            try {
                bufferedWriter = new java.io.BufferedWriter(new java.io.FileWriter(file));
                try {
                    for (java.lang.String str2 : hashMap.keySet()) {
                        bufferedWriter.write(str2 + "%%%" + hashMap.get(str2));
                        bufferedWriter.newLine();
                    }
                    com.xiaomi.push.c.a(bufferedWriter);
                } catch (java.lang.Exception e2) {
                    e = e2;
                    com.xiaomi.channel.commonutils.logger.b.a(e);
                    com.xiaomi.push.c.a(bufferedWriter);
                }
            } catch (java.lang.Throwable th2) {
                th = th2;
                com.xiaomi.push.c.a((java.io.Closeable) null);
                throw th;
            }
        } catch (java.lang.Exception e3) {
            bufferedWriter = null;
            e = e3;
        } catch (java.lang.Throwable th3) {
            th = th3;
            com.xiaomi.push.c.a((java.io.Closeable) null);
            throw th;
        }
    }

    public static void a(java.lang.String str, com.xiaomi.a.a.d[] dVarArr) {
        java.io.RandomAccessFile randomAccessFile;
        java.lang.StringBuilder sb;
        if (dVarArr.length <= 0 || android.text.TextUtils.isEmpty(str)) {
            return;
        }
        java.nio.channels.FileLock fileLock = null;
        try {
            java.io.File file = new java.io.File(str + ".lock");
            com.xiaomi.push.c.b(file);
            randomAccessFile = new java.io.RandomAccessFile(file, "rw");
        } catch (java.lang.Throwable unused) {
            randomAccessFile = null;
        }
        try {
            fileLock = randomAccessFile.getChannel().lock();
            java.util.HashMap<java.lang.String, java.lang.String> c = c(str);
            for (com.xiaomi.a.a.d dVar : dVarArr) {
                if (dVar != null) {
                    java.lang.String a = a((com.xiaomi.a.a.c) dVar);
                    long j = ((com.xiaomi.a.a.c) dVar).b;
                    long j2 = ((com.xiaomi.a.a.c) dVar).c;
                    if (!android.text.TextUtils.isEmpty(a) && j > 0 && j2 >= 0) {
                        java.lang.String str2 = c.get(a);
                        if (android.text.TextUtils.isEmpty(str2)) {
                            sb = new java.lang.StringBuilder();
                            sb.append(j);
                            sb.append("#");
                            sb.append(j2);
                        } else {
                            long[] b = b(str2);
                            if (b != null) {
                                long j3 = b[0];
                                if (j3 > 0) {
                                    long j4 = b[1];
                                    if (j4 >= 0) {
                                        j2 += j4;
                                        sb = new java.lang.StringBuilder();
                                        sb.append(j + j3);
                                        sb.append("#");
                                        sb.append(j2);
                                    }
                                }
                            }
                            sb = new java.lang.StringBuilder();
                            sb.append(j);
                            sb.append("#");
                            sb.append(j2);
                        }
                        c.put(a, sb.toString());
                    }
                }
            }
            a(str, c);
            if (fileLock != null && fileLock.isValid()) {
                try {
                    fileLock.release();
                } catch (java.io.IOException e) {
                    com.xiaomi.channel.commonutils.logger.b.a(e);
                }
            }
            com.xiaomi.push.c.a(randomAccessFile);
        } catch (java.lang.Throwable unused2) {
            try {
                com.xiaomi.channel.commonutils.logger.b.c("failed to write perf to file ");
                if (fileLock != null && fileLock.isValid()) {
                    try {
                        fileLock.release();
                    } catch (java.io.IOException e2) {
                        com.xiaomi.channel.commonutils.logger.b.a(e2);
                    }
                }
                com.xiaomi.push.c.a(randomAccessFile);
            } catch (java.lang.Throwable th) {
                if (fileLock != null && fileLock.isValid()) {
                    try {
                        fileLock.release();
                    } catch (java.io.IOException e3) {
                        com.xiaomi.channel.commonutils.logger.b.a(e3);
                    }
                }
                com.xiaomi.push.c.a(randomAccessFile);
                throw th;
            }
        }
    }

    private static long[] b(java.lang.String str) {
        long[] jArr = new long[2];
        try {
            java.lang.String[] split = str.split("#");
            if (split.length >= 2) {
                jArr[0] = java.lang.Long.parseLong(split[0].trim());
                jArr[1] = java.lang.Long.parseLong(split[1].trim());
            }
            return jArr;
        } catch (java.lang.Exception e) {
            com.xiaomi.channel.commonutils.logger.b.a(e);
            return null;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v12, types: [int] */
    /* JADX WARN: Type inference failed for: r1v13 */
    /* JADX WARN: Type inference failed for: r1v14 */
    /* JADX WARN: Type inference failed for: r1v15, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r1v17 */
    /* JADX WARN: Type inference failed for: r1v18 */
    /* JADX WARN: Type inference failed for: r1v8 */
    /* JADX WARN: Type inference failed for: r3v2, types: [java.lang.CharSequence] */
    /* JADX WARN: Type inference failed for: r4v0, types: [java.lang.CharSequence] */
    /* JADX WARN: Type inference failed for: r5v8, types: [java.lang.String[]] */
    /* JADX WARN: Type inference failed for: r5v9, types: [java.lang.Object] */
    private static java.util.HashMap<java.lang.String, java.lang.String> c(java.lang.String str) {
        java.util.HashMap hashMap = new java.util.HashMap();
        if (android.text.TextUtils.isEmpty(str) || !new java.io.File(str).exists()) {
            return hashMap;
        }
        java.io.BufferedReader bufferedReader = null;
        ?? r1 = 0;
        java.io.BufferedReader bufferedReader2 = null;
        try {
            try {
                java.io.BufferedReader bufferedReader3 = new java.io.BufferedReader(new java.io.FileReader(str));
                while (true) {
                    try {
                        java.lang.String readLine = bufferedReader3.readLine();
                        if (readLine == null) {
                            break;
                        }
                        ?? split = readLine.split("%%%");
                        r1 = split.length;
                        if (r1 >= 2) {
                            r1 = 0;
                            r1 = 0;
                            if (!android.text.TextUtils.isEmpty(split[0]) && !android.text.TextUtils.isEmpty(split[1])) {
                                r1 = split[0];
                                hashMap.put(r1, split[1]);
                            }
                        }
                    } catch (java.lang.Exception e) {
                        e = e;
                        bufferedReader2 = bufferedReader3;
                        com.xiaomi.channel.commonutils.logger.b.a(e);
                        com.xiaomi.push.c.a(bufferedReader2);
                        bufferedReader = bufferedReader2;
                        return hashMap;
                    } catch (java.lang.Throwable th) {
                        th = th;
                        bufferedReader = bufferedReader3;
                        com.xiaomi.push.c.a(bufferedReader);
                        throw th;
                    }
                }
                com.xiaomi.push.c.a(bufferedReader3);
                bufferedReader = r1;
            } catch (java.lang.Throwable th2) {
                th = th2;
            }
        } catch (java.lang.Exception e2) {
            e = e2;
        }
        return hashMap;
    }

    private static com.xiaomi.a.a.c d(java.lang.String str) {
        com.xiaomi.a.a.c cVar = null;
        try {
            java.lang.String[] split = android.text.TextUtils.isEmpty(str) ? null : str.split("#");
            if (split == null || split.length < 4 || android.text.TextUtils.isEmpty(split[0]) || android.text.TextUtils.isEmpty(split[1]) || android.text.TextUtils.isEmpty(split[2]) || android.text.TextUtils.isEmpty(split[3])) {
                return null;
            }
            com.xiaomi.a.a.c cVar2 = new com.xiaomi.a.a.c();
            try {
                cVar2.e = java.lang.Integer.parseInt(split[0]);
                cVar2.f = split[1];
                cVar2.g = java.lang.Integer.parseInt(split[2]);
                cVar2.a = java.lang.Integer.parseInt(split[3]);
                return cVar2;
            } catch (java.lang.Exception unused) {
                cVar = cVar2;
                com.xiaomi.channel.commonutils.logger.b.c("parse per key error");
                return cVar;
            }
        } catch (java.lang.Exception unused2) {
        }
    }
}
