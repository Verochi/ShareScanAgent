package com.google.android.exoplayer2.source;

/* loaded from: classes22.dex */
class SampleDataQueue {
    public final com.google.android.exoplayer2.upstream.Allocator a;
    public final int b;
    public final com.google.android.exoplayer2.util.ParsableByteArray c;
    public com.google.android.exoplayer2.source.SampleDataQueue.AllocationNode d;
    public com.google.android.exoplayer2.source.SampleDataQueue.AllocationNode e;
    public com.google.android.exoplayer2.source.SampleDataQueue.AllocationNode f;
    public long g;

    public static final class AllocationNode {
        public final long a;
        public final long b;
        public boolean c;

        @androidx.annotation.Nullable
        public com.google.android.exoplayer2.upstream.Allocation d;

        @androidx.annotation.Nullable
        public com.google.android.exoplayer2.source.SampleDataQueue.AllocationNode e;

        public AllocationNode(long j, int i) {
            this.a = j;
            this.b = j + i;
        }

        public com.google.android.exoplayer2.source.SampleDataQueue.AllocationNode a() {
            this.d = null;
            com.google.android.exoplayer2.source.SampleDataQueue.AllocationNode allocationNode = this.e;
            this.e = null;
            return allocationNode;
        }

        public void b(com.google.android.exoplayer2.upstream.Allocation allocation, com.google.android.exoplayer2.source.SampleDataQueue.AllocationNode allocationNode) {
            this.d = allocation;
            this.e = allocationNode;
            this.c = true;
        }

        public int c(long j) {
            return ((int) (j - this.a)) + this.d.offset;
        }
    }

    public SampleDataQueue(com.google.android.exoplayer2.upstream.Allocator allocator) {
        this.a = allocator;
        int individualAllocationLength = allocator.getIndividualAllocationLength();
        this.b = individualAllocationLength;
        this.c = new com.google.android.exoplayer2.util.ParsableByteArray(32);
        com.google.android.exoplayer2.source.SampleDataQueue.AllocationNode allocationNode = new com.google.android.exoplayer2.source.SampleDataQueue.AllocationNode(0L, individualAllocationLength);
        this.d = allocationNode;
        this.e = allocationNode;
        this.f = allocationNode;
    }

    public final void a(long j) {
        while (true) {
            com.google.android.exoplayer2.source.SampleDataQueue.AllocationNode allocationNode = this.e;
            if (j < allocationNode.b) {
                return;
            } else {
                this.e = allocationNode.e;
            }
        }
    }

    public final void b(com.google.android.exoplayer2.source.SampleDataQueue.AllocationNode allocationNode) {
        if (allocationNode.c) {
            com.google.android.exoplayer2.source.SampleDataQueue.AllocationNode allocationNode2 = this.f;
            boolean z = allocationNode2.c;
            int i = (z ? 1 : 0) + (((int) (allocationNode2.a - allocationNode.a)) / this.b);
            com.google.android.exoplayer2.upstream.Allocation[] allocationArr = new com.google.android.exoplayer2.upstream.Allocation[i];
            for (int i2 = 0; i2 < i; i2++) {
                allocationArr[i2] = allocationNode.d;
                allocationNode = allocationNode.a();
            }
            this.a.release(allocationArr);
        }
    }

    public void c(long j) {
        com.google.android.exoplayer2.source.SampleDataQueue.AllocationNode allocationNode;
        if (j == -1) {
            return;
        }
        while (true) {
            allocationNode = this.d;
            if (j < allocationNode.b) {
                break;
            }
            this.a.release(allocationNode.d);
            this.d = this.d.a();
        }
        if (this.e.a < allocationNode.a) {
            this.e = allocationNode;
        }
    }

