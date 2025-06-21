package com.google.android.exoplayer2.extractor.mp4;

/* loaded from: classes22.dex */
public final class Mp4Extractor implements com.google.android.exoplayer2.extractor.Extractor, com.google.android.exoplayer2.extractor.SeekMap {
    public static final com.google.android.exoplayer2.extractor.ExtractorsFactory FACTORY = new defpackage.fo1();
    public static final int FLAG_WORKAROUND_IGNORE_EDIT_LISTS = 1;
    public final int a;
    public final com.google.android.exoplayer2.util.ParsableByteArray b;
    public final com.google.android.exoplayer2.util.ParsableByteArray c;
    public final com.google.android.exoplayer2.util.ParsableByteArray d;
    public final com.google.android.exoplayer2.util.ParsableByteArray e;
    public final java.util.ArrayDeque<com.google.android.exoplayer2.extractor.mp4.Atom.ContainerAtom> f;
    public int g;
    public int h;
    public long i;
    public int j;

    @androidx.annotation.Nullable
    public com.google.android.exoplayer2.util.ParsableByteArray k;
    public int l;
    public int m;
    public int n;
    public int o;
    public com.google.android.exoplayer2.extractor.ExtractorOutput p;
    public com.google.android.exoplayer2.extractor.mp4.Mp4Extractor.Mp4Track[] q;
    public long[][] r;

    /* renamed from: s, reason: collision with root package name */
    public int f352s;
    public long t;
    public boolean u;

    @java.lang.annotation.Documented
    @java.lang.annotation.Retention(java.lang.annotation.RetentionPolicy.SOURCE)
    public @interface Flags {
    }

    public static final class Mp4Track {
        public final com.google.android.exoplayer2.extractor.mp4.Track a;
        public final com.google.android.exoplayer2.extractor.mp4.TrackSampleTable b;
        public final com.google.android.exoplayer2.extractor.TrackOutput c;
        public int d;

        public Mp4Track(com.google.android.exoplayer2.extractor.mp4.Track track, com.google.android.exoplayer2.extractor.mp4.TrackSampleTable trackSampleTable, com.google.android.exoplayer2.extractor.TrackOutput trackOutput) {
            this.a = track;
            this.b = trackSampleTable;
            this.c = trackOutput;
        }
    }

    public Mp4Extractor() {
        this(0);
    }

    public Mp4Extractor(int i) {
        this.a = i;
        this.e = new com.google.android.exoplayer2.util.ParsableByteArray(16);
        this.f = new java.util.ArrayDeque<>();
        this.b = new com.google.android.exoplayer2.util.ParsableByteArray(com.google.android.exoplayer2.util.NalUnitUtil.NAL_START_CODE);
        this.c = new com.google.android.exoplayer2.util.ParsableByteArray(4);
        this.d = new com.google.android.exoplayer2.util.ParsableByteArray();
        this.l = -1;
    }

    public static long[][] c(com.google.android.exoplayer2.extractor.mp4.Mp4Extractor.Mp4Track[] mp4TrackArr) {
        long[][] jArr = new long[mp4TrackArr.length][];
        int[] iArr = new int[mp4TrackArr.length];
        long[] jArr2 = new long[mp4TrackArr.length];
        boolean[] zArr = new boolean[mp4TrackArr.length];
        for (int i = 0; i < mp4TrackArr.length; i++) {
            jArr[i] = new long[mp4TrackArr[i].b.b];
            jArr2[i] = mp4TrackArr[i].b.f[0];
        }
        long j = 0;
        int i2 = 0;
        while (i2 < mp4TrackArr.length) {
            long j2 = Long.MAX_VALUE;
            int i3 = -1;
            for (int i4 = 0; i4 < mp4TrackArr.length; i4++) {
                if (!zArr[i4]) {
                    long j3 = jArr2[i4];
                    if (j3 <= j2) {
                        i3 = i4;
                        j2 = j3;
                    }
                }
            }
            int i5 = iArr[i3];
            long[] jArr3 = jArr[i3];
            jArr3[i5] = j;
            com.google.android.exoplayer2.extractor.mp4.TrackSampleTable trackSampleTable = mp4TrackArr[i3].b;
            j += trackSampleTable.d[i5];
            int i6 = i5 + 1;
            iArr[i3] = i6;
            if (i6 < jArr3.length) {
                jArr2[i3] = trackSampleTable.f[i6];
            } else {
                zArr[i3] = true;
                i2++;
            }
        }
        return jArr;
    }

