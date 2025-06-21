package com.alibaba.fastjson;

/* loaded from: classes.dex */
public abstract class JSON implements com.alibaba.fastjson.JSONStreamAware, com.alibaba.fastjson.JSONAware {
    public static final java.lang.String DEFAULT_TYPE_KEY = "@type";
    public static final java.lang.String VERSION = "1.1.74";
    public static java.util.TimeZone defaultTimeZone = java.util.TimeZone.getDefault();
    public static java.util.Locale defaultLocale = java.util.Locale.getDefault();
    public static int DEFAULT_PARSER_FEATURE = ((com.alibaba.fastjson.parser.Feature.UseBigDecimal.mask | 0) | com.alibaba.fastjson.parser.Feature.SortFeidFastMatch.mask) | com.alibaba.fastjson.parser.Feature.IgnoreNotMatch.mask;
    public static java.lang.String DEFFAULT_DATE_FORMAT = "yyyy-MM-dd HH:mm:ss";
    public static int DEFAULT_GENERATE_FEATURE = (((com.alibaba.fastjson.serializer.SerializerFeature.QuoteFieldNames.mask | 0) | com.alibaba.fastjson.serializer.SerializerFeature.SkipTransientField.mask) | com.alibaba.fastjson.serializer.SerializerFeature.WriteEnumUsingToString.mask) | com.alibaba.fastjson.serializer.SerializerFeature.SortField.mask;

    public static final java.lang.Object parse(java.lang.String str) {
        return parse(str, DEFAULT_PARSER_FEATURE);
    }

    public static final java.lang.Object parse(java.lang.String str, int i) {
        if (str == null) {
            return null;
        }
        com.alibaba.fastjson.parser.DefaultJSONParser defaultJSONParser = new com.alibaba.fastjson.parser.DefaultJSONParser(str, com.alibaba.fastjson.parser.ParserConfig.global, i);
        java.lang.Object parse = defaultJSONParser.parse(null);
        defaultJSONParser.handleResovleTask(parse);
        defaultJSONParser.close();
        return parse;
    }

    public static java.lang.Object parse(java.lang.String str, com.alibaba.fastjson.parser.ParserConfig parserConfig) {
        return parse(str, parserConfig, DEFAULT_PARSER_FEATURE);
    }

    public static java.lang.Object parse(java.lang.String str, com.alibaba.fastjson.parser.ParserConfig parserConfig, int i) {
        if (str == null) {
            return null;
        }
        com.alibaba.fastjson.parser.DefaultJSONParser defaultJSONParser = new com.alibaba.fastjson.parser.DefaultJSONParser(str, parserConfig, i);
        java.lang.Object parse = defaultJSONParser.parse();
        defaultJSONParser.handleResovleTask(parse);
        defaultJSONParser.close();
        return parse;
    }

    public static java.lang.Object parse(java.lang.String str, com.alibaba.fastjson.parser.ParserConfig parserConfig, com.alibaba.fastjson.parser.Feature... featureArr) {
        int i = DEFAULT_PARSER_FEATURE;
        for (com.alibaba.fastjson.parser.Feature feature : featureArr) {
            i |= feature.mask;
        }
        return parse(str, parserConfig, i);
    }

    public static final java.lang.Object parse(java.lang.String str, com.alibaba.fastjson.parser.Feature... featureArr) {
        int i = DEFAULT_PARSER_FEATURE;
        for (com.alibaba.fastjson.parser.Feature feature : featureArr) {
            i |= feature.mask;
        }
        return parse(str, i);
    }

    public static final java.lang.Object parse(byte[] bArr, com.alibaba.fastjson.parser.Feature... featureArr) {
        try {
            return parseObject(new java.lang.String(bArr, "UTF-8"), featureArr);
        } catch (java.io.UnsupportedEncodingException e) {
            throw new com.alibaba.fastjson.JSONException("UTF-8 not support", e);
        }
    }

    public static final com.alibaba.fastjson.JSONArray parseArray(java.lang.String str) {
        return parseArray(str, new com.alibaba.fastjson.parser.Feature[0]);
    }