    public void d(long j) {
        this.g = j;
        if (j != 0) {
            com.google.android.exoplayer2.source.SampleDataQueue.AllocationNode allocationNode = this.d;
            if (j != allocationNode.a) {
                while (this.g > allocationNode.b) {
                    allocationNode = allocationNode.e;
                }
                com.google.android.exoplayer2.source.SampleDataQueue.AllocationNode allocationNode2 = allocationNode.e;
                b(allocationNode2);
                com.google.android.exoplayer2.source.SampleDataQueue.AllocationNode allocationNode3 = new com.google.android.exoplayer2.source.SampleDataQueue.AllocationNode(allocationNode.b, this.b);
                allocationNode.e = allocationNode3;
                if (this.g == allocationNode.b) {
                    allocationNode = allocationNode3;
                }
                this.f = allocationNode;
                if (this.e == allocationNode2) {
                    this.e = allocationNode3;
                    return;
                }
                return;
            }
        }
        b(this.d);
        com.google.android.exoplayer2.source.SampleDataQueue.AllocationNode allocationNode4 = new com.google.android.exoplayer2.source.SampleDataQueue.AllocationNode(this.g, this.b);
        this.d = allocationNode4;
        this.e = allocationNode4;
        this.f = allocationNode4;
    }

    public long e() {
        return this.g;
    }

    public final void f(int i) {
        long j = this.g + i;
        this.g = j;
        com.google.android.exoplayer2.source.SampleDataQueue.AllocationNode allocationNode = this.f;
        if (j == allocationNode.b) {
            this.f = allocationNode.e;
        }
    }

    public final int g(int i) {
        com.google.android.exoplayer2.source.SampleDataQueue.AllocationNode allocationNode = this.f;
        if (!allocationNode.c) {
            allocationNode.b(this.a.allocate(), new com.google.android.exoplayer2.source.SampleDataQueue.AllocationNode(this.f.b, this.b));
        }
        return java.lang.Math.min(i, (int) (this.f.b - this.g));
    }

    public final void h(long j, java.nio.ByteBuffer byteBuffer, int i) {
        a(j);
        while (i > 0) {
            int min = java.lang.Math.min(i, (int) (this.e.b - j));
            com.google.android.exoplayer2.source.SampleDataQueue.AllocationNode allocationNode = this.e;
            byteBuffer.put(allocationNode.d.data, allocationNode.c(j), min);
            i -= min;
            j += min;
            com.google.android.exoplayer2.source.SampleDataQueue.AllocationNode allocationNode2 = this.e;
            if (j == allocationNode2.b) {
                this.e = allocationNode2.e;
            }
        }
    }

    public final void i(long j, byte[] bArr, int i) {
        a(j);
        int i2 = i;
        while (i2 > 0) {
            int min = java.lang.Math.min(i2, (int) (this.e.b - j));
            com.google.android.exoplayer2.source.SampleDataQueue.AllocationNode allocationNode = this.e;
            java.lang.System.arraycopy(allocationNode.d.data, allocationNode.c(j), bArr, i - i2, min);
            i2 -= min;
            j += min;
            com.google.android.exoplayer2.source.SampleDataQueue.AllocationNode allocationNode2 = this.e;
            if (j == allocationNode2.b) {
                this.e = allocationNode2.e;
            }
        }
    }