    public static int e(com.google.android.exoplayer2.extractor.mp4.TrackSampleTable trackSampleTable, long j) {
        int a = trackSampleTable.a(j);
        return a == -1 ? trackSampleTable.b(j) : a;
    }

    public static /* synthetic */ com.google.android.exoplayer2.extractor.mp4.Track g(com.google.android.exoplayer2.extractor.mp4.Track track) {
        return track;
    }

    public static /* synthetic */ com.google.android.exoplayer2.extractor.Extractor[] h() {
        return new com.google.android.exoplayer2.extractor.Extractor[]{new com.google.android.exoplayer2.extractor.mp4.Mp4Extractor()};
    }

    public static long i(com.google.android.exoplayer2.extractor.mp4.TrackSampleTable trackSampleTable, long j, long j2) {
        int e = e(trackSampleTable, j);
        return e == -1 ? j2 : java.lang.Math.min(trackSampleTable.c[e], j2);
    }

    public static boolean l(com.google.android.exoplayer2.util.ParsableByteArray parsableByteArray) {
        parsableByteArray.setPosition(8);
        if (parsableByteArray.readInt() == 1903435808) {
            return true;
        }
        parsableByteArray.skipBytes(4);
        while (parsableByteArray.bytesLeft() > 0) {
            if (parsableByteArray.readInt() == 1903435808) {
                return true;
            }
        }
        return false;
    }

    public static boolean q(int i) {
        return i == 1836019574 || i == 1953653099 || i == 1835297121 || i == 1835626086 || i == 1937007212 || i == 1701082227 || i == 1835365473;
    }

    public static boolean r(int i) {
        return i == 1835296868 || i == 1836476516 || i == 1751411826 || i == 1937011556 || i == 1937011827 || i == 1937011571 || i == 1668576371 || i == 1701606260 || i == 1937011555 || i == 1937011578 || i == 1937013298 || i == 1937007471 || i == 1668232756 || i == 1953196132 || i == 1718909296 || i == 1969517665 || i == 1801812339 || i == 1768715124;
    }

    public final void d() {
        this.g = 0;
        this.j = 0;
    }

    public final int f(long j) {
        int i = -1;
        int i2 = -1;
        long j2 = Long.MAX_VALUE;
        boolean z = true;
        long j3 = Long.MAX_VALUE;
        boolean z2 = true;
        long j4 = Long.MAX_VALUE;
        for (int i3 = 0; i3 < ((com.google.android.exoplayer2.extractor.mp4.Mp4Extractor.Mp4Track[]) com.google.android.exoplayer2.util.Util.castNonNull(this.q)).length; i3++) {
            com.google.android.exoplayer2.extractor.mp4.Mp4Extractor.Mp4Track mp4Track = this.q[i3];
            int i4 = mp4Track.d;
            com.google.android.exoplayer2.extractor.mp4.TrackSampleTable trackSampleTable = mp4Track.b;
            if (i4 != trackSampleTable.b) {
                long j5 = trackSampleTable.c[i4];
                long j6 = ((long[][]) com.google.android.exoplayer2.util.Util.castNonNull(this.r))[i3][i4];
                long j7 = j5 - j;
                boolean z3 = j7 < 0 || j7 >= android.support.v4.media.session.PlaybackStateCompat.ACTION_SET_REPEAT_MODE;
                if ((!z3 && z2) || (z3 == z2 && j7 < j4)) {
                    z2 = z3;
                    j4 = j7;
                    i2 = i3;
                    j3 = j6;
                }
                if (j6 < j2) {
                    z = z3;
                    i = i3;
                    j2 = j6;
                }
            }
        }
        return (j2 == Long.MAX_VALUE || !z || j3 < j2 + 10485760) ? i2 : i;
    }

    @Override // com.google.android.exoplayer2.extractor.SeekMap
    public long getDurationUs() {
        return this.t;
    }

