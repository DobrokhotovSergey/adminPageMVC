package ua.laksmi.web.domain.tables.export;

import java.util.Arrays;

/**
 * Created by Dobriks on 29.06.2017.
 */
public class CommercialFile {
    private byte[] bytes;
    private String fileName;

    public byte[] getBytes() {
        return bytes;
    }

    public void setBytes(byte[] bytes) {
        this.bytes = bytes;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    @Override
    public String toString() {
        return "CommercialFile{" +
                "bytes=" + Arrays.toString(bytes) +
                ", fileName='" + fileName + '\'' +
                '}';
    }
}
