package defpackage;

/* loaded from: classes9.dex */
public final /* synthetic */ class de1 implements android.media.MediaPlayer.OnCompletionListener {
    public final /* synthetic */ com.moji.novice.memberadtutorial.fragment.MemberAdTutorialFragment n;

    public /* synthetic */ de1(com.moji.novice.memberadtutorial.fragment.MemberAdTutorialFragment memberAdTutorialFragment) {
        this.n = memberAdTutorialFragment;
    }

    @Override // android.media.MediaPlayer.OnCompletionListener
    public final void onCompletion(android.media.MediaPlayer mediaPlayer) {
        com.moji.novice.memberadtutorial.fragment.MemberAdTutorialFragment.b(this.n, mediaPlayer);
    }
}
