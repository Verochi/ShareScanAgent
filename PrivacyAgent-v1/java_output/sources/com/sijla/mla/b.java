package com.sijla.mla;

/* loaded from: classes19.dex */
public final class b {
    public com.sijla.mla.a.n a;
    public int b;
    public int c;

    public static class a {
        int a;
        int b;
        java.lang.String c;

        private a() {
            this.a = -1;
            this.b = -1;
            this.c = "";
        }

        public /* synthetic */ a(byte b) {
            this();
        }

        public final java.lang.String toString() {
            return "";
        }
    }

    public b(com.sijla.mla.a.n nVar, int i, int i2) {
        this.a = nVar;
        this.b = i;
        this.c = i2;
    }

    private static int a(java.io.InputStream inputStream, int i, boolean z) {
        int i2 = z ? (i - 1) << 3 : 0;
        int i3 = z ? -8 : 8;
        int i4 = i2;
        int i5 = 0;
        for (int i6 = 0; i6 < i; i6++) {
            i5 |= inputStream.read() << i4;
            i4 += i3;
        }
        return i5;
    }

    public static com.sijla.mla.a.o a(java.lang.String str, int i) {
        com.sijla.mla.a.o Y = com.sijla.mla.a.r.Y();
        com.sijla.mla.b.a aVar = new com.sijla.mla.b.a((byte) 0);
        if (i == 0) {
            aVar = c(str);
        } else {
            if (i != 1) {
                if (i == 2) {
                    aVar = b(str);
                }
                Y.a(com.baidu.mobads.sdk.api.IAdInterListener.AdReqParam.WIDTH, aVar.a);
                Y.a("h", aVar.b);
                Y.b("type", aVar.c);
                return Y;
            }
            aVar = a(str);
        }
        Y.a(com.baidu.mobads.sdk.api.IAdInterListener.AdReqParam.WIDTH, aVar.a);
        Y.a("h", aVar.b);
        Y.b("type", aVar.c);
        return Y;
    }

    private static com.sijla.mla.b.a a(java.lang.String str) {
        com.sijla.mla.b.a aVar = new com.sijla.mla.b.a((byte) 0);
        try {
            android.graphics.BitmapFactory.Options options = new android.graphics.BitmapFactory.Options();
            options.inJustDecodeBounds = true;
            android.graphics.Bitmap decodeFile = android.graphics.BitmapFactory.decodeFile(str, options);
            if (decodeFile != null) {
                decodeFile.recycle();
            }
            int i = options.outWidth;
            int i2 = options.outHeight;
            java.lang.String str2 = options.outMimeType;
            aVar.a = i;
            aVar.b = i2;
            aVar.c = str2;
        } catch (java.lang.Throwable th) {
            th.printStackTrace();
        }
        return aVar;
    }

    private static com.sijla.mla.b.a b(java.lang.String str) {
        com.sijla.mla.b.a aVar = new com.sijla.mla.b.a((byte) 0);
        try {
            int[] psize = com.sijla.mla.L2.psize(str);
            if (psize != null) {
                aVar.a = psize[0];
                aVar.b = psize[1];
            }
        } catch (java.lang.Throwable th) {
            th.printStackTrace();
        }
        return aVar;
    }

