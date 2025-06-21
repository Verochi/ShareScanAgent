package com.google.android.exoplayer2.extractor.mp4;

/* loaded from: classes22.dex */
public class FragmentedMp4Extractor implements com.google.android.exoplayer2.extractor.Extractor {
    public static final int FLAG_ENABLE_EMSG_TRACK = 4;
    public static final int FLAG_WORKAROUND_EVERY_VIDEO_FRAME_IS_SYNC_FRAME = 1;
    public static final int FLAG_WORKAROUND_IGNORE_EDIT_LISTS = 16;
    public static final int FLAG_WORKAROUND_IGNORE_TFDT_BOX = 2;
    public int A;
    public int B;
    public int C;
    public boolean D;
    public com.google.android.exoplayer2.extractor.ExtractorOutput E;
    public com.google.android.exoplayer2.extractor.TrackOutput[] F;
    public com.google.android.exoplayer2.extractor.TrackOutput[] G;
    public boolean H;
    public final int a;

    @androidx.annotation.Nullable
    public final com.google.android.exoplayer2.extractor.mp4.Track b;
    public final java.util.List<com.google.android.exoplayer2.Format> c;
    public final android.util.SparseArray<com.google.android.exoplayer2.extractor.mp4.FragmentedMp4Extractor.TrackBundle> d;
    public final com.google.android.exoplayer2.util.ParsableByteArray e;
    public final com.google.android.exoplayer2.util.ParsableByteArray f;
    public final com.google.android.exoplayer2.util.ParsableByteArray g;
    public final byte[] h;
    public final com.google.android.exoplayer2.util.ParsableByteArray i;

    @androidx.annotation.Nullable
    public final com.google.android.exoplayer2.util.TimestampAdjuster j;
    public final com.google.android.exoplayer2.metadata.emsg.EventMessageEncoder k;
    public final com.google.android.exoplayer2.util.ParsableByteArray l;
    public final java.util.ArrayDeque<com.google.android.exoplayer2.extractor.mp4.Atom.ContainerAtom> m;
    public final java.util.ArrayDeque<com.google.android.exoplayer2.extractor.mp4.FragmentedMp4Extractor.MetadataSampleInfo> n;

    @androidx.annotation.Nullable
    public final com.google.android.exoplayer2.extractor.TrackOutput o;
    public int p;
    public int q;
    public long r;

    /* renamed from: s, reason: collision with root package name */
    public int f351s;

    @androidx.annotation.Nullable
    public com.google.android.exoplayer2.util.ParsableByteArray t;
    public long u;
    public int v;
    public long w;
    public long x;
    public long y;

    @androidx.annotation.Nullable
    public com.google.android.exoplayer2.extractor.mp4.FragmentedMp4Extractor.TrackBundle z;
    public static final com.google.android.exoplayer2.extractor.ExtractorsFactory FACTORY = new defpackage.ei0();
    public static final byte[] I = {-94, 57, 79, 82, 90, -101, 79, com.google.common.base.Ascii.DC4, -94, 68, 108, 66, 124, 100, -115, -12};
    public static final com.google.android.exoplayer2.Format J = new com.google.android.exoplayer2.Format.Builder().setSampleMimeType("application/x-emsg").build();

    @java.lang.annotation.Documented
    @java.lang.annotation.Retention(java.lang.annotation.RetentionPolicy.SOURCE)
    public @interface Flags {
    }

    public static final class MetadataSampleInfo {
        public final long a;
        public final int b;

        public MetadataSampleInfo(long j, int i) {
            this.a = j;
            this.b = i;
        }
    }

    public static final class TrackBundle {
        public final com.google.android.exoplayer2.extractor.TrackOutput a;
        public com.google.android.exoplayer2.extractor.mp4.TrackSampleTable d;
        public com.google.android.exoplayer2.extractor.mp4.DefaultSampleValues e;
        public int f;
        public int g;
        public int h;
        public int i;
        public boolean l;
        public final com.google.android.exoplayer2.extractor.mp4.TrackFragment b = new com.google.android.exoplayer2.extractor.mp4.TrackFragment();
        public final com.google.android.exoplayer2.util.ParsableByteArray c = new com.google.android.exoplayer2.util.ParsableByteArray();
        public final com.google.android.exoplayer2.util.ParsableByteArray j = new com.google.android.exoplayer2.util.ParsableByteArray(1);
        public final com.google.android.exoplayer2.util.ParsableByteArray k = new com.google.android.exoplayer2.util.ParsableByteArray();

        public TrackBundle(com.google.android.exoplayer2.extractor.TrackOutput trackOutput, com.google.android.exoplayer2.extractor.mp4.TrackSampleTable trackSampleTable, com.google.android.exoplayer2.extractor.mp4.DefaultSampleValues defaultSampleValues) {
            this.a = trackOutput;
            this.d = trackSampleTable;
            this.e = defaultSampleValues;
            j(trackSampleTable, defaultSampleValues);
        }

        public int c() {
            int i = !this.l ? this.d.g[this.f] : this.b.l[this.f] ? 1 : 0;
            return g() != null ? i | 1073741824 : i;
        }

        public long d() {
            return !this.l ? this.d.c[this.f] : this.b.g[this.h];
        }

        public long e() {
            return !this.l ? this.d.f[this.f] : this.b.c(this.f);
        }

        public int f() {
            return !this.l ? this.d.d[this.f] : this.b.i[this.f];
        }

        @androidx.annotation.Nullable
        public com.google.android.exoplayer2.extractor.mp4.TrackEncryptionBox g() {
            if (!this.l) {
                return null;
            }
            int i = ((com.google.android.exoplayer2.extractor.mp4.DefaultSampleValues) com.google.android.exoplayer2.util.Util.castNonNull(this.b.a)).a;
            com.google.android.exoplayer2.extractor.mp4.TrackEncryptionBox trackEncryptionBox = this.b.o;
            if (trackEncryptionBox == null) {
                trackEncryptionBox = this.d.a.getSampleDescriptionEncryptionBox(i);
            }
            if (trackEncryptionBox == null || !trackEncryptionBox.isEncrypted) {
                return null;
            }
            return trackEncryptionBox;
        }

        public boolean h() {
            this.f++;
            if (!this.l) {
                return false;
            }
            int i = this.g + 1;
            this.g = i;
            int[] iArr = this.b.h;
            int i2 = this.h;
            if (i != iArr[i2]) {
                return true;
            }
            this.h = i2 + 1;
            this.g = 0;
            return false;
        }

        public int i(int i, int i2) {
            com.google.android.exoplayer2.util.ParsableByteArray parsableByteArray;
            com.google.android.exoplayer2.extractor.mp4.TrackEncryptionBox g = g();
            if (g == null) {
                return 0;
            }
            int i3 = g.perSampleIvSize;
            if (i3 != 0) {
                parsableByteArray = this.b.p;
            } else {
                byte[] bArr = (byte[]) com.google.android.exoplayer2.util.Util.castNonNull(g.defaultInitializationVector);
                this.k.reset(bArr, bArr.length);
                com.google.android.exoplayer2.util.ParsableByteArray parsableByteArray2 = this.k;
                i3 = bArr.length;
                parsableByteArray = parsableByteArray2;
            }
            boolean g2 = this.b.g(this.f);
            boolean z = g2 || i2 != 0;
            this.j.getData()[0] = (byte) ((z ? 128 : 0) | i3);
            this.j.setPosition(0);
            this.a.sampleData(this.j, 1, 1);
            this.a.sampleData(parsableByteArray, i3, 1);
            if (!z) {
                return i3 + 1;
            }
            if (!g2) {
                this.c.reset(8);
                byte[] data = this.c.getData();
                data[0] = 0;
                data[1] = 1;
                data[2] = (byte) ((i2 >> 8) & 255);
                data[3] = (byte) (i2 & 255);
                data[4] = (byte) ((i >> 24) & 255);
                data[5] = (byte) ((i >> 16) & 255);
                data[6] = (byte) ((i >> 8) & 255);
                data[7] = (byte) (i & 255);
                this.a.sampleData(this.c, 8, 1);
                return i3 + 1 + 8;
            }
            com.google.android.exoplayer2.util.ParsableByteArray parsableByteArray3 = this.b.p;
            int readUnsignedShort = parsableByteArray3.readUnsignedShort();
            parsableByteArray3.skipBytes(-2);
            int i4 = (readUnsignedShort * 6) + 2;
            if (i2 != 0) {
                this.c.reset(i4);
                byte[] data2 = this.c.getData();
                parsableByteArray3.readBytes(data2, 0, i4);
                int i5 = (((data2[2] & 255) << 8) | (data2[3] & 255)) + i2;
                data2[2] = (byte) ((i5 >> 8) & 255);
                data2[3] = (byte) (i5 & 255);
                parsableByteArray3 = this.c;
            }
            this.a.sampleData(parsableByteArray3, i4, 1);
            return i3 + 1 + i4;
        }

