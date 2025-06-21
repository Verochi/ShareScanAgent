package com.huawei.hms.api;

/* loaded from: classes22.dex */
public abstract class HuaweiApiClient implements com.huawei.hms.support.api.client.AidlApiClient {

    public static final class Builder {
        private final android.content.Context a;
        private final java.util.List<com.huawei.hms.support.api.entity.auth.Scope> b = new java.util.ArrayList();
        private final java.util.List<com.huawei.hms.support.api.entity.auth.PermissionInfo> c = new java.util.ArrayList();
        private final java.util.Map<com.huawei.hms.api.Api<?>, com.huawei.hms.api.Api.ApiOptions> d = new java.util.HashMap();
        private com.huawei.hms.api.HuaweiApiClient.OnConnectionFailedListener e;
        private com.huawei.hms.api.HuaweiApiClient.ConnectionCallbacks f;
        private int g;
        private android.app.Activity h;

        public Builder(android.content.Context context) throws java.lang.NullPointerException {
            com.huawei.hms.utils.Checker.checkNonNull(context, "context must not be null.");
            android.content.Context applicationContext = context.getApplicationContext();
            this.a = applicationContext;
            this.g = -1;
            com.huawei.hms.utils.ResourceLoaderUtil.setmContext(applicationContext);
            a(context);
        }

        private void a(android.content.Context context) {
            com.huawei.hms.utils.HMSBIInitializer.getInstance(context).initBI();
        }

        private void a(com.huawei.hms.api.HuaweiApiClient huaweiApiClient) {
            com.huawei.hms.common.internal.AutoLifecycleFragment.getInstance(this.h).startAutoMange(this.g, huaweiApiClient);
        }

        public com.huawei.hms.api.HuaweiApiClient.Builder addApi(com.huawei.hms.api.Api<? extends com.huawei.hms.api.Api.ApiOptions.NotRequiredOptions> api) {
            this.d.put(api, null);
            if (com.huawei.hms.api.HuaweiApiAvailability.HMS_API_NAME_GAME.equals(api.getApiName())) {
                com.huawei.hms.support.hianalytics.HiAnalyticsUtil.getInstance().onEvent(this.a.getApplicationContext(), com.huawei.hms.support.hianalytics.HiAnalyticsConstant.KeyAndValue.GAME_INIT_KEY, "|" + java.lang.System.currentTimeMillis());
            }
            return this;
        }

        public <O extends com.huawei.hms.api.Api.ApiOptions.HasOptions> com.huawei.hms.api.HuaweiApiClient.Builder addApi(com.huawei.hms.api.Api<O> api, O o) {
            com.huawei.hms.utils.Checker.checkNonNull(api, "Api must not be null");
            com.huawei.hms.utils.Checker.checkNonNull(o, "Null options are not permitted for this Api");
            this.d.put(api, o);
            if (api.getOptions() != null) {
                this.b.addAll(api.getOptions().getScopeList(o));
                this.c.addAll(api.getOptions().getPermissionInfoList(o));
            }
            return this;
        }

        public <O extends com.huawei.hms.api.Api.ApiOptions.HasOptions> com.huawei.hms.api.HuaweiApiClient.Builder addApiWithScope(com.huawei.hms.api.Api<O> api, O o, com.huawei.hms.support.api.entity.auth.Scope... scopeArr) {
            com.huawei.hms.utils.Checker.checkNonNull(api, "Api must not be null");
            com.huawei.hms.utils.Checker.checkNonNull(o, "Null options are not permitted for this Api");
            com.huawei.hms.utils.Checker.checkNonNull(scopeArr, "Scopes must not be null");
            this.d.put(api, o);
            if (api.getOptions() != null) {
                this.b.addAll(api.getOptions().getScopeList(o));
                this.c.addAll(api.getOptions().getPermissionInfoList(o));
            }
            this.b.addAll(new java.util.ArrayList(java.util.Arrays.asList(scopeArr)));
            return this;
        }

        public com.huawei.hms.api.HuaweiApiClient.Builder addApiWithScope(com.huawei.hms.api.Api<? extends com.huawei.hms.api.Api.ApiOptions.NotRequiredOptions> api, com.huawei.hms.support.api.entity.auth.Scope... scopeArr) {
            com.huawei.hms.utils.Checker.checkNonNull(api, "Api must not be null");
            com.huawei.hms.utils.Checker.checkNonNull(scopeArr, "Scopes must not be null");
            this.d.put(api, null);
            this.b.addAll(new java.util.ArrayList(java.util.Arrays.asList(scopeArr)));
            return this;
        }

        public com.huawei.hms.api.HuaweiApiClient.Builder addConnectionCallbacks(com.huawei.hms.api.HuaweiApiClient.ConnectionCallbacks connectionCallbacks) {
            com.huawei.hms.utils.Checker.checkNonNull(connectionCallbacks, "listener must not be null.");
            this.f = connectionCallbacks;
            return this;
        }

        public com.huawei.hms.api.HuaweiApiClient.Builder addOnConnectionFailedListener(com.huawei.hms.api.HuaweiApiClient.OnConnectionFailedListener onConnectionFailedListener) {
            com.huawei.hms.utils.Checker.checkNonNull(onConnectionFailedListener, "listener must not be null.");
            this.e = onConnectionFailedListener;
            return this;
        }

        public com.huawei.hms.api.HuaweiApiClient.Builder addScope(com.huawei.hms.support.api.entity.auth.Scope scope) {
            com.huawei.hms.utils.Checker.checkNonNull(scope, "scope must not be null.");
            this.b.add(scope);
            return this;
        }

