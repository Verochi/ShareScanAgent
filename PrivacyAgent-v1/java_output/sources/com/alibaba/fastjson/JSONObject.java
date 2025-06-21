package com.alibaba.fastjson;

/* loaded from: classes.dex */
public class JSONObject extends com.alibaba.fastjson.JSON implements java.util.Map<java.lang.String, java.lang.Object>, java.lang.Cloneable, java.io.Serializable, java.lang.reflect.InvocationHandler {
    private final java.util.Map<java.lang.String, java.lang.Object> map;

    public JSONObject() {
        this(16, false);
    }

    public JSONObject(int i) {
        this(i, false);
    }

    public JSONObject(int i, boolean z) {
        if (z) {
            this.map = new java.util.LinkedHashMap(i);
        } else {
            this.map = new java.util.HashMap(i);
        }
    }

    public JSONObject(java.util.Map<java.lang.String, java.lang.Object> map) {
        this.map = map;
    }

    public JSONObject(boolean z) {
        this(16, z);
    }

    @Override // java.util.Map
    public void clear() {
        this.map.clear();
    }

    public java.lang.Object clone() {
        return new com.alibaba.fastjson.JSONObject(new java.util.LinkedHashMap(this.map));
    }

    @Override // java.util.Map
    public boolean containsKey(java.lang.Object obj) {
        return this.map.containsKey(obj);
    }

    @Override // java.util.Map
    public boolean containsValue(java.lang.Object obj) {
        return this.map.containsValue(obj);
    }

    @Override // java.util.Map
    public java.util.Set<java.util.Map.Entry<java.lang.String, java.lang.Object>> entrySet() {
        return this.map.entrySet();
    }

    @Override // java.util.Map
    public boolean equals(java.lang.Object obj) {
        if (this == obj) {
            return true;
        }
        return obj instanceof com.alibaba.fastjson.JSONObject ? this.map.equals(((com.alibaba.fastjson.JSONObject) obj).map) : this.map.equals(obj);
    }

    @Override // java.util.Map
    public java.lang.Object get(java.lang.Object obj) {
        return this.map.get(obj);
    }

    public java.math.BigDecimal getBigDecimal(java.lang.String str) {
        return com.alibaba.fastjson.util.TypeUtils.castToBigDecimal(get(str));
    }

    public java.math.BigInteger getBigInteger(java.lang.String str) {
        return com.alibaba.fastjson.util.TypeUtils.castToBigInteger(get(str));
    }

    public java.lang.Boolean getBoolean(java.lang.String str) {
        java.lang.Object obj = get(str);
        if (obj == null) {
            return null;
        }
        return com.alibaba.fastjson.util.TypeUtils.castToBoolean(obj);
    }

    public boolean getBooleanValue(java.lang.String str) {
        java.lang.Boolean castToBoolean = com.alibaba.fastjson.util.TypeUtils.castToBoolean(get(str));
        if (castToBoolean == null) {
            return false;
        }
        return castToBoolean.booleanValue();
    }

    public java.lang.Byte getByte(java.lang.String str) {
        return com.alibaba.fastjson.util.TypeUtils.castToByte(get(str));
    }

    public byte getByteValue(java.lang.String str) {
        java.lang.Byte castToByte = com.alibaba.fastjson.util.TypeUtils.castToByte(get(str));
        if (castToByte == null) {
            return (byte) 0;
        }
        return castToByte.byteValue();
    }

    public byte[] getBytes(java.lang.String str) {
        java.lang.Object obj = get(str);
        if (obj == null) {
            return null;
        }
        return com.alibaba.fastjson.util.TypeUtils.castToBytes(obj);
    }

    public java.util.Date getDate(java.lang.String str) {
        return com.alibaba.fastjson.util.TypeUtils.castToDate(get(str));
    }

    public java.lang.Double getDouble(java.lang.String str) {
        return com.alibaba.fastjson.util.TypeUtils.castToDouble(get(str));
    }

    public double getDoubleValue(java.lang.String str) {
        java.lang.Double castToDouble = com.alibaba.fastjson.util.TypeUtils.castToDouble(get(str));
        if (castToDouble == null) {
            return 0.0d;
        }
        return castToDouble.doubleValue();
    }

    public java.lang.Float getFloat(java.lang.String str) {
        return com.alibaba.fastjson.util.TypeUtils.castToFloat(get(str));
    }