        public void j(com.google.android.exoplayer2.extractor.mp4.TrackSampleTable trackSampleTable, com.google.android.exoplayer2.extractor.mp4.DefaultSampleValues defaultSampleValues) {
            this.d = trackSampleTable;
            this.e = defaultSampleValues;
            this.a.format(trackSampleTable.a.format);
            k();
        }

        public void k() {
            this.b.f();
            this.f = 0;
            this.h = 0;
            this.g = 0;
            this.i = 0;
            this.l = false;
        }

        public void l(long j) {
            int i = this.f;
            while (true) {
                com.google.android.exoplayer2.extractor.mp4.TrackFragment trackFragment = this.b;
                if (i >= trackFragment.f || trackFragment.c(i) >= j) {
                    return;
                }
                if (this.b.l[i]) {
                    this.i = i;
                }
                i++;
            }
        }

        public void m() {
            com.google.android.exoplayer2.extractor.mp4.TrackEncryptionBox g = g();
            if (g == null) {
                return;
            }
            com.google.android.exoplayer2.util.ParsableByteArray parsableByteArray = this.b.p;
            int i = g.perSampleIvSize;
            if (i != 0) {
                parsableByteArray.skipBytes(i);
            }
            if (this.b.g(this.f)) {
                parsableByteArray.skipBytes(parsableByteArray.readUnsignedShort() * 6);
            }
        }

        public void n(com.google.android.exoplayer2.drm.DrmInitData drmInitData) {
            com.google.android.exoplayer2.extractor.mp4.TrackEncryptionBox sampleDescriptionEncryptionBox = this.d.a.getSampleDescriptionEncryptionBox(((com.google.android.exoplayer2.extractor.mp4.DefaultSampleValues) com.google.android.exoplayer2.util.Util.castNonNull(this.b.a)).a);
            this.a.format(this.d.a.format.buildUpon().setDrmInitData(drmInitData.copyWithSchemeType(sampleDescriptionEncryptionBox != null ? sampleDescriptionEncryptionBox.schemeType : null)).build());
        }
    }

    public FragmentedMp4Extractor() {
        this(0);
    }

    public FragmentedMp4Extractor(int i) {
        this(i, null);
    }

    public FragmentedMp4Extractor(int i, @androidx.annotation.Nullable com.google.android.exoplayer2.util.TimestampAdjuster timestampAdjuster) {
        this(i, timestampAdjuster, null, java.util.Collections.emptyList());
    }

    public FragmentedMp4Extractor(int i, @androidx.annotation.Nullable com.google.android.exoplayer2.util.TimestampAdjuster timestampAdjuster, @androidx.annotation.Nullable com.google.android.exoplayer2.extractor.mp4.Track track) {
        this(i, timestampAdjuster, track, java.util.Collections.emptyList());
    }

    public FragmentedMp4Extractor(int i, @androidx.annotation.Nullable com.google.android.exoplayer2.util.TimestampAdjuster timestampAdjuster, @androidx.annotation.Nullable com.google.android.exoplayer2.extractor.mp4.Track track, java.util.List<com.google.android.exoplayer2.Format> list) {
        this(i, timestampAdjuster, track, list, null);
    }

    public FragmentedMp4Extractor(int i, @androidx.annotation.Nullable com.google.android.exoplayer2.util.TimestampAdjuster timestampAdjuster, @androidx.annotation.Nullable com.google.android.exoplayer2.extractor.mp4.Track track, java.util.List<com.google.android.exoplayer2.Format> list, @androidx.annotation.Nullable com.google.android.exoplayer2.extractor.TrackOutput trackOutput) {
        this.a = i | (track != null ? 8 : 0);
        this.j = timestampAdjuster;
        this.b = track;
        this.c = java.util.Collections.unmodifiableList(list);
        this.o = trackOutput;
        this.k = new com.google.android.exoplayer2.metadata.emsg.EventMessageEncoder();
        this.l = new com.google.android.exoplayer2.util.ParsableByteArray(16);
        this.e = new com.google.android.exoplayer2.util.ParsableByteArray(com.google.android.exoplayer2.util.NalUnitUtil.NAL_START_CODE);
        this.f = new com.google.android.exoplayer2.util.ParsableByteArray(5);
        this.g = new com.google.android.exoplayer2.util.ParsableByteArray();
        byte[] bArr = new byte[16];
        this.h = bArr;
        this.i = new com.google.android.exoplayer2.util.ParsableByteArray(bArr);
        this.m = new java.util.ArrayDeque<>();
        this.n = new java.util.ArrayDeque<>();
        this.d = new android.util.SparseArray<>();
        this.x = -9223372036854775807L;
        this.w = -9223372036854775807L;
        this.y = -9223372036854775807L;
        this.E = com.google.android.exoplayer2.extractor.ExtractorOutput.PLACEHOLDER;
        this.F = new com.google.android.exoplayer2.extractor.TrackOutput[0];
        this.G = new com.google.android.exoplayer2.extractor.TrackOutput[0];
    }

    public static android.util.Pair<java.lang.Integer, com.google.android.exoplayer2.extractor.mp4.DefaultSampleValues> A(com.google.android.exoplayer2.util.ParsableByteArray parsableByteArray) {
        parsableByteArray.setPosition(12);
        return android.util.Pair.create(java.lang.Integer.valueOf(parsableByteArray.readInt()), new com.google.android.exoplayer2.extractor.mp4.DefaultSampleValues(parsableByteArray.readInt() - 1, parsableByteArray.readInt(), parsableByteArray.readInt(), parsableByteArray.readInt()));
    }

