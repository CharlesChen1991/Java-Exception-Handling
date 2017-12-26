package com.domain.business.service;

import com.domain.business.pojo.FileInformation;
import com.domain.exception.FileOperationException;
import com.domain.exception.FileTypeNotSupportedException;

import java.io.FileNotFoundException;

/**
 * This service is to load(print) file content and write information to file
 *
 * @author hao.e.chen
 * @date 26/12/2017
 */
public interface IFileLoadingService {

    /**
     * This method is to print content from file
     *
     * @param fileInformation
     * @throws FileNotFoundException
     * @throws FileTypeNotSupportedException
     * @throws FileOperationException
     */
    void loadFile(FileInformation fileInformation) throws FileNotFoundException, FileTypeNotSupportedException, FileOperationException;

    /**
     * This method is to write content to file
     *
     * @param fileInformation
     * @throws FileNotFoundException
     * @throws FileTypeNotSupportedException
     * @throws FileOperationException
     */
    void writeFile(FileInformation fileInformation) throws FileNotFoundException, FileTypeNotSupportedException, FileOperationException;
}
