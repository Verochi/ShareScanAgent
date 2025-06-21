package com.aliyun.common.utils;

/* loaded from: classes.dex */
public class MediaUtil {
    /* JADX WARN: Removed duplicated region for block: B:39:0x0073 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static int getFrameRate(java.lang.String str) {
        java.lang.Throwable th;
        java.lang.Exception e;
        android.media.MediaExtractor mediaExtractor = new android.media.MediaExtractor();
        int i = 0;
        java.io.FileInputStream fileInputStream = null;
        try {
            java.io.FileInputStream fileInputStream2 = new java.io.FileInputStream(new java.io.File(str));
            try {
                try {
                    mediaExtractor.setDataSource(fileInputStream2.getFD());
                    int trackCount = mediaExtractor.getTrackCount();
                    int i2 = 0;
                    while (i < trackCount) {
                        try {
                            android.media.MediaFormat trackFormat = mediaExtractor.getTrackFormat(i);
                            if (trackFormat.getString("mime").startsWith("video/") && trackFormat.containsKey("frame-rate")) {
                                i2 = trackFormat.getInteger("frame-rate");
                            }
                            i++;
                        } catch (java.lang.Exception e2) {
                            e = e2;
                            i = i2;
                            fileInputStream = fileInputStream2;
                            try {
                                e.printStackTrace();
                                mediaExtractor.release();
                                if (fileInputStream != null) {
                                    try {
                                        fileInputStream.close();
                                    } catch (java.io.IOException e3) {
                                        e3.printStackTrace();
                                    }
                                }
                                return i;
                            } catch (java.lang.Throwable th2) {
                                th = th2;
                                mediaExtractor.release();
                                if (fileInputStream != null) {
                                }
                                throw th;
                            }
                        }
                    }
                    mediaExtractor.release();
                    try {
                        fileInputStream2.close();
                        return i2;
                    } catch (java.io.IOException e4) {
                        e4.printStackTrace();
                        return i2;
                    }
                } catch (java.lang.Throwable th3) {
                    th = th3;
                    fileInputStream = fileInputStream2;
                    mediaExtractor.release();
                    if (fileInputStream != null) {
                        try {
                            fileInputStream.close();
                        } catch (java.io.IOException e5) {
                            e5.printStackTrace();
                        }
                    }
                    throw th;
                }
            } catch (java.lang.Exception e6) {
                e = e6;
            }
        } catch (java.lang.Exception e7) {
            e = e7;
        } catch (java.lang.Throwable th4) {
            th = th4;
        }
    }

    public static long getVideoDuration(java.lang.String str) {
        android.media.MediaMetadataRetriever mediaMetadataRetriever;
        android.media.MediaMetadataRetriever mediaMetadataRetriever2 = null;
        try {
            try {
                mediaMetadataRetriever = new android.media.MediaMetadataRetriever();
            } catch (java.lang.Exception unused) {
            }
        } catch (java.lang.Throwable th) {
            th = th;
        }
        try {
            mediaMetadataRetriever.setDataSource(str);
            long parseLong = java.lang.Long.parseLong(mediaMetadataRetriever.extractMetadata(9));
            mediaMetadataRetriever.release();
            return parseLong;
        } catch (java.lang.Exception unused2) {
            mediaMetadataRetriever2 = mediaMetadataRetriever;
            java.lang.StringBuilder sb = new java.lang.StringBuilder();
            sb.append("Invalid source[");
            sb.append(str);
            sb.append("]");
            if (mediaMetadataRetriever2 == null) {
                return 0L;
            }
            mediaMetadataRetriever2.release();
            return 0L;
        } catch (java.lang.Throwable th2) {
            th = th2;
            mediaMetadataRetriever2 = mediaMetadataRetriever;
            if (mediaMetadataRetriever2 != null) {
                mediaMetadataRetriever2.release();
            }
            throw th;
        }
    }
}
