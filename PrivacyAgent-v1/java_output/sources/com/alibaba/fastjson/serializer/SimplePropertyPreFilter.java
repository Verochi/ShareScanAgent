package com.alibaba.fastjson.serializer;

/* loaded from: classes.dex */
public class SimplePropertyPreFilter implements com.alibaba.fastjson.serializer.PropertyPreFilter {
    private final java.lang.Class<?> clazz;
    private final java.util.Set<java.lang.String> excludes;
    private final java.util.Set<java.lang.String> includes;
    private int maxLevel;

    public SimplePropertyPreFilter(java.lang.Class<?> cls, java.lang.String... strArr) {
        this.includes = new java.util.HashSet();
        this.excludes = new java.util.HashSet();
        this.maxLevel = 0;
        this.clazz = cls;
        for (java.lang.String str : strArr) {
            if (str != null) {
                this.includes.add(str);
            }
        }
    }

    public SimplePropertyPreFilter(java.lang.String... strArr) {
        this(null, strArr);
    }

    @Override // com.alibaba.fastjson.serializer.PropertyPreFilter
    public boolean apply(com.alibaba.fastjson.serializer.JSONSerializer jSONSerializer, java.lang.Object obj, java.lang.String str) {
        if (obj == null) {
            return true;
        }
        java.lang.Class<?> cls = this.clazz;
        if (cls != null && !cls.isInstance(obj)) {
            return true;
        }
        if (this.excludes.contains(str)) {
            return false;
        }
        if (this.maxLevel > 0) {
            int i = 0;
            for (com.alibaba.fastjson.serializer.SerialContext serialContext = jSONSerializer.context; serialContext != null; serialContext = serialContext.parent) {
                i++;
                if (i > this.maxLevel) {
                    return false;
                }
            }
        }
        return this.includes.size() == 0 || this.includes.contains(str);
    }

    public java.lang.Class<?> getClazz() {
        return this.clazz;
    }

    public java.util.Set<java.lang.String> getExcludes() {
        return this.excludes;
    }

    public java.util.Set<java.lang.String> getIncludes() {
        return this.includes;
    }

    public int getMaxLevel() {
        return this.maxLevel;
    }

    public void setMaxLevel(int i) {
        this.maxLevel = i;
    }
}
