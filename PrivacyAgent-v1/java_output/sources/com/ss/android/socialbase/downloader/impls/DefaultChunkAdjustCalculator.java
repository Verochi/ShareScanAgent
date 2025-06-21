package com.ss.android.socialbase.downloader.impls;

/* loaded from: classes19.dex */
public class DefaultChunkAdjustCalculator implements com.ss.android.socialbase.downloader.downloader.IChunkAdjustCalculator {
    @Override // com.ss.android.socialbase.downloader.downloader.IChunkAdjustCalculator
    public int calculateChunkCount(int i, com.ss.android.socialbase.downloader.network.NetworkQuality networkQuality) {
        if (networkQuality.ordinal() <= com.ss.android.socialbase.downloader.network.NetworkQuality.MODERATE.ordinal()) {
            return 1;
        }
        return networkQuality == com.ss.android.socialbase.downloader.network.NetworkQuality.GOOD ? i - 1 : i;
    }
}
