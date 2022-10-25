package com.architeo.ehiringapp.Service;

import com.architeo.ehiringapp.Model.Document;
import org.springframework.web.multipart.MultipartFile;

public interface DocumentService {
    Document saveDocument(MultipartFile file) throws Exception;
    Document getDocument(Long fileId) throws Exception;

}
