package com.google.gson;

/* loaded from: classes22.dex */
public final class JsonPrimitive extends com.google.gson.JsonElement {
    private final java.lang.Object value;

    public JsonPrimitive(java.lang.Boolean bool) {
        this.value = com.google.gson.internal.C$Gson$Preconditions.checkNotNull(bool);
    }

    public JsonPrimitive(java.lang.Character ch) {
        this.value = ((java.lang.Character) com.google.gson.internal.C$Gson$Preconditions.checkNotNull(ch)).toString();
    }

    public JsonPrimitive(java.lang.Number number) {
        this.value = com.google.gson.internal.C$Gson$Preconditions.checkNotNull(number);
    }

    public JsonPrimitive(java.lang.String str) {
        this.value = com.google.gson.internal.C$Gson$Preconditions.checkNotNull(str);
    }

    private static boolean isIntegral(com.google.gson.JsonPrimitive jsonPrimitive) {
        java.lang.Object obj = jsonPrimitive.value;
        if (!(obj instanceof java.lang.Number)) {
            return false;
        }
        java.lang.Number number = (java.lang.Number) obj;
        return (number instanceof java.math.BigInteger) || (number instanceof java.lang.Long) || (number instanceof java.lang.Integer) || (number instanceof java.lang.Short) || (number instanceof java.lang.Byte);
    }

    @Override // com.google.gson.JsonElement
    public com.google.gson.JsonPrimitive deepCopy() {
        return this;
    }

    public boolean equals(java.lang.Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || com.google.gson.JsonPrimitive.class != obj.getClass()) {
            return false;
        }
        com.google.gson.JsonPrimitive jsonPrimitive = (com.google.gson.JsonPrimitive) obj;
        if (this.value == null) {
            return jsonPrimitive.value == null;
        }
        if (isIntegral(this) && isIntegral(jsonPrimitive)) {
            return getAsNumber().longValue() == jsonPrimitive.getAsNumber().longValue();
        }
        java.lang.Object obj2 = this.value;
        if (!(obj2 instanceof java.lang.Number) || !(jsonPrimitive.value instanceof java.lang.Number)) {
            return obj2.equals(jsonPrimitive.value);
        }
        double doubleValue = getAsNumber().doubleValue();
        double doubleValue2 = jsonPrimitive.getAsNumber().doubleValue();
        if (doubleValue != doubleValue2) {
            return java.lang.Double.isNaN(doubleValue) && java.lang.Double.isNaN(doubleValue2);
        }
        return true;
    }

    @Override // com.google.gson.JsonElement
    public java.math.BigDecimal getAsBigDecimal() {
        java.lang.Object obj = this.value;
        return obj instanceof java.math.BigDecimal ? (java.math.BigDecimal) obj : new java.math.BigDecimal(this.value.toString());
    }

    @Override // com.google.gson.JsonElement
    public java.math.BigInteger getAsBigInteger() {
        java.lang.Object obj = this.value;
        return obj instanceof java.math.BigInteger ? (java.math.BigInteger) obj : new java.math.BigInteger(this.value.toString());
    }

    @Override // com.google.gson.JsonElement
    public boolean getAsBoolean() {
        return isBoolean() ? ((java.lang.Boolean) this.value).booleanValue() : java.lang.Boolean.parseBoolean(getAsString());
    }

    @Override // com.google.gson.JsonElement
    public byte getAsByte() {
        return isNumber() ? getAsNumber().byteValue() : java.lang.Byte.parseByte(getAsString());
    }

    @Override // com.google.gson.JsonElement
    public char getAsCharacter() {
        return getAsString().charAt(0);
    }

    @Override // com.google.gson.JsonElement
    public double getAsDouble() {
        return isNumber() ? getAsNumber().doubleValue() : java.lang.Double.parseDouble(getAsString());
    }

    @Override // com.google.gson.JsonElement
    public float getAsFloat() {
        return isNumber() ? getAsNumber().floatValue() : java.lang.Float.parseFloat(getAsString());
    }

    @Override // com.google.gson.JsonElement
    public int getAsInt() {
        return isNumber() ? getAsNumber().intValue() : java.lang.Integer.parseInt(getAsString());
    }

    @Override // com.google.gson.JsonElement
    public long getAsLong() {
        return isNumber() ? getAsNumber().longValue() : java.lang.Long.parseLong(getAsString());
    }

    @Override // com.google.gson.JsonElement
    public java.lang.Number getAsNumber() {
        java.lang.Object obj = this.value;
        return obj instanceof java.lang.String ? new com.google.gson.internal.LazilyParsedNumber((java.lang.String) obj) : (java.lang.Number) obj;
    }

    @Override // com.google.gson.JsonElement
    public short getAsShort() {
        return isNumber() ? getAsNumber().shortValue() : java.lang.Short.parseShort(getAsString());
    }

    @Override // com.google.gson.JsonElement
    public java.lang.String getAsString() {
        return isNumber() ? getAsNumber().toString() : isBoolean() ? ((java.lang.Boolean) this.value).toString() : (java.lang.String) this.value;
    }

    public int hashCode() {
        long doubleToLongBits;
        if (this.value == null) {
            return 31;
        }
        if (isIntegral(this)) {
            doubleToLongBits = getAsNumber().longValue();
        } else {
            java.lang.Object obj = this.value;
            if (!(obj instanceof java.lang.Number)) {
                return obj.hashCode();
            }
            doubleToLongBits = java.lang.Double.doubleToLongBits(getAsNumber().doubleValue());
        }
        return (int) ((doubleToLongBits >>> 32) ^ doubleToLongBits);
    }

    public boolean isBoolean() {
        return this.value instanceof java.lang.Boolean;
    }

    public boolean isNumber() {
        return this.value instanceof java.lang.Number;
    }

    public boolean isString() {
        return this.value instanceof java.lang.String;
    }
}
