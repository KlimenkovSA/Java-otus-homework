package ru.otus.klem.hwproject;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.channels.FileChannel;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ainur
 */
public class FileManager {

    File currentFolder;

    /**
     * @param args the command line arguments
     */

    public boolean changeFolder(String toPath){

        File toFolder = new File(toPath);



        if(toFolder.exists() && toFolder.isDirectory()){

            currentFolder = toFolder;
            return true;
        }

        if(toPath.equals("-p")){
            currentFolder = currentFolder.getParentFile();
            return true;
        }

        if(!toFolder.exists()){

            File[] files = currentFolder.listFiles();
            for(File file: files){

                if(file.isDirectory() && toPath.equals(file.getName())){
                    currentFolder = file;
                    return true;
                }
            }
            System.out.println("Folder doesn't exists");
            return false;
        }

        if(!toFolder.isDirectory()){
            System.out.println("Not a folder!");
            return false;
        }


        System.out.println("Folder doesn't exists");
        return false;
    }

    public void list(File f){
        int sizeIndent = 16;
        int dateIndent = 28;

        if (f.exists() && f.isDirectory()){

            StringBuilder sb = new StringBuilder();
            sb.append("size")
                    .append(new String(new char[sizeIndent - 4]).replace("\0", " "))
                    .append(" | ")
                    .append("last modified")
                    .append(new String(new char[dateIndent - 13]).replace("\0", " "))
                    .append(" | ")
                    .append("path");

            System.out.println(sb.toString());

            File[] files = f.listFiles();
            for(File file: files){
                String modifiedDate = new Date(file.lastModified()).toString();

                sb = new StringBuilder();
                sb.append(file.length())
                        .append(new String(new char[sizeIndent - String.valueOf(file.length()).length()]).replace("\0", " "))
                        .append(" | ")
                        .append(modifiedDate)
                        .append(new String(new char[dateIndent - modifiedDate.length()]).replace("\0", " "))
                        .append(" | ")
                        .append(file.getPath());

                System.out.println(sb.toString());
            }
        }else{
            System.out.println("Directory or file does not exist!");
        }

    }

    public void createDir(String dirName, String key){

        if(key.equals("-f")){
            File newDir = new File(dirName);
            if(!newDir.exists()){
                newDir.mkdir();
                System.out.println("The directory "+newDir.getName()+" sucessfully created!");

            }else{
                System.out.println("Directory already exists");
            }
        }else if(!key.equals("-f")){

            File newDir = new File(currentFolder.getAbsolutePath()+"/"+dirName);

            if(!newDir.exists()){
                newDir.mkdir();
                System.out.println("The directory "+newDir.getName()+" sucessfully created!");
            }else{
                System.out.println("Directory already exists");
            }
        }

    }

    public void createFile(String fileName, String key){

        if(key.equals("-f")){
            File newFile = new File(fileName);
            if(!newFile.exists()){
                try {
                    newFile.createNewFile();
                } catch (IOException ex) {
                    Logger.getLogger(FileManager.class.getName()).log(Level.SEVERE, null, ex);
                }
                System.out.println("The file "+newFile.getName()+" sucessfully created!");

            }else{
                System.out.println("File already exists");
            }
        }else if(!key.equals("-f")){

            File newFile = new File(currentFolder.getAbsolutePath()+"/"+fileName);

            if(!newFile.exists()){
                try {
                    newFile.createNewFile();
                } catch (IOException ex) {
                    Logger.getLogger(FileManager.class.getName()).log(Level.SEVERE, null, ex);
                }
                System.out.println("The file "+newFile.getName()+" sucessfully created!");
            }else{
                System.out.println("File already exists");
            }
        }

    }

    public void move(String sourcePath, String destPath){
        Path from;
        if(curPathContains(sourcePath)){
            from = Paths.get(currentFolder + "/" + sourcePath);
        }else{
            from = Paths.get(sourcePath);
        }

        Path to = Paths.get(destPath+"/"+from.getFileName());
        try{
            Files.move(from,to);
            System.out.println("File " + from.getFileName() + " succesfully moved to " + to);
        }catch(IOException e){
            System.out.println("Source or destination file doesn't exist");
        }


    }

    public boolean curPathContains(String toPath){
        File[] files = currentFolder.listFiles();
        for(File file: files){

            if(file.isDirectory() && toPath.equals(file.getName())){
                return true;
            }
        }
        return false;
    }
}