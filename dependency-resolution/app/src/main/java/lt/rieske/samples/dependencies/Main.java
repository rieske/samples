package lt.rieske.samples.dependencies;

import lt.rieske.samples.submodule.java.SubmoduleJava;
import lt.rieske.samples.submodule.javalib.SubmoduleJavaLib;

public class Main {

    public static void main(String[] args) {
        // can call code that uses a dependency
        SubmoduleJava.useDependency();

        // can not access - wont compile!
        //var dependencyFromJavaSubmodule = SubmoduleJava.getDependency();
        //System.out.println(dependencyFromJavaSubmodule);

        // can call code that uses a dependency
        SubmoduleJavaLib.useDependency();

        // can access only if java-library declares the dependency as `api`
        var apiDependencyFromJavaLibSubmodule = SubmoduleJavaLib.getDependency();
        System.out.println(apiDependencyFromJavaLibSubmodule);
    }
}
