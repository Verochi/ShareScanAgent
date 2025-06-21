package com.bytedance.pangle.util.b;

/* loaded from: classes.dex */
public final class b {
    private static void a(int i, java.lang.String str, int i2, long j, java.lang.Throwable th, java.lang.String str2) {
        org.json.JSONObject jSONObject = new org.json.JSONObject();
        org.json.JSONObject jSONObject2 = new org.json.JSONObject();
        org.json.JSONObject jSONObject3 = new org.json.JSONObject();
        try {
            jSONObject.putOpt(com.ss.android.socialbase.downloader.constants.MonitorConstants.STATUS_CODE, com.bytedance.pangle.log.b.a(java.lang.Integer.valueOf(i)));
            jSONObject.putOpt("plugin_package_name", com.bytedance.pangle.log.b.a(str));
            jSONObject.putOpt("version_code", com.bytedance.pangle.log.b.a(java.lang.Integer.valueOf(i2)));
            jSONObject3.putOpt("duration", java.lang.Integer.valueOf(com.bytedance.pangle.log.b.b(java.lang.Long.valueOf(j))));
            jSONObject2.putOpt("message", str2 + com.bytedance.pangle.log.b.a(th));
        } catch (org.json.JSONException e) {
            e.printStackTrace();
        }
        com.bytedance.pangle.c.b.a().a(com.bytedance.pangle.c.b.k, jSONObject, jSONObject3, jSONObject2);
    }

