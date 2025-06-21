package com.igexin.push.h;

/* loaded from: classes23.dex */
public final class i {
    java.lang.String a;
    java.lang.String b;
    java.io.File c;
    private byte[] d;

    private i(java.io.File file) {
        this.c = file;
    }

    private i(java.lang.String str) {
        this(new java.io.File(str));
    }

    private i(java.lang.String str, byte[] bArr) {
        this.a = str;
        this.d = bArr;
    }

    private i(java.lang.String str, byte[] bArr, java.lang.String str2) {
        this(str, bArr);
        this.b = str2;
    }

    private i(byte[] bArr) {
        this.d = bArr;
    }

    private static java.lang.String a(byte[] bArr) {
        java.lang.Object obj = null;
        if (bArr != null && bArr.length >= 10) {
            byte b = bArr[0];
            if (b == 71 && bArr[1] == 73 && bArr[2] == 70) {
                obj = "GIF";
            } else {
                byte b2 = bArr[1];
                if (b2 == 80 && bArr[2] == 78 && bArr[3] == 71) {
                    obj = "PNG";
                } else if (bArr[6] == 74 && bArr[7] == 70 && bArr[8] == 73 && bArr[9] == 70) {
                    obj = "JPG";
                } else if (b == 66 && b2 == 77) {
                    obj = "BMP";
                }
            }
        }
        return "JPG".equals(obj) ? "image/jpeg" : "GIF".equals(obj) ? "image/gif" : "PNG".equals(obj) ? "image/png" : "BMP".equals(obj) ? "image/bmp" : com.alibaba.sdk.android.oss.common.OSSConstants.DEFAULT_OBJECT_CONTENT_TYPE;
    }

    private java.lang.String b() {
        java.io.File file;
        if (this.a == null && (file = this.c) != null && file.exists()) {
            this.a = this.c.getName();
        }
        return this.a;
    }

    private static java.lang.String b(byte[] bArr) {
        if (bArr != null && bArr.length >= 10) {
            byte b = bArr[0];
            if (b == 71 && bArr[1] == 73 && bArr[2] == 70) {
                return "GIF";
            }
            byte b2 = bArr[1];
            if (b2 == 80 && bArr[2] == 78 && bArr[3] == 71) {
                return "PNG";
            }
            if (bArr[6] == 74 && bArr[7] == 70 && bArr[8] == 73 && bArr[9] == 70) {
                return "JPG";
            }
            if (b == 66 && b2 == 77) {
                return "BMP";
            }
        }
        return null;
    }

    private java.lang.String c() throws java.io.IOException {
        if (this.b == null) {
            byte[] a = a();
            java.lang.Object obj = null;
            if (a != null && a.length >= 10) {
                byte b = a[0];
                if (b == 71 && a[1] == 73 && a[2] == 70) {
                    obj = "GIF";
                } else {
                    byte b2 = a[1];
                    if (b2 == 80 && a[2] == 78 && a[3] == 71) {
                        obj = "PNG";
                    } else if (a[6] == 74 && a[7] == 70 && a[8] == 73 && a[9] == 70) {
                        obj = "JPG";
                    } else if (b == 66 && b2 == 77) {
                        obj = "BMP";
                    }
                }
            }
            this.b = "JPG".equals(obj) ? "image/jpeg" : "GIF".equals(obj) ? "image/gif" : "PNG".equals(obj) ? "image/png" : "BMP".equals(obj) ? "image/bmp" : com.alibaba.sdk.android.oss.common.OSSConstants.DEFAULT_OBJECT_CONTENT_TYPE;
        }
        return this.b;
    }

    public final byte[] a() throws java.io.IOException {
        java.io.File file;
        java.io.ByteArrayOutputStream byteArrayOutputStream;
        java.lang.Throwable th;
        java.io.FileInputStream fileInputStream;
        if (this.d == null && (file = this.c) != null && file.exists()) {
            try {
                fileInputStream = new java.io.FileInputStream(this.c);
                try {
                    byteArrayOutputStream = new java.io.ByteArrayOutputStream();
                    while (true) {
                        try {
                            int read = fileInputStream.read();
                            if (read == -1) {
                                break;
                            }
                            byteArrayOutputStream.write(read);
                        } catch (java.lang.Throwable th2) {
                            th = th2;
                            if (byteArrayOutputStream != null) {
                                byteArrayOutputStream.close();
                            }
                            if (fileInputStream != null) {
                                fileInputStream.close();
                            }
                            throw th;
                        }
                    }
                    this.d = byteArrayOutputStream.toByteArray();
                    byteArrayOutputStream.close();
                    fileInputStream.close();
                } catch (java.lang.Throwable th3) {
                    byteArrayOutputStream = null;
                    th = th3;
                }
            } catch (java.lang.Throwable th4) {
                byteArrayOutputStream = null;
                th = th4;
                fileInputStream = null;
            }
        }
        return this.d;
    }
}