    /* JADX WARN: Removed duplicated region for block: B:36:0x00bd  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static int B(com.google.android.exoplayer2.extractor.mp4.FragmentedMp4Extractor.TrackBundle trackBundle, int i, int i2, com.google.android.exoplayer2.util.ParsableByteArray parsableByteArray, int i3) throws com.google.android.exoplayer2.ParserException {
        long j;
        long j2;
        int i4;
        int i5;
        boolean z;
        int i6;
        boolean z2;
        int i7;
        boolean z3;
        boolean z4;
        boolean z5;
        com.google.android.exoplayer2.extractor.mp4.FragmentedMp4Extractor.TrackBundle trackBundle2 = trackBundle;
        parsableByteArray.setPosition(8);
        int b = com.google.android.exoplayer2.extractor.mp4.Atom.b(parsableByteArray.readInt());
        com.google.android.exoplayer2.extractor.mp4.Track track = trackBundle2.d.a;
        com.google.android.exoplayer2.extractor.mp4.TrackFragment trackFragment = trackBundle2.b;
        com.google.android.exoplayer2.extractor.mp4.DefaultSampleValues defaultSampleValues = (com.google.android.exoplayer2.extractor.mp4.DefaultSampleValues) com.google.android.exoplayer2.util.Util.castNonNull(trackFragment.a);
        trackFragment.h[i] = parsableByteArray.readUnsignedIntToInt();
        long[] jArr = trackFragment.g;
        long j3 = trackFragment.c;
        jArr[i] = j3;
        if ((b & 1) != 0) {
            jArr[i] = j3 + parsableByteArray.readInt();
        }
        boolean z6 = (b & 4) != 0;
        int i8 = defaultSampleValues.d;
        if (z6) {
            i8 = parsableByteArray.readInt();
        }
        boolean z7 = (b & 256) != 0;
        boolean z8 = (b & 512) != 0;
        boolean z9 = (b & 1024) != 0;
        boolean z10 = (b & 2048) != 0;
        long[] jArr2 = track.editListDurations;
        if (jArr2 == null || jArr2.length != 1) {
            j = 0;
        } else {
            j = 0;
            if (jArr2[0] == 0) {
                j2 = com.google.android.exoplayer2.util.Util.scaleLargeTimestamp(((long[]) com.google.android.exoplayer2.util.Util.castNonNull(track.editListMediaTimes))[0], 1000000L, track.timescale);
                int[] iArr = trackFragment.i;
                int[] iArr2 = trackFragment.j;
                long[] jArr3 = trackFragment.k;
                boolean[] zArr = trackFragment.l;
                int i9 = i8;
                boolean z11 = (track.type == 2 || (i2 & 1) == 0) ? false : true;
                i4 = i3 + trackFragment.h[i];
                boolean z12 = z11;
                long j4 = track.timescale;
                long j5 = j2;
                long j6 = trackFragment.r;
                i5 = i3;
                while (i5 < i4) {
                    int b2 = b(z7 ? parsableByteArray.readInt() : defaultSampleValues.b);
                    if (z8) {
                        z = z7;
                        i6 = parsableByteArray.readInt();
                    } else {
                        z = z7;
                        i6 = defaultSampleValues.c;
                    }
                    int b3 = b(i6);
                    if (z9) {
                        z2 = z6;
                        i7 = parsableByteArray.readInt();
                    } else if (i5 == 0 && z6) {
                        z2 = z6;
                        i7 = i9;
                    } else {
                        z2 = z6;
                        i7 = defaultSampleValues.d;
                    }
                    if (z10) {
                        z3 = z10;
                        z4 = z8;
                        z5 = z9;
                        iArr2[i5] = (int) ((parsableByteArray.readInt() * 1000000) / j4);
                    } else {
                        z3 = z10;
                        z4 = z8;
                        z5 = z9;
                        iArr2[i5] = 0;
                    }
                    long scaleLargeTimestamp = com.google.android.exoplayer2.util.Util.scaleLargeTimestamp(j6, 1000000L, j4) - j5;
                    jArr3[i5] = scaleLargeTimestamp;
                    if (!trackFragment.f353s) {
                        jArr3[i5] = scaleLargeTimestamp + trackBundle2.d.h;
                    }
                    iArr[i5] = b3;
                    zArr[i5] = ((i7 >> 16) & 1) == 0 && (!z12 || i5 == 0);
                    j6 += b2;
                    i5++;
                    trackBundle2 = trackBundle;
                    z7 = z;
                    j4 = j4;
                    z6 = z2;
                    z10 = z3;
                    z8 = z4;
                    z9 = z5;
                }
                trackFragment.r = j6;
                return i4;
            }
        }
        j2 = j;
        int[] iArr3 = trackFragment.i;
        int[] iArr22 = trackFragment.j;
        long[] jArr32 = trackFragment.k;
        boolean[] zArr2 = trackFragment.l;
        int i92 = i8;
        if (track.type == 2) {
        }
        i4 = i3 + trackFragment.h[i];
        boolean z122 = z11;
        long j42 = track.timescale;
        long j52 = j2;
        long j62 = trackFragment.r;
        i5 = i3;
        while (i5 < i4) {
        }
        trackFragment.r = j62;
        return i4;
    }

    public static void C(com.google.android.exoplayer2.extractor.mp4.Atom.ContainerAtom containerAtom, com.google.android.exoplayer2.extractor.mp4.FragmentedMp4Extractor.TrackBundle trackBundle, int i) throws com.google.android.exoplayer2.ParserException {
        java.util.List<com.google.android.exoplayer2.extractor.mp4.Atom.LeafAtom> list = containerAtom.c;
        int size = list.size();
        int i2 = 0;
        int i3 = 0;
        for (int i4 = 0; i4 < size; i4++) {
            com.google.android.exoplayer2.extractor.mp4.Atom.LeafAtom leafAtom = list.get(i4);
            if (leafAtom.a == 1953658222) {
                com.google.android.exoplayer2.util.ParsableByteArray parsableByteArray = leafAtom.b;
                parsableByteArray.setPosition(12);
                int readUnsignedIntToInt = parsableByteArray.readUnsignedIntToInt();
                if (readUnsignedIntToInt > 0) {
                    i3 += readUnsignedIntToInt;
                    i2++;
                }
            }
        }
        trackBundle.h = 0;
        trackBundle.g = 0;
        trackBundle.f = 0;
        trackBundle.b.e(i2, i3);
        int i5 = 0;
        int i6 = 0;
        for (int i7 = 0; i7 < size; i7++) {
            com.google.android.exoplayer2.extractor.mp4.Atom.LeafAtom leafAtom2 = list.get(i7);
            if (leafAtom2.a == 1953658222) {
                i6 = B(trackBundle, i5, i, leafAtom2.b, i6);
                i5++;
            }
        }
    }

    public static void D(com.google.android.exoplayer2.util.ParsableByteArray parsableByteArray, com.google.android.exoplayer2.extractor.mp4.TrackFragment trackFragment, byte[] bArr) throws com.google.android.exoplayer2.ParserException {
        parsableByteArray.setPosition(8);
        parsableByteArray.readBytes(bArr, 0, 16);
        if (java.util.Arrays.equals(bArr, I)) {
            u(parsableByteArray, 16, trackFragment);
        }
    }

    public static boolean J(int i) {
        return i == 1836019574 || i == 1953653099 || i == 1835297121 || i == 1835626086 || i == 1937007212 || i == 1836019558 || i == 1953653094 || i == 1836475768 || i == 1701082227;
    }

    public static boolean K(int i) {
        return i == 1751411826 || i == 1835296868 || i == 1836476516 || i == 1936286840 || i == 1937011556 || i == 1937011827 || i == 1668576371 || i == 1937011555 || i == 1937011578 || i == 1937013298 || i == 1937007471 || i == 1668232756 || i == 1937011571 || i == 1952867444 || i == 1952868452 || i == 1953196132 || i == 1953654136 || i == 1953658222 || i == 1886614376 || i == 1935763834 || i == 1935763823 || i == 1936027235 || i == 1970628964 || i == 1935828848 || i == 1936158820 || i == 1701606260 || i == 1835362404 || i == 1701671783;
    }

    public static int b(int i) throws com.google.android.exoplayer2.ParserException {
        if (i >= 0) {
            return i;
        }
        java.lang.StringBuilder sb = new java.lang.StringBuilder(37);
        sb.append("Unexpected negtive value: ");
        sb.append(i);
        throw new com.google.android.exoplayer2.ParserException(sb.toString());
    }

    @androidx.annotation.Nullable
    public static com.google.android.exoplayer2.drm.DrmInitData e(java.util.List<com.google.android.exoplayer2.extractor.mp4.Atom.LeafAtom> list) {
        int size = list.size();
        java.util.ArrayList arrayList = null;
        for (int i = 0; i < size; i++) {
            com.google.android.exoplayer2.extractor.mp4.Atom.LeafAtom leafAtom = list.get(i);
            if (leafAtom.a == 1886614376) {
                if (arrayList == null) {
                    arrayList = new java.util.ArrayList();
                }
                byte[] data = leafAtom.b.getData();
                java.util.UUID parseUuid = com.google.android.exoplayer2.extractor.mp4.PsshAtomUtil.parseUuid(data);
                if (parseUuid == null) {
                    com.google.android.exoplayer2.util.Log.w("FragmentedMp4Extractor", "Skipped pssh atom (failed to extract uuid)");
                } else {
                    arrayList.add(new com.google.android.exoplayer2.drm.DrmInitData.SchemeData(parseUuid, "video/mp4", data));
                }
            }
        }
        if (arrayList == null) {
            return null;
        }
        return new com.google.android.exoplayer2.drm.DrmInitData(arrayList);
    }

    @androidx.annotation.Nullable
    public static com.google.android.exoplayer2.extractor.mp4.FragmentedMp4Extractor.TrackBundle f(android.util.SparseArray<com.google.android.exoplayer2.extractor.mp4.FragmentedMp4Extractor.TrackBundle> sparseArray) {
        int size = sparseArray.size();
        com.google.android.exoplayer2.extractor.mp4.FragmentedMp4Extractor.TrackBundle trackBundle = null;
        long j = Long.MAX_VALUE;
        for (int i = 0; i < size; i++) {
            com.google.android.exoplayer2.extractor.mp4.FragmentedMp4Extractor.TrackBundle valueAt = sparseArray.valueAt(i);
            if ((valueAt.l || valueAt.f != valueAt.d.b) && (!valueAt.l || valueAt.h != valueAt.b.e)) {
                long d = valueAt.d();
                if (d < j) {
                    trackBundle = valueAt;
                    j = d;
                }
            }
        }
        return trackBundle;
    }

    @androidx.annotation.Nullable
    public static com.google.android.exoplayer2.extractor.mp4.FragmentedMp4Extractor.TrackBundle g(android.util.SparseArray<com.google.android.exoplayer2.extractor.mp4.FragmentedMp4Extractor.TrackBundle> sparseArray, int i) {
        return sparseArray.size() == 1 ? sparseArray.valueAt(0) : sparseArray.get(i);
    }

    public static /* synthetic */ com.google.android.exoplayer2.extractor.Extractor[] i() {
        return new com.google.android.exoplayer2.extractor.Extractor[]{new com.google.android.exoplayer2.extractor.mp4.FragmentedMp4Extractor()};
    }

