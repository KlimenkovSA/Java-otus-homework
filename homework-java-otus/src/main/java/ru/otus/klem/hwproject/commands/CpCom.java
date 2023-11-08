package ru.otus.klem.hwproject.commands;

import ru.otus.klem.hw14.AppArrayDataException;
import ru.otus.klem.hwproject.model.CommandRequest;
import ru.otus.klem.hwproject.model.CommandResponse;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

public class CpCom implements FileCommand{
    @Override
    public String getName() {
        return "cp";
    }

    @Override
    public String getDescription() {
        return "cp [source] [destination] – скопировать файл";
    }

    @Override
    public CommandResponse execute(CommandRequest request) throws IOException{
        try {
            String from = request.command()[1];
            String to = request.command()[2];
            var pathFrom = Paths.get(String.valueOf(request.currentPath()), from);
            var pathTo = Paths.get(String.valueOf(request.currentPath()), to);
            try {
                Files.copy(pathFrom, pathTo, StandardCopyOption.REPLACE_EXISTING);
            } catch (IOException e) {
                e.printStackTrace();
            }
            return new CommandResponse(request.currentPath(),"Объект <"+pathFrom.getFileName()+"> успешно скопирован c именем <" + pathTo.getFileName()+ ">" );
        } catch (ArrayIndexOutOfBoundsException e){
            return new CommandResponse(request.currentPath(),"Неверные аргументы для команды cp" );
        }

    }
}
