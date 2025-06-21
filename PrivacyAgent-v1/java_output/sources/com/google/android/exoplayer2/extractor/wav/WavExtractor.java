package com.google.android.exoplayer2.extractor.wav;

/* loaded from: classes22.dex */
public final class WavExtractor implements com.google.android.exoplayer2.extractor.Extractor {
    public static final com.google.android.exoplayer2.extractor.ExtractorsFactory FACTORY = new defpackage.ie3();
    public com.google.android.exoplayer2.extractor.ExtractorOutput a;
    public com.google.android.exoplayer2.extractor.TrackOutput b;
    public com.google.android.exoplayer2.extractor.wav.WavExtractor.OutputWriter c;
    public int d = -1;
    public long e = -1;

    public static final class ImaAdPcmOutputWriter implements com.google.android.exoplayer2.extractor.wav.WavExtractor.OutputWriter {
        public static final int[] m = {-1, -1, -1, -1, 2, 4, 6, 8, -1, -1, -1, -1, 2, 4, 6, 8};
        public static final int[] n = {7, 8, 9, 10, 11, 12, 13, 14, 16, 17, 19, 21, 23, 25, 28, 31, 34, 37, 41, 45, 50, 55, 60, 66, 73, 80, 88, 97, 107, 118, 130, com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField.CALL_DOWNLOAD_MODEL_SET_MIME_TYPE, 157, 173, 190, com.qq.e.comm.adevent.AdEventType.VIDEO_INIT, 230, com.igexin.push.config.c.E, com.anythink.expressad.foundation.g.a.aT, okhttp3.internal.http.StatusLine.HTTP_TEMP_REDIRECT, 337, 371, com.bytedance.sdk.openadsdk.TTAdConstant.INTERACTION_TYPE_CODE, 449, 494, 544, 598, 658, 724, 796, 876, 963, com.ss.android.socialbase.downloader.constants.DownloadErrorCode.ERROR_HTTP_RETRY, 1166, com.badlogic.gdx.graphics.GL20.GL_INVALID_OPERATION, 1411, 1552, 1707, 1878, 2066, 2272, 2499, 2749, 3024, 3327, 3660, 4026, 4428, 4871, 5358, 5894, 6484, 7132, 7845, 8630, 9493, 10442, 11487, 12635, 13899, 15289, 16818, 18500, 20350, 22385, 24623, 27086, 29794, 32767};
        public final com.google.android.exoplayer2.extractor.ExtractorOutput a;
        public final com.google.android.exoplayer2.extractor.TrackOutput b;
        public final com.google.android.exoplayer2.extractor.wav.WavHeader c;
        public final int d;
        public final byte[] e;
        public final com.google.android.exoplayer2.util.ParsableByteArray f;
        public final int g;
        public final com.google.android.exoplayer2.Format h;
        public int i;
        public long j;
        public int k;
        public long l;

        public ImaAdPcmOutputWriter(com.google.android.exoplayer2.extractor.ExtractorOutput extractorOutput, com.google.android.exoplayer2.extractor.TrackOutput trackOutput, com.google.android.exoplayer2.extractor.wav.WavHeader wavHeader) throws com.google.android.exoplayer2.ParserException {
            this.a = extractorOutput;
            this.b = trackOutput;
            this.c = wavHeader;
            int max = java.lang.Math.max(1, wavHeader.c / 10);
            this.g = max;
            com.google.android.exoplayer2.util.ParsableByteArray parsableByteArray = new com.google.android.exoplayer2.util.ParsableByteArray(wavHeader.g);
            parsableByteArray.readLittleEndianUnsignedShort();
            int readLittleEndianUnsignedShort = parsableByteArray.readLittleEndianUnsignedShort();
            this.d = readLittleEndianUnsignedShort;
            int i = wavHeader.b;
            int i2 = (((wavHeader.e - (i * 4)) * 8) / (wavHeader.f * i)) + 1;
            if (readLittleEndianUnsignedShort == i2) {
                int ceilDivide = com.google.android.exoplayer2.util.Util.ceilDivide(max, readLittleEndianUnsignedShort);
                this.e = new byte[wavHeader.e * ceilDivide];
                this.f = new com.google.android.exoplayer2.util.ParsableByteArray(ceilDivide * h(readLittleEndianUnsignedShort, i));
                int i3 = ((wavHeader.c * wavHeader.e) * 8) / readLittleEndianUnsignedShort;
                this.h = new com.google.android.exoplayer2.Format.Builder().setSampleMimeType("audio/raw").setAverageBitrate(i3).setPeakBitrate(i3).setMaxInputSize(h(max, i)).setChannelCount(wavHeader.b).setSampleRate(wavHeader.c).setPcmEncoding(2).build();
                return;
            }
            java.lang.StringBuilder sb = new java.lang.StringBuilder(56);
            sb.append("Expected frames per block: ");
            sb.append(i2);
            sb.append("; got: ");
            sb.append(readLittleEndianUnsignedShort);
            throw new com.google.android.exoplayer2.ParserException(sb.toString());
        }

