package prototype.demo;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class PatientFiles {

    public List<String> patientInfoFiles;

    public PatientFiles() {
        patientInfoFiles = getAllPatientInfoFiles();
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
            String filename = username + "_PatientInformation.txt";
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
}