    @Override // com.google.android.exoplayer2.extractor.SeekMap
    public com.google.android.exoplayer2.extractor.SeekMap.SeekPoints getSeekPoints(long j) {
        long j2;
        long j3;
        long j4;
        long j5;
        int b;
        if (((com.google.android.exoplayer2.extractor.mp4.Mp4Extractor.Mp4Track[]) com.google.android.exoplayer2.util.Assertions.checkNotNull(this.q)).length == 0) {
            return new com.google.android.exoplayer2.extractor.SeekMap.SeekPoints(com.google.android.exoplayer2.extractor.SeekPoint.START);
        }
        int i = this.f352s;
        if (i != -1) {
            com.google.android.exoplayer2.extractor.mp4.TrackSampleTable trackSampleTable = this.q[i].b;
            int e = e(trackSampleTable, j);
            if (e == -1) {
                return new com.google.android.exoplayer2.extractor.SeekMap.SeekPoints(com.google.android.exoplayer2.extractor.SeekPoint.START);
            }
            long j6 = trackSampleTable.f[e];
            j2 = trackSampleTable.c[e];
            if (j6 >= j || e >= trackSampleTable.b - 1 || (b = trackSampleTable.b(j)) == -1 || b == e) {
                j5 = -1;
                j4 = -9223372036854775807L;
            } else {
                j4 = trackSampleTable.f[b];
                j5 = trackSampleTable.c[b];
            }
            j3 = j5;
            j = j6;
        } else {
            j2 = Long.MAX_VALUE;
            j3 = -1;
            j4 = -9223372036854775807L;
        }
        int i2 = 0;
        while (true) {
            com.google.android.exoplayer2.extractor.mp4.Mp4Extractor.Mp4Track[] mp4TrackArr = this.q;
            if (i2 >= mp4TrackArr.length) {
                break;
            }
            if (i2 != this.f352s) {
                com.google.android.exoplayer2.extractor.mp4.TrackSampleTable trackSampleTable2 = mp4TrackArr[i2].b;
                long i3 = i(trackSampleTable2, j, j2);
                if (j4 != -9223372036854775807L) {
                    j3 = i(trackSampleTable2, j4, j3);
                }
                j2 = i3;
            }
            i2++;
        }
        com.google.android.exoplayer2.extractor.SeekPoint seekPoint = new com.google.android.exoplayer2.extractor.SeekPoint(j, j2);
        return j4 == -9223372036854775807L ? new com.google.android.exoplayer2.extractor.SeekMap.SeekPoints(seekPoint) : new com.google.android.exoplayer2.extractor.SeekMap.SeekPoints(seekPoint, new com.google.android.exoplayer2.extractor.SeekPoint(j4, j3));
    }

    @Override // com.google.android.exoplayer2.extractor.Extractor
    public void init(com.google.android.exoplayer2.extractor.ExtractorOutput extractorOutput) {
        this.p = extractorOutput;
    }

    @Override // com.google.android.exoplayer2.extractor.SeekMap
    public boolean isSeekable() {
        return true;
    }

    public final void j(com.google.android.exoplayer2.extractor.ExtractorInput extractorInput) throws java.io.IOException {
        this.d.reset(8);
        extractorInput.peekFully(this.d.getData(), 0, 8);
        this.d.skipBytes(4);
        if (this.d.readInt() == 1751411826) {
            extractorInput.resetPeekPosition();
        } else {
            extractorInput.skipFully(4);
        }
    }

    public final void k(long j) throws com.google.android.exoplayer2.ParserException {
        while (!this.f.isEmpty() && this.f.peek().b == j) {
            com.google.android.exoplayer2.extractor.mp4.Atom.ContainerAtom pop = this.f.pop();
            if (pop.a == 1836019574) {
                m(pop);
                this.f.clear();
                this.g = 2;
            } else if (!this.f.isEmpty()) {
                this.f.peek().d(pop);
            }
        }
        if (this.g != 2) {
            d();
        }
    }