        public static int h(int i, int i2) {
            return i * 2 * i2;
        }

        /* JADX WARN: Removed duplicated region for block: B:15:0x0048  */
        /* JADX WARN: Removed duplicated region for block: B:6:0x0021  */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:8:0x0036 -> B:3:0x001c). Please report as a decompilation issue!!! */
        @Override // com.google.android.exoplayer2.extractor.wav.WavExtractor.OutputWriter
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public boolean a(com.google.android.exoplayer2.extractor.ExtractorInput extractorInput, long j) throws java.io.IOException {
            boolean z;
            int i;
            int f;
            int ceilDivide = com.google.android.exoplayer2.util.Util.ceilDivide(this.g - f(this.k), this.d) * this.c.e;
            if (j != 0) {
                z = false;
                while (!z) {
                    if (this.i >= ceilDivide) {
                        break;
                    }
                    int read = extractorInput.read(this.e, this.i, (int) java.lang.Math.min(ceilDivide - r2, j));
                    if (read != -1) {
                        this.i += read;
                    }
                }
                i = this.i / this.c.e;
                if (i > 0) {
                    d(this.e, i, this.f);
                    this.i -= i * this.c.e;
                    int limit = this.f.limit();
                    this.b.sampleData(this.f, limit);
                    int i2 = this.k + limit;
                    this.k = i2;
                    int f2 = f(i2);
                    int i3 = this.g;
                    if (f2 >= i3) {
                        i(i3);
                    }
                }
                if (z && (f = f(this.k)) > 0) {
                    i(f);
                }
                return z;
            }
            z = true;
            while (!z) {
            }
            i = this.i / this.c.e;
            if (i > 0) {
            }
            if (z) {
                i(f);
            }
            return z;
        }

        @Override // com.google.android.exoplayer2.extractor.wav.WavExtractor.OutputWriter
        public void b(int i, long j) {
            this.a.seekMap(new com.google.android.exoplayer2.extractor.wav.WavSeekMap(this.c, this.d, i, j));
            this.b.format(this.h);
        }

        @Override // com.google.android.exoplayer2.extractor.wav.WavExtractor.OutputWriter
        public void c(long j) {
            this.i = 0;
            this.j = j;
            this.k = 0;
            this.l = 0L;
        }

        public final void d(byte[] bArr, int i, com.google.android.exoplayer2.util.ParsableByteArray parsableByteArray) {
            for (int i2 = 0; i2 < i; i2++) {
                for (int i3 = 0; i3 < this.c.b; i3++) {
                    e(bArr, i2, i3, parsableByteArray.getData());
                }
            }
            parsableByteArray.reset(g(this.d * i));
        }

        public final void e(byte[] bArr, int i, int i2, byte[] bArr2) {
            com.google.android.exoplayer2.extractor.wav.WavHeader wavHeader = this.c;
            int i3 = wavHeader.e;
            int i4 = wavHeader.b;
            int i5 = (i * i3) + (i2 * 4);
            int i6 = (i4 * 4) + i5;
            int i7 = (i3 / i4) - 4;
            int i8 = (short) (((bArr[i5 + 1] & 255) << 8) | (bArr[i5] & 255));
            int min = java.lang.Math.min(bArr[i5 + 2] & 255, 88);
            int i9 = n[min];
            int i10 = ((i * this.d * i4) + i2) * 2;
            bArr2[i10] = (byte) (i8 & 255);
            bArr2[i10 + 1] = (byte) (i8 >> 8);
            for (int i11 = 0; i11 < i7 * 2; i11++) {
                int i12 = bArr[((i11 / 8) * i4 * 4) + i6 + ((i11 / 2) % 4)] & 255;
                int i13 = i11 % 2 == 0 ? i12 & 15 : i12 >> 4;
                int i14 = ((((i13 & 7) * 2) + 1) * i9) >> 3;
                if ((i13 & 8) != 0) {
                    i14 = -i14;
                }
                i8 = com.google.android.exoplayer2.util.Util.constrainValue(i8 + i14, -32768, 32767);
                i10 += i4 * 2;
                bArr2[i10] = (byte) (i8 & 255);
                bArr2[i10 + 1] = (byte) (i8 >> 8);
                int i15 = min + m[i13];
                int[] iArr = n;
                min = com.google.android.exoplayer2.util.Util.constrainValue(i15, 0, iArr.length - 1);
                i9 = iArr[min];
            }
        }