        public com.huawei.hms.api.HuaweiApiClient.Builder allowLifeCycleManagement(android.app.Activity activity, int i, com.huawei.hms.api.HuaweiApiClient.OnConnectionFailedListener onConnectionFailedListener) {
            if (i < 0) {
                throw new java.lang.IllegalArgumentException("allowLifeCycleManagement id should be positive");
            }
            this.g = i;
            this.h = (android.app.Activity) com.huawei.hms.common.internal.Preconditions.checkNotNull(activity, "activity must not be Null.");
            return this;
        }

        public com.huawei.hms.api.HuaweiApiClient.Builder allowLifeCycleManagement(android.app.Activity activity, com.huawei.hms.api.HuaweiApiClient.OnConnectionFailedListener onConnectionFailedListener) {
            return allowLifeCycleManagement(activity, 0, onConnectionFailedListener);
        }

        public com.huawei.hms.api.HuaweiApiClient.Builder applyDefaultAccount() {
            return this;
        }

        public com.huawei.hms.api.HuaweiApiClient build() {
            addApi(new com.huawei.hms.api.Api<>("Core.API"));
            com.huawei.hms.api.HuaweiApiClientImpl huaweiApiClientImpl = new com.huawei.hms.api.HuaweiApiClientImpl(this.a);
            huaweiApiClientImpl.setScopes(this.b);
            huaweiApiClientImpl.setPermissionInfos(this.c);
            huaweiApiClientImpl.setApiMap(this.d);
            huaweiApiClientImpl.setConnectionCallbacks(this.f);
            huaweiApiClientImpl.setConnectionFailedListener(this.e);
            huaweiApiClientImpl.setAutoLifecycleClientId(this.g);
            if (this.g >= 0) {
                a(huaweiApiClientImpl);
            }
            return huaweiApiClientImpl;
        }

        public com.huawei.hms.api.HuaweiApiClient.Builder setAccountName(java.lang.String str) {
            return this;
        }

        public com.huawei.hms.api.HuaweiApiClient.Builder setHandler(android.os.Handler handler) {
            return this;
        }

        public com.huawei.hms.api.HuaweiApiClient.Builder setPopupsGravity(int i) {
            return this;
        }

        public com.huawei.hms.api.HuaweiApiClient.Builder setViewForPopups(android.view.View view) {
            return this;
        }
    }

    public interface ConnectionCallbacks {
        public static final int CAUSE_API_CLIENT_EXPIRED = 3;
        public static final int CAUSE_NETWORK_LOST = 2;
        public static final int CAUSE_SERVICE_DISCONNECTED = 1;

        void onConnected();

        void onConnectionSuspended(int i);
    }

    public interface OnConnectionFailedListener {
        void onConnectionFailed(com.huawei.hms.api.ConnectionResult connectionResult);
    }

    public abstract void checkUpdate(android.app.Activity activity, com.huawei.hms.api.CheckUpdatelistener checkUpdatelistener);

    public void connect(int i) {
        throw new java.lang.UnsupportedOperationException();
    }

    public abstract void connect(android.app.Activity activity);

    public abstract void connectForeground();

    public abstract void disableLifeCycleManagement(android.app.Activity activity);

    public abstract com.huawei.hms.support.api.client.PendingResult<com.huawei.hms.support.api.client.Status> discardAndReconnect();

    public abstract void disconnect();

    public abstract java.util.Map<com.huawei.hms.api.Api<?>, com.huawei.hms.api.Api.ApiOptions> getApiMap();

    public abstract com.huawei.hms.api.ConnectionResult getConnectionResult(com.huawei.hms.api.Api<?> api);

    public abstract java.util.List<com.huawei.hms.support.api.entity.auth.PermissionInfo> getPermissionInfos();

    public abstract java.util.List<com.huawei.hms.support.api.entity.auth.Scope> getScopes();

    public abstract android.app.Activity getTopActivity();

    public abstract boolean hasConnectedApi(com.huawei.hms.api.Api<?> api);

    public abstract boolean hasConnectionFailureListener(com.huawei.hms.api.HuaweiApiClient.OnConnectionFailedListener onConnectionFailedListener);

    public abstract boolean hasConnectionSuccessListener(com.huawei.hms.api.HuaweiApiClient.ConnectionCallbacks connectionCallbacks);

    public abstract com.huawei.hms.api.ConnectionResult holdUpConnect();

    public abstract com.huawei.hms.api.ConnectionResult holdUpConnect(long j, java.util.concurrent.TimeUnit timeUnit);

    @Override // com.huawei.hms.support.api.client.ApiClient
    public abstract boolean isConnected();

    public abstract boolean isConnecting();

    public abstract void onPause(android.app.Activity activity);

    public abstract void onResume(android.app.Activity activity);

    public abstract void print(java.lang.String str, java.io.FileDescriptor fileDescriptor, java.io.PrintWriter printWriter, java.lang.String[] strArr);

    public abstract void reconnect();

    public abstract void removeConnectionFailureListener(com.huawei.hms.api.HuaweiApiClient.OnConnectionFailedListener onConnectionFailedListener);

    public abstract void removeConnectionSuccessListener(com.huawei.hms.api.HuaweiApiClient.ConnectionCallbacks connectionCallbacks);

    public abstract void setConnectionCallbacks(com.huawei.hms.api.HuaweiApiClient.ConnectionCallbacks connectionCallbacks);

    public abstract void setConnectionFailedListener(com.huawei.hms.api.HuaweiApiClient.OnConnectionFailedListener onConnectionFailedListener);

    public abstract boolean setSubAppInfo(com.huawei.hms.support.api.client.SubAppInfo subAppInfo);
}
