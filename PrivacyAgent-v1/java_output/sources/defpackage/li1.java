package defpackage;

/* loaded from: classes8.dex */
public final /* synthetic */ class li1 implements com.moji.newmember.order.adapter.ProductPricesAdapter.PricesAdapterCallBack {
    public final /* synthetic */ com.moji.newmember.order.MemberProductDialogActivity a;

    public /* synthetic */ li1(com.moji.newmember.order.MemberProductDialogActivity memberProductDialogActivity) {
        this.a = memberProductDialogActivity;
    }

    public final void onPriceChange(com.moji.http.member.entity.PricesResult.MemberPrice memberPrice) {
        com.moji.newmember.order.MemberProductDialogActivity.f(this.a, memberPrice);
    }
}
