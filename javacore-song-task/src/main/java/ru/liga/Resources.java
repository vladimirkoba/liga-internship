package ru.liga;

import java.io.File;
import java.net.URI;
import java.net.URISyntaxException;

public class Resources {
    private final String fileName;

    public Resources(String fileName) {
        this.fileName = fileName;
    }

    public File getFile() {
        ClassLoader classLoader = getClass().getClassLoader();
        File file = new File(classLoader.getResource(fileName).getFile());
        return file;
    }

    public URI getUri() throws URISyntaxException {
        ClassLoader classLoader = getClass().getClassLoader();
        return classLoader.getResource(fileName).toURI();
    }

}
