package com.alibaba.sdk.android.oss.network;

/* loaded from: classes.dex */
public class OSSRequestTask<T extends com.alibaba.sdk.android.oss.model.OSSResult> implements java.util.concurrent.Callable<T> {
    private okhttp3.OkHttpClient client;
    private com.alibaba.sdk.android.oss.network.ExecutionContext context;
    private int currentRetryCount = 0;
    private com.alibaba.sdk.android.oss.internal.RequestMessage message;
    private com.alibaba.sdk.android.oss.internal.ResponseParser<T> responseParser;
    private com.alibaba.sdk.android.oss.internal.OSSRetryHandler retryHandler;

    /* renamed from: com.alibaba.sdk.android.oss.network.OSSRequestTask$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$alibaba$sdk$android$oss$common$HttpMethod;

        static {
            int[] iArr = new int[com.alibaba.sdk.android.oss.common.HttpMethod.values().length];
            $SwitchMap$com$alibaba$sdk$android$oss$common$HttpMethod = iArr;
            try {
                iArr[com.alibaba.sdk.android.oss.common.HttpMethod.POST.ordinal()] = 1;
            } catch (java.lang.NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$alibaba$sdk$android$oss$common$HttpMethod[com.alibaba.sdk.android.oss.common.HttpMethod.PUT.ordinal()] = 2;
            } catch (java.lang.NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$alibaba$sdk$android$oss$common$HttpMethod[com.alibaba.sdk.android.oss.common.HttpMethod.GET.ordinal()] = 3;
            } catch (java.lang.NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$alibaba$sdk$android$oss$common$HttpMethod[com.alibaba.sdk.android.oss.common.HttpMethod.HEAD.ordinal()] = 4;
            } catch (java.lang.NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$com$alibaba$sdk$android$oss$common$HttpMethod[com.alibaba.sdk.android.oss.common.HttpMethod.DELETE.ordinal()] = 5;
            } catch (java.lang.NoSuchFieldError unused5) {
            }
        }
    }

    public OSSRequestTask(com.alibaba.sdk.android.oss.internal.RequestMessage requestMessage, com.alibaba.sdk.android.oss.internal.ResponseParser responseParser, com.alibaba.sdk.android.oss.network.ExecutionContext executionContext, int i) {
        this.responseParser = responseParser;
        this.message = requestMessage;
        this.context = executionContext;
        this.client = executionContext.getClient();
        this.retryHandler = new com.alibaba.sdk.android.oss.internal.OSSRetryHandler(i);
    }

    private com.alibaba.sdk.android.oss.internal.ResponseMessage buildResponseMessage(com.alibaba.sdk.android.oss.internal.RequestMessage requestMessage, okhttp3.Response response) {
        com.alibaba.sdk.android.oss.internal.ResponseMessage responseMessage = new com.alibaba.sdk.android.oss.internal.ResponseMessage();
        responseMessage.setRequest(requestMessage);
        responseMessage.setResponse(response);
        java.util.HashMap hashMap = new java.util.HashMap();
        okhttp3.Headers headers = response.headers();
        for (int i = 0; i < headers.size(); i++) {
            hashMap.put(headers.name(i), headers.value(i));
        }
        responseMessage.setHeaders(hashMap);
        responseMessage.setStatusCode(response.code());
        responseMessage.setContentLength(response.body().contentLength());
        responseMessage.setContent(response.body().byteStream());
        return responseMessage;
    }

    /* JADX WARN: Removed duplicated region for block: B:123:0x019a A[Catch: Exception -> 0x02d0, TryCatch #0 {Exception -> 0x02d0, blocks: (B:3:0x0004, B:5:0x000c, B:6:0x0019, B:8:0x0040, B:10:0x0049, B:11:0x0056, B:12:0x0068, B:14:0x006e, B:16:0x0085, B:27:0x01ff, B:112:0x00cc, B:113:0x00d2, B:114:0x00d8, B:117:0x00e3, B:119:0x00f0, B:123:0x019a, B:125:0x01a2, B:126:0x01ad, B:128:0x01ce, B:129:0x01eb, B:130:0x0107, B:132:0x0111, B:135:0x012d, B:136:0x0134, B:137:0x0135, B:139:0x013d, B:145:0x016b, B:150:0x0175, B:151:0x0178, B:154:0x0179, B:156:0x0181, B:157:0x018f, B:159:0x0050, B:160:0x02c8, B:161:0x02cf), top: B:2:0x0004 }] */
    /* JADX WARN: Removed duplicated region for block: B:127:0x01cc  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x038b  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x03bd  */
    /* JADX WARN: Removed duplicated region for block: B:96:0x0321 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    @Override // java.util.concurrent.Callable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public T call() throws java.lang.Exception {
        okhttp3.Call call;
        okhttp3.Request request;
        java.lang.Exception clientException;
        com.alibaba.sdk.android.oss.internal.ResponseMessage responseMessage;
        com.alibaba.sdk.android.oss.internal.OSSRetryType shouldRetry;
        com.alibaba.sdk.android.oss.model.OSSRequest request2;
        long j;
        java.lang.String stringBody;
        java.io.InputStream inputStream;
        long contentLength;
        android.os.ParcelFileDescriptor parcelFileDescriptor;
        try {
            if (this.context.getApplicationContext() != null) {
                com.alibaba.sdk.android.oss.common.OSSLog.logInfo(com.alibaba.sdk.android.oss.common.utils.OSSUtils.buildBaseLogInfo(this.context.getApplicationContext()));
            }
            com.alibaba.sdk.android.oss.common.OSSLog.logDebug("[call] - ");
            request2 = this.context.getRequest();
            com.alibaba.sdk.android.oss.common.utils.OSSUtils.ensureRequestValid(request2, this.message);
            this.message.getSigner().sign(this.message);
        } catch (java.lang.Exception e) {
            e = e;
            call = null;
            request = null;
        }
        if (this.context.getCancellationHandler().isCancelled()) {
            throw new java.io.InterruptedIOException("This task is cancelled!");
        }
        okhttp3.Request.Builder url = new okhttp3.Request.Builder().url(request2 instanceof com.alibaba.sdk.android.oss.model.ListBucketsRequest ? this.message.buildOSSServiceURL() : this.message.buildCanonicalURL());
        for (java.lang.String str : this.message.getHeaders().keySet()) {
            url = url.addHeader(str, (java.lang.String) this.message.getHeaders().get(str));
        }
        java.lang.String str2 = (java.lang.String) this.message.getHeaders().get("Content-Type");
        com.alibaba.sdk.android.oss.common.OSSLog.logDebug("request method = " + this.message.getMethod());
        int i = com.alibaba.sdk.android.oss.network.OSSRequestTask.AnonymousClass1.$SwitchMap$com$alibaba$sdk$android$oss$common$HttpMethod[this.message.getMethod().ordinal()];
        if (i == 1 || i == 2) {
            com.alibaba.sdk.android.oss.common.utils.OSSUtils.assertTrue(str2 != null, "Content type can't be null when upload!");
            if (this.message.getUploadData() != null) {
                inputStream = new java.io.ByteArrayInputStream(this.message.getUploadData());
                contentLength = this.message.getUploadData().length;
            } else {
                if (this.message.getUploadFilePath() != null) {
                    java.io.File file = new java.io.File(this.message.getUploadFilePath());
                    java.io.FileInputStream fileInputStream = new java.io.FileInputStream(file);
                    long length = file.length();
                    if (length <= 0) {
                        throw new com.alibaba.sdk.android.oss.ClientException("the length of file is 0!");
                    }
                    stringBody = null;
                    inputStream = fileInputStream;
                    j = length;
                } else if (this.message.getUploadUri() != null) {
                    inputStream = this.context.getApplicationContext().getContentResolver().openInputStream(this.message.getUploadUri());
                    try {
                        parcelFileDescriptor = this.context.getApplicationContext().getContentResolver().openFileDescriptor(this.message.getUploadUri(), "r");
                    } catch (java.lang.Throwable th) {
                        th = th;
                        parcelFileDescriptor = null;
                    }
                    try {
                        j = parcelFileDescriptor.getStatSize();
                        parcelFileDescriptor.close();
                        stringBody = null;
                    } catch (java.lang.Throwable th2) {
                        th = th2;
                        if (parcelFileDescriptor != null) {
                            parcelFileDescriptor.close();
                        }
                        throw th;
                    }
                } else if (this.message.getContent() != null) {
                    inputStream = this.message.getContent();
                    contentLength = this.message.getContentLength();
                } else {
                    j = 0;
                    stringBody = this.message.getStringBody();
                    inputStream = null;
                }
                if (inputStream == null) {
                    if (this.message.isCheckCRC64()) {
                        inputStream = new java.util.zip.CheckedInputStream(inputStream, new com.alibaba.sdk.android.oss.common.utils.CRC64());
                    }
                    this.message.setContent(inputStream);
                    this.message.setContentLength(j);
                    url = url.method(this.message.getMethod().toString(), com.alibaba.sdk.android.oss.network.NetworkProgressHelper.addProgressRequestBody(inputStream, j, str2, this.context));
                } else {
                    url = stringBody != null ? url.method(this.message.getMethod().toString(), okhttp3.RequestBody.create(okhttp3.MediaType.parse(str2), stringBody.getBytes("UTF-8"))) : url.method(this.message.getMethod().toString(), okhttp3.RequestBody.create((okhttp3.MediaType) null, new byte[0]));
                }
            }
            j = contentLength;
            stringBody = null;
            if (inputStream == null) {
            }
        } else if (i == 3) {
            url = url.get();
        } else if (i == 4) {
            url = url.head();
        } else if (i == 5) {
            url = url.delete();
        }
        request = url.build();
        try {
            if (request2 instanceof com.alibaba.sdk.android.oss.model.GetObjectRequest) {
                this.client = com.alibaba.sdk.android.oss.network.NetworkProgressHelper.addProgressResponseListener(this.client, this.context);
                com.alibaba.sdk.android.oss.common.OSSLog.logDebug("getObject");
            }
            call = this.client.newCall(request);
        } catch (java.lang.Exception e2) {
            e = e2;
            call = null;
        }
        try {
            this.context.getCancellationHandler().setCall(call);
            okhttp3.Response execute = call.execute();
            if (com.alibaba.sdk.android.oss.common.OSSLog.isEnableLog()) {
                java.util.Map<java.lang.String, java.util.List<java.lang.String>> multimap = execute.headers().toMultimap();
                java.lang.StringBuilder sb = new java.lang.StringBuilder();
                sb.append("response:---------------------\n");
                sb.append("response code: " + execute.code() + " for url: " + request.url() + "\n");
                for (java.lang.String str3 : multimap.keySet()) {
                    sb.append("responseHeader [" + str3 + "]: ");
                    java.lang.StringBuilder sb2 = new java.lang.StringBuilder();
                    sb2.append(multimap.get(str3).get(0));
                    sb2.append("\n");
                    sb.append(sb2.toString());
                }
                com.alibaba.sdk.android.oss.common.OSSLog.logDebug(sb.toString());
            }
            responseMessage = buildResponseMessage(this.message, execute);
            clientException = null;
        } catch (java.lang.Exception e3) {
            e = e3;
            com.alibaba.sdk.android.oss.common.OSSLog.logError("Encounter local execpiton: " + e.toString());
            if (com.alibaba.sdk.android.oss.common.OSSLog.isEnableLog()) {
                e.printStackTrace();
            }
            clientException = new com.alibaba.sdk.android.oss.ClientException(e.getMessage(), e);
            responseMessage = null;
            if (clientException != null) {
            }
            if (clientException == null) {
            }
            if (call != null) {
                clientException = new com.alibaba.sdk.android.oss.ClientException("Task is cancelled!", clientException.getCause(), java.lang.Boolean.TRUE);
                shouldRetry = this.retryHandler.shouldRetry(clientException, this.currentRetryCount);
                com.alibaba.sdk.android.oss.common.OSSLog.logError("[run] - retry, retry type: " + shouldRetry);
                if (shouldRetry == com.alibaba.sdk.android.oss.internal.OSSRetryType.OSSRetryTypeShouldRetry) {
                }
            }
            clientException = new com.alibaba.sdk.android.oss.ClientException("Task is cancelled!", clientException.getCause(), java.lang.Boolean.TRUE);
            shouldRetry = this.retryHandler.shouldRetry(clientException, this.currentRetryCount);
            com.alibaba.sdk.android.oss.common.OSSLog.logError("[run] - retry, retry type: " + shouldRetry);
            if (shouldRetry == com.alibaba.sdk.android.oss.internal.OSSRetryType.OSSRetryTypeShouldRetry) {
            }
        }
        if (clientException != null && (responseMessage.getStatusCode() == 203 || responseMessage.getStatusCode() >= 300)) {
            clientException = com.alibaba.sdk.android.oss.internal.ResponseParsers.parseResponseErrorXML(responseMessage, request.method().equals("HEAD"));
        } else if (clientException == null) {
            try {
                T parse = this.responseParser.parse(responseMessage);
                if (this.context.getCompletedCallback() != null) {
                    this.context.getCompletedCallback().onSuccess(this.context.getRequest(), parse);
                }
                return parse;
            } catch (java.io.IOException e4) {
                clientException = new com.alibaba.sdk.android.oss.ClientException(e4.getMessage(), e4);
            }
        }
        if ((call != null && call.isCanceled()) || this.context.getCancellationHandler().isCancelled()) {
            clientException = new com.alibaba.sdk.android.oss.ClientException("Task is cancelled!", clientException.getCause(), java.lang.Boolean.TRUE);
        }
        shouldRetry = this.retryHandler.shouldRetry(clientException, this.currentRetryCount);
        com.alibaba.sdk.android.oss.common.OSSLog.logError("[run] - retry, retry type: " + shouldRetry);
        if (shouldRetry == com.alibaba.sdk.android.oss.internal.OSSRetryType.OSSRetryTypeShouldRetry) {
            this.currentRetryCount++;
            if (this.context.getRetryCallback() != null) {
                this.context.getRetryCallback().onRetryCallback();
            }
            try {
                java.lang.Thread.sleep(this.retryHandler.timeInterval(this.currentRetryCount, shouldRetry));
            } catch (java.lang.InterruptedException e5) {
                java.lang.Thread.currentThread().interrupt();
                e5.printStackTrace();
            }
            return call();
        }
        if (shouldRetry != com.alibaba.sdk.android.oss.internal.OSSRetryType.OSSRetryTypeShouldFixedTimeSkewedAndRetry) {
            if (clientException instanceof com.alibaba.sdk.android.oss.ClientException) {
                if (this.context.getCompletedCallback() == null) {
                    throw clientException;
                }
                this.context.getCompletedCallback().onFailure(this.context.getRequest(), (com.alibaba.sdk.android.oss.ClientException) clientException, null);
                throw clientException;
            }
            if (this.context.getCompletedCallback() == null) {
                throw clientException;
            }
            this.context.getCompletedCallback().onFailure(this.context.getRequest(), null, (com.alibaba.sdk.android.oss.ServiceException) clientException);
            throw clientException;
        }
        if (responseMessage != null) {
            java.lang.String str4 = (java.lang.String) responseMessage.getHeaders().get("Date");
            try {
                com.alibaba.sdk.android.oss.common.utils.DateUtil.setCurrentServerTime(com.alibaba.sdk.android.oss.common.utils.DateUtil.parseRfc822Date(str4).getTime());
                this.message.getHeaders().put("Date", str4);
            } catch (java.lang.Exception unused) {
                com.alibaba.sdk.android.oss.common.OSSLog.logError("[error] - synchronize time, reponseDate:" + str4);
            }
        }
        this.currentRetryCount++;
        if (this.context.getRetryCallback() != null) {
            this.context.getRetryCallback().onRetryCallback();
        }
        return call();
    }
}
