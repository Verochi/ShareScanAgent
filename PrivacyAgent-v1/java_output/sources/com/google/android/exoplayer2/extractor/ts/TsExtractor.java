package com.google.android.exoplayer2.extractor.ts;

/* loaded from: classes22.dex */
public final class TsExtractor implements com.google.android.exoplayer2.extractor.Extractor {
    public static final int DEFAULT_TIMESTAMP_SEARCH_BYTES = 112800;
    public static final com.google.android.exoplayer2.extractor.ExtractorsFactory FACTORY = new defpackage.c43();
    public static final int MODE_HLS = 2;
    public static final int MODE_MULTI_PMT = 0;
    public static final int MODE_SINGLE_PMT = 1;
    public static final int TS_PACKET_SIZE = 188;
    public static final int TS_STREAM_TYPE_AAC_ADTS = 15;
    public static final int TS_STREAM_TYPE_AAC_LATM = 17;
    public static final int TS_STREAM_TYPE_AC3 = 129;
    public static final int TS_STREAM_TYPE_AC4 = 172;
    public static final int TS_STREAM_TYPE_AIT = 257;
    public static final int TS_STREAM_TYPE_DTS = 138;
    public static final int TS_STREAM_TYPE_DVBSUBS = 89;
    public static final int TS_STREAM_TYPE_E_AC3 = 135;
    public static final int TS_STREAM_TYPE_H262 = 2;
    public static final int TS_STREAM_TYPE_H263 = 16;
    public static final int TS_STREAM_TYPE_H264 = 27;
    public static final int TS_STREAM_TYPE_H265 = 36;
    public static final int TS_STREAM_TYPE_HDMV_DTS = 130;
    public static final int TS_STREAM_TYPE_ID3 = 21;
    public static final int TS_STREAM_TYPE_MPA = 3;
    public static final int TS_STREAM_TYPE_MPA_LSF = 4;
    public static final int TS_STREAM_TYPE_SPLICE_INFO = 134;
    public static final int TS_SYNC_BYTE = 71;
    public final int a;
    public final int b;
    public final java.util.List<com.google.android.exoplayer2.util.TimestampAdjuster> c;
    public final com.google.android.exoplayer2.util.ParsableByteArray d;
    public final android.util.SparseIntArray e;
    public final com.google.android.exoplayer2.extractor.ts.TsPayloadReader.Factory f;
    public final android.util.SparseArray<com.google.android.exoplayer2.extractor.ts.TsPayloadReader> g;
    public final android.util.SparseBooleanArray h;
    public final android.util.SparseBooleanArray i;
    public final com.google.android.exoplayer2.extractor.ts.TsDurationReader j;
    public com.google.android.exoplayer2.extractor.ts.TsBinarySearchSeeker k;
    public com.google.android.exoplayer2.extractor.ExtractorOutput l;
    public int m;
    public boolean n;
    public boolean o;
    public boolean p;
    public com.google.android.exoplayer2.extractor.ts.TsPayloadReader q;
    public int r;

    /* renamed from: s, reason: collision with root package name */
    public int f356s;

    @java.lang.annotation.Documented
    @java.lang.annotation.Retention(java.lang.annotation.RetentionPolicy.SOURCE)
    public @interface Mode {
    }

    public class PatReader implements com.google.android.exoplayer2.extractor.ts.SectionPayloadReader {
        public final com.google.android.exoplayer2.util.ParsableBitArray a = new com.google.android.exoplayer2.util.ParsableBitArray(new byte[4]);

        public PatReader() {
        }

        @Override // com.google.android.exoplayer2.extractor.ts.SectionPayloadReader
        public void consume(com.google.android.exoplayer2.util.ParsableByteArray parsableByteArray) {
            if (parsableByteArray.readUnsignedByte() == 0 && (parsableByteArray.readUnsignedByte() & 128) != 0) {
                parsableByteArray.skipBytes(6);
                int bytesLeft = parsableByteArray.bytesLeft() / 4;
                for (int i = 0; i < bytesLeft; i++) {
                    parsableByteArray.readBytes(this.a, 4);
                    int readBits = this.a.readBits(16);
                    this.a.skipBits(3);
                    if (readBits == 0) {
                        this.a.skipBits(13);
                    } else {
                        int readBits2 = this.a.readBits(13);
                        if (com.google.android.exoplayer2.extractor.ts.TsExtractor.this.g.get(readBits2) == null) {
                            com.google.android.exoplayer2.extractor.ts.TsExtractor.this.g.put(readBits2, new com.google.android.exoplayer2.extractor.ts.SectionReader(com.google.android.exoplayer2.extractor.ts.TsExtractor.this.new PmtReader(readBits2)));
                            com.google.android.exoplayer2.extractor.ts.TsExtractor.g(com.google.android.exoplayer2.extractor.ts.TsExtractor.this);
                        }
                    }
                }
                if (com.google.android.exoplayer2.extractor.ts.TsExtractor.this.a != 2) {
                    com.google.android.exoplayer2.extractor.ts.TsExtractor.this.g.remove(0);
                }
            }
        }

