package com.aliyun.svideo.editor;

/* loaded from: classes31.dex */
public class Transcoder {
    private static final int GOP = 35;
    private static final int HEIGHT = 1080;
    private static final java.lang.String TAG = "Transcoder";
    private static final int WIDTH = 1920;
    private com.aliyun.svideosdk.crop.AliyunICrop mAliyunCrop;
    private com.aliyun.svideo.editor.Transcoder.TransCallback mTransCallback;
    private android.os.AsyncTask<java.lang.Void, java.lang.Long, java.util.List<com.aliyun.svideo.media.MediaInfo>> mTranscodeTask;
    private java.util.ArrayList<com.aliyun.svideo.media.MediaInfo> mOriginalVideos = new java.util.ArrayList<>();
    private java.util.concurrent.CopyOnWriteArrayList<com.aliyun.svideosdk.crop.CropParam> mTranscodeVideos = new java.util.concurrent.CopyOnWriteArrayList<>();
    private int mTranscodeIndex = 0;
    private int mTranscodeTotal = 0;
    private java.util.List<java.lang.String> mConvertFilePaths = new java.util.concurrent.CopyOnWriteArrayList();
    private com.aliyun.svideosdk.crop.CropCallback mTranscodeCallback = new com.aliyun.svideo.editor.Transcoder.AnonymousClass2();

    /* renamed from: com.aliyun.svideo.editor.Transcoder$1, reason: invalid class name */
    /* loaded from: classes12.dex */
    public class AnonymousClass1 extends android.os.AsyncTask<java.lang.Void, java.lang.Long, java.util.List<com.aliyun.svideo.media.MediaInfo>> {
        final /* synthetic */ android.content.Context val$context;
        final /* synthetic */ com.aliyun.svideosdk.common.struct.common.VideoDisplayMode val$scaleMode;
        final /* synthetic */ boolean val$transcode;

        public AnonymousClass1(boolean z, android.content.Context context, com.aliyun.svideosdk.common.struct.common.VideoDisplayMode videoDisplayMode) {
            this.val$transcode = z;
            this.val$context = context;
            this.val$scaleMode = videoDisplayMode;
        }

        @Override // android.os.AsyncTask
        public java.util.List<com.aliyun.svideo.media.MediaInfo> doInBackground(java.lang.Void... voidArr) {
            com.aliyun.svideo.editor.Transcoder transcoder = com.aliyun.svideo.editor.Transcoder.this;
            transcoder.checkHEIFImages(transcoder.mOriginalVideos);
            if (this.val$transcode) {
                java.util.Iterator it = com.aliyun.svideo.editor.Transcoder.this.mOriginalVideos.iterator();
                com.aliyun.svideosdk.crop.CropParam cropParam = null;
                while (it.hasNext()) {
                    com.aliyun.svideo.media.MediaInfo mediaInfo = (com.aliyun.svideo.media.MediaInfo) it.next();
                    if (!mediaInfo.filePath.endsWith("gif") && !mediaInfo.filePath.endsWith("GIF")) {
                        if (mediaInfo.mimeType.startsWith("video")) {
                            cropParam = com.aliyun.svideo.editor.Transcoder.this.loadVideoCropInfo(this.val$context, mediaInfo, this.val$scaleMode);
                        } else if (mediaInfo.mimeType.startsWith("image")) {
                            cropParam = com.aliyun.svideo.editor.Transcoder.this.loadImageCropInfo(this.val$context, mediaInfo, this.val$scaleMode);
                        }
                        if (cropParam != null) {
                            com.aliyun.svideo.editor.Transcoder.this.mTranscodeVideos.add(cropParam);
                            com.aliyun.svideo.editor.Transcoder.this.mTranscodeTotal++;
                        }
                        if (isCancelled()) {
                            return null;
                        }
                    }
                }
            }
            if (isCancelled()) {
                return null;
            }
            if (com.aliyun.svideo.editor.Transcoder.this.mTranscodeVideos.size() > 0) {
                com.aliyun.svideo.editor.Transcoder.this.transcodeVideo(0);
            } else if (com.aliyun.svideo.editor.Transcoder.this.mTransCallback != null) {
                com.aliyun.svideo.editor.Transcoder.this.mTransCallback.onComplete(com.aliyun.svideo.editor.Transcoder.this.mOriginalVideos);
            }
            return null;
        }
    }

