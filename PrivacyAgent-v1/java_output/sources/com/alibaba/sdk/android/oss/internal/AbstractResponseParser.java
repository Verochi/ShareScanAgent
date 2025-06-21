package com.alibaba.sdk.android.oss.internal;

/* loaded from: classes.dex */
public abstract class AbstractResponseParser<T extends com.alibaba.sdk.android.oss.model.OSSResult> implements com.alibaba.sdk.android.oss.internal.ResponseParser {
    private com.alibaba.sdk.android.oss.common.utils.CaseInsensitiveHashMap<java.lang.String, java.lang.String> parseResponseHeader(okhttp3.Response response) {
        com.alibaba.sdk.android.oss.common.utils.CaseInsensitiveHashMap<java.lang.String, java.lang.String> caseInsensitiveHashMap = new com.alibaba.sdk.android.oss.common.utils.CaseInsensitiveHashMap<>();
        okhttp3.Headers headers = response.headers();
        for (int i = 0; i < headers.size(); i++) {
            caseInsensitiveHashMap.put(headers.name(i), headers.value(i));
        }
        return caseInsensitiveHashMap;
    }

    public static void safeCloseResponse(com.alibaba.sdk.android.oss.internal.ResponseMessage responseMessage) {
        try {
            responseMessage.close();
        } catch (java.lang.Exception unused) {
        }
    }

    public boolean needCloseResponse() {
        return true;
    }

    @Override // com.alibaba.sdk.android.oss.internal.ResponseParser
    public T parse(com.alibaba.sdk.android.oss.internal.ResponseMessage responseMessage) throws java.io.IOException {
        try {
            try {
                T t = (T) ((java.lang.Class) ((java.lang.reflect.ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0]).newInstance();
                if (t != null) {
                    t.setRequestId((java.lang.String) responseMessage.getHeaders().get(com.alibaba.sdk.android.oss.common.OSSHeaders.OSS_HEADER_REQUEST_ID));
                    t.setStatusCode(responseMessage.getStatusCode());
                    t.setResponseHeader(parseResponseHeader(responseMessage.getResponse()));
                    setCRC(t, responseMessage);
                    t = parseData(responseMessage, t);
                }
                return t;
            } catch (java.lang.Exception e) {
                java.io.IOException iOException = new java.io.IOException(e.getMessage(), e);
                e.printStackTrace();
                com.alibaba.sdk.android.oss.common.OSSLog.logThrowable2Local(e);
                throw iOException;
            }
        } finally {
            if (needCloseResponse()) {
                safeCloseResponse(responseMessage);
            }
        }
    }

    public abstract T parseData(com.alibaba.sdk.android.oss.internal.ResponseMessage responseMessage, T t) throws java.lang.Exception;

    public <Result extends com.alibaba.sdk.android.oss.model.OSSResult> void setCRC(Result result, com.alibaba.sdk.android.oss.internal.ResponseMessage responseMessage) {
        java.io.InputStream content = responseMessage.getRequest().getContent();
        if (content != null && (content instanceof java.util.zip.CheckedInputStream)) {
            result.setClientCRC(java.lang.Long.valueOf(((java.util.zip.CheckedInputStream) content).getChecksum().getValue()));
        }
        java.lang.String str = (java.lang.String) responseMessage.getHeaders().get(com.alibaba.sdk.android.oss.common.OSSHeaders.OSS_HASH_CRC64_ECMA);
        if (str != null) {
            result.setServerCRC(java.lang.Long.valueOf(new java.math.BigInteger(str).longValue()));
        }
    }
}
