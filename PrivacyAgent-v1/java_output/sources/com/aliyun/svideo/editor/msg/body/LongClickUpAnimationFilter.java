package com.aliyun.svideo.editor.msg.body;

/* loaded from: classes12.dex */
public class LongClickUpAnimationFilter {
    private com.aliyun.svideosdk.common.struct.effect.EffectConfig mEffectConfig;
    private com.aliyun.svideo.editor.effects.control.EffectInfo mEffectInfo;
    private int mIndex;

    public static final class Builder {
        private com.aliyun.svideosdk.common.struct.effect.EffectConfig mEffectConfig;
        private com.aliyun.svideo.editor.effects.control.EffectInfo mEffectInfo;
        private int mIndex;

        public com.aliyun.svideo.editor.msg.body.LongClickUpAnimationFilter build() {
            return new com.aliyun.svideo.editor.msg.body.LongClickUpAnimationFilter(this, null);
        }

        public com.aliyun.svideo.editor.msg.body.LongClickUpAnimationFilter.Builder effectConfig(com.aliyun.svideosdk.common.struct.effect.EffectConfig effectConfig) {
            this.mEffectConfig = effectConfig;
            return this;
        }

        public com.aliyun.svideo.editor.msg.body.LongClickUpAnimationFilter.Builder effectInfo(com.aliyun.svideo.editor.effects.control.EffectInfo effectInfo) {
            this.mEffectInfo = effectInfo;
            return this;
        }

        public com.aliyun.svideo.editor.msg.body.LongClickUpAnimationFilter.Builder index(int i) {
            this.mIndex = i;
            return this;
        }
    }

    private LongClickUpAnimationFilter(com.aliyun.svideo.editor.msg.body.LongClickUpAnimationFilter.Builder builder) {
        this.mEffectInfo = builder.mEffectInfo;
        this.mIndex = builder.mIndex;
        this.mEffectConfig = builder.mEffectConfig;
    }

    public /* synthetic */ LongClickUpAnimationFilter(com.aliyun.svideo.editor.msg.body.LongClickUpAnimationFilter.Builder builder, defpackage.f01 f01Var) {
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
