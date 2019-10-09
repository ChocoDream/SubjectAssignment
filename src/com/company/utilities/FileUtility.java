package com.company.utilities;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.List;

public class FileUtility {
    //Taken from java19l nodehill, Article fileutility

    public static void saveObject(Object o, String fileName, StandardOpenOption... option){
        Path path = Paths.get(fileName);
        try (ObjectOutputStream out = new ObjectOutputStream(Files.newOutputStream(path, option))){
            out.writeObject(o);
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }

    public static Object loadObject(String fileName){
        Path path = Paths.get(fileName);
        try (ObjectInputStream in = new ObjectInputStream(Files.newInputStream(path))){
            return in.readObject();
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    public static void saveText(String fileName, List<String> list, StandardOpenOption... option){
        Path path = Paths.get(fileName);
        try {
            Files.write(path, list, option);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public static List<String> loadText(String fileName){
        Path path = Paths.get(fileName);
        try{
            return Files.readAllLines(path);
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }
}
