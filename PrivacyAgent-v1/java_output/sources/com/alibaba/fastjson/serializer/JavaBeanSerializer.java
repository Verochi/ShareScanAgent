package com.alibaba.fastjson.serializer;

/* loaded from: classes.dex */
public class JavaBeanSerializer implements com.alibaba.fastjson.serializer.ObjectSerializer {
    protected int features;
    private final com.alibaba.fastjson.serializer.FieldSerializer[] getters;
    private final com.alibaba.fastjson.serializer.FieldSerializer[] sortedGetters;
    protected final java.lang.String typeKey;
    protected final java.lang.String typeName;
    private static final char[] true_chars = {com.aliyun.svideo.editor.guide.customView.MultiLamp.TOP, com.aliyun.svideo.editor.guide.customView.MultiLamp.RIGHT, 'u', 'e'};
    private static final char[] false_chars = {'f', 'a', com.aliyun.svideo.editor.guide.customView.MultiLamp.LEFT, 's', 'e'};

    public JavaBeanSerializer(java.lang.Class<?> cls) {
        this(cls, (com.alibaba.fastjson.PropertyNamingStrategy) null);
    }

    public JavaBeanSerializer(java.lang.Class<?> cls, int i, java.util.Map<java.lang.String, java.lang.String> map, boolean z, boolean z2, boolean z3, boolean z4, com.alibaba.fastjson.PropertyNamingStrategy propertyNamingStrategy) {
        com.alibaba.fastjson.PropertyNamingStrategy propertyNamingStrategy2;
        java.lang.String str;
        java.lang.String str2;
        this.features = 0;
        com.alibaba.fastjson.annotation.JSONType jSONType = z2 ? (com.alibaba.fastjson.annotation.JSONType) cls.getAnnotation(com.alibaba.fastjson.annotation.JSONType.class) : null;
        if (jSONType != null) {
            this.features = com.alibaba.fastjson.serializer.SerializerFeature.of(jSONType.serialzeFeatures());
            str = jSONType.typeName();
            if (str.length() == 0) {
                str = null;
                str2 = null;
            } else {
                str2 = null;
                for (java.lang.Class<? super java.lang.Object> superclass = cls.getSuperclass(); superclass != null && superclass != java.lang.Object.class; superclass = superclass.getSuperclass()) {
                    com.alibaba.fastjson.annotation.JSONType jSONType2 = (com.alibaba.fastjson.annotation.JSONType) superclass.getAnnotation(com.alibaba.fastjson.annotation.JSONType.class);
                    if (jSONType2 == null) {
                        break;
                    }
                    str2 = jSONType2.typeKey();
                    if (str2.length() != 0) {
                        break;
                    }
                }
                for (java.lang.Class<?> cls2 : cls.getInterfaces()) {
                    com.alibaba.fastjson.annotation.JSONType jSONType3 = (com.alibaba.fastjson.annotation.JSONType) cls2.getAnnotation(com.alibaba.fastjson.annotation.JSONType.class);
                    if (jSONType3 != null) {
                        str2 = jSONType3.typeKey();
                        if (str2.length() != 0) {
                            break;
                        }
                    }
                }
                if (str2 != null && str2.length() == 0) {
                    str2 = null;
                }
            }
            if (propertyNamingStrategy != null || (propertyNamingStrategy2 = jSONType.naming()) == com.alibaba.fastjson.PropertyNamingStrategy.CamelCase) {
                propertyNamingStrategy2 = propertyNamingStrategy;
            }
        } else {
            propertyNamingStrategy2 = propertyNamingStrategy;
            str = null;
            str2 = null;
        }
        this.typeName = str;
        this.typeKey = str2;
        java.util.List<com.alibaba.fastjson.util.FieldInfo> computeGetters = com.alibaba.fastjson.util.TypeUtils.computeGetters(cls, i, z, jSONType, map, false, z3, z4, propertyNamingStrategy2);
        java.util.ArrayList arrayList = new java.util.ArrayList();
        java.util.Iterator<com.alibaba.fastjson.util.FieldInfo> it = computeGetters.iterator();
        while (it.hasNext()) {
            arrayList.add(new com.alibaba.fastjson.serializer.FieldSerializer(it.next()));
        }
        com.alibaba.fastjson.serializer.FieldSerializer[] fieldSerializerArr = (com.alibaba.fastjson.serializer.FieldSerializer[]) arrayList.toArray(new com.alibaba.fastjson.serializer.FieldSerializer[arrayList.size()]);
        this.getters = fieldSerializerArr;
        java.lang.String[] orders = jSONType != null ? jSONType.orders() : null;
        if (orders != null && orders.length != 0) {
            java.util.List<com.alibaba.fastjson.util.FieldInfo> computeGetters2 = com.alibaba.fastjson.util.TypeUtils.computeGetters(cls, i, z, jSONType, map, true, z3, z4, propertyNamingStrategy2);
            java.util.ArrayList arrayList2 = new java.util.ArrayList();
            java.util.Iterator<com.alibaba.fastjson.util.FieldInfo> it2 = computeGetters2.iterator();
            while (it2.hasNext()) {
                arrayList2.add(new com.alibaba.fastjson.serializer.FieldSerializer(it2.next()));
            }
            this.sortedGetters = (com.alibaba.fastjson.serializer.FieldSerializer[]) arrayList2.toArray(new com.alibaba.fastjson.serializer.FieldSerializer[arrayList2.size()]);
            return;
        }
        com.alibaba.fastjson.serializer.FieldSerializer[] fieldSerializerArr2 = new com.alibaba.fastjson.serializer.FieldSerializer[fieldSerializerArr.length];
        java.lang.System.arraycopy(fieldSerializerArr, 0, fieldSerializerArr2, 0, fieldSerializerArr.length);
        java.util.Arrays.sort(fieldSerializerArr2);
        if (java.util.Arrays.equals(fieldSerializerArr2, fieldSerializerArr)) {
            this.sortedGetters = fieldSerializerArr;
        } else {
            this.sortedGetters = fieldSerializerArr2;
        }
    }

    public JavaBeanSerializer(java.lang.Class<?> cls, com.alibaba.fastjson.PropertyNamingStrategy propertyNamingStrategy) {
        this(cls, cls.getModifiers(), null, false, true, true, true, propertyNamingStrategy);
    }

    public JavaBeanSerializer(java.lang.Class<?> cls, java.lang.String... strArr) {
        this(cls, cls.getModifiers(), map(strArr), false, true, true, true, null);
    }

    private static java.util.Map<java.lang.String, java.lang.String> map(java.lang.String... strArr) {
        java.util.HashMap hashMap = new java.util.HashMap();
        for (java.lang.String str : strArr) {
            hashMap.put(str, str);
        }
        return hashMap;
    }

    public java.util.Map<java.lang.String, java.lang.Object> getFieldValuesMap(java.lang.Object obj) throws java.lang.Exception {
        java.util.LinkedHashMap linkedHashMap = new java.util.LinkedHashMap(this.sortedGetters.length);
        for (com.alibaba.fastjson.serializer.FieldSerializer fieldSerializer : this.sortedGetters) {
            linkedHashMap.put(fieldSerializer.fieldInfo.name, fieldSerializer.getPropertyValue(obj));
        }
        return linkedHashMap;
    }

