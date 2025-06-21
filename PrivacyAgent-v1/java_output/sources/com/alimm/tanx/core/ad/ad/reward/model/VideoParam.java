package com.alimm.tanx.core.ad.ad.reward.model;

/* loaded from: classes.dex */
public class VideoParam extends com.alimm.tanx.core.ad.bean.BaseBean {
    public boolean looping;
    public boolean mute;

    public VideoParam() {
        this.mute = false;
        this.looping = false;
    }

    public VideoParam(boolean z) {
        this.looping = false;
        this.mute = z;
    }

    public VideoParam(boolean z, boolean z2) {
        this.mute = z;
        this.looping = z2;
    }
}
