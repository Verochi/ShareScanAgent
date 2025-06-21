package com.sensorsdata.analytics.android.sdk.data.persistent;

/* loaded from: classes19.dex */
public class PersistentRemoteSDKConfig extends com.sensorsdata.analytics.android.sdk.data.persistent.PersistentIdentity<java.lang.String> {

    /* renamed from: com.sensorsdata.analytics.android.sdk.data.persistent.PersistentRemoteSDKConfig$1, reason: invalid class name */
    public class AnonymousClass1 implements com.sensorsdata.analytics.android.sdk.data.persistent.PersistentIdentity.PersistentSerializer<java.lang.String> {
        @Override // com.sensorsdata.analytics.android.sdk.data.persistent.PersistentIdentity.PersistentSerializer
        public java.lang.String create() {
            return null;
        }

        @Override // com.sensorsdata.analytics.android.sdk.data.persistent.PersistentIdentity.PersistentSerializer
        public java.lang.String load(java.lang.String str) {
            return str;
        }

        @Override // com.sensorsdata.analytics.android.sdk.data.persistent.PersistentIdentity.PersistentSerializer
        public java.lang.String save(java.lang.String str) {
            return str;
        }
    }

    public PersistentRemoteSDKConfig() {
        super(com.sensorsdata.analytics.android.sdk.data.adapter.DbParams.PersistentName.REMOTE_CONFIG, new com.sensorsdata.analytics.android.sdk.data.persistent.PersistentRemoteSDKConfig.AnonymousClass1());
    }
}
