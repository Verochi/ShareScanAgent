package com.aliyun.svideosdk.mixrecorder.impl;

/* loaded from: classes12.dex */
class a extends com.aliyun.svideosdk.nativeload.AbstractNativeLoader implements com.aliyun.svideosdk.mixrecorder.AliyunIMixComposer {
    private com.aliyun.svideosdk.mixrecorder.AliyunMixOutputParam b;
    private com.aliyun.svideosdk.mixrecorder.NativeMixComposer a = new com.aliyun.svideosdk.mixrecorder.NativeMixComposer(false, 0);
    private java.util.List<com.aliyun.svideosdk.mixrecorder.AliyunMixTrack> c = new java.util.ArrayList();

    @Override // com.aliyun.svideosdk.mixrecorder.AliyunIMixComposer
    public int cancel() {
        return this.a.a();
    }

    @Override // com.aliyun.svideosdk.mixrecorder.AliyunIMixComposer
    public com.aliyun.svideosdk.mixrecorder.AliyunMixTrack createTrack(com.aliyun.svideosdk.mixrecorder.AliyunMixTrackLayoutParam aliyunMixTrackLayoutParam) {
        if (aliyunMixTrackLayoutParam == null) {
            com.aliyun.common.log.debuglog.AlivcSvideoLog.e("AliYunLog", "Invalid layoutParam!");
            return null;
        }
        com.aliyun.svideosdk.mixrecorder.AliyunMixTrack aliyunMixTrack = new com.aliyun.svideosdk.mixrecorder.AliyunMixTrack();
        this.c.add(aliyunMixTrack);
        aliyunMixTrack.setMixTrackLayoutParam(aliyunMixTrackLayoutParam);
        return aliyunMixTrack;
    }

    @Override // com.aliyun.svideosdk.mixrecorder.AliyunIMixComposer
    public int pause() {
        return this.a.b();
    }

    @Override // com.aliyun.svideosdk.mixrecorder.AliyunIMixComposer
    public int release() {
        int i;
        com.aliyun.svideosdk.mixrecorder.NativeMixComposer nativeMixComposer = this.a;
        if (nativeMixComposer != null) {
            i = nativeMixComposer.c();
            this.a = null;
        } else {
            i = 0;
        }
        java.util.List<com.aliyun.svideosdk.mixrecorder.AliyunMixTrack> list = this.c;
        if (list != null) {
            list.clear();
            this.c = null;
        }
        return i;
    }

    @Override // com.aliyun.svideosdk.mixrecorder.AliyunIMixComposer
    public int resume() {
        return this.a.d();
    }

    @Override // com.aliyun.svideosdk.mixrecorder.AliyunIMixComposer
    public int setBackgroundColor(int i) {
        return this.a.a(i);
    }

    @Override // com.aliyun.svideosdk.mixrecorder.AliyunIMixComposer
    public int setBackgroundImage(android.graphics.Bitmap bitmap, int i) {
        this.a.b(i);
        return this.a.a(bitmap);
    }

    @Override // com.aliyun.svideosdk.mixrecorder.AliyunIMixComposer
    public int setBackgroundImage(java.lang.String str, int i) {
        this.a.b(i);
        return this.a.a(str);
    }

    @Override // com.aliyun.svideosdk.mixrecorder.AliyunIMixComposer
    public int setOutputParam(com.aliyun.svideosdk.mixrecorder.AliyunMixOutputParam aliyunMixOutputParam) {
        if (aliyunMixOutputParam == null) {
            com.aliyun.common.log.debuglog.AlivcSvideoLog.e("AliYunLog", "AliyunMixOutputParam is null!");
            return -20003002;
        }
        this.b = aliyunMixOutputParam;
        return 0;
    }