    public static final com.alibaba.fastjson.JSONArray parseArray(java.lang.String str, com.alibaba.fastjson.parser.Feature... featureArr) {
        com.alibaba.fastjson.JSONArray jSONArray = null;
        if (str == null) {
            return null;
        }
        int i = DEFAULT_PARSER_FEATURE;
        for (com.alibaba.fastjson.parser.Feature feature : featureArr) {
            i |= feature.mask;
        }
        com.alibaba.fastjson.parser.DefaultJSONParser defaultJSONParser = new com.alibaba.fastjson.parser.DefaultJSONParser(str, com.alibaba.fastjson.parser.ParserConfig.global, i);
        com.alibaba.fastjson.parser.JSONLexer jSONLexer = defaultJSONParser.lexer;
        int i2 = jSONLexer.token();
        if (i2 == 8) {
            jSONLexer.nextToken();
        } else if (i2 != 20) {
            com.alibaba.fastjson.JSONArray jSONArray2 = new com.alibaba.fastjson.JSONArray();
            defaultJSONParser.parseArray(jSONArray2, (java.lang.Object) null);
            defaultJSONParser.handleResovleTask(jSONArray2);
            jSONArray = jSONArray2;
        }
        defaultJSONParser.close();
        return jSONArray;
    }

    public static final <T> java.util.List<T> parseArray(java.lang.String str, java.lang.Class<T> cls) {
        java.util.ArrayList arrayList = null;
        if (str == null) {
            return null;
        }
        com.alibaba.fastjson.parser.DefaultJSONParser defaultJSONParser = new com.alibaba.fastjson.parser.DefaultJSONParser(str, com.alibaba.fastjson.parser.ParserConfig.global);
        com.alibaba.fastjson.parser.JSONLexer jSONLexer = defaultJSONParser.lexer;
        int i = jSONLexer.token();
        if (i == 8) {
            jSONLexer.nextToken();
        } else if (i != 20 || !jSONLexer.isBlankInput()) {
            arrayList = new java.util.ArrayList();
            defaultJSONParser.parseArray((java.lang.Class<?>) cls, (java.util.Collection) arrayList);
            defaultJSONParser.handleResovleTask(arrayList);
        }
        defaultJSONParser.close();
        return arrayList;
    }

    public static final java.util.List<java.lang.Object> parseArray(java.lang.String str, java.lang.reflect.Type[] typeArr) {
        if (str == null) {
            return null;
        }
        com.alibaba.fastjson.parser.DefaultJSONParser defaultJSONParser = new com.alibaba.fastjson.parser.DefaultJSONParser(str, com.alibaba.fastjson.parser.ParserConfig.global);
        java.lang.Object[] parseArray = defaultJSONParser.parseArray(typeArr);
        java.util.List<java.lang.Object> asList = parseArray != null ? java.util.Arrays.asList(parseArray) : null;
        defaultJSONParser.handleResovleTask(asList);
        defaultJSONParser.close();
        return asList;
    }

    public static final com.alibaba.fastjson.JSONObject parseObject(java.lang.String str) {
        java.lang.Object parse = parse(str);
        if ((parse instanceof com.alibaba.fastjson.JSONObject) || parse == null) {
            return (com.alibaba.fastjson.JSONObject) parse;
        }
        com.alibaba.fastjson.JSONObject jSONObject = (com.alibaba.fastjson.JSONObject) toJSON(parse);
        if ((DEFAULT_PARSER_FEATURE & com.alibaba.fastjson.parser.Feature.SupportAutoType.mask) != 0) {
            jSONObject.put(DEFAULT_TYPE_KEY, (java.lang.Object) parse.getClass().getName());
        }
        return jSONObject;
    }

    public static final com.alibaba.fastjson.JSONObject parseObject(java.lang.String str, com.alibaba.fastjson.parser.Feature... featureArr) {
        java.lang.Object parse = parse(str, featureArr);
        if (parse instanceof com.alibaba.fastjson.JSONObject) {
            return (com.alibaba.fastjson.JSONObject) parse;
        }
        com.alibaba.fastjson.JSONObject jSONObject = (com.alibaba.fastjson.JSONObject) toJSON(parse);
        boolean z = (DEFAULT_PARSER_FEATURE & com.alibaba.fastjson.parser.Feature.SupportAutoType.mask) != 0;
        if (!z) {
            for (com.alibaba.fastjson.parser.Feature feature : featureArr) {
                if (feature == com.alibaba.fastjson.parser.Feature.SupportAutoType) {
                    z = true;
                }
            }
        }
        if (z) {
            jSONObject.put(DEFAULT_TYPE_KEY, (java.lang.Object) parse.getClass().getName());
        }
        return jSONObject;
    }

