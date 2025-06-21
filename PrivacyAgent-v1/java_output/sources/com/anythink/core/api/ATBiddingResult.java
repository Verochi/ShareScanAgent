package com.anythink.core.api;

/* loaded from: classes12.dex */
public class ATBiddingResult extends com.anythink.core.common.f.o {
    private ATBiddingResult(boolean z, double d, double d2, java.lang.String str, com.anythink.core.api.ATBiddingNotice aTBiddingNotice, java.lang.String str2, com.anythink.core.api.ATAdConst.CURRENCY currency) {
        super(z, d, d2, str, aTBiddingNotice, str2, currency);
    }

    public static com.anythink.core.api.ATBiddingResult fail(java.lang.String str) {
        return new com.anythink.core.api.ATBiddingResult(false, 0.0d, 0.0d, null, null, str, com.anythink.core.api.ATAdConst.CURRENCY.USD);
    }

    public static com.anythink.core.api.ATBiddingResult success(double d, double d2, java.lang.String str, com.anythink.core.api.ATBiddingNotice aTBiddingNotice, com.anythink.core.api.ATAdConst.CURRENCY currency) {
        return new com.anythink.core.api.ATBiddingResult(true, d, d2, str, aTBiddingNotice, null, currency);
    }

    public static com.anythink.core.api.ATBiddingResult success(double d, java.lang.String str, com.anythink.core.api.ATBiddingNotice aTBiddingNotice) {
        return new com.anythink.core.api.ATBiddingResult(true, d, d, str, aTBiddingNotice, null, com.anythink.core.api.ATAdConst.CURRENCY.USD);
    }

    public static com.anythink.core.api.ATBiddingResult success(double d, java.lang.String str, com.anythink.core.api.ATBiddingNotice aTBiddingNotice, com.anythink.core.api.ATAdConst.CURRENCY currency) {
        return new com.anythink.core.api.ATBiddingResult(true, d, d, str, aTBiddingNotice, null, currency);
    }
}
