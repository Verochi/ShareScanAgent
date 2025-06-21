package com.huawei.hms.utils;

/* loaded from: classes22.dex */
public class JsonUtil {
    private static final java.lang.String BYTE_BYTE = "_byte_";
    private static final java.lang.String LIST_FIELD_VALUE = "_value_";
    private static final java.lang.String LIST_ITEM_VALUE = "_list_item_";
    private static final java.lang.String LIST_SIZE = "_list_size_";
    private static final java.lang.String MAP_MAP = "_map_";
    private static final java.lang.String NEXT_ITEM = "_next_item_";
    private static final java.lang.String PRE_PKG = "com.huawei";
    private static final java.lang.String TAG = "JsonUtil";
    protected static final int VAL_BYTE = 2;
    protected static final int VAL_ENTITY = 0;
    protected static final int VAL_LIST = 1;
    protected static final int VAL_MAP = 3;
    protected static final int VAL_NULL = -1;
    protected static final java.lang.String VAL_TYPE = "_val_type_";

    /* renamed from: com.huawei.hms.utils.JsonUtil$1, reason: invalid class name */
    public static class AnonymousClass1 implements java.security.PrivilegedAction {
        final /* synthetic */ java.lang.reflect.Field val$field;
        final /* synthetic */ boolean val$flag;

        public AnonymousClass1(java.lang.reflect.Field field, boolean z) {
            this.val$field = field;
            this.val$flag = z;
        }

        @Override // java.security.PrivilegedAction
        public java.lang.Object run() {
            this.val$field.setAccessible(this.val$flag);
            return null;
        }
    }

    private static java.lang.String createInnerJsonString(com.huawei.hms.core.aidl.IMessageEntity iMessageEntity) throws java.lang.IllegalAccessException, org.json.JSONException {
        org.json.JSONObject jSONObject = new org.json.JSONObject();
        for (java.lang.Class<?> cls = iMessageEntity.getClass(); cls != null; cls = cls.getSuperclass()) {
            for (java.lang.reflect.Field field : cls.getDeclaredFields()) {
                if (field.isAnnotationPresent(com.huawei.hms.core.aidl.annotation.Packed.class)) {
                    boolean isAccessible = field.isAccessible();
                    setAccessible(field, true);
                    java.lang.String name = field.getName();
                    java.lang.Object obj = field.get(iMessageEntity);
                    setAccessible(field, isAccessible);
                    disposeType(name, obj, jSONObject);
                }
            }
        }
        return jSONObject.toString();
    }

    public static java.lang.String createJsonString(com.huawei.hms.core.aidl.IMessageEntity iMessageEntity) {
        if (iMessageEntity == null) {
            com.huawei.hms.support.log.HMSLog.e(TAG, "createJsonString error, the input IMessageEntity is null");
            return "";
        }
        try {
            return createInnerJsonString(iMessageEntity);
        } catch (java.lang.IllegalAccessException e) {
            com.huawei.hms.support.log.HMSLog.e(TAG, "catch IllegalAccessException " + e.getMessage());
            return "";
        } catch (org.json.JSONException e2) {
            com.huawei.hms.support.log.HMSLog.e(TAG, "catch JSONException " + e2.getMessage());
            return "";
        }
    }

    private static boolean disposeType(java.lang.String str, java.lang.Object obj, org.json.JSONObject jSONObject) throws org.json.JSONException, java.lang.IllegalAccessException {
        if (obj instanceof java.lang.String) {
            jSONObject.put(str, (java.lang.String) obj);
            return true;
        }
        if (obj instanceof java.lang.Integer) {
            jSONObject.put(str, ((java.lang.Integer) obj).intValue());
            return true;
        }
        if (obj instanceof java.lang.Short) {
            jSONObject.put(str, (java.lang.Short) obj);
            return true;
        }
        if (obj instanceof java.lang.Long) {
            jSONObject.put(str, (java.lang.Long) obj);
            return true;
        }
        if (obj instanceof java.lang.Float) {
            jSONObject.put(str, (java.lang.Float) obj);
            return true;
        }
        if (obj instanceof java.lang.Double) {
            jSONObject.put(str, (java.lang.Double) obj);
            return true;
        }
        if (obj instanceof java.lang.Boolean) {
            jSONObject.put(str, (java.lang.Boolean) obj);
            return true;
        }
        if (obj instanceof org.json.JSONObject) {
            jSONObject.put(str, (org.json.JSONObject) obj);
            return true;
        }
        if (obj instanceof byte[]) {
            writeByte(str, (byte[]) obj, jSONObject);
            return true;
        }
        if (obj instanceof java.util.List) {
            writeList(str, (java.util.List) obj, jSONObject);
            return true;
        }
        if (obj instanceof java.util.Map) {
            writeMap(str, (java.util.Map) obj, jSONObject);
            return true;
        }
        if (obj instanceof com.huawei.hms.core.aidl.IMessageEntity) {
            try {
                jSONObject.put(str, createInnerJsonString((com.huawei.hms.core.aidl.IMessageEntity) obj));
                return true;
            } catch (java.lang.IllegalAccessException e) {
                com.huawei.hms.support.log.HMSLog.e(TAG, "IllegalAccessException , " + e);
            }
        }
        return false;
    }

