package com.google.gson;

/* loaded from: classes22.dex */
public final class JsonArray extends com.google.gson.JsonElement implements java.lang.Iterable<com.google.gson.JsonElement> {
    private final java.util.List<com.google.gson.JsonElement> elements;

    public JsonArray() {
        this.elements = new java.util.ArrayList();
    }

    public JsonArray(int i) {
        this.elements = new java.util.ArrayList(i);
    }

    public void add(com.google.gson.JsonElement jsonElement) {
        if (jsonElement == null) {
            jsonElement = com.google.gson.JsonNull.INSTANCE;
        }
        this.elements.add(jsonElement);
    }

    public void add(java.lang.Boolean bool) {
        this.elements.add(bool == null ? com.google.gson.JsonNull.INSTANCE : new com.google.gson.JsonPrimitive(bool));
    }

    public void add(java.lang.Character ch) {
        this.elements.add(ch == null ? com.google.gson.JsonNull.INSTANCE : new com.google.gson.JsonPrimitive(ch));
    }

    public void add(java.lang.Number number) {
        this.elements.add(number == null ? com.google.gson.JsonNull.INSTANCE : new com.google.gson.JsonPrimitive(number));
    }

    public void add(java.lang.String str) {
        this.elements.add(str == null ? com.google.gson.JsonNull.INSTANCE : new com.google.gson.JsonPrimitive(str));
    }

    public void addAll(com.google.gson.JsonArray jsonArray) {
        this.elements.addAll(jsonArray.elements);
    }

    public boolean contains(com.google.gson.JsonElement jsonElement) {
        return this.elements.contains(jsonElement);
    }

    @Override // com.google.gson.JsonElement
    public com.google.gson.JsonArray deepCopy() {
        if (this.elements.isEmpty()) {
            return new com.google.gson.JsonArray();
        }
        com.google.gson.JsonArray jsonArray = new com.google.gson.JsonArray(this.elements.size());
        java.util.Iterator<com.google.gson.JsonElement> it = this.elements.iterator();
        while (it.hasNext()) {
            jsonArray.add(it.next().deepCopy());
        }
        return jsonArray;
    }

    public boolean equals(java.lang.Object obj) {
        return obj == this || ((obj instanceof com.google.gson.JsonArray) && ((com.google.gson.JsonArray) obj).elements.equals(this.elements));
    }

    public com.google.gson.JsonElement get(int i) {
        return this.elements.get(i);
    }

    @Override // com.google.gson.JsonElement
    public java.math.BigDecimal getAsBigDecimal() {
        if (this.elements.size() == 1) {
            return this.elements.get(0).getAsBigDecimal();
        }
        throw new java.lang.IllegalStateException();
    }

    @Override // com.google.gson.JsonElement
    public java.math.BigInteger getAsBigInteger() {
        if (this.elements.size() == 1) {
            return this.elements.get(0).getAsBigInteger();
        }
        throw new java.lang.IllegalStateException();
    }

    @Override // com.google.gson.JsonElement
    public boolean getAsBoolean() {
        if (this.elements.size() == 1) {
            return this.elements.get(0).getAsBoolean();
        }
        throw new java.lang.IllegalStateException();
    }

    @Override // com.google.gson.JsonElement
    public byte getAsByte() {
        if (this.elements.size() == 1) {
            return this.elements.get(0).getAsByte();
        }
        throw new java.lang.IllegalStateException();
    }

    @Override // com.google.gson.JsonElement
    public char getAsCharacter() {
        if (this.elements.size() == 1) {
            return this.elements.get(0).getAsCharacter();
        }
        throw new java.lang.IllegalStateException();
    }

    @Override // com.google.gson.JsonElement
    public double getAsDouble() {
        if (this.elements.size() == 1) {
            return this.elements.get(0).getAsDouble();
        }
        throw new java.lang.IllegalStateException();
    }

    @Override // com.google.gson.JsonElement
    public float getAsFloat() {
        if (this.elements.size() == 1) {
            return this.elements.get(0).getAsFloat();
        }
        throw new java.lang.IllegalStateException();
    }

    @Override // com.google.gson.JsonElement
    public int getAsInt() {
        if (this.elements.size() == 1) {
            return this.elements.get(0).getAsInt();
        }
        throw new java.lang.IllegalStateException();
    }

    @Override // com.google.gson.JsonElement
    public long getAsLong() {
        if (this.elements.size() == 1) {
            return this.elements.get(0).getAsLong();
        }
        throw new java.lang.IllegalStateException();
    }

    @Override // com.google.gson.JsonElement
    public java.lang.Number getAsNumber() {
        if (this.elements.size() == 1) {
            return this.elements.get(0).getAsNumber();
        }
        throw new java.lang.IllegalStateException();
    }

    @Override // com.google.gson.JsonElement
    public short getAsShort() {
        if (this.elements.size() == 1) {
            return this.elements.get(0).getAsShort();
        }
        throw new java.lang.IllegalStateException();
    }

    @Override // com.google.gson.JsonElement
    public java.lang.String getAsString() {
        if (this.elements.size() == 1) {
            return this.elements.get(0).getAsString();
        }
        throw new java.lang.IllegalStateException();
    }

    public int hashCode() {
        return this.elements.hashCode();
    }

    @Override // java.lang.Iterable
    public java.util.Iterator<com.google.gson.JsonElement> iterator() {
        return this.elements.iterator();
    }

    public com.google.gson.JsonElement remove(int i) {
        return this.elements.remove(i);
    }

    public boolean remove(com.google.gson.JsonElement jsonElement) {
        return this.elements.remove(jsonElement);
    }

    public com.google.gson.JsonElement set(int i, com.google.gson.JsonElement jsonElement) {
        return this.elements.set(i, jsonElement);
    }

    public int size() {
        return this.elements.size();
    }
}
