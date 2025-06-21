package com.sina.weibo.sdk.share;

/* loaded from: classes19.dex */
public final class a {
    /* JADX WARN: Removed duplicated region for block: B:15:0x00c2 A[Catch: all -> 0x0158, Exception -> 0x015b, TryCatch #10 {Exception -> 0x015b, all -> 0x0158, blocks: (B:3:0x0005, B:6:0x0013, B:12:0x0094, B:13:0x00bc, B:15:0x00c2, B:18:0x00d9, B:20:0x00e0, B:77:0x00b8, B:82:0x0154, B:83:0x0157), top: B:2:0x0005 }] */
    /* JADX WARN: Removed duplicated region for block: B:24:0x011d A[Catch: all -> 0x0149, Exception -> 0x014d, TryCatch #13 {Exception -> 0x014d, all -> 0x0149, blocks: (B:22:0x00f8, B:24:0x011d, B:25:0x0120), top: B:21:0x00f8 }] */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0130 A[Catch: all -> 0x0145, Exception -> 0x0147, LOOP:0: B:29:0x0129->B:31:0x0130, LOOP_END, TryCatch #12 {Exception -> 0x0147, all -> 0x0145, blocks: (B:28:0x0127, B:29:0x0129, B:31:0x0130, B:33:0x0135), top: B:27:0x0127 }] */
    /* JADX WARN: Removed duplicated region for block: B:32:0x0135 A[EDGE_INSN: B:32:0x0135->B:33:0x0135 BREAK  A[LOOP:0: B:29:0x0129->B:31:0x0130], SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:51:0x0183 A[Catch: Exception -> 0x017f, TRY_LEAVE, TryCatch #6 {Exception -> 0x017f, blocks: (B:58:0x017b, B:51:0x0183), top: B:57:0x017b }] */
    /* JADX WARN: Removed duplicated region for block: B:57:0x017b A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:82:0x0154 A[Catch: all -> 0x0158, Exception -> 0x015b, TRY_ENTER, TryCatch #10 {Exception -> 0x015b, all -> 0x0158, blocks: (B:3:0x0005, B:6:0x0013, B:12:0x0094, B:13:0x00bc, B:15:0x00c2, B:18:0x00d9, B:20:0x00e0, B:77:0x00b8, B:82:0x0154, B:83:0x0157), top: B:2:0x0005 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static java.lang.String a(android.content.Context context, android.net.Uri uri, int i) {
        java.io.FileOutputStream fileOutputStream;
        android.database.Cursor cursor;
        java.lang.String str;
        java.io.BufferedInputStream bufferedInputStream;
        java.io.File file;
        byte[] bArr;
        int read;
        java.io.BufferedInputStream bufferedInputStream2 = null;
        try {
            java.lang.String str2 = com.sina.weibo.sdk.c.a.c(context).packageName;
            if (android.text.TextUtils.isEmpty(str2)) {
                str2 = "com.sina.weibo";
            }
            java.lang.String str3 = "/Android/data/" + str2 + "/files/.composerTem/";
            new java.io.File(android.os.Environment.getExternalStorageDirectory().getAbsolutePath() + str3).mkdirs();
            java.util.Calendar calendar = java.util.Calendar.getInstance();
            try {
                if ("file".equals(uri.getScheme())) {
                    str = calendar.getTimeInMillis() + uri.getLastPathSegment();
                    cursor = null;
                } else {
                    cursor = context.getContentResolver().query(uri, new java.lang.String[]{"_display_name"}, null, null, null);
                    if (cursor != null) {
                        try {
                            try {
                                if (cursor.moveToFirst()) {
                                    str = cursor.getString(cursor.getColumnIndex("_display_name"));
                                }
                            } catch (java.lang.Exception e) {
                                e = e;
                                com.sina.weibo.sdk.c.c.b("WBShareTag", "share util and exception is " + e.getMessage());
                                e.printStackTrace();
                                if (cursor != null) {
                                    cursor.close();
                                }
                                str = null;
                                if (android.text.TextUtils.isEmpty(str)) {
                                }
                                bufferedInputStream = new java.io.BufferedInputStream(new java.io.FileInputStream(context.getContentResolver().openFileDescriptor(uri, "r").getFileDescriptor()));
                                file = new java.io.File(android.os.Environment.getExternalStorageDirectory().getAbsolutePath() + str3 + str);
                                if (file.exists()) {
                                }
                                fileOutputStream = new java.io.FileOutputStream(file);
                                bArr = new byte[1444];
                                while (true) {
                                    read = bufferedInputStream.read(bArr);
                                    if (read != -1) {
                                    }
                                    fileOutputStream.write(bArr, 0, read);
                                }
                                java.lang.String path = file.getPath();
                                try {
                                    bufferedInputStream.close();
                                    fileOutputStream.close();
                                } catch (java.lang.Exception e2) {
                                    e2.printStackTrace();
                                }
                                return path;
                            }
                        } catch (java.lang.Throwable th) {
                            th = th;
                            if (cursor != null) {
                                cursor.close();
                            }
                            throw th;
                        }
                    }
                    str = null;
                }
                if (cursor != null) {
                    cursor.close();
                }
            } catch (java.lang.Exception e3) {
                e = e3;
                cursor = null;
            } catch (java.lang.Throwable th2) {
                th = th2;
                cursor = null;
                if (cursor != null) {
                }
                throw th;
            }
            if (android.text.TextUtils.isEmpty(str)) {
                java.lang.StringBuilder sb = new java.lang.StringBuilder();
                sb.append(java.util.Calendar.getInstance().getTimeInMillis());
                sb.append(i == 0 ? "_sdk_temp.mp4" : "_sdk_temp.jpg");
                str = sb.toString();
            }
            bufferedInputStream = new java.io.BufferedInputStream(new java.io.FileInputStream(context.getContentResolver().openFileDescriptor(uri, "r").getFileDescriptor()));
            try {
                file = new java.io.File(android.os.Environment.getExternalStorageDirectory().getAbsolutePath() + str3 + str);
                if (file.exists()) {
                    file.delete();
                }
                fileOutputStream = new java.io.FileOutputStream(file);
            } catch (java.lang.Exception e4) {
                e = e4;
                fileOutputStream = null;
            } catch (java.lang.Throwable th3) {
                th = th3;
                fileOutputStream = null;
            }
            try {
                bArr = new byte[1444];
                while (true) {
                    read = bufferedInputStream.read(bArr);
                    if (read != -1) {
                        break;
                    }
                    fileOutputStream.write(bArr, 0, read);
                }
                java.lang.String path2 = file.getPath();
                bufferedInputStream.close();
                fileOutputStream.close();
                return path2;
            } catch (java.lang.Exception e5) {
                e = e5;
                bufferedInputStream2 = bufferedInputStream;
                try {
                    com.sina.weibo.sdk.c.c.b("WBShareTag", "share util and error is " + e.getMessage());
                    throw new java.lang.Throwable(e);
                } catch (java.lang.Throwable th4) {
                    th = th4;
                    if (bufferedInputStream2 != null) {
                        try {
                            bufferedInputStream2.close();
                        } catch (java.lang.Exception e6) {
                            e6.printStackTrace();
                            throw th;
                        }
                    }
                    if (fileOutputStream != null) {
                        fileOutputStream.close();
                    }
                    throw th;
                }
            } catch (java.lang.Throwable th5) {
                th = th5;
                bufferedInputStream2 = bufferedInputStream;
                if (bufferedInputStream2 != null) {
                }
                if (fileOutputStream != null) {
                }
                throw th;
            }
        } catch (java.lang.Exception e7) {
            e = e7;
            fileOutputStream = null;
        } catch (java.lang.Throwable th6) {
            th = th6;
            fileOutputStream = null;
        }
    }
}
