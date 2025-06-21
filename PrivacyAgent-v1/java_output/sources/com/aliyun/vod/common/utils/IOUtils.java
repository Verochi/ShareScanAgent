package com.aliyun.vod.common.utils;

/* loaded from: classes12.dex */
public class IOUtils {
    public static final int CONTINUE_LOADING_PERCENTAGE = 75;
    public static final int DEFAULT_BUFFER_SIZE = 32768;
    public static final char DIR_SEPARATOR = java.io.File.separatorChar;
    public static final char DIR_SEPARATOR_UNIX = '/';
    public static final char DIR_SEPARATOR_WINDOWS = '\\';
    private static final int EOF = -1;
    public static final java.lang.String LINE_SEPARATOR;
    public static final java.lang.String LINE_SEPARATOR_UNIX = "\n";
    public static final java.lang.String LINE_SEPARATOR_WINDOWS = "\r\n";
    private static final int SKIP_BUFFER_SIZE = 2048;
    private static byte[] SKIP_BYTE_BUFFER;
    private static char[] SKIP_CHAR_BUFFER;

    public interface CopyListener {
        boolean onBytesCopied(int i, int i2);
    }

    static {
        com.aliyun.vod.common.stream.StringBuilderWriter stringBuilderWriter = new com.aliyun.vod.common.stream.StringBuilderWriter(4);
        java.io.PrintWriter printWriter = new java.io.PrintWriter(stringBuilderWriter);
        printWriter.println();
        LINE_SEPARATOR = stringBuilderWriter.toString();
        printWriter.close();
    }

    public static void close(java.net.URLConnection uRLConnection) {
        if (uRLConnection instanceof java.net.HttpURLConnection) {
            ((java.net.HttpURLConnection) uRLConnection).disconnect();
        }
    }

