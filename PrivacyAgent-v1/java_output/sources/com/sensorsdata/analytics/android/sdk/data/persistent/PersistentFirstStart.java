package com.sensorsdata.analytics.android.sdk.data.persistent;

/* loaded from: classes19.dex */
public class PersistentFirstStart extends com.sensorsdata.analytics.android.sdk.data.persistent.PersistentIdentity<java.lang.Boolean> {

    /* renamed from: com.sensorsdata.analytics.android.sdk.data.persistent.PersistentFirstStart$1, reason: invalid class name */
    public class AnonymousClass1 implements com.sensorsdata.analytics.android.sdk.data.persistent.PersistentIdentity.PersistentSerializer<java.lang.Boolean> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.sensorsdata.analytics.android.sdk.data.persistent.PersistentIdentity.PersistentSerializer
        public java.lang.Boolean create() {
            return java.lang.Boolean.TRUE;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.sensorsdata.analytics.android.sdk.data.persistent.PersistentIdentity.PersistentSerializer
        public java.lang.Boolean load(java.lang.String str) {
            return java.lang.Boolean.FALSE;
        }

        @Override // com.sensorsdata.analytics.android.sdk.data.persistent.PersistentIdentity.PersistentSerializer
        public java.lang.String save(java.lang.Boolean bool) {
            return bool == null ? create().toString() : java.lang.String.valueOf(true);
        }
    }

    public PersistentFirstStart() {
        super(com.sensorsdata.analytics.android.sdk.data.adapter.DbParams.PersistentName.FIRST_START, new com.sensorsdata.analytics.android.sdk.data.persistent.PersistentFirstStart.AnonymousClass1());
    }
}
