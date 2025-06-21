package com.bytedance.android.live.base.api.outer;

/* loaded from: classes.dex */
public interface ILivePreviewLayout {

    public static class Builder {
        private android.content.Context context;
        private com.bytedance.android.live.base.api.ILiveBorderAnimController liveBorderAnimController = null;
        private final android.os.Bundle arguments = new android.os.Bundle();
        private boolean showTopList = false;
        private boolean showTopListAtOnce = false;
        private boolean enablePullToRefresh = true;
        private boolean smoothEnterEnable = false;
        private boolean autoEnterEnable = false;
        private boolean canShowDislike = true;

        public Builder() {
        }

        public Builder(android.content.Context context) {
            this.context = context;
        }

        public android.os.Bundle getArguments() {
            return this.arguments;
        }

        public android.content.Context getContext() {
            return this.context;
        }

        public com.bytedance.android.live.base.api.ILiveBorderAnimController getLiveBorderAnimController() {
            return this.liveBorderAnimController;
        }

        public boolean isAutoEnterEnable() {
            return this.autoEnterEnable;
        }

        public boolean isCanShowDislike() {
            return this.canShowDislike;
        }

        public boolean isEnablePullToRefresh() {
            return this.enablePullToRefresh;
        }

        public boolean isShowTopList() {
            return this.showTopList;
        }

        public boolean isShowTopListAtOnce() {
            return this.showTopListAtOnce;
        }

        public boolean isSmoothEnterEnable() {
            return this.smoothEnterEnable;
        }

        public com.bytedance.android.live.base.api.outer.ILivePreviewLayout.Builder setArguments(android.os.Bundle bundle) {
            if (bundle != null) {
                this.arguments.putAll(bundle);
            }
            return this;
        }

        public com.bytedance.android.live.base.api.outer.ILivePreviewLayout.Builder setAutoEnterEnable(boolean z) {
            this.autoEnterEnable = z;
            return this;
        }

        public com.bytedance.android.live.base.api.outer.ILivePreviewLayout.Builder setCanShowDislike(boolean z) {
            this.canShowDislike = z;
            return this;
        }

        public com.bytedance.android.live.base.api.outer.ILivePreviewLayout.Builder setContext(android.content.Context context) {
            this.context = context;
            return this;
        }

        public com.bytedance.android.live.base.api.outer.ILivePreviewLayout.Builder setEnablePullToRefresh(boolean z) {
            this.enablePullToRefresh = z;
            return this;
        }

        public com.bytedance.android.live.base.api.outer.ILivePreviewLayout.Builder setLiveBorderAnimController(com.bytedance.android.live.base.api.ILiveBorderAnimController iLiveBorderAnimController) {
            this.liveBorderAnimController = iLiveBorderAnimController;
            return this;
        }

        public com.bytedance.android.live.base.api.outer.ILivePreviewLayout.Builder setShowTopList(boolean z) {
            this.showTopList = z;
            return this;
        }

        public com.bytedance.android.live.base.api.outer.ILivePreviewLayout.Builder setShowTopListAtOnce(boolean z) {
            this.showTopListAtOnce = z;
            return this;
        }

        public com.bytedance.android.live.base.api.outer.ILivePreviewLayout.Builder setSmoothEnterEnable(boolean z) {
            this.smoothEnterEnable = z;
            return this;
        }
    }

    public interface OnRefreshListener {
        void onError(java.lang.String str);

        void onSuccess();
    }

    android.view.View getView();

    void onPlay();

    void onPullRefresh();

    void onRelease();

    void onStop();

    void setRefreshListener(com.bytedance.android.live.base.api.outer.ILivePreviewLayout.OnRefreshListener onRefreshListener);
}