    public final void m(com.google.android.exoplayer2.extractor.mp4.Atom.ContainerAtom containerAtom) throws com.google.android.exoplayer2.ParserException {
        com.google.android.exoplayer2.metadata.Metadata metadata;
        java.util.List<com.google.android.exoplayer2.extractor.mp4.TrackSampleTable> list;
        int i;
        com.google.android.exoplayer2.extractor.mp4.Mp4Extractor mp4Extractor = this;
        java.util.ArrayList arrayList = new java.util.ArrayList();
        com.google.android.exoplayer2.extractor.GaplessInfoHolder gaplessInfoHolder = new com.google.android.exoplayer2.extractor.GaplessInfoHolder();
        com.google.android.exoplayer2.extractor.mp4.Atom.LeafAtom g = containerAtom.g(1969517665);
        if (g != null) {
            com.google.android.exoplayer2.metadata.Metadata y = com.google.android.exoplayer2.extractor.mp4.AtomParsers.y(g, mp4Extractor.u);
            if (y != null) {
                gaplessInfoHolder.setFromMetadata(y);
            }
            metadata = y;
        } else {
            metadata = null;
        }
        com.google.android.exoplayer2.extractor.mp4.Atom.ContainerAtom f = containerAtom.f(1835365473);
        com.google.android.exoplayer2.metadata.Metadata l = f != null ? com.google.android.exoplayer2.extractor.mp4.AtomParsers.l(f) : null;
        java.util.List<com.google.android.exoplayer2.extractor.mp4.TrackSampleTable> x = com.google.android.exoplayer2.extractor.mp4.AtomParsers.x(containerAtom, gaplessInfoHolder, -9223372036854775807L, null, (mp4Extractor.a & 1) != 0, mp4Extractor.u, new defpackage.go1());
        com.google.android.exoplayer2.extractor.ExtractorOutput extractorOutput = (com.google.android.exoplayer2.extractor.ExtractorOutput) com.google.android.exoplayer2.util.Assertions.checkNotNull(mp4Extractor.p);
        int size = x.size();
        long j = -9223372036854775807L;
        long j2 = -9223372036854775807L;
        int i2 = 0;
        int i3 = -1;
        while (i2 < size) {
            com.google.android.exoplayer2.extractor.mp4.TrackSampleTable trackSampleTable = x.get(i2);
            if (trackSampleTable.b == 0) {
                list = x;
                i = size;
            } else {
                com.google.android.exoplayer2.extractor.mp4.Track track = trackSampleTable.a;
                list = x;
                long j3 = track.durationUs;
                if (j3 == j) {
                    j3 = trackSampleTable.h;
                }
                long max = java.lang.Math.max(j2, j3);
                com.google.android.exoplayer2.extractor.mp4.Mp4Extractor.Mp4Track mp4Track = new com.google.android.exoplayer2.extractor.mp4.Mp4Extractor.Mp4Track(track, trackSampleTable, extractorOutput.track(i2, track.type));
                int i4 = trackSampleTable.e + 30;
                i = size;
                com.google.android.exoplayer2.Format.Builder buildUpon = track.format.buildUpon();
                buildUpon.setMaxInputSize(i4);
                if (track.type == 2 && j3 > 0) {
                    int i5 = trackSampleTable.b;
                    if (i5 > 1) {
                        buildUpon.setFrameRate(i5 / (j3 / 1000000.0f));
                    }
                }
                com.google.android.exoplayer2.extractor.mp4.MetadataUtil.k(track.type, metadata, l, gaplessInfoHolder, buildUpon);
                mp4Track.c.format(buildUpon.build());
                if (track.type == 2 && i3 == -1) {
                    i3 = arrayList.size();
                }
                arrayList.add(mp4Track);
                j2 = max;
            }
            i2++;
            x = list;
            size = i;
            j = -9223372036854775807L;
            mp4Extractor = this;
        }
        com.google.android.exoplayer2.extractor.mp4.Mp4Extractor mp4Extractor2 = mp4Extractor;
        mp4Extractor2.f352s = i3;
        mp4Extractor2.t = j2;
        com.google.android.exoplayer2.extractor.mp4.Mp4Extractor.Mp4Track[] mp4TrackArr = (com.google.android.exoplayer2.extractor.mp4.Mp4Extractor.Mp4Track[]) arrayList.toArray(new com.google.android.exoplayer2.extractor.mp4.Mp4Extractor.Mp4Track[0]);
        mp4Extractor2.q = mp4TrackArr;
        mp4Extractor2.r = c(mp4TrackArr);
        extractorOutput.endTracks();
        extractorOutput.seekMap(mp4Extractor2);
    }

