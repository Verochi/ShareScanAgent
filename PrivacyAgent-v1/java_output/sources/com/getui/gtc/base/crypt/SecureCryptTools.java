package com.getui.gtc.base.crypt;

/* loaded from: classes22.dex */
public class SecureCryptTools {
    private static final java.lang.String CIPHER_FLAG_FIRST = "First";
    private static final java.lang.String CIPHER_FLAG_SECOND = "Second";
    private static final java.lang.String CIPHER_FLAG_SEPARATOR = "-";
    private static final java.lang.String CIPHER_FLAG_STARTER = ":::";
    private volatile boolean initInvoked;
    private java.util.concurrent.locks.ReentrantLock lock;
    private com.getui.gtc.base.crypt.d secureKeyStore;

    public static class a {
        private static com.getui.gtc.base.crypt.SecureCryptTools a = new com.getui.gtc.base.crypt.SecureCryptTools(null);
    }

    private SecureCryptTools() {
        this.lock = new java.util.concurrent.locks.ReentrantLock();
        try {
            init(com.getui.gtc.base.GtcProvider.context());
        } catch (java.lang.Throwable th) {
            th.printStackTrace();
        }
    }

    public /* synthetic */ SecureCryptTools(com.getui.gtc.base.crypt.SecureCryptTools.AnonymousClass1 anonymousClass1) {
        this();
    }

    /* JADX WARN: Multi-variable type inference failed */
    private synchronized byte[] doDecrypt(byte[] bArr) throws com.getui.gtc.base.crypt.CryptException {
        java.io.InputStream inputStream;
        java.io.InputStream inputStream2;
        java.io.ByteArrayInputStream byteArrayInputStream;
        java.io.InputStream inputStream3;
        java.io.InputStream inputStream4;
        java.io.ByteArrayInputStream byteArrayInputStream2;
        java.lang.String cipherFlag = getCipherFlag(bArr);
        if (cipherFlag == null) {
            throw new com.getui.gtc.base.crypt.CryptException("Cipher flag not found in cipher text!");
        }
        java.lang.String[] split = cipherFlag.split("-");
        if (split.length < 2) {
            throw new com.getui.gtc.base.crypt.CryptException("Cipher flag is wrong in cipher text!");
        }
        java.lang.String str = split[0];
        byte[] copyOfRange = java.util.Arrays.copyOfRange(bArr, 0, (bArr.length - cipherFlag.length()) - 3);
        java.io.InputStream inputStream5 = null;
        if (cipherFlag.endsWith(CIPHER_FLAG_FIRST)) {
            try {
                byteArrayInputStream = new java.io.ByteArrayInputStream(copyOfRange);
            } catch (java.lang.Throwable th) {
                th = th;
                inputStream = null;
            }
            try {
                java.io.ByteArrayOutputStream byteArrayOutputStream = new java.io.ByteArrayOutputStream();
                try {
                    inputStream5 = com.getui.gtc.base.crypt.CryptTools.decrypt("AES/CBC/PKCS7Padding", this.secureKeyStore.a(str), this.secureKeyStore.c(str), byteArrayInputStream);
                    byte[] bArr2 = new byte[256];
                    while (true) {
                        int read = inputStream5.read(bArr2);
                        if (read == -1) {
                            byteArrayOutputStream.flush();
                            byte[] byteArray = byteArrayOutputStream.toByteArray();
                            com.getui.gtc.base.util.io.IOUtils.safeClose(inputStream5);
                            com.getui.gtc.base.util.io.IOUtils.safeClose(byteArrayInputStream);
                            com.getui.gtc.base.util.io.IOUtils.safeClose(byteArrayOutputStream);
                            return byteArray;
                        }
                        byteArrayOutputStream.write(bArr2, 0, read);
                    }
                } catch (java.lang.Throwable th2) {
                    th = th2;
                    inputStream2 = byteArrayOutputStream;
                    inputStream = inputStream5;
                    inputStream5 = byteArrayInputStream;
                    try {
                        throw new com.getui.gtc.base.crypt.CryptException("decrypt failed!", th);
                    } finally {
                    }
                }
            } catch (java.lang.Throwable th3) {
                th = th3;
                inputStream = null;
                inputStream5 = byteArrayInputStream;
                inputStream2 = inputStream;
                throw new com.getui.gtc.base.crypt.CryptException("decrypt failed!", th);
            }
        } else {
            if (!cipherFlag.endsWith(CIPHER_FLAG_SECOND)) {
                throw new com.getui.gtc.base.crypt.CryptException("Cipher flag not found in cipher text!");
            }
            try {
                byteArrayInputStream2 = new java.io.ByteArrayInputStream(copyOfRange);
            } catch (java.lang.Throwable th4) {
                th = th4;
                inputStream3 = null;
            }
            try {
                java.io.ByteArrayOutputStream byteArrayOutputStream2 = new java.io.ByteArrayOutputStream();
                try {
                    inputStream5 = com.getui.gtc.base.crypt.CryptTools.decrypt("AES/CBC/PKCS7Padding", this.secureKeyStore.b(str), this.secureKeyStore.c(str), byteArrayInputStream2);
                    byte[] bArr3 = new byte[256];
                    while (true) {
                        int read2 = inputStream5.read(bArr3);
                        if (read2 == -1) {
                            byteArrayOutputStream2.flush();
                            byte[] byteArray2 = byteArrayOutputStream2.toByteArray();
                            com.getui.gtc.base.util.io.IOUtils.safeClose(inputStream5);
                            com.getui.gtc.base.util.io.IOUtils.safeClose(byteArrayInputStream2);
                            com.getui.gtc.base.util.io.IOUtils.safeClose(byteArrayOutputStream2);
                            return byteArray2;
                        }
                        byteArrayOutputStream2.write(bArr3, 0, read2);
                    }
                } catch (java.lang.Throwable th5) {
                    th = th5;
                    inputStream4 = byteArrayOutputStream2;
                    inputStream3 = inputStream5;
                    inputStream5 = byteArrayInputStream2;
                    try {
                        throw new com.getui.gtc.base.crypt.CryptException("decrypt failed!", th);
                    } finally {
                    }
                }
            } catch (java.lang.Throwable th6) {
                th = th6;
                inputStream3 = null;
                inputStream5 = byteArrayInputStream2;
                inputStream4 = inputStream3;
                throw new com.getui.gtc.base.crypt.CryptException("decrypt failed!", th);
            }
        }
    }

