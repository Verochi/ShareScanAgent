package com.alibaba.fastjson.serializer;

/* loaded from: classes.dex */
public class SerializeConfig {
    public static final com.alibaba.fastjson.serializer.SerializeConfig globalInstance = new com.alibaba.fastjson.serializer.SerializeConfig();
    public com.alibaba.fastjson.PropertyNamingStrategy propertyNamingStrategy;
    private final com.alibaba.fastjson.util.IdentityHashMap<com.alibaba.fastjson.serializer.ObjectSerializer> serializers;
    protected java.lang.String typeKey = com.alibaba.fastjson.JSON.DEFAULT_TYPE_KEY;

    public SerializeConfig() {
        com.alibaba.fastjson.util.IdentityHashMap<com.alibaba.fastjson.serializer.ObjectSerializer> identityHashMap = new com.alibaba.fastjson.util.IdentityHashMap<>(1024);
        this.serializers = identityHashMap;
        identityHashMap.put(java.lang.Boolean.class, com.alibaba.fastjson.serializer.BooleanCodec.instance);
        com.alibaba.fastjson.serializer.MiscCodec miscCodec = com.alibaba.fastjson.serializer.MiscCodec.instance;
        identityHashMap.put(java.lang.Character.class, miscCodec);
        identityHashMap.put(java.lang.Byte.class, com.alibaba.fastjson.serializer.IntegerCodec.instance);
        identityHashMap.put(java.lang.Short.class, com.alibaba.fastjson.serializer.IntegerCodec.instance);
        identityHashMap.put(java.lang.Integer.class, com.alibaba.fastjson.serializer.IntegerCodec.instance);
        identityHashMap.put(java.lang.Long.class, com.alibaba.fastjson.serializer.IntegerCodec.instance);
        com.alibaba.fastjson.serializer.NumberCodec numberCodec = com.alibaba.fastjson.serializer.NumberCodec.instance;
        identityHashMap.put(java.lang.Float.class, numberCodec);
        identityHashMap.put(java.lang.Double.class, numberCodec);
        identityHashMap.put(java.lang.Number.class, numberCodec);
        com.alibaba.fastjson.serializer.BigDecimalCodec bigDecimalCodec = com.alibaba.fastjson.serializer.BigDecimalCodec.instance;
        identityHashMap.put(java.math.BigDecimal.class, bigDecimalCodec);
        identityHashMap.put(java.math.BigInteger.class, bigDecimalCodec);
        identityHashMap.put(java.lang.String.class, com.alibaba.fastjson.serializer.StringCodec.instance);
        identityHashMap.put(java.lang.Object[].class, com.alibaba.fastjson.serializer.ArrayCodec.instance);
        identityHashMap.put(java.lang.Class.class, miscCodec);
        identityHashMap.put(java.text.SimpleDateFormat.class, miscCodec);
        identityHashMap.put(java.util.Locale.class, miscCodec);
        identityHashMap.put(java.util.Currency.class, miscCodec);
        identityHashMap.put(java.util.TimeZone.class, miscCodec);
        identityHashMap.put(java.util.UUID.class, miscCodec);
        identityHashMap.put(java.net.URI.class, miscCodec);
        identityHashMap.put(java.net.URL.class, miscCodec);
        identityHashMap.put(java.util.regex.Pattern.class, miscCodec);
        identityHashMap.put(java.nio.charset.Charset.class, miscCodec);
    }

    public static final com.alibaba.fastjson.serializer.SerializeConfig getGlobalInstance() {
        return globalInstance;
    }

