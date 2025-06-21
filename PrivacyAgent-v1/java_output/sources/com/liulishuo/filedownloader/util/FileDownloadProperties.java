package com.liulishuo.filedownloader.util;

/* loaded from: classes23.dex */
public class FileDownloadProperties {
    public final boolean broadcastCompleted;
    public final int downloadMaxNetworkThreadCount;
    public final int downloadMinProgressStep;
    public final long downloadMinProgressTime;
    public final boolean fileNonPreAllocation;
    public final boolean httpLenient;
    public final boolean processNonSeparate;
    public final boolean trialConnectionHeadMethod;

    public static class HolderClass {
        public static final com.liulishuo.filedownloader.util.FileDownloadProperties a = new com.liulishuo.filedownloader.util.FileDownloadProperties(null);
    }

    /* JADX WARN: Removed duplicated region for block: B:104:0x00ad A[Catch: all -> 0x0294, TryCatch #5 {all -> 0x0294, blocks: (B:77:0x0036, B:80:0x003d, B:83:0x0041, B:86:0x0045, B:89:0x0049, B:92:0x004d, B:95:0x0051, B:98:0x0055, B:102:0x00a9, B:104:0x00ad, B:106:0x00b1, B:115:0x00bf), top: B:76:0x0036 }] */
    /* JADX WARN: Removed duplicated region for block: B:109:0x00c6 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:115:0x00bf A[Catch: all -> 0x0294, TRY_LEAVE, TryCatch #5 {all -> 0x0294, blocks: (B:77:0x0036, B:80:0x003d, B:83:0x0041, B:86:0x0045, B:89:0x0049, B:92:0x004d, B:95:0x0051, B:98:0x0055, B:102:0x00a9, B:104:0x00ad, B:106:0x00b1, B:115:0x00bf), top: B:76:0x0036 }] */
    /* JADX WARN: Removed duplicated region for block: B:12:0x00ec  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x011e  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0149  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x015e  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x017b  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x0190  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x01bd  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x01e8  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x0215  */
    /* JADX WARN: Removed duplicated region for block: B:62:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:63:0x020f  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x01e4  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x01b8  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x018b  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x0172  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x0158  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x0145  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x0117  */
    /* JADX WARN: Type inference failed for: r10v1 */
    /* JADX WARN: Type inference failed for: r10v2, types: [boolean, int] */
    /* JADX WARN: Type inference failed for: r10v3 */
    /* JADX WARN: Type inference failed for: r9v2 */
    /* JADX WARN: Type inference failed for: r9v3, types: [boolean] */
    /* JADX WARN: Type inference failed for: r9v5 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public FileDownloadProperties() {
        java.lang.Throwable th;
        java.io.InputStream inputStream;
        java.lang.String str;
        java.lang.String str2;
        java.lang.String str3;
        java.lang.String str4;
        java.lang.String str5;
        java.lang.String str6;
        java.lang.String str7;
        java.lang.String str8;
        java.lang.Object obj;
        java.lang.String str9;
        java.lang.String str10;
        java.lang.String str11;
        java.lang.String str12;
        java.lang.Object obj2;
        java.lang.Object obj3;
        ?? r10;
        java.lang.Object obj4;
        long j;
        int i;
        ?? r9;
        java.lang.String str13;
        java.lang.String property;
        if (com.liulishuo.filedownloader.util.FileDownloadHelper.getAppContext() == null) {
            throw new java.lang.IllegalStateException("Please invoke the 'FileDownloader#setup' before using FileDownloader. If you want to register some components on FileDownloader please invoke the 'FileDownloader#setupOnApplicationOnCreate' on the 'Application#onCreate' first.");
        }
        long currentTimeMillis = java.lang.System.currentTimeMillis();
        java.util.Properties properties = new java.util.Properties();
        try {
            inputStream = com.liulishuo.filedownloader.util.FileDownloadHelper.getAppContext().getAssets().open("filedownloader.properties");
            if (inputStream != null) {
                try {
                    try {
                        properties.load(inputStream);
                        str = properties.getProperty("http.lenient");
                    } catch (java.io.IOException e) {
                        e = e;
                        str = null;
                        str2 = null;
                        str3 = null;
                        str4 = null;
                        str5 = null;
                        str6 = null;
                        str7 = null;
                        if (e instanceof java.io.FileNotFoundException) {
                            str8 = str;
                            e.printStackTrace();
                        } else if (com.liulishuo.filedownloader.util.FileDownloadLog.NEED_LOG) {
                            str8 = str;
                            com.liulishuo.filedownloader.util.FileDownloadLog.d(com.liulishuo.filedownloader.util.FileDownloadProperties.class, "not found filedownloader.properties", new java.lang.Object[0]);
                        } else {
                            str8 = str;
                        }
                        if (inputStream != null) {
                            try {
                                inputStream.close();
                            } catch (java.io.IOException e2) {
                                e2.printStackTrace();
                            }
                        }
                        obj = com.liulishuo.filedownloader.util.FileDownloadProperties.class;
                        str9 = str2;
                        str10 = str6;
                        str11 = str7;
                        str = str8;
                        str12 = null;
                        obj2 = "download.max-network-thread-count";
                        if (str == null) {
                        }
                        if (str9 == null) {
                        }
                        if (str3 != null) {
                        }
                        if (str4 != null) {
                        }
                        if (str5 != null) {
                        }
                        if (str10 == null) {
                        }
                        if (str11 == null) {
                        }
                        if (str12 == null) {
                        }
                        if (com.liulishuo.filedownloader.util.FileDownloadLog.NEED_LOG) {
                        }
                    }
                    try {
                        str2 = properties.getProperty("process.non-separate");
                    } catch (java.io.IOException e3) {
                        e = e3;
                        str2 = null;
                        str3 = null;
                        str4 = null;
                        str5 = null;
                        str6 = null;
                        str7 = null;
                        if (e instanceof java.io.FileNotFoundException) {
                        }
                        if (inputStream != null) {
                        }
                        obj = com.liulishuo.filedownloader.util.FileDownloadProperties.class;
                        str9 = str2;
                        str10 = str6;
                        str11 = str7;
                        str = str8;
                        str12 = null;
                        obj2 = "download.max-network-thread-count";
                        if (str == null) {
                        }
                        if (str9 == null) {
                        }
                        if (str3 != null) {
                        }
                        if (str4 != null) {
                        }
                        if (str5 != null) {
                        }
                        if (str10 == null) {
                        }
                        if (str11 == null) {
                        }
                        if (str12 == null) {
                        }
                        if (com.liulishuo.filedownloader.util.FileDownloadLog.NEED_LOG) {
                        }
                    }
                    try {
                        str3 = properties.getProperty("download.min-progress-step");
                    } catch (java.io.IOException e4) {
                        e = e4;
                        str3 = null;
                        str4 = null;
                        str5 = null;
                        str6 = null;
                        str7 = null;
                        if (e instanceof java.io.FileNotFoundException) {
                        }
                        if (inputStream != null) {
                        }
                        obj = com.liulishuo.filedownloader.util.FileDownloadProperties.class;
                        str9 = str2;
                        str10 = str6;
                        str11 = str7;
                        str = str8;
                        str12 = null;
                        obj2 = "download.max-network-thread-count";
                        if (str == null) {
                        }
                        if (str9 == null) {
                        }
                        if (str3 != null) {
                        }
                        if (str4 != null) {
                        }
                        if (str5 != null) {
                        }
                        if (str10 == null) {
                        }
                        if (str11 == null) {
                        }
                        if (str12 == null) {
                        }
                        if (com.liulishuo.filedownloader.util.FileDownloadLog.NEED_LOG) {
                        }
                    }
                    try {
                        str4 = properties.getProperty("download.min-progress-time");
                    } catch (java.io.IOException e5) {
                        e = e5;
                        str4 = null;
                        str5 = null;
                        str6 = null;
                        str7 = null;
                        if (e instanceof java.io.FileNotFoundException) {
                        }
                        if (inputStream != null) {
                        }
                        obj = com.liulishuo.filedownloader.util.FileDownloadProperties.class;
                        str9 = str2;
                        str10 = str6;
                        str11 = str7;
                        str = str8;
                        str12 = null;
                        obj2 = "download.max-network-thread-count";
                        if (str == null) {
                        }
                        if (str9 == null) {
                        }
                        if (str3 != null) {
                        }
                        if (str4 != null) {
                        }
                        if (str5 != null) {
                        }
                        if (str10 == null) {
                        }
                        if (str11 == null) {
                        }
                        if (str12 == null) {
                        }
                        if (com.liulishuo.filedownloader.util.FileDownloadLog.NEED_LOG) {
                        }
                    }
                    try {
                        str5 = properties.getProperty("download.max-network-thread-count");
                    } catch (java.io.IOException e6) {
                        e = e6;
                        str5 = null;
                        str6 = null;
                        str7 = null;
                        if (e instanceof java.io.FileNotFoundException) {
                        }
                        if (inputStream != null) {
                        }
                        obj = com.liulishuo.filedownloader.util.FileDownloadProperties.class;
                        str9 = str2;
                        str10 = str6;
                        str11 = str7;
                        str = str8;
                        str12 = null;
                        obj2 = "download.max-network-thread-count";
                        if (str == null) {
                        }
                        if (str9 == null) {
                        }
                        if (str3 != null) {
                        }
                        if (str4 != null) {
                        }
                        if (str5 != null) {
                        }
                        if (str10 == null) {
                        }
                        if (str11 == null) {
                        }
                        if (str12 == null) {
                        }
                        if (com.liulishuo.filedownloader.util.FileDownloadLog.NEED_LOG) {
                        }
                    }
                    try {
                        str6 = properties.getProperty("file.non-pre-allocation");
                    } catch (java.io.IOException e7) {
                        e = e7;
                        str6 = null;
                        str7 = null;
                        if (e instanceof java.io.FileNotFoundException) {
                        }
                        if (inputStream != null) {
                        }
                        obj = com.liulishuo.filedownloader.util.FileDownloadProperties.class;
                        str9 = str2;
                        str10 = str6;
                        str11 = str7;
                        str = str8;
                        str12 = null;
                        obj2 = "download.max-network-thread-count";
                        if (str == null) {
                        }
                        if (str9 == null) {
                        }
                        if (str3 != null) {
                        }
                        if (str4 != null) {
                        }
                        if (str5 != null) {
                        }
                        if (str10 == null) {
                        }
                        if (str11 == null) {
                        }
                        if (str12 == null) {
                        }
                        if (com.liulishuo.filedownloader.util.FileDownloadLog.NEED_LOG) {
                        }
                    }
                    try {
                        str7 = properties.getProperty("broadcast.completed");
                    } catch (java.io.IOException e8) {
                        e = e8;
                        str7 = null;
                        if (e instanceof java.io.FileNotFoundException) {
                        }
                        if (inputStream != null) {
                        }
                        obj = com.liulishuo.filedownloader.util.FileDownloadProperties.class;
                        str9 = str2;
                        str10 = str6;
                        str11 = str7;
                        str = str8;
                        str12 = null;
                        obj2 = "download.max-network-thread-count";
                        if (str == null) {
                        }
                        if (str9 == null) {
                        }
                        if (str3 != null) {
                        }
                        if (str4 != null) {
                        }
                        if (str5 != null) {
                        }
                        if (str10 == null) {
                        }
                        if (str11 == null) {
                        }
                        if (str12 == null) {
                        }
                        if (com.liulishuo.filedownloader.util.FileDownloadLog.NEED_LOG) {
                        }
                    }
                    try {
                        str13 = str2;
                        property = properties.getProperty("download.trial-connection-head-method");
                    } catch (java.io.IOException e9) {
                        e = e9;
                        if (e instanceof java.io.FileNotFoundException) {
                        }
                        if (inputStream != null) {
                        }
                        obj = com.liulishuo.filedownloader.util.FileDownloadProperties.class;
                        str9 = str2;
                        str10 = str6;
                        str11 = str7;
                        str = str8;
                        str12 = null;
                        obj2 = "download.max-network-thread-count";
                        if (str == null) {
                        }
                        if (str9 == null) {
                        }
                        if (str3 != null) {
                        }
                        if (str4 != null) {
                        }
                        if (str5 != null) {
                        }
                        if (str10 == null) {
                        }
                        if (str11 == null) {
                        }
                        if (str12 == null) {
                        }
                        if (com.liulishuo.filedownloader.util.FileDownloadLog.NEED_LOG) {
                        }
                    }
                } catch (java.lang.Throwable th2) {
                    th = th2;
                    if (inputStream == null) {
                        throw th;
                    }
                    try {
                        inputStream.close();
                        throw th;
                    } catch (java.io.IOException e10) {
                        e10.printStackTrace();
                        throw th;
                    }
                }
            } else {
                str = null;
                str13 = null;
                property = null;
                str3 = null;
                str4 = null;
                str5 = null;
                str6 = null;
                str7 = null;
            }
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (java.io.IOException e11) {
                    e11.printStackTrace();
                }
            }
            str9 = str13;
            str12 = property;
            str10 = str6;
            obj2 = "download.max-network-thread-count";
            obj = com.liulishuo.filedownloader.util.FileDownloadProperties.class;
            str11 = str7;
        } catch (java.io.IOException e12) {
            e = e12;
            inputStream = null;
        } catch (java.lang.Throwable th3) {
            th = th3;
            inputStream = null;
        }
        if (str == null) {
            obj3 = "http.lenient";
            r10 = 0;
            this.httpLenient = false;
        } else {
            if (!str.equals(com.aliyun.svideosdk.preview.camera.AliyunRecorderProperty.SURFACE_ROTATION_MODE_TRUE) && !str.equals(com.aliyun.svideosdk.preview.camera.AliyunRecorderProperty.SURFACE_ROTATION_MODE_FALSE)) {
                throw new java.lang.IllegalStateException(com.liulishuo.filedownloader.util.FileDownloadUtils.formatString("the value of '%s' must be '%s' or '%s'", "http.lenient", com.aliyun.svideosdk.preview.camera.AliyunRecorderProperty.SURFACE_ROTATION_MODE_TRUE, com.aliyun.svideosdk.preview.camera.AliyunRecorderProperty.SURFACE_ROTATION_MODE_FALSE));
            }
            obj3 = "http.lenient";
            r10 = 0;
            this.httpLenient = str.equals(com.aliyun.svideosdk.preview.camera.AliyunRecorderProperty.SURFACE_ROTATION_MODE_TRUE);
        }
        if (str9 == null) {
            this.processNonSeparate = r10;
        } else {
            if (!str9.equals(com.aliyun.svideosdk.preview.camera.AliyunRecorderProperty.SURFACE_ROTATION_MODE_TRUE) && !str9.equals(com.aliyun.svideosdk.preview.camera.AliyunRecorderProperty.SURFACE_ROTATION_MODE_FALSE)) {
                java.lang.Object[] objArr = new java.lang.Object[3];
                objArr[r10] = "process.non-separate";
                objArr[1] = com.aliyun.svideosdk.preview.camera.AliyunRecorderProperty.SURFACE_ROTATION_MODE_TRUE;
                objArr[2] = com.aliyun.svideosdk.preview.camera.AliyunRecorderProperty.SURFACE_ROTATION_MODE_FALSE;
                throw new java.lang.IllegalStateException(com.liulishuo.filedownloader.util.FileDownloadUtils.formatString("the value of '%s' must be '%s' or '%s'", objArr));
            }
            this.processNonSeparate = str9.equals(com.aliyun.svideosdk.preview.camera.AliyunRecorderProperty.SURFACE_ROTATION_MODE_TRUE);
        }
        if (str3 != null) {
            this.downloadMinProgressStep = java.lang.Math.max((int) r10, java.lang.Integer.valueOf(str3).intValue());
        } else {
            this.downloadMinProgressStep = 65536;
        }
        if (str4 != null) {
            obj4 = "process.non-separate";
            j = currentTimeMillis;
            this.downloadMinProgressTime = java.lang.Math.max(0L, java.lang.Long.valueOf(str4).longValue());
        } else {
            obj4 = "process.non-separate";
            j = currentTimeMillis;
            this.downloadMinProgressTime = 2000L;
        }
        if (str5 != null) {
            this.downloadMaxNetworkThreadCount = getValidNetworkThreadCount(java.lang.Integer.valueOf(str5).intValue());
            i = 3;
        } else {
            i = 3;
            this.downloadMaxNetworkThreadCount = 3;
        }
        if (str10 == null) {
            r9 = 0;
            this.fileNonPreAllocation = false;
        } else {
            if (!str10.equals(com.aliyun.svideosdk.preview.camera.AliyunRecorderProperty.SURFACE_ROTATION_MODE_TRUE) && !str10.equals(com.aliyun.svideosdk.preview.camera.AliyunRecorderProperty.SURFACE_ROTATION_MODE_FALSE)) {
                java.lang.Object[] objArr2 = new java.lang.Object[i];
                objArr2[0] = "file.non-pre-allocation";
                objArr2[1] = com.aliyun.svideosdk.preview.camera.AliyunRecorderProperty.SURFACE_ROTATION_MODE_TRUE;
                objArr2[2] = com.aliyun.svideosdk.preview.camera.AliyunRecorderProperty.SURFACE_ROTATION_MODE_FALSE;
                throw new java.lang.IllegalStateException(com.liulishuo.filedownloader.util.FileDownloadUtils.formatString("the value of '%s' must be '%s' or '%s'", objArr2));
            }
            r9 = 0;
            this.fileNonPreAllocation = str10.equals(com.aliyun.svideosdk.preview.camera.AliyunRecorderProperty.SURFACE_ROTATION_MODE_TRUE);
        }
        if (str11 == null) {
            this.broadcastCompleted = r9;
        } else {
            if (!str11.equals(com.aliyun.svideosdk.preview.camera.AliyunRecorderProperty.SURFACE_ROTATION_MODE_TRUE) && !str11.equals(com.aliyun.svideosdk.preview.camera.AliyunRecorderProperty.SURFACE_ROTATION_MODE_FALSE)) {
                java.lang.Object[] objArr3 = new java.lang.Object[3];
                objArr3[r9] = "broadcast.completed";
                objArr3[1] = com.aliyun.svideosdk.preview.camera.AliyunRecorderProperty.SURFACE_ROTATION_MODE_TRUE;
                objArr3[2] = com.aliyun.svideosdk.preview.camera.AliyunRecorderProperty.SURFACE_ROTATION_MODE_FALSE;
                throw new java.lang.IllegalStateException(com.liulishuo.filedownloader.util.FileDownloadUtils.formatString("the value of '%s' must be '%s' or '%s'", objArr3));
            }
            this.broadcastCompleted = str11.equals(com.aliyun.svideosdk.preview.camera.AliyunRecorderProperty.SURFACE_ROTATION_MODE_TRUE);
        }
        if (str12 == null) {
            this.trialConnectionHeadMethod = r9;
        } else {
            if (!str12.equals(com.aliyun.svideosdk.preview.camera.AliyunRecorderProperty.SURFACE_ROTATION_MODE_TRUE) && !str12.equals(com.aliyun.svideosdk.preview.camera.AliyunRecorderProperty.SURFACE_ROTATION_MODE_FALSE)) {
                java.lang.Object[] objArr4 = new java.lang.Object[3];
                objArr4[r9] = "download.trial-connection-head-method";
                objArr4[1] = com.aliyun.svideosdk.preview.camera.AliyunRecorderProperty.SURFACE_ROTATION_MODE_TRUE;
                objArr4[2] = com.aliyun.svideosdk.preview.camera.AliyunRecorderProperty.SURFACE_ROTATION_MODE_FALSE;
                throw new java.lang.IllegalStateException(com.liulishuo.filedownloader.util.FileDownloadUtils.formatString("the value of '%s' must be '%s' or '%s'", objArr4));
            }
            this.trialConnectionHeadMethod = str12.equals(com.aliyun.svideosdk.preview.camera.AliyunRecorderProperty.SURFACE_ROTATION_MODE_TRUE);
        }
        if (com.liulishuo.filedownloader.util.FileDownloadLog.NEED_LOG) {
            java.lang.Object[] objArr5 = new java.lang.Object[17];
            objArr5[r9] = java.lang.Long.valueOf(java.lang.System.currentTimeMillis() - j);
            objArr5[1] = obj3;
            objArr5[2] = java.lang.Boolean.valueOf(this.httpLenient);
            objArr5[3] = obj4;
            objArr5[4] = java.lang.Boolean.valueOf(this.processNonSeparate);
            objArr5[5] = "download.min-progress-step";
            objArr5[6] = java.lang.Integer.valueOf(this.downloadMinProgressStep);
            objArr5[7] = "download.min-progress-time";
            objArr5[8] = java.lang.Long.valueOf(this.downloadMinProgressTime);
            objArr5[9] = obj2;
            objArr5[10] = java.lang.Integer.valueOf(this.downloadMaxNetworkThreadCount);
            objArr5[11] = "file.non-pre-allocation";
            objArr5[12] = java.lang.Boolean.valueOf(this.fileNonPreAllocation);
            objArr5[13] = "broadcast.completed";
            objArr5[14] = java.lang.Boolean.valueOf(this.broadcastCompleted);
            objArr5[15] = "download.trial-connection-head-method";
            objArr5[16] = java.lang.Boolean.valueOf(this.trialConnectionHeadMethod);
            com.liulishuo.filedownloader.util.FileDownloadLog.i(obj, "init properties %d\n load properties: %s=%B; %s=%B; %s=%d; %s=%d; %s=%d; %s=%B; %s=%B; %s=%B", objArr5);
        }
    }

    public /* synthetic */ FileDownloadProperties(com.liulishuo.filedownloader.util.FileDownloadProperties.AnonymousClass1 anonymousClass1) {
        this();
    }

    public static com.liulishuo.filedownloader.util.FileDownloadProperties getImpl() {
        return com.liulishuo.filedownloader.util.FileDownloadProperties.HolderClass.a;
    }

    public static int getValidNetworkThreadCount(int i) {
        if (i > 12) {
            com.liulishuo.filedownloader.util.FileDownloadLog.w(com.liulishuo.filedownloader.util.FileDownloadProperties.class, "require the count of network thread  is %d, what is more than the max valid count(%d), so adjust to %d auto", java.lang.Integer.valueOf(i), 12, 12);
            return 12;
        }
        if (i >= 1) {
            return i;
        }
        com.liulishuo.filedownloader.util.FileDownloadLog.w(com.liulishuo.filedownloader.util.FileDownloadProperties.class, "require the count of network thread  is %d, what is less than the min valid count(%d), so adjust to %d auto", java.lang.Integer.valueOf(i), 1, 1);
        return 1;
    }
}