    public final boolean n(com.google.android.exoplayer2.extractor.ExtractorInput extractorInput) throws java.io.IOException {
        com.google.android.exoplayer2.extractor.mp4.Atom.ContainerAtom peek;
        if (this.j == 0) {
            if (!extractorInput.readFully(this.e.getData(), 0, 8, true)) {
                return false;
            }
            this.j = 8;
            this.e.setPosition(0);
            this.i = this.e.readUnsignedInt();
            this.h = this.e.readInt();
        }
        long j = this.i;
        if (j == 1) {
            extractorInput.readFully(this.e.getData(), 8, 8);
            this.j += 8;
            this.i = this.e.readUnsignedLongToLong();
        } else if (j == 0) {
            long length = extractorInput.getLength();
            if (length == -1 && (peek = this.f.peek()) != null) {
                length = peek.b;
            }
            if (length != -1) {
                this.i = (length - extractorInput.getPosition()) + this.j;
            }
        }
        if (this.i < this.j) {
            throw new com.google.android.exoplayer2.ParserException("Atom size less than header length (unsupported).");
        }
        if (q(this.h)) {
            long position = extractorInput.getPosition();
            long j2 = this.i;
            int i = this.j;
            long j3 = (position + j2) - i;
            if (j2 != i && this.h == 1835365473) {
                j(extractorInput);
            }
            this.f.push(new com.google.android.exoplayer2.extractor.mp4.Atom.ContainerAtom(this.h, j3));
            if (this.i == this.j) {
                k(j3);
            } else {
                d();
            }
        } else if (r(this.h)) {
            com.google.android.exoplayer2.util.Assertions.checkState(this.j == 8);
            com.google.android.exoplayer2.util.Assertions.checkState(this.i <= 2147483647L);
            com.google.android.exoplayer2.util.ParsableByteArray parsableByteArray = new com.google.android.exoplayer2.util.ParsableByteArray((int) this.i);
            java.lang.System.arraycopy(this.e.getData(), 0, parsableByteArray.getData(), 0, 8);
            this.k = parsableByteArray;
            this.g = 1;
        } else {
            this.k = null;
            this.g = 1;
        }
        return true;
    }

    public final boolean o(com.google.android.exoplayer2.extractor.ExtractorInput extractorInput, com.google.android.exoplayer2.extractor.PositionHolder positionHolder) throws java.io.IOException {
        boolean z;
        long j = this.i - this.j;
        long position = extractorInput.getPosition() + j;
        com.google.android.exoplayer2.util.ParsableByteArray parsableByteArray = this.k;
        if (parsableByteArray != null) {
            extractorInput.readFully(parsableByteArray.getData(), this.j, (int) j);
            if (this.h == 1718909296) {
                this.u = l(parsableByteArray);
            } else if (!this.f.isEmpty()) {
                this.f.peek().e(new com.google.android.exoplayer2.extractor.mp4.Atom.LeafAtom(this.h, parsableByteArray));
            }
        } else {
            if (j >= android.support.v4.media.session.PlaybackStateCompat.ACTION_SET_REPEAT_MODE) {
                positionHolder.position = extractorInput.getPosition() + j;
                z = true;
                k(position);
                return (z || this.g == 2) ? false : true;
            }
            extractorInput.skipFully((int) j);
        }
        z = false;
        k(position);
        if (z) {
        }
    }

