package com.google.android.exoplayer2.source;

@java.lang.Deprecated
/* loaded from: classes22.dex */
public abstract class DefaultMediaSourceEventListener implements com.google.android.exoplayer2.source.MediaSourceEventListener {
    @Override // com.google.android.exoplayer2.source.MediaSourceEventListener
    public /* synthetic */ void onDownstreamFormatChanged(int i, com.google.android.exoplayer2.source.MediaSource.MediaPeriodId mediaPeriodId, com.google.android.exoplayer2.source.MediaLoadData mediaLoadData) {
        defpackage.nd1.a(this, i, mediaPeriodId, mediaLoadData);
    }

    @Override // com.google.android.exoplayer2.source.MediaSourceEventListener
    public /* synthetic */ void onLoadCanceled(int i, com.google.android.exoplayer2.source.MediaSource.MediaPeriodId mediaPeriodId, com.google.android.exoplayer2.source.LoadEventInfo loadEventInfo, com.google.android.exoplayer2.source.MediaLoadData mediaLoadData) {
        defpackage.nd1.b(this, i, mediaPeriodId, loadEventInfo, mediaLoadData);
    }

    @Override // com.google.android.exoplayer2.source.MediaSourceEventListener
    public /* synthetic */ void onLoadCompleted(int i, com.google.android.exoplayer2.source.MediaSource.MediaPeriodId mediaPeriodId, com.google.android.exoplayer2.source.LoadEventInfo loadEventInfo, com.google.android.exoplayer2.source.MediaLoadData mediaLoadData) {
        defpackage.nd1.c(this, i, mediaPeriodId, loadEventInfo, mediaLoadData);
    }

    @Override // com.google.android.exoplayer2.source.MediaSourceEventListener
    public /* synthetic */ void onLoadError(int i, com.google.android.exoplayer2.source.MediaSource.MediaPeriodId mediaPeriodId, com.google.android.exoplayer2.source.LoadEventInfo loadEventInfo, com.google.android.exoplayer2.source.MediaLoadData mediaLoadData, java.io.IOException iOException, boolean z) {
        defpackage.nd1.d(this, i, mediaPeriodId, loadEventInfo, mediaLoadData, iOException, z);
    }

    @Override // com.google.android.exoplayer2.source.MediaSourceEventListener
    public /* synthetic */ void onLoadStarted(int i, com.google.android.exoplayer2.source.MediaSource.MediaPeriodId mediaPeriodId, com.google.android.exoplayer2.source.LoadEventInfo loadEventInfo, com.google.android.exoplayer2.source.MediaLoadData mediaLoadData) {
        defpackage.nd1.e(this, i, mediaPeriodId, loadEventInfo, mediaLoadData);
    }

    @Override // com.google.android.exoplayer2.source.MediaSourceEventListener
    public /* synthetic */ void onUpstreamDiscarded(int i, com.google.android.exoplayer2.source.MediaSource.MediaPeriodId mediaPeriodId, com.google.android.exoplayer2.source.MediaLoadData mediaLoadData) {
        defpackage.nd1.f(this, i, mediaPeriodId, mediaLoadData);
    }
}
