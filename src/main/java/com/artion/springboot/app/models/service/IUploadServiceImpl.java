package com.artion.springboot.app.models.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;
import org.springframework.util.FileSystemUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.UUID;

@Service
public class IUploadServiceImpl implements IUploadFileService{

    private final Logger log = LoggerFactory.getLogger(getClass());
    private final static String UPLOADS_FOLDER = "uploads";

    @Override
    public Resource load(String filename) throws MalformedURLException {
        Path pathfoto = getPath(filename);
        log.info("pathfoto: " + pathfoto);
        Resource recurso = null;

        recurso = new UrlResource(pathfoto.toUri());

        if (!recurso.exists()  && !recurso.isReadable()){
            throw new RuntimeException("Error: nose puede cargar la imagen: " + pathfoto.toString());
        }

        return recurso;
    }

    @Override
    public String copy(MultipartFile file) throws IOException {
        String uniqueFilename = UUID.randomUUID().toString() + " " + file.getOriginalFilename();
        Path rootPath = getPath(uniqueFilename);

        log.info("rootPath: " + rootPath);
        Files.copy(file.getInputStream(), rootPath );

        return uniqueFilename;
    }

    @Override
    public boolean delete(String filename) {
        Path rootPath = getPath(filename);
        File archivo = rootPath.toFile();

        if (archivo.exists() && archivo.canRead()){
            if (archivo.delete())
               return true;
        }

        return false;
    }

    @Override
    public void deleteAll() {
        FileSystemUtils.deleteRecursively(getPath(UPLOADS_FOLDER).toFile());
    }

    @Override
    public void init() throws IOException {
        if(Files.notExists(Paths.get(UPLOADS_FOLDER))) {
            Files.createDirectory(Paths.get(UPLOADS_FOLDER));
            log.info("No existe el folder "+ UPLOADS_FOLDER + " y lo vamos a crear");
        } else {
            log.info("El folder " + UPLOADS_FOLDER + " existe para guardar archivos");
        }
    }

    public Path getPath(String filename){
        return Paths.get(UPLOADS_FOLDER).resolve(filename).toAbsolutePath();
    }
}
