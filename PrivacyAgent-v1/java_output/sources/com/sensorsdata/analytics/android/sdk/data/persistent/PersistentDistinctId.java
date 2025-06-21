package com.sensorsdata.analytics.android.sdk.data.persistent;

/* loaded from: classes19.dex */
public class PersistentDistinctId extends com.sensorsdata.analytics.android.sdk.data.persistent.PersistentIdentity<java.lang.String> {

    /* renamed from: com.sensorsdata.analytics.android.sdk.data.persistent.PersistentDistinctId$1, reason: invalid class name */
    public class AnonymousClass1 implements com.sensorsdata.analytics.android.sdk.data.persistent.PersistentIdentity.PersistentSerializer<java.lang.String> {
        final /* synthetic */ android.content.Context val$context;

        public AnonymousClass1(android.content.Context context) {
            this.val$context = context;
        }

        @Override // com.sensorsdata.analytics.android.sdk.data.persistent.PersistentIdentity.PersistentSerializer
        public java.lang.String create() {
            java.lang.String identifier = com.sensorsdata.analytics.android.sdk.util.SensorsDataUtils.getIdentifier(this.val$context);
            return com.sensorsdata.analytics.android.sdk.util.SensorsDataUtils.isValidAndroidId(identifier) ? identifier : java.util.UUID.randomUUID().toString();
        }

        @Override // com.sensorsdata.analytics.android.sdk.data.persistent.PersistentIdentity.PersistentSerializer
        public java.lang.String load(java.lang.String str) {
            return str;
        }

        @Override // com.sensorsdata.analytics.android.sdk.data.persistent.PersistentIdentity.PersistentSerializer
        public java.lang.String save(java.lang.String str) {
            return str == null ? create() : str;
        }
    }

    public PersistentDistinctId(android.content.Context context) {
        super(com.sensorsdata.analytics.android.sdk.data.adapter.DbParams.PersistentName.DISTINCT_ID, new com.sensorsdata.analytics.android.sdk.data.persistent.PersistentDistinctId.AnonymousClass1(context));
    }
}