    public final int p(com.google.android.exoplayer2.extractor.ExtractorInput extractorInput, com.google.android.exoplayer2.extractor.PositionHolder positionHolder) throws java.io.IOException {
        long position = extractorInput.getPosition();
        if (this.l == -1) {
            int f = f(position);
            this.l = f;
            if (f == -1) {
                return -1;
            }
        }
        com.google.android.exoplayer2.extractor.mp4.Mp4Extractor.Mp4Track mp4Track = ((com.google.android.exoplayer2.extractor.mp4.Mp4Extractor.Mp4Track[]) com.google.android.exoplayer2.util.Util.castNonNull(this.q))[this.l];
        com.google.android.exoplayer2.extractor.TrackOutput trackOutput = mp4Track.c;
        int i = mp4Track.d;
        com.google.android.exoplayer2.extractor.mp4.TrackSampleTable trackSampleTable = mp4Track.b;
        long j = trackSampleTable.c[i];
        int i2 = trackSampleTable.d[i];
        long j2 = (j - position) + this.m;
        if (j2 < 0 || j2 >= android.support.v4.media.session.PlaybackStateCompat.ACTION_SET_REPEAT_MODE) {
            positionHolder.position = j;
            return 1;
        }
        if (mp4Track.a.sampleTransformation == 1) {
            j2 += 8;
            i2 -= 8;
        }
        extractorInput.skipFully((int) j2);
        com.google.android.exoplayer2.extractor.mp4.Track track = mp4Track.a;
        if (track.nalUnitLengthFieldLength == 0) {
            if (com.google.android.exoplayer2.util.MimeTypes.AUDIO_AC4.equals(track.format.sampleMimeType)) {
                if (this.n == 0) {
                    com.google.android.exoplayer2.audio.Ac4Util.getAc4SampleHeader(i2, this.d);
                    trackOutput.sampleData(this.d, 7);
                    this.n += 7;
                }
                i2 += 7;
            }
            while (true) {
                int i3 = this.n;
                if (i3 >= i2) {
                    break;
                }
                int sampleData = trackOutput.sampleData((com.google.android.exoplayer2.upstream.DataReader) extractorInput, i2 - i3, false);
                this.m += sampleData;
                this.n += sampleData;
                this.o -= sampleData;
            }
        } else {
            byte[] data = this.c.getData();
            data[0] = 0;
            data[1] = 0;
            data[2] = 0;
            int i4 = mp4Track.a.nalUnitLengthFieldLength;
            int i5 = 4 - i4;
            while (this.n < i2) {
                int i6 = this.o;
                if (i6 == 0) {
                    extractorInput.readFully(data, i5, i4);
                    this.m += i4;
                    this.c.setPosition(0);
                    int readInt = this.c.readInt();
                    if (readInt < 0) {
                        throw new com.google.android.exoplayer2.ParserException("Invalid NAL length");
                    }
                    this.o = readInt;
                    this.b.setPosition(0);
                    trackOutput.sampleData(this.b, 4);
                    this.n += 4;
                    i2 += i5;
                } else {
                    int sampleData2 = trackOutput.sampleData((com.google.android.exoplayer2.upstream.DataReader) extractorInput, i6, false);
                    this.m += sampleData2;
                    this.n += sampleData2;
                    this.o -= sampleData2;
                }
            }
        }
        com.google.android.exoplayer2.extractor.mp4.TrackSampleTable trackSampleTable2 = mp4Track.b;
        trackOutput.sampleMetadata(trackSampleTable2.f[i], trackSampleTable2.g[i], i2, 0, null);
        mp4Track.d++;
        this.l = -1;
        this.m = 0;
        this.n = 0;
        this.o = 0;
        return 0;
    }

    @Override // com.google.android.exoplayer2.extractor.Extractor
    public int read(com.google.android.exoplayer2.extractor.ExtractorInput extractorInput, com.google.android.exoplayer2.extractor.PositionHolder positionHolder) throws java.io.IOException {
        while (true) {
            int i = this.g;
            if (i != 0) {
                if (i != 1) {
                    if (i == 2) {
                        return p(extractorInput, positionHolder);
                    }
                    throw new java.lang.IllegalStateException();
                }
                if (o(extractorInput, positionHolder)) {
                    return 1;
                }
            } else if (!n(extractorInput)) {
                return -1;
            }
        }
    }

    @Override // com.google.android.exoplayer2.extractor.Extractor
    public void release() {
    }

    @org.checkerframework.checker.nullness.qual.RequiresNonNull({"tracks"})
    public final void s(long j) {
        for (com.google.android.exoplayer2.extractor.mp4.Mp4Extractor.Mp4Track mp4Track : this.q) {
            com.google.android.exoplayer2.extractor.mp4.TrackSampleTable trackSampleTable = mp4Track.b;
            int a = trackSampleTable.a(j);
            if (a == -1) {
                a = trackSampleTable.b(j);
            }
            mp4Track.d = a;
        }
    }

    @Override // com.google.android.exoplayer2.extractor.Extractor
    public void seek(long j, long j2) {
        this.f.clear();
        this.j = 0;
        this.l = -1;
        this.m = 0;
        this.n = 0;
        this.o = 0;
        if (j == 0) {
            d();
        } else if (this.q != null) {
            s(j2);
        }
    }

    @Override // com.google.android.exoplayer2.extractor.Extractor
    public boolean sniff(com.google.android.exoplayer2.extractor.ExtractorInput extractorInput) throws java.io.IOException {
        return com.google.android.exoplayer2.extractor.mp4.Sniffer.d(extractorInput);
    }
}
