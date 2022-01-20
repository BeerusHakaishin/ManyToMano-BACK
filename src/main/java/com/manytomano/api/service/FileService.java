package com.manytomano.api.service;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;

@Service
public class FileService {

	private String locationFile = "/home/ario/eclipse-workspace/ManyToMano-BACK/src/main/resources/static/img/";

	private final Path root = Paths.get(locationFile);

	public Resource load(String filename) throws IOException {
		if (filename != null) {
			Path file = root.resolve(filename);
			Resource resource = new UrlResource(file.toUri());

			if (resource.exists() || resource.isReadable()) {
				return resource;
			} else {
				throw new IOException("Resource not here");
			}
		} else {
			throw new IOException("Give a name to the file you're searching");
		}
	}}

