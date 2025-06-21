package com.otaliastudios.cameraview.internal;

/* loaded from: classes19.dex */
public class DeviceEncoders {
    public static final int MODE_PREFER_HARDWARE = 1;
    public static final int MODE_RESPECT_ORDER = 0;
    public static final com.otaliastudios.cameraview.CameraLogger e = com.otaliastudios.cameraview.CameraLogger.create(com.otaliastudios.cameraview.internal.DeviceEncoders.class.getSimpleName());

    @androidx.annotation.VisibleForTesting
    public static boolean f = true;
    public final android.media.MediaCodecInfo a;
    public final android.media.MediaCodecInfo b;
    public final android.media.MediaCodecInfo.VideoCapabilities c;
    public final android.media.MediaCodecInfo.AudioCapabilities d;

    /* renamed from: com.otaliastudios.cameraview.internal.DeviceEncoders$1, reason: invalid class name */
    public class AnonymousClass1 implements java.util.Comparator<android.media.MediaCodecInfo> {
        public AnonymousClass1() {
        }

        @Override // java.util.Comparator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(android.media.MediaCodecInfo mediaCodecInfo, android.media.MediaCodecInfo mediaCodecInfo2) {
            return java.lang.Boolean.compare(com.otaliastudios.cameraview.internal.DeviceEncoders.this.c(mediaCodecInfo2.getName()), com.otaliastudios.cameraview.internal.DeviceEncoders.this.c(mediaCodecInfo.getName()));
        }
    }

    public class AudioException extends java.lang.RuntimeException {
        private AudioException(@androidx.annotation.NonNull java.lang.String str) {
            super(str);
        }

        public /* synthetic */ AudioException(com.otaliastudios.cameraview.internal.DeviceEncoders deviceEncoders, java.lang.String str, com.otaliastudios.cameraview.internal.DeviceEncoders.AnonymousClass1 anonymousClass1) {
            this(str);
        }
    }

    public class VideoException extends java.lang.RuntimeException {
        private VideoException(@androidx.annotation.NonNull java.lang.String str) {
            super(str);
        }

        public /* synthetic */ VideoException(com.otaliastudios.cameraview.internal.DeviceEncoders deviceEncoders, java.lang.String str, com.otaliastudios.cameraview.internal.DeviceEncoders.AnonymousClass1 anonymousClass1) {
            this(str);
        }
    }

    @android.annotation.SuppressLint({"NewApi"})
    public DeviceEncoders(int i, @androidx.annotation.NonNull java.lang.String str, @androidx.annotation.NonNull java.lang.String str2, int i2, int i3) {
        if (!f) {
            this.a = null;
            this.b = null;
            this.c = null;
            this.d = null;
            e.i("Disabled.");
            return;
        }
        java.util.List<android.media.MediaCodecInfo> b = b();
        android.media.MediaCodecInfo a = a(b, str, i, i2);
        this.a = a;
        com.otaliastudios.cameraview.CameraLogger cameraLogger = e;
        cameraLogger.i("Enabled. Found video encoder:", a.getName());
        android.media.MediaCodecInfo a2 = a(b, str2, i, i3);
        this.b = a2;
        cameraLogger.i("Enabled. Found audio encoder:", a2.getName());
        this.c = a.getCapabilitiesForType(str).getVideoCapabilities();
        this.d = a2.getCapabilitiesForType(str2).getAudioCapabilities();
    }

    @androidx.annotation.NonNull
    @android.annotation.SuppressLint({"NewApi"})
    @androidx.annotation.VisibleForTesting
    public android.media.MediaCodecInfo a(@androidx.annotation.NonNull java.util.List<android.media.MediaCodecInfo> list, @androidx.annotation.NonNull java.lang.String str, int i, int i2) {
        java.util.ArrayList arrayList = new java.util.ArrayList();
        java.util.Iterator<android.media.MediaCodecInfo> it = list.iterator();
        while (true) {
            int i3 = 0;
            if (!it.hasNext()) {
                break;
            }
            android.media.MediaCodecInfo next = it.next();
            java.lang.String[] supportedTypes = next.getSupportedTypes();
            int length = supportedTypes.length;
            while (true) {
                if (i3 >= length) {
                    break;
                }
                if (supportedTypes[i3].equalsIgnoreCase(str)) {
                    arrayList.add(next);
                    break;
                }
                i3++;
            }
        }
        e.i("findDeviceEncoder -", "type:", str, "encoders:", java.lang.Integer.valueOf(arrayList.size()));
        if (i == 1) {
            java.util.Collections.sort(arrayList, new com.otaliastudios.cameraview.internal.DeviceEncoders.AnonymousClass1());
        }
        if (arrayList.size() >= i2 + 1) {
            return (android.media.MediaCodecInfo) arrayList.get(i2);
        }
        throw new java.lang.RuntimeException("No encoders for type:" + str);
    }

    @androidx.annotation.NonNull
    @android.annotation.SuppressLint({"NewApi"})
    @androidx.annotation.VisibleForTesting
    public java.util.List<android.media.MediaCodecInfo> b() {
        java.util.ArrayList arrayList = new java.util.ArrayList();
        for (android.media.MediaCodecInfo mediaCodecInfo : new android.media.MediaCodecList(0).getCodecInfos()) {
            if (mediaCodecInfo.isEncoder()) {
                arrayList.add(mediaCodecInfo);
            }
        }
        return arrayList;
    }

    @android.annotation.SuppressLint({"NewApi"})
    @androidx.annotation.VisibleForTesting
    public boolean c(@androidx.annotation.NonNull java.lang.String str) {
        java.lang.String lowerCase = str.toLowerCase();
        return !(lowerCase.startsWith("omx.google.") || lowerCase.startsWith("c2.android.") || !(lowerCase.startsWith("omx.") || lowerCase.startsWith("c2.")));
    }

    @androidx.annotation.Nullable
    @android.annotation.SuppressLint({"NewApi"})
    public java.lang.String getAudioEncoder() {
        android.media.MediaCodecInfo mediaCodecInfo = this.b;
        if (mediaCodecInfo != null) {
            return mediaCodecInfo.getName();
        }
        return null;
    }

    @android.annotation.SuppressLint({"NewApi"})
    public int getSupportedAudioBitRate(int i) {
        if (!f) {
            return i;
        }
        int intValue = this.d.getBitrateRange().clamp(java.lang.Integer.valueOf(i)).intValue();
        e.i("getSupportedAudioBitRate -", "inputRate:", java.lang.Integer.valueOf(i), "adjustedRate:", java.lang.Integer.valueOf(intValue));
        return intValue;
    }

    @android.annotation.SuppressLint({"NewApi"})
    public int getSupportedVideoBitRate(int i) {
        if (!f) {
            return i;
        }
        int intValue = this.c.getBitrateRange().clamp(java.lang.Integer.valueOf(i)).intValue();
        e.i("getSupportedVideoBitRate -", "inputRate:", java.lang.Integer.valueOf(i), "adjustedRate:", java.lang.Integer.valueOf(intValue));
        return intValue;
    }

    @android.annotation.SuppressLint({"NewApi"})
    public int getSupportedVideoFrameRate(@androidx.annotation.NonNull com.otaliastudios.cameraview.size.Size size, int i) {
        if (!f) {
            return i;
        }
        int doubleValue = (int) this.c.getSupportedFrameRatesFor(size.getWidth(), size.getHeight()).clamp(java.lang.Double.valueOf(i)).doubleValue();
        e.i("getSupportedVideoFrameRate -", "inputRate:", java.lang.Integer.valueOf(i), "adjustedRate:", java.lang.Integer.valueOf(doubleValue));
        return doubleValue;
    }

    @androidx.annotation.NonNull
    @android.annotation.SuppressLint({"NewApi"})
    public com.otaliastudios.cameraview.size.Size getSupportedVideoSize(@androidx.annotation.NonNull com.otaliastudios.cameraview.size.Size size) {
        if (!f) {
            return size;
        }
        int width = size.getWidth();
        int height = size.getHeight();
        double d = width / height;
        com.otaliastudios.cameraview.CameraLogger cameraLogger = e;
        cameraLogger.i("getSupportedVideoSize - started. width:", java.lang.Integer.valueOf(width), "height:", java.lang.Integer.valueOf(height));
        if (this.c.getSupportedWidths().getUpper().intValue() < width) {
            width = this.c.getSupportedWidths().getUpper().intValue();
            height = (int) java.lang.Math.round(width / d);
            cameraLogger.i("getSupportedVideoSize - exceeds maxWidth! width:", java.lang.Integer.valueOf(width), "height:", java.lang.Integer.valueOf(height));
        }
        if (this.c.getSupportedHeights().getUpper().intValue() < height) {
            height = this.c.getSupportedHeights().getUpper().intValue();
            width = (int) java.lang.Math.round(height * d);
            cameraLogger.i("getSupportedVideoSize - exceeds maxHeight! width:", java.lang.Integer.valueOf(width), "height:", java.lang.Integer.valueOf(height));
        }
        while (width % this.c.getWidthAlignment() != 0) {
            width--;
        }
        while (height % this.c.getHeightAlignment() != 0) {
            height--;
        }
        e.i("getSupportedVideoSize - aligned. width:", java.lang.Integer.valueOf(width), "height:", java.lang.Integer.valueOf(height));
        if (!this.c.getSupportedWidths().contains((android.util.Range<java.lang.Integer>) java.lang.Integer.valueOf(width))) {
            throw new com.otaliastudios.cameraview.internal.DeviceEncoders.VideoException(this, "Width not supported after adjustment. Desired:" + width + " Range:" + this.c.getSupportedWidths(), null);
        }
        if (!this.c.getSupportedHeights().contains((android.util.Range<java.lang.Integer>) java.lang.Integer.valueOf(height))) {
            throw new com.otaliastudios.cameraview.internal.DeviceEncoders.VideoException(this, "Height not supported after adjustment. Desired:" + height + " Range:" + this.c.getSupportedHeights(), null);
        }
        try {
            if (!this.c.getSupportedHeightsFor(width).contains((android.util.Range<java.lang.Integer>) java.lang.Integer.valueOf(height))) {
                int intValue = this.c.getSupportedWidths().getLower().intValue();
                int widthAlignment = this.c.getWidthAlignment();
                int i = width;
                while (i >= intValue) {
                    i -= 32;
                    while (i % widthAlignment != 0) {
                        i--;
                    }
                    int round = (int) java.lang.Math.round(i / d);
                    if (this.c.getSupportedHeightsFor(i).contains((android.util.Range<java.lang.Integer>) java.lang.Integer.valueOf(round))) {
                        e.w("getSupportedVideoSize - restarting with smaller size.");
                        return getSupportedVideoSize(new com.otaliastudios.cameraview.size.Size(i, round));
                    }
                }
            }
        } catch (java.lang.IllegalArgumentException unused) {
        }
        if (this.c.isSizeSupported(width, height)) {
            return new com.otaliastudios.cameraview.size.Size(width, height);
        }
        throw new com.otaliastudios.cameraview.internal.DeviceEncoders.VideoException(this, "Size not supported for unknown reason. Might be an aspect ratio issue. Desired size:" + new com.otaliastudios.cameraview.size.Size(width, height), null);
    }

    @androidx.annotation.Nullable
    @android.annotation.SuppressLint({"NewApi"})
    public java.lang.String getVideoEncoder() {
        android.media.MediaCodecInfo mediaCodecInfo = this.a;
        if (mediaCodecInfo != null) {
            return mediaCodecInfo.getName();
        }
        return null;
    }

    /* JADX WARN: Removed duplicated region for block: B:28:0x0052 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    @android.annotation.SuppressLint({"NewApi"})
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void tryConfigureAudio(@androidx.annotation.NonNull java.lang.String str, int i, int i2, int i3) {
        android.media.MediaCodec mediaCodec;
        if (this.b == null) {
            return;
        }
        android.media.MediaCodec mediaCodec2 = null;
        try {
            android.media.MediaFormat createAudioFormat = android.media.MediaFormat.createAudioFormat(str, i2, i3);
            createAudioFormat.setInteger("channel-mask", i3 == 2 ? 12 : 16);
            createAudioFormat.setInteger(tv.danmaku.ijk.media.player.IjkMediaMeta.IJKM_KEY_BITRATE, i);
            mediaCodec = android.media.MediaCodec.createByCodecName(this.b.getName());
            try {
                try {
                    mediaCodec.configure(createAudioFormat, (android.view.Surface) null, (android.media.MediaCrypto) null, 1);
                    try {
                        mediaCodec.release();
                    } catch (java.lang.Exception unused) {
                    }
                } catch (java.lang.Exception e2) {
                    e = e2;
                    throw new com.otaliastudios.cameraview.internal.DeviceEncoders.AudioException(this, "Failed to configure video audio: " + e.getMessage(), null);
                }
            } catch (java.lang.Throwable th) {
                th = th;
                mediaCodec2 = mediaCodec;
                if (mediaCodec2 != null) {
                    try {
                        mediaCodec2.release();
                    } catch (java.lang.Exception unused2) {
                    }
                }
                throw th;
            }
        } catch (java.lang.Exception e3) {
            e = e3;
            mediaCodec = null;
        } catch (java.lang.Throwable th2) {
            th = th2;
            if (mediaCodec2 != null) {
            }
            throw th;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:24:0x005f A[EXC_TOP_SPLITTER, SYNTHETIC] */
    @android.annotation.SuppressLint({"NewApi"})
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void tryConfigureVideo(@androidx.annotation.NonNull java.lang.String str, @androidx.annotation.NonNull com.otaliastudios.cameraview.size.Size size, int i, int i2) {
        android.media.MediaCodec mediaCodec;
        if (this.a == null) {
            return;
        }
        android.media.MediaCodec mediaCodec2 = null;
        try {
            android.media.MediaFormat createVideoFormat = android.media.MediaFormat.createVideoFormat(str, size.getWidth(), size.getHeight());
            createVideoFormat.setInteger("color-format", 2130708361);
            createVideoFormat.setInteger(tv.danmaku.ijk.media.player.IjkMediaMeta.IJKM_KEY_BITRATE, i2);
            createVideoFormat.setInteger("frame-rate", i);
            createVideoFormat.setInteger("i-frame-interval", 1);
            mediaCodec = android.media.MediaCodec.createByCodecName(this.a.getName());
            try {
                try {
                    mediaCodec.configure(createVideoFormat, (android.view.Surface) null, (android.media.MediaCrypto) null, 1);
                    try {
                        mediaCodec.release();
                    } catch (java.lang.Exception unused) {
                    }
                } catch (java.lang.Exception e2) {
                    e = e2;
                    throw new com.otaliastudios.cameraview.internal.DeviceEncoders.VideoException(this, "Failed to configure video codec: " + e.getMessage(), null);
                }
            } catch (java.lang.Throwable th) {
                th = th;
                mediaCodec2 = mediaCodec;
                if (mediaCodec2 != null) {
                    try {
                        mediaCodec2.release();
                    } catch (java.lang.Exception unused2) {
                    }
                }
                throw th;
            }
        } catch (java.lang.Exception e3) {
            e = e3;
            mediaCodec = null;
        } catch (java.lang.Throwable th2) {
            th = th2;
            if (mediaCodec2 != null) {
            }
            throw th;
        }
    }
}
