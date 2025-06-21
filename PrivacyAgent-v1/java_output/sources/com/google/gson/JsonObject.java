package com.google.gson;

/* loaded from: classes22.dex */
public final class JsonObject extends com.google.gson.JsonElement {
    private final com.google.gson.internal.LinkedTreeMap<java.lang.String, com.google.gson.JsonElement> members = new com.google.gson.internal.LinkedTreeMap<>();

    public void add(java.lang.String str, com.google.gson.JsonElement jsonElement) {
        com.google.gson.internal.LinkedTreeMap<java.lang.String, com.google.gson.JsonElement> linkedTreeMap = this.members;
        if (jsonElement == null) {
            jsonElement = com.google.gson.JsonNull.INSTANCE;
        }
        linkedTreeMap.put(str, jsonElement);
    }

    public void addProperty(java.lang.String str, java.lang.Boolean bool) {
        add(str, bool == null ? com.google.gson.JsonNull.INSTANCE : new com.google.gson.JsonPrimitive(bool));
    }

    public void addProperty(java.lang.String str, java.lang.Character ch) {
        add(str, ch == null ? com.google.gson.JsonNull.INSTANCE : new com.google.gson.JsonPrimitive(ch));
    }

    public void addProperty(java.lang.String str, java.lang.Number number) {
        add(str, number == null ? com.google.gson.JsonNull.INSTANCE : new com.google.gson.JsonPrimitive(number));
    }

    public void addProperty(java.lang.String str, java.lang.String str2) {
        add(str, str2 == null ? com.google.gson.JsonNull.INSTANCE : new com.google.gson.JsonPrimitive(str2));
    }

    @Override // com.google.gson.JsonElement
    public com.google.gson.JsonObject deepCopy() {
        com.google.gson.JsonObject jsonObject = new com.google.gson.JsonObject();
        for (java.util.Map.Entry<java.lang.String, com.google.gson.JsonElement> entry : this.members.entrySet()) {
            jsonObject.add(entry.getKey(), entry.getValue().deepCopy());
        }
        return jsonObject;
    }

    public java.util.Set<java.util.Map.Entry<java.lang.String, com.google.gson.JsonElement>> entrySet() {
        return this.members.entrySet();
    }

    public boolean equals(java.lang.Object obj) {
        return obj == this || ((obj instanceof com.google.gson.JsonObject) && ((com.google.gson.JsonObject) obj).members.equals(this.members));
    }

    public com.google.gson.JsonElement get(java.lang.String str) {
        return this.members.get(str);
    }

    public com.google.gson.JsonArray getAsJsonArray(java.lang.String str) {
        return (com.google.gson.JsonArray) this.members.get(str);
    }

    public com.google.gson.JsonObject getAsJsonObject(java.lang.String str) {
        return (com.google.gson.JsonObject) this.members.get(str);
    }

    public com.google.gson.JsonPrimitive getAsJsonPrimitive(java.lang.String str) {
        return (com.google.gson.JsonPrimitive) this.members.get(str);
    }

    public boolean has(java.lang.String str) {
        return this.members.containsKey(str);
    }

    public int hashCode() {
        return this.members.hashCode();
    }

    public java.util.Set<java.lang.String> keySet() {
        return this.members.keySet();
    }

    public com.google.gson.JsonElement remove(java.lang.String str) {
        return this.members.remove(str);
    }

    public int size() {
        return this.members.size();
    }
}
