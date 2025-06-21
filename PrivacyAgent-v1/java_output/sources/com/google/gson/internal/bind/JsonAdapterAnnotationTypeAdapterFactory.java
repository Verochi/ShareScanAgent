package com.google.gson.internal.bind;

/* loaded from: classes22.dex */
public final class JsonAdapterAnnotationTypeAdapterFactory implements com.google.gson.TypeAdapterFactory {
    private final com.google.gson.internal.ConstructorConstructor constructorConstructor;

    public JsonAdapterAnnotationTypeAdapterFactory(com.google.gson.internal.ConstructorConstructor constructorConstructor) {
        this.constructorConstructor = constructorConstructor;
    }

    @Override // com.google.gson.TypeAdapterFactory
    public <T> com.google.gson.TypeAdapter<T> create(com.google.gson.Gson gson, com.google.gson.reflect.TypeToken<T> typeToken) {
        com.google.gson.annotations.JsonAdapter jsonAdapter = (com.google.gson.annotations.JsonAdapter) typeToken.getRawType().getAnnotation(com.google.gson.annotations.JsonAdapter.class);
        if (jsonAdapter == null) {
            return null;
        }
        return (com.google.gson.TypeAdapter<T>) getTypeAdapter(this.constructorConstructor, gson, typeToken, jsonAdapter);
    }

    public com.google.gson.TypeAdapter<?> getTypeAdapter(com.google.gson.internal.ConstructorConstructor constructorConstructor, com.google.gson.Gson gson, com.google.gson.reflect.TypeToken<?> typeToken, com.google.gson.annotations.JsonAdapter jsonAdapter) {
        com.google.gson.TypeAdapter<?> treeTypeAdapter;
        java.lang.Object construct = constructorConstructor.get(com.google.gson.reflect.TypeToken.get((java.lang.Class) jsonAdapter.value())).construct();
        if (construct instanceof com.google.gson.TypeAdapter) {
            treeTypeAdapter = (com.google.gson.TypeAdapter) construct;
        } else if (construct instanceof com.google.gson.TypeAdapterFactory) {
            treeTypeAdapter = ((com.google.gson.TypeAdapterFactory) construct).create(gson, typeToken);
        } else {
            boolean z = construct instanceof com.google.gson.JsonSerializer;
            if (!z && !(construct instanceof com.google.gson.JsonDeserializer)) {
                throw new java.lang.IllegalArgumentException("Invalid attempt to bind an instance of " + construct.getClass().getName() + " as a @JsonAdapter for " + typeToken.toString() + ". @JsonAdapter value must be a TypeAdapter, TypeAdapterFactory, JsonSerializer or JsonDeserializer.");
            }
            treeTypeAdapter = new com.google.gson.internal.bind.TreeTypeAdapter<>(z ? (com.google.gson.JsonSerializer) construct : null, construct instanceof com.google.gson.JsonDeserializer ? (com.google.gson.JsonDeserializer) construct : null, gson, typeToken, null);
        }
        return (treeTypeAdapter == null || !jsonAdapter.nullSafe()) ? treeTypeAdapter : treeTypeAdapter.nullSafe();
    }
}
