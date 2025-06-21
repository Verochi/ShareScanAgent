package com.xiaomi.push.service;

/* loaded from: classes19.dex */
public final class z {
    private static long a;

    public static class a {
        byte[] a;
        int b;

        public a(byte[] bArr, int i) {
            this.a = bArr;
            this.b = i;
        }
    }

    public static class b {
        public android.graphics.Bitmap a = null;
        public long b = 0;
    }

    private static int a(android.content.Context context, java.io.InputStream inputStream) {
        int i;
        android.graphics.BitmapFactory.Options options = new android.graphics.BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        android.graphics.BitmapFactory.decodeStream(inputStream, null, options);
        if (options.outWidth == -1 || options.outHeight == -1) {
            com.xiaomi.channel.commonutils.logger.b.a("decode dimension failed for bitmap.");
            return 1;
        }
        int round = java.lang.Math.round((context.getResources().getDisplayMetrics().densityDpi / 160.0f) * 48.0f);
        int i2 = options.outWidth;
        if (i2 <= round || (i = options.outHeight) <= round) {
            return 1;
        }
        return java.lang.Math.min(i2 / round, i / round);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v0 */
    /* JADX WARN: Type inference failed for: r0v1 */
    /* JADX WARN: Type inference failed for: r0v2, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r0v3 */
    public static android.graphics.Bitmap a(android.content.Context context, java.lang.String str) {
        java.io.InputStream inputStream;
        java.io.InputStream inputStream2;
        android.net.Uri parse = android.net.Uri.parse(str);
        ?? r0 = 0;
        r0 = 0;
        try {
            try {
                inputStream = context.getContentResolver().openInputStream(parse);
            } catch (java.lang.Throwable th) {
                th = th;
                r0 = context;
            }
        } catch (java.io.IOException e) {
            e = e;
            inputStream2 = null;
            inputStream = null;
        } catch (java.lang.Throwable th2) {
            th = th2;
            inputStream = null;
        }
        try {
            int a2 = a(context, inputStream);
            inputStream2 = context.getContentResolver().openInputStream(parse);
            try {
                android.graphics.BitmapFactory.Options options = new android.graphics.BitmapFactory.Options();
                options.inSampleSize = a2;
                android.graphics.Bitmap decodeStream = android.graphics.BitmapFactory.decodeStream(inputStream2, null, options);
                com.xiaomi.push.c.a(inputStream2);
                com.xiaomi.push.c.a(inputStream);
                return decodeStream;
            } catch (java.io.IOException e2) {
                e = e2;
                com.xiaomi.channel.commonutils.logger.b.a(e);
                com.xiaomi.push.c.a(inputStream2);
                com.xiaomi.push.c.a(inputStream);
                return null;
            }
        } catch (java.io.IOException e3) {
            e = e3;
            inputStream2 = null;
        } catch (java.lang.Throwable th3) {
            th = th3;
            com.xiaomi.push.c.a((java.io.Closeable) r0);
            com.xiaomi.push.c.a(inputStream);
            throw th;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:41:0x00e6, code lost:
    
        if (r1 == null) goto L53;
     */
    /* JADX WARN: Code restructure failed: missing block: B:42:0x00e9, code lost:
    
        return null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:43:0x00d0, code lost:
    
        r1.disconnect();
     */
    /* JADX WARN: Code restructure failed: missing block: B:47:0x00ce, code lost:
    
        if (r1 == null) goto L53;
     */
    /* JADX WARN: Not initialized variable reg: 2, insn: 0x00eb: MOVE (r0 I:??[OBJECT, ARRAY]) = (r2 I:??[OBJECT, ARRAY]), block:B:58:0x00eb */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static com.xiaomi.push.service.z.a a(java.lang.String str, boolean z) {
        java.net.HttpURLConnection httpURLConnection;
        java.io.InputStream inputStream;
        java.io.Closeable closeable;
        java.io.Closeable closeable2 = null;
        try {
            try {
                httpURLConnection = (java.net.HttpURLConnection) new java.net.URL(str).openConnection();
            } catch (java.lang.Throwable th) {
                th = th;
                closeable2 = closeable;
            }
        } catch (java.net.SocketTimeoutException unused) {
            httpURLConnection = null;
            inputStream = null;
        } catch (java.io.IOException e) {
            e = e;
            httpURLConnection = null;
            inputStream = null;
        } catch (java.lang.Throwable th2) {
            th = th2;
            httpURLConnection = null;
        }
        try {
            httpURLConnection.setConnectTimeout(8000);
            httpURLConnection.setReadTimeout(20000);
            httpURLConnection.setRequestProperty("User-agent", "Mozilla/5.0 (Linux; U;) AppleWebKit/537.36 (KHTML, like Gecko) Version/4.0 Chrome/71.0.3578.141 Mobile Safari/537.36 XiaoMi/MiuiBrowser");
            httpURLConnection.connect();
            int contentLength = httpURLConnection.getContentLength();
            if (z && contentLength > 102400) {
                com.xiaomi.channel.commonutils.logger.b.a("Bitmap size is too big, max size is 102400  contentLen size is " + contentLength + " from url " + str);
                com.xiaomi.push.c.a((java.io.Closeable) null);
                httpURLConnection.disconnect();
                return null;
            }
            int responseCode = httpURLConnection.getResponseCode();
            if (responseCode != 200) {
                com.xiaomi.channel.commonutils.logger.b.a("Invalid Http Response Code " + responseCode + " received");
                com.xiaomi.push.c.a((java.io.Closeable) null);
                httpURLConnection.disconnect();
                return null;
            }
            inputStream = httpURLConnection.getInputStream();
            try {
                java.io.ByteArrayOutputStream byteArrayOutputStream = new java.io.ByteArrayOutputStream();
                int i = z ? 102400 : 2048000;
                byte[] bArr = new byte[1024];
                while (i > 0) {
                    int read = inputStream.read(bArr, 0, 1024);
                    if (read == -1) {
                        break;
                    }
                    i -= read;
                    byteArrayOutputStream.write(bArr, 0, read);
                }
                if (i <= 0) {
                    com.xiaomi.channel.commonutils.logger.b.a("length 102400 exhausted.");
                    com.xiaomi.push.service.z.a aVar = new com.xiaomi.push.service.z.a(null, 102400);
                    com.xiaomi.push.c.a(inputStream);
                    httpURLConnection.disconnect();
                    return aVar;
                }
                byte[] byteArray = byteArrayOutputStream.toByteArray();
                com.xiaomi.push.service.z.a aVar2 = new com.xiaomi.push.service.z.a(byteArray, byteArray.length);
                com.xiaomi.push.c.a(inputStream);
                httpURLConnection.disconnect();
                return aVar2;
            } catch (java.net.SocketTimeoutException unused2) {
                com.xiaomi.channel.commonutils.logger.b.d("Connect timeout to ".concat(java.lang.String.valueOf(str)));
                com.xiaomi.push.c.a(inputStream);
            } catch (java.io.IOException e2) {
                e = e2;
                com.xiaomi.channel.commonutils.logger.b.a(e);
                com.xiaomi.push.c.a(inputStream);
            }
        } catch (java.net.SocketTimeoutException unused3) {
            inputStream = null;
        } catch (java.io.IOException e3) {
            e = e3;
            inputStream = null;
        } catch (java.lang.Throwable th3) {
            th = th3;
            com.xiaomi.push.c.a(closeable2);
            if (httpURLConnection != null) {
                httpURLConnection.disconnect();
            }
            throw th;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:22:0x004b A[Catch: all -> 0x0106, Exception -> 0x0109, TryCatch #8 {Exception -> 0x0109, all -> 0x0106, blocks: (B:19:0x002c, B:20:0x0047, B:22:0x004b, B:25:0x0052, B:27:0x007c, B:28:0x007f, B:39:0x00a1, B:40:0x00c5, B:42:0x00cd, B:52:0x00ff, B:53:0x0105, B:48:0x00bf), top: B:18:0x002c }] */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0052 A[Catch: all -> 0x0106, Exception -> 0x0109, TryCatch #8 {Exception -> 0x0109, all -> 0x0106, blocks: (B:19:0x002c, B:20:0x0047, B:22:0x004b, B:25:0x0052, B:27:0x007c, B:28:0x007f, B:39:0x00a1, B:40:0x00c5, B:42:0x00cd, B:52:0x00ff, B:53:0x0105, B:48:0x00bf), top: B:18:0x002c }] */
    /* JADX WARN: Removed duplicated region for block: B:42:0x00cd A[Catch: all -> 0x0106, Exception -> 0x0109, TRY_LEAVE, TryCatch #8 {Exception -> 0x0109, all -> 0x0106, blocks: (B:19:0x002c, B:20:0x0047, B:22:0x004b, B:25:0x0052, B:27:0x007c, B:28:0x007f, B:39:0x00a1, B:40:0x00c5, B:42:0x00cd, B:52:0x00ff, B:53:0x0105, B:48:0x00bf), top: B:18:0x002c }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static com.xiaomi.push.service.z.b a(android.content.Context context, java.lang.String str, boolean z) {
        com.xiaomi.push.service.z.a a2;
        java.io.ByteArrayInputStream byteArrayInputStream;
        byte[] bArr;
        java.io.FileOutputStream fileOutputStream;
        java.io.FileOutputStream fileOutputStream2;
        java.io.BufferedOutputStream bufferedOutputStream;
        com.xiaomi.push.service.z.b bVar = new com.xiaomi.push.service.z.b();
        android.graphics.Bitmap b2 = b(context, str);
        if (b2 != null) {
            bVar.a = b2;
            return bVar;
        }
        java.io.ByteArrayInputStream byteArrayInputStream2 = null;
        try {
            try {
                a2 = a(str, z);
            } catch (java.lang.Exception e) {
                e = e;
            }
            if (a2 == null) {
                com.xiaomi.push.c.a((java.io.Closeable) null);
                return bVar;
            }
            bVar.b = a2.b;
            byte[] bArr2 = a2.a;
            if (bArr2 != null) {
                if (z) {
                    byteArrayInputStream = new java.io.ByteArrayInputStream(bArr2);
                    try {
                        int a3 = a(context, byteArrayInputStream);
                        android.graphics.BitmapFactory.Options options = new android.graphics.BitmapFactory.Options();
                        options.inSampleSize = a3;
                        bVar.a = android.graphics.BitmapFactory.decodeByteArray(bArr2, 0, bArr2.length, options);
                        bArr = a2.a;
                        if (bArr != null) {
                            com.xiaomi.channel.commonutils.logger.b.a("cannot save small icon cause bitmap is null");
                        } else {
                            a(context);
                            java.io.File file = new java.io.File(context.getCacheDir().getPath() + java.io.File.separator + "mipush_icon");
                            if (!file.exists()) {
                                file.mkdirs();
                            }
                            java.io.File file2 = new java.io.File(file, com.xiaomi.push.ao.a(str));
                            try {
                                if (!file2.exists()) {
                                    file2.createNewFile();
                                }
                                fileOutputStream = new java.io.FileOutputStream(file2);
                                try {
                                    bufferedOutputStream = new java.io.BufferedOutputStream(fileOutputStream);
                                } catch (java.lang.Exception e2) {
                                    fileOutputStream2 = fileOutputStream;
                                    e = e2;
                                } catch (java.lang.Throwable th) {
                                    th = th;
                                }
                                try {
                                    bufferedOutputStream.write(bArr);
                                    bufferedOutputStream.flush();
                                    com.xiaomi.push.c.a(bufferedOutputStream);
                                    com.xiaomi.push.c.a(fileOutputStream);
                                } catch (java.lang.Exception e3) {
                                    fileOutputStream2 = fileOutputStream;
                                    e = e3;
                                    byteArrayInputStream2 = bufferedOutputStream;
                                    try {
                                        com.xiaomi.channel.commonutils.logger.b.a(e);
                                        com.xiaomi.push.c.a(byteArrayInputStream2);
                                        com.xiaomi.push.c.a(fileOutputStream2);
                                        if (a == 0) {
                                        }
                                        com.xiaomi.push.c.a(byteArrayInputStream);
                                        return bVar;
                                    } catch (java.lang.Throwable th2) {
                                        th = th2;
                                        fileOutputStream = fileOutputStream2;
                                        com.xiaomi.push.c.a(byteArrayInputStream2);
                                        com.xiaomi.push.c.a(fileOutputStream);
                                        throw th;
                                    }
                                } catch (java.lang.Throwable th3) {
                                    th = th3;
                                    byteArrayInputStream2 = bufferedOutputStream;
                                    com.xiaomi.push.c.a(byteArrayInputStream2);
                                    com.xiaomi.push.c.a(fileOutputStream);
                                    throw th;
                                }
                            } catch (java.lang.Exception e4) {
                                e = e4;
                                fileOutputStream2 = null;
                            } catch (java.lang.Throwable th4) {
                                th = th4;
                                fileOutputStream = null;
                            }
                            if (a == 0) {
                                a = com.xiaomi.push.b.a(new java.io.File(context.getCacheDir().getPath() + java.io.File.separator + "mipush_icon")) + file2.length();
                            }
                        }
                        com.xiaomi.push.c.a(byteArrayInputStream);
                    } catch (java.lang.Exception e5) {
                        e = e5;
                        byteArrayInputStream2 = byteArrayInputStream;
                        com.xiaomi.channel.commonutils.logger.b.a(e);
                        com.xiaomi.push.c.a(byteArrayInputStream2);
                        return bVar;
                    } catch (java.lang.Throwable th5) {
                        th = th5;
                        byteArrayInputStream2 = byteArrayInputStream;
                        com.xiaomi.push.c.a(byteArrayInputStream2);
                        throw th;
                    }
                    return bVar;
                }
                bVar.a = android.graphics.BitmapFactory.decodeByteArray(bArr2, 0, bArr2.length);
            }
            byteArrayInputStream = null;
            bArr = a2.a;
            if (bArr != null) {
            }
            com.xiaomi.push.c.a(byteArrayInputStream);
            return bVar;
        } catch (java.lang.Throwable th6) {
            th = th6;
        }
    }

    private static void a(android.content.Context context) {
        java.io.File file = new java.io.File(context.getCacheDir().getPath() + java.io.File.separator + "mipush_icon");
        if (file.exists()) {
            if (a == 0) {
                a = com.xiaomi.push.b.a(file);
            }
            if (a > 15728640) {
                try {
                    java.io.File[] listFiles = file.listFiles();
                    for (int i = 0; i < listFiles.length; i++) {
                        if (!listFiles[i].isDirectory() && java.lang.Math.abs(java.lang.System.currentTimeMillis() - listFiles[i].lastModified()) > 1209600) {
                            listFiles[i].delete();
                        }
                    }
                } catch (java.lang.Exception e) {
                    com.xiaomi.channel.commonutils.logger.b.a(e);
                }
                a = 0L;
            }
        }
    }

    private static android.graphics.Bitmap b(android.content.Context context, java.lang.String str) {
        java.lang.Throwable th;
        java.io.FileInputStream fileInputStream;
        android.graphics.Bitmap bitmap;
        java.io.File file = new java.io.File(context.getCacheDir().getPath() + java.io.File.separator + "mipush_icon", com.xiaomi.push.ao.a(str));
        java.io.FileInputStream fileInputStream2 = null;
        android.graphics.Bitmap bitmap2 = null;
        fileInputStream2 = null;
        if (!file.exists()) {
            return null;
        }
        try {
            try {
                fileInputStream = new java.io.FileInputStream(file);
            } catch (java.lang.Exception e) {
                e = e;
                bitmap = null;
            }
        } catch (java.lang.Throwable th2) {
            java.io.FileInputStream fileInputStream3 = fileInputStream2;
            th = th2;
            fileInputStream = fileInputStream3;
        }
        try {
            bitmap2 = android.graphics.BitmapFactory.decodeStream(fileInputStream);
            file.setLastModified(java.lang.System.currentTimeMillis());
            com.xiaomi.push.c.a(fileInputStream);
            return bitmap2;
        } catch (java.lang.Exception e2) {
            e = e2;
            android.graphics.Bitmap bitmap3 = bitmap2;
            fileInputStream2 = fileInputStream;
            bitmap = bitmap3;
            com.xiaomi.channel.commonutils.logger.b.a(e);
            com.xiaomi.push.c.a(fileInputStream2);
            return bitmap;
        } catch (java.lang.Throwable th3) {
            th = th3;
            com.xiaomi.push.c.a(fileInputStream);
            throw th;
        }
    }
}
