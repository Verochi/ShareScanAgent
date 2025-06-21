package com.alibaba.fastjson.annotation;

@java.lang.annotation.Target({java.lang.annotation.ElementType.TYPE})
@java.lang.annotation.Retention(java.lang.annotation.RetentionPolicy.RUNTIME)
/* loaded from: classes.dex */
public @interface JSONType {
    boolean alphabetic() default true;

    boolean asm() default true;

    java.lang.String[] ignores() default {};

    java.lang.Class<?> mappingTo() default java.lang.Void.class;

    com.alibaba.fastjson.PropertyNamingStrategy naming() default com.alibaba.fastjson.PropertyNamingStrategy.CamelCase;

    java.lang.String[] orders() default {};

    com.alibaba.fastjson.parser.Feature[] parseFeatures() default {};

    java.lang.Class<?>[] seeAlso() default {};

    com.alibaba.fastjson.serializer.SerializerFeature[] serialzeFeatures() default {};

    java.lang.String typeKey() default "";

    java.lang.String typeName() default "";
}
