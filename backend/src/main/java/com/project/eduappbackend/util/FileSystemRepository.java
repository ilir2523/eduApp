package com.project.eduappbackend.util;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Date;

public class FileSystemRepository {

    String filesPath = "C:\\eduapp\\files\\";

    public String save(byte[] content, String name) throws Exception {
        Path newFile = Paths.get(filesPath + new Date().getTime() + "-" + name);
        Files.createDirectories(newFile.getParent());

        Files.write(newFile, content);

        return newFile.toAbsolutePath()
                .toString();
    }

    public Path findInFileSystem(String location) throws Exception {
        try {
            return Paths.get(location);
        } catch (Exception e) {
            throw new Exception("File not found.");
        }
    }

    public void delete(String location) throws IOException, Exception {
        Path fileToDeletePath = Paths.get(location);
        try {
            Files.delete(fileToDeletePath);
        } catch (Exception e) {
            throw new Exception("File not found.");
        }
    }
}
