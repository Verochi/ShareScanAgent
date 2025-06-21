package com.xiaomi.a.c;

/* loaded from: classes19.dex */
public class c implements com.xiaomi.a.c.a {
    protected android.content.Context a;
    private java.util.HashMap<java.lang.String, java.util.ArrayList<com.xiaomi.a.a.d>> b;

    public c(android.content.Context context) {
        this.a = context;
    }

    private java.lang.String a(byte[] bArr) {
        byte[] a;
        if (bArr.length <= 0) {
            return null;
        }
        if (!com.xiaomi.a.b.b.a(this.a).a().a) {
            return com.xiaomi.push.ao.b(bArr);
        }
        java.lang.String a2 = com.xiaomi.push.as.a(this.a);
        if (!android.text.TextUtils.isEmpty(a2) && (a = com.xiaomi.push.as.a(a2)) != null && a.length > 0) {
            try {
                return com.xiaomi.push.ao.b(android.util.Base64.decode(com.xiaomi.push.hb.a(a, bArr), 2));
            } catch (java.security.InvalidAlgorithmParameterException | java.security.InvalidKeyException | java.security.NoSuchAlgorithmException | javax.crypto.BadPaddingException | javax.crypto.IllegalBlockSizeException | javax.crypto.NoSuchPaddingException e) {
                com.xiaomi.channel.commonutils.logger.b.a(e);
            }
        }
        return null;
    }

    /* JADX WARN: Code restructure failed: missing block: B:31:0x0038, code lost:
    
        com.xiaomi.channel.commonutils.logger.b.d(r9);
     */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x0060, code lost:
    
        r9 = "eventData read from cache file failed cause lengthBuffer < 1 || lengthBuffer > 4K";
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private java.util.List<java.lang.String> a(java.lang.String str) {
        java.lang.String str2;
        java.util.ArrayList arrayList = new java.util.ArrayList();
        byte[] bArr = new byte[4];
        byte[] bArr2 = new byte[4];
        java.io.FileInputStream fileInputStream = null;
        try {
            try {
                java.io.FileInputStream fileInputStream2 = new java.io.FileInputStream(new java.io.File(str));
                while (true) {
                    try {
                        int read = fileInputStream2.read(bArr);
                        if (read != -1) {
                            if (read != 4 || com.xiaomi.push.g.a(bArr) != -573785174) {
                                break;
                            }
                            int read2 = fileInputStream2.read(bArr2);
                            if (read2 != -1) {
                                if (read2 == 4) {
                                    int a = com.xiaomi.push.g.a(bArr2);
                                    if (a <= 0 || a > 4096) {
                                        break;
                                    }
                                    byte[] bArr3 = new byte[a];
                                    if (fileInputStream2.read(bArr3) != a) {
                                        str2 = "eventData read from cache file failed cause buffer size not equal length";
                                        break;
                                    }
                                    java.lang.String a2 = a(bArr3);
                                    if (!android.text.TextUtils.isEmpty(a2)) {
                                        arrayList.add(a2);
                                    }
                                } else {
                                    str2 = "eventData read from cache file failed cause lengthBuffer error";
                                    break;
                                }
                            } else {
                                break;
                            }
                        } else {
                            break;
                        }
                    } catch (java.lang.Exception e) {
                        e = e;
                        fileInputStream = fileInputStream2;
                        com.xiaomi.channel.commonutils.logger.b.a(e);
                        com.xiaomi.push.c.a(fileInputStream);
                        return arrayList;
                    } catch (java.lang.Throwable th) {
                        th = th;
                        fileInputStream = fileInputStream2;
                        com.xiaomi.push.c.a(fileInputStream);
                        throw th;
                    }
                }
                com.xiaomi.channel.commonutils.logger.b.d("eventData read from cache file failed because magicNumber error");
                com.xiaomi.push.c.a(fileInputStream2);
            } catch (java.lang.Exception e2) {
                e = e2;
            }
            return arrayList;
        } catch (java.lang.Throwable th2) {
            th = th2;
        }
    }

