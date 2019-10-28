package lt.rieske.samples.submodule.java;

import org.msgpack.core.MessageBufferPacker;
import org.msgpack.core.MessagePack;


public class SubmoduleJava {

    public static void useDependency() {
        System.out.println("SubmoduleJava");
        var packer = MessagePack.newDefaultBufferPacker();
        System.out.println(packer);
    }

    public static MessageBufferPacker getDependency() {
        System.out.println("SubmoduleJava");
        return MessagePack.newDefaultBufferPacker();
    }
}
