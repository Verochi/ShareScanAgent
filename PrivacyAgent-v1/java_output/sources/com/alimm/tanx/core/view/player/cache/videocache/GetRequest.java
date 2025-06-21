package com.alimm.tanx.core.view.player.cache.videocache;

/* loaded from: classes.dex */
class GetRequest {
    private static final java.util.regex.Pattern RANGE_HEADER_PATTERN = java.util.regex.Pattern.compile("[R,r]ange:[ ]?bytes=(\\d*)-");
    private static final java.util.regex.Pattern URL_PATTERN = java.util.regex.Pattern.compile("GET /(.*) HTTP");
    public final boolean partial;
    public final long rangeOffset;
    public final java.lang.String uri;

    public GetRequest(java.lang.String str) {
        com.alimm.tanx.core.view.player.cache.videocache.Preconditions.checkNotNull(str);
        long findRangeOffset = findRangeOffset(str);
        this.rangeOffset = java.lang.Math.max(0L, findRangeOffset);
        this.partial = findRangeOffset >= 0;
        this.uri = findUri(str);
    }

    private long findRangeOffset(java.lang.String str) {
        java.util.regex.Matcher matcher = RANGE_HEADER_PATTERN.matcher(str);
        if (matcher.find()) {
            return java.lang.Long.parseLong(matcher.group(1));
        }
        return -1L;
    }

    private java.lang.String findUri(java.lang.String str) {
        java.util.regex.Matcher matcher = URL_PATTERN.matcher(str);
        if (matcher.find()) {
            return matcher.group(1);
        }
        throw new java.lang.IllegalArgumentException("Invalid request `" + str + "`: url not found!");
    }

    public static com.alimm.tanx.core.view.player.cache.videocache.GetRequest read(java.io.InputStream inputStream) throws java.io.IOException {
        java.io.BufferedReader bufferedReader = new java.io.BufferedReader(new java.io.InputStreamReader(inputStream, java.nio.charset.StandardCharsets.UTF_8));
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        while (true) {
            java.lang.String readLine = bufferedReader.readLine();
            if (android.text.TextUtils.isEmpty(readLine)) {
                return new com.alimm.tanx.core.view.player.cache.videocache.GetRequest(sb.toString());
            }
            sb.append(readLine);
            sb.append('\n');
        }
    }

    public java.lang.String toString() {
        return "GetRequest{rangeOffset=" + this.rangeOffset + ", partial=" + this.partial + ", uri='" + this.uri + "'}";
    }
}
