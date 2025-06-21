package com.alibaba.fastjson.parser;

/* loaded from: classes.dex */
public class ParserConfig {
    private static long[] denyList = {-9164606388214699518L, -8720046426850100497L, -8649961213709896794L, -8165637398350707645L, -8109300701639721088L, -7966123100503199569L, -7921218830998286408L, -7775351613326101303L, -7768608037458185275L, -7766605818834748097L, -6835437086156813536L, -6316154655839304624L, -6179589609550493385L, -6149130139291498841L, -6149093380703242441L, -6025144546313590215L, -5939269048541779808L, -5885964883385605994L, -5767141746063564198L, -5764804792063216819L, -5472097725414717105L, -5194641081268104286L, -5076846148177416215L, -4837536971810737970L, -4836620931940850535L, -4703320437989596122L, -4608341446948126581L, -4537258998789938600L, -4438775680185074100L, -4314457471973557243L, -4150995715611818742L, -4082057040235125754L, -3975378478825053783L, -3967588558552655563L, -3935185854875733362L, -3319207949486691020L, -3077205613010077203L, -3053747177772160511L, -2995060141064716555L, -2825378362173150292L, -2533039401923731906L, -2439930098895578154L, -2378990704010641148L, -2364987994247679115L, -2262244760619952081L, -2192804397019347313L, -2095516571388852610L, -1872417015366588117L, -1650485814983027158L, -1589194880214235129L, -965955008570215305L, -905177026366752536L, -831789045734283466L, -731978084025273882L, -666475508176557463L, -582813228520337988L, -254670111376247151L, -219577392946377768L, -190281065685395680L, -26639035867733124L, -9822483067882491L, 4750336058574309L, 33238344207745342L, 156405680656087946L, 218512992947536312L, 313864100207897507L, 386461436234701831L, 744602970950881621L, 823641066473609950L, 1073634739308289776L, 1153291637701043748L, 1203232727967308606L, 1214780596910349029L, 1459860845934817624L, 1502845958873959152L, 1534439610567445754L, 1698504441317515818L, 1818089308493370394L, 2078113382421334967L, 2164696723069287854L, 2622551729063269307L, 2653453629929770569L, 2660670623866180977L, 2731823439467737506L, 2836431254737891113L, 2930861374593775110L, 3085473968517218653L, 3089451460101527857L, 3114862868117605599L, 3129395579983849527L, 3256258368248066264L, 3452379460455804429L, 3547627781654598988L, 3637939656440441093L, 3688179072722109200L, 3718352661124136681L, 3730752432285826863L, 3794316665763266033L, 4000049462512838776L, 4046190361520671643L, 4147696707147271408L, 4193204392725694463L, 4241163808635564644L, 4254584350247334433L, 4814658433570175913L, 4841947709850912914L, 4904007817188630457L, 5100336081510080343L, 5274044858141538265L, 5347909877633654828L, 5450448828334921485L, 5474268165959054640L, 5545425291794704408L, 5596129856135573697L, 5688200883751798389L, 5751393439502795295L, 5944107969236155580L, 6007332606592876737L, 6280357960959217660L, 6456855723474196908L, 6511035576063254270L, 6534946468240507089L, 6584624952928234050L, 6734240326434096246L, 6742705432718011780L, 6800727078373023163L, 6854854816081053523L, 7045245923763966215L, 7123326897294507060L, 7179336928365889465L, 7240293012336844478L, 7347653049056829645L, 7375862386996623731L, 7442624256860549330L, 7617522210483516279L, 7658177784286215602L, 8055461369741094911L, 8064026652676081192L, 8389032537095247355L, 8409640769019589119L, 8488266005336625107L, 8537233257283452655L, 8838294710098435315L, 9140390920032557669L, 9140416208800006522L};
    public static com.alibaba.fastjson.parser.ParserConfig global = new com.alibaba.fastjson.parser.ParserConfig();
    public boolean autoTypeSupport;
    public java.lang.ClassLoader defaultClassLoader;
    private final com.alibaba.fastjson.util.IdentityHashMap<com.alibaba.fastjson.parser.deserializer.ObjectDeserializer> deserializers;
    public com.alibaba.fastjson.PropertyNamingStrategy propertyNamingStrategy;
    public final com.alibaba.fastjson.parser.SymbolTable symbolTable;

