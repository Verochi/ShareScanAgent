package cn.shuzilm.core;

/* loaded from: classes.dex */
public class t {
    public static byte[] b(java.io.InputStream inputStream) {
        java.io.ByteArrayOutputStream byteArrayOutputStream;
        try {
            byteArrayOutputStream = new java.io.ByteArrayOutputStream();
        } catch (java.lang.Throwable unused) {
            byteArrayOutputStream = null;
        }
        try {
            byte[] bArr = new byte[1024];
            while (true) {
                int read = inputStream.read(bArr, 0, 1024);
                if (read == -1) {
                    break;
                }
                byteArrayOutputStream.write(bArr, 0, read);
            }
            byte[] byteArray = byteArrayOutputStream.toByteArray();
            try {
                byteArrayOutputStream.close();
            } catch (java.lang.Throwable unused2) {
            }
            return byteArray;
        } catch (java.lang.Throwable unused3) {
            if (byteArrayOutputStream != null) {
                try {
                    byteArrayOutputStream.close();
                } catch (java.lang.Throwable unused4) {
                }
            }
            return null;
        }
    }

    public static boolean i(android.content.Context context) {
        android.net.Network activeNetwork;
        try {
            android.net.ConnectivityManager connectivityManager = (android.net.ConnectivityManager) context.getSystemService("connectivity");
            android.net.NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
            if (activeNetworkInfo != null) {
                int type = activeNetworkInfo.getType();
                if (type == 1) {
                    return true;
                }
                if (type == 0) {
                    return false;
                }
            }
            if (android.os.Build.VERSION.SDK_INT >= 23) {
                activeNetwork = connectivityManager.getActiveNetwork();
                if (connectivityManager.getNetworkCapabilities(activeNetwork).hasTransport(1)) {
                    return true;
                }
            }
        } catch (java.lang.Throwable unused) {
        }
        return false;
    }

    public static int p(android.content.Context context) {
        try {
            android.net.DhcpInfo dhcpInfo = ((android.net.wifi.WifiManager) context.getSystemService(com.efs.sdk.base.core.util.NetworkUtil.NETWORK_TYPE_WIFI)).getDhcpInfo();
            if (dhcpInfo != null) {
                return dhcpInfo.ipAddress;
            }
        } catch (java.lang.Exception unused) {
        }
        return 0;
    }

    public static boolean p(android.content.Context context, java.lang.String str) {
        return (context == null || str == null || context.getPackageManager().checkPermission(str, context.getPackageName()) != 0) ? false : true;
    }
}