    /* renamed from: com.aliyun.svideo.editor.Transcoder$2, reason: invalid class name */
    /* loaded from: classes12.dex */
    public class AnonymousClass2 implements com.aliyun.svideosdk.crop.CropCallback {
        public AnonymousClass2() {
        }

        @Override // com.aliyun.svideosdk.crop.CropCallback
        public void onCancelComplete() {
        }

        @Override // com.aliyun.svideosdk.crop.CropCallback
        public void onComplete(long j) {
            if (com.aliyun.svideo.editor.Transcoder.this.mTranscodeIndex < com.aliyun.svideo.editor.Transcoder.this.mTranscodeVideos.size()) {
                com.aliyun.svideo.editor.Transcoder transcoder = com.aliyun.svideo.editor.Transcoder.this;
                transcoder.transcodeVideo(transcoder.mTranscodeIndex);
            } else if (com.aliyun.svideo.editor.Transcoder.this.mTransCallback != null) {
                com.aliyun.svideo.editor.Transcoder.this.replaceOutputPath();
                com.aliyun.svideo.editor.Transcoder.this.mTransCallback.onComplete(com.aliyun.svideo.editor.Transcoder.this.mOriginalVideos);
            }
        }

        @Override // com.aliyun.svideosdk.crop.CropCallback
        public void onError(int i) {
            if (com.aliyun.svideo.editor.Transcoder.this.mTransCallback != null) {
                com.aliyun.svideo.editor.Transcoder.this.mTransCallback.onError(new java.lang.Throwable("transcode error, error code = " + i), i);
            }
        }

        @Override // com.aliyun.svideosdk.crop.CropCallback
        public void onProgress(int i) {
            int i2 = (int) ((((com.aliyun.svideo.editor.Transcoder.this.mTranscodeIndex - 1) / com.aliyun.svideo.editor.Transcoder.this.mTranscodeTotal) * 100.0f) + (i / com.aliyun.svideo.editor.Transcoder.this.mTranscodeTotal));
            java.lang.StringBuilder sb = new java.lang.StringBuilder();
            sb.append("progress...");
            sb.append(i2);
            if (com.aliyun.svideo.editor.Transcoder.this.mTransCallback != null) {
                com.aliyun.svideo.editor.Transcoder.this.mTransCallback.onProgress(i2);
            }
        }
    }

    /* loaded from: classes12.dex */
    public interface TransCallback {
        void onCancelComplete();

        void onComplete(java.util.List<com.aliyun.svideo.media.MediaInfo> list);

        void onError(java.lang.Throwable th, int i);

