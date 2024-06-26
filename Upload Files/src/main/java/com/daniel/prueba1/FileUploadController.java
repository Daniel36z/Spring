package com.daniel.prueba1;


import java.io.IOException;
import java.util.stream.Collectors;

import com.daniel.prueba1.storage.StorageException;
import com.daniel.prueba1.storage.StorageFileNotFoundException;
import com.daniel.prueba1.storage.StorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.method.annotation.MvcUriComponentsBuilder;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;



@Controller
public class FileUploadController {

    private final StorageService storageService;

    @Autowired
    public FileUploadController(StorageService storageService) {
        this.storageService = storageService;
    }

    @GetMapping("/")
    public String listUploadedFiles(Model model) throws IOException {
        model.addAttribute("files", storageService.loadAll().map(
                        path -> MvcUriComponentsBuilder.fromMethodName(FileUploadController.class,
                                "serveFile", path.getFileName().toString()).build().toUri().toString())
                .collect(Collectors.toList()));

        return "plantilla";
    }

    @GetMapping("/files/{filename:.+}")
    @ResponseBody
    public ResponseEntity<String> serveFile(@PathVariable String filename) {

        Resource file = storageService.loadAsResource(filename);

        if (file == null){
            System.out.println("doku");
            return ResponseEntity.notFound().build();}

        System.out.println("oki");
        return ResponseEntity.status(HttpStatus.OK).body("Se ha subido sin problema");
    }

    @PostMapping("/")
    public String handleFileUpload(@RequestParam("file") MultipartFile file,
                                   RedirectAttributes redirectAttributes) {
        storageService.store(file);
        redirectAttributes.addFlashAttribute("message",
                "¡Se ha subido con éxito!");

        return "redirect:/";
    }

    @ExceptionHandler(StorageException.class)
    public String handleStorageFileNotFound(RedirectAttributes redirectAttributes) {

        redirectAttributes.addFlashAttribute("message",
                "ERROR No se puede subir un archivo vacio!!");

        return "redirect:/";
    }

}