package com.sensorsdata.analytics.android.sdk.data.persistent;

/* loaded from: classes19.dex */
public class PersistentSuperProperties extends com.sensorsdata.analytics.android.sdk.data.persistent.PersistentIdentity<org.json.JSONObject> {

    /* renamed from: com.sensorsdata.analytics.android.sdk.data.persistent.PersistentSuperProperties$1, reason: invalid class name */
    public class AnonymousClass1 implements com.sensorsdata.analytics.android.sdk.data.persistent.PersistentIdentity.PersistentSerializer<org.json.JSONObject> {
        @Override // com.sensorsdata.analytics.android.sdk.data.persistent.PersistentIdentity.PersistentSerializer
        public org.json.JSONObject create() {
            return new org.json.JSONObject();
        }

        @Override // com.sensorsdata.analytics.android.sdk.data.persistent.PersistentIdentity.PersistentSerializer
        public org.json.JSONObject load(java.lang.String str) {
            try {
                return new org.json.JSONObject(str);
            } catch (org.json.JSONException e) {
                com.sensorsdata.analytics.android.sdk.SALog.d("Persistent", "failed to load SuperProperties from SharedPreferences.", e);
                return new org.json.JSONObject();
            }
        }

        @Override // com.sensorsdata.analytics.android.sdk.data.persistent.PersistentIdentity.PersistentSerializer
        public java.lang.String save(org.json.JSONObject jSONObject) {
            if (jSONObject == null) {
                jSONObject = create();
            }
            return jSONObject.toString();
        }
    }

    public PersistentSuperProperties() {
        super(com.sensorsdata.analytics.android.sdk.data.adapter.DbParams.PersistentName.SUPER_PROPERTIES, new com.sensorsdata.analytics.android.sdk.data.persistent.PersistentSuperProperties.AnonymousClass1());
    }
}