    public static long p(com.google.android.exoplayer2.util.ParsableByteArray parsableByteArray) {
        parsableByteArray.setPosition(8);
        return com.google.android.exoplayer2.extractor.mp4.Atom.c(parsableByteArray.readInt()) == 0 ? parsableByteArray.readUnsignedInt() : parsableByteArray.readUnsignedLongToLong();
    }

    public static void q(com.google.android.exoplayer2.extractor.mp4.Atom.ContainerAtom containerAtom, android.util.SparseArray<com.google.android.exoplayer2.extractor.mp4.FragmentedMp4Extractor.TrackBundle> sparseArray, int i, byte[] bArr) throws com.google.android.exoplayer2.ParserException {
        int size = containerAtom.d.size();
        for (int i2 = 0; i2 < size; i2++) {
            com.google.android.exoplayer2.extractor.mp4.Atom.ContainerAtom containerAtom2 = containerAtom.d.get(i2);
            if (containerAtom2.a == 1953653094) {
                z(containerAtom2, sparseArray, i, bArr);
            }
        }
    }

    public static void r(com.google.android.exoplayer2.util.ParsableByteArray parsableByteArray, com.google.android.exoplayer2.extractor.mp4.TrackFragment trackFragment) throws com.google.android.exoplayer2.ParserException {
        parsableByteArray.setPosition(8);
        int readInt = parsableByteArray.readInt();
        if ((com.google.android.exoplayer2.extractor.mp4.Atom.b(readInt) & 1) == 1) {
            parsableByteArray.skipBytes(8);
        }
        int readUnsignedIntToInt = parsableByteArray.readUnsignedIntToInt();
        if (readUnsignedIntToInt == 1) {
            trackFragment.d += com.google.android.exoplayer2.extractor.mp4.Atom.c(readInt) == 0 ? parsableByteArray.readUnsignedInt() : parsableByteArray.readUnsignedLongToLong();
        } else {
            java.lang.StringBuilder sb = new java.lang.StringBuilder(40);
            sb.append("Unexpected saio entry count: ");
            sb.append(readUnsignedIntToInt);
            throw new com.google.android.exoplayer2.ParserException(sb.toString());
        }
    }

    public static void s(com.google.android.exoplayer2.extractor.mp4.TrackEncryptionBox trackEncryptionBox, com.google.android.exoplayer2.util.ParsableByteArray parsableByteArray, com.google.android.exoplayer2.extractor.mp4.TrackFragment trackFragment) throws com.google.android.exoplayer2.ParserException {
        int i;
        int i2 = trackEncryptionBox.perSampleIvSize;
        parsableByteArray.setPosition(8);
        if ((com.google.android.exoplayer2.extractor.mp4.Atom.b(parsableByteArray.readInt()) & 1) == 1) {
            parsableByteArray.skipBytes(8);
        }
        int readUnsignedByte = parsableByteArray.readUnsignedByte();
        int readUnsignedIntToInt = parsableByteArray.readUnsignedIntToInt();
        if (readUnsignedIntToInt > trackFragment.f) {
            int i3 = trackFragment.f;
            java.lang.StringBuilder sb = new java.lang.StringBuilder(78);
            sb.append("Saiz sample count ");
            sb.append(readUnsignedIntToInt);
            sb.append(" is greater than fragment sample count");
            sb.append(i3);
            throw new com.google.android.exoplayer2.ParserException(sb.toString());
        }
        if (readUnsignedByte == 0) {
            boolean[] zArr = trackFragment.n;
            i = 0;
            for (int i4 = 0; i4 < readUnsignedIntToInt; i4++) {
                int readUnsignedByte2 = parsableByteArray.readUnsignedByte();
                i += readUnsignedByte2;
                zArr[i4] = readUnsignedByte2 > i2;
            }
        } else {
            i = (readUnsignedByte * readUnsignedIntToInt) + 0;
            java.util.Arrays.fill(trackFragment.n, 0, readUnsignedIntToInt, readUnsignedByte > i2);
        }
        java.util.Arrays.fill(trackFragment.n, readUnsignedIntToInt, trackFragment.f, false);
        if (i > 0) {
            trackFragment.d(i);
        }
    }

    public static void t(com.google.android.exoplayer2.extractor.mp4.Atom.ContainerAtom containerAtom, @androidx.annotation.Nullable java.lang.String str, com.google.android.exoplayer2.extractor.mp4.TrackFragment trackFragment) throws com.google.android.exoplayer2.ParserException {
        byte[] bArr = null;
        com.google.android.exoplayer2.util.ParsableByteArray parsableByteArray = null;
        com.google.android.exoplayer2.util.ParsableByteArray parsableByteArray2 = null;
        for (int i = 0; i < containerAtom.c.size(); i++) {
            com.google.android.exoplayer2.extractor.mp4.Atom.LeafAtom leafAtom = containerAtom.c.get(i);
            com.google.android.exoplayer2.util.ParsableByteArray parsableByteArray3 = leafAtom.b;
            int i2 = leafAtom.a;
            if (i2 == 1935828848) {
                parsableByteArray3.setPosition(12);
                if (parsableByteArray3.readInt() == 1936025959) {
                    parsableByteArray = parsableByteArray3;
                }
            } else if (i2 == 1936158820) {
                parsableByteArray3.setPosition(12);
                if (parsableByteArray3.readInt() == 1936025959) {
                    parsableByteArray2 = parsableByteArray3;
                }
            }
        }
        if (parsableByteArray == null || parsableByteArray2 == null) {
            return;
        }
        parsableByteArray.setPosition(8);
        int c = com.google.android.exoplayer2.extractor.mp4.Atom.c(parsableByteArray.readInt());
        parsableByteArray.skipBytes(4);
        if (c == 1) {
            parsableByteArray.skipBytes(4);
        }
        if (parsableByteArray.readInt() != 1) {
            throw new com.google.android.exoplayer2.ParserException("Entry count in sbgp != 1 (unsupported).");
        }
        parsableByteArray2.setPosition(8);
        int c2 = com.google.android.exoplayer2.extractor.mp4.Atom.c(parsableByteArray2.readInt());
        parsableByteArray2.skipBytes(4);
        if (c2 == 1) {
            if (parsableByteArray2.readUnsignedInt() == 0) {
                throw new com.google.android.exoplayer2.ParserException("Variable length description in sgpd found (unsupported)");
            }
        } else if (c2 >= 2) {
            parsableByteArray2.skipBytes(4);
        }
        if (parsableByteArray2.readUnsignedInt() != 1) {
            throw new com.google.android.exoplayer2.ParserException("Entry count in sgpd != 1 (unsupported).");
        }
        parsableByteArray2.skipBytes(1);
        int readUnsignedByte = parsableByteArray2.readUnsignedByte();
        int i3 = (readUnsignedByte & 240) >> 4;
        int i4 = readUnsignedByte & 15;
        boolean z = parsableByteArray2.readUnsignedByte() == 1;
        if (z) {
            int readUnsignedByte2 = parsableByteArray2.readUnsignedByte();
            byte[] bArr2 = new byte[16];
            parsableByteArray2.readBytes(bArr2, 0, 16);
            if (readUnsignedByte2 == 0) {
                int readUnsignedByte3 = parsableByteArray2.readUnsignedByte();
                bArr = new byte[readUnsignedByte3];
                parsableByteArray2.readBytes(bArr, 0, readUnsignedByte3);
            }
            trackFragment.m = true;
            trackFragment.o = new com.google.android.exoplayer2.extractor.mp4.TrackEncryptionBox(z, str, readUnsignedByte2, bArr2, i3, i4, bArr);
        }
    }