        public final int f(int i) {
            return i / (this.c.b * 2);
        }

        public final int g(int i) {
            return h(i, this.c.b);
        }

        public final void i(int i) {
            long scaleLargeTimestamp = this.j + com.google.android.exoplayer2.util.Util.scaleLargeTimestamp(this.l, 1000000L, this.c.c);
            int g = g(i);
            this.b.sampleMetadata(scaleLargeTimestamp, 1, g, this.k - g, null);
            this.l += i;
            this.k -= g;
        }
    }

    public interface OutputWriter {
        boolean a(com.google.android.exoplayer2.extractor.ExtractorInput extractorInput, long j) throws java.io.IOException;

        void b(int i, long j) throws com.google.android.exoplayer2.ParserException;

        void c(long j);
    }

    public static final class PassthroughOutputWriter implements com.google.android.exoplayer2.extractor.wav.WavExtractor.OutputWriter {
        public final com.google.android.exoplayer2.extractor.ExtractorOutput a;
        public final com.google.android.exoplayer2.extractor.TrackOutput b;
        public final com.google.android.exoplayer2.extractor.wav.WavHeader c;
        public final com.google.android.exoplayer2.Format d;
        public final int e;
        public long f;
        public int g;
        public long h;

        public PassthroughOutputWriter(com.google.android.exoplayer2.extractor.ExtractorOutput extractorOutput, com.google.android.exoplayer2.extractor.TrackOutput trackOutput, com.google.android.exoplayer2.extractor.wav.WavHeader wavHeader, java.lang.String str, int i) throws com.google.android.exoplayer2.ParserException {
            this.a = extractorOutput;
            this.b = trackOutput;
            this.c = wavHeader;
            int i2 = (wavHeader.b * wavHeader.f) / 8;
            if (wavHeader.e == i2) {
                int i3 = wavHeader.c;
                int i4 = i3 * i2 * 8;
                int max = java.lang.Math.max(i2, (i3 * i2) / 10);
                this.e = max;
                this.d = new com.google.android.exoplayer2.Format.Builder().setSampleMimeType(str).setAverageBitrate(i4).setPeakBitrate(i4).setMaxInputSize(max).setChannelCount(wavHeader.b).setSampleRate(wavHeader.c).setPcmEncoding(i).build();
                return;
            }
            int i5 = wavHeader.e;
            java.lang.StringBuilder sb = new java.lang.StringBuilder(50);
            sb.append("Expected block size: ");
            sb.append(i2);
            sb.append("; got: ");
            sb.append(i5);
            throw new com.google.android.exoplayer2.ParserException(sb.toString());
        }

        @Override // com.google.android.exoplayer2.extractor.wav.WavExtractor.OutputWriter
        public boolean a(com.google.android.exoplayer2.extractor.ExtractorInput extractorInput, long j) throws java.io.IOException {
            int i;
            int i2;
            long j2 = j;
            while (j2 > 0 && (i = this.g) < (i2 = this.e)) {
                int sampleData = this.b.sampleData((com.google.android.exoplayer2.upstream.DataReader) extractorInput, (int) java.lang.Math.min(i2 - i, j2), true);
                if (sampleData == -1) {
                    j2 = 0;
                } else {
                    this.g += sampleData;
                    j2 -= sampleData;
                }
            }
            int i3 = this.c.e;
            int i4 = this.g / i3;
            if (i4 > 0) {
                long scaleLargeTimestamp = this.f + com.google.android.exoplayer2.util.Util.scaleLargeTimestamp(this.h, 1000000L, r1.c);
                int i5 = i4 * i3;
                int i6 = this.g - i5;
                this.b.sampleMetadata(scaleLargeTimestamp, 1, i5, i6, null);
                this.h += i4;
                this.g = i6;
            }
            return j2 <= 0;
        }

        @Override // com.google.android.exoplayer2.extractor.wav.WavExtractor.OutputWriter
        public void b(int i, long j) {
            this.a.seekMap(new com.google.android.exoplayer2.extractor.wav.WavSeekMap(this.c, 1, i, j));
            this.b.format(this.d);
        }

        @Override // com.google.android.exoplayer2.extractor.wav.WavExtractor.OutputWriter
        public void c(long j) {
            this.f = j;
            this.g = 0;
            this.h = 0L;
        }
    }

    public static /* synthetic */ com.google.android.exoplayer2.extractor.Extractor[] c() {
        return new com.google.android.exoplayer2.extractor.Extractor[]{new com.google.android.exoplayer2.extractor.wav.WavExtractor()};
    }

    @org.checkerframework.checker.nullness.qual.EnsuresNonNull({"extractorOutput", "trackOutput"})
    public final void b() {
        com.google.android.exoplayer2.util.Assertions.checkStateNotNull(this.b);
        com.google.android.exoplayer2.util.Util.castNonNull(this.a);
    }

    @Override // com.google.android.exoplayer2.extractor.Extractor
    public void init(com.google.android.exoplayer2.extractor.ExtractorOutput extractorOutput) {
        this.a = extractorOutput;
        this.b = extractorOutput.track(0, 1);
        extractorOutput.endTracks();
    }

    @Override // com.google.android.exoplayer2.extractor.Extractor
    public int read(com.google.android.exoplayer2.extractor.ExtractorInput extractorInput, com.google.android.exoplayer2.extractor.PositionHolder positionHolder) throws java.io.IOException {
        b();
        if (this.c == null) {
            com.google.android.exoplayer2.extractor.wav.WavHeader a = com.google.android.exoplayer2.extractor.wav.WavHeaderReader.a(extractorInput);
            if (a == null) {
                throw new com.google.android.exoplayer2.ParserException("Unsupported or unrecognized wav header.");
            }
            int i = a.a;
            if (i == 17) {
                this.c = new com.google.android.exoplayer2.extractor.wav.WavExtractor.ImaAdPcmOutputWriter(this.a, this.b, a);
            } else if (i == 6) {
                this.c = new com.google.android.exoplayer2.extractor.wav.WavExtractor.PassthroughOutputWriter(this.a, this.b, a, "audio/g711-alaw", -1);
            } else if (i == 7) {
                this.c = new com.google.android.exoplayer2.extractor.wav.WavExtractor.PassthroughOutputWriter(this.a, this.b, a, "audio/g711-mlaw", -1);
            } else {
                int pcmEncodingForType = com.google.android.exoplayer2.audio.WavUtil.getPcmEncodingForType(i, a.f);
                if (pcmEncodingForType == 0) {
                    int i2 = a.a;
                    java.lang.StringBuilder sb = new java.lang.StringBuilder(40);
                    sb.append("Unsupported WAV format type: ");
                    sb.append(i2);
                    throw new com.google.android.exoplayer2.ParserException(sb.toString());
                }
                this.c = new com.google.android.exoplayer2.extractor.wav.WavExtractor.PassthroughOutputWriter(this.a, this.b, a, "audio/raw", pcmEncodingForType);
            }
        }
        if (this.d == -1) {
            android.util.Pair<java.lang.Long, java.lang.Long> b = com.google.android.exoplayer2.extractor.wav.WavHeaderReader.b(extractorInput);
            this.d = ((java.lang.Long) b.first).intValue();
            long longValue = ((java.lang.Long) b.second).longValue();
            this.e = longValue;
            this.c.b(this.d, longValue);
        } else if (extractorInput.getPosition() == 0) {
            extractorInput.skipFully(this.d);
        }
        com.google.android.exoplayer2.util.Assertions.checkState(this.e != -1);
        return this.c.a(extractorInput, this.e - extractorInput.getPosition()) ? -1 : 0;
    }

    @Override // com.google.android.exoplayer2.extractor.Extractor
    public void release() {
    }

    @Override // com.google.android.exoplayer2.extractor.Extractor
    public void seek(long j, long j2) {
        com.google.android.exoplayer2.extractor.wav.WavExtractor.OutputWriter outputWriter = this.c;
        if (outputWriter != null) {
            outputWriter.c(j2);
        }
    }

    @Override // com.google.android.exoplayer2.extractor.Extractor
    public boolean sniff(com.google.android.exoplayer2.extractor.ExtractorInput extractorInput) throws java.io.IOException {
        return com.google.android.exoplayer2.extractor.wav.WavHeaderReader.a(extractorInput) != null;
    }
}