    public ParserConfig() {
        com.alibaba.fastjson.util.IdentityHashMap<com.alibaba.fastjson.parser.deserializer.ObjectDeserializer> identityHashMap = new com.alibaba.fastjson.util.IdentityHashMap<>(1024);
        this.deserializers = identityHashMap;
        this.symbolTable = new com.alibaba.fastjson.parser.SymbolTable(16384);
        com.alibaba.fastjson.serializer.MiscCodec miscCodec = com.alibaba.fastjson.serializer.MiscCodec.instance;
        identityHashMap.put(java.text.SimpleDateFormat.class, miscCodec);
        com.alibaba.fastjson.serializer.DateCodec dateCodec = com.alibaba.fastjson.serializer.DateCodec.instance;
        identityHashMap.put(java.util.Date.class, dateCodec);
        identityHashMap.put(java.util.Calendar.class, dateCodec);
        identityHashMap.put(java.util.Map.class, com.alibaba.fastjson.parser.MapDeserializer.instance);
        identityHashMap.put(java.util.HashMap.class, com.alibaba.fastjson.parser.MapDeserializer.instance);
        identityHashMap.put(java.util.LinkedHashMap.class, com.alibaba.fastjson.parser.MapDeserializer.instance);
        identityHashMap.put(java.util.TreeMap.class, com.alibaba.fastjson.parser.MapDeserializer.instance);
        identityHashMap.put(java.util.concurrent.ConcurrentMap.class, com.alibaba.fastjson.parser.MapDeserializer.instance);
        identityHashMap.put(java.util.concurrent.ConcurrentHashMap.class, com.alibaba.fastjson.parser.MapDeserializer.instance);
        com.alibaba.fastjson.serializer.CollectionCodec collectionCodec = com.alibaba.fastjson.serializer.CollectionCodec.instance;
        identityHashMap.put(java.util.Collection.class, collectionCodec);
        identityHashMap.put(java.util.List.class, collectionCodec);
        identityHashMap.put(java.util.ArrayList.class, collectionCodec);
        com.alibaba.fastjson.parser.JavaObjectDeserializer javaObjectDeserializer = com.alibaba.fastjson.parser.JavaObjectDeserializer.instance;
        identityHashMap.put(java.lang.Object.class, javaObjectDeserializer);
        identityHashMap.put(java.lang.String.class, com.alibaba.fastjson.serializer.StringCodec.instance);
        identityHashMap.put(java.lang.Character.TYPE, miscCodec);
        identityHashMap.put(java.lang.Character.class, miscCodec);
        java.lang.Class cls = java.lang.Byte.TYPE;
        com.alibaba.fastjson.serializer.NumberCodec numberCodec = com.alibaba.fastjson.serializer.NumberCodec.instance;
        identityHashMap.put(cls, numberCodec);
        identityHashMap.put(java.lang.Byte.class, numberCodec);
        identityHashMap.put(java.lang.Short.TYPE, numberCodec);
        identityHashMap.put(java.lang.Short.class, numberCodec);
        identityHashMap.put(java.lang.Integer.TYPE, com.alibaba.fastjson.serializer.IntegerCodec.instance);
        identityHashMap.put(java.lang.Integer.class, com.alibaba.fastjson.serializer.IntegerCodec.instance);
        identityHashMap.put(java.lang.Long.TYPE, com.alibaba.fastjson.serializer.IntegerCodec.instance);
        identityHashMap.put(java.lang.Long.class, com.alibaba.fastjson.serializer.IntegerCodec.instance);
        com.alibaba.fastjson.serializer.BigDecimalCodec bigDecimalCodec = com.alibaba.fastjson.serializer.BigDecimalCodec.instance;
        identityHashMap.put(java.math.BigInteger.class, bigDecimalCodec);
        identityHashMap.put(java.math.BigDecimal.class, bigDecimalCodec);
        identityHashMap.put(java.lang.Float.TYPE, numberCodec);
        identityHashMap.put(java.lang.Float.class, numberCodec);
        identityHashMap.put(java.lang.Double.TYPE, numberCodec);
        identityHashMap.put(java.lang.Double.class, numberCodec);
        java.lang.Class cls2 = java.lang.Boolean.TYPE;
        com.alibaba.fastjson.serializer.BooleanCodec booleanCodec = com.alibaba.fastjson.serializer.BooleanCodec.instance;
        identityHashMap.put(cls2, booleanCodec);
        identityHashMap.put(java.lang.Boolean.class, booleanCodec);
        identityHashMap.put(java.lang.Class.class, miscCodec);
        com.alibaba.fastjson.serializer.ArrayCodec arrayCodec = com.alibaba.fastjson.serializer.ArrayCodec.instance;
        identityHashMap.put(char[].class, arrayCodec);
        identityHashMap.put(java.lang.Object[].class, arrayCodec);
        identityHashMap.put(java.util.UUID.class, miscCodec);
        identityHashMap.put(java.util.TimeZone.class, miscCodec);
        identityHashMap.put(java.util.Locale.class, miscCodec);
        identityHashMap.put(java.util.Currency.class, miscCodec);
        identityHashMap.put(java.net.URI.class, miscCodec);
        identityHashMap.put(java.net.URL.class, miscCodec);
        identityHashMap.put(java.util.regex.Pattern.class, miscCodec);
        identityHashMap.put(java.nio.charset.Charset.class, miscCodec);
        identityHashMap.put(java.lang.Number.class, numberCodec);
        identityHashMap.put(java.lang.StackTraceElement.class, miscCodec);
        identityHashMap.put(java.io.Serializable.class, javaObjectDeserializer);
        identityHashMap.put(java.lang.Cloneable.class, javaObjectDeserializer);
        identityHashMap.put(java.lang.Comparable.class, javaObjectDeserializer);
        identityHashMap.put(java.io.Closeable.class, javaObjectDeserializer);
    }

