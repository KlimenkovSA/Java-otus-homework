package ru.otus.klem.hwproject.commands;

import ru.otus.klem.hwproject.model.CommandRequest;
import ru.otus.klem.hwproject.model.CommandResponse;
import java.io.File;
import java.nio.file.Files;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.stream.Collectors;

public class InfoCom implements FileCommand {
    @Override
    public String getName() {
        return "info";
    }

    @Override
    public String getDescription() {
        return "info – получить подробную информацию о текущем файле. \n" +
                "info [filename] – получить подробную информацию об указанном файле.";
    }

    @Override
    public CommandResponse execute(CommandRequest request) {
        File newDir = new File(request.currentPath());
        if (request.command().length == 2) {
            newDir = new File(request.currentPath(), request.command()[1]);
        }
        HashMap<String, Object> infoMap = new LinkedHashMap<String, Object>();
        try {
            infoMap.put("isExist: \t", newDir.exists()); //существует ли такой путь
            infoMap.put("name: \t", newDir.getName());   // его название
            infoMap.put("path: \t", newDir.getPath());   // его путь
            infoMap.put("canonicalPath: \t", newDir.getCanonicalPath()); //исходный путь
            infoMap.put("isFolder: \t", newDir.isDirectory()); //дериктория
            infoMap.put("isFile: \t", newDir.isFile());        //файл
            BasicFileAttributes attributes = Files.readAttributes(newDir.toPath(), BasicFileAttributes.class); //является ли ссылкой
            infoMap.put("isSymbolicLink: \t", attributes.isSymbolicLink()); //дата создания
            infoMap.put("creationTime: \t", attributes.creationTime()); //дата создания
            infoMap.put("size: \t", newDir.length());  //размер
            infoMap.put("canRead: \t", newDir.canRead()); //можем ли читать
            infoMap.put("canWrite: \t", newDir.canWrite()); //можем ли записывать
            //infoMap.put("canWrite: ", Files.getPosixFilePermissions(newFile.toPath())); //права
            return new CommandResponse(request.currentPath(), infoMap.entrySet().stream().map(it -> it.getKey() + it.getValue()).collect(Collectors.joining("\n")));
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }


    }
}
