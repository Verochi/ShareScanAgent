package com.getkeepsafe.relinker.elf;

/* loaded from: classes22.dex */
public class ElfParser implements java.io.Closeable, com.getkeepsafe.relinker.elf.Elf {
    public final int n = 1179403647;
    public final java.nio.channels.FileChannel t;

    public ElfParser(java.io.File file) throws java.io.FileNotFoundException {
        if (file == null || !file.exists()) {
            throw new java.lang.IllegalArgumentException("File is null or does not exist");
        }
        this.t = new java.io.FileInputStream(file).getChannel();
    }

    public final long a(com.getkeepsafe.relinker.elf.Elf.Header header, long j, long j2) throws java.io.IOException {
        for (long j3 = 0; j3 < j; j3++) {
            com.getkeepsafe.relinker.elf.Elf.ProgramHeader programHeader = header.getProgramHeader(j3);
            if (programHeader.type == 1) {
                long j4 = programHeader.vaddr;
                if (j4 <= j2 && j2 <= programHeader.memsz + j4) {
                    return (j2 - j4) + programHeader.offset;
                }
            }
        }
        throw new java.lang.IllegalStateException("Could not map vma to file offset!");
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws java.io.IOException {
        this.t.close();
    }

    public com.getkeepsafe.relinker.elf.Elf.Header parseHeader() throws java.io.IOException {
        this.t.position(0L);
        java.nio.ByteBuffer allocate = java.nio.ByteBuffer.allocate(8);
        allocate.order(java.nio.ByteOrder.LITTLE_ENDIAN);
        if (readWord(allocate, 0L) != 1179403647) {
            throw new java.lang.IllegalArgumentException("Invalid ELF Magic!");
        }
        short readByte = readByte(allocate, 4L);
        boolean z = readByte(allocate, 5L) == 2;
        if (readByte == 1) {
            return new com.getkeepsafe.relinker.elf.Elf32Header(z, this);
        }
        if (readByte == 2) {
            return new com.getkeepsafe.relinker.elf.Elf64Header(z, this);
        }
        throw new java.lang.IllegalStateException("Invalid class type!");
    }

    public java.util.List<java.lang.String> parseNeededDependencies() throws java.io.IOException {
        long j;
        this.t.position(0L);
        java.util.ArrayList arrayList = new java.util.ArrayList();
        com.getkeepsafe.relinker.elf.Elf.Header parseHeader = parseHeader();
        java.nio.ByteBuffer allocate = java.nio.ByteBuffer.allocate(8);
        allocate.order(parseHeader.bigEndian ? java.nio.ByteOrder.BIG_ENDIAN : java.nio.ByteOrder.LITTLE_ENDIAN);
        long j2 = parseHeader.phnum;
        int i = 0;
        if (j2 == 65535) {
            j2 = parseHeader.getSectionHeader(0).info;
        }
        long j3 = 0;
        while (true) {
            if (j3 >= j2) {
                j = 0;
                break;
            }
            com.getkeepsafe.relinker.elf.Elf.ProgramHeader programHeader = parseHeader.getProgramHeader(j3);
            if (programHeader.type == 2) {
                j = programHeader.offset;
                break;
            }
            j3++;
        }
        if (j == 0) {
            return java.util.Collections.unmodifiableList(arrayList);
        }
        java.util.ArrayList arrayList2 = new java.util.ArrayList();
        long j4 = 0;
        while (true) {
            com.getkeepsafe.relinker.elf.Elf.DynamicStructure dynamicStructure = parseHeader.getDynamicStructure(j, i);
            long j5 = j;
            long j6 = dynamicStructure.tag;
            if (j6 == 1) {
                arrayList2.add(java.lang.Long.valueOf(dynamicStructure.val));
            } else if (j6 == 5) {
                j4 = dynamicStructure.val;
            }
            i++;
            if (dynamicStructure.tag == 0) {
                break;
            }
            j = j5;
        }
        if (j4 == 0) {
            throw new java.lang.IllegalStateException("String table offset not found!");
        }
        long a = a(parseHeader, j2, j4);
        java.util.Iterator it = arrayList2.iterator();
        while (it.hasNext()) {
            arrayList.add(readString(allocate, ((java.lang.Long) it.next()).longValue() + a));
        }
        return arrayList;
    }

    public void read(java.nio.ByteBuffer byteBuffer, long j, int i) throws java.io.IOException {
        byteBuffer.position(0);
        byteBuffer.limit(i);
        long j2 = 0;
        while (j2 < i) {
            int read = this.t.read(byteBuffer, j + j2);
            if (read == -1) {
                throw new java.io.EOFException();
            }
            j2 += read;
        }
        byteBuffer.position(0);
    }

    public short readByte(java.nio.ByteBuffer byteBuffer, long j) throws java.io.IOException {
        read(byteBuffer, j, 1);
        return (short) (byteBuffer.get() & 255);
    }

    public int readHalf(java.nio.ByteBuffer byteBuffer, long j) throws java.io.IOException {
        read(byteBuffer, j, 2);
        return byteBuffer.getShort() & kotlin.UShort.MAX_VALUE;
    }

    public long readLong(java.nio.ByteBuffer byteBuffer, long j) throws java.io.IOException {
        read(byteBuffer, j, 8);
        return byteBuffer.getLong();
    }

    public java.lang.String readString(java.nio.ByteBuffer byteBuffer, long j) throws java.io.IOException {
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        while (true) {
            long j2 = 1 + j;
            short readByte = readByte(byteBuffer, j);
            if (readByte == 0) {
                return sb.toString();
            }
            sb.append((char) readByte);
            j = j2;
        }
    }

    public long readWord(java.nio.ByteBuffer byteBuffer, long j) throws java.io.IOException {
        read(byteBuffer, j, 4);
        return byteBuffer.getInt() & net.lingala.zip4j.util.InternalZipConstants.ZIP_64_LIMIT;
    }
}
