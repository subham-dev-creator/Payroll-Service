package com.training.payrollservice;

import static org.junit.Assert.*;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.IntStream;
import java.nio.file.Files;

import org.junit.Assert;
import org.junit.Test;

public class IOFileAPITest {
    public static final String HOME = System.getProperty("user.home");
    public static final String PLAY_WITH_FILE = "TempFiles";

    @Test
    public void givenPathWhenCheckedThenConfirm() throws IOException {
        Path homePath = Paths.get(HOME);
        Assert.assertTrue(Files.exists(homePath));

        Path playPath = Paths.get(HOME + "/" + PLAY_WITH_FILE);
        if (Files.exists(playPath))
            FileUtils.deleteFiles(playPath.toFile());
        Assert.assertTrue(Files.notExists(playPath));

        Files.createDirectory(playPath);
        Assert.assertTrue(Files.exists(playPath));

        IntStream.range(1, 10).forEach(counter -> {
            Path tempFilePath = Paths.get(playPath + "/temp" + counter);
            Assert.assertTrue(Files.notExists(tempFilePath));
            try {
                Files.createFile(tempFilePath);
            } catch (IOException e) {
            }
            Assert.assertTrue(Files.exists(tempFilePath));
        });

        Files.newDirectoryStream(playPath).forEach(System.out::println);
        Files.newDirectoryStream(playPath, path -> path.toFile().isFile() && path.toString().startsWith("temp"))
                .forEach(System.out::println);

    }


}
