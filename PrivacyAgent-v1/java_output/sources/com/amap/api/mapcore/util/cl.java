package com.amap.api.mapcore.util;

/* loaded from: classes12.dex */
public enum cl {
    STYLE_ELEMENT_LABELFILL_OLD("labels.text.fill", 0),
    STYLE_ELEMENT_LABELSTROKE_OLD("labels.text.stroke", 1),
    STYLE_ELEMENT_GEOMETRYSTROKE_OLD("geometry.stroke", 2),
    STYLE_ELEMENT_GEOMETRYFILL_OLD("geometry.fill", 3),
    STYLE_ELEMENT_LABELFILL("textFillColor", 0),
    STYLE_ELEMENT_LABELSTROKE("textStrokeColor", 1),
    STYLE_ELEMENT_GEOMETRYSTROKE("strokeColor", 2),
    STYLE_ELEMENT_GEOMETRYFILL("fillColor", 3),
    STYLE_ELEMENT_GEOMETRYFILL1("color", 3),
    STYLE_ELEMENT_GEOMETRYFILL2("textureName", 3),
    STYLE_ELEMENT_BACKGROUNDFILL(com.sensorsdata.sf.ui.view.UIProperty.backgroundColor, 4),
    STYLE_ELEMENT_VISIBLE("visible", 5);

    private java.lang.String m;
    private int n;

    cl(java.lang.String str, int i) {
        this.m = str;
        this.n = i;
    }

    public static int a(java.lang.String str) {
        for (com.amap.api.mapcore.util.cl clVar : values()) {
            if (clVar.a().equals(str)) {
                return clVar.n;
            }
        }
        return -1;
    }

    private java.lang.String a() {
        return this.m;
    }
}