    public final void j(com.google.android.exoplayer2.decoder.DecoderInputBuffer decoderInputBuffer, com.google.android.exoplayer2.source.SampleQueue.SampleExtrasHolder sampleExtrasHolder) {
        int i;
        long j = sampleExtrasHolder.b;
        this.c.reset(1);
        i(j, this.c.getData(), 1);
        long j2 = j + 1;
        byte b = this.c.getData()[0];
        boolean z = (b & 128) != 0;
        int i2 = b & Byte.MAX_VALUE;
        com.google.android.exoplayer2.decoder.CryptoInfo cryptoInfo = decoderInputBuffer.cryptoInfo;
        byte[] bArr = cryptoInfo.iv;
        if (bArr == null) {
            cryptoInfo.iv = new byte[16];
        } else {
            java.util.Arrays.fill(bArr, (byte) 0);
        }
        i(j2, cryptoInfo.iv, i2);
        long j3 = j2 + i2;
        if (z) {
            this.c.reset(2);
            i(j3, this.c.getData(), 2);
            j3 += 2;
            i = this.c.readUnsignedShort();
        } else {
            i = 1;
        }
        int[] iArr = cryptoInfo.numBytesOfClearData;
        if (iArr == null || iArr.length < i) {
            iArr = new int[i];
        }
        int[] iArr2 = iArr;
        int[] iArr3 = cryptoInfo.numBytesOfEncryptedData;
        if (iArr3 == null || iArr3.length < i) {
            iArr3 = new int[i];
        }
        int[] iArr4 = iArr3;
        if (z) {
            int i3 = i * 6;
            this.c.reset(i3);
            i(j3, this.c.getData(), i3);
            j3 += i3;
            this.c.setPosition(0);
            for (int i4 = 0; i4 < i; i4++) {
                iArr2[i4] = this.c.readUnsignedShort();
                iArr4[i4] = this.c.readUnsignedIntToInt();
            }
        } else {
            iArr2[0] = 0;
            iArr4[0] = sampleExtrasHolder.a - ((int) (j3 - sampleExtrasHolder.b));
        }
        com.google.android.exoplayer2.extractor.TrackOutput.CryptoData cryptoData = (com.google.android.exoplayer2.extractor.TrackOutput.CryptoData) com.google.android.exoplayer2.util.Util.castNonNull(sampleExtrasHolder.c);
        cryptoInfo.set(i, iArr2, iArr4, cryptoData.encryptionKey, cryptoInfo.iv, cryptoData.cryptoMode, cryptoData.encryptedBlocks, cryptoData.clearBlocks);
        long j4 = sampleExtrasHolder.b;
        int i5 = (int) (j3 - j4);
        sampleExtrasHolder.b = j4 + i5;
        sampleExtrasHolder.a -= i5;
    }

    public void k(com.google.android.exoplayer2.decoder.DecoderInputBuffer decoderInputBuffer, com.google.android.exoplayer2.source.SampleQueue.SampleExtrasHolder sampleExtrasHolder) {
        if (decoderInputBuffer.isEncrypted()) {
            j(decoderInputBuffer, sampleExtrasHolder);
        }
        if (!decoderInputBuffer.hasSupplementalData()) {
            decoderInputBuffer.ensureSpaceForWrite(sampleExtrasHolder.a);
            h(sampleExtrasHolder.b, decoderInputBuffer.data, sampleExtrasHolder.a);
            return;
        }
        this.c.reset(4);
        i(sampleExtrasHolder.b, this.c.getData(), 4);
        int readUnsignedIntToInt = this.c.readUnsignedIntToInt();
        sampleExtrasHolder.b += 4;
        sampleExtrasHolder.a -= 4;
        decoderInputBuffer.ensureSpaceForWrite(readUnsignedIntToInt);
        h(sampleExtrasHolder.b, decoderInputBuffer.data, readUnsignedIntToInt);
        sampleExtrasHolder.b += readUnsignedIntToInt;
        int i = sampleExtrasHolder.a - readUnsignedIntToInt;
        sampleExtrasHolder.a = i;
        decoderInputBuffer.resetSupplementalData(i);
        h(sampleExtrasHolder.b, decoderInputBuffer.supplementalData, sampleExtrasHolder.a);
    }

    public void l() {
        b(this.d);
        com.google.android.exoplayer2.source.SampleDataQueue.AllocationNode allocationNode = new com.google.android.exoplayer2.source.SampleDataQueue.AllocationNode(0L, this.b);
        this.d = allocationNode;
        this.e = allocationNode;
        this.f = allocationNode;
        this.g = 0L;
        this.a.trim();
    }

    public void m() {
        this.e = this.d;
    }

    public int n(com.google.android.exoplayer2.upstream.DataReader dataReader, int i, boolean z) throws java.io.IOException {
        int g = g(i);
        com.google.android.exoplayer2.source.SampleDataQueue.AllocationNode allocationNode = this.f;
        int read = dataReader.read(allocationNode.d.data, allocationNode.c(this.g), g);
        if (read != -1) {
            f(read);
            return read;
        }
        if (z) {
            return -1;
        }
        throw new java.io.EOFException();
    }

    public void o(com.google.android.exoplayer2.util.ParsableByteArray parsableByteArray, int i) {
        while (i > 0) {
            int g = g(i);
            com.google.android.exoplayer2.source.SampleDataQueue.AllocationNode allocationNode = this.f;
            parsableByteArray.readBytes(allocationNode.d.data, allocationNode.c(this.g), g);
            i -= g;
            f(g);
        }
    }
}
