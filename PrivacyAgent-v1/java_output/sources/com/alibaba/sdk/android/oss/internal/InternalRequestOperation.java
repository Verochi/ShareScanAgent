package com.alibaba.sdk.android.oss.internal;

/* loaded from: classes.dex */
public class InternalRequestOperation {
    private static final int LIST_PART_MAX_RETURNS = 1000;
    private static final int MAX_PART_NUMBER = 10000;
    private static java.util.concurrent.ExecutorService executorServiceDefault = java.util.concurrent.Executors.newFixedThreadPool(5, new com.alibaba.sdk.android.oss.internal.InternalRequestOperation.AnonymousClass1());
    private android.content.Context applicationContext;
    private java.lang.String cloudBoxId;
    private com.alibaba.sdk.android.oss.ClientConfiguration conf;
    private com.alibaba.sdk.android.oss.common.auth.OSSCredentialProvider credentialProvider;
    private volatile java.net.URI endpoint;
    private java.util.concurrent.ExecutorService executorService;
    private okhttp3.OkHttpClient innerClient;
    private int maxRetryCount;
    private java.lang.String product;
    private java.lang.String region;
    private java.net.URI service;

    /* renamed from: com.alibaba.sdk.android.oss.internal.InternalRequestOperation$1, reason: invalid class name */
    public static class AnonymousClass1 implements java.util.concurrent.ThreadFactory {
        @Override // java.util.concurrent.ThreadFactory
        public java.lang.Thread newThread(java.lang.Runnable runnable) {
            return new java.lang.Thread(runnable, "oss-android-api-thread");
        }
    }

    /* renamed from: com.alibaba.sdk.android.oss.internal.InternalRequestOperation$2, reason: invalid class name */
    public class AnonymousClass2 implements javax.net.ssl.HostnameVerifier {
        final /* synthetic */ java.lang.String val$host;

        public AnonymousClass2(java.lang.String str) {
            this.val$host = str;
        }

        @Override // javax.net.ssl.HostnameVerifier
        public boolean verify(java.lang.String str, javax.net.ssl.SSLSession sSLSession) {
            return javax.net.ssl.HttpsURLConnection.getDefaultHostnameVerifier().verify(this.val$host, sSLSession);
        }
    }

    /* renamed from: com.alibaba.sdk.android.oss.internal.InternalRequestOperation$3, reason: invalid class name */
    public class AnonymousClass3 implements com.alibaba.sdk.android.oss.callback.OSSCompletedCallback<com.alibaba.sdk.android.oss.model.PutObjectRequest, com.alibaba.sdk.android.oss.model.PutObjectResult> {
        final /* synthetic */ com.alibaba.sdk.android.oss.callback.OSSCompletedCallback val$completedCallback;

        public AnonymousClass3(com.alibaba.sdk.android.oss.callback.OSSCompletedCallback oSSCompletedCallback) {
            this.val$completedCallback = oSSCompletedCallback;
        }

        @Override // com.alibaba.sdk.android.oss.callback.OSSCompletedCallback
        public void onFailure(com.alibaba.sdk.android.oss.model.PutObjectRequest putObjectRequest, com.alibaba.sdk.android.oss.ClientException clientException, com.alibaba.sdk.android.oss.ServiceException serviceException) {
            this.val$completedCallback.onFailure(putObjectRequest, clientException, serviceException);
        }

        @Override // com.alibaba.sdk.android.oss.callback.OSSCompletedCallback
        public void onSuccess(com.alibaba.sdk.android.oss.model.PutObjectRequest putObjectRequest, com.alibaba.sdk.android.oss.model.PutObjectResult putObjectResult) {
            com.alibaba.sdk.android.oss.internal.InternalRequestOperation.this.checkCRC64(putObjectRequest, putObjectResult, this.val$completedCallback);
        }
    }

    /* renamed from: com.alibaba.sdk.android.oss.internal.InternalRequestOperation$4, reason: invalid class name */
    public class AnonymousClass4 implements com.alibaba.sdk.android.oss.callback.OSSCompletedCallback<com.alibaba.sdk.android.oss.model.AppendObjectRequest, com.alibaba.sdk.android.oss.model.AppendObjectResult> {
        final /* synthetic */ com.alibaba.sdk.android.oss.callback.OSSCompletedCallback val$completedCallback;

        public AnonymousClass4(com.alibaba.sdk.android.oss.callback.OSSCompletedCallback oSSCompletedCallback) {
            this.val$completedCallback = oSSCompletedCallback;
        }

        @Override // com.alibaba.sdk.android.oss.callback.OSSCompletedCallback
        public void onFailure(com.alibaba.sdk.android.oss.model.AppendObjectRequest appendObjectRequest, com.alibaba.sdk.android.oss.ClientException clientException, com.alibaba.sdk.android.oss.ServiceException serviceException) {
            this.val$completedCallback.onFailure(appendObjectRequest, clientException, serviceException);
        }

        @Override // com.alibaba.sdk.android.oss.callback.OSSCompletedCallback
        public void onSuccess(com.alibaba.sdk.android.oss.model.AppendObjectRequest appendObjectRequest, com.alibaba.sdk.android.oss.model.AppendObjectResult appendObjectResult) {
            boolean z = appendObjectRequest.getCRC64() == com.alibaba.sdk.android.oss.model.OSSRequest.CRC64Config.YES;
            if (appendObjectRequest.getInitCRC64() != null && z) {
                appendObjectResult.setClientCRC(java.lang.Long.valueOf(com.alibaba.sdk.android.oss.common.utils.CRC64.combine(appendObjectRequest.getInitCRC64().longValue(), appendObjectResult.getClientCRC().longValue(), appendObjectResult.getNextPosition() - appendObjectRequest.getPosition())));
            }
            com.alibaba.sdk.android.oss.internal.InternalRequestOperation.this.checkCRC64(appendObjectRequest, appendObjectResult, this.val$completedCallback);
        }
    }

    /* renamed from: com.alibaba.sdk.android.oss.internal.InternalRequestOperation$5, reason: invalid class name */
    public class AnonymousClass5 implements com.alibaba.sdk.android.oss.callback.OSSCompletedCallback<com.alibaba.sdk.android.oss.model.UploadPartRequest, com.alibaba.sdk.android.oss.model.UploadPartResult> {
        final /* synthetic */ com.alibaba.sdk.android.oss.callback.OSSCompletedCallback val$completedCallback;

        public AnonymousClass5(com.alibaba.sdk.android.oss.callback.OSSCompletedCallback oSSCompletedCallback) {
            this.val$completedCallback = oSSCompletedCallback;
        }

        @Override // com.alibaba.sdk.android.oss.callback.OSSCompletedCallback
        public void onFailure(com.alibaba.sdk.android.oss.model.UploadPartRequest uploadPartRequest, com.alibaba.sdk.android.oss.ClientException clientException, com.alibaba.sdk.android.oss.ServiceException serviceException) {
            this.val$completedCallback.onFailure(uploadPartRequest, clientException, serviceException);
        }

        @Override // com.alibaba.sdk.android.oss.callback.OSSCompletedCallback
        public void onSuccess(com.alibaba.sdk.android.oss.model.UploadPartRequest uploadPartRequest, com.alibaba.sdk.android.oss.model.UploadPartResult uploadPartResult) {
            com.alibaba.sdk.android.oss.internal.InternalRequestOperation.this.checkCRC64(uploadPartRequest, uploadPartResult, this.val$completedCallback);
        }
    }

    /* renamed from: com.alibaba.sdk.android.oss.internal.InternalRequestOperation$6, reason: invalid class name */
    public class AnonymousClass6 implements com.alibaba.sdk.android.oss.callback.OSSCompletedCallback<com.alibaba.sdk.android.oss.model.CompleteMultipartUploadRequest, com.alibaba.sdk.android.oss.model.CompleteMultipartUploadResult> {
        final /* synthetic */ com.alibaba.sdk.android.oss.callback.OSSCompletedCallback val$completedCallback;

        public AnonymousClass6(com.alibaba.sdk.android.oss.callback.OSSCompletedCallback oSSCompletedCallback) {
            this.val$completedCallback = oSSCompletedCallback;
        }

        @Override // com.alibaba.sdk.android.oss.callback.OSSCompletedCallback
        public void onFailure(com.alibaba.sdk.android.oss.model.CompleteMultipartUploadRequest completeMultipartUploadRequest, com.alibaba.sdk.android.oss.ClientException clientException, com.alibaba.sdk.android.oss.ServiceException serviceException) {
            this.val$completedCallback.onFailure(completeMultipartUploadRequest, clientException, serviceException);
        }

        @Override // com.alibaba.sdk.android.oss.callback.OSSCompletedCallback
        public void onSuccess(com.alibaba.sdk.android.oss.model.CompleteMultipartUploadRequest completeMultipartUploadRequest, com.alibaba.sdk.android.oss.model.CompleteMultipartUploadResult completeMultipartUploadResult) {
            if (completeMultipartUploadResult.getServerCRC() != null) {
                completeMultipartUploadResult.setClientCRC(java.lang.Long.valueOf(com.alibaba.sdk.android.oss.internal.InternalRequestOperation.this.calcObjectCRCFromParts(completeMultipartUploadRequest.getPartETags())));
            }
            com.alibaba.sdk.android.oss.internal.InternalRequestOperation.this.checkCRC64(completeMultipartUploadRequest, completeMultipartUploadResult, this.val$completedCallback);
        }
    }

    /* renamed from: com.alibaba.sdk.android.oss.internal.InternalRequestOperation$7, reason: invalid class name */
    public class AnonymousClass7 implements java.util.concurrent.Callable {
        final /* synthetic */ java.io.UnsupportedEncodingException val$e;

        public AnonymousClass7(java.io.UnsupportedEncodingException unsupportedEncodingException) {
            this.val$e = unsupportedEncodingException;
        }

        @Override // java.util.concurrent.Callable
        public java.lang.Object call() throws java.lang.Exception {
            throw this.val$e;
        }
    }

    public InternalRequestOperation(android.content.Context context, com.alibaba.sdk.android.oss.common.auth.OSSCredentialProvider oSSCredentialProvider, com.alibaba.sdk.android.oss.ClientConfiguration clientConfiguration) {
        this.maxRetryCount = 2;
        try {
            this.service = new java.net.URI(clientConfiguration.getHttpProtocol().toString() + "://oss.aliyuncs.com");
            this.endpoint = new java.net.URI(clientConfiguration.getHttpProtocol().toString() + "://127.0.0.1");
            this.applicationContext = context;
            this.credentialProvider = oSSCredentialProvider;
            this.conf = clientConfiguration;
            this.maxRetryCount = clientConfiguration.getMaxErrorRetry();
            if (clientConfiguration.getExecutorService() != null) {
                this.executorService = clientConfiguration.getExecutorService();
            } else {
                this.executorService = executorServiceDefault;
            }
            this.product = "oss";
            this.innerClient = buildOkHttpClient(this.service.getHost(), clientConfiguration);
        } catch (java.lang.Exception unused) {
            throw new java.lang.IllegalArgumentException("Endpoint must be a string like 'http://oss-cn-****.aliyuncs.com',or your cname like 'http://image.cnamedomain.com'!");
        }
    }

    public InternalRequestOperation(android.content.Context context, java.net.URI uri, com.alibaba.sdk.android.oss.common.auth.OSSCredentialProvider oSSCredentialProvider, com.alibaba.sdk.android.oss.ClientConfiguration clientConfiguration) {
        this.maxRetryCount = 2;
        this.applicationContext = context;
        this.endpoint = uri;
        this.service = uri;
        this.credentialProvider = oSSCredentialProvider;
        this.conf = clientConfiguration;
        this.maxRetryCount = clientConfiguration.getMaxErrorRetry();
        if (clientConfiguration.getExecutorService() != null) {
            this.executorService = clientConfiguration.getExecutorService();
        } else {
            this.executorService = executorServiceDefault;
        }
        this.product = "oss";
        this.innerClient = buildOkHttpClient(uri.getHost(), clientConfiguration);
    }

