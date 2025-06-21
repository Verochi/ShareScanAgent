package com.sensorsdata.analytics.android.sdk.plugin.encrypt;

/* loaded from: classes19.dex */
public class SAStoreManager extends com.sensorsdata.analytics.android.sdk.plugin.encrypt.AbstractStoreManager {
    public static final java.lang.String SECRET_KEY = "sa_sp_encrypt_secret_key";
    private static final java.lang.String SP_SENSORS_DATA = "sensorsdata";
    private static final java.lang.String SP_SENSORS_DATA_API = "com.sensorsdata.analytics.android.sdk.SensorsDataAPI";
    private static final java.lang.String SP_SENSORS_DATA_EXIT = "sensorsdata.exit";
    private static final java.lang.String TAG = "SA.SAStoreManager";
    private final java.util.ArrayList<java.lang.String> mAPIStoreKeys;

    /* renamed from: com.sensorsdata.analytics.android.sdk.plugin.encrypt.SAStoreManager$1, reason: invalid class name */
    public class AnonymousClass1 extends com.sensorsdata.analytics.android.sdk.plugin.encrypt.DefaultStorePlugin {
        final /* synthetic */ java.util.List val$exitKeys;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(android.content.Context context, java.lang.String str, java.util.List list) {
            super(context, str);
            this.val$exitKeys = list;
        }

        @Override // com.sensorsdata.analytics.android.sdk.plugin.encrypt.DefaultStorePlugin
        public java.util.List<java.lang.String> storeKeys() {
            return this.val$exitKeys;
        }
    }

    /* renamed from: com.sensorsdata.analytics.android.sdk.plugin.encrypt.SAStoreManager$2, reason: invalid class name */
    public class AnonymousClass2 extends com.sensorsdata.analytics.android.sdk.plugin.encrypt.DefaultStorePlugin {
        public AnonymousClass2(android.content.Context context, java.lang.String str) {
            super(context, str);
        }

        @Override // com.sensorsdata.analytics.android.sdk.plugin.encrypt.DefaultStorePlugin
        public java.util.List<java.lang.String> storeKeys() {
            if (com.sensorsdata.analytics.android.sdk.plugin.encrypt.SAStoreManager.this.mAPIStoreKeys.isEmpty()) {
                com.sensorsdata.analytics.android.sdk.plugin.encrypt.SAStoreManager.this.initAPIKeys();
            }
            return com.sensorsdata.analytics.android.sdk.plugin.encrypt.SAStoreManager.this.mAPIStoreKeys;
        }
    }

    /* renamed from: com.sensorsdata.analytics.android.sdk.plugin.encrypt.SAStoreManager$3, reason: invalid class name */
    public class AnonymousClass3 extends com.sensorsdata.analytics.android.sdk.plugin.encrypt.DefaultStorePlugin {
        public AnonymousClass3(android.content.Context context, java.lang.String str) {
            super(context, str);
        }

        @Override // com.sensorsdata.analytics.android.sdk.plugin.encrypt.DefaultStorePlugin
        public java.util.List<java.lang.String> storeKeys() {
            return null;
        }
    }

    public static class SingletonHolder {
        private static final com.sensorsdata.analytics.android.sdk.plugin.encrypt.SAStoreManager INSTANCE = new com.sensorsdata.analytics.android.sdk.plugin.encrypt.SAStoreManager(null);

        private SingletonHolder() {
        }
    }

    private SAStoreManager() {
        this.mAPIStoreKeys = new java.util.ArrayList<>();
    }

    public /* synthetic */ SAStoreManager(com.sensorsdata.analytics.android.sdk.plugin.encrypt.SAStoreManager.AnonymousClass1 anonymousClass1) {
        this();
    }

    public static com.sensorsdata.analytics.android.sdk.plugin.encrypt.SAStoreManager getInstance() {
        return com.sensorsdata.analytics.android.sdk.plugin.encrypt.SAStoreManager.SingletonHolder.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void initAPIKeys() {
        try {
            for (java.lang.reflect.Field field : com.sensorsdata.analytics.android.sdk.data.adapter.DbParams.PersistentName.class.getDeclaredFields()) {
                this.mAPIStoreKeys.add((java.lang.String) field.get(null));
            }
        } catch (java.lang.Exception e) {
            com.sensorsdata.analytics.android.sdk.SALog.printStackTrace(e);
        }
    }

    private void registerAPIPlugin(android.content.Context context) {
        registerPlugin(new com.sensorsdata.analytics.android.sdk.plugin.encrypt.SAStoreManager.AnonymousClass2(context, SP_SENSORS_DATA_API));
    }

    private void registerExitPlugin(android.content.Context context) {
        java.util.ArrayList arrayList = new java.util.ArrayList();
        arrayList.add(com.sensorsdata.analytics.android.sdk.data.adapter.DbParams.APP_EXIT_DATA);
        registerPlugin(new com.sensorsdata.analytics.android.sdk.plugin.encrypt.SAStoreManager.AnonymousClass1(context, SP_SENSORS_DATA_EXIT, arrayList));
    }

    private void registerSensorsDataPlugin(android.content.Context context) {
        registerPlugin(new com.sensorsdata.analytics.android.sdk.plugin.encrypt.SAStoreManager.AnonymousClass3(context, "sensorsdata"));
    }

    public void registerPlugins(java.util.List<com.sensorsdata.analytics.android.sdk.plugin.encrypt.StorePlugin> list, android.content.Context context) {
        if (list == null || list.isEmpty()) {
            this.mDefaultState = true;
            registerExitPlugin(context);
            registerAPIPlugin(context);
            registerSensorsDataPlugin(context);
            return;
        }
        this.mDefaultState = false;
        if (isRegisterPlugin(context, SP_SENSORS_DATA_EXIT)) {
            registerExitPlugin(context);
        }
        if (isRegisterPlugin(context, SP_SENSORS_DATA_API)) {
            registerAPIPlugin(context);
        }
        if (isRegisterPlugin(context, "sensorsdata")) {
            registerSensorsDataPlugin(context);
        }
        java.util.Iterator<com.sensorsdata.analytics.android.sdk.plugin.encrypt.StorePlugin> it = list.iterator();
        while (it.hasNext()) {
            registerPlugin(it.next());
        }
    }
}
