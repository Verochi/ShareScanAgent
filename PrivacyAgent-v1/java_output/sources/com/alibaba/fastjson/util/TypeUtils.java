package com.alibaba.fastjson.util;

/* loaded from: classes.dex */
public class TypeUtils {
    public static boolean compatibleWithJavaBean = false;
    private static volatile java.util.Map<java.lang.Class, java.lang.String[]> kotlinIgnores = null;
    private static volatile boolean kotlinIgnores_error = false;
    private static volatile boolean kotlin_class_klass_error = false;
    private static volatile boolean kotlin_error = false;
    private static volatile java.lang.reflect.Constructor kotlin_kclass_constructor = null;
    private static volatile java.lang.reflect.Method kotlin_kclass_getConstructors = null;
    private static volatile java.lang.reflect.Method kotlin_kfunction_getParameters = null;
    private static volatile java.lang.reflect.Method kotlin_kparameter_getName = null;
    private static volatile java.lang.Class kotlin_metadata = null;
    private static volatile boolean kotlin_metadata_error = false;
    private static final java.util.concurrent.ConcurrentMap<java.lang.String, java.lang.Class<?>> mappings;
    private static boolean setAccessibleEnable = true;

    static {
        java.util.concurrent.ConcurrentHashMap concurrentHashMap = new java.util.concurrent.ConcurrentHashMap(36, 0.75f, 1);
        mappings = concurrentHashMap;
        concurrentHashMap.put("byte", java.lang.Byte.TYPE);
        concurrentHashMap.put("short", java.lang.Short.TYPE);
        concurrentHashMap.put(com.baidu.mobads.sdk.api.IAdInterListener.AdProdType.PRODUCT_INTERSTITIAL, java.lang.Integer.TYPE);
        concurrentHashMap.put("long", java.lang.Long.TYPE);
        concurrentHashMap.put("float", java.lang.Float.TYPE);
        concurrentHashMap.put("double", java.lang.Double.TYPE);
        concurrentHashMap.put("boolean", java.lang.Boolean.TYPE);
        concurrentHashMap.put("char", java.lang.Character.TYPE);
        concurrentHashMap.put("[byte", byte[].class);
        concurrentHashMap.put("[short", short[].class);
        concurrentHashMap.put("[int", int[].class);
        concurrentHashMap.put("[long", long[].class);
        concurrentHashMap.put("[float", float[].class);
        concurrentHashMap.put("[double", double[].class);
        concurrentHashMap.put("[boolean", boolean[].class);
        concurrentHashMap.put("[char", char[].class);
        concurrentHashMap.put("[B", byte[].class);
        concurrentHashMap.put("[S", short[].class);
        concurrentHashMap.put("[I", int[].class);
        concurrentHashMap.put("[J", long[].class);
        concurrentHashMap.put("[F", float[].class);
        concurrentHashMap.put("[D", double[].class);
        concurrentHashMap.put("[C", char[].class);
        concurrentHashMap.put("[Z", boolean[].class);
        concurrentHashMap.put("java.util.HashMap", java.util.HashMap.class);
        concurrentHashMap.put("java.util.TreeMap", java.util.TreeMap.class);
        concurrentHashMap.put("java.util.Date", java.util.Date.class);
        concurrentHashMap.put("com.alibaba.fastjson.JSONObject", com.alibaba.fastjson.JSONObject.class);
        concurrentHashMap.put("java.util.concurrent.ConcurrentHashMap", java.util.concurrent.ConcurrentHashMap.class);
        concurrentHashMap.put("java.text.SimpleDateFormat", java.text.SimpleDateFormat.class);
        concurrentHashMap.put("java.lang.StackTraceElement", java.lang.StackTraceElement.class);
        concurrentHashMap.put("java.lang.RuntimeException", java.lang.RuntimeException.class);
    }

    public static void addMapping(java.lang.String str, java.lang.Class<?> cls) {
        mappings.put(str, cls);
    }