    public static final <T> T parseObject(java.lang.String str, com.alibaba.fastjson.TypeReference<T> typeReference, com.alibaba.fastjson.parser.Feature... featureArr) {
        return (T) parseObject(str, typeReference.type, com.alibaba.fastjson.parser.ParserConfig.global, DEFAULT_PARSER_FEATURE, featureArr);
    }

    public static final <T> T parseObject(java.lang.String str, java.lang.Class<T> cls) {
        return (T) parseObject(str, (java.lang.Class) cls, new com.alibaba.fastjson.parser.Feature[0]);
    }

    public static final <T> T parseObject(java.lang.String str, java.lang.Class<T> cls, com.alibaba.fastjson.parser.deserializer.ParseProcess parseProcess, com.alibaba.fastjson.parser.Feature... featureArr) {
        return (T) parseObject(str, cls, com.alibaba.fastjson.parser.ParserConfig.global, parseProcess, DEFAULT_PARSER_FEATURE, featureArr);
    }

    public static final <T> T parseObject(java.lang.String str, java.lang.Class<T> cls, com.alibaba.fastjson.parser.Feature... featureArr) {
        return (T) parseObject(str, cls, com.alibaba.fastjson.parser.ParserConfig.global, DEFAULT_PARSER_FEATURE, featureArr);
    }

    public static final <T> T parseObject(java.lang.String str, java.lang.reflect.Type type, int i, com.alibaba.fastjson.parser.Feature... featureArr) {
        if (str == null) {
            return null;
        }
        for (com.alibaba.fastjson.parser.Feature feature : featureArr) {
            i |= feature.mask;
        }
        com.alibaba.fastjson.parser.DefaultJSONParser defaultJSONParser = new com.alibaba.fastjson.parser.DefaultJSONParser(str, com.alibaba.fastjson.parser.ParserConfig.global, i);
        T t = (T) defaultJSONParser.parseObject(type);
        defaultJSONParser.handleResovleTask(t);
        defaultJSONParser.close();
        return t;
    }

    public static final <T> T parseObject(java.lang.String str, java.lang.reflect.Type type, com.alibaba.fastjson.parser.ParserConfig parserConfig, int i, com.alibaba.fastjson.parser.Feature... featureArr) {
        return (T) parseObject(str, type, parserConfig, null, i, featureArr);
    }

    public static final <T> T parseObject(java.lang.String str, java.lang.reflect.Type type, com.alibaba.fastjson.parser.ParserConfig parserConfig, com.alibaba.fastjson.parser.deserializer.ParseProcess parseProcess, int i, com.alibaba.fastjson.parser.Feature... featureArr) {
        if (str == null) {
            return null;
        }
        for (com.alibaba.fastjson.parser.Feature feature : featureArr) {
            i |= feature.mask;
        }
        com.alibaba.fastjson.parser.DefaultJSONParser defaultJSONParser = new com.alibaba.fastjson.parser.DefaultJSONParser(str, parserConfig, i);
        if (parseProcess instanceof com.alibaba.fastjson.parser.deserializer.ExtraTypeProvider) {
            defaultJSONParser.getExtraTypeProviders().add((com.alibaba.fastjson.parser.deserializer.ExtraTypeProvider) parseProcess);
        }
        if (parseProcess instanceof com.alibaba.fastjson.parser.deserializer.ExtraProcessor) {
            defaultJSONParser.getExtraProcessors().add((com.alibaba.fastjson.parser.deserializer.ExtraProcessor) parseProcess);
        }
        if (parseProcess instanceof com.alibaba.fastjson.parser.deserializer.FieldTypeResolver) {
            defaultJSONParser.fieldTypeResolver = (com.alibaba.fastjson.parser.deserializer.FieldTypeResolver) parseProcess;
        }
        T t = (T) defaultJSONParser.parseObject(type);
        defaultJSONParser.handleResovleTask(t);
        defaultJSONParser.close();
        return t;
    }

