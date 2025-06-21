package com.jd.ad.sdk.jad_uh;

/* loaded from: classes23.dex */
public class jad_cp {
    public static android.content.ContentResolver jad_an() {
        try {
            return com.jd.ad.sdk.jad_fq.jad_cp.jad_an().getContentResolver();
        } catch (java.lang.Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static java.lang.Object jad_an(com.jd.ad.sdk.jad_uh.jad_dq jad_dqVar, java.lang.String str, java.lang.Class<?> cls) {
        try {
            if (!com.jd.ad.sdk.jad_qd.jad_jw.jad_dq(com.jd.ad.sdk.jad_fq.jad_cp.jad_an())) {
                return jad_an(str, cls);
            }
            if (jad_dqVar == null || android.text.TextUtils.isEmpty(str) || cls == null) {
                return null;
            }
            if (cls == java.lang.Integer.TYPE) {
                return java.lang.Integer.valueOf(jad_dqVar.jad_an.getInt(str, -1));
            }
            if (cls == java.lang.Long.TYPE) {
                return java.lang.Long.valueOf(jad_dqVar.jad_an.getLong(str, -1L));
            }
            if (cls == java.lang.Float.TYPE) {
                return java.lang.Float.valueOf(jad_dqVar.jad_an.getFloat(str, -1.0f));
            }
            if (cls == java.lang.Boolean.TYPE) {
                return java.lang.Boolean.valueOf(jad_dqVar.jad_an.getBoolean(str, false));
            }
            if (cls != java.util.Set.class) {
                return jad_dqVar.jad_an.getString(str, "");
            }
            return jad_dqVar.jad_an.getStringSet(str, java.util.Collections.emptySet());
        } catch (java.lang.Exception e) {
            java.lang.StringBuilder jad_an = com.jd.ad.sdk.jad_bo.jad_bo.jad_an("Exception while sp get: ");
            jad_an.append(e.getMessage());
            com.jd.ad.sdk.logger.Logger.w(jad_an.toString(), new java.lang.Object[0]);
            return null;
        }
    }

    public static java.lang.Object jad_an(java.lang.String str, java.lang.Class<?> cls) {
        try {
            java.lang.StringBuilder sb = new java.lang.StringBuilder();
            sb.append(com.jd.ad.sdk.jad_tg.jad_an.jad_bo());
            sb.append("sp_jadyunsdk");
            sb.append(net.lingala.zip4j.util.InternalZipConstants.ZIP_FILE_SEPARATOR);
            sb.append(com.ss.android.socialbase.downloader.constants.MonitorConstants.CONNECT_TYPE_GET);
            sb.append(net.lingala.zip4j.util.InternalZipConstants.ZIP_FILE_SEPARATOR);
            java.lang.Class<?> cls2 = java.lang.Integer.TYPE;
            sb.append(cls == cls2 ? com.baidu.mobads.sdk.api.IAdInterListener.AdProdType.PRODUCT_INTERSTITIAL : cls == java.lang.Long.TYPE ? "long" : cls == java.lang.Float.TYPE ? "float" : cls == java.lang.Boolean.TYPE ? "boolean" : cls == java.util.Set.class ? "string_set" : com.anythink.expressad.foundation.h.i.g);
            sb.append(net.lingala.zip4j.util.InternalZipConstants.ZIP_FILE_SEPARATOR);
            sb.append(str);
            android.net.Uri parse = android.net.Uri.parse(sb.toString());
            android.content.ContentResolver jad_an = jad_an();
            if (jad_an == null) {
                return null;
            }
            java.lang.String type = jad_an.getType(parse);
            if (cls == cls2) {
                if (type != null && !type.equals(com.igexin.push.core.b.m)) {
                    return java.lang.Integer.valueOf(java.lang.Integer.parseInt(type));
                }
                return -1;
            }
            if (cls == java.lang.Long.TYPE) {
                if (type != null && !type.equals(com.igexin.push.core.b.m)) {
                    return java.lang.Long.valueOf(java.lang.Long.parseLong(type));
                }
                return -1L;
            }
            if (cls == java.lang.Float.TYPE) {
                if (type != null && !type.equals(com.igexin.push.core.b.m)) {
                    return java.lang.Float.valueOf(java.lang.Float.parseFloat(str));
                }
                return java.lang.Float.valueOf(-1.0f);
            }
            if (cls == java.lang.Boolean.TYPE) {
                if (type != null && !type.equals(com.igexin.push.core.b.m)) {
                    return java.lang.Boolean.valueOf(java.lang.Boolean.parseBoolean(type));
                }
                return java.lang.Boolean.FALSE;
            }
            if (cls != java.util.Set.class) {
                return (type == null || type.equals(com.igexin.push.core.b.m)) ? "" : type;
            }
            if (type == null || type.equals(com.igexin.push.core.b.m) || !type.matches("\\[.*\\]")) {
                return "";
            }
            java.lang.String[] split = type.substring(1, type.length() - 1).split(", ");
            java.util.HashSet hashSet = new java.util.HashSet();
            for (java.lang.String str2 : split) {
                hashSet.add(str2.replace("__COMMA__", ", "));
            }
            return hashSet;
        } catch (java.lang.Exception e) {
            com.jd.ad.sdk.jad_wj.jad_an jad_anVar = com.jd.ad.sdk.jad_wj.jad_an.MULTIPLE_PROCESS_SP_GET_ERROR;
            com.jd.ad.sdk.jad_xk.jad_fs.jad_an("", jad_anVar.jad_an, jad_anVar.jad_an(e.getMessage()));
            return null;
        }
    }

    public static void jad_an(java.lang.String str, java.lang.Object obj) {
        try {
            android.content.ContentResolver jad_an = jad_an();
            if (jad_an == null) {
                return;
            }
            android.net.Uri parse = android.net.Uri.parse(com.jd.ad.sdk.jad_tg.jad_an.jad_bo() + "sp_jadyunsdk" + net.lingala.zip4j.util.InternalZipConstants.ZIP_FILE_SEPARATOR + "update");
            android.content.ContentValues contentValues = new android.content.ContentValues();
            contentValues.put("key", str);
            if (obj instanceof java.lang.String) {
                contentValues.put("type_object", com.anythink.expressad.foundation.h.i.g);
                contentValues.put("value", (java.lang.String) obj);
            } else if (obj instanceof java.lang.Long) {
                contentValues.put("type_object", "long");
                contentValues.put("value", (java.lang.Long) obj);
            } else if (obj instanceof java.lang.Float) {
                contentValues.put("type_object", "float");
                contentValues.put("value", (java.lang.Float) obj);
            } else if (obj instanceof java.lang.Integer) {
                contentValues.put("type_object", com.baidu.mobads.sdk.api.IAdInterListener.AdProdType.PRODUCT_INTERSTITIAL);
                contentValues.put("value", (java.lang.Integer) obj);
            } else if (obj instanceof java.lang.Boolean) {
                contentValues.put("type_object", "boolean");
                contentValues.put("value", (java.lang.Boolean) obj);
            } else if (obj instanceof java.util.Set) {
                java.util.HashSet hashSet = new java.util.HashSet();
                java.util.Iterator it = ((java.util.Set) obj).iterator();
                while (it.hasNext()) {
                    hashSet.add(((java.lang.String) it.next()).replace(",", "__COMMA__"));
                }
                contentValues.put("type_object", "string_set");
                contentValues.put("value", hashSet.toString());
            }
            jad_an.update(parse, contentValues, null, null);
        } catch (java.lang.Exception e) {
            com.jd.ad.sdk.jad_wj.jad_an jad_anVar = com.jd.ad.sdk.jad_wj.jad_an.MULTIPLE_PROCESS_SP_UPDATE_ERROR;
            com.jd.ad.sdk.jad_xk.jad_fs.jad_an("", jad_anVar.jad_an, jad_anVar.jad_an(e.getMessage()));
        }
    }

    public static boolean jad_an(com.jd.ad.sdk.jad_uh.jad_dq jad_dqVar, java.lang.String str, java.lang.Object obj) {
        boolean jad_dq;
        try {
            jad_dq = com.jd.ad.sdk.jad_qd.jad_jw.jad_dq(com.jd.ad.sdk.jad_fq.jad_cp.jad_an());
        } catch (java.lang.Exception e) {
            java.lang.StringBuilder jad_an = com.jd.ad.sdk.jad_bo.jad_bo.jad_an("Exception while sp put: ");
            jad_an.append(e.getMessage());
            com.jd.ad.sdk.logger.Logger.w(jad_an.toString(), new java.lang.Object[0]);
        }
        if ((jad_dq && jad_dqVar == null) || android.text.TextUtils.isEmpty(str) || obj == null) {
            return false;
        }
        if (!jad_dq) {
            jad_an(str, obj);
            return true;
        }
        if (obj instanceof java.lang.String) {
            jad_dqVar.jad_an.edit().putString(str, (java.lang.String) obj).apply();
            return true;
        }
        if (obj instanceof java.lang.Long) {
            jad_dqVar.jad_an.edit().putLong(str, ((java.lang.Long) obj).longValue()).apply();
            return true;
        }
        if (obj instanceof java.lang.Float) {
            jad_dqVar.jad_an.edit().putFloat(str, ((java.lang.Float) obj).floatValue()).apply();
            return true;
        }
        if (obj instanceof java.lang.Integer) {
            jad_dqVar.jad_an.edit().putInt(str, ((java.lang.Integer) obj).intValue()).apply();
            return true;
        }
        if (obj instanceof java.lang.Boolean) {
            jad_dqVar.jad_an.edit().putBoolean(str, ((java.lang.Boolean) obj).booleanValue()).apply();
            return true;
        }
        if (obj instanceof java.util.Set) {
            jad_dqVar.jad_an.edit().putStringSet(str, (java.util.Set) obj).apply();
            return true;
        }
        return false;
    }

    public static boolean jad_an(java.lang.String str) {
        try {
            android.net.Uri parse = android.net.Uri.parse(com.jd.ad.sdk.jad_tg.jad_an.jad_bo() + "sp_jadyunsdk" + net.lingala.zip4j.util.InternalZipConstants.ZIP_FILE_SEPARATOR + "contain" + net.lingala.zip4j.util.InternalZipConstants.ZIP_FILE_SEPARATOR + str);
            android.content.ContentResolver jad_an = jad_an();
            if (jad_an == null) {
                return false;
            }
            java.lang.String type = jad_an.getType(parse);
            if (android.text.TextUtils.isEmpty(type)) {
                return false;
            }
            return java.lang.Boolean.parseBoolean(type);
        } catch (java.lang.Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
