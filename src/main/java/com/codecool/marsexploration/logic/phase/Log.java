package com.codecool.marsexploration.logic.phase;

import com.codecool.marsexploration.data.Context;
import com.codecool.marsexploration.helpers.Database;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.sql.SQLException;

public class Log implements Phase{
    @Override
    public void perform(Context context) {
        String log;
        if (context.getOutcome() == null) {
            log = "STEP " + context.getStepNumber()
                    + "; EVENT position; UNIT " + context.getRover().getId()
                    + "; POSITION [" + context.getRover().getPosition().x() + "," + context.getRover().getPosition().y() + "]";
        } else {
            log = "STEP " + context.getStepNumber() + "; EVENT outcome; OUTCOME " + context.getOutcome();
        }
        if (context.getStepNumber() == 0)
            clear(context.getLogFilePath());
        write(log, context.getLogFilePath());

        try{
            Database.logInsert(context.getConnection(), context.getMapNameWithoutExtension(), context.getStepNumber(), context.getOutcome() == null ? "position" : "OUTCOME_" + context.getOutcome(), context.getRover().getId(), context.getRover().getPosition().x(), context.getRover().getPosition().y());
        }catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
        System.out.println(log);
    }

    private void write(String log, String logPath) {
        try{
            FileWriter writer = new FileWriter(logPath, true);
            writer.write(log + "\n");
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void clear(String logPath) {
        Path path = Path.of(logPath);
        try{
            Files.deleteIfExists(path);
            Files.createFile(path);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
