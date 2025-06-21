package com.aliyun.svideosdk.crop.impl;

/* loaded from: classes12.dex */
class a implements com.aliyun.svideosdk.crop.AliyunICrop {
    private static final java.util.ArrayList<java.lang.String> l = new com.aliyun.svideosdk.crop.impl.a.C0091a();
    private static final java.util.ArrayList<java.lang.String> m = new com.aliyun.svideosdk.crop.impl.a.b();
    private final java.lang.String a;
    private com.aliyun.svideosdk.crop.CropCallback b;
    private com.aliyun.svideosdk.transcode.NativeTranscode2 c;
    private com.aliyun.svideosdk.transcode.NativeTranscode2InitStruct d;
    private android.media.MediaMetadataRetriever e;
    private com.aliyun.svideosdk.crop.CropParam f;
    private byte g;
    private final java.lang.Object h;
    private android.os.Handler i;
    private long j;
    private com.aliyun.common.log.reporter.AlivcCropReporter k;

    /* renamed from: com.aliyun.svideosdk.crop.impl.a$a, reason: collision with other inner class name */
    public static class C0091a extends java.util.ArrayList {
        public C0091a() {
            add("aac");
            add("mp3");
            add("amr");
            add("pcm");
            add("no_audio");
            add("unknown");
        }
    }

    public static class b extends java.util.ArrayList {
        public b() {
            add(tv.danmaku.ijk.media.player.misc.IjkMediaFormat.CODEC_NAME_H264);
            add("hevc");
            add("mpeg4");
            add("3gp");
            add("h263");
        }
    }