    /* JADX WARN: Removed duplicated region for block: B:11:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:8:0x019c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public com.alibaba.fastjson.serializer.ObjectSerializer get(java.lang.Class<?> cls) {
        com.alibaba.fastjson.serializer.ObjectSerializer enumSerializer;
        java.lang.Class<? super java.lang.Object> superclass;
        boolean z;
        com.alibaba.fastjson.serializer.ObjectSerializer objectSerializer;
        com.alibaba.fastjson.serializer.ObjectSerializer objectSerializer2 = this.serializers.get(cls);
        if (objectSerializer2 != null) {
            return objectSerializer2;
        }
        if (java.util.Map.class.isAssignableFrom(cls)) {
            com.alibaba.fastjson.util.IdentityHashMap<com.alibaba.fastjson.serializer.ObjectSerializer> identityHashMap = this.serializers;
            enumSerializer = new com.alibaba.fastjson.serializer.MapSerializer();
            identityHashMap.put(cls, enumSerializer);
        } else if (java.util.AbstractSequentialList.class.isAssignableFrom(cls)) {
            com.alibaba.fastjson.util.IdentityHashMap<com.alibaba.fastjson.serializer.ObjectSerializer> identityHashMap2 = this.serializers;
            enumSerializer = com.alibaba.fastjson.serializer.CollectionCodec.instance;
            identityHashMap2.put(cls, enumSerializer);
        } else if (java.util.List.class.isAssignableFrom(cls)) {
            com.alibaba.fastjson.util.IdentityHashMap<com.alibaba.fastjson.serializer.ObjectSerializer> identityHashMap3 = this.serializers;
            enumSerializer = new com.alibaba.fastjson.serializer.ListSerializer();
            identityHashMap3.put(cls, enumSerializer);
        } else if (java.util.Collection.class.isAssignableFrom(cls)) {
            com.alibaba.fastjson.util.IdentityHashMap<com.alibaba.fastjson.serializer.ObjectSerializer> identityHashMap4 = this.serializers;
            enumSerializer = com.alibaba.fastjson.serializer.CollectionCodec.instance;
            identityHashMap4.put(cls, enumSerializer);
        } else if (java.util.Date.class.isAssignableFrom(cls)) {
            com.alibaba.fastjson.util.IdentityHashMap<com.alibaba.fastjson.serializer.ObjectSerializer> identityHashMap5 = this.serializers;
            enumSerializer = com.alibaba.fastjson.serializer.DateCodec.instance;
            identityHashMap5.put(cls, enumSerializer);
        } else if (com.alibaba.fastjson.JSONAware.class.isAssignableFrom(cls)) {
            com.alibaba.fastjson.util.IdentityHashMap<com.alibaba.fastjson.serializer.ObjectSerializer> identityHashMap6 = this.serializers;
            enumSerializer = com.alibaba.fastjson.serializer.MiscCodec.instance;
            identityHashMap6.put(cls, enumSerializer);
        } else if (com.alibaba.fastjson.serializer.JSONSerializable.class.isAssignableFrom(cls)) {
            com.alibaba.fastjson.util.IdentityHashMap<com.alibaba.fastjson.serializer.ObjectSerializer> identityHashMap7 = this.serializers;
            enumSerializer = com.alibaba.fastjson.serializer.MiscCodec.instance;
            identityHashMap7.put(cls, enumSerializer);
        } else if (com.alibaba.fastjson.JSONStreamAware.class.isAssignableFrom(cls)) {
            com.alibaba.fastjson.util.IdentityHashMap<com.alibaba.fastjson.serializer.ObjectSerializer> identityHashMap8 = this.serializers;
            enumSerializer = com.alibaba.fastjson.serializer.MiscCodec.instance;
            identityHashMap8.put(cls, enumSerializer);
        } else {
            if (!cls.isEnum() && ((superclass = cls.getSuperclass()) == null || superclass == java.lang.Object.class || !superclass.isEnum())) {
                if (cls.isArray()) {
                    java.lang.Class<?> componentType = cls.getComponentType();
                    com.alibaba.fastjson.serializer.ObjectSerializer objectSerializer3 = get(componentType);
                    com.alibaba.fastjson.util.IdentityHashMap<com.alibaba.fastjson.serializer.ObjectSerializer> identityHashMap9 = this.serializers;
                    com.alibaba.fastjson.serializer.ArraySerializer arraySerializer = new com.alibaba.fastjson.serializer.ArraySerializer(componentType, objectSerializer3);
                    identityHashMap9.put(cls, arraySerializer);
                    objectSerializer = arraySerializer;
                } else if (java.lang.Throwable.class.isAssignableFrom(cls)) {
                    com.alibaba.fastjson.serializer.JavaBeanSerializer javaBeanSerializer = new com.alibaba.fastjson.serializer.JavaBeanSerializer(cls, this.propertyNamingStrategy);
                    javaBeanSerializer.features |= com.alibaba.fastjson.serializer.SerializerFeature.WriteClassName.mask;
                    this.serializers.put(cls, javaBeanSerializer);
                    objectSerializer = javaBeanSerializer;
                } else if (java.util.TimeZone.class.isAssignableFrom(cls)) {
                    com.alibaba.fastjson.util.IdentityHashMap<com.alibaba.fastjson.serializer.ObjectSerializer> identityHashMap10 = this.serializers;
                    enumSerializer = com.alibaba.fastjson.serializer.MiscCodec.instance;
                    identityHashMap10.put(cls, enumSerializer);
                } else if (java.nio.charset.Charset.class.isAssignableFrom(cls)) {
                    com.alibaba.fastjson.util.IdentityHashMap<com.alibaba.fastjson.serializer.ObjectSerializer> identityHashMap11 = this.serializers;
                    enumSerializer = com.alibaba.fastjson.serializer.MiscCodec.instance;
                    identityHashMap11.put(cls, enumSerializer);
                } else if (java.util.Enumeration.class.isAssignableFrom(cls)) {
                    com.alibaba.fastjson.util.IdentityHashMap<com.alibaba.fastjson.serializer.ObjectSerializer> identityHashMap12 = this.serializers;
                    enumSerializer = com.alibaba.fastjson.serializer.MiscCodec.instance;
                    identityHashMap12.put(cls, enumSerializer);
                } else if (java.util.Calendar.class.isAssignableFrom(cls)) {
                    com.alibaba.fastjson.util.IdentityHashMap<com.alibaba.fastjson.serializer.ObjectSerializer> identityHashMap13 = this.serializers;
                    enumSerializer = com.alibaba.fastjson.serializer.DateCodec.instance;
                    identityHashMap13.put(cls, enumSerializer);
                } else {
                    boolean z2 = false;
                    for (java.lang.Class<?> cls2 : cls.getInterfaces()) {
                        z = true;
                        if (cls2.getName().equals("net.sf.cglib.proxy.Factory") || cls2.getName().equals("org.springframework.cglib.proxy.Factory")) {
                            z2 = true;
                            break;
                        }
                        if (cls2.getName().equals("javassist.util.proxy.ProxyObject")) {
                            break;
                        }
                    }
                    z = false;
                    if (z2 || z) {
                        com.alibaba.fastjson.serializer.ObjectSerializer objectSerializer4 = get(cls.getSuperclass());
                        this.serializers.put(cls, objectSerializer4);
                        return objectSerializer4;
                    }
                    com.alibaba.fastjson.serializer.ObjectSerializer javaBeanSerializer2 = cls.getName().startsWith("android.net.Uri$") ? com.alibaba.fastjson.serializer.MiscCodec.instance : new com.alibaba.fastjson.serializer.JavaBeanSerializer(cls, this.propertyNamingStrategy);
                    this.serializers.put(cls, javaBeanSerializer2);
                    objectSerializer = javaBeanSerializer2;
                }
                return objectSerializer != null ? this.serializers.get(cls) : objectSerializer;
            }
            com.alibaba.fastjson.util.IdentityHashMap<com.alibaba.fastjson.serializer.ObjectSerializer> identityHashMap14 = this.serializers;
            enumSerializer = new com.alibaba.fastjson.serializer.EnumSerializer();
            identityHashMap14.put(cls, enumSerializer);
        }
        objectSerializer = enumSerializer;
        if (objectSerializer != null) {
        }
    }

    public java.lang.String getTypeKey() {
        return this.typeKey;
    }

    public boolean put(java.lang.reflect.Type type, com.alibaba.fastjson.serializer.ObjectSerializer objectSerializer) {
        return this.serializers.put(type, objectSerializer);
    }

    public com.alibaba.fastjson.serializer.ObjectSerializer registerIfNotExists(java.lang.Class<?> cls) {
        return registerIfNotExists(cls, cls.getModifiers(), false, true, true, true);
    }

    public com.alibaba.fastjson.serializer.ObjectSerializer registerIfNotExists(java.lang.Class<?> cls, int i, boolean z, boolean z2, boolean z3, boolean z4) {
        com.alibaba.fastjson.serializer.ObjectSerializer objectSerializer = this.serializers.get(cls);
        if (objectSerializer != null) {
            return objectSerializer;
        }
        com.alibaba.fastjson.serializer.JavaBeanSerializer javaBeanSerializer = new com.alibaba.fastjson.serializer.JavaBeanSerializer(cls, i, null, z, z2, z3, z4, this.propertyNamingStrategy);
        this.serializers.put(cls, javaBeanSerializer);
        return javaBeanSerializer;
    }

    public void setTypeKey(java.lang.String str) {
        this.typeKey = str;
    }
}