    public static <T> T parseObject(java.lang.String str, java.lang.reflect.Type type, com.alibaba.fastjson.parser.ParserConfig parserConfig, com.alibaba.fastjson.parser.Feature... featureArr) {
        return (T) parseObject(str, type, parserConfig, null, DEFAULT_PARSER_FEATURE, featureArr);
    }

    public static final <T> T parseObject(java.lang.String str, java.lang.reflect.Type type, com.alibaba.fastjson.parser.deserializer.ParseProcess parseProcess, com.alibaba.fastjson.parser.Feature... featureArr) {
        return (T) parseObject(str, type, com.alibaba.fastjson.parser.ParserConfig.global, parseProcess, DEFAULT_PARSER_FEATURE, featureArr);
    }

    public static final <T> T parseObject(java.lang.String str, java.lang.reflect.Type type, com.alibaba.fastjson.parser.Feature... featureArr) {
        return (T) parseObject(str, type, com.alibaba.fastjson.parser.ParserConfig.global, DEFAULT_PARSER_FEATURE, featureArr);
    }

    public static final <T> T parseObject(byte[] bArr, java.lang.reflect.Type type, com.alibaba.fastjson.parser.Feature... featureArr) {
        try {
            return (T) parseObject(new java.lang.String(bArr, "UTF-8"), type, featureArr);
        } catch (java.io.UnsupportedEncodingException unused) {
            throw new com.alibaba.fastjson.JSONException("UTF-8 not support");
        }
    }

    public static final <T> T parseObject(char[] cArr, int i, java.lang.reflect.Type type, com.alibaba.fastjson.parser.Feature... featureArr) {
        if (cArr == null || cArr.length == 0) {
            return null;
        }
        int i2 = DEFAULT_PARSER_FEATURE;
        for (com.alibaba.fastjson.parser.Feature feature : featureArr) {
            i2 |= feature.mask;
        }
        com.alibaba.fastjson.parser.DefaultJSONParser defaultJSONParser = new com.alibaba.fastjson.parser.DefaultJSONParser(cArr, i, com.alibaba.fastjson.parser.ParserConfig.global, i2);
        T t = (T) defaultJSONParser.parseObject(type);
        defaultJSONParser.handleResovleTask(t);
        defaultJSONParser.close();
        return t;
    }

    public static final java.lang.Object toJSON(java.lang.Object obj) {
        return toJSON(obj, com.alibaba.fastjson.serializer.SerializeConfig.globalInstance);
    }

    @java.lang.Deprecated
    public static final java.lang.Object toJSON(java.lang.Object obj, com.alibaba.fastjson.parser.ParserConfig parserConfig) {
        return toJSON(obj, com.alibaba.fastjson.serializer.SerializeConfig.globalInstance);
    }

