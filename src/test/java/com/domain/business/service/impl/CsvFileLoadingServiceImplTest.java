package com.domain.business.service.impl;

import com.domain.business.constant.FileTypeEnum;
import com.domain.business.pojo.FileInformation;
import com.domain.business.service.IFileLoadingService;
import com.domain.exception.FileOperationException;
import com.domain.exception.FileTypeNotSupportedException;
import org.hamcrest.CoreMatchers;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.io.FileNotFoundException;

/**
 * Created by hao.e.chen on 26/12/2017.
 */
public class CsvFileLoadingServiceImplTest {

    static IFileLoadingService fileLoadingService;
    static FileInformation fileNotExisted;
    static FileInformation fileFormatIncorrect;
    static FileInformation fileCsv;
    static FileInformation fileTxt;
    static FileInformation fileIllegal;
    static FileInformation writeFileTxt;
    static FileInformation writeFileFormatIncorrect;
    static FileInformation writeFileIllegal;
    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @BeforeClass
    public static void setUp() {
        System.out.println("Setting up the test...");
        fileLoadingService = new CsvFileLoadingServiceImpl();
        fileNotExisted = new FileInformation("non_existed", FileTypeEnum.CSV);
        fileCsv = new FileInformation("test", FileTypeEnum.CSV);
        fileTxt = new FileInformation("test", FileTypeEnum.TXT);
        fileFormatIncorrect = new FileInformation("test_format_incorrect", FileTypeEnum.CSV);
        fileIllegal = new FileInformation("test_content_illegal", FileTypeEnum.CSV);

        writeFileTxt = new FileInformation("test_write", FileTypeEnum.TXT);
        writeFileFormatIncorrect = new FileInformation("test_write_format_incorrect", FileTypeEnum.CSV);
        writeFileIllegal = new FileInformation("test_write_format_incorrect", FileTypeEnum.CSV);
    }

    @Test
    public void loadFileNotExisted() throws Exception {
        thrown.expect(FileNotFoundException.class);
        fileLoadingService.loadFile(fileNotExisted);
    }

    @Test
    public void loadFileTypeNotSupported() throws Exception {
        thrown.expect(FileTypeNotSupportedException.class);
        fileLoadingService.loadFile(fileTxt);
    }

    @Test
    public void loadFileFormatIncorrect() throws Exception {
        thrown.expect(FileOperationException.class);
        thrown.expectMessage(CoreMatchers.containsString(FileOperationException.ERROR_FORMAT_INCORRECT));
        fileLoadingService.loadFile(fileFormatIncorrect);
    }

    @Test
    public void loadFileContainsIllegalContain() throws Exception {
        thrown.expect(FileOperationException.class);
        thrown.expectMessage(CoreMatchers.containsString(FileOperationException.ERROR_ILLEGAL_CONTENT));
        fileLoadingService.loadFile(fileIllegal);
    }

    @Test
    public void writeFileNotExisted() throws Exception {
        thrown.expect(FileNotFoundException.class);
        fileNotExisted.setFileContent("test");
        fileLoadingService.writeFile(fileNotExisted);
    }

    @Test
    public void writeFileTypeNotSupported() throws Exception {
        thrown.expect(FileTypeNotSupportedException.class);
        writeFileTxt.setFileContent("aaaa\tbbbb\naaaa\tvvvv");
        fileLoadingService.writeFile(writeFileTxt);
    }

    @Test
    public void writeFileFormatIncorrect() throws Exception {
        thrown.expect(FileOperationException.class);
        thrown.expectMessage(CoreMatchers.containsString(FileOperationException.ERROR_FORMAT_INCORRECT));
        writeFileFormatIncorrect.setFileContent("\t");
        fileLoadingService.writeFile(writeFileFormatIncorrect);
    }

    @Test
    public void writeContainsIllegalContain() throws Exception {
        thrown.expect(FileOperationException.class);
        thrown.expectMessage(CoreMatchers.containsString(FileOperationException.ERROR_ILLEGAL_CONTENT));
        writeFileIllegal.setFileContent("%^$\t%^&\naaa");
        fileLoadingService.writeFile(writeFileIllegal);
    }

}