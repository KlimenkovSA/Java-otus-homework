package ru.otus.klem.hwproject.commands;

import ru.otus.klem.hwproject.model.CommandRequest;
import ru.otus.klem.hwproject.model.CommandResponse;
import java.io.File;
import java.io.IOException;

public class MkdirCom implements FileCommand {
    @Override
    public String getName() {
        return "mkdir";
    }

    @Override
    public String getDescription() {
        return "mkdir [name] – создание новой директории с указанным именем.";
    }

    @Override
    public CommandResponse execute(CommandRequest request) throws IOException {
        if (request.command().length == 2) {
            File newDir = new File(request.currentPath() + "\\" + request.command()[1]);
            if (!newDir.exists()) {
                return new CommandResponse(request.currentPath(), newDir.mkdir());
            }
            return new CommandResponse(request.currentPath(), "Директория уже существует");
        }
        return new CommandResponse(request.currentPath(), "Неверные аргументы для команды mkdir");
    }
}
