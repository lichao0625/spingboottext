package com.example.spingboottext.util;

public class StorageFileNotFoundException extends StorageException {
    private static final long serialVersionUID = -7119518537629449580L;

    public StorageFileNotFoundException(String message) {

        super(message);

    }

    public StorageFileNotFoundException(String message, Throwable cause) {

        super(message, cause);

    }
}
