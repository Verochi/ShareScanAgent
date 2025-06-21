package defpackage;

/* loaded from: classes9.dex */
public final /* synthetic */ class nk1 implements android.media.MediaPlayer.OnCompletionListener {
    public final /* synthetic */ com.moji.novice.membertutorial.fragment.MemberTutorialFragment n;

    public /* synthetic */ nk1(com.moji.novice.membertutorial.fragment.MemberTutorialFragment memberTutorialFragment) {
        this.n = memberTutorialFragment;
    }

    @Override // android.media.MediaPlayer.OnCompletionListener
    public final void onCompletion(android.media.MediaPlayer mediaPlayer) {
        com.moji.novice.membertutorial.fragment.MemberTutorialFragment.b(this.n, mediaPlayer);
    }
}
