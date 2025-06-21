package com.getui.gtc.base.log.b;

/* loaded from: classes22.dex */
public class a implements com.getui.gtc.base.log.ILogDestination {
    private static final java.util.Map<java.io.File, com.getui.gtc.base.log.b.a.HandlerC0295a> a = new java.util.concurrent.ConcurrentHashMap();
    private final android.content.Context b;
    private java.io.File c;

    /* renamed from: com.getui.gtc.base.log.b.a$a, reason: collision with other inner class name */
    public static class HandlerC0295a extends android.os.Handler {
        final javax.crypto.SecretKey a;
        final javax.crypto.spec.IvParameterSpec b;
        final java.io.File c;

        public HandlerC0295a(android.os.Looper looper, java.io.File file, javax.crypto.SecretKey secretKey, javax.crypto.spec.IvParameterSpec ivParameterSpec) {
            super(looper);
            this.c = file;
            this.a = secretKey;
            this.b = ivParameterSpec;
        }

        @Override // android.os.Handler
        public final void handleMessage(android.os.Message message) {
            java.io.RandomAccessFile randomAccessFile;
            java.nio.channels.FileLock fileLock;
            java.nio.channels.FileLock fileLock2;
            java.io.RandomAccessFile randomAccessFile2;
            int i = message.what;
            java.io.DataOutputStream dataOutputStream = null;
            if (i == 1) {
                java.io.File file = this.c;
                try {
                    randomAccessFile = new java.io.RandomAccessFile(file, "rw");
                    try {
                        fileLock = randomAccessFile.getChannel().lock();
                        if (fileLock != null) {
                            try {
                                if (fileLock.isValid()) {
                                    java.io.DataOutputStream dataOutputStream2 = new java.io.DataOutputStream(new java.io.FileOutputStream(file, true));
                                    try {
                                        byte[] encrypt = com.getui.gtc.base.crypt.CryptTools.encrypt("RSA/ECB/OAEPWithSHA1AndMGF1Padding", com.getui.gtc.base.crypt.CryptTools.parsePublicKey(com.alipay.sdk.m.n.d.a, com.igexin.push.h.e.a), this.a.getEncoded());
                                        int length = encrypt.length;
                                        dataOutputStream2.write(0);
                                        dataOutputStream2.write(this.b.getIV());
                                        dataOutputStream2.writeInt(length);
                                        dataOutputStream2.write(encrypt);
                                        dataOutputStream = dataOutputStream2;
                                    } catch (java.lang.Throwable th) {
                                        th = th;
                                        dataOutputStream = dataOutputStream2;
                                        try {
                                            java.lang.System.out.println("gtc-base fileLog writeKeyBlock failed: " + th.getMessage());
                                            th.printStackTrace();
                                            if (dataOutputStream != null) {
                                                try {
                                                    dataOutputStream.flush();
                                                    dataOutputStream.close();
                                                } catch (java.io.IOException unused) {
                                                }
                                            }
                                            if (fileLock2 != null && fileLock2.isValid()) {
                                                try {
                                                    fileLock2.release();
                                                } catch (java.io.IOException unused2) {
                                                }
                                            }
                                            if (randomAccessFile2 != null) {
                                                try {
                                                    randomAccessFile2.close();
                                                    return;
                                                } catch (java.io.IOException unused3) {
                                                    return;
                                                }
                                            }
                                            return;
                                        } finally {
                                        }
                                    }
                                }
                            } catch (java.lang.Throwable th2) {
                                th = th2;
                            }
                        }
                        if (dataOutputStream != null) {
                            try {
                                dataOutputStream.flush();
                                dataOutputStream.close();
                            } catch (java.io.IOException unused4) {
                            }
                        }
                        if (fileLock != null && fileLock.isValid()) {
                            try {
                                fileLock.release();
                            } catch (java.io.IOException unused5) {
                            }
                        }
                        try {
                            randomAccessFile.close();
                        } catch (java.io.IOException unused6) {
                        }
                    } catch (java.lang.Throwable th3) {
                        th = th3;
                        fileLock = null;
                    }
                } catch (java.lang.Throwable th4) {
                    th = th4;
                    randomAccessFile = null;
                    fileLock = null;
                }
            } else {
                if (i != 2) {
                    return;
                }
                java.lang.String str = (java.lang.String) message.obj;
                java.io.File file2 = this.c;
                try {
                    randomAccessFile2 = new java.io.RandomAccessFile(file2, "rw");
                    try {
                        fileLock2 = randomAccessFile2.getChannel().lock();
                        if (fileLock2 != null) {
                            try {
                                if (fileLock2.isValid()) {
                                    java.io.DataOutputStream dataOutputStream3 = new java.io.DataOutputStream(new java.io.FileOutputStream(file2, true));
                                    try {
                                        byte[] digest = com.getui.gtc.base.crypt.CryptTools.digest("SHA1", this.a.getEncoded());
                                        byte[] encrypt2 = com.getui.gtc.base.crypt.CryptTools.encrypt("AES/CBC/PKCS5Padding", this.a, this.b, str.getBytes());
                                        int length2 = encrypt2.length;
                                        dataOutputStream3.write(112);
                                        dataOutputStream3.write(digest);
                                        dataOutputStream3.writeInt(length2);
                                        dataOutputStream3.write(encrypt2);
                                        dataOutputStream = dataOutputStream3;
                                    } catch (java.lang.Throwable th5) {
                                        th = th5;
                                        dataOutputStream = dataOutputStream3;
                                        try {
                                            java.lang.System.out.println("gtc-base fileLog writeMessageBlock failed: ".concat(java.lang.String.valueOf(str)));
                                            th.printStackTrace();
                                            if (dataOutputStream != null) {
                                                try {
                                                    dataOutputStream.flush();
                                                    dataOutputStream.close();
                                                } catch (java.io.IOException unused7) {
                                                }
                                            }
                                            if (fileLock2 != null && fileLock2.isValid()) {
                                                try {
                                                    fileLock2.release();
                                                } catch (java.io.IOException unused8) {
                                                }
                                            }
                                            if (randomAccessFile2 != null) {
                                                try {
                                                    randomAccessFile2.close();
                                                    return;
                                                } catch (java.io.IOException unused9) {
                                                    return;
                                                }
                                            }
                                            return;
                                        } finally {
                                        }
                                    }
                                }
                            } catch (java.lang.Throwable th6) {
                                th = th6;
                            }
                        }
                        if (dataOutputStream != null) {
                            try {
                                dataOutputStream.flush();
                                dataOutputStream.close();
                            } catch (java.io.IOException unused10) {
                            }
                        }
                        if (fileLock2 != null && fileLock2.isValid()) {
                            try {
                                fileLock2.release();
                            } catch (java.io.IOException unused11) {
                            }
                        }
                        try {
                            randomAccessFile2.close();
                        } catch (java.io.IOException unused12) {
                        }
                    } catch (java.lang.Throwable th7) {
                        th = th7;
                        fileLock2 = null;
                    }
                } catch (java.lang.Throwable th8) {
                    th = th8;
                    fileLock2 = null;
                    randomAccessFile2 = null;
                }
            }
        }
    }