    /* JADX WARN: Removed duplicated region for block: B:124:0x020d  */
    /* JADX WARN: Removed duplicated region for block: B:138:0x0254  */
    /* JADX WARN: Removed duplicated region for block: B:139:0x0256  */
    /* JADX WARN: Removed duplicated region for block: B:196:0x03b1 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:222:0x03f3 A[Catch: all -> 0x058a, Exception -> 0x0590, TryCatch #9 {Exception -> 0x0590, all -> 0x058a, blocks: (B:92:0x0162, B:94:0x017d, B:96:0x0181, B:104:0x0186, B:106:0x018a, B:110:0x0193, B:111:0x0197, B:113:0x019d, B:118:0x01b8, B:120:0x01be, B:122:0x01c3, B:125:0x020f, B:127:0x0215, B:129:0x0230, B:130:0x0234, B:132:0x023a, B:142:0x025c, B:144:0x0260, B:146:0x0268, B:148:0x026c, B:149:0x0271, B:151:0x0275, B:152:0x027a, B:153:0x0281, B:155:0x0287, B:160:0x02a1, B:162:0x02a5, B:164:0x02ac, B:166:0x02b0, B:167:0x02b5, B:169:0x02b9, B:170:0x02be, B:171:0x02c5, B:173:0x02cb, B:181:0x02ee, B:183:0x02fc, B:185:0x0309, B:187:0x030d, B:190:0x0312, B:192:0x0315, B:198:0x03b5, B:200:0x03b9, B:202:0x03bd, B:204:0x03c1, B:206:0x03c5, B:208:0x03c9, B:210:0x03db, B:212:0x03df, B:214:0x03e3, B:216:0x03cd, B:218:0x03d1, B:222:0x03f3, B:224:0x03fc, B:226:0x0400, B:227:0x0404, B:228:0x0408, B:230:0x041b, B:233:0x0425, B:234:0x0429, B:240:0x0433, B:241:0x0436, B:244:0x043e, B:246:0x0449, B:248:0x044d, B:250:0x0452, B:254:0x046e, B:257:0x0478, B:260:0x047f, B:264:0x0489, B:268:0x0495, B:272:0x049b, B:274:0x049f, B:275:0x04a1, B:277:0x04a9, B:279:0x04ad, B:280:0x04b1, B:282:0x04c0, B:270:0x04ca, B:285:0x04cd, B:287:0x04d1, B:288:0x04da, B:291:0x04e0, B:292:0x04eb, B:295:0x04fa, B:297:0x0501, B:299:0x050a, B:302:0x050e, B:303:0x0513, B:304:0x051a, B:306:0x051e, B:307:0x0523, B:308:0x052a, B:311:0x0532, B:313:0x053b, B:317:0x054f, B:318:0x0554, B:320:0x0559, B:321:0x0564, B:322:0x0569, B:323:0x056e, B:325:0x0319, B:328:0x0321, B:330:0x032c, B:332:0x0330, B:335:0x0335, B:337:0x0338, B:340:0x0340, B:342:0x0348, B:344:0x0353, B:346:0x0357, B:349:0x035e, B:351:0x0361, B:353:0x0366, B:354:0x036c, B:356:0x0374, B:358:0x037f, B:360:0x0383, B:363:0x038a, B:365:0x038d, B:367:0x0392, B:369:0x039a, B:371:0x039e, B:379:0x021c, B:381:0x0220, B:382:0x0225, B:384:0x0229, B:387:0x01d3, B:389:0x01d7, B:391:0x01e3, B:393:0x01e7, B:394:0x01f7, B:396:0x01fe, B:421:0x05a5, B:422:0x05a9, B:424:0x05af, B:430:0x05c1, B:432:0x05ca, B:435:0x05d9, B:437:0x05dd, B:438:0x05e1), top: B:91:0x0162 }] */
    /* JADX WARN: Removed duplicated region for block: B:232:0x0423  */
    /* JADX WARN: Removed duplicated region for block: B:238:0x042f  */
    /* JADX WARN: Removed duplicated region for block: B:282:0x04c0 A[Catch: all -> 0x058a, Exception -> 0x0590, TryCatch #9 {Exception -> 0x0590, all -> 0x058a, blocks: (B:92:0x0162, B:94:0x017d, B:96:0x0181, B:104:0x0186, B:106:0x018a, B:110:0x0193, B:111:0x0197, B:113:0x019d, B:118:0x01b8, B:120:0x01be, B:122:0x01c3, B:125:0x020f, B:127:0x0215, B:129:0x0230, B:130:0x0234, B:132:0x023a, B:142:0x025c, B:144:0x0260, B:146:0x0268, B:148:0x026c, B:149:0x0271, B:151:0x0275, B:152:0x027a, B:153:0x0281, B:155:0x0287, B:160:0x02a1, B:162:0x02a5, B:164:0x02ac, B:166:0x02b0, B:167:0x02b5, B:169:0x02b9, B:170:0x02be, B:171:0x02c5, B:173:0x02cb, B:181:0x02ee, B:183:0x02fc, B:185:0x0309, B:187:0x030d, B:190:0x0312, B:192:0x0315, B:198:0x03b5, B:200:0x03b9, B:202:0x03bd, B:204:0x03c1, B:206:0x03c5, B:208:0x03c9, B:210:0x03db, B:212:0x03df, B:214:0x03e3, B:216:0x03cd, B:218:0x03d1, B:222:0x03f3, B:224:0x03fc, B:226:0x0400, B:227:0x0404, B:228:0x0408, B:230:0x041b, B:233:0x0425, B:234:0x0429, B:240:0x0433, B:241:0x0436, B:244:0x043e, B:246:0x0449, B:248:0x044d, B:250:0x0452, B:254:0x046e, B:257:0x0478, B:260:0x047f, B:264:0x0489, B:268:0x0495, B:272:0x049b, B:274:0x049f, B:275:0x04a1, B:277:0x04a9, B:279:0x04ad, B:280:0x04b1, B:282:0x04c0, B:270:0x04ca, B:285:0x04cd, B:287:0x04d1, B:288:0x04da, B:291:0x04e0, B:292:0x04eb, B:295:0x04fa, B:297:0x0501, B:299:0x050a, B:302:0x050e, B:303:0x0513, B:304:0x051a, B:306:0x051e, B:307:0x0523, B:308:0x052a, B:311:0x0532, B:313:0x053b, B:317:0x054f, B:318:0x0554, B:320:0x0559, B:321:0x0564, B:322:0x0569, B:323:0x056e, B:325:0x0319, B:328:0x0321, B:330:0x032c, B:332:0x0330, B:335:0x0335, B:337:0x0338, B:340:0x0340, B:342:0x0348, B:344:0x0353, B:346:0x0357, B:349:0x035e, B:351:0x0361, B:353:0x0366, B:354:0x036c, B:356:0x0374, B:358:0x037f, B:360:0x0383, B:363:0x038a, B:365:0x038d, B:367:0x0392, B:369:0x039a, B:371:0x039e, B:379:0x021c, B:381:0x0220, B:382:0x0225, B:384:0x0229, B:387:0x01d3, B:389:0x01d7, B:391:0x01e3, B:393:0x01e7, B:394:0x01f7, B:396:0x01fe, B:421:0x05a5, B:422:0x05a9, B:424:0x05af, B:430:0x05c1, B:432:0x05ca, B:435:0x05d9, B:437:0x05dd, B:438:0x05e1), top: B:91:0x0162 }] */
    /* JADX WARN: Removed duplicated region for block: B:324:0x041f  */
    /* JADX WARN: Removed duplicated region for block: B:386:0x024f  */
    /* JADX WARN: Removed duplicated region for block: B:411:0x060a A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:419:0x059f  */
    /* JADX WARN: Removed duplicated region for block: B:430:0x05c1 A[Catch: all -> 0x058a, Exception -> 0x0590, TRY_ENTER, TryCatch #9 {Exception -> 0x0590, all -> 0x058a, blocks: (B:92:0x0162, B:94:0x017d, B:96:0x0181, B:104:0x0186, B:106:0x018a, B:110:0x0193, B:111:0x0197, B:113:0x019d, B:118:0x01b8, B:120:0x01be, B:122:0x01c3, B:125:0x020f, B:127:0x0215, B:129:0x0230, B:130:0x0234, B:132:0x023a, B:142:0x025c, B:144:0x0260, B:146:0x0268, B:148:0x026c, B:149:0x0271, B:151:0x0275, B:152:0x027a, B:153:0x0281, B:155:0x0287, B:160:0x02a1, B:162:0x02a5, B:164:0x02ac, B:166:0x02b0, B:167:0x02b5, B:169:0x02b9, B:170:0x02be, B:171:0x02c5, B:173:0x02cb, B:181:0x02ee, B:183:0x02fc, B:185:0x0309, B:187:0x030d, B:190:0x0312, B:192:0x0315, B:198:0x03b5, B:200:0x03b9, B:202:0x03bd, B:204:0x03c1, B:206:0x03c5, B:208:0x03c9, B:210:0x03db, B:212:0x03df, B:214:0x03e3, B:216:0x03cd, B:218:0x03d1, B:222:0x03f3, B:224:0x03fc, B:226:0x0400, B:227:0x0404, B:228:0x0408, B:230:0x041b, B:233:0x0425, B:234:0x0429, B:240:0x0433, B:241:0x0436, B:244:0x043e, B:246:0x0449, B:248:0x044d, B:250:0x0452, B:254:0x046e, B:257:0x0478, B:260:0x047f, B:264:0x0489, B:268:0x0495, B:272:0x049b, B:274:0x049f, B:275:0x04a1, B:277:0x04a9, B:279:0x04ad, B:280:0x04b1, B:282:0x04c0, B:270:0x04ca, B:285:0x04cd, B:287:0x04d1, B:288:0x04da, B:291:0x04e0, B:292:0x04eb, B:295:0x04fa, B:297:0x0501, B:299:0x050a, B:302:0x050e, B:303:0x0513, B:304:0x051a, B:306:0x051e, B:307:0x0523, B:308:0x052a, B:311:0x0532, B:313:0x053b, B:317:0x054f, B:318:0x0554, B:320:0x0559, B:321:0x0564, B:322:0x0569, B:323:0x056e, B:325:0x0319, B:328:0x0321, B:330:0x032c, B:332:0x0330, B:335:0x0335, B:337:0x0338, B:340:0x0340, B:342:0x0348, B:344:0x0353, B:346:0x0357, B:349:0x035e, B:351:0x0361, B:353:0x0366, B:354:0x036c, B:356:0x0374, B:358:0x037f, B:360:0x0383, B:363:0x038a, B:365:0x038d, B:367:0x0392, B:369:0x039a, B:371:0x039e, B:379:0x021c, B:381:0x0220, B:382:0x0225, B:384:0x0229, B:387:0x01d3, B:389:0x01d7, B:391:0x01e3, B:393:0x01e7, B:394:0x01f7, B:396:0x01fe, B:421:0x05a5, B:422:0x05a9, B:424:0x05af, B:430:0x05c1, B:432:0x05ca, B:435:0x05d9, B:437:0x05dd, B:438:0x05e1), top: B:91:0x0162 }] */
    /* JADX WARN: Removed duplicated region for block: B:435:0x05d9 A[Catch: all -> 0x058a, Exception -> 0x0590, TRY_ENTER, TryCatch #9 {Exception -> 0x0590, all -> 0x058a, blocks: (B:92:0x0162, B:94:0x017d, B:96:0x0181, B:104:0x0186, B:106:0x018a, B:110:0x0193, B:111:0x0197, B:113:0x019d, B:118:0x01b8, B:120:0x01be, B:122:0x01c3, B:125:0x020f, B:127:0x0215, B:129:0x0230, B:130:0x0234, B:132:0x023a, B:142:0x025c, B:144:0x0260, B:146:0x0268, B:148:0x026c, B:149:0x0271, B:151:0x0275, B:152:0x027a, B:153:0x0281, B:155:0x0287, B:160:0x02a1, B:162:0x02a5, B:164:0x02ac, B:166:0x02b0, B:167:0x02b5, B:169:0x02b9, B:170:0x02be, B:171:0x02c5, B:173:0x02cb, B:181:0x02ee, B:183:0x02fc, B:185:0x0309, B:187:0x030d, B:190:0x0312, B:192:0x0315, B:198:0x03b5, B:200:0x03b9, B:202:0x03bd, B:204:0x03c1, B:206:0x03c5, B:208:0x03c9, B:210:0x03db, B:212:0x03df, B:214:0x03e3, B:216:0x03cd, B:218:0x03d1, B:222:0x03f3, B:224:0x03fc, B:226:0x0400, B:227:0x0404, B:228:0x0408, B:230:0x041b, B:233:0x0425, B:234:0x0429, B:240:0x0433, B:241:0x0436, B:244:0x043e, B:246:0x0449, B:248:0x044d, B:250:0x0452, B:254:0x046e, B:257:0x0478, B:260:0x047f, B:264:0x0489, B:268:0x0495, B:272:0x049b, B:274:0x049f, B:275:0x04a1, B:277:0x04a9, B:279:0x04ad, B:280:0x04b1, B:282:0x04c0, B:270:0x04ca, B:285:0x04cd, B:287:0x04d1, B:288:0x04da, B:291:0x04e0, B:292:0x04eb, B:295:0x04fa, B:297:0x0501, B:299:0x050a, B:302:0x050e, B:303:0x0513, B:304:0x051a, B:306:0x051e, B:307:0x0523, B:308:0x052a, B:311:0x0532, B:313:0x053b, B:317:0x054f, B:318:0x0554, B:320:0x0559, B:321:0x0564, B:322:0x0569, B:323:0x056e, B:325:0x0319, B:328:0x0321, B:330:0x032c, B:332:0x0330, B:335:0x0335, B:337:0x0338, B:340:0x0340, B:342:0x0348, B:344:0x0353, B:346:0x0357, B:349:0x035e, B:351:0x0361, B:353:0x0366, B:354:0x036c, B:356:0x0374, B:358:0x037f, B:360:0x0383, B:363:0x038a, B:365:0x038d, B:367:0x0392, B:369:0x039a, B:371:0x039e, B:379:0x021c, B:381:0x0220, B:382:0x0225, B:384:0x0229, B:387:0x01d3, B:389:0x01d7, B:391:0x01e3, B:393:0x01e7, B:394:0x01f7, B:396:0x01fe, B:421:0x05a5, B:422:0x05a9, B:424:0x05af, B:430:0x05c1, B:432:0x05ca, B:435:0x05d9, B:437:0x05dd, B:438:0x05e1), top: B:91:0x0162 }] */
    /* JADX WARN: Removed duplicated region for block: B:451:0x014f  */
    /* JADX WARN: Removed duplicated region for block: B:452:0x0145  */
    /* JADX WARN: Removed duplicated region for block: B:459:0x0128  */
    /* JADX WARN: Removed duplicated region for block: B:460:0x010a  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x0107  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x010f A[Catch: all -> 0x0096, Exception -> 0x009b, TRY_ENTER, TryCatch #6 {Exception -> 0x009b, all -> 0x0096, blocks: (B:465:0x0089, B:467:0x008d, B:468:0x0091, B:33:0x00ab, B:35:0x00b4, B:39:0x00c3, B:42:0x00ca, B:44:0x00d1, B:46:0x00d5, B:51:0x00df, B:53:0x00e5, B:56:0x00ee, B:58:0x00f5, B:59:0x00fd, B:66:0x010f, B:67:0x0113, B:69:0x0119, B:76:0x0132, B:461:0x00ea), top: B:464:0x0089 }] */
    /* JADX WARN: Removed duplicated region for block: B:72:0x0126  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x0132 A[Catch: all -> 0x0096, Exception -> 0x009b, TRY_ENTER, TRY_LEAVE, TryCatch #6 {Exception -> 0x009b, all -> 0x0096, blocks: (B:465:0x0089, B:467:0x008d, B:468:0x0091, B:33:0x00ab, B:35:0x00b4, B:39:0x00c3, B:42:0x00ca, B:44:0x00d1, B:46:0x00d5, B:51:0x00df, B:53:0x00e5, B:56:0x00ee, B:58:0x00f5, B:59:0x00fd, B:66:0x010f, B:67:0x0113, B:69:0x0119, B:76:0x0132, B:461:0x00ea), top: B:464:0x0089 }] */
    /* JADX WARN: Removed duplicated region for block: B:82:0x0143  */
    /* JADX WARN: Removed duplicated region for block: B:85:0x014d  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x0162 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    @Override // com.alibaba.fastjson.serializer.ObjectSerializer
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void write(com.alibaba.fastjson.serializer.JSONSerializer jSONSerializer, java.lang.Object obj, java.lang.Object obj2, java.lang.reflect.Type type) throws java.io.IOException {
        java.util.IdentityHashMap<java.lang.Object, com.alibaba.fastjson.serializer.SerialContext> identityHashMap;
        com.alibaba.fastjson.serializer.SerialContext serialContext;
        java.lang.Exception exc;
        java.lang.Throwable th;
        boolean z;
        boolean z2;
        java.util.List<com.alibaba.fastjson.serializer.BeforeFilter> list;
        int i;
        boolean z3;
        int i2;
        com.alibaba.fastjson.serializer.FieldSerializer[] fieldSerializerArr;
        java.util.List<com.alibaba.fastjson.serializer.AfterFilter> list2;
        int i3;
        int i4;
        java.lang.String str;
        boolean z4;
        java.lang.Object propertyValue;
        long j;
        boolean z5;
        boolean z6;
        int i5;
        boolean z7;
        java.util.List<com.alibaba.fastjson.serializer.PropertyPreFilter> list3;
        boolean z8;
        java.util.List<com.alibaba.fastjson.serializer.NameFilter> list4;
        java.lang.String str2;
        java.util.List<com.alibaba.fastjson.serializer.ValueFilter> list5;
        java.lang.Object obj3;
        java.util.List<com.alibaba.fastjson.serializer.PropertyFilter> list6;
        java.lang.String str3;
        com.alibaba.fastjson.util.FieldInfo fieldInfo;
        java.lang.Object obj4;
        java.lang.Object obj5;
        boolean z9;
        int i6;
        java.lang.Object valueOf;
        com.alibaba.fastjson.serializer.SerialContext serialContext2;
        java.lang.Object obj6 = obj;
        com.alibaba.fastjson.serializer.SerializeWriter serializeWriter = jSONSerializer.out;
        if (obj6 == null) {
            serializeWriter.writeNull();
            return;
        }
        com.alibaba.fastjson.serializer.SerialContext serialContext3 = jSONSerializer.context;
        if ((serialContext3 == null || (serialContext3.features & com.alibaba.fastjson.serializer.SerializerFeature.DisableCircularReferenceDetect.mask) == 0) && (identityHashMap = jSONSerializer.references) != null && identityHashMap.containsKey(obj6)) {
            jSONSerializer.writeReference(obj);
            return;
        }
        int i7 = serializeWriter.features;
        com.alibaba.fastjson.serializer.FieldSerializer[] fieldSerializerArr2 = (com.alibaba.fastjson.serializer.SerializerFeature.SortField.mask & i7) != 0 ? this.sortedGetters : this.getters;
        com.alibaba.fastjson.serializer.SerialContext serialContext4 = jSONSerializer.context;
        if ((i7 & com.alibaba.fastjson.serializer.SerializerFeature.DisableCircularReferenceDetect.mask) == 0) {
            jSONSerializer.context = new com.alibaba.fastjson.serializer.SerialContext(serialContext4, obj6, obj2, this.features);
            if (jSONSerializer.references == null) {
                jSONSerializer.references = new java.util.IdentityHashMap<>();
            }
            jSONSerializer.references.put(obj6, jSONSerializer.context);
        }
        int i8 = this.features;
        int i9 = com.alibaba.fastjson.serializer.SerializerFeature.BeanToArray.mask;
        boolean z10 = ((i8 & i9) == 0 && (serializeWriter.features & i9) == 0) ? false : true;
        char c = z10 ? '[' : '{';
        char c2 = z10 ? ']' : '}';
        try {
            int i10 = serializeWriter.count + 1;
            if (i10 > serializeWriter.buf.length) {
                try {
                    if (serializeWriter.writer == null) {
                        serializeWriter.expandCapacity(i10);
                    } else {
                        serializeWriter.flush();
                        i10 = 1;
                    }
                } catch (java.lang.Exception e) {
                    exc = e;
                    serialContext = serialContext4;
                    java.lang.String str4 = "write javaBean error, fastjson version 1.1.74";
                    if (obj2 != null) {
                    }
                    throw new com.alibaba.fastjson.JSONException(str4, exc);
                } catch (java.lang.Throwable th2) {
                    th = th2;
                    serialContext = serialContext4;
                    jSONSerializer.context = serialContext;
                    throw th;
                }
            }
            serializeWriter.buf[serializeWriter.count] = c;
            serializeWriter.count = i10;
            if (fieldSerializerArr2.length > 0 && (serializeWriter.features & com.alibaba.fastjson.serializer.SerializerFeature.PrettyFormat.mask) != 0) {
                jSONSerializer.incrementIndent();
                jSONSerializer.println();
            }
            int i11 = this.features;
            int i12 = com.alibaba.fastjson.serializer.SerializerFeature.WriteClassName.mask;
            if ((i11 & i12) == 0) {
                int i13 = serializeWriter.features;
                if ((i12 & i13) == 0 || (type == null && (i13 & com.alibaba.fastjson.serializer.SerializerFeature.NotWriteRootClassName.mask) != 0 && ((serialContext2 = jSONSerializer.context) == null || serialContext2.parent == null))) {
                    z = false;
                    if (z || obj.getClass() == type) {
                        z2 = false;
                    } else {
                        java.lang.String str5 = this.typeKey;
                        if (str5 == null) {
                            str5 = jSONSerializer.config.typeKey;
                        }
                        serializeWriter.writeFieldName(str5, false);
                        java.lang.String str6 = this.typeName;
                        if (str6 == null) {
                            str6 = obj.getClass().getName();
                        }
                        jSONSerializer.write(str6);
                        z2 = true;
                    }
                    char c3 = !z2 ? ',' : (char) 0;
                    list = jSONSerializer.beforeFilters;
                    if (list != null) {
                        java.util.Iterator<com.alibaba.fastjson.serializer.BeforeFilter> it = list.iterator();
                        while (it.hasNext()) {
                            c3 = it.next().writeBefore(jSONSerializer, obj6, c3);
                        }
                    }
                    boolean z11 = c3 != ',';
                    i = serializeWriter.features;
                    if ((com.alibaba.fastjson.serializer.SerializerFeature.QuoteFieldNames.mask & i) != 0) {
                        if ((com.alibaba.fastjson.serializer.SerializerFeature.UseSingleQuotes.mask & i) == 0) {
                            z3 = true;
                            boolean z12 = (com.alibaba.fastjson.serializer.SerializerFeature.UseSingleQuotes.mask & i) != 0;
                            boolean z13 = (com.alibaba.fastjson.serializer.SerializerFeature.NotWriteDefaultValue.mask & i) != 0;
                            java.util.List<com.alibaba.fastjson.serializer.PropertyFilter> list7 = jSONSerializer.propertyFilters;
                            java.util.List<com.alibaba.fastjson.serializer.NameFilter> list8 = jSONSerializer.nameFilters;
                            boolean z14 = z11;
                            java.util.List<com.alibaba.fastjson.serializer.ValueFilter> list9 = jSONSerializer.valueFilters;
                            java.util.List<com.alibaba.fastjson.serializer.PropertyPreFilter> list10 = jSONSerializer.propertyPreFilters;
                            char c4 = c2;
                            i2 = 0;
                            while (i2 < fieldSerializerArr2.length) {
                                try {
                                    try {
                                        com.alibaba.fastjson.serializer.FieldSerializer fieldSerializer = fieldSerializerArr2[i2];
                                        com.alibaba.fastjson.serializer.FieldSerializer[] fieldSerializerArr3 = fieldSerializerArr2;
                                        com.alibaba.fastjson.util.FieldInfo fieldInfo2 = fieldSerializer.fieldInfo;
                                        int i14 = i2;
                                        java.lang.Class<?> cls = fieldInfo2.fieldClass;
                                        boolean z15 = z12;
                                        java.lang.String str7 = fieldInfo2.name;
                                        boolean z16 = z3;
                                        boolean z17 = z13;
                                        if (((com.alibaba.fastjson.serializer.SerializerFeature.SkipTransientField.mask & serializeWriter.features) == 0 || fieldInfo2.field == null || !fieldInfo2.fieldTransient) && ((str = this.typeKey) == null || !str.equals(str7))) {
                                            if (list10 != null) {
                                                java.util.Iterator<com.alibaba.fastjson.serializer.PropertyPreFilter> it2 = list10.iterator();
                                                while (it2.hasNext()) {
                                                    if (!it2.next().apply(jSONSerializer, obj6, str7)) {
                                                        z4 = false;
                                                        break;
                                                    }
                                                }
                                            }
                                            z4 = true;
                                            if (z4) {
                                                if (fieldInfo2.fieldAccess) {
                                                    propertyValue = null;
                                                    if (cls == java.lang.Integer.TYPE) {
                                                        j = 0;
                                                        z6 = false;
                                                        z7 = false;
                                                        i5 = fieldInfo2.field.getInt(obj6);
                                                        z5 = true;
                                                    } else if (cls == java.lang.Long.TYPE) {
                                                        j = fieldInfo2.field.getLong(obj6);
                                                        z5 = true;
                                                        z6 = false;
                                                        i5 = 0;
                                                        z7 = false;
                                                    } else if (cls == java.lang.Boolean.TYPE) {
                                                        z7 = fieldInfo2.field.getBoolean(obj6);
                                                        j = 0;
                                                        z5 = true;
                                                        z6 = false;
                                                        i5 = 0;
                                                    } else {
                                                        propertyValue = fieldInfo2.field.get(obj6);
                                                    }
                                                    if (list7 == null) {
                                                        if (z5) {
                                                            list3 = list10;
                                                            if (cls == java.lang.Integer.TYPE) {
                                                                propertyValue = java.lang.Integer.valueOf(i5);
                                                            } else if (cls == java.lang.Long.TYPE) {
                                                                propertyValue = java.lang.Long.valueOf(j);
                                                            } else if (cls == java.lang.Boolean.TYPE) {
                                                                propertyValue = java.lang.Boolean.valueOf(z7);
                                                            }
                                                            z6 = true;
                                                        } else {
                                                            list3 = list10;
                                                        }
                                                        java.util.Iterator<com.alibaba.fastjson.serializer.PropertyFilter> it3 = list7.iterator();
                                                        while (it3.hasNext()) {
                                                            java.util.Iterator<com.alibaba.fastjson.serializer.PropertyFilter> it4 = it3;
                                                            if (!it3.next().apply(obj6, str7, propertyValue)) {
                                                                z8 = false;
                                                                break;
                                                            }
                                                            it3 = it4;
                                                        }
                                                    } else {
                                                        list3 = list10;
                                                    }
                                                    z8 = true;
                                                    if (z8) {
                                                        list5 = list9;
                                                        list4 = list8;
                                                        list6 = list7;
                                                        i2 = i14 + 1;
                                                        obj6 = obj;
                                                        fieldSerializerArr2 = fieldSerializerArr3;
                                                        z12 = z15;
                                                        z3 = z16;
                                                        z13 = z17;
                                                        list10 = list3;
                                                        list8 = list4;
                                                        list9 = list5;
                                                        list7 = list6;
                                                    } else {
                                                        if (list8 != null) {
                                                            if (z5 && !z6) {
                                                                if (cls == java.lang.Integer.TYPE) {
                                                                    valueOf = java.lang.Integer.valueOf(i5);
                                                                } else if (cls == java.lang.Long.TYPE) {
                                                                    valueOf = java.lang.Long.valueOf(j);
                                                                } else if (cls == java.lang.Boolean.TYPE) {
                                                                    valueOf = java.lang.Boolean.valueOf(z7);
                                                                }
                                                                propertyValue = valueOf;
                                                                z6 = true;
                                                            }
                                                            list4 = list8;
                                                            str2 = str7;
                                                            for (java.util.Iterator<com.alibaba.fastjson.serializer.NameFilter> it5 = list8.iterator(); it5.hasNext(); it5 = it5) {
                                                                str2 = it5.next().process(obj6, str2, propertyValue);
                                                            }
                                                        } else {
                                                            list4 = list8;
                                                            str2 = str7;
                                                        }
                                                        if (list9 != null) {
                                                            if (z5 && !z6) {
                                                                if (cls == java.lang.Integer.TYPE) {
                                                                    propertyValue = java.lang.Integer.valueOf(i5);
                                                                } else if (cls == java.lang.Long.TYPE) {
                                                                    propertyValue = java.lang.Long.valueOf(j);
                                                                } else if (cls == java.lang.Boolean.TYPE) {
                                                                    propertyValue = java.lang.Boolean.valueOf(z7);
                                                                }
                                                                z6 = true;
                                                            }
                                                            java.util.Iterator<com.alibaba.fastjson.serializer.ValueFilter> it6 = list9.iterator();
                                                            list5 = list9;
                                                            java.lang.Object obj7 = propertyValue;
                                                            while (it6.hasNext()) {
                                                                java.util.Iterator<com.alibaba.fastjson.serializer.ValueFilter> it7 = it6;
                                                                obj7 = it6.next().process(obj6, str7, obj7);
                                                                it6 = it7;
                                                            }
                                                            obj3 = propertyValue;
                                                            propertyValue = obj7;
                                                        } else {
                                                            list5 = list9;
                                                            obj3 = propertyValue;
                                                        }
                                                        list6 = list7;
                                                        if (z6 && propertyValue == null) {
                                                            obj4 = propertyValue;
                                                            int i15 = this.features | fieldInfo2.serialzeFeatures;
                                                            int i16 = serializeWriter.features;
                                                            int i17 = i15 | i16;
                                                            fieldInfo = fieldInfo2;
                                                            if (cls == java.lang.Boolean.class) {
                                                                int i18 = com.alibaba.fastjson.serializer.SerializerFeature.WriteNullBooleanAsFalse.mask;
                                                                str3 = "";
                                                                int i19 = com.alibaba.fastjson.serializer.SerializerFeature.WriteMapNullValue.mask | i18;
                                                                if (!z10 && (i17 & i19) == 0 && (i19 & i16) == 0) {
                                                                    i2 = i14 + 1;
                                                                    obj6 = obj;
                                                                    fieldSerializerArr2 = fieldSerializerArr3;
                                                                    z12 = z15;
                                                                    z3 = z16;
                                                                    z13 = z17;
                                                                    list10 = list3;
                                                                    list8 = list4;
                                                                    list9 = list5;
                                                                    list7 = list6;
                                                                } else if ((i17 & i18) != 0 || (i16 & i18) != 0) {
                                                                    obj5 = java.lang.Boolean.FALSE;
                                                                    if (z6 || obj5 == null || !z17 || (((cls != java.lang.Byte.TYPE && cls != java.lang.Short.TYPE && cls != java.lang.Integer.TYPE && cls != java.lang.Long.TYPE && cls != java.lang.Float.TYPE && cls != java.lang.Double.TYPE) || !(obj5 instanceof java.lang.Number) || ((java.lang.Number) obj5).byteValue() != 0) && (cls != java.lang.Boolean.TYPE || !(obj5 instanceof java.lang.Boolean) || ((java.lang.Boolean) obj5).booleanValue()))) {
                                                                        if (z14) {
                                                                            int i20 = serializeWriter.count + 1;
                                                                            if (i20 > serializeWriter.buf.length) {
                                                                                if (serializeWriter.writer == null) {
                                                                                    serializeWriter.expandCapacity(i20);
                                                                                } else {
                                                                                    serializeWriter.flush();
                                                                                    i20 = 1;
                                                                                }
                                                                            }
                                                                            serializeWriter.buf[serializeWriter.count] = ',';
                                                                            serializeWriter.count = i20;
                                                                            if ((serializeWriter.features & com.alibaba.fastjson.serializer.SerializerFeature.PrettyFormat.mask) != 0) {
                                                                                jSONSerializer.println();
                                                                            }
                                                                        }
                                                                        if (str2 != str7) {
                                                                            if (!z10) {
                                                                                serializeWriter.writeFieldName(str2, true);
                                                                            }
                                                                            jSONSerializer.write(obj5);
                                                                        } else if (obj3 != obj5) {
                                                                            if (!z10) {
                                                                                fieldSerializer.writePrefix(jSONSerializer);
                                                                            }
                                                                            jSONSerializer.write(obj5);
                                                                        } else {
                                                                            if (!z10) {
                                                                                if (z16) {
                                                                                    char[] cArr = fieldSerializer.name_chars;
                                                                                    int length = cArr.length;
                                                                                    int i21 = serializeWriter.count + length;
                                                                                    if (i21 > serializeWriter.buf.length) {
                                                                                        if (serializeWriter.writer == null) {
                                                                                            serializeWriter.expandCapacity(i21);
                                                                                        } else {
                                                                                            int i22 = 0;
                                                                                            do {
                                                                                                char[] cArr2 = serializeWriter.buf;
                                                                                                int length2 = cArr2.length;
                                                                                                int i23 = serializeWriter.count;
                                                                                                int i24 = length2 - i23;
                                                                                                java.lang.System.arraycopy(cArr, i22, cArr2, i23, i24);
                                                                                                serializeWriter.count = serializeWriter.buf.length;
                                                                                                serializeWriter.flush();
                                                                                                length -= i24;
                                                                                                i22 += i24;
                                                                                            } while (length > serializeWriter.buf.length);
                                                                                            i6 = i22;
                                                                                            i21 = length;
                                                                                            java.lang.System.arraycopy(cArr, i6, serializeWriter.buf, serializeWriter.count, length);
                                                                                            serializeWriter.count = i21;
                                                                                        }
                                                                                    }
                                                                                    i6 = 0;
                                                                                    java.lang.System.arraycopy(cArr, i6, serializeWriter.buf, serializeWriter.count, length);
                                                                                    serializeWriter.count = i21;
                                                                                } else {
                                                                                    fieldSerializer.writePrefix(jSONSerializer);
                                                                                }
                                                                            }
                                                                            if (!z5 || z6) {
                                                                                if (z10) {
                                                                                    fieldSerializer.writeValue(jSONSerializer, obj5);
                                                                                } else if (cls == java.lang.String.class) {
                                                                                    int i25 = fieldSerializer.features | this.features;
                                                                                    if (obj5 == null) {
                                                                                        int i26 = serializeWriter.features;
                                                                                        int i27 = com.alibaba.fastjson.serializer.SerializerFeature.WriteNullStringAsEmpty.mask;
                                                                                        if ((i26 & i27) == 0 && (i25 & i27) == 0) {
                                                                                            serializeWriter.writeNull();
                                                                                        }
                                                                                        serializeWriter.writeString(str3);
                                                                                    } else {
                                                                                        java.lang.String str8 = (java.lang.String) obj5;
                                                                                        if (z15) {
                                                                                            serializeWriter.writeStringWithSingleQuote(str8);
                                                                                        } else {
                                                                                            serializeWriter.writeStringWithDoubleQuote(str8, (char) 0, true);
                                                                                        }
                                                                                    }
                                                                                } else if (!fieldInfo.isEnum) {
                                                                                    fieldSerializer.writeValue(jSONSerializer, obj5);
                                                                                } else if (obj5 == null) {
                                                                                    serializeWriter.writeNull();
                                                                                } else if ((serializeWriter.features & com.alibaba.fastjson.serializer.SerializerFeature.WriteEnumUsingToString.mask) != 0) {
                                                                                    java.lang.String str9 = ((java.lang.Enum) obj5).toString();
                                                                                    if ((serializeWriter.features & com.alibaba.fastjson.serializer.SerializerFeature.UseSingleQuotes.mask) != 0) {
                                                                                        serializeWriter.writeStringWithSingleQuote(str9);
                                                                                    } else {
                                                                                        serializeWriter.writeStringWithDoubleQuote(str9, (char) 0, false);
                                                                                    }
                                                                                } else {
                                                                                    serializeWriter.writeInt(((java.lang.Enum) obj5).ordinal());
                                                                                }
                                                                                z14 = true;
                                                                                i2 = i14 + 1;
                                                                                obj6 = obj;
                                                                                fieldSerializerArr2 = fieldSerializerArr3;
                                                                                z12 = z15;
                                                                                z3 = z16;
                                                                                z13 = z17;
                                                                                list10 = list3;
                                                                                list8 = list4;
                                                                                list9 = list5;
                                                                                list7 = list6;
                                                                            } else if (cls == java.lang.Integer.TYPE) {
                                                                                int i28 = i5;
                                                                                if (i28 == Integer.MIN_VALUE) {
                                                                                    serializeWriter.write("-2147483648");
                                                                                } else {
                                                                                    int i29 = 0;
                                                                                    while ((i28 < 0 ? -i28 : i28) > com.alibaba.fastjson.serializer.SerializeWriter.sizeTable[i29]) {
                                                                                        i29++;
                                                                                    }
                                                                                    int i30 = i29 + 1;
                                                                                    if (i28 < 0) {
                                                                                        i30++;
                                                                                    }
                                                                                    int i31 = serializeWriter.count + i30;
                                                                                    if (i31 > serializeWriter.buf.length) {
                                                                                        if (serializeWriter.writer == null) {
                                                                                            serializeWriter.expandCapacity(i31);
                                                                                        } else {
                                                                                            char[] cArr3 = new char[i30];
                                                                                            com.alibaba.fastjson.serializer.SerializeWriter.getChars(i28, i30, cArr3);
                                                                                            serializeWriter.write(cArr3, 0, i30);
                                                                                            z9 = true;
                                                                                            if (!z9) {
                                                                                                com.alibaba.fastjson.serializer.SerializeWriter.getChars(i28, i31, serializeWriter.buf);
                                                                                                serializeWriter.count = i31;
                                                                                            }
                                                                                        }
                                                                                    }
                                                                                    z9 = false;
                                                                                    if (!z9) {
                                                                                    }
                                                                                }
                                                                            } else if (cls == java.lang.Long.TYPE) {
                                                                                jSONSerializer.out.writeLong(j);
                                                                            } else if (cls == java.lang.Boolean.TYPE) {
                                                                                if (z7) {
                                                                                    com.alibaba.fastjson.serializer.SerializeWriter serializeWriter2 = jSONSerializer.out;
                                                                                    char[] cArr4 = true_chars;
                                                                                    serializeWriter2.write(cArr4, 0, cArr4.length);
                                                                                } else {
                                                                                    com.alibaba.fastjson.serializer.SerializeWriter serializeWriter3 = jSONSerializer.out;
                                                                                    char[] cArr5 = false_chars;
                                                                                    serializeWriter3.write(cArr5, 0, cArr5.length);
                                                                                }
                                                                            }
                                                                        }
                                                                        z14 = true;
                                                                        i2 = i14 + 1;
                                                                        obj6 = obj;
                                                                        fieldSerializerArr2 = fieldSerializerArr3;
                                                                        z12 = z15;
                                                                        z3 = z16;
                                                                        z13 = z17;
                                                                        list10 = list3;
                                                                        list8 = list4;
                                                                        list9 = list5;
                                                                        list7 = list6;
                                                                    }
                                                                    i2 = i14 + 1;
                                                                    obj6 = obj;
                                                                    fieldSerializerArr2 = fieldSerializerArr3;
                                                                    z12 = z15;
                                                                    z3 = z16;
                                                                    z13 = z17;
                                                                    list10 = list3;
                                                                    list8 = list4;
                                                                    list9 = list5;
                                                                    list7 = list6;
                                                                }
                                                            } else {
                                                                str3 = "";
                                                                if (cls == java.lang.String.class) {
                                                                    int i32 = com.alibaba.fastjson.serializer.SerializerFeature.WriteNullStringAsEmpty.mask;
                                                                    int i33 = com.alibaba.fastjson.serializer.SerializerFeature.WriteMapNullValue.mask | i32;
                                                                    if (!z10 && (i17 & i33) == 0 && (i33 & i16) == 0) {
                                                                        i2 = i14 + 1;
                                                                        obj6 = obj;
                                                                        fieldSerializerArr2 = fieldSerializerArr3;
                                                                        z12 = z15;
                                                                        z3 = z16;
                                                                        z13 = z17;
                                                                        list10 = list3;
                                                                        list8 = list4;
                                                                        list9 = list5;
                                                                        list7 = list6;
                                                                    } else if ((i17 & i32) != 0 || (i16 & i32) != 0) {
                                                                        obj5 = str3;
                                                                        if (z6) {
                                                                        }
                                                                        if (z14) {
                                                                        }
                                                                        if (str2 != str7) {
                                                                        }
                                                                        z14 = true;
                                                                        i2 = i14 + 1;
                                                                        obj6 = obj;
                                                                        fieldSerializerArr2 = fieldSerializerArr3;
                                                                        z12 = z15;
                                                                        z3 = z16;
                                                                        z13 = z17;
                                                                        list10 = list3;
                                                                        list8 = list4;
                                                                        list9 = list5;
                                                                        list7 = list6;
                                                                    }
                                                                } else if (java.lang.Number.class.isAssignableFrom(cls)) {
                                                                    int i34 = com.alibaba.fastjson.serializer.SerializerFeature.WriteNullNumberAsZero.mask;
                                                                    int i35 = com.alibaba.fastjson.serializer.SerializerFeature.WriteMapNullValue.mask | i34;
                                                                    if (!z10 && (i17 & i35) == 0 && (i35 & serializeWriter.features) == 0) {
                                                                        i2 = i14 + 1;
                                                                        obj6 = obj;
                                                                        fieldSerializerArr2 = fieldSerializerArr3;
                                                                        z12 = z15;
                                                                        z3 = z16;
                                                                        z13 = z17;
                                                                        list10 = list3;
                                                                        list8 = list4;
                                                                        list9 = list5;
                                                                        list7 = list6;
                                                                    } else if ((i17 & i34) != 0 || (serializeWriter.features & i34) != 0) {
                                                                        obj5 = 0;
                                                                        if (z6) {
                                                                        }
                                                                        if (z14) {
                                                                        }
                                                                        if (str2 != str7) {
                                                                        }
                                                                        z14 = true;
                                                                        i2 = i14 + 1;
                                                                        obj6 = obj;
                                                                        fieldSerializerArr2 = fieldSerializerArr3;
                                                                        z12 = z15;
                                                                        z3 = z16;
                                                                        z13 = z17;
                                                                        list10 = list3;
                                                                        list8 = list4;
                                                                        list9 = list5;
                                                                        list7 = list6;
                                                                    }
                                                                } else if (java.util.Collection.class.isAssignableFrom(cls)) {
                                                                    int i36 = com.alibaba.fastjson.serializer.SerializerFeature.WriteNullListAsEmpty.mask;
                                                                    int i37 = com.alibaba.fastjson.serializer.SerializerFeature.WriteMapNullValue.mask | i36;
                                                                    if (!z10 && (i17 & i37) == 0 && (i37 & serializeWriter.features) == 0) {
                                                                        i2 = i14 + 1;
                                                                        obj6 = obj;
                                                                        fieldSerializerArr2 = fieldSerializerArr3;
                                                                        z12 = z15;
                                                                        z3 = z16;
                                                                        z13 = z17;
                                                                        list10 = list3;
                                                                        list8 = list4;
                                                                        list9 = list5;
                                                                        list7 = list6;
                                                                    } else if ((i17 & i36) != 0 || (serializeWriter.features & i36) != 0) {
                                                                        obj5 = java.util.Collections.emptyList();
                                                                        if (z6) {
                                                                        }
                                                                        if (z14) {
                                                                        }
                                                                        if (str2 != str7) {
                                                                        }
                                                                        z14 = true;
                                                                        i2 = i14 + 1;
                                                                        obj6 = obj;
                                                                        fieldSerializerArr2 = fieldSerializerArr3;
                                                                        z12 = z15;
                                                                        z3 = z16;
                                                                        z13 = z17;
                                                                        list10 = list3;
                                                                        list8 = list4;
                                                                        list9 = list5;
                                                                        list7 = list6;
                                                                    }
                                                                } else if (!z10 && !fieldSerializer.writeNull && !serializeWriter.isEnabled(com.alibaba.fastjson.serializer.SerializerFeature.WriteMapNullValue)) {
                                                                    i2 = i14 + 1;
                                                                    obj6 = obj;
                                                                    fieldSerializerArr2 = fieldSerializerArr3;
                                                                    z12 = z15;
                                                                    z3 = z16;
                                                                    z13 = z17;
                                                                    list10 = list3;
                                                                    list8 = list4;
                                                                    list9 = list5;
                                                                    list7 = list6;
                                                                }
                                                            }
                                                        } else {
                                                            str3 = "";
                                                            fieldInfo = fieldInfo2;
                                                            obj4 = propertyValue;
                                                        }
                                                        obj5 = obj4;
                                                        if (z6) {
                                                        }
                                                        if (z14) {
                                                        }
                                                        if (str2 != str7) {
                                                        }
                                                        z14 = true;
                                                        i2 = i14 + 1;
                                                        obj6 = obj;
                                                        fieldSerializerArr2 = fieldSerializerArr3;
                                                        z12 = z15;
                                                        z3 = z16;
                                                        z13 = z17;
                                                        list10 = list3;
                                                        list8 = list4;
                                                        list9 = list5;
                                                        list7 = list6;
                                                    }
                                                } else {
                                                    propertyValue = fieldSerializer.getPropertyValue(obj6);
                                                }
                                                j = 0;
                                                z5 = false;
                                                z6 = true;
                                                i5 = 0;
                                                z7 = false;
                                                if (list7 == null) {
                                                }
                                                z8 = true;
                                                if (z8) {
                                                }
                                            }
                                        }
                                        list3 = list10;
                                        list5 = list9;
                                        list4 = list8;
                                        list6 = list7;
                                        i2 = i14 + 1;
                                        obj6 = obj;
                                        fieldSerializerArr2 = fieldSerializerArr3;
                                        z12 = z15;
                                        z3 = z16;
                                        z13 = z17;
                                        list10 = list3;
                                        list8 = list4;
                                        list9 = list5;
                                        list7 = list6;
                                    } catch (java.lang.Exception e2) {
                                        exc = e2;
                                        serialContext = serialContext4;
                                        java.lang.String str42 = "write javaBean error, fastjson version 1.1.74";
                                        if (obj2 != null) {
                                            try {
                                                str42 = "write javaBean error, fastjson version 1.1.74, fieldName : " + obj2;
                                            } catch (java.lang.Throwable th3) {
                                                th = th3;
                                                th = th;
                                                jSONSerializer.context = serialContext;
                                                throw th;
                                            }
                                        }
                                        throw new com.alibaba.fastjson.JSONException(str42, exc);
                                    } catch (java.lang.Throwable th4) {
                                        th = th4;
                                        serialContext = serialContext4;
                                        jSONSerializer.context = serialContext;
                                        throw th;
                                    }
                                } catch (java.lang.Exception e3) {
                                    e = e3;
                                    serialContext = serialContext4;
                                    exc = e;
                                    java.lang.String str422 = "write javaBean error, fastjson version 1.1.74";
                                    if (obj2 != null) {
                                    }
                                    throw new com.alibaba.fastjson.JSONException(str422, exc);
                                } catch (java.lang.Throwable th5) {
                                    th = th5;
                                    serialContext = serialContext4;
                                    th = th;
                                    jSONSerializer.context = serialContext;
                                    throw th;
                                }
                            }
                            fieldSerializerArr = fieldSerializerArr2;
                            list2 = jSONSerializer.afterFilters;
                            if (list2 != null) {
                                char c5 = z14 ? ',' : (char) 0;
                                java.util.Iterator<com.alibaba.fastjson.serializer.AfterFilter> it8 = list2.iterator();
                                while (it8.hasNext()) {
                                    c5 = it8.next().writeAfter(jSONSerializer, obj, c5);
                                }
                            }
                            if (fieldSerializerArr.length > 0 && (serializeWriter.features & com.alibaba.fastjson.serializer.SerializerFeature.PrettyFormat.mask) != 0) {
                                jSONSerializer.decrementIdent();
                                jSONSerializer.println();
                            }
                            i3 = serializeWriter.count + 1;
                            if (i3 > serializeWriter.buf.length) {
                                if (serializeWriter.writer != null) {
                                    serializeWriter.flush();
                                    i4 = 1;
                                    serializeWriter.buf[serializeWriter.count] = c4;
                                    serializeWriter.count = i4;
                                    jSONSerializer.context = serialContext4;
                                }
                                serializeWriter.expandCapacity(i3);
                            }
                            i4 = i3;
                            serializeWriter.buf[serializeWriter.count] = c4;
                            serializeWriter.count = i4;
                            jSONSerializer.context = serialContext4;
                        }
                    }
                    z3 = false;
                    if ((com.alibaba.fastjson.serializer.SerializerFeature.UseSingleQuotes.mask & i) != 0) {
                    }
                    if ((com.alibaba.fastjson.serializer.SerializerFeature.NotWriteDefaultValue.mask & i) != 0) {
                    }
                    java.util.List<com.alibaba.fastjson.serializer.PropertyFilter> list72 = jSONSerializer.propertyFilters;
                    java.util.List<com.alibaba.fastjson.serializer.NameFilter> list82 = jSONSerializer.nameFilters;
                    boolean z142 = z11;
                    java.util.List<com.alibaba.fastjson.serializer.ValueFilter> list92 = jSONSerializer.valueFilters;
                    java.util.List<com.alibaba.fastjson.serializer.PropertyPreFilter> list102 = jSONSerializer.propertyPreFilters;
                    char c42 = c2;
                    i2 = 0;
                    while (i2 < fieldSerializerArr2.length) {
                    }
                    fieldSerializerArr = fieldSerializerArr2;
                    list2 = jSONSerializer.afterFilters;
                    if (list2 != null) {
                    }
                    if (fieldSerializerArr.length > 0) {
                        jSONSerializer.decrementIdent();
                        jSONSerializer.println();
                    }
                    i3 = serializeWriter.count + 1;
                    if (i3 > serializeWriter.buf.length) {
                    }
                    i4 = i3;
                    serializeWriter.buf[serializeWriter.count] = c42;
                    serializeWriter.count = i4;
                    jSONSerializer.context = serialContext4;
                }
            }
            z = true;
            if (z) {
            }
            z2 = false;
            if (!z2) {
            }
            list = jSONSerializer.beforeFilters;
            if (list != null) {
            }
            if (c3 != ',') {
            }
            i = serializeWriter.features;
            if ((com.alibaba.fastjson.serializer.SerializerFeature.QuoteFieldNames.mask & i) != 0) {
            }
            z3 = false;
            if ((com.alibaba.fastjson.serializer.SerializerFeature.UseSingleQuotes.mask & i) != 0) {
            }
            if ((com.alibaba.fastjson.serializer.SerializerFeature.NotWriteDefaultValue.mask & i) != 0) {
            }
            java.util.List<com.alibaba.fastjson.serializer.PropertyFilter> list722 = jSONSerializer.propertyFilters;
            java.util.List<com.alibaba.fastjson.serializer.NameFilter> list822 = jSONSerializer.nameFilters;
            boolean z1422 = z11;
            java.util.List<com.alibaba.fastjson.serializer.ValueFilter> list922 = jSONSerializer.valueFilters;
            java.util.List<com.alibaba.fastjson.serializer.PropertyPreFilter> list1022 = jSONSerializer.propertyPreFilters;
            char c422 = c2;
            i2 = 0;
            while (i2 < fieldSerializerArr2.length) {
            }
            fieldSerializerArr = fieldSerializerArr2;
            list2 = jSONSerializer.afterFilters;
            if (list2 != null) {
            }
            if (fieldSerializerArr.length > 0) {
            }
            i3 = serializeWriter.count + 1;
            if (i3 > serializeWriter.buf.length) {
            }
            i4 = i3;
            serializeWriter.buf[serializeWriter.count] = c422;
            serializeWriter.count = i4;
            jSONSerializer.context = serialContext4;
        } catch (java.lang.Exception e4) {
            e = e4;
            serialContext = serialContext4;
        } catch (java.lang.Throwable th6) {
            th = th6;
            serialContext = serialContext4;
        }
    }
}