    /* JADX WARN: Code restructure failed: missing block: B:24:0x00c9, code lost:
    
        if (r0.h.endsWith(".so") != false) goto L34;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:100:0x00d2 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:27:0x00dc A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:55:0x0337 A[Catch: all -> 0x0333, TryCatch #11 {all -> 0x0333, blocks: (B:90:0x032f, B:55:0x0337, B:56:0x033a, B:57:0x033d), top: B:89:0x032f }] */
    /* JADX WARN: Removed duplicated region for block: B:65:0x036d  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x032f A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r2v0 */
    /* JADX WARN: Type inference failed for: r2v10 */
    /* JADX WARN: Type inference failed for: r2v11 */
    /* JADX WARN: Type inference failed for: r2v12 */
    /* JADX WARN: Type inference failed for: r2v13 */
    /* JADX WARN: Type inference failed for: r2v15 */
    /* JADX WARN: Type inference failed for: r2v16 */
    /* JADX WARN: Type inference failed for: r2v22 */
    /* JADX WARN: Type inference failed for: r2v30 */
    /* JADX WARN: Type inference failed for: r2v34 */
    /* JADX WARN: Type inference failed for: r4v0, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r4v11 */
    /* JADX WARN: Type inference failed for: r4v12 */
    /* JADX WARN: Type inference failed for: r4v24 */
    /* JADX WARN: Type inference failed for: r4v31 */
    /* JADX WARN: Type inference failed for: r4v38 */
    /* JADX WARN: Type inference failed for: r4v6 */
    /* JADX WARN: Type inference failed for: r4v7 */
    /* JADX WARN: Type inference failed for: r4v8 */
    /* JADX WARN: Type inference failed for: r4v9 */
    /* JADX WARN: Type inference failed for: r5v0, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r5v11 */
    /* JADX WARN: Type inference failed for: r5v12 */
    /* JADX WARN: Type inference failed for: r5v17 */
    /* JADX WARN: Type inference failed for: r5v25 */
    /* JADX WARN: Type inference failed for: r5v30 */
    /* JADX WARN: Type inference failed for: r5v6 */
    /* JADX WARN: Type inference failed for: r5v7 */
    /* JADX WARN: Type inference failed for: r5v8 */
    /* JADX WARN: Type inference failed for: r5v9 */
    /* JADX WARN: Type inference failed for: r8v0, types: [long] */
    /* JADX WARN: Type inference failed for: r8v11 */
    /* JADX WARN: Type inference failed for: r8v12 */
    /* JADX WARN: Type inference failed for: r8v16 */
    /* JADX WARN: Type inference failed for: r8v31 */
    /* JADX WARN: Type inference failed for: r8v32 */
    /* JADX WARN: Type inference failed for: r8v37 */
    /* JADX WARN: Type inference failed for: r8v6 */
    /* JADX WARN: Type inference failed for: r8v7 */
    /* JADX WARN: Type inference failed for: r8v8 */
    /* JADX WARN: Type inference failed for: r8v9 */
    /* JADX WARN: Unreachable blocks removed: 2, instructions: 7 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static boolean a(java.lang.String str, boolean z, boolean z2, java.lang.String str2, int i, int i2) {
        long j;
        java.lang.String str3;
        java.lang.String str4;
        boolean z3;
        boolean z4;
        java.lang.String str5;
        java.lang.Throwable th;
        int i3;
        int i4;
        int i5;
        int i6;
        java.lang.String str6;
        boolean z5;
        boolean z6;
        java.lang.String str7;
        java.io.RandomAccessFile randomAccessFile;
        java.io.RandomAccessFile randomAccessFile2;
        java.io.RandomAccessFile randomAccessFile3;
        java.io.RandomAccessFile randomAccessFile4;
        java.lang.String str8;
        boolean z7;
        boolean z8;
        java.lang.String str9;
        java.util.HashSet hashSet;
        java.lang.String str10;
        java.lang.String str11;
        java.lang.String str12;
        java.io.ByteArrayOutputStream byteArrayOutputStream;
        int size;
        int i7;
        int i8;
        int i9;
        boolean z9;
        boolean z10;
        boolean z11;
        java.lang.String str13;
        java.lang.String str14;
        java.lang.String str15;
        boolean z12 = z;
        ?? r2 = z2;
        ?? r4 = "[shootsTag]";
        ?? r5 = com.bytedance.pangle.log.ZeusLogger.TAG;
        java.lang.String str16 = "rmSo:";
        ?? currentTimeMillis = java.lang.System.currentTimeMillis();
        try {
            new com.bytedance.pangle.util.b.a.a();
            com.bytedance.pangle.util.b.a aVar = new com.bytedance.pangle.util.b.a(com.bytedance.pangle.util.b.a.a.a(str));
            java.io.File file = new java.io.File(aVar.a.d.getAbsolutePath() + ".rm_tmp");
            if (file.exists()) {
                file.delete();
            }
            try {
                randomAccessFile3 = new java.io.RandomAccessFile(file, "rw");
                try {
                    randomAccessFile4 = new java.io.RandomAccessFile(aVar.a.d, "r");
                    try {
                        java.util.List<com.bytedance.pangle.util.b.b.c> list = aVar.a.a.a;
                        hashSet = new java.util.HashSet();
                        java.util.Iterator<com.bytedance.pangle.util.b.b.c> it = list.iterator();
                        int i10 = 0;
                        while (it.hasNext()) {
                            try {
                                java.util.Iterator<com.bytedance.pangle.util.b.b.c> it2 = it;
                                com.bytedance.pangle.util.b.b.c next = it.next();
                                if (z12) {
                                    try {
                                        if (com.bytedance.pangle.util.i.d()) {
                                            j = currentTimeMillis;
                                            try {
                                                str4 = "classes.dex";
                                                if (!next.h.equals("classes.dex")) {
                                                }
                                                z9 = false;
                                                if (z9) {
                                                    hashSet.add(next.h);
                                                    it = it2;
                                                    currentTimeMillis = j;
                                                } else {
                                                    try {
                                                        long j2 = next.i;
                                                        java.lang.String str17 = r5;
                                                        java.lang.String str18 = r4;
                                                        try {
                                                            if ("resources.arsc".equals(next.h)) {
                                                                long filePointer = randomAccessFile3.getFilePointer() + next.c();
                                                                long j3 = filePointer % 4096 == 0 ? 0L : 4096 - ((filePointer - next.g) % 4096);
                                                                if (j3 != 0) {
                                                                    int i11 = next.g;
                                                                    int i12 = (int) j3;
                                                                    next.g = i12;
                                                                    com.bytedance.pangle.util.b.a.a(randomAccessFile4, randomAccessFile3, j2, 28L, next.h);
                                                                    com.bytedance.pangle.util.b.a.c cVar = aVar.a.c;
                                                                    com.bytedance.pangle.util.b.a.c.a(cVar.a, i12);
                                                                    randomAccessFile3.write(cVar.a);
                                                                    long j4 = j2 + 28 + 2;
                                                                    str15 = str16;
                                                                    try {
                                                                        com.bytedance.pangle.util.b.a.a(randomAccessFile4, randomAccessFile3, j4, next.e, next.h);
                                                                        randomAccessFile3.write(new byte[i12]);
                                                                        com.bytedance.pangle.util.b.a.a(randomAccessFile4, randomAccessFile3, j4 + next.e + i11, next.a(), next.h);
                                                                        long j5 = i10;
                                                                        next.i = j5;
                                                                        i10 = (int) (j5 + next.b());
                                                                        z12 = z;
                                                                        r2 = z2;
                                                                        it = it2;
                                                                        currentTimeMillis = j;
                                                                        r5 = str17;
                                                                        r4 = str18;
                                                                        str16 = str15;
                                                                    } catch (java.lang.Throwable th2) {
                                                                        th = th2;
                                                                        z10 = z;
                                                                        z11 = z2;
                                                                        randomAccessFile2 = randomAccessFile3;
                                                                        str4 = str17;
                                                                        str14 = str18;
                                                                        str13 = str15;
                                                                        str9 = str13;
                                                                        z8 = z11;
                                                                        z7 = z10;
                                                                        str8 = str14;
                                                                        randomAccessFile = randomAccessFile4;
                                                                        str7 = str9;
                                                                        z6 = z8;
                                                                        z5 = z7;
                                                                        str6 = str8;
                                                                        if (randomAccessFile != null) {
                                                                        }
                                                                        if (randomAccessFile2 != null) {
                                                                        }
                                                                        com.bytedance.pangle.util.b.a.a(file);
                                                                        throw th;
                                                                    }
                                                                }
                                                            }
                                                            str15 = str16;
                                                            com.bytedance.pangle.util.b.a.a(randomAccessFile4, randomAccessFile3, j2, next.b(), next.h);
                                                            long j52 = i10;
                                                            next.i = j52;
                                                            i10 = (int) (j52 + next.b());
                                                            z12 = z;
                                                            r2 = z2;
                                                            it = it2;
                                                            currentTimeMillis = j;
                                                            r5 = str17;
                                                            r4 = str18;
                                                            str16 = str15;
                                                        } catch (java.lang.Throwable th3) {
                                                            th = th3;
                                                            z10 = z;
                                                            z11 = z2;
                                                            str13 = str16;
                                                            randomAccessFile2 = randomAccessFile3;
                                                            str4 = str17;
                                                            str14 = str18;
                                                        }
                                                    } catch (java.lang.Throwable th4) {
                                                        th = th4;
                                                        str8 = r4;
                                                        str4 = r5;
                                                        str9 = str16;
                                                        randomAccessFile2 = randomAccessFile3;
                                                        z7 = z;
                                                        z8 = z2;
                                                        randomAccessFile = randomAccessFile4;
                                                        str7 = str9;
                                                        z6 = z8;
                                                        z5 = z7;
                                                        str6 = str8;
                                                        if (randomAccessFile != null) {
                                                        }
                                                        if (randomAccessFile2 != null) {
                                                        }
                                                        com.bytedance.pangle.util.b.a.a(file);
                                                        throw th;
                                                    }
                                                }
                                            } catch (java.lang.Throwable th5) {
                                                th = th5;
                                                str6 = r4;
                                                str4 = r5;
                                                randomAccessFile2 = randomAccessFile3;
                                                z5 = z12;
                                                z6 = r2;
                                                str7 = str16;
                                                randomAccessFile = randomAccessFile4;
                                                if (randomAccessFile != null) {
                                                }
                                                if (randomAccessFile2 != null) {
                                                }
                                                com.bytedance.pangle.util.b.a.a(file);
                                                throw th;
                                            }
                                        } else {
                                            j = currentTimeMillis;
                                        }
                                        str4 = "classes";
                                        if (next.h.startsWith("classes")) {
                                            str4 = ".dex";
                                            if (next.h.endsWith(".dex")) {
                                                z9 = true;
                                                if (z9) {
                                                }
                                            }
                                        }
                                    } catch (java.lang.Throwable th6) {
                                        th = th6;
                                        j = currentTimeMillis;
                                    }
                                } else {
                                    j = currentTimeMillis;
                                }
                                if (r2 != 0) {
                                    str4 = "lib/";
                                    if (next.h.startsWith("lib/")) {
                                        str4 = ".so";
                                    }
                                }
                                z9 = false;
                                if (z9) {
                                }
                            } catch (java.lang.Throwable th7) {
                                th = th7;
                                j = currentTimeMillis;
                            }
                        }
                        str10 = r4;
                        str11 = r5;
                        str12 = str16;
                        j = currentTimeMillis;
                    } catch (java.lang.Throwable th8) {
                        th = th8;
                        j = currentTimeMillis;
                        currentTimeMillis = r4;
                        str4 = r5;
                        r5 = z12;
                        r4 = r2;
                        r2 = str16;
                    }
                } catch (java.lang.Throwable th9) {
                    th = th9;
                    j = currentTimeMillis;
                    str6 = "[shootsTag]";
                    str4 = com.bytedance.pangle.log.ZeusLogger.TAG;
                    z5 = z12;
                    z6 = r2 == true ? 1 : 0;
                    str7 = "rmSo:";
                    randomAccessFile2 = randomAccessFile3;
                    randomAccessFile = null;
                }
            } catch (java.lang.Throwable th10) {
                th = th10;
                j = currentTimeMillis;
                str6 = "[shootsTag]";
                str4 = com.bytedance.pangle.log.ZeusLogger.TAG;
                z5 = z12;
                z6 = r2 == true ? 1 : 0;
                str7 = "rmSo:";
                randomAccessFile = null;
                randomAccessFile2 = null;
            }
            try {
                aVar.a.a.a(hashSet);
                com.bytedance.pangle.util.b.b.d dVar = aVar.a;
                try {
                    if (dVar == null) {
                        throw new java.io.IOException("input parameters is null, cannot finalize zip file");
                    }
                    try {
                        byteArrayOutputStream = new java.io.ByteArrayOutputStream();
                        try {
                            long filePointer2 = randomAccessFile3.getFilePointer();
                            com.bytedance.pangle.util.b.a.b.a(dVar, byteArrayOutputStream);
                            size = byteArrayOutputStream.size();
                            i7 = (int) filePointer2;
                            dVar.c.a((java.io.OutputStream) byteArrayOutputStream, 101010256);
                        } catch (java.lang.Throwable th11) {
                            th = th11;
                        }
                    } catch (java.lang.Throwable th12) {
                        th = th12;
                        byteArrayOutputStream = null;
                    }
                    try {
                        dVar.c.a(byteArrayOutputStream, 0);
                        dVar.c.a(byteArrayOutputStream, 0);
                        int size2 = dVar.a.a.size();
                        dVar.c.a(byteArrayOutputStream, size2);
                        dVar.c.a(byteArrayOutputStream, size2);
                        dVar.c.a((java.io.OutputStream) byteArrayOutputStream, size);
                        dVar.c.a((java.io.OutputStream) byteArrayOutputStream, i7);
                        dVar.c.a(byteArrayOutputStream, 0);
                        randomAccessFile3.write(byteArrayOutputStream.toByteArray());
                        try {
                            byteArrayOutputStream.close();
                            if (!file.renameTo(aVar.a.d)) {
                                throw new java.util.zip.ZipException("cannot rename modified zip file");
                            }
                            try {
                                randomAccessFile4.close();
                                randomAccessFile3.close();
                                com.bytedance.pangle.util.b.a.a(file);
                                if (i2 != 0) {
                                    if (i2 == 1) {
                                        i9 = com.bytedance.pangle.c.b.a.a;
                                    } else if (i2 == 2) {
                                        i9 = com.bytedance.pangle.c.b.a.b;
                                    } else {
                                        i8 = 0;
                                        java.lang.String str19 = str12 + z2 + " rmDex:" + z;
                                        com.bytedance.pangle.log.ZeusLogger.d(str11, str10.concat(java.lang.String.valueOf(str19)));
                                        a(i8, str2, i, java.lang.System.currentTimeMillis() - j, (java.lang.Throwable) null, str19);
                                    }
                                    i8 = i9;
                                    java.lang.String str192 = str12 + z2 + " rmDex:" + z;
                                    com.bytedance.pangle.log.ZeusLogger.d(str11, str10.concat(java.lang.String.valueOf(str192)));
                                    a(i8, str2, i, java.lang.System.currentTimeMillis() - j, (java.lang.Throwable) null, str192);
                                }
                                return true;
                            } catch (java.lang.Throwable th13) {
                                th = th13;
                                z3 = z;
                                z4 = z2;
                                str4 = str11;
                                str3 = str10;
                                str5 = str12;
                                th = th;
                                try {
                                    com.bytedance.pangle.log.ZeusLogger.errReport(com.bytedance.pangle.log.ZeusLogger.TAG_INSTALL, "rmEntries failed. zipFile:" + str + " rmDex:" + z3 + " rmSO:" + z4, th);
                                    if (i2 != 0) {
                                        if (i2 == 1) {
                                            i6 = com.bytedance.pangle.c.b.a.c;
                                        } else if (i2 == 2) {
                                            i6 = com.bytedance.pangle.c.b.a.d;
                                        } else {
                                            i5 = 0;
                                            java.lang.String str20 = str5 + z4 + " rmDex:" + z3;
                                            com.bytedance.pangle.log.ZeusLogger.d(str4, str3.concat(java.lang.String.valueOf(str20)));
                                            a(i5, str2, i, java.lang.System.currentTimeMillis() - j, th, str20);
                                        }
                                        i5 = i6;
                                        java.lang.String str202 = str5 + z4 + " rmDex:" + z3;
                                        com.bytedance.pangle.log.ZeusLogger.d(str4, str3.concat(java.lang.String.valueOf(str202)));
                                        a(i5, str2, i, java.lang.System.currentTimeMillis() - j, th, str202);
                                    }
                                    return false;
                                } catch (java.lang.Throwable th14) {
                                    if (i2 != 0) {
                                        if (i2 == 1) {
                                            i3 = com.bytedance.pangle.c.b.a.c;
                                        } else if (i2 == 2) {
                                            i3 = com.bytedance.pangle.c.b.a.d;
                                        } else {
                                            i4 = 0;
                                            java.lang.String str21 = str5 + z4 + " rmDex:" + z3;
                                            com.bytedance.pangle.log.ZeusLogger.d(str4, str3.concat(java.lang.String.valueOf(str21)));
                                            a(i4, str2, i, java.lang.System.currentTimeMillis() - j, th, str21);
                                        }
                                        i4 = i3;
                                        java.lang.String str212 = str5 + z4 + " rmDex:" + z3;
                                        com.bytedance.pangle.log.ZeusLogger.d(str4, str3.concat(java.lang.String.valueOf(str212)));
                                        a(i4, str2, i, java.lang.System.currentTimeMillis() - j, th, str212);
                                    }
                                    throw th14;
                                }
                            }
                        } catch (java.lang.Throwable th15) {
                            th = th15;
                            r5 = z;
                            r4 = z2;
                            str4 = str11;
                            currentTimeMillis = str10;
                            r2 = str12;
                            randomAccessFile2 = randomAccessFile3;
                            str9 = r2;
                            z8 = r4;
                            z7 = r5;
                            str8 = currentTimeMillis;
                            randomAccessFile = randomAccessFile4;
                            str7 = str9;
                            z6 = z8;
                            z5 = z7;
                            str6 = str8;
                            if (randomAccessFile != null) {
                                try {
                                    randomAccessFile.close();
                                } catch (java.lang.Throwable th16) {
                                    th = th16;
                                    str5 = str7;
                                    z4 = z6;
                                    z3 = z5;
                                    str3 = str6;
                                    th = th;
                                    com.bytedance.pangle.log.ZeusLogger.errReport(com.bytedance.pangle.log.ZeusLogger.TAG_INSTALL, "rmEntries failed. zipFile:" + str + " rmDex:" + z3 + " rmSO:" + z4, th);
                                    if (i2 != 0) {
                                    }
                                    return false;
                                }
                            }
                            if (randomAccessFile2 != null) {
                                randomAccessFile2.close();
                            }
                            com.bytedance.pangle.util.b.a.a(file);
                            throw th;
                        }
                    } catch (java.lang.Throwable th17) {
                        th = th17;
                        if (byteArrayOutputStream != null) {
                            byteArrayOutputStream.close();
                        }
                        throw th;
                    }
                } catch (java.lang.Throwable th18) {
                    th = th18;
                }
            } catch (java.lang.Throwable th19) {
                th = th19;
                r5 = z;
                r4 = z2;
                str4 = str11;
                currentTimeMillis = str10;
                r2 = str12;
                randomAccessFile2 = randomAccessFile3;
                str9 = r2;
                z8 = r4;
                z7 = r5;
                str8 = currentTimeMillis;
                randomAccessFile = randomAccessFile4;
                str7 = str9;
                z6 = z8;
                z5 = z7;
                str6 = str8;
                if (randomAccessFile != null) {
                }
                if (randomAccessFile2 != null) {
                }
                com.bytedance.pangle.util.b.a.a(file);
                throw th;
            }
        } catch (java.lang.Throwable th20) {
            th = th20;
            j = currentTimeMillis;
            str3 = "[shootsTag]";
            str4 = com.bytedance.pangle.log.ZeusLogger.TAG;
            z3 = z12;
            z4 = r2 == true ? 1 : 0;
            str5 = "rmSo:";
        }
    }
}