    public static void u(com.google.android.exoplayer2.util.ParsableByteArray parsableByteArray, int i, com.google.android.exoplayer2.extractor.mp4.TrackFragment trackFragment) throws com.google.android.exoplayer2.ParserException {
        parsableByteArray.setPosition(i + 8);
        int b = com.google.android.exoplayer2.extractor.mp4.Atom.b(parsableByteArray.readInt());
        if ((b & 1) != 0) {
            throw new com.google.android.exoplayer2.ParserException("Overriding TrackEncryptionBox parameters is unsupported.");
        }
        boolean z = (b & 2) != 0;
        int readUnsignedIntToInt = parsableByteArray.readUnsignedIntToInt();
        if (readUnsignedIntToInt == 0) {
            java.util.Arrays.fill(trackFragment.n, 0, trackFragment.f, false);
            return;
        }
        if (readUnsignedIntToInt == trackFragment.f) {
            java.util.Arrays.fill(trackFragment.n, 0, readUnsignedIntToInt, z);
            trackFragment.d(parsableByteArray.bytesLeft());
            trackFragment.b(parsableByteArray);
        } else {
            int i2 = trackFragment.f;
            java.lang.StringBuilder sb = new java.lang.StringBuilder(80);
            sb.append("Senc sample count ");
            sb.append(readUnsignedIntToInt);
            sb.append(" is different from fragment sample count");
            sb.append(i2);
            throw new com.google.android.exoplayer2.ParserException(sb.toString());
        }
    }

    public static void v(com.google.android.exoplayer2.util.ParsableByteArray parsableByteArray, com.google.android.exoplayer2.extractor.mp4.TrackFragment trackFragment) throws com.google.android.exoplayer2.ParserException {
        u(parsableByteArray, 0, trackFragment);
    }

    public static android.util.Pair<java.lang.Long, com.google.android.exoplayer2.extractor.ChunkIndex> w(com.google.android.exoplayer2.util.ParsableByteArray parsableByteArray, long j) throws com.google.android.exoplayer2.ParserException {
        long readUnsignedLongToLong;
        long readUnsignedLongToLong2;
        parsableByteArray.setPosition(8);
        int c = com.google.android.exoplayer2.extractor.mp4.Atom.c(parsableByteArray.readInt());
        parsableByteArray.skipBytes(4);
        long readUnsignedInt = parsableByteArray.readUnsignedInt();
        if (c == 0) {
            readUnsignedLongToLong = parsableByteArray.readUnsignedInt();
            readUnsignedLongToLong2 = parsableByteArray.readUnsignedInt();
        } else {
            readUnsignedLongToLong = parsableByteArray.readUnsignedLongToLong();
            readUnsignedLongToLong2 = parsableByteArray.readUnsignedLongToLong();
        }
        long j2 = readUnsignedLongToLong;
        long j3 = j + readUnsignedLongToLong2;
        long scaleLargeTimestamp = com.google.android.exoplayer2.util.Util.scaleLargeTimestamp(j2, 1000000L, readUnsignedInt);
        parsableByteArray.skipBytes(2);
        int readUnsignedShort = parsableByteArray.readUnsignedShort();
        int[] iArr = new int[readUnsignedShort];
        long[] jArr = new long[readUnsignedShort];
        long[] jArr2 = new long[readUnsignedShort];
        long[] jArr3 = new long[readUnsignedShort];
        long j4 = j2;
        long j5 = scaleLargeTimestamp;
        int i = 0;
        while (i < readUnsignedShort) {
            int readInt = parsableByteArray.readInt();
            if ((readInt & Integer.MIN_VALUE) != 0) {
                throw new com.google.android.exoplayer2.ParserException("Unhandled indirect reference");
            }
            long readUnsignedInt2 = parsableByteArray.readUnsignedInt();
            iArr[i] = readInt & Integer.MAX_VALUE;
            jArr[i] = j3;
            jArr3[i] = j5;
            long j6 = j4 + readUnsignedInt2;
            long[] jArr4 = jArr2;
            long[] jArr5 = jArr3;
            int i2 = readUnsignedShort;
            long scaleLargeTimestamp2 = com.google.android.exoplayer2.util.Util.scaleLargeTimestamp(j6, 1000000L, readUnsignedInt);
            jArr4[i] = scaleLargeTimestamp2 - jArr5[i];
            parsableByteArray.skipBytes(4);
            j3 += r1[i];
            i++;
            iArr = iArr;
            jArr3 = jArr5;
            jArr2 = jArr4;
            jArr = jArr;
            readUnsignedShort = i2;
            j4 = j6;
            j5 = scaleLargeTimestamp2;
        }
        return android.util.Pair.create(java.lang.Long.valueOf(scaleLargeTimestamp), new com.google.android.exoplayer2.extractor.ChunkIndex(iArr, jArr, jArr2, jArr3));
    }

    public static long x(com.google.android.exoplayer2.util.ParsableByteArray parsableByteArray) {
        parsableByteArray.setPosition(8);
        return com.google.android.exoplayer2.extractor.mp4.Atom.c(parsableByteArray.readInt()) == 1 ? parsableByteArray.readUnsignedLongToLong() : parsableByteArray.readUnsignedInt();
    }

    @androidx.annotation.Nullable
    public static com.google.android.exoplayer2.extractor.mp4.FragmentedMp4Extractor.TrackBundle y(com.google.android.exoplayer2.util.ParsableByteArray parsableByteArray, android.util.SparseArray<com.google.android.exoplayer2.extractor.mp4.FragmentedMp4Extractor.TrackBundle> sparseArray) {
        parsableByteArray.setPosition(8);
        int b = com.google.android.exoplayer2.extractor.mp4.Atom.b(parsableByteArray.readInt());
        com.google.android.exoplayer2.extractor.mp4.FragmentedMp4Extractor.TrackBundle g = g(sparseArray, parsableByteArray.readInt());
        if (g == null) {
            return null;
        }
        if ((b & 1) != 0) {
            long readUnsignedLongToLong = parsableByteArray.readUnsignedLongToLong();
            com.google.android.exoplayer2.extractor.mp4.TrackFragment trackFragment = g.b;
            trackFragment.c = readUnsignedLongToLong;
            trackFragment.d = readUnsignedLongToLong;
        }
        com.google.android.exoplayer2.extractor.mp4.DefaultSampleValues defaultSampleValues = g.e;
        g.b.a = new com.google.android.exoplayer2.extractor.mp4.DefaultSampleValues((b & 2) != 0 ? parsableByteArray.readInt() - 1 : defaultSampleValues.a, (b & 8) != 0 ? parsableByteArray.readInt() : defaultSampleValues.b, (b & 16) != 0 ? parsableByteArray.readInt() : defaultSampleValues.c, (b & 32) != 0 ? parsableByteArray.readInt() : defaultSampleValues.d);
        return g;
    }

    public static void z(com.google.android.exoplayer2.extractor.mp4.Atom.ContainerAtom containerAtom, android.util.SparseArray<com.google.android.exoplayer2.extractor.mp4.FragmentedMp4Extractor.TrackBundle> sparseArray, int i, byte[] bArr) throws com.google.android.exoplayer2.ParserException {
        com.google.android.exoplayer2.extractor.mp4.FragmentedMp4Extractor.TrackBundle y = y(((com.google.android.exoplayer2.extractor.mp4.Atom.LeafAtom) com.google.android.exoplayer2.util.Assertions.checkNotNull(containerAtom.g(1952868452))).b, sparseArray);
        if (y == null) {
            return;
        }
        com.google.android.exoplayer2.extractor.mp4.TrackFragment trackFragment = y.b;
        long j = trackFragment.r;
        boolean z = trackFragment.f353s;
        y.k();
        y.l = true;
        com.google.android.exoplayer2.extractor.mp4.Atom.LeafAtom g = containerAtom.g(1952867444);
        if (g == null || (i & 2) != 0) {
            trackFragment.r = j;
            trackFragment.f353s = z;
        } else {
            trackFragment.r = x(g.b);
            trackFragment.f353s = true;
        }
        C(containerAtom, y, i);
        com.google.android.exoplayer2.extractor.mp4.TrackEncryptionBox sampleDescriptionEncryptionBox = y.d.a.getSampleDescriptionEncryptionBox(((com.google.android.exoplayer2.extractor.mp4.DefaultSampleValues) com.google.android.exoplayer2.util.Assertions.checkNotNull(trackFragment.a)).a);
        com.google.android.exoplayer2.extractor.mp4.Atom.LeafAtom g2 = containerAtom.g(1935763834);
        if (g2 != null) {
            s((com.google.android.exoplayer2.extractor.mp4.TrackEncryptionBox) com.google.android.exoplayer2.util.Assertions.checkNotNull(sampleDescriptionEncryptionBox), g2.b, trackFragment);
        }
        com.google.android.exoplayer2.extractor.mp4.Atom.LeafAtom g3 = containerAtom.g(1935763823);
        if (g3 != null) {
            r(g3.b, trackFragment);
        }
        com.google.android.exoplayer2.extractor.mp4.Atom.LeafAtom g4 = containerAtom.g(1936027235);
        if (g4 != null) {
            v(g4.b, trackFragment);
        }
        t(containerAtom, sampleDescriptionEncryptionBox != null ? sampleDescriptionEncryptionBox.schemeType : null, trackFragment);
        int size = containerAtom.c.size();
        for (int i2 = 0; i2 < size; i2++) {
            com.google.android.exoplayer2.extractor.mp4.Atom.LeafAtom leafAtom = containerAtom.c.get(i2);
            if (leafAtom.a == 1970628964) {
                D(leafAtom.b, trackFragment, bArr);
            }
        }
    }