    private byte[] doEncrypt(byte[] bArr) throws com.getui.gtc.base.crypt.CryptException {
        java.io.InputStream inputStream;
        java.io.ByteArrayInputStream byteArrayInputStream;
        java.io.InputStream inputStream2;
        java.io.ByteArrayOutputStream byteArrayOutputStream;
        java.io.ByteArrayInputStream byteArrayInputStream2;
        java.io.ByteArrayOutputStream byteArrayOutputStream2;
        java.io.ByteArrayOutputStream byteArrayOutputStream3 = null;
        if (this.secureKeyStore.c != null) {
            try {
                java.io.ByteArrayInputStream byteArrayInputStream3 = new java.io.ByteArrayInputStream(bArr);
                try {
                    byteArrayOutputStream = new java.io.ByteArrayOutputStream();
                    try {
                        com.getui.gtc.base.crypt.d dVar = this.secureKeyStore;
                        byteArrayOutputStream3 = com.getui.gtc.base.crypt.CryptTools.encrypt("AES/CBC/PKCS7Padding", dVar.a(dVar.g), this.secureKeyStore.b(), byteArrayInputStream3);
                        byte[] bArr2 = new byte[256];
                        while (true) {
                            int read = byteArrayOutputStream3.read(bArr2);
                            if (read == -1) {
                                byteArrayOutputStream.flush();
                                byte[] byteArray = byteArrayOutputStream.toByteArray();
                                byte[] bytes = (CIPHER_FLAG_STARTER + this.secureKeyStore.g + "-First").getBytes();
                                int length = bytes.length;
                                byte[] bArr3 = new byte[byteArray.length + length];
                                java.lang.System.arraycopy(byteArray, 0, bArr3, 0, byteArray.length);
                                java.lang.System.arraycopy(bytes, 0, bArr3, byteArray.length, length);
                                com.getui.gtc.base.util.io.IOUtils.safeClose(byteArrayOutputStream3);
                                com.getui.gtc.base.util.io.IOUtils.safeClose(byteArrayInputStream3);
                                com.getui.gtc.base.util.io.IOUtils.safeClose(byteArrayOutputStream);
                                return bArr3;
                            }
                            byteArrayOutputStream.write(bArr2, 0, read);
                        }
                    } catch (java.lang.Throwable unused) {
                        java.io.InputStream inputStream3 = byteArrayOutputStream3;
                        byteArrayOutputStream3 = byteArrayInputStream3;
                        inputStream2 = inputStream3;
                        try {
                            byteArrayInputStream2 = new java.io.ByteArrayInputStream(bArr);
                            try {
                                byteArrayOutputStream2 = new java.io.ByteArrayOutputStream();
                            } catch (java.lang.Throwable th) {
                                th = th;
                            }
                        } catch (java.lang.Throwable th2) {
                            th = th2;
                        }
                        try {
                            inputStream2 = com.getui.gtc.base.crypt.CryptTools.encrypt("AES/CBC/PKCS7Padding", this.secureKeyStore.a(), this.secureKeyStore.b(), byteArrayInputStream2);
                            byte[] bArr4 = new byte[256];
                            while (true) {
                                int read2 = inputStream2.read(bArr4);
                                if (read2 == -1) {
                                    byteArrayOutputStream2.flush();
                                    byte[] byteArray2 = byteArrayOutputStream2.toByteArray();
                                    byte[] bytes2 = (CIPHER_FLAG_STARTER + this.secureKeyStore.g + "-Second").getBytes();
                                    int length2 = bytes2.length;
                                    byte[] bArr5 = new byte[byteArray2.length + length2];
                                    java.lang.System.arraycopy(byteArray2, 0, bArr5, 0, byteArray2.length);
                                    java.lang.System.arraycopy(bytes2, 0, bArr5, byteArray2.length, length2);
                                    com.getui.gtc.base.util.io.IOUtils.safeClose(inputStream2);
                                    com.getui.gtc.base.util.io.IOUtils.safeClose(byteArrayInputStream2);
                                    com.getui.gtc.base.util.io.IOUtils.safeClose(byteArrayOutputStream2);
                                    return bArr5;
                                }
                                byteArrayOutputStream2.write(bArr4, 0, read2);
                            }
                        } catch (java.lang.Throwable th3) {
                            th = th3;
                            byteArrayOutputStream = byteArrayOutputStream2;
                            byteArrayOutputStream3 = byteArrayInputStream2;
                            try {
                                throw new com.getui.gtc.base.crypt.CryptException("encrypt failed", th);
                            } catch (java.lang.Throwable th4) {
                                com.getui.gtc.base.util.io.IOUtils.safeClose(inputStream2);
                                throw th4;
                            }
                        }
                    }
                } catch (java.lang.Throwable unused2) {
                    byteArrayOutputStream = null;
                    byteArrayOutputStream3 = byteArrayInputStream3;
                    inputStream2 = null;
                }
            } catch (java.lang.Throwable unused3) {
                inputStream2 = null;
                byteArrayOutputStream = null;
            }
        } else {
            try {
                byteArrayInputStream = new java.io.ByteArrayInputStream(bArr);
            } catch (java.lang.Throwable th5) {
                th = th5;
                inputStream = null;
            }
            try {
                java.io.ByteArrayOutputStream byteArrayOutputStream4 = new java.io.ByteArrayOutputStream();
                byteArrayOutputStream3 = com.getui.gtc.base.crypt.CryptTools.encrypt("AES/CBC/PKCS7Padding", this.secureKeyStore.a(), this.secureKeyStore.b(), byteArrayInputStream);
                byte[] bArr6 = new byte[256];
                while (true) {
                    int read3 = byteArrayOutputStream3.read(bArr6);
                    if (read3 == -1) {
                        byteArrayOutputStream4.flush();
                        byte[] byteArray3 = byteArrayOutputStream4.toByteArray();
                        byte[] bytes3 = (CIPHER_FLAG_STARTER + this.secureKeyStore.g + "-Second").getBytes();
                        int length3 = bytes3.length;
                        byte[] bArr7 = new byte[byteArray3.length + length3];
                        java.lang.System.arraycopy(byteArray3, 0, bArr7, 0, byteArray3.length);
                        java.lang.System.arraycopy(bytes3, 0, bArr7, byteArray3.length, length3);
                        com.getui.gtc.base.util.io.IOUtils.safeClose(byteArrayOutputStream3);
                        com.getui.gtc.base.util.io.IOUtils.safeClose(byteArrayInputStream);
                        return bArr7;
                    }
                    byteArrayOutputStream4.write(bArr6, 0, read3);
                }
            } catch (java.lang.Throwable th6) {
                th = th6;
                java.io.InputStream inputStream4 = byteArrayOutputStream3;
                byteArrayOutputStream3 = byteArrayInputStream;
                inputStream = inputStream4;
                try {
                    throw new com.getui.gtc.base.crypt.CryptException("encrypt failed", th);
                } finally {
                    com.getui.gtc.base.util.io.IOUtils.safeClose(inputStream);
                    com.getui.gtc.base.util.io.IOUtils.safeClose(byteArrayOutputStream3);
                }
            }
        }
    }

