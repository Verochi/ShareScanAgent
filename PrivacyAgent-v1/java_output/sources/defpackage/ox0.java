package defpackage;

/* loaded from: classes7.dex */
public final /* synthetic */ class ox0 implements android.media.AudioManager.OnAudioFocusChangeListener {
    public final /* synthetic */ com.moji.mjweather.feed.newvideo.live.LiveVideoFragment a;

    public /* synthetic */ ox0(com.moji.mjweather.feed.newvideo.live.LiveVideoFragment liveVideoFragment) {
        this.a = liveVideoFragment;
    }

    @Override // android.media.AudioManager.OnAudioFocusChangeListener
    public final void onAudioFocusChange(int i) {
        com.moji.mjweather.feed.newvideo.live.LiveVideoFragment.a(this.a, i);
    }
}
