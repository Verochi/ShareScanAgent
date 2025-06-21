package com.huawei.hms.support.api.client;

/* loaded from: classes22.dex */
public final class PendingResultsCreator {

    public static class DiscardedPendingResult<R extends com.huawei.hms.support.api.client.Result> extends com.huawei.hms.support.api.client.EmptyPendingResult {
        public DiscardedPendingResult() {
        }

        public DiscardedPendingResult(R r) {
            setResult(r);
        }

        @Override // com.huawei.hms.support.api.client.EmptyPendingResult, com.huawei.hms.support.api.client.PendingResult
        public boolean isCanceled() {
            return true;
        }
    }

    public static class InstantPendingResult<R extends com.huawei.hms.support.api.client.Result> extends com.huawei.hms.support.api.client.EmptyPendingResult {
        public InstantPendingResult(R r) {
            setResult(r);
        }

        @Override // com.huawei.hms.support.api.client.EmptyPendingResult, com.huawei.hms.support.api.client.PendingResult
        public void cancel() {
            throw new java.lang.IllegalStateException("cancel() is not available.");
        }

        @Override // com.huawei.hms.support.api.client.EmptyPendingResult, com.huawei.hms.support.api.client.PendingResult
        public void setResultCallback(com.huawei.hms.support.api.client.ResultCallback resultCallback) {
            resultCallback.onResult(getResult());
        }
    }

    public static com.huawei.hms.support.api.client.PendingResult<com.huawei.hms.support.api.client.Status> discardedPendingResult() {
        return new com.huawei.hms.support.api.client.PendingResultsCreator.DiscardedPendingResult();
    }

    public static <R extends com.huawei.hms.support.api.client.Result> com.huawei.hms.support.api.client.PendingResult<R> discardedPendingResult(R r) {
        return new com.huawei.hms.support.api.client.PendingResultsCreator.DiscardedPendingResult(r);
    }

    public static <R extends com.huawei.hms.support.api.client.Result> com.huawei.hms.common.api.OptionalPendingResult<R> instantPendingResult(R r) {
        return new com.huawei.hms.common.api.internal.OptionalPendingResultImpl(new com.huawei.hms.support.api.client.PendingResultsCreator.InstantPendingResult(r));
    }

    public static com.huawei.hms.support.api.client.PendingResult<com.huawei.hms.support.api.client.Status> instantPendingResult(com.huawei.hms.support.api.client.Status status) {
        return new com.huawei.hms.support.api.client.PendingResultsCreator.InstantPendingResult(status);
    }
}