    /* JADX WARN: Removed duplicated region for block: B:77:0x0166  */
    /* JADX WARN: Removed duplicated region for block: B:87:0x0168  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static com.sijla.mla.b.a c(java.lang.String str) {
        java.io.FileInputStream fileInputStream;
        int i;
        int i2;
        int a2;
        com.sijla.mla.b.a aVar = new com.sijla.mla.b.a((byte) 0);
        java.io.File file = new java.io.File(str);
        if (file.exists() && file.isFile() && file.canRead()) {
            java.io.FileInputStream fileInputStream2 = null;
            try {
                try {
                    fileInputStream = new java.io.FileInputStream(file);
                } catch (java.io.IOException e) {
                    e.printStackTrace();
                }
                try {
                    int read = fileInputStream.read();
                    int read2 = fileInputStream.read();
                    int read3 = fileInputStream.read();
                    java.lang.String str2 = "";
                    if (read == 71 && read2 == 73 && read3 == 70) {
                        fileInputStream.skip(3L);
                        i2 = a(fileInputStream, 2, false);
                        i = a(fileInputStream, 2, false);
                        str2 = "image/gif";
                    } else {
                        if (read == 255 && read2 == 216) {
                            while (read3 == 255) {
                                int read4 = fileInputStream.read();
                                int a3 = a(fileInputStream, 2, true);
                                if (read4 != 192 && read4 != 193 && read4 != 194) {
                                    fileInputStream.skip(a3 - 2);
                                    read3 = fileInputStream.read();
                                }
                                fileInputStream.skip(1L);
                                i = a(fileInputStream, 2, true);
                                i2 = a(fileInputStream, 2, true);
                                str2 = "image/jpeg";
                                break;
                            }
                            i = -1;
                            i2 = -1;
                        } else if (read == 137 && read2 == 80 && read3 == 78) {
                            fileInputStream.skip(15L);
                            i2 = a(fileInputStream, 2, true);
                            fileInputStream.skip(2L);
                            i = a(fileInputStream, 2, true);
                            str2 = "image/png";
                        } else if (read == 66 && read2 == 77) {
                            fileInputStream.skip(15L);
                            i2 = a(fileInputStream, 2, false);
                            fileInputStream.skip(2L);
                            i = a(fileInputStream, 2, false);
                            str2 = "image/bmp";
                        } else if (read == 82 && read2 == 73 && read3 == 70) {
                            str2 = "image/webp";
                            byte[] bArr = new byte[30];
                            fileInputStream.read(bArr, 0, 30);
                            if (bArr[12] == 88) {
                                int i3 = (bArr[26] & 255) << 8;
                                byte b = bArr[24];
                                int i4 = i3 | ((b & 255) + 1);
                                int i5 = ((b & 255) + 1) | ((bArr[25] & 255) << 8);
                                i2 = i4;
                                i = i5;
                            } else {
                                i2 = (bArr[23] & 255) | ((bArr[24] & 255) << 8);
                                i = ((bArr[26] & 255) << 8) | (bArr[25] & 255);
                            }
                        } else {
                            int read5 = fileInputStream.read();
                            if ((read == 77 && read2 == 77 && read3 == 0 && read5 == 42) || (read == 73 && read2 == 73 && read3 == 42 && read5 == 0)) {
                                boolean z = read == 77;
                                fileInputStream.skip(a(fileInputStream, 4, z) - 8);
                                int a4 = a(fileInputStream, 2, z);
                                int i6 = -1;
                                int i7 = -1;
                                int i8 = 1;
                                while (true) {
                                    if (i8 > a4) {
                                        break;
                                    }
                                    int a5 = a(fileInputStream, 2, z);
                                    int a6 = a(fileInputStream, 2, z);
                                    if (a6 != 3 && a6 != 8) {
                                        a2 = a(fileInputStream, 4, z);
                                        if (a5 != 256) {
                                            i7 = a2;
                                        } else if (a5 == 257) {
                                            i6 = a2;
                                        }
                                        if (i7 == -1 && i6 != -1) {
                                            str2 = "image/tiff";
                                            break;
                                        }
                                        i8++;
                                    }
                                    a2 = a(fileInputStream, 2, z);
                                    fileInputStream.skip(2L);
                                    if (a5 != 256) {
                                    }
                                    if (i7 == -1) {
                                    }
                                    i8++;
                                }
                                i = i6;
                                i2 = i7;
                            }
                            i = -1;
                            i2 = -1;
                        }
                        e.printStackTrace();
                    }
                    aVar.a = i2;
                    aVar.b = i;
                    aVar.c = str2;
                    fileInputStream.close();
                } catch (java.lang.Throwable th) {
                    th = th;
                    fileInputStream2 = fileInputStream;
                    try {
                        th.printStackTrace();
                        if (fileInputStream2 != null) {
                            fileInputStream2.close();
                        }
                        return aVar;
                    } finally {
                    }
                }
            } catch (java.lang.Throwable th2) {
                th = th2;
            }
        }
        return aVar;
    }
}
