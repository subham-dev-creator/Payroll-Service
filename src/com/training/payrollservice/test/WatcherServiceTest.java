package com.training.payrollservice.test;

import com.training.payrollservice.main.WatcherService;
import org.junit.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class WatcherServiceTest {
    public static final String HOME = System.getProperty("user.home");
    public static final String PLAY_WITH_FILE = "IdeaProjects\\Payroll-Service\\TempFiles";

    @Test
    public void givenDirectoryWhenWatchedListAllActivities() throws IOException {
        Path dir= Paths.get(HOME+ "/" +PLAY_WITH_FILE);
        Files.list(dir).filter(Files::isRegularFile).forEach(System.out::println);
        new WatcherService(dir).processEvents();
    }
}
