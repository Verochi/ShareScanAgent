package com.google.android.exoplayer2.metadata.dvbsi;

/* loaded from: classes22.dex */
public final class AppInfoTableDecoder extends com.google.android.exoplayer2.metadata.SimpleMetadataDecoder {
    public static final int APPLICATION_INFORMATION_TABLE_ID = 116;

    @androidx.annotation.Nullable
    public static com.google.android.exoplayer2.metadata.Metadata a(com.google.android.exoplayer2.util.ParsableBitArray parsableBitArray) {
        parsableBitArray.skipBits(12);
        int bytePosition = (parsableBitArray.getBytePosition() + parsableBitArray.readBits(12)) - 4;
        parsableBitArray.skipBits(44);
        parsableBitArray.skipBytes(parsableBitArray.readBits(12));
        parsableBitArray.skipBits(16);
        java.util.ArrayList arrayList = new java.util.ArrayList();
        while (true) {
            java.lang.String str = null;
            if (parsableBitArray.getBytePosition() >= bytePosition) {
                break;
            }
            parsableBitArray.skipBits(48);
            int readBits = parsableBitArray.readBits(8);
            parsableBitArray.skipBits(4);
            int bytePosition2 = parsableBitArray.getBytePosition() + parsableBitArray.readBits(12);
            java.lang.String str2 = null;
            while (parsableBitArray.getBytePosition() < bytePosition2) {
                int readBits2 = parsableBitArray.readBits(8);
                int readBits3 = parsableBitArray.readBits(8);
                int bytePosition3 = parsableBitArray.getBytePosition() + readBits3;
                if (readBits2 == 2) {
                    int readBits4 = parsableBitArray.readBits(16);
                    parsableBitArray.skipBits(8);
                    if (readBits4 == 3) {
                        while (parsableBitArray.getBytePosition() < bytePosition3) {
                            str = parsableBitArray.readBytesAsString(parsableBitArray.readBits(8), com.google.common.base.Charsets.US_ASCII);
                            int readBits5 = parsableBitArray.readBits(8);
                            for (int i = 0; i < readBits5; i++) {
                                parsableBitArray.skipBytes(parsableBitArray.readBits(8));
                            }
                        }
                    }
                } else if (readBits2 == 21) {
                    str2 = parsableBitArray.readBytesAsString(readBits3, com.google.common.base.Charsets.US_ASCII);
                }
                parsableBitArray.setPosition(bytePosition3 * 8);
            }
            parsableBitArray.setPosition(bytePosition2 * 8);
            if (str != null && str2 != null) {
                arrayList.add(new com.google.android.exoplayer2.metadata.dvbsi.AppInfoTable(readBits, str2.length() != 0 ? str.concat(str2) : new java.lang.String(str)));
            }
        }
        if (arrayList.isEmpty()) {
            return null;
        }
        return new com.google.android.exoplayer2.metadata.Metadata(arrayList);
    }

    @Override // com.google.android.exoplayer2.metadata.SimpleMetadataDecoder
    @androidx.annotation.Nullable
    public com.google.android.exoplayer2.metadata.Metadata decode(com.google.android.exoplayer2.metadata.MetadataInputBuffer metadataInputBuffer, java.nio.ByteBuffer byteBuffer) {
        if (byteBuffer.get() == 116) {
            return a(new com.google.android.exoplayer2.util.ParsableBitArray(byteBuffer.array(), byteBuffer.limit()));
        }
        return null;
    }
}
