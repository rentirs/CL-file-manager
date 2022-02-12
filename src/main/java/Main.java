import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 * Author: Renat Mavlikhanov
 * Date: 11.02.2022
 * Time: 19:03
 * Description:
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        FileManager fileManager = new FileManager("D:\\Coding\\Java\\file-manager\\root");
        String input = scanner.nextLine();

        while (!input.equals(Commands.EXIT)) {
            String[] tokens = input.split(" ");
            String command = tokens[0];
            switch (command) {
                case Commands.LIST_OF_FILES -> fileManager.listOfFiles(false);
                case Commands.LIST_OF_FILES_WITH_SIZE -> fileManager.listOfFiles(true);
                case Commands.COPY_FILE -> {
                    String sourceFileName = tokens[1];
                    String destFileName = tokens[2];
                    fileManager.copyFile(sourceFileName, destFileName);
                }
                case Commands.CREATE_FILE -> {
                    String fileName = tokens[1];
                    fileManager.createFile(fileName);
                }
                case Commands.FILE_CONTENT -> {
                    String fileName = tokens[1];
                    fileManager.fileContent(fileName);
                }
                case Commands.CHANGE_DIRECTORY -> {
                    String folderName = tokens[1];
                    fileManager.changeDirectory(folderName);
                }
            }
            input = scanner.nextLine();
        }
    }
}
