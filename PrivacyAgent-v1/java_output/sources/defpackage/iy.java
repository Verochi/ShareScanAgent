package defpackage;

/* loaded from: classes14.dex */
public final /* synthetic */ class iy implements io.reactivex.functions.Consumer {
    public final /* synthetic */ com.moji.share.fragment.DaysShareFragment n;
    public final /* synthetic */ com.moji.share.databinding.FragmentDaysBinding t;

    public /* synthetic */ iy(com.moji.share.fragment.DaysShareFragment daysShareFragment, com.moji.share.databinding.FragmentDaysBinding fragmentDaysBinding) {
        this.n = daysShareFragment;
        this.t = fragmentDaysBinding;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(java.lang.Object obj) {
        com.moji.share.fragment.DaysShareFragment.d(this.n, this.t, (com.moji.share.fragment.ShareBaseFragment.ShareImg) obj);
    }
}
