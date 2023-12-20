package com.santam.workshopmongo.services.exceptions;

public class ResourceNotFoundException extends RuntimeException {
  private static final long serialVersionUID = 1L;

  public ResourceNotFoundException(String id) {
    super("Resource not found. Id: " + id);
  }
}
