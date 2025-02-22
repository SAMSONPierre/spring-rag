package fr.efrei.rag.web.rest;

import fr.efrei.rag.domain.Document;
import fr.efrei.rag.service.DocumentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/documents")
public class DocumentResource {

    private final DocumentService documentService;

    public DocumentResource(DocumentService documentService) {
        this.documentService = documentService;
    }

    @GetMapping("/get-all")
    public List<Document> getAllDocuments() {
        return documentService.findAll();
    }

    @PostMapping("/create")
    public ResponseEntity<Document> createDocument(@RequestBody Document document) {
        Document savedDocument = documentService.buildAndSave(document);
        return ResponseEntity.ok(savedDocument);
    }

    @PostMapping("/documents/chat2/{user}")
    public String chat2(@RequestBody String query) throws InterruptedException {
        return documentService.chat(query);
    }
}
