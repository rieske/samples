package lt.rieske.records;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class RecordsTest {

    @Test
    void recordAccessors() {
        var sampleRecord = new SampleRecord("str", 42, true);

        assertThat(sampleRecord.stringField()).isEqualTo("str");
        assertThat(sampleRecord.intField()).isEqualTo(42);
        assertThat(sampleRecord.boolField()).isTrue();
    }

    @Test
    void recordToString() {
        var sampleRecord = new SampleRecord("str", 42, true);

        assertThat(sampleRecord.toString()).isEqualTo("SampleRecord[stringField=str, intField=42, boolField=true]");
    }

    @Test
    void recordEquals() {
        var record1 = new SampleRecord("str", 42, true);
        var record2 = new SampleRecord("str", 42, true);

        assertThat(record1).isEqualTo(record2);
        assertThat(record1.hashCode()).isEqualTo(record2.hashCode());
    }

    @Test
    void recordNotEquals() {
        var record1 = new SampleRecord("str", 42, true);
        var record2 = new SampleRecord("str", 42, false);

        assertThat(record1).isNotEqualTo(record2);
    }

    @Test
    void recordWithArray() {
        var record1 = new RecordWithArray("str", new String[]{});
        var record2 = new RecordWithArray("str", new String[]{});

        // NOT equal! Both contain empty arrays, but references are used in equality comparison
        assertThat(record1).isNotEqualTo(record2);
    }

    private static record RecordWithArray(String stringField, String[] arrayField) {}

    @Test
    void recordWithEmptyList() {
        var record1 = new RecordWithList("str", new ArrayList<>());
        var record2 = new RecordWithList("str", new ArrayList<>());

        assertThat(record1).isEqualTo(record2);
    }

    @Test
    void recordWithEmptyDifferentListImplementations() {
        var record1 = new RecordWithList("str", new ArrayList<>());
        var record2 = new RecordWithList("str", new LinkedList<>());

        assertThat(record1).isEqualTo(record2);
    }

    @Test
    void recordWithNonEmptyList() {
        var record1 = new RecordWithList("str", List.of("foo", "bar"));
        var record2 = new RecordWithList("str", List.of("foo", "bar"));

        assertThat(record1).isEqualTo(record2);
    }

    @Test
    void recordWithDifferentLists() {
        var record1 = new RecordWithList("str", List.of("foo", "bar"));
        var record2 = new RecordWithList("str", List.of("foo"));

        assertThat(record1).isNotEqualTo(record2);
    }

    private static record RecordWithList(String stringField, List<String>listField) {}

    @Test
    void recordWithMethod() {
        var recordWithMethod = new RecordWithMethod("str");

        assertThat(recordWithMethod.method("foo")).isEqualTo("strfoo");
    }

    private static record RecordWithMethod(String stringField) {
        String method(String arg) {
            return stringField + arg;
        }
    }

    @Test
    void recordWithInterface() {
        var a = new ComparableRecord("a");
        var b = new ComparableRecord("b");

        assertThat(a.compareTo(b)).isEqualTo(1);
    }

    private static record ComparableRecord(String stringField) implements Comparable<ComparableRecord> {
        @Override
        public int compareTo(ComparableRecord o) {
            return o.stringField().compareTo(stringField);
        }
    }
}
