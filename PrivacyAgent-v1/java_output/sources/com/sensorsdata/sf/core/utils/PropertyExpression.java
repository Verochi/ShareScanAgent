package com.sensorsdata.sf.core.utils;

/* loaded from: classes19.dex */
public class PropertyExpression {
    private static final java.lang.String ABSOLUTE1_BETWEEN = "absoluteBetween";
    private static final java.lang.String ABSOLUTE_BETWEEN = "absolute_between";
    public static final java.lang.String AND = "AND";
    private static final java.lang.String BETWEEN = "between";
    private static final java.lang.String CONTAIN = "contain";
    private static final java.lang.String EQUAL = "equal";
    private static final java.lang.String GREATER = "greater";
    private static final java.lang.String INCLUDE = "in";
    private static final java.lang.String IS_EMPTY = "isEmpty";
    private static final java.lang.String IS_FALSE = "isFalse";
    private static final java.lang.String IS_NOT_EMPTY = "isNotEmpty";
    private static final java.lang.String IS_SET = "isSet";
    private static final java.lang.String IS_TRUE = "isTrue";
    private static final java.lang.String LESS = "less";
    private static final java.lang.String NOT_CONTAIN = "notContain";
    private static final java.lang.String NOT_EQUAL = "notEqual";
    private static final java.lang.String NOT_INCLUDE = "notInclude";
    private static final java.lang.String NOT_SET = "notSet";
    public static final java.lang.String OR = "OR";

    private static long getConvertLongValue(java.lang.Number number) {
        return (long) (number.floatValue() * 1000.0f);
    }

