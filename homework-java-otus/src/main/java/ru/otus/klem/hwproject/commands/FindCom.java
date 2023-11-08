package ru.otus.klem.hwproject.commands;

import ru.otus.klem.hw14.AppArrayDataException;
import ru.otus.klem.hwproject.model.CommandRequest;
import ru.otus.klem.hwproject.model.CommandResponse;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class FindCom implements FileCommand {
    @Override
    public String getName() {
        return "find";
    }

    @Override
    public String getDescription() {
        return "find [filename] – найти файл.";
    }

    @Override
    public CommandResponse execute(CommandRequest request) throws IOException, AppArrayDataException {
        File newDir = new File(request.currentPath());

            File directory = new File(newDir.toURI());

            List<File> subDirectories = getSubDirectories(directory);
            do {
                List<File> subSubDirectories = new ArrayList<>();
                for (File subDirectory : subDirectories) {
                    File fileInSubDirectory = new File(subDirectory, request.command()[1]);
                    if (fileInSubDirectory.isFile()) {
                        return new CommandResponse(request.currentPath(), "Найден файл в директории: " + fileInSubDirectory);
                    }
                    subSubDirectories.addAll(getSubDirectories(subDirectory));
                }
                subDirectories = subSubDirectories;
            } while (!subDirectories.isEmpty());
        return new CommandResponse(request.currentPath(), "Файл <" + request.command()[1] + "> не найден");
    }


    private static List<File> getSubDirectories(final File directory) {
        File[] subDirectories = directory.listFiles((current, name) -> new File(current, name).isDirectory());
        assert subDirectories != null;
        return Arrays.asList(subDirectories);
    }
}