        void onProgress(int i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void checkHEIFImages(java.util.List<com.aliyun.svideo.media.MediaInfo> list) {
        for (com.aliyun.svideo.media.MediaInfo mediaInfo : list) {
            if (com.aliyun.svideosdk.common.utils.AliyunSVideoUtils.isHEIFImage(mediaInfo.filePath) && android.os.Build.VERSION.SDK_INT >= 28) {
                java.lang.StringBuilder sb = new java.lang.StringBuilder();
                sb.append("HEIF file ");
                sb.append(mediaInfo.filePath);
                java.lang.StringBuilder sb2 = new java.lang.StringBuilder();
                sb2.append(android.os.Environment.getExternalStorageDirectory().getPath());
                java.lang.String str = java.io.File.separator;
                sb2.append(str);
                sb2.append("DCIM");
                sb2.append(str);
                sb2.append("Camera");
                sb2.append(str);
                sb2.append("editor_temp_");
                sb2.append(java.lang.System.currentTimeMillis());
                sb2.append(".png");
                java.lang.String sb3 = sb2.toString();
                if (com.aliyun.svideosdk.common.utils.AliyunSVideoUtils.convertHEIFImage(mediaInfo.filePath, sb3, android.graphics.Bitmap.CompressFormat.PNG, 100)) {
                    java.lang.StringBuilder sb4 = new java.lang.StringBuilder();
                    sb4.append("convert HEIF image success! ");
                    sb4.append(sb3);
                    mediaInfo.filePath = sb3;
                    this.mConvertFilePaths.add(sb3);
                } else {
                    java.lang.StringBuilder sb5 = new java.lang.StringBuilder();
                    sb5.append("convert HEIF image failed! ");
                    sb5.append(mediaInfo.filePath);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public com.aliyun.svideosdk.crop.CropParam loadImageCropInfo(android.content.Context context, com.aliyun.svideo.media.MediaInfo mediaInfo, com.aliyun.svideosdk.common.struct.common.VideoDisplayMode videoDisplayMode) {
        int min;
        int i;
        android.graphics.BitmapFactory.Options options = new android.graphics.BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        android.graphics.BitmapFactory.decodeFile(mediaInfo.filePath, options);
        int i2 = options.outWidth;
        int i3 = options.outHeight;
        com.aliyun.svideosdk.crop.CropParam cropParam = new com.aliyun.svideosdk.crop.CropParam();
        cropParam.setInputPath(mediaInfo.filePath);
        if (options.outMimeType == null) {
            return null;
        }
        cropParam.setOutputPath(com.aliyun.svideo.base.Constants.SDCardConstants.getCacheDir(context) + java.io.File.separator + java.lang.System.currentTimeMillis() + this.mTranscodeTotal + options.outMimeType.replace("image/", "."));
        if (i2 * i3 <= 4147200) {
            return null;
        }
        if (i2 > i3) {
            i = java.lang.Math.min(WIDTH, 1080);
            min = (int) ((i3 / i2) * i);
        } else {
            min = java.lang.Math.min(WIDTH, 1080);
            i = (int) ((i2 / i3) * min);
        }
        cropParam.setOutputHeight(min);
        cropParam.setOutputWidth(i);
        cropParam.setCropRect(new android.graphics.Rect(0, 0, i2, i3));
        cropParam.setScaleMode(videoDisplayMode);
        cropParam.setQuality(com.aliyun.svideosdk.common.struct.common.VideoQuality.SSD);
        cropParam.setFrameRate(30);
        cropParam.setStartTime(0L);
        cropParam.setEndTime(mediaInfo.duration);
        cropParam.setMediaType(com.aliyun.svideosdk.common.struct.common.MediaType.ANY_IMAGE_TYPE);
        return cropParam;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Can't wrap try/catch for region: R(14:0|1|2|3|4|5|6|7|(7:8|9|10|11|12|13|14)|15|16|17|18|(12:20|(2:22|(1:24)(1:43))(1:44)|25|(1:27)|28|(1:30)|31|(1:34)|35|(1:42)(1:38)|39|40)(1:45)) */
    /* JADX WARN: Code restructure failed: missing block: B:47:0x003d, code lost:
    
        r0 = e;
     */
    /* JADX WARN: Code restructure failed: missing block: B:48:0x0043, code lost:
    
        r0.printStackTrace();
        r6 = 0;
     */
    /* JADX WARN: Removed duplicated region for block: B:20:0x004f  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x0118 A[RETURN] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public com.aliyun.svideosdk.crop.CropParam loadVideoCropInfo(android.content.Context context, com.aliyun.svideo.media.MediaInfo mediaInfo, com.aliyun.svideosdk.common.struct.common.VideoDisplayMode videoDisplayMode) {
        int i;
        int i2;
        int i3;
        int i4;
        int i5;
        int i6;
        com.aliyun.svideosdk.transcode.NativeParser nativeParser;
        try {
            nativeParser = new com.aliyun.svideosdk.transcode.NativeParser();
            nativeParser.init(mediaInfo.filePath);
            try {
                i = java.lang.Integer.parseInt(nativeParser.getValue(14));
            } catch (java.lang.Exception unused) {
                i = 0;
            }
        } catch (java.lang.Exception e) {
            e = e;
            i = 0;
            i2 = 0;
            i3 = 0;
        }
        try {
            i2 = java.lang.Integer.parseInt(nativeParser.getValue(6));
            try {
                i3 = java.lang.Integer.parseInt(nativeParser.getValue(7));
                try {
                    nativeParser.getMaxGopSize();
                    nativeParser.checkBFrame();
                } catch (java.lang.Exception unused2) {
                }
            } catch (java.lang.Exception unused3) {
                i3 = 0;
                nativeParser.release();
                nativeParser.dispose();
                long j = mediaInfo.duration;
                i4 = i2 * i3;
                if (i4 > 2073600) {
                }
            }
        } catch (java.lang.Exception unused4) {
            i2 = 0;
            i3 = 0;
            nativeParser.release();
            nativeParser.dispose();
            long j2 = mediaInfo.duration;
            i4 = i2 * i3;
            if (i4 > 2073600) {
            }
        }
        nativeParser.release();
        nativeParser.dispose();
        long j22 = mediaInfo.duration;
        i4 = i2 * i3;
        if (i4 > 2073600) {
            return null;
        }
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        sb.append("need transcode...path...");
        sb.append(mediaInfo.filePath);
        com.aliyun.svideosdk.crop.CropParam cropParam = new com.aliyun.svideosdk.crop.CropParam();
        cropParam.setInputPath(mediaInfo.filePath);
        cropParam.setOutputPath(com.aliyun.svideo.base.Constants.SDCardConstants.getCacheDir(context) + java.io.File.separator + java.lang.System.currentTimeMillis() + com.aliyun.svideo.base.Constants.SDCardConstants.TRANSCODE_SUFFIX);
        if (i4 <= 2073600) {
            i5 = i2;
            i6 = i3;
        } else if (i2 > i3) {
            i5 = java.lang.Math.max(WIDTH, 1080);
            i6 = (int) ((i3 / i2) * i5);
        } else {
            i6 = java.lang.Math.max(WIDTH, 1080);
            i5 = (int) ((i2 / i3) * i6);
        }
        if (i5 % 2 == 1) {
            i5++;
        }
        if (i6 % 2 == 1) {
            i6++;
        }
        if (i != 90 && i != 270) {
            int i7 = i6;
            i6 = i5;
            i5 = i7;
        }
        cropParam.setOutputHeight(i5 - (i5 % 16));
        cropParam.setOutputWidth(i6);
        if (i == 90 || i == 270) {
            cropParam.setCropRect(new android.graphics.Rect(0, 0, i3, i2));
        } else {
            cropParam.setCropRect(new android.graphics.Rect(0, 0, i2, i3));
        }
        long j3 = mediaInfo.startTime;
        java.util.concurrent.TimeUnit timeUnit = java.util.concurrent.TimeUnit.MILLISECONDS;
        cropParam.setStartTime(j3, timeUnit);
        cropParam.setScaleMode(videoDisplayMode);
        cropParam.setQuality(com.aliyun.svideosdk.common.struct.common.VideoQuality.SSD);
        cropParam.setGop(5);
        cropParam.setFrameRate(30);
        cropParam.setCrf(19);
        cropParam.setVideoCodec(com.aliyun.svideosdk.common.struct.encoder.VideoCodecs.H264_SOFT_OPENH264);
        cropParam.setEndTime(j22 + cropParam.getStartTime(timeUnit), timeUnit);
        cropParam.setMediaType(com.aliyun.svideosdk.common.struct.common.MediaType.ANY_VIDEO_TYPE);
        return cropParam;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void replaceOutputPath() {
        java.util.Iterator<com.aliyun.svideosdk.crop.CropParam> it = this.mTranscodeVideos.iterator();
        while (it.hasNext()) {
            com.aliyun.svideosdk.crop.CropParam next = it.next();
            java.util.Iterator<com.aliyun.svideo.media.MediaInfo> it2 = this.mOriginalVideos.iterator();
            while (it2.hasNext()) {
                com.aliyun.svideo.media.MediaInfo next2 = it2.next();
                if (next.getInputPath().equals(next2.filePath)) {
                    next2.filePath = next.getOutputPath();
                    if (next2.mimeType.contains("video")) {
                        next2.startTime = 0L;
                        java.util.concurrent.TimeUnit timeUnit = java.util.concurrent.TimeUnit.MILLISECONDS;
                        next2.duration = (int) (next.getEndTime(timeUnit) - next.getStartTime(timeUnit));
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void transcodeVideo(int i) {
        this.mTranscodeIndex++;
        com.aliyun.svideosdk.crop.CropParam cropParam = this.mTranscodeVideos.get(i);
        this.mAliyunCrop.setCropParam(cropParam);
        this.mAliyunCrop.setCropCallback(this.mTranscodeCallback);
        this.mAliyunCrop.startCrop();
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        sb.append("log_editor_media_transcode :");
        sb.append(cropParam.getInputPath());
    }

    public void addMedia(int i, com.aliyun.svideo.media.MediaInfo mediaInfo) {
        this.mOriginalVideos.add(i, mediaInfo);
    }

    public void addMedia(com.aliyun.svideo.media.MediaInfo mediaInfo) {
        this.mOriginalVideos.add(mediaInfo);
    }

    public void cancel() {
        this.mTranscodeTask.cancel(true);
        this.mAliyunCrop.cancel();
        com.aliyun.svideo.editor.Transcoder.TransCallback transCallback = this.mTransCallback;
        if (transCallback != null) {
            transCallback.onCancelComplete();
        }
    }

    public java.util.ArrayList<com.aliyun.svideo.media.MediaInfo> getOriginalVideos() {
        return this.mOriginalVideos;
    }

    public int getVideoCount() {
        return this.mOriginalVideos.size();
    }

    public void init(android.content.Context context) {
        this.mAliyunCrop = com.aliyun.svideosdk.crop.impl.AliyunCropCreator.createCropInstance(context);
    }

    public void release() {
        com.aliyun.svideosdk.crop.AliyunICrop aliyunICrop = this.mAliyunCrop;
        if (aliyunICrop != null) {
            aliyunICrop.dispose();
            this.mAliyunCrop = null;
        }
        if (this.mTranscodeCallback != null) {
            this.mTranscodeCallback = null;
        }
        if (this.mTransCallback != null) {
            this.mTransCallback = null;
        }
        try {
            if (this.mConvertFilePaths.size() > 0) {
                for (java.lang.String str : this.mConvertFilePaths) {
                    boolean deleteFile = com.aliyun.common.utils.FileUtils.deleteFile(str);
                    java.lang.StringBuilder sb = new java.lang.StringBuilder();
                    sb.append("delete temp file ");
                    sb.append(str);
                    sb.append(" | ");
                    sb.append(deleteFile);
                }
            }
        } catch (java.lang.Throwable unused) {
        }
    }

    public int removeMedia(com.aliyun.svideo.media.MediaInfo mediaInfo) {
        int i = -1;
        for (int i2 = 0; i2 < this.mOriginalVideos.size(); i2++) {
            if (this.mOriginalVideos.get(i2) == mediaInfo) {
                i = i2;
            }
        }
        if (i == -1) {
            i = this.mOriginalVideos.indexOf(mediaInfo);
        }
        this.mOriginalVideos.remove(i);
        return i;
    }

    public void setTransCallback(com.aliyun.svideo.editor.Transcoder.TransCallback transCallback) {
        this.mTransCallback = transCallback;
    }

    public void swap(int i, int i2) {
        if (i == i2 || i >= this.mOriginalVideos.size() || i2 >= this.mOriginalVideos.size()) {
            return;
        }
        java.util.Collections.swap(this.mOriginalVideos, i, i2);
    }

    public void transcode(android.content.Context context, com.aliyun.svideosdk.common.struct.common.VideoDisplayMode videoDisplayMode, boolean z) {
        this.mTranscodeTotal = 0;
        this.mTranscodeIndex = 0;
        this.mTranscodeVideos.clear();
        if (this.mAliyunCrop == null) {
            return;
        }
        this.mTranscodeTask = new com.aliyun.svideo.editor.Transcoder.AnonymousClass1(z, context, videoDisplayMode).executeOnExecutor(android.os.AsyncTask.THREAD_POOL_EXECUTOR, new java.lang.Void[0]);
    }
}
