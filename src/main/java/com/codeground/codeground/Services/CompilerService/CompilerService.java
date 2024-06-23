package com.codeground.codeground.Services.CompilerService;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.springframework.stereotype.Service;

@Service
public class CompilerService {
    public String compileAndExecuteJavaCode(String javaCode) {
        String javaFileName = "CodeGround.java";
        String classFileName = "CodeGround.class";
        StringBuilder execOutput = new StringBuilder();

        try {
            Files.write(Paths.get(javaFileName), javaCode.getBytes());
            Process compileProcess = new ProcessBuilder("javac", javaFileName).start();
            compileProcess.waitFor();

            if (compileProcess.exitValue() != 0) {
                InputStream errorStream = compileProcess.getErrorStream();
                byte[] errorBytes = errorStream.readAllBytes();
                execOutput.append(new String(errorBytes));
                System.out.println("Compilation failed. Error message:\n" +
                        execOutput.toString());
                return execOutput.toString();
            }

            Process execProcess = new ProcessBuilder("java", "CodeGround").start();

            InputStream execInputStream = execProcess.getInputStream();
            InputStream execErrorStream = execProcess.getErrorStream();

            byte[] execOutputBytes = execInputStream.readAllBytes();
            byte[] execErrorBytes = execErrorStream.readAllBytes();

            execOutput.append(new String(execOutputBytes));
            execOutput.append(new String(execErrorBytes));

            Files.delete(Paths.get(javaFileName));
            Files.delete(Paths.get(classFileName));

        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
            return e.getMessage();
        }

        return execOutput.toString();
    }

    public String testInprogressCompileAndExecuteJavaCode(String javaCode) {
        String javaFileName = "CodeGround.java";
        String classFileName = "CodeGround.class";
        StringBuilder execOutput = new StringBuilder();

        try {
            // Write the Java code to a file
            Files.write(Paths.get(javaFileName), javaCode.getBytes());

            // Compile the Java code
            Process compileProcess = new ProcessBuilder("javac", javaFileName).start();
            compileProcess.waitFor();

            // Check if compilation failed
            if (compileProcess.exitValue() != 0) {
                InputStream errorStream = compileProcess.getErrorStream();
                byte[] errorBytes = errorStream.readAllBytes();
                execOutput.append(new String(errorBytes));
                System.out.println("Compilation failed. Error message:\n" + execOutput.toString());
                return execOutput.toString(); // Return compilation error message
            }

            // Execute the compiled Java program
            Process execProcess = new ProcessBuilder("java", "CodeGround").start();

            // Read the output from the process
            InputStream execInputStream = execProcess.getInputStream();
            InputStream execErrorStream = execProcess.getErrorStream();

            byte[] execOutputBytes = execInputStream.readAllBytes();
            byte[] execErrorBytes = execErrorStream.readAllBytes();

            execOutput.append(new String(execOutputBytes));
            execOutput.append(new String(execErrorBytes));

            // Clean up: delete Java and class files
            Files.delete(Paths.get(javaFileName));
            Files.delete(Paths.get(classFileName));

        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
            return e.getMessage();
        }

        return execOutput.toString(); // Return execution output as a string
    }

    public String testcompileAndExecuteJavaCode(String userCode) {
        String uniqueFileName = generateUniqueFileName();
        String javaFileName = uniqueFileName + ".java";
        String classFileName = uniqueFileName + ".class";
        StringBuilder execOutput = new StringBuilder();

        try {
            // Prepare static content for the Java file
            String staticJavaContent = generateStaticJavaContent(userCode);

            // Write the Java file with unique filename
            Files.write(Paths.get(javaFileName), staticJavaContent.getBytes());

            // Compile the Java code
            Process compileProcess = new ProcessBuilder("javac", javaFileName).start();
            compileProcess.waitFor();

            // Check if compilation failed
            if (compileProcess.exitValue() != 0) {
                InputStream errorStream = compileProcess.getErrorStream();
                byte[] errorBytes = errorStream.readAllBytes();
                execOutput.append(new String(errorBytes));
                System.out.println("Compilation failed. Error message:\n" +
                        execOutput.toString());
                return execOutput.toString(); // Return compilation error message
            }

            // Execute the compiled Java program
            Process execProcess = new ProcessBuilder("java", uniqueFileName).start();

            // Read the output from the process
            InputStream execInputStream = execProcess.getInputStream();
            InputStream execErrorStream = execProcess.getErrorStream();

            byte[] execOutputBytes = execInputStream.readAllBytes();
            byte[] execErrorBytes = execErrorStream.readAllBytes();

            execOutput.append(new String(execOutputBytes));
            execOutput.append(new String(execErrorBytes));

        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
            return e.getMessage();
        } finally {
            // Clean up: delete Java and class files
            try {
                Files.deleteIfExists(Paths.get(javaFileName));
                Files.deleteIfExists(Paths.get(classFileName));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        return execOutput.toString(); // Return execution output as a string
    }

    private String generateUniqueFileName() {
        // Generate a unique filename (e.g., using timestamp or UUID)
        return "CodeGround_" + System.currentTimeMillis();
    }

    private String generateStaticJavaContent(String userCode) {
        // Prepare static content for the Java file
        // You can include predefined class structure, imports, etc.
        // Example: This could be a template with placeholders for user code
        StringBuilder staticContent = new StringBuilder();
        staticContent.append("public class ").append(generateUniqueFileName()).append(" {\n");
        staticContent.append("    public static void main(String[] args) {\n");
        staticContent.append("        // Static boilerplate code\n");
        staticContent.append("        ").append(userCode).append("\n");
        staticContent.append("    }\n");
        staticContent.append("}\n");
        return staticContent.toString();
    }
}