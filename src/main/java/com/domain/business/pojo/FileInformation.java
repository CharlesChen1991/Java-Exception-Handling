package com.domain.business.pojo;

import com.domain.business.constant.FileTypeEnum;

/**
 * Pojo to store file information
 *
 * @author hao.e.chen
 * @date 26/12/2017
 */
public class FileInformation {

    private String fileName;
    private FileTypeEnum fileType;
    private String fileContent;

    public FileInformation(String fileName, FileTypeEnum fileType) {
        this.fileName = fileName;
        this.fileType = fileType;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public FileTypeEnum getFileType() {
        return fileType;
    }

    public void setFileType(FileTypeEnum fileType) {
        this.fileType = fileType;
    }

    public String getFileContent() {
        return fileContent;
    }

    public void setFileContent(String fileContent) {
        this.fileContent = fileContent;
    }

}
