package ru.otus.klem.hwproject.model;

import java.io.File;

public record CommandRequest (String currentPath, String[] command){
}
