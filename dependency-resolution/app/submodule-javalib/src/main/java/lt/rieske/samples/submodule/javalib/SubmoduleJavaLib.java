package lt.rieske.samples.submodule.javalib;

import com.fasterxml.jackson.databind.ObjectMapper;

public class SubmoduleJavaLib {

    public static void useDependency() {
        var objectMapper = new ObjectMapper();
        System.out.println(objectMapper);
    }

    public static ObjectMapper getDependency() {
        return new ObjectMapper();
    }
}