    private okhttp3.OkHttpClient buildOkHttpClient(java.lang.String str, com.alibaba.sdk.android.oss.ClientConfiguration clientConfiguration) {
        if (clientConfiguration.getOkHttpClient() != null) {
            return clientConfiguration.getOkHttpClient();
        }
        okhttp3.OkHttpClient.Builder hostnameVerifier = new okhttp3.OkHttpClient.Builder().followRedirects(clientConfiguration.isFollowRedirectsEnable()).followSslRedirects(clientConfiguration.isFollowRedirectsEnable()).retryOnConnectionFailure(false).cache(null).hostnameVerifier(new com.alibaba.sdk.android.oss.internal.InternalRequestOperation.AnonymousClass2(str));
        okhttp3.Dispatcher dispatcher = new okhttp3.Dispatcher();
        dispatcher.setMaxRequests(clientConfiguration.getMaxConcurrentRequest());
        if (clientConfiguration.getMaxConcurrentRequestsPerHost() > 0) {
            dispatcher.setMaxRequestsPerHost(clientConfiguration.getMaxConcurrentRequestsPerHost());
        }
        long connectionTimeout = clientConfiguration.getConnectionTimeout();
        java.util.concurrent.TimeUnit timeUnit = java.util.concurrent.TimeUnit.MILLISECONDS;
        hostnameVerifier.connectTimeout(connectionTimeout, timeUnit).readTimeout(clientConfiguration.getSocketTimeout(), timeUnit).writeTimeout(clientConfiguration.getSocketTimeout(), timeUnit).dispatcher(dispatcher);
        if (clientConfiguration.getProxyHost() != null && clientConfiguration.getProxyPort() != 0) {
            hostnameVerifier.proxy(new java.net.Proxy(java.net.Proxy.Type.HTTP, new java.net.InetSocketAddress(clientConfiguration.getProxyHost(), clientConfiguration.getProxyPort())));
        }
        return hostnameVerifier.build();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public long calcObjectCRCFromParts(java.util.List<com.alibaba.sdk.android.oss.model.PartETag> list) {
        long j = 0;
        for (com.alibaba.sdk.android.oss.model.PartETag partETag : list) {
            if (partETag.getCRC64() == 0 || partETag.getPartSize() <= 0) {
                return 0L;
            }
            j = com.alibaba.sdk.android.oss.common.utils.CRC64.combine(j, partETag.getCRC64(), partETag.getPartSize());
        }
        return j;
    }

    private void canonicalizeRequestMessage(com.alibaba.sdk.android.oss.internal.RequestMessage requestMessage, com.alibaba.sdk.android.oss.model.OSSRequest oSSRequest) {
        java.util.Map headers = requestMessage.getHeaders();
        if ((requestMessage.getMethod() == com.alibaba.sdk.android.oss.common.HttpMethod.POST || requestMessage.getMethod() == com.alibaba.sdk.android.oss.common.HttpMethod.PUT) && com.alibaba.sdk.android.oss.common.utils.OSSUtils.isEmptyString((java.lang.String) headers.get("Content-Type"))) {
            headers.put("Content-Type", com.alibaba.sdk.android.oss.common.utils.OSSUtils.determineContentType(null, requestMessage.getUploadFilePath(), requestMessage.getObjectKey()));
        }
        requestMessage.setHttpDnsEnable(checkIfHttpDnsAvailable(this.conf.isHttpDnsEnable()));
        requestMessage.setSigner(createSigner(requestMessage.getBucketName(), requestMessage.getObjectKey(), this.credentialProvider, this.conf));
        requestMessage.setPathStyleAccessEnable(this.conf.isPathStyleAccessEnable());
        requestMessage.setCustomPathPrefixEnable(this.conf.isCustomPathPrefixEnable());
        requestMessage.setAdditionalHeaderNames(oSSRequest.getAdditionalHeaderNames());
        requestMessage.setIpWithHeader(this.conf.getIpWithHeader());
        requestMessage.getHeaders().put("User-Agent", com.alibaba.sdk.android.oss.common.utils.VersionInfoUtils.getUserAgent(this.conf.getCustomUserMark()));
        boolean z = false;
        if (requestMessage.getHeaders().containsKey("Range") || requestMessage.getParameters().containsKey(com.alibaba.sdk.android.oss.common.RequestParameters.X_OSS_PROCESS)) {
            requestMessage.setCheckCRC64(false);
        }
        requestMessage.setIsInCustomCnameExcludeList(com.alibaba.sdk.android.oss.common.utils.OSSUtils.isInCustomCnameExcludeList(this.endpoint.getHost(), this.conf.getCustomCnameExcludeList()));
        if (oSSRequest.getCRC64() == com.alibaba.sdk.android.oss.model.OSSRequest.CRC64Config.NULL) {
            z = this.conf.isCheckCRC64();
        } else if (oSSRequest.getCRC64() == com.alibaba.sdk.android.oss.model.OSSRequest.CRC64Config.YES) {
            z = true;
        }
        requestMessage.setCheckCRC64(z);
        oSSRequest.setCRC64(z ? com.alibaba.sdk.android.oss.model.OSSRequest.CRC64Config.YES : com.alibaba.sdk.android.oss.model.OSSRequest.CRC64Config.NO);
    }

    private <Request extends com.alibaba.sdk.android.oss.model.OSSRequest, Result extends com.alibaba.sdk.android.oss.model.OSSResult> void checkCRC64(Request request, Result result) throws com.alibaba.sdk.android.oss.ClientException {
        if (request.getCRC64() == com.alibaba.sdk.android.oss.model.OSSRequest.CRC64Config.YES) {
            try {
                com.alibaba.sdk.android.oss.common.utils.OSSUtils.checkChecksum(result.getClientCRC(), result.getServerCRC(), result.getRequestId());
            } catch (com.alibaba.sdk.android.oss.exception.InconsistentException e) {
                throw new com.alibaba.sdk.android.oss.ClientException(e.getMessage(), e);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public <Request extends com.alibaba.sdk.android.oss.model.OSSRequest, Result extends com.alibaba.sdk.android.oss.model.OSSResult> void checkCRC64(Request request, Result result, com.alibaba.sdk.android.oss.callback.OSSCompletedCallback<Request, Result> oSSCompletedCallback) {
        try {
            checkCRC64(request, result);
            if (oSSCompletedCallback != null) {
                oSSCompletedCallback.onSuccess(request, result);
            }
        } catch (com.alibaba.sdk.android.oss.ClientException e) {
            if (oSSCompletedCallback != null) {
                oSSCompletedCallback.onFailure(request, e, null);
            }
        }
    }

    private boolean checkIfHttpDnsAvailable(boolean z) {
        if (!z || this.applicationContext == null) {
            return false;
        }
        java.lang.String property = java.lang.System.getProperty(org.apache.tools.ant.util.ProxySetup.HTTP_PROXY_HOST);
        java.lang.String proxyHost = this.conf.getProxyHost();
        if (!android.text.TextUtils.isEmpty(proxyHost)) {
            property = proxyHost;
        }
        return android.text.TextUtils.isEmpty(property);
    }

    private com.alibaba.sdk.android.oss.signer.RequestSigner createSigner(java.lang.String str, java.lang.String str2, com.alibaba.sdk.android.oss.common.auth.OSSCredentialProvider oSSCredentialProvider, com.alibaba.sdk.android.oss.ClientConfiguration clientConfiguration) {
        java.lang.String str3;
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        sb.append(net.lingala.zip4j.util.InternalZipConstants.ZIP_FILE_SEPARATOR);
        if (str != null) {
            str3 = str + net.lingala.zip4j.util.InternalZipConstants.ZIP_FILE_SEPARATOR;
        } else {
            str3 = "";
        }
        sb.append(str3);
        if (str2 == null) {
            str2 = "";
        }
        sb.append(str2);
        com.alibaba.sdk.android.oss.signer.OSSSignerParams oSSSignerParams = new com.alibaba.sdk.android.oss.signer.OSSSignerParams(sb.toString(), oSSCredentialProvider);
        oSSSignerParams.setProduct(this.product);
        oSSSignerParams.setRegion(this.region);
        oSSSignerParams.setCloudBoxId(this.cloudBoxId);
        return com.alibaba.sdk.android.oss.signer.OSSSignerBase.createRequestSigner(clientConfiguration.getSignVersion(), oSSSignerParams);
    }

    public com.alibaba.sdk.android.oss.internal.OSSAsyncTask<com.alibaba.sdk.android.oss.model.AbortMultipartUploadResult> abortMultipartUpload(com.alibaba.sdk.android.oss.model.AbortMultipartUploadRequest abortMultipartUploadRequest, com.alibaba.sdk.android.oss.callback.OSSCompletedCallback<com.alibaba.sdk.android.oss.model.AbortMultipartUploadRequest, com.alibaba.sdk.android.oss.model.AbortMultipartUploadResult> oSSCompletedCallback) {
        com.alibaba.sdk.android.oss.internal.RequestMessage requestMessage = new com.alibaba.sdk.android.oss.internal.RequestMessage();
        requestMessage.setIsAuthorizationRequired(abortMultipartUploadRequest.isAuthorizationRequired());
        requestMessage.setEndpoint(this.endpoint);
        requestMessage.setMethod(com.alibaba.sdk.android.oss.common.HttpMethod.DELETE);
        requestMessage.setBucketName(abortMultipartUploadRequest.getBucketName());
        requestMessage.setObjectKey(abortMultipartUploadRequest.getObjectKey());
        requestMessage.getParameters().put(com.alibaba.sdk.android.oss.common.RequestParameters.UPLOAD_ID, abortMultipartUploadRequest.getUploadId());
        canonicalizeRequestMessage(requestMessage, abortMultipartUploadRequest);
        com.alibaba.sdk.android.oss.network.ExecutionContext executionContext = new com.alibaba.sdk.android.oss.network.ExecutionContext(getInnerClient(), abortMultipartUploadRequest, this.applicationContext);
        if (oSSCompletedCallback != null) {
            executionContext.setCompletedCallback(oSSCompletedCallback);
        }
        return com.alibaba.sdk.android.oss.internal.OSSAsyncTask.wrapRequestTask(this.executorService.submit(new com.alibaba.sdk.android.oss.network.OSSRequestTask(requestMessage, new com.alibaba.sdk.android.oss.internal.ResponseParsers.AbortMultipartUploadResponseParser(), executionContext, this.maxRetryCount)), executionContext);
    }

    public com.alibaba.sdk.android.oss.internal.OSSAsyncTask<com.alibaba.sdk.android.oss.model.AppendObjectResult> appendObject(com.alibaba.sdk.android.oss.model.AppendObjectRequest appendObjectRequest, com.alibaba.sdk.android.oss.callback.OSSCompletedCallback<com.alibaba.sdk.android.oss.model.AppendObjectRequest, com.alibaba.sdk.android.oss.model.AppendObjectResult> oSSCompletedCallback) {
        com.alibaba.sdk.android.oss.internal.RequestMessage requestMessage = new com.alibaba.sdk.android.oss.internal.RequestMessage();
        requestMessage.setIsAuthorizationRequired(appendObjectRequest.isAuthorizationRequired());
        requestMessage.setEndpoint(this.endpoint);
        requestMessage.setMethod(com.alibaba.sdk.android.oss.common.HttpMethod.POST);
        requestMessage.setBucketName(appendObjectRequest.getBucketName());
        requestMessage.setObjectKey(appendObjectRequest.getObjectKey());
        if (appendObjectRequest.getUploadData() != null) {
            requestMessage.setUploadData(appendObjectRequest.getUploadData());
        }
        if (appendObjectRequest.getUploadFilePath() != null) {
            requestMessage.setUploadFilePath(appendObjectRequest.getUploadFilePath());
        }
        if (appendObjectRequest.getUploadUri() != null) {
            requestMessage.setUploadUri(appendObjectRequest.getUploadUri());
        }
        requestMessage.getParameters().put(com.alibaba.sdk.android.oss.common.RequestParameters.SUBRESOURCE_APPEND, "");
        requestMessage.getParameters().put(com.alibaba.sdk.android.oss.common.RequestParameters.POSITION, java.lang.String.valueOf(appendObjectRequest.getPosition()));
        com.alibaba.sdk.android.oss.common.utils.OSSUtils.populateRequestMetadata(requestMessage.getHeaders(), appendObjectRequest.getMetadata());
        canonicalizeRequestMessage(requestMessage, appendObjectRequest);
        com.alibaba.sdk.android.oss.network.ExecutionContext executionContext = new com.alibaba.sdk.android.oss.network.ExecutionContext(getInnerClient(), appendObjectRequest, this.applicationContext);
        if (oSSCompletedCallback != null) {
            executionContext.setCompletedCallback(new com.alibaba.sdk.android.oss.internal.InternalRequestOperation.AnonymousClass4(oSSCompletedCallback));
        }
        executionContext.setProgressCallback(appendObjectRequest.getProgressCallback());
        return com.alibaba.sdk.android.oss.internal.OSSAsyncTask.wrapRequestTask(this.executorService.submit(new com.alibaba.sdk.android.oss.network.OSSRequestTask(requestMessage, new com.alibaba.sdk.android.oss.internal.ResponseParsers.AppendObjectResponseParser(), executionContext, this.maxRetryCount)), executionContext);
    }

    public com.alibaba.sdk.android.oss.model.TriggerCallbackResult asyncTriggerCallback(com.alibaba.sdk.android.oss.model.TriggerCallbackRequest triggerCallbackRequest) throws com.alibaba.sdk.android.oss.ClientException, com.alibaba.sdk.android.oss.ServiceException {
        return triggerCallback(triggerCallbackRequest, null).getResult();
    }

    public com.alibaba.sdk.android.oss.internal.OSSAsyncTask<com.alibaba.sdk.android.oss.model.CompleteMultipartUploadResult> completeMultipartUpload(com.alibaba.sdk.android.oss.model.CompleteMultipartUploadRequest completeMultipartUploadRequest, com.alibaba.sdk.android.oss.callback.OSSCompletedCallback<com.alibaba.sdk.android.oss.model.CompleteMultipartUploadRequest, com.alibaba.sdk.android.oss.model.CompleteMultipartUploadResult> oSSCompletedCallback) {
        com.alibaba.sdk.android.oss.internal.RequestMessage requestMessage = new com.alibaba.sdk.android.oss.internal.RequestMessage();
        requestMessage.setIsAuthorizationRequired(completeMultipartUploadRequest.isAuthorizationRequired());
        requestMessage.setEndpoint(this.endpoint);
        requestMessage.setMethod(com.alibaba.sdk.android.oss.common.HttpMethod.POST);
        requestMessage.setBucketName(completeMultipartUploadRequest.getBucketName());
        requestMessage.setObjectKey(completeMultipartUploadRequest.getObjectKey());
        requestMessage.setStringBody(com.alibaba.sdk.android.oss.common.utils.OSSUtils.buildXMLFromPartEtagList(completeMultipartUploadRequest.getPartETags()));
        requestMessage.getParameters().put(com.alibaba.sdk.android.oss.common.RequestParameters.UPLOAD_ID, completeMultipartUploadRequest.getUploadId());
        if (completeMultipartUploadRequest.getCallbackParam() != null) {
            requestMessage.getHeaders().put("x-oss-callback", com.alibaba.sdk.android.oss.common.utils.OSSUtils.populateMapToBase64JsonString(completeMultipartUploadRequest.getCallbackParam()));
        }
        if (completeMultipartUploadRequest.getCallbackVars() != null) {
            requestMessage.getHeaders().put("x-oss-callback-var", com.alibaba.sdk.android.oss.common.utils.OSSUtils.populateMapToBase64JsonString(completeMultipartUploadRequest.getCallbackVars()));
        }
        com.alibaba.sdk.android.oss.common.utils.OSSUtils.populateRequestMetadata(requestMessage.getHeaders(), completeMultipartUploadRequest.getMetadata());
        canonicalizeRequestMessage(requestMessage, completeMultipartUploadRequest);
        com.alibaba.sdk.android.oss.network.ExecutionContext executionContext = new com.alibaba.sdk.android.oss.network.ExecutionContext(getInnerClient(), completeMultipartUploadRequest, this.applicationContext);
        if (oSSCompletedCallback != null) {
            executionContext.setCompletedCallback(new com.alibaba.sdk.android.oss.internal.InternalRequestOperation.AnonymousClass6(oSSCompletedCallback));
        }
        return com.alibaba.sdk.android.oss.internal.OSSAsyncTask.wrapRequestTask(this.executorService.submit(new com.alibaba.sdk.android.oss.network.OSSRequestTask(requestMessage, new com.alibaba.sdk.android.oss.internal.ResponseParsers.CompleteMultipartUploadResponseParser(), executionContext, this.maxRetryCount)), executionContext);
    }

    public com.alibaba.sdk.android.oss.internal.OSSAsyncTask<com.alibaba.sdk.android.oss.model.CopyObjectResult> copyObject(com.alibaba.sdk.android.oss.model.CopyObjectRequest copyObjectRequest, com.alibaba.sdk.android.oss.callback.OSSCompletedCallback<com.alibaba.sdk.android.oss.model.CopyObjectRequest, com.alibaba.sdk.android.oss.model.CopyObjectResult> oSSCompletedCallback) {
        com.alibaba.sdk.android.oss.internal.RequestMessage requestMessage = new com.alibaba.sdk.android.oss.internal.RequestMessage();
        requestMessage.setIsAuthorizationRequired(copyObjectRequest.isAuthorizationRequired());
        requestMessage.setEndpoint(this.endpoint);
        requestMessage.setMethod(com.alibaba.sdk.android.oss.common.HttpMethod.PUT);
        requestMessage.setBucketName(copyObjectRequest.getDestinationBucketName());
        requestMessage.setObjectKey(copyObjectRequest.getDestinationKey());
        com.alibaba.sdk.android.oss.common.utils.OSSUtils.populateCopyObjectHeaders(copyObjectRequest, requestMessage.getHeaders());
        canonicalizeRequestMessage(requestMessage, copyObjectRequest);
        com.alibaba.sdk.android.oss.network.ExecutionContext executionContext = new com.alibaba.sdk.android.oss.network.ExecutionContext(getInnerClient(), copyObjectRequest, this.applicationContext);
        if (oSSCompletedCallback != null) {
            executionContext.setCompletedCallback(oSSCompletedCallback);
        }
        return com.alibaba.sdk.android.oss.internal.OSSAsyncTask.wrapRequestTask(this.executorService.submit(new com.alibaba.sdk.android.oss.network.OSSRequestTask(requestMessage, new com.alibaba.sdk.android.oss.internal.ResponseParsers.CopyObjectResponseParser(), executionContext, this.maxRetryCount)), executionContext);
    }

    public com.alibaba.sdk.android.oss.internal.OSSAsyncTask<com.alibaba.sdk.android.oss.model.CreateBucketResult> createBucket(com.alibaba.sdk.android.oss.model.CreateBucketRequest createBucketRequest, com.alibaba.sdk.android.oss.callback.OSSCompletedCallback<com.alibaba.sdk.android.oss.model.CreateBucketRequest, com.alibaba.sdk.android.oss.model.CreateBucketResult> oSSCompletedCallback) {
        com.alibaba.sdk.android.oss.internal.RequestMessage requestMessage = new com.alibaba.sdk.android.oss.internal.RequestMessage();
        requestMessage.setIsAuthorizationRequired(createBucketRequest.isAuthorizationRequired());
        requestMessage.setEndpoint(this.endpoint);
        requestMessage.setMethod(com.alibaba.sdk.android.oss.common.HttpMethod.PUT);
        requestMessage.setBucketName(createBucketRequest.getBucketName());
        if (createBucketRequest.getBucketACL() != null) {
            requestMessage.getHeaders().put(com.alibaba.sdk.android.oss.common.OSSHeaders.OSS_CANNED_ACL, createBucketRequest.getBucketACL().toString());
        }
        try {
            java.util.HashMap hashMap = new java.util.HashMap();
            if (createBucketRequest.getLocationConstraint() != null) {
                hashMap.put(com.alibaba.sdk.android.oss.model.CreateBucketRequest.TAB_LOCATIONCONSTRAINT, createBucketRequest.getLocationConstraint());
            }
            hashMap.put(com.alibaba.sdk.android.oss.model.CreateBucketRequest.TAB_STORAGECLASS, createBucketRequest.getBucketStorageClass().toString());
            requestMessage.createBucketRequestBodyMarshall(hashMap);
            canonicalizeRequestMessage(requestMessage, createBucketRequest);
            com.alibaba.sdk.android.oss.network.ExecutionContext executionContext = new com.alibaba.sdk.android.oss.network.ExecutionContext(getInnerClient(), createBucketRequest, this.applicationContext);
            if (oSSCompletedCallback != null) {
                executionContext.setCompletedCallback(oSSCompletedCallback);
            }
            return com.alibaba.sdk.android.oss.internal.OSSAsyncTask.wrapRequestTask(this.executorService.submit(new com.alibaba.sdk.android.oss.network.OSSRequestTask(requestMessage, new com.alibaba.sdk.android.oss.internal.ResponseParsers.CreateBucketResponseParser(), executionContext, this.maxRetryCount)), executionContext);
        } catch (java.io.UnsupportedEncodingException e) {
            e.printStackTrace();
            return null;
        }
    }

    public com.alibaba.sdk.android.oss.internal.OSSAsyncTask<com.alibaba.sdk.android.oss.model.DeleteBucketResult> deleteBucket(com.alibaba.sdk.android.oss.model.DeleteBucketRequest deleteBucketRequest, com.alibaba.sdk.android.oss.callback.OSSCompletedCallback<com.alibaba.sdk.android.oss.model.DeleteBucketRequest, com.alibaba.sdk.android.oss.model.DeleteBucketResult> oSSCompletedCallback) {
        com.alibaba.sdk.android.oss.internal.RequestMessage requestMessage = new com.alibaba.sdk.android.oss.internal.RequestMessage();
        requestMessage.setIsAuthorizationRequired(deleteBucketRequest.isAuthorizationRequired());
        requestMessage.setEndpoint(this.endpoint);
        requestMessage.setMethod(com.alibaba.sdk.android.oss.common.HttpMethod.DELETE);
        requestMessage.setBucketName(deleteBucketRequest.getBucketName());
        canonicalizeRequestMessage(requestMessage, deleteBucketRequest);
        com.alibaba.sdk.android.oss.network.ExecutionContext executionContext = new com.alibaba.sdk.android.oss.network.ExecutionContext(getInnerClient(), deleteBucketRequest, this.applicationContext);
        if (oSSCompletedCallback != null) {
            executionContext.setCompletedCallback(oSSCompletedCallback);
        }
        return com.alibaba.sdk.android.oss.internal.OSSAsyncTask.wrapRequestTask(this.executorService.submit(new com.alibaba.sdk.android.oss.network.OSSRequestTask(requestMessage, new com.alibaba.sdk.android.oss.internal.ResponseParsers.DeleteBucketResponseParser(), executionContext, this.maxRetryCount)), executionContext);
    }

    public com.alibaba.sdk.android.oss.internal.OSSAsyncTask<com.alibaba.sdk.android.oss.model.DeleteBucketLifecycleResult> deleteBucketLifecycle(com.alibaba.sdk.android.oss.model.DeleteBucketLifecycleRequest deleteBucketLifecycleRequest, com.alibaba.sdk.android.oss.callback.OSSCompletedCallback<com.alibaba.sdk.android.oss.model.DeleteBucketLifecycleRequest, com.alibaba.sdk.android.oss.model.DeleteBucketLifecycleResult> oSSCompletedCallback) {
        com.alibaba.sdk.android.oss.internal.RequestMessage requestMessage = new com.alibaba.sdk.android.oss.internal.RequestMessage();
        java.util.LinkedHashMap linkedHashMap = new java.util.LinkedHashMap();
        linkedHashMap.put(com.alibaba.sdk.android.oss.common.RequestParameters.SUBRESOURCE_LIFECYCLE, "");
        requestMessage.setIsAuthorizationRequired(deleteBucketLifecycleRequest.isAuthorizationRequired());
        requestMessage.setEndpoint(this.endpoint);
        requestMessage.setMethod(com.alibaba.sdk.android.oss.common.HttpMethod.DELETE);
        requestMessage.setBucketName(deleteBucketLifecycleRequest.getBucketName());
        requestMessage.setParameters(linkedHashMap);
        canonicalizeRequestMessage(requestMessage, deleteBucketLifecycleRequest);
        com.alibaba.sdk.android.oss.network.ExecutionContext executionContext = new com.alibaba.sdk.android.oss.network.ExecutionContext(getInnerClient(), deleteBucketLifecycleRequest, this.applicationContext);
        if (oSSCompletedCallback != null) {
            executionContext.setCompletedCallback(oSSCompletedCallback);
        }
        return com.alibaba.sdk.android.oss.internal.OSSAsyncTask.wrapRequestTask(this.executorService.submit(new com.alibaba.sdk.android.oss.network.OSSRequestTask(requestMessage, new com.alibaba.sdk.android.oss.internal.ResponseParsers.DeleteBucketLifecycleResponseParser(), executionContext, this.maxRetryCount)), executionContext);
    }

    public com.alibaba.sdk.android.oss.internal.OSSAsyncTask<com.alibaba.sdk.android.oss.model.DeleteBucketLoggingResult> deleteBucketLogging(com.alibaba.sdk.android.oss.model.DeleteBucketLoggingRequest deleteBucketLoggingRequest, com.alibaba.sdk.android.oss.callback.OSSCompletedCallback<com.alibaba.sdk.android.oss.model.DeleteBucketLoggingRequest, com.alibaba.sdk.android.oss.model.DeleteBucketLoggingResult> oSSCompletedCallback) {
        com.alibaba.sdk.android.oss.internal.RequestMessage requestMessage = new com.alibaba.sdk.android.oss.internal.RequestMessage();
        java.util.LinkedHashMap linkedHashMap = new java.util.LinkedHashMap();
        linkedHashMap.put(com.alibaba.sdk.android.oss.common.RequestParameters.SUBRESOURCE_LOGGING, "");
        requestMessage.setIsAuthorizationRequired(deleteBucketLoggingRequest.isAuthorizationRequired());
        requestMessage.setEndpoint(this.endpoint);
        requestMessage.setMethod(com.alibaba.sdk.android.oss.common.HttpMethod.DELETE);
        requestMessage.setBucketName(deleteBucketLoggingRequest.getBucketName());
        requestMessage.setParameters(linkedHashMap);
        canonicalizeRequestMessage(requestMessage, deleteBucketLoggingRequest);
        com.alibaba.sdk.android.oss.network.ExecutionContext executionContext = new com.alibaba.sdk.android.oss.network.ExecutionContext(getInnerClient(), deleteBucketLoggingRequest, this.applicationContext);
        if (oSSCompletedCallback != null) {
            executionContext.setCompletedCallback(oSSCompletedCallback);
        }
        return com.alibaba.sdk.android.oss.internal.OSSAsyncTask.wrapRequestTask(this.executorService.submit(new com.alibaba.sdk.android.oss.network.OSSRequestTask(requestMessage, new com.alibaba.sdk.android.oss.internal.ResponseParsers.DeleteBucketLoggingResponseParser(), executionContext, this.maxRetryCount)), executionContext);
    }

    public com.alibaba.sdk.android.oss.internal.OSSAsyncTask<com.alibaba.sdk.android.oss.model.DeleteMultipleObjectResult> deleteMultipleObject(com.alibaba.sdk.android.oss.model.DeleteMultipleObjectRequest deleteMultipleObjectRequest, com.alibaba.sdk.android.oss.callback.OSSCompletedCallback<com.alibaba.sdk.android.oss.model.DeleteMultipleObjectRequest, com.alibaba.sdk.android.oss.model.DeleteMultipleObjectResult> oSSCompletedCallback) {
        com.alibaba.sdk.android.oss.internal.RequestMessage requestMessage = new com.alibaba.sdk.android.oss.internal.RequestMessage();
        java.util.LinkedHashMap linkedHashMap = new java.util.LinkedHashMap();
        linkedHashMap.put("delete", "");
        requestMessage.setIsAuthorizationRequired(deleteMultipleObjectRequest.isAuthorizationRequired());
        requestMessage.setEndpoint(this.endpoint);
        requestMessage.setMethod(com.alibaba.sdk.android.oss.common.HttpMethod.POST);
        requestMessage.setBucketName(deleteMultipleObjectRequest.getBucketName());
        requestMessage.setParameters(linkedHashMap);
        try {
            byte[] deleteMultipleObjectRequestBodyMarshall = requestMessage.deleteMultipleObjectRequestBodyMarshall(deleteMultipleObjectRequest.getObjectKeys(), deleteMultipleObjectRequest.getQuiet().booleanValue());
            if (deleteMultipleObjectRequestBodyMarshall != null && deleteMultipleObjectRequestBodyMarshall.length > 0) {
                requestMessage.getHeaders().put("Content-MD5", com.alibaba.sdk.android.oss.common.utils.BinaryUtil.calculateBase64Md5(deleteMultipleObjectRequestBodyMarshall));
                requestMessage.getHeaders().put("Content-Length", java.lang.String.valueOf(deleteMultipleObjectRequestBodyMarshall.length));
            }
            canonicalizeRequestMessage(requestMessage, deleteMultipleObjectRequest);
            com.alibaba.sdk.android.oss.network.ExecutionContext executionContext = new com.alibaba.sdk.android.oss.network.ExecutionContext(getInnerClient(), deleteMultipleObjectRequest, this.applicationContext);
            if (oSSCompletedCallback != null) {
                executionContext.setCompletedCallback(oSSCompletedCallback);
            }
            return com.alibaba.sdk.android.oss.internal.OSSAsyncTask.wrapRequestTask(this.executorService.submit(new com.alibaba.sdk.android.oss.network.OSSRequestTask(requestMessage, new com.alibaba.sdk.android.oss.internal.ResponseParsers.DeleteMultipleObjectResponseParser(), executionContext, this.maxRetryCount)), executionContext);
        } catch (java.io.UnsupportedEncodingException e) {
            e.printStackTrace();
            return null;
        }
    }

    public com.alibaba.sdk.android.oss.internal.OSSAsyncTask<com.alibaba.sdk.android.oss.model.DeleteObjectResult> deleteObject(com.alibaba.sdk.android.oss.model.DeleteObjectRequest deleteObjectRequest, com.alibaba.sdk.android.oss.callback.OSSCompletedCallback<com.alibaba.sdk.android.oss.model.DeleteObjectRequest, com.alibaba.sdk.android.oss.model.DeleteObjectResult> oSSCompletedCallback) {
        com.alibaba.sdk.android.oss.internal.RequestMessage requestMessage = new com.alibaba.sdk.android.oss.internal.RequestMessage();
        requestMessage.setIsAuthorizationRequired(deleteObjectRequest.isAuthorizationRequired());
        requestMessage.setEndpoint(this.endpoint);
        requestMessage.setMethod(com.alibaba.sdk.android.oss.common.HttpMethod.DELETE);
        requestMessage.setBucketName(deleteObjectRequest.getBucketName());
        requestMessage.setObjectKey(deleteObjectRequest.getObjectKey());
        canonicalizeRequestMessage(requestMessage, deleteObjectRequest);
        com.alibaba.sdk.android.oss.network.ExecutionContext executionContext = new com.alibaba.sdk.android.oss.network.ExecutionContext(getInnerClient(), deleteObjectRequest, this.applicationContext);
        if (oSSCompletedCallback != null) {
            executionContext.setCompletedCallback(oSSCompletedCallback);
        }
        return com.alibaba.sdk.android.oss.internal.OSSAsyncTask.wrapRequestTask(this.executorService.submit(new com.alibaba.sdk.android.oss.network.OSSRequestTask(requestMessage, new com.alibaba.sdk.android.oss.internal.ResponseParsers.DeleteObjectResponseParser(), executionContext, this.maxRetryCount)), executionContext);
    }

    public com.alibaba.sdk.android.oss.internal.OSSAsyncTask<com.alibaba.sdk.android.oss.model.DeleteObjectTaggingResult> deleteObjectTagging(com.alibaba.sdk.android.oss.model.DeleteObjectTaggingRequest deleteObjectTaggingRequest, com.alibaba.sdk.android.oss.callback.OSSCompletedCallback<com.alibaba.sdk.android.oss.model.DeleteObjectTaggingRequest, com.alibaba.sdk.android.oss.model.DeleteObjectTaggingResult> oSSCompletedCallback) {
        com.alibaba.sdk.android.oss.internal.RequestMessage requestMessage = new com.alibaba.sdk.android.oss.internal.RequestMessage();
        java.util.LinkedHashMap linkedHashMap = new java.util.LinkedHashMap();
        linkedHashMap.put(com.alibaba.sdk.android.oss.common.RequestParameters.X_OSS_TAGGING, "");
        requestMessage.setIsAuthorizationRequired(deleteObjectTaggingRequest.isAuthorizationRequired());
        requestMessage.setEndpoint(this.endpoint);
        requestMessage.setMethod(com.alibaba.sdk.android.oss.common.HttpMethod.DELETE);
        requestMessage.setBucketName(deleteObjectTaggingRequest.getBucketName());
        requestMessage.setObjectKey(deleteObjectTaggingRequest.getObjectKey());
        requestMessage.setParameters(linkedHashMap);
        canonicalizeRequestMessage(requestMessage, deleteObjectTaggingRequest);
        com.alibaba.sdk.android.oss.network.ExecutionContext executionContext = new com.alibaba.sdk.android.oss.network.ExecutionContext(getInnerClient(), deleteObjectTaggingRequest, this.applicationContext);
        if (oSSCompletedCallback != null) {
            executionContext.setCompletedCallback(oSSCompletedCallback);
        }
        return com.alibaba.sdk.android.oss.internal.OSSAsyncTask.wrapRequestTask(this.executorService.submit(new com.alibaba.sdk.android.oss.network.OSSRequestTask(requestMessage, new com.alibaba.sdk.android.oss.internal.ResponseParsers.DeleteObjectTaggingResponseParser(), executionContext, this.maxRetryCount)), executionContext);
    }

    public android.content.Context getApplicationContext() {
        return this.applicationContext;
    }

    public com.alibaba.sdk.android.oss.internal.OSSAsyncTask<com.alibaba.sdk.android.oss.model.GetBucketACLResult> getBucketACL(com.alibaba.sdk.android.oss.model.GetBucketACLRequest getBucketACLRequest, com.alibaba.sdk.android.oss.callback.OSSCompletedCallback<com.alibaba.sdk.android.oss.model.GetBucketACLRequest, com.alibaba.sdk.android.oss.model.GetBucketACLResult> oSSCompletedCallback) {
        com.alibaba.sdk.android.oss.internal.RequestMessage requestMessage = new com.alibaba.sdk.android.oss.internal.RequestMessage();
        java.util.LinkedHashMap linkedHashMap = new java.util.LinkedHashMap();
        linkedHashMap.put(com.alibaba.sdk.android.oss.common.RequestParameters.SUBRESOURCE_ACL, "");
        requestMessage.setIsAuthorizationRequired(getBucketACLRequest.isAuthorizationRequired());
        requestMessage.setEndpoint(this.endpoint);
        requestMessage.setMethod(com.alibaba.sdk.android.oss.common.HttpMethod.GET);
        requestMessage.setBucketName(getBucketACLRequest.getBucketName());
        requestMessage.setParameters(linkedHashMap);
        canonicalizeRequestMessage(requestMessage, getBucketACLRequest);
        com.alibaba.sdk.android.oss.network.ExecutionContext executionContext = new com.alibaba.sdk.android.oss.network.ExecutionContext(getInnerClient(), getBucketACLRequest, this.applicationContext);
        if (oSSCompletedCallback != null) {
            executionContext.setCompletedCallback(oSSCompletedCallback);
        }
        return com.alibaba.sdk.android.oss.internal.OSSAsyncTask.wrapRequestTask(this.executorService.submit(new com.alibaba.sdk.android.oss.network.OSSRequestTask(requestMessage, new com.alibaba.sdk.android.oss.internal.ResponseParsers.GetBucketACLResponseParser(), executionContext, this.maxRetryCount)), executionContext);
    }

    public com.alibaba.sdk.android.oss.internal.OSSAsyncTask<com.alibaba.sdk.android.oss.model.GetBucketInfoResult> getBucketInfo(com.alibaba.sdk.android.oss.model.GetBucketInfoRequest getBucketInfoRequest, com.alibaba.sdk.android.oss.callback.OSSCompletedCallback<com.alibaba.sdk.android.oss.model.GetBucketInfoRequest, com.alibaba.sdk.android.oss.model.GetBucketInfoResult> oSSCompletedCallback) {
        com.alibaba.sdk.android.oss.internal.RequestMessage requestMessage = new com.alibaba.sdk.android.oss.internal.RequestMessage();
        java.util.LinkedHashMap linkedHashMap = new java.util.LinkedHashMap();
        linkedHashMap.put(com.alibaba.sdk.android.oss.common.RequestParameters.SUBRESOURCE_BUCKETINFO, "");
        requestMessage.setIsAuthorizationRequired(getBucketInfoRequest.isAuthorizationRequired());
        requestMessage.setEndpoint(this.endpoint);
        requestMessage.setMethod(com.alibaba.sdk.android.oss.common.HttpMethod.GET);
        requestMessage.setBucketName(getBucketInfoRequest.getBucketName());
        requestMessage.setParameters(linkedHashMap);
        canonicalizeRequestMessage(requestMessage, getBucketInfoRequest);
        com.alibaba.sdk.android.oss.network.ExecutionContext executionContext = new com.alibaba.sdk.android.oss.network.ExecutionContext(getInnerClient(), getBucketInfoRequest, this.applicationContext);
        if (oSSCompletedCallback != null) {
            executionContext.setCompletedCallback(oSSCompletedCallback);
        }
        return com.alibaba.sdk.android.oss.internal.OSSAsyncTask.wrapRequestTask(this.executorService.submit(new com.alibaba.sdk.android.oss.network.OSSRequestTask(requestMessage, new com.alibaba.sdk.android.oss.internal.ResponseParsers.GetBucketInfoResponseParser(), executionContext, this.maxRetryCount)), executionContext);
    }

    public com.alibaba.sdk.android.oss.internal.OSSAsyncTask<com.alibaba.sdk.android.oss.model.GetBucketLifecycleResult> getBucketLifecycle(com.alibaba.sdk.android.oss.model.GetBucketLifecycleRequest getBucketLifecycleRequest, com.alibaba.sdk.android.oss.callback.OSSCompletedCallback<com.alibaba.sdk.android.oss.model.GetBucketLifecycleRequest, com.alibaba.sdk.android.oss.model.GetBucketLifecycleResult> oSSCompletedCallback) {
        com.alibaba.sdk.android.oss.internal.RequestMessage requestMessage = new com.alibaba.sdk.android.oss.internal.RequestMessage();
        java.util.LinkedHashMap linkedHashMap = new java.util.LinkedHashMap();
        linkedHashMap.put(com.alibaba.sdk.android.oss.common.RequestParameters.SUBRESOURCE_LIFECYCLE, "");
        requestMessage.setIsAuthorizationRequired(getBucketLifecycleRequest.isAuthorizationRequired());
        requestMessage.setEndpoint(this.endpoint);
        requestMessage.setMethod(com.alibaba.sdk.android.oss.common.HttpMethod.GET);
        requestMessage.setBucketName(getBucketLifecycleRequest.getBucketName());
        requestMessage.setParameters(linkedHashMap);
        canonicalizeRequestMessage(requestMessage, getBucketLifecycleRequest);
        com.alibaba.sdk.android.oss.network.ExecutionContext executionContext = new com.alibaba.sdk.android.oss.network.ExecutionContext(getInnerClient(), getBucketLifecycleRequest, this.applicationContext);
        if (oSSCompletedCallback != null) {
            executionContext.setCompletedCallback(oSSCompletedCallback);
        }
        return com.alibaba.sdk.android.oss.internal.OSSAsyncTask.wrapRequestTask(this.executorService.submit(new com.alibaba.sdk.android.oss.network.OSSRequestTask(requestMessage, new com.alibaba.sdk.android.oss.internal.ResponseParsers.GetBucketLifecycleResponseParser(), executionContext, this.maxRetryCount)), executionContext);
    }

    public com.alibaba.sdk.android.oss.internal.OSSAsyncTask<com.alibaba.sdk.android.oss.model.GetBucketLoggingResult> getBucketLogging(com.alibaba.sdk.android.oss.model.GetBucketLoggingRequest getBucketLoggingRequest, com.alibaba.sdk.android.oss.callback.OSSCompletedCallback<com.alibaba.sdk.android.oss.model.GetBucketLoggingRequest, com.alibaba.sdk.android.oss.model.GetBucketLoggingResult> oSSCompletedCallback) {
        com.alibaba.sdk.android.oss.internal.RequestMessage requestMessage = new com.alibaba.sdk.android.oss.internal.RequestMessage();
        java.util.LinkedHashMap linkedHashMap = new java.util.LinkedHashMap();
        linkedHashMap.put(com.alibaba.sdk.android.oss.common.RequestParameters.SUBRESOURCE_LOGGING, "");
        requestMessage.setIsAuthorizationRequired(getBucketLoggingRequest.isAuthorizationRequired());
        requestMessage.setEndpoint(this.endpoint);
        requestMessage.setMethod(com.alibaba.sdk.android.oss.common.HttpMethod.GET);
        requestMessage.setBucketName(getBucketLoggingRequest.getBucketName());
        requestMessage.setParameters(linkedHashMap);
        canonicalizeRequestMessage(requestMessage, getBucketLoggingRequest);
        com.alibaba.sdk.android.oss.network.ExecutionContext executionContext = new com.alibaba.sdk.android.oss.network.ExecutionContext(getInnerClient(), getBucketLoggingRequest, this.applicationContext);
        if (oSSCompletedCallback != null) {
            executionContext.setCompletedCallback(oSSCompletedCallback);
        }
        return com.alibaba.sdk.android.oss.internal.OSSAsyncTask.wrapRequestTask(this.executorService.submit(new com.alibaba.sdk.android.oss.network.OSSRequestTask(requestMessage, new com.alibaba.sdk.android.oss.internal.ResponseParsers.GetBucketLoggingResponseParser(), executionContext, this.maxRetryCount)), executionContext);
    }

    public com.alibaba.sdk.android.oss.internal.OSSAsyncTask<com.alibaba.sdk.android.oss.model.GetBucketRefererResult> getBucketReferer(com.alibaba.sdk.android.oss.model.GetBucketRefererRequest getBucketRefererRequest, com.alibaba.sdk.android.oss.callback.OSSCompletedCallback<com.alibaba.sdk.android.oss.model.GetBucketRefererRequest, com.alibaba.sdk.android.oss.model.GetBucketRefererResult> oSSCompletedCallback) {
        com.alibaba.sdk.android.oss.internal.RequestMessage requestMessage = new com.alibaba.sdk.android.oss.internal.RequestMessage();
        java.util.LinkedHashMap linkedHashMap = new java.util.LinkedHashMap();
        linkedHashMap.put(com.alibaba.sdk.android.oss.common.RequestParameters.SUBRESOURCE_REFERER, "");
        requestMessage.setIsAuthorizationRequired(getBucketRefererRequest.isAuthorizationRequired());
        requestMessage.setEndpoint(this.endpoint);
        requestMessage.setMethod(com.alibaba.sdk.android.oss.common.HttpMethod.GET);
        requestMessage.setBucketName(getBucketRefererRequest.getBucketName());
        requestMessage.setParameters(linkedHashMap);
        canonicalizeRequestMessage(requestMessage, getBucketRefererRequest);
        com.alibaba.sdk.android.oss.network.ExecutionContext executionContext = new com.alibaba.sdk.android.oss.network.ExecutionContext(getInnerClient(), getBucketRefererRequest, this.applicationContext);
        if (oSSCompletedCallback != null) {
            executionContext.setCompletedCallback(oSSCompletedCallback);
        }
        return com.alibaba.sdk.android.oss.internal.OSSAsyncTask.wrapRequestTask(this.executorService.submit(new com.alibaba.sdk.android.oss.network.OSSRequestTask(requestMessage, new com.alibaba.sdk.android.oss.internal.ResponseParsers.GetBucketRefererResponseParser(), executionContext, this.maxRetryCount)), executionContext);
    }

    public java.lang.String getCloudBoxId() {
        return this.cloudBoxId;
    }

    public com.alibaba.sdk.android.oss.ClientConfiguration getConf() {
        return this.conf;
    }

    public okhttp3.OkHttpClient getInnerClient() {
        return this.innerClient;
    }

    public com.alibaba.sdk.android.oss.internal.OSSAsyncTask<com.alibaba.sdk.android.oss.model.GetObjectResult> getObject(com.alibaba.sdk.android.oss.model.GetObjectRequest getObjectRequest, com.alibaba.sdk.android.oss.callback.OSSCompletedCallback<com.alibaba.sdk.android.oss.model.GetObjectRequest, com.alibaba.sdk.android.oss.model.GetObjectResult> oSSCompletedCallback) {
        com.alibaba.sdk.android.oss.internal.RequestMessage requestMessage = new com.alibaba.sdk.android.oss.internal.RequestMessage();
        requestMessage.setIsAuthorizationRequired(getObjectRequest.isAuthorizationRequired());
        requestMessage.setEndpoint(this.endpoint);
        requestMessage.setMethod(com.alibaba.sdk.android.oss.common.HttpMethod.GET);
        requestMessage.setBucketName(getObjectRequest.getBucketName());
        requestMessage.setObjectKey(getObjectRequest.getObjectKey());
        if (getObjectRequest.getRange() != null) {
            requestMessage.getHeaders().put("Range", getObjectRequest.getRange().toString());
        }
        if (getObjectRequest.getxOssProcess() != null) {
            requestMessage.getParameters().put(com.alibaba.sdk.android.oss.common.RequestParameters.X_OSS_PROCESS, getObjectRequest.getxOssProcess());
        }
        canonicalizeRequestMessage(requestMessage, getObjectRequest);
        if (getObjectRequest.getRequestHeaders() != null) {
            for (java.util.Map.Entry<java.lang.String, java.lang.String> entry : getObjectRequest.getRequestHeaders().entrySet()) {
                requestMessage.getHeaders().put(entry.getKey(), entry.getValue());
            }
        }
        com.alibaba.sdk.android.oss.network.ExecutionContext executionContext = new com.alibaba.sdk.android.oss.network.ExecutionContext(getInnerClient(), getObjectRequest, this.applicationContext);
        if (oSSCompletedCallback != null) {
            executionContext.setCompletedCallback(oSSCompletedCallback);
        }
        executionContext.setProgressCallback(getObjectRequest.getProgressListener());
        return com.alibaba.sdk.android.oss.internal.OSSAsyncTask.wrapRequestTask(this.executorService.submit(new com.alibaba.sdk.android.oss.network.OSSRequestTask(requestMessage, new com.alibaba.sdk.android.oss.internal.ResponseParsers.GetObjectResponseParser(), executionContext, this.maxRetryCount)), executionContext);
    }

    public com.alibaba.sdk.android.oss.internal.OSSAsyncTask<com.alibaba.sdk.android.oss.model.GetObjectACLResult> getObjectACL(com.alibaba.sdk.android.oss.model.GetObjectACLRequest getObjectACLRequest, com.alibaba.sdk.android.oss.callback.OSSCompletedCallback<com.alibaba.sdk.android.oss.model.GetObjectACLRequest, com.alibaba.sdk.android.oss.model.GetObjectACLResult> oSSCompletedCallback) {
        com.alibaba.sdk.android.oss.internal.RequestMessage requestMessage = new com.alibaba.sdk.android.oss.internal.RequestMessage();
        java.util.LinkedHashMap linkedHashMap = new java.util.LinkedHashMap();
        linkedHashMap.put(com.alibaba.sdk.android.oss.common.RequestParameters.SUBRESOURCE_ACL, "");
        requestMessage.setIsAuthorizationRequired(getObjectACLRequest.isAuthorizationRequired());
        requestMessage.setEndpoint(this.endpoint);
        requestMessage.setMethod(com.alibaba.sdk.android.oss.common.HttpMethod.GET);
        requestMessage.setParameters(linkedHashMap);
        requestMessage.setBucketName(getObjectACLRequest.getBucketName());
        requestMessage.setObjectKey(getObjectACLRequest.getObjectKey());
        canonicalizeRequestMessage(requestMessage, getObjectACLRequest);
        com.alibaba.sdk.android.oss.network.ExecutionContext executionContext = new com.alibaba.sdk.android.oss.network.ExecutionContext(getInnerClient(), getObjectACLRequest, this.applicationContext);
        if (oSSCompletedCallback != null) {
            executionContext.setCompletedCallback(oSSCompletedCallback);
        }
        return com.alibaba.sdk.android.oss.internal.OSSAsyncTask.wrapRequestTask(this.executorService.submit(new com.alibaba.sdk.android.oss.network.OSSRequestTask(requestMessage, new com.alibaba.sdk.android.oss.internal.ResponseParsers.GetObjectACLResponseParser(), executionContext, this.maxRetryCount)), executionContext);
    }

    public com.alibaba.sdk.android.oss.internal.OSSAsyncTask<com.alibaba.sdk.android.oss.model.GetObjectMetaResult> getObjectMeta(com.alibaba.sdk.android.oss.model.GetObjectMetaRequest getObjectMetaRequest, com.alibaba.sdk.android.oss.callback.OSSCompletedCallback<com.alibaba.sdk.android.oss.model.GetObjectMetaRequest, com.alibaba.sdk.android.oss.model.GetObjectMetaResult> oSSCompletedCallback) {
        java.util.LinkedHashMap linkedHashMap = new java.util.LinkedHashMap();
        linkedHashMap.put(com.alibaba.sdk.android.oss.common.RequestParameters.SUBRESOURCE_OBJECT_META, "");
        com.alibaba.sdk.android.oss.internal.RequestMessage requestMessage = new com.alibaba.sdk.android.oss.internal.RequestMessage();
        requestMessage.setIsAuthorizationRequired(getObjectMetaRequest.isAuthorizationRequired());
        requestMessage.setEndpoint(this.endpoint);
        requestMessage.setMethod(com.alibaba.sdk.android.oss.common.HttpMethod.HEAD);
        requestMessage.setBucketName(getObjectMetaRequest.getBucketName());
        requestMessage.setObjectKey(getObjectMetaRequest.getObjectKey());
        requestMessage.setParameters(linkedHashMap);
        canonicalizeRequestMessage(requestMessage, getObjectMetaRequest);
        com.alibaba.sdk.android.oss.network.ExecutionContext executionContext = new com.alibaba.sdk.android.oss.network.ExecutionContext(getInnerClient(), getObjectMetaRequest, this.applicationContext);
        if (oSSCompletedCallback != null) {
            executionContext.setCompletedCallback(oSSCompletedCallback);
        }
        return com.alibaba.sdk.android.oss.internal.OSSAsyncTask.wrapRequestTask(this.executorService.submit(new com.alibaba.sdk.android.oss.network.OSSRequestTask(requestMessage, new com.alibaba.sdk.android.oss.internal.ResponseParsers.GetObjectMetaResponseParser(), executionContext, this.maxRetryCount)), executionContext);
    }

    public com.alibaba.sdk.android.oss.internal.OSSAsyncTask<com.alibaba.sdk.android.oss.model.GetObjectTaggingResult> getObjectTagging(com.alibaba.sdk.android.oss.model.GetObjectTaggingRequest getObjectTaggingRequest, com.alibaba.sdk.android.oss.callback.OSSCompletedCallback<com.alibaba.sdk.android.oss.model.GetObjectTaggingRequest, com.alibaba.sdk.android.oss.model.GetObjectTaggingResult> oSSCompletedCallback) {
        com.alibaba.sdk.android.oss.internal.RequestMessage requestMessage = new com.alibaba.sdk.android.oss.internal.RequestMessage();
        java.util.LinkedHashMap linkedHashMap = new java.util.LinkedHashMap();
        linkedHashMap.put(com.alibaba.sdk.android.oss.common.RequestParameters.X_OSS_TAGGING, "");
        requestMessage.setIsAuthorizationRequired(getObjectTaggingRequest.isAuthorizationRequired());
        requestMessage.setEndpoint(this.endpoint);
        requestMessage.setMethod(com.alibaba.sdk.android.oss.common.HttpMethod.GET);
        requestMessage.setBucketName(getObjectTaggingRequest.getBucketName());
        requestMessage.setObjectKey(getObjectTaggingRequest.getObjectKey());
        requestMessage.setParameters(linkedHashMap);
        canonicalizeRequestMessage(requestMessage, getObjectTaggingRequest);
        com.alibaba.sdk.android.oss.network.ExecutionContext executionContext = new com.alibaba.sdk.android.oss.network.ExecutionContext(getInnerClient(), getObjectTaggingRequest, this.applicationContext);
        if (oSSCompletedCallback != null) {
            executionContext.setCompletedCallback(oSSCompletedCallback);
        }
        return com.alibaba.sdk.android.oss.internal.OSSAsyncTask.wrapRequestTask(this.executorService.submit(new com.alibaba.sdk.android.oss.network.OSSRequestTask(requestMessage, new com.alibaba.sdk.android.oss.internal.ResponseParsers.GetObjectTaggingResponseParser(), executionContext, this.maxRetryCount)), executionContext);
    }

    public java.lang.String getProduct() {
        return this.product;
    }

    public java.lang.String getRegion() {
        return this.region;
    }

    public com.alibaba.sdk.android.oss.internal.OSSAsyncTask<com.alibaba.sdk.android.oss.model.GetSymlinkResult> getSymlink(com.alibaba.sdk.android.oss.model.GetSymlinkRequest getSymlinkRequest, com.alibaba.sdk.android.oss.callback.OSSCompletedCallback<com.alibaba.sdk.android.oss.model.GetSymlinkRequest, com.alibaba.sdk.android.oss.model.GetSymlinkResult> oSSCompletedCallback) {
        com.alibaba.sdk.android.oss.internal.RequestMessage requestMessage = new com.alibaba.sdk.android.oss.internal.RequestMessage();
        java.util.LinkedHashMap linkedHashMap = new java.util.LinkedHashMap();
        linkedHashMap.put(com.alibaba.sdk.android.oss.common.RequestParameters.X_OSS_SYMLINK, "");
        requestMessage.setEndpoint(this.endpoint);
        requestMessage.setMethod(com.alibaba.sdk.android.oss.common.HttpMethod.GET);
        requestMessage.setBucketName(getSymlinkRequest.getBucketName());
        requestMessage.setObjectKey(getSymlinkRequest.getObjectKey());
        requestMessage.setParameters(linkedHashMap);
        canonicalizeRequestMessage(requestMessage, getSymlinkRequest);
        com.alibaba.sdk.android.oss.network.ExecutionContext executionContext = new com.alibaba.sdk.android.oss.network.ExecutionContext(getInnerClient(), getSymlinkRequest, this.applicationContext);
        if (oSSCompletedCallback != null) {
            executionContext.setCompletedCallback(oSSCompletedCallback);
        }
        return com.alibaba.sdk.android.oss.internal.OSSAsyncTask.wrapRequestTask(this.executorService.submit(new com.alibaba.sdk.android.oss.network.OSSRequestTask(requestMessage, new com.alibaba.sdk.android.oss.internal.ResponseParsers.GetSymlinkResponseParser(), executionContext, this.maxRetryCount)), executionContext);
    }

    public com.alibaba.sdk.android.oss.internal.OSSAsyncTask<com.alibaba.sdk.android.oss.model.HeadObjectResult> headObject(com.alibaba.sdk.android.oss.model.HeadObjectRequest headObjectRequest, com.alibaba.sdk.android.oss.callback.OSSCompletedCallback<com.alibaba.sdk.android.oss.model.HeadObjectRequest, com.alibaba.sdk.android.oss.model.HeadObjectResult> oSSCompletedCallback) {
        com.alibaba.sdk.android.oss.internal.RequestMessage requestMessage = new com.alibaba.sdk.android.oss.internal.RequestMessage();
        requestMessage.setIsAuthorizationRequired(headObjectRequest.isAuthorizationRequired());
        requestMessage.setEndpoint(this.endpoint);
        requestMessage.setMethod(com.alibaba.sdk.android.oss.common.HttpMethod.HEAD);
        requestMessage.setBucketName(headObjectRequest.getBucketName());
        requestMessage.setObjectKey(headObjectRequest.getObjectKey());
        canonicalizeRequestMessage(requestMessage, headObjectRequest);
        com.alibaba.sdk.android.oss.network.ExecutionContext executionContext = new com.alibaba.sdk.android.oss.network.ExecutionContext(getInnerClient(), headObjectRequest, this.applicationContext);
        if (oSSCompletedCallback != null) {
            executionContext.setCompletedCallback(oSSCompletedCallback);
        }
        return com.alibaba.sdk.android.oss.internal.OSSAsyncTask.wrapRequestTask(this.executorService.submit(new com.alibaba.sdk.android.oss.network.OSSRequestTask(requestMessage, new com.alibaba.sdk.android.oss.internal.ResponseParsers.HeadObjectResponseParser(), executionContext, this.maxRetryCount)), executionContext);
    }

    public com.alibaba.sdk.android.oss.internal.OSSAsyncTask<com.alibaba.sdk.android.oss.model.ImagePersistResult> imageActionPersist(com.alibaba.sdk.android.oss.model.ImagePersistRequest imagePersistRequest, com.alibaba.sdk.android.oss.callback.OSSCompletedCallback<com.alibaba.sdk.android.oss.model.ImagePersistRequest, com.alibaba.sdk.android.oss.model.ImagePersistResult> oSSCompletedCallback) {
        com.alibaba.sdk.android.oss.internal.RequestMessage requestMessage = new com.alibaba.sdk.android.oss.internal.RequestMessage();
        java.util.LinkedHashMap linkedHashMap = new java.util.LinkedHashMap();
        linkedHashMap.put(com.alibaba.sdk.android.oss.common.RequestParameters.X_OSS_PROCESS, "");
        requestMessage.setEndpoint(this.endpoint);
        requestMessage.setMethod(com.alibaba.sdk.android.oss.common.HttpMethod.POST);
        requestMessage.setBucketName(imagePersistRequest.mFromBucket);
        requestMessage.setObjectKey(imagePersistRequest.mFromObjectkey);
        requestMessage.setParameters(linkedHashMap);
        requestMessage.setStringBody(com.alibaba.sdk.android.oss.common.utils.OSSUtils.buildImagePersistentBody(imagePersistRequest.mToBucketName, imagePersistRequest.mToObjectKey, imagePersistRequest.mAction));
        canonicalizeRequestMessage(requestMessage, imagePersistRequest);
        com.alibaba.sdk.android.oss.network.ExecutionContext executionContext = new com.alibaba.sdk.android.oss.network.ExecutionContext(getInnerClient(), imagePersistRequest, this.applicationContext);
        if (oSSCompletedCallback != null) {
            executionContext.setCompletedCallback(oSSCompletedCallback);
        }
        return com.alibaba.sdk.android.oss.internal.OSSAsyncTask.wrapRequestTask(this.executorService.submit(new com.alibaba.sdk.android.oss.network.OSSRequestTask(requestMessage, new com.alibaba.sdk.android.oss.internal.ResponseParsers.ImagePersistResponseParser(), executionContext, this.maxRetryCount)), executionContext);
    }

    public com.alibaba.sdk.android.oss.internal.OSSAsyncTask<com.alibaba.sdk.android.oss.model.InitiateMultipartUploadResult> initMultipartUpload(com.alibaba.sdk.android.oss.model.InitiateMultipartUploadRequest initiateMultipartUploadRequest, com.alibaba.sdk.android.oss.callback.OSSCompletedCallback<com.alibaba.sdk.android.oss.model.InitiateMultipartUploadRequest, com.alibaba.sdk.android.oss.model.InitiateMultipartUploadResult> oSSCompletedCallback) {
        com.alibaba.sdk.android.oss.internal.RequestMessage requestMessage = new com.alibaba.sdk.android.oss.internal.RequestMessage();
        requestMessage.setIsAuthorizationRequired(initiateMultipartUploadRequest.isAuthorizationRequired());
        requestMessage.setEndpoint(this.endpoint);
        requestMessage.setMethod(com.alibaba.sdk.android.oss.common.HttpMethod.POST);
        requestMessage.setBucketName(initiateMultipartUploadRequest.getBucketName());
        requestMessage.setObjectKey(initiateMultipartUploadRequest.getObjectKey());
        requestMessage.getParameters().put(com.alibaba.sdk.android.oss.common.RequestParameters.SUBRESOURCE_UPLOADS, "");
        if (initiateMultipartUploadRequest.isSequential) {
            requestMessage.getParameters().put(com.alibaba.sdk.android.oss.common.RequestParameters.SUBRESOURCE_SEQUENTIAL, "");
        }
        com.alibaba.sdk.android.oss.common.utils.OSSUtils.populateRequestMetadata(requestMessage.getHeaders(), initiateMultipartUploadRequest.getMetadata());
        canonicalizeRequestMessage(requestMessage, initiateMultipartUploadRequest);
        com.alibaba.sdk.android.oss.network.ExecutionContext executionContext = new com.alibaba.sdk.android.oss.network.ExecutionContext(getInnerClient(), initiateMultipartUploadRequest, this.applicationContext);
        if (oSSCompletedCallback != null) {
            executionContext.setCompletedCallback(oSSCompletedCallback);
        }
        return com.alibaba.sdk.android.oss.internal.OSSAsyncTask.wrapRequestTask(this.executorService.submit(new com.alibaba.sdk.android.oss.network.OSSRequestTask(requestMessage, new com.alibaba.sdk.android.oss.internal.ResponseParsers.InitMultipartResponseParser(), executionContext, this.maxRetryCount)), executionContext);
    }

    public com.alibaba.sdk.android.oss.internal.OSSAsyncTask<com.alibaba.sdk.android.oss.model.ListBucketsResult> listBuckets(com.alibaba.sdk.android.oss.model.ListBucketsRequest listBucketsRequest, com.alibaba.sdk.android.oss.callback.OSSCompletedCallback<com.alibaba.sdk.android.oss.model.ListBucketsRequest, com.alibaba.sdk.android.oss.model.ListBucketsResult> oSSCompletedCallback) {
        com.alibaba.sdk.android.oss.internal.RequestMessage requestMessage = new com.alibaba.sdk.android.oss.internal.RequestMessage();
        requestMessage.setIsAuthorizationRequired(listBucketsRequest.isAuthorizationRequired());
        requestMessage.setMethod(com.alibaba.sdk.android.oss.common.HttpMethod.GET);
        requestMessage.setService(this.service);
        requestMessage.setEndpoint(this.endpoint);
        canonicalizeRequestMessage(requestMessage, listBucketsRequest);
        com.alibaba.sdk.android.oss.common.utils.OSSUtils.populateListBucketRequestParameters(listBucketsRequest, requestMessage.getParameters());
        com.alibaba.sdk.android.oss.network.ExecutionContext executionContext = new com.alibaba.sdk.android.oss.network.ExecutionContext(getInnerClient(), listBucketsRequest, this.applicationContext);
        if (oSSCompletedCallback != null) {
            executionContext.setCompletedCallback(oSSCompletedCallback);
        }
        return com.alibaba.sdk.android.oss.internal.OSSAsyncTask.wrapRequestTask(this.executorService.submit(new com.alibaba.sdk.android.oss.network.OSSRequestTask(requestMessage, new com.alibaba.sdk.android.oss.internal.ResponseParsers.ListBucketResponseParser(), executionContext, this.maxRetryCount)), executionContext);
    }

    public com.alibaba.sdk.android.oss.internal.OSSAsyncTask<com.alibaba.sdk.android.oss.model.ListMultipartUploadsResult> listMultipartUploads(com.alibaba.sdk.android.oss.model.ListMultipartUploadsRequest listMultipartUploadsRequest, com.alibaba.sdk.android.oss.callback.OSSCompletedCallback<com.alibaba.sdk.android.oss.model.ListMultipartUploadsRequest, com.alibaba.sdk.android.oss.model.ListMultipartUploadsResult> oSSCompletedCallback) {
        com.alibaba.sdk.android.oss.internal.RequestMessage requestMessage = new com.alibaba.sdk.android.oss.internal.RequestMessage();
        requestMessage.setIsAuthorizationRequired(listMultipartUploadsRequest.isAuthorizationRequired());
        requestMessage.setEndpoint(this.endpoint);
        requestMessage.setMethod(com.alibaba.sdk.android.oss.common.HttpMethod.GET);
        requestMessage.setBucketName(listMultipartUploadsRequest.getBucketName());
        requestMessage.getParameters().put(com.alibaba.sdk.android.oss.common.RequestParameters.SUBRESOURCE_UPLOADS, "");
        com.alibaba.sdk.android.oss.common.utils.OSSUtils.populateListMultipartUploadsRequestParameters(listMultipartUploadsRequest, requestMessage.getParameters());
        canonicalizeRequestMessage(requestMessage, listMultipartUploadsRequest);
        com.alibaba.sdk.android.oss.network.ExecutionContext executionContext = new com.alibaba.sdk.android.oss.network.ExecutionContext(getInnerClient(), listMultipartUploadsRequest, this.applicationContext);
        if (oSSCompletedCallback != null) {
            executionContext.setCompletedCallback(oSSCompletedCallback);
        }
        return com.alibaba.sdk.android.oss.internal.OSSAsyncTask.wrapRequestTask(this.executorService.submit(new com.alibaba.sdk.android.oss.network.OSSRequestTask(requestMessage, new com.alibaba.sdk.android.oss.internal.ResponseParsers.ListMultipartUploadsResponseParser(), executionContext, this.maxRetryCount)), executionContext);
    }

    public com.alibaba.sdk.android.oss.internal.OSSAsyncTask<com.alibaba.sdk.android.oss.model.ListObjectsResult> listObjects(com.alibaba.sdk.android.oss.model.ListObjectsRequest listObjectsRequest, com.alibaba.sdk.android.oss.callback.OSSCompletedCallback<com.alibaba.sdk.android.oss.model.ListObjectsRequest, com.alibaba.sdk.android.oss.model.ListObjectsResult> oSSCompletedCallback) {
        com.alibaba.sdk.android.oss.internal.RequestMessage requestMessage = new com.alibaba.sdk.android.oss.internal.RequestMessage();
        requestMessage.setIsAuthorizationRequired(listObjectsRequest.isAuthorizationRequired());
        requestMessage.setEndpoint(this.endpoint);
        requestMessage.setMethod(com.alibaba.sdk.android.oss.common.HttpMethod.GET);
        requestMessage.setBucketName(listObjectsRequest.getBucketName());
        canonicalizeRequestMessage(requestMessage, listObjectsRequest);
        com.alibaba.sdk.android.oss.common.utils.OSSUtils.populateListObjectsRequestParameters(listObjectsRequest, requestMessage.getParameters());
        com.alibaba.sdk.android.oss.network.ExecutionContext executionContext = new com.alibaba.sdk.android.oss.network.ExecutionContext(getInnerClient(), listObjectsRequest, this.applicationContext);
        if (oSSCompletedCallback != null) {
            executionContext.setCompletedCallback(oSSCompletedCallback);
        }
        return com.alibaba.sdk.android.oss.internal.OSSAsyncTask.wrapRequestTask(this.executorService.submit(new com.alibaba.sdk.android.oss.network.OSSRequestTask(requestMessage, new com.alibaba.sdk.android.oss.internal.ResponseParsers.ListObjectsResponseParser(), executionContext, this.maxRetryCount)), executionContext);
    }

    public com.alibaba.sdk.android.oss.internal.OSSAsyncTask<com.alibaba.sdk.android.oss.model.ListPartsResult> listParts(com.alibaba.sdk.android.oss.model.ListPartsRequest listPartsRequest, com.alibaba.sdk.android.oss.callback.OSSCompletedCallback<com.alibaba.sdk.android.oss.model.ListPartsRequest, com.alibaba.sdk.android.oss.model.ListPartsResult> oSSCompletedCallback) {
        com.alibaba.sdk.android.oss.internal.RequestMessage requestMessage = new com.alibaba.sdk.android.oss.internal.RequestMessage();
        requestMessage.setIsAuthorizationRequired(listPartsRequest.isAuthorizationRequired());
        requestMessage.setEndpoint(this.endpoint);
        requestMessage.setMethod(com.alibaba.sdk.android.oss.common.HttpMethod.GET);
        requestMessage.setBucketName(listPartsRequest.getBucketName());
        requestMessage.setObjectKey(listPartsRequest.getObjectKey());
        requestMessage.getParameters().put(com.alibaba.sdk.android.oss.common.RequestParameters.UPLOAD_ID, listPartsRequest.getUploadId());
        java.lang.Integer maxParts = listPartsRequest.getMaxParts();
        if (maxParts != null) {
            if (!com.alibaba.sdk.android.oss.common.utils.OSSUtils.checkParamRange(maxParts.intValue(), 0L, true, 1000L, true)) {
                throw new java.lang.IllegalArgumentException("MaxPartsOutOfRange: 1000");
            }
            requestMessage.getParameters().put(com.alibaba.sdk.android.oss.common.RequestParameters.MAX_PARTS, maxParts.toString());
        }
        java.lang.Integer partNumberMarker = listPartsRequest.getPartNumberMarker();
        if (partNumberMarker != null) {
            if (!com.alibaba.sdk.android.oss.common.utils.OSSUtils.checkParamRange(partNumberMarker.intValue(), 0L, false, 10000L, true)) {
                throw new java.lang.IllegalArgumentException("PartNumberMarkerOutOfRange: 10000");
            }
            requestMessage.getParameters().put(com.alibaba.sdk.android.oss.common.RequestParameters.PART_NUMBER_MARKER, partNumberMarker.toString());
        }
        canonicalizeRequestMessage(requestMessage, listPartsRequest);
        com.alibaba.sdk.android.oss.network.ExecutionContext executionContext = new com.alibaba.sdk.android.oss.network.ExecutionContext(getInnerClient(), listPartsRequest, this.applicationContext);
        if (oSSCompletedCallback != null) {
            executionContext.setCompletedCallback(oSSCompletedCallback);
        }
        return com.alibaba.sdk.android.oss.internal.OSSAsyncTask.wrapRequestTask(this.executorService.submit(new com.alibaba.sdk.android.oss.network.OSSRequestTask(requestMessage, new com.alibaba.sdk.android.oss.internal.ResponseParsers.ListPartsResponseParser(), executionContext, this.maxRetryCount)), executionContext);
    }

    public com.alibaba.sdk.android.oss.internal.OSSAsyncTask<com.alibaba.sdk.android.oss.model.PutBucketLifecycleResult> putBucketLifecycle(com.alibaba.sdk.android.oss.model.PutBucketLifecycleRequest putBucketLifecycleRequest, com.alibaba.sdk.android.oss.callback.OSSCompletedCallback<com.alibaba.sdk.android.oss.model.PutBucketLifecycleRequest, com.alibaba.sdk.android.oss.model.PutBucketLifecycleResult> oSSCompletedCallback) {
        com.alibaba.sdk.android.oss.internal.RequestMessage requestMessage = new com.alibaba.sdk.android.oss.internal.RequestMessage();
        java.util.LinkedHashMap linkedHashMap = new java.util.LinkedHashMap();
        linkedHashMap.put(com.alibaba.sdk.android.oss.common.RequestParameters.SUBRESOURCE_LIFECYCLE, "");
        requestMessage.setIsAuthorizationRequired(putBucketLifecycleRequest.isAuthorizationRequired());
        requestMessage.setEndpoint(this.endpoint);
        requestMessage.setMethod(com.alibaba.sdk.android.oss.common.HttpMethod.PUT);
        requestMessage.setBucketName(putBucketLifecycleRequest.getBucketName());
        requestMessage.setParameters(linkedHashMap);
        try {
            requestMessage.putBucketLifecycleRequestBodyMarshall(putBucketLifecycleRequest.getLifecycleRules());
            canonicalizeRequestMessage(requestMessage, putBucketLifecycleRequest);
            com.alibaba.sdk.android.oss.network.ExecutionContext executionContext = new com.alibaba.sdk.android.oss.network.ExecutionContext(getInnerClient(), putBucketLifecycleRequest, this.applicationContext);
            if (oSSCompletedCallback != null) {
                executionContext.setCompletedCallback(oSSCompletedCallback);
            }
            return com.alibaba.sdk.android.oss.internal.OSSAsyncTask.wrapRequestTask(this.executorService.submit(new com.alibaba.sdk.android.oss.network.OSSRequestTask(requestMessage, new com.alibaba.sdk.android.oss.internal.ResponseParsers.PutBucketLifecycleResponseParser(), executionContext, this.maxRetryCount)), executionContext);
        } catch (java.io.UnsupportedEncodingException e) {
            e.printStackTrace();
            return null;
        }
    }

    public com.alibaba.sdk.android.oss.internal.OSSAsyncTask<com.alibaba.sdk.android.oss.model.PutBucketLoggingResult> putBucketLogging(com.alibaba.sdk.android.oss.model.PutBucketLoggingRequest putBucketLoggingRequest, com.alibaba.sdk.android.oss.callback.OSSCompletedCallback<com.alibaba.sdk.android.oss.model.PutBucketLoggingRequest, com.alibaba.sdk.android.oss.model.PutBucketLoggingResult> oSSCompletedCallback) {
        com.alibaba.sdk.android.oss.internal.RequestMessage requestMessage = new com.alibaba.sdk.android.oss.internal.RequestMessage();
        java.util.LinkedHashMap linkedHashMap = new java.util.LinkedHashMap();
        linkedHashMap.put(com.alibaba.sdk.android.oss.common.RequestParameters.SUBRESOURCE_LOGGING, "");
        requestMessage.setIsAuthorizationRequired(putBucketLoggingRequest.isAuthorizationRequired());
        requestMessage.setEndpoint(this.endpoint);
        requestMessage.setMethod(com.alibaba.sdk.android.oss.common.HttpMethod.PUT);
        requestMessage.setBucketName(putBucketLoggingRequest.getBucketName());
        requestMessage.setParameters(linkedHashMap);
        try {
            requestMessage.putBucketLoggingRequestBodyMarshall(putBucketLoggingRequest.getTargetBucketName(), putBucketLoggingRequest.getTargetPrefix());
            canonicalizeRequestMessage(requestMessage, putBucketLoggingRequest);
            com.alibaba.sdk.android.oss.network.ExecutionContext executionContext = new com.alibaba.sdk.android.oss.network.ExecutionContext(getInnerClient(), putBucketLoggingRequest, this.applicationContext);
            if (oSSCompletedCallback != null) {
                executionContext.setCompletedCallback(oSSCompletedCallback);
            }
            return com.alibaba.sdk.android.oss.internal.OSSAsyncTask.wrapRequestTask(this.executorService.submit(new com.alibaba.sdk.android.oss.network.OSSRequestTask(requestMessage, new com.alibaba.sdk.android.oss.internal.ResponseParsers.PutBucketLoggingResponseParser(), executionContext, this.maxRetryCount)), executionContext);
        } catch (java.io.UnsupportedEncodingException e) {
            e.printStackTrace();
            return null;
        }
    }

    public com.alibaba.sdk.android.oss.internal.OSSAsyncTask<com.alibaba.sdk.android.oss.model.PutBucketRefererResult> putBucketReferer(com.alibaba.sdk.android.oss.model.PutBucketRefererRequest putBucketRefererRequest, com.alibaba.sdk.android.oss.callback.OSSCompletedCallback<com.alibaba.sdk.android.oss.model.PutBucketRefererRequest, com.alibaba.sdk.android.oss.model.PutBucketRefererResult> oSSCompletedCallback) {
        com.alibaba.sdk.android.oss.internal.RequestMessage requestMessage = new com.alibaba.sdk.android.oss.internal.RequestMessage();
        java.util.LinkedHashMap linkedHashMap = new java.util.LinkedHashMap();
        linkedHashMap.put(com.alibaba.sdk.android.oss.common.RequestParameters.SUBRESOURCE_REFERER, "");
        requestMessage.setIsAuthorizationRequired(putBucketRefererRequest.isAuthorizationRequired());
        requestMessage.setEndpoint(this.endpoint);
        requestMessage.setMethod(com.alibaba.sdk.android.oss.common.HttpMethod.PUT);
        requestMessage.setBucketName(putBucketRefererRequest.getBucketName());
        requestMessage.setParameters(linkedHashMap);
        try {
            requestMessage.putBucketRefererRequestBodyMarshall(putBucketRefererRequest.getReferers(), putBucketRefererRequest.isAllowEmpty());
            canonicalizeRequestMessage(requestMessage, putBucketRefererRequest);
            com.alibaba.sdk.android.oss.network.ExecutionContext executionContext = new com.alibaba.sdk.android.oss.network.ExecutionContext(getInnerClient(), putBucketRefererRequest, this.applicationContext);
            if (oSSCompletedCallback != null) {
                executionContext.setCompletedCallback(oSSCompletedCallback);
            }
            return com.alibaba.sdk.android.oss.internal.OSSAsyncTask.wrapRequestTask(this.executorService.submit(new com.alibaba.sdk.android.oss.network.OSSRequestTask(requestMessage, new com.alibaba.sdk.android.oss.internal.ResponseParsers.PutBucketRefererResponseParser(), executionContext, this.maxRetryCount)), executionContext);
        } catch (java.io.UnsupportedEncodingException e) {
            e.printStackTrace();
            return null;
        }
    }

    public com.alibaba.sdk.android.oss.internal.OSSAsyncTask<com.alibaba.sdk.android.oss.model.PutObjectResult> putObject(com.alibaba.sdk.android.oss.model.PutObjectRequest putObjectRequest, com.alibaba.sdk.android.oss.callback.OSSCompletedCallback<com.alibaba.sdk.android.oss.model.PutObjectRequest, com.alibaba.sdk.android.oss.model.PutObjectResult> oSSCompletedCallback) {
        com.alibaba.sdk.android.oss.common.OSSLog.logDebug(" Internal putObject Start ");
        com.alibaba.sdk.android.oss.internal.RequestMessage requestMessage = new com.alibaba.sdk.android.oss.internal.RequestMessage();
        requestMessage.setIsAuthorizationRequired(putObjectRequest.isAuthorizationRequired());
        requestMessage.setEndpoint(this.endpoint);
        requestMessage.setMethod(com.alibaba.sdk.android.oss.common.HttpMethod.PUT);
        requestMessage.setBucketName(putObjectRequest.getBucketName());
        requestMessage.setObjectKey(putObjectRequest.getObjectKey());
        if (putObjectRequest.getUploadData() != null) {
            requestMessage.setUploadData(putObjectRequest.getUploadData());
        }
        if (putObjectRequest.getUploadFilePath() != null) {
            requestMessage.setUploadFilePath(putObjectRequest.getUploadFilePath());
        }
        if (putObjectRequest.getUploadUri() != null) {
            requestMessage.setUploadUri(putObjectRequest.getUploadUri());
        }
        if (putObjectRequest.getCallbackParam() != null) {
            requestMessage.getHeaders().put("x-oss-callback", com.alibaba.sdk.android.oss.common.utils.OSSUtils.populateMapToBase64JsonString(putObjectRequest.getCallbackParam()));
        }
        if (putObjectRequest.getCallbackVars() != null) {
            requestMessage.getHeaders().put("x-oss-callback-var", com.alibaba.sdk.android.oss.common.utils.OSSUtils.populateMapToBase64JsonString(putObjectRequest.getCallbackVars()));
        }
        com.alibaba.sdk.android.oss.common.OSSLog.logDebug(" populateRequestMetadata ");
        com.alibaba.sdk.android.oss.common.utils.OSSUtils.populateRequestMetadata(requestMessage.getHeaders(), putObjectRequest.getMetadata());
        com.alibaba.sdk.android.oss.common.OSSLog.logDebug(" canonicalizeRequestMessage ");
        canonicalizeRequestMessage(requestMessage, putObjectRequest);
        com.alibaba.sdk.android.oss.common.OSSLog.logDebug(" ExecutionContext ");
        com.alibaba.sdk.android.oss.network.ExecutionContext executionContext = new com.alibaba.sdk.android.oss.network.ExecutionContext(getInnerClient(), putObjectRequest, this.applicationContext);
        if (oSSCompletedCallback != null) {
            executionContext.setCompletedCallback(new com.alibaba.sdk.android.oss.internal.InternalRequestOperation.AnonymousClass3(oSSCompletedCallback));
        }
        if (putObjectRequest.getRetryCallback() != null) {
            executionContext.setRetryCallback(putObjectRequest.getRetryCallback());
        }
        executionContext.setProgressCallback(putObjectRequest.getProgressCallback());
        com.alibaba.sdk.android.oss.network.OSSRequestTask oSSRequestTask = new com.alibaba.sdk.android.oss.network.OSSRequestTask(requestMessage, new com.alibaba.sdk.android.oss.internal.ResponseParsers.PutObjectResponseParser(), executionContext, this.maxRetryCount);
        com.alibaba.sdk.android.oss.common.OSSLog.logDebug(" call OSSRequestTask ");
        return com.alibaba.sdk.android.oss.internal.OSSAsyncTask.wrapRequestTask(this.executorService.submit(oSSRequestTask), executionContext);
    }

    public com.alibaba.sdk.android.oss.internal.OSSAsyncTask<com.alibaba.sdk.android.oss.model.PutObjectTaggingResult> putObjectTagging(com.alibaba.sdk.android.oss.model.PutObjectTaggingRequest putObjectTaggingRequest, com.alibaba.sdk.android.oss.callback.OSSCompletedCallback<com.alibaba.sdk.android.oss.model.PutObjectTaggingRequest, com.alibaba.sdk.android.oss.model.PutObjectTaggingResult> oSSCompletedCallback) {
        com.alibaba.sdk.android.oss.internal.RequestMessage requestMessage = new com.alibaba.sdk.android.oss.internal.RequestMessage();
        java.util.LinkedHashMap linkedHashMap = new java.util.LinkedHashMap();
        linkedHashMap.put(com.alibaba.sdk.android.oss.common.RequestParameters.X_OSS_TAGGING, "");
        requestMessage.setIsAuthorizationRequired(putObjectTaggingRequest.isAuthorizationRequired());
        requestMessage.setEndpoint(this.endpoint);
        requestMessage.setMethod(com.alibaba.sdk.android.oss.common.HttpMethod.PUT);
        requestMessage.setBucketName(putObjectTaggingRequest.getBucketName());
        requestMessage.setObjectKey(putObjectTaggingRequest.getObjectKey());
        requestMessage.setParameters(linkedHashMap);
        try {
            byte[] putObjectTaggingRequestBodyMarshall = requestMessage.putObjectTaggingRequestBodyMarshall(putObjectTaggingRequest.getTags());
            if (putObjectTaggingRequestBodyMarshall != null && putObjectTaggingRequestBodyMarshall.length > 0) {
                requestMessage.getHeaders().put("Content-MD5", com.alibaba.sdk.android.oss.common.utils.BinaryUtil.calculateBase64Md5(putObjectTaggingRequestBodyMarshall));
                requestMessage.getHeaders().put("Content-Length", java.lang.String.valueOf(putObjectTaggingRequestBodyMarshall.length));
            }
            canonicalizeRequestMessage(requestMessage, putObjectTaggingRequest);
            com.alibaba.sdk.android.oss.network.ExecutionContext executionContext = new com.alibaba.sdk.android.oss.network.ExecutionContext(getInnerClient(), putObjectTaggingRequest, this.applicationContext);
            if (oSSCompletedCallback != null) {
                executionContext.setCompletedCallback(oSSCompletedCallback);
            }
            return com.alibaba.sdk.android.oss.internal.OSSAsyncTask.wrapRequestTask(this.executorService.submit(new com.alibaba.sdk.android.oss.network.OSSRequestTask(requestMessage, new com.alibaba.sdk.android.oss.internal.ResponseParsers.PutObjectTaggingResponseParser(), executionContext, this.maxRetryCount)), executionContext);
        } catch (java.io.UnsupportedEncodingException e) {
            e.printStackTrace();
            if (oSSCompletedCallback != null) {
                oSSCompletedCallback.onFailure(putObjectTaggingRequest, new com.alibaba.sdk.android.oss.ClientException(e.getMessage(), e), null);
            }
            return com.alibaba.sdk.android.oss.internal.OSSAsyncTask.wrapRequestTask(this.executorService.submit(new com.alibaba.sdk.android.oss.internal.InternalRequestOperation.AnonymousClass7(e)), null);
        }
    }

    public com.alibaba.sdk.android.oss.internal.OSSAsyncTask<com.alibaba.sdk.android.oss.model.PutSymlinkResult> putSymlink(com.alibaba.sdk.android.oss.model.PutSymlinkRequest putSymlinkRequest, com.alibaba.sdk.android.oss.callback.OSSCompletedCallback<com.alibaba.sdk.android.oss.model.PutSymlinkRequest, com.alibaba.sdk.android.oss.model.PutSymlinkResult> oSSCompletedCallback) {
        com.alibaba.sdk.android.oss.internal.RequestMessage requestMessage = new com.alibaba.sdk.android.oss.internal.RequestMessage();
        java.util.LinkedHashMap linkedHashMap = new java.util.LinkedHashMap();
        linkedHashMap.put(com.alibaba.sdk.android.oss.common.RequestParameters.X_OSS_SYMLINK, "");
        requestMessage.setEndpoint(this.endpoint);
        requestMessage.setMethod(com.alibaba.sdk.android.oss.common.HttpMethod.PUT);
        requestMessage.setBucketName(putSymlinkRequest.getBucketName());
        requestMessage.setObjectKey(putSymlinkRequest.getObjectKey());
        requestMessage.setParameters(linkedHashMap);
        if (!com.alibaba.sdk.android.oss.common.utils.OSSUtils.isEmptyString(putSymlinkRequest.getTargetObjectName())) {
            requestMessage.getHeaders().put(com.alibaba.sdk.android.oss.common.OSSHeaders.OSS_HEADER_SYMLINK_TARGET, com.alibaba.sdk.android.oss.common.utils.HttpUtil.urlEncode(putSymlinkRequest.getTargetObjectName(), "utf-8"));
        }
        com.alibaba.sdk.android.oss.common.utils.OSSUtils.populateRequestMetadata(requestMessage.getHeaders(), putSymlinkRequest.getMetadata());
        canonicalizeRequestMessage(requestMessage, putSymlinkRequest);
        com.alibaba.sdk.android.oss.network.ExecutionContext executionContext = new com.alibaba.sdk.android.oss.network.ExecutionContext(getInnerClient(), putSymlinkRequest, this.applicationContext);
        if (oSSCompletedCallback != null) {
            executionContext.setCompletedCallback(oSSCompletedCallback);
        }
        return com.alibaba.sdk.android.oss.internal.OSSAsyncTask.wrapRequestTask(this.executorService.submit(new com.alibaba.sdk.android.oss.network.OSSRequestTask(requestMessage, new com.alibaba.sdk.android.oss.internal.ResponseParsers.PutSymlinkResponseParser(), executionContext, this.maxRetryCount)), executionContext);
    }

    public com.alibaba.sdk.android.oss.internal.OSSAsyncTask<com.alibaba.sdk.android.oss.model.RestoreObjectResult> restoreObject(com.alibaba.sdk.android.oss.model.RestoreObjectRequest restoreObjectRequest, com.alibaba.sdk.android.oss.callback.OSSCompletedCallback<com.alibaba.sdk.android.oss.model.RestoreObjectRequest, com.alibaba.sdk.android.oss.model.RestoreObjectResult> oSSCompletedCallback) {
        com.alibaba.sdk.android.oss.internal.RequestMessage requestMessage = new com.alibaba.sdk.android.oss.internal.RequestMessage();
        java.util.LinkedHashMap linkedHashMap = new java.util.LinkedHashMap();
        linkedHashMap.put(com.alibaba.sdk.android.oss.common.RequestParameters.X_OSS_RESTORE, "");
        requestMessage.setEndpoint(this.endpoint);
        requestMessage.setMethod(com.alibaba.sdk.android.oss.common.HttpMethod.POST);
        requestMessage.setBucketName(restoreObjectRequest.getBucketName());
        requestMessage.setObjectKey(restoreObjectRequest.getObjectKey());
        requestMessage.setParameters(linkedHashMap);
        canonicalizeRequestMessage(requestMessage, restoreObjectRequest);
        com.alibaba.sdk.android.oss.network.ExecutionContext executionContext = new com.alibaba.sdk.android.oss.network.ExecutionContext(getInnerClient(), restoreObjectRequest, this.applicationContext);
        if (oSSCompletedCallback != null) {
            executionContext.setCompletedCallback(oSSCompletedCallback);
        }
        return com.alibaba.sdk.android.oss.internal.OSSAsyncTask.wrapRequestTask(this.executorService.submit(new com.alibaba.sdk.android.oss.network.OSSRequestTask(requestMessage, new com.alibaba.sdk.android.oss.internal.ResponseParsers.RestoreObjectResponseParser(), executionContext, this.maxRetryCount)), executionContext);
    }

    public void setCloudBoxId(java.lang.String str) {
        this.cloudBoxId = str;
    }

    public void setCredentialProvider(com.alibaba.sdk.android.oss.common.auth.OSSCredentialProvider oSSCredentialProvider) {
        this.credentialProvider = oSSCredentialProvider;
    }

    public void setProduct(java.lang.String str) {
        this.product = str;
    }

    public void setRegion(java.lang.String str) {
        this.region = str;
    }

    public com.alibaba.sdk.android.oss.model.AppendObjectResult syncAppendObject(com.alibaba.sdk.android.oss.model.AppendObjectRequest appendObjectRequest) throws com.alibaba.sdk.android.oss.ClientException, com.alibaba.sdk.android.oss.ServiceException {
        com.alibaba.sdk.android.oss.model.AppendObjectResult result = appendObject(appendObjectRequest, null).getResult();
        boolean z = appendObjectRequest.getCRC64() == com.alibaba.sdk.android.oss.model.OSSRequest.CRC64Config.YES;
        if (appendObjectRequest.getInitCRC64() != null && z) {
            result.setClientCRC(java.lang.Long.valueOf(com.alibaba.sdk.android.oss.common.utils.CRC64.combine(appendObjectRequest.getInitCRC64().longValue(), result.getClientCRC().longValue(), result.getNextPosition() - appendObjectRequest.getPosition())));
        }
        checkCRC64(appendObjectRequest, result);
        return result;
    }

    public com.alibaba.sdk.android.oss.model.CompleteMultipartUploadResult syncCompleteMultipartUpload(com.alibaba.sdk.android.oss.model.CompleteMultipartUploadRequest completeMultipartUploadRequest) throws com.alibaba.sdk.android.oss.ClientException, com.alibaba.sdk.android.oss.ServiceException {
        com.alibaba.sdk.android.oss.model.CompleteMultipartUploadResult result = completeMultipartUpload(completeMultipartUploadRequest, null).getResult();
        if (result.getServerCRC() != null) {
            result.setClientCRC(java.lang.Long.valueOf(calcObjectCRCFromParts(completeMultipartUploadRequest.getPartETags())));
        }
        checkCRC64(completeMultipartUploadRequest, result);
        return result;
    }

    public com.alibaba.sdk.android.oss.model.DeleteObjectTaggingResult syncDeleteObjectTagging(com.alibaba.sdk.android.oss.model.DeleteObjectTaggingRequest deleteObjectTaggingRequest) throws com.alibaba.sdk.android.oss.ClientException, com.alibaba.sdk.android.oss.ServiceException {
        return deleteObjectTagging(deleteObjectTaggingRequest, null).getResult();
    }

    public com.alibaba.sdk.android.oss.model.GetObjectTaggingResult syncGetObjectTagging(com.alibaba.sdk.android.oss.model.GetObjectTaggingRequest getObjectTaggingRequest) throws com.alibaba.sdk.android.oss.ClientException, com.alibaba.sdk.android.oss.ServiceException {
        return getObjectTagging(getObjectTaggingRequest, null).getResult();
    }

    public com.alibaba.sdk.android.oss.model.GetSymlinkResult syncGetSymlink(com.alibaba.sdk.android.oss.model.GetSymlinkRequest getSymlinkRequest) throws com.alibaba.sdk.android.oss.ClientException, com.alibaba.sdk.android.oss.ServiceException {
        return getSymlink(getSymlinkRequest, null).getResult();
    }

    public com.alibaba.sdk.android.oss.model.PutObjectResult syncPutObject(com.alibaba.sdk.android.oss.model.PutObjectRequest putObjectRequest) throws com.alibaba.sdk.android.oss.ClientException, com.alibaba.sdk.android.oss.ServiceException {
        com.alibaba.sdk.android.oss.model.PutObjectResult result = putObject(putObjectRequest, null).getResult();
        checkCRC64(putObjectRequest, result);
        return result;
    }

    public com.alibaba.sdk.android.oss.model.PutObjectTaggingResult syncPutObjectTagging(com.alibaba.sdk.android.oss.model.PutObjectTaggingRequest putObjectTaggingRequest) throws com.alibaba.sdk.android.oss.ClientException, com.alibaba.sdk.android.oss.ServiceException {
        return putObjectTagging(putObjectTaggingRequest, null).getResult();
    }

    public com.alibaba.sdk.android.oss.model.PutSymlinkResult syncPutSymlink(com.alibaba.sdk.android.oss.model.PutSymlinkRequest putSymlinkRequest) throws com.alibaba.sdk.android.oss.ClientException, com.alibaba.sdk.android.oss.ServiceException {
        return putSymlink(putSymlinkRequest, null).getResult();
    }

    public com.alibaba.sdk.android.oss.model.RestoreObjectResult syncRestoreObject(com.alibaba.sdk.android.oss.model.RestoreObjectRequest restoreObjectRequest) throws com.alibaba.sdk.android.oss.ClientException, com.alibaba.sdk.android.oss.ServiceException {
        return restoreObject(restoreObjectRequest, null).getResult();
    }

    public com.alibaba.sdk.android.oss.model.UploadPartResult syncUploadPart(com.alibaba.sdk.android.oss.model.UploadPartRequest uploadPartRequest) throws com.alibaba.sdk.android.oss.ClientException, com.alibaba.sdk.android.oss.ServiceException {
        com.alibaba.sdk.android.oss.model.UploadPartResult result = uploadPart(uploadPartRequest, null).getResult();
        checkCRC64(uploadPartRequest, result);
        return result;
    }

    public com.alibaba.sdk.android.oss.internal.OSSAsyncTask<com.alibaba.sdk.android.oss.model.TriggerCallbackResult> triggerCallback(com.alibaba.sdk.android.oss.model.TriggerCallbackRequest triggerCallbackRequest, com.alibaba.sdk.android.oss.callback.OSSCompletedCallback<com.alibaba.sdk.android.oss.model.TriggerCallbackRequest, com.alibaba.sdk.android.oss.model.TriggerCallbackResult> oSSCompletedCallback) {
        com.alibaba.sdk.android.oss.internal.RequestMessage requestMessage = new com.alibaba.sdk.android.oss.internal.RequestMessage();
        java.util.LinkedHashMap linkedHashMap = new java.util.LinkedHashMap();
        linkedHashMap.put(com.alibaba.sdk.android.oss.common.RequestParameters.X_OSS_PROCESS, "");
        requestMessage.setEndpoint(this.endpoint);
        requestMessage.setMethod(com.alibaba.sdk.android.oss.common.HttpMethod.POST);
        requestMessage.setBucketName(triggerCallbackRequest.getBucketName());
        requestMessage.setObjectKey(triggerCallbackRequest.getObjectKey());
        requestMessage.setParameters(linkedHashMap);
        java.lang.String buildTriggerCallbackBody = com.alibaba.sdk.android.oss.common.utils.OSSUtils.buildTriggerCallbackBody(triggerCallbackRequest.getCallbackParam(), triggerCallbackRequest.getCallbackVars());
        requestMessage.setStringBody(buildTriggerCallbackBody);
        requestMessage.getHeaders().put("Content-MD5", com.alibaba.sdk.android.oss.common.utils.BinaryUtil.calculateBase64Md5(buildTriggerCallbackBody.getBytes()));
        canonicalizeRequestMessage(requestMessage, triggerCallbackRequest);
        com.alibaba.sdk.android.oss.network.ExecutionContext executionContext = new com.alibaba.sdk.android.oss.network.ExecutionContext(getInnerClient(), triggerCallbackRequest, this.applicationContext);
        if (oSSCompletedCallback != null) {
            executionContext.setCompletedCallback(oSSCompletedCallback);
        }
        return com.alibaba.sdk.android.oss.internal.OSSAsyncTask.wrapRequestTask(this.executorService.submit(new com.alibaba.sdk.android.oss.network.OSSRequestTask(requestMessage, new com.alibaba.sdk.android.oss.internal.ResponseParsers.TriggerCallbackResponseParser(), executionContext, this.maxRetryCount)), executionContext);
    }

    public com.alibaba.sdk.android.oss.internal.OSSAsyncTask<com.alibaba.sdk.android.oss.model.UploadPartResult> uploadPart(com.alibaba.sdk.android.oss.model.UploadPartRequest uploadPartRequest, com.alibaba.sdk.android.oss.callback.OSSCompletedCallback<com.alibaba.sdk.android.oss.model.UploadPartRequest, com.alibaba.sdk.android.oss.model.UploadPartResult> oSSCompletedCallback) {
        com.alibaba.sdk.android.oss.internal.RequestMessage requestMessage = new com.alibaba.sdk.android.oss.internal.RequestMessage();
        requestMessage.setIsAuthorizationRequired(uploadPartRequest.isAuthorizationRequired());
        requestMessage.setEndpoint(this.endpoint);
        requestMessage.setMethod(com.alibaba.sdk.android.oss.common.HttpMethod.PUT);
        requestMessage.setBucketName(uploadPartRequest.getBucketName());
        requestMessage.setObjectKey(uploadPartRequest.getObjectKey());
        requestMessage.getParameters().put(com.alibaba.sdk.android.oss.common.RequestParameters.UPLOAD_ID, uploadPartRequest.getUploadId());
        requestMessage.getParameters().put(com.alibaba.sdk.android.oss.common.RequestParameters.PART_NUMBER, java.lang.String.valueOf(uploadPartRequest.getPartNumber()));
        requestMessage.setUploadData(uploadPartRequest.getPartContent());
        if (uploadPartRequest.getMd5Digest() != null) {
            requestMessage.getHeaders().put("Content-MD5", uploadPartRequest.getMd5Digest());
        }
        canonicalizeRequestMessage(requestMessage, uploadPartRequest);
        com.alibaba.sdk.android.oss.network.ExecutionContext executionContext = new com.alibaba.sdk.android.oss.network.ExecutionContext(getInnerClient(), uploadPartRequest, this.applicationContext);
        if (oSSCompletedCallback != null) {
            executionContext.setCompletedCallback(new com.alibaba.sdk.android.oss.internal.InternalRequestOperation.AnonymousClass5(oSSCompletedCallback));
        }
        executionContext.setProgressCallback(uploadPartRequest.getProgressCallback());
        return com.alibaba.sdk.android.oss.internal.OSSAsyncTask.wrapRequestTask(this.executorService.submit(new com.alibaba.sdk.android.oss.network.OSSRequestTask(requestMessage, new com.alibaba.sdk.android.oss.internal.ResponseParsers.UploadPartResponseParser(), executionContext, this.maxRetryCount)), executionContext);
    }
}