    public static void closeQuietly(java.io.Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (java.io.IOException unused) {
            }
        }
    }

    public static void closeQuietly(java.io.InputStream inputStream) {
        closeQuietly((java.io.Closeable) inputStream);
    }

    public static void closeQuietly(java.io.OutputStream outputStream) {
        closeQuietly((java.io.Closeable) outputStream);
    }

    public static void closeQuietly(java.io.Reader reader) {
        closeQuietly((java.io.Closeable) reader);
    }

    public static void closeQuietly(java.io.Writer writer) {
        closeQuietly((java.io.Closeable) writer);
    }

    public static void closeQuietly(java.net.ServerSocket serverSocket) {
        if (serverSocket != null) {
            try {
                serverSocket.close();
            } catch (java.io.IOException unused) {
            }
        }
    }

    public static void closeQuietly(java.net.Socket socket) {
        if (socket != null) {
            try {
                socket.close();
            } catch (java.io.IOException unused) {
            }
        }
    }

    public static void closeQuietly(java.nio.channels.Selector selector) {
        if (selector != null) {
            try {
                selector.close();
            } catch (java.io.IOException unused) {
            }
        }
    }

    public static void closeSilently(java.io.Closeable closeable) {
        try {
            closeable.close();
        } catch (java.lang.Exception unused) {
        }
    }

    public static boolean contentEquals(java.io.InputStream inputStream, java.io.InputStream inputStream2) throws java.io.IOException {
        if (!(inputStream instanceof java.io.BufferedInputStream)) {
            inputStream = new java.io.BufferedInputStream(inputStream);
        }
        if (!(inputStream2 instanceof java.io.BufferedInputStream)) {
            inputStream2 = new java.io.BufferedInputStream(inputStream2);
        }
        for (int read = inputStream.read(); -1 != read; read = inputStream.read()) {
            if (read != inputStream2.read()) {
                return false;
            }
        }
        return inputStream2.read() == -1;
    }

    public static boolean contentEquals(java.io.Reader reader, java.io.Reader reader2) throws java.io.IOException {
        java.io.BufferedReader bufferedReader = toBufferedReader(reader);
        java.io.BufferedReader bufferedReader2 = toBufferedReader(reader2);
        for (int read = bufferedReader.read(); -1 != read; read = bufferedReader.read()) {
            if (read != bufferedReader2.read()) {
                return false;
            }
        }
        return bufferedReader2.read() == -1;
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x0027, code lost:
    
        return true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:12:0x0029, code lost:
    
        return false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:9:0x0025, code lost:
    
        if (r1 != null) goto L11;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static boolean contentEqualsIgnoreEOL(java.io.Reader reader, java.io.Reader reader2) throws java.io.IOException {
        java.io.BufferedReader bufferedReader = toBufferedReader(reader);
        java.io.BufferedReader bufferedReader2 = toBufferedReader(reader2);
        java.lang.String readLine = bufferedReader.readLine();
        java.lang.String readLine2 = bufferedReader2.readLine();
        while (readLine != null && readLine2 != null && readLine.equals(readLine2)) {
            readLine = bufferedReader.readLine();
            readLine2 = bufferedReader2.readLine();
        }
        return readLine.equals(readLine2);
    }

    public static int copy(java.io.InputStream inputStream, java.io.OutputStream outputStream) throws java.io.IOException {
        long copyLarge = copyLarge(inputStream, outputStream);
        if (copyLarge > 2147483647L) {
            return -1;
        }
        return (int) copyLarge;
    }

    public static int copy(java.io.Reader reader, java.io.Writer writer) throws java.io.IOException {
        long copyLarge = copyLarge(reader, writer);
        if (copyLarge > 2147483647L) {
            return -1;
        }
        return (int) copyLarge;
    }

    public static void copy(java.io.InputStream inputStream, java.io.Writer writer) throws java.io.IOException {
        copy(inputStream, writer, java.nio.charset.Charset.defaultCharset());
    }

    public static void copy(java.io.InputStream inputStream, java.io.Writer writer, java.lang.String str) throws java.io.IOException {
        copy(inputStream, writer, com.aliyun.vod.common.utils.Charsets.toCharset(str));
    }

    public static void copy(java.io.InputStream inputStream, java.io.Writer writer, java.nio.charset.Charset charset) throws java.io.IOException {
        copy(new java.io.InputStreamReader(inputStream, com.aliyun.vod.common.utils.Charsets.toCharset(charset)), writer);
    }

    public static void copy(java.io.Reader reader, java.io.OutputStream outputStream) throws java.io.IOException {
        copy(reader, outputStream, java.nio.charset.Charset.defaultCharset());
    }

    public static void copy(java.io.Reader reader, java.io.OutputStream outputStream, java.lang.String str) throws java.io.IOException {
        copy(reader, outputStream, com.aliyun.vod.common.utils.Charsets.toCharset(str));
    }

    public static void copy(java.io.Reader reader, java.io.OutputStream outputStream, java.nio.charset.Charset charset) throws java.io.IOException {
        java.io.OutputStreamWriter outputStreamWriter = new java.io.OutputStreamWriter(outputStream, com.aliyun.vod.common.utils.Charsets.toCharset(charset));
        copy(reader, outputStreamWriter);
        outputStreamWriter.flush();
    }

    public static long copyLarge(java.io.InputStream inputStream, java.io.OutputStream outputStream) throws java.io.IOException {
        return copyLarge(inputStream, outputStream, new byte[32768]);
    }

    public static long copyLarge(java.io.InputStream inputStream, java.io.OutputStream outputStream, long j, long j2) throws java.io.IOException {
        return copyLarge(inputStream, outputStream, j, j2, new byte[32768]);
    }

    public static long copyLarge(java.io.InputStream inputStream, java.io.OutputStream outputStream, long j, long j2, byte[] bArr) throws java.io.IOException {
        long j3 = 0;
        if (j > 0) {
            skipFully(inputStream, j);
        }
        if (j2 == 0) {
            return 0L;
        }
        int length = bArr.length;
        int i = (j2 <= 0 || j2 >= ((long) length)) ? length : (int) j2;
        while (i > 0) {
            int read = inputStream.read(bArr, 0, i);
            if (-1 == read) {
                break;
            }
            outputStream.write(bArr, 0, read);
            j3 += read;
            if (j2 > 0) {
                i = (int) java.lang.Math.min(j2 - j3, length);
            }
        }
        return j3;
    }

    public static long copyLarge(java.io.InputStream inputStream, java.io.OutputStream outputStream, byte[] bArr) throws java.io.IOException {
        long j = 0;
        while (true) {
            int read = inputStream.read(bArr);
            if (-1 == read) {
                return j;
            }
            outputStream.write(bArr, 0, read);
            j += read;
        }
    }

    public static long copyLarge(java.io.Reader reader, java.io.Writer writer) throws java.io.IOException {
        return copyLarge(reader, writer, new char[32768]);
    }

    public static long copyLarge(java.io.Reader reader, java.io.Writer writer, long j, long j2) throws java.io.IOException {
        return copyLarge(reader, writer, j, j2, new char[32768]);
    }

    public static long copyLarge(java.io.Reader reader, java.io.Writer writer, long j, long j2, char[] cArr) throws java.io.IOException {
        long j3 = 0;
        if (j > 0) {
            skipFully(reader, j);
        }
        if (j2 == 0) {
            return 0L;
        }
        int length = cArr.length;
        if (j2 > 0 && j2 < cArr.length) {
            length = (int) j2;
        }
        while (length > 0) {
            int read = reader.read(cArr, 0, length);
            if (-1 == read) {
                break;
            }
            writer.write(cArr, 0, read);
            j3 += read;
            if (j2 > 0) {
                length = (int) java.lang.Math.min(j2 - j3, cArr.length);
            }
        }
        return j3;
    }

    public static long copyLarge(java.io.Reader reader, java.io.Writer writer, char[] cArr) throws java.io.IOException {
        long j = 0;
        while (true) {
            int read = reader.read(cArr);
            if (-1 == read) {
                return j;
            }
            writer.write(cArr, 0, read);
            j += read;
        }
    }

    public static boolean copyStream(java.io.InputStream inputStream, java.io.RandomAccessFile randomAccessFile, com.aliyun.vod.common.utils.IOUtils.CopyListener copyListener, int i) throws java.io.IOException {
        return copyStream(inputStream, randomAccessFile, copyListener, i, 32768);
    }

    public static boolean copyStream(java.io.InputStream inputStream, java.io.RandomAccessFile randomAccessFile, com.aliyun.vod.common.utils.IOUtils.CopyListener copyListener, int i, int i2) throws java.io.IOException {
        int available = inputStream.available();
        byte[] bArr = new byte[i2];
        if (shouldStopLoading(copyListener, i, available)) {
            return false;
        }
        do {
            int read = inputStream.read(bArr, 0, i2);
            if (read == -1) {
                return true;
            }
            randomAccessFile.write(bArr, 0, read);
            i += read;
        } while (!shouldStopLoading(copyListener, i, available));
        return false;
    }

    public static int read(java.io.InputStream inputStream, byte[] bArr) throws java.io.IOException {
        return read(inputStream, bArr, 0, bArr.length);
    }

    public static int read(java.io.InputStream inputStream, byte[] bArr, int i, int i2) throws java.io.IOException {
        if (i2 < 0) {
            throw new java.lang.IllegalArgumentException("Length must not be negative: " + i2);
        }
        int i3 = i2;
        while (i3 > 0) {
            int read = inputStream.read(bArr, (i2 - i3) + i, i3);
            if (-1 == read) {
                break;
            }
            i3 -= read;
        }
        return i2 - i3;
    }

    public static int read(java.io.Reader reader, char[] cArr) throws java.io.IOException {
        return read(reader, cArr, 0, cArr.length);
    }

    public static int read(java.io.Reader reader, char[] cArr, int i, int i2) throws java.io.IOException {
        if (i2 < 0) {
            throw new java.lang.IllegalArgumentException("Length must not be negative: " + i2);
        }
        int i3 = i2;
        while (i3 > 0) {
            int read = reader.read(cArr, (i2 - i3) + i, i3);
            if (-1 == read) {
                break;
            }
            i3 -= read;
        }
        return i2 - i3;
    }

    public static void readFully(java.io.InputStream inputStream, byte[] bArr) throws java.io.IOException {
        readFully(inputStream, bArr, 0, bArr.length);
    }

    public static void readFully(java.io.InputStream inputStream, byte[] bArr, int i, int i2) throws java.io.IOException {
        int read = read(inputStream, bArr, i, i2);
        if (read == i2) {
            return;
        }
        throw new java.io.EOFException("Length to read: " + i2 + " actual: " + read);
    }

    public static void readFully(java.io.Reader reader, char[] cArr) throws java.io.IOException {
        readFully(reader, cArr, 0, cArr.length);
    }

    public static void readFully(java.io.Reader reader, char[] cArr, int i, int i2) throws java.io.IOException {
        int read = read(reader, cArr, i, i2);
        if (read == i2) {
            return;
        }
        throw new java.io.EOFException("Length to read: " + i2 + " actual: " + read);
    }

    public static java.util.List<java.lang.String> readLines(java.io.InputStream inputStream) throws java.io.IOException {
        return readLines(inputStream, java.nio.charset.Charset.defaultCharset());
    }

    public static java.util.List<java.lang.String> readLines(java.io.InputStream inputStream, java.lang.String str) throws java.io.IOException {
        return readLines(inputStream, com.aliyun.vod.common.utils.Charsets.toCharset(str));
    }

    public static java.util.List<java.lang.String> readLines(java.io.InputStream inputStream, java.nio.charset.Charset charset) throws java.io.IOException {
        return readLines(new java.io.InputStreamReader(inputStream, com.aliyun.vod.common.utils.Charsets.toCharset(charset)));
    }

    public static java.util.List<java.lang.String> readLines(java.io.Reader reader) throws java.io.IOException {
        java.io.BufferedReader bufferedReader = toBufferedReader(reader);
        java.util.ArrayList arrayList = new java.util.ArrayList();
        for (java.lang.String readLine = bufferedReader.readLine(); readLine != null; readLine = bufferedReader.readLine()) {
            arrayList.add(readLine);
        }
        return arrayList;
    }

    private static boolean shouldStopLoading(com.aliyun.vod.common.utils.IOUtils.CopyListener copyListener, int i, int i2) {
        return (copyListener == null || copyListener.onBytesCopied(i, i2) || (i * 100) / i2 >= 75) ? false : true;
    }

    public static long skip(java.io.InputStream inputStream, long j) throws java.io.IOException {
        if (j < 0) {
            throw new java.lang.IllegalArgumentException("Skip count must be non-negative, actual: " + j);
        }
        if (SKIP_BYTE_BUFFER == null) {
            SKIP_BYTE_BUFFER = new byte[2048];
        }
        long j2 = j;
        while (j2 > 0) {
            long read = inputStream.read(SKIP_BYTE_BUFFER, 0, (int) java.lang.Math.min(j2, 2048L));
            if (read < 0) {
                break;
            }
            j2 -= read;
        }
        return j - j2;
    }

    public static long skip(java.io.Reader reader, long j) throws java.io.IOException {
        if (j < 0) {
            throw new java.lang.IllegalArgumentException("Skip count must be non-negative, actual: " + j);
        }
        if (SKIP_CHAR_BUFFER == null) {
            SKIP_CHAR_BUFFER = new char[2048];
        }
        long j2 = j;
        while (j2 > 0) {
            long read = reader.read(SKIP_CHAR_BUFFER, 0, (int) java.lang.Math.min(j2, 2048L));
            if (read < 0) {
                break;
            }
            j2 -= read;
        }
        return j - j2;
    }

    public static void skipFully(java.io.InputStream inputStream, long j) throws java.io.IOException {
        if (j < 0) {
            throw new java.lang.IllegalArgumentException("Bytes to skip must not be negative: " + j);
        }
        long skip = skip(inputStream, j);
        if (skip == j) {
            return;
        }
        throw new java.io.EOFException("Bytes to skip: " + j + " actual: " + skip);
    }

    public static void skipFully(java.io.Reader reader, long j) throws java.io.IOException {
        long skip = skip(reader, j);
        if (skip == j) {
            return;
        }
        throw new java.io.EOFException("Chars to skip: " + j + " actual: " + skip);
    }

    public static java.io.InputStream toBufferedInputStream(java.io.InputStream inputStream) throws java.io.IOException {
        return com.aliyun.vod.common.stream.ByteArrayOutputStream.toBufferedInputStream(inputStream);
    }

    public static java.io.BufferedReader toBufferedReader(java.io.Reader reader) {
        return reader instanceof java.io.BufferedReader ? (java.io.BufferedReader) reader : new java.io.BufferedReader(reader);
    }

    public static byte[] toByteArray(java.io.InputStream inputStream) throws java.io.IOException {
        com.aliyun.vod.common.stream.ByteArrayOutputStream byteArrayOutputStream = new com.aliyun.vod.common.stream.ByteArrayOutputStream();
        copy(inputStream, byteArrayOutputStream);
        return byteArrayOutputStream.toByteArray();
    }

    public static byte[] toByteArray(java.io.InputStream inputStream, int i) throws java.io.IOException {
        if (i < 0) {
            throw new java.lang.IllegalArgumentException("Size must be equal or greater than zero: " + i);
        }
        int i2 = 0;
        if (i == 0) {
            return new byte[0];
        }
        byte[] bArr = new byte[i];
        while (i2 < i) {
            int read = inputStream.read(bArr, i2, i - i2);
            if (read == -1) {
                break;
            }
            i2 += read;
        }
        if (i2 == i) {
            return bArr;
        }
        throw new java.io.IOException("Unexpected readed size. current: " + i2 + ", excepted: " + i);
    }

    public static byte[] toByteArray(java.io.InputStream inputStream, long j) throws java.io.IOException {
        if (j <= 2147483647L) {
            return toByteArray(inputStream, (int) j);
        }
        throw new java.lang.IllegalArgumentException("Size cannot be greater than Integer max value: " + j);
    }

    public static byte[] toByteArray(java.io.Reader reader) throws java.io.IOException {
        return toByteArray(reader, java.nio.charset.Charset.defaultCharset());
    }

    public static byte[] toByteArray(java.io.Reader reader, java.lang.String str) throws java.io.IOException {
        return toByteArray(reader, com.aliyun.vod.common.utils.Charsets.toCharset(str));
    }

    public static byte[] toByteArray(java.io.Reader reader, java.nio.charset.Charset charset) throws java.io.IOException {
        com.aliyun.vod.common.stream.ByteArrayOutputStream byteArrayOutputStream = new com.aliyun.vod.common.stream.ByteArrayOutputStream();
        copy(reader, byteArrayOutputStream, charset);
        return byteArrayOutputStream.toByteArray();
    }

    @java.lang.Deprecated
    public static byte[] toByteArray(java.lang.String str) throws java.io.IOException {
        return str.getBytes();
    }

    public static byte[] toByteArray(java.net.URI uri) throws java.io.IOException {
        return toByteArray(uri.toURL());
    }

    public static byte[] toByteArray(java.net.URL url) throws java.io.IOException {
        java.net.URLConnection openConnection = url.openConnection();
        try {
            return toByteArray(openConnection);
        } finally {
            close(openConnection);
        }
    }

    public static byte[] toByteArray(java.net.URLConnection uRLConnection) throws java.io.IOException {
        java.io.InputStream inputStream = uRLConnection.getInputStream();
        try {
            return toByteArray(inputStream);
        } finally {
            inputStream.close();
        }
    }

    public static char[] toCharArray(java.io.InputStream inputStream) throws java.io.IOException {
        return toCharArray(inputStream, java.nio.charset.Charset.defaultCharset());
    }

    public static char[] toCharArray(java.io.InputStream inputStream, java.lang.String str) throws java.io.IOException {
        return toCharArray(inputStream, com.aliyun.vod.common.utils.Charsets.toCharset(str));
    }

    public static char[] toCharArray(java.io.InputStream inputStream, java.nio.charset.Charset charset) throws java.io.IOException {
        java.io.CharArrayWriter charArrayWriter = new java.io.CharArrayWriter();
        copy(inputStream, charArrayWriter, charset);
        return charArrayWriter.toCharArray();
    }

    public static char[] toCharArray(java.io.Reader reader) throws java.io.IOException {
        java.io.CharArrayWriter charArrayWriter = new java.io.CharArrayWriter();
        copy(reader, charArrayWriter);
        return charArrayWriter.toCharArray();
    }

    public static java.io.InputStream toInputStream(java.lang.CharSequence charSequence) {
        return toInputStream(charSequence, java.nio.charset.Charset.defaultCharset());
    }

    public static java.io.InputStream toInputStream(java.lang.CharSequence charSequence, java.lang.String str) throws java.io.IOException {
        return toInputStream(charSequence, com.aliyun.vod.common.utils.Charsets.toCharset(str));
    }

    public static java.io.InputStream toInputStream(java.lang.CharSequence charSequence, java.nio.charset.Charset charset) {
        return toInputStream(charSequence.toString(), charset);
    }

    public static java.io.InputStream toInputStream(java.lang.String str) {
        return toInputStream(str, java.nio.charset.Charset.defaultCharset());
    }

    public static java.io.InputStream toInputStream(java.lang.String str, java.lang.String str2) throws java.io.IOException {
        return new java.io.ByteArrayInputStream(com.aliyun.vod.common.utils.StringCodingUtils.getBytes(str, com.aliyun.vod.common.utils.Charsets.toCharset(str2)));
    }

    public static java.io.InputStream toInputStream(java.lang.String str, java.nio.charset.Charset charset) {
        return new java.io.ByteArrayInputStream(com.aliyun.vod.common.utils.StringCodingUtils.getBytes(str, com.aliyun.vod.common.utils.Charsets.toCharset(charset)));
    }

    public static java.lang.String toString(java.io.InputStream inputStream) throws java.io.IOException {
        return toString(inputStream, java.nio.charset.Charset.defaultCharset());
    }

    public static java.lang.String toString(java.io.InputStream inputStream, java.lang.String str) throws java.io.IOException {
        return toString(inputStream, com.aliyun.vod.common.utils.Charsets.toCharset(str));
    }

    public static java.lang.String toString(java.io.InputStream inputStream, java.nio.charset.Charset charset) throws java.io.IOException {
        com.aliyun.vod.common.stream.StringBuilderWriter stringBuilderWriter = new com.aliyun.vod.common.stream.StringBuilderWriter();
        copy(inputStream, stringBuilderWriter, charset);
        return stringBuilderWriter.toString();
    }

    public static java.lang.String toString(java.io.Reader reader) throws java.io.IOException {
        com.aliyun.vod.common.stream.StringBuilderWriter stringBuilderWriter = new com.aliyun.vod.common.stream.StringBuilderWriter();
        copy(reader, stringBuilderWriter);
        return stringBuilderWriter.toString();
    }

    public static java.lang.String toString(java.net.URI uri) throws java.io.IOException {
        return toString(uri, java.nio.charset.Charset.defaultCharset());
    }

    public static java.lang.String toString(java.net.URI uri, java.lang.String str) throws java.io.IOException {
        return toString(uri, com.aliyun.vod.common.utils.Charsets.toCharset(str));
    }

    public static java.lang.String toString(java.net.URI uri, java.nio.charset.Charset charset) throws java.io.IOException {
        return toString(uri.toURL(), com.aliyun.vod.common.utils.Charsets.toCharset(charset));
    }

    public static java.lang.String toString(java.net.URL url) throws java.io.IOException {
        return toString(url, java.nio.charset.Charset.defaultCharset());
    }

    public static java.lang.String toString(java.net.URL url, java.lang.String str) throws java.io.IOException {
        return toString(url, com.aliyun.vod.common.utils.Charsets.toCharset(str));
    }

    public static java.lang.String toString(java.net.URL url, java.nio.charset.Charset charset) throws java.io.IOException {
        java.io.InputStream openStream = url.openStream();
        try {
            return toString(openStream, charset);
        } finally {
            openStream.close();
        }
    }

    @java.lang.Deprecated
    public static java.lang.String toString(byte[] bArr) throws java.io.IOException {
        return new java.lang.String(bArr);
    }

    public static java.lang.String toString(byte[] bArr, java.lang.String str) throws java.io.IOException {
        return new java.lang.String(bArr, str);
    }

    public static void write(java.lang.CharSequence charSequence, java.io.OutputStream outputStream) throws java.io.IOException {
        write(charSequence, outputStream, java.nio.charset.Charset.defaultCharset());
    }

    public static void write(java.lang.CharSequence charSequence, java.io.OutputStream outputStream, java.lang.String str) throws java.io.IOException {
        write(charSequence, outputStream, com.aliyun.vod.common.utils.Charsets.toCharset(str));
    }

    public static void write(java.lang.CharSequence charSequence, java.io.OutputStream outputStream, java.nio.charset.Charset charset) throws java.io.IOException {
        if (charSequence != null) {
            write(charSequence.toString(), outputStream, charset);
        }
    }

    public static void write(java.lang.CharSequence charSequence, java.io.Writer writer) throws java.io.IOException {
        if (charSequence != null) {
            write(charSequence.toString(), writer);
        }
    }

    public static void write(java.lang.String str, java.io.OutputStream outputStream) throws java.io.IOException {
        write(str, outputStream, java.nio.charset.Charset.defaultCharset());
    }

    public static void write(java.lang.String str, java.io.OutputStream outputStream, java.lang.String str2) throws java.io.IOException {
        write(str, outputStream, com.aliyun.vod.common.utils.Charsets.toCharset(str2));
    }

    public static void write(java.lang.String str, java.io.OutputStream outputStream, java.nio.charset.Charset charset) throws java.io.IOException {
        if (str != null) {
            outputStream.write(com.aliyun.vod.common.utils.StringCodingUtils.getBytes(str, com.aliyun.vod.common.utils.Charsets.toCharset(charset)));
        }
    }

    public static void write(java.lang.String str, java.io.Writer writer) throws java.io.IOException {
        if (str != null) {
            writer.write(str);
        }
    }

    @java.lang.Deprecated
    public static void write(java.lang.StringBuffer stringBuffer, java.io.OutputStream outputStream) throws java.io.IOException {
        write(stringBuffer, outputStream, (java.lang.String) null);
    }

    @java.lang.Deprecated
    public static void write(java.lang.StringBuffer stringBuffer, java.io.OutputStream outputStream, java.lang.String str) throws java.io.IOException {
        if (stringBuffer != null) {
            outputStream.write(com.aliyun.vod.common.utils.StringCodingUtils.getBytes(stringBuffer.toString(), com.aliyun.vod.common.utils.Charsets.toCharset(str)));
        }
    }

    @java.lang.Deprecated
    public static void write(java.lang.StringBuffer stringBuffer, java.io.Writer writer) throws java.io.IOException {
        if (stringBuffer != null) {
            writer.write(stringBuffer.toString());
        }
    }

    public static void write(byte[] bArr, java.io.OutputStream outputStream) throws java.io.IOException {
        if (bArr != null) {
            outputStream.write(bArr);
        }
    }

    public static void write(byte[] bArr, java.io.Writer writer) throws java.io.IOException {
        write(bArr, writer, java.nio.charset.Charset.defaultCharset());
    }

    public static void write(byte[] bArr, java.io.Writer writer, java.lang.String str) throws java.io.IOException {
        write(bArr, writer, com.aliyun.vod.common.utils.Charsets.toCharset(str));
    }

    public static void write(byte[] bArr, java.io.Writer writer, java.nio.charset.Charset charset) throws java.io.IOException {
        if (bArr != null) {
            writer.write(new java.lang.String(bArr, com.aliyun.vod.common.utils.Charsets.toCharset(charset)));
        }
    }

    public static void write(char[] cArr, java.io.OutputStream outputStream) throws java.io.IOException {
        write(cArr, outputStream, java.nio.charset.Charset.defaultCharset());
    }

    public static void write(char[] cArr, java.io.OutputStream outputStream, java.lang.String str) throws java.io.IOException {
        write(cArr, outputStream, com.aliyun.vod.common.utils.Charsets.toCharset(str));
    }

    public static void write(char[] cArr, java.io.OutputStream outputStream, java.nio.charset.Charset charset) throws java.io.IOException {
        if (cArr != null) {
            outputStream.write(com.aliyun.vod.common.utils.StringCodingUtils.getBytes(new java.lang.String(cArr), com.aliyun.vod.common.utils.Charsets.toCharset(charset)));
        }
    }

    public static void write(char[] cArr, java.io.Writer writer) throws java.io.IOException {
        if (cArr != null) {
            writer.write(cArr);
        }
    }

    public static void writeLines(java.util.Collection<?> collection, java.lang.String str, java.io.OutputStream outputStream) throws java.io.IOException {
        writeLines(collection, str, outputStream, java.nio.charset.Charset.defaultCharset());
    }

    public static void writeLines(java.util.Collection<?> collection, java.lang.String str, java.io.OutputStream outputStream, java.lang.String str2) throws java.io.IOException {
        writeLines(collection, str, outputStream, com.aliyun.vod.common.utils.Charsets.toCharset(str2));
    }

    public static void writeLines(java.util.Collection<?> collection, java.lang.String str, java.io.OutputStream outputStream, java.nio.charset.Charset charset) throws java.io.IOException {
        if (collection == null) {
            return;
        }
        if (str == null) {
            str = LINE_SEPARATOR;
        }
        java.nio.charset.Charset charset2 = com.aliyun.vod.common.utils.Charsets.toCharset(charset);
        for (java.lang.Object obj : collection) {
            if (obj != null) {
                outputStream.write(com.aliyun.vod.common.utils.StringCodingUtils.getBytes(obj.toString(), charset2));
            }
            outputStream.write(com.aliyun.vod.common.utils.StringCodingUtils.getBytes(str, charset2));
        }
    }

    public static void writeLines(java.util.Collection<?> collection, java.lang.String str, java.io.Writer writer) throws java.io.IOException {
        if (collection == null) {
            return;
        }
        if (str == null) {
            str = LINE_SEPARATOR;
        }
        for (java.lang.Object obj : collection) {
            if (obj != null) {
                writer.write(obj.toString());
            }
            writer.write(str);
        }
    }
}
