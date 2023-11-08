package ru.otus.klem.hwproject.commands;

import ru.otus.klem.hwproject.model.CommandRequest;
import ru.otus.klem.hwproject.model.CommandResponse;
import java.io.File;
import java.io.IOException;

public class RmCom implements FileCommand {
    @Override
    public String getName() {
        return "rm";
    }

    @Override
    public String getDescription() {
        return "rm [filename] – удаление указанного файла или директории. \n" +
                "rm -r [filename] - рекурсивное удаление.";
    }

    @Override
    public CommandResponse execute(CommandRequest request) throws IOException {
        File newDir = new File(request.currentPath() + "\\" + request.command()[1]);

        if (request.command().length == 2) {
            if (newDir.delete()) {
                return new CommandResponse(request.currentPath(), newDir.delete());
            } else {
                return new CommandResponse(request.currentPath(), "Удалить не удалось, т.к. папка не пуста, используйте рекурсивное удаление rm -r [filename]");
            }
        }
        if ((request.command().length == 3) && (request.command()[1].equals("-r"))) {
            String folder = request.currentPath() + "\\" + request.command()[2];
            recursiveDelete(new File(folder));
            return new CommandResponse(request.currentPath(), "Удалено рекурсивно: " + request.command()[2]);
        }
        return new CommandResponse(request.currentPath(), "Неверные аргументы для команды rm");

    }

    public static void recursiveDelete(File file) {
        if (!file.exists())
            return;
        if (file.isDirectory()) {
            for (File f : file.listFiles()) {
                recursiveDelete(f);
            }
        }
        file.delete();
    }
}
