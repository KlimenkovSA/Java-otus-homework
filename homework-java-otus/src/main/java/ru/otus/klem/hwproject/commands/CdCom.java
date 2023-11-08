package ru.otus.klem.hwproject.commands;

import ru.otus.klem.hwproject.FileManager;
import ru.otus.klem.hwproject.model.CommandRequest;
import ru.otus.klem.hwproject.model.CommandResponse;
import java.io.File;
import java.io.IOException;

public class CdCom implements FileCommand{
    @Override
    public String getName() {
        return "cd";
    }

    @Override
    public String getDescription() {
        return "cd [path] – переход в указанную поддиректорию, cd .. переход в родительский каталог.";
    }

    @Override
    public CommandResponse execute(CommandRequest request) throws IOException {
        if (request.command().length == 2) {
            File newDir = new File(request.currentPath() + "\\" + request.command()[1]);
            if(!newDir.exists()){
                return new CommandResponse(request.currentPath(),"Директория не найдена");
            }
            return new CommandResponse(new File(newDir.toURI()).getCanonicalPath(),"");
        }
        return new CommandResponse(request.currentPath(),"Неверные аргументы для команды cd");
    }
}
