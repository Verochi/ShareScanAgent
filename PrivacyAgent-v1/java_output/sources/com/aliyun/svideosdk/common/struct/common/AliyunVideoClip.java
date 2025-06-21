package com.aliyun.svideosdk.common.struct.common;

@com.aliyun.Visible
/* loaded from: classes12.dex */
public class AliyunVideoClip extends com.aliyun.svideosdk.common.struct.common.AliyunClip {
    private long mDuration;
    private long mEndTime;
    private int mRotation;
    private long mStartTime;

    @com.aliyun.Visible
    public static final class Builder {
        private com.aliyun.svideosdk.common.struct.common.AliyunVideoClip mClip;

        public Builder() {
            com.aliyun.svideosdk.common.struct.common.AliyunVideoClip aliyunVideoClip = new com.aliyun.svideosdk.common.struct.common.AliyunVideoClip(null);
            this.mClip = aliyunVideoClip;
            aliyunVideoClip.setMediaType(com.aliyun.svideosdk.common.struct.common.MediaType.ANY_VIDEO_TYPE);
        }

        /* JADX WARN: Removed duplicated region for block: B:19:0x00bd  */
        /* JADX WARN: Removed duplicated region for block: B:22:0x00cb  */
        /* JADX WARN: Removed duplicated region for block: B:27:0x00e7  */
        /* JADX WARN: Removed duplicated region for block: B:43:0x00af  */
        /* JADX WARN: Removed duplicated region for block: B:54:0x0116  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public com.aliyun.svideosdk.common.struct.common.AliyunVideoClip build() {
            android.media.MediaMetadataRetriever mediaMetadataRetriever;
            int i;
            int i2;
            com.aliyun.svideosdk.transcode.NativeParser nativeParser;
            long j;
            long j2;
            android.media.MediaMetadataRetriever mediaMetadataRetriever2 = null;
            if (android.text.TextUtils.isEmpty(this.mClip.getSource())) {
                return null;
            }
            int i3 = 0;
            try {
                mediaMetadataRetriever = new android.media.MediaMetadataRetriever();
                try {
                    try {
                        mediaMetadataRetriever.setDataSource(this.mClip.getSource());
                        i = java.lang.Integer.parseInt(mediaMetadataRetriever.extractMetadata(18));
                        try {
                            i2 = java.lang.Integer.parseInt(mediaMetadataRetriever.extractMetadata(19));
                        } catch (java.lang.Exception unused) {
                            i2 = 0;
                            try {
                                nativeParser = new com.aliyun.svideosdk.transcode.NativeParser();
                                nativeParser.init(this.mClip.getSource());
                                try {
                                    try {
                                        i = java.lang.Integer.parseInt(nativeParser.getValue(6));
                                        i2 = java.lang.Integer.parseInt(nativeParser.getValue(7));
                                        i3 = java.lang.Integer.parseInt(nativeParser.getValue(14));
                                        j = java.lang.Long.parseLong(nativeParser.getValue(3));
                                        nativeParser.release();
                                    } catch (java.lang.Exception unused2) {
                                        nativeParser.release();
                                        j = 0;
                                    }
                                    nativeParser.dispose();
                                    if (mediaMetadataRetriever != null) {
                                        mediaMetadataRetriever.release();
                                    }
                                    j2 = j;
                                    if (this.mClip.getEndTime() <= 0) {
                                    }
                                    if (i3 != 90) {
                                    }
                                    com.aliyun.svideosdk.common.struct.common.AliyunVideoClip aliyunVideoClip = this.mClip;
                                    aliyunVideoClip.mClipHeight = i;
                                    aliyunVideoClip.mClipWidth = i2;
                                    if (this.mClip.mDuration != 0) {
                                        com.aliyun.svideosdk.common.struct.common.AliyunVideoClip aliyunVideoClip2 = this.mClip;
                                        aliyunVideoClip2.mEndTime = aliyunVideoClip2.mStartTime + this.mClip.mDuration;
                                    }
                                    return this.mClip;
                                } catch (java.lang.Throwable th) {
                                    nativeParser.release();
                                    nativeParser.dispose();
                                    throw th;
                                }
                            } catch (java.lang.Throwable th2) {
                                th = th2;
                                mediaMetadataRetriever2 = mediaMetadataRetriever;
                                mediaMetadataRetriever = mediaMetadataRetriever2;
                                if (mediaMetadataRetriever != null) {
                                    mediaMetadataRetriever.release();
                                }
                                throw th;
                            }
                        }
                    } catch (java.lang.Exception unused3) {
                        i = 0;
                        i2 = 0;
                        nativeParser = new com.aliyun.svideosdk.transcode.NativeParser();
                        nativeParser.init(this.mClip.getSource());
                        i = java.lang.Integer.parseInt(nativeParser.getValue(6));
                        i2 = java.lang.Integer.parseInt(nativeParser.getValue(7));
                        i3 = java.lang.Integer.parseInt(nativeParser.getValue(14));
                        j = java.lang.Long.parseLong(nativeParser.getValue(3));
                        nativeParser.release();
                        nativeParser.dispose();
                        if (mediaMetadataRetriever != null) {
                        }
                        j2 = j;
                        if (this.mClip.getEndTime() <= 0) {
                        }
                        if (i3 != 90) {
                        }
                        com.aliyun.svideosdk.common.struct.common.AliyunVideoClip aliyunVideoClip3 = this.mClip;
                        aliyunVideoClip3.mClipHeight = i;
                        aliyunVideoClip3.mClipWidth = i2;
                        if (this.mClip.mDuration != 0) {
                        }
                        return this.mClip;
                    }
                    try {
                        i3 = java.lang.Integer.parseInt(mediaMetadataRetriever.extractMetadata(24));
                        j2 = java.lang.Long.parseLong(mediaMetadataRetriever.extractMetadata(9) + "000");
                        mediaMetadataRetriever.release();
                    } catch (java.lang.Exception unused4) {
                        nativeParser = new com.aliyun.svideosdk.transcode.NativeParser();
                        nativeParser.init(this.mClip.getSource());
                        i = java.lang.Integer.parseInt(nativeParser.getValue(6));
                        i2 = java.lang.Integer.parseInt(nativeParser.getValue(7));
                        i3 = java.lang.Integer.parseInt(nativeParser.getValue(14));
                        j = java.lang.Long.parseLong(nativeParser.getValue(3));
                        nativeParser.release();
                        nativeParser.dispose();
                        if (mediaMetadataRetriever != null) {
                        }
                        j2 = j;
                        if (this.mClip.getEndTime() <= 0) {
                        }
                        if (i3 != 90) {
                        }
                        com.aliyun.svideosdk.common.struct.common.AliyunVideoClip aliyunVideoClip32 = this.mClip;
                        aliyunVideoClip32.mClipHeight = i;
                        aliyunVideoClip32.mClipWidth = i2;
                        if (this.mClip.mDuration != 0) {
                        }
                        return this.mClip;
                    }
                } catch (java.lang.Throwable th3) {
                    th = th3;
                    if (mediaMetadataRetriever != null) {
                    }
                    throw th;
                }
            } catch (java.lang.Exception unused5) {
                mediaMetadataRetriever = null;
            } catch (java.lang.Throwable th4) {
                th = th4;
                mediaMetadataRetriever = mediaMetadataRetriever2;
                if (mediaMetadataRetriever != null) {
                }
                throw th;
            }
            if (this.mClip.getEndTime() <= 0) {
                this.mClip.setEndTime(com.aliyun.common.media.TimeUnitUtil.microsToMills(j2));
            }
            if (i3 != 90 || i3 == 270) {
                com.aliyun.svideosdk.common.struct.common.AliyunVideoClip aliyunVideoClip322 = this.mClip;
                aliyunVideoClip322.mClipHeight = i;
                aliyunVideoClip322.mClipWidth = i2;
            } else {
                com.aliyun.svideosdk.common.struct.common.AliyunVideoClip aliyunVideoClip4 = this.mClip;
                aliyunVideoClip4.mClipWidth = i;
                aliyunVideoClip4.mClipHeight = i2;
            }
            if (this.mClip.mDuration != 0 && this.mClip.mStartTime + this.mClip.mDuration > this.mClip.mEndTime) {
                com.aliyun.svideosdk.common.struct.common.AliyunVideoClip aliyunVideoClip22 = this.mClip;
                aliyunVideoClip22.mEndTime = aliyunVideoClip22.mStartTime + this.mClip.mDuration;
            }
            return this.mClip;
        }

        public com.aliyun.svideosdk.common.struct.common.AliyunVideoClip.Builder displayMode(com.aliyun.svideosdk.common.struct.common.AliyunDisplayMode aliyunDisplayMode) {
            this.mClip.setDisplayMode(aliyunDisplayMode);
            return this;
        }

        public com.aliyun.svideosdk.common.struct.common.AliyunVideoClip.Builder duration(long j) {
            this.mClip.setDuration(j);
            return this;
        }

        public com.aliyun.svideosdk.common.struct.common.AliyunVideoClip.Builder endTime(long j) {
            this.mClip.setEndTime(j);
            return this;
        }

        public com.aliyun.svideosdk.common.struct.common.AliyunVideoClip.Builder id(int i) {
            this.mClip.setId(i);
            return this;
        }

        public com.aliyun.svideosdk.common.struct.common.AliyunVideoClip.Builder rotation(int i) {
            this.mClip.setRotation(i);
            return this;
        }

        public com.aliyun.svideosdk.common.struct.common.AliyunVideoClip.Builder source(java.lang.String str) {
            this.mClip.setSource(str);
            return this;
        }

        public com.aliyun.svideosdk.common.struct.common.AliyunVideoClip.Builder startTime(long j) {
            this.mClip.setStartTime(j);
            return this;
        }

        public com.aliyun.svideosdk.common.struct.common.AliyunVideoClip.Builder transition(com.aliyun.svideosdk.common.struct.effect.TransitionBase transitionBase) {
            this.mClip.setTransition(transitionBase);
            return this;
        }
    }

    private AliyunVideoClip() {
        this.mStartTime = 0L;
        this.mEndTime = 0L;
        this.mRotation = -1;
    }

    public /* synthetic */ AliyunVideoClip(com.aliyun.svideosdk.common.struct.common.AliyunVideoClip.AnonymousClass1 anonymousClass1) {
        this();
    }

    public long getDuration() {
        return this.mDuration;
    }

    public long getEndTime() {
        return this.mEndTime;
    }

    public int getRotation() {
        return this.mRotation;
    }

    public long getStartTime() {
        return this.mStartTime;
    }

    public int getVideoHeight() {
        return getClipHeight();
    }

    public int getVideoWidth() {
        return getClipWidth();
    }

    public void setDuration(long j) {
        this.mDuration = java.lang.Math.max(j, 0L);
    }

    public void setEndTime(long j) {
        this.mEndTime = java.lang.Math.max(j, 0L);
    }

    public void setRotation(int i) {
        this.mRotation = i;
    }

    public void setStartTime(long j) {
        this.mStartTime = java.lang.Math.max(j, 0L);
    }
}
