package com.google.android.exoplayer2.text;

/* loaded from: classes22.dex */
public interface SubtitleDecoderFactory {
    public static final com.google.android.exoplayer2.text.SubtitleDecoderFactory DEFAULT = new com.google.android.exoplayer2.text.SubtitleDecoderFactory.AnonymousClass1();

    /* renamed from: com.google.android.exoplayer2.text.SubtitleDecoderFactory$1, reason: invalid class name */
    public class AnonymousClass1 implements com.google.android.exoplayer2.text.SubtitleDecoderFactory {
        @Override // com.google.android.exoplayer2.text.SubtitleDecoderFactory
        public com.google.android.exoplayer2.text.SubtitleDecoder createDecoder(com.google.android.exoplayer2.Format format) {
            java.lang.String str = format.sampleMimeType;
            if (str != null) {
                switch (str) {
                    case "application/dvbsubs":
                        return new com.google.android.exoplayer2.text.dvb.DvbDecoder(format.initializationData);
                    case "application/pgs":
                        return new com.google.android.exoplayer2.text.pgs.PgsDecoder();
                    case "application/x-mp4-vtt":
                        return new com.google.android.exoplayer2.text.webvtt.Mp4WebvttDecoder();
                    case "text/vtt":
                        return new com.google.android.exoplayer2.text.webvtt.WebvttDecoder();
                    case "application/x-quicktime-tx3g":
                        return new com.google.android.exoplayer2.text.tx3g.Tx3gDecoder(format.initializationData);
                    case "text/x-ssa":
                        return new com.google.android.exoplayer2.text.ssa.SsaDecoder(format.initializationData);
                    case "application/x-mp4-cea-608":
                    case "application/cea-608":
                        return new com.google.android.exoplayer2.text.cea.Cea608Decoder(str, format.accessibilityChannel, com.google.android.exoplayer2.text.cea.Cea608Decoder.MIN_DATA_CHANNEL_TIMEOUT_MS);
                    case "application/cea-708":
                        return new com.google.android.exoplayer2.text.cea.Cea708Decoder(format.accessibilityChannel, format.initializationData);
                    case "application/x-subrip":
                        return new com.google.android.exoplayer2.text.subrip.SubripDecoder();
                    case "application/ttml+xml":
                        return new com.google.android.exoplayer2.text.ttml.TtmlDecoder();
                }
            }
            java.lang.String valueOf = java.lang.String.valueOf(str);
            throw new java.lang.IllegalArgumentException(valueOf.length() != 0 ? "Attempted to create decoder for unsupported MIME type: ".concat(valueOf) : new java.lang.String("Attempted to create decoder for unsupported MIME type: "));
        }

        @Override // com.google.android.exoplayer2.text.SubtitleDecoderFactory
        public boolean supportsFormat(com.google.android.exoplayer2.Format format) {
            java.lang.String str = format.sampleMimeType;
            return "text/vtt".equals(str) || "text/x-ssa".equals(str) || "application/ttml+xml".equals(str) || "application/x-mp4-vtt".equals(str) || "application/x-subrip".equals(str) || "application/x-quicktime-tx3g".equals(str) || "application/cea-608".equals(str) || "application/x-mp4-cea-608".equals(str) || "application/cea-708".equals(str) || "application/dvbsubs".equals(str) || "application/pgs".equals(str);
        }
    }

    com.google.android.exoplayer2.text.SubtitleDecoder createDecoder(com.google.android.exoplayer2.Format format);

    boolean supportsFormat(com.google.android.exoplayer2.Format format);
}