    public static java.lang.Object toJSON(java.lang.Object obj, com.alibaba.fastjson.serializer.SerializeConfig serializeConfig) {
        if (obj == null) {
            return null;
        }
        if (obj instanceof com.alibaba.fastjson.JSON) {
            return (com.alibaba.fastjson.JSON) obj;
        }
        if (obj instanceof java.util.Map) {
            java.util.Map map = (java.util.Map) obj;
            int size = map.size();
            com.alibaba.fastjson.JSONObject jSONObject = new com.alibaba.fastjson.JSONObject((java.util.Map<java.lang.String, java.lang.Object>) (map instanceof java.util.LinkedHashMap ? new java.util.LinkedHashMap(size) : map instanceof java.util.TreeMap ? new java.util.TreeMap() : new java.util.HashMap(size)));
            for (java.util.Map.Entry entry : map.entrySet()) {
                jSONObject.put(com.alibaba.fastjson.util.TypeUtils.castToString(entry.getKey()), toJSON(entry.getValue()));
            }
            return jSONObject;
        }
        if (obj instanceof java.util.Collection) {
            java.util.Collection collection = (java.util.Collection) obj;
            com.alibaba.fastjson.JSONArray jSONArray = new com.alibaba.fastjson.JSONArray(collection.size());
            java.util.Iterator it = collection.iterator();
            while (it.hasNext()) {
                jSONArray.add(toJSON(it.next()));
            }
            return jSONArray;
        }
        java.lang.Class<?> cls = obj.getClass();
        if (cls.isEnum()) {
            return ((java.lang.Enum) obj).name();
        }
        if (cls.isArray()) {
            int length = java.lang.reflect.Array.getLength(obj);
            com.alibaba.fastjson.JSONArray jSONArray2 = new com.alibaba.fastjson.JSONArray(length);
            for (int i = 0; i < length; i++) {
                jSONArray2.add(toJSON(java.lang.reflect.Array.get(obj, i)));
            }
            return jSONArray2;
        }
        if (com.alibaba.fastjson.parser.ParserConfig.isPrimitive(cls)) {
            return obj;
        }
        com.alibaba.fastjson.serializer.ObjectSerializer objectSerializer = serializeConfig.get(cls);
        if (!(objectSerializer instanceof com.alibaba.fastjson.serializer.JavaBeanSerializer)) {
            return null;
        }
        com.alibaba.fastjson.serializer.JavaBeanSerializer javaBeanSerializer = (com.alibaba.fastjson.serializer.JavaBeanSerializer) objectSerializer;
        com.alibaba.fastjson.JSONObject jSONObject2 = new com.alibaba.fastjson.JSONObject();
        try {
            for (java.util.Map.Entry<java.lang.String, java.lang.Object> entry2 : javaBeanSerializer.getFieldValuesMap(obj).entrySet()) {
                jSONObject2.put(entry2.getKey(), toJSON(entry2.getValue()));
            }
            return jSONObject2;
        } catch (java.lang.Exception e) {
            throw new com.alibaba.fastjson.JSONException("toJSON error", e);
        }
    }

    public static byte[] toJSONBytes(java.lang.Object obj, com.alibaba.fastjson.serializer.SerializeConfig serializeConfig, int i, com.alibaba.fastjson.serializer.SerializerFeature... serializerFeatureArr) {
        return toJSONBytes(obj, serializeConfig, new com.alibaba.fastjson.serializer.SerializeFilter[0], i, serializerFeatureArr);
    }

    public static byte[] toJSONBytes(java.lang.Object obj, com.alibaba.fastjson.serializer.SerializeConfig serializeConfig, com.alibaba.fastjson.serializer.SerializeFilter[] serializeFilterArr, int i, com.alibaba.fastjson.serializer.SerializerFeature... serializerFeatureArr) {
        com.alibaba.fastjson.serializer.SerializeWriter serializeWriter = new com.alibaba.fastjson.serializer.SerializeWriter(null, i, serializerFeatureArr);
        try {
            com.alibaba.fastjson.serializer.JSONSerializer jSONSerializer = new com.alibaba.fastjson.serializer.JSONSerializer(serializeWriter, serializeConfig);
            if (serializeFilterArr != null) {
                for (com.alibaba.fastjson.serializer.SerializeFilter serializeFilter : serializeFilterArr) {
                    if (serializeFilter != null) {
                        if (serializeFilter instanceof com.alibaba.fastjson.serializer.PropertyPreFilter) {
                            jSONSerializer.getPropertyPreFilters().add((com.alibaba.fastjson.serializer.PropertyPreFilter) serializeFilter);
                        }
                        if (serializeFilter instanceof com.alibaba.fastjson.serializer.NameFilter) {
                            jSONSerializer.getNameFilters().add((com.alibaba.fastjson.serializer.NameFilter) serializeFilter);
                        }
                        if (serializeFilter instanceof com.alibaba.fastjson.serializer.ValueFilter) {
                            jSONSerializer.getValueFilters().add((com.alibaba.fastjson.serializer.ValueFilter) serializeFilter);
                        }
                        if (serializeFilter instanceof com.alibaba.fastjson.serializer.PropertyFilter) {
                            jSONSerializer.getPropertyFilters().add((com.alibaba.fastjson.serializer.PropertyFilter) serializeFilter);
                        }
                        if (serializeFilter instanceof com.alibaba.fastjson.serializer.BeforeFilter) {
                            jSONSerializer.getBeforeFilters().add((com.alibaba.fastjson.serializer.BeforeFilter) serializeFilter);
                        }
                        if (serializeFilter instanceof com.alibaba.fastjson.serializer.AfterFilter) {
                            jSONSerializer.getAfterFilters().add((com.alibaba.fastjson.serializer.AfterFilter) serializeFilter);
                        }
                    }
                }
            }
            jSONSerializer.write(obj);
            return serializeWriter.toBytes("UTF-8");
        } finally {
            serializeWriter.close();
        }
    }

