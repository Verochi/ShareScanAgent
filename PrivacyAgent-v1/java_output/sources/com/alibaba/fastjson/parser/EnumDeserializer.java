package com.alibaba.fastjson.parser;

/* loaded from: classes.dex */
public class EnumDeserializer implements com.alibaba.fastjson.parser.deserializer.ObjectDeserializer {
    private final java.lang.Class<?> enumClass;
    protected long[] enumNameHashCodes;
    protected final java.lang.Enum[] enums;
    protected final java.lang.Enum[] ordinalEnums;

    public EnumDeserializer(java.lang.Class<?> cls) {
        this.enumClass = cls;
        java.lang.Enum[] enumArr = (java.lang.Enum[]) cls.getEnumConstants();
        this.ordinalEnums = enumArr;
        int length = enumArr.length;
        long[] jArr = new long[length];
        this.enumNameHashCodes = new long[enumArr.length];
        int i = 0;
        while (true) {
            java.lang.Enum[] enumArr2 = this.ordinalEnums;
            if (i >= enumArr2.length) {
                break;
            }
            long j = -3750763034362895579L;
            for (int i2 = 0; i2 < enumArr2[i].name().length(); i2++) {
                j = (j ^ r3.charAt(i2)) * 1099511628211L;
            }
            jArr[i] = j;
            this.enumNameHashCodes[i] = j;
            i++;
        }
        java.util.Arrays.sort(this.enumNameHashCodes);
        this.enums = new java.lang.Enum[this.ordinalEnums.length];
        for (int i3 = 0; i3 < this.enumNameHashCodes.length; i3++) {
            int i4 = 0;
            while (true) {
                if (i4 >= length) {
                    break;
                }
                if (this.enumNameHashCodes[i3] == jArr[i4]) {
                    this.enums[i3] = this.ordinalEnums[i4];
                    break;
                }
                i4++;
            }
        }
    }

    @Override // com.alibaba.fastjson.parser.deserializer.ObjectDeserializer
    public <T> T deserialze(com.alibaba.fastjson.parser.DefaultJSONParser defaultJSONParser, java.lang.reflect.Type type, java.lang.Object obj) {
        try {
            com.alibaba.fastjson.parser.JSONLexer jSONLexer = defaultJSONParser.lexer;
            int i = jSONLexer.token;
            if (i == 2) {
                int intValue = jSONLexer.intValue();
                jSONLexer.nextToken(16);
                if (intValue >= 0) {
                    java.lang.Object[] objArr = this.ordinalEnums;
                    if (intValue <= objArr.length) {
                        return (T) objArr[intValue];
                    }
                }
                throw new com.alibaba.fastjson.JSONException("parse enum " + this.enumClass.getName() + " error, value : " + intValue);
            }
            if (i != 4) {
                if (i == 8) {
                    jSONLexer.nextToken(16);
                    return null;
                }
                throw new com.alibaba.fastjson.JSONException("parse enum " + this.enumClass.getName() + " error, value : " + defaultJSONParser.parse());
            }
            java.lang.String stringVal = jSONLexer.stringVal();
            jSONLexer.nextToken(16);
            if (stringVal.length() == 0) {
                return null;
            }
            long j = -3750763034362895579L;
            for (int i2 = 0; i2 < stringVal.length(); i2++) {
                j = (j ^ stringVal.charAt(i2)) * 1099511628211L;
            }
            int binarySearch = java.util.Arrays.binarySearch(this.enumNameHashCodes, j);
            if (binarySearch < 0) {
                return null;
            }
            return (T) this.enums[binarySearch];
        } catch (com.alibaba.fastjson.JSONException e) {
            throw e;
        } catch (java.lang.Exception e2) {
            throw new com.alibaba.fastjson.JSONException(e2.getMessage(), e2);
        }
    }
}