        @Override // com.google.android.exoplayer2.extractor.ts.SectionPayloadReader
        public void init(com.google.android.exoplayer2.util.TimestampAdjuster timestampAdjuster, com.google.android.exoplayer2.extractor.ExtractorOutput extractorOutput, com.google.android.exoplayer2.extractor.ts.TsPayloadReader.TrackIdGenerator trackIdGenerator) {
        }
    }

    public class PmtReader implements com.google.android.exoplayer2.extractor.ts.SectionPayloadReader {
        public final com.google.android.exoplayer2.util.ParsableBitArray a = new com.google.android.exoplayer2.util.ParsableBitArray(new byte[5]);
        public final android.util.SparseArray<com.google.android.exoplayer2.extractor.ts.TsPayloadReader> b = new android.util.SparseArray<>();
        public final android.util.SparseIntArray c = new android.util.SparseIntArray();
        public final int d;

        public PmtReader(int i) {
            this.d = i;
        }

        public final com.google.android.exoplayer2.extractor.ts.TsPayloadReader.EsInfo a(com.google.android.exoplayer2.util.ParsableByteArray parsableByteArray, int i) {
            int position = parsableByteArray.getPosition();
            int i2 = i + position;
            int i3 = -1;
            java.lang.String str = null;
            java.util.ArrayList arrayList = null;
            while (parsableByteArray.getPosition() < i2) {
                int readUnsignedByte = parsableByteArray.readUnsignedByte();
                int position2 = parsableByteArray.getPosition() + parsableByteArray.readUnsignedByte();
                if (position2 > i2) {
                    break;
                }
                if (readUnsignedByte == 5) {
                    long readUnsignedInt = parsableByteArray.readUnsignedInt();
                    if (readUnsignedInt != 1094921523) {
                        if (readUnsignedInt != 1161904947) {
                            if (readUnsignedInt != 1094921524) {
                                if (readUnsignedInt == 1212503619) {
                                    i3 = 36;
                                }
                            }
                            i3 = com.google.android.exoplayer2.extractor.ts.TsExtractor.TS_STREAM_TYPE_AC4;
                        }
                        i3 = 135;
                    }
                    i3 = 129;
                } else {
                    if (readUnsignedByte != 106) {
                        if (readUnsignedByte != 122) {
                            if (readUnsignedByte == 127) {
                                if (parsableByteArray.readUnsignedByte() != 21) {
                                }
                                i3 = com.google.android.exoplayer2.extractor.ts.TsExtractor.TS_STREAM_TYPE_AC4;
                            } else if (readUnsignedByte == 123) {
                                i3 = 138;
                            } else if (readUnsignedByte == 10) {
                                str = parsableByteArray.readString(3).trim();
                            } else if (readUnsignedByte == 89) {
                                java.util.ArrayList arrayList2 = new java.util.ArrayList();
                                while (parsableByteArray.getPosition() < position2) {
                                    java.lang.String trim = parsableByteArray.readString(3).trim();
                                    int readUnsignedByte2 = parsableByteArray.readUnsignedByte();
                                    byte[] bArr = new byte[4];
                                    parsableByteArray.readBytes(bArr, 0, 4);
                                    arrayList2.add(new com.google.android.exoplayer2.extractor.ts.TsPayloadReader.DvbSubtitleInfo(trim, readUnsignedByte2, bArr));
                                }
                                arrayList = arrayList2;
                                i3 = 89;
                            } else if (readUnsignedByte == 111) {
                                i3 = 257;
                            }
                        }
                        i3 = 135;
                    }
                    i3 = 129;
                }
                parsableByteArray.skipBytes(position2 - parsableByteArray.getPosition());
            }
            parsableByteArray.setPosition(i2);
            return new com.google.android.exoplayer2.extractor.ts.TsPayloadReader.EsInfo(i3, str, arrayList, java.util.Arrays.copyOfRange(parsableByteArray.getData(), position, i2));
        }

