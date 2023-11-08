package ru.otus.klem.hwproject.commands;

import ru.otus.klem.hw14.AppArrayDataException;
import ru.otus.klem.hwproject.model.CommandRequest;
import ru.otus.klem.hwproject.model.CommandResponse;
import java.io.File;
import java.io.IOException;

public class TouchCom implements FileCommand {
    @Override
    public String getName() {
        return "touch";
    }

    @Override
    public String getDescription() {
        return "touch [name.extension] – создание нового файла с указанным именем и расширением.";
    }

    @Override
    public CommandResponse execute(CommandRequest request) throws IOException, AppArrayDataException {

        if (request.command().length == 2) {
            File newDir = new File(request.currentPath() + "\\" + request.command()[1]);
            if (!newDir.exists()) {
                return new CommandResponse(request.currentPath(), newDir.createNewFile());
            }
            return new CommandResponse(request.currentPath(), "Директория уже существует");
        }
        return new CommandResponse(request.currentPath(), "Неверные аргументы для команды touch");
    }


}
