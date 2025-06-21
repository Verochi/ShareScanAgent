package com.anythink.core.b.b;

/* loaded from: classes12.dex */
public abstract class b implements com.anythink.core.api.ATBiddingListener {
    protected com.anythink.core.api.ATBaseAdAdapter c;

    public b(com.anythink.core.api.ATBaseAdAdapter aTBaseAdAdapter) {
        this.c = aTBaseAdAdapter;
    }

    private void a() {
        this.c = null;
    }
}
