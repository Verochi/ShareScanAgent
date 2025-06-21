package com.anythink.core.api;

/* loaded from: classes12.dex */
public interface ATAdSourceStatusListener {
    void onAdSourceAttempt(com.anythink.core.api.ATAdInfo aTAdInfo);

    void onAdSourceBiddingAttempt(com.anythink.core.api.ATAdInfo aTAdInfo);

    void onAdSourceBiddingFail(com.anythink.core.api.ATAdInfo aTAdInfo, com.anythink.core.api.AdError adError);

    void onAdSourceBiddingFilled(com.anythink.core.api.ATAdInfo aTAdInfo);

    void onAdSourceLoadFail(com.anythink.core.api.ATAdInfo aTAdInfo, com.anythink.core.api.AdError adError);

    void onAdSourceLoadFilled(com.anythink.core.api.ATAdInfo aTAdInfo);
}
