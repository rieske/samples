package lt.rieske.samples.submodule.javalib;

import com.fasterxml.jackson.databind.ObjectMapper;

public class SubmoduleJavaLib {

    public static void useDependency() {
        System.out.println("SubmoduleJavaLib");
        var objectMapper = new ObjectMapper();
        System.out.println(objectMapper);
    }

    public static ObjectMapper getDependency() {
        System.out.println("SubmoduleJavaLib");
        return new ObjectMapper();
    }
}
