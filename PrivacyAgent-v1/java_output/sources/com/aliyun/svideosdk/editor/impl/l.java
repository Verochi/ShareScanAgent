package com.aliyun.svideosdk.editor.impl;

/* loaded from: classes12.dex */
class l extends com.aliyun.svideosdk.editor.impl.a<com.aliyun.svideosdk.common.struct.effect.EffectPaster> {
    public l(com.aliyun.svideosdk.common.struct.effect.EffectPaster effectPaster, com.aliyun.svideosdk.editor.impl.p pVar, com.aliyun.svideosdk.editor.AliyunPasterManager aliyunPasterManager) {
        super(effectPaster, pVar, aliyunPasterManager, false);
    }

    public l(com.aliyun.svideosdk.common.struct.effect.EffectPaster effectPaster, com.aliyun.svideosdk.editor.impl.p pVar, com.aliyun.svideosdk.editor.AliyunPasterManager aliyunPasterManager, boolean z) {
        super(effectPaster, pVar, aliyunPasterManager, z);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void a() {
        int pasterWidth = this.b.getPasterWidth();
        if (pasterWidth != 0) {
            ((com.aliyun.svideosdk.common.struct.effect.EffectPaster) this.a).width = pasterWidth;
        }
        int pasterHeight = this.b.getPasterHeight();
        if (pasterHeight != 0) {
            ((com.aliyun.svideosdk.common.struct.effect.EffectPaster) this.a).height = pasterHeight;
        }
        if (!isOnlyApplyUI() && !isRevert()) {
            ((com.aliyun.svideosdk.common.struct.effect.EffectPaster) this.a).x = this.b.getPasterCenterX();
            ((com.aliyun.svideosdk.common.struct.effect.EffectPaster) this.a).y = this.b.getPasterCenterY();
        }
        ((com.aliyun.svideosdk.common.struct.effect.EffectPaster) this.a).mirror = this.b.isPasterMirrored();
        ((com.aliyun.svideosdk.common.struct.effect.EffectPaster) this.a).rotation = this.b.getPasterRotation();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.aliyun.svideosdk.editor.AliyunPasterController
    public com.aliyun.svideosdk.editor.pplayer.AnimPlayerView createPasterPlayer(android.view.TextureView textureView) {
        com.aliyun.svideosdk.editor.pplayer.AnimPlayerView animPlayerView = new com.aliyun.svideosdk.editor.pplayer.AnimPlayerView(textureView);
        java.util.ArrayList arrayList = new java.util.ArrayList();
        for (com.aliyun.svideosdk.common.struct.project.FrameTime frameTime : ((com.aliyun.svideosdk.common.struct.effect.EffectPaster) this.a).timeArry) {
            arrayList.add(new com.aliyun.svideosdk.editor.pplayer.a((long) (frameTime.beginTime * 1000.0d), (long) (frameTime.endTime * 1000.0d), (long) (frameTime.minTime * 1000.0d), (long) (frameTime.maxTime * 1000.0d), frameTime.shrink));
        }
        for (com.aliyun.svideosdk.common.struct.project.Frame frame : ((com.aliyun.svideosdk.common.struct.effect.EffectPaster) this.a).frameArry) {
            animPlayerView.addFrameList((long) (frame.time * 1000.0f), frame.pic);
        }
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        sb.append("init duration : ");
        sb.append(((com.aliyun.svideosdk.common.struct.effect.EffectPaster) this.a).duration);
        animPlayerView.setAnimationBlocks(arrayList);
        animPlayerView.setMirror(((com.aliyun.svideosdk.common.struct.effect.EffectPaster) this.a).mirror);
        animPlayerView.setDefaltDuration(((com.aliyun.svideosdk.common.struct.effect.EffectPaster) this.a).duration / 1000);
        com.aliyun.svideosdk.common.struct.effect.EffectPaster effectPaster = (com.aliyun.svideosdk.common.struct.effect.EffectPaster) this.a;
        animPlayerView.setPlayTime(effectPaster.start, effectPaster.end);
        animPlayerView.setAnimationPath(((com.aliyun.svideosdk.common.struct.effect.EffectPaster) this.a).getPath() + net.lingala.zip4j.util.InternalZipConstants.ZIP_FILE_SEPARATOR + ((com.aliyun.svideosdk.common.struct.effect.EffectPaster) this.a).name);
        animPlayerView.setPreview(false);
        return animPlayerView;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int editCompleted() {
        if (this.b != null) {
            a();
        }
        if (isOnlyApplyUI()) {
            return 0;
        }
        if (this.c) {
            return this.mRender.showPaster((com.aliyun.svideosdk.common.struct.effect.EffectPaster) this.a);
        }
        int addEffectPaster = this.mRender.addEffectPaster((com.aliyun.svideosdk.common.struct.effect.EffectPaster) this.a);
        if (addEffectPaster != 0) {
            return addEffectPaster;
        }
        this.c = true;
        return 0;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.aliyun.svideosdk.editor.AliyunPasterController
    public void editStart() {
        if (isOnlyApplyUI()) {
            return;
        }
        this.mRender.hidePaster((com.aliyun.svideosdk.common.struct.effect.EffectPaster) this.a);
    }

    @Override // com.aliyun.svideosdk.editor.AliyunIPasterController
    public long getDuration() {
        return getPasterDuration();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public com.aliyun.svideosdk.common.struct.effect.EffectBase getEffect() {
        return (com.aliyun.svideosdk.common.struct.effect.EffectBase) this.a;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.aliyun.svideosdk.editor.AliyunPasterController
    public float getPasterCenterX() {
        return ((com.aliyun.svideosdk.common.struct.effect.EffectPaster) this.a).x;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.aliyun.svideosdk.editor.AliyunPasterController
    public float getPasterCenterY() {
        return ((com.aliyun.svideosdk.common.struct.effect.EffectPaster) this.a).y;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.aliyun.svideosdk.editor.AliyunPasterController
    public long getPasterDuration() {
        com.aliyun.svideosdk.common.struct.effect.EffectPaster effectPaster = (com.aliyun.svideosdk.common.struct.effect.EffectPaster) this.a;
        return effectPaster.end - effectPaster.start;
    }

    @Override // com.aliyun.svideosdk.editor.AliyunPasterController
    public long getPasterDuration(java.util.concurrent.TimeUnit timeUnit) {
        return timeUnit.convert(getPasterDuration(), java.util.concurrent.TimeUnit.MICROSECONDS);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.aliyun.svideosdk.editor.AliyunPasterController
    public int getPasterHeight() {
        return ((com.aliyun.svideosdk.common.struct.effect.EffectPaster) this.a).height;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.aliyun.svideosdk.editor.AliyunPasterController
    public java.lang.String getPasterIconPath() {
        java.util.Locale locale = java.util.Locale.ENGLISH;
        com.aliyun.svideosdk.common.struct.effect.EffectPaster effectPaster = (com.aliyun.svideosdk.common.struct.effect.EffectPaster) this.a;
        return java.lang.String.format(locale, "%s/%s%d.png", ((com.aliyun.svideosdk.common.struct.effect.EffectPaster) this.a).getPath(), effectPaster.name, java.lang.Integer.valueOf(effectPaster.kernelFrame));
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.aliyun.svideosdk.editor.AliyunPasterController
    public float getPasterRotation() {
        return ((com.aliyun.svideosdk.common.struct.effect.EffectPaster) this.a).rotation;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.aliyun.svideosdk.editor.AliyunPasterController
    public long getPasterStartTime() {
        return ((com.aliyun.svideosdk.common.struct.effect.EffectPaster) this.a).start;
    }

    @Override // com.aliyun.svideosdk.editor.AliyunPasterController
    public long getPasterStartTime(java.util.concurrent.TimeUnit timeUnit) {
        return java.util.concurrent.TimeUnit.MICROSECONDS.toMillis(getPasterStartTime());
    }

    public int getPasterType() {
        return 0;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.aliyun.svideosdk.editor.AliyunPasterController
    public int getPasterWidth() {
        return ((com.aliyun.svideosdk.common.struct.effect.EffectPaster) this.a).width;
    }

    @Override // com.aliyun.svideosdk.editor.AliyunIPasterController
    public android.graphics.PointF getPosition() {
        return new android.graphics.PointF(getPasterCenterX(), getPasterCenterY());
    }

    @Override // com.aliyun.svideosdk.editor.AliyunIPasterController
    public float getRotate() {
        return getPasterRotation();
    }

    @Override // com.aliyun.svideosdk.editor.AliyunIPasterController
    public android.graphics.RectF getSize() {
        return new android.graphics.RectF(0.0f, 0.0f, getPasterWidth(), getPasterHeight());
    }

    @Override // com.aliyun.svideosdk.editor.AliyunIPasterController
    public long getStartTime() {
        return getPasterStartTime();
    }

    @Override // com.aliyun.svideosdk.editor.AliyunIPasterController
    public int getType() {
        return getPasterType();
    }

    @Override // com.aliyun.svideosdk.editor.AliyunPasterController
    public boolean isOnlyApplyUI() {
        return this.d;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public boolean isPasterExists() {
        return new java.io.File(((com.aliyun.svideosdk.common.struct.effect.EffectPaster) this.a).getPath()).exists();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.aliyun.svideosdk.editor.AliyunPasterController
    public boolean isPasterMirrored() {
        return ((com.aliyun.svideosdk.common.struct.effect.EffectPaster) this.a).mirror;
    }

    @Override // com.aliyun.svideosdk.editor.AliyunPasterController
    public boolean isRevert() {
        return this.e;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.aliyun.svideosdk.editor.impl.h
    public int remove() {
        return this.mRender.removePaster((com.aliyun.svideosdk.common.struct.effect.EffectPaster) this.a);
    }

    @Override // com.aliyun.svideosdk.editor.AliyunPasterController
    public int removePaster() {
        this.f.remove(this);
        return 0;
    }

    @Override // com.aliyun.svideosdk.editor.impl.AliyunPasterAbstractController, com.aliyun.svideosdk.editor.AliyunIPasterController
    public void setDuration(long j) {
        setPasterDuration(j);
    }

    @Override // com.aliyun.svideosdk.editor.AliyunIPasterController
    public void setDuration(long j, java.util.concurrent.TimeUnit timeUnit) {
        setPasterDuration(j, timeUnit);
    }

    /* JADX WARN: Type inference failed for: r2v1, types: [T, com.aliyun.svideosdk.common.struct.effect.EffectPaster] */
    public void setEffect(com.aliyun.svideosdk.common.struct.effect.EffectBase effectBase) {
        if (effectBase instanceof com.aliyun.svideosdk.common.struct.effect.EffectPaster) {
            this.a = (com.aliyun.svideosdk.common.struct.effect.EffectPaster) effectBase;
        }
    }

    @Override // com.aliyun.svideosdk.editor.AliyunPasterController
    public void setOnlyApplyUI(boolean z) {
        this.d = z;
    }

    @Override // com.aliyun.svideosdk.editor.AliyunPasterController
    public void setPasterDuration(long j) {
        setPasterDuration(j, java.util.concurrent.TimeUnit.MICROSECONDS);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.aliyun.svideosdk.editor.AliyunPasterController
    public void setPasterDuration(long j, java.util.concurrent.TimeUnit timeUnit) {
        ((com.aliyun.svideosdk.common.struct.effect.EffectPaster) this.a).end = getPasterStartTime() + timeUnit.toMicros(j);
    }

    @Override // com.aliyun.svideosdk.editor.AliyunPasterController
    public void setPasterStartTime(long j) {
        setPasterStartTime(j, java.util.concurrent.TimeUnit.MICROSECONDS);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.aliyun.svideosdk.editor.AliyunPasterController
    public void setPasterStartTime(long j, java.util.concurrent.TimeUnit timeUnit) {
        ((com.aliyun.svideosdk.common.struct.effect.EffectPaster) this.a).end = timeUnit.toMicros(j) + getPasterDuration();
        ((com.aliyun.svideosdk.common.struct.effect.EffectPaster) this.a).start = timeUnit.toMicros(j);
    }

    @Override // com.aliyun.svideosdk.editor.AliyunIPasterController
    @java.lang.Deprecated
    public void setPosition(android.graphics.PointF pointF) {
    }

    @Override // com.aliyun.svideosdk.editor.AliyunPasterController
    public void setRevert(boolean z) {
        this.e = z;
    }

    @Override // com.aliyun.svideosdk.editor.AliyunIPasterController
    @java.lang.Deprecated
    public void setRotate(float f) {
    }

    @Override // com.aliyun.svideosdk.editor.impl.AliyunPasterAbstractController, com.aliyun.svideosdk.editor.AliyunIPasterController
    public void setStartTime(long j) {
        setPasterStartTime(j);
    }

    @Override // com.aliyun.svideosdk.editor.AliyunIPasterController
    public void setStartTime(long j, java.util.concurrent.TimeUnit timeUnit) {
        setPasterStartTime(j, timeUnit);
    }
}
