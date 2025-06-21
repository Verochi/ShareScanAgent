package com.aliyun.vod.qupaiokhttp;

/* loaded from: classes12.dex */
public class RequestParams {
    private boolean applicationJson;
    protected okhttp3.CacheControl cacheControl;
    private final java.util.List<com.aliyun.vod.qupaiokhttp.Part> files;
    protected final okhttp3.Headers.Builder headers;
    protected com.aliyun.vod.qupaiokhttp.HttpCycleContext httpCycleContext;
    private java.lang.String httpTaskKey;
    private final java.util.List<com.aliyun.vod.qupaiokhttp.Part> params;
    private okhttp3.RequestBody requestBody;
    private boolean urlEncoder;

    public RequestParams() {
        this(null);
    }

    public RequestParams(com.aliyun.vod.qupaiokhttp.HttpCycleContext httpCycleContext) {
        this.headers = new okhttp3.Headers.Builder();
        this.params = new java.util.ArrayList();
        this.files = new java.util.ArrayList();
        this.httpCycleContext = httpCycleContext;
        init();
    }

    private void init() {
        this.headers.add("charset", "UTF-8");
        java.util.List<com.aliyun.vod.qupaiokhttp.Part> commonParams = com.aliyun.vod.qupaiokhttp.OkHttpFinal.getInstance().getCommonParams();
        if (commonParams != null && commonParams.size() > 0) {
            this.params.addAll(commonParams);
        }
        okhttp3.Headers commonHeaders = com.aliyun.vod.qupaiokhttp.OkHttpFinal.getInstance().getCommonHeaders();
        if (commonHeaders != null && commonHeaders.size() > 0) {
            for (int i = 0; i < commonHeaders.size(); i++) {
                this.headers.add(commonHeaders.name(i), commonHeaders.value(i));
            }
        }
        com.aliyun.vod.qupaiokhttp.HttpCycleContext httpCycleContext = this.httpCycleContext;
        if (httpCycleContext != null) {
            this.httpTaskKey = httpCycleContext.getHttpTaskKey();
        }
    }

    public void addFormDataPart(java.lang.String str, double d) {
        addFormDataPart(str, java.lang.String.valueOf(d));
    }

    public void addFormDataPart(java.lang.String str, float f) {
        addFormDataPart(str, java.lang.String.valueOf(f));
    }

    public void addFormDataPart(java.lang.String str, int i) {
        addFormDataPart(str, java.lang.String.valueOf(i));
    }

    public void addFormDataPart(java.lang.String str, long j) {
        addFormDataPart(str, java.lang.String.valueOf(j));
    }

    public void addFormDataPart(java.lang.String str, com.aliyun.vod.qupaiokhttp.FileWrapper fileWrapper) {
        java.io.File file;
        if (com.aliyun.vod.common.utils.StringUtils.isEmpty(str) || fileWrapper == null || (file = fileWrapper.getFile()) == null || !file.exists() || file.length() == 0) {
            return;
        }
        this.files.add(new com.aliyun.vod.qupaiokhttp.Part(str, fileWrapper));
    }

    public void addFormDataPart(java.lang.String str, java.io.File file) {
        if (file == null || !file.exists() || file.length() == 0) {
            return;
        }
        boolean z = file.getName().lastIndexOf(com.aliyun.auth.common.AliyunVodHttpCommon.ImageExt.IMAGEEXT_PNG) > 0 || file.getName().lastIndexOf("PNG") > 0;
        if (z) {
            addFormDataPart(str, file, "image/png; charset=UTF-8");
            return;
        }
        boolean z2 = file.getName().lastIndexOf(com.aliyun.auth.common.AliyunVodHttpCommon.ImageExt.IMAGEEXT_JPG) > 0 || file.getName().lastIndexOf("JPG") > 0 || file.getName().lastIndexOf(com.aliyun.auth.common.AliyunVodHttpCommon.ImageExt.IMAGEEXT_JPEG) > 0 || file.getName().lastIndexOf("JPEG") > 0;
        if (z2) {
            addFormDataPart(str, file, "image/jpeg; charset=UTF-8");
        } else {
            if (z || z2) {
                return;
            }
            addFormDataPart(str, new com.aliyun.vod.qupaiokhttp.FileWrapper(file, null));
        }
    }

    public void addFormDataPart(java.lang.String str, java.io.File file, java.lang.String str2) {
        okhttp3.MediaType mediaType;
        if (file == null || !file.exists() || file.length() == 0) {
            return;
        }
        try {
            mediaType = okhttp3.MediaType.parse(str2);
        } catch (java.lang.Exception e) {
            com.aliyun.vod.qupaiokhttp.ILogger.e(e);
            mediaType = null;
        }
        addFormDataPart(str, new com.aliyun.vod.qupaiokhttp.FileWrapper(file, mediaType));
    }

    public void addFormDataPart(java.lang.String str, java.io.File file, okhttp3.MediaType mediaType) {
        if (file == null || !file.exists() || file.length() == 0) {
            return;
        }
        addFormDataPart(str, new com.aliyun.vod.qupaiokhttp.FileWrapper(file, mediaType));
    }

    public void addFormDataPart(java.lang.String str, java.lang.String str2) {
        if (str2 == null) {
            str2 = "";
        }
        com.aliyun.vod.qupaiokhttp.Part part = new com.aliyun.vod.qupaiokhttp.Part(str, str2);
        if (com.aliyun.vod.common.utils.StringUtils.isEmpty(str) || this.params.contains(part)) {
            return;
        }
        this.params.add(part);
    }

