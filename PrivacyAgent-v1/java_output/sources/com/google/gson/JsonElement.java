package com.google.gson;

/* loaded from: classes22.dex */
public abstract class JsonElement {
    public abstract com.google.gson.JsonElement deepCopy();

    public java.math.BigDecimal getAsBigDecimal() {
        throw new java.lang.UnsupportedOperationException(getClass().getSimpleName());
    }

    public java.math.BigInteger getAsBigInteger() {
        throw new java.lang.UnsupportedOperationException(getClass().getSimpleName());
    }

    public boolean getAsBoolean() {
        throw new java.lang.UnsupportedOperationException(getClass().getSimpleName());
    }

    public byte getAsByte() {
        throw new java.lang.UnsupportedOperationException(getClass().getSimpleName());
    }

    @java.lang.Deprecated
    public char getAsCharacter() {
        throw new java.lang.UnsupportedOperationException(getClass().getSimpleName());
    }

    public double getAsDouble() {
        throw new java.lang.UnsupportedOperationException(getClass().getSimpleName());
    }

    public float getAsFloat() {
        throw new java.lang.UnsupportedOperationException(getClass().getSimpleName());
    }

    public int getAsInt() {
        throw new java.lang.UnsupportedOperationException(getClass().getSimpleName());
    }

    public com.google.gson.JsonArray getAsJsonArray() {
        if (isJsonArray()) {
            return (com.google.gson.JsonArray) this;
        }
        throw new java.lang.IllegalStateException("Not a JSON Array: " + this);
    }

    public com.google.gson.JsonNull getAsJsonNull() {
        if (isJsonNull()) {
            return (com.google.gson.JsonNull) this;
        }
        throw new java.lang.IllegalStateException("Not a JSON Null: " + this);
    }

    public com.google.gson.JsonObject getAsJsonObject() {
        if (isJsonObject()) {
            return (com.google.gson.JsonObject) this;
        }
        throw new java.lang.IllegalStateException("Not a JSON Object: " + this);
    }

    public com.google.gson.JsonPrimitive getAsJsonPrimitive() {
        if (isJsonPrimitive()) {
            return (com.google.gson.JsonPrimitive) this;
        }
        throw new java.lang.IllegalStateException("Not a JSON Primitive: " + this);
    }

    public long getAsLong() {
        throw new java.lang.UnsupportedOperationException(getClass().getSimpleName());
    }

    public java.lang.Number getAsNumber() {
        throw new java.lang.UnsupportedOperationException(getClass().getSimpleName());
    }

    public short getAsShort() {
        throw new java.lang.UnsupportedOperationException(getClass().getSimpleName());
    }

    public java.lang.String getAsString() {
        throw new java.lang.UnsupportedOperationException(getClass().getSimpleName());
    }

    public boolean isJsonArray() {
        return this instanceof com.google.gson.JsonArray;
    }

    public boolean isJsonNull() {
        return this instanceof com.google.gson.JsonNull;
    }

    public boolean isJsonObject() {
        return this instanceof com.google.gson.JsonObject;
    }

    public boolean isJsonPrimitive() {
        return this instanceof com.google.gson.JsonPrimitive;
    }

    public java.lang.String toString() {
        try {
            java.io.StringWriter stringWriter = new java.io.StringWriter();
            com.google.gson.stream.JsonWriter jsonWriter = new com.google.gson.stream.JsonWriter(stringWriter);
            jsonWriter.setLenient(true);
            com.google.gson.internal.Streams.write(this, jsonWriter);
            return stringWriter.toString();
        } catch (java.io.IOException e) {
            throw new java.lang.AssertionError(e);
        }
    }
}