    @Override // com.aliyun.svideosdk.mixrecorder.AliyunIMixComposer
    public int start(com.aliyun.svideosdk.mixrecorder.AliyunMixCallback aliyunMixCallback) {
        java.lang.String str;
        if (this.b == null) {
            com.aliyun.common.log.debuglog.AlivcSvideoLog.e("AliYunLog", "There's no outputParam!Start mixing failed!");
            return -4;
        }
        java.util.List<com.aliyun.svideosdk.mixrecorder.AliyunMixTrack> list = this.c;
        if (list != null && !list.isEmpty()) {
            java.util.ArrayList<com.aliyun.svideosdk.mixrecorder.AliyunMixTrack> arrayList = new java.util.ArrayList();
            int i = 0;
            int i2 = 0;
            for (com.aliyun.svideosdk.mixrecorder.AliyunMixTrack aliyunMixTrack : this.c) {
                if (i == 0) {
                    i2 = aliyunMixTrack.getTrackId();
                    i++;
                }
                com.aliyun.svideosdk.mixrecorder.AliyunMixTrackLayoutParam mixTrackLayoutParam = aliyunMixTrack.getMixTrackLayoutParam();
                if (mixTrackLayoutParam == null) {
                    str = "track's AliyunMixTrackLayoutParam is null";
                } else {
                    com.aliyun.svideosdk.mixrecorder.AliyunMixStream mixStream = aliyunMixTrack.getMixStream();
                    if (mixStream == null) {
                        str = "track's AliyunMixStream is null, please call AliyunMixTrack.addStream first";
                    } else {
                        int a = this.a.a(mixTrackLayoutParam.getCenterX(), mixTrackLayoutParam.getCenterY(), mixTrackLayoutParam.getWidthRatio(), mixTrackLayoutParam.getHeightRatio(), false);
                        aliyunMixTrack.setTrackId(a);
                        mixStream.setStreamId(this.a.a(mixStream.getFilePath(), a, mixStream.getStreamStartTimeMills() * 1000, mixStream.getStreamEndTimeMills() * 1000, mixStream.getDisplayMode().ordinal()));
                        if (aliyunMixTrack.isAudioOutputTrack()) {
                            if (i == 0) {
                                i2 = aliyunMixTrack.getTrackId();
                                i++;
                            }
                            arrayList.add(aliyunMixTrack);
                        }
                        if (mixTrackLayoutParam.getMixBorderParam() != null) {
                            com.aliyun.common.utils.Assert.assertNotEquals(0, java.lang.Integer.valueOf(this.b.getOutputWidth()));
                            this.a.a(a, (mixTrackLayoutParam.getMixBorderParam().getBorderWidth() * 1.0f) / this.b.getOutputWidth(), mixTrackLayoutParam.getMixBorderParam().getBorderColor(), mixTrackLayoutParam.getMixBorderParam().getCornerRadius() / this.b.getOutputWidth());
                        }
                    }
                }
            }
            com.aliyun.svideosdk.mixrecorder.AliyunMixTrack outputDurationReferenceTrack = this.b.getOutputDurationReferenceTrack();
            int trackId = outputDurationReferenceTrack == null ? 0 : outputDurationReferenceTrack.getTrackId();
            int[] iArr = new int[arrayList.size() * 2];
            int i3 = 0;
            for (com.aliyun.svideosdk.mixrecorder.AliyunMixTrack aliyunMixTrack2 : arrayList) {
                int i4 = i3 + 1;
                iArr[i3] = aliyunMixTrack2.getTrackId();
                i3 = i4 + 1;
                iArr[i4] = aliyunMixTrack2.getMixAudioWeight();
            }
            int a2 = this.a.a(this.b.getOutputPath(), trackId, i2, this.b.getOutputWidth(), this.b.getOutputHeight(), this.b.getCrf(), this.b.getBitrate(), this.b.getVideoQuality().ordinal(), this.b.getFps(), this.b.getGopSize(), iArr, arrayList.size(), new int[0], 0);
            return a2 != 0 ? a2 : this.a.a(aliyunMixCallback);
        }
        str = "There's no track to mix!Start mixing failed! please createTrack first";
        com.aliyun.common.log.debuglog.AlivcSvideoLog.e("AliYunLog", str);
        return -2;
    }
}
