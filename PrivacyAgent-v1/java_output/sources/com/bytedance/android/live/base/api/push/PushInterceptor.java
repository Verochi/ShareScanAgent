package com.bytedance.android.live.base.api.push;

/* loaded from: classes.dex */
public interface PushInterceptor {

    public static class InterceptResult {
        public boolean intercept;
        public java.lang.String interceptReason;

        public InterceptResult() {
        }

        public InterceptResult(boolean z) {
            this(z, "");
        }

        public InterceptResult(boolean z, java.lang.String str) {
            this.intercept = z;
            this.interceptReason = "";
        }
    }

    com.bytedance.android.live.base.api.push.PushInterceptor.InterceptResult intercept();
}
