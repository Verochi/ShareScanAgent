package com.google.android.exoplayer2.upstream;

/* loaded from: classes22.dex */
public interface LoaderErrorThrower {

    public static final class Dummy implements com.google.android.exoplayer2.upstream.LoaderErrorThrower {
        @Override // com.google.android.exoplayer2.upstream.LoaderErrorThrower
        public void maybeThrowError() {
        }

        @Override // com.google.android.exoplayer2.upstream.LoaderErrorThrower
        public void maybeThrowError(int i) {
        }
    }

    void maybeThrowError() throws java.io.IOException;

    void maybeThrowError(int i) throws java.io.IOException;
}
