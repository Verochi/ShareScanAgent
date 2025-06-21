package com.google.android.exoplayer2.metadata;

/* loaded from: classes22.dex */
public interface MetadataDecoderFactory {
    public static final com.google.android.exoplayer2.metadata.MetadataDecoderFactory DEFAULT = new com.google.android.exoplayer2.metadata.MetadataDecoderFactory.AnonymousClass1();

    /* renamed from: com.google.android.exoplayer2.metadata.MetadataDecoderFactory$1, reason: invalid class name */
    public class AnonymousClass1 implements com.google.android.exoplayer2.metadata.MetadataDecoderFactory {
        @Override // com.google.android.exoplayer2.metadata.MetadataDecoderFactory
        public com.google.android.exoplayer2.metadata.MetadataDecoder createDecoder(com.google.android.exoplayer2.Format format) {
            java.lang.String str = format.sampleMimeType;
            if (str != null) {
                switch (str) {
                    case "application/vnd.dvb.ait":
                        return new com.google.android.exoplayer2.metadata.dvbsi.AppInfoTableDecoder();
                    case "application/x-icy":
                        return new com.google.android.exoplayer2.metadata.icy.IcyDecoder();
                    case "application/id3":
                        return new com.google.android.exoplayer2.metadata.id3.Id3Decoder();
                    case "application/x-emsg":
                        return new com.google.android.exoplayer2.metadata.emsg.EventMessageDecoder();
                    case "application/x-scte35":
                        return new com.google.android.exoplayer2.metadata.scte35.SpliceInfoDecoder();
                }
            }
            java.lang.String valueOf = java.lang.String.valueOf(str);
            throw new java.lang.IllegalArgumentException(valueOf.length() != 0 ? "Attempted to create decoder for unsupported MIME type: ".concat(valueOf) : new java.lang.String("Attempted to create decoder for unsupported MIME type: "));
        }

        @Override // com.google.android.exoplayer2.metadata.MetadataDecoderFactory
        public boolean supportsFormat(com.google.android.exoplayer2.Format format) {
            java.lang.String str = format.sampleMimeType;
            return "application/id3".equals(str) || "application/x-emsg".equals(str) || "application/x-scte35".equals(str) || com.google.android.exoplayer2.util.MimeTypes.APPLICATION_ICY.equals(str) || com.google.android.exoplayer2.util.MimeTypes.APPLICATION_AIT.equals(str);
        }
    }

    com.google.android.exoplayer2.metadata.MetadataDecoder createDecoder(com.google.android.exoplayer2.Format format);

    boolean supportsFormat(com.google.android.exoplayer2.Format format);
}