    public void addFormDataPart(java.lang.String str, java.util.List<com.aliyun.vod.qupaiokhttp.FileWrapper> list) {
        java.util.Iterator<com.aliyun.vod.qupaiokhttp.FileWrapper> it = list.iterator();
        while (it.hasNext()) {
            addFormDataPart(str, it.next());
        }
    }

    public void addFormDataPart(java.lang.String str, java.util.List<java.io.File> list, okhttp3.MediaType mediaType) {
        for (java.io.File file : list) {
            if (file != null && file.exists() && file.length() != 0) {
                addFormDataPart(str, new com.aliyun.vod.qupaiokhttp.FileWrapper(file, mediaType));
            }
        }
    }

    public void addFormDataPart(java.lang.String str, boolean z) {
        addFormDataPart(str, java.lang.String.valueOf(z));
    }

    public void addFormDataPartFiles(java.lang.String str, java.util.List<java.io.File> list) {
        for (java.io.File file : list) {
            if (file != null && file.exists() && file.length() != 0) {
                addFormDataPart(str, file);
            }
        }
    }

    public void addFormDataParts(java.util.List<com.aliyun.vod.qupaiokhttp.Part> list) {
        this.params.addAll(list);
    }

    public void addHeader(java.lang.String str) {
        this.headers.add(str);
    }

    public void addHeader(java.lang.String str, double d) {
        addHeader(str, java.lang.String.valueOf(d));
    }

    public void addHeader(java.lang.String str, float f) {
        addHeader(str, java.lang.String.valueOf(f));
    }

    public void addHeader(java.lang.String str, int i) {
        addHeader(str, java.lang.String.valueOf(i));
    }

    public void addHeader(java.lang.String str, long j) {
        addHeader(str, java.lang.String.valueOf(j));
    }

    public void addHeader(java.lang.String str, java.lang.String str2) {
        if (str2 == null) {
            str2 = "";
        }
        if (android.text.TextUtils.isEmpty(str)) {
            return;
        }
        this.headers.add(str, str2);
    }

    public void addHeader(java.lang.String str, boolean z) {
        addHeader(str, java.lang.String.valueOf(z));
    }

    public void applicationJson() {
        this.applicationJson = true;
    }

    public void clear() {
        this.params.clear();
        this.files.clear();
    }

    public java.util.List<com.aliyun.vod.qupaiokhttp.Part> getFormParams() {
        return this.params;
    }

    public java.lang.String getHttpTaskKey() {
        return this.httpTaskKey;
    }

    public okhttp3.RequestBody getRequestBody() {
        if (this.applicationJson) {
            return null;
        }
        okhttp3.RequestBody requestBody = this.requestBody;
        if (requestBody == null) {
            if (this.files.size() <= 0) {
                okhttp3.FormBody.Builder builder = new okhttp3.FormBody.Builder();
                for (com.aliyun.vod.qupaiokhttp.Part part : this.params) {
                    builder.add(part.getKey(), part.getValue());
                }
                return builder.build();
            }
            okhttp3.MultipartBody.Builder builder2 = new okhttp3.MultipartBody.Builder();
            builder2.setType(okhttp3.MultipartBody.FORM);
            boolean z = false;
            for (com.aliyun.vod.qupaiokhttp.Part part2 : this.params) {
                builder2.addFormDataPart(part2.getKey(), part2.getValue());
                z = true;
            }
            for (com.aliyun.vod.qupaiokhttp.Part part3 : this.files) {
                java.lang.String key = part3.getKey();
                com.aliyun.vod.qupaiokhttp.FileWrapper fileWrapper = part3.getFileWrapper();
                if (fileWrapper != null) {
                    builder2.addFormDataPart(key, fileWrapper.getFileName(), okhttp3.RequestBody.create(fileWrapper.getMediaType(), fileWrapper.getFile()));
                    z = true;
                }
            }
            if (!z) {
                return null;
            }
            requestBody = builder2.build();
        }
        return requestBody;
    }

    public boolean isUrlEncoder() {
        return this.urlEncoder;
    }

    public void setCacheControl(okhttp3.CacheControl cacheControl) {
        this.cacheControl = cacheControl;
    }

    public void setCustomRequestBody(okhttp3.RequestBody requestBody) {
        this.requestBody = requestBody;
    }

    public void setRequestBody(java.lang.String str, java.lang.String str2) {
        setRequestBody(okhttp3.MediaType.parse(str), str2);
    }

    public void setRequestBody(okhttp3.MediaType mediaType, java.lang.String str) {
        setCustomRequestBody(okhttp3.RequestBody.create(mediaType, str));
    }

    public void setRequestBodyString(java.lang.String str) {
        setRequestBody(okhttp3.MediaType.parse("text/plain; charset=utf-8"), str);
    }

    public java.lang.String toString() {
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        for (com.aliyun.vod.qupaiokhttp.Part part : this.params) {
            java.lang.String key = part.getKey();
            java.lang.String value = part.getValue();
            if (sb.length() > 0) {
                sb.append("&");
            }
            sb.append(key);
            sb.append(com.huawei.hms.framework.common.ContainerUtils.KEY_VALUE_DELIMITER);
            sb.append(value);
        }
        java.util.Iterator<com.aliyun.vod.qupaiokhttp.Part> it = this.files.iterator();
        while (it.hasNext()) {
            java.lang.String key2 = it.next().getKey();
            if (sb.length() > 0) {
                sb.append("&");
            }
            sb.append(key2);
            sb.append(com.huawei.hms.framework.common.ContainerUtils.KEY_VALUE_DELIMITER);
            sb.append("FILE");
        }
        return sb.toString();
    }

    public void urlEncoder() {
        this.urlEncoder = true;
    }
}