    public final void E(long j) throws com.google.android.exoplayer2.ParserException {
        while (!this.m.isEmpty() && this.m.peek().b == j) {
            j(this.m.pop());
        }
        c();
    }

    public final boolean F(com.google.android.exoplayer2.extractor.ExtractorInput extractorInput) throws java.io.IOException {
        if (this.f351s == 0) {
            if (!extractorInput.readFully(this.l.getData(), 0, 8, true)) {
                return false;
            }
            this.f351s = 8;
            this.l.setPosition(0);
            this.r = this.l.readUnsignedInt();
            this.q = this.l.readInt();
        }
        long j = this.r;
        if (j == 1) {
            extractorInput.readFully(this.l.getData(), 8, 8);
            this.f351s += 8;
            this.r = this.l.readUnsignedLongToLong();
        } else if (j == 0) {
            long length = extractorInput.getLength();
            if (length == -1 && !this.m.isEmpty()) {
                length = this.m.peek().b;
            }
            if (length != -1) {
                this.r = (length - extractorInput.getPosition()) + this.f351s;
            }
        }
        if (this.r < this.f351s) {
            throw new com.google.android.exoplayer2.ParserException("Atom size less than header length (unsupported).");
        }
        long position = extractorInput.getPosition() - this.f351s;
        int i = this.q;
        if ((i == 1836019558 || i == 1835295092) && !this.H) {
            this.E.seekMap(new com.google.android.exoplayer2.extractor.SeekMap.Unseekable(this.x, position));
            this.H = true;
        }
        if (this.q == 1836019558) {
            int size = this.d.size();
            for (int i2 = 0; i2 < size; i2++) {
                com.google.android.exoplayer2.extractor.mp4.TrackFragment trackFragment = this.d.valueAt(i2).b;
                trackFragment.b = position;
                trackFragment.d = position;
                trackFragment.c = position;
            }
        }
        int i3 = this.q;
        if (i3 == 1835295092) {
            this.z = null;
            this.u = position + this.r;
            this.p = 2;
            return true;
        }
        if (J(i3)) {
            long position2 = (extractorInput.getPosition() + this.r) - 8;
            this.m.push(new com.google.android.exoplayer2.extractor.mp4.Atom.ContainerAtom(this.q, position2));
            if (this.r == this.f351s) {
                E(position2);
            } else {
                c();
            }
        } else if (K(this.q)) {
            if (this.f351s != 8) {
                throw new com.google.android.exoplayer2.ParserException("Leaf atom defines extended atom size (unsupported).");
            }
            long j2 = this.r;
            if (j2 > 2147483647L) {
                throw new com.google.android.exoplayer2.ParserException("Leaf atom with length > 2147483647 (unsupported).");
            }
            com.google.android.exoplayer2.util.ParsableByteArray parsableByteArray = new com.google.android.exoplayer2.util.ParsableByteArray((int) j2);
            java.lang.System.arraycopy(this.l.getData(), 0, parsableByteArray.getData(), 0, 8);
            this.t = parsableByteArray;
            this.p = 1;
        } else {
            if (this.r > 2147483647L) {
                throw new com.google.android.exoplayer2.ParserException("Skipping atom with length > 2147483647 (unsupported).");
            }
            this.t = null;
            this.p = 1;
        }
        return true;
    }

    public final void G(com.google.android.exoplayer2.extractor.ExtractorInput extractorInput) throws java.io.IOException {
        int i = ((int) this.r) - this.f351s;
        com.google.android.exoplayer2.util.ParsableByteArray parsableByteArray = this.t;
        if (parsableByteArray != null) {
            extractorInput.readFully(parsableByteArray.getData(), 8, i);
            l(new com.google.android.exoplayer2.extractor.mp4.Atom.LeafAtom(this.q, parsableByteArray), extractorInput.getPosition());
        } else {
            extractorInput.skipFully(i);
        }
        E(extractorInput.getPosition());
    }

    public final void H(com.google.android.exoplayer2.extractor.ExtractorInput extractorInput) throws java.io.IOException {
        int size = this.d.size();
        com.google.android.exoplayer2.extractor.mp4.FragmentedMp4Extractor.TrackBundle trackBundle = null;
        long j = Long.MAX_VALUE;
        for (int i = 0; i < size; i++) {
            com.google.android.exoplayer2.extractor.mp4.TrackFragment trackFragment = this.d.valueAt(i).b;
            if (trackFragment.q) {
                long j2 = trackFragment.d;
                if (j2 < j) {
                    trackBundle = this.d.valueAt(i);
                    j = j2;
                }
            }
        }
        if (trackBundle == null) {
            this.p = 3;
            return;
        }
        int position = (int) (j - extractorInput.getPosition());
        if (position < 0) {
            throw new com.google.android.exoplayer2.ParserException("Offset to encryption data was negative.");
        }
        extractorInput.skipFully(position);
        trackBundle.b.a(extractorInput);
    }