    public class c implements java.lang.Runnable {
        public c() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (com.aliyun.svideosdk.crop.impl.a.this.b != null) {
                com.aliyun.svideosdk.crop.impl.a.this.b.onComplete(0L);
            }
        }
    }

    public class d implements com.aliyun.svideosdk.transcode.NativeTranscode2.TranscodeCallback {

        /* renamed from: com.aliyun.svideosdk.crop.impl.a$d$a, reason: collision with other inner class name */
        public class RunnableC0092a implements java.lang.Runnable {
            final /* synthetic */ int a;

            public RunnableC0092a(int i) {
                this.a = i;
            }

            @Override // java.lang.Runnable
            public void run() {
                if (com.aliyun.svideosdk.crop.impl.a.this.b != null) {
                    com.aliyun.svideosdk.crop.impl.a.this.b.onProgress(this.a);
                }
            }
        }

        public class b implements java.lang.Runnable {
            final /* synthetic */ int a;

            public b(int i) {
                this.a = i;
            }

            @Override // java.lang.Runnable
            public void run() {
                synchronized (com.aliyun.svideosdk.crop.impl.a.this.h) {
                    if (com.aliyun.svideosdk.crop.impl.a.this.c != null) {
                        com.aliyun.svideosdk.crop.impl.a.this.c.uninit();
                    }
                    com.aliyun.svideosdk.crop.impl.a.this.g = (byte) 0;
                }
                com.aliyun.svideosdk.crop.impl.a.this.a(com.aliyun.svideosdk.common.a.a(this.a));
            }
        }

        public class c implements java.lang.Runnable {
            public c() {
            }

            @Override // java.lang.Runnable
            public void run() {
                long j;
                synchronized (com.aliyun.svideosdk.crop.impl.a.this.h) {
                    if (com.aliyun.svideosdk.crop.impl.a.this.c != null) {
                        j = com.aliyun.svideosdk.crop.impl.a.this.c.getDuration();
                        com.aliyun.svideosdk.crop.impl.a.this.c.uninit();
                    } else {
                        j = 0;
                    }
                    if (com.aliyun.svideosdk.crop.impl.a.this.b != null && com.aliyun.svideosdk.crop.impl.a.this.g == 1) {
                        com.aliyun.svideosdk.crop.impl.a.this.g = (byte) 0;
                        com.aliyun.svideosdk.crop.impl.a.this.b.onComplete(j);
                    } else if (com.aliyun.svideosdk.crop.impl.a.this.b != null && com.aliyun.svideosdk.crop.impl.a.this.g == 2) {
                        com.aliyun.svideosdk.crop.impl.a.this.g = (byte) 0;
                        com.aliyun.svideosdk.crop.impl.a.this.b.onCancelComplete();
                    }
                }
            }
        }

        public d() {
        }

        @Override // com.aliyun.svideosdk.transcode.NativeTranscode2.TranscodeCallback
        public void onError(int i) {
            com.aliyun.svideosdk.crop.impl.a.this.i.post(new com.aliyun.svideosdk.crop.impl.a.d.b(i));
        }

        @Override // com.aliyun.svideosdk.transcode.NativeTranscode2.TranscodeCallback
        public void onExit() {
            if (com.aliyun.svideosdk.crop.impl.a.this.g == 1) {
                com.aliyun.svideosdk.crop.impl.a aVar = com.aliyun.svideosdk.crop.impl.a.this;
                aVar.a(aVar.j);
            }
            com.aliyun.svideosdk.crop.impl.a.this.j = 0L;
            com.aliyun.svideosdk.crop.impl.a.this.i.post(new com.aliyun.svideosdk.crop.impl.a.d.c());
        }

        @Override // com.aliyun.svideosdk.transcode.NativeTranscode2.TranscodeCallback
        public void onProgress(int i) {
            com.aliyun.svideosdk.crop.impl.a.this.i.post(new com.aliyun.svideosdk.crop.impl.a.d.RunnableC0092a(i));
        }
    }

    public class e implements java.lang.Runnable {
        final /* synthetic */ long a;

        public e(long j) {
            this.a = j;
        }

        /* JADX WARN: Removed duplicated region for block: B:21:0x0159  */
        /* JADX WARN: Removed duplicated region for block: B:24:? A[RETURN, SYNTHETIC] */
        @Override // java.lang.Runnable
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void run() {
            java.lang.String str;
            java.lang.String str2;
            java.lang.String str3 = com.aliyun.common.log.struct.AliyunLogKey.KEY_AUDIO_DURATION;
            java.io.File file = new java.io.File(com.aliyun.svideosdk.crop.impl.a.this.f.getOutputPath());
            if (file.exists()) {
                java.util.HashMap<java.lang.String, java.lang.String> hashMap = new java.util.HashMap<>();
                try {
                    hashMap.put("sz", java.lang.String.valueOf(file.length()));
                    try {
                        hashMap.put(com.aliyun.common.log.struct.AliyunLogKey.KEY_TIME_CONSUMPTION, java.lang.String.valueOf((java.lang.System.nanoTime() - this.a) / 1000));
                        hashMap.put("op", com.aliyun.svideosdk.crop.impl.a.this.f.getOutputPath());
                        com.aliyun.svideosdk.crop.impl.a.this.e.setDataSource(file.getPath());
                        hashMap.put("dr", com.aliyun.svideosdk.crop.impl.a.this.e.extractMetadata(9) + "000");
                        hashMap.put("wd", com.aliyun.svideosdk.crop.impl.a.this.e.extractMetadata(18));
                        hashMap.put("ht", com.aliyun.svideosdk.crop.impl.a.this.e.extractMetadata(19));
                        hashMap.put("cc", com.aliyun.svideosdk.crop.impl.a.this.e.extractMetadata(12));
                        hashMap.put("fm", com.aliyun.svideosdk.crop.impl.a.this.e.extractMetadata(12));
                        hashMap.put("br", com.aliyun.svideosdk.crop.impl.a.this.e.extractMetadata(20));
                        hashMap.put("fps", java.lang.String.valueOf(com.aliyun.common.utils.MediaUtil.getFrameRate(com.aliyun.svideosdk.crop.impl.a.this.f.getOutputPath())));
                        java.lang.String str4 = com.aliyun.svideosdk.crop.impl.a.this.e.extractMetadata(9) + "000";
                        str3 = com.aliyun.common.log.struct.AliyunLogKey.KEY_AUDIO_DURATION;
                        try {
                            hashMap.put(str3, str4);
                            str2 = com.aliyun.svideosdk.crop.impl.a.this.e.extractMetadata(9) + "000";
                            str = com.aliyun.common.log.struct.AliyunLogKey.KEY_VIDEO_DURATION;
                        } catch (java.lang.Exception unused) {
                            str = com.aliyun.common.log.struct.AliyunLogKey.KEY_VIDEO_DURATION;
                        }
                    } catch (java.lang.Exception unused2) {
                        str = com.aliyun.common.log.struct.AliyunLogKey.KEY_VIDEO_DURATION;
                        str3 = com.aliyun.common.log.struct.AliyunLogKey.KEY_AUDIO_DURATION;
                    }
                    try {
                        hashMap.put(str, str2);
                    } catch (java.lang.Exception unused3) {
                        hashMap.put("dr", "0");
                        hashMap.put("wd", "0");
                        hashMap.put("ht", "0");
                        hashMap.put("cc", "unknown");
                        hashMap.put("fm", "unknown");
                        hashMap.put("br", "0");
                        hashMap.put("fps", "0");
                        hashMap.put(str3, "0");
                        hashMap.put(str, "0");
                        if (com.aliyun.svideosdk.crop.impl.a.this.k == null) {
                        }
                    }
                } catch (java.lang.Exception unused4) {
                    str = com.aliyun.common.log.struct.AliyunLogKey.KEY_VIDEO_DURATION;
                }
                if (com.aliyun.svideosdk.crop.impl.a.this.k == null) {
                    com.aliyun.svideosdk.crop.impl.a.this.k.sendCompleteEvent(hashMap);
                }
            }
        }
    }

    public class f implements java.lang.Thread.UncaughtExceptionHandler {
        public f(com.aliyun.svideosdk.crop.impl.a aVar) {
        }

        @Override // java.lang.Thread.UncaughtExceptionHandler
        public void uncaughtException(java.lang.Thread thread, java.lang.Throwable th) {
            com.aliyun.common.log.debuglog.AlivcSvideoLog.e("AliYunLog", "parse File failed, msg is " + th.getMessage());
        }
    }

    public static /* synthetic */ class g {
        static final /* synthetic */ int[] a;
        static final /* synthetic */ int[] b;
        static final /* synthetic */ int[] c;

        static {
            int[] iArr = new int[com.aliyun.svideosdk.common.struct.encoder.VideoCodecs.values().length];
            c = iArr;
            try {
                iArr[com.aliyun.svideosdk.common.struct.encoder.VideoCodecs.H264_HARDWARE.ordinal()] = 1;
            } catch (java.lang.NoSuchFieldError unused) {
            }
            try {
                c[com.aliyun.svideosdk.common.struct.encoder.VideoCodecs.H264_SOFT_OPENH264.ordinal()] = 2;
            } catch (java.lang.NoSuchFieldError unused2) {
            }
            int[] iArr2 = new int[com.aliyun.svideosdk.common.struct.common.VideoDisplayMode.values().length];
            b = iArr2;
            try {
                iArr2[com.aliyun.svideosdk.common.struct.common.VideoDisplayMode.FILL.ordinal()] = 1;
            } catch (java.lang.NoSuchFieldError unused3) {
            }
            try {
                b[com.aliyun.svideosdk.common.struct.common.VideoDisplayMode.SCALE.ordinal()] = 2;
            } catch (java.lang.NoSuchFieldError unused4) {
            }
            int[] iArr3 = new int[com.aliyun.svideosdk.common.struct.common.MediaType.values().length];
            a = iArr3;
            try {
                iArr3[com.aliyun.svideosdk.common.struct.common.MediaType.ANY_IMAGE_TYPE.ordinal()] = 1;
            } catch (java.lang.NoSuchFieldError unused5) {
            }
            try {
                a[com.aliyun.svideosdk.common.struct.common.MediaType.ANY_AUDIO_TYPE.ordinal()] = 2;
            } catch (java.lang.NoSuchFieldError unused6) {
            }
            try {
                a[com.aliyun.svideosdk.common.struct.common.MediaType.ANY_VIDEO_TYPE.ordinal()] = 3;
            } catch (java.lang.NoSuchFieldError unused7) {
            }
        }
    }

    public a(android.content.Context context) {
        java.lang.String generateUUID = com.aliyun.common.log.util.UUIDGenerator.generateUUID();
        this.a = generateUUID;
        this.c = new com.aliyun.svideosdk.transcode.NativeTranscode2();
        this.d = new com.aliyun.svideosdk.transcode.NativeTranscode2InitStruct();
        this.e = new android.media.MediaMetadataRetriever();
        this.g = (byte) 0;
        this.h = new java.lang.Object();
        this.i = null;
        this.j = 0L;
        this.k = new com.aliyun.common.log.reporter.AlivcCropReporter(context, generateUUID);
        com.aliyun.common.log.debuglog.AlivcSvideoLog.i("AliYunLog", "AliyunCrop2 constructor");
        com.aliyun.svideosdk.transcode.NativeTranscode2InitStruct nativeTranscode2InitStruct = this.d;
        com.aliyun.common.log.reporter.AlivcCropReporter alivcCropReporter = this.k;
        nativeTranscode2InitStruct.reportId = alivcCropReporter == null ? -1L : alivcCropReporter.getReportId();
        this.i = new android.os.Handler(android.os.Looper.getMainLooper());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int a(int i) {
        return a(i, true);
    }

    private int a(int i, boolean z) {
        com.aliyun.svideosdk.crop.CropCallback cropCallback;
        com.aliyun.common.log.debuglog.AlivcSvideoLog.e("AliYunLog", "crop occur error :" + i);
        if (z && (cropCallback = this.b) != null) {
            cropCallback.onError(i);
        }
        com.aliyun.common.log.reporter.AlivcCropReporter alivcCropReporter = this.k;
        if (alivcCropReporter != null) {
            alivcCropReporter.sendErrorEvent(i);
        }
        return i;
    }

    private int a(java.lang.String str) {
        android.media.ExifInterface exifInterface;
        int attributeInt;
        try {
            exifInterface = new android.media.ExifInterface(str);
        } catch (java.io.IOException e2) {
            com.aliyun.common.log.debuglog.AlivcSvideoLog.e("AliYunLog", "cannot read exif" + e2);
            exifInterface = null;
        }
        if (exifInterface != null && (attributeInt = exifInterface.getAttributeInt(androidx.exifinterface.media.ExifInterface.TAG_ORIENTATION, -1)) != -1) {
            if (attributeInt == 3) {
                return 180;
            }
            if (attributeInt == 6) {
                return 90;
            }
            if (attributeInt == 8) {
                return 270;
            }
        }
        return 0;
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x0093  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0098  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private int a(java.lang.String str, java.lang.String str2, android.graphics.Rect rect) {
        int i;
        boolean a;
        if (str == null || !new java.io.File(str).exists()) {
            i = -20002003;
        } else if (str2 == null) {
            i = -20003021;
        } else {
            com.aliyun.svideosdk.common.b.c.a aVar = new com.aliyun.svideosdk.common.b.c.a();
            android.graphics.BitmapFactory.Options options = new android.graphics.BitmapFactory.Options();
            options.inJustDecodeBounds = true;
            android.graphics.BitmapFactory.decodeFile(str, options);
            int i2 = options.outWidth;
            int i3 = options.outHeight;
            float f2 = (i2 * 1.0f) / i3;
            float width = (rect.width() * 1.0f) / rect.height();
            int a2 = a(str);
            if (f2 != width) {
                int i4 = com.aliyun.svideosdk.crop.impl.a.g.b[this.f.getScaleMode().ordinal()];
                if (i4 == 1) {
                    a = aVar.a(str, str2, this.f.getOutputWidth(), this.f.getOutputHeight(), i2, i3, this.f.getFillColor(), a2, android.graphics.Bitmap.Config.ARGB_8888);
                } else if (i4 != 2) {
                    a = false;
                }
                if (!a) {
                    this.i.post(new com.aliyun.svideosdk.crop.impl.a.c());
                    return 0;
                }
                i = -20004007;
            }
            a = aVar.a(str, str2, rect, this.f.getOutputWidth(), this.f.getOutputHeight(), a2, android.graphics.Bitmap.Config.ARGB_8888);
            if (!a) {
            }
        }
        return a(i);
    }

    private int a(boolean z) {
        int i;
        if (this.f.getInputPath() == null || this.f.getInputPath().isEmpty() || !new java.io.File(this.f.getInputPath()).exists()) {
            i = -20003004;
        } else if (this.f.getOutputPath() == null || this.f.getOutputPath().isEmpty()) {
            i = -20003021;
        } else {
            com.aliyun.common.log.debuglog.AlivcSvideoLog.d("AliYunLog", "Call start crop video");
            com.aliyun.svideosdk.transcode.NativeParser nativeParser = new com.aliyun.svideosdk.transcode.NativeParser();
            nativeParser.init(this.f.getInputPath());
            boolean contains = m.contains(nativeParser.getValue(1));
            boolean contains2 = l.contains(nativeParser.getValue(16));
            nativeParser.release();
            nativeParser.dispose();
            synchronized (this.h) {
                if (this.g != 0) {
                    return a(-20010001);
                }
                this.g = (byte) 1;
                if (this.f == null) {
                    synchronized (this.h) {
                        this.g = (byte) 0;
                    }
                    i = -20010002;
                } else if (z && !contains) {
                    synchronized (this.h) {
                        this.g = (byte) 0;
                    }
                    i = -20004001;
                } else if (contains2) {
                    com.aliyun.svideosdk.transcode.NativeTranscode2InitStruct nativeTranscode2InitStruct = this.d;
                    nativeTranscode2InitStruct.needAudio = true;
                    nativeTranscode2InitStruct.needVideo = z;
                    i = this.c.init(nativeTranscode2InitStruct);
                    if (i == 0) {
                        int start = this.c.start();
                        if (start >= 0) {
                            this.j = java.lang.System.nanoTime();
                            return 0;
                        }
                        synchronized (this.h) {
                            this.g = (byte) 0;
                        }
                        return a(start);
                    }
                    synchronized (this.h) {
                        this.g = (byte) 0;
                    }
                    com.aliyun.common.log.debuglog.AlivcSvideoLog.e("AliYunLog", "NativeTranscode init failed, return " + i);
                } else {
                    synchronized (this.h) {
                        this.g = (byte) 0;
                    }
                    i = -20004002;
                }
            }
        }
        return a(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(long j) {
        if (this.k != null) {
            java.lang.Thread thread = new java.lang.Thread(new com.aliyun.svideosdk.crop.impl.a.e(j));
            thread.setUncaughtExceptionHandler(new com.aliyun.svideosdk.crop.impl.a.f(this));
            thread.start();
        }
    }

    @Override // com.aliyun.svideosdk.crop.AliyunICrop
    public void cancel() {
        com.aliyun.common.log.debuglog.AlivcSvideoLog.i("AliYunLog", "AliyunCrop cancel");
        synchronized (this.h) {
            if (this.g == 1) {
                this.g = (byte) 2;
                com.aliyun.common.log.debuglog.AlivcSvideoLog.d("AliYunLog", "call crop cancel");
                this.k.sendCancelEvent();
                this.c.cancel();
            }
        }
    }

    @Override // com.aliyun.svideosdk.crop.AliyunICrop
    public void dispose() {
        com.aliyun.common.log.debuglog.AlivcSvideoLog.i("AliYunLog", "AliyunCrop2 dispose");
        synchronized (this.h) {
            com.aliyun.svideosdk.transcode.NativeTranscode2 nativeTranscode2 = this.c;
            if (nativeTranscode2 != null) {
                nativeTranscode2.dispose();
                this.c = null;
            }
            this.d = null;
            this.b = null;
            com.aliyun.common.log.reporter.AlivcCropReporter alivcCropReporter = this.k;
            if (alivcCropReporter != null) {
                alivcCropReporter.release();
                this.k = null;
            }
            android.media.MediaMetadataRetriever mediaMetadataRetriever = this.e;
            if (mediaMetadataRetriever != null) {
                mediaMetadataRetriever.release();
                this.e = null;
            }
            this.g = (byte) 0;
        }
    }

    @Override // com.aliyun.svideosdk.crop.AliyunICrop
    public long getVideoDuration(java.lang.String str) throws java.lang.Exception {
        com.aliyun.svideosdk.transcode.NativeParser nativeParser = new com.aliyun.svideosdk.transcode.NativeParser();
        nativeParser.init(str);
        java.lang.String value = nativeParser.getValue(3);
        nativeParser.release();
        nativeParser.dispose();
        if (value == null || value.isEmpty()) {
            return 0L;
        }
        return java.lang.Long.parseLong(value);
    }

    @Override // com.aliyun.svideosdk.crop.AliyunICrop
    public void setCropCallback(com.aliyun.svideosdk.crop.CropCallback cropCallback) {
        this.b = cropCallback;
        this.d.cb = new com.aliyun.svideosdk.crop.impl.a.d();
    }

    /* JADX WARN: Can't wrap try/catch for region: R(12:32|(2:33|34)|(7:39|40|41|42|43|(1:49)(1:47)|48)|56|57|58|59|42|43|(1:45)|49|48) */
    /* JADX WARN: Code restructure failed: missing block: B:61:0x00d0, code lost:
    
        r7 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:62:0x00d1, code lost:
    
        r8 = r7;
        r7 = r6;
        r6 = 0;
     */
    /* JADX WARN: Removed duplicated region for block: B:45:0x0101  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x018b  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x01e5  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x01f3  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x018d  */
    @Override // com.aliyun.svideosdk.crop.AliyunICrop
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public int setCropParam(com.aliyun.svideosdk.crop.CropParam cropParam) {
        java.lang.String str;
        int i;
        com.aliyun.svideosdk.transcode.NativeTranscode2 nativeTranscode2;
        int a;
        com.aliyun.svideosdk.c.e eVar;
        java.lang.Exception exc;
        int i2;
        int i3;
        int outputHeight;
        int parseInt;
        com.aliyun.common.log.debuglog.AlivcSvideoLog.i("AliYunLog", "AliyunCrop setCropParam");
        if (cropParam == null) {
            str = "AliyunCrop setCropParam failed ,param is null";
        } else {
            int outputWidth = cropParam.getOutputWidth();
            if (outputWidth % 2 != 0) {
                cropParam.setOutputWidth(outputWidth - 1);
            }
            int outputHeight2 = cropParam.getOutputHeight();
            if (outputHeight2 % 2 != 0) {
                cropParam.setOutputHeight(outputHeight2 - 1);
            }
            if (cropParam.getInputPath() != null && new java.io.File(cropParam.getInputPath()).exists() && cropParam.getOutputPath() != null) {
                this.f = cropParam;
                if (cropParam.getMediaType() == com.aliyun.svideosdk.common.struct.common.MediaType.ANY_IMAGE_TYPE) {
                    return 0;
                }
                if (cropParam.getScaleMode().ordinal() == 0) {
                    this.d.cropBackColor = cropParam.getFillColor();
                }
                android.graphics.Rect cropRect = cropParam.getCropRect();
                if (cropRect == null) {
                    cropRect = new android.graphics.Rect();
                }
                if (cropParam.getScaleMode().ordinal() == 0 && cropRect.isEmpty()) {
                    android.media.MediaMetadataRetriever mediaMetadataRetriever = new android.media.MediaMetadataRetriever();
                    mediaMetadataRetriever.setDataSource(cropParam.getInputPath());
                    try {
                        try {
                            parseInt = java.lang.Integer.parseInt(mediaMetadataRetriever.extractMetadata(24));
                        } finally {
                            mediaMetadataRetriever.release();
                        }
                    } catch (java.lang.Exception e2) {
                        exc = e2;
                        i2 = 0;
                    }
                    if (parseInt != 90 && parseInt != 270) {
                        i2 = java.lang.Integer.parseInt(mediaMetadataRetriever.extractMetadata(18));
                        try {
                            i3 = java.lang.Integer.parseInt(mediaMetadataRetriever.extractMetadata(19));
                        } catch (java.lang.Exception e3) {
                            exc = e3;
                            int i4 = 0;
                            com.aliyun.common.log.debuglog.AlivcSvideoLog.e("AliYunLog", "AliyunCrop setCropParam failed  catch exception " + exc.toString());
                            exc.printStackTrace();
                            mediaMetadataRetriever.release();
                            i3 = i4;
                            if (i2 > cropParam.getOutputWidth()) {
                            }
                            float f2 = i2;
                            float f3 = i3;
                            float min = java.lang.Math.min(f2 / cropParam.getOutputWidth(), f3 / cropParam.getOutputHeight());
                            int outputWidth2 = (int) ((((f2 / min) - cropParam.getOutputWidth()) / 2.0f) * min);
                            cropRect.left = outputWidth2;
                            cropRect.right = (int) (outputWidth2 + (cropParam.getOutputWidth() * min));
                            int outputHeight3 = (int) ((((f3 / min) - cropParam.getOutputHeight()) / 2.0f) * min);
                            cropRect.top = outputHeight3;
                            outputHeight = (int) (outputHeight3 + (cropParam.getOutputHeight() * min));
                            cropRect.bottom = outputHeight;
                            this.d.intputPath = cropParam.getInputPath();
                            this.d.outputPath = cropParam.getOutputPath();
                            this.d.cropMode = cropParam.getScaleMode() == com.aliyun.svideosdk.common.struct.common.VideoDisplayMode.FILL ? 0 : 1;
                            com.aliyun.svideosdk.transcode.NativeTranscode2InitStruct nativeTranscode2InitStruct = this.d;
                            int i5 = cropRect.left;
                            nativeTranscode2InitStruct.cropX = i5;
                            int i6 = cropRect.top;
                            nativeTranscode2InitStruct.cropY = i6;
                            nativeTranscode2InitStruct.cropWidth = cropRect.right - i5;
                            nativeTranscode2InitStruct.cropHeight = cropRect.bottom - i6;
                            java.util.concurrent.TimeUnit timeUnit = java.util.concurrent.TimeUnit.MICROSECONDS;
                            nativeTranscode2InitStruct.startTime = cropParam.getStartTime(timeUnit);
                            this.d.endTime = cropParam.getEndTime(timeUnit);
                            this.d.outputWidth = cropParam.getOutputWidth();
                            this.d.outputHeight = cropParam.getOutputHeight();
                            this.c.setExtraParam(com.aliyun.svideosdk.c.d.AudioCodecIdKey.a(), com.aliyun.svideosdk.c.b.SoftAAC.a());
                            i = com.aliyun.svideosdk.crop.impl.a.g.c[this.f.getVideoCodec().ordinal()];
                            if (i != 1) {
                            }
                            nativeTranscode2.setExtraParam(a, eVar.a());
                            this.c.setExtraParam(com.aliyun.svideosdk.c.d.VideoCrfKey.a(), this.f.getCrf());
                            this.c.setExtraParam(com.aliyun.svideosdk.c.d.VideoFpsKey.a(), cropParam.getFrameRate());
                            this.c.setExtraParam(com.aliyun.svideosdk.c.d.VideoGopSizeKey.a(), cropParam.getGop());
                            this.c.setExtraParam(com.aliyun.svideosdk.c.d.VideoQualityKey.a(), cropParam.getQuality().ordinal());
                            this.c.setExtraParam(com.aliyun.svideosdk.c.d.VideoBpsKey.a(), cropParam.getvideobitrate());
                            return 0;
                        }
                        if (i2 > cropParam.getOutputWidth() || i3 <= cropParam.getOutputHeight()) {
                            float f22 = i2;
                            float f32 = i3;
                            float min2 = java.lang.Math.min(f22 / cropParam.getOutputWidth(), f32 / cropParam.getOutputHeight());
                            int outputWidth22 = (int) ((((f22 / min2) - cropParam.getOutputWidth()) / 2.0f) * min2);
                            cropRect.left = outputWidth22;
                            cropRect.right = (int) (outputWidth22 + (cropParam.getOutputWidth() * min2));
                            int outputHeight32 = (int) ((((f32 / min2) - cropParam.getOutputHeight()) / 2.0f) * min2);
                            cropRect.top = outputHeight32;
                            outputHeight = (int) (outputHeight32 + (cropParam.getOutputHeight() * min2));
                        } else {
                            int outputWidth3 = (i2 - cropParam.getOutputWidth()) / 2;
                            cropRect.left = outputWidth3;
                            cropRect.right = outputWidth3 + cropParam.getOutputWidth();
                            int outputHeight4 = (i3 - cropParam.getOutputHeight()) / 2;
                            cropRect.top = outputHeight4;
                            outputHeight = outputHeight4 + cropParam.getOutputHeight();
                        }
                        cropRect.bottom = outputHeight;
                    }
                    int parseInt2 = java.lang.Integer.parseInt(mediaMetadataRetriever.extractMetadata(18));
                    i2 = java.lang.Integer.parseInt(mediaMetadataRetriever.extractMetadata(19));
                    i3 = parseInt2;
                    if (i2 > cropParam.getOutputWidth()) {
                    }
                    float f222 = i2;
                    float f322 = i3;
                    float min22 = java.lang.Math.min(f222 / cropParam.getOutputWidth(), f322 / cropParam.getOutputHeight());
                    int outputWidth222 = (int) ((((f222 / min22) - cropParam.getOutputWidth()) / 2.0f) * min22);
                    cropRect.left = outputWidth222;
                    cropRect.right = (int) (outputWidth222 + (cropParam.getOutputWidth() * min22));
                    int outputHeight322 = (int) ((((f322 / min22) - cropParam.getOutputHeight()) / 2.0f) * min22);
                    cropRect.top = outputHeight322;
                    outputHeight = (int) (outputHeight322 + (cropParam.getOutputHeight() * min22));
                    cropRect.bottom = outputHeight;
                }
                this.d.intputPath = cropParam.getInputPath();
                this.d.outputPath = cropParam.getOutputPath();
                this.d.cropMode = cropParam.getScaleMode() == com.aliyun.svideosdk.common.struct.common.VideoDisplayMode.FILL ? 0 : 1;
                com.aliyun.svideosdk.transcode.NativeTranscode2InitStruct nativeTranscode2InitStruct2 = this.d;
                int i52 = cropRect.left;
                nativeTranscode2InitStruct2.cropX = i52;
                int i62 = cropRect.top;
                nativeTranscode2InitStruct2.cropY = i62;
                nativeTranscode2InitStruct2.cropWidth = cropRect.right - i52;
                nativeTranscode2InitStruct2.cropHeight = cropRect.bottom - i62;
                java.util.concurrent.TimeUnit timeUnit2 = java.util.concurrent.TimeUnit.MICROSECONDS;
                nativeTranscode2InitStruct2.startTime = cropParam.getStartTime(timeUnit2);
                this.d.endTime = cropParam.getEndTime(timeUnit2);
                this.d.outputWidth = cropParam.getOutputWidth();
                this.d.outputHeight = cropParam.getOutputHeight();
                this.c.setExtraParam(com.aliyun.svideosdk.c.d.AudioCodecIdKey.a(), com.aliyun.svideosdk.c.b.SoftAAC.a());
                i = com.aliyun.svideosdk.crop.impl.a.g.c[this.f.getVideoCodec().ordinal()];
                if (i != 1) {
                    if (i == 2) {
                        nativeTranscode2 = this.c;
                        a = com.aliyun.svideosdk.c.d.VideoCodecIdKey.a();
                        eVar = com.aliyun.svideosdk.c.e.ALIVC_CODEC_H264_OPENH264;
                    }
                    this.c.setExtraParam(com.aliyun.svideosdk.c.d.VideoCrfKey.a(), this.f.getCrf());
                    this.c.setExtraParam(com.aliyun.svideosdk.c.d.VideoFpsKey.a(), cropParam.getFrameRate());
                    this.c.setExtraParam(com.aliyun.svideosdk.c.d.VideoGopSizeKey.a(), cropParam.getGop());
                    this.c.setExtraParam(com.aliyun.svideosdk.c.d.VideoQualityKey.a(), cropParam.getQuality().ordinal());
                    this.c.setExtraParam(com.aliyun.svideosdk.c.d.VideoBpsKey.a(), cropParam.getvideobitrate());
                    return 0;
                }
                nativeTranscode2 = this.c;
                a = com.aliyun.svideosdk.c.d.VideoCodecIdKey.a();
                eVar = com.aliyun.svideosdk.c.e.ALIVC_CODEC_H264_HARDWARE;
                nativeTranscode2.setExtraParam(a, eVar.a());
                this.c.setExtraParam(com.aliyun.svideosdk.c.d.VideoCrfKey.a(), this.f.getCrf());
                this.c.setExtraParam(com.aliyun.svideosdk.c.d.VideoFpsKey.a(), cropParam.getFrameRate());
                this.c.setExtraParam(com.aliyun.svideosdk.c.d.VideoGopSizeKey.a(), cropParam.getGop());
                this.c.setExtraParam(com.aliyun.svideosdk.c.d.VideoQualityKey.a(), cropParam.getQuality().ordinal());
                this.c.setExtraParam(com.aliyun.svideosdk.c.d.VideoBpsKey.a(), cropParam.getvideobitrate());
                return 0;
            }
            str = "AliyunCrop setCropParam failed ,input path " + cropParam.getInputPath() + " output path " + cropParam.getOutputPath();
        }
        com.aliyun.common.log.debuglog.AlivcSvideoLog.e("AliYunLog", str);
        return -20010002;
    }

    @Override // com.aliyun.svideosdk.crop.AliyunICrop
    public void setUseHW(boolean z) {
        com.aliyun.common.log.debuglog.AlivcSvideoLog.i("AliYunLog", "AliyunCrop setUseHW:" + z);
        this.d.useHWDecoder = z;
    }

    @Override // com.aliyun.svideosdk.crop.AliyunICrop
    public int startCrop() {
        com.aliyun.common.log.debuglog.AlivcSvideoLog.i("AliYunLog", "Call start crop");
        com.aliyun.svideosdk.crop.CropParam cropParam = this.f;
        if (cropParam == null) {
            return a(-20010002);
        }
        int i = com.aliyun.svideosdk.crop.impl.a.g.a[cropParam.getMediaType().ordinal()];
        if (i == 1) {
            return com.aliyun.svideosdk.common.a.a(a(this.f.getInputPath(), this.f.getOutputPath(), this.f.getCropRect()));
        }
        if (i != 2) {
            return i != 3 ? a(-20004004) : com.aliyun.svideosdk.common.a.a(a(true));
        }
        java.lang.String inputPath = this.f.getInputPath();
        java.lang.String outputPath = this.f.getOutputPath();
        com.aliyun.svideosdk.crop.CropParam cropParam2 = this.f;
        java.util.concurrent.TimeUnit timeUnit = java.util.concurrent.TimeUnit.MICROSECONDS;
        return com.aliyun.svideosdk.common.a.a(startCropAudio(inputPath, outputPath, cropParam2.getStartTime(timeUnit), this.f.getEndTime(timeUnit)));
    }

    @Override // com.aliyun.svideosdk.crop.AliyunICrop
    public int startCropAudio(java.lang.String str, java.lang.String str2, long j, long j2) {
        return startCropAudio(str, str2, j, j2, java.util.concurrent.TimeUnit.MICROSECONDS);
    }

    @Override // com.aliyun.svideosdk.crop.AliyunICrop
    public int startCropAudio(java.lang.String str, java.lang.String str2, long j, long j2, java.util.concurrent.TimeUnit timeUnit) {
        if (str == null || !new java.io.File(str).exists()) {
            return a(-20002003);
        }
        if (str2 == null) {
            return a(-20003021);
        }
        com.aliyun.svideosdk.crop.CropParam cropParam = new com.aliyun.svideosdk.crop.CropParam();
        cropParam.setInputPath(str);
        cropParam.setOutputPath(str2);
        cropParam.setStartTime(j, timeUnit);
        cropParam.setEndTime(j2, timeUnit);
        int cropParam2 = setCropParam(cropParam);
        return cropParam2 != 0 ? a(cropParam2) : com.aliyun.svideosdk.common.a.a(a(false));
    }

    @Override // com.aliyun.svideosdk.crop.AliyunICrop
    public java.lang.String version() {
        return com.aliyun.common.global.Version.VERSION;
    }
}
