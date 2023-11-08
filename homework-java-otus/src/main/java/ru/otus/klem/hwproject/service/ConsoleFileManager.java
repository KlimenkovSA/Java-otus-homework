package ru.otus.klem.hwproject.service;

import ru.otus.klem.hwproject.commands.FileCommand;
import ru.otus.klem.hwproject.model.CommandRequest;
import ru.otus.klem.hwproject.model.CommandResponse;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.function.Function;
import java.util.stream.Collectors;

public class ConsoleFileManager implements FileManager {
    private String currentLocation;
    private List<FileCommand> commandList;
    private Map<String, FileCommand> commandMap;
    private Scanner scanner;


    public ConsoleFileManager(String currentLocation, List<FileCommand> commandList) {
        this.currentLocation = currentLocation;
        this.commandList = commandList;
        this.commandMap = commandList.stream().collect(Collectors.toMap(FileCommand::getName, Function.identity()));
        this.scanner = new Scanner(System.in);
    }

    @Override
    public void run() {
        String[] command = getCommand();

        while (!command[0].equals("exit")) {
            if (command[0].equals("help")) {
                String help = commandList.stream().map(FileCommand::getDescription).collect(Collectors.joining("\n"));
                System.out.println(help);
            } else {
                try {
                    CommandResponse commandResponse = commandMap.get(command[0]).execute(new CommandRequest(currentLocation, command));
                    if (commandResponse.result() != null) {
                        System.out.println(commandResponse.result());
                    }
                    currentLocation = commandResponse.newPath();
                } catch (NullPointerException e) {
                    System.out.println("Unknown command");
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
            command = getCommand();
        }
    }

    private String[] getCommand() {
        System.out.println(currentLocation + ": ");
        return scanner.nextLine().split(" ");
    }
}