    public static final byte[] toJSONBytes(java.lang.Object obj, com.alibaba.fastjson.serializer.SerializeConfig serializeConfig, com.alibaba.fastjson.serializer.SerializerFeature... serializerFeatureArr) {
        com.alibaba.fastjson.serializer.SerializeWriter serializeWriter = new com.alibaba.fastjson.serializer.SerializeWriter(null, DEFAULT_GENERATE_FEATURE, serializerFeatureArr);
        try {
            new com.alibaba.fastjson.serializer.JSONSerializer(serializeWriter, serializeConfig).write(obj);
            return serializeWriter.toBytes("UTF-8");
        } finally {
            serializeWriter.close();
        }
    }

    public static byte[] toJSONBytes(java.lang.Object obj, com.alibaba.fastjson.serializer.SerializeFilter[] serializeFilterArr, com.alibaba.fastjson.serializer.SerializerFeature... serializerFeatureArr) {
        return toJSONBytes(obj, com.alibaba.fastjson.serializer.SerializeConfig.globalInstance, serializeFilterArr, DEFAULT_GENERATE_FEATURE, serializerFeatureArr);
    }

    public static final byte[] toJSONBytes(java.lang.Object obj, com.alibaba.fastjson.serializer.SerializerFeature... serializerFeatureArr) {
        com.alibaba.fastjson.serializer.SerializeWriter serializeWriter = new com.alibaba.fastjson.serializer.SerializeWriter(null, DEFAULT_GENERATE_FEATURE, serializerFeatureArr);
        try {
            new com.alibaba.fastjson.serializer.JSONSerializer(serializeWriter, com.alibaba.fastjson.serializer.SerializeConfig.globalInstance).write(obj);
            return serializeWriter.toBytes("UTF-8");
        } finally {
            serializeWriter.close();
        }
    }

    public static final java.lang.String toJSONString(java.lang.Object obj) {
        return toJSONString(obj, com.alibaba.fastjson.serializer.SerializeConfig.globalInstance, null, null, DEFAULT_GENERATE_FEATURE, new com.alibaba.fastjson.serializer.SerializerFeature[0]);
    }

    public static final java.lang.String toJSONString(java.lang.Object obj, int i, com.alibaba.fastjson.serializer.SerializerFeature... serializerFeatureArr) {
        return toJSONString(obj, com.alibaba.fastjson.serializer.SerializeConfig.globalInstance, null, null, i, serializerFeatureArr);
    }

    public static final java.lang.String toJSONString(java.lang.Object obj, com.alibaba.fastjson.serializer.SerializeConfig serializeConfig, com.alibaba.fastjson.serializer.SerializeFilter serializeFilter, com.alibaba.fastjson.serializer.SerializerFeature... serializerFeatureArr) {
        return toJSONString(obj, serializeConfig, new com.alibaba.fastjson.serializer.SerializeFilter[]{serializeFilter}, null, DEFAULT_GENERATE_FEATURE, serializerFeatureArr);
    }

