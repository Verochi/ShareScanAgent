package defpackage;

/* loaded from: classes14.dex */
public final /* synthetic */ class gy implements java.lang.Runnable {
    public final /* synthetic */ com.moji.share.fragment.DaysShareFragment n;
    public final /* synthetic */ com.moji.share.databinding.FragmentDaysBinding t;

    public /* synthetic */ gy(com.moji.share.fragment.DaysShareFragment daysShareFragment, com.moji.share.databinding.FragmentDaysBinding fragmentDaysBinding) {
        this.n = daysShareFragment;
        this.t = fragmentDaysBinding;
    }

    @Override // java.lang.Runnable
    public final void run() {
        com.moji.share.fragment.DaysShareFragment.e(this.n, this.t);
    }
}
