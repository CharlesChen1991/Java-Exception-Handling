package com.domain.business.constant;

/**
 * This enum is to specify the file suffix
 *
 * @author hao.e.chen
 * @date 26/12/2017
 */
public enum FileTypeEnum {

    /**
     * csv file in *.csv format
     */
    CSV(".csv", "*.csv file"),
    /**
     * text file in *.txt format
     */
    TXT(".txt", "*.txt file");

    private String suffix;

    private String description;

    public String getSuffix() {
        return suffix;
    }

    public String getDescription() {
        return description;
    }

    FileTypeEnum(String subfix, String description) {
        this.suffix = subfix;
        this.description = description;
    }

    public static FileTypeEnum getFileType(final String subFix) {
        FileTypeEnum temp = null;
        for (FileTypeEnum typeEnum : FileTypeEnum.values()) {
            if (typeEnum.getSuffix().equalsIgnoreCase(subFix)) {
                temp = typeEnum;
            }
        }
        return temp;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("FileTypeEnum{");
        sb.append("suffix='").append(suffix).append('\'');
        sb.append(", description='").append(description).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
