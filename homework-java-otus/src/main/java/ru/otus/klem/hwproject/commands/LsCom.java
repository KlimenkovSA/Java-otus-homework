package ru.otus.klem.hwproject.commands;

import org.apache.commons.io.FileUtils;
import ru.otus.klem.hwproject.model.CommandRequest;
import ru.otus.klem.hwproject.model.CommandResponse;

import java.io.File;
import java.util.Arrays;
import java.util.Date;

public class LsCom implements FileCommand {
    @Override
    public String getName() {
        return "ls";
    }

    @Override
    public String getDescription() {
        return "ls – возвращает список файлов текущего каталога. Если добавлен ключ -l, то должна быть более подробная информация о файлах: имя – размер – дата последнего изменения.";
    }

    @Override
    public CommandResponse execute(CommandRequest request) {
        File newDir = new File(request.currentPath());
        if (request.command().length == 1) {

            return new CommandResponse(request.currentPath(),
                    Arrays.stream(newDir.listFiles()).map(File::getName).toList());
        } else if (request.command().length == 2 && request.command()[1].equals("-l")) {

            int Indent = 16;
            int dateIndent = 28;

            if (newDir.exists() && newDir.isDirectory()) {

                StringBuilder sb = new StringBuilder();
                sb.append("name")
                        .append(new String(new char[Indent - 4]).replace("\0", " "))
                        .append(" | ")
                        .append("size")
                        .append(new String(new char[Indent - 4]).replace("\0", " "))
                        .append(" | ")
                        .append("last modified")
                        .append(new String(new char[dateIndent - 13]).replace("\0", " "))
                        .append(" | ")
                        .append("path");

                System.out.println(sb);

                File[] files = newDir.listFiles();
                for (File file : files) {
                    String modifiedDate = new Date(file.lastModified()).toString();

                    String size = String.valueOf(new File(String.valueOf(file.length())));
                    if (file.isDirectory()){
                        // узнать размер папки
                        size = String.valueOf(new File(String.valueOf(FileUtils.sizeOfDirectory(file))));
                    }


                    sb = new StringBuilder();
                    sb.append(file.getName())
                            .append(new String(new char[Indent - (file.getName()).length()]).replace("\0", " "))
                            .append(" | ")
                            .append(size)
                            .append(new String(new char[Indent - size.length()]).replace("\0", " "))
                            .append(" | ")
                            .append(modifiedDate)
                            .append(new String(new char[dateIndent - modifiedDate.length()]).replace("\0", " "))
                            .append(" | ")
                            .append(file.getPath());

                    System.out.println(sb);
                }
            } else {
                System.out.println("Директория или файл не найден!");
            }

        }
        return new CommandResponse(request.currentPath(), "");
    }
}
