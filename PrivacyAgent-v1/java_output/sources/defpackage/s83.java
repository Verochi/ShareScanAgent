package defpackage;

/* loaded from: classes7.dex */
public final /* synthetic */ class s83 implements android.media.AudioManager.OnAudioFocusChangeListener {
    public final /* synthetic */ com.moji.mjweather.feed.newvideo.detail.VideoDetailActivity a;

    public /* synthetic */ s83(com.moji.mjweather.feed.newvideo.detail.VideoDetailActivity videoDetailActivity) {
        this.a = videoDetailActivity;
    }

    @Override // android.media.AudioManager.OnAudioFocusChangeListener
    public final void onAudioFocusChange(int i) {
        com.moji.mjweather.feed.newvideo.detail.VideoDetailActivity.b(this.a, i);
    }
}