    public float getFloatValue(java.lang.String str) {
        java.lang.Float castToFloat = com.alibaba.fastjson.util.TypeUtils.castToFloat(get(str));
        if (castToFloat == null) {
            return 0.0f;
        }
        return castToFloat.floatValue();
    }

    public java.util.Map<java.lang.String, java.lang.Object> getInnerMap() {
        return this.map;
    }

    public int getIntValue(java.lang.String str) {
        java.lang.Integer castToInt = com.alibaba.fastjson.util.TypeUtils.castToInt(get(str));
        if (castToInt == null) {
            return 0;
        }
        return castToInt.intValue();
    }

    public java.lang.Integer getInteger(java.lang.String str) {
        return com.alibaba.fastjson.util.TypeUtils.castToInt(get(str));
    }

    public com.alibaba.fastjson.JSONArray getJSONArray(java.lang.String str) {
        java.lang.Object obj = this.map.get(str);
        return obj instanceof com.alibaba.fastjson.JSONArray ? (com.alibaba.fastjson.JSONArray) obj : obj instanceof java.lang.String ? (com.alibaba.fastjson.JSONArray) com.alibaba.fastjson.JSON.parse((java.lang.String) obj) : (com.alibaba.fastjson.JSONArray) com.alibaba.fastjson.JSON.toJSON(obj);
    }

    public com.alibaba.fastjson.JSONObject getJSONObject(java.lang.String str) {
        java.lang.Object obj = this.map.get(str);
        return obj instanceof com.alibaba.fastjson.JSONObject ? (com.alibaba.fastjson.JSONObject) obj : obj instanceof java.lang.String ? com.alibaba.fastjson.JSON.parseObject((java.lang.String) obj) : (com.alibaba.fastjson.JSONObject) com.alibaba.fastjson.JSON.toJSON(obj);
    }

    public java.lang.Long getLong(java.lang.String str) {
        return com.alibaba.fastjson.util.TypeUtils.castToLong(get(str));
    }

    public long getLongValue(java.lang.String str) {
        java.lang.Long castToLong = com.alibaba.fastjson.util.TypeUtils.castToLong(get(str));
        if (castToLong == null) {
            return 0L;
        }
        return castToLong.longValue();
    }

    public <T> T getObject(java.lang.String str, java.lang.Class<T> cls) {
        return (T) com.alibaba.fastjson.util.TypeUtils.castToJavaBean(this.map.get(str), cls);
    }

    public <T> T getObject(java.lang.String str, java.lang.Class<T> cls, com.alibaba.fastjson.parser.Feature... featureArr) {
        java.lang.Object obj = this.map.get(str);
        int i = com.alibaba.fastjson.JSON.DEFAULT_PARSER_FEATURE;
        for (com.alibaba.fastjson.parser.Feature feature : featureArr) {
            i |= feature.mask;
        }
        return (T) com.alibaba.fastjson.util.TypeUtils.cast(obj, cls, com.alibaba.fastjson.parser.ParserConfig.global, i);
    }

    public java.lang.Short getShort(java.lang.String str) {
        return com.alibaba.fastjson.util.TypeUtils.castToShort(get(str));
    }

    public short getShortValue(java.lang.String str) {
        java.lang.Short castToShort = com.alibaba.fastjson.util.TypeUtils.castToShort(get(str));
        if (castToShort == null) {
            return (short) 0;
        }
        return castToShort.shortValue();
    }

    public java.lang.String getString(java.lang.String str) {
        java.lang.Object obj = get(str);
        if (obj == null) {
            return null;
        }
        return obj.toString();
    }

    @Override // java.util.Map
    public int hashCode() {
        return this.map.hashCode();
    }

