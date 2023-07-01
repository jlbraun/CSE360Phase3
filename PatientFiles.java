package application;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class PatientFiles {

    public List<String> patientInfoFiles;

    public PatientFiles() {
        patientInfoFiles = getAllPatientInfoFiles();

    }

    public boolean usernameExists(String username)
    {
        for (String filenames : patientInfoFiles) {
            if (filenames.contains(username)) 
                return true;
        }
        return false;
    }

    public File createPatientInfoFile(String username) throws IOException {
        boolean fileExists = false;
        // check for patient question file
        for (String filenames : patientInfoFiles) {
            if (filenames.contains(username)) {
                fileExists = true;
                return getPatientInfoFile(username);
            }
        }

        if (!fileExists) {
            // create file name
            String filename = username + "_patientInfo.txt";
            File patientQuestionFile = new File("C:\\Users\\LoNeZiLLa\\Documents\\ASU\\Classes\\Summer 2023\\CSE 360\\Class Project\\Phase 3\\prototype\\demo\\src\\main\\java\\prototype\\demo\\PatientInfoFiles\\" + filename);
            return patientQuestionFile;
        }
        return null;
    }

    public List<String> getAllPatientInfoFiles() {
        patientInfoFiles = new ArrayList<String>();
        File files[] = new File("C:\\Users\\LoNeZiLLa\\Documents\\ASU\\Classes\\Summer 2023\\CSE 360\\Class Project\\Phase 3\\prototype\\demo\\src\\main\\java\\prototype\\demo\\PatientInfoFiles").listFiles();
        if (files != null) {
            for (File file : files) {
                if (file.isFile()) {
                    patientInfoFiles.add(file.getName());
                }
            }
        }
        return patientInfoFiles;
    }

    public File getPatientInfoFile(String username) {
        File files[] = new File("C:\\Users\\LoNeZiLLa\\Documents\\ASU\\Classes\\Summer 2023\\CSE 360\\Class Project\\Phase 3\\prototype\\demo\\src\\main\\java\\prototype\\demo\\PatientInfoFiles").listFiles();
        if (files != null) {
            for (File file : files) {
                if (file.isFile()) {
                    if (file.getName().contains(username)) return file;
                }
            }
        }
        return null;
    }

    public void saveQuestionInfo(String username, String information) throws IOException {
        File file = createPatientInfoFile(username);
        if (file != null) {
            // add to end of file
            FileWriter fileWriter = new FileWriter(file, true);
            fileWriter.write('\n' + "Nurse Questionaire: " + information);
            fileWriter.flush();
            fileWriter.close();
        }
    }

    public void saveNurseExamInfo(String username, String height, String weight, String bp, String bodyTemp) throws IOException {
        File file = createPatientInfoFile(username);
        if (file != null) {
            FileWriter fileWriter = new FileWriter(file, true);
            fileWriter.write("\nHeight: " + height);
            fileWriter.write("\nWeight: " + weight);
            fileWriter.write("\nBlood Pressure: " + bp);
            fileWriter.write("\nBody Temperature: " + bodyTemp + '\n');
            fileWriter.flush();
            fileWriter.close();
        }
    }

    public File getMessageFile(String username) {
        return new File("C:\\Users\\LoNeZiLLa\\Documents\\ASU\\Classes\\Summer 2023\\CSE 360\\Class Project\\Phase 3\\prototype\\demo\\src\\main\\java\\prototype\\demo\\PatientInfoFiles\\" + username + "_patientMessage.txt");
    }

    public void writeSentMessage(String username, String messageText, boolean isPatient) throws IOException {
        File file = getMessageFile(username);
        if (file != null) {
            FileWriter fileWriter = new FileWriter(file, true);
            if (isPatient)
                fileWriter.write(username + ": " + messageText + '\n');
            else
                fileWriter.write("Staff: " + messageText + '\n');
            fileWriter.flush();
            fileWriter.close();
        }
    }

    public String readMessageFile(String username) throws IOException {
        File file = getMessageFile(username);
        BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
        String messageText = "";
        String message = "";
        while ((message = bufferedReader.readLine()) != null) {
            messageText += message + '\n';
        }
        return messageText;
    }
}
