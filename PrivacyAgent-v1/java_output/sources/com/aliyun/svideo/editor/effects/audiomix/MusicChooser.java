package com.aliyun.svideo.editor.effects.audiomix;

/* loaded from: classes12.dex */
public class MusicChooser extends com.aliyun.svideo.editor.effects.control.BaseChooser {
    private long mStreamDuration;
    private com.aliyun.svideo.music.music.MusicChooseView musicChooseView;

    /* renamed from: com.aliyun.svideo.editor.effects.audiomix.MusicChooser$1, reason: invalid class name */
    public class AnonymousClass1 implements com.aliyun.svideo.music.music.MusicSelectListener {
        public AnonymousClass1() {
        }

        @Override // com.aliyun.svideo.music.music.MusicSelectListener
        public void onCancel() {
            com.aliyun.svideo.editor.effects.audiomix.MusicChooser.this.onBackPressed();
        }

        @Override // com.aliyun.svideo.music.music.MusicSelectListener
        public void onMusicSelect(com.aliyun.svideo.base.http.MusicFileBean musicFileBean, long j) {
            java.lang.String str;
            com.aliyun.svideo.editor.effects.control.EffectInfo effectInfo = new com.aliyun.svideo.editor.effects.control.EffectInfo();
            if (musicFileBean != null) {
                effectInfo.id = musicFileBean.id;
                effectInfo.setPath(musicFileBean.getPath());
                com.aliyun.svideosdk.common.struct.project.Source source = new com.aliyun.svideosdk.common.struct.project.Source(musicFileBean.getPath());
                source.setId(musicFileBean.musicId);
                if (!com.aliyun.common.utils.StringUtils.isEmpty(musicFileBean.musicId)) {
                    try {
                        str = java.lang.String.format("&name=%s", java.net.URLEncoder.encode(musicFileBean.title, "utf-8"));
                    } catch (java.io.UnsupportedEncodingException e) {
                        e.printStackTrace();
                        str = null;
                    }
                    source.setURL(com.aliyun.svideo.editor.util.AlivcResUtil.getCloudResUri(com.aliyun.svideo.editor.util.AlivcResUtil.TYPE_MUSIC, musicFileBean.musicId) + str);
                }
                effectInfo.setSource(source);
            }
            effectInfo.musicWeight = 50;
            effectInfo.startTime = 0L;
            effectInfo.type = com.aliyun.svideo.editor.effects.control.UIEditorPage.AUDIO_MIX;
            effectInfo.endTime = com.aliyun.svideo.editor.effects.audiomix.MusicChooser.this.mStreamDuration;
            effectInfo.streamStartTime = j;
            effectInfo.streamEndTime = j + com.aliyun.svideo.editor.effects.audiomix.MusicChooser.this.mStreamDuration;
            com.aliyun.svideo.editor.effects.audiomix.MusicChooser.this.mOnEffectChangeListener.onEffectChange(effectInfo);
            if (((com.aliyun.svideo.editor.effects.control.BaseChooser) com.aliyun.svideo.editor.effects.audiomix.MusicChooser.this).mOnEffectActionLister != null) {
                ((com.aliyun.svideo.editor.effects.control.BaseChooser) com.aliyun.svideo.editor.effects.audiomix.MusicChooser.this).mOnEffectActionLister.onComplete();
            }
        }
    }

    public MusicChooser(@androidx.annotation.NonNull android.content.Context context) {
        this(context, null);
    }

    public MusicChooser(@androidx.annotation.NonNull android.content.Context context, @androidx.annotation.Nullable android.util.AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public MusicChooser(@androidx.annotation.NonNull android.content.Context context, @androidx.annotation.Nullable android.util.AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mStreamDuration = 10000L;
    }

    @Override // com.aliyun.svideo.editor.effects.control.BaseChooser
    public com.aliyun.svideo.editor.effects.control.UIEditorPage getUIEditorPage() {
        return com.aliyun.svideo.editor.effects.control.UIEditorPage.AUDIO_MIX;
    }

    @Override // com.aliyun.svideo.editor.effects.control.BaseChooser
    public void init() {
        com.aliyun.svideo.music.music.MusicChooseView musicChooseView = new com.aliyun.svideo.music.music.MusicChooseView(getContext());
        this.musicChooseView = musicChooseView;
        addView(musicChooseView, -1, -1);
        this.musicChooseView.setMusicSelectListener(new com.aliyun.svideo.editor.effects.audiomix.MusicChooser.AnonymousClass1());
    }

    @Override // com.aliyun.svideo.editor.effects.control.BaseChooser
    public boolean isPlayerNeedZoom() {
        return false;
    }

    @Override // com.aliyun.svideo.editor.effects.control.BaseChooser
    public void onBackPressed() {
        com.aliyun.svideo.editor.effects.control.OnEffectActionLister onEffectActionLister = this.mOnEffectActionLister;
        if (onEffectActionLister != null) {
            onEffectActionLister.onCancel();
        }
    }

    public void setStreamDuration(long j) {
        this.mStreamDuration = j;
        com.aliyun.svideo.music.music.MusicChooseView musicChooseView = this.musicChooseView;
        if (musicChooseView != null) {
            musicChooseView.setStreamDuration((int) j);
        }
    }

    public void setVisibleStatus(boolean z) {
        com.aliyun.svideo.music.music.MusicChooseView musicChooseView = this.musicChooseView;
        if (musicChooseView != null) {
            musicChooseView.setVisibleStatus(z);
        }
    }
}
