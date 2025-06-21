package com.google.android.exoplayer2.extractor.mp3;

/* loaded from: classes22.dex */
public final class Mp3Extractor implements com.google.android.exoplayer2.extractor.Extractor {
    public static final int FLAG_DISABLE_ID3_METADATA = 4;
    public static final int FLAG_ENABLE_CONSTANT_BITRATE_SEEKING = 1;
    public static final int FLAG_ENABLE_INDEX_SEEKING = 2;
    public final int a;
    public final long b;
    public final com.google.android.exoplayer2.util.ParsableByteArray c;
    public final com.google.android.exoplayer2.audio.MpegAudioUtil.Header d;
    public final com.google.android.exoplayer2.extractor.GaplessInfoHolder e;
    public final com.google.android.exoplayer2.extractor.Id3Peeker f;
    public final com.google.android.exoplayer2.extractor.TrackOutput g;
    public com.google.android.exoplayer2.extractor.ExtractorOutput h;
    public com.google.android.exoplayer2.extractor.TrackOutput i;
    public com.google.android.exoplayer2.extractor.TrackOutput j;
    public int k;

    @androidx.annotation.Nullable
    public com.google.android.exoplayer2.metadata.Metadata l;
    public long m;
    public long n;
    public long o;
    public int p;
    public com.google.android.exoplayer2.extractor.mp3.Seeker q;
    public boolean r;

    /* renamed from: s, reason: collision with root package name */
    public boolean f350s;
    public long t;
    public static final com.google.android.exoplayer2.extractor.ExtractorsFactory FACTORY = new defpackage.do1();
    public static final com.google.android.exoplayer2.metadata.id3.Id3Decoder.FramePredicate u = new defpackage.eo1();

    @java.lang.annotation.Documented
    @java.lang.annotation.Retention(java.lang.annotation.RetentionPolicy.SOURCE)
    public @interface Flags {
    }

    public Mp3Extractor() {
        this(0);
    }

    public Mp3Extractor(int i) {
        this(i, -9223372036854775807L);
    }

    public Mp3Extractor(int i, long j) {
        this.a = i;
        this.b = j;
        this.c = new com.google.android.exoplayer2.util.ParsableByteArray(10);
        this.d = new com.google.android.exoplayer2.audio.MpegAudioUtil.Header();
        this.e = new com.google.android.exoplayer2.extractor.GaplessInfoHolder();
        this.m = -9223372036854775807L;
        this.f = new com.google.android.exoplayer2.extractor.Id3Peeker();
        com.google.android.exoplayer2.extractor.DummyTrackOutput dummyTrackOutput = new com.google.android.exoplayer2.extractor.DummyTrackOutput();
        this.g = dummyTrackOutput;
        this.j = dummyTrackOutput;
    }

    public static long g(@androidx.annotation.Nullable com.google.android.exoplayer2.metadata.Metadata metadata) {
        if (metadata == null) {
            return -9223372036854775807L;
        }
        int length = metadata.length();
        for (int i = 0; i < length; i++) {
            com.google.android.exoplayer2.metadata.Metadata.Entry entry = metadata.get(i);
            if (entry instanceof com.google.android.exoplayer2.metadata.id3.TextInformationFrame) {
                com.google.android.exoplayer2.metadata.id3.TextInformationFrame textInformationFrame = (com.google.android.exoplayer2.metadata.id3.TextInformationFrame) entry;
                if (textInformationFrame.id.equals("TLEN")) {
                    return com.google.android.exoplayer2.C.msToUs(java.lang.Long.parseLong(textInformationFrame.value));
                }
            }
        }
        return -9223372036854775807L;
    }

    public static int h(com.google.android.exoplayer2.util.ParsableByteArray parsableByteArray, int i) {
        if (parsableByteArray.limit() >= i + 4) {
            parsableByteArray.setPosition(i);
            int readInt = parsableByteArray.readInt();
            if (readInt == 1483304551 || readInt == 1231971951) {
                return readInt;
            }
        }
        if (parsableByteArray.limit() < 40) {
            return 0;
        }
        parsableByteArray.setPosition(36);
        return parsableByteArray.readInt() == 1447187017 ? 1447187017 : 0;
    }

    public static boolean i(int i, long j) {
        return ((long) (i & (-128000))) == (j & (-128000));
    }

    public static /* synthetic */ com.google.android.exoplayer2.extractor.Extractor[] j() {
        return new com.google.android.exoplayer2.extractor.Extractor[]{new com.google.android.exoplayer2.extractor.mp3.Mp3Extractor()};
    }

