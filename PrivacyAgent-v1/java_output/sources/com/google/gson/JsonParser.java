package com.google.gson;

/* loaded from: classes22.dex */
public final class JsonParser {
    @java.lang.Deprecated
    public JsonParser() {
    }

    public static com.google.gson.JsonElement parseReader(com.google.gson.stream.JsonReader jsonReader) throws com.google.gson.JsonIOException, com.google.gson.JsonSyntaxException {
        boolean isLenient = jsonReader.isLenient();
        jsonReader.setLenient(true);
        try {
            try {
                return com.google.gson.internal.Streams.parse(jsonReader);
            } catch (java.lang.OutOfMemoryError e) {
                throw new com.google.gson.JsonParseException("Failed parsing JSON source: " + jsonReader + " to Json", e);
            } catch (java.lang.StackOverflowError e2) {
                throw new com.google.gson.JsonParseException("Failed parsing JSON source: " + jsonReader + " to Json", e2);
            }
        } finally {
            jsonReader.setLenient(isLenient);
        }
    }

    public static com.google.gson.JsonElement parseReader(java.io.Reader reader) throws com.google.gson.JsonIOException, com.google.gson.JsonSyntaxException {
        try {
            com.google.gson.stream.JsonReader jsonReader = new com.google.gson.stream.JsonReader(reader);
            com.google.gson.JsonElement parseReader = parseReader(jsonReader);
            if (!parseReader.isJsonNull() && jsonReader.peek() != com.google.gson.stream.JsonToken.END_DOCUMENT) {
                throw new com.google.gson.JsonSyntaxException("Did not consume the entire document.");
            }
            return parseReader;
        } catch (com.google.gson.stream.MalformedJsonException e) {
            throw new com.google.gson.JsonSyntaxException(e);
        } catch (java.io.IOException e2) {
            throw new com.google.gson.JsonIOException(e2);
        } catch (java.lang.NumberFormatException e3) {
            throw new com.google.gson.JsonSyntaxException(e3);
        }
    }

    public static com.google.gson.JsonElement parseString(java.lang.String str) throws com.google.gson.JsonSyntaxException {
        return parseReader(new java.io.StringReader(str));
    }

    @java.lang.Deprecated
    public com.google.gson.JsonElement parse(com.google.gson.stream.JsonReader jsonReader) throws com.google.gson.JsonIOException, com.google.gson.JsonSyntaxException {
        return parseReader(jsonReader);
    }

    @java.lang.Deprecated
    public com.google.gson.JsonElement parse(java.io.Reader reader) throws com.google.gson.JsonIOException, com.google.gson.JsonSyntaxException {
        return parseReader(reader);
    }

    @java.lang.Deprecated
    public com.google.gson.JsonElement parse(java.lang.String str) throws com.google.gson.JsonSyntaxException {
        return parseString(str);
    }
}