        @Override // com.google.android.exoplayer2.extractor.ts.SectionPayloadReader
        public void consume(com.google.android.exoplayer2.util.ParsableByteArray parsableByteArray) {
            com.google.android.exoplayer2.util.TimestampAdjuster timestampAdjuster;
            if (parsableByteArray.readUnsignedByte() != 2) {
                return;
            }
            if (com.google.android.exoplayer2.extractor.ts.TsExtractor.this.a == 1 || com.google.android.exoplayer2.extractor.ts.TsExtractor.this.a == 2 || com.google.android.exoplayer2.extractor.ts.TsExtractor.this.m == 1) {
                timestampAdjuster = (com.google.android.exoplayer2.util.TimestampAdjuster) com.google.android.exoplayer2.extractor.ts.TsExtractor.this.c.get(0);
            } else {
                timestampAdjuster = new com.google.android.exoplayer2.util.TimestampAdjuster(((com.google.android.exoplayer2.util.TimestampAdjuster) com.google.android.exoplayer2.extractor.ts.TsExtractor.this.c.get(0)).getFirstSampleTimestampUs());
                com.google.android.exoplayer2.extractor.ts.TsExtractor.this.c.add(timestampAdjuster);
            }
            if ((parsableByteArray.readUnsignedByte() & 128) == 0) {
                return;
            }
            parsableByteArray.skipBytes(1);
            int readUnsignedShort = parsableByteArray.readUnsignedShort();
            int i = 3;
            parsableByteArray.skipBytes(3);
            parsableByteArray.readBytes(this.a, 2);
            this.a.skipBits(3);
            int i2 = 13;
            com.google.android.exoplayer2.extractor.ts.TsExtractor.this.f356s = this.a.readBits(13);
            parsableByteArray.readBytes(this.a, 2);
            int i3 = 4;
            this.a.skipBits(4);
            parsableByteArray.skipBytes(this.a.readBits(12));
            if (com.google.android.exoplayer2.extractor.ts.TsExtractor.this.a == 2 && com.google.android.exoplayer2.extractor.ts.TsExtractor.this.q == null) {
                com.google.android.exoplayer2.extractor.ts.TsPayloadReader.EsInfo esInfo = new com.google.android.exoplayer2.extractor.ts.TsPayloadReader.EsInfo(21, null, null, com.google.android.exoplayer2.util.Util.EMPTY_BYTE_ARRAY);
                com.google.android.exoplayer2.extractor.ts.TsExtractor tsExtractor = com.google.android.exoplayer2.extractor.ts.TsExtractor.this;
                tsExtractor.q = tsExtractor.f.createPayloadReader(21, esInfo);
                com.google.android.exoplayer2.extractor.ts.TsExtractor.this.q.init(timestampAdjuster, com.google.android.exoplayer2.extractor.ts.TsExtractor.this.l, new com.google.android.exoplayer2.extractor.ts.TsPayloadReader.TrackIdGenerator(readUnsignedShort, 21, 8192));
            }
            this.b.clear();
            this.c.clear();
            int bytesLeft = parsableByteArray.bytesLeft();
            while (bytesLeft > 0) {
                parsableByteArray.readBytes(this.a, 5);
                int readBits = this.a.readBits(8);
                this.a.skipBits(i);
                int readBits2 = this.a.readBits(i2);
                this.a.skipBits(i3);
                int readBits3 = this.a.readBits(12);
                com.google.android.exoplayer2.extractor.ts.TsPayloadReader.EsInfo a = a(parsableByteArray, readBits3);
                if (readBits == 6 || readBits == 5) {
                    readBits = a.streamType;
                }
                bytesLeft -= readBits3 + 5;
                int i4 = com.google.android.exoplayer2.extractor.ts.TsExtractor.this.a == 2 ? readBits : readBits2;
                if (!com.google.android.exoplayer2.extractor.ts.TsExtractor.this.h.get(i4)) {
                    com.google.android.exoplayer2.extractor.ts.TsPayloadReader createPayloadReader = (com.google.android.exoplayer2.extractor.ts.TsExtractor.this.a == 2 && readBits == 21) ? com.google.android.exoplayer2.extractor.ts.TsExtractor.this.q : com.google.android.exoplayer2.extractor.ts.TsExtractor.this.f.createPayloadReader(readBits, a);
                    if (com.google.android.exoplayer2.extractor.ts.TsExtractor.this.a != 2 || readBits2 < this.c.get(i4, 8192)) {
                        this.c.put(i4, readBits2);
                        this.b.put(i4, createPayloadReader);
                    }
                }
                i = 3;
                i3 = 4;
                i2 = 13;
            }
            int size = this.c.size();
            for (int i5 = 0; i5 < size; i5++) {
                int keyAt = this.c.keyAt(i5);
                int valueAt = this.c.valueAt(i5);
                com.google.android.exoplayer2.extractor.ts.TsExtractor.this.h.put(keyAt, true);
                com.google.android.exoplayer2.extractor.ts.TsExtractor.this.i.put(valueAt, true);
                com.google.android.exoplayer2.extractor.ts.TsPayloadReader valueAt2 = this.b.valueAt(i5);
                if (valueAt2 != null) {
                    if (valueAt2 != com.google.android.exoplayer2.extractor.ts.TsExtractor.this.q) {
                        valueAt2.init(timestampAdjuster, com.google.android.exoplayer2.extractor.ts.TsExtractor.this.l, new com.google.android.exoplayer2.extractor.ts.TsPayloadReader.TrackIdGenerator(readUnsignedShort, keyAt, 8192));
                    }
                    com.google.android.exoplayer2.extractor.ts.TsExtractor.this.g.put(valueAt, valueAt2);
                }
            }
            if (com.google.android.exoplayer2.extractor.ts.TsExtractor.this.a == 2) {
                if (com.google.android.exoplayer2.extractor.ts.TsExtractor.this.n) {
                    return;
                }
                com.google.android.exoplayer2.extractor.ts.TsExtractor.this.l.endTracks();
                com.google.android.exoplayer2.extractor.ts.TsExtractor.this.m = 0;
                com.google.android.exoplayer2.extractor.ts.TsExtractor.this.n = true;
                return;
            }
            com.google.android.exoplayer2.extractor.ts.TsExtractor.this.g.remove(this.d);
            com.google.android.exoplayer2.extractor.ts.TsExtractor tsExtractor2 = com.google.android.exoplayer2.extractor.ts.TsExtractor.this;
            tsExtractor2.m = tsExtractor2.a == 1 ? 0 : com.google.android.exoplayer2.extractor.ts.TsExtractor.this.m - 1;
            if (com.google.android.exoplayer2.extractor.ts.TsExtractor.this.m == 0) {
                com.google.android.exoplayer2.extractor.ts.TsExtractor.this.l.endTracks();
                com.google.android.exoplayer2.extractor.ts.TsExtractor.this.n = true;
            }
        }

