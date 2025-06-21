package com.google.android.exoplayer2.extractor.ts;

/* loaded from: classes22.dex */
public interface TsPayloadReader {
    public static final int FLAG_DATA_ALIGNMENT_INDICATOR = 4;
    public static final int FLAG_PAYLOAD_UNIT_START_INDICATOR = 1;
    public static final int FLAG_RANDOM_ACCESS_INDICATOR = 2;

    public static final class DvbSubtitleInfo {
        public final byte[] initializationData;
        public final java.lang.String language;
        public final int type;

        public DvbSubtitleInfo(java.lang.String str, int i, byte[] bArr) {
            this.language = str;
            this.type = i;
            this.initializationData = bArr;
        }
    }

    public static final class EsInfo {
        public final byte[] descriptorBytes;
        public final java.util.List<com.google.android.exoplayer2.extractor.ts.TsPayloadReader.DvbSubtitleInfo> dvbSubtitleInfos;

        @androidx.annotation.Nullable
        public final java.lang.String language;
        public final int streamType;

        public EsInfo(int i, @androidx.annotation.Nullable java.lang.String str, @androidx.annotation.Nullable java.util.List<com.google.android.exoplayer2.extractor.ts.TsPayloadReader.DvbSubtitleInfo> list, byte[] bArr) {
            this.streamType = i;
            this.language = str;
            this.dvbSubtitleInfos = list == null ? java.util.Collections.emptyList() : java.util.Collections.unmodifiableList(list);
            this.descriptorBytes = bArr;
        }
    }

    public interface Factory {
        android.util.SparseArray<com.google.android.exoplayer2.extractor.ts.TsPayloadReader> createInitialPayloadReaders();

        @androidx.annotation.Nullable
        com.google.android.exoplayer2.extractor.ts.TsPayloadReader createPayloadReader(int i, com.google.android.exoplayer2.extractor.ts.TsPayloadReader.EsInfo esInfo);
    }

    @java.lang.annotation.Documented
    @java.lang.annotation.Retention(java.lang.annotation.RetentionPolicy.SOURCE)
    public @interface Flags {
    }

    public static final class TrackIdGenerator {
        public final java.lang.String a;
        public final int b;
        public final int c;
        public int d;
        public java.lang.String e;

        public TrackIdGenerator(int i, int i2) {
            this(Integer.MIN_VALUE, i, i2);
        }

        public TrackIdGenerator(int i, int i2, int i3) {
            java.lang.String str;
            if (i != Integer.MIN_VALUE) {
                java.lang.StringBuilder sb = new java.lang.StringBuilder(12);
                sb.append(i);
                sb.append(net.lingala.zip4j.util.InternalZipConstants.ZIP_FILE_SEPARATOR);
                str = sb.toString();
            } else {
                str = "";
            }
            this.a = str;
            this.b = i2;
            this.c = i3;
            this.d = Integer.MIN_VALUE;
            this.e = "";
        }

        public final void a() {
            if (this.d == Integer.MIN_VALUE) {
                throw new java.lang.IllegalStateException("generateNewId() must be called before retrieving ids.");
            }
        }

        public void generateNewId() {
            int i = this.d;
            int i2 = i == Integer.MIN_VALUE ? this.b : i + this.c;
            this.d = i2;
            java.lang.String str = this.a;
            java.lang.StringBuilder sb = new java.lang.StringBuilder(java.lang.String.valueOf(str).length() + 11);
            sb.append(str);
            sb.append(i2);
            this.e = sb.toString();
        }

        public java.lang.String getFormatId() {
            a();
            return this.e;
        }

        public int getTrackId() {
            a();
            return this.d;
        }
    }

    void consume(com.google.android.exoplayer2.util.ParsableByteArray parsableByteArray, int i) throws com.google.android.exoplayer2.ParserException;

    void init(com.google.android.exoplayer2.util.TimestampAdjuster timestampAdjuster, com.google.android.exoplayer2.extractor.ExtractorOutput extractorOutput, com.google.android.exoplayer2.extractor.ts.TsPayloadReader.TrackIdGenerator trackIdGenerator);

    void seek();
}