    public static /* synthetic */ boolean k(int i, int i2, int i3, int i4, int i5) {
        return (i2 == 67 && i3 == 79 && i4 == 77 && (i5 == 77 || i == 2)) || (i2 == 77 && i3 == 76 && i4 == 76 && (i5 == 84 || i == 2));
    }

    @androidx.annotation.Nullable
    public static com.google.android.exoplayer2.extractor.mp3.MlltSeeker l(@androidx.annotation.Nullable com.google.android.exoplayer2.metadata.Metadata metadata, long j) {
        if (metadata == null) {
            return null;
        }
        int length = metadata.length();
        for (int i = 0; i < length; i++) {
            com.google.android.exoplayer2.metadata.Metadata.Entry entry = metadata.get(i);
            if (entry instanceof com.google.android.exoplayer2.metadata.id3.MlltFrame) {
                return com.google.android.exoplayer2.extractor.mp3.MlltSeeker.a(j, (com.google.android.exoplayer2.metadata.id3.MlltFrame) entry, g(metadata));
            }
        }
        return null;
    }

    @org.checkerframework.checker.nullness.qual.EnsuresNonNull({"extractorOutput", "realTrackOutput"})
    public final void c() {
        com.google.android.exoplayer2.util.Assertions.checkStateNotNull(this.i);
        com.google.android.exoplayer2.util.Util.castNonNull(this.h);
    }

    public final com.google.android.exoplayer2.extractor.mp3.Seeker d(com.google.android.exoplayer2.extractor.ExtractorInput extractorInput) throws java.io.IOException {
        long g;
        long j;
        com.google.android.exoplayer2.extractor.mp3.Seeker m = m(extractorInput);
        com.google.android.exoplayer2.extractor.mp3.MlltSeeker l = l(this.l, extractorInput.getPosition());
        if (this.r) {
            return new com.google.android.exoplayer2.extractor.mp3.Seeker.UnseekableSeeker();
        }
        if ((this.a & 2) != 0) {
            if (l != null) {
                g = l.getDurationUs();
                j = l.getDataEndPosition();
            } else if (m != null) {
                g = m.getDurationUs();
                j = m.getDataEndPosition();
            } else {
                g = g(this.l);
                j = -1;
            }
            m = new com.google.android.exoplayer2.extractor.mp3.IndexSeeker(g, extractorInput.getPosition(), j);
        } else if (l != null) {
            m = l;
        } else if (m == null) {
            m = null;
        }
        return (m == null || !(m.isSeekable() || (this.a & 1) == 0)) ? f(extractorInput) : m;
    }

    public void disableSeeking() {
        this.r = true;
    }

    public final long e(long j) {
        return this.m + ((j * 1000000) / this.d.sampleRate);
    }

    public final com.google.android.exoplayer2.extractor.mp3.Seeker f(com.google.android.exoplayer2.extractor.ExtractorInput extractorInput) throws java.io.IOException {
        extractorInput.peekFully(this.c.getData(), 0, 4);
        this.c.setPosition(0);
        this.d.setForHeaderData(this.c.readInt());
        return new com.google.android.exoplayer2.extractor.mp3.ConstantBitrateSeeker(extractorInput.getLength(), extractorInput.getPosition(), this.d);
    }

    @Override // com.google.android.exoplayer2.extractor.Extractor
    public void init(com.google.android.exoplayer2.extractor.ExtractorOutput extractorOutput) {
        this.h = extractorOutput;
        com.google.android.exoplayer2.extractor.TrackOutput track = extractorOutput.track(0, 1);
        this.i = track;
        this.j = track;
        this.h.endTracks();
    }

