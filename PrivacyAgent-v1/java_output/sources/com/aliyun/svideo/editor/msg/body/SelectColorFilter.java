package com.aliyun.svideo.editor.msg.body;

/* loaded from: classes12.dex */
public class SelectColorFilter {
    private com.aliyun.svideo.editor.effects.control.EffectInfo mEffectInfo;
    private int mIndex;

    public static final class Builder {
        private com.aliyun.svideo.editor.effects.control.EffectInfo mEffectInfo;
        private int mIndex;

        public com.aliyun.svideo.editor.msg.body.SelectColorFilter build() {
            return new com.aliyun.svideo.editor.msg.body.SelectColorFilter(this, null);
        }

        public com.aliyun.svideo.editor.msg.body.SelectColorFilter.Builder effectInfo(com.aliyun.svideo.editor.effects.control.EffectInfo effectInfo) {
            this.mEffectInfo = effectInfo;
            return this;
        }

        public com.aliyun.svideo.editor.msg.body.SelectColorFilter.Builder index(int i) {
            this.mIndex = i;
            return this;
        }
    }

    private SelectColorFilter(com.aliyun.svideo.editor.msg.body.SelectColorFilter.Builder builder) {
        this.mEffectInfo = builder.mEffectInfo;
        this.mIndex = builder.mIndex;
    }

    public /* synthetic */ SelectColorFilter(com.aliyun.svideo.editor.msg.body.SelectColorFilter.Builder builder, defpackage.de2 de2Var) {
        this(builder);
    }

    public com.aliyun.svideo.editor.effects.control.EffectInfo getEffectInfo() {
        return this.mEffectInfo;
    }
}