    public static java.lang.String toJSONString(java.lang.Object obj, com.alibaba.fastjson.serializer.SerializeConfig serializeConfig, com.alibaba.fastjson.serializer.SerializeFilter[] serializeFilterArr, java.lang.String str, int i, com.alibaba.fastjson.serializer.SerializerFeature... serializerFeatureArr) {
        com.alibaba.fastjson.serializer.SerializeWriter serializeWriter = new com.alibaba.fastjson.serializer.SerializeWriter(null, i, serializerFeatureArr);
        try {
            com.alibaba.fastjson.serializer.JSONSerializer jSONSerializer = new com.alibaba.fastjson.serializer.JSONSerializer(serializeWriter, serializeConfig);
            for (com.alibaba.fastjson.serializer.SerializerFeature serializerFeature : serializerFeatureArr) {
                jSONSerializer.config(serializerFeature, true);
            }
            if (str != null && str.length() != 0) {
                jSONSerializer.setDateFormat(str);
                jSONSerializer.config(com.alibaba.fastjson.serializer.SerializerFeature.WriteDateUseDateFormat, true);
            }
            if (serializeFilterArr != null) {
                for (com.alibaba.fastjson.serializer.SerializeFilter serializeFilter : serializeFilterArr) {
                    if (serializeFilter != null) {
                        if (serializeFilter instanceof com.alibaba.fastjson.serializer.PropertyPreFilter) {
                            jSONSerializer.getPropertyPreFilters().add((com.alibaba.fastjson.serializer.PropertyPreFilter) serializeFilter);
                        }
                        if (serializeFilter instanceof com.alibaba.fastjson.serializer.NameFilter) {
                            jSONSerializer.getNameFilters().add((com.alibaba.fastjson.serializer.NameFilter) serializeFilter);
                        }
                        if (serializeFilter instanceof com.alibaba.fastjson.serializer.ValueFilter) {
                            jSONSerializer.getValueFilters().add((com.alibaba.fastjson.serializer.ValueFilter) serializeFilter);
                        }
                        if (serializeFilter instanceof com.alibaba.fastjson.serializer.PropertyFilter) {
                            jSONSerializer.getPropertyFilters().add((com.alibaba.fastjson.serializer.PropertyFilter) serializeFilter);
                        }
                        if (serializeFilter instanceof com.alibaba.fastjson.serializer.BeforeFilter) {
                            jSONSerializer.getBeforeFilters().add((com.alibaba.fastjson.serializer.BeforeFilter) serializeFilter);
                        }
                        if (serializeFilter instanceof com.alibaba.fastjson.serializer.AfterFilter) {
                            jSONSerializer.getAfterFilters().add((com.alibaba.fastjson.serializer.AfterFilter) serializeFilter);
                        }
                    }
                }
            }
            jSONSerializer.write(obj);
            return serializeWriter.toString();
        } finally {
            serializeWriter.close();
        }
    }

    public static final java.lang.String toJSONString(java.lang.Object obj, com.alibaba.fastjson.serializer.SerializeConfig serializeConfig, com.alibaba.fastjson.serializer.SerializeFilter[] serializeFilterArr, com.alibaba.fastjson.serializer.SerializerFeature... serializerFeatureArr) {
        return toJSONString(obj, serializeConfig, serializeFilterArr, null, DEFAULT_GENERATE_FEATURE, serializerFeatureArr);
    }

    public static final java.lang.String toJSONString(java.lang.Object obj, com.alibaba.fastjson.serializer.SerializeConfig serializeConfig, com.alibaba.fastjson.serializer.SerializerFeature... serializerFeatureArr) {
        return toJSONString(obj, serializeConfig, null, null, DEFAULT_GENERATE_FEATURE, serializerFeatureArr);
    }

    public static final java.lang.String toJSONString(java.lang.Object obj, com.alibaba.fastjson.serializer.SerializeFilter serializeFilter, com.alibaba.fastjson.serializer.SerializerFeature... serializerFeatureArr) {
        return toJSONString(obj, com.alibaba.fastjson.serializer.SerializeConfig.globalInstance, new com.alibaba.fastjson.serializer.SerializeFilter[]{serializeFilter}, null, DEFAULT_GENERATE_FEATURE, serializerFeatureArr);
    }

    public static final java.lang.String toJSONString(java.lang.Object obj, boolean z) {
        return !z ? toJSONString(obj) : toJSONString(obj, com.alibaba.fastjson.serializer.SerializerFeature.PrettyFormat);
    }