        @Override // com.google.android.exoplayer2.extractor.ts.SectionPayloadReader
        public void init(com.google.android.exoplayer2.util.TimestampAdjuster timestampAdjuster, com.google.android.exoplayer2.extractor.ExtractorOutput extractorOutput, com.google.android.exoplayer2.extractor.ts.TsPayloadReader.TrackIdGenerator trackIdGenerator) {
        }
    }

    public TsExtractor() {
        this(0);
    }

    public TsExtractor(int i) {
        this(1, i, DEFAULT_TIMESTAMP_SEARCH_BYTES);
    }

    public TsExtractor(int i, int i2, int i3) {
        this(i, new com.google.android.exoplayer2.util.TimestampAdjuster(0L), new com.google.android.exoplayer2.extractor.ts.DefaultTsPayloadReaderFactory(i2), i3);
    }

    public TsExtractor(int i, com.google.android.exoplayer2.util.TimestampAdjuster timestampAdjuster, com.google.android.exoplayer2.extractor.ts.TsPayloadReader.Factory factory) {
        this(i, timestampAdjuster, factory, DEFAULT_TIMESTAMP_SEARCH_BYTES);
    }

    public TsExtractor(int i, com.google.android.exoplayer2.util.TimestampAdjuster timestampAdjuster, com.google.android.exoplayer2.extractor.ts.TsPayloadReader.Factory factory, int i2) {
        this.f = (com.google.android.exoplayer2.extractor.ts.TsPayloadReader.Factory) com.google.android.exoplayer2.util.Assertions.checkNotNull(factory);
        this.b = i2;
        this.a = i;
        if (i == 1 || i == 2) {
            this.c = java.util.Collections.singletonList(timestampAdjuster);
        } else {
            java.util.ArrayList arrayList = new java.util.ArrayList();
            this.c = arrayList;
            arrayList.add(timestampAdjuster);
        }
        this.d = new com.google.android.exoplayer2.util.ParsableByteArray(new byte[9400], 0);
        this.h = new android.util.SparseBooleanArray();
        this.i = new android.util.SparseBooleanArray();
        this.g = new android.util.SparseArray<>();
        this.e = new android.util.SparseIntArray();
        this.j = new com.google.android.exoplayer2.extractor.ts.TsDurationReader(i2);
        this.f356s = -1;
        u();
    }

