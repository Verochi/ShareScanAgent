package com.aliyun.svideo.editor.msg.body;

/* loaded from: classes12.dex */
public class LongClickAnimationFilter {
    private com.aliyun.svideosdk.common.struct.effect.EffectConfig mEffectConfig;
    private com.aliyun.svideo.editor.effects.control.EffectInfo mEffectInfo;
    private int mIndex;

    public static final class Builder {
        private com.aliyun.svideosdk.common.struct.effect.EffectConfig mEffectConfig;
        private com.aliyun.svideo.editor.effects.control.EffectInfo mEffectInfo;
        private int mIndex;

        public com.aliyun.svideo.editor.msg.body.LongClickAnimationFilter build() {
            return new com.aliyun.svideo.editor.msg.body.LongClickAnimationFilter(this, null);
        }

        public com.aliyun.svideo.editor.msg.body.LongClickAnimationFilter.Builder effectConfig(com.aliyun.svideosdk.common.struct.effect.EffectConfig effectConfig) {
            this.mEffectConfig = effectConfig;
            return this;
        }

        public com.aliyun.svideo.editor.msg.body.LongClickAnimationFilter.Builder effectInfo(com.aliyun.svideo.editor.effects.control.EffectInfo effectInfo) {
            this.mEffectInfo = effectInfo;
            return this;
        }

        public com.aliyun.svideo.editor.msg.body.LongClickAnimationFilter.Builder index(int i) {
            this.mIndex = i;
            return this;
        }
    }

    private LongClickAnimationFilter(com.aliyun.svideo.editor.msg.body.LongClickAnimationFilter.Builder builder) {
        this.mEffectInfo = builder.mEffectInfo;
        this.mIndex = builder.mIndex;
        this.mEffectConfig = builder.mEffectConfig;
    }

    public /* synthetic */ LongClickAnimationFilter(com.aliyun.svideo.editor.msg.body.LongClickAnimationFilter.Builder builder, defpackage.e01 e01Var) {
        this(builder);
    }

    public com.aliyun.svideosdk.common.struct.effect.EffectConfig getEffectConfig() {
        return this.mEffectConfig;
    }

    public com.aliyun.svideo.editor.effects.control.EffectInfo getEffectInfo() {
        return this.mEffectInfo;
    }

    public int getIndex() {
        return this.mIndex;
    }
}
