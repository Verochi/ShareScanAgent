package com.sensorsdata.analytics.android.sdk.visual.snap;

/* loaded from: classes19.dex */
public abstract class ResourceReader implements com.sensorsdata.analytics.android.sdk.visual.snap.ResourceIds {
    private static final java.lang.String TAG = "SA.ResourceReader";
    private final android.content.Context mContext;
    private final java.util.Map<java.lang.String, java.lang.Integer> mIdNameToId = new java.util.HashMap();
    private final android.util.SparseArray<java.lang.String> mIdToIdName = new android.util.SparseArray<>();

    public static class Drawables extends com.sensorsdata.analytics.android.sdk.visual.snap.ResourceReader {
        private final java.lang.String mResourcePackageName;

        public Drawables(java.lang.String str, android.content.Context context) {
            super(context);
            this.mResourcePackageName = str;
            initialize();
        }

        @Override // com.sensorsdata.analytics.android.sdk.visual.snap.ResourceReader
        public java.lang.String getLocalClassName(android.content.Context context) {
            return this.mResourcePackageName + ".R$drawable";
        }

        @Override // com.sensorsdata.analytics.android.sdk.visual.snap.ResourceReader
        public java.lang.Class<?> getSystemClass() {
            return android.R.drawable.class;
        }
    }

    public static class Ids extends com.sensorsdata.analytics.android.sdk.visual.snap.ResourceReader {
        private final java.lang.String mResourcePackageName;

        public Ids(java.lang.String str, android.content.Context context) {
            super(context);
            this.mResourcePackageName = str;
            initialize();
        }

        @Override // com.sensorsdata.analytics.android.sdk.visual.snap.ResourceReader
        public java.lang.String getLocalClassName(android.content.Context context) {
            return this.mResourcePackageName + ".R$id";
        }

        @Override // com.sensorsdata.analytics.android.sdk.visual.snap.ResourceReader
        public java.lang.Class<?> getSystemClass() {
            return android.R.id.class;
        }
    }

    public ResourceReader(android.content.Context context) {
        this.mContext = context;
    }

    private static void readClassIds(java.lang.Class<?> cls, java.lang.String str, java.util.Map<java.lang.String, java.lang.Integer> map) {
        try {
            for (java.lang.reflect.Field field : cls.getFields()) {
                if (java.lang.reflect.Modifier.isStatic(field.getModifiers()) && field.getType() == java.lang.Integer.TYPE) {
                    java.lang.String name = field.getName();
                    int i = field.getInt(null);
                    if (str != null) {
                        name = str + com.xiaomi.mipush.sdk.Constants.COLON_SEPARATOR + name;
                    }
                    map.put(name, java.lang.Integer.valueOf(i));
                }
            }
        } catch (java.lang.IllegalAccessException e) {
            com.sensorsdata.analytics.android.sdk.SALog.i(TAG, "Can't read built-in id names from " + cls.getName(), e);
        }
    }

    public abstract java.lang.String getLocalClassName(android.content.Context context);

    public abstract java.lang.Class<?> getSystemClass();

    @Override // com.sensorsdata.analytics.android.sdk.visual.snap.ResourceIds
    public int idFromName(java.lang.String str) {
        return this.mIdNameToId.get(str).intValue();
    }

    public void initialize() {
        this.mIdNameToId.clear();
        this.mIdToIdName.clear();
        readClassIds(getSystemClass(), com.aliyun.vod.log.core.AliyunLogCommon.OPERATION_SYSTEM, this.mIdNameToId);
        java.lang.String localClassName = getLocalClassName(this.mContext);
        try {
            readClassIds(java.lang.Class.forName(localClassName), null, this.mIdNameToId);
        } catch (java.lang.ClassNotFoundException unused) {
            com.sensorsdata.analytics.android.sdk.SALog.i(TAG, "Can't load names for Android view ids from '" + localClassName + "', ids by name will not be available in the events editor.");
            com.sensorsdata.analytics.android.sdk.SALog.i(TAG, "You may be missing a Resources class for your package due to your proguard configuration, or you may be using an applicationId in your build that isn't the same as the package declared in your AndroidManifest.xml file.\nIf you're using proguard, you can fix this issue by adding the following to your proguard configuration:\n\n-keep class **.R$* {\n    <fields>;\n}\n\nIf you're not using proguard, or if your proguard configuration already contains the directive above, you can add the following to your AndroidManifest.xml file to explicitly point the SensorsData library to the appropriate library for your resources class:\n\n<meta-data android:name=\"com.sensorsdata.analytics.android.ResourcePackageName\" android:value=\"YOUR_PACKAGE_NAME\" />\n\nwhere YOUR_PACKAGE_NAME is the same string you use for the \"package\" attribute in your <manifest> tag.");
        }
        for (java.util.Map.Entry<java.lang.String, java.lang.Integer> entry : this.mIdNameToId.entrySet()) {
            this.mIdToIdName.put(entry.getValue().intValue(), entry.getKey());
        }
    }

    @Override // com.sensorsdata.analytics.android.sdk.visual.snap.ResourceIds
    public boolean knownIdName(java.lang.String str) {
        return this.mIdNameToId.containsKey(str);
    }

    @Override // com.sensorsdata.analytics.android.sdk.visual.snap.ResourceIds
    public java.lang.String nameForId(int i) {
        return this.mIdToIdName.get(i);
    }
}
