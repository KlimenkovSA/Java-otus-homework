package ru.otus.klem.hwproject;

import ru.otus.klem.hwproject.commands.*;
import ru.otus.klem.hwproject.service.ConsoleFileManager;
import ru.otus.klem.hwproject.service.FileManager;

import javax.swing.filechooser.FileSystemView;
import java.io.File;
import java.io.IOException;
import java.util.List;

public class ConsoleFileApplication {
    public static void main(String[] args) throws IOException {
        var startPath = args.length > 0 ? args[0] : ".";
        var currentLocation = new File(startPath).getCanonicalPath();
        List<FileCommand> commandList = List.of(
                new LsCom(),
                new InfoCom(),
                new CdCom(),
                new MkdirCom(),
                new RmCom(),
                new CpCom(),
                new MvCom(),
                new CatCom(),
                new TouchCom(),
                new FindCom()
        );
//        //FileSystemView fileSystemView = FileSystemView.getFileSystemView();
//        ru.otus.klem.hwproject.FileManager fm = new ru.otus.klem.hwproject.FileManager();
//        //fm.currentFolder = fileSystemView.getDefaultDirectory();
//        fm.currentFolder = new File("C:\\Users\\KLEM\\Desktop\\testFolder");


        FileManager manager = new ConsoleFileManager(currentLocation,commandList);
        manager.run();
    }
}
