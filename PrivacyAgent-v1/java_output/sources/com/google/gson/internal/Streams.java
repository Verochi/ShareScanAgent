package com.google.gson.internal;

/* loaded from: classes22.dex */
public final class Streams {

    public static final class AppendableWriter extends java.io.Writer {
        private final java.lang.Appendable appendable;
        private final com.google.gson.internal.Streams.AppendableWriter.CurrentWrite currentWrite = new com.google.gson.internal.Streams.AppendableWriter.CurrentWrite();

        public static class CurrentWrite implements java.lang.CharSequence {
            char[] chars;

            @Override // java.lang.CharSequence
            public char charAt(int i) {
                return this.chars[i];
            }

            @Override // java.lang.CharSequence
            public int length() {
                return this.chars.length;
            }

            @Override // java.lang.CharSequence
            public java.lang.CharSequence subSequence(int i, int i2) {
                return new java.lang.String(this.chars, i, i2 - i);
            }
        }

        public AppendableWriter(java.lang.Appendable appendable) {
            this.appendable = appendable;
        }

        @Override // java.io.Writer, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
        }

        @Override // java.io.Writer, java.io.Flushable
        public void flush() {
        }

        @Override // java.io.Writer
        public void write(int i) throws java.io.IOException {
            this.appendable.append((char) i);
        }

        @Override // java.io.Writer
        public void write(char[] cArr, int i, int i2) throws java.io.IOException {
            com.google.gson.internal.Streams.AppendableWriter.CurrentWrite currentWrite = this.currentWrite;
            currentWrite.chars = cArr;
            this.appendable.append(currentWrite, i, i2 + i);
        }
    }

    private Streams() {
        throw new java.lang.UnsupportedOperationException();
    }

    public static com.google.gson.JsonElement parse(com.google.gson.stream.JsonReader jsonReader) throws com.google.gson.JsonParseException {
        boolean z;
        try {
            try {
                jsonReader.peek();
                z = false;
            } catch (java.io.EOFException e) {
                e = e;
                z = true;
            }
            try {
                return com.google.gson.internal.bind.TypeAdapters.JSON_ELEMENT.read2(jsonReader);
            } catch (java.io.EOFException e2) {
                e = e2;
                if (z) {
                    return com.google.gson.JsonNull.INSTANCE;
                }
                throw new com.google.gson.JsonSyntaxException(e);
            }
        } catch (com.google.gson.stream.MalformedJsonException e3) {
            throw new com.google.gson.JsonSyntaxException(e3);
        } catch (java.io.IOException e4) {
            throw new com.google.gson.JsonIOException(e4);
        } catch (java.lang.NumberFormatException e5) {
            throw new com.google.gson.JsonSyntaxException(e5);
        }
    }

    public static void write(com.google.gson.JsonElement jsonElement, com.google.gson.stream.JsonWriter jsonWriter) throws java.io.IOException {
        com.google.gson.internal.bind.TypeAdapters.JSON_ELEMENT.write(jsonWriter, jsonElement);
    }

    public static java.io.Writer writerForAppendable(java.lang.Appendable appendable) {
        return appendable instanceof java.io.Writer ? (java.io.Writer) appendable : new com.google.gson.internal.Streams.AppendableWriter(appendable);
    }
}
