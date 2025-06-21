package com.google.android.exoplayer2.upstream;

/* loaded from: classes22.dex */
public final class DefaultAllocator implements com.google.android.exoplayer2.upstream.Allocator {
    public final boolean a;
    public final int b;

    @androidx.annotation.Nullable
    public final byte[] c;
    public final com.google.android.exoplayer2.upstream.Allocation[] d;
    public int e;
    public int f;
    public int g;
    public com.google.android.exoplayer2.upstream.Allocation[] h;

    public DefaultAllocator(boolean z, int i) {
        this(z, i, 0);
    }

    public DefaultAllocator(boolean z, int i, int i2) {
        com.google.android.exoplayer2.util.Assertions.checkArgument(i > 0);
        com.google.android.exoplayer2.util.Assertions.checkArgument(i2 >= 0);
        this.a = z;
        this.b = i;
        this.g = i2;
        this.h = new com.google.android.exoplayer2.upstream.Allocation[i2 + 100];
        if (i2 > 0) {
            this.c = new byte[i2 * i];
            for (int i3 = 0; i3 < i2; i3++) {
                this.h[i3] = new com.google.android.exoplayer2.upstream.Allocation(this.c, i3 * i);
            }
        } else {
            this.c = null;
        }
        this.d = new com.google.android.exoplayer2.upstream.Allocation[1];
    }

    @Override // com.google.android.exoplayer2.upstream.Allocator
    public synchronized com.google.android.exoplayer2.upstream.Allocation allocate() {
        com.google.android.exoplayer2.upstream.Allocation allocation;
        this.f++;
        int i = this.g;
        if (i > 0) {
            com.google.android.exoplayer2.upstream.Allocation[] allocationArr = this.h;
            int i2 = i - 1;
            this.g = i2;
            allocation = (com.google.android.exoplayer2.upstream.Allocation) com.google.android.exoplayer2.util.Assertions.checkNotNull(allocationArr[i2]);
            this.h[this.g] = null;
        } else {
            allocation = new com.google.android.exoplayer2.upstream.Allocation(new byte[this.b], 0);
        }
        return allocation;
    }

    @Override // com.google.android.exoplayer2.upstream.Allocator
    public int getIndividualAllocationLength() {
        return this.b;
    }

    @Override // com.google.android.exoplayer2.upstream.Allocator
    public synchronized int getTotalBytesAllocated() {
        return this.f * this.b;
    }

    @Override // com.google.android.exoplayer2.upstream.Allocator
    public synchronized void release(com.google.android.exoplayer2.upstream.Allocation allocation) {
        com.google.android.exoplayer2.upstream.Allocation[] allocationArr = this.d;
        allocationArr[0] = allocation;
        release(allocationArr);
    }

    @Override // com.google.android.exoplayer2.upstream.Allocator
    public synchronized void release(com.google.android.exoplayer2.upstream.Allocation[] allocationArr) {
        int i = this.g;
        int length = allocationArr.length + i;
        com.google.android.exoplayer2.upstream.Allocation[] allocationArr2 = this.h;
        if (length >= allocationArr2.length) {
            this.h = (com.google.android.exoplayer2.upstream.Allocation[]) java.util.Arrays.copyOf(allocationArr2, java.lang.Math.max(allocationArr2.length * 2, i + allocationArr.length));
        }
        for (com.google.android.exoplayer2.upstream.Allocation allocation : allocationArr) {
            com.google.android.exoplayer2.upstream.Allocation[] allocationArr3 = this.h;
            int i2 = this.g;
            this.g = i2 + 1;
            allocationArr3[i2] = allocation;
        }
        this.f -= allocationArr.length;
        notifyAll();
    }

    public synchronized void reset() {
        if (this.a) {
            setTargetBufferSize(0);
        }
    }

    public synchronized void setTargetBufferSize(int i) {
        boolean z = i < this.e;
        this.e = i;
        if (z) {
            trim();
        }
    }

    @Override // com.google.android.exoplayer2.upstream.Allocator
    public synchronized void trim() {
        int i = 0;
        int max = java.lang.Math.max(0, com.google.android.exoplayer2.util.Util.ceilDivide(this.e, this.b) - this.f);
        int i2 = this.g;
        if (max >= i2) {
            return;
        }
        if (this.c != null) {
            int i3 = i2 - 1;
            while (i <= i3) {
                com.google.android.exoplayer2.upstream.Allocation allocation = (com.google.android.exoplayer2.upstream.Allocation) com.google.android.exoplayer2.util.Assertions.checkNotNull(this.h[i]);
                if (allocation.data == this.c) {
                    i++;
                } else {
                    com.google.android.exoplayer2.upstream.Allocation allocation2 = (com.google.android.exoplayer2.upstream.Allocation) com.google.android.exoplayer2.util.Assertions.checkNotNull(this.h[i3]);
                    if (allocation2.data != this.c) {
                        i3--;
                    } else {
                        com.google.android.exoplayer2.upstream.Allocation[] allocationArr = this.h;
                        allocationArr[i] = allocation2;
                        allocationArr[i3] = allocation;
                        i3--;
                        i++;
                    }
                }
            }
            max = java.lang.Math.max(max, i);
            if (max >= this.g) {
                return;
            }
        }
        java.util.Arrays.fill(this.h, max, this.g, (java.lang.Object) null);
        this.g = max;
    }
}
