package defpackage;

/* loaded from: classes28.dex */
public final /* synthetic */ class nc2 implements com.baidu.mobads.sdk.api.BiddingListener {
    @Override // com.baidu.mobads.sdk.api.BiddingListener
    public final void onBiddingResult(boolean z, java.lang.String str, java.util.HashMap hashMap) {
        com.moji.mjad.util.SDKBidPriceReport.Companion.c(z, str, hashMap);
    }
}
