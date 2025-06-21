package defpackage;

/* loaded from: classes7.dex */
public final /* synthetic */ class ud3 implements android.animation.ValueAnimator.AnimatorUpdateListener {
    public final /* synthetic */ com.moji.mjweather.feed.subject.items.VoteItem n;
    public final /* synthetic */ android.view.View t;

    public /* synthetic */ ud3(com.moji.mjweather.feed.subject.items.VoteItem voteItem, android.view.View view) {
        this.n = voteItem;
        this.t = view;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public final void onAnimationUpdate(android.animation.ValueAnimator valueAnimator) {
        com.moji.mjweather.feed.subject.items.VoteItem.a(this.n, this.t, valueAnimator);
    }
}