    @androidx.annotation.Nullable
    public final com.google.android.exoplayer2.extractor.mp3.Seeker m(com.google.android.exoplayer2.extractor.ExtractorInput extractorInput) throws java.io.IOException {
        int i;
        com.google.android.exoplayer2.util.ParsableByteArray parsableByteArray = new com.google.android.exoplayer2.util.ParsableByteArray(this.d.frameSize);
        extractorInput.peekFully(parsableByteArray.getData(), 0, this.d.frameSize);
        com.google.android.exoplayer2.audio.MpegAudioUtil.Header header = this.d;
        if ((header.version & 1) != 0) {
            if (header.channels != 1) {
                i = 36;
            }
            i = 21;
        } else {
            if (header.channels == 1) {
                i = 13;
            }
            i = 21;
        }
        int h = h(parsableByteArray, i);
        if (h != 1483304551 && h != 1231971951) {
            if (h != 1447187017) {
                extractorInput.resetPeekPosition();
                return null;
            }
            com.google.android.exoplayer2.extractor.mp3.VbriSeeker a = com.google.android.exoplayer2.extractor.mp3.VbriSeeker.a(extractorInput.getLength(), extractorInput.getPosition(), this.d, parsableByteArray);
            extractorInput.skipFully(this.d.frameSize);
            return a;
        }
        com.google.android.exoplayer2.extractor.mp3.XingSeeker a2 = com.google.android.exoplayer2.extractor.mp3.XingSeeker.a(extractorInput.getLength(), extractorInput.getPosition(), this.d, parsableByteArray);
        if (a2 != null && !this.e.hasGaplessInfo()) {
            extractorInput.resetPeekPosition();
            extractorInput.advancePeekPosition(i + com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField.CALL_DOWNLOAD_MODEL_SET_BACKUP_URLS);
            extractorInput.peekFully(this.c.getData(), 0, 3);
            this.c.setPosition(0);
            this.e.setFromXingHeaderValue(this.c.readUnsignedInt24());
        }
        extractorInput.skipFully(this.d.frameSize);
        return (a2 == null || a2.isSeekable() || h != 1231971951) ? a2 : f(extractorInput);
    }

    public final boolean n(com.google.android.exoplayer2.extractor.ExtractorInput extractorInput) throws java.io.IOException {
        com.google.android.exoplayer2.extractor.mp3.Seeker seeker = this.q;
        if (seeker != null) {
            long dataEndPosition = seeker.getDataEndPosition();
            if (dataEndPosition != -1 && extractorInput.getPeekPosition() > dataEndPosition - 4) {
                return true;
            }
        }
        try {
            return !extractorInput.peekFully(this.c.getData(), 0, 4, true);
        } catch (java.io.EOFException unused) {
            return true;
        }
    }

    @org.checkerframework.checker.nullness.qual.RequiresNonNull({"extractorOutput", "realTrackOutput"})
    public final int o(com.google.android.exoplayer2.extractor.ExtractorInput extractorInput) throws java.io.IOException {
        if (this.k == 0) {
            try {
                q(extractorInput, false);
            } catch (java.io.EOFException unused) {
                return -1;
            }
        }
        if (this.q == null) {
            com.google.android.exoplayer2.extractor.mp3.Seeker d = d(extractorInput);
            this.q = d;
            this.h.seekMap(d);
            this.j.format(new com.google.android.exoplayer2.Format.Builder().setSampleMimeType(this.d.mimeType).setMaxInputSize(4096).setChannelCount(this.d.channels).setSampleRate(this.d.sampleRate).setEncoderDelay(this.e.encoderDelay).setEncoderPadding(this.e.encoderPadding).setMetadata((this.a & 4) != 0 ? null : this.l).build());
            this.o = extractorInput.getPosition();
        } else if (this.o != 0) {
            long position = extractorInput.getPosition();
            long j = this.o;
            if (position < j) {
                extractorInput.skipFully((int) (j - position));
            }
        }
        return p(extractorInput);
    }

    @org.checkerframework.checker.nullness.qual.RequiresNonNull({"realTrackOutput", "seeker"})
    public final int p(com.google.android.exoplayer2.extractor.ExtractorInput extractorInput) throws java.io.IOException {
        if (this.p == 0) {
            extractorInput.resetPeekPosition();
            if (n(extractorInput)) {
                return -1;
            }
            this.c.setPosition(0);
            int readInt = this.c.readInt();
            if (!i(readInt, this.k) || com.google.android.exoplayer2.audio.MpegAudioUtil.getFrameSize(readInt) == -1) {
                extractorInput.skipFully(1);
                this.k = 0;
                return 0;
            }
            this.d.setForHeaderData(readInt);
            if (this.m == -9223372036854775807L) {
                this.m = this.q.getTimeUs(extractorInput.getPosition());
                if (this.b != -9223372036854775807L) {
                    this.m += this.b - this.q.getTimeUs(0L);
                }
            }
            this.p = this.d.frameSize;
            com.google.android.exoplayer2.extractor.mp3.Seeker seeker = this.q;
            if (seeker instanceof com.google.android.exoplayer2.extractor.mp3.IndexSeeker) {
                com.google.android.exoplayer2.extractor.mp3.IndexSeeker indexSeeker = (com.google.android.exoplayer2.extractor.mp3.IndexSeeker) seeker;
                indexSeeker.b(e(this.n + r0.samplesPerFrame), extractorInput.getPosition() + this.d.frameSize);
                if (this.f350s && indexSeeker.a(this.t)) {
                    this.f350s = false;
                    this.j = this.i;
                }
            }
        }
        int sampleData = this.j.sampleData((com.google.android.exoplayer2.upstream.DataReader) extractorInput, this.p, true);
        if (sampleData == -1) {
            return -1;
        }
        int i = this.p - sampleData;
        this.p = i;
        if (i > 0) {
            return 0;
        }
        this.j.sampleMetadata(e(this.n), 1, this.d.frameSize, 0, null);
        this.n += this.d.samplesPerFrame;
        this.p = 0;
        return 0;
    }

