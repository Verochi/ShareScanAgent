package com.bumptech.glide.load.engine.bitmap_recycle;

/* loaded from: classes.dex */
class PrettyPrintTreeMap<K, V> extends java.util.TreeMap<K, V> {
    @Override // java.util.AbstractMap
    public java.lang.String toString() {
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        sb.append("( ");
        for (java.util.Map.Entry<K, V> entry : entrySet()) {
            sb.append('{');
            sb.append(entry.getKey());
            sb.append(':');
            sb.append(entry.getValue());
            sb.append("}, ");
        }
        if (!isEmpty()) {
            sb.replace(sb.length() - 2, sb.length(), "");
        }
        sb.append(" )");
        return sb.toString();
    }
}
