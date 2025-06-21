package com.alibaba.sdk.android.oss.network;

/* loaded from: classes.dex */
public class NetworkProgressHelper {

    /* renamed from: com.alibaba.sdk.android.oss.network.NetworkProgressHelper$1, reason: invalid class name */
    public static class AnonymousClass1 implements okhttp3.Interceptor {
        final /* synthetic */ com.alibaba.sdk.android.oss.network.ExecutionContext val$context;

        public AnonymousClass1(com.alibaba.sdk.android.oss.network.ExecutionContext executionContext) {
            this.val$context = executionContext;
        }

        @Override // okhttp3.Interceptor
        public okhttp3.Response intercept(okhttp3.Interceptor.Chain chain) throws java.io.IOException {
            okhttp3.Response proceed = chain.proceed(chain.request());
            return proceed.newBuilder().body(new com.alibaba.sdk.android.oss.network.ProgressTouchableResponseBody(proceed.body(), this.val$context)).build();
        }
    }

    public static com.alibaba.sdk.android.oss.network.ProgressTouchableRequestBody addProgressRequestBody(java.io.InputStream inputStream, long j, java.lang.String str, com.alibaba.sdk.android.oss.network.ExecutionContext executionContext) {
        return new com.alibaba.sdk.android.oss.network.ProgressTouchableRequestBody(inputStream, j, str, executionContext);
    }

    public static okhttp3.OkHttpClient addProgressResponseListener(okhttp3.OkHttpClient okHttpClient, com.alibaba.sdk.android.oss.network.ExecutionContext executionContext) {
        return okHttpClient.newBuilder().addNetworkInterceptor(new com.alibaba.sdk.android.oss.network.NetworkProgressHelper.AnonymousClass1(executionContext)).build();
    }
}