    public static boolean isMatchProperty(java.lang.String str, java.lang.Object obj, java.util.List<java.lang.Object> list) {
        try {
        } catch (java.lang.Exception e) {
            com.sensorsdata.sf.core.utils.SFLog.printStackTrace(e);
        }
        if (obj == null) {
            return android.text.TextUtils.equals(str, NOT_SET);
        }
        if (android.text.TextUtils.equals(str, EQUAL)) {
            boolean z = obj instanceof java.lang.String;
            boolean z2 = obj instanceof java.lang.Number;
            for (java.lang.Object obj2 : list) {
                if (z) {
                    if (obj2 instanceof java.lang.CharSequence) {
                        if (android.text.TextUtils.equals((java.lang.String) obj2, (java.lang.String) obj)) {
                            return true;
                        }
                    } else if ((obj2 instanceof java.lang.Number) && android.text.TextUtils.equals(obj2.toString(), (java.lang.String) obj)) {
                        return true;
                    }
                } else if (!z2) {
                    continue;
                } else if (obj2 instanceof java.lang.Number) {
                    if (getConvertLongValue((java.lang.Number) obj2) == getConvertLongValue((java.lang.Number) obj)) {
                        return true;
                    }
                } else if ((obj2 instanceof java.lang.String) && ((long) (java.lang.Float.parseFloat((java.lang.String) obj2) * 1000.0f)) == getConvertLongValue((java.lang.Number) obj)) {
                    return true;
                }
            }
        } else {
            if (android.text.TextUtils.equals(str, NOT_EQUAL)) {
                boolean z3 = obj instanceof java.lang.String;
                boolean z4 = obj instanceof java.lang.Number;
                for (java.lang.Object obj3 : list) {
                    if (z3) {
                        if (obj3 instanceof java.lang.CharSequence) {
                            if (android.text.TextUtils.equals((java.lang.String) obj3, (java.lang.String) obj)) {
                                return false;
                            }
                        } else if ((obj3 instanceof java.lang.Number) && android.text.TextUtils.equals(obj3.toString(), (java.lang.String) obj)) {
                            return false;
                        }
                    } else if (!z4) {
                        continue;
                    } else if (obj3 instanceof java.lang.Number) {
                        if (getConvertLongValue((java.lang.Number) obj3) == getConvertLongValue((java.lang.Number) obj)) {
                            return false;
                        }
                    } else if ((obj3 instanceof java.lang.String) && ((long) (java.lang.Float.parseFloat((java.lang.String) obj3) * 1000.0f)) == getConvertLongValue((java.lang.Number) obj)) {
                        return false;
                    }
                }
                return true;
            }
            if (android.text.TextUtils.equals(str, IS_TRUE)) {
                if (obj instanceof java.lang.Boolean) {
                    return ((java.lang.Boolean) obj).booleanValue();
                }
            } else if (!android.text.TextUtils.equals(str, IS_FALSE)) {
                if (android.text.TextUtils.equals(str, IS_SET)) {
                    return true;
                }
                if (android.text.TextUtils.equals(str, NOT_SET)) {
                    return false;
                }
                if (android.text.TextUtils.equals(str, IS_EMPTY)) {
                    if (obj instanceof java.lang.String) {
                        if (android.text.TextUtils.isEmpty((java.lang.String) obj)) {
                            return true;
                        }
                    } else if (obj instanceof org.json.JSONArray) {
                        org.json.JSONArray jSONArray = (org.json.JSONArray) obj;
                        for (int i = 0; i < jSONArray.length(); i++) {
                            if (!android.text.TextUtils.isEmpty(jSONArray.optString(i))) {
                                return false;
                            }
                        }
                        return true;
                    }
                } else if (android.text.TextUtils.equals(str, IS_NOT_EMPTY)) {
                    if (obj instanceof java.lang.String) {
                        return !android.text.TextUtils.isEmpty((java.lang.String) obj);
                    }
                    if (obj instanceof org.json.JSONArray) {
                        org.json.JSONArray jSONArray2 = (org.json.JSONArray) obj;
                        for (int i2 = 0; i2 < jSONArray2.length(); i2++) {
                            java.lang.String optString = jSONArray2.optString(i2);
                            if (optString != null && !android.text.TextUtils.isEmpty(optString.trim())) {
                                return true;
                            }
                        }
                    }
                } else if (android.text.TextUtils.equals(str, INCLUDE)) {
                    if (obj instanceof org.json.JSONArray) {
                        org.json.JSONArray jSONArray3 = (org.json.JSONArray) obj;
                        java.lang.CharSequence charSequence = (java.lang.CharSequence) list.get(0);
                        for (int i3 = 0; i3 < jSONArray3.length(); i3++) {
                            if (android.text.TextUtils.equals((java.lang.CharSequence) jSONArray3.get(i3), charSequence)) {
                                return true;
                            }
                        }
                    }
                } else if (!android.text.TextUtils.equals(str, NOT_INCLUDE)) {
                    if (android.text.TextUtils.equals(str, LESS)) {
                        return (obj instanceof java.lang.Number) && getConvertLongValue((java.lang.Number) obj) < getConvertLongValue(java.lang.Float.valueOf(java.lang.Float.parseFloat((java.lang.String) list.get(0))));
                    }
                    if (android.text.TextUtils.equals(str, GREATER)) {
                        return (obj instanceof java.lang.Number) && getConvertLongValue((java.lang.Number) obj) > getConvertLongValue(java.lang.Float.valueOf(java.lang.Float.parseFloat((java.lang.String) list.get(0))));
                    }
                    if (android.text.TextUtils.equals(str, BETWEEN)) {
                        if (obj instanceof java.lang.Number) {
                            long convertLongValue = getConvertLongValue((java.lang.Number) obj);
                            return convertLongValue >= getConvertLongValue(java.lang.Float.valueOf(java.lang.Float.parseFloat((java.lang.String) list.get(0)))) && convertLongValue <= getConvertLongValue(java.lang.Float.valueOf(java.lang.Float.parseFloat((java.lang.String) list.get(1))));
                        }
                    } else if (android.text.TextUtils.equals(str, CONTAIN)) {
                        if (obj instanceof java.lang.String) {
                            java.lang.String str2 = (java.lang.String) obj;
                            for (int i4 = 0; i4 < list.size(); i4++) {
                                if (str2.contains((java.lang.CharSequence) list.get(i4))) {
                                    return true;
                                }
                            }
                        }
                    } else if (android.text.TextUtils.equals(str, NOT_CONTAIN)) {
                        if (obj instanceof java.lang.String) {
                            java.lang.String str3 = (java.lang.String) obj;
                            for (int i5 = 0; i5 < list.size(); i5++) {
                                if (str3.contains((java.lang.String) list.get(i5))) {
                                    return false;
                                }
                            }
                            return true;
                        }
                    } else if ((android.text.TextUtils.equals(str, ABSOLUTE_BETWEEN) || android.text.TextUtils.equals(str, ABSOLUTE1_BETWEEN)) && (obj instanceof java.lang.String)) {
                        return ((java.lang.String) list.get(0)).compareTo((java.lang.String) obj) <= 0 && ((java.lang.String) list.get(1)).compareTo((java.lang.String) obj) >= 0;
                    }
                } else if (obj instanceof org.json.JSONArray) {
                    org.json.JSONArray jSONArray4 = (org.json.JSONArray) obj;
                    java.lang.CharSequence charSequence2 = (java.lang.CharSequence) list.get(0);
                    for (int i6 = 0; i6 < jSONArray4.length(); i6++) {
                        if (android.text.TextUtils.equals((java.lang.CharSequence) jSONArray4.get(i6), charSequence2)) {
                            return false;
                        }
                    }
                    return true;
                }
            } else if (obj instanceof java.lang.Boolean) {
                return !((java.lang.Boolean) obj).booleanValue();
            }
        }
        return false;
    }
}