    public static com.alibaba.fastjson.parser.ParserConfig getGlobalInstance() {
        return global;
    }

    public static boolean isPrimitive(java.lang.Class<?> cls) {
        return cls.isPrimitive() || cls == java.lang.Boolean.class || cls == java.lang.Character.class || cls == java.lang.Byte.class || cls == java.lang.Short.class || cls == java.lang.Integer.class || cls == java.lang.Long.class || cls == java.lang.Float.class || cls == java.lang.Double.class || cls == java.math.BigInteger.class || cls == java.math.BigDecimal.class || cls == java.lang.String.class || cls == java.util.Date.class || cls == java.sql.Date.class || cls == java.sql.Time.class || cls == java.sql.Timestamp.class;
    }

    public java.lang.Class<?> checkAutoType(java.lang.String str, java.lang.Class<?> cls, int i) {
        java.lang.Class<?> findClass;
        if (str == null) {
            return null;
        }
        if (str.length() < 128) {
            if (str.length() >= 3) {
                long charAt = (str.charAt(0) ^ (-3750763034362895579L)) * 1099511628211L;
                if (charAt == -5808493101479473382L) {
                    throw new com.alibaba.fastjson.JSONException("autoType is not support. " + str);
                }
                if ((charAt ^ str.charAt(str.length() - 1)) * 1099511628211L == 655701488918567152L) {
                    throw new com.alibaba.fastjson.JSONException("autoType is not support. " + str);
                }
                long charAt2 = (((((str.charAt(0) ^ (-3750763034362895579L)) * 1099511628211L) ^ str.charAt(1)) * 1099511628211L) ^ str.charAt(2)) * 1099511628211L;
                for (int i2 = 3; i2 < str.length(); i2++) {
                    charAt2 = (charAt2 ^ str.charAt(i2)) * 1099511628211L;
                    if (java.util.Arrays.binarySearch(denyList, charAt2) >= 0 && com.alibaba.fastjson.util.TypeUtils.getClassFromMapping(str) == null) {
                        throw new com.alibaba.fastjson.JSONException("autoType is not support. " + str);
                    }
                }
                java.lang.Class<?> classFromMapping = com.alibaba.fastjson.util.TypeUtils.getClassFromMapping(str);
                if (classFromMapping != null) {
                    return classFromMapping;
                }
                int i3 = com.alibaba.fastjson.parser.Feature.SupportAutoType.mask;
                int i4 = i & i3;
                if ((i4 != 0 || (com.alibaba.fastjson.JSON.DEFAULT_PARSER_FEATURE & i3) != 0 || this.autoTypeSupport) && (findClass = this.deserializers.findClass(str)) != null) {
                    return findClass;
                }
                java.lang.Class<?> loadClass = com.alibaba.fastjson.util.TypeUtils.loadClass(str, this.defaultClassLoader, false);
                if (loadClass != null && cls != null && loadClass != java.util.HashMap.class) {
                    if (cls.isAssignableFrom(loadClass)) {
                        com.alibaba.fastjson.util.TypeUtils.addMapping(str, loadClass);
                        return loadClass;
                    }
                    throw new com.alibaba.fastjson.JSONException("type not match. " + str + " -> " + cls.getName());
                }
                if (loadClass.isAnnotationPresent(com.alibaba.fastjson.annotation.JSONType.class)) {
                    com.alibaba.fastjson.util.TypeUtils.addMapping(str, loadClass);
                    return loadClass;
                }
                if (i4 != 0 || (com.alibaba.fastjson.JSON.DEFAULT_PARSER_FEATURE & i3) != 0 || this.autoTypeSupport) {
                    com.alibaba.fastjson.util.TypeUtils.addMapping(str, loadClass);
                    return loadClass;
                }
                throw new com.alibaba.fastjson.JSONException("autoType is not support : " + str);
            }
        }
        throw new com.alibaba.fastjson.JSONException("autoType is not support. " + str);
    }

