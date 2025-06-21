package com.aliyun.svideo.common.utils;

/* loaded from: classes.dex */
public class UriUtils {
    private static final java.lang.String TAG = "UriUtils";

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:48:0x00de A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:53:0x00d4 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:58:0x00ca A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:74:0x00ff A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:81:? A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:82:0x00f5 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:87:0x00eb A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r5v1 */
    /* JADX WARN: Type inference failed for: r5v11 */
    /* JADX WARN: Type inference failed for: r5v4, types: [java.io.OutputStream] */
    /* JADX WARN: Type inference failed for: r5v7 */
    /* JADX WARN: Type inference failed for: r7v0, types: [android.content.Context] */
    /* JADX WARN: Type inference failed for: r7v10, types: [android.os.ParcelFileDescriptor] */
    /* JADX WARN: Type inference failed for: r7v6 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static boolean copyFileToDir(android.content.Context context, java.lang.String str, java.lang.String str2) {
        android.os.ParcelFileDescriptor parcelFileDescriptor;
        java.io.OutputStream outputStream;
        android.os.ParcelFileDescriptor parcelFileDescriptor2;
        java.io.BufferedInputStream bufferedInputStream;
        ?? r5;
        android.os.ParcelFileDescriptor parcelFileDescriptor3;
        java.io.File file;
        java.io.BufferedOutputStream bufferedOutputStream;
        long currentTimeMillis = java.lang.System.currentTimeMillis();
        java.io.BufferedInputStream bufferedInputStream2 = null;
        r3 = null;
        bufferedInputStream2 = null;
        java.io.File file2 = null;
        try {
            try {
                context = context.getContentResolver().openFileDescriptor(android.net.Uri.parse(str), "r");
            } catch (java.lang.Throwable th) {
                th = th;
            }
            try {
                bufferedInputStream = new java.io.BufferedInputStream(new android.os.ParcelFileDescriptor.AutoCloseInputStream(context));
                try {
                    try {
                        file = new java.io.File(str2);
                        try {
                            bufferedOutputStream = new java.io.BufferedOutputStream(new java.io.FileOutputStream(file));
                        } catch (java.lang.Exception e) {
                            e = e;
                            bufferedOutputStream = null;
                        }
                    } catch (java.lang.Exception e2) {
                        e = e2;
                        r5 = 0;
                        parcelFileDescriptor3 = context;
                    }
                    try {
                        byte[] bArr = new byte[2048];
                        while (true) {
                            int read = bufferedInputStream.read(bArr);
                            if (read >= 0) {
                                bufferedOutputStream.write(bArr, 0, read);
                                bufferedOutputStream.flush();
                            } else {
                                try {
                                    break;
                                } catch (java.io.IOException e3) {
                                    e3.printStackTrace();
                                }
                            }
                        }
                        bufferedInputStream.close();
                        try {
                            bufferedOutputStream.close();
                        } catch (java.io.IOException e4) {
                            e4.printStackTrace();
                        }
                        if (context != 0) {
                            try {
                                context.close();
                            } catch (java.io.IOException e5) {
                                e5.printStackTrace();
                            }
                        }
                        double length = (new java.io.File(str2).length() / 1024.0d) / 1024.0d;
                        java.lang.StringBuilder sb = new java.lang.StringBuilder();
                        sb.append("log_duration : ");
                        sb.append(java.lang.System.currentTimeMillis() - currentTimeMillis);
                        sb.append(" ,size : ");
                        sb.append(length);
                        sb.append(" M");
                        return true;
                    } catch (java.lang.Exception e6) {
                        e = e6;
                        file2 = file;
                        r5 = bufferedOutputStream;
                        parcelFileDescriptor3 = context;
                        java.lang.StringBuilder sb2 = new java.lang.StringBuilder();
                        sb2.append("copyFileToDir failure ,path = ");
                        sb2.append(str2);
                        sb2.append(" ,msg = ");
                        sb2.append(e.getMessage());
                        e.printStackTrace();
                        if (file2 != null && file2.exists()) {
                            file2.delete();
                        }
                        if (bufferedInputStream != null) {
                            try {
                                bufferedInputStream.close();
                            } catch (java.io.IOException e7) {
                                e7.printStackTrace();
                            }
                        }
                        if (r5 != 0) {
                            try {
                                r5.close();
                            } catch (java.io.IOException e8) {
                                e8.printStackTrace();
                            }
                        }
                        if (parcelFileDescriptor3 != null) {
                            try {
                                parcelFileDescriptor3.close();
                            } catch (java.io.IOException e9) {
                                e9.printStackTrace();
                            }
                        }
                        return false;
                    }
                } catch (java.lang.Throwable th2) {
                    th = th2;
                    outputStream = null;
                    bufferedInputStream2 = bufferedInputStream;
                    parcelFileDescriptor = context;
                    if (bufferedInputStream2 != null) {
                        try {
                            bufferedInputStream2.close();
                        } catch (java.io.IOException e10) {
                            e10.printStackTrace();
                        }
                    }
                    if (outputStream != null) {
                        try {
                            outputStream.close();
                        } catch (java.io.IOException e11) {
                            e11.printStackTrace();
                        }
                    }
                    if (parcelFileDescriptor != null) {
                        throw th;
                    }
                    try {
                        parcelFileDescriptor.close();
                        throw th;
                    } catch (java.io.IOException e12) {
                        e12.printStackTrace();
                        throw th;
                    }
                }
            } catch (java.lang.Exception e13) {
                e = e13;
                bufferedInputStream = null;
                parcelFileDescriptor2 = context;
                r5 = bufferedInputStream;
                parcelFileDescriptor3 = parcelFileDescriptor2;
                java.lang.StringBuilder sb22 = new java.lang.StringBuilder();
                sb22.append("copyFileToDir failure ,path = ");
                sb22.append(str2);
                sb22.append(" ,msg = ");
                sb22.append(e.getMessage());
                e.printStackTrace();
                if (file2 != null) {
                    file2.delete();
                }
                if (bufferedInputStream != null) {
                }
                if (r5 != 0) {
                }
                if (parcelFileDescriptor3 != null) {
                }
                return false;
            } catch (java.lang.Throwable th3) {
                th = th3;
                outputStream = null;
                parcelFileDescriptor = context;
                if (bufferedInputStream2 != null) {
                }
                if (outputStream != null) {
                }
                if (parcelFileDescriptor != null) {
                }
            }
        } catch (java.lang.Exception e14) {
            e = e14;
            parcelFileDescriptor2 = null;
            bufferedInputStream = null;
        } catch (java.lang.Throwable th4) {
            th = th4;
            parcelFileDescriptor = null;
            outputStream = null;
        }
    }

    @androidx.annotation.RequiresApi(api = 29)
    public static void saveImgToMediaStore(android.content.Context context, java.lang.String str) {
        long currentTimeMillis = java.lang.System.currentTimeMillis();
        android.content.ContentValues contentValues = new android.content.ContentValues();
        contentValues.put("_display_name", currentTimeMillis + "-photo.jpg");
        contentValues.put("mime_type", "image/jpeg");
        contentValues.put("is_pending", (java.lang.Integer) 1);
        android.content.ContentResolver contentResolver = context.getContentResolver();
        android.net.Uri insert = contentResolver.insert(android.provider.MediaStore.Images.Media.getContentUri("external_primary"), contentValues);
        try {
            android.os.ParcelFileDescriptor openFileDescriptor = contentResolver.openFileDescriptor(insert, com.baidu.mobads.sdk.api.IAdInterListener.AdReqParam.WIDTH, null);
            try {
                java.io.BufferedInputStream bufferedInputStream = new java.io.BufferedInputStream(new java.io.FileInputStream(str));
                java.io.BufferedOutputStream bufferedOutputStream = new java.io.BufferedOutputStream(new android.os.ParcelFileDescriptor.AutoCloseOutputStream(openFileDescriptor));
                byte[] bArr = new byte[2048];
                while (true) {
                    int read = bufferedInputStream.read(bArr);
                    if (read < 0) {
                        break;
                    }
                    bufferedOutputStream.write(bArr, 0, read);
                    bufferedOutputStream.flush();
                }
                bufferedInputStream.close();
                bufferedOutputStream.close();
                if (openFileDescriptor != null) {
                    openFileDescriptor.close();
                }
            } finally {
            }
        } catch (java.io.IOException e) {
            e.printStackTrace();
        }
        contentValues.clear();
        contentValues.put("is_pending", (java.lang.Integer) 0);
        contentResolver.update(insert, contentValues, null, null);
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        sb.append("duration : ");
        sb.append(java.lang.System.currentTimeMillis() - currentTimeMillis);
    }

    @androidx.annotation.RequiresApi(api = 29)
    public static void saveVideoToMediaStore(android.content.Context context, java.lang.String str) {
        java.lang.String str2;
        long currentTimeMillis = java.lang.System.currentTimeMillis();
        android.content.ContentValues contentValues = new android.content.ContentValues();
        int lastIndexOf = !android.text.TextUtils.isEmpty(str) ? str.lastIndexOf(java.io.File.separator) : -1;
        if (lastIndexOf < 0 || lastIndexOf >= str.length() - 1) {
            str2 = currentTimeMillis + "-video.mp4";
        } else {
            str2 = str.substring(lastIndexOf + 1);
        }
        contentValues.put("_display_name", str2);
        contentValues.put("mime_type", "video/mp4");
        contentValues.put("is_pending", (java.lang.Integer) 1);
        android.content.ContentResolver contentResolver = context.getContentResolver();
        android.net.Uri insert = contentResolver.insert(android.provider.MediaStore.Video.Media.getContentUri("external_primary"), contentValues);
        try {
            android.os.ParcelFileDescriptor openFileDescriptor = contentResolver.openFileDescriptor(insert, com.baidu.mobads.sdk.api.IAdInterListener.AdReqParam.WIDTH, null);
            try {
                java.io.BufferedInputStream bufferedInputStream = new java.io.BufferedInputStream(new java.io.FileInputStream(str));
                java.io.BufferedOutputStream bufferedOutputStream = new java.io.BufferedOutputStream(new android.os.ParcelFileDescriptor.AutoCloseOutputStream(openFileDescriptor));
                byte[] bArr = new byte[2048];
                while (true) {
                    int read = bufferedInputStream.read(bArr);
                    if (read < 0) {
                        break;
                    }
                    bufferedOutputStream.write(bArr, 0, read);
                    bufferedOutputStream.flush();
                }
                bufferedInputStream.close();
                bufferedOutputStream.close();
                if (openFileDescriptor != null) {
                    openFileDescriptor.close();
                }
            } finally {
            }
        } catch (java.io.IOException e) {
            e.printStackTrace();
        }
        contentValues.clear();
        contentValues.put("is_pending", (java.lang.Integer) 0);
        contentResolver.update(insert, contentValues, null, null);
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        sb.append("duration : ");
        sb.append(java.lang.System.currentTimeMillis() - currentTimeMillis);
    }
}
