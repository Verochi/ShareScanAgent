package com.sensorsdata.analytics.android.sdk.util;

/* loaded from: classes19.dex */
public class SADataHelper {
    private static final java.util.regex.Pattern KEY_PATTERN = java.util.regex.Pattern.compile("^((?!^distinct_id$|^original_id$|^time$|^properties$|^id$|^first_id$|^second_id$|^users$|^events$|^event$|^user_id$|^date$|^datetime$|^user_tag.*|^user_group.*)[a-zA-Z_$][a-zA-Z\\d_$]*)$", 2);
    private static final int MAX_LENGTH_100 = 100;
    public static final int MAX_LENGTH_1024 = 1024;
    private static final java.lang.String TAG = "SA.SADataHelper";

    public static void addTimeProperty(org.json.JSONObject jSONObject) {
        if (jSONObject.has("$time")) {
            return;
        }
        try {
            jSONObject.put("$time", new java.util.Date(java.lang.System.currentTimeMillis()));
        } catch (org.json.JSONException e) {
            com.sensorsdata.analytics.android.sdk.SALog.printStackTrace(e);
        }
    }

    public static org.json.JSONObject appendLibMethodAutoTrack(org.json.JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new org.json.JSONObject();
        }
        try {
            jSONObject.put("$lib_method", "autoTrack");
        } catch (org.json.JSONException e) {
            com.sensorsdata.analytics.android.sdk.SALog.printStackTrace(e);
        }
        return jSONObject;
    }

    public static void assertDistinctId(java.lang.String str) throws com.sensorsdata.analytics.android.sdk.exceptions.InvalidDataException {
        if (android.text.TextUtils.isEmpty(str)) {
            throw new com.sensorsdata.analytics.android.sdk.exceptions.InvalidDataException("Id is empty or null");
        }
        if (str.length() > 1024) {
            com.sensorsdata.analytics.android.sdk.SALog.i(TAG, str + "'s length is longer than 1024");
        }
    }

    public static void assertEventName(java.lang.String str) {
        if (android.text.TextUtils.isEmpty(str)) {
            com.sensorsdata.analytics.android.sdk.SALog.i(TAG, "EventName is empty or null");
            return;
        }
        if (str.length() > 100) {
            com.sensorsdata.analytics.android.sdk.SALog.i(TAG, str + "'s length is longer than 100");
            return;
        }
        if (KEY_PATTERN.matcher(str).matches()) {
            return;
        }
        com.sensorsdata.analytics.android.sdk.SALog.i(TAG, str + " is invalid");
    }

    public static void assertItemId(java.lang.String str) {
        if (str == null) {
            com.sensorsdata.analytics.android.sdk.SALog.i(TAG, "ItemId is empty or null");
            return;
        }
        if (str.length() > 1024) {
            com.sensorsdata.analytics.android.sdk.SALog.i(TAG, str + "'s length is longer than 1024");
        }
    }

    public static boolean assertPropertyKey(java.lang.String str) {
        if (android.text.TextUtils.isEmpty(str)) {
            com.sensorsdata.analytics.android.sdk.SALog.i(TAG, "Property key is empty or null");
            return false;
        }
        if (!KEY_PATTERN.matcher(str).matches()) {
            com.sensorsdata.analytics.android.sdk.SALog.i(TAG, str + " is invalid");
            return false;
        }
        if (str.length() <= 100) {
            return true;
        }
        com.sensorsdata.analytics.android.sdk.SALog.i(TAG, str + "'s length is longer than 100");
        return true;
    }

    public static void assertPropertyTypes(org.json.JSONObject jSONObject) throws com.sensorsdata.analytics.android.sdk.exceptions.InvalidDataException {
        if (jSONObject == null) {
            return;
        }
        java.util.Iterator<java.lang.String> keys = jSONObject.keys();
        while (keys.hasNext()) {
            java.lang.String next = keys.next();
            try {
                if (assertPropertyKey(next)) {
                    java.lang.Object obj = jSONObject.get(next);
                    if (obj == org.json.JSONObject.NULL) {
                        com.sensorsdata.analytics.android.sdk.SALog.i(TAG, "Property value is empty or null");
                        keys.remove();
                    } else {
                        int i = 0;
                        if (obj instanceof java.util.List) {
                            java.util.List list = (java.util.List) obj;
                            int size = list.size();
                            org.json.JSONArray jSONArray = new org.json.JSONArray();
                            while (i < size) {
                                jSONArray.put(formatString(list.get(i)));
                                i++;
                            }
                            jSONObject.put(next, jSONArray);
                        } else if (!(obj instanceof java.lang.CharSequence) && !(obj instanceof java.lang.Number) && !(obj instanceof org.json.JSONArray) && !(obj instanceof java.lang.Boolean) && !(obj instanceof java.util.Date)) {
                            com.sensorsdata.analytics.android.sdk.SALog.i(TAG, "The property value must be an instance of CharSequence/Number/Boolean/JSONArray/Date/List<String>. [key='" + next + "', value='" + obj.toString() + "', class='" + obj.getClass().getCanonicalName() + "']");
                            keys.remove();
                        } else if (obj instanceof org.json.JSONArray) {
                            org.json.JSONArray jSONArray2 = (org.json.JSONArray) obj;
                            while (i < jSONArray2.length()) {
                                jSONArray2.put(i, formatString(jSONArray2.opt(i)));
                                i++;
                            }
                        } else if ("app_crashed_reason".equals(next) && (obj instanceof java.lang.String) && ((java.lang.String) obj).length() > 16382) {
                            com.sensorsdata.analytics.android.sdk.SALog.d(TAG, "The property value is too long. [key='" + next + "', value='" + obj + "']");
                            java.lang.StringBuilder sb = new java.lang.StringBuilder();
                            sb.append(((java.lang.String) obj).substring(0, 16382));
                            sb.append("$");
                            jSONObject.put(next, sb.toString());
                        } else if ((obj instanceof java.lang.String) && ((java.lang.String) obj).length() > 8191) {
                            jSONObject.put(next, ((java.lang.String) obj).substring(0, 8191) + "$");
                            com.sensorsdata.analytics.android.sdk.SALog.d(TAG, "The property value is too long. [key='" + next + "', value='" + obj + "']");
                        }
                    }
                } else {
                    keys.remove();
                }
            } catch (java.lang.Error e) {
                com.sensorsdata.analytics.android.sdk.SALog.i(TAG, e);
            } catch (org.json.JSONException unused) {
                throw new com.sensorsdata.analytics.android.sdk.exceptions.InvalidDataException("Unexpected property key. [key='" + next + "']");
            }
        }
    }

    public static java.lang.String assertPropertyValue(java.lang.String str) {
        if (str == null) {
            com.sensorsdata.analytics.android.sdk.SALog.i(TAG, "Property value is empty or null");
            return str;
        }
        if (str.length() > 1024) {
            com.sensorsdata.analytics.android.sdk.SALog.i(TAG, str + "'s length is longer than 1024");
        }
        return str;
    }

    public static void closeStream(java.io.BufferedOutputStream bufferedOutputStream, java.io.OutputStream outputStream, java.io.InputStream inputStream, java.net.HttpURLConnection httpURLConnection) {
        if (bufferedOutputStream != null) {
            try {
                bufferedOutputStream.close();
            } catch (java.lang.Exception e) {
                com.sensorsdata.analytics.android.sdk.SALog.i(TAG, e.getMessage());
            }
        }
        if (outputStream != null) {
            try {
                outputStream.close();
            } catch (java.lang.Exception e2) {
                com.sensorsdata.analytics.android.sdk.SALog.i(TAG, e2.getMessage());
            }
        }
        if (inputStream != null) {
            try {
                inputStream.close();
            } catch (java.lang.Exception e3) {
                com.sensorsdata.analytics.android.sdk.SALog.i(TAG, e3.getMessage());
            }
        }
        if (httpURLConnection != null) {
            try {
                httpURLConnection.disconnect();
            } catch (java.lang.Exception e4) {
                com.sensorsdata.analytics.android.sdk.SALog.i(TAG, e4.getMessage());
            }
        }
    }

    public static java.lang.String formatString(java.lang.Object obj) {
        return obj == null ? "" : obj instanceof java.util.Date ? com.sensorsdata.analytics.android.sdk.util.TimeUtils.formatDate((java.util.Date) obj) : obj.toString();
    }

    public static java.lang.String gzipData(java.lang.String str) throws com.sensorsdata.analytics.android.sdk.exceptions.InvalidDataException {
        byte[] bytes;
        java.io.ByteArrayOutputStream byteArrayOutputStream;
        java.util.zip.GZIPOutputStream gZIPOutputStream;
        java.util.zip.GZIPOutputStream gZIPOutputStream2 = null;
        try {
            try {
                bytes = str.getBytes("UTF-8");
                byteArrayOutputStream = new java.io.ByteArrayOutputStream(bytes.length);
                gZIPOutputStream = new java.util.zip.GZIPOutputStream(byteArrayOutputStream);
            } catch (java.lang.Throwable th) {
                th = th;
            }
        } catch (java.io.IOException e) {
            e = e;
        }
        try {
            gZIPOutputStream.write(bytes);
            gZIPOutputStream.close();
            byte[] byteArray = byteArrayOutputStream.toByteArray();
            byteArrayOutputStream.close();
            java.lang.String str2 = new java.lang.String(com.sensorsdata.analytics.android.sdk.util.Base64Coder.encode(byteArray));
            try {
                gZIPOutputStream.close();
            } catch (java.io.IOException unused) {
            }
            return str2;
        } catch (java.io.IOException e2) {
            e = e2;
            throw new com.sensorsdata.analytics.android.sdk.exceptions.InvalidDataException(e);
        } catch (java.lang.Throwable th2) {
            th = th2;
            gZIPOutputStream2 = gZIPOutputStream;
            if (gZIPOutputStream2 != null) {
                try {
                    gZIPOutputStream2.close();
                } catch (java.io.IOException unused2) {
                }
            }
            throw th;
        }
    }

    public static byte[] slurp(java.io.InputStream inputStream) throws java.io.IOException {
        java.io.ByteArrayOutputStream byteArrayOutputStream = new java.io.ByteArrayOutputStream();
        byte[] bArr = new byte[8192];
        while (true) {
            int read = inputStream.read(bArr, 0, 8192);
            if (read == -1) {
                byteArrayOutputStream.flush();
                return byteArrayOutputStream.toByteArray();
            }
            byteArrayOutputStream.write(bArr, 0, read);
        }
    }
}
