package com.opstty.mapper;

import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

import java.io.IOException;

public class SpeciesMapper extends Mapper<Object, Text, Text, Text> {
    private Text species = new Text();

    public void map(Object key, Text value, Context context) throws IOException, InterruptedException {
        String[] fields = value.toString().split(";");
        if (fields.length > 3 && !fields[3].equals("ESPECE")) {
            species.set(fields[3]);
            context.write(species, new Text(""));
        }
    }
}
