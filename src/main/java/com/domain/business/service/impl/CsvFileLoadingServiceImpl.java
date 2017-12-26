package com.domain.business.service.impl;

import com.domain.business.constant.FileTypeEnum;
import com.domain.business.pojo.FileInformation;
import com.domain.business.service.IFileLoadingService;
import com.domain.exception.FileOperationException;
import com.domain.exception.FileTypeNotSupportedException;

import java.io.*;
import java.net.URISyntaxException;
import java.util.regex.Pattern;

/**
 * This is file loading service for CSV file
 *
 * @author hao.e.chen
 * @date 26/12/2017
 */
public class CsvFileLoadingServiceImpl implements IFileLoadingService {

    private static Pattern pattern = Pattern.compile("[A-Za-z0-9\t]*");

    /**
     * This method is to print content from file
     *
     * @param fileInformation
     * @throws FileNotFoundException         - if file not exist
     * @throws FileTypeNotSupportedException - if file type is not csv
     * @throws FileOperationException        - if exception occur during printing the file content to console
     */
    @Override
    public void loadFile(FileInformation fileInformation) throws FileNotFoundException, FileTypeNotSupportedException, FileOperationException {

        if (!FileTypeEnum.CSV.equals(fileInformation.getFileType())) {
            throw new FileTypeNotSupportedException("CsvFileLoadingServiceImpl only support to handle csv file.");
        }
        String fileName = fileInformation.getFileName() + fileInformation.getFileType().getSuffix();
        try (BufferedReader br = new BufferedReader(new InputStreamReader(this.getClass().getClassLoader().getResourceAsStream(fileName)))) {
            String line = br.readLine();
            if (!pattern.matcher(line).matches()) {
                System.out.println("File content incorrect.");
                throw new FileOperationException("File content incorrect [" + FileOperationException.ERROR_ILLEGAL_CONTENT + "]");
            }
            while (line != null) {
                if ("".equals(line.trim())) {
                    throw new FileOperationException("File format incorrect [" + FileOperationException.ERROR_FORMAT_INCORRECT + "]");
                }
                line.replaceAll(",", " ");
                System.out.println(line);
                line = br.readLine();
            }
        } catch (NullPointerException e) {
            throw new FileNotFoundException(e.getMessage());
        } catch (IOException e) {
            throw new FileOperationException("IO Exception occur.", e);
        }
    }

    /**
     * This method is to write content to file
     *
     * @param fileInformation
     * @throws FileNotFoundException         - if file not exist
     * @throws FileTypeNotSupportedException - if file type is not csv
     * @throws FileOperationException        - if exception occur during saving the file content to file
     */
    @Override
    public void writeFile(FileInformation fileInformation) throws FileNotFoundException, FileTypeNotSupportedException, FileOperationException {
        if (!FileTypeEnum.CSV.equals(fileInformation.getFileType())) {
            throw new FileTypeNotSupportedException("CsvFileLoadingServiceImpl only support to handle csv file.");
        }
        if ("".equals(fileInformation.getFileContent().trim())) {
            throw new FileOperationException("File format incorrect [" + FileOperationException.ERROR_FORMAT_INCORRECT + "]");
        }
        if (!pattern.matcher(fileInformation.getFileContent()).matches()) {
            throw new FileOperationException("File content incorrect [" + FileOperationException.ERROR_ILLEGAL_CONTENT + "]");
        }
        String fileName = fileInformation.getFileName() + fileInformation.getFileType().getSuffix();

        try (BufferedWriter bw = new BufferedWriter(new FileWriter(new File(this.getClass().getClassLoader().getResource(fileName).toURI())))) {
            //Dummy
            String[] strs = fileInformation.getFileContent().split("\t");
            for (String temp : strs) {
                System.out.println(temp);
            }
        } catch (URISyntaxException e) {
            throw new FileOperationException("URISyntaxException occur.", e);
        } catch (NullPointerException e) {
            throw new FileNotFoundException(e.getMessage());
        } catch (IOException e) {
            throw new FileOperationException("IO Exception occur.", e);
        }
    }
}
