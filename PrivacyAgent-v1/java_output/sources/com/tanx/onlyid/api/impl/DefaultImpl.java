package com.tanx.onlyid.api.impl;

/* loaded from: classes19.dex */
class DefaultImpl implements com.tanx.onlyid.api.IOAID {
    @Override // com.tanx.onlyid.api.IOAID
    public void doGet(com.tanx.onlyid.api.IGetter iGetter) {
        if (iGetter == null) {
            return;
        }
        iGetter.oaidError(new com.tanx.onlyid.api.OAIDException("Unsupported"));
    }

    @Override // com.tanx.onlyid.api.IOAID
    public boolean supported() {
        return false;
    }
}