    public static java.lang.Object getInfoFromJsonobject(java.lang.String str, java.lang.String str2) {
        if (!android.text.TextUtils.isEmpty(str) && !android.text.TextUtils.isEmpty(str2)) {
            try {
                org.json.JSONObject jSONObject = new org.json.JSONObject(str);
                if (!jSONObject.has(str2)) {
                    return null;
                }
                java.lang.Object obj = jSONObject.get(str2);
                if (obj instanceof java.lang.String) {
                    return obj;
                }
            } catch (org.json.JSONException unused) {
                com.huawei.hms.support.log.HMSLog.e(TAG, "getInfoFromJsonobject:parser json error :" + str2);
            }
        }
        return null;
    }

    public static int getIntValue(org.json.JSONObject jSONObject, java.lang.String str) throws org.json.JSONException {
        if (jSONObject == null || !jSONObject.has(str)) {
            return -1;
        }
        return jSONObject.getInt(str);
    }

    private static java.lang.Object getObjectValue(java.lang.String str, org.json.JSONObject jSONObject) throws org.json.JSONException {
        if (jSONObject.has(str)) {
            return jSONObject.get(str);
        }
        if (jSONObject.has("header") && jSONObject.getJSONObject("header").has(str)) {
            return jSONObject.getJSONObject("header").get(str);
        }
        if (jSONObject.has("body") && jSONObject.getJSONObject("body").has(str)) {
            return jSONObject.getJSONObject("body").get(str);
        }
        return null;
    }

    public static java.lang.String getStringValue(org.json.JSONObject jSONObject, java.lang.String str) throws org.json.JSONException {
        if (jSONObject == null || !jSONObject.has(str)) {
            return null;
        }
        return jSONObject.getString(str);
    }

    public static com.huawei.hms.core.aidl.IMessageEntity jsonToEntity(java.lang.String str, com.huawei.hms.core.aidl.IMessageEntity iMessageEntity) {
        try {
            org.json.JSONObject jSONObject = new org.json.JSONObject(str);
            for (java.lang.Class<?> cls = iMessageEntity.getClass(); cls != null; cls = cls.getSuperclass()) {
                for (java.lang.reflect.Field field : cls.getDeclaredFields()) {
                    if (field.isAnnotationPresent(com.huawei.hms.core.aidl.annotation.Packed.class)) {
                        try {
                            readFiled(iMessageEntity, field, jSONObject);
                        } catch (java.lang.IllegalAccessException unused) {
                            com.huawei.hms.support.log.HMSLog.e(TAG, "jsonToEntity, set value of the field exception, field name:" + field.getName());
                        }
                    }
                }
            }
        } catch (org.json.JSONException e) {
            com.huawei.hms.support.log.HMSLog.e(TAG, "catch JSONException when parse jsonString" + e.getMessage());
        }
        return iMessageEntity;
    }

    private static byte[] readByte(org.json.JSONObject jSONObject) throws org.json.JSONException {
        try {
            return com.huawei.hms.support.log.common.Base64.decode(jSONObject.getString(BYTE_BYTE));
        } catch (java.lang.IllegalArgumentException e) {
            com.huawei.hms.support.log.HMSLog.e(TAG, "readByte failed : " + e.getMessage());
            return null;
        }
    }

    private static void readFiled(com.huawei.hms.core.aidl.IMessageEntity iMessageEntity, java.lang.reflect.Field field, org.json.JSONObject jSONObject) throws org.json.JSONException, java.lang.IllegalAccessException {
        java.lang.Object readJson = readJson(iMessageEntity, field, jSONObject);
        if (readJson != null) {
            boolean isAccessible = field.isAccessible();
            setAccessible(field, true);
            field.set(iMessageEntity, readJson);
            setAccessible(field, isAccessible);
        }
    }

    private static java.lang.Object readJson(com.huawei.hms.core.aidl.IMessageEntity iMessageEntity, java.lang.reflect.Field field, org.json.JSONObject jSONObject) throws org.json.JSONException, java.lang.IllegalAccessException {
        java.lang.Object objectValue = getObjectValue(field.getName(), jSONObject);
        if (objectValue != null) {
            try {
                if (field.getType().getName().startsWith(PRE_PKG) && (field.getType().newInstance() instanceof com.huawei.hms.core.aidl.IMessageEntity)) {
                    return jsonToEntity((java.lang.String) objectValue, (com.huawei.hms.core.aidl.IMessageEntity) field.getType().newInstance());
                }
                if (!(objectValue instanceof org.json.JSONObject) || !((org.json.JSONObject) objectValue).has(VAL_TYPE)) {
                    return objectValue;
                }
                int i = ((org.json.JSONObject) objectValue).getInt(VAL_TYPE);
                if (i != 1 && i != 0) {
                    if (i == 2) {
                        return readByte((org.json.JSONObject) objectValue);
                    }
                    if (i == 3) {
                        return readMap(field.getGenericType(), (org.json.JSONObject) objectValue);
                    }
                    com.huawei.hms.support.log.HMSLog.e(TAG, "cannot support type : " + i);
                }
                return readList(field.getGenericType(), (org.json.JSONObject) objectValue);
            } catch (java.lang.InstantiationException unused) {
                com.huawei.hms.support.log.HMSLog.e(TAG, "InstantiationException  ");
            }
        }
        return null;
    }

