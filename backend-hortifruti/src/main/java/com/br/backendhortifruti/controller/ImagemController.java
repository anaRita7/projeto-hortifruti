package com.br.backendhortifruti.controller;

import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@RestController
@RequestMapping("/api/imagem")
public class ImagemController {

    @GetMapping ("{pid}")
    public void downloadImagem(@PathVariable ("pid") String pid, HttpServletResponse response){
        try{
            File fileDownload = new File("c:/hortifrutti/imagem/" + pid);
            try(InputStream inputStream = new FileInputStream(fileDownload)){
                response.setContentType("application/force-download");
                response.setHeader("Content-Disposition", "attachment; filename=" + pid);
                IOUtils.copy(inputStream, response.getOutputStream());
                response.flushBuffer();
            }
        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }

    @PostMapping
    public ResponseEntity<?> uploadImagem(@RequestParam("pid") String pid, @RequestParam("file") MultipartFile file) {
        if (file.isEmpty()) {
            throw new RuntimeException("Nenhuma imagem selecionada.");
        }
        String folder = "c:/hortifrutti/imagem/";

        try {
            Path pathFolder = Paths.get(folder);
            Files.createDirectories(pathFolder);
            Path pathFile = Paths.get(folder + pid);
            Files.write(pathFile, file.getBytes());

        } catch (RuntimeException | IOException e) {
            throw new RuntimeException();
        }
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
