package com.architeo.ehiringapp.api;

import com.architeo.ehiringapp.Model.Document;
import com.architeo.ehiringapp.ResponseData;
import com.architeo.ehiringapp.ServiceImpl.DocumentServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
@RestController
@RequiredArgsConstructor
@CrossOrigin("http://localhost:4200")
@RequestMapping("/api")
public class DocumentController {

    private final DocumentServiceImpl documentService;


    @PostMapping("/api/upload")
    public ResponseData uploadFile(@RequestParam("file")MultipartFile file, Document document) throws Exception {
        /*Document document = null;
        String downloadURl = "";
        document = documentService.saveDocument(file);*/
        String downloadURl = ServletUriComponentsBuilder.fromCurrentContextPath()
                .path("/download/")
                .path(String.valueOf(document.getId()))
                .toUriString();
        document.setData(file.getBytes());
        document.setFileName(file.getOriginalFilename());
        document.setFileType(file.getContentType());
        Document doc=documentService.saveDocument(file);
        return new ResponseData(doc.getFileName(),
                downloadURl,
                file.getContentType(),
                file.getSize());
    }

    @GetMapping("/download/{fileId}")
    public ResponseEntity<Resource> downloadFile(@PathVariable Long fileId) throws Exception {
        Document document = null;
        document = documentService.getDocument(fileId);
        return  ResponseEntity.ok()
                .contentType(MediaType.parseMediaType(document.getFileType()))
                .header(HttpHeaders.CONTENT_DISPOSITION,
                        "attachment; filename=\"" + document.getFileName()
                                + "\"")
                .body(new ByteArrayResource(document.getData()));
    }
}