    private java.lang.String getCipherFlag(byte[] bArr) {
        java.lang.String str = new java.lang.String(bArr);
        int lastIndexOf = str.lastIndexOf(CIPHER_FLAG_STARTER);
        if (lastIndexOf < 0) {
            return null;
        }
        return str.substring(lastIndexOf + 3);
    }

    public static com.getui.gtc.base.crypt.SecureCryptTools getInstance() {
        return com.getui.gtc.base.crypt.SecureCryptTools.a.a;
    }

    private java.util.List<com.getui.gtc.base.crypt.CryptException> init(android.content.Context context) throws com.getui.gtc.base.crypt.CryptException {
        java.util.List<com.getui.gtc.base.crypt.CryptException> a2;
        try {
            this.lock.lock();
            if (this.initInvoked) {
                a2 = java.util.Collections.emptyList();
            } else {
                this.initInvoked = true;
                com.getui.gtc.base.crypt.d dVar = new com.getui.gtc.base.crypt.d();
                this.secureKeyStore = dVar;
                a2 = dVar.a(context);
            }
            return a2;
        } finally {
            this.lock.unlock();
        }
    }

    public byte[] decrypt(byte[] bArr) throws com.getui.gtc.base.crypt.CryptException {
        if (!this.initInvoked) {
            throw new com.getui.gtc.base.crypt.CryptException("SecureCryptTools: please init firstly!");
        }
        try {
            try {
                this.lock.tryLock(3000L, java.util.concurrent.TimeUnit.MILLISECONDS);
                return doDecrypt(bArr);
            } catch (java.lang.InterruptedException unused) {
                throw new com.getui.gtc.base.crypt.CryptException("SecureCryptTools: wait init time out!");
            }
        } finally {
            if (this.lock.isLocked()) {
                this.lock.unlock();
            }
        }
    }

    public byte[] encrypt(byte[] bArr) throws com.getui.gtc.base.crypt.CryptException {
        if (!this.initInvoked) {
            throw new com.getui.gtc.base.crypt.CryptException("SecureCryptTools: please init firstly!");
        }
        try {
            try {
                this.lock.tryLock(3000L, java.util.concurrent.TimeUnit.MILLISECONDS);
                return doEncrypt(bArr);
            } catch (java.lang.InterruptedException unused) {
                throw new com.getui.gtc.base.crypt.CryptException("SecureCryptTools: wait init time out!");
            }
        } finally {
            if (this.lock.isLocked()) {
                this.lock.unlock();
            }
        }
    }
}