    public static final <T> T cast(java.lang.Object obj, java.lang.Class<T> cls, com.alibaba.fastjson.parser.ParserConfig parserConfig) {
        return (T) cast(obj, cls, parserConfig, 0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final <T> T cast(java.lang.Object obj, java.lang.Class<T> cls, com.alibaba.fastjson.parser.ParserConfig parserConfig, int i) {
        java.lang.Object obj2;
        if (obj == 0) {
            return null;
        }
        if (cls == null) {
            throw new java.lang.IllegalArgumentException("clazz is null");
        }
        if (cls == obj.getClass()) {
            return obj;
        }
        if (obj instanceof java.util.Map) {
            if (cls == java.util.Map.class) {
                return obj;
            }
            java.util.Map map = (java.util.Map) obj;
            return (cls != java.lang.Object.class || map.containsKey(com.alibaba.fastjson.JSON.DEFAULT_TYPE_KEY)) ? (T) castToJavaBean(map, cls, parserConfig, i) : obj;
        }
        int i2 = 0;
        if (cls.isArray()) {
            if (obj instanceof java.util.Collection) {
                java.util.Collection collection = (java.util.Collection) obj;
                T t = (T) java.lang.reflect.Array.newInstance(cls.getComponentType(), collection.size());
                java.util.Iterator it = collection.iterator();
                while (it.hasNext()) {
                    java.lang.reflect.Array.set(t, i2, cast(it.next(), (java.lang.Class) cls.getComponentType(), parserConfig));
                    i2++;
                }
                return t;
            }
            if (cls == byte[].class) {
                return (T) castToBytes(obj);
            }
        }
        if (cls.isAssignableFrom(obj.getClass())) {
            return obj;
        }
        if (cls == java.lang.Boolean.TYPE || cls == java.lang.Boolean.class) {
            return (T) castToBoolean(obj);
        }
        if (cls == java.lang.Byte.TYPE || cls == java.lang.Byte.class) {
            return (T) castToByte(obj);
        }
        if ((cls == java.lang.Character.TYPE || cls == java.lang.Character.class) && (obj instanceof java.lang.String)) {
            java.lang.String str = (java.lang.String) obj;
            if (str.length() == 1) {
                return (T) java.lang.Character.valueOf(str.charAt(0));
            }
        }
        if (cls == java.lang.Short.TYPE || cls == java.lang.Short.class) {
            return (T) castToShort(obj);
        }
        if (cls == java.lang.Integer.TYPE || cls == java.lang.Integer.class) {
            return (T) castToInt(obj);
        }
        if (cls == java.lang.Long.TYPE || cls == java.lang.Long.class) {
            return (T) castToLong(obj);
        }
        if (cls == java.lang.Float.TYPE || cls == java.lang.Float.class) {
            return (T) castToFloat(obj);
        }
        if (cls == java.lang.Double.TYPE || cls == java.lang.Double.class) {
            return (T) castToDouble(obj);
        }
        if (cls == java.lang.String.class) {
            return (T) castToString(obj);
        }
        if (cls == java.math.BigDecimal.class) {
            return (T) castToBigDecimal(obj);
        }
        if (cls == java.math.BigInteger.class) {
            return (T) castToBigInteger(obj);
        }
        if (cls == java.util.Date.class) {
            return (T) castToDate(obj);
        }
        if (cls.isEnum()) {
            return (T) castToEnum(obj, cls, parserConfig);
        }
        if (java.util.Calendar.class.isAssignableFrom(cls)) {
            java.util.Date castToDate = castToDate(obj);
            if (cls == java.util.Calendar.class) {
                obj2 = (T) java.util.Calendar.getInstance(com.alibaba.fastjson.JSON.defaultTimeZone, com.alibaba.fastjson.JSON.defaultLocale);
            } else {
                try {
                    obj2 = (T) ((java.util.Calendar) cls.newInstance());
                } catch (java.lang.Exception e) {
                    throw new com.alibaba.fastjson.JSONException("can not cast to : " + cls.getName(), e);
                }
            }
            ((java.util.Calendar) obj2).setTime(castToDate);
            return (T) obj2;
        }
        if (obj instanceof java.lang.String) {
            java.lang.String str2 = (java.lang.String) obj;
            if (str2.length() == 0 || com.igexin.push.core.b.m.equals(str2)) {
                return null;
            }
            if (cls == java.util.Currency.class) {
                return (T) java.util.Currency.getInstance(str2);
            }
        }
        throw new com.alibaba.fastjson.JSONException("can not cast to : " + cls.getName());
    }

    /* JADX WARN: Type inference failed for: r0v1, types: [T, java.util.ArrayList] */
    /* JADX WARN: Type inference failed for: r10v6, types: [T, java.util.HashMap, java.util.Map] */
    public static final <T> T cast(java.lang.Object obj, java.lang.reflect.ParameterizedType parameterizedType, com.alibaba.fastjson.parser.ParserConfig parserConfig) {
        if (obj == null) {
            return null;
        }
        java.lang.reflect.Type rawType = parameterizedType.getRawType();
        if (rawType == java.util.List.class || rawType == java.util.ArrayList.class) {
            java.lang.reflect.Type type = parameterizedType.getActualTypeArguments()[0];
            if (obj instanceof java.util.List) {
                java.util.List list = (java.util.List) obj;
                int size = list.size();
                ?? r0 = (T) new java.util.ArrayList(size);
                for (int i = 0; i < size; i++) {
                    java.lang.Object obj2 = list.get(i);
                    r0.add(type instanceof java.lang.Class ? (obj2 == null || obj2.getClass() != com.alibaba.fastjson.JSONObject.class) ? cast(obj2, (java.lang.Class) type, parserConfig, 0) : ((com.alibaba.fastjson.JSONObject) obj2).toJavaObject((java.lang.Class) type, parserConfig, 0) : cast(obj2, type, parserConfig));
                }
                return r0;
            }
        }
        if (rawType == java.util.Set.class || rawType == java.util.HashSet.class || rawType == java.util.TreeSet.class || rawType == java.util.List.class || rawType == java.util.ArrayList.class) {
            java.lang.reflect.Type type2 = parameterizedType.getActualTypeArguments()[0];
            if (obj instanceof java.lang.Iterable) {
                T t = (rawType == java.util.Set.class || rawType == java.util.HashSet.class) ? (T) new java.util.HashSet() : rawType == java.util.TreeSet.class ? (T) new java.util.TreeSet() : (T) new java.util.ArrayList();
                java.util.Iterator<T> it = ((java.lang.Iterable) obj).iterator();
                while (it.hasNext()) {
                    T next = it.next();
                    ((java.util.Collection) t).add(type2 instanceof java.lang.Class ? (next == null || next.getClass() != com.alibaba.fastjson.JSONObject.class) ? cast(next, (java.lang.Class) type2, parserConfig, 0) : ((com.alibaba.fastjson.JSONObject) next).toJavaObject((java.lang.Class) type2, parserConfig, 0) : cast(next, type2, parserConfig));
                }
                return t;
            }
        }
        if (rawType == java.util.Map.class || rawType == java.util.HashMap.class) {
            java.lang.reflect.Type type3 = parameterizedType.getActualTypeArguments()[0];
            java.lang.reflect.Type type4 = parameterizedType.getActualTypeArguments()[1];
            if (obj instanceof java.util.Map) {
                ?? r10 = (T) new java.util.HashMap();
                for (java.util.Map.Entry entry : ((java.util.Map) obj).entrySet()) {
                    r10.put(cast(entry.getKey(), type3, parserConfig), cast(entry.getValue(), type4, parserConfig));
                }
                return r10;
            }
        }
        if (obj instanceof java.lang.String) {
            java.lang.String str = (java.lang.String) obj;
            if (str.length() == 0 || com.igexin.push.core.b.m.equals(str)) {
                return null;
            }
        }
        if (parameterizedType.getActualTypeArguments().length == 1 && (parameterizedType.getActualTypeArguments()[0] instanceof java.lang.reflect.WildcardType)) {
            return (T) cast(obj, rawType, parserConfig);
        }
        throw new com.alibaba.fastjson.JSONException("can not cast to : " + parameterizedType);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final <T> T cast(java.lang.Object obj, java.lang.reflect.Type type, com.alibaba.fastjson.parser.ParserConfig parserConfig) {
        if (obj == 0) {
            if (type == java.lang.Integer.TYPE) {
                return (T) 0;
            }
            if (type == java.lang.Long.TYPE) {
                return (T) 0L;
            }
            if (type == java.lang.Short.TYPE) {
                return (T) (short) 0;
            }
            if (type == java.lang.Byte.TYPE) {
                return (T) (byte) 0;
            }
            if (type == java.lang.Float.TYPE) {
                return (T) java.lang.Float.valueOf(0.0f);
            }
            if (type == java.lang.Double.TYPE) {
                return (T) java.lang.Double.valueOf(0.0d);
            }
            if (type == java.lang.Boolean.TYPE) {
                return (T) java.lang.Boolean.FALSE;
            }
            return null;
        }
        if (type instanceof java.lang.Class) {
            return (T) cast(obj, (java.lang.Class) type, parserConfig, 0);
        }
        if (type instanceof java.lang.reflect.ParameterizedType) {
            return (T) cast(obj, (java.lang.reflect.ParameterizedType) type, parserConfig);
        }
        if (obj instanceof java.lang.String) {
            java.lang.String str = (java.lang.String) obj;
            if (str.length() == 0 || com.igexin.push.core.b.m.equals(str)) {
                return null;
            }
        }
        if (type instanceof java.lang.reflect.TypeVariable) {
            return obj;
        }
        throw new com.alibaba.fastjson.JSONException("can not cast to : " + type);
    }

    public static final java.math.BigDecimal castToBigDecimal(java.lang.Object obj) {
        if (obj == null) {
            return null;
        }
        if (obj instanceof java.math.BigDecimal) {
            return (java.math.BigDecimal) obj;
        }
        if (obj instanceof java.math.BigInteger) {
            return new java.math.BigDecimal((java.math.BigInteger) obj);
        }
        java.lang.String obj2 = obj.toString();
        if (obj2.length() == 0 || com.igexin.push.core.b.m.equals(obj2)) {
            return null;
        }
        return new java.math.BigDecimal(obj2);
    }

    public static final java.math.BigInteger castToBigInteger(java.lang.Object obj) {
        if (obj == null) {
            return null;
        }
        if (obj instanceof java.math.BigInteger) {
            return (java.math.BigInteger) obj;
        }
        if ((obj instanceof java.lang.Float) || (obj instanceof java.lang.Double)) {
            return java.math.BigInteger.valueOf(((java.lang.Number) obj).longValue());
        }
        java.lang.String obj2 = obj.toString();
        if (obj2.length() == 0 || com.igexin.push.core.b.m.equals(obj2)) {
            return null;
        }
        return new java.math.BigInteger(obj2);
    }

    public static final java.lang.Boolean castToBoolean(java.lang.Object obj) {
        if (obj == null) {
            return null;
        }
        if (obj instanceof java.lang.Boolean) {
            return (java.lang.Boolean) obj;
        }
        if (obj instanceof java.math.BigDecimal) {
            return java.lang.Boolean.valueOf(((java.math.BigDecimal) obj).intValueExact() == 1);
        }
        if (obj instanceof java.lang.Number) {
            return java.lang.Boolean.valueOf(((java.lang.Number) obj).intValue() == 1);
        }
        if (obj instanceof java.lang.String) {
            java.lang.String str = (java.lang.String) obj;
            if (str.length() == 0 || com.igexin.push.core.b.m.equals(str)) {
                return null;
            }
            if (com.aliyun.svideosdk.preview.camera.AliyunRecorderProperty.SURFACE_ROTATION_MODE_TRUE.equalsIgnoreCase(str) || "1".equals(str)) {
                return java.lang.Boolean.TRUE;
            }
            if (com.aliyun.svideosdk.preview.camera.AliyunRecorderProperty.SURFACE_ROTATION_MODE_FALSE.equalsIgnoreCase(str) || "0".equals(str)) {
                return java.lang.Boolean.FALSE;
            }
        }
        throw new com.alibaba.fastjson.JSONException("can not cast to int, value : " + obj);
    }

    public static final java.lang.Byte castToByte(java.lang.Object obj) {
        if (obj == null) {
            return null;
        }
        if (obj instanceof java.lang.Number) {
            return java.lang.Byte.valueOf(((java.lang.Number) obj).byteValue());
        }
        if (obj instanceof java.lang.String) {
            java.lang.String str = (java.lang.String) obj;
            if (str.length() == 0 || com.igexin.push.core.b.m.equals(str)) {
                return null;
            }
            return java.lang.Byte.valueOf(java.lang.Byte.parseByte(str));
        }
        if (obj instanceof java.lang.Boolean) {
            return java.lang.Byte.valueOf(((java.lang.Boolean) obj).booleanValue() ? (byte) 1 : (byte) 0);
        }
        throw new com.alibaba.fastjson.JSONException("can not cast to byte, value : " + obj);
    }

    public static final byte[] castToBytes(java.lang.Object obj) {
        if (obj instanceof byte[]) {
            return (byte[]) obj;
        }
        if (obj instanceof java.lang.String) {
            java.lang.String str = (java.lang.String) obj;
            return com.alibaba.fastjson.parser.JSONLexer.decodeFast(str, 0, str.length());
        }
        throw new com.alibaba.fastjson.JSONException("can not cast to int, value : " + obj);
    }

    public static final java.lang.Character castToChar(java.lang.Object obj) {
        if (obj == null) {
            return null;
        }
        if (obj instanceof java.lang.Character) {
            return (java.lang.Character) obj;
        }
        if (!(obj instanceof java.lang.String)) {
            throw new com.alibaba.fastjson.JSONException("can not cast to byte, value : " + obj);
        }
        java.lang.String str = (java.lang.String) obj;
        if (str.length() == 0) {
            return null;
        }
        if (str.length() == 1) {
            return java.lang.Character.valueOf(str.charAt(0));
        }
        throw new com.alibaba.fastjson.JSONException("can not cast to byte, value : " + obj);
    }

    public static final java.util.Date castToDate(java.lang.Object obj) {
        long j;
        if (obj == null) {
            return null;
        }
        if (obj instanceof java.util.Calendar) {
            return ((java.util.Calendar) obj).getTime();
        }
        if (obj instanceof java.util.Date) {
            return (java.util.Date) obj;
        }
        if (obj instanceof java.math.BigDecimal) {
            java.math.BigDecimal bigDecimal = (java.math.BigDecimal) obj;
            int scale = bigDecimal.scale();
            j = (scale < -100 || scale > 100) ? bigDecimal.longValueExact() : bigDecimal.longValue();
        } else if (obj instanceof java.lang.Number) {
            j = ((java.lang.Number) obj).longValue();
        } else if (obj instanceof java.lang.String) {
            java.lang.String str = (java.lang.String) obj;
            if (str.indexOf(45) != -1) {
                java.text.SimpleDateFormat simpleDateFormat = new java.text.SimpleDateFormat(str.length() == com.alibaba.fastjson.JSON.DEFFAULT_DATE_FORMAT.length() ? com.alibaba.fastjson.JSON.DEFFAULT_DATE_FORMAT : str.length() == 10 ? "yyyy-MM-dd" : str.length() == 19 ? "yyyy-MM-dd HH:mm:ss" : (str.length() == 29 && str.charAt(26) == ':' && str.charAt(28) == '0') ? "yyyy-MM-dd'T'HH:mm:ss.SSSXXX" : "yyyy-MM-dd HH:mm:ss.SSS", com.alibaba.fastjson.JSON.defaultLocale);
                simpleDateFormat.setTimeZone(com.alibaba.fastjson.JSON.defaultTimeZone);
                try {
                    return simpleDateFormat.parse(str);
                } catch (java.text.ParseException unused) {
                    throw new com.alibaba.fastjson.JSONException("can not cast to Date, value : " + str);
                }
            }
            if (str.length() == 0 || com.igexin.push.core.b.m.equals(str)) {
                return null;
            }
            j = java.lang.Long.parseLong(str);
        } else {
            j = -1;
        }
        if (j >= 0) {
            return new java.util.Date(j);
        }
        throw new com.alibaba.fastjson.JSONException("can not cast to Date, value : " + obj);
    }

    public static final java.lang.Double castToDouble(java.lang.Object obj) {
        if (obj == null) {
            return null;
        }
        if (obj instanceof java.lang.Number) {
            return java.lang.Double.valueOf(((java.lang.Number) obj).doubleValue());
        }
        if (obj instanceof java.lang.String) {
            java.lang.String obj2 = obj.toString();
            if (obj2.length() == 0 || com.igexin.push.core.b.m.equals(obj2) || "NULL".equals(obj2)) {
                return null;
            }
            return java.lang.Double.valueOf(java.lang.Double.parseDouble(obj2));
        }
        if (obj instanceof java.lang.Boolean) {
            return java.lang.Double.valueOf(((java.lang.Boolean) obj).booleanValue() ? 1.0d : 0.0d);
        }
        throw new com.alibaba.fastjson.JSONException("can not cast to double, value : " + obj);
    }

    public static final <T> T castToEnum(java.lang.Object obj, java.lang.Class<T> cls, com.alibaba.fastjson.parser.ParserConfig parserConfig) {
        try {
            if (obj instanceof java.lang.String) {
                java.lang.String str = (java.lang.String) obj;
                if (str.length() == 0) {
                    return null;
                }
                return (T) java.lang.Enum.valueOf(cls, str);
            }
            if ((obj instanceof java.lang.Integer) || (obj instanceof java.lang.Long)) {
                int intValue = ((java.lang.Number) obj).intValue();
                T[] enumConstants = cls.getEnumConstants();
                if (intValue < enumConstants.length) {
                    return enumConstants[intValue];
                }
            }
            throw new com.alibaba.fastjson.JSONException("can not cast to : " + cls.getName());
        } catch (java.lang.Exception e) {
            throw new com.alibaba.fastjson.JSONException("can not cast to : " + cls.getName(), e);
        }
    }

    public static final java.lang.Float castToFloat(java.lang.Object obj) {
        if (obj == null) {
            return null;
        }
        if (obj instanceof java.lang.Number) {
            return java.lang.Float.valueOf(((java.lang.Number) obj).floatValue());
        }
        if (obj instanceof java.lang.String) {
            java.lang.String obj2 = obj.toString();
            if (obj2.length() == 0 || com.igexin.push.core.b.m.equals(obj2)) {
                return null;
            }
            return java.lang.Float.valueOf(java.lang.Float.parseFloat(obj2));
        }
        if (obj instanceof java.lang.Boolean) {
            return java.lang.Float.valueOf(((java.lang.Boolean) obj).booleanValue() ? 1.0f : 0.0f);
        }
        throw new com.alibaba.fastjson.JSONException("can not cast to float, value : " + obj);
    }

    public static final java.lang.Integer castToInt(java.lang.Object obj) {
        if (obj == null) {
            return null;
        }
        if (obj instanceof java.lang.Integer) {
            return (java.lang.Integer) obj;
        }
        if (obj instanceof java.math.BigDecimal) {
            java.math.BigDecimal bigDecimal = (java.math.BigDecimal) obj;
            int scale = bigDecimal.scale();
            return (scale < -100 || scale > 100) ? java.lang.Integer.valueOf(bigDecimal.intValueExact()) : java.lang.Integer.valueOf(bigDecimal.intValue());
        }
        if (obj instanceof java.lang.Number) {
            return java.lang.Integer.valueOf(((java.lang.Number) obj).intValue());
        }
        if (obj instanceof java.lang.String) {
            java.lang.String str = (java.lang.String) obj;
            if (str.length() == 0 || com.igexin.push.core.b.m.equals(str)) {
                return null;
            }
            return java.lang.Integer.valueOf(java.lang.Integer.parseInt(str));
        }
        if (obj instanceof java.lang.Boolean) {
            return java.lang.Integer.valueOf(((java.lang.Boolean) obj).booleanValue() ? 1 : 0);
        }
        throw new com.alibaba.fastjson.JSONException("can not cast to int, value : " + obj);
    }

    public static final <T> T castToJavaBean(java.lang.Object obj, java.lang.Class<T> cls) {
        return (T) cast(obj, (java.lang.Class) cls, com.alibaba.fastjson.parser.ParserConfig.global);
    }

    public static final <T> T castToJavaBean(java.util.Map<java.lang.String, java.lang.Object> map, java.lang.Class<T> cls, com.alibaba.fastjson.parser.ParserConfig parserConfig) {
        return (T) castToJavaBean(map, cls, parserConfig, 0);
    }

    public static final <T> T castToJavaBean(java.util.Map<java.lang.String, java.lang.Object> map, java.lang.Class<T> cls, com.alibaba.fastjson.parser.ParserConfig parserConfig, int i) {
        int i2 = 0;
        try {
            if (cls == java.lang.StackTraceElement.class) {
                java.lang.String str = (java.lang.String) map.get(com.vivo.push.PushClientConstants.TAG_CLASS_NAME);
                java.lang.String str2 = (java.lang.String) map.get("methodName");
                java.lang.String str3 = (java.lang.String) map.get(com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField.TT_FILE_NAME);
                java.lang.Number number = (java.lang.Number) map.get("lineNumber");
                if (number != null) {
                    i2 = number instanceof java.math.BigDecimal ? ((java.math.BigDecimal) number).intValueExact() : number.intValue();
                }
                return (T) new java.lang.StackTraceElement(str, str2, str3, i2);
            }
            java.lang.Object obj = map.get(com.alibaba.fastjson.JSON.DEFAULT_TYPE_KEY);
            if (obj instanceof java.lang.String) {
                java.lang.String str4 = (java.lang.String) obj;
                if (parserConfig == null) {
                    parserConfig = com.alibaba.fastjson.parser.ParserConfig.global;
                }
                java.lang.Class<?> checkAutoType = parserConfig.checkAutoType(str4, null, i);
                if (checkAutoType == null) {
                    throw new java.lang.ClassNotFoundException(str4 + " not found");
                }
                if (!checkAutoType.equals(cls)) {
                    return (T) castToJavaBean(map, checkAutoType, parserConfig, i);
                }
            }
            if (cls.isInterface()) {
                com.alibaba.fastjson.JSONObject jSONObject = map instanceof com.alibaba.fastjson.JSONObject ? (com.alibaba.fastjson.JSONObject) map : new com.alibaba.fastjson.JSONObject(map);
                if (parserConfig == null) {
                    parserConfig = com.alibaba.fastjson.parser.ParserConfig.getGlobalInstance();
                }
                return parserConfig.getDeserializer(cls) != null ? (T) com.alibaba.fastjson.JSON.parseObject(com.alibaba.fastjson.JSON.toJSONString(jSONObject), cls) : (T) java.lang.reflect.Proxy.newProxyInstance(java.lang.Thread.currentThread().getContextClassLoader(), new java.lang.Class[]{cls}, jSONObject);
            }
            if (cls == java.lang.String.class && (map instanceof com.alibaba.fastjson.JSONObject)) {
                return (T) map.toString();
            }
            if (parserConfig == null) {
                parserConfig = com.alibaba.fastjson.parser.ParserConfig.global;
            }
            com.alibaba.fastjson.parser.deserializer.ObjectDeserializer deserializer = parserConfig.getDeserializer(cls);
            com.alibaba.fastjson.parser.JavaBeanDeserializer javaBeanDeserializer = deserializer instanceof com.alibaba.fastjson.parser.JavaBeanDeserializer ? (com.alibaba.fastjson.parser.JavaBeanDeserializer) deserializer : null;
            if (javaBeanDeserializer != null) {
                return (T) javaBeanDeserializer.createInstance(map, parserConfig);
            }
            throw new com.alibaba.fastjson.JSONException("can not get javaBeanDeserializer");
        } catch (java.lang.Exception e) {
            throw new com.alibaba.fastjson.JSONException(e.getMessage(), e);
        }
    }

    public static final java.lang.Long castToLong(java.lang.Object obj) {
        if (obj == null) {
            return null;
        }
        if (obj instanceof java.math.BigDecimal) {
            java.math.BigDecimal bigDecimal = (java.math.BigDecimal) obj;
            int scale = bigDecimal.scale();
            return (scale < -100 || scale > 100) ? java.lang.Long.valueOf(bigDecimal.longValueExact()) : java.lang.Long.valueOf(bigDecimal.longValue());
        }
        if (obj instanceof java.lang.Number) {
            return java.lang.Long.valueOf(((java.lang.Number) obj).longValue());
        }
        if (obj instanceof java.lang.String) {
            java.lang.String str = (java.lang.String) obj;
            if (str.length() == 0 || com.igexin.push.core.b.m.equals(str)) {
                return null;
            }
            try {
                return java.lang.Long.valueOf(java.lang.Long.parseLong(str));
            } catch (java.lang.NumberFormatException unused) {
                com.alibaba.fastjson.parser.JSONLexer jSONLexer = new com.alibaba.fastjson.parser.JSONLexer(str);
                java.util.Calendar calendar = jSONLexer.scanISO8601DateIfMatch(false) ? jSONLexer.calendar : null;
                jSONLexer.close();
                if (calendar != null) {
                    return java.lang.Long.valueOf(calendar.getTimeInMillis());
                }
            }
        }
        if (obj instanceof java.lang.Boolean) {
            return java.lang.Long.valueOf(((java.lang.Boolean) obj).booleanValue() ? 1L : 0L);
        }
        throw new com.alibaba.fastjson.JSONException("can not cast to long, value : " + obj);
    }

    public static final java.lang.Short castToShort(java.lang.Object obj) {
        if (obj == null) {
            return null;
        }
        if (obj instanceof java.lang.Number) {
            return java.lang.Short.valueOf(((java.lang.Number) obj).shortValue());
        }
        if (obj instanceof java.lang.String) {
            java.lang.String str = (java.lang.String) obj;
            if (str.length() == 0 || com.igexin.push.core.b.m.equals(str)) {
                return null;
            }
            return java.lang.Short.valueOf(java.lang.Short.parseShort(str));
        }
        if (obj instanceof java.lang.Boolean) {
            return java.lang.Short.valueOf(((java.lang.Boolean) obj).booleanValue() ? (short) 1 : (short) 0);
        }
        throw new com.alibaba.fastjson.JSONException("can not cast to short, value : " + obj);
    }

    public static final java.lang.String castToString(java.lang.Object obj) {
        if (obj == null) {
            return null;
        }
        return obj.toString();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v11, types: [java.lang.Class] */
    /* JADX WARN: Type inference failed for: r3v3, types: [java.lang.Class] */
    /* JADX WARN: Type inference failed for: r3v4, types: [java.lang.Class] */
    /* JADX WARN: Type inference failed for: r3v5, types: [java.lang.Class] */
    /* JADX WARN: Type inference failed for: r3v6, types: [java.lang.Class] */
    /* JADX WARN: Type inference failed for: r3v7, types: [java.lang.Class] */
    /* JADX WARN: Type inference failed for: r3v8, types: [java.lang.Class] */
    /* JADX WARN: Type inference failed for: r3v9, types: [java.lang.Class] */
    public static java.lang.reflect.Type checkPrimitiveArray(java.lang.reflect.GenericArrayType genericArrayType) {
        java.lang.reflect.Type genericComponentType = genericArrayType.getGenericComponentType();
        java.lang.String str = "[";
        while (genericComponentType instanceof java.lang.reflect.GenericArrayType) {
            genericComponentType = ((java.lang.reflect.GenericArrayType) genericComponentType).getGenericComponentType();
            str = str + str;
        }
        if (genericComponentType instanceof java.lang.Class) {
            java.lang.Class cls = (java.lang.Class) genericComponentType;
            if (cls.isPrimitive()) {
                try {
                    if (cls == java.lang.Boolean.TYPE) {
                        genericArrayType = java.lang.Class.forName(str + "Z");
                    } else if (cls == java.lang.Character.TYPE) {
                        genericArrayType = java.lang.Class.forName(str + "C");
                    } else if (cls == java.lang.Byte.TYPE) {
                        genericArrayType = java.lang.Class.forName(str + "B");
                    } else if (cls == java.lang.Short.TYPE) {
                        genericArrayType = java.lang.Class.forName(str + androidx.exifinterface.media.ExifInterface.LATITUDE_SOUTH);
                    } else if (cls == java.lang.Integer.TYPE) {
                        genericArrayType = java.lang.Class.forName(str + "I");
                    } else if (cls == java.lang.Long.TYPE) {
                        genericArrayType = java.lang.Class.forName(str + "J");
                    } else if (cls == java.lang.Float.TYPE) {
                        genericArrayType = java.lang.Class.forName(str + "F");
                    } else {
                        genericArrayType = genericArrayType;
                        if (cls == java.lang.Double.TYPE) {
                            genericArrayType = java.lang.Class.forName(str + "D");
                        }
                    }
                } catch (java.lang.ClassNotFoundException unused) {
                }
            }
        }
        return genericArrayType;
    }

    /* JADX WARN: Code restructure failed: missing block: B:175:0x044e, code lost:
    
        if (r0 == null) goto L211;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:311:0x05f5  */
    /* JADX WARN: Removed duplicated region for block: B:317:0x0607  */
    /* JADX WARN: Type inference failed for: r18v19, types: [java.lang.annotation.Annotation[][]] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static java.util.List<com.alibaba.fastjson.util.FieldInfo> computeGetters(java.lang.Class<?> cls, int i, boolean z, com.alibaba.fastjson.annotation.JSONType jSONType, java.util.Map<java.lang.String, java.lang.String> map, boolean z2, boolean z3, boolean z4, com.alibaba.fastjson.PropertyNamingStrategy propertyNamingStrategy) {
        java.lang.String[] strArr;
        boolean z5;
        boolean z6;
        int i2;
        int i3;
        java.util.Iterator it;
        java.lang.Class<com.alibaba.fastjson.annotation.JSONField> cls2;
        java.util.LinkedHashMap linkedHashMap;
        short[] sArr;
        java.lang.Class<com.alibaba.fastjson.annotation.JSONField> cls3;
        java.lang.Class<? super java.lang.Object> cls4;
        short[] sArr2;
        com.alibaba.fastjson.annotation.JSONField jSONField;
        java.lang.reflect.Constructor<?>[] constructorArr;
        com.alibaba.fastjson.annotation.JSONField[][] jSONFieldArr;
        java.lang.String[] strArr2;
        java.lang.reflect.Field[] fieldArr;
        java.util.HashMap hashMap;
        java.lang.Class<? super java.lang.Object> cls5;
        java.util.LinkedHashMap linkedHashMap2;
        java.lang.Class<com.alibaba.fastjson.annotation.JSONField> cls6;
        int i4;
        int i5;
        java.lang.String str;
        java.lang.reflect.Method method;
        java.util.LinkedHashMap linkedHashMap3;
        java.lang.Class<com.alibaba.fastjson.annotation.JSONField> cls7;
        java.lang.reflect.Field[] fieldArr2;
        java.util.HashMap hashMap2;
        int i6;
        java.lang.Class<com.alibaba.fastjson.annotation.JSONField> cls8;
        java.lang.reflect.Field[] fieldArr3;
        java.lang.String substring;
        java.util.LinkedHashMap linkedHashMap4;
        java.lang.Class<com.alibaba.fastjson.annotation.JSONField> cls9;
        com.alibaba.fastjson.PropertyNamingStrategy propertyNamingStrategy2;
        com.alibaba.fastjson.annotation.JSONField jSONField2;
        java.lang.String decapitalize;
        int i7;
        int i8;
        com.alibaba.fastjson.annotation.JSONField jSONField3;
        boolean z7;
        com.alibaba.fastjson.PropertyNamingStrategy propertyNamingStrategy3;
        com.alibaba.fastjson.annotation.JSONField jSONField4;
        java.lang.String[] strArr3;
        java.lang.reflect.Constructor<?>[] constructorArr2;
        com.alibaba.fastjson.annotation.JSONField[] jSONFieldArr2;
        int i9;
        java.lang.Class<?> cls10 = cls;
        int i10 = i;
        com.alibaba.fastjson.annotation.JSONType jSONType2 = jSONType;
        java.util.Map<java.lang.String, java.lang.String> map2 = map;
        java.util.LinkedHashMap linkedHashMap5 = new java.util.LinkedHashMap();
        java.util.HashMap hashMap3 = new java.util.HashMap();
        java.lang.reflect.Field[] declaredFields = cls.getDeclaredFields();
        java.lang.Class<? super java.lang.Object> cls11 = java.lang.Object.class;
        java.lang.Class<com.alibaba.fastjson.annotation.JSONField> cls12 = com.alibaba.fastjson.annotation.JSONField.class;
        if (!z) {
            boolean isKotlin = isKotlin(cls);
            java.util.ArrayList<java.lang.reflect.Method> arrayList = new java.util.ArrayList();
            for (java.lang.Class<?> cls13 = cls10; cls13 != null && cls13 != cls11; cls13 = cls13.getSuperclass()) {
                java.lang.reflect.Method[] declaredMethods = cls13.getDeclaredMethods();
                int length = declaredMethods.length;
                int i11 = 0;
                while (i11 < length) {
                    java.lang.reflect.Method method2 = declaredMethods[i11];
                    java.lang.reflect.Method[] methodArr = declaredMethods;
                    int modifiers = method2.getModifiers();
                    if ((modifiers & 8) == 0 && (modifiers & 2) == 0) {
                        i9 = length;
                        if ((modifiers & 256) == 0 && (modifiers & 4) == 0 && !method2.getReturnType().equals(java.lang.Void.TYPE) && method2.getParameterTypes().length == 0 && method2.getReturnType() != java.lang.ClassLoader.class && method2.getDeclaringClass() != cls11) {
                            arrayList.add(method2);
                        }
                    } else {
                        i9 = length;
                    }
                    i11++;
                    declaredMethods = methodArr;
                    length = i9;
                }
            }
            java.lang.reflect.Constructor<?>[] constructorArr3 = null;
            java.lang.String[] strArr4 = null;
            short[] sArr3 = null;
            com.alibaba.fastjson.annotation.JSONField[][] jSONFieldArr3 = null;
            for (java.lang.reflect.Method method3 : arrayList) {
                java.lang.String name = method3.getName();
                java.lang.String[] strArr5 = strArr4;
                if (name.equals("getMetaClass")) {
                    sArr = sArr3;
                    if (method3.getReturnType().getName().equals("groovy.lang.MetaClass")) {
                        strArr4 = strArr5;
                        sArr3 = sArr;
                    }
                } else {
                    sArr = sArr3;
                }
                com.alibaba.fastjson.annotation.JSONField jSONField5 = z3 ? (com.alibaba.fastjson.annotation.JSONField) method3.getAnnotation(cls12) : null;
                if (jSONField5 == null && z3) {
                    jSONField5 = getSupperMethodAnnotation(cls10, method3);
                }
                if (isKotlin && isKotlinIgnore(cls10, name)) {
                    strArr4 = strArr5;
                    sArr3 = sArr;
                } else {
                    java.util.LinkedHashMap linkedHashMap6 = linkedHashMap5;
                    if (jSONField5 == null && isKotlin) {
                        if (constructorArr3 == null) {
                            constructorArr3 = cls.getDeclaredConstructors();
                            com.alibaba.fastjson.annotation.JSONField[][] jSONFieldArr4 = jSONFieldArr3;
                            if (constructorArr3.length == 1) {
                                ?? parameterAnnotations = constructorArr3[0].getParameterAnnotations();
                                java.lang.String[] koltinConstructorParameters = getKoltinConstructorParameters(cls);
                                if (koltinConstructorParameters != null) {
                                    java.lang.String[] strArr6 = new java.lang.String[koltinConstructorParameters.length];
                                    cls3 = cls12;
                                    java.lang.System.arraycopy(koltinConstructorParameters, 0, strArr6, 0, koltinConstructorParameters.length);
                                    java.util.Arrays.sort(strArr6);
                                    short[] sArr4 = new short[koltinConstructorParameters.length];
                                    jSONField4 = jSONField5;
                                    for (short s2 = 0; s2 < koltinConstructorParameters.length; s2 = (short) (s2 + 1)) {
                                        sArr4[java.util.Arrays.binarySearch(strArr6, koltinConstructorParameters[s2])] = s2;
                                    }
                                    sArr = sArr4;
                                    strArr3 = strArr6;
                                    jSONFieldArr3 = parameterAnnotations;
                                    constructorArr3 = constructorArr3;
                                } else {
                                    jSONField4 = jSONField5;
                                    cls3 = cls12;
                                    strArr3 = koltinConstructorParameters;
                                    jSONFieldArr3 = parameterAnnotations;
                                }
                            } else {
                                jSONField4 = jSONField5;
                                cls3 = cls12;
                                strArr3 = strArr5;
                                jSONFieldArr3 = jSONFieldArr4;
                            }
                        } else {
                            jSONField4 = jSONField5;
                            cls3 = cls12;
                            strArr3 = strArr5;
                        }
                        if (strArr3 == null || sArr == null || !name.startsWith(com.ss.android.socialbase.downloader.constants.MonitorConstants.CONNECT_TYPE_GET)) {
                            constructorArr2 = constructorArr3;
                            cls4 = cls11;
                        } else {
                            java.lang.String decapitalize2 = decapitalize(name.substring(3));
                            int binarySearch = java.util.Arrays.binarySearch(strArr3, decapitalize2);
                            constructorArr2 = constructorArr3;
                            cls4 = cls11;
                            if (binarySearch < 0) {
                                int i12 = 0;
                                while (true) {
                                    if (i12 >= strArr3.length) {
                                        break;
                                    }
                                    if (decapitalize2.equalsIgnoreCase(strArr3[i12])) {
                                        binarySearch = i12;
                                        break;
                                    }
                                    i12++;
                                }
                            }
                            if (binarySearch >= 0 && (jSONFieldArr2 = jSONFieldArr3[sArr[binarySearch]]) != null) {
                                int length2 = jSONFieldArr2.length;
                                int i13 = 0;
                                while (i13 < length2) {
                                    com.alibaba.fastjson.annotation.JSONField jSONField6 = jSONFieldArr2[i13];
                                    com.alibaba.fastjson.annotation.JSONField[] jSONFieldArr5 = jSONFieldArr2;
                                    if (jSONField6 instanceof com.alibaba.fastjson.annotation.JSONField) {
                                        strArr2 = strArr3;
                                        jSONFieldArr = jSONFieldArr3;
                                        jSONField = jSONField6;
                                        sArr2 = sArr;
                                        constructorArr = constructorArr2;
                                        break;
                                    }
                                    i13++;
                                    jSONFieldArr2 = jSONFieldArr5;
                                }
                            }
                        }
                        strArr2 = strArr3;
                        sArr2 = sArr;
                        jSONField = jSONField4;
                        constructorArr = constructorArr2;
                        jSONFieldArr = jSONFieldArr3;
                    } else {
                        cls3 = cls12;
                        cls4 = cls11;
                        sArr2 = sArr;
                        jSONField = jSONField5;
                        constructorArr = constructorArr3;
                        jSONFieldArr = jSONFieldArr3;
                        strArr2 = strArr5;
                    }
                    if (jSONField != null) {
                        if (jSONField.serialize()) {
                            i4 = jSONField.ordinal();
                            i5 = com.alibaba.fastjson.serializer.SerializerFeature.of(jSONField.serialzeFeatures());
                            if (jSONField.name().length() != 0) {
                                java.lang.String name2 = jSONField.name();
                                if (map2 == null || (name2 = map2.get(name2)) != null) {
                                    java.lang.String str2 = name2;
                                    setAccessible(cls10, method3, i10);
                                    cls6 = cls3;
                                    cls5 = cls4;
                                    fieldArr = declaredFields;
                                    hashMap = hashMap3;
                                    linkedHashMap2 = linkedHashMap6;
                                    linkedHashMap2.put(str2, new com.alibaba.fastjson.util.FieldInfo(str2, method3, null, cls, null, i4, i5, jSONField, null, true));
                                    linkedHashMap5 = linkedHashMap2;
                                    cls8 = cls6;
                                    fieldArr3 = fieldArr;
                                    cls10 = cls;
                                    jSONType2 = jSONType;
                                    cls12 = cls8;
                                    declaredFields = fieldArr3;
                                    constructorArr3 = constructorArr;
                                    strArr4 = strArr2;
                                    sArr3 = sArr2;
                                    jSONFieldArr3 = jSONFieldArr;
                                    cls11 = cls5;
                                    hashMap3 = hashMap;
                                    i10 = i;
                                }
                            } else {
                                fieldArr = declaredFields;
                                hashMap = hashMap3;
                                cls5 = cls4;
                                linkedHashMap2 = linkedHashMap6;
                                cls6 = cls3;
                            }
                        }
                        fieldArr3 = declaredFields;
                        hashMap = hashMap3;
                        cls5 = cls4;
                        linkedHashMap5 = linkedHashMap6;
                        cls8 = cls3;
                        cls10 = cls;
                        jSONType2 = jSONType;
                        cls12 = cls8;
                        declaredFields = fieldArr3;
                        constructorArr3 = constructorArr;
                        strArr4 = strArr2;
                        sArr3 = sArr2;
                        jSONFieldArr3 = jSONFieldArr;
                        cls11 = cls5;
                        hashMap3 = hashMap;
                        i10 = i;
                    } else {
                        fieldArr = declaredFields;
                        hashMap = hashMap3;
                        cls5 = cls4;
                        linkedHashMap2 = linkedHashMap6;
                        cls6 = cls3;
                        i4 = 0;
                        i5 = 0;
                    }
                    if (name.startsWith(com.ss.android.socialbase.downloader.constants.MonitorConstants.CONNECT_TYPE_GET)) {
                        if (name.length() >= 4) {
                            if (!name.equals("getClass")) {
                                char charAt = name.charAt(3);
                                if (java.lang.Character.isUpperCase(charAt)) {
                                    decapitalize = compatibleWithJavaBean ? decapitalize(name.substring(3)) : java.lang.Character.toLowerCase(name.charAt(3)) + name.substring(4);
                                } else if (charAt == '_') {
                                    decapitalize = name.substring(4);
                                } else if (charAt == 'f') {
                                    decapitalize = name.substring(3);
                                } else if (name.length() >= 5 && java.lang.Character.isUpperCase(name.charAt(4))) {
                                    decapitalize = decapitalize(name.substring(3));
                                }
                                if (!isJSONTypeIgnore(cls10, jSONType2, decapitalize)) {
                                    java.lang.reflect.Field[] fieldArr4 = fieldArr;
                                    java.util.HashMap hashMap4 = hashMap;
                                    java.lang.reflect.Field field = getField(cls10, decapitalize, fieldArr4, hashMap4);
                                    java.lang.Class<com.alibaba.fastjson.annotation.JSONField> cls14 = cls6;
                                    if (field != null) {
                                        com.alibaba.fastjson.annotation.JSONField jSONField7 = z3 ? (com.alibaba.fastjson.annotation.JSONField) field.getAnnotation(cls14) : null;
                                        if (jSONField7 != null) {
                                            if (jSONField7.serialize()) {
                                                i4 = jSONField7.ordinal();
                                                i5 = com.alibaba.fastjson.serializer.SerializerFeature.of(jSONField7.serialzeFeatures());
                                                if (jSONField7.name().length() != 0) {
                                                    decapitalize = jSONField7.name();
                                                    if (map2 == null || (decapitalize = map2.get(decapitalize)) != null) {
                                                        i8 = i5;
                                                        jSONField3 = jSONField7;
                                                        propertyNamingStrategy3 = propertyNamingStrategy;
                                                        i7 = i4;
                                                        z7 = true;
                                                    }
                                                }
                                            }
                                            fieldArr3 = fieldArr4;
                                            hashMap = hashMap4;
                                            linkedHashMap5 = linkedHashMap2;
                                            cls8 = cls14;
                                            cls10 = cls;
                                            jSONType2 = jSONType;
                                            cls12 = cls8;
                                            declaredFields = fieldArr3;
                                            constructorArr3 = constructorArr;
                                            strArr4 = strArr2;
                                            sArr3 = sArr2;
                                            jSONFieldArr3 = jSONFieldArr;
                                            cls11 = cls5;
                                            hashMap3 = hashMap;
                                            i10 = i;
                                        }
                                        i8 = i5;
                                        jSONField3 = jSONField7;
                                        propertyNamingStrategy3 = propertyNamingStrategy;
                                        i7 = i4;
                                        z7 = false;
                                    } else {
                                        i7 = i4;
                                        i8 = i5;
                                        jSONField3 = null;
                                        z7 = false;
                                        propertyNamingStrategy3 = propertyNamingStrategy;
                                    }
                                    if (propertyNamingStrategy3 != null && !z7) {
                                        decapitalize = propertyNamingStrategy3.translate(decapitalize);
                                    }
                                    if (map2 == null || (decapitalize = map2.get(decapitalize)) != null) {
                                        java.util.LinkedHashMap linkedHashMap7 = linkedHashMap2;
                                        java.lang.String str3 = decapitalize;
                                        setAccessible(cls10, method3, i);
                                        linkedHashMap3 = linkedHashMap7;
                                        cls7 = cls14;
                                        fieldArr2 = fieldArr4;
                                        str = name;
                                        method = method3;
                                        i4 = i7;
                                        i5 = i8;
                                        hashMap2 = hashMap4;
                                        i6 = 3;
                                        linkedHashMap3.put(str3, new com.alibaba.fastjson.util.FieldInfo(str3, method3, field, cls, null, i4, i5, jSONField, jSONField3, z4));
                                    }
                                    fieldArr3 = fieldArr4;
                                    hashMap = hashMap4;
                                    linkedHashMap5 = linkedHashMap2;
                                    cls8 = cls14;
                                    cls10 = cls;
                                    jSONType2 = jSONType;
                                    cls12 = cls8;
                                    declaredFields = fieldArr3;
                                    constructorArr3 = constructorArr;
                                    strArr4 = strArr2;
                                    sArr3 = sArr2;
                                    jSONFieldArr3 = jSONFieldArr;
                                    cls11 = cls5;
                                    hashMap3 = hashMap;
                                    i10 = i;
                                }
                            }
                            linkedHashMap5 = linkedHashMap2;
                            cls8 = cls6;
                            fieldArr3 = fieldArr;
                            cls10 = cls;
                            jSONType2 = jSONType;
                            cls12 = cls8;
                            declaredFields = fieldArr3;
                            constructorArr3 = constructorArr;
                            strArr4 = strArr2;
                            sArr3 = sArr2;
                            jSONFieldArr3 = jSONFieldArr;
                            cls11 = cls5;
                            hashMap3 = hashMap;
                            i10 = i;
                        }
                        map2 = map;
                        linkedHashMap5 = linkedHashMap2;
                        cls8 = cls6;
                        fieldArr3 = fieldArr;
                        cls10 = cls;
                        jSONType2 = jSONType;
                        cls12 = cls8;
                        declaredFields = fieldArr3;
                        constructorArr3 = constructorArr;
                        strArr4 = strArr2;
                        sArr3 = sArr2;
                        jSONFieldArr3 = jSONFieldArr;
                        cls11 = cls5;
                        hashMap3 = hashMap;
                        i10 = i;
                    } else {
                        str = name;
                        method = method3;
                        linkedHashMap3 = linkedHashMap2;
                        cls7 = cls6;
                        fieldArr2 = fieldArr;
                        hashMap2 = hashMap;
                        i6 = 3;
                    }
                    if (str.startsWith("is") && str.length() >= i6) {
                        char charAt2 = str.charAt(2);
                        if (java.lang.Character.isUpperCase(charAt2)) {
                            substring = compatibleWithJavaBean ? decapitalize(str.substring(2)) : java.lang.Character.toLowerCase(str.charAt(2)) + str.substring(i6);
                        } else if (charAt2 == '_') {
                            substring = str.substring(i6);
                        } else if (charAt2 == 'f') {
                            substring = str.substring(2);
                        }
                        java.lang.String str4 = str;
                        if (!isJSONTypeIgnore(cls, jSONType, substring)) {
                            fieldArr3 = fieldArr2;
                            java.util.HashMap hashMap5 = hashMap2;
                            java.lang.reflect.Field field2 = getField(cls, substring, fieldArr3, hashMap5);
                            java.lang.reflect.Field field3 = field2 == null ? getField(cls, str4, fieldArr3, hashMap5) : field2;
                            if (field3 != null) {
                                cls9 = cls7;
                                com.alibaba.fastjson.annotation.JSONField jSONField8 = z3 ? (com.alibaba.fastjson.annotation.JSONField) field3.getAnnotation(cls9) : null;
                                if (jSONField8 == null) {
                                    linkedHashMap4 = linkedHashMap3;
                                    map2 = map;
                                    propertyNamingStrategy2 = propertyNamingStrategy;
                                    jSONField2 = jSONField8;
                                } else if (jSONField8.serialize()) {
                                    int ordinal = jSONField8.ordinal();
                                    int of = com.alibaba.fastjson.serializer.SerializerFeature.of(jSONField8.serialzeFeatures());
                                    if (jSONField8.name().length() != 0) {
                                        substring = jSONField8.name();
                                        linkedHashMap4 = linkedHashMap3;
                                        map2 = map;
                                        if (map2 != null) {
                                            substring = map2.get(substring);
                                        }
                                    } else {
                                        linkedHashMap4 = linkedHashMap3;
                                        map2 = map;
                                    }
                                    propertyNamingStrategy2 = propertyNamingStrategy;
                                    jSONField2 = jSONField8;
                                    i4 = ordinal;
                                    i5 = of;
                                } else {
                                    cls8 = cls9;
                                    hashMap = hashMap5;
                                    linkedHashMap5 = linkedHashMap3;
                                    map2 = map;
                                    cls10 = cls;
                                    jSONType2 = jSONType;
                                    cls12 = cls8;
                                    declaredFields = fieldArr3;
                                    constructorArr3 = constructorArr;
                                    strArr4 = strArr2;
                                    sArr3 = sArr2;
                                    jSONFieldArr3 = jSONFieldArr;
                                    cls11 = cls5;
                                    hashMap3 = hashMap;
                                    i10 = i;
                                }
                            } else {
                                linkedHashMap4 = linkedHashMap3;
                                cls9 = cls7;
                                map2 = map;
                                propertyNamingStrategy2 = propertyNamingStrategy;
                                jSONField2 = null;
                            }
                            if (propertyNamingStrategy2 != null) {
                                substring = propertyNamingStrategy2.translate(substring);
                            }
                            if (map2 == null || (substring = map2.get(substring)) != null) {
                                java.lang.String str5 = substring;
                                setAccessible(cls, field3, i);
                                java.lang.reflect.Method method4 = method;
                                setAccessible(cls, method4, i);
                                hashMap = hashMap5;
                                cls8 = cls9;
                                linkedHashMap5 = linkedHashMap4;
                                linkedHashMap5.put(str5, new com.alibaba.fastjson.util.FieldInfo(str5, method4, field3, cls, null, i4, i5, jSONField, jSONField2, z4));
                                cls10 = cls;
                                jSONType2 = jSONType;
                                cls12 = cls8;
                                declaredFields = fieldArr3;
                                constructorArr3 = constructorArr;
                                strArr4 = strArr2;
                                sArr3 = sArr2;
                                jSONFieldArr3 = jSONFieldArr;
                                cls11 = cls5;
                                hashMap3 = hashMap;
                                i10 = i;
                            }
                            cls8 = cls9;
                            hashMap = hashMap5;
                            linkedHashMap5 = linkedHashMap4;
                            cls10 = cls;
                            jSONType2 = jSONType;
                            cls12 = cls8;
                            declaredFields = fieldArr3;
                            constructorArr3 = constructorArr;
                            strArr4 = strArr2;
                            sArr3 = sArr2;
                            jSONFieldArr3 = jSONFieldArr;
                            cls11 = cls5;
                            hashMap3 = hashMap;
                            i10 = i;
                        }
                    }
                    linkedHashMap5 = linkedHashMap3;
                    cls8 = cls7;
                    fieldArr3 = fieldArr2;
                    hashMap = hashMap2;
                    map2 = map;
                    cls10 = cls;
                    jSONType2 = jSONType;
                    cls12 = cls8;
                    declaredFields = fieldArr3;
                    constructorArr3 = constructorArr;
                    strArr4 = strArr2;
                    sArr3 = sArr2;
                    jSONFieldArr3 = jSONFieldArr;
                    cls11 = cls5;
                    hashMap3 = hashMap;
                    i10 = i;
                }
            }
        }
        java.lang.Class<com.alibaba.fastjson.annotation.JSONField> cls15 = cls12;
        java.lang.Class<? super java.lang.Object> cls16 = cls11;
        java.lang.reflect.Field[] fieldArr5 = declaredFields;
        java.util.ArrayList arrayList2 = new java.util.ArrayList(fieldArr5.length);
        for (java.lang.reflect.Field field4 : fieldArr5) {
            if ((field4.getModifiers() & 8) == 0 && !field4.getName().equals("this$0") && (field4.getModifiers() & 1) != 0) {
                arrayList2.add(field4);
            }
        }
        java.lang.Class<? super java.lang.Object> superclass = cls.getSuperclass();
        while (superclass != null) {
            java.lang.Class<? super java.lang.Object> cls17 = cls16;
            if (superclass == cls17) {
                break;
            }
            for (java.lang.reflect.Field field5 : superclass.getDeclaredFields()) {
                if ((field5.getModifiers() & 8) == 0 && (field5.getModifiers() & 1) != 0) {
                    arrayList2.add(field5);
                }
            }
            superclass = superclass.getSuperclass();
            cls16 = cls17;
        }
        java.util.Iterator it2 = arrayList2.iterator();
        while (it2.hasNext()) {
            java.lang.reflect.Field field6 = (java.lang.reflect.Field) it2.next();
            com.alibaba.fastjson.annotation.JSONField jSONField9 = z3 ? (com.alibaba.fastjson.annotation.JSONField) field6.getAnnotation(cls15) : null;
            java.lang.String name3 = field6.getName();
            if (jSONField9 == null) {
                i2 = 0;
                i3 = 0;
            } else if (jSONField9.serialize()) {
                int ordinal2 = jSONField9.ordinal();
                int of2 = com.alibaba.fastjson.serializer.SerializerFeature.of(jSONField9.serialzeFeatures());
                if (jSONField9.name().length() != 0) {
                    name3 = jSONField9.name();
                }
                i2 = ordinal2;
                i3 = of2;
            }
            if (map2 == null || (name3 = map2.get(name3)) != null) {
                if (propertyNamingStrategy != null) {
                    name3 = propertyNamingStrategy.translate(name3);
                }
                java.lang.String str6 = name3;
                if (linkedHashMap5.containsKey(str6)) {
                    it = it2;
                    cls2 = cls15;
                    linkedHashMap = linkedHashMap5;
                } else {
                    cls2 = cls15;
                    setAccessible(cls, field6, i);
                    it = it2;
                    linkedHashMap = linkedHashMap5;
                    linkedHashMap.put(str6, new com.alibaba.fastjson.util.FieldInfo(str6, null, field6, cls, null, i2, i3, null, jSONField9, z4));
                }
                linkedHashMap5 = linkedHashMap;
                cls15 = cls2;
                it2 = it;
            }
        }
        java.util.LinkedHashMap linkedHashMap8 = linkedHashMap5;
        java.util.ArrayList arrayList3 = new java.util.ArrayList();
        if (jSONType != null) {
            strArr = jSONType.orders();
            if (strArr != null && strArr.length == linkedHashMap8.size()) {
                int length3 = strArr.length;
                int i14 = 0;
                while (true) {
                    if (i14 >= length3) {
                        z6 = true;
                        break;
                    }
                    if (!linkedHashMap8.containsKey(strArr[i14])) {
                        z6 = false;
                        break;
                    }
                    i14++;
                }
                z5 = z6;
                if (z5) {
                    java.util.Iterator it3 = linkedHashMap8.values().iterator();
                    while (it3.hasNext()) {
                        arrayList3.add((com.alibaba.fastjson.util.FieldInfo) it3.next());
                    }
                    if (z2) {
                        java.util.Collections.sort(arrayList3);
                    }
                } else {
                    for (java.lang.String str7 : strArr) {
                        arrayList3.add((com.alibaba.fastjson.util.FieldInfo) linkedHashMap8.get(str7));
                    }
                }
                return arrayList3;
            }
        } else {
            strArr = null;
        }
        z5 = false;
        if (z5) {
        }
        return arrayList3;
    }

    public static java.lang.String decapitalize(java.lang.String str) {
        if (str == null || str.length() == 0 || (str.length() > 1 && java.lang.Character.isUpperCase(str.charAt(1)) && java.lang.Character.isUpperCase(str.charAt(0)))) {
            return str;
        }
        char[] charArray = str.toCharArray();
        charArray[0] = java.lang.Character.toLowerCase(charArray[0]);
        return new java.lang.String(charArray);
    }

    public static java.lang.Object defaultValue(java.lang.Class<?> cls) {
        if (cls == java.lang.Byte.TYPE) {
            return (byte) 0;
        }
        if (cls == java.lang.Short.TYPE) {
            return (short) 0;
        }
        if (cls == java.lang.Integer.TYPE) {
            return 0;
        }
        if (cls == java.lang.Long.TYPE) {
            return 0L;
        }
        return cls == java.lang.Float.TYPE ? java.lang.Float.valueOf(0.0f) : cls == java.lang.Double.TYPE ? java.lang.Double.valueOf(0.0d) : cls == java.lang.Boolean.TYPE ? java.lang.Boolean.FALSE : cls == java.lang.Character.TYPE ? '0' : null;
    }

    public static long fnv_64_lower(java.lang.String str) {
        if (str == null) {
            return 0L;
        }
        long j = -3750763034362895579L;
        for (int i = 0; i < str.length(); i++) {
            char charAt = str.charAt(i);
            if (charAt != '_' && charAt != '-') {
                if (charAt >= 'A' && charAt <= 'Z') {
                    charAt = (char) (charAt + ' ');
                }
                j = (j ^ charAt) * 1099511628211L;
            }
        }
        return j;
    }

    public static boolean getArgument(java.lang.reflect.Type[] typeArr, java.lang.reflect.TypeVariable[] typeVariableArr, java.lang.reflect.Type[] typeArr2) {
        if (typeArr2 == null || typeVariableArr.length == 0) {
            return false;
        }
        boolean z = false;
        for (int i = 0; i < typeArr.length; i++) {
            java.lang.reflect.Type type = typeArr[i];
            if (type instanceof java.lang.reflect.ParameterizedType) {
                java.lang.reflect.ParameterizedType parameterizedType = (java.lang.reflect.ParameterizedType) type;
                java.lang.reflect.Type[] actualTypeArguments = parameterizedType.getActualTypeArguments();
                if (getArgument(actualTypeArguments, typeVariableArr, typeArr2)) {
                    typeArr[i] = new com.alibaba.fastjson.util.ParameterizedTypeImpl(actualTypeArguments, parameterizedType.getOwnerType(), parameterizedType.getRawType());
                    z = true;
                }
            } else if (type instanceof java.lang.reflect.TypeVariable) {
                for (int i2 = 0; i2 < typeVariableArr.length; i2++) {
                    if (type.equals(typeVariableArr[i2])) {
                        typeArr[i] = typeArr2[i2];
                        z = true;
                    }
                }
            }
        }
        return z;
    }

    public static java.lang.Class<?> getClass(java.lang.reflect.Type type) {
        if (type.getClass() == java.lang.Class.class) {
            return (java.lang.Class) type;
        }
        if (type instanceof java.lang.reflect.ParameterizedType) {
            return getClass(((java.lang.reflect.ParameterizedType) type).getRawType());
        }
        if (type instanceof java.lang.reflect.TypeVariable) {
            return (java.lang.Class) ((java.lang.reflect.TypeVariable) type).getBounds()[0];
        }
        if (!(type instanceof java.lang.reflect.WildcardType)) {
            return java.lang.Object.class;
        }
        java.lang.reflect.Type[] upperBounds = ((java.lang.reflect.WildcardType) type).getUpperBounds();
        return upperBounds.length == 1 ? getClass(upperBounds[0]) : java.lang.Object.class;
    }

    public static java.lang.Class<?> getClassFromMapping(java.lang.String str) {
        return mappings.get(str);
    }

    public static java.lang.reflect.Type getCollectionItemType(java.lang.reflect.Type type) {
        java.lang.reflect.Type type2;
        if (type instanceof java.lang.reflect.ParameterizedType) {
            type2 = ((java.lang.reflect.ParameterizedType) type).getActualTypeArguments()[0];
            if (type2 instanceof java.lang.reflect.WildcardType) {
                java.lang.reflect.Type[] upperBounds = ((java.lang.reflect.WildcardType) type2).getUpperBounds();
                if (upperBounds.length == 1) {
                    type2 = upperBounds[0];
                }
            }
        } else {
            if (type instanceof java.lang.Class) {
                java.lang.Class cls = (java.lang.Class) type;
                if (!cls.getName().startsWith("java.")) {
                    type2 = getCollectionItemType(cls.getGenericSuperclass());
                }
            }
            type2 = null;
        }
        return type2 == null ? java.lang.Object.class : type2;
    }

    public static java.lang.reflect.Field getField(java.lang.Class<?> cls, java.lang.String str, java.lang.reflect.Field[] fieldArr) {
        return getField(cls, str, fieldArr, null);
    }

    public static java.lang.reflect.Field getField(java.lang.Class<?> cls, java.lang.String str, java.lang.reflect.Field[] fieldArr, java.util.Map<java.lang.Class<?>, java.lang.reflect.Field[]> map) {
        java.lang.reflect.Field field0 = getField0(cls, str, fieldArr, map);
        if (field0 == null) {
            field0 = getField0(cls, "_" + str, fieldArr, map);
        }
        if (field0 == null) {
            field0 = getField0(cls, "m_" + str, fieldArr, map);
        }
        if (field0 != null) {
            return field0;
        }
        return getField0(cls, com.anythink.expressad.d.a.b.dH + str.substring(0, 1).toUpperCase() + str.substring(1), fieldArr, map);
    }

    private static java.lang.reflect.Field getField0(java.lang.Class<?> cls, java.lang.String str, java.lang.reflect.Field[] fieldArr, java.util.Map<java.lang.Class<?>, java.lang.reflect.Field[]> map) {
        char charAt;
        char charAt2;
        for (java.lang.reflect.Field field : fieldArr) {
            java.lang.String name = field.getName();
            if (str.equals(name)) {
                return field;
            }
            if (str.length() > 2 && (charAt = str.charAt(0)) >= 'a' && charAt <= 'z' && (charAt2 = str.charAt(1)) >= 'A' && charAt2 <= 'Z' && str.equalsIgnoreCase(name)) {
                return field;
            }
        }
        java.lang.Class<? super java.lang.Object> superclass = cls.getSuperclass();
        if (superclass == null || superclass == java.lang.Object.class) {
            return null;
        }
        java.lang.reflect.Field[] fieldArr2 = map != null ? map.get(superclass) : null;
        if (fieldArr2 == null) {
            fieldArr2 = superclass.getDeclaredFields();
            if (map != null) {
                map.put(superclass, fieldArr2);
            }
        }
        return getField(superclass, str, fieldArr2, map);
    }

    public static java.lang.reflect.Type getGenericParamType(java.lang.reflect.Type type) {
        return type instanceof java.lang.Class ? getGenericParamType(((java.lang.Class) type).getGenericSuperclass()) : type;
    }

    public static java.lang.String[] getKoltinConstructorParameters(java.lang.Class cls) {
        if (kotlin_kclass_constructor == null && !kotlin_class_klass_error) {
            try {
                java.lang.Class<?> cls2 = java.lang.Class.forName("kotlin.reflect.jvm.internal.KClassImpl");
                kotlin_kclass_constructor = cls2.getConstructor(java.lang.Class.class);
                kotlin_kclass_getConstructors = cls2.getMethod("getConstructors", new java.lang.Class[0]);
                kotlin_kfunction_getParameters = kotlin.reflect.KFunction.class.getMethod("getParameters", new java.lang.Class[0]);
                kotlin_kparameter_getName = kotlin.reflect.KParameter.class.getMethod("getName", new java.lang.Class[0]);
            } catch (java.lang.Throwable unused) {
                kotlin_class_klass_error = true;
            }
        }
        if (kotlin_kclass_constructor == null || kotlin_error) {
            return null;
        }
        try {
            java.util.Iterator it = ((java.lang.Iterable) kotlin_kclass_getConstructors.invoke(kotlin_kclass_constructor.newInstance(cls), new java.lang.Object[0])).iterator();
            java.lang.Object obj = null;
            while (it.hasNext()) {
                java.lang.Object next = it.next();
                java.util.List list = (java.util.List) kotlin_kfunction_getParameters.invoke(next, new java.lang.Object[0]);
                if (obj == null || list.size() != 0) {
                    obj = next;
                }
                it.hasNext();
            }
            java.util.List list2 = (java.util.List) kotlin_kfunction_getParameters.invoke(obj, new java.lang.Object[0]);
            java.lang.String[] strArr = new java.lang.String[list2.size()];
            for (int i = 0; i < list2.size(); i++) {
                strArr[i] = (java.lang.String) kotlin_kparameter_getName.invoke(list2.get(i), new java.lang.Object[0]);
            }
            return strArr;
        } catch (java.lang.Throwable unused2) {
            kotlin_error = true;
            return null;
        }
    }

    public static com.alibaba.fastjson.annotation.JSONField getSupperMethodAnnotation(java.lang.Class<?> cls, java.lang.reflect.Method method) {
        boolean z;
        com.alibaba.fastjson.annotation.JSONField jSONField;
        boolean z2;
        com.alibaba.fastjson.annotation.JSONField jSONField2;
        for (java.lang.Class<?> cls2 : cls.getInterfaces()) {
            for (java.lang.reflect.Method method2 : cls2.getMethods()) {
                if (method2.getName().equals(method.getName())) {
                    java.lang.Class<?>[] parameterTypes = method2.getParameterTypes();
                    java.lang.Class<?>[] parameterTypes2 = method.getParameterTypes();
                    if (parameterTypes.length != parameterTypes2.length) {
                        continue;
                    } else {
                        int i = 0;
                        while (true) {
                            if (i >= parameterTypes.length) {
                                z2 = true;
                                break;
                            }
                            if (!parameterTypes[i].equals(parameterTypes2[i])) {
                                z2 = false;
                                break;
                            }
                            i++;
                        }
                        if (z2 && (jSONField2 = (com.alibaba.fastjson.annotation.JSONField) method2.getAnnotation(com.alibaba.fastjson.annotation.JSONField.class)) != null) {
                            return jSONField2;
                        }
                    }
                }
            }
        }
        java.lang.Class<? super java.lang.Object> superclass = cls.getSuperclass();
        if (superclass != null && java.lang.reflect.Modifier.isAbstract(superclass.getModifiers())) {
            java.lang.Class<?>[] parameterTypes3 = method.getParameterTypes();
            for (java.lang.reflect.Method method3 : superclass.getMethods()) {
                java.lang.Class<?>[] parameterTypes4 = method3.getParameterTypes();
                if (parameterTypes4.length == parameterTypes3.length && method3.getName().equals(method.getName())) {
                    int i2 = 0;
                    while (true) {
                        if (i2 >= parameterTypes3.length) {
                            z = true;
                            break;
                        }
                        if (!parameterTypes4[i2].equals(parameterTypes3[i2])) {
                            z = false;
                            break;
                        }
                        i2++;
                    }
                    if (z && (jSONField = (com.alibaba.fastjson.annotation.JSONField) method3.getAnnotation(com.alibaba.fastjson.annotation.JSONField.class)) != null) {
                        return jSONField;
                    }
                }
            }
        }
        return null;
    }

    public static boolean isGenericParamType(java.lang.reflect.Type type) {
        java.lang.reflect.Type genericSuperclass;
        if (type instanceof java.lang.reflect.ParameterizedType) {
            return true;
        }
        return (type instanceof java.lang.Class) && (genericSuperclass = ((java.lang.Class) type).getGenericSuperclass()) != java.lang.Object.class && isGenericParamType(genericSuperclass);
    }

    private static boolean isJSONTypeIgnore(java.lang.Class<?> cls, com.alibaba.fastjson.annotation.JSONType jSONType, java.lang.String str) {
        if (jSONType != null && jSONType.ignores() != null) {
            for (java.lang.String str2 : jSONType.ignores()) {
                if (str.equalsIgnoreCase(str2)) {
                    return true;
                }
            }
        }
        java.lang.Class<? super java.lang.Object> superclass = cls.getSuperclass();
        return (superclass == java.lang.Object.class || superclass == null || !isJSONTypeIgnore(superclass, (com.alibaba.fastjson.annotation.JSONType) superclass.getAnnotation(com.alibaba.fastjson.annotation.JSONType.class), str)) ? false : true;
    }

    public static boolean isKotlin(java.lang.Class cls) {
        if (kotlin_metadata == null && !kotlin_metadata_error) {
            try {
                kotlin_metadata = kotlin.Metadata.class;
            } catch (java.lang.Throwable unused) {
                kotlin_metadata_error = true;
            }
        }
        if (kotlin_metadata == null) {
            return false;
        }
        return cls.isAnnotationPresent(kotlin_metadata);
    }

    private static boolean isKotlinIgnore(java.lang.Class cls, java.lang.String str) {
        java.lang.String[] strArr;
        if (kotlinIgnores == null && !kotlinIgnores_error) {
            try {
                java.util.HashMap hashMap = new java.util.HashMap();
                kotlin.ranges.CharRange.Companion companion = kotlin.ranges.CharRange.INSTANCE;
                hashMap.put(kotlin.ranges.CharRange.class, new java.lang.String[]{"getEndInclusive", "isEmpty"});
                kotlin.ranges.IntRange.Companion companion2 = kotlin.ranges.IntRange.INSTANCE;
                hashMap.put(kotlin.ranges.IntRange.class, new java.lang.String[]{"getEndInclusive", "isEmpty"});
                kotlin.ranges.LongRange.Companion companion3 = kotlin.ranges.LongRange.INSTANCE;
                hashMap.put(kotlin.ranges.LongRange.class, new java.lang.String[]{"getEndInclusive", "isEmpty"});
                hashMap.put(java.lang.Class.forName("kotlin.ranges.ClosedFloatRange"), new java.lang.String[]{"getEndInclusive", "isEmpty"});
                hashMap.put(java.lang.Class.forName("kotlin.ranges.ClosedDoubleRange"), new java.lang.String[]{"getEndInclusive", "isEmpty"});
                kotlinIgnores = hashMap;
            } catch (java.lang.Throwable unused) {
                kotlinIgnores_error = true;
            }
        }
        return (kotlinIgnores == null || (strArr = kotlinIgnores.get(cls)) == null || java.util.Arrays.binarySearch(strArr, str) < 0) ? false : true;
    }

    public static java.lang.Class<?> loadClass(java.lang.String str, java.lang.ClassLoader classLoader) {
        return loadClass(str, classLoader, false);
    }

    public static java.lang.Class<?> loadClass(java.lang.String str, java.lang.ClassLoader classLoader, boolean z) {
        if (str == null || str.length() == 0) {
            return null;
        }
        if (str.length() >= 256) {
            throw new com.alibaba.fastjson.JSONException("className too long. " + str);
        }
        java.util.concurrent.ConcurrentMap<java.lang.String, java.lang.Class<?>> concurrentMap = mappings;
        java.lang.Class<?> cls = concurrentMap.get(str);
        if (cls != null) {
            return cls;
        }
        if (str.charAt(0) == '[') {
            java.lang.Class<?> loadClass = loadClass(str.substring(1), classLoader, false);
            if (loadClass == null) {
                return null;
            }
            return java.lang.reflect.Array.newInstance(loadClass, 0).getClass();
        }
        if (str.startsWith("L") && str.endsWith(com.alipay.sdk.m.u.i.b)) {
            return loadClass(str.substring(1, str.length() - 1), classLoader, false);
        }
        if (classLoader != null) {
            try {
                cls = classLoader.loadClass(str);
                if (z) {
                    concurrentMap.put(str, cls);
                }
                return cls;
            } catch (java.lang.Exception unused) {
            }
        }
        try {
            java.lang.ClassLoader contextClassLoader = java.lang.Thread.currentThread().getContextClassLoader();
            if (contextClassLoader != null && contextClassLoader != classLoader) {
                java.lang.Class<?> loadClass2 = contextClassLoader.loadClass(str);
                if (z) {
                    try {
                        mappings.put(str, loadClass2);
                    } catch (java.lang.Exception unused2) {
                        cls = loadClass2;
                    }
                }
                return loadClass2;
            }
        } catch (java.lang.Exception unused3) {
        }
        try {
            cls = java.lang.Class.forName(str);
            if (z) {
                mappings.put(str, cls);
            }
        } catch (java.lang.Exception unused4) {
        }
        return cls;
    }

    public static double parseDouble(java.lang.String str) {
        double d;
        double d2;
        int length = str.length();
        if (length > 10) {
            return java.lang.Double.parseDouble(str);
        }
        long j = 0;
        boolean z = false;
        int i = 0;
        for (int i2 = 0; i2 < length; i2++) {
            char charAt = str.charAt(i2);
            if (charAt == '-' && i2 == 0) {
                z = true;
            } else if (charAt == '.') {
                if (i != 0) {
                    return java.lang.Double.parseDouble(str);
                }
                i = (length - i2) - 1;
            } else {
                if (charAt < '0' || charAt > '9') {
                    return java.lang.Double.parseDouble(str);
                }
                j = (j * 10) + (charAt - '0');
            }
        }
        if (z) {
            j = -j;
        }
        switch (i) {
            case 0:
                return j;
            case 1:
                d = j;
                d2 = 10.0d;
                break;
            case 2:
                d = j;
                d2 = 100.0d;
                break;
            case 3:
                d = j;
                d2 = 1000.0d;
                break;
            case 4:
                d = j;
                d2 = 10000.0d;
                break;
            case 5:
                d = j;
                d2 = 100000.0d;
                break;
            case 6:
                d = j;
                d2 = 1000000.0d;
                break;
            case 7:
                d = j;
                d2 = 1.0E7d;
                break;
            case 8:
                d = j;
                d2 = 1.0E8d;
                break;
            case 9:
                d = j;
                d2 = 1.0E9d;
                break;
            default:
                return java.lang.Double.parseDouble(str);
        }
        return d / d2;
    }

    public static float parseFloat(java.lang.String str) {
        float f;
        float f2;
        int length = str.length();
        if (length >= 10) {
            return java.lang.Float.parseFloat(str);
        }
        long j = 0;
        boolean z = false;
        int i = 0;
        for (int i2 = 0; i2 < length; i2++) {
            char charAt = str.charAt(i2);
            if (charAt == '-' && i2 == 0) {
                z = true;
            } else if (charAt == '.') {
                if (i != 0) {
                    return java.lang.Float.parseFloat(str);
                }
                i = (length - i2) - 1;
            } else {
                if (charAt < '0' || charAt > '9') {
                    return java.lang.Float.parseFloat(str);
                }
                j = (j * 10) + (charAt - '0');
            }
        }
        if (z) {
            j = -j;
        }
        switch (i) {
            case 0:
                return j;
            case 1:
                f = j;
                f2 = 10.0f;
                break;
            case 2:
                f = j;
                f2 = 100.0f;
                break;
            case 3:
                f = j;
                f2 = 1000.0f;
                break;
            case 4:
                f = j;
                f2 = 10000.0f;
                break;
            case 5:
                f = j;
                f2 = 100000.0f;
                break;
            case 6:
                f = j;
                f2 = 1000000.0f;
                break;
            case 7:
                f = j;
                f2 = 1.0E7f;
                break;
            case 8:
                f = j;
                f2 = 1.0E8f;
                break;
            case 9:
                f = j;
                f2 = 1.0E9f;
                break;
            default:
                return java.lang.Float.parseFloat(str);
        }
        return f / f2;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static boolean setAccessible(java.lang.Class<?> cls, java.lang.reflect.Member member, int i) {
        if (member != 0 && setAccessibleEnable) {
            java.lang.Class<? super java.lang.Object> superclass = cls.getSuperclass();
            if ((superclass == null || superclass == java.lang.Object.class) && (member.getModifiers() & 1) != 0 && (i & 1) != 0) {
                return false;
            }
            try {
                ((java.lang.reflect.AccessibleObject) member).setAccessible(true);
                return true;
            } catch (java.security.AccessControlException unused) {
                setAccessibleEnable = false;
            }
        }
        return false;
    }
}