    @Override // java.lang.reflect.InvocationHandler
    public java.lang.Object invoke(java.lang.Object obj, java.lang.reflect.Method method, java.lang.Object[] objArr) throws java.lang.Throwable {
        java.lang.Class<?>[] parameterTypes = method.getParameterTypes();
        java.lang.String str = null;
        if (parameterTypes.length == 1) {
            if (method.getName().equals("equals")) {
                return java.lang.Boolean.valueOf(equals(objArr[0]));
            }
            if (method.getReturnType() != java.lang.Void.TYPE) {
                throw new com.alibaba.fastjson.JSONException("illegal setter");
            }
            com.alibaba.fastjson.annotation.JSONField jSONField = (com.alibaba.fastjson.annotation.JSONField) method.getAnnotation(com.alibaba.fastjson.annotation.JSONField.class);
            java.lang.String name = (jSONField == null || jSONField.name().length() == 0) ? null : jSONField.name();
            if (name == null) {
                java.lang.String name2 = method.getName();
                if (!name2.startsWith("set")) {
                    throw new com.alibaba.fastjson.JSONException("illegal setter");
                }
                java.lang.String substring = name2.substring(3);
                if (substring.length() == 0) {
                    throw new com.alibaba.fastjson.JSONException("illegal setter");
                }
                name = java.lang.Character.toLowerCase(substring.charAt(0)) + substring.substring(1);
            }
            this.map.put(name, objArr[0]);
            return null;
        }
        if (parameterTypes.length != 0) {
            throw new java.lang.UnsupportedOperationException(method.toGenericString());
        }
        if (method.getReturnType() == java.lang.Void.TYPE) {
            throw new com.alibaba.fastjson.JSONException("illegal getter");
        }
        com.alibaba.fastjson.annotation.JSONField jSONField2 = (com.alibaba.fastjson.annotation.JSONField) method.getAnnotation(com.alibaba.fastjson.annotation.JSONField.class);
        if (jSONField2 != null && jSONField2.name().length() != 0) {
            str = jSONField2.name();
        }
        if (str == null) {
            java.lang.String name3 = method.getName();
            if (name3.startsWith(com.ss.android.socialbase.downloader.constants.MonitorConstants.CONNECT_TYPE_GET)) {
                java.lang.String substring2 = name3.substring(3);
                if (substring2.length() == 0) {
                    throw new com.alibaba.fastjson.JSONException("illegal getter");
                }
                str = java.lang.Character.toLowerCase(substring2.charAt(0)) + substring2.substring(1);
            } else {
                if (!name3.startsWith("is")) {
                    if (name3.startsWith(com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField.TT_HASHCODE)) {
                        return java.lang.Integer.valueOf(hashCode());
                    }
                    if (name3.startsWith("toString")) {
                        return toString();
                    }
                    throw new com.alibaba.fastjson.JSONException("illegal getter");
                }
                java.lang.String substring3 = name3.substring(2);
                if (substring3.length() == 0) {
                    throw new com.alibaba.fastjson.JSONException("illegal getter");
                }
                str = java.lang.Character.toLowerCase(substring3.charAt(0)) + substring3.substring(1);
            }
        }
        return com.alibaba.fastjson.util.TypeUtils.cast(this.map.get(str), method.getGenericReturnType(), com.alibaba.fastjson.parser.ParserConfig.global);
    }

    @Override // java.util.Map
    public boolean isEmpty() {
        return this.map.isEmpty();
    }

    @Override // java.util.Map
    public java.util.Set<java.lang.String> keySet() {
        return this.map.keySet();
    }

    @Override // java.util.Map
    public java.lang.Object put(java.lang.String str, java.lang.Object obj) {
        return this.map.put(str, obj);
    }

    @Override // java.util.Map
    public void putAll(java.util.Map<? extends java.lang.String, ? extends java.lang.Object> map) {
        this.map.putAll(map);
    }

    @Override // java.util.Map
    public java.lang.Object remove(java.lang.Object obj) {
        return this.map.remove(obj);
    }

    @Override // java.util.Map
    public int size() {
        return this.map.size();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.alibaba.fastjson.JSON
    public <T> T toJavaObject(java.lang.Class<T> cls) {
        return cls == java.util.Map.class ? this : (cls != java.lang.Object.class || containsKey(com.alibaba.fastjson.JSON.DEFAULT_TYPE_KEY)) ? (T) com.alibaba.fastjson.util.TypeUtils.castToJavaBean(this, cls, com.alibaba.fastjson.parser.ParserConfig.getGlobalInstance(), 0) : this;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public <T> T toJavaObject(java.lang.Class<T> cls, com.alibaba.fastjson.parser.ParserConfig parserConfig, int i) {
        return cls == java.util.Map.class ? this : (cls != java.lang.Object.class || containsKey(com.alibaba.fastjson.JSON.DEFAULT_TYPE_KEY)) ? (T) com.alibaba.fastjson.util.TypeUtils.castToJavaBean(this, cls, parserConfig, i) : this;
    }

    @Override // java.util.Map
    public java.util.Collection<java.lang.Object> values() {
        return this.map.values();
    }
}