    public final boolean I(com.google.android.exoplayer2.extractor.ExtractorInput extractorInput) throws java.io.IOException {
        int sampleData;
        com.google.android.exoplayer2.extractor.mp4.FragmentedMp4Extractor.TrackBundle trackBundle = this.z;
        if (trackBundle == null) {
            trackBundle = f(this.d);
            if (trackBundle == null) {
                int position = (int) (this.u - extractorInput.getPosition());
                if (position < 0) {
                    throw new com.google.android.exoplayer2.ParserException("Offset to end of mdat was negative.");
                }
                extractorInput.skipFully(position);
                c();
                return false;
            }
            int d = (int) (trackBundle.d() - extractorInput.getPosition());
            if (d < 0) {
                com.google.android.exoplayer2.util.Log.w("FragmentedMp4Extractor", "Ignoring negative offset to sample data.");
                d = 0;
            }
            extractorInput.skipFully(d);
            this.z = trackBundle;
        }
        int i = 4;
        int i2 = 1;
        if (this.p == 3) {
            int f = trackBundle.f();
            this.A = f;
            if (trackBundle.f < trackBundle.i) {
                extractorInput.skipFully(f);
                trackBundle.m();
                if (!trackBundle.h()) {
                    this.z = null;
                }
                this.p = 3;
                return true;
            }
            if (trackBundle.d.a.sampleTransformation == 1) {
                this.A = f - 8;
                extractorInput.skipFully(8);
            }
            if (com.google.android.exoplayer2.util.MimeTypes.AUDIO_AC4.equals(trackBundle.d.a.format.sampleMimeType)) {
                this.B = trackBundle.i(this.A, 7);
                com.google.android.exoplayer2.audio.Ac4Util.getAc4SampleHeader(this.A, this.i);
                trackBundle.a.sampleData(this.i, 7);
                this.B += 7;
            } else {
                this.B = trackBundle.i(this.A, 0);
            }
            this.A += this.B;
            this.p = 4;
            this.C = 0;
        }
        com.google.android.exoplayer2.extractor.mp4.Track track = trackBundle.d.a;
        com.google.android.exoplayer2.extractor.TrackOutput trackOutput = trackBundle.a;
        long e = trackBundle.e();
        com.google.android.exoplayer2.util.TimestampAdjuster timestampAdjuster = this.j;
        if (timestampAdjuster != null) {
            e = timestampAdjuster.adjustSampleTimestamp(e);
        }
        long j = e;
        if (track.nalUnitLengthFieldLength == 0) {
            while (true) {
                int i3 = this.B;
                int i4 = this.A;
                if (i3 >= i4) {
                    break;
                }
                this.B += trackOutput.sampleData((com.google.android.exoplayer2.upstream.DataReader) extractorInput, i4 - i3, false);
            }
        } else {
            byte[] data = this.f.getData();
            data[0] = 0;
            data[1] = 0;
            data[2] = 0;
            int i5 = track.nalUnitLengthFieldLength;
            int i6 = i5 + 1;
            int i7 = 4 - i5;
            while (this.B < this.A) {
                int i8 = this.C;
                if (i8 == 0) {
                    extractorInput.readFully(data, i7, i6);
                    this.f.setPosition(0);
                    int readInt = this.f.readInt();
                    if (readInt < i2) {
                        throw new com.google.android.exoplayer2.ParserException("Invalid NAL length");
                    }
                    this.C = readInt - 1;
                    this.e.setPosition(0);
                    trackOutput.sampleData(this.e, i);
                    trackOutput.sampleData(this.f, i2);
                    this.D = this.G.length > 0 && com.google.android.exoplayer2.util.NalUnitUtil.isNalUnitSei(track.format.sampleMimeType, data[i]);
                    this.B += 5;
                    this.A += i7;
                } else {
                    if (this.D) {
                        this.g.reset(i8);
                        extractorInput.readFully(this.g.getData(), 0, this.C);
                        trackOutput.sampleData(this.g, this.C);
                        sampleData = this.C;
                        int unescapeStream = com.google.android.exoplayer2.util.NalUnitUtil.unescapeStream(this.g.getData(), this.g.limit());
                        this.g.setPosition("video/hevc".equals(track.format.sampleMimeType) ? 1 : 0);
                        this.g.setLimit(unescapeStream);
                        com.google.android.exoplayer2.extractor.CeaUtil.consume(j, this.g, this.G);
                    } else {
                        sampleData = trackOutput.sampleData((com.google.android.exoplayer2.upstream.DataReader) extractorInput, i8, false);
                    }
                    this.B += sampleData;
                    this.C -= sampleData;
                    i = 4;
                    i2 = 1;
                }
            }
        }
        int c = trackBundle.c();
        com.google.android.exoplayer2.extractor.mp4.TrackEncryptionBox g = trackBundle.g();
        trackOutput.sampleMetadata(j, c, this.A, 0, g != null ? g.cryptoData : null);
        o(j);
        if (!trackBundle.h()) {
            this.z = null;
        }
        this.p = 3;
        return true;
    }

    public final void c() {
        this.p = 0;
        this.f351s = 0;
    }

    public final com.google.android.exoplayer2.extractor.mp4.DefaultSampleValues d(android.util.SparseArray<com.google.android.exoplayer2.extractor.mp4.DefaultSampleValues> sparseArray, int i) {
        return sparseArray.size() == 1 ? sparseArray.valueAt(0) : (com.google.android.exoplayer2.extractor.mp4.DefaultSampleValues) com.google.android.exoplayer2.util.Assertions.checkNotNull(sparseArray.get(i));
    }

    public final void h() {
        int i;
        com.google.android.exoplayer2.extractor.TrackOutput[] trackOutputArr = new com.google.android.exoplayer2.extractor.TrackOutput[2];
        this.F = trackOutputArr;
        com.google.android.exoplayer2.extractor.TrackOutput trackOutput = this.o;
        int i2 = 0;
        if (trackOutput != null) {
            trackOutputArr[0] = trackOutput;
            i = 1;
        } else {
            i = 0;
        }
        int i3 = 100;
        if ((this.a & 4) != 0) {
            trackOutputArr[i] = this.E.track(100, 4);
            i3 = 101;
            i++;
        }
        com.google.android.exoplayer2.extractor.TrackOutput[] trackOutputArr2 = (com.google.android.exoplayer2.extractor.TrackOutput[]) com.google.android.exoplayer2.util.Util.nullSafeArrayCopy(this.F, i);
        this.F = trackOutputArr2;
        for (com.google.android.exoplayer2.extractor.TrackOutput trackOutput2 : trackOutputArr2) {
            trackOutput2.format(J);
        }
        this.G = new com.google.android.exoplayer2.extractor.TrackOutput[this.c.size()];
        while (i2 < this.G.length) {
            com.google.android.exoplayer2.extractor.TrackOutput track = this.E.track(i3, 3);
            track.format(this.c.get(i2));
            this.G[i2] = track;
            i2++;
            i3++;
        }
    }

    @Override // com.google.android.exoplayer2.extractor.Extractor
    public void init(com.google.android.exoplayer2.extractor.ExtractorOutput extractorOutput) {
        this.E = extractorOutput;
        c();
        h();
        com.google.android.exoplayer2.extractor.mp4.Track track = this.b;
        if (track != null) {
            this.d.put(0, new com.google.android.exoplayer2.extractor.mp4.FragmentedMp4Extractor.TrackBundle(extractorOutput.track(0, track.type), new com.google.android.exoplayer2.extractor.mp4.TrackSampleTable(this.b, new long[0], new int[0], 0, new long[0], new int[0], 0L), new com.google.android.exoplayer2.extractor.mp4.DefaultSampleValues(0, 0, 0, 0)));
            this.E.endTracks();
        }
    }

    public final void j(com.google.android.exoplayer2.extractor.mp4.Atom.ContainerAtom containerAtom) throws com.google.android.exoplayer2.ParserException {
        int i = containerAtom.a;
        if (i == 1836019574) {
            n(containerAtom);
        } else if (i == 1836019558) {
            m(containerAtom);
        } else {
            if (this.m.isEmpty()) {
                return;
            }
            this.m.peek().d(containerAtom);
        }
    }

    public final void k(com.google.android.exoplayer2.util.ParsableByteArray parsableByteArray) {
        long scaleLargeTimestamp;
        java.lang.String str;
        long scaleLargeTimestamp2;
        java.lang.String str2;
        long readUnsignedInt;
        long j;
        if (this.F.length == 0) {
            return;
        }
        parsableByteArray.setPosition(8);
        int c = com.google.android.exoplayer2.extractor.mp4.Atom.c(parsableByteArray.readInt());
        if (c == 0) {
            java.lang.String str3 = (java.lang.String) com.google.android.exoplayer2.util.Assertions.checkNotNull(parsableByteArray.readNullTerminatedString());
            java.lang.String str4 = (java.lang.String) com.google.android.exoplayer2.util.Assertions.checkNotNull(parsableByteArray.readNullTerminatedString());
            long readUnsignedInt2 = parsableByteArray.readUnsignedInt();
            scaleLargeTimestamp = com.google.android.exoplayer2.util.Util.scaleLargeTimestamp(parsableByteArray.readUnsignedInt(), 1000000L, readUnsignedInt2);
            long j2 = this.y;
            long j3 = j2 != -9223372036854775807L ? j2 + scaleLargeTimestamp : -9223372036854775807L;
            str = str3;
            scaleLargeTimestamp2 = com.google.android.exoplayer2.util.Util.scaleLargeTimestamp(parsableByteArray.readUnsignedInt(), 1000L, readUnsignedInt2);
            str2 = str4;
            readUnsignedInt = parsableByteArray.readUnsignedInt();
            j = j3;
        } else {
            if (c != 1) {
                java.lang.StringBuilder sb = new java.lang.StringBuilder(46);
                sb.append("Skipping unsupported emsg version: ");
                sb.append(c);
                com.google.android.exoplayer2.util.Log.w("FragmentedMp4Extractor", sb.toString());
                return;
            }
            long readUnsignedInt3 = parsableByteArray.readUnsignedInt();
            j = com.google.android.exoplayer2.util.Util.scaleLargeTimestamp(parsableByteArray.readUnsignedLongToLong(), 1000000L, readUnsignedInt3);
            long scaleLargeTimestamp3 = com.google.android.exoplayer2.util.Util.scaleLargeTimestamp(parsableByteArray.readUnsignedInt(), 1000L, readUnsignedInt3);
            long readUnsignedInt4 = parsableByteArray.readUnsignedInt();
            str = (java.lang.String) com.google.android.exoplayer2.util.Assertions.checkNotNull(parsableByteArray.readNullTerminatedString());
            scaleLargeTimestamp2 = scaleLargeTimestamp3;
            readUnsignedInt = readUnsignedInt4;
            str2 = (java.lang.String) com.google.android.exoplayer2.util.Assertions.checkNotNull(parsableByteArray.readNullTerminatedString());
            scaleLargeTimestamp = -9223372036854775807L;
        }
        byte[] bArr = new byte[parsableByteArray.bytesLeft()];
        parsableByteArray.readBytes(bArr, 0, parsableByteArray.bytesLeft());
        com.google.android.exoplayer2.util.ParsableByteArray parsableByteArray2 = new com.google.android.exoplayer2.util.ParsableByteArray(this.k.encode(new com.google.android.exoplayer2.metadata.emsg.EventMessage(str, str2, scaleLargeTimestamp2, readUnsignedInt, bArr)));
        int bytesLeft = parsableByteArray2.bytesLeft();
        for (com.google.android.exoplayer2.extractor.TrackOutput trackOutput : this.F) {
            parsableByteArray2.setPosition(0);
            trackOutput.sampleData(parsableByteArray2, bytesLeft);
        }
        if (j == -9223372036854775807L) {
            this.n.addLast(new com.google.android.exoplayer2.extractor.mp4.FragmentedMp4Extractor.MetadataSampleInfo(scaleLargeTimestamp, bytesLeft));
            this.v += bytesLeft;
            return;
        }
        com.google.android.exoplayer2.util.TimestampAdjuster timestampAdjuster = this.j;
        if (timestampAdjuster != null) {
            j = timestampAdjuster.adjustSampleTimestamp(j);
        }
        for (com.google.android.exoplayer2.extractor.TrackOutput trackOutput2 : this.F) {
            trackOutput2.sampleMetadata(j, 1, bytesLeft, 0, null);
        }
    }

