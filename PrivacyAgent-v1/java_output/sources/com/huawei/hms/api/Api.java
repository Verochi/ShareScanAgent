package com.huawei.hms.api;

/* loaded from: classes22.dex */
public class Api<O extends com.huawei.hms.api.Api.ApiOptions> {
    private final java.lang.String mApiName;
    public java.util.List<com.huawei.hms.common.api.ConnectionPostProcessor> mConnetctPostList;
    private final com.huawei.hms.api.Api.Options<O> mOption;

    public interface ApiOptions {

        public interface HasOptions extends com.huawei.hms.api.Api.ApiOptions {
        }

        public static final class NoOptions implements com.huawei.hms.api.Api.ApiOptions.NotRequiredOptions {
        }

        public interface NotRequiredOptions extends com.huawei.hms.api.Api.ApiOptions {
        }

        public interface Optional extends com.huawei.hms.api.Api.ApiOptions.HasOptions, com.huawei.hms.api.Api.ApiOptions.NotRequiredOptions {
        }
    }

    public static abstract class Options<O> {
        public java.util.List<com.huawei.hms.support.api.entity.auth.PermissionInfo> getPermissionInfoList(O o) {
            return java.util.Collections.emptyList();
        }

        public java.util.List<com.huawei.hms.support.api.entity.auth.Scope> getScopeList(O o) {
            return java.util.Collections.emptyList();
        }
    }

    public Api(java.lang.String str) {
        this.mApiName = str;
        this.mOption = null;
    }

    public Api(java.lang.String str, com.huawei.hms.api.Api.Options<O> options) {
        this.mApiName = str;
        this.mOption = options;
    }

    public java.lang.String getApiName() {
        return this.mApiName;
    }

    public com.huawei.hms.api.Api.Options<O> getOptions() {
        return this.mOption;
    }

    public java.util.List<com.huawei.hms.common.api.ConnectionPostProcessor> getmConnetctPostList() {
        return this.mConnetctPostList;
    }

    public void setmConnetctPostList(java.util.List<com.huawei.hms.common.api.ConnectionPostProcessor> list) {
        this.mConnetctPostList = list;
    }
}
