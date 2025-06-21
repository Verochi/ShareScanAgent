package com.igexin.base.a;

/* loaded from: classes22.dex */
final class b implements java.lang.Runnable {
    private static com.igexin.base.a.b b;
    final java.util.List<com.igexin.base.a.c> a = new java.util.ArrayList();

    private b() {
        java.util.concurrent.Executors.newScheduledThreadPool(1).scheduleWithFixedDelay(this, 5L, 5L, java.util.concurrent.TimeUnit.SECONDS);
    }

    public static synchronized com.igexin.base.a.b a() {
        com.igexin.base.a.b bVar;
        synchronized (com.igexin.base.a.b.class) {
            if (b == null) {
                b = new com.igexin.base.a.b();
            }
            bVar = b;
        }
        return bVar;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:30:0x022b A[Catch: all -> 0x0245, TRY_ENTER, TryCatch #5 {all -> 0x0245, blocks: (B:3:0x000b, B:5:0x001c, B:7:0x0026, B:11:0x002d, B:14:0x0034, B:17:0x003b, B:18:0x0042, B:20:0x0048, B:22:0x0057, B:24:0x005d, B:30:0x022b, B:32:0x0231, B:124:0x0239, B:126:0x023f, B:127:0x0242), top: B:2:0x000b }] */
    /* JADX WARN: Removed duplicated region for block: B:35:? A[ADDED_TO_REGION, RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:79:0x01f0  */
    /* JADX WARN: Type inference failed for: r21v10 */
    /* JADX WARN: Type inference failed for: r21v18 */
    /* JADX WARN: Type inference failed for: r21v19 */
    /* JADX WARN: Type inference failed for: r21v2 */
    /* JADX WARN: Type inference failed for: r21v3 */
    /* JADX WARN: Type inference failed for: r21v4 */
    /* JADX WARN: Type inference failed for: r21v6 */
    /* JADX WARN: Type inference failed for: r21v7, types: [int] */
    /* JADX WARN: Type inference failed for: r21v8 */
    /* JADX WARN: Type inference failed for: r21v9 */
    /* JADX WARN: Type inference failed for: r27v12 */
    /* JADX WARN: Type inference failed for: r27v13 */
    /* JADX WARN: Type inference failed for: r27v2 */
    /* JADX WARN: Type inference failed for: r27v3 */
    /* JADX WARN: Type inference failed for: r27v5 */
    /* JADX WARN: Type inference failed for: r9v0, types: [int] */
    /* JADX WARN: Type inference failed for: r9v1 */
    /* JADX WARN: Type inference failed for: r9v17 */
    /* JADX WARN: Type inference failed for: r9v18 */
    /* JADX WARN: Type inference failed for: r9v2 */
    /* JADX WARN: Type inference failed for: r9v3 */
    /* JADX WARN: Type inference failed for: r9v5 */
    /* JADX WARN: Type inference failed for: r9v6 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static boolean a(com.igexin.base.a.c cVar) {
        ?? size;
        java.nio.channels.FileLock fileLock;
        org.json.JSONObject jSONObject;
        org.json.JSONObject jSONObject2;
        byte[] a;
        boolean z;
        ?? r21;
        java.io.OutputStream outputStream;
        java.io.OutputStream fileOutputStream;
        java.lang.String str;
        java.nio.channels.FileLock fileLock2;
        java.lang.String str2;
        java.lang.String bytesToHexString;
        java.nio.channels.FileLock fileLock3;
        java.lang.Object obj;
        java.lang.Object obj2;
        java.lang.Object obj3;
        java.nio.channels.FileLock fileLock4;
        java.lang.String str3 = "";
        java.lang.String str4 = null;
        try {
            java.io.File file = new java.io.File(cVar.a(cVar.f));
            if (!file.exists()) {
                java.io.File parentFile = file.getParentFile();
                if ((!parentFile.exists() && !parentFile.mkdirs()) || !file.createNewFile()) {
                    return false;
                }
            }
            if (!file.isFile()) {
                return false;
            }
            java.lang.StringBuilder sb = new java.lang.StringBuilder();
            java.util.List<java.lang.String> list = cVar.a;
            while (true) {
                size = list.size();
                if (size <= 0) {
                    break;
                }
                sb.append(list.remove(0));
                sb.append("\r\n");
            }
            if (sb.length() <= 0) {
                return true;
            }
            java.io.RandomAccessFile randomAccessFile = new java.io.RandomAccessFile(file, "rw");
            try {
                java.nio.channels.FileLock lock = randomAccessFile.getChannel().lock();
                if (lock != null) {
                    try {
                        if (lock.isValid()) {
                            java.lang.String sb2 = sb.toString();
                            java.lang.String str5 = cVar.e;
                            java.lang.String md5 = com.igexin.base.util.StringUtil.getMD5(file.getAbsolutePath());
                            try {
                                try {
                                    jSONObject = new org.json.JSONObject(com.igexin.base.api.SharedPreferencesManager.get("gbase").getParam("logkey3", "").toString());
                                    try {
                                        str3 = jSONObject.getString(md5);
                                    } catch (org.json.JSONException unused) {
                                    }
                                } catch (org.json.JSONException unused2) {
                                    jSONObject = null;
                                }
                                java.lang.String str6 = str3;
                                jSONObject2 = jSONObject;
                                if (android.text.TextUtils.isEmpty(str6)) {
                                    javax.crypto.KeyGenerator keyGenerator = javax.crypto.KeyGenerator.getInstance("AES");
                                    keyGenerator.init(128);
                                    byte[] encoded = keyGenerator.generateKey().getEncoded();
                                    if (file.length() > 0) {
                                        file.delete();
                                    }
                                    a = encoded;
                                    z = true;
                                } else {
                                    a = com.igexin.base.util.a.a.a(com.igexin.base.util.StringUtil.hexStringToBytes(str6), (android.text.TextUtils.isEmpty(str5) ? "cantgetimei" : str5).getBytes());
                                    z = false;
                                }
                            } catch (java.lang.Throwable th) {
                                th = th;
                                fileLock = lock;
                                if (fileLock != null && fileLock.isValid()) {
                                    fileLock.release();
                                }
                                throw th;
                            }
                            try {
                                try {
                                    javax.crypto.spec.SecretKeySpec secretKeySpec = new javax.crypto.spec.SecretKeySpec(a, "AES");
                                    byte[] bArr = new byte[16];
                                    r21 = (randomAccessFile.length() > 0L ? 1 : (randomAccessFile.length() == 0L ? 0 : -1));
                                    try {
                                        try {
                                            if (r21 == 0) {
                                                try {
                                                    bytesToHexString = com.igexin.base.util.StringUtil.bytesToHexString(secretKeySpec.getEncoded());
                                                    cVar = "cantgetimei";
                                                } catch (java.lang.Throwable th2) {
                                                    th = th2;
                                                    r21 = lock;
                                                    cVar = "cantgetimei";
                                                }
                                                try {
                                                    fileLock3 = lock;
                                                    java.security.interfaces.RSAPublicKey rSAPublicKey = (java.security.interfaces.RSAPublicKey) java.security.KeyFactory.getInstance(com.alipay.sdk.m.n.d.a).generatePublic(new java.security.spec.X509EncodedKeySpec(android.util.Base64.decode(com.igexin.push.h.e.a, 0)));
                                                    javax.crypto.Cipher cipher = javax.crypto.Cipher.getInstance("RSA/ECB/OAEPWithSHA1AndMGF1Padding");
                                                    cipher.init(1, rSAPublicKey);
                                                    randomAccessFile.write(cipher.doFinal(bytesToHexString.getBytes("UTF-8")));
                                                    new java.security.SecureRandom().nextBytes(bArr);
                                                    randomAccessFile.write(bArr);
                                                    str4 = "logkey3";
                                                    obj = "gbase";
                                                    obj2 = cVar;
                                                } catch (java.lang.Throwable th3) {
                                                    th = th3;
                                                    r21 = lock;
                                                    str4 = "logkey3";
                                                    size = "gbase";
                                                    try {
                                                        th.printStackTrace();
                                                        fileOutputStream = new java.io.FileOutputStream(file, true);
                                                        size = size;
                                                        r21 = r21;
                                                        cVar = cVar;
                                                        outputStream = fileOutputStream;
                                                        try {
                                                            outputStream.write(sb2.getBytes("UTF-8"));
                                                            str2 = size;
                                                            fileLock2 = r21;
                                                            str = cVar;
                                                        } catch (java.io.IOException e) {
                                                            e = e;
                                                            e.printStackTrace();
                                                            str2 = size;
                                                            fileLock2 = r21;
                                                            str = cVar;
                                                            com.igexin.base.util.IOUtils.close(outputStream);
                                                            fileLock4 = fileLock2;
                                                            if (z) {
                                                            }
                                                            if (fileLock4 == null) {
                                                            }
                                                        }
                                                    } catch (java.io.IOException e2) {
                                                        e = e2;
                                                        outputStream = null;
                                                        e.printStackTrace();
                                                        str2 = size;
                                                        fileLock2 = r21;
                                                        str = cVar;
                                                        com.igexin.base.util.IOUtils.close(outputStream);
                                                        fileLock4 = fileLock2;
                                                        if (z) {
                                                        }
                                                        if (fileLock4 == null) {
                                                        }
                                                    } catch (java.lang.Throwable th4) {
                                                        th = th4;
                                                        outputStream = null;
                                                        com.igexin.base.util.IOUtils.close(outputStream);
                                                        throw th;
                                                    }
                                                    com.igexin.base.util.IOUtils.close(outputStream);
                                                    fileLock4 = fileLock2;
                                                    if (z) {
                                                    }
                                                    if (fileLock4 == null) {
                                                    }
                                                }
                                            } else {
                                                fileLock3 = lock;
                                                obj2 = "cantgetimei";
                                                if (randomAccessFile.length() < 144) {
                                                    throw new java.lang.IllegalArgumentException("Invalid file length (need 2 blocks for iv and data)");
                                                }
                                                if (randomAccessFile.length() % 16 != 0) {
                                                    str4 = "logkey3";
                                                    obj3 = "gbase";
                                                    long length = (int) (randomAccessFile.length() % 16);
                                                    if (length < 16 && length > 0) {
                                                        randomAccessFile.setLength(randomAccessFile.length() - length);
                                                    }
                                                    randomAccessFile.seek(randomAccessFile.length() - 16);
                                                } else {
                                                    str4 = "logkey3";
                                                    obj3 = "gbase";
                                                    randomAccessFile.seek(randomAccessFile.length() - 16);
                                                }
                                                randomAccessFile.read(bArr);
                                                obj = obj3;
                                            }
                                            javax.crypto.Cipher cipher2 = javax.crypto.Cipher.getInstance("AES/CBC/PKCS5Padding");
                                            cipher2.init(1, secretKeySpec, new javax.crypto.spec.IvParameterSpec(bArr));
                                            fileOutputStream = new javax.crypto.CipherOutputStream(new java.io.FileOutputStream(randomAccessFile.getFD()), cipher2);
                                            size = obj;
                                            r21 = fileLock3;
                                            cVar = obj2;
                                        } catch (java.lang.Throwable th5) {
                                            th = th5;
                                            th.printStackTrace();
                                            fileOutputStream = new java.io.FileOutputStream(file, true);
                                            size = size;
                                            r21 = r21;
                                            cVar = cVar;
                                            outputStream = fileOutputStream;
                                            outputStream.write(sb2.getBytes("UTF-8"));
                                            str2 = size;
                                            fileLock2 = r21;
                                            str = cVar;
                                            com.igexin.base.util.IOUtils.close(outputStream);
                                            fileLock4 = fileLock2;
                                            if (z) {
                                            }
                                            if (fileLock4 == null) {
                                            }
                                        }
                                    } catch (java.lang.Throwable th6) {
                                        th = th6;
                                    }
                                } catch (java.lang.Throwable th7) {
                                    th = th7;
                                    str4 = "logkey3";
                                    size = "gbase";
                                    r21 = lock;
                                    cVar = "cantgetimei";
                                }
                                outputStream = fileOutputStream;
                                try {
                                    outputStream.write(sb2.getBytes("UTF-8"));
                                    str2 = size;
                                    fileLock2 = r21;
                                    str = cVar;
                                    com.igexin.base.util.IOUtils.close(outputStream);
                                    fileLock4 = fileLock2;
                                    if (z) {
                                        if (jSONObject2 == null) {
                                            jSONObject2 = new org.json.JSONObject();
                                        }
                                        if (android.text.TextUtils.isEmpty(str5)) {
                                            str5 = str;
                                        }
                                        jSONObject2.put(md5, com.igexin.base.util.StringUtil.bytesToHexString(com.igexin.base.util.a.a.a(a, str5.getBytes())));
                                        com.igexin.base.api.SharedPreferencesManager.get(str2).saveParam(str4, jSONObject2.toString());
                                        fileLock4 = fileLock2;
                                    }
                                    if (fileLock4 == null && fileLock4.isValid()) {
                                        fileLock4.release();
                                        return true;
                                    }
                                } catch (java.lang.Throwable th8) {
                                    th = th8;
                                    com.igexin.base.util.IOUtils.close(outputStream);
                                    throw th;
                                }
                            } catch (java.lang.Throwable th9) {
                                th = th9;
                                fileLock = lock;
                                if (fileLock != null) {
                                    fileLock.release();
                                }
                                throw th;
                            }
                        }
                    } catch (java.lang.Throwable th10) {
                        th = th10;
                    }
                }
                fileLock4 = lock;
                return fileLock4 == null ? true : true;
            } catch (java.lang.Throwable th11) {
                th = th11;
                fileLock = null;
            }
        } catch (java.lang.Throwable unused3) {
            return false;
        }
    }

    @Override // java.lang.Runnable
    public final void run() {
        for (com.igexin.base.a.c cVar : this.a) {
            if (cVar.isEnabled()) {
                if (cVar.a.size() >= cVar.b || android.os.SystemClock.elapsedRealtime() - cVar.d >= cVar.c) {
                    a(cVar);
                    cVar.d = android.os.SystemClock.elapsedRealtime();
                }
            }
        }
    }
}