    private static void a(java.io.RandomAccessFile randomAccessFile, java.nio.channels.FileLock fileLock) {
        if (fileLock != null && fileLock.isValid()) {
            try {
                fileLock.release();
            } catch (java.io.IOException e) {
                com.xiaomi.channel.commonutils.logger.b.a(e);
            }
        }
        com.xiaomi.push.c.a(randomAccessFile);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Not initialized variable reg: 6, insn: 0x0105: MOVE (r3 I:??[OBJECT, ARRAY]) = (r6 I:??[OBJECT, ARRAY]), block:B:63:0x0105 */
    /* JADX WARN: Type inference failed for: r1v11 */
    /* JADX WARN: Type inference failed for: r1v12 */
    /* JADX WARN: Type inference failed for: r1v14, types: [java.nio.channels.FileLock] */
    /* JADX WARN: Type inference failed for: r1v4, types: [boolean] */
    /* JADX WARN: Type inference failed for: r1v5, types: [java.nio.channels.FileLock] */
    /* JADX WARN: Type inference failed for: r1v6 */
    /* JADX WARN: Type inference failed for: r1v7 */
    /* JADX WARN: Type inference failed for: r1v8 */
    /* JADX WARN: Type inference failed for: r1v9, types: [java.nio.channels.FileLock] */
    /* JADX WARN: Type inference failed for: r2v1, types: [java.io.File] */
    /* JADX WARN: Type inference failed for: r2v10 */
    /* JADX WARN: Type inference failed for: r2v11 */
    /* JADX WARN: Type inference failed for: r2v12, types: [java.io.RandomAccessFile] */
    /* JADX WARN: Type inference failed for: r2v15, types: [java.io.RandomAccessFile] */
    /* JADX WARN: Type inference failed for: r2v16 */
    /* JADX WARN: Type inference failed for: r2v17 */
    /* JADX WARN: Type inference failed for: r2v4 */
    /* JADX WARN: Type inference failed for: r2v5, types: [int] */
    /* JADX WARN: Type inference failed for: r2v7 */
    /* JADX WARN: Type inference failed for: r2v8, types: [java.io.RandomAccessFile] */
    /* JADX WARN: Type inference failed for: r2v9 */
    /* JADX WARN: Type inference failed for: r4v2, types: [java.lang.StringBuilder] */
    private com.xiaomi.a.a.d[] a(com.xiaomi.a.a.d[] dVarArr) {
        java.lang.String str;
        java.io.Closeable closeable;
        java.io.BufferedOutputStream bufferedOutputStream;
        com.xiaomi.a.a.d dVar = dVarArr[0];
        ?? externalFilesDir = this.a.getExternalFilesDir("event");
        java.lang.String valueOf = java.lang.String.valueOf(dVar.e);
        java.io.Closeable closeable2 = null;
        if (externalFilesDir != 0) {
            java.lang.String str2 = externalFilesDir.getAbsolutePath() + java.io.File.separator + valueOf;
            externalFilesDir = 0;
            while (externalFilesDir < 100) {
                str = str2 + externalFilesDir;
                if (com.xiaomi.push.as.a(this.a, str)) {
                    break;
                }
                externalFilesDir++;
            }
        }
        str = null;
        ?? isEmpty = android.text.TextUtils.isEmpty(str);
        try {
            if (isEmpty != 0) {
                return null;
            }
            try {
                java.io.File file = new java.io.File(str + ".lock");
                com.xiaomi.push.c.b(file);
                externalFilesDir = new java.io.RandomAccessFile(file, "rw");
                try {
                    isEmpty = externalFilesDir.getChannel().lock();
                    try {
                        bufferedOutputStream = new java.io.BufferedOutputStream(new java.io.FileOutputStream(new java.io.File(str), true));
                        try {
                            int i = 0;
                            for (com.xiaomi.a.a.d dVar2 : dVarArr) {
                                if (dVar2 != null) {
                                    byte[] b = b(dVar2.b());
                                    if (b != null && b.length > 0 && b.length <= 4096) {
                                        if (!com.xiaomi.push.as.a(this.a, str)) {
                                            int length = dVarArr.length - i;
                                            com.xiaomi.a.a.d[] dVarArr2 = new com.xiaomi.a.a.d[length];
                                            java.lang.System.arraycopy(dVarArr, i, dVarArr2, 0, length);
                                            com.xiaomi.push.c.a(bufferedOutputStream);
                                            a(externalFilesDir, isEmpty);
                                            return dVarArr2;
                                        }
                                        bufferedOutputStream.write(com.xiaomi.push.g.a(-573785174));
                                        bufferedOutputStream.write(com.xiaomi.push.g.a(b.length));
                                        bufferedOutputStream.write(b);
                                        bufferedOutputStream.flush();
                                        i++;
                                    }
                                    com.xiaomi.channel.commonutils.logger.b.d("event data throw a invalid item ");
                                }
                            }
                        } catch (java.lang.Exception e) {
                            e = e;
                            com.xiaomi.channel.commonutils.logger.b.a("event data write to cache file failed cause exception", e);
                            com.xiaomi.push.c.a(bufferedOutputStream);
                            a(externalFilesDir, isEmpty);
                            return null;
                        }
                    } catch (java.lang.Exception e2) {
                        e = e2;
                        bufferedOutputStream = null;
                    } catch (java.lang.Throwable th) {
                        th = th;
                        com.xiaomi.push.c.a(closeable2);
                        a(externalFilesDir, isEmpty);
                        throw th;
                    }
                } catch (java.lang.Exception e3) {
                    e = e3;
                    isEmpty = 0;
                    bufferedOutputStream = null;
                } catch (java.lang.Throwable th2) {
                    th = th2;
                    isEmpty = 0;
                }
            } catch (java.lang.Exception e4) {
                e = e4;
                isEmpty = 0;
                externalFilesDir = 0;
                bufferedOutputStream = null;
            } catch (java.lang.Throwable th3) {
                th = th3;
                isEmpty = 0;
                externalFilesDir = 0;
            }
            com.xiaomi.push.c.a(bufferedOutputStream);
            a(externalFilesDir, isEmpty);
            return null;
        } catch (java.lang.Throwable th4) {
            th = th4;
            closeable2 = closeable;
        }
    }

    private byte[] b(java.lang.String str) {
        byte[] a;
        if (android.text.TextUtils.isEmpty(str)) {
            return null;
        }
        if (!com.xiaomi.a.b.b.a(this.a).a().a) {
            return com.xiaomi.push.ao.c(str);
        }
        java.lang.String a2 = com.xiaomi.push.as.a(this.a);
        byte[] c = com.xiaomi.push.ao.c(str);
        if (!android.text.TextUtils.isEmpty(a2) && c != null && c.length > 1 && (a = com.xiaomi.push.as.a(a2)) != null) {
            try {
                if (a.length > 1) {
                    return com.xiaomi.push.hb.b(a, android.util.Base64.encode(c, 2));
                }
            } catch (java.lang.Exception e) {
                com.xiaomi.channel.commonutils.logger.b.a(e);
            }
        }
        return null;
    }

    @Override // com.xiaomi.a.c.e
    public final void a() {
        int i;
        java.io.RandomAccessFile randomAccessFile;
        com.xiaomi.push.as.a(this.a, "event", "eventUploading");
        java.io.File[] b = com.xiaomi.push.as.b(this.a, "eventUploading");
        if (b == null || b.length <= 0) {
            return;
        }
        int length = b.length;
        java.nio.channels.FileLock fileLock = null;
        java.io.RandomAccessFile randomAccessFile2 = null;
        java.io.File file = null;
        while (i < length) {
            java.io.File file2 = b[i];
            if (file2 == null) {
                if (fileLock != null && fileLock.isValid()) {
                    try {
                        fileLock.release();
                    } catch (java.io.IOException e) {
                        com.xiaomi.channel.commonutils.logger.b.a(e);
                    }
                }
                com.xiaomi.push.c.a(randomAccessFile2);
                i = file == null ? i + 1 : 0;
                file.delete();
            } else {
                try {
                    try {
                    } catch (java.lang.Exception e2) {
                        e = e2;
                    }
                    if (file2.length() > com.google.android.exoplayer2.upstream.cache.CacheDataSink.DEFAULT_FRAGMENT_SIZE) {
                        com.xiaomi.channel.commonutils.logger.b.d("eventData read from cache file failed because " + file2.getName() + " is too big, length " + file2.length());
                        java.lang.String name = file2.getName();
                        java.lang.String formatFileSize = android.text.format.Formatter.formatFileSize(this.a, file2.length());
                        com.xiaomi.a.a.b a = com.xiaomi.a.b.b.a(this.a).a("24:" + name + "," + formatFileSize);
                        java.util.ArrayList arrayList = new java.util.ArrayList();
                        arrayList.add(a.b());
                        a(arrayList);
                        file2.delete();
                        if (fileLock != null && fileLock.isValid()) {
                            try {
                                fileLock.release();
                            } catch (java.io.IOException e3) {
                                com.xiaomi.channel.commonutils.logger.b.a(e3);
                            }
                        }
                        com.xiaomi.push.c.a(randomAccessFile2);
                        if (file == null) {
                        }
                        file.delete();
                    } else {
                        java.lang.String absolutePath = file2.getAbsolutePath();
                        java.io.File file3 = new java.io.File(absolutePath + ".lock");
                        try {
                            com.xiaomi.push.c.b(file3);
                            randomAccessFile = new java.io.RandomAccessFile(file3, "rw");
                        } catch (java.lang.Exception e4) {
                            e = e4;
                        } catch (java.lang.Throwable th) {
                            th = th;
                        }
                        try {
                            fileLock = randomAccessFile.getChannel().lock();
                            a(a(absolutePath));
                            file2.delete();
                            if (fileLock != null && fileLock.isValid()) {
                                try {
                                    fileLock.release();
                                } catch (java.io.IOException e5) {
                                    com.xiaomi.channel.commonutils.logger.b.a(e5);
                                }
                            }
                            com.xiaomi.push.c.a(randomAccessFile);
                            file3.delete();
                            randomAccessFile2 = randomAccessFile;
                            file = file3;
                        } catch (java.lang.Exception e6) {
                            e = e6;
                            randomAccessFile2 = randomAccessFile;
                            file = file3;
                            com.xiaomi.channel.commonutils.logger.b.a(e);
                            if (fileLock != null && fileLock.isValid()) {
                                try {
                                    fileLock.release();
                                } catch (java.io.IOException e7) {
                                    com.xiaomi.channel.commonutils.logger.b.a(e7);
                                }
                            }
                            com.xiaomi.push.c.a(randomAccessFile2);
                            if (file == null) {
                            }
                            file.delete();
                        } catch (java.lang.Throwable th2) {
                            th = th2;
                            randomAccessFile2 = randomAccessFile;
                            file = file3;
                            if (fileLock != null && fileLock.isValid()) {
                                try {
                                    fileLock.release();
                                } catch (java.io.IOException e8) {
                                    com.xiaomi.channel.commonutils.logger.b.a(e8);
                                }
                            }
                            com.xiaomi.push.c.a(randomAccessFile2);
                            if (file == null) {
                                throw th;
                            }
                            file.delete();
                            throw th;
                        }
                    }
                } catch (java.lang.Throwable th3) {
                    th = th3;
                }
            }
        }
    }

    @Override // com.xiaomi.a.c.f
    public final void a(com.xiaomi.a.a.d dVar) {
        if ((dVar instanceof com.xiaomi.a.a.b) && this.b != null) {
            com.xiaomi.a.a.b bVar = (com.xiaomi.a.a.b) dVar;
            java.lang.String valueOf = java.lang.String.valueOf(bVar.e);
            java.util.ArrayList<com.xiaomi.a.a.d> arrayList = this.b.get(valueOf);
            if (arrayList == null) {
                arrayList = new java.util.ArrayList<>();
            }
            arrayList.add(bVar);
            this.b.put(valueOf, arrayList);
        }
    }

    @Override // com.xiaomi.a.c.a
    public final void a(java.util.HashMap<java.lang.String, java.util.ArrayList<com.xiaomi.a.a.d>> hashMap) {
        this.b = hashMap;
    }

    public void a(java.util.List<java.lang.String> list) {
        com.xiaomi.push.as.a(this.a, list);
    }

    @Override // com.xiaomi.a.c.f
    public final void b() {
        java.util.HashMap<java.lang.String, java.util.ArrayList<com.xiaomi.a.a.d>> hashMap = this.b;
        if (hashMap == null) {
            return;
        }
        if (hashMap.size() > 0) {
            java.util.Iterator<java.lang.String> it = this.b.keySet().iterator();
            while (it.hasNext()) {
                java.util.ArrayList<com.xiaomi.a.a.d> arrayList = this.b.get(it.next());
                if (arrayList != null && arrayList.size() > 0) {
                    int size = arrayList.size();
                    com.xiaomi.a.a.d[] dVarArr = new com.xiaomi.a.a.d[size];
                    arrayList.toArray(dVarArr);
                    if (size == 0 || dVarArr[0] == null) {
                        com.xiaomi.channel.commonutils.logger.b.a("event data write to cache file failed because data null");
                    } else {
                        do {
                            dVarArr = a(dVarArr);
                            if (dVarArr != null && dVarArr.length > 0) {
                            }
                        } while (dVarArr[0] != null);
                    }
                }
            }
        }
        this.b.clear();
    }
}
