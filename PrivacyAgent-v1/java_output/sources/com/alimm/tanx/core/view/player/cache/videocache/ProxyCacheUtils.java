package com.alimm.tanx.core.view.player.cache.videocache;

/* loaded from: classes.dex */
public class ProxyCacheUtils {
    static final int DEFAULT_BUFFER_SIZE = 8192;
    private static final com.alimm.tanx.core.view.player.cache.videocache.log.Logger LOG = com.alimm.tanx.core.view.player.cache.videocache.log.LoggerFactory.getLogger("ProxyCacheUtils");
    static final int MAX_ARRAY_PREVIEW = 16;

    public static void assertBuffer(byte[] bArr, long j, int i) {
        com.alimm.tanx.core.view.player.cache.videocache.Preconditions.checkNotNull(bArr, "Buffer must be not null!");
        com.alimm.tanx.core.view.player.cache.videocache.Preconditions.checkArgument(j >= 0, "Data offset must be positive!");
        com.alimm.tanx.core.view.player.cache.videocache.Preconditions.checkArgument(i >= 0 && i <= bArr.length, "Length must be in range [0..buffer.length]");
    }

    private static java.lang.String bytesToHexString(byte[] bArr) {
        java.lang.StringBuffer stringBuffer = new java.lang.StringBuffer();
        for (byte b : bArr) {
            stringBuffer.append(java.lang.String.format("%02x", java.lang.Byte.valueOf(b)));
        }
        return stringBuffer.toString();
    }

    public static void close(java.io.Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (java.io.IOException e) {
                LOG.error("Error closing resource", e);
            }
        }
    }

    public static java.lang.String computeMD5(java.lang.String str) {
        try {
            return bytesToHexString(java.security.MessageDigest.getInstance("MD5").digest(str.getBytes()));
        } catch (java.security.NoSuchAlgorithmException e) {
            throw new java.lang.IllegalStateException(e);
        }
    }

    public static java.lang.String decode(java.lang.String str) {
        try {
            return java.net.URLDecoder.decode(str, "utf-8");
        } catch (java.io.UnsupportedEncodingException e) {
            throw new java.lang.RuntimeException("Error decoding url", e);
        }
    }

    public static java.lang.String encode(java.lang.String str) {
        try {
            return java.net.URLEncoder.encode(str, "utf-8");
        } catch (java.io.UnsupportedEncodingException e) {
            throw new java.lang.RuntimeException("Error encoding url", e);
        }
    }

    public static java.lang.String getSupposablyMime(java.lang.String str) {
        android.webkit.MimeTypeMap singleton = android.webkit.MimeTypeMap.getSingleton();
        java.lang.String fileExtensionFromUrl = android.webkit.MimeTypeMap.getFileExtensionFromUrl(str);
        if (android.text.TextUtils.isEmpty(fileExtensionFromUrl)) {
            return null;
        }
        return singleton.getMimeTypeFromExtension(fileExtensionFromUrl);
    }

    public static java.lang.String preview(byte[] bArr, int i) {
        int min = java.lang.Math.min(16, java.lang.Math.max(i, 0));
        java.lang.String arrays = java.util.Arrays.toString(java.util.Arrays.copyOfRange(bArr, 0, min));
        if (min >= i) {
            return arrays;
        }
        return arrays.substring(0, arrays.length() - 1) + ", ...]";
    }
}
