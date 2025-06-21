package defpackage;

/* loaded from: classes9.dex */
public final /* synthetic */ class j43 implements android.media.MediaPlayer.OnPreparedListener {
    public final /* synthetic */ com.moji.novice.tutorial.fragment.TutorialFragmentSecond n;

    public /* synthetic */ j43(com.moji.novice.tutorial.fragment.TutorialFragmentSecond tutorialFragmentSecond) {
        this.n = tutorialFragmentSecond;
    }

    @Override // android.media.MediaPlayer.OnPreparedListener
    public final void onPrepared(android.media.MediaPlayer mediaPlayer) {
        com.moji.novice.tutorial.fragment.TutorialFragmentSecond.a(this.n, mediaPlayer);
    }
}
