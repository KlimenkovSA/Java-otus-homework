package ru.otus.klem.hwproject.commands;

import ru.otus.klem.hw14.AppArrayDataException;
import ru.otus.klem.hwproject.model.CommandRequest;
import ru.otus.klem.hwproject.model.CommandResponse;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class MvCom implements FileCommand {
    @Override
    public String getName() {
        return "mv";
    }

    @Override
    public String getDescription() {
        return "mv [source] [destination] – переименовать/перенести файл или директорию";
    }

    @Override
    public CommandResponse execute(CommandRequest request) throws IOException, AppArrayDataException {
        String dirFrom = request.command()[1];
        String dirTo = request.command()[2];
        File newDirFrom = new File(request.currentPath() + "\\" + request.command()[1]);
        File newDirTo = new File(request.currentPath() + "\\" + request.command()[2]);

        if (!newDirFrom.exists()) {
            return new CommandResponse(request.currentPath(), "Первый аргумент не найден");
        }
        if (!newDirTo.exists()) {
            return new CommandResponse(request.currentPath(), "Второй аргумент не найден");
        }
        if (newDirTo.equals(newDirTo)) {
            return new CommandResponse(request.currentPath(), "Перемещние объекта в тот же объект невозможно");
        }
        var pathFrom = Paths.get(request.currentPath() + "\\" + dirFrom);
        var pathTo = Paths.get(request.currentPath() + "\\" + dirTo + "/" + pathFrom.getFileName());
        Files.move(pathFrom, pathTo);
        return new CommandResponse(request.currentPath(), "Объект " + dirFrom + " перемещен в " + dirTo);
    }

}