    public a(android.content.Context context) {
        this.b = context;
        a(null);
    }

    public final void a(java.lang.String str) {
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        sb.append(this.b.getPackageName());
        java.lang.String str2 = com.xiaomi.mipush.sdk.Constants.ACCEPT_TIME_SEPARATOR_SERVER;
        if (str != null) {
            str2 = com.xiaomi.mipush.sdk.Constants.ACCEPT_TIME_SEPARATOR_SERVER + str + com.xiaomi.mipush.sdk.Constants.ACCEPT_TIME_SEPARATOR_SERVER;
        }
        sb.append(str2);
        sb.append(new java.text.SimpleDateFormat("yyyy-MM-dd", java.util.Locale.getDefault()).format(new java.util.Date()));
        sb.append(com.anythink.china.common.a.a.f);
        this.c = new java.io.File(com.getui.gtc.base.util.CommonUtil.getExternalFilesDir(this.b), sb.toString());
    }

    @Override // com.getui.gtc.base.log.ILogDestination
    public void log(int i, java.lang.String str, java.lang.String str2) {
        com.getui.gtc.base.log.b.a.HandlerC0295a handlerC0295a = a.get(this.c);
        if (!this.c.exists()) {
            try {
                this.c.getParentFile().mkdirs();
                this.c.createNewFile();
            } catch (java.lang.Throwable unused) {
            }
            if (handlerC0295a != null) {
                handlerC0295a.obtainMessage(1).sendToTarget();
            }
        }
        if (handlerC0295a == null) {
            synchronized (com.getui.gtc.base.log.b.a.class) {
                java.util.Map<java.io.File, com.getui.gtc.base.log.b.a.HandlerC0295a> map = a;
                com.getui.gtc.base.log.b.a.HandlerC0295a handlerC0295a2 = map.get(this.c);
                if (handlerC0295a2 == null) {
                    try {
                        javax.crypto.SecretKey generateKey = com.getui.gtc.base.crypt.CryptTools.generateKey("AES", 128);
                        android.os.HandlerThread handlerThread = new android.os.HandlerThread("File-Log-Thread");
                        handlerThread.start();
                        byte[] generateSeed = new java.security.SecureRandom().generateSeed(16);
                        java.io.File file = this.c;
                        com.getui.gtc.base.log.b.a.HandlerC0295a handlerC0295a3 = new com.getui.gtc.base.log.b.a.HandlerC0295a(handlerThread.getLooper(), this.c, generateKey, new javax.crypto.spec.IvParameterSpec(generateSeed));
                        map.put(file, handlerC0295a3);
                        handlerC0295a = handlerC0295a3;
                    } catch (java.security.NoSuchAlgorithmException e) {
                        e.printStackTrace();
                        return;
                    }
                } else {
                    handlerC0295a = handlerC0295a2;
                }
            }
            handlerC0295a.obtainMessage(1).sendToTarget();
        }
        handlerC0295a.obtainMessage(2, str2).sendToTarget();
    }
}
