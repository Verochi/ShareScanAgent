package org.apache.tools.zip;

/* loaded from: classes26.dex */
public abstract class ZipUtil {
    public static final byte[] a = org.apache.tools.zip.ZipLong.getBytes(8448);

    public static boolean a(org.apache.tools.zip.ZipEntry zipEntry) {
        return f(zipEntry) && g(zipEntry);
    }

    public static long adjustToLong(int i) {
        return i < 0 ? i + tv.danmaku.ijk.media.player.IjkMediaMeta.AV_CH_WIDE_RIGHT : i;
    }

    public static void b(org.apache.tools.zip.ZipEntry zipEntry) throws org.apache.tools.zip.UnsupportedZipFeatureException {
        if (!f(zipEntry)) {
            throw new org.apache.tools.zip.UnsupportedZipFeatureException(org.apache.tools.zip.UnsupportedZipFeatureException.Feature.ENCRYPTION, zipEntry);
        }
        if (!g(zipEntry)) {
            throw new org.apache.tools.zip.UnsupportedZipFeatureException(org.apache.tools.zip.UnsupportedZipFeatureException.Feature.METHOD, zipEntry);
        }
    }

    public static byte[] c(byte[] bArr) {
        if (bArr == null) {
            return null;
        }
        int length = bArr.length;
        byte[] bArr2 = new byte[length];
        java.lang.System.arraycopy(bArr, 0, bArr2, 0, length);
        return bArr2;
    }

    public static java.lang.String d(org.apache.tools.zip.AbstractUnicodeExtraField abstractUnicodeExtraField, byte[] bArr) {
        if (abstractUnicodeExtraField != null) {
            java.util.zip.CRC32 crc32 = new java.util.zip.CRC32();
            crc32.update(bArr);
            if (crc32.getValue() == abstractUnicodeExtraField.getNameCRC32()) {
                try {
                    return org.apache.tools.zip.ZipEncodingHelper.c.decode(abstractUnicodeExtraField.getUnicodeName());
                } catch (java.io.IOException unused) {
                }
            }
        }
        return null;
    }

    public static long dosToJavaTime(long j) {
        java.util.Calendar calendar = java.util.Calendar.getInstance();
        calendar.set(1, ((int) ((j >> 25) & 127)) + 1980);
        calendar.set(2, ((int) ((j >> 21) & 15)) - 1);
        calendar.set(5, ((int) (j >> 16)) & 31);
        calendar.set(11, ((int) (j >> 11)) & 31);
        calendar.set(12, ((int) (j >> 5)) & 63);
        calendar.set(13, ((int) (j << 1)) & 62);
        calendar.set(14, 0);
        return calendar.getTime().getTime();
    }

    public static void e(org.apache.tools.zip.ZipEntry zipEntry, byte[] bArr, byte[] bArr2) {
        java.lang.String d;
        org.apache.tools.zip.UnicodePathExtraField unicodePathExtraField = (org.apache.tools.zip.UnicodePathExtraField) zipEntry.getExtraField(org.apache.tools.zip.UnicodePathExtraField.UPATH_ID);
        java.lang.String name = zipEntry.getName();
        java.lang.String d2 = d(unicodePathExtraField, bArr);
        if (d2 != null && !name.equals(d2)) {
            zipEntry.setName(d2);
        }
        if (bArr2 == null || bArr2.length <= 0 || (d = d((org.apache.tools.zip.UnicodeCommentExtraField) zipEntry.getExtraField(org.apache.tools.zip.UnicodeCommentExtraField.UCOM_ID), bArr2)) == null) {
            return;
        }
        zipEntry.setComment(d);
    }

    public static boolean f(org.apache.tools.zip.ZipEntry zipEntry) {
        return !zipEntry.getGeneralPurposeBit().usesEncryption();
    }

    public static java.util.Date fromDosTime(org.apache.tools.zip.ZipLong zipLong) {
        return new java.util.Date(dosToJavaTime(zipLong.getValue()));
    }

    public static boolean g(org.apache.tools.zip.ZipEntry zipEntry) {
        return zipEntry.getMethod() == 0 || zipEntry.getMethod() == 8;
    }

    public static void h(java.util.Calendar calendar, long j, byte[] bArr, int i) {
        calendar.setTimeInMillis(j);
        if (calendar.get(1) < 1980) {
            byte[] bArr2 = a;
            java.lang.System.arraycopy(bArr2, 0, bArr, i, bArr2.length);
        } else {
            org.apache.tools.zip.ZipLong.putLong((calendar.get(13) >> 1) | ((r5 - 1980) << 25) | ((calendar.get(2) + 1) << 21) | (calendar.get(5) << 16) | (calendar.get(11) << 11) | (calendar.get(12) << 5), bArr, i);
        }
    }

    public static org.apache.tools.zip.ZipLong toDosTime(java.util.Date date) {
        return new org.apache.tools.zip.ZipLong(toDosTime(date.getTime()));
    }

    public static void toDosTime(long j, byte[] bArr, int i) {
        h(java.util.Calendar.getInstance(), j, bArr, i);
    }

    public static byte[] toDosTime(long j) {
        byte[] bArr = new byte[4];
        toDosTime(j, bArr, 0);
        return bArr;
    }
}
