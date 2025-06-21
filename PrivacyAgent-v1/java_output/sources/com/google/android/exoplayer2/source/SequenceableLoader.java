package com.google.android.exoplayer2.source;

/* loaded from: classes22.dex */
public interface SequenceableLoader {

    public interface Callback<T extends com.google.android.exoplayer2.source.SequenceableLoader> {
        void onContinueLoadingRequested(T t);
    }

    boolean continueLoading(long j);

    long getBufferedPositionUs();

    long getNextLoadPositionUs();

    boolean isLoading();

    void reevaluateBuffer(long j);
}