    public static /* synthetic */ int g(com.google.android.exoplayer2.extractor.ts.TsExtractor tsExtractor) {
        int i = tsExtractor.m;
        tsExtractor.m = i + 1;
        return i;
    }

    public static /* synthetic */ com.google.android.exoplayer2.extractor.Extractor[] s() {
        return new com.google.android.exoplayer2.extractor.Extractor[]{new com.google.android.exoplayer2.extractor.ts.TsExtractor()};
    }

    @Override // com.google.android.exoplayer2.extractor.Extractor
    public void init(com.google.android.exoplayer2.extractor.ExtractorOutput extractorOutput) {
        this.l = extractorOutput;
    }

    public final boolean q(com.google.android.exoplayer2.extractor.ExtractorInput extractorInput) throws java.io.IOException {
        byte[] data = this.d.getData();
        if (9400 - this.d.getPosition() < 188) {
            int bytesLeft = this.d.bytesLeft();
            if (bytesLeft > 0) {
                java.lang.System.arraycopy(data, this.d.getPosition(), data, 0, bytesLeft);
            }
            this.d.reset(data, bytesLeft);
        }
        while (this.d.bytesLeft() < 188) {
            int limit = this.d.limit();
            int read = extractorInput.read(data, limit, 9400 - limit);
            if (read == -1) {
                return false;
            }
            this.d.setLimit(limit + read);
        }
        return true;
    }

    public final int r() throws com.google.android.exoplayer2.ParserException {
        int position = this.d.getPosition();
        int limit = this.d.limit();
        int findSyncBytePosition = com.google.android.exoplayer2.extractor.ts.TsUtil.findSyncBytePosition(this.d.getData(), position, limit);
        this.d.setPosition(findSyncBytePosition);
        int i = findSyncBytePosition + TS_PACKET_SIZE;
        if (i > limit) {
            int i2 = this.r + (findSyncBytePosition - position);
            this.r = i2;
            if (this.a == 2 && i2 > 376) {
                throw new com.google.android.exoplayer2.ParserException("Cannot find sync byte. Most likely not a Transport Stream.");
            }
        } else {
            this.r = 0;
        }
        return i;
    }

    @Override // com.google.android.exoplayer2.extractor.Extractor
    public int read(com.google.android.exoplayer2.extractor.ExtractorInput extractorInput, com.google.android.exoplayer2.extractor.PositionHolder positionHolder) throws java.io.IOException {
        long length = extractorInput.getLength();
        if (this.n) {
            if (((length == -1 || this.a == 2) ? false : true) && !this.j.d()) {
                return this.j.e(extractorInput, positionHolder, this.f356s);
            }
            t(length);
            if (this.p) {
                this.p = false;
                seek(0L, 0L);
                if (extractorInput.getPosition() != 0) {
                    positionHolder.position = 0L;
                    return 1;
                }
            }
            com.google.android.exoplayer2.extractor.ts.TsBinarySearchSeeker tsBinarySearchSeeker = this.k;
            if (tsBinarySearchSeeker != null && tsBinarySearchSeeker.isSeeking()) {
                return this.k.handlePendingSeek(extractorInput, positionHolder);
            }
        }
        if (!q(extractorInput)) {
            return -1;
        }
        int r = r();
        int limit = this.d.limit();
        if (r > limit) {
            return 0;
        }
        int readInt = this.d.readInt();
        if ((8388608 & readInt) != 0) {
            this.d.setPosition(r);
            return 0;
        }
        int i = ((4194304 & readInt) != 0 ? 1 : 0) | 0;
        int i2 = (2096896 & readInt) >> 8;
        boolean z = (readInt & 32) != 0;
        com.google.android.exoplayer2.extractor.ts.TsPayloadReader tsPayloadReader = (readInt & 16) != 0 ? this.g.get(i2) : null;
        if (tsPayloadReader == null) {
            this.d.setPosition(r);
            return 0;
        }
        if (this.a != 2) {
            int i3 = readInt & 15;
            int i4 = this.e.get(i2, i3 - 1);
            this.e.put(i2, i3);
            if (i4 == i3) {
                this.d.setPosition(r);
                return 0;
            }
            if (i3 != ((i4 + 1) & 15)) {
                tsPayloadReader.seek();
            }
        }
        if (z) {
            int readUnsignedByte = this.d.readUnsignedByte();
            i |= (this.d.readUnsignedByte() & 64) != 0 ? 2 : 0;
            this.d.skipBytes(readUnsignedByte - 1);
        }
        boolean z2 = this.n;
        if (v(i2)) {
            this.d.setLimit(r);
            tsPayloadReader.consume(this.d, i);
            this.d.setLimit(limit);
        }
        if (this.a != 2 && !z2 && this.n && length != -1) {
            this.p = true;
        }
        this.d.setPosition(r);
        return 0;
    }

