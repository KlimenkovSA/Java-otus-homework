package ru.otus.klem.hwproject;


import java.io.File;
import java.util.Scanner;
import javax.swing.filechooser.FileSystemView;

/**
 *
 * @author ainur
 */
public class Main {

    public static void main(String[] args) {

        FileSystemView fileSystemView = FileSystemView.getFileSystemView();
        FileManager fm = new FileManager();
        fm.currentFolder = fileSystemView.getDefaultDirectory();


        label:
        while(true){

            try{

                Scanner scan = new Scanner(System.in);
                System.out.println(fm.currentFolder + ":");


                String input = scan.nextLine();
                String[] cmd = input.split(" ");

                switch(cmd[0]){

                    case "cd":
                        if(cmd.length == 2){
                            fm.changeFolder(cmd[1]);
                        }else{
                            System.out.println("Incorrect arguments");
                        }
                        System.out.println("\n");
                        break;

                    case "list":
                        if(cmd.length == 1){
                            fm.list(fm.currentFolder);
                        }else if(cmd.length == 2){
                            fm.list(new File(cmd[1]));
                        }else{
                            System.out.println("Incorrect arguments count");
                        }
                        System.out.println("\n");
                        break;

                    case "newdir":
                        if (cmd.length > 1){
                            if(cmd[1].equals("-f")){
                                for(int i = 2; i < cmd.length; i++){
                                    fm.createDir(cmd[i], cmd[1]);
                                }
                            }else{
                                for(int i = 1; i < cmd.length; i++){
                                    fm.createDir(cmd[i], cmd[1]);
                                }
                            }

                        }else{
                            System.out.println("Incorrect arguments, key existed");
                        }
                        System.out.println("\n");
                        break;

                    case "newfile":
                        if (cmd.length > 1){
                            if(cmd[1].equals("-f")){
                                for(int i = 2; i < cmd.length; i++){
                                    fm.createDir(cmd[i], cmd[1]);
                                }
                            }else{
                                for(int i = 1; i < cmd.length; i++){
                                    fm.createDir(cmd[i], cmd[1]);
                                }
                            }
                        }else{
                            System.out.println("Incorrect arguments, key existed");
                        }
                        System.out.println("\n");
                        break;

                    case "move":

                        int length = cmd.length;

                        for(int i = 1; i < length-1; i++){
                            fm.move(cmd[i], cmd[length-1]);
                        }

                        System.out.println("\n");
                        break;

                    case"quit":
                        break label;

                    default:
                        System.out.println("Unknown command");
                }


            }catch(Exception e){
                System.out.println(e);
            }
        }


    }

}