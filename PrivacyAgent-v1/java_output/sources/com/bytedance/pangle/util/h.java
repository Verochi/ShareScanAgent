package com.bytedance.pangle.util;

/* loaded from: classes.dex */
public final class h {
    public static void a(java.lang.String str, java.lang.String str2) {
        if (android.text.TextUtils.isEmpty(str) || android.text.TextUtils.isEmpty(str2)) {
            return;
        }
        java.io.File file = new java.io.File(str);
        java.io.File file2 = new java.io.File(str2);
        if (file.exists() && file.isFile() && file.canRead()) {
            if (file2.getParentFile() != null && !file2.getParentFile().exists()) {
                file2.getParentFile().mkdirs();
            }
            java.io.FileInputStream fileInputStream = new java.io.FileInputStream(str);
            java.io.FileOutputStream fileOutputStream = new java.io.FileOutputStream(str2);
            java.nio.channels.FileChannel channel = fileInputStream.getChannel();
            java.nio.channels.FileChannel channel2 = fileOutputStream.getChannel();
            channel2.write(channel.map(java.nio.channels.FileChannel.MapMode.READ_ONLY, 0L, channel.size()));
            channel.close();
            channel2.close();
            fileInputStream.close();
            fileOutputStream.close();
        }
    }

    public static void a(java.nio.channels.ReadableByteChannel readableByteChannel, java.nio.channels.WritableByteChannel writableByteChannel) {
        java.nio.ByteBuffer allocateDirect = java.nio.ByteBuffer.allocateDirect(4096);
        while (readableByteChannel.read(allocateDirect) != -1) {
            allocateDirect.flip();
            while (allocateDirect.hasRemaining()) {
                writableByteChannel.write(allocateDirect);
            }
            allocateDirect.clear();
        }
    }

    public static boolean a(java.lang.String str, java.io.File file, java.lang.StringBuilder sb) {
        try {
            java.io.FileOutputStream fileOutputStream = new java.io.FileOutputStream(file);
            java.nio.channels.FileChannel channel = fileOutputStream.getChannel();
            channel.write(java.nio.ByteBuffer.wrap(str.getBytes()));
            channel.close();
            fileOutputStream.close();
            return true;
        } catch (java.io.IOException e) {
            sb.append(e.getMessage());
            return false;
        }
    }
}
