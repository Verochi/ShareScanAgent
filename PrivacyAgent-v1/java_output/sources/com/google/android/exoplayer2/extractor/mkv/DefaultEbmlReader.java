package com.google.android.exoplayer2.extractor.mkv;

/* loaded from: classes22.dex */
final class DefaultEbmlReader implements com.google.android.exoplayer2.extractor.mkv.EbmlReader {
    public final byte[] a = new byte[8];
    public final java.util.ArrayDeque<com.google.android.exoplayer2.extractor.mkv.DefaultEbmlReader.MasterElement> b = new java.util.ArrayDeque<>();
    public final com.google.android.exoplayer2.extractor.mkv.VarintReader c = new com.google.android.exoplayer2.extractor.mkv.VarintReader();
    public com.google.android.exoplayer2.extractor.mkv.EbmlProcessor d;
    public int e;
    public int f;
    public long g;

    public static final class MasterElement {
        public final int a;
        public final long b;

        public MasterElement(int i, long j) {
            this.a = i;
            this.b = j;
        }

        public /* synthetic */ MasterElement(int i, long j, com.google.android.exoplayer2.extractor.mkv.DefaultEbmlReader.AnonymousClass1 anonymousClass1) {
            this(i, j);
        }
    }

    public static java.lang.String e(com.google.android.exoplayer2.extractor.ExtractorInput extractorInput, int i) throws java.io.IOException {
        if (i == 0) {
            return "";
        }
        byte[] bArr = new byte[i];
        extractorInput.readFully(bArr, 0, i);
        while (i > 0 && bArr[i - 1] == 0) {
            i--;
        }
        return new java.lang.String(bArr, 0, i);
    }

    @Override // com.google.android.exoplayer2.extractor.mkv.EbmlReader
    public void a(com.google.android.exoplayer2.extractor.mkv.EbmlProcessor ebmlProcessor) {
        this.d = ebmlProcessor;
    }

    @org.checkerframework.checker.nullness.qual.RequiresNonNull({"processor"})
    public final long b(com.google.android.exoplayer2.extractor.ExtractorInput extractorInput) throws java.io.IOException {
        extractorInput.resetPeekPosition();
        while (true) {
            extractorInput.peekFully(this.a, 0, 4);
            int c = com.google.android.exoplayer2.extractor.mkv.VarintReader.c(this.a[0]);
            if (c != -1 && c <= 4) {
                int a = (int) com.google.android.exoplayer2.extractor.mkv.VarintReader.a(this.a, c, false);
                if (this.d.isLevel1Element(a)) {
                    extractorInput.skipFully(c);
                    return a;
                }
            }
            extractorInput.skipFully(1);
        }
    }

    public final double c(com.google.android.exoplayer2.extractor.ExtractorInput extractorInput, int i) throws java.io.IOException {
        return i == 4 ? java.lang.Float.intBitsToFloat((int) r0) : java.lang.Double.longBitsToDouble(d(extractorInput, i));
    }

    public final long d(com.google.android.exoplayer2.extractor.ExtractorInput extractorInput, int i) throws java.io.IOException {
        extractorInput.readFully(this.a, 0, i);
        long j = 0;
        for (int i2 = 0; i2 < i; i2++) {
            j = (j << 8) | (this.a[i2] & 255);
        }
        return j;
    }

    @Override // com.google.android.exoplayer2.extractor.mkv.EbmlReader
    public boolean read(com.google.android.exoplayer2.extractor.ExtractorInput extractorInput) throws java.io.IOException {
        com.google.android.exoplayer2.util.Assertions.checkStateNotNull(this.d);
        while (true) {
            com.google.android.exoplayer2.extractor.mkv.DefaultEbmlReader.MasterElement peek = this.b.peek();
            if (peek != null && extractorInput.getPosition() >= peek.b) {
                this.d.endMasterElement(this.b.pop().a);
                return true;
            }
            if (this.e == 0) {
                long d = this.c.d(extractorInput, true, false, 4);
                if (d == -2) {
                    d = b(extractorInput);
                }
                if (d == -1) {
                    return false;
                }
                this.f = (int) d;
                this.e = 1;
            }
            if (this.e == 1) {
                this.g = this.c.d(extractorInput, false, true, 8);
                this.e = 2;
            }
            int elementType = this.d.getElementType(this.f);
            if (elementType != 0) {
                if (elementType == 1) {
                    long position = extractorInput.getPosition();
                    this.b.push(new com.google.android.exoplayer2.extractor.mkv.DefaultEbmlReader.MasterElement(this.f, this.g + position, null));
                    this.d.startMasterElement(this.f, position, this.g);
                    this.e = 0;
                    return true;
                }
                if (elementType == 2) {
                    long j = this.g;
                    if (j <= 8) {
                        this.d.integerElement(this.f, d(extractorInput, (int) j));
                        this.e = 0;
                        return true;
                    }
                    long j2 = this.g;
                    java.lang.StringBuilder sb = new java.lang.StringBuilder(42);
                    sb.append("Invalid integer size: ");
                    sb.append(j2);
                    throw new com.google.android.exoplayer2.ParserException(sb.toString());
                }
                if (elementType == 3) {
                    long j3 = this.g;
                    if (j3 <= 2147483647L) {
                        this.d.stringElement(this.f, e(extractorInput, (int) j3));
                        this.e = 0;
                        return true;
                    }
                    long j4 = this.g;
                    java.lang.StringBuilder sb2 = new java.lang.StringBuilder(41);
                    sb2.append("String element size: ");
                    sb2.append(j4);
                    throw new com.google.android.exoplayer2.ParserException(sb2.toString());
                }
                if (elementType == 4) {
                    this.d.binaryElement(this.f, (int) this.g, extractorInput);
                    this.e = 0;
                    return true;
                }
                if (elementType != 5) {
                    java.lang.StringBuilder sb3 = new java.lang.StringBuilder(32);
                    sb3.append("Invalid element type ");
                    sb3.append(elementType);
                    throw new com.google.android.exoplayer2.ParserException(sb3.toString());
                }
                long j5 = this.g;
                if (j5 == 4 || j5 == 8) {
                    this.d.floatElement(this.f, c(extractorInput, (int) j5));
                    this.e = 0;
                    return true;
                }
                long j6 = this.g;
                java.lang.StringBuilder sb4 = new java.lang.StringBuilder(40);
                sb4.append("Invalid float size: ");
                sb4.append(j6);
                throw new com.google.android.exoplayer2.ParserException(sb4.toString());
            }
            extractorInput.skipFully((int) this.g);
            this.e = 0;
        }
    }

    @Override // com.google.android.exoplayer2.extractor.mkv.EbmlReader
    public void reset() {
        this.e = 0;
        this.b.clear();
        this.c.e();
    }
}