    /* JADX WARN: Code restructure failed: missing block: B:49:0x009d, code lost:
    
        if (r13 == false) goto L51;
     */
    /* JADX WARN: Code restructure failed: missing block: B:50:0x009f, code lost:
    
        r12.skipFully(r2 + r4);
     */
    /* JADX WARN: Code restructure failed: missing block: B:51:0x00a7, code lost:
    
        r11.k = r1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:52:0x00a9, code lost:
    
        return true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:53:0x00a4, code lost:
    
        r12.resetPeekPosition();
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final boolean q(com.google.android.exoplayer2.extractor.ExtractorInput extractorInput, boolean z) throws java.io.IOException {
        int i;
        int i2;
        int frameSize;
        int i3 = z ? 32768 : 131072;
        extractorInput.resetPeekPosition();
        if (extractorInput.getPosition() == 0) {
            com.google.android.exoplayer2.metadata.Metadata peekId3Data = this.f.peekId3Data(extractorInput, (this.a & 4) == 0 ? null : u);
            this.l = peekId3Data;
            if (peekId3Data != null) {
                this.e.setFromMetadata(peekId3Data);
            }
            i2 = (int) extractorInput.getPeekPosition();
            if (!z) {
                extractorInput.skipFully(i2);
            }
            i = 0;
        } else {
            i = 0;
            i2 = 0;
        }
        int i4 = 0;
        int i5 = 0;
        while (true) {
            if (!n(extractorInput)) {
                this.c.setPosition(0);
                int readInt = this.c.readInt();
                if ((i == 0 || i(readInt, i)) && (frameSize = com.google.android.exoplayer2.audio.MpegAudioUtil.getFrameSize(readInt)) != -1) {
                    i4++;
                    if (i4 != 1) {
                        if (i4 == 4) {
                            break;
                        }
                    } else {
                        this.d.setForHeaderData(readInt);
                        i = readInt;
                    }
                    extractorInput.advancePeekPosition(frameSize - 4);
                } else {
                    int i6 = i5 + 1;
                    if (i5 == i3) {
                        if (z) {
                            return false;
                        }
                        throw new com.google.android.exoplayer2.ParserException("Searched too many bytes.");
                    }
                    if (z) {
                        extractorInput.resetPeekPosition();
                        extractorInput.advancePeekPosition(i2 + i6);
                    } else {
                        extractorInput.skipFully(1);
                    }
                    i5 = i6;
                    i = 0;
                    i4 = 0;
                }
            } else if (i4 <= 0) {
                throw new java.io.EOFException();
            }
        }
    }

    @Override // com.google.android.exoplayer2.extractor.Extractor
    public int read(com.google.android.exoplayer2.extractor.ExtractorInput extractorInput, com.google.android.exoplayer2.extractor.PositionHolder positionHolder) throws java.io.IOException {
        c();
        int o = o(extractorInput);
        if (o == -1 && (this.q instanceof com.google.android.exoplayer2.extractor.mp3.IndexSeeker)) {
            long e = e(this.n);
            if (this.q.getDurationUs() != e) {
                ((com.google.android.exoplayer2.extractor.mp3.IndexSeeker) this.q).c(e);
                this.h.seekMap(this.q);
            }
        }
        return o;
    }

    @Override // com.google.android.exoplayer2.extractor.Extractor
    public void release() {
    }

    @Override // com.google.android.exoplayer2.extractor.Extractor
    public void seek(long j, long j2) {
        this.k = 0;
        this.m = -9223372036854775807L;
        this.n = 0L;
        this.p = 0;
        this.t = j2;
        com.google.android.exoplayer2.extractor.mp3.Seeker seeker = this.q;
        if (!(seeker instanceof com.google.android.exoplayer2.extractor.mp3.IndexSeeker) || ((com.google.android.exoplayer2.extractor.mp3.IndexSeeker) seeker).a(j2)) {
            return;
        }
        this.f350s = true;
        this.j = this.g;
    }

    @Override // com.google.android.exoplayer2.extractor.Extractor
    public boolean sniff(com.google.android.exoplayer2.extractor.ExtractorInput extractorInput) throws java.io.IOException {
        return q(extractorInput, true);
    }
}