    public boolean containsKey(java.lang.Class cls) {
        return this.deserializers.get(cls) != null;
    }

    public com.alibaba.fastjson.parser.deserializer.FieldDeserializer createFieldDeserializer(com.alibaba.fastjson.parser.ParserConfig parserConfig, java.lang.Class<?> cls, com.alibaba.fastjson.util.FieldInfo fieldInfo) {
        java.lang.Class<?> cls2 = fieldInfo.fieldClass;
        return (cls2 == java.util.List.class || cls2 == java.util.ArrayList.class || (cls2.isArray() && !cls2.getComponentType().isPrimitive())) ? new com.alibaba.fastjson.parser.ListTypeFieldDeserializer(parserConfig, cls, fieldInfo) : new com.alibaba.fastjson.parser.DefaultFieldDeserializer(parserConfig, cls, fieldInfo);
    }

    public com.alibaba.fastjson.parser.deserializer.ObjectDeserializer getDeserializer(java.lang.Class<?> cls, java.lang.reflect.Type type) {
        com.alibaba.fastjson.annotation.JSONType jSONType;
        java.lang.Class<?> mappingTo;
        com.alibaba.fastjson.parser.deserializer.ObjectDeserializer objectDeserializer = this.deserializers.get(type);
        if (objectDeserializer != null) {
            return objectDeserializer;
        }
        if (type == null) {
            type = cls;
        }
        com.alibaba.fastjson.parser.deserializer.ObjectDeserializer objectDeserializer2 = this.deserializers.get(type);
        if (objectDeserializer2 != null) {
            return objectDeserializer2;
        }
        if (!isPrimitive(cls) && (jSONType = (com.alibaba.fastjson.annotation.JSONType) cls.getAnnotation(com.alibaba.fastjson.annotation.JSONType.class)) != null && (mappingTo = jSONType.mappingTo()) != java.lang.Void.class) {
            return getDeserializer(mappingTo, mappingTo);
        }
        if ((type instanceof java.lang.reflect.WildcardType) || (type instanceof java.lang.reflect.TypeVariable) || (type instanceof java.lang.reflect.ParameterizedType)) {
            objectDeserializer2 = this.deserializers.get(cls);
        }
        if (objectDeserializer2 != null) {
            return objectDeserializer2;
        }
        com.alibaba.fastjson.parser.deserializer.ObjectDeserializer objectDeserializer3 = this.deserializers.get(type);
        if (objectDeserializer3 != null) {
            return objectDeserializer3;
        }
        com.alibaba.fastjson.parser.deserializer.ObjectDeserializer enumDeserializer = cls.isEnum() ? new com.alibaba.fastjson.parser.EnumDeserializer(cls) : cls.isArray() ? com.alibaba.fastjson.serializer.ArrayCodec.instance : (cls == java.util.Set.class || cls == java.util.HashSet.class || cls == java.util.Collection.class || cls == java.util.List.class || cls == java.util.ArrayList.class) ? com.alibaba.fastjson.serializer.CollectionCodec.instance : java.util.Collection.class.isAssignableFrom(cls) ? com.alibaba.fastjson.serializer.CollectionCodec.instance : java.util.Map.class.isAssignableFrom(cls) ? com.alibaba.fastjson.parser.MapDeserializer.instance : java.lang.Throwable.class.isAssignableFrom(cls) ? new com.alibaba.fastjson.parser.ThrowableDeserializer(this, cls) : cls.getName().equals("android.net.Uri") ? com.alibaba.fastjson.serializer.MiscCodec.instance : new com.alibaba.fastjson.parser.JavaBeanDeserializer(this, cls, type);
        putDeserializer(type, enumDeserializer);
        return enumDeserializer;
    }

