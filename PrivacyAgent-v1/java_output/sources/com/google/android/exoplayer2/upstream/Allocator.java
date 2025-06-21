package com.google.android.exoplayer2.upstream;

/* loaded from: classes22.dex */
public interface Allocator {
    com.google.android.exoplayer2.upstream.Allocation allocate();

    int getIndividualAllocationLength();

    int getTotalBytesAllocated();

    void release(com.google.android.exoplayer2.upstream.Allocation allocation);

    void release(com.google.android.exoplayer2.upstream.Allocation[] allocationArr);

    void trim();
}