    public static final java.lang.String toJSONString(java.lang.Object obj, com.alibaba.fastjson.serializer.SerializeFilter[] serializeFilterArr, com.alibaba.fastjson.serializer.SerializerFeature... serializerFeatureArr) {
        return toJSONString(obj, com.alibaba.fastjson.serializer.SerializeConfig.globalInstance, serializeFilterArr, null, DEFAULT_GENERATE_FEATURE, serializerFeatureArr);
    }

    public static final java.lang.String toJSONString(java.lang.Object obj, com.alibaba.fastjson.serializer.SerializerFeature... serializerFeatureArr) {
        return toJSONString(obj, DEFAULT_GENERATE_FEATURE, serializerFeatureArr);
    }

    public static final java.lang.String toJSONStringWithDateFormat(java.lang.Object obj, java.lang.String str, com.alibaba.fastjson.serializer.SerializerFeature... serializerFeatureArr) {
        return toJSONString(obj, com.alibaba.fastjson.serializer.SerializeConfig.globalInstance, null, str, DEFAULT_GENERATE_FEATURE, serializerFeatureArr);
    }

    public static final java.lang.String toJSONStringZ(java.lang.Object obj, com.alibaba.fastjson.serializer.SerializeConfig serializeConfig, com.alibaba.fastjson.serializer.SerializerFeature... serializerFeatureArr) {
        return toJSONString(obj, com.alibaba.fastjson.serializer.SerializeConfig.globalInstance, null, null, 0, serializerFeatureArr);
    }

    public static final <T> T toJavaObject(com.alibaba.fastjson.JSON json, java.lang.Class<T> cls) {
        return (T) com.alibaba.fastjson.util.TypeUtils.cast((java.lang.Object) json, (java.lang.Class) cls, com.alibaba.fastjson.parser.ParserConfig.global);
    }

    public static final void writeJSONStringTo(java.lang.Object obj, java.io.Writer writer, com.alibaba.fastjson.serializer.SerializerFeature... serializerFeatureArr) {
        com.alibaba.fastjson.serializer.SerializeWriter serializeWriter = new com.alibaba.fastjson.serializer.SerializeWriter(writer, DEFAULT_GENERATE_FEATURE, serializerFeatureArr);
        try {
            new com.alibaba.fastjson.serializer.JSONSerializer(serializeWriter, com.alibaba.fastjson.serializer.SerializeConfig.globalInstance).write(obj);
        } finally {
            serializeWriter.close();
        }
    }

    @Override // com.alibaba.fastjson.JSONAware
    public java.lang.String toJSONString() {
        com.alibaba.fastjson.serializer.SerializeWriter serializeWriter = new com.alibaba.fastjson.serializer.SerializeWriter(null, DEFAULT_GENERATE_FEATURE, com.alibaba.fastjson.serializer.SerializerFeature.EMPTY);
        try {
            new com.alibaba.fastjson.serializer.JSONSerializer(serializeWriter, com.alibaba.fastjson.serializer.SerializeConfig.globalInstance).write(this);
            return serializeWriter.toString();
        } finally {
            serializeWriter.close();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public <T> T toJavaObject(java.lang.Class<T> cls) {
        return cls == java.util.Map.class ? this : (T) com.alibaba.fastjson.util.TypeUtils.cast(this, cls, com.alibaba.fastjson.parser.ParserConfig.getGlobalInstance(), 0);
    }

    public java.lang.String toString() {
        return toJSONString();
    }

    @Override // com.alibaba.fastjson.JSONStreamAware
    public void writeJSONString(java.lang.Appendable appendable) {
        com.alibaba.fastjson.serializer.SerializeWriter serializeWriter = new com.alibaba.fastjson.serializer.SerializeWriter(null, DEFAULT_GENERATE_FEATURE, com.alibaba.fastjson.serializer.SerializerFeature.EMPTY);
        try {
            try {
                new com.alibaba.fastjson.serializer.JSONSerializer(serializeWriter, com.alibaba.fastjson.serializer.SerializeConfig.globalInstance).write(this);
                appendable.append(serializeWriter.toString());
            } catch (java.io.IOException e) {
                throw new com.alibaba.fastjson.JSONException(e.getMessage(), e);
            }
        } finally {
            serializeWriter.close();
        }
    }
}