    public com.alibaba.fastjson.parser.deserializer.ObjectDeserializer getDeserializer(java.lang.reflect.Type type) {
        com.alibaba.fastjson.parser.deserializer.ObjectDeserializer objectDeserializer = this.deserializers.get(type);
        if (objectDeserializer != null) {
            return objectDeserializer;
        }
        if (type instanceof java.lang.Class) {
            return getDeserializer((java.lang.Class) type, type);
        }
        if (type instanceof java.lang.reflect.ParameterizedType) {
            java.lang.reflect.Type rawType = ((java.lang.reflect.ParameterizedType) type).getRawType();
            return rawType instanceof java.lang.Class ? getDeserializer((java.lang.Class) rawType, type) : getDeserializer(rawType);
        }
        if (type instanceof java.lang.reflect.WildcardType) {
            java.lang.reflect.Type[] upperBounds = ((java.lang.reflect.WildcardType) type).getUpperBounds();
            if (upperBounds.length == 1) {
                return getDeserializer(upperBounds[0]);
            }
        }
        return com.alibaba.fastjson.parser.JavaObjectDeserializer.instance;
    }

    public void putDeserializer(java.lang.reflect.Type type, com.alibaba.fastjson.parser.deserializer.ObjectDeserializer objectDeserializer) {
        this.deserializers.put(type, objectDeserializer);
    }

    public com.alibaba.fastjson.parser.deserializer.ObjectDeserializer registerIfNotExists(java.lang.Class<?> cls) {
        return registerIfNotExists(cls, cls.getModifiers(), false, true, true, true);
    }

    public com.alibaba.fastjson.parser.deserializer.ObjectDeserializer registerIfNotExists(java.lang.Class<?> cls, int i, boolean z, boolean z2, boolean z3, boolean z4) {
        com.alibaba.fastjson.parser.deserializer.ObjectDeserializer objectDeserializer = this.deserializers.get(cls);
        if (objectDeserializer != null) {
            return objectDeserializer;
        }
        com.alibaba.fastjson.parser.JavaBeanDeserializer javaBeanDeserializer = new com.alibaba.fastjson.parser.JavaBeanDeserializer(this, cls, cls, com.alibaba.fastjson.parser.JavaBeanInfo.build(cls, i, cls, z, z2, z3, z4, this.propertyNamingStrategy));
        putDeserializer(cls, javaBeanDeserializer);
        return javaBeanDeserializer;
    }
}
