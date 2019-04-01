package braincohort.pku.edu.website.services;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.*;

@Service
public class FileUtils {
    @Value("${markdown.basePackage}")
    private String markdownBase;

    public String getMarkDownInfo(String markdown) throws IOException {
        System.out.println(markdownBase + markdown);
        File file = new File(markdownBase + markdown);
        if (file.exists()) {
            StringBuilder builder = new StringBuilder();
            BufferedReader reader = new BufferedReader(new FileReader(file));
            try {
                String line;
                while ((line = reader.readLine()) != null) {
                    builder.append(line).append("\n");
                }

            } finally {
                try {
                    reader.close();
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
            }

            return builder.toString();
        } else {
            throw new FileNotFoundException("file " + markdown + " is not exists!");
        }
    }
}
