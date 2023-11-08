package ru.otus.klem.hwproject.commands;

import ru.otus.klem.hw14.AppArrayDataException;
import ru.otus.klem.hwproject.model.CommandRequest;
import ru.otus.klem.hwproject.model.CommandResponse;
import java.io.IOException;

public interface FileCommand {
    String getName();

    String getDescription();

    CommandResponse execute(CommandRequest request) throws IOException, AppArrayDataException;
}