    public final void l(com.google.android.exoplayer2.extractor.mp4.Atom.LeafAtom leafAtom, long j) throws com.google.android.exoplayer2.ParserException {
        if (!this.m.isEmpty()) {
            this.m.peek().e(leafAtom);
            return;
        }
        int i = leafAtom.a;
        if (i != 1936286840) {
            if (i == 1701671783) {
                k(leafAtom.b);
            }
        } else {
            android.util.Pair<java.lang.Long, com.google.android.exoplayer2.extractor.ChunkIndex> w = w(leafAtom.b, j);
            this.y = ((java.lang.Long) w.first).longValue();
            this.E.seekMap((com.google.android.exoplayer2.extractor.SeekMap) w.second);
            this.H = true;
        }
    }

    public final void m(com.google.android.exoplayer2.extractor.mp4.Atom.ContainerAtom containerAtom) throws com.google.android.exoplayer2.ParserException {
        q(containerAtom, this.d, this.a, this.h);
        com.google.android.exoplayer2.drm.DrmInitData e = e(containerAtom.c);
        if (e != null) {
            int size = this.d.size();
            for (int i = 0; i < size; i++) {
                this.d.valueAt(i).n(e);
            }
        }
        if (this.w != -9223372036854775807L) {
            int size2 = this.d.size();
            for (int i2 = 0; i2 < size2; i2++) {
                this.d.valueAt(i2).l(this.w);
            }
            this.w = -9223372036854775807L;
        }
    }

    @androidx.annotation.Nullable
    public com.google.android.exoplayer2.extractor.mp4.Track modifyTrack(@androidx.annotation.Nullable com.google.android.exoplayer2.extractor.mp4.Track track) {
        return track;
    }

    public final void n(com.google.android.exoplayer2.extractor.mp4.Atom.ContainerAtom containerAtom) throws com.google.android.exoplayer2.ParserException {
        int i = 0;
        com.google.android.exoplayer2.util.Assertions.checkState(this.b == null, "Unexpected moov box.");
        com.google.android.exoplayer2.drm.DrmInitData e = e(containerAtom.c);
        com.google.android.exoplayer2.extractor.mp4.Atom.ContainerAtom containerAtom2 = (com.google.android.exoplayer2.extractor.mp4.Atom.ContainerAtom) com.google.android.exoplayer2.util.Assertions.checkNotNull(containerAtom.f(1836475768));
        android.util.SparseArray<com.google.android.exoplayer2.extractor.mp4.DefaultSampleValues> sparseArray = new android.util.SparseArray<>();
        int size = containerAtom2.c.size();
        long j = -9223372036854775807L;
        for (int i2 = 0; i2 < size; i2++) {
            com.google.android.exoplayer2.extractor.mp4.Atom.LeafAtom leafAtom = containerAtom2.c.get(i2);
            int i3 = leafAtom.a;
            if (i3 == 1953654136) {
                android.util.Pair<java.lang.Integer, com.google.android.exoplayer2.extractor.mp4.DefaultSampleValues> A = A(leafAtom.b);
                sparseArray.put(((java.lang.Integer) A.first).intValue(), (com.google.android.exoplayer2.extractor.mp4.DefaultSampleValues) A.second);
            } else if (i3 == 1835362404) {
                j = p(leafAtom.b);
            }
        }
        java.util.List<com.google.android.exoplayer2.extractor.mp4.TrackSampleTable> x = com.google.android.exoplayer2.extractor.mp4.AtomParsers.x(containerAtom, new com.google.android.exoplayer2.extractor.GaplessInfoHolder(), j, e, (this.a & 16) != 0, false, new defpackage.di0(this));
        int size2 = x.size();
        if (this.d.size() != 0) {
            com.google.android.exoplayer2.util.Assertions.checkState(this.d.size() == size2);
            while (i < size2) {
                com.google.android.exoplayer2.extractor.mp4.TrackSampleTable trackSampleTable = x.get(i);
                com.google.android.exoplayer2.extractor.mp4.Track track = trackSampleTable.a;
                this.d.get(track.id).j(trackSampleTable, d(sparseArray, track.id));
                i++;
            }
            return;
        }
        while (i < size2) {
            com.google.android.exoplayer2.extractor.mp4.TrackSampleTable trackSampleTable2 = x.get(i);
            com.google.android.exoplayer2.extractor.mp4.Track track2 = trackSampleTable2.a;
            this.d.put(track2.id, new com.google.android.exoplayer2.extractor.mp4.FragmentedMp4Extractor.TrackBundle(this.E.track(i, track2.type), trackSampleTable2, d(sparseArray, track2.id)));
            this.x = java.lang.Math.max(this.x, track2.durationUs);
            i++;
        }
        this.E.endTracks();
    }

    public final void o(long j) {
        while (!this.n.isEmpty()) {
            com.google.android.exoplayer2.extractor.mp4.FragmentedMp4Extractor.MetadataSampleInfo removeFirst = this.n.removeFirst();
            this.v -= removeFirst.b;
            long j2 = removeFirst.a + j;
            com.google.android.exoplayer2.util.TimestampAdjuster timestampAdjuster = this.j;
            if (timestampAdjuster != null) {
                j2 = timestampAdjuster.adjustSampleTimestamp(j2);
            }
            for (com.google.android.exoplayer2.extractor.TrackOutput trackOutput : this.F) {
                trackOutput.sampleMetadata(j2, 1, removeFirst.b, this.v, null);
            }
        }
    }

    @Override // com.google.android.exoplayer2.extractor.Extractor
    public int read(com.google.android.exoplayer2.extractor.ExtractorInput extractorInput, com.google.android.exoplayer2.extractor.PositionHolder positionHolder) throws java.io.IOException {
        while (true) {
            int i = this.p;
            if (i != 0) {
                if (i == 1) {
                    G(extractorInput);
                } else if (i == 2) {
                    H(extractorInput);
                } else if (I(extractorInput)) {
                    return 0;
                }
            } else if (!F(extractorInput)) {
                return -1;
            }
        }
    }

    @Override // com.google.android.exoplayer2.extractor.Extractor
    public void release() {
    }

    @Override // com.google.android.exoplayer2.extractor.Extractor
    public void seek(long j, long j2) {
        int size = this.d.size();
        for (int i = 0; i < size; i++) {
            this.d.valueAt(i).k();
        }
        this.n.clear();
        this.v = 0;
        this.w = j2;
        this.m.clear();
        c();
    }

    @Override // com.google.android.exoplayer2.extractor.Extractor
    public boolean sniff(com.google.android.exoplayer2.extractor.ExtractorInput extractorInput) throws java.io.IOException {
        return com.google.android.exoplayer2.extractor.mp4.Sniffer.b(extractorInput);
    }
}
