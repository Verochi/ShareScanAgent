package com.alimm.tanx.ui.image.glide.request;

/* loaded from: classes.dex */
public interface RequestCoordinator {
    boolean canNotifyStatusChanged(com.alimm.tanx.ui.image.glide.request.Request request);

    boolean canSetImage(com.alimm.tanx.ui.image.glide.request.Request request);

    boolean isAnyResourceSet();

    void onRequestSuccess(com.alimm.tanx.ui.image.glide.request.Request request);
}
