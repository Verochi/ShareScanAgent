package com.autonavi.base.ae.gmap.style;

/* loaded from: classes12.dex */
public class StyleItem {
    public int mainKey;
    private java.util.Map<java.lang.Integer, com.autonavi.base.ae.gmap.style.StyleElement> styleElements = new java.util.HashMap();
    private int styleTypeId;
    public int[] subKey;

    public StyleItem(int i) {
        this.styleTypeId = i;
    }

    public com.autonavi.base.ae.gmap.style.StyleElement get(int i) {
        return this.styleElements.get(java.lang.Integer.valueOf(i));
    }

    public com.autonavi.base.ae.gmap.style.StyleElement[] getStyleElements() {
        java.util.Map<java.lang.Integer, com.autonavi.base.ae.gmap.style.StyleElement> map = this.styleElements;
        if (map == null || map.size() <= 0) {
            return null;
        }
        return (com.autonavi.base.ae.gmap.style.StyleElement[]) this.styleElements.values().toArray(new com.autonavi.base.ae.gmap.style.StyleElement[this.styleElements.size()]);
    }

    public boolean isValid() {
        return this.styleElements.size() > 0 && this.styleTypeId >= 0;
    }

    public void put(int i, com.autonavi.base.ae.gmap.style.StyleElement styleElement) {
        this.styleElements.put(java.lang.Integer.valueOf(i), styleElement);
    }

    public java.lang.String toString() {
        return "styleTypeId:" + this.styleTypeId + "\nstyleElements.size :" + this.styleElements.size();
    }
}
