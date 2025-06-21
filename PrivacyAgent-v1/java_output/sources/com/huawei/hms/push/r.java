package com.huawei.hms.push;

/* loaded from: classes22.dex */
public class r {
    public static int a(android.content.Context context, java.lang.String str) {
        android.os.Bundle bundle;
        try {
            android.content.pm.ApplicationInfo applicationInfo = context.getPackageManager().getApplicationInfo(context.getPackageName(), 128);
            if (applicationInfo == null || (bundle = applicationInfo.metaData) == null) {
                return 0;
            }
            return bundle.getInt(str);
        } catch (android.content.pm.PackageManager.NameNotFoundException unused) {
            com.huawei.hms.support.log.HMSLog.w("ResourceLoader", "load meta data resource failed.");
            return 0;
        }
    }

    public static int a(android.content.Context context, java.lang.String str, java.lang.String str2) {
        try {
            int identifier = context.getResources().getIdentifier(str2, str, context.getPackageName());
            if (identifier == 0) {
                java.lang.StringBuilder sb = new java.lang.StringBuilder();
                sb.append(context.getPackageName());
                sb.append(".R$");
                sb.append(str);
                java.lang.reflect.Field field = java.lang.Class.forName(sb.toString()).getField(str2);
                identifier = java.lang.Integer.parseInt(field.get(field.getName()).toString());
                if (identifier == 0) {
                    java.lang.StringBuilder sb2 = new java.lang.StringBuilder();
                    sb2.append("Error-resourceType=");
                    sb2.append(str);
                    sb2.append("--resourceName=");
                    sb2.append(str2);
                    sb2.append("--resourceId =");
                    sb2.append(identifier);
                    com.huawei.hms.support.log.HMSLog.i("ResourceLoader", sb2.toString());
                }
            }
            return identifier;
        } catch (java.lang.ClassNotFoundException e) {
            com.huawei.hms.support.log.HMSLog.e("ResourceLoader", "!!!! ResourceLoader: ClassNotFoundException-resourceType=" + str + "--resourceName=" + str2, e);
            return 0;
        } catch (java.lang.IllegalAccessException e2) {
            com.huawei.hms.support.log.HMSLog.e("ResourceLoader", "!!!! ResourceLoader: IllegalAccessException-resourceType=" + str + "--resourceName=" + str2, e2);
            return 0;
        } catch (java.lang.NoSuchFieldException e3) {
            com.huawei.hms.support.log.HMSLog.e("ResourceLoader", "!!!! ResourceLoader: NoSuchFieldException-resourceType=" + str + "--resourceName=" + str2, e3);
            return 0;
        } catch (java.lang.NumberFormatException e4) {
            com.huawei.hms.support.log.HMSLog.e("ResourceLoader", "!!!! ResourceLoader: NumberFormatException-resourceType=" + str + "--resourceName=" + str2, e4);
            return 0;
        } catch (java.lang.IllegalArgumentException e5) {
            com.huawei.hms.support.log.HMSLog.e("ResourceLoader", "!!!! ResourceLoader: IllegalArgumentException-resourceType=" + str + "--resourceName=" + str2, e5);
            return 0;
        }
    }
}
