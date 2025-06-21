package defpackage;

/* loaded from: classes9.dex */
public final /* synthetic */ class mk1 implements android.media.MediaPlayer.OnPreparedListener {
    public final /* synthetic */ com.moji.novice.membertutorial.fragment.MemberTutorialFragment n;

    public /* synthetic */ mk1(com.moji.novice.membertutorial.fragment.MemberTutorialFragment memberTutorialFragment) {
        this.n = memberTutorialFragment;
    }

    @Override // android.media.MediaPlayer.OnPreparedListener
    public final void onPrepared(android.media.MediaPlayer mediaPlayer) {
        com.moji.novice.membertutorial.fragment.MemberTutorialFragment.a(this.n, mediaPlayer);
    }
}