    private static java.util.List<java.lang.Object> readList(java.lang.reflect.Type type, org.json.JSONObject jSONObject) throws org.json.JSONException, java.lang.IllegalAccessException, java.lang.InstantiationException {
        int i = jSONObject.getInt(LIST_SIZE);
        int i2 = jSONObject.getInt(VAL_TYPE);
        java.util.ArrayList arrayList = new java.util.ArrayList(i);
        for (int i3 = 0; i3 < i; i3++) {
            java.lang.Object obj = jSONObject.get(LIST_ITEM_VALUE + i3);
            if (i2 == 0) {
                arrayList.add(jsonToEntity((java.lang.String) obj, (com.huawei.hms.core.aidl.IMessageEntity) ((java.lang.Class) ((java.lang.reflect.ParameterizedType) type).getActualTypeArguments()[0]).newInstance()));
            } else if (i2 == 1) {
                arrayList.add(obj);
            }
        }
        return arrayList;
    }

    private static java.util.Map readMap(java.lang.reflect.Type type, org.json.JSONObject jSONObject) throws org.json.JSONException, java.lang.IllegalAccessException, java.lang.InstantiationException {
        java.lang.Class cls = (java.lang.Class) ((java.lang.reflect.ParameterizedType) type).getActualTypeArguments()[1];
        org.json.JSONArray jSONArray = new org.json.JSONArray(jSONObject.getString(MAP_MAP));
        java.util.HashMap hashMap = new java.util.HashMap();
        for (int i = 0; i < jSONArray.length(); i += 2) {
            if (cls.newInstance() instanceof com.huawei.hms.core.aidl.IMessageEntity) {
                hashMap.put(jSONArray.get(i), jsonToEntity(jSONArray.getString(i + 1), (com.huawei.hms.core.aidl.IMessageEntity) cls.newInstance()));
            } else {
                hashMap.put(jSONArray.get(i), jSONArray.get(i + 1));
            }
        }
        return hashMap;
    }

    private static void setAccessible(java.lang.reflect.Field field, boolean z) {
        java.security.AccessController.doPrivileged(new com.huawei.hms.utils.JsonUtil.AnonymousClass1(field, z));
    }

    private static void writeByte(java.lang.String str, byte[] bArr, org.json.JSONObject jSONObject) throws org.json.JSONException {
        org.json.JSONObject jSONObject2 = new org.json.JSONObject();
        jSONObject2.put(VAL_TYPE, 2);
        try {
            jSONObject2.put(BYTE_BYTE, com.huawei.hms.support.log.common.Base64.encode(bArr));
        } catch (java.lang.IllegalArgumentException e) {
            com.huawei.hms.support.log.HMSLog.e(TAG, "writeByte failed : " + e.getMessage());
        }
        jSONObject.put(str, jSONObject2);
    }

    private static void writeList(java.lang.String str, java.util.List<?> list, org.json.JSONObject jSONObject) throws org.json.JSONException, java.lang.IllegalAccessException {
        org.json.JSONObject jSONObject2 = new org.json.JSONObject();
        jSONObject2.put(VAL_TYPE, 1);
        jSONObject2.put(LIST_SIZE, list.size());
        for (int i = 0; i < list.size(); i++) {
            disposeType(LIST_ITEM_VALUE + i, list.get(i), jSONObject2);
            if (list.get(i) instanceof com.huawei.hms.core.aidl.IMessageEntity) {
                jSONObject2.put(VAL_TYPE, 0);
            }
        }
        jSONObject.put(str, jSONObject2);
    }

    private static void writeMap(java.lang.String str, java.util.Map map, org.json.JSONObject jSONObject) throws org.json.JSONException, java.lang.IllegalAccessException {
        org.json.JSONArray jSONArray = new org.json.JSONArray();
        for (java.util.Map.Entry entry : map.entrySet()) {
            java.lang.Object key = entry.getKey();
            java.lang.Object value = entry.getValue();
            if (key instanceof com.huawei.hms.core.aidl.IMessageEntity) {
                jSONArray.put(createInnerJsonString((com.huawei.hms.core.aidl.IMessageEntity) key));
            } else {
                jSONArray.put(key);
            }
            if (value instanceof com.huawei.hms.core.aidl.IMessageEntity) {
                jSONArray.put(createInnerJsonString((com.huawei.hms.core.aidl.IMessageEntity) value));
            } else {
                jSONArray.put(value);
            }
        }
        org.json.JSONObject jSONObject2 = new org.json.JSONObject();
        jSONObject2.put(VAL_TYPE, 3);
        jSONObject2.put(MAP_MAP, jSONArray.toString());
        jSONObject.put(str, jSONObject2);
    }
}
