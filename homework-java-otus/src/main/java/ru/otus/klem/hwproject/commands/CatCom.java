package ru.otus.klem.hwproject.commands;

import ru.otus.klem.hw14.AppArrayDataException;
import ru.otus.klem.hwproject.model.CommandRequest;
import ru.otus.klem.hwproject.model.CommandResponse;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class CatCom implements FileCommand {
    @Override
    public String getName() {
        return "cat";
    }

    @Override
    public String getDescription() {
        return "cat[filename] – показать содержимое файла";
    }

    @Override
    public CommandResponse execute(CommandRequest request) throws IOException, AppArrayDataException {
        File newDir = new File(request.currentPath() + "\\" + request.command()[1]);
        if (!newDir.exists()) {
            return new CommandResponse(request.currentPath(), "Файл в текущей директории не найден");
        }
        BufferedReader reader = new BufferedReader(new FileReader(newDir));
        try {
            String row = reader.readLine();
            if (row == null) {
                return new CommandResponse(request.currentPath(), "Файл пустой");
            }
            while (row != null) {
                System.out.println(row);
                row = reader.readLine();
            }
        } catch (IOException e) {
            System.out.println("Ошибка чтения файла");
        }
        return new CommandResponse(request.currentPath(), "");
    }
}