    @Override // com.google.android.exoplayer2.extractor.Extractor
    public void release() {
    }

    @Override // com.google.android.exoplayer2.extractor.Extractor
    public void seek(long j, long j2) {
        com.google.android.exoplayer2.extractor.ts.TsBinarySearchSeeker tsBinarySearchSeeker;
        com.google.android.exoplayer2.util.Assertions.checkState(this.a != 2);
        int size = this.c.size();
        for (int i = 0; i < size; i++) {
            com.google.android.exoplayer2.util.TimestampAdjuster timestampAdjuster = this.c.get(i);
            if ((timestampAdjuster.getTimestampOffsetUs() == -9223372036854775807L) || (timestampAdjuster.getTimestampOffsetUs() != 0 && timestampAdjuster.getFirstSampleTimestampUs() != j2)) {
                timestampAdjuster.reset();
                timestampAdjuster.setFirstSampleTimestampUs(j2);
            }
        }
        if (j2 != 0 && (tsBinarySearchSeeker = this.k) != null) {
            tsBinarySearchSeeker.setSeekTargetUs(j2);
        }
        this.d.reset(0);
        this.e.clear();
        for (int i2 = 0; i2 < this.g.size(); i2++) {
            this.g.valueAt(i2).seek();
        }
        this.r = 0;
    }

    @Override // com.google.android.exoplayer2.extractor.Extractor
    public boolean sniff(com.google.android.exoplayer2.extractor.ExtractorInput extractorInput) throws java.io.IOException {
        boolean z;
        byte[] data = this.d.getData();
        extractorInput.peekFully(data, 0, 940);
        for (int i = 0; i < 188; i++) {
            int i2 = 0;
            while (true) {
                if (i2 >= 5) {
                    z = true;
                    break;
                }
                if (data[(i2 * TS_PACKET_SIZE) + i] != 71) {
                    z = false;
                    break;
                }
                i2++;
            }
            if (z) {
                extractorInput.skipFully(i);
                return true;
            }
        }
        return false;
    }

    public final void t(long j) {
        if (this.o) {
            return;
        }
        this.o = true;
        if (this.j.b() == -9223372036854775807L) {
            this.l.seekMap(new com.google.android.exoplayer2.extractor.SeekMap.Unseekable(this.j.b()));
            return;
        }
        com.google.android.exoplayer2.extractor.ts.TsBinarySearchSeeker tsBinarySearchSeeker = new com.google.android.exoplayer2.extractor.ts.TsBinarySearchSeeker(this.j.c(), this.j.b(), j, this.f356s, this.b);
        this.k = tsBinarySearchSeeker;
        this.l.seekMap(tsBinarySearchSeeker.getSeekMap());
    }

    public final void u() {
        this.h.clear();
        this.g.clear();
        android.util.SparseArray<com.google.android.exoplayer2.extractor.ts.TsPayloadReader> createInitialPayloadReaders = this.f.createInitialPayloadReaders();
        int size = createInitialPayloadReaders.size();
        for (int i = 0; i < size; i++) {
            this.g.put(createInitialPayloadReaders.keyAt(i), createInitialPayloadReaders.valueAt(i));
        }
        this.g.put(0, new com.google.android.exoplayer2.extractor.ts.SectionReader(new com.google.android.exoplayer2.extractor.ts.TsExtractor.PatReader()));
        this.q = null;
    }

    public final boolean v(int i) {
        return this.a == 2 || this.n || !this.i.get(i, false);
    }
}
