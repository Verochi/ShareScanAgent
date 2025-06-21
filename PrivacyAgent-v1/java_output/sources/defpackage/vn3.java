package defpackage;

/* loaded from: classes19.dex */
public final /* synthetic */ class vn3 implements android.animation.ValueAnimator.AnimatorUpdateListener {
    public final /* synthetic */ com.moji.zodiac.databinding.FragmentZodiacSelectBinding n;

    public /* synthetic */ vn3(com.moji.zodiac.databinding.FragmentZodiacSelectBinding fragmentZodiacSelectBinding) {
        this.n = fragmentZodiacSelectBinding;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public final void onAnimationUpdate(android.animation.ValueAnimator valueAnimator) {
        com.moji.zodiac.ZodiacSelectFragment.a(this.n, valueAnimator);
    }
}
